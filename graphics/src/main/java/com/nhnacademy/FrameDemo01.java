package com.nhnacademy;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FrameDemo01 {
    public static class MyCanvas extends JPanel {
        public static void drawBox(Graphics g, int x, int y, int width, int height) {
            if ((width > 5) && (height < 5)) {
                g.drawRect(x, y, width, height);

                MyCanvas.drawBox(g, x, y, width/3, height/3);
                MyCanvas.drawBox(g, x, y, (width/3)/3, (height/3)/3);
                MyCanvas.drawBox(g, x, y, width/3, height/3);
                MyCanvas.drawBox(g, x, y, width/3, height/3);
                MyCanvas.drawBox(g, x, y, width/3, height/3);

            }
            
        }
        @Override
        public void paint(Graphics g) {
            super.paint(g);
            System.out.println("paint mycanvas : " + getWidth() + "," + getHeight());
            g.setColor(Color.RED);
            // g.drawRect(0, 0, 50, 50);
            // g.drawRect(30, 30, 80, 80);
            // g.drawRect(60, 60, 110, 110);
            // g.drawRect(90, 90, 140, 140);
            for (int i = 0; i < 10; i++) {
                g.drawRect(i * 50, i * 50, 3 + (i*10), 3 + (i*10)); // 혼자 생각하기 연습하세요 강하경 
            }

        }
    }
    public static void main(String[] args) {
        
        JFrame frame = new JFrame("Demo01"); // 프레임 만들기

        frame.setSize(400, 300); // 프레임 크기 지정
        
        System.out.println(frame.getInsets().top + "," + frame.getInsets().left);

        MyCanvas panel = new MyCanvas(); // 캔버스 추가 
        frame.add(panel);

        frame.setVisible(true); // 프레임 보여주기 
 
    }
    
}
