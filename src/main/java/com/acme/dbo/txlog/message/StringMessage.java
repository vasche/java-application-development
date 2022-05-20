package com.acme.dbo.txlog.message;

public class StringMessage {
    private final String body;

    public StringMessage(String body) {
        this.body = body;
    }

    public String getValue() {
        return body;
    }
}
