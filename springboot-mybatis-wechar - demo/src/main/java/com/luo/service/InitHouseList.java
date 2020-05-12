package com.luo.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InitHouseList {
    public static void main(String[] args) {
        getBiuldList("","");
    }

    //查询
    public static Map getBiuldList(String biuldId,String unitId){
        //企业登录编码
        String app_id="funi";
        //企业key.请联系管理人在 系统管理-》对外接口 模块下申请
        String keyValue="623169b7-f167-46cf-a52c-9e784ec24b1a";
        //erp系统访问地址
        String urlHttp="http://wyerp.yijuweilai.com";


        String url = "";
        String param ="";
        String sign = "";
        String responseText = "";

        //查询小区收费项目列表
        String areaId = "e4439739-3e60-4c90-9a80-4da16bd0e92a";
        //查询当前企业房屋清单
        url=urlHttp+"/sys/interface/houseList";
        param="app_id="+app_id+"&area_id="+areaId;
        sign= InterfaceTest.MD5Utils.md5(param,keyValue);
        //System.out.println("查询当前企业房屋清单:"+sign);
        responseText=sendGet(url,param,sign);

        initRoomData(responseText);

        return null;

//        if (!(biuldId == null || biuldId.equals(""))){
//            if (!(unitId == null || unitId.equals(""))){
//                return getRoom(responseText,biuldId,unitId);
//            }else{
//                return getUnit(responseText,biuldId);
//            }
//        }
//        return getBuildData(responseText);

    }


    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     *  获取所有楼栋号、单元号与房间号
     * @param responseText  接口返回数据
     * @return
     */
    public Map getBuildData(String responseText){
        List retListText = new ArrayList();//返回结果对象
        List retListIndex = new ArrayList();//返回结果对象


        Map retMap = new HashMap();
        JSONObject jsonObject = JSONObject.parseObject(responseText);//将返回结果转为JSON对象
        List<Map> list = JSONObject.parseArray((jsonObject.get("results").toString()),Map.class);//获取返回结果中的results值
        //System.out.println(list);

        List buildListIndex = new ArrayList();//楼栋号
        List unitListIndex = new ArrayList();//单元号
        List roomListIndex = new ArrayList();//房间号
        List buildListText = new ArrayList();//楼栋号
        List unitListText = new ArrayList();//单元号
        List roomListText = new ArrayList();//房间号

        for (int i = 0;i<list.size();i++){
            String roomNumStr = list.get(i).get("houseName").toString();//获取房间号，12-3-202
            String[] roomNumArr = roomNumStr.split("-");//解析房间号，房间号由楼栋号单元号和房间号组成

            if (roomNumArr.length == 3){
                if (i == 0){
                    buildListIndex.add(roomNumArr[0]);//将组装结果装入数组中
                    unitListIndex.add(roomNumArr[1]);//将组装结果装入数组中
                    roomListIndex.add(roomNumArr[2]);//将组装结果装入数组中

                    buildListText.add(roomNumArr[0]);//将组装结果装入数组中
                    unitListText.add(roomNumArr[1]);//将组装结果装入数组中
                    roomListText.add(roomNumArr[2]);//将组装结果装入数组中
                }else{

                    //去重
                    if (!buildListText.contains(roomNumArr[0])){
                        buildListIndex.add(roomNumArr[0]);//将组装结果装入数组中
                        buildListText.add(roomNumArr[0]);//将组装结果装入数组中
                    }


                    //去重
                    if (!unitListText.contains(roomNumArr[1])){
                        unitListIndex.add(roomNumArr[1]);//将组装结果装入数组中
                        unitListText.add(roomNumArr[1]);//将组装结果装入数组中
                    }


                    //去重
                    if (!roomListText.contains(roomNumArr[2])){
                        roomListIndex.add(roomNumArr[2]);//将组装结果装入数组中
                        roomListText.add(roomNumArr[2]);//将组装结果装入数组中
                    }
                }
            }
        }

        retListText.add(buildListText);
        retListText.add(unitListText);
        retListText.add(roomListText);
        retListIndex.add(buildListIndex);
        retListIndex.add(unitListIndex);
        retListIndex.add(roomListIndex);

        retMap.put("retListText",retListText);
        retMap.put("retListIndex",retListIndex);

        System.out.println(retMap);
        return retMap;
    }


    //根据楼栋号获取单元号
    public static Map getUnit(String responseText,String biuldId){
        Map retMap = new HashMap();
        JSONObject jsonObject = JSONObject.parseObject(responseText);//将返回结果转为JSON对象
        List<Map> list = JSONObject.parseArray((jsonObject.get("results").toString()),Map.class);//获取返回结果中的results值

        List unitListText = new ArrayList();//单元号
        List roomListText = new ArrayList();//房间号

        List retListText = new ArrayList();//返回结果对象

        for (int i=0; i<list.size(); i++) {
            String roomNumStr = list.get(i).get("houseName").toString();//获取房间号，12-5-1
            //System.out.println(roomNumStr);
            String[] roomNumArr = roomNumStr.split("-");//解析房间号，房间号由楼栋号单元号和房间号组成

            //房间号符合规范的进行赋值，有的房间号没有严格按照：楼栋号-单元号-房间号格式组成
            if (roomNumArr.length == 3 && roomNumArr[0].equals(biuldId)){
                if (i == 0){
                    unitListText.add(roomNumArr[1]);//将组装结果装入数组中
                    roomListText.add(roomNumArr[2]);//将组装结果装入数组中
                }else{
                    if (!unitListText.contains(roomNumArr[1])){
                        unitListText.add(roomNumArr[1]);//将组装结果装入数组中
                    }
                    if (!roomListText.contains(roomNumArr[2])){
                        roomListText.add(roomNumArr[2]);//将组装结果装入数组中
                    }
                }
            }

        }


        retListText.add(unitListText);
        retListText.add(roomListText);//将数据添加到返回结果数组中，组成二维数组

        retMap.put("retListText",retListText);

        System.out.println(retMap);

        return retMap;
    }


    //根据楼栋号和单元号获取房间号
    public static Map getRoom(String responseText,String biuldId,String unitId){
        Map retMap = new HashMap();
        JSONObject jsonObject = JSONObject.parseObject(responseText);//将返回结果转为JSON对象
        List<Map> list = JSONObject.parseArray((jsonObject.get("results").toString()),Map.class);//获取返回结果中的results值
        List roomListText = new ArrayList();//房间号

        List retListText = new ArrayList();//返回结果对象

        for (int i=0; i<list.size(); i++) {
            String roomNumStr = list.get(i).get("houseName").toString();//获取房间号，12-5-1
            //System.out.println(roomNumStr);
            String[] roomNumArr = roomNumStr.split("-");//解析房间号，房间号由楼栋号单元号和房间号组成

            //房间号符合规范的进行赋值，有的房间号没有严格按照：楼栋号-单元号-房间号格式组成
            if (roomNumArr.length == 3 && roomNumArr[0].equals(biuldId) && roomNumArr[1].equals(unitId)){
                roomListText.add(roomNumArr[2]);//将组装结果装入数组中
                if (i == 0){
                    roomListText.add(roomNumArr[2]);//将组装结果装入数组中
                }else{
                    if (!roomListText.contains(roomNumArr[2])){
                        roomListText.add(roomNumArr[2]);//将组装结果装入数组中
                    }
                }
            }

        }

        retListText.add(roomListText);//将数据添加到返回结果数组中，组成二维数组

        retMap.put("retListText",retListText);

        System.out.println(retMap);

        return retMap;
    }


    //测试
    public static List initRoomData(String responseText){
        JSONObject jsonObject = JSONObject.parseObject(responseText);//将返回结果转为JSON对象
        List<Map> list = JSONObject.parseArray((jsonObject.get("results").toString()),Map.class);//获取返回结果中的results值

        List<JSONObject> buildList = new ArrayList();//楼栋号
        List<JSONObject> unitList = new ArrayList();//单元号
        List<JSONObject> roomList = new ArrayList();//房间号

        List retList = new ArrayList();//返回结果对象
        System.out.println(list.size());

        for (int i=0; i<list.size(); i++) {
            String roomNumStr = list.get(i).get("houseName").toString();//获取房间号，12-5-1
            String[] roomNumArr = roomNumStr.split("-");//解析房间号，房间号由楼栋号单元号和房间号组成

            //房间号符合规范的进行赋值，有的房间号没有严格按照：楼栋号-单元号-房间号格式组成
            if (roomNumArr.length == 3){
                JSONObject biuldMap = new JSONObject();
                JSONObject unitMap = new JSONObject();
                JSONObject roomMap = new JSONObject();

                biuldMap.put("id",i);
                biuldMap.put("name",roomNumArr[0]);//组装需要的结果

                unitMap.put("id",i);
                unitMap.put("name",roomNumArr[1]);
                unitMap.put("parentId",biuldMap.get("id"));//组装需要的结果

                roomMap.put("id",i);
                roomMap.put("name",roomNumArr[2]);
                roomMap.put("parentId",unitMap.get("id"));//组装需要的结果

                buildList.add(biuldMap);//将组装结果装入数组中
                unitList.add(unitMap);//将组装结果装入数组中
                roomList.add(roomMap);//将组装结果装入数组中
                System.out.println(buildList);




            }

        }


        retList.add(buildList);
        retList.add(unitList);
        retList.add(roomList);//将数据添加到返回结果数组中，组成二维数组

        //System.out.println(retList);

        return retList;
    }





    /**
     * 向指定URL发送GET方法的请求
     *
     * @param url
     *            发送请求的URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return URL 所代表远程资源的响应结果
     */
    public static String sendGet(String url, String param,String sign) {
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url + "?" + param+"&sign="+sign;
            //System.out.println(urlNameString);
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }
    static class MD5Utils {
        /**
         * MD5加密计算摘要
         * @param str 待加密字符串
         * @param salt 盐值
         * @return
         */
        public static String md5(String str,String salt){
            String sum = null;
            try {
                // 生成一个MD5加密计算摘要
                MessageDigest md = MessageDigest.getInstance("MD5");
                // 计算md5函数
                md.update(salt.getBytes());
                md.update(str.getBytes());
                // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
                sum = new BigInteger(1, md.digest()).toString(16);
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            return sum;
        }
    }
}
