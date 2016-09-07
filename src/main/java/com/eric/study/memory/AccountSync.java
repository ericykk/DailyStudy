package com.eric.study.memory;

/**
 * description:多线程可见性和有序性实例
 * synchronized关键字保证了多个线程对于同步块是互斥的，synchronized作为一种同步手段，解决java多线程的执行有序性和内存可见性
 * author:yangkang
 * Date:16/5/23
 * Time:17:25
 * version 1.0.0
 */
public class AccountSync {


    private int balance;

    public AccountSync(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    //存钱
    public synchronized void add(int num) {
        balance = balance + num;
    }

    //取钱
    public synchronized void withdrawal(int num) {
        balance = balance - num;
    }


    static class AddThread implements Runnable {
        AccountSync account;
        int     amount;

        public AddThread(AccountSync account, int amount) {
            this.account = account;
            this.amount = amount;
        }

        public void run() {
            //模拟多线程并发调用
            for (int i = 0; i < 100000; i++) {
                account.add(amount);
            }
        }
    }

    static class WithdrawalThread implements Runnable {
        AccountSync account;
        int     amount;

        public WithdrawalThread(AccountSync account, int amount) {
            this.account = account;
            this.amount = amount;
        }

        public void run() {
            //模拟多线程并发调用
            for (int i = 0; i < 100000; i++) {
                account.withdrawal(amount);
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        AccountSync account = new AccountSync(1000);
        Thread a = new Thread(new AddThread(account, 20), "add");
        Thread b = new Thread(new WithdrawalThread(account, 20), "withdrawal");
        a.start();
        b.start();
        a.join();
        b.join();
        System.out.println(account.getBalance());
    }
}
