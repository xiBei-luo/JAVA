package com.greenplatform.util.sendMsg;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.greenplatform.model.base.ReturnModel;

import javax.servlet.http.HttpSession;

/**
 * 发送短信验证码
 */
public class GetMessageCode {
    private static final String QUERY_PATH = "https://openapi.miaodiyun.com/distributor/sendSMS";
    private static final String ACCOUNT_SID = "fd9f84e8daa81a690c2d473ff070e24e";
    private static final String AUTH_TOKEN = "95e6274540b19969f21d5ab99a3a0d20";

    // 根据相应的手机号发送验证码
    public static ReturnModel getCode(String cPhone, HttpSession session) {
        ReturnModel returnModel = new ReturnModel();

        String rod = smsCode();//生成随机验证码

        String timestamp = String.valueOf(new Date().getTime());//获取时时间戳

        String sig = getMD5(ACCOUNT_SID, AUTH_TOKEN, timestamp);//获取签名


        String tamp = "【绿沙平台】您的验证码为" + rod + "，您正在申请注册绿沙平台账号，需要进行验证。请勿泄漏于他人。如非本人操作，请忽略此短信。";//短信内容


        OutputStreamWriter out = null;
        BufferedReader br = null;
        StringBuilder result = new StringBuilder();
        try {
            URL url = new URL(QUERY_PATH);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoInput(true);// 设置是否允许数据写入
            connection.setDoOutput(true);// 设置是否允许参数数据输出
            connection.setConnectTimeout(5000);// 设置链接响应时间
            connection.setReadTimeout(10000);// 设置参数读取时间
            connection.setRequestProperty("Content-type", "application/x-www-form-urlencoded");
            // 提交请求
            out = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
            String args = getQueryArgs(ACCOUNT_SID, tamp, cPhone, timestamp, sig, "JSON");//组装参数
            out.write(args);
            out.flush();
            // 读取返回参数

            br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
            String temp = "";
            while ((temp = br.readLine()) != null) {
                result.append(temp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JSONObject json = JSONObject.parseObject(result.toString());
        System.out.println("返回参数："+json);
        String respCode = json.getString("respCode");
        String defaultRespCode = "0000";//发送成功状态码

        if (!defaultRespCode.equals(respCode)) {
            returnModel.setFlag(1);
            returnModel.setMsg(json.getString("respDesc"));
            returnModel.setObject(null);
            return returnModel;//发送短信失败
        } else {
            List failList = (List) json.get("failList");
            if (failList.size() < 1){
                //将手机号，验证码存到session中,同时存入创建时间
                json.put("smsCode", rod);
                json.put("createTime", System.currentTimeMillis());
                json.put("cPhone",cPhone);
                // 将认证码存入SESSION
                session.setAttribute("smsCodeObj", json);
                returnModel.setFlag(0);
                returnModel.setMsg("");
                returnModel.setObject(null);
                return returnModel;//发送短信失败
            }else{
                Object tmpObj = failList.get(0);
                returnModel.setFlag(1);
                returnModel.setMsg(JSONObject.parseObject(tmpObj.toString()).getString("respCode"));
                returnModel.setObject(null);
                return returnModel;//发送短信失败
            }

        }
    }

    // 定义一个请求参数拼接方法
    public static String getQueryArgs(String accountSid, String smsContent, String to, String timestamp, String sig,
                                      String respDataType) {
        return "accountSid=" + accountSid + "&smsContent=" + smsContent + "&to=" + to + "&"+"timestamp=" + timestamp
                + "&sig=" + sig + "&respDataType=" + respDataType;
    }


    // sing签名
    public static String getMD5(String sid, String token, String timestamp) {

        StringBuilder result = new StringBuilder();
        String source = sid + token + timestamp;
        // 获取某个类的实例
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            // 要进行加密的东西
            byte[] bytes = digest.digest(source.getBytes());
            for (byte b : bytes) {
                String hex = Integer.toHexString(b & 0xff);
                if (hex.length() == 1) {
                    result.append("0" + hex);
                } else {
                    result.append(hex);
                }
            }
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return result.toString();
    }

    // 创建验证码
    public static String smsCode() {
        String random = (int) ((Math.random() * 9 + 1) * 100000) + "";
        return random;
    }
}



