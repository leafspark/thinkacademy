package com.eaydu.omni.logger;

import android.os.HandlerThread;
import com.eaydu.omni.logger.Logger;
import com.eaydu.omni.logger.MemoryLogStrategy;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MemoryFormatStrategy implements FormatStrategy {
    private static final String NEW_LINE = System.getProperty("line.separator");
    private static final String NEW_LINE_REPLACEMENT = " <br> ";
    private static final String SEPARATOR = ",";
    private final Date date;
    private final SimpleDateFormat dateFormat;
    private final LogStrategy logStrategy;
    private final String tag;
    MemoryLogStrategy.WriteHandler writeHandler;

    private MemoryFormatStrategy(Builder builder) {
        Utils.checkNotNull(builder);
        this.date = builder.date;
        this.dateFormat = builder.dateFormat;
        this.logStrategy = builder.logStrategy;
        this.tag = builder.tag;
        this.writeHandler = builder.writeHandler;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public void log(int i, String str, String str2) {
        Utils.checkNotNull(str2);
        if (str == null || !str.equals(Logger.LoggerTags.SdkTag) || str2 == null) {
            String formatTag = formatTag(str);
            this.date.setTime(System.currentTimeMillis());
            StringBuilder sb = new StringBuilder();
            sb.append(Long.toString(this.date.getTime()));
            sb.append(SEPARATOR);
            sb.append(this.dateFormat.format(this.date));
            sb.append(SEPARATOR);
            sb.append(Utils.logLevel(i));
            sb.append(SEPARATOR);
            sb.append(formatTag);
            String str3 = NEW_LINE;
            if (str2.contains(str3)) {
                str2 = str2.replaceAll(str3, NEW_LINE_REPLACEMENT);
            }
            sb.append(SEPARATOR);
            sb.append(str2);
            sb.append(str3);
            this.logStrategy.log(i, formatTag, sb.toString());
            return;
        }
        LogStrategy logStrategy2 = this.logStrategy;
        String str4 = this.tag;
        logStrategy2.log(i, str4, str2 + NEW_LINE);
    }

    private String formatTag(String str) {
        if (Utils.isEmpty(str) || Utils.equals(this.tag, str)) {
            return this.tag;
        }
        return this.tag + "-" + str;
    }

    public StringBuffer getData() {
        MemoryLogStrategy.WriteHandler writeHandler2 = this.writeHandler;
        if (writeHandler2 != null) {
            return writeHandler2.getData();
        }
        return new StringBuffer();
    }

    public static final class Builder {
        private static final int MAX_BYTES = 1024000;
        Date date;
        SimpleDateFormat dateFormat;
        LogStrategy logStrategy;
        String tag;
        MemoryLogStrategy.WriteHandler writeHandler;

        private Builder() {
            this.tag = "RTC_LOGGER";
        }

        public Builder date(Date date2) {
            this.date = date2;
            return this;
        }

        public Builder dateFormat(SimpleDateFormat simpleDateFormat) {
            this.dateFormat = simpleDateFormat;
            return this;
        }

        public Builder logStrategy(LogStrategy logStrategy2) {
            this.logStrategy = logStrategy2;
            return this;
        }

        public Builder tag(String str) {
            this.tag = str;
            return this;
        }

        public MemoryFormatStrategy build() {
            if (this.date == null) {
                this.date = new Date();
            }
            if (this.dateFormat == null) {
                this.dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss.SSS", Locale.UK);
            }
            if (this.logStrategy == null) {
                HandlerThread handlerThread = new HandlerThread("MemoryRTCLogger");
                handlerThread.start();
                MemoryLogStrategy.WriteHandler writeHandler2 = new MemoryLogStrategy.WriteHandler(handlerThread.getLooper(), MAX_BYTES);
                this.writeHandler = writeHandler2;
                this.logStrategy = new MemoryLogStrategy(writeHandler2);
            }
            return new MemoryFormatStrategy(this);
        }
    }
}
