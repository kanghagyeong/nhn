package com.nhnacademy;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class Main {
    public static void main(String[] args) {
        Options options = new Options();
        Option helpOption = new Option("h", false, "Help");

        options.addOption(helpOption);

        Option addData = Option.builder("a")
                .longOpt("add")
                .argName("path")
                .desc("Add Data")
                .build();

        options.addOption(addData);

        Option typeData = Option.builder("t")
                .longOpt("type")
                .hasArg()
                .argName("path")
                .desc("Specify Data Type")
                .build();

        options.addOption(typeData);

        Option id = Option.builder("i")
                .longOpt("id")
                .hasArg()
                .argName("path")
                .desc("Show id")
                .build();

        options.addOption(id);

        Option name = Option.builder("n")
                .longOpt("name")
                .hasArg()
                .argName("path")
                .desc("Show name")
                .build();

        options.addOption(name);

        Option list = Option.builder("l")
                .longOpt("list")
                .argName("path")
                .desc("Show list")
                .build();

        options.addOption(list);

        Option count = Option.builder("c")
                .longOpt("count")
                .hasArg()
                .argName("path")
                .desc("Show count")
                .build();

        options.addOption(count);

        Option Win = Option.builder("W")
                .longOpt("Win")
                .hasArg()
                .argName("path")
                .desc("Win Count")
                .build();

        options.addOption(Win);

        Option energy = Option.builder("e")
                .longOpt("energy")
                .hasArg()
                .argName("path")
                .desc("HP")
                .build();

        options.addOption(energy);

        Option attack = Option.builder("k")
                .longOpt("attack")
                .hasArg()
                .argName("path")
                .desc("Attack Power")
                .build();

        options.addOption(attack);

        Option defence = Option.builder("d")
                .longOpt("defence")
                .hasArg()
                .argName("path")
                .desc("Defence Power")
                .build();

        options.addOption(defence);

        Option movingSpeed = Option.builder("m")
                .longOpt("moving speed")
                .hasArg()
                .argName("path")
                .desc("Moving Speed")
                .build();

        options.addOption(movingSpeed);

        Option attackSpeed = Option.builder("A")
                .longOpt("attack speed")
                .hasArg()
                .argName("path")
                .desc("Attack Speed")
                .build();

        options.addOption(attackSpeed);

        Option history = Option.builder("L")
                .longOpt("history")
                .argName("path")
                .desc("Change History")
                .build();

        options.addOption(history);

        Option dbFile = Option.builder("f")
                .longOpt("DB File")
                .hasArg()
                .argName("path")
                .desc("DB File")
                .build();

        options.addOption(dbFile);

        CommandLineParser parser = new DefaultParser();
        try {
            CommandLine commandLine = parser.parse(options, args);

            DataBase dataBase = new DataBase();

            if (commandLine.hasOption(helpOption.getOpt())) {
                HelpFormatter formatter = new HelpFormatter();
                formatter.printHelp("recoder", options);
            }
            if (commandLine.hasOption("a")) {
                System.out.println("add Data");
            }
            if (commandLine.hasOption(typeData.getOpt())) {
                System.out.println("type");
            }
        } catch (ParseException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }

    }
}