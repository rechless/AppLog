package com.rech;

import java.util.Scanner;
import com.rech.Util;

public class AppLog {
    public static int logLevel = 0;

    public static final int DISABLE_LOG = 0;
    public static final int ERROR_LEVEL = 1;
    public static final int WARNING_LEVEL = 2;
    public static final int ERROR_AND_WARNING = 3;

    public static boolean exitProgram = false;

    public static void showLogLevelStatus()
    {
        switch (logLevel) {
            case DISABLE_LOG:
                Util.print("Log level is: DISABLED");
                break;
            case ERROR_LEVEL:
                Util.print("Log level is: ERROR");
                break;
            case WARNING_LEVEL:
                Util.print("Log level is: WARNING");
                break;
            case ERROR_AND_WARNING:
                Util.print("Log level is: ERROR AND WARNING");
                break;
            default:
                Util.print("Invalid log level, please set up again");
                break;
        }
    }

    public static void inputLogLevel(int inputtedLogLevel)
    {
        try {
            logLevel = inputtedLogLevel;
        } catch (NumberFormatException capturedException) {
            System.out.println("Please only numbers Error: " +capturedException);
        }
    }

    public void run()
    {
        while (!exitProgram)
        {
            Scanner keyboardInput = new Scanner(System.in);

            showLogLevelStatus();

            Util.print("DISABLE log level = 0");
            Util.print("ERROR log level = 1");
            Util.print("WARNING log level = 2");
            Util.print("ERROR and WARNING log level = 3");
            Util.print("Please enter a number: ");

            inputLogLevel(keyboardInput.nextInt());
        }
    }
}
