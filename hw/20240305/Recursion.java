import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Recursion {
    public static class MyCanvas extends JPanel {
        public static void drawLine(Graphics g, int startX, int startY, double angle, int length, int depth) {
            if (depth == 0) return; // 재귀 종료

            // 끝점
            int endX = startX + (int) (length * Math.cos(Math.toRadians(angle)));
            int endY = startY + (int) (length * Math.sin(Math.toRadians(angle)));

            g.drawLine(startX, startY, endX, endY);

            // 새로운 길이 계산
            int newLength = (int) (length * 0.7);

            
            drawLine(g, endX, endY, angle + 30, newLength, depth - 1);

            drawLine(g, endX, endY, angle -30, newLength, depth - 1);
        }

        @Override
        public void paint(Graphics g) {
            super.paint(g);
            System.out.println("paint mycanvas : " + getWidth() + "," + getHeight());
            g.setColor(Color.RED);

            // 재귀적으로 나무 그리기
            drawLine(g, getWidth() / 2, getHeight(), -90, 250, 20);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Tree"); // 프레임 생성
        frame.setSize(1500, 1500); // 프레임 크기 지정
        System.out.println(frame.getInsets().top + "," + frame.getInsets().left);

        MyCanvas panel = new MyCanvas(); // 캔버스 추가
        frame.add(panel); // add 다음 setVisible 해야 프레임에 바로 그림이 나옴 

        frame.setVisible(true); // 프레임 보이기
    }
}
