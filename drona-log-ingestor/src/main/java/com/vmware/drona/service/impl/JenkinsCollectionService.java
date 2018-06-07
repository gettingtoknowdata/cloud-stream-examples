package com.vmware.drona.service.impl;


import com.vmware.drona.config.model.Jenkins;
import com.vmware.drona.domain.JenkinsDataRetriever;
import com.vmware.drona.service.EndPointMonitoringService;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@Service
public class JenkinsCollectionService implements EndPointMonitoringService {



    private Jenkins jenkins;

    public JenkinsCollectionService(Jenkins jenkins){
        this.jenkins = jenkins;
    }

    @Bean
    private JenkinsDataRetriever jenkinsDataRetriever(Jenkins jenkins) throws URISyntaxException {
        return  new JenkinsDataRetriever(new URI(jenkins.getServer()), jenkins.getCredential());
    }

    public List<Jenkins> getEndPoints() {

        List<Jenkins> endPoints = new ArrayList<>();
        endPoints.add(jenkins);
        return endPoints;
    }

    public void monitorLogs(String serviceName, String changeset) {

       jenkins.getServices().stream()
               .filter( s -> serviceName.equals(s.getName()))
               .map(s -> s.getJobs())
               .flatMap(s -> s.stream())
               .forEach(job -> {
                   try {
                       jenkinsDataRetriever(jenkins).getJobDetails(job);
                   } catch (URISyntaxException e) {
                       e.printStackTrace();
                   }
               });
    }
}
