package com.acme.dbo.txlog.decorator;

public class PrefixDecorator {
    public static final String PRIMITIVE_PREFIX = "primitive: ";
    public static final String CHAR_PREFIX = "char: ";
    public static final String STRING_STRING = "string: ";
    public static final String REFERENCE_PREFIX = "reference: ";

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
