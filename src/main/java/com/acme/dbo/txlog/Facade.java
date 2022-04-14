package com.acme.dbo.txlog;

import static com.acme.dbo.txlog.decorator.PrefixDecorator.*;
import static com.acme.dbo.txlog.printer.ConsolePrinter.print;

public class Facade {

    public static void log(int message) {
        print(decorate(PRIMITIVE_PREFIX, message));
    }

    public static void log(byte message) {
        print(decorate(PRIMITIVE_PREFIX, message));
    }

    public static void log(char message) {
        print(decorate(CHAR_PREFIX, message));
    }

    public static void log(String message) {
        print(decorate(STRING_PREFIX, message));
    }

    public static void log(boolean message) {
        print(decorate(PRIMITIVE_PREFIX, message));
    }

    public static void log(Object message) {
        print(decorate(REFERENCE_PREFIX, message));
    }
}
