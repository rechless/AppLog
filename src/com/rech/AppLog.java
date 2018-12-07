package com.rech;

import java.util.Scanner;

//See's it isn't used because i have just called static methods
import com.rech.Util;


public class AppLog {
    public static int logLevel = 0;
    public static int attemptsToSetLogLevel = 5;

    public static final int DISABLE_LOG = 0;
    public static final int ERROR_LEVEL = 1;
    public static final int WARNING_LEVEL = 2;
    public static final int ERROR_AND_WARNING = 3;
    public static final int EXIT_PROGRAM = 9;
    public static Scanner keyboardInput = new Scanner(System.in);

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
            case EXIT_PROGRAM:
                System.exit(0);
                break;
            default:
                logLevel = 0;
                Util.print("Invalid log level, please set up again, log level"
                        + " set to DISABLED");
                attemptsToSetLogLevel -= 1;
                break;
        }
    }

    public static void inputLogLevel(int inputtedLogLevel)
    {
        if(attemptsToSetLogLevel == 0)
        {
            Util.print("Your chances are over! \n enter any character to exit");
            keyboardInput.next();
            System.exit(0);
        }
        logLevel = inputtedLogLevel;
    }

    public void run()
    {
        while (true)
        {


            showLogLevelStatus();

            Util.print("DISABLE log level = 0"
                    + "\nERROR log level = 1"
                    + "\nWARNING log level = 2"
                    + "\nERROR and WARNING log level = 3"
                    + "\nOr enter 9 to exit program."
                    + "\n_____________________________________"
                    + "\n You have "+ attemptsToSetLogLevel + " left."
                    + "\nPlease enter a valid number");

            try {
                inputLogLevel(keyboardInput.nextInt());
                showLogLevelStatus();
            } catch (Exception capturedException) {
                System.out.println("Please only numbers Error: " + capturedException);
            }

        }
    }
}
