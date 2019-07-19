package com.greenplatform.aop;


import java.lang.annotation.*;

/**
 * 增加金币业务：（如果是第一次增加账户金币则需要新增一条金币汇总表）
 * 增加账户金币的业务：每日种植任务；分享平台；捐赠植物
 * 调用这三个服务时需使用此注解来增加对应账户的金币数
 *
 * 业务说明：1.判断是否第一次增加金币==>金币汇总表中增加一条记录
 * 2.增加金币明细表中增加一条记录
 * 3.修改金币汇总表记录
 * 4.如果是基础任务获得金币说要判断是否三次任务都已完成==>三项任务都完成才增加一条记录
 */
@Target(ElementType.METHOD) //注解放置的目标位置,METHOD是可注解在方法级别上
@Retention(RetentionPolicy.RUNTIME) //注解在哪个阶段执行
@Documented //生成文档
public @interface WebAddGold {
    //操作类型(完成种植任务C_GOLD_ZJYY_1,平台分享好友C_GOLD_ZJYY_2,完成植物捐赠C_GOLD_ZJYY_3)
    String cAddType() default "";
}
