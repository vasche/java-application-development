package com.acme.dbo.txlog;

import java.util.Objects;

import static com.acme.dbo.txlog.decorator.PrefixDecorator.*;
import static com.acme.dbo.txlog.decorator.PrefixDecorator.decorate;
import static com.acme.dbo.txlog.printer.ConsolePrinter.print;

/**
 * my super logger
 */
public class Facade {
    private static final String INT_STATE = "int";
    private static final String BYTE_STATE = "byte";
    private static final String CHAR_STATE = "char";
    private static final String STRING_STATE = "string";
    private static final String BOOLEAN_STATE = "boolean";
    private static final String OBJECT_STATE = "Object";

    private static int intAggregator = 0;
    private static int byteAggregator = 0;
    private static int stringCounter = 0;
    private static String stateMessage = null;
    private static String state = "";
    private static String prevMessage = null;

    public static void log(int message) {
        if (!INT_STATE.equals(state) || (intAggregator + message) < Integer.min(message,intAggregator)){
            flush();
        }
        state = INT_STATE;
        intAggregator += message;
        stateMessage = decorate(intAggregator);
    }

    public static void log(byte message) {
        if (!BYTE_STATE.equals(state) || message + byteAggregator > Byte.MAX_VALUE) {
            flush();
        }
        state = BYTE_STATE;
        byteAggregator += message;
        stateMessage = decorate(byteAggregator);
    }

    public static void log(char message) {
        state = CHAR_STATE;
        print(decorate(message));
    }

    public static void log(String message) {
        if (!STRING_STATE.equals(state) || !Objects.equals(prevMessage, message)) {
            flush();
            stateMessage = decorate(message);
        }
        state = STRING_STATE;
        stringCounter++;
        prevMessage = message;
    }

    public static void log(boolean message) {
        state = BOOLEAN_STATE;
        print(decorate(message));
    }

    public static void log(Object message) {
        state = OBJECT_STATE;
        print(decorate(message));
    }

    /**
     * Sets flush to true and print out the message
     */
    public static void flush() {
        switch (state){
            case STRING_STATE:
                if(stringCounter > 1) {
                    stateMessage = decorate(String.format("%s (x%s)",prevMessage, stringCounter));
                } else {
                    stateMessage = decorate(prevMessage);
                }
                stringFlush();
                print(stateMessage);
                break;
            case INT_STATE:
                intFlush();
                print(stateMessage);
                break;
            case BYTE_STATE:
                byteAggregator = 0;
                print(stateMessage);
            default:
                intFlush();
                stringFlush();
                byteFlush();
                break;
        }

    }

    private static void byteFlush() {
        byteAggregator = 0;
    }

    private static void intFlush() {
        intAggregator = 0;
    }

    private static void stringFlush() {
        stringCounter = 0;
        prevMessage = null;
    }
}
