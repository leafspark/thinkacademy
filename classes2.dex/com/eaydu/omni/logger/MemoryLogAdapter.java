package com.eaydu.omni.logger;

public class MemoryLogAdapter implements LogAdapter {
    private final FormatStrategy formatStrategy;

    public boolean isLoggable(int i, String str) {
        return true;
    }

    public MemoryLogAdapter() {
        this.formatStrategy = MemoryFormatStrategy.newBuilder().build();
    }

    public MemoryLogAdapter(FormatStrategy formatStrategy2) {
        this.formatStrategy = (FormatStrategy) Utils.checkNotNull(formatStrategy2);
    }

    public void log(int i, String str, String str2) {
        this.formatStrategy.log(i, str, str2);
    }

    public StringBuffer getData() {
        FormatStrategy formatStrategy2 = this.formatStrategy;
        if (formatStrategy2 instanceof MemoryFormatStrategy) {
            return ((MemoryFormatStrategy) formatStrategy2).getData();
        }
        return new StringBuffer();
    }
}
