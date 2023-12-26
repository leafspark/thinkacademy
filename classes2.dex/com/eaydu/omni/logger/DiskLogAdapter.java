package com.eaydu.omni.logger;

public class DiskLogAdapter implements LogAdapter {
    private final FormatStrategy formatStrategy;

    public boolean isLoggable(int i, String str) {
        return true;
    }

    public DiskLogAdapter() {
        this.formatStrategy = CsvFormatStrategy.newBuilder().build();
    }

    public DiskLogAdapter(FormatStrategy formatStrategy2) {
        this.formatStrategy = (FormatStrategy) Utils.checkNotNull(formatStrategy2);
    }

    public void log(int i, String str, String str2) {
        this.formatStrategy.log(i, str, str2);
    }
}
