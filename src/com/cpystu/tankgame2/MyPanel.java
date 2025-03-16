package com.cpystu.tankgame2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * 我的面板
 *
 * @author cuipeiyao
 * @date 2025/03/11
 */
//为了通过WADS改变坦克的方向，使用KeyListener监听器监听键盘事件
public class MyPanel extends JPanel implements KeyListener {
    //定义一个坦克
    Hero hero = null;

    public MyPanel() {
        hero = new Hero(100, 100);//初始化
    }
    //调用paint方法绘图

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750);//填充矩形，默认黑色
        //画坦克-封装到方法里面
        drawTank(hero.getX(), hero.getY(), g, hero.getDirect(), 1);
        //drawTank(hero.getX(),hero.getY(),g,0,0);
    }

    /**
     * 提取
     *
     * @param x      x 坦克的左上角横坐标
     * @param y      y 纵坐标
     * @param g      g 画笔
     * @param direct 方向
     * @param type   类型 （敌我）
     *///编写方法 画出坦克
    /*
     * */
    public void drawTank(int x, int y, Graphics g, int direct, int type) {
        //根据不同类型的坦克，设置不同的颜色
        switch (type) {
            case 0://我方坦克
                g.setColor(Color.cyan);
                break;
            case 1://敌方坦克
                g.setColor(Color.yellow);
                break;
        }
        //根据坦克的方向，绘制对应形状的坦克
        //direct表示方向（0上 1右 2下 3 左）
        switch (direct) {
            case 0://向上
                g.fill3DRect(x, y, 10, 60, false);//坦克左轮
                g.fill3DRect(x + 30, y, 10, 60, false);//坦克右轮
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//坦克盖子
                g.fillOval(x + 10, y + 20, 20, 20);//圆盖
                g.drawLine(x + 20, y + 30, x + 20, y);//炮筒
                break;
            case 1://向右
                g.fill3DRect(x, y, 60, 10, false);//坦克上面轮
                g.fill3DRect(x, y + 30, 60, 10, false);//坦克右轮
                g.fill3DRect(x + 10, y + 10, 40, 20, false);//坦克盖子
                g.fillOval(x + 20, y + 10, 20, 20);//圆盖
                g.drawLine(x + 30, y + 20, x + 60, y + 20);//炮筒
                break;
            case 2://向下
                g.fill3DRect(x, y, 10, 60, false);//坦克左轮
                g.fill3DRect(x + 30, y, 10, 60, false);//坦克右轮
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//坦克盖子
                g.fillOval(x + 10, y + 20, 20, 20);//圆盖
                g.drawLine(x + 20, y + 30, x + 20, y + 60);//炮筒
                break;
            case 3://向左
                g.fill3DRect(x, y, 60, 10, false);//坦克上面轮
                g.fill3DRect(x, y + 30, 60, 10, false);//坦克右轮
                g.fill3DRect(x + 10, y + 10, 40, 20, false);//坦克盖子
                g.fillOval(x + 20, y + 10, 20, 20);//圆盖
                g.drawLine(x + 30, y + 20, x, y + 20);//炮筒
                break;

            default:
                System.out.println("暂时没有处理");
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {//e是对象名 通过它来调用方法
        if (e.getKeyCode() == KeyEvent.VK_W) {
            hero.setDirect(0);//按下W键 坦克向上
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            hero.setDirect(1);
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            hero.setDirect(2);
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            hero.setDirect(3);
        }
        //让面板重绘
        this.repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}


