package com.acme.dbo.txlog.message;

/**
 * Message interface
 * @author vasche
 */
public interface Message {

    /**
     *
     * @param message Message to compare
     * @return brand new aggregated Message object
     */
    Message aggregate(Message message);

    /**
     *
     * @param message Message to aggregate
     * @return boolean
     */
    boolean shouldAgrregate(Message message);

    /**
     *
     * Decorate message
     * @return String
     */
    String decorate();
}
