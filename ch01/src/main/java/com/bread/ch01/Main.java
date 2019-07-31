package com.bread.ch01;

/**
 * @author zhiwj
 * @date 2019/7/30
 */
public class Main {
    /**
     * 
     * @ClassName: Main
     * @Description: 设置  program arguments 为  -help； 可以看到输出
     * @author zhiwj
     * @date 2019/7/31 18:47
     */
    public static void main(String[] args) {
        Cmd cmd = Cmd.parse(args);
        if (cmd.versionFlag) {
            System.out.println("version 0.0.1");
        } else if (cmd.helpFlag) {
            System.out.println("Usage: <main class> [-options] class [args...]");
        } else {
            startJVM(cmd);
        }
    }

    private static void startJVM(Cmd cmd) {
        System.out.println("Usage: <main class> [-options] class [args...]");
    }


}
