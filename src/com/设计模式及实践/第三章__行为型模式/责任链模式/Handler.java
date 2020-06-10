package com.设计模式及实践.第三章__行为型模式.责任链模式;





class main {
    public static void main(String[] args) {
            new ConcreteHandler1().handleRequest("123");
    }
}



public abstract class Handler {
    protected Handler successor;
    public void setSuccessor(Handler successor){
        this.successor=successor;
    }
    public abstract void handleRequest(String request);
}


class  ConcreteHandler1 extends Handler{

    boolean canHandle(String request){
        // 假设处理不了，传给下一个处理器
        setSuccessor(new ConcreteHandler2());

        return false;
    }

    @Override
    public void handleRequest(String request) {
        if(canHandle(request)){

        }else{

           successor.handleRequest(request);
        }
    }
}

class  ConcreteHandler2 extends Handler{

    boolean canHandle(String request){
        return true;
    }

    @Override
    public void handleRequest(String request) {
        if(canHandle(request)){
            System.out.println("ConcreteHandler2处理成功");
        }else{

            successor.handleRequest(request);
        }
    }
}