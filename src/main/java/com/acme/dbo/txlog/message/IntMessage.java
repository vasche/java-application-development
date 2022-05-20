package com.acme.dbo.txlog.message;


public class IntMessage {

    private final Integer body;

    public IntMessage(Integer body) {
        this.body = body;
    }

    public Integer getValue() {
        return body;
    }

}


