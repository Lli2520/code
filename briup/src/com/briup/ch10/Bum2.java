package com.briup.ch10;

import java.lang.String;

/**
 * @Author briup-adam
 * @Date 2023/10/27 上午10:42
 * @Description
 **/

public class Bum2 {
    int num;
    //flag  三个状态  -1 0 1
    int flag = -1;
}

class Producer2 extends Thread {
    private Bum2 bum;

    Producer2(String name, Bum2 bum) {
        super(name);
        this.bum = bum;
    }

    @Override
    public void run() {
        for (int i = 1; i < 101; i++) {
            synchronized (bum) {
                while (bum.flag != -1) {
                    try {
                        bum.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                // 生产包子
                System.out.println("第" + i + "次，" + this.getName() + ": 开始生产包子...");
                // 每次生产2个包子
                bum.num += 2;
                System.out.println("生产完成，包子数量: " + bum.num + "，快来吃!");
                bum.flag = 0;
                bum.notifyAll();
                try {
                    bum.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }

        }
    }
}

class Customer2 extends Thread {
    private Bum2 bum;

    Customer2(String name, Bum2 bum) {
        super(name);
        this.bum = bum;
    }

    @Override
    public void run() {
        for (int i = 1; i < 101; i++) {
            synchronized (bum) {
                while (bum.flag != 0) {
                    try {
                        bum.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(this.getName() + " 开始吃包子");
                bum.num--;
                System.out.println("消费完成，包子剩余数量: " + bum.num);
                bum.flag = 1;
                bum.notifyAll();
                try {
                    bum.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class Customer3 extends Thread {
    private Bum2 bum;

    Customer3(String name, Bum2 bum) {
        super(name);
        this.bum = bum;
    }

    @Override
    public void run() {
        for (int i = 1; i < 101; i++) {
            synchronized (bum) {
                while (bum.flag != 1) {
                    try {
                        bum.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println(this.getName() + " 开始吃包子");
                bum.num--;
                System.out.println("消费完成，包子剩余数量: " + bum.num);
                bum.flag = -1;
                bum.notifyAll();
                try {
                    if (i != 100)
                        bum.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class MoreCommunication {
    public static void main(String[] args) {
        Bum2 bum = new Bum2();
        Producer2 producer = new Producer2("狗不理", bum);
        Customer2 cust = new Customer2("闫昊", bum);
        Customer3 cust1 = new Customer3("杨硕", bum);
        producer.start();
        cust.start();
        cust1.start();
    }
}
