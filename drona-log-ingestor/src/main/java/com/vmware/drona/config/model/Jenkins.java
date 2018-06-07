package com.vmware.drona.config.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties("jenkins")
@Data
public class Jenkins {
    String server;
    List<JenkinsService> services;
    Credential credential;
}

