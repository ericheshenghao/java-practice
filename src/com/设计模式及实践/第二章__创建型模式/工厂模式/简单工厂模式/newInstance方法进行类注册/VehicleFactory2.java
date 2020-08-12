package com.设计模式及实践.第二章__创建型模式.工厂模式.简单工厂模式.newInstance方法进行类注册;



import java.util.HashMap;
import java.util.Map;

class main{
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {

        VehicleFactory2.registerVehicle("1", new Bike());
        Vehicle vehicle = new VehicleFactory2().createVehicle("1");


    }
}

public class VehicleFactory2 {
    private static Map<String ,Vehicle> registeredProducts = new HashMap<String, Vehicle>();


    public static void registerVehicle(String vehicleId,Vehicle vehicle){
        registeredProducts.put(vehicleId,vehicle);
    }

    public Vehicle createVehicle(String vehicleId) throws IllegalAccessException, InstantiationException {

        return  registeredProducts.get(vehicleId).newInstace();
    }



}

abstract class Vehicle{

    abstract  public Vehicle newInstace();


}

class Bike extends Vehicle {
    Bike(){
        System.out.println("bike is initialized");
    }

    @Override
    public Vehicle newInstace() {
        return new Bike();
    }
}

class Car extends Vehicle {

    @Override
    public Vehicle newInstace() {
        return new Car();
    }
}

class Truck extends Vehicle {

    @Override
    public Vehicle newInstace() {
        return new Truck();
    }
}