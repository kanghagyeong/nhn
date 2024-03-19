package com.nhnacademy;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.List;
import java.util.LinkedList;

import javax.swing.JPanel;

public class World extends JPanel implements MouseListener, MouseMotionListener{
    List<Regionable> regionableList = new LinkedList<>();
    private int boxY;
    private int boxX;
    private int paddleX;
    static final int FRAME_WIDTH = 700;
    static final int PADDLE_WIDTH = 90;


    public World() {
        addMouseListener(this);
        addMouseMotionListener(this);
        paddleX = FRAME_WIDTH / 2 - PADDLE_WIDTH / 2;
    }

    public void movePaddle(int x) {
        paddleX = x;
        repaint(); 
    }
    /**
     *
     * @param object
     * @throw IllegalArgumentException 공간을 벗어나거나, null인 경우, 볼간 충돌된 경우
     */
    public void add(Regionable object) {
        if (object == null) {
            throw new IllegalArgumentException();
        }

        for (Regionable item : regionableList) {
            if (((object instanceof Bounded || (item instanceof Bounded))
                    && (object.getRegion().intersects(item.getRegion())))) {
                throw new IllegalArgumentException();
            }
        }

        regionableList.add(object);
    }


    public void remove(Regionable object) {
        regionableList.remove(object);
    }

    @Override
    public void remove(int index) {
        regionableList.remove(index);
    }

    public int getCount() {
        return regionableList.size();
    }

    public Regionable get(int index) {
        return regionableList.get(index);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        for (Regionable object : regionableList) {
            if (object instanceof Paintable) {
                ((Paintable) object).paint(g);
            }
        }

        g.setColor(Color.BLACK);
        g.fillRect(paddleX, FRAME_WIDTH - 50, PADDLE_WIDTH, 10);

        Rectangle paddleRect = new Rectangle(paddleX, FRAME_WIDTH - 50, PADDLE_WIDTH, 10); // 패들의 사각 영역
        for (Regionable object : regionableList) {
            if (object instanceof BoundedBall) {
                BoundedBall ball = (BoundedBall) object;
                if (paddleRect.intersects(ball.getRegion())) { 
                    ball.setDY(-ball.getDY());
                }
            }
        }
    }
    

    @Override
    public void mouseClicked(MouseEvent e) {
        //add(new PaintableBox(e.getX(), e.getY(), 50, 50));
    }

    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        int mouseX = e.getX();

        if (mouseX < 0) {

            movePaddle(0); 
        } else if (mouseX > FRAME_WIDTH - PADDLE_WIDTH) {

            movePaddle(FRAME_WIDTH - PADDLE_WIDTH); 
        } else {
            
            movePaddle(mouseX); 
        }
    }
}