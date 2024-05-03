package com.nhnacademy;

import java.awt.Color;
import java.awt.Rectangle;

public class BoundedBall extends MovableBall implements Bounded{
    private Rectangle bounds;

    public BoundedBall(int x, int y, int radius, Color color) {
        super(x, y, radius, color);

        bounds = new Rectangle(x - radius, y - radius, 2 * radius, 2 * radius);
    }

    public Rectangle getBounds() {
        return this.bounds;
    }

    public void setBounds(Rectangle bounds) {
        this.bounds = bounds;
    }

    public boolean isOutOfBounds() {
        if (bounds.intersects(new Rectangle(x - radius, y - radius, 2 * radius, 2 * radius))) {
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
        if ((getX() - getRadius()) < getBounds().getMinX()) {
            setDX(-getDX());
        }
        // 아래쪽 벽 : (dx, dy) → (dx, -dy) -oks
        else if ((getY() + getRadius()) > getBounds().getMaxY()) {
            setDY(-getDY());
        }
        // 오른쪽 벽 : (dx, dy) → (-dx, dy) -ok
        else if (getX() + getRadius() > getBounds().getMaxX()) {
            setDX(-getDX());
        }
        // 위쪽 벽 : (dx, dy) → (dx, -dy) -ok
        else if ((getY() - getRadius()) < getBounds().getMinX()) {
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
