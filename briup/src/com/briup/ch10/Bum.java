package com.briup.ch10;

import java.lang.String;

/**
 * @Author briup-adam
 * @Date 2023/10/27 上午10:19
 * @Description
 **/

public class Bum {
    //包子存在标识
    boolean flag = false;
    //包子数量
    int num = 0;
}

//生产者
class Producer extends Thread {
    private Bum bum;

    Producer(String name, Bum bum) {
        super(name);
        this.bum = bum;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            synchronized (bum) {
                if (bum.flag) {
                    try {
                        bum.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("第" + i + "次，" + this.getName() + ": 开始生产包子...");
                bum.num++;
                System.out.println("生产完成，包子数量: " + bum.num + "，快来吃!");
                //生产完成，修改flag存在标识为true
                bum.flag = true;
                //通知 消费者线程吃包子
                bum.notify();
            }

        }
    }
}

class Customer extends Thread {
    private Bum bum;

    Customer(String name, Bum bum) {
        super(name);
        this.bum = bum;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            synchronized (bum) {
                if (!bum.flag) {
                    try {
                        bum.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("第" + i + "次，" + this.getName() + " 开始吃包子...");
                bum.num--;
                System.out.println("消费完成，包子数量: " + bum.num + "，快生产吧!");
                bum.flag = false;
                //唤醒生产者线程
                bum.notify();
            }

        }
    }
}

class TwoCommunication {
    public static void main(String[] args) {
        Bum bum = new Bum();
        Producer producer = new Producer("狗不理", bum);
        Customer customer = new Customer("闫昊", bum);
//        Customer customer1 = new Customer("杨硕", bum);
        producer.start();
        customer.start();
//        customer1.start();
    }
}