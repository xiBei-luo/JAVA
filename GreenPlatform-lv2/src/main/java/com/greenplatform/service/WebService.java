package com.greenplatform.service;

import com.greenplatform.model.*;
import com.greenplatform.model.base.ReturnModel;
import net.sf.json.JSONObject;
import org.springframework.http.HttpRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public interface WebService {

    //查询用户
    ReturnModel selectUserByPhone(String cPhone);

    //完成任务业务
    ReturnModel accomplishRw(TGreenRwRwmx tGreenRwRwmx);

    //补任务
    ReturnModel accYesRw();

    //能量兑换种子业务
    ReturnModel buySeeds(TGreenZzZjzzmx tGreenZzZjzzmx);

    //查询我的账户信息（人员姓名，人员等级，能量总量，种子汇总，今日任务）
    ReturnModel selectLoginuserAccount();

    //查询首页所需信息（当前人当日任务完成情况，能量汇总排行前十，商品明细）
    ReturnModel selectLoginuserHome();

    //点赞业务
    ReturnModel doLike();

    //实名认证
    ReturnModel certification(PlateUser plateUser, HttpSession session);

    //捐赠植物业务
    ReturnModel contributeSeed(String cLsh,String cSpbh);

    //充值能量
    ReturnModel rechargeNl();

    //能量提现
    ReturnModel presentationNl();

    //金币点赞数达到10万，瓜分能量业务
    void divideNl() throws Exception;

    //查询能量充值记录
    ReturnModel selectTGreenNlCzjl(JSONObject jsonObject);

    //查询能量提现记录
    ReturnModel selectTGreenNlTxjl(JSONObject jsonObject);

    //查询捐赠记录
    ReturnModel selectTGreenZzJzjl(JSONObject jsonObject);

    //查询欢迎页数据
    ReturnModel selectWelcomePageInfo();

    ReturnModel getInviteQrcode(HttpServletRequest httpServletRequest);

    //查询我的账户-基本信息（能量/金币/点赞数）
    ReturnModel selectLoginuserAccountJbxx();

    //查询我的账户-我的任务（）
    ReturnModel selectLoginuserAccountWdrw();

    //查询我的账户-我的植物（）
    ReturnModel selectLoginuserAccountWdzw();

    //查询我的账户-我的徒弟（）
    ReturnModel selectLoginuserAccountWdtd();

    //查询任务日历提示
    ReturnModel selectRwDayTips();




}
