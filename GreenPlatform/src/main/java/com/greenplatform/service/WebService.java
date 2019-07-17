package com.greenplatform.service;

import com.greenplatform.model.*;
import com.greenplatform.model.base.ReturnModel;

public interface WebService {

    //完成任务业务
    public ReturnModel accomplishRw(TGreenRwRwmx tGreenRwRwmx);

    //能量兑换种子业务
    public ReturnModel buySeeds(TGreenZzZjzzmx tGreenZzZjzzmx);

    //查询我的账户信息（人员姓名，人员等级，能量总量，种子汇总，今日任务）
    public ReturnModel selectLoginuserAccount();

    //查询首页所需信息（当前人当日任务完成情况，能量汇总排行前十，商品明细）
    public ReturnModel selectLoginuserHome();

    //点赞业务
    public ReturnModel doLike();

    //实名认证
    public ReturnModel certification(PlateUser plateUser);

    //金币点赞数达到10万，瓜分能量业务
    public void divideNl();

}
