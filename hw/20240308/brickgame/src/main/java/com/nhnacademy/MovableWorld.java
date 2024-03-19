package com.nhnacademy;

public class MovableWorld extends World {
    static final int DEAFAULT_DT = 10;
    int moveCount;
    int maxMoveCount = 0;
    int dt = DEAFAULT_DT;
    private Regionable other;

    public void setDT(int dt) {
        if (dt < 0) {
            throw new IllegalArgumentException();
        }
        this.dt = dt;
    }

    public int getDT() {
        return this.dt;
    }

    public void reset() {
        moveCount = 0;
    }

    public void move() {
        if ((getMaxMoveCount() == 0) || (getMoveCount() < getMaxMoveCount())) {
            for (int i = 0; i < getCount(); i++) {
                Regionable object = get(i);
                if (object instanceof Movable) {
                    ((Movable) object).move();

                    if (object instanceof Bounded) {
                        for (int j = 0; j < getCount(); j++) {
                            Regionable item = get(j);

                            if (item != object && item instanceof BreakableBox
                                    && item.getRegion().intersects(object.getRegion())) {
                                remove(item); // 벽돌 제거
                                ((Bounded) object).bounce(item);
                            } else if (item != object && !(item instanceof BreakableBox)
                                    && item.getRegion().intersects(object.getRegion())) {
                                ((Bounded) object).bounce(item);
                            }
                        }
                    }

                }
            }
            moveCount++;
            repaint();
        }
    }

    public void run() {
        while (!Thread.currentThread().isInterrupted()) {

            try {
                Thread.sleep(getDT());
                move();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public int getMoveCount() {
        return moveCount;
    }

    public int getMaxMoveCount() {
        return maxMoveCount;
    }

    public void setMaxMoveCount(int count) {
        if (count < 0) {
            throw new IllegalArgumentException();
        }

        maxMoveCount = count;
    }

}