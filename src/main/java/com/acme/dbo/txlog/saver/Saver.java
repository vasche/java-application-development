package com.acme.dbo.txlog.saver;

import com.acme.dbo.txlog.SaverDefaultException;

public interface Saver {
    /**
     *
     * @param message String object
     */
    void save(String message) throws SaverDefaultException;
}
