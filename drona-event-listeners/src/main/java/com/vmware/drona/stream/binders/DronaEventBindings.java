package com.vmware.drona.stream.binders;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;


public interface DronaEventBindings {
    String DRONA_BUILD_EVENT_OUT = "dbuildOutput";

    @Output(DRONA_BUILD_EVENT_OUT)
    MessageChannel dronaBuildEventOut();
}
