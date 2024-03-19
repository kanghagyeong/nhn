package com.nhnacademy;

import java.awt.Color;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class TestWorld {
        static final int FRAME_WIDTH = 700;
        static final int FRAME_HEIGHT = 800;
        static final int FIXED_BOX_COUNT = 0;
        static final int BOUNDED_BALL_COUNT = 1;
        static final int MIN_DELTA = 5;
        static final int MAX_DELTA = 7;
        static final int BOX_WIDTH = 70;
        static final int BOX_HEIGHT = 30;
        static final int MAX_MOVE_COUNT = 0;
        static final int PADDLE_WIDTH = 90;
        static final int PADDLE_HEIGHT = 30;
        static final int DT = 10;
        static final int WALL_THICKNESS = 50;
        static final Color[] COLOR_TABLE = {
                        Color.RED,
                        Color.BLUE,
                        Color.YELLOW,
                        Color.ORANGE
        };

        static Color getRandomColor() {
                Random random = new Random();
                Color[] colors = { Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW, Color.ORANGE };
                return colors[random.nextInt(colors.length)];
        }

        public static void main(String[] args) {
                JFrame frame = new JFrame();
                BreakableBox[][] breakableBoxes = new BreakableBox[10][10];

                frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

                MovableWorld world = new MovableWorld();
                world.setBounds(-WALL_THICKNESS, -WALL_THICKNESS,
                                FRAME_WIDTH + WALL_THICKNESS * 2,
                                FRAME_HEIGHT + WALL_THICKNESS * 2);
                frame.add(world);

                Random random = new Random();

                world.add(new PaintableBox(-WALL_THICKNESS / 2, FRAME_HEIGHT / 2,
                                WALL_THICKNESS, FRAME_HEIGHT + 2 * WALL_THICKNESS));
                world.add(new PaintableBox(FRAME_WIDTH / 2, -WALL_THICKNESS / 2,
                                FRAME_WIDTH + 2 * WALL_THICKNESS, WALL_THICKNESS));
                world.add(new PaintableBox(FRAME_WIDTH + WALL_THICKNESS / 2, FRAME_HEIGHT / 2,
                                WALL_THICKNESS, FRAME_HEIGHT + 2 * WALL_THICKNESS));
                world.add(new PaintableBox(FRAME_WIDTH / 2, FRAME_HEIGHT + WALL_THICKNESS / 2,
                                FRAME_WIDTH + 2 * WALL_THICKNESS, WALL_THICKNESS));

                for (int i = 0; i < 10; i++) {
                        for (int j = 0; j < 10; j++) {
                                int x = (i * BOX_WIDTH) + (BOX_WIDTH / 2);
                                int y = (j * BOX_HEIGHT) + (BOX_HEIGHT / 2);
                                Color color = getRandomColor();
                                BreakableBox breakableBox = new BreakableBox(x, y, BOX_WIDTH, BOX_HEIGHT, color, 1);
                                world.add(breakableBox);
                        }
                }

                try {
                        BoundedBall ball = new BoundedBall(FRAME_WIDTH / 2,FRAME_HEIGHT / 2, 10, Color.BLACK);
                        
                        int dx = MIN_DELTA - random.nextInt(MAX_DELTA - MIN_DELTA + 1);
                        int dy = MIN_DELTA - random.nextInt(MAX_DELTA - MIN_DELTA + 1);

                        ball.setDX(dx);
                        ball.setDY(dy);

                        world.add(ball);
                } catch (IllegalArgumentException ignore) {

                }
        

                frame.setVisible(true);

                world.setMaxMoveCount(MAX_MOVE_COUNT);
                world.setDT(DT);
                world.run();
        }
}