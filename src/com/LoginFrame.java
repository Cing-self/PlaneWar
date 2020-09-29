package com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginFrame extends JFrame implements BaseFrame{

    private JLabel label = new JLabel();


    public LoginFrame(){
        setElements();
        addElements();
        addListener();
        setFrameSelf();
    }
    @Override
    public void setElements() {
        label.setBounds(0, 0, 480, 480);
        label.setIcon(new ImageIcon("image/login.jpg"));
        this.add(label);

    }

    @Override
    public void addElements() {
        this.add(label);
    }

    @Override
    public void addListener() {
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getX() >= 120 && e.getX() <= 355 && e.getY() >= 565 && e.getY() <= 630){
                    LoginFrame.this.setVisible(false);
                    new Thread(new GameFrame()).start();
                }
            }
        });

        label.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                if (e.getX() >= 120 && e.getX() <= 355 && e.getY() >= 565 && e.getY() <= 630){
                    label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                }else{
                    label.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                }
            }
        });
    }

    @Override
    public void setFrameSelf() {
        this.setBounds(300, 20, 480, 800);
        this.setVisible(true);
    }
}
