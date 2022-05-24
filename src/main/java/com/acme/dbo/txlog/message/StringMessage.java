package com.acme.dbo.txlog.message;

public class StringMessage implements Message {
    private static final String PREFIX = "string: ";
    private final String body;
    Integer counter;

    public StringMessage(String body) {
        this.body = body;
        this.counter = 1;
    }

    @Override
    public Integer getValue() {
        return counter;
    }

    @Override
    public String getMessage() {
        return body;
    }

    @Override
    public void aggregate(Message message) {
        counter += message.getValue();
    }

    @Override
    public boolean shouldAgrregate(Message message) {
        if (message == null ) {
            return false;
        }

        if (message.getMessage().equals(this.getMessage())) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String decorate() {
        if (counter > 1) {
            return String.format("%s%s (x%s)", PREFIX, this.getMessage(), counter);
        } else {
            return PREFIX + this.getMessage();
        }
    }
}
