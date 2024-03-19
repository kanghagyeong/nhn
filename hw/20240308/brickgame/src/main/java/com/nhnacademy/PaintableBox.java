package com.nhnacademy;

import java.awt.Color;
import java.awt.Graphics;

public class PaintableBox extends Box implements Paintable {
    public static final Color DEFAULT_COLOR = Color.BLACK;

    Color color;

    public PaintableBox(int x, int y, int width, int height) {
        this(x, y, width, height,Color.ORANGE);

    }

    public PaintableBox(int x, int y, int width, int height, Color color) {
        super(x, y, width, height);

        if(color == null) {
            throw new IllegalArgumentException();
        }

        this.color = color;
    }

    

    public Color getColor() {
        return color;
    }

    public synchronized void setColor(Color color) {
        this.color = color;
    }

    public void paint(Graphics g) {
        if ( g == null ) {
            throw new IllegalArgumentException();
        }

        Color origiColor = g.getColor();

        g.setColor(getColor());
        g.fillRect(getX() - getWidth() / 2, getY() - getHeight() / 2, getWidth(), getHeight());
        g.setColor(Color.BLACK);
        g.drawRect(getX() - getWidth() / 2, getY() - getHeight() / 2, getWidth(), getHeight());

        g.setColor(origiColor);
        
    }
}
