package com.vmware.drona.enums;

public enum JenkinsResult  {

    SUCCESS ("SUCCESS"),
    UNSTABLE("UNSTABLE"),
    FAILURE("FAILURE"),
    NOT_BUILT("NOT_BUILT"),
    ABORTED("ABORTED");

    private String result;
    JenkinsResult(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    public Boolean isNotSuccess() {
        return this == SUCCESS;
    }
}