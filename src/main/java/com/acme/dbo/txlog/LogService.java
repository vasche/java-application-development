package com.acme.dbo.txlog;

import com.acme.dbo.txlog.message.Message;
import com.acme.dbo.txlog.saver.ConsoleSaver;
import com.acme.dbo.txlog.saver.Saver;

public class LogService {
    private static Message currentMessage = null;
    private static final Saver saver = new ConsoleSaver();

    public void log(Message message) {
        if (message.shouldAgrregate(currentMessage)) {
            message.aggregate(currentMessage);
        } else {
            flush();
        }
        currentMessage = message;
    }

    public void flush() {
        if (currentMessage == null) {
            return;
        }
        saver.save(currentMessage.decorate());
        currentMessage = null;
    }

}
