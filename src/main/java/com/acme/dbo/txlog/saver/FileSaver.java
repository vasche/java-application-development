package com.acme.dbo.txlog.saver;

import com.acme.dbo.txlog.SaverDefaultException;

public class FileSaver implements Saver {
    private final String filename;

    public FileSaver(String filename) {
        this.filename = filename;
    }

    @Override
    public void save(String message) throws SaverDefaultException {
        throw new SaverDefaultException("Something went wrong: Unable to write message to file " + filename );
    }
}
