package com.acme.dbo.txlog.saver;

public class ConsoleSaver implements Saver {
    @Override
    public void save(String message) {
        System.out.println(message);
    }
}
