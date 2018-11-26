package com.imooc.concurrent.iodemo;

import java.io.Serializable;

/**
 * Created by Luowenlv on 2018/11/26,15:06
 */
public class Student implements Serializable {
    private String stuname;
    private String stuno;
    private transient int stuage;//被transient修饰符修饰的属性不会进行默认的序列化，但也可以自行完成对此属性的序列化

    public Student(String stuname, String stuno, int stuage) {
        this.stuname = stuname;
        this.stuno = stuno;
        this.stuage = stuage;
    }

    public Student() {
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }

    public String getStuno() {
        return stuno;
    }

    public void setStuno(String stuno) {
        this.stuno = stuno;
    }

    public int getStuage() {
        return stuage;
    }

    public void setStuage(int stuage) {
        this.stuage = stuage;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuname='" + stuname + '\'' +
                ", stuno='" + stuno + '\'' +
                ", stuage=" + stuage +
                '}';
    }

    private void writeObject(java.io.ObjectOutputStream s) throws java.io.IOException{
        s.defaultWriteObject();//把jvm能默认序列化的元素进行序列化操作
        s.writeInt(stuage);//自行完成被transient修饰的stuage的序列化
    }//序列化

    private void readObject(java.io.ObjectInputStream s) throws java.io.IOException,ClassNotFoundException{
        s.defaultReadObject();//把jvm能默认反序列化的元素进行反序列化操作
        this.stuage = s.readInt();//自行完成被transient修饰的stuage的反序列化
    }//反序列化


}
