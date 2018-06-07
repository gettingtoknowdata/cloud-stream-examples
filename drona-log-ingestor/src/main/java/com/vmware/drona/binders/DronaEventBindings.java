package com.vmware.drona.binders;

import com.vmware.drona.event.model.JenkinsEvents;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;


public interface DronaEventBindings {
    String DRONA_BUILD_EVENT_IN = "dbuildEventIn";

    @Input(DRONA_BUILD_EVENT_IN)
    KStream<String, JenkinsEvents> dronaBuildEventin();
}
