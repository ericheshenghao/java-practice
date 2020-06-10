package com.company.chapter20.线程安全.Account1;


public class AccoutThread extends Thread {
    // 两个线程共享同一个账号
    private Account1 act;

    public AccoutThread(Account1 act) {
        this.act = act;
    }

    @Override
    public void run() {
        // run 方法的执行
        // 取款5000
        double money = 5000;
        act.withdraw(money);
        System.out.println(Thread.currentThread().getName() + "账户取款成功" + act.getBalance());
    }
}
