package com.nhnacademy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 유리수
 * 
 * @author xtra
 */

public class Rational {
        // 분자  - 어떤 타입을 가져야하는지 생각해보기 
            // 자바에서 정수형태의 값은 ? 5가지 - byte short long int char
        static int numerator; 

        // 분모
        static int denominator;
        Logger logger = LogManager.getLogger(this.getClass().getName());
        
    

 /**
  * 정수를 받아 생성 
  * @param n 정수
  * @param denominator 분모(정수)
  * @param denominator 분자(정수)
  */
    public Rational(int n) {
        numerator = n;
        denominator = 1;
        logger.trace("new rational : [{} / {}]", numerator, denominator);
        
    }

    public Rational (int numerator, int denominator) {
        if (denominator == 0) {
            throw new ArithmeticException();
        }

        if (denominator < 0) {
            numerator *= -1;
            denominator *= -1;
        }

        int g = gcd(Math.abs(numerator), denominator);

        this.numerator = numerator / g;
        this.denominator = denominator / g;
    }

    public Rational (Rational other) {
        this.numerator = other.getNumerator();
        this.denominator = other.getDenominator();
    }

    @Override  // toString()은 Object에 있는 함수이므로 오버라이드 적어주기
    public String toString() {
        if (getDenominator() == 1) {
            return "" + "[" + getNumerator() + "]";
        } else {
            return "[" + getNumerator() + "/" + getDenominator() + "]";
        }
    }

    static int getNumerator() {
        return numerator;
    }

    static int getDenominator() {
        return denominator;
    }

    @Override // 재정의
    public boolean equals(Object other) {
        return (other instanceof Rational) 
        && (hashCode() == other.hashCode()) 
        && (getNumerator() == ((Rational) other).getNumerator()) 
        && (getDenominator() == ((Rational) other).getDenominator());
    }
    
    /** 더하기 
     * 
     * @param Rational x
     * @param Rational y
     * @return x+y
     */
    public static Rational add(Rational x, Rational y) {
        int numerator = x.getNumerator() * y.getDenominator() + x.getDenominator() * y.getNumerator();
        int denominator = x.getDenominator() * y.getNumerator();
        return new Rational(numerator, denominator);
    }


    public static Rational subtract(Rational x, Rational y) {
        int numerator = x.getNumerator() * y.getDenominator() - x.getDenominator() * y.getNumerator();
        int denominator = x.getDenominator() * y.getNumerator();
        return new Rational(numerator, denominator);
    }

    public static Rational multiply(Rational x, Rational y) {
        int numerator = x.getNumerator() * y.getNumerator();
        int denominator = x.getDenominator() * y.getDenominator();
        return new Rational(numerator, denominator);
    }

    public static Rational divide(Rational x, Rational y ) {
        int numerator = x.getNumerator() * y.getDenominator();
        int denominator = x.getDenominator() * y.getNumerator();
        return new Rational(numerator, denominator);
    }

    public Rational inverse() {
        return new Rational(-getNumerator(), getDenominator());
    }

    public Rational reciprocal() {
        return new Rational(getDenominator(), getNumerator());
    }

    public Rational pow(int n) { //??????????????
        double newNumerator = Math.pow(getNumerator(), n);
        double newDenominator = Math.pow(getDenominator(), n);

        return new Rational((int)newNumerator, (int)newDenominator);
    }

    int gcd(int x, int y) {
        if  ( (x < 0) || (y < 0) ) {
            throw new ArithmeticException();
        }
        if (y == 0) {
            return x;
        }
        return gcd(y, x % y);
    } 
}
