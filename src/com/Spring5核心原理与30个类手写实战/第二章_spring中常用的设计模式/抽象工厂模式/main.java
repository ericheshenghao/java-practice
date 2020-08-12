package com.Spring5核心原理与30个类手写实战.第二章_spring中常用的设计模式.抽象工厂模式;


class main {
    public static void main(String[] args) {
        TruckFactory truckFactory = new TruckFactory();
        Vehicle vehicle = truckFactory.createVehicle();
        vehicle.travel();

    }

}

interface Vehicle{
    public void travel();
}


interface VehicleFactory{
    Vehicle createVehicle();
}

 class Truck implements  Vehicle{
    @Override
    public void travel() {
        System.out.println("卡车在开车");
    }


}

  class TruckFactory implements VehicleFactory{
    @Override
    public Vehicle createVehicle() {
        return new Truck();
    }
}

