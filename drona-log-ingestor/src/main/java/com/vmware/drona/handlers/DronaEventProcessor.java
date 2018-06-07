package com.vmware.drona.handlers;

import com.vmware.drona.binders.DronaEventBindings;
import com.vmware.drona.event.model.JenkinsEvents;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@EnableBinding(DronaEventBindings.class)
public class DronaEventProcessor {

    @Autowired
    DronaEventBindings bindings;

    @StreamListener
    public void process(@Input(DronaEventBindings.DRONA_BUILD_EVENT_IN) KStream<String, String> jenkinsEventsKStream) {
        jenkinsEventsKStream.foreach((key, value) -> log.info("The build"  + value));
    }

    @ServiceActivator(inputChannel = DronaEventBindings.DRONA_BUILD_EVENT_IN + ".jenkins.errors") //channel name 'input.myGroup.errors'
    public void error(Message<?> message) {
       log.error("Handling ERROR: " + message);
    }
}
