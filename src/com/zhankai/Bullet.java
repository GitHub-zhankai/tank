package com.zhankai;

import com.zhankai.enums.DirectionEnum;

import java.awt.*;

/**
 * @author: wang zhan kai
 * @create time: 2020/3/5
 * @Email: zhankai.wang@ambow.com
 * @description:
 */
public class Bullet {
    //子弹飞行的速度
    private static final int SPEED = 10;
    //子弹大小
    private static int WIDTH = 10, HIGHT = 10;

    private int x,y;
    private DirectionEnum dir;

    public Bullet(int x, int y, DirectionEnum dir) {
        super();
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public void paint(Graphics g) {
        System.out.println("bullet - paint");
        Color color = g.getColor();
        g.setColor(Color.RED);
        //初始化子弹大小和位置
        g.fillOval(x,y,WIDTH,HIGHT);
        //改变方向
        fly();
    }

    private void fly() {
        switch(dir){
            case LEFT: x -= SPEED; break;
            case RIGHT: x += SPEED; break;
            case UP: y -= SPEED; break;
            case DOWN: y += SPEED; break;
            default: break;
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public DirectionEnum getDir() {
        return dir;
    }

    public void setDir(DirectionEnum dir) {
        this.dir = dir;
    }
}
