package com.acme.dbo.txlog.message;

public abstract class PrefixDecoratingMessage implements Message {
    private final String prefix;

    public PrefixDecoratingMessage(String prefix) {
        this.prefix = prefix;
    }

    protected String decorate(String value) {
        return prefix + value;
    }

    public boolean shouldAgrregate(Message message) {
        return message != null;
    }
}
