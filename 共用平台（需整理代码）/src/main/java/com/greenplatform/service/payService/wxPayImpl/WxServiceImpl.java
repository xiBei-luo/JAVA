package com.greenplatform.service.payService.wxPayImpl;

import com.github.wxpay.sdk.WXPay;
import com.github.wxpay.sdk.WXPayConstants;
import com.github.wxpay.sdk.WXPayUtil;
import com.greenplatform.util.payUtil.wxpay.WXConfigUtil;
import com.greenplatform.service.payService.WxService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class WxServiceImpl implements WxService {
    public static final String SPBILL_CREATE_IP = "服务器ip地址";
    public static final String NOTIFY_URL = "回调接口地址";
    public static final String TRADE_TYPE_APP = "APP";


    /**
     * 支付后回调函数
     * @param resXml
     * @return
     */
    @Override
    public String payBack(String resXml) {
        WXConfigUtil config = null;
        try {
            config = new WXConfigUtil();
        } catch (Exception e) {
            e.printStackTrace();
        }
        WXPay wxpay = new WXPay(config);
        String xmlBack = "";
        Map<String, String> notifyMap = null;
        try {
            notifyMap = WXPayUtil.xmlToMap(resXml);         // 调用官方SDK转换成map类型数据
            if (wxpay.isPayResultNotifySignatureValid(notifyMap)) {//验证签名是否有效，有效则进一步处理

                String return_code = notifyMap.get("return_code");//状态
                String out_trade_no = notifyMap.get("out_trade_no");//商户订单号
                if (return_code.equals("SUCCESS")) {
                    if (out_trade_no != null) {
                        // 注意特殊情况：订单已经退款，但收到了支付结果成功的通知，不应把商户的订单状态从退款改成支付成功
                        // 注意特殊情况：微信服务端同样的通知可能会多次发送给商户系统，所以数据持久化之前需要检查是否已经处理过了，处理了直接返回成功标志
                        //业务数据持久化
                        System.out.println("微信手机支付回调成功订单号:{}"+out_trade_no);
                        xmlBack = "<xml>" + "<return_code><![CDATA[SUCCESS]]></return_code>" + "<return_msg><![CDATA[OK]]></return_msg>" + "</xml> ";
                    } else {
                        System.out.println("微信手机支付回调失败订单号:{}"+ out_trade_no);
                        xmlBack = "<xml>" + "<return_code><![CDATA[FAIL]]></return_code>" + "<return_msg><![CDATA[报文为空]]></return_msg>" + "</xml> ";
                    }
                }
                return xmlBack;
            } else {
                // 签名错误，如果数据里没有sign字段，也认为是签名错误
                //失败的数据要不要存储？
                System.out.println("手机支付回调通知签名错误");
                xmlBack = "<xml>" + "<return_code><![CDATA[FAIL]]></return_code>" + "<return_msg><![CDATA[报文为空]]></return_msg>" + "</xml> ";
                return xmlBack;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("手机支付回调通知失败"+ e);
            xmlBack = "<xml>" + "<return_code><![CDATA[FAIL]]></return_code>" + "<return_msg><![CDATA[报文为空]]></return_msg>" + "</xml> ";
        }
        return xmlBack;
    }


    /**
     * 封装参数，调用微信支付
     * @return
     * @throws Exception
     */
    @Override
    public Map doUnifiedOrder() throws Exception {
        try {
            WXConfigUtil config = new WXConfigUtil();
            WXPay wxpay = new WXPay(config);
            Map<String, String> data = new HashMap<>();
            //1.封装支付请求接口参数
            data.put("appid", config.getAppID());//微信支付分配的公众账号ID（企业号corpid即为此appId）
            data.put("mch_id", config.getMchID());//微信支付分配的商户号
            data.put("nonce_str", WXPayUtil.generateNonceStr());//随机字符串，长度要求在32位以内。推荐随机数生成算法
            String body = "订单支付";
            data.put("body", body);//商品简单描述，该字段请按照规范传递，具体请见参数规定
            data.put("out_trade_no", "订单号");//商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|* 且在同一个商户号下唯一。详见商户订单号
            data.put("total_fee", "1");//订单总金额，单位为分，详见支付金额
            //自己的服务器IP地址
            data.put("spbill_create_ip", SPBILL_CREATE_IP);//支持IPV4和IPV6两种格式的IP地址。用户的客户端IP
            //异步通知地址（请注意必须是外网）
            data.put("notify_url", NOTIFY_URL);//异步接收微信支付结果通知的回调地址，通知url必须为外网可访问的url，不能携带参数。
            //交易类型
            data.put("trade_type", TRADE_TYPE_APP);//JSAPI -JSAPI支付，NATIVE -Native支付，APP -APP支付
            //附加数据，在查询API和支付通知中原样返回，该字段主要用于商户携带订单的自定义数据
            data.put("attach", "");//附加数据，在查询API和支付通知中原样返回，可作为自定义参数使用
            data.put("sign", WXPayUtil.generateSignature(data, config.getKey(),
                    WXPayConstants.SignType.MD5));//通过签名算法计算得出的签名值，详见签名生成算法



            Map<String, String> response = wxpay.unifiedOrder(data);//使用官方API请求预付订单
            System.out.println("请求支付返回数据："+response);
            if ("SUCCESS".equals(response.get("return_code"))) {//主要返回以下5个参数
                Map<String, String> param = new HashMap<>();
                param.put("appid",config.getAppID());
                param.put("partnerid",response.get("mch_id"));
                param.put("prepayid",response.get("prepay_id"));
                param.put("package","Sign=WXPay");
                param.put("noncestr",WXPayUtil.generateNonceStr());
                param.put("timestamp",System.currentTimeMillis()/1000+"");
                param.put("sign",WXPayUtil.generateSignature(param, config.getKey(),
                        WXPayConstants.SignType.MD5));
                return param;
            }else{
                System.out.println("请求出错："+response.get("return_msg"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("下单失败");
        }
        throw new Exception("下单失败");
    }
}
