package com.lamda表达式.第四章.查找最大值和最小值;

import java.text.CollationElementIterator;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class Test01 {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(  // 员工集合
                new Employee("张", 123, "公司1"),
                new Employee("何", 1234, "公司2"),
                new Employee("王", 12356, "公司3"),
                new Employee("郑", 123456, "公司4"),
                new Employee("李", 1234567, "公司5"),
                new Employee("舞", 12345678, "公司6")
        );
        // 流为空时的默认值
        Employee employee = new Employee("a man has no name ", 0, "balck and white");

        Optional<Employee> optionEmp = employees.stream()
                .reduce(BinaryOperator.maxBy(Comparator.comparingInt(Employee::getSalary)));
        System.out.println(optionEmp.orElse(employee));

        Optional<Employee> max = employees.stream()
                .max(Comparator.comparingInt(Employee::getSalary));
        OptionalInt max1 = employees.stream()
                .mapToInt(Employee::getSalary)
                .max();
        System.out.println("The max salary is "+max1);

        Map<String, Optional<Employee>> map = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.maxBy(Comparator.comparingInt(Employee::getSalary))));
        map.forEach((house,emp)->{
            System.out.println(house+":"+emp.orElse(employee));
        });


    }
}

class Employee{
    private String name;
    private Integer salary;
    private String department;

    public Employee(String name, Integer salary, String department) {
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}