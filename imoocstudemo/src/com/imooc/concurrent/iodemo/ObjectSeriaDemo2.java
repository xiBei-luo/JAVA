package com.imooc.concurrent.iodemo;

import java.io.*;

/**
 * Created by Luowenlv on 2018/11/26,15:33
 */
public class ObjectSeriaDemo2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        /*ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("f:\\iotest\\objSeria1.dat")
        );
        Foo2 foo2 = new Foo2();
        oos.writeObject(foo2);
        oos.flush();
        oos.close();*/
        /*ObjectInputStream ois=  new ObjectInputStream(
                new FileInputStream("f:\\\\iotest\\\\objSeria1.dat")
        );
        Foo2 foo2 = (Foo2)ois.readObject();
        System.out.println(foo2);
        ois.close();*/

        /*ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("f:\\iotest\\objSeria1.dat")
        );
        Bar2 bar2 = new Bar2();
        oos.writeObject(bar2);
        oos.flush();
        oos.close();*/

        ObjectInputStream ois=  new ObjectInputStream(
                new FileInputStream("f:\\\\iotest\\\\objSeria1.dat")
        );
        Bar2 bar2 = (Bar2)ois.readObject();
        System.out.println(bar2);
        ois.close();//对子类对象进行反序列化操作时，若子类实现了序列化接口，但其父类未实现序列化接口，则该父类构造函数会被调用
                    //简言之反序列化子类时，其父类构造函数会被调用（若父类实现了序列化接口则子类会默认也实现了序列化接口，则子类不用实现序列化接口）



    }
}

class Foo implements Serializable{
    public Foo(){
        System.out.println("Foo");
    }
}
class Foo1 extends Foo{
    public Foo1(){
        System.out.println("Foo1");
    }
}
class Foo2 extends Foo1{
    public Foo2(){
        System.out.println("Foo2");
    }
}
class Bar{
    public Bar(){
        System.out.println("bar");
    }
}
class Bar1 extends Bar implements Serializable{
    public Bar1() {
        System.out.println("bar1");
    }
}
class Bar2 extends Bar1{
    public Bar2() {
        System.out.println("bar2");
    }
}
