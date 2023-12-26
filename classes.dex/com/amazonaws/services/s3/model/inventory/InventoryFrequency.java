package com.amazonaws.services.s3.model.inventory;

public enum InventoryFrequency {
    Daily("Daily"),
    Weekly("Weekly");
    
    private final String frequency;

    private InventoryFrequency(String str) {
        this.frequency = str;
    }

    public String toString() {
        return this.frequency;
    }
}
