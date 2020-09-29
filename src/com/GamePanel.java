package com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class GamePanel extends JPanel implements MouseMotionListener {

    //飞机
    private Plane plane = new Plane(200, 520);
    //爆炸飞机
    private PlaneDestory planeDestory;
    //子弹
    private ArrayList<Bullet> bullets = new ArrayList<>();

    //敌机
    private ArrayList<Enemy> enemies = new ArrayList<>();

    //背景（2个对象）
    private ArrayList<Background> backgrounds = new ArrayList<>();

    //爆炸敌机
    private ArrayList<Bomb> bombs = new ArrayList<>();

    //记录总分数
    private int score = 0;
    //记录每个敌机的分书
    private final int MIN_SCORE = 10;
    //初始化面板
    public void init(){
        //初始化背景
        backgrounds.add(new Background(0, 0));
        //初始化飞机
        long count = 0;//控制子弹添加的时间
        while (true){
            count ++;

            //添加另一张背景图
            if (backgrounds.size() == 1)
                backgrounds.add(new Background(0, -700));
            //控制背景图片
            for (int i = 0; i < backgrounds.size(); i ++){
                Background bg = backgrounds.get(i);
                if (bg != null){
                    bg.move();//每一次向下移动1像素
                    if (bg.getY() > 700){
                        backgrounds.remove(bg);
                    }
                }
            }

            //初始化子弹
            if (count % 15 == 0){//子弹之间的间隔，每隔15次画一次子弹
                bullets.add(new Bullet(plane.getX() + 45, plane.getY() - 15));
            }
            //控制子弹个数，删除，移动等
            for (int i = 0; i < bullets.size(); i ++){
                Bullet bullet = bullets.get(i);
                if (bullet != null){
                    bullet.move();
                    if (bullet.getY() < -15){//子弹已经飞出去了
                        bullets.remove(bullet);
                    }
                }
            }
            //初始化敌机
            if (count % 80 == 0){
                //随机计算敌机出现的x位置
                //x的位置需要在整个窗口的范围内
                int tempEnemyX = (int)(Math.random() * 430);
                //初始化敌机对象
                enemies.add(new Enemy(tempEnemyX, -30));
            }
            //控制敌机个数
            for (int i = 0; i < enemies.size(); i ++){
                Enemy enemy = enemies.get(i);
                if (enemy != null){
                    if (enemy.getY() > 700){
                        enemies.remove(enemy);
                    }
                    //当敌机和子弹发生碰撞
                    for (int j = 0; j < bullets.size(); j ++){
                        //循环每一颗子弹，与当前敌机比较，看是哪颗子弹发生了碰撞
                        Bullet bullet = bullets.get(j);
                        if (bullet != null){
                            if (this.isHit(enemy, bullet)){//发生碰撞了
                                enemies.remove(enemy);
                                bullets.remove(bullet);

                                //出现击中效果
                                System.out.println("击中敌机----");
                                score += MIN_SCORE;    //分数加分
                                bombs.add(new Bomb(enemy.getX(), enemy.getY(), 0));
                            }
                        }
                    }

                    //当敌机与英雄碰撞
                    if (this.isHit(plane, enemy)){
                        System.out.println("我放飞机坠毁.....");
                        planeDestory = new PlaneDestory(plane.getX(), plane.getY());
                        plane = null;
                        bombs.add(new Bomb(enemy.getX(), enemy.getY(), 0));
                        enemies.remove(enemy);//去掉敌机
                        repaint();
                        JOptionPane.showMessageDialog(this, "游戏结束， 您的得分为" + score);
                        return;
                    }
                    enemy.move();
                }
            }

            //控制爆炸图片存储的时间
            for (int i = 0; i < bombs.size(); i ++){
                Bomb bomb = bombs.get(i);
                if (bomb != null){
                    bomb.setTime(bomb.getTime() + 1);
                    if (bomb.getTime() >= 15){
                        bombs.remove(bomb);
                    }
                }
            }
            repaint();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
    //展示飞机
    public void paint(Graphics g){//重写方法
        super.paint(g);

        //画背景
        for (int i = 0; i < backgrounds.size(); i ++){
            Background background = backgrounds.get(i);
            g.drawImage(background.getBackgroundIcon().getImage(), background.getX(), background.getY(), null);
        }
        //画飞机
        if (plane != null){
            Image image = plane.getPlaneImage().getImage();
            g.drawImage(image, plane.getX(), plane.getY(), null);
        }

        //画飞机爆炸
        if (planeDestory != null){
            g.drawImage(planeDestory.getPlaneDestoryIcon().getImage(), planeDestory.getX(), planeDestory.getY(), null);
        }

        //画子弹
        for (int i = 0; i < bullets.size(); i ++){
            Bullet bullet = bullets.get(i);
            if (bullet != null){
                g.drawImage(bullet.getBulletIcon().getImage(), bullet.getX(), bullet.getY(), null);
            }
        }

        //画敌机
        for (int i = 0; i < enemies.size(); i ++){
            Enemy enemy = enemies.get(i);
            if (enemy != null){
                g.drawImage(enemy.getEnemyIcon().getImage(), enemy.getX(), enemy.getY(), null);
            }
        }

        //画敌机爆炸
        for (int i = 0; i < bombs.size(); i++) {
            Bomb bomb = bombs.get(i);
            if (bomb != null){
                g.drawImage(bomb.getBackgroundIcon().getImage(), bomb.getX(), bomb.getY(), null);
            }
        }

        //设置分数显示位置
        g.setFont(new Font("宋体", Font.BOLD, 24));
        g.drawString("得分：" + score, 350, 30);
    }

    //计算敌机和子弹是否发生碰撞
    private boolean isHit(Enemy e, Bullet b){
        Rectangle enemy = new Rectangle(e.getX(), e.getY(), e.getWidth(), e.getHeight());
        Rectangle bullet = new Rectangle(b.getX(), b.getY(), b.getWidth(), b.getHeight());

        return enemy.intersects(bullet);
    }

    //计算敌机和子弹是否发生碰撞
    private boolean isHit(Plane p, Enemy e){
        Rectangle plane = new Rectangle(p.getX(), p.getY(), p.getWidth(), p.getHeight());
        Rectangle enemy = new Rectangle(e.getX(), e.getY(), e.getWidth(), e.getHeight());

        return plane.intersects(enemy);
    }
    //===================
    //计算飞机的位置
    /**
     * @param e 获取鼠标的位置
     */
    private void calculatePosition(MouseEvent e){
        //拖拽，根据鼠标的位置移动飞机的位置
        int tempX = e.getX();
        int tempY = e.getY();
        System.out.println(tempX + "--" + tempY);
        if (plane != null){
            if (tempX > 10 && tempX < 486)
                plane.setX(tempX - 60);
            if (tempY > 150 && tempY < 650)
                plane.setY(tempY - 100);
        }
        repaint();
    }
    @Override
    public void mouseDragged(MouseEvent e) {
        this.calculatePosition(e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        this.calculatePosition(e);
    }


}
