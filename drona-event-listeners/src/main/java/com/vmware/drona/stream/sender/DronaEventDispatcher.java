package com.vmware.drona.stream.sender;

import com.vmware.drona.event.model.JenkinsEvents;
import com.vmware.drona.stream.binders.DronaEventBindings;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@EnableBinding(DronaEventBindings.class)
public class DronaEventDispatcher {

    private MessageChannel dronaBuildEventOut;

    public DronaEventDispatcher(DronaEventBindings dronaEventBindings) {
        this.dronaBuildEventOut = dronaEventBindings.dronaBuildEventOut();
    }

    //TODO Make it generic for all events
    public void sendEvents(JenkinsEvents buildEvents) {

        /*Message<JenkinsEvents> jenkinsEventsMessage = MessageBuilder
                .withPayload(buildEvents)
                .setHeader(KafkaHeaders.MESSAGE_KEY, buildEvents.getName().getBytes())
                .build();*/
        Message<String> jenkinsEventsMessage = MessageBuilder
                .withPayload(buildEvents.toString())
                .setHeader(KafkaHeaders.MESSAGE_KEY, buildEvents.getName().getBytes())
                .build();

        try {
            this.dronaBuildEventOut.send(jenkinsEventsMessage);
            log.info("The build event has been sent to the broker: " + buildEvents.getBuild() );
        }catch (Exception e) {
            log.error("The build event " + buildEvents.getBuild() + " has not sent", e);
        }

    }

}
