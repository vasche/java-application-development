package com.acme.dbo.txlog.message;

public class StringMessage extends PrefixDecoratingMessage {
    private static final String PREFIX = "string: ";
    private final String body;
    private final Integer counter;

    public StringMessage(String body) {
        super(PREFIX);
        this.body = body;
        this.counter = 1;
    }

    public StringMessage(String body, Integer counter) {
        super(PREFIX);
        this.body = body;
        this.counter = counter;
    }

    @Override
    public Message aggregate(Message message) {
        return new StringMessage(body, counter + 1);
    }

    @Override
    public boolean shouldAgrregate(Message message) {
        return super.shouldAgrregate(message)
                && (message instanceof StringMessage
                && ((StringMessage) message).body.equals(body));
    }

    @Override
    public String decorate() {
        if (this.counter > 1) {
            return super.decorate(String.format("%s (x%s)", body, counter));
        }
        return super.decorate(body);
    }
}
