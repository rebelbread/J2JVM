package com.bread.ch01;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

import java.util.List;

/**
 * @author zhiwj
 * @date 2019/7/29
 */
public class Cmd {

    @Parameter(names = { "-help", "-?" }, description = "print help message", help = true, order = 3)
    boolean helpFlag = false;
    @Parameter(names = "-version", description = "print version and exit", order = 2)
    boolean versionFlag = false;
    @Parameter(names = { "-cp", "-classpath" }, description = "classpath", order = 1)
    String cpOption;
    String className;
    @Parameter(description = "main class and args")
    List<String> args;


    static Cmd parse(String[] argv) {
        Cmd args = new Cmd();
        JCommander cmd = JCommander.newBuilder().addObject(args).build();
        cmd.parse(argv);
        return args;
    }

}
