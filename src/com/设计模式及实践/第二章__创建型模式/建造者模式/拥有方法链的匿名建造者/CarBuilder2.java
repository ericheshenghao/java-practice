package com.设计模式及实践.第二章__创建型模式.建造者模式.拥有方法链的匿名建造者;

public abstract class CarBuilder2 {
   abstract  CarBuilder2  buildCar();
   abstract CarBuilder2 addEngine(String  type);
    abstract CarBuilder2 addWheel(String  type);
    abstract  CarBuilder2 paint(String color);
    abstract CarBuilder2 addTransmission(String type);
    abstract CarBuilder2 addGasTank(String type);
    abstract  CarBuilder2 addBatteries(String type);
    abstract Car build();
}

class main {
    public static void main(String[] args) {
        Car car = new CarBuilderDirector().buildElectricCar(new ElectricCarBuilder());
        System.out.println(car);
        System.out.println(car.engine);
    }
}

class CarBuilderDirector {
    public Car buildElectricCar(CarBuilder2 builder){
        return builder.buildCar().addEngine("Electric 150 km").addBatteries("1500 kwh").addTransmission("Manual").paint("red").addWheel("20*12*30")
               .addEngine("Gas 1600cc").build();
    }

    public Car buildHybridCar(CarBuilder2 builder){
        builder.buildCar();
        builder.addEngine("Electric 150 km");
        builder.addBatteries("1500 kwh");
        builder.addTransmission("Manual");
        for (int i = 0; i < 4; i++)
            builder.addWheel("20*12*30");
            builder.paint("red");
            builder.addGasTank("1500 kwh");
            builder.addEngine("Gas 1600cc");
        return  builder.build();
    }
}

class Car {
    public String engine;

    @Override
    public String toString() {
        return engine;
    }
}

class ElectricCarBuilder extends CarBuilder2 {
    Car car;

    @Override
    ElectricCarBuilder buildCar() {
        this.car = new Car();
        return this;
    }

    @Override
    ElectricCarBuilder addEngine(String type) {
        car.engine = type;
        System.out.println("添加了"+type+"引擎");
        return this;
    }

    @Override
    ElectricCarBuilder addWheel(String type) {
        System.out.println("添加了"+type+"轮子");
        return this;
    }

    @Override
    ElectricCarBuilder paint(String color) {
        System.out.println("给车子喷了"+color+"油漆");
        return this;
    }

    @Override
    ElectricCarBuilder addTransmission(String type) {
        System.out.println("添加了"+type+"发动机");
        return this;
    }

    @Override
    ElectricCarBuilder addGasTank(String type) {

        return  null;
    }

    @Override
    ElectricCarBuilder addBatteries(String type) {
        System.out.println("添加了"+type+"电池");
        return this;
    }

    @Override
    Car build() {
        return this.car;
    }
}

class GasolineCarBuilder extends CarBuilder2 {
    Car car;
    @Override
    CarBuilder2 buildCar() {
        this.car = new Car();
        return  this;
    }

    @Override
    CarBuilder2 addEngine(String type) {
        System.out.println("添加了"+type+"引擎");
        return this;
    }

    @Override
    CarBuilder2 addWheel(String type) {
        System.out.println("添加了"+type+"轮子");
        return this;
    }

    @Override
    CarBuilder2 paint(String color) {
        System.out.println("给车子喷了"+color+"油漆");
        return this;
    }

    @Override
    CarBuilder2 addTransmission(String type) {
        System.out.println("添加了"+type+"发动机");
        return this;
    }

    @Override
    CarBuilder2 addGasTank(String type) {
        System.out.println("添加了"+type+"油箱");
        return this;
    }

    @Override
    CarBuilder2 addBatteries(String type) {
        return null;
    }

    @Override
    Car build() {
        return this.car;
    }
}