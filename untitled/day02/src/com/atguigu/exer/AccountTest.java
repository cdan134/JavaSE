package com.atguigu.exer;

/**
 * @author ChenDan
 * @create 2021-04-09
 * @desc 一个银行账户，两个人往里面存钱，3次/人，1000/次
 */

class Account {
    static public float balance;

    public Account(float balance) {
        this.balance = balance;
    }

    public synchronized void deposit(float amt) {
        if (amt > 0) {
            this.balance += amt;
            System.out.println(Thread.currentThread().getName() + " : " + this.balance);
        }
    }
}

class Customer implements Runnable {
    Account acc;

    public Customer(Account acc) {
        this.acc = acc;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            acc.deposit(1000);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class AccountTest {
    public static void main(String[] args) {
        Account a1 = new Account(100);
        Customer cus1 = new Customer(a1);
        Customer cus2 = new Customer(a1);
        Customer cus3 = new Customer(a1);

        Thread t1 = new Thread(cus1);
        Thread t2 = new Thread(cus2);
        Thread t3 = new Thread(cus3);

        t1.setName("甲");
        t2.setName("乙");
        t3.setName("丙");

        t1.start();
        t2.start();
        t3.start();
    }
}