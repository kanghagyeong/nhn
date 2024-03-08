package com.nhnacademy;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

public class TestEventFrame extends JFrame implements KeyListener, MouseMotionListener{
    
    public TestEventFrame() {
        
        addKeyListener(this);
        addMouseMotionListener(this);
    }

    public static void main(String[] args) {
        TestEventFrame frame = new TestEventFrame();

        frame.setSize(600, 500);

        frame.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyPressed(KeyEvent arg0) {
        // TODO Auto-generated method stub
        System.out.println("key pressed : " + arg0.getKeyCode());
       
    }

    @Override
    public void keyReleased(KeyEvent arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseDragged(MouseEvent arg0) {
        // TODO Auto-generated method stub
        System.out.println("mouse dragg : " + arg0.getX() + "," + getY());
    }

    @Override
    public void mouseMoved(MouseEvent arg0) {
        // TODO Auto-generated method stub
        System.out.println("mouse move : " + arg0.getX() + "," + getY());
    }
}
