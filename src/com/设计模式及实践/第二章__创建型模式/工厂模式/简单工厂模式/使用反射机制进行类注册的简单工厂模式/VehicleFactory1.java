package com.设计模式及实践.第二章__创建型模式.工厂模式.简单工厂模式.使用反射机制进行类注册的简单工厂模式;



import java.util.HashMap;
import java.util.Map;

class main{
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {

        VehicleFactory1.registerVehicle("1",Bike.class);
        new VehicleFactory1().createVehicle("1");


    }
}

public class VehicleFactory1 {
    private static Map<String ,Class> registeredProducts = new HashMap<String, Class>();


    public static void registerVehicle(String vehicleId,Class vehicleClass){
        registeredProducts.put(vehicleId,vehicleClass);
    }

    public Vehicle createVehicle(String type) throws IllegalAccessException, InstantiationException {
        Class productClass = registeredProducts.get(type);
        return (Vehicle) productClass.newInstance();
    }



}

class Vehicle{



}

class Bike extends Vehicle {
    Bike(){
        System.out.println("bike is initialized");
    }
}

class Car extends Vehicle {

}

class Truck extends Vehicle {

}