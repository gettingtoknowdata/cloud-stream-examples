package com.vmware.drona.config.model;

import lombok.Data;

import java.util.List;

@Data
public class JenkinsService {
    String name;
    List<String> jobs;
}
