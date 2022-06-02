package com.acme.dbo.txlog;

import com.acme.dbo.txlog.message.ByteMessage;
import com.acme.dbo.txlog.message.IntMessage;
import com.acme.dbo.txlog.message.StringMessage;
import com.acme.dbo.txlog.saver.FileSaver;

/**
 * my super logger
 * @author vasche
 */
public class Facade {

    private Facade() {
        throw new IllegalStateException("Facade class");
    }

    private static final LogService service = new LogService(new FileSaver("console.log"));

    public static void log(int message) {
        service.log(new IntMessage(message));
    }

    public static void log(String message) {
        service.log(new StringMessage(message));
    }

    public static void log(byte message) {
        service.log(new ByteMessage(message));
    }

    public static void flush() {
        service.flush();
    }

}
