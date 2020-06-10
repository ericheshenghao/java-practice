package com.设计模式及实践.第二章__创建型模式.工厂模式.简单工厂模式.静态工厂模式;

class main{
    public static void main(String[] args) {
        VehicleFactory.create(VehicleFactory.VehicheType.Bike);
    }
}

public class VehicleFactory {
    public enum VehicheType{
        Bike,Car,Truck
    }
    public static Vehicle create (VehicheType type){
        if(type.equals(VehicheType.Bike)){
            System.out.println("创建了自行车");
//            return new Bike();
        }
        if(type.equals(VehicheType.Car)){

            return new Car();
        }
        if(type.equals(VehicheType.Truck)){
            return new Truck();
        }
        return null;
    }

}

class Vehicle{

}
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  class Car extends Vehicle{

}class Truck extends Vehicle{

}