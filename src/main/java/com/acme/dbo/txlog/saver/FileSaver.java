package com.acme.dbo.txlog.saver;

public class FileSaver implements Saver {
    private final String filename;

    public FileSaver(String filename) {
        this.filename = filename;
    }

    @Override
    public void save(String message) {
        System.out.println("message saved to file");
    }
}
