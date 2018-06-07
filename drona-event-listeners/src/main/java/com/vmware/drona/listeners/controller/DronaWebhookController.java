package com.vmware.drona.listeners.controller;

import com.vmware.drona.event.model.JenkinsEvents;
import com.vmware.drona.stream.sender.DronaEventDispatcher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping(path = "/drona/hooks" )
public class DronaWebhookController {
    private DronaEventDispatcher dronaEventDispatcher;

    public DronaWebhookController(DronaEventDispatcher dronaEventDispatcher) {
        this.dronaEventDispatcher = dronaEventDispatcher;
    }

    @PostMapping(path = "/jenkins", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void  recieveJenkinsEvents(@RequestBody JenkinsEvents events) {

        Mono<JenkinsEvents> eventsMono = Mono.justOrEmpty(events);
        eventsMono.log()
                .subscribe(dronaEventDispatcher::sendEvents);

        return;

    }

    @PostMapping(path = "/reimann", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void  recieveReimannEvents(@RequestBody JenkinsEvents events) {

        Mono<JenkinsEvents> eventsMono = Mono.justOrEmpty(events);
        eventsMono.log()
                .subscribe(System.out::println);

        return;

    }
}
