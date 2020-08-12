package com.Spring5核心原理与30个类手写实战.第二章_spring中常用的设计模式.原型模式.齐天大圣;

import java.io.*;
import java.util.Date;

public class main {
    public static void main(String[] args) {
        QiTianDaSheng qiTianDaSheng = new QiTianDaSheng();
        try {
            QiTianDaSheng clone = (QiTianDaSheng) qiTianDaSheng.clone();
            System.out.println("深克隆："+(qiTianDaSheng.jinGuBnag==clone.jinGuBnag));
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        QiTianDaSheng q = new QiTianDaSheng();
        QiTianDaSheng n = qiTianDaSheng.shallowClone(q);
        System.out.println("浅克隆："+(q.jinGuBnag==n.jinGuBnag));
    }

}

class  Monkey{
    public int height;
    public int weight;
    public Date birthday;
}

class JinGuBnag implements Serializable{
    public float h=100;
    public float d=100;
    public void big(){
        this.d*=2;
        this.h*=2;
    }
    public void small(){
        this.d/=2;
        this.h/=2;
    }

}

class QiTianDaSheng extends Monkey implements Cloneable,Serializable{
    public JinGuBnag jinGuBnag;
    public QiTianDaSheng(){
        this.birthday= new Date();
        this.jinGuBnag = new JinGuBnag();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return this.deepClone();
    }

    private Object deepClone() {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(this);

            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);
          QiTianDaSheng copy =   (QiTianDaSheng)  ois.readObject();
            copy.birthday = new Date();
            return copy;

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return  null;
        }
    }

    public QiTianDaSheng shallowClone(QiTianDaSheng target){
        QiTianDaSheng qiTianDaSheng = new QiTianDaSheng();
        qiTianDaSheng.height =target.height;
        qiTianDaSheng.weight=target.weight;
        qiTianDaSheng.jinGuBnag=target.jinGuBnag;
        qiTianDaSheng.birthday=new Date();
        return qiTianDaSheng;
    }
}