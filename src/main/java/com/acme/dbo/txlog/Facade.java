package com.acme.dbo.txlog;

import com.acme.dbo.txlog.message.IntMessage;
import com.acme.dbo.txlog.message.StringMessage;
import com.acme.dbo.txlog.saver.ConsoleSaver;

/**
 * my super logger
 */
public class Facade {
    private static final LogService service = new LogService(new ConsoleSaver());

    public static void log(int message) {
        service.log(new IntMessage(message));
    }

    public static void log(String message) {
        service.log(new StringMessage(message));
    }

    public static void flush() {
        service.flush();
    }

}
