package com.设计模式及实践.第三章__行为型模式.观察者模式;




import java.util.ArrayList;
import java.util.List;


abstract class Observer {
    public Observer(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }
    protected Subject subject;
    public abstract void update();
}

public class Subject {

    private List<Observer> observers
            = new ArrayList<Observer>();
    public int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    public void attach(Observer observer){
        observers.add(observer);
    }

    public void notifyAllObservers(){
        for (Observer observer : observers) {
            observer.update();
        }
    }
}

 class BinaryObserver extends Observer{


     public BinaryObserver(Subject subject) {
         super(subject);
     }

     @Override
    public void update() {
        System.out.println( "Binary String: "
                + Integer.toBinaryString( subject.getState() ) );
    }
}

class HashObserver extends Observer{


    public HashObserver(Subject subject) {
        super(subject);
    }

    @Override
    public void update() {
        int state = subject.state;
        System.out.println("Hash Code: "
        + state);
    }
}

 class ObserverPatternDemo {
    public static void main(String[] args) {
        Subject subject = new Subject();


        new BinaryObserver(subject);
        new HashObserver(subject);
        System.out.println("First state change: 15");
        subject.setState(15);
        System.out.println("Second state change: 10");
        subject.setState(10);
    }
}