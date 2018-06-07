package com.vmware.drona.endpoint.impl;

import com.vmware.drona.config.model.Jenkins;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(Jenkins.class)
public class JenkinsConfiguration {
}
