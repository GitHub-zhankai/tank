package com.zhankai;

import com.zhankai.enums.DirectionEnum;

import java.awt.*;

/**
 * @author: wang zhan kai
 * @create time: 2020/3/5
 * @Email: zhankai.wang@ambow.com
 * @description:
 */
public class Tank {

    //距左边距
    private int x = 200;
    //距上边距
    private int y = 300;

    private DirectionEnum dir = DirectionEnum.DOWN;
    private static final int SPEED = 10;

    private boolean move = false;

    public Tank(int x, int y, DirectionEnum dir) {
        super();
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public void paint(Graphics g) {
        System.out.println("tank - paint");
        //初始化坦克大小和位置
        g.fillRect(x,y,50,50);
        //改变方向
        move();
    }

    private void move() {
        if(move) {
            switch(dir){
                case LEFT: x -= SPEED; break;
                case RIGHT: x += SPEED; break;
                case UP: y -= SPEED; break;
                case DOWN: y += SPEED; break;
                default: break;
            }
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

    public boolean isMove() {
        return move;
    }

    public void setMove(boolean move) {
        this.move = move;
    }
}
