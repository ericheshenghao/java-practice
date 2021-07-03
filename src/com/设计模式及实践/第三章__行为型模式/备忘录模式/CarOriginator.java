package com.设计模式及实践.第三章__行为型模式.备忘录模式;

public class CarOriginator {

    private String state;

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public Memento saveState(){
        return  new Memento(this.state);
    }
    public void restoreState(Memento memento){
        this.state = memento.getState();
    }

    public static class Memento{
        private final String state;

        public Memento(String state) {
            this.state = state;
        }

        public String getState() {
            return state;
        }
    }
}

class CarCaretaker{
    public static void main(String[] args) {
        new CarCaretaker().runMechanicTest();
    }
    
    public void runMechanicTest(){
        CarOriginator.Memento savedState;
        CarOriginator originator = new CarOriginator();
        originator.setState("State1");
        originator.setState("State2");
        savedState = originator.saveState();
        originator.setState("State3");
        CarOriginator.Memento savedState1 = originator.saveState();
        
        System.out.println(savedState==savedState1);

//
        originator.restoreState(savedState1);
//        originator.restoreState(savedState);
        System.out.println("final state:"+originator.getState());
        

    }
}