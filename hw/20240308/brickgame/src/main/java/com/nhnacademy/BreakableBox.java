package com.nhnacademy;

import java.awt.Color;
import java.awt.List;
import java.awt.Rectangle;
import java.util.ArrayList;

public class BreakableBox extends PaintableBox implements Breakable  {
    int heart;

    public BreakableBox(int x, int y, int width, int height, Color color, int heart) {
        super(x, y, width, height, color);
        this.heart = heart;

    }

    public void breakBox(){
        
    }

}
