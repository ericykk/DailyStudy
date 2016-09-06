package com.dooioo.study.memory;

/**
 * description:多线程可见性和有序性实例
 * 每次执行的结果不确定，线程的执行顺序是不可预见的
 * author:yangkang
 * Date:16/5/23
 * Time:17:11
 * version 1.0.0
 */
public class AccountNoSync {


    private int balance;

    public AccountNoSync(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    //存钱
    public void add(int num) {
        balance = balance + num;
    }

    //取钱
    public void withdrawal(int num) {
        balance = balance - num;
    }


    static class AddThread implements Runnable {

        AccountNoSync account;
        int     amount;

        public AddThread(AccountNoSync account, int amount) {
            this.account = account;
            this.amount = amount;
        }

        public void run() {
            for (int i = 0; i < 100000; i++) {
                account.add(amount);
            }
        }

    }

    static class WithdrawalThread implements Runnable {
        AccountNoSync account;
        int     amount;

        public WithdrawalThread(AccountNoSync account, int amount) {
            this.account = account;
            this.amount = amount;
        }

        public void run() {
            for (int i = 0; i < 100000; i++) {
                account.withdrawal(amount);
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        AccountNoSync account = new AccountNoSync(1000);
        Thread a = new Thread(new AddThread(account, 20), "add");
        Thread b = new Thread(new WithdrawalThread(account, 20), "withdrawal");
        a.start();
        b.start();
        a.join();
        b.join();
        System.out.println(account.getBalance());
    }

}
