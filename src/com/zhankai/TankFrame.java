package com.zhankai;

import com.zhankai.enums.DirectionEnum;

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

    //游戏界面
    private static final int GAME_WIDTH = 700, GAME_HIGHT = 900;

    Tank mainTank = new Tank(200, 300, DirectionEnum.DOWN, this);
    Bullet bullet = new Bullet(200, 300, DirectionEnum.DOWN);

    public TankFrame(){
        setSize(GAME_WIDTH,GAME_HIGHT);
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

    //为了解决双缓冲
    Image image = null;
    @Override
    public void update(Graphics g) {
        if(image == null){
            image = this.createImage(GAME_WIDTH,GAME_HIGHT);
        }
        Graphics goffScreen = image.getGraphics();
        Color color = goffScreen.getColor();
        goffScreen.setColor(Color.WHITE);
        goffScreen.fillRect(0,0,GAME_WIDTH,GAME_HIGHT);
        goffScreen.setColor(color);
        paint(goffScreen);
        g.drawImage(image,0,0,null);
    }

    @Override
    public void paint(Graphics g) {
        mainTank.paint(g);
        bullet.paint(g);
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
            setMainTankDir();
        }

        @Override
        public void keyReleased(KeyEvent e) {
            System.out.println("keyReleased");
            int key = e.getKeyCode();
            switch (key){
                case KeyEvent.VK_LEFT:  left = false;    //左
                    break;
                case KeyEvent.VK_RIGHT: right = false;   //右
                    break;
                case KeyEvent.VK_UP:    up = false;    //上
                    break;
                case KeyEvent.VK_DOWN:  down = false;   //下
                    break;
                case KeyEvent.VK_CONTROL:  mainTank.fire();
                    break;
                default: break;
            }
            //刷新坦克方向
             setMainTankDir();
        }

        private void setMainTankDir() {
            if(!left && !right && !up && !down){
                mainTank.setMove(false);
            }else {
                mainTank.setMove(true);
                if(left) mainTank.setDir(DirectionEnum.LEFT);
                if(right) mainTank.setDir(DirectionEnum.RIGHT);
                if(up) mainTank.setDir(DirectionEnum.UP);
                if(down) mainTank.setDir(DirectionEnum.DOWN);
            }
        }

    }
}

