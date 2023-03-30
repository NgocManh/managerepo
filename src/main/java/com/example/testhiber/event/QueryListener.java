package com.example.testhiber.event;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class QueryListener {

    @Async
    @EventListener
    void listener(QueryListener event) throws InterruptedException {
       // Thread.sleep(2000);

        System.out.println("query listener success: " + Thread.currentThread().getName());

    }
}
