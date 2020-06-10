package com.company.chapter20.线程安全.Account1;

public class Account1 {
    private String actno;
    private double balance;

    Object object = new Object();

    @Override
    public String toString() {
        return "Account{" +
                "actno='" + actno + '\'' +
                ", balance=" + balance +
                '}';
    }

    public Account1(String actno, double balance) {
        this.actno = actno;
        this.balance = balance;
    }

    public Account1() {
    }

    public String getActno() {
        return actno;
    }

    public void setActno(String actno) {
        this.actno = actno;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


    /*
     在实例方法上使用synchronized
     synchronized出现在实例方法上锁的只能是this 不灵活
     另外，表示整个方法体需要同步，可能会无辜扩大同步的范围
     导致程序的执行效率降低

     优点：
        代码写的少 节约
        如果共享的对象就是this，建议使用这种方式

      如果使用局部变量的话：
      建议使用 stringbuilder
      因为局部变量不存在线程安全问题，

      arraylist是非线程安全的
      vector是安全的
      hashamp hashset 是非线程安全的
      hashtable是线程安全的

     */
    public synchronized void withdraw(double money) {
     /*
       必须是线程排队的，不能并发
      传的参数非常关键
      （）中要看哪些线程同步
       假设t1,t2,t3,t4,t5，
        你只希望某些排队，某些不排队
       你一定要在（）写一个t1,t2,t3共享的对象
       这里的共享对象是账户对象
       this就是账户对象

      */

//        synchronized (object){
        double before = this.getBalance();

        double after = before - money;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.setBalance(after);
//        }

    }
}
