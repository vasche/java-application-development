package com.acme.dbo.txlog.message;


public class IntMessage implements Message{
    private static final String PREFIX = "primitive: ";
    private final Integer body;
    Integer counter;

    public IntMessage(Integer body) {
        this.body = body;
        this.counter = body;
    }

    public Integer getValue() {
        return counter;
    }

    @Override
    public String getMessage() {
        return String.valueOf(counter);
    }

    @Override
    public void aggregate(Message message) {
        counter += message.getValue();
    }

    @Override
    public boolean shouldAgrregate(Message message) {
        if (message == null) {
            return false;
        }
        return message instanceof IntMessage;
    }

    @Override
    public String decorate() {
        return PREFIX + this.getMessage();
    }

}


