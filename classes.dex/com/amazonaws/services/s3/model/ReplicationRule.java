package com.amazonaws.services.s3.model;

public class ReplicationRule {
    private ReplicationDestinationConfig destinationConfig;
    private String prefix;
    private String status;

    public String getPrefix() {
        return this.prefix;
    }

    public void setPrefix(String str) {
        if (str != null) {
            this.prefix = str;
            return;
        }
        throw new IllegalArgumentException("Prefix cannot be null for a replication rule");
    }

    public ReplicationRule withPrefix(String str) {
        setPrefix(str);
        return this;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public ReplicationRule withStatus(String str) {
        setStatus(str);
        return this;
    }

    public void setStatus(ReplicationRuleStatus replicationRuleStatus) {
        setStatus(replicationRuleStatus.getStatus());
    }

    public ReplicationRule withStatus(ReplicationRuleStatus replicationRuleStatus) {
        setStatus(replicationRuleStatus.getStatus());
        return this;
    }

    public ReplicationDestinationConfig getDestinationConfig() {
        return this.destinationConfig;
    }

    public void setDestinationConfig(ReplicationDestinationConfig replicationDestinationConfig) {
        if (replicationDestinationConfig != null) {
            this.destinationConfig = replicationDestinationConfig;
            return;
        }
        throw new IllegalArgumentException("Destination cannot be null in the replication rule");
    }

    public ReplicationRule withDestinationConfig(ReplicationDestinationConfig replicationDestinationConfig) {
        setDestinationConfig(replicationDestinationConfig);
        return this;
    }
}
