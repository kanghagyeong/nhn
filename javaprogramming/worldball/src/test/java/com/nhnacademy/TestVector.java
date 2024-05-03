package com.nhnacademy;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class TestVector {
    @Test
    void testConstructor() {
        assertDoesNotThrow(() -> {
            int dx = 100;
            int dy = -100;
            Vector vector = new Vector(100, -100);

            assertEquals(dx, vector.getDX());
            assertEquals(dy, vector.getDX());
        });
    }

    // ????????????????????/
    // @Test
    // void testSet() {
    //     assertDoesNotThrow(()-> {
    //         Vector targetVector = new Vector(100, -100);
    //         Vector 
    //     })
    // }
}
