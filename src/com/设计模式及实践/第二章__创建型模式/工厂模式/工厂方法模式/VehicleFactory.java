package com.设计模式及实践.第二章__创建型模式.工厂模式.工厂方法模式;


class main {
    public static void main(String[] args) {
        VehicleFactory carFactory = new CarFactory();
        Vehicle vehicle = carFactory.orderVehicle("large", "blue");
        System.out.println(vehicle.color);

        TruckFactory truckFactory = new TruckFactory();
        truckFactory.orderVehicle("large","blue");
    }
}

// 抽象工厂
public  abstract class VehicleFactory {
    protected  abstract Vehicle createVehicle(String size);

    public Vehicle orderVehicle(String size, String color) {
      Vehicle vehicle = createVehicle(size);
      vehicle.testVehicle();
        vehicle.setColor(color);
        return vehicle;
    }
}

// 实体工厂
class CarFactory extends VehicleFactory{

    @Override
    protected Vehicle createVehicle(String size) {
        if(size.equals("small")){
            return new SportCar();
        }else if(size.equals("large"))
            return new SedanCar();
        return null;
    }
}

//卡车实体工厂
class TruckFactory extends VehicleFactory{

    @Override
    protected Vehicle createVehicle(String size) {
        if(size.equals("small")) return new SmallTruck();
        else if(size.equals("large")) return new LargeTruck();
        return  null;
    }
}


//
class Vehicle{
    public String color;
    public void testVehicle() {
        System.out.println("测试中");
    }

    public void setColor(String color) {
        this.color = color;
    }
}

class SmallTruck extends  Vehicle{

}


class LargeTruck extends  Vehicle{

}

class SportCar extends  Vehicle{

    // 重写方法
    @Override
    public void testVehicle() {
        super.testVehicle();
    }
}

class SedanCar extends  Vehicle{
    // 重写方法
    @Override
    public void setColor(String color) {
        super.setColor(color);
    }
}