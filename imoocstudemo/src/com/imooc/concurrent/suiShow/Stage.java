package com.imooc.concurrent.suiShow;

/**
 * Created by Luowenlv on 2018/11/21,9:57  大戏舞台线程
 */
public class Stage extends Thread {
    public void run() {
        System.out.println("欢迎观看隋唐演义,请将手机调为振动或者静音");

        try {
            Thread.sleep(5000);//给与观众设置手机的时间
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("大幕徐徐拉开");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("话说隋末年间......");

        ArmyRunnable armyTaskOfSuiDynasty = new ArmyRunnable();//作战任务
        ArmyRunnable armyTaskOfRevolt = new ArmyRunnable();

        Thread armyOfSuiDynasty = new Thread(armyTaskOfSuiDynasty, "隋军");//军队
        Thread armyOfRevolt = new Thread(armyTaskOfRevolt, "农名起义军");

        armyOfSuiDynasty.start();
        armyOfRevolt.start();

        try {
            Thread.sleep(50);//Stage线程中嵌套了armyOfSuiDynasty和armyOfRevolt线程，当Stage线程在执行时占用了CPU
            //因而其他两个线程得不到资源无法执行，当Stage线程休眠时其他两个线程获取到了资源因此则
            //一直在执行（一直在打架），当Stage休眠时间结束之后，程序向下执行，将双方的keepRunning
            //属性设置为false双方的循环结束
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("正当双方激战正酣，半路杀出了个程咬金");

        Thread mrCheng = new KeyPersonThread();//关键人物出场，关键人物的出现会影响整个战争的形势
        mrCheng.setName("程咬金");
        System.out.println("程咬金的理想是结束战争，使百姓安居乐业");

        //停止军队作战
        armyTaskOfSuiDynasty.keepRunning = false;
        armyTaskOfRevolt.keepRunning = false;

        try {
            Thread.sleep(2000);//让出资源给关键人物
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mrCheng.start();//关键人物开始作战
        try {
            mrCheng.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("战争结束，百姓安居乐业，程咬金完成了理想");
        System.out.println("感谢观看隋唐演义，再见！");



        /*try {
            armyOfRevolt.join();//暂停其他线程，让当前线程获取资源继续执行
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

    }

    public static void main(String[] args) {
        new Stage().start();
    }
}
