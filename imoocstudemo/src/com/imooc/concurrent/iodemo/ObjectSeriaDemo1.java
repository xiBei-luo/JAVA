package com.imooc.concurrent.iodemo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * Created by Luowenlv on 2018/11/26,15:08
 */
public class ObjectSeriaDemo1 {
    public static void main(String[] args) throws Exception {
        String file = "f:\\iotest\\objSeria.dat";
        /*1.对象的序列化
        ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(file)
        );
        Student stu = new Student("1001","张三",20);;
        oos.writeObject(stu);
        oos.flush();
        oos.close();*/

        /*2.对象的反序列化*/
        ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(file)
        );
        Student stu = (Student) ois.readObject();
        System.out.println(stu);
        ois.close();
    }
}
