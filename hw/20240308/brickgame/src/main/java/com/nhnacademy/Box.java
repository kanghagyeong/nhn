package com.nhnacademy;

import java.awt.Rectangle;

public class Box implements Regionable {
    
    Rectangle region;

    public Box(int x, int y, int width, int height) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("0보다 커야 합니다,");
        }
        
        this.region = new Rectangle(x - width /2, y - height/2, width, height);
    }

    public int getWidth() {
        return (int)getRegion().getWidth();
    }

    public int getHeight() {
        return (int)getRegion().getHeight();
    }

    public Rectangle getRegion() {
        return region;
    }

    public int getX() {
        return (int)getRegion().getCenterX();
    }

    public int getY() {
        return (int)getRegion().getCenterY();
    }

    void setX(int x) {
        region.setLocation(x - getWidth() / 2, getY() - getHeight() / 2);
    }

    void setY(int y) {
        region.setLocation(getX() - getWidth() / 2, y - getHeight() / 2);
    }




}
