package com.zhankai;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author: wang zhan kai
 * @create time: 2020/3/5
 * @Email: zhankai.wang@ambow.com
 * @description:
 */
public class TankFrame extends Frame {

    //距左边距
    int x = 200;
    //距上边距
    int y = 300;

    public TankFrame(){
        setSize(800,600);
        //是否窗口可调节
        setResizable(false);
        //设置标题名称
        setTitle("tank war");
        //是否显示
        setVisible(true);

        //窗口关闭事件
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
//                super.windowClosing(e);
                System.exit(0);
            }
        });

        //添加键盘监听事件
        this.addKeyListener(new MyKeyListener());
    }

    @Override
    public void paint(Graphics g) {
        System.out.println("paint");
        g.fillRect(x,y,50,50);
        x += 10;

    }

    //重写键盘监听处理对象
    class MyKeyListener extends KeyAdapter{

        boolean left = false;
        boolean right = false;
        boolean up = false;
        boolean down = false;

        @Override
        public void keyPressed(KeyEvent e) {
            System.out.println("keyPressed");
            int key = e.getKeyCode();
            switch (key){
                case KeyEvent.VK_LEFT:  left = true;    //左
                    break;
                case KeyEvent.VK_RIGHT: right = true;   //右
                    break;
                case KeyEvent.VK_UP:    up = true;    //上
                    break;
                case KeyEvent.VK_DOWN:  down = true;   //下
                    break;
                default: break;
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            System.out.println("keyReleased");
//            super.keyReleased(e);
        }
    }
}

