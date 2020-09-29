package com;

import javax.swing.*;

/**
 * 敌机类
 */
public class Enemy {

    //图片（路径）起始坐标x，y，宽度、高度
    private int x;
    private int y;
    private int width;
    private int height;
    private ImageIcon enemyIcon = new ImageIcon("image/enemy.png");

    //构建enemy
    public Enemy(int x, int y){
        this.x = x;
        this.y = y;
        this.width = enemyIcon.getIconWidth();
        this.height = enemyIcon.getIconHeight();
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

    public ImageIcon getEnemyIcon() {
        return enemyIcon;
    }

    //让敌机移动
    public void move(){
        System.out.println("敌机：" + x + "--" + y);
        this.y += 3;//敌机的速度
    }
}
