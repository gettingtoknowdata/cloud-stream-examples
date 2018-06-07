package com.vmware.drona.controller;

import com.vmware.drona.config.model.Jenkins;
import com.vmware.drona.endpoint.impl.JenkinsConfiguration;
import com.vmware.drona.service.impl.JenkinsCollectionService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
@RequestMapping(path="/drona/ingest")
public class DronaIngestionController {

    private JenkinsCollectionService jenkinsCollectionService;

    public DronaIngestionController(JenkinsCollectionService jenkinsCollectionService) {
        this.jenkinsCollectionService = jenkinsCollectionService;
    }

    @GetMapping(path="/endpoints" )
    public List<Jenkins> getEndPoints() {

       return jenkinsCollectionService.getEndPoints();

    }

    @PostMapping(path="/{serviceName}/{changeset}/start")
    public void start(@PathVariable(name = "serviceName") String serviceName,
                      @PathVariable(name = "changeset") String changeset) {
        jenkinsCollectionService.monitorLogs(serviceName, changeset);
    }

}

