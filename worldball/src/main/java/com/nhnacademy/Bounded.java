package com.nhnacademy;

import java.awt.Rectangle;

public interface Bounded {
    public Rectangle getBounds();
    public void bounce(Regionable other);
    public void setBounds(Rectangle bounds); ////??
    

}
