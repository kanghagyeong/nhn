package com.nhnacademy;

import java.awt.Rectangle;

import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;

public class Ball implements Regionable{
    static int count = 0;
    int id = ++count;
    int x;
    int y;
    int radius;
    Rectangle region;
    Logger logger = LogManager.getLogger(this.getClass().getSimpleName());

    public Ball(int x, int y, int radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("반지름은 0보다 커야 합니다.");
        }

        if ((x + (long) radius > Integer.MAX_VALUE)
                || (x - (long) radius < Integer.MIN_VALUE)
                || (y + (long) radius > Integer.MAX_VALUE)
                || (y - (long) radius < Integer.MIN_VALUE)) {
            throw new IllegalArgumentException("볼이 정수 공간을 벗어납니다.");
        }

        this.x = x;
        this.y = y;
        this.radius = radius;
        region = new Rectangle(getX() - getRadius(), getY() - getRadius(), 2 * getRadius(), 2 * getRadius());

        logger.trace("Ball created : {}, {}, {}", x ,y, radius);
    }

    public void setX(int x) {
        this.x = x;
        region.setLocation(getX() - getRadius(), getY() - getRadius());
    }

    public void setY(int y) {
        this.y = y;
        region.setLocation(getX() - getRadius(), getY() - getRadius());
    }

    public int getX() {
        return x;
        // return (int)region.getCenterX();
    }

    public int getY() {
        return y;
        //return (int)getRegion().getCenterY();
    }

    public int getRadius() {
        return radius;
    }

    public int getId() {
        return id;
    }

    public Rectangle getRegion() {
        return region;
    }

    @Override
    public String toString() {
        return String.format("(%d,%d,%d)", getX(), getY(), getRadius());
    }
}