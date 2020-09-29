package com;

import javax.swing.*;

public class Bullet {

    //图片（路径）起始坐标x，y，宽度、高度
    private int x;
    private int y;
    private int width;
    private int height;
    private ImageIcon bulletIcon = new ImageIcon("image/bullet.png");

    //构建bullet
    public Bullet(int x, int y){
        this.x = x;
        this.y = y;
        this.width = bulletIcon.getIconWidth();
        this.height = bulletIcon.getIconHeight();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public ImageIcon getBulletIcon() {
        return bulletIcon;
    }

    //让子弹飞
    public void move(){
        System.out.println("子弹：" + x + "--" + y);
        this.y -= 4;//子弹飞行速度
    }
}
