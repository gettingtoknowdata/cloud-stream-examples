package com.vmware.drona.event.model;

import com.vmware.drona.enums.JenkinsPhase;
import com.vmware.drona.enums.JenkinsResult;
import lombok.Data;

import java.util.List;

@Data
public class JenkinsEvents {
    private String name;
    private String url;
    private Build build;
}

@Data
class Build {
    private String full_url;
    private String url;
    private JenkinsPhase phase;
    private JenkinsResult status;
    private SCM scm;
}

@Data
class SCM {
    private String url;
    private String branch;
    private String commit;
    private List<String> changes;
    private List<String> culprits;
}
