package com.设计模式及实践.第二章__创建型模式.工厂模式.抽象工厂模式;

public abstract class CarBuilder {
   abstract  void  buildCar();
   abstract void addEngine(String  type);
    abstract void addWheel(String  type);
    abstract  void paint(String color);
    abstract void addTransmission(String type);
    abstract void addGasTank(String type);
    abstract  void addBatteries(String type);
    abstract  Car getCar();
}

class main {
    public static void main(String[] args) {
        Car car = new CarBuilderDirector().buildElectricCar(new ElectricCarBuilder());


        System.out.println(car);
        System.out.println(car.engine);
    }
}

class CarBuilderDirector {
    public Car buildElectricCar(CarBuilder builder){
        builder.buildCar();
        builder.addEngine("Electric 150 km");
        builder.addBatteries("1500 kwh");
        builder.addTransmission("Manual");
        for (int i = 0; i < 4; i++) {
            builder.addWheel("20*12*30");
            builder.paint("red");
        }
        return  builder.getCar();

    }

    public Car buildHybridCar(CarBuilder builder){
        builder.buildCar();
        builder.addEngine("Electric 150 km");
        builder.addBatteries("1500 kwh");
        builder.addTransmission("Manual");
        for (int i = 0; i < 4; i++)
            builder.addWheel("20*12*30");
            builder.paint("red");
            builder.addGasTank("1500 kwh");
            builder.addEngine("Gas 1600cc");
        return  builder.getCar();
    }
}

class Car {
    public String engine;

    @Override
    public String toString() {
        return engine;
    }
}

class ElectricCarBuilder extends CarBuilder{
    Car car;

    @Override
    void buildCar() {
        this.car = new Car();
    }

    @Override
    void addEngine(String type) {
        car.engine = type;
        System.out.println("添加了"+type+"引擎");
    }

    @Override
    void addWheel(String type) {
        System.out.println("添加了"+type+"轮子");
    }

    @Override
    void paint(String color) {
        System.out.println("给车子喷了"+color+"油漆");
    }

    @Override
    void addTransmission(String type) {
        System.out.println("添加了"+type+"发动机");
    }

    @Override
    void addGasTank(String type) {

    }

    @Override
    void addBatteries(String type) {
        System.out.println("添加了"+type+"电池");
    }

    @Override
    Car getCar() {
        return this.car;
    }
}

class GasolineCarBuilder extends CarBuilder {
    Car car;
    @Override
    void buildCar() {
        this.car = new Car();
    }

    @Override
    void addEngine(String type) {
        System.out.println("添加了"+type+"引擎");
    }

    @Override
    void addWheel(String type) {
        System.out.println("添加了"+type+"轮子");
    }

    @Override
    void paint(String color) {
        System.out.println("给车子喷了"+color+"油漆");
    }

    @Override
    void addTransmission(String type) {
        System.out.println("添加了"+type+"发动机");
    }

    @Override
    void addGasTank(String type) {
        System.out.println("添加了"+type+"油箱");
    }

    @Override
    void addBatteries(String type) {

    }

    @Override
    Car getCar() {
        return this.car;
    }
}