package com.aliyun.sls.android.producer;

import com.aliyun.sls.android.producer.utils.TimeUtils;
import java.util.Map;

public class LogProducerClient {
    private IAddLogInterceptor addLogInterceptor;
    private final long client;
    private final long producer;

    public interface IAddLogInterceptor {
        void onBeforeLogAdded(Log log);
    }

    private static native long create_log_producer(long j, LogProducerCallback logProducerCallback);

    private static native void destroy_log_producer(long j);

    private static native long get_log_producer_client(long j);

    private static native int log_producer_client_add_log_with_len(long j, long j2, int i, String[] strArr, String[] strArr2, int i2);

    private static native int log_producer_client_add_log_with_len_time_int32(long j, long j2, int i, byte[][] bArr, byte[][] bArr2);

    public LogProducerClient(LogProducerConfig logProducerConfig) throws LogProducerException {
        this(logProducerConfig, (LogProducerCallback) null);
    }

    public LogProducerClient(LogProducerConfig logProducerConfig, LogProducerCallback logProducerCallback) throws LogProducerException {
        long create_log_producer = create_log_producer(logProducerConfig.getConfig(), logProducerCallback);
        this.producer = create_log_producer;
        if (create_log_producer != 0) {
            long j = get_log_producer_client(create_log_producer);
            this.client = j;
            if (j != 0) {
                TimeUtils.startUpdateServerTime(logProducerConfig.getContext(), logProducerConfig.getEndpoint(), logProducerConfig.getProject());
                return;
            }
            throw new LogProducerException("Can not create log producer client");
        }
        throw new LogProducerException("Can not create log producer");
    }

    public LogProducerResult addLog(Log log) {
        return addLog(log, 0);
    }

    public LogProducerResult addLog(Log log, int i) {
        if (this.client == 0 || log == null) {
            return LogProducerResult.LOG_PRODUCER_INVALID;
        }
        IAddLogInterceptor iAddLogInterceptor = this.addLogInterceptor;
        if (iAddLogInterceptor != null) {
            iAddLogInterceptor.onBeforeLogAdded(log);
        }
        Map<String, String> content = log.getContent();
        int size = content.size();
        String[] strArr = new String[size];
        String[] strArr2 = new String[size];
        int i2 = 0;
        for (Map.Entry next : content.entrySet()) {
            String str = (String) next.getKey();
            String str2 = "";
            if (str == null) {
                str = str2;
            }
            strArr[i2] = str;
            String str3 = (String) next.getValue();
            if (str3 != null) {
                str2 = str3;
            }
            strArr2[i2] = str2;
            i2++;
        }
        return LogProducerResult.fromInt(log_producer_client_add_log_with_len(this.client, log.getLogTime(), size, strArr, strArr2, i));
    }

    public void setAddLogInterceptor(IAddLogInterceptor iAddLogInterceptor) {
        this.addLogInterceptor = iAddLogInterceptor;
    }

    public LogProducerResult addLogRaw(byte[][] bArr, byte[][] bArr2) {
        if (this.client == 0 || bArr == null || bArr2 == null) {
            return LogProducerResult.LOG_PRODUCER_INVALID;
        }
        return LogProducerResult.fromInt(log_producer_client_add_log_with_len_time_int32(this.client, new Log().getLogTime(), bArr.length, bArr, bArr2));
    }

    public void destroyLogProducer() {
        destroy_log_producer(this.producer);
    }
}
