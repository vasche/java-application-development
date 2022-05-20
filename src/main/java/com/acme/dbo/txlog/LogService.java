package com.acme.dbo.txlog;

import com.acme.dbo.txlog.message.IntMessage;
import com.acme.dbo.txlog.message.MessageStateType;
import com.acme.dbo.txlog.message.StringMessage;

import java.util.Objects;

import static com.acme.dbo.txlog.decorator.PrefixDecorator.decorate;
import static com.acme.dbo.txlog.printer.ConsolePrinter.print;

public class LogService {
    private MessageStateType state = MessageStateType.NONE;
    private static Integer intAggregator = 0;
    private static Integer stringCounter = 0;
    private static String stateMessage = null;


    public void log(IntMessage message) {
        if (!state.equals(MessageStateType.INTEGER)) {
            flush();
        }
        this.state = MessageStateType.INTEGER;
        intAggregator += message.getValue();
    }

    public void log(StringMessage message) {
        if (!state.equals(MessageStateType.STRING) || !Objects.equals(stateMessage, message.getValue())) {
            flush();
        }
        stringCounter++;
        this.state = MessageStateType.STRING;
        stateMessage = message.getValue();
    }

    public void flush() {
        switch (state) {
            case NONE:
                return;
            case STRING:
                if (stringCounter > 1) {
                    print(decorate(String.format("%s (x%s)", stateMessage, stringCounter)));
                } else {
                    print(decorate(stateMessage));
                }
                stringCounter = 0;
                break;
            case INTEGER:
                print(decorate(intAggregator.intValue()));
                intAggregator = 0;
                break;
        }
    }
}
