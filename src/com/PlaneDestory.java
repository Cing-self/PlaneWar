package com;

import javax.swing.*;

public class PlaneDestory {

    //图片(路径) 起始坐标x 起始坐标y 宽度 高度
    private int x;
    private int y;
    private ImageIcon planeDestoryIcon = new ImageIcon("image/hero_destory.png");

    public PlaneDestory(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public ImageIcon getPlaneDestoryIcon() {
        return planeDestoryIcon;
    }
}
