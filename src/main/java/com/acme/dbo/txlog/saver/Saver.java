package com.acme.dbo.txlog.saver;

public interface Saver {
    /**
     *
     * @param message String object
     */
    void save(String message);
}
