package com.nhnacademy;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OptionHandler {
    public static void main(String[] args) {
        Options options = new Options();
        Logger logger = LogManager.getLogger();

        Option help = Option.builder("h")
                .longOpt("help")
                .desc("Help")
                .build();
        options.addOption(help);

        Option option1 = Option.builder("l")
                .longOpt("hello")
                .desc("Print Hello")
                .build();
        options.addOption(option1);

        Option option2 = Option.builder("n")
                .longOpt("number")
                .desc("Print number")
                .hasArg()
                .build();
        options.addOption(option2);

        Option option3 = Option.builder("p")
                .longOpt("run on port number")
                .desc("")
                .hasArg()
                .build();
        options.addOption(option3);

        CommandLineParser parser = new DefaultParser();
        try {
            CommandLine cmd = parser.parse(options, args);

            if (cmd.hasOption(("h"))) {
                HelpFormatter formatter = new HelpFormatter();
                formatter.printHelp("ls", options);
                System.exit(0);
            }

            if (cmd.hasOption("l")) {

                logger.info("안녕하세요");
            }

            if (cmd.hasOption("n")) {
                String op2 = cmd.getOptionValue(option2.getOpt());
                logger.trace("안녕하세요 {} 입니다", op2);

            }

            if (cmd.hasOption("p")) {

                String op3 = cmd.getOptionValue(option3.getOpt());
                try (ServerSocket serverSocket = new ServerSocket(Integer.parseInt(op3))) {
                    Socket socket = serverSocket.accept();
                    
                    logger.info("서버가 포트 {} 로 열렸습니다", op3);
                    
                    while (!Thread.currentThread().interrupted()) {
                    }

                } catch (IOException e) {
                    //
                    e.printStackTrace();
                }

            }

        } catch (ParseException e) {
            //
            e.printStackTrace();
        }

    }
}
