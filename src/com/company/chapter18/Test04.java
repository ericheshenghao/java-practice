package com.company.chapter18;


import java.util.Objects;

public class Test04 {
    public static void main(String[] args) {

    }
}

class Student {
    //     学号
    int no;  // 基本数据类新 比较时使用 ==
    // 应用数据类型 使用equals
    String school;

    public Student(int no, String school) {
        this.no = no;
        this.school = school;
    }

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "no=" + no +
                ", school='" + school + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return no == student.no && this.school.equals(student.school);
    }

}
