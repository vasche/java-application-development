package com.acme.dbo.txlog.message;

public class ByteMessage extends PrefixDecoratingMessage {
    private static final String PREFIX = "primitive: ";
    private final Byte body;

    public ByteMessage(Byte body) {
        super(PREFIX);
        this.body = body;
    }

    @Override
    public Message aggregate(Message message) {
        return new ByteMessage((byte) (body + ((ByteMessage) message).body));
    }

    @Override
    public boolean shouldAgrregate(Message message) {
        return super.shouldAgrregate(message) &&  message instanceof ByteMessage;
    }

    @Override
    public String decorate() {
        return super.decorate(String.valueOf(body));
    }
}
