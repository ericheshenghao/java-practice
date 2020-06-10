package com.company.chapter20.IO流.对象流;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/*‘
错误信息
Exception in thread "main" java.io.InvalidClassException:
com.company.chapter20.IO流.对象流.Student; local class incompatible:
stream classdesc serialVersionUID = -2869926022333735997,（十年后）
local class serialVersionUID = -63602546340085210（十年前）
// 首先通过类名区分
// 然后靠版本号区分
主要作用
不同的人开发了同名字的类，但不是同一个类，这时候序列化起作用
jm可以区分开这两个类，都有序列化版本号

有什么缺陷
后续不能修改代码

最终结论：
 凡是实现了这个和接口，建议提供一个固定不变的序列化版本号,例如
private static final long serialVersionUID = 8683452581122892189L;
 */
public class Test02 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("student"));
        Object obj = ois.readObject();
        System.out.println(obj.toString());
        ois.close();
    }
}
