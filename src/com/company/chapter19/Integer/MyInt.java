package com.company.chapter19.Integer;

// 这种包装类实际上我们不需要写
// 可以直接使用
public class MyInt {
    int value;

    public MyInt(int value) {
        this.value = value;
    }

    public MyInt() {
    }

    @Override
    public String toString() {
        return "MyInt{" +
                "value=" + value +
                '}';
    }
}
