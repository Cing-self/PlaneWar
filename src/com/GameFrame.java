package com;

import javax.swing.*;

public class GameFrame extends JFrame implements Runnable, BaseFrame{

    //窗体内的面板
    private GamePanel panel = new GamePanel();

    public GameFrame(){
        addElements();
        addListener();
        setFrameSelf();
    }

    //带标题的构造方法
    public GameFrame(String title){
        setTitle(title);
        addElements();
        addListener();
        setFrameSelf();
    }

    //设置窗体标题
    public void setTitle(String title){
        super.setTitle(title);
    }

    @Override
    public void setElements() {

    }

    //将面板添加到窗体中
    public void addElements(){
        this.add(panel);
    }

    //将绑定了监听器的对象添加在窗体中
    public void addListener(){
        this.addMouseMotionListener(panel);
    }

    //设计窗体属性
    public void setFrameSelf(){
        this.setBounds(300, 100, 480, 700);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }


    @Override
    public void run() {
        panel.init();
    }
}
