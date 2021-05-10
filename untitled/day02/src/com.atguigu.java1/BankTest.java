package com.atguigu.java1;

/**
 * @author ChenDan
 * @create 2021-04-11
 * @desc 单例模式，有一个问题，怎么判断创建的函数唯一？？
 */
public class BankTest {
    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            Bank b1 = Bank.getInstance();
            System.out.println(b1.toString());
        }
    }
}

class Bank {
    private Bank() {
    }

    private static Bank instance = null;

    public static Bank getInstance() {
        if (instance == null) {
            synchronized (Bank.class) {
                instance = new Bank();
            }
        }
        return instance;
    }
}

