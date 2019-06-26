package com.imooc.concurrent.suiShow;

/**
 * Created by Luowenlv on 2018/11/21,9:45  双方作战军队线程
 */
public class ArmyRunnable implements Runnable {
    //volatile保证线程可以正确读取其他线程写入的值
    //可见性ref JMM，happens-before原则
    volatile boolean keepRunning = true;

    //军队任务作战细节
    @Override
    public void run() {
        while (keepRunning) {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + "进攻对方[" + i + "]次");

                Thread.yield();//让出处理器时间,让其他线程也有执行的机会
            }
        }

        System.out.println(Thread.currentThread().getName() + "结束战斗！");
    }
}
