package com.vmware.drona.enums;

public enum JenkinsPhase {
    QUEUED("QUEUED") {
        @Override
        public Boolean isFinalized() {
            return Boolean.FALSE;
        }

        @Override
        public Boolean isCompleted() {
            return Boolean.FALSE;
        }
    },

    STARTED("STARTED") {
        @Override
        public Boolean isFinalized() {
            return Boolean.FALSE;
        }

        @Override
        public Boolean isCompleted() {
            return Boolean.FALSE;
        }
    },

    COMPLETED("COMPLETED") {
        @Override
        public Boolean isFinalized() {
            return Boolean.FALSE;
        }

        @Override
        public Boolean isCompleted() {
            return Boolean.TRUE;
        }
    },

    FINALIZED("FINALIZED") {
        @Override
        public Boolean isFinalized() {
            return Boolean.TRUE;
        }

        @Override
        public Boolean isCompleted() {
            return Boolean.TRUE;
        }
    };


    private String phase;

    JenkinsPhase(String phase) {
        this.phase = phase;
    }

    public String phase() {
        return  phase;
    }

    public abstract Boolean isFinalized();
    public abstract Boolean isCompleted();

}

