import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Recursion2 {
    public static class MyCanvas extends JPanel {
        
        public static void drawTriangle(Graphics g, int[] xPoints, int[] yPoints, int depth) {
            if (depth == 0) return; // 재귀 종료

            g.setColor(Color.RED);
            g.drawPolygon(xPoints, yPoints, 3); // 삼각형 그리기

            // 중심점
            int[] newxPoints = new int[3];
            int[] newyPoints = new int[3];
            for (int i = 0; i < 3; i++) {
                newxPoints[i] = (xPoints[i] + xPoints[(i + 1) % 3]) / 2;
                newyPoints[i] = (yPoints[i] + yPoints[(i + 1) % 3]) / 2;
            }

            // 새로운 삼각형 그리기
            drawTriangle(g, newxPoints, newyPoints, depth - 1);
        }

        @Override
        public void paint(Graphics g) {
            super.paint(g);
            System.out.println("paint mycanvas : " + getWidth() + "," + getHeight());
            g.setColor(Color.RED);

            int[] xPoints = {500, 750, 200};
            int[] yPoints = {200, 750, 750};

            
            drawTriangle(g, xPoints, yPoints, 10);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Triangle"); // 프레임 생성
        frame.setSize(1000, 1000); // 프레임 크기 지정

        MyCanvas panel = new MyCanvas(); // 캔버스 추가
        frame.add(panel);

        frame.setVisible(true); // 프레임 보이기
    }
}
