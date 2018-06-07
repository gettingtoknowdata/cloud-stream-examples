package com.vmware.drona.domain;

import com.offbytwo.jenkins.JenkinsServer;
import com.offbytwo.jenkins.model.BuildWithDetails;
import com.offbytwo.jenkins.model.JobWithDetails;
import com.vmware.drona.config.model.Credential;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.net.URI;

@Data
public class JenkinsDataRetriever {
    @NotNull
    private JenkinsServer jenkinsServer;

    @NotNull
    private URI jenkinsURI;

    @NotNull
    private Credential credential;

    public JenkinsDataRetriever(@NotNull URI jenkinsURI, @NotNull Credential credential) {
        this.jenkinsURI = jenkinsURI;
        this.credential = credential;

        this.jenkinsServer = new JenkinsServer(jenkinsURI, credential.getUsername(), credential.getPassword());
    }

    public void getJobDetails(String jobName) {

        String jobXML = "";
        try {
           JobWithDetails jobsWithDetails = jenkinsServer.getJob(jobName);
            System.out.println("jobName = [" + jobName + "]");
           if(null != jobsWithDetails) {
               @NotNull BuildWithDetails buildWithDetails = jobsWithDetails.getLastBuild().details();
               if(null != jobsWithDetails ) {
                   System.out.println("Last Build details = " + buildWithDetails.getConsoleOutputText());
               }
           }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
