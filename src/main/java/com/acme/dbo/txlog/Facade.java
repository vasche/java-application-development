package com.acme.dbo.txlog;

import java.util.Objects;

import static com.acme.dbo.txlog.decorator.PrefixDecorator.*;
import static com.acme.dbo.txlog.printer.ConsolePrinter.print;

/**
 * my super logger
 */
public class Facade {
    private static int intMessage = 0;
    private static int stringCounter = 0;
    private static Object prevValue = null;
    private static String currentLine = null;


    public static void log(int message) {
        if (prevValue instanceof String) {
            flush();
        }
        intMessage = intMessage + message;
        currentLine = decorate(intMessage);
        prevValue = message;
    }

    public static void log(byte message) {
        print(decorate(message));
//        prevValue = message;
//        if (message == Byte.MAX_VALUE) {
//            flush();
//            intMessage = message;
//        } else {
//            intMessage = intMessage + message;
//        }
    }

    public static void log(char message) {
        print(decorate(message));
    }

    public static void log(String message) {
        stringCounter++;
        if (prevValue instanceof Integer) {
            flush();
        }
        if (prevValue != null || Objects.equals(message, prevValue)) {
            currentLine = decorate(message + " (x" + stringCounter + ")");
        } else {
            currentLine = decorate(message);
            flush();
        }
        prevValue = message;
    }

    public static void log(boolean message) {
        print(decorate(message));
    }

    public static void log(Object message) {
        print(decorate(message));
    }

    /**
     * Sets flush to true and print out the message
     */
    public static void flush() {
        print(currentLine);
        intMessage = 0;
        stringCounter = 0;
        currentLine = null;
        prevValue = null;
    }
}
