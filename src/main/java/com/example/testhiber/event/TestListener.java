package com.example.testhiber.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class TestListener {

    @Autowired
    ApplicationEventPublisher publisher;

    public void sendEvent()
    {
        publisher.publishEvent(new QueryEvent(this));
    }
}
