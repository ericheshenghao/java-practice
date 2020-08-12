package com.Spring5核心原理与30个类手写实战.第二章_spring中常用的设计模式.工厂方法模式;


class main {
    public static void main(String[] args) {
        CarFactory carFactory = new CarFactory();
        Vehicle vehicle = carFactory.create("small");
        vehicle.travel();
    }
}

// 抽象工厂
public  abstract class VehicleFactory {
    protected  abstract Vehicle create(String size);
}

// 汽车实体工厂
class CarFactory extends VehicleFactory {
    @Override
    protected Vehicle create(String size) {
          if(size.equals("small")){
            return new SportCar();
        }else if(size.equals("large"))
            return new SedanCar();
        return null;
    }
}

//卡车实体工厂
class TruckFactory extends VehicleFactory {
    @Override
    protected Vehicle create(String size) {
       if(size.equals("small")) return new SmallTruck();
        else if(size.equals("large")) return new LargeTruck();
        return  null;
    }
}


//
abstract  class Vehicle{
   abstract void travel();
}

class SmallTruck extends Vehicle {
    @Override
    void travel() {
        System.out.println("SmallTruck在开");
    }
}


class LargeTruck extends Vehicle {
    @Override
    void travel() {
        System.out.println("LargeTruck在开");
    }
}

class SportCar extends Vehicle {
    @Override
    void travel() {
        System.out.println("SportCar在开");
    }
}

class SedanCar extends Vehicle {
    @Override
    void travel() {
        System.out.println("SedanCar在开");
    }
}