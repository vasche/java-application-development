package com.acme.dbo.txlog.decorator;

public class PrefixDecorator {
    public static final String PRIMITIVE = "primitive: ";
    public static final String CHAR = "char: ";
    public static final String STRING = "string: ";
    public static final String REFERENCE = "reference: ";

    public static String decorate(String prefix, int message) {
        return prefix + message;
    }

    public static String decorate(String prefix, char message) {
        return prefix + message;
    }

    public static String decorate(String prefix, String message) {
        return prefix + message;
    }

    public static String decorate(String prefix, boolean message) {
        return prefix + message;
    }

    public static String decorate(String prefix, Object message) {
        return prefix + message;
    }

}
