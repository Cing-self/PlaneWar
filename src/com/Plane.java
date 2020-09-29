package com;

import javax.swing.*;

/**
 * 飞机类
 */
public class Plane {

    //图片（路径）起始坐标x，y，宽度、高度
    private int x;
    private int y;
    private int width;
    private int height;
    private ImageIcon planeImage = new ImageIcon("image/hero.png");

    //初始化飞机
    public Plane(int x, int y){
        this.x = x;
        this.y = y;
        this.width = planeImage.getIconWidth();
        this.height = planeImage.getIconHeight();
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

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public ImageIcon getPlaneImage() {
        return planeImage;
    }

    public void setPlaneImage(ImageIcon planeImage) {
        this.planeImage = planeImage;
    }
}
