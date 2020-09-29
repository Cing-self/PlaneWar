package com;

import javax.swing.*;

public interface BaseFrame {

    //设置窗体标题
    public void setTitle(String title);

    public void setElements();
    //将面板添加到窗体中
    public void addElements();

    //将绑定了监听器的对象添加在窗体中
    public void addListener();

    //设计窗体属性
    public void setFrameSelf();
}
