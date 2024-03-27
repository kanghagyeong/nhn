package com.nhnacademy;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;    
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.Option;

public class OptionHandler {
    public static void main(String[] args) {

        Options options = new Options(); // 옵션 객체 생성
        Option helpOption = new Option("h", false, "Help"); // 도움말 옵션 생성

        options.addOption(helpOption); // 도움말 옵션 추가

        Option head = Option.builder("H") // 새로 정의한 옵션 a -> add id - 사용자 접속 차단 등록
                .longOpt("head")
                .argName("path")
                .desc("Head")
                .build(); // 옵션을 생성하고 옵션의 속성 설정

        options.addOption(head); // 사용자 정의 옵션 추가해주기

        Option post = Option.builder("p")
                .longOpt("post")
                .argName("path")
                .hasArg()
                .desc("Post")
                .build();

        options.addOption(post);

        Option put = Option.builder("P")
                .longOpt("put")
                .argName("path")
                .hasArg()
                .desc("Put")
                .build();

        options.addOption(put);

        Option del = Option.builder("d")
                .longOpt("delete")
                .argName("path")
                .hasArg()
                .desc("Delete")
                .build();

        options.addOption(del);

        CommandLineParser parser = new DefaultParser(); // 명령줄 인자 파싱
        try {
            CommandLine commandLine = parser.parse(options, args); // 명령줄 옵션을 파싱하고 commandLine 객체를 얻는다

            if (commandLine.hasOption(helpOption.getOpt())) { // hasoption:옵션이 잘 전달되었는지 확인
                HelpFormatter formatter = new HelpFormatter();
                formatter.printHelp("recoder", options);
            }

            if (commandLine.hasOption("p")) {

            } else {

            }

            if (commandLine.hasOption("H")) {

            } else {

            }

            if (commandLine.hasOption("l")) {

            } else {

            }

        } catch (ParseException e) { // 예외처리
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }
}
