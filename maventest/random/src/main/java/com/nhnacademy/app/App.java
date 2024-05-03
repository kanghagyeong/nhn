package com.nhnacademy.app;

import java.util.Random;
import org.apache.commons.math3.random.RandomDataGenerator;

public class App 
{
    public static void main( String[] args )
    {
        Random random = new Random();
        int randomNum = random.nextInt(1,100);
        System.out.println(randomNum);



        RandomDataGenerator rdg = new RandomDataGenerator();
        int num = rdg.nextInt(1, 100);
        System.out.println(num);


    }
}
