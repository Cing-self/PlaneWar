package com;

import javax.swing.*;

public class Background {

    //图片（路径）起始坐标x，y，宽度、高度
    private int x;
    private int y;
    private ImageIcon backgroundIcon = new ImageIcon("image/bg.jpg");

    //构造方法
    public Background(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public ImageIcon getBackgroundIcon() {
        return backgroundIcon;
    }

    public void move(){
        System.out.println("背景：" + x + "--" + y);
        this.y += 1;//背景移动速度
    }
}
