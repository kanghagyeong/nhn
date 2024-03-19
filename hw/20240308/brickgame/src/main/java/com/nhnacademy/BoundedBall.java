package com.nhnacademy;

import java.awt.Color;
import java.awt.Rectangle;

public class BoundedBall extends MovableBall implements Bounded{
    
    public BoundedBall(int x, int y, int radius, Color color) {
        super(x, y, radius, color);

    }


    @Override
    public void move() {
        super.move();

    }

    //충돌하면 튕겨내기 
    public void bounce(Regionable other) {
        Rectangle intersection = getRegion().intersection(other.getRegion());

        if (getRegion().getWidth() != intersection.getWidth()) {
            setDX(-getDX());
        }
        if (getRegion().getHeight() != intersection.getHeight()) {
            setDY(-getDY());
        }

    }

}
