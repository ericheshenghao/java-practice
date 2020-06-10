package com.company.chapter20.线程安全;

public class Account {
    private String actno;
    private double balance;

    @Override
    public String toString() {
        return "Account{" +
                "actno='" + actno + '\'' +
                ", balance=" + balance +
                '}';
    }

    public Account(String actno, double balance) {
        this.actno = actno;
        this.balance = balance;
    }

    public Account() {
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

    //取款方法
    public void withdraw(double money) {
        // t1和t2并发方法 两个栈
        // 取款之前的余额
        double before = this.getBalance();

        //取款之后
        double after = before - money;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 更新余额
        this.setBalance(after);
    }
}
