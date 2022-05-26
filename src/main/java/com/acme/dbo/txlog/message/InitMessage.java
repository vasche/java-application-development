package com.acme.dbo.txlog.message;

import java.util.Objects;

public class InitMessage extends PrefixDecoratingMessage {

    public InitMessage() {
        super(null);
    }

    @Override
    public Message aggregate(Message message) {
        return Objects.requireNonNullElseGet(message, InitMessage::new);
    }

    @Override
    public String decorate() {
        return null;
    }
}
