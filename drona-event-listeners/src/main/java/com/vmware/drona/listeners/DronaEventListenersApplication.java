package com.vmware.drona.listeners;

import com.vmware.drona.stream.binders.DronaEventBindings;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication(scanBasePackages = "com.vmware.drona")
@EnableBinding(DronaEventBindings.class)
public class DronaEventListenersApplication {

	public static void main(String[] args) {
		SpringApplication.run(DronaEventListenersApplication.class, args);
	}
}
