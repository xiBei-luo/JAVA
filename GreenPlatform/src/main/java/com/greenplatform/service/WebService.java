package com.greenplatform.service;

import com.greenplatform.model.*;
import com.greenplatform.model.base.ReturnModel;
import net.sf.json.JSONObject;

public interface WebService {

    //查询用户
    ReturnModel selectUserByPhone(String cPhone);

    //完成任务业务
    ReturnModel accomplishRw(TGreenRwRwmx tGreenRwRwmx);

    //能量兑换种子业务
    ReturnModel buySeeds(TGreenZzZjzzmx tGreenZzZjzzmx);

    //查询我的账户信息（人员姓名，人员等级，能量总量，种子汇总，今日任务）
    ReturnModel selectLoginuserAccount();

    //查询首页所需信息（当前人当日任务完成情况，能量汇总排行前十，商品明细）
    ReturnModel selectLoginuserHome();

    //点赞业务
    ReturnModel doLike();

    //实名认证
    ReturnModel certification(PlateUser plateUser);

    //捐赠植物业务
    ReturnModel contributeSeed(String cLsh,String cSpbh);

    //充值能量
    ReturnModel rechargeNl();

    //能量提现
    ReturnModel presentationNl();

    //金币点赞数达到10万，瓜分能量业务
    void divideNl();

    //查询能量充值记录
    ReturnModel selectTGreenNlCzjl(JSONObject jsonObject);

    //查询能量提现记录
    ReturnModel selectTGreenNlTxjl(JSONObject jsonObject);

    //查询捐赠记录
    ReturnModel selectTGreenZzJzjl(JSONObject jsonObject);



}
