package com.cpystu.tankgame2;

public class Tank {
    private int direct;//坦克的方向
    private int speed;//设置变量控制坦克速度
    private int x;

    public int getDirect() {
        return direct;
    }

    public void setDirect(int direct) {
        this.direct = direct;
    }

    private int y;

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }
    //封装方法实现坦克上下左右的移动
    public void moveUp(){
        y-=speed;
    }
    public void moveRight(){
        x+=speed;
    }
    public void moveDown(){
        y+=speed;
    }
    public void moveLeft(){
        x-=speed;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
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
}
