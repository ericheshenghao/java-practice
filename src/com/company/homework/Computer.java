package com.company.homework;


public class Computer {

    private InsertDrawable equipment;

    public Computer(InsertDrawable equipment) {
        this.equipment = equipment;
    }

    public InsertDrawable getEquipment() {

        return equipment;
    }

    public void setEquipment(InsertDrawable equipment) {
        this.equipment = equipment;

    }

    public void insert() {
        InsertDrawable eq = this.equipment;
        eq.insert();
    }
}
