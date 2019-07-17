package com.greenplatform.aop;


/**
 * 调用用户点赞业务前后都需要判断金币点赞池中的点赞数有无达到10万
 * 前：未达到十万，调用点赞，达到十万：停止调用
 * 后：未达到十万，继续，达到十万：停用点赞业务，设置定时任务两个小时候调用瓜分金币业务
 */
public @interface WebDoLike {
}
