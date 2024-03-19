package com.nhnacademy;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Exam01 {
    public static void main(String[] args) {
        // Worker test
        // //ThreadPool 생성
        // ExecutorService executor = Executors.newFixedThreadPool(5);

        // for (int i = 0; i < 10; i++) {
        //     executor.submit(new Woker("Woker" + i));
        // }
        
        // // 모든 작업이 완료될 때까지 대기
        // executor.shutdown();
        // while (!executor.isTerminated()) {
            
        // }
        // System.out.println("모든 작업이 완료되었습니다.");

        ExecutorService executor = Executors.newFixedThreadPool(5);

        String[] urls = {
            "https://nhnacademy.dooray.com/share/drive-files/ocfkrcbb5vui.go2pyBWXRZ6IXN3whxDFtg",
            "https://nhnacademy.dooray.com/share/drive-files/ocfkrcbb5vui.YQloTWfJRz24Xhq2aVSGgw",
            "https://nhnacademy.dooray.com/share/drive-files/ocfkrcbb5vui.DwdVMtMaTmOFS_mQebo56w",
            "https://nhnacademy.dooray.com/share/drive-files/ocfkrcbb5vui.e2pbYnmHT_mRPWZZ3Z511Q",
            "https://nhnacademy.dooray.com/share/drive-files/ocfkrcbb5vui.p0sB3Ke2Tt64uXFPa1sU5A",
        };


        for (String url : urls) {
            Runnable worker = new DownloadWoker(url);
            executor.execute(worker);
        }
        executor.shutdown();
        while (!executor.isTerminated()) {
            
        }


    }
}
