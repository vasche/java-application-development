package com.acme.dbo.txlog.message;


public class IntMessage extends PrefixDecoratingMessage {
    private static final String PREFIX = "primitive: ";
    private final Integer body;

    /**
     *  Class constructor.
     * @param body Integer as message
     */
    public IntMessage(Integer body) {
        super(PREFIX);
        this.body = body;
    }

    @Override
    public Message aggregate(Message message) {
        return new IntMessage(body + ((IntMessage)message).body) ;
    }

    @Override
    public boolean shouldAgrregate(Message message) {
        return super.shouldAgrregate(message) && message instanceof IntMessage;
    }

    @Override
    public String decorate() {
        return super.decorate(String.valueOf(body));
    }

}


