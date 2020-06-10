package com.company.chapter20.反射;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/*
非常灵活、OCP原则，对扩展开放、对修改关闭
 */
public class ReflectTest03 {
    public static void main(String[] args) throws IOException {
        // 通过io流读取文件
        FileReader reader = new FileReader("src/com/company/chapter20/反射/info.properities");
        // 创建属性类对象map
        Properties pro = new Properties();  // key value都是string
        //
        // 加载
        pro.load(reader);

//        关闭流
        reader.close();

        String className = pro.getProperty("className");

        //拿到了类名
        System.out.println(className);

        try {
            Class c = Class.forName(className);
            c.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

    }
}
