package com.amazonaws.services.s3.model;

import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.services.s3.model.inventory.InventoryConfiguration;
import java.io.Serializable;

public class SetBucketInventoryConfigurationRequest extends AmazonWebServiceRequest implements Serializable {
    private String bucketName;
    private InventoryConfiguration inventoryConfiguration;

    public SetBucketInventoryConfigurationRequest() {
    }

    public SetBucketInventoryConfigurationRequest(String str, InventoryConfiguration inventoryConfiguration2) {
        this.bucketName = str;
        this.inventoryConfiguration = inventoryConfiguration2;
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }

    public SetBucketInventoryConfigurationRequest withBucketName(String str) {
        setBucketName(str);
        return this;
    }

    public InventoryConfiguration getInventoryConfiguration() {
        return this.inventoryConfiguration;
    }

    public void setInventoryConfiguration(InventoryConfiguration inventoryConfiguration2) {
        this.inventoryConfiguration = inventoryConfiguration2;
    }

    public SetBucketInventoryConfigurationRequest withInventoryConfiguration(InventoryConfiguration inventoryConfiguration2) {
        setInventoryConfiguration(inventoryConfiguration2);
        return this;
    }
}
