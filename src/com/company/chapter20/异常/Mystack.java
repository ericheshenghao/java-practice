package com.company.chapter20.异常;

/*
 1.可以储存任何引用数据类型
 2.提供push方法模拟压栈
 3.提供pop方法模拟弹栈
 4.编写测试程序，new 对象，调用push pop模拟压栈弹栈的动作
 5.假设站的默认初始化容量是10
 */
public class Mystack {
    // Object[],一维数组模拟，数组是java的第一个容器
    private Object[] elements;
    // 栈帧，永远指向栈顶部元素
    //默认初始值为空
    private int index = -1;


    public void push(Object obj) throws MyException {
        if (this.index >= this.elements.length - 1) {
            System.out.println("栈以满");
            MyException e = new MyException("栈以满");
            throw e;
        }
        //
        index++;
        elements[index] = obj;
        System.out.println("压栈成功，指向" + index);
    }

    /// 无参钩爪方法
    public Mystack() {
        // 动态初始化
        this.elements = new Object[10];
    }

    public Object[] getElements() {
        return elements;
    }

    public void setElements(Object[] elements) {
        this.elements = elements;
    }
}
