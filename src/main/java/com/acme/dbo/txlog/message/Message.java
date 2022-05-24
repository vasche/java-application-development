package com.acme.dbo.txlog.message;

public interface Message {
    Integer getValue();
    String getMessage();
    void aggregate(Message message);
    boolean shouldAgrregate(Message message);
    String decorate();

}
