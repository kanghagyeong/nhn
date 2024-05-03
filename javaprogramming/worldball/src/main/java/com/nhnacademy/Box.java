package com.nhnacademy;

import java.awt.Rectangle;

public class Box implements Regionable {
    int x;
    int y;
    int id;
    int width;
    int height;
    Rectangle region;

    public Box(int x, int y, int width, int height) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("0보다 커야 합니다,");
        }
        this.x = x;
        this.y = y;
        this. width = width;
        this.height = height;
        this.region = new Rectangle(x - getWidth() /2, y - getHeight()/2, getWidth(), getHeight());
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Rectangle getRegion() {
        return region;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getId() {
        return id;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }


}
