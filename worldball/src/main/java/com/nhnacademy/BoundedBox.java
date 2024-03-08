package com.nhnacademy;

import java.awt.Color;
import java.awt.Rectangle;

public class BoundedBox extends MovableBox implements Bounded {
    private Rectangle bounds;

    public BoundedBox(int x, int y, int width, int height, Color color) {
        super(x, y, width, height, color);

        bounds = new Rectangle(x - width / 2 , y - height / 2, width, height);
    }

    public Rectangle getBounds() {
        return this.bounds;
    }

    public void setBounds(Rectangle bounds) {
        this.bounds = bounds;
    }

    public boolean isOutOfBounds() {
        if (bounds.intersects(new Rectangle(x - getWidth() / 2 , y - getHeight() / 2, getWidth(), getHeight()))) {
            // if(x < 0 || x > width || y < 0 || y > height) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void move() {
        super.move();
        if (isOutOfBounds()) {
            bounce();
        }

    }

    public void bounce() {
        // 왼쪽 벽 : (dx, dy) → (-dx, dy) -ok
        if ((getX() - getWidth()/2) < getBounds().getMinX()) {
            setDX(-getDX());
        }
        // 아래쪽 벽 : (dx, dy) → (dx, -dy) -oks
        else if ((getY() + getHeight()/2) > getBounds().getMaxY()) {
            setDY(-getDY());
        }
        // 오른쪽 벽 : (dx, dy) → (-dx, dy) -ok
        else if (getX() + getWidth() > getBounds().getMaxX()) {
            setDX(-getDX());
        }
        // 위쪽 벽 : (dx, dy) → (dx, -dy) -ok
        else if ((getY() - getHeight()) < getBounds().getMinX()) {
            setDY(-getDY());
        }
    }
    //공끼리 충돌하면 튕겨내기 
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
