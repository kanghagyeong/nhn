package com.nhnacademy;

import java.awt.Color;

public class MovableBox extends PaintableBox implements Movable {
    public static final int DEFAULT_DX = 0;
    public static final int DEFAULT_DY = 0;
    
    final Vector motion = new Vector();
    int dx = 0;
    int dy = 0;
    
    public MovableBox(int x, int y, int width, int height, Color color) {
        super(x, y, width, height, color);
        
    }

    public int getDX() {
        return motion.getDX();
    }

    public int getDY() {
        return motion.getDY();
    }

    public void setDX(int dx) {
       // motion.setDX(dx); 
        motion.set(new Vector(dx,motion.getDY()));
    }

    public void setDY(int dy) {
        motion.setDY(dy);
    }

    public void move() { // point 만들어서 point에 vector를 더하는 것 ? 이 이해하기 쉬울것 ? 
        moveTo(getX() + getDX(), getY() + getDY());
        //logger.trace("{}, {}, {}, {}, {}",getId(), getX(), getY(), getRegion().getX(), getRegion().getY());
    }

    public void moveTo(int x, int y) {
        setX(x);
        setY(y);
    }
}
