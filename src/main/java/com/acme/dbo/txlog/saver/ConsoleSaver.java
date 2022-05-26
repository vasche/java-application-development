package com.acme.dbo.txlog.saver;

public class ConsoleSaver implements Saver {
    @Override
    public void save(String message) {
        if (message == null) {
            return;
        }
        System.out.println(message);
    }
}
