package com.Spring5核心原理与30个类手写实战.第二章_spring中常用的设计模式.简单工厂模式;

import java.util.HashMap;
import java.util.Map;

class main{
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        VehicleFactory vehicleFactory = new VehicleFactory();
        Vehicle vehicle = vehicleFactory.create(Bike.class);
        vehicle.travel();
    }
}

class VehicleFactory {
   public Vehicle create(Class<? extends Vehicle> clazz){
        try {
            if(null!=clazz){
                return  clazz.newInstance();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}

abstract class Vehicle{
    abstract void travel();
}


class Bike extends Vehicle{
    @Override
    void travel() {
        System.out.println("自行车在开");
    }
}

class Car extends Vehicle{
    @Override
    void travel() {
        System.out.println("汽车在开");
    }
}

class Truck extends Vehicle{

    @Override
    void travel() {
        System.out.println("卡车在开");
    }
}