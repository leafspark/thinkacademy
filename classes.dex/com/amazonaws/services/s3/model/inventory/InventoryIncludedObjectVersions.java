package com.amazonaws.services.s3.model.inventory;

public enum InventoryIncludedObjectVersions {
    All("All"),
    Current("Current");
    
    private final String name;

    private InventoryIncludedObjectVersions(String str) {
        this.name = str;
    }

    public String toString() {
        return this.name;
    }
}
