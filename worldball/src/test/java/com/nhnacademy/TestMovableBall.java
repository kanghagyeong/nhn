package com.nhnacademy;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Color;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class TestMovableBall {
    @Test
    void testConstructor() {
        assertDoesNotThrow(() -> {
            //MovableBox ball = new MovableBox(1, 1, 1, Color.RED);

            assertEquals(MovableBox.DEFAULT_DX, ball.getDX());
            assertEquals(MovableBox.DEFAULT_DY, ball.getDY());
        });
    }

    @ParameterizedTest
    @MethodSource("deltaProvider")
    void testDeltaXY(int x, int y, int radius, int dx, int dy) {
        assertDoesNotThrow(() -> {
            //MovableBox ball = new MovableBox(x, y, radius, Color.RED);

            ball.setDX(dx);
            ball.setDY(dy);
            assertEquals(dx, ball.getDX());
            assertEquals(dy, ball.getDY());
        });
    }

    static Stream<Arguments> deltaProvider() {
        return Stream.of(
                Arguments.arguments(0, 0, 10, 0, 0),
                Arguments.arguments(0, 0, 10, 1, -1),
                Arguments.arguments(0, 0, 10, 1, 1),
                Arguments.arguments(0, 0, 10, -1, 1),
                Arguments.arguments(0, 0, 10, -1, -1),
                Arguments.arguments(0, 0, 10, Integer.MAX_VALUE, 0),
                Arguments.arguments(0, 0, 10, 0, Integer.MAX_VALUE),
                Arguments.arguments(0, 0, 10, Integer.MAX_VALUE, Integer.MAX_VALUE),
                Arguments.arguments(0, 0, 10, Integer.MIN_VALUE, 0),
                Arguments.arguments(0, 0, 10, 0, Integer.MIN_VALUE),
                Arguments.arguments(0, 0, 10, Integer.MIN_VALUE, Integer.MIN_VALUE));
    }

    @ParameterizedTest
    @MethodSource("moveProvider")
    void testMove(int x, int y, int radius, int dx, int dy, int count) {
        assertDoesNotThrow(() -> {
            //MovableBox ball = new MovableBox(x, y, radius, Color.BLUE);

            ball.setDX(dx);
            ball.setDY(dy);

            int currentX = x;
            int currentY = y;

            for (int i = 0; i < count; i++) {
                ball.move();
                currentX += dx;
                currentY += dy;

                assertEquals(currentX, ball.getX());
                assertEquals(currentY, ball.getY());
            }

            assertEquals(x + dx * count, ball.getX());
            assertEquals(y + dy * count, ball.getY());
        });
    }

    static Stream<Arguments> moveProvider() {
        return Stream.of(
                Arguments.arguments(10, 20, 10, 5, 10, 10),
                Arguments.arguments(10, 20, 10, -5, 10, 100),
                Arguments.arguments(10, 2, 10, 5, -10, 1000));
    }

    MovableBox ball;
    int startX = 0;
    int startY = 0;
    int deltaX = 10;
    int deltaY = 100;

    @BeforeEach
    void beforRepeatedMove() {
        //ball = new MovableBox(startX, startY, 10, Color.RED);
        ball.setDX(deltaX);
        ball.setDY(deltaY);
    }

    @RepeatedTest(10)
    void testRepeatedMove(RepetitionInfo repetitionInfo) {
        ball.move();
        assertEquals(startX + deltaX * repetitionInfo.getCurrentRepetition(), ball.getX());
        assertEquals(startY + deltaY * repetitionInfo.getCurrentRepetition(), ball.getY());
    }
}