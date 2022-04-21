package com.acme.dbo.txlog.decorator;

public class PrefixDecorator {
    private static final String PRIMITIVE_PREFIX = "primitive: ";
    private static final String CHAR_PREFIX = "char: ";
    private static final String STRING_PREFIX = "string: ";
    private static final String REFERENCE_PREFIX = "reference: ";

    public static String decorate(int message) {
        return PRIMITIVE_PREFIX + message;
    }

    public static String decorate(char message) {
        return CHAR_PREFIX + message;
    }

    public static String decorate(String message) {
        return STRING_PREFIX + message;
    }

    public static String decorate(boolean message) {
        return PRIMITIVE_PREFIX + message;
    }

    public static String decorate(Object message) {
        return REFERENCE_PREFIX + message;
    }

}
