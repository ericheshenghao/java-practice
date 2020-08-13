package com.company.chapter18;

class main {
    public static void main(String[] args) {
        Test08 test08 = new Test08(new serviceImpl());
        test08.Do();
    }
}

public class Test08{
    service service;
    Test08(service service){
        this.service =service;
    }

   void Do(){
        service.dosome();
   }
}

 interface service{

    public void dosome();
}

class serviceImpl implements service{
    @Override
    public void dosome() {
        System.out.println("im doing");
    }
}