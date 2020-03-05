package com.zhankai;

import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {
        // write your code here
        TankFrame tk = new TankFrame();
//        ExecutorService thread = Executors.newSingleThreadExecutor();   //后期改造使用线程池
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    tk.repaint();
                }
            }
        }).start();

    }
}
