package com.amazonaws.services.s3.model.inventory;

public enum InventoryFormat {
    CSV("CSV");
    
    private final String format;

    private InventoryFormat(String str) {
        this.format = str;
    }

    public String toString() {
        return this.format;
    }
}
