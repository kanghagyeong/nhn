package com.nhnacademy;

public class Vector {
    // dx, dy 변수
    int dx = 0;
    int dy = 0;

    public Vector () {
        
    }
    // dx, dy 를 받아서 Vector 오브젝트 생성
    public Vector(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    // dx, dy를 위한 getter
    public int getDX() {
        return dx;
    }
    
    public int getDY() {
        return dy;
    }

    // dx, dy의 setter
    public void setDX(int dx) {
        this.dx = dx;
    }
    public void setDY(int dy) {
        this.dy = dy;
    }

    // dx, dy 방향 바꾼다 
    public void turnDX() {
        setDX(-getDX());
    }
    public void turnDY() {
        setDY(-getDY());
    }

    // 추가 + - 연산 (이것은 나중에)

    public void set (int dx, int dy) {
        setDX(dx);
        setDY(dy);
    }

    public void set (Vector other) {
        setDX(other.getDX());
        setDY(other.getDY());
    }

    public void add(Vector other) {
        set(getDX() + other.getDX(), getDY() + other.getDY());
        // setDX(getDX() + other.getDX()) ;
        // setDY(getDY() + other.getDY());
    }

    public void subtract(Vector other) {
        setDX(getDX() - other.getDX());
        setDY(getDY() - other.getDY());

    }
    // ???????????????
    // public boolean equals(Other other) {
    //     return (other instanceof Vector) && ((Vector)other).getDX() = 
    // }
}