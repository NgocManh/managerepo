package com.example.testhiber.event;

import org.springframework.context.ApplicationEvent;

public class QueryEvent extends ApplicationEvent {
    public QueryEvent(Object source) {
        super(source);
    }
}
