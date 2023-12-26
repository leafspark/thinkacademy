package com.tal.app.thinkacademy.lib.download.operation;

public enum OperationState {
    SUCCESS(0),
    FAILED(1);
    
    public int value;

    private OperationState(int i) {
        this.value = i;
    }
}
