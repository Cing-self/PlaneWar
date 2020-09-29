package com;

import javax.swing.*;

public class Bomb {

    //图片（路径）起始坐标x，y，宽度、高度
    private int x;
    private int y;
    private ImageIcon backgroundIcon = new ImageIcon("image/bomb.png");
    //time：控制爆炸图片在屏幕上停留的时间
    private int time;

    public Bomb(int x, int y, int time) {
        this.x = x;
        this.y = y;
        this.time = time;
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

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
