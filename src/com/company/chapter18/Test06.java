package com.company.chapter18;

/*
关于object类中finalize()方法
2. 只有一个方法体，里面没有代码，而且这个方法是protected修饰的
3. 这个方法不需要手动调用，jvm的垃圾回收期负责调用这个方法。
只需要重写，不需要自己调用。GC来调用，GabageCollection
4. finalize()方法的执行时机：
当一个java对象即将被垃圾回收器回收的时候。垃圾回收期气负责掉用finalize（）方法
5 . finalized 方法在对象被销毁前执行的一段代码。
6. 垃圾回收不会轻易启动
    垃圾太少不会启动
 */
public class Test06 {
    public static void main(String[] args) {
        Person p = new Person();
        // 怎么回收
        p = null;

        System.gc();
        // 建议启动回收机制的代码

        // 多早点垃圾
//        for (int i = 0; i < 10000000; i++) {
//            Person p = new Person();
//            p=null;
//        }
    }
}

// 项目开发中有这样的需求：所有对象在jvm中被释放的时候，请记录一下释放时间
// 记录对象被试方的时间点，这个负责记录的代码写道哪里
// finalize()
class Person {
    protected void finalize() throws Throwable {
        System.out.println(this + "即将被销毁");
    }
}
