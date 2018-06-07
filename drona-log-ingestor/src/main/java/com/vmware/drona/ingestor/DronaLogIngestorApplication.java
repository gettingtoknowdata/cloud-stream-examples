package com.vmware.drona.ingestor;

import com.vmware.drona.binders.DronaEventBindings;
import com.vmware.drona.handlers.DronaEventProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication(scanBasePackages = {"com.vmware.drona"})
@EnableBinding(DronaEventBindings.class)
public class DronaLogIngestorApplication {

    @Autowired
    private DronaEventProcessor dronaEventProcessor;

    public static void main(String[] args) {
        SpringApplication.run(DronaLogIngestorApplication.class, args);
    }


}
