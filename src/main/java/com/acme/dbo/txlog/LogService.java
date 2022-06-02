package com.acme.dbo.txlog;

import com.acme.dbo.txlog.message.InitMessage;
import com.acme.dbo.txlog.message.Message;
import com.acme.dbo.txlog.saver.Saver;

import java.io.IOException;

/**
 * LogService
 */
public class LogService {
    private Message currentMessage = new InitMessage();
    private final Saver saver;

    public LogService(Saver saver) {
        this.saver = saver;
    }

    public void log(Message message) {
        if (currentMessage.shouldAgrregate(message)) {
            currentMessage = currentMessage.aggregate(message);
        } else {
            flush();
            currentMessage = message;
        }
    }

    public void flush() {
        try {
            saver.save(currentMessage.decorate());
        } catch (SaverDefaultException e) {
            throw new LogException(e.getMessage(), e);
        }
        currentMessage = new InitMessage();
    }

}
