package com.aliyun.sls.android.producer;

import android.content.Context;
import android.text.TextUtils;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import com.aliyun.sls.android.producer.utils.SoLoader;
import com.aliyun.sls.android.producer.utils.TimeUtils;

public class LogProducerConfig {
    private static boolean hasSoLoaded = false;
    private final long config;
    private final Context context;
    private String endpoint;
    private String logstore;
    private String project;

    private static native long create_log_producer_config();

    private static native void log_producer_config_add_tag(long j, String str, String str2);

    private static native int log_producer_config_is_valid(long j);

    private static native void log_producer_config_reset_security_token(long j, String str, String str2, String str3);

    private static native void log_producer_config_set_access_id(long j, String str);

    private static native void log_producer_config_set_access_key(long j, String str);

    private static native void log_producer_config_set_compress_type(long j, int i);

    private static native void log_producer_config_set_connect_timeout_sec(long j, int i);

    private static native void log_producer_config_set_destroy_flusher_wait_sec(long j, int i);

    private static native void log_producer_config_set_destroy_sender_wait_sec(long j, int i);

    private static native void log_producer_config_set_drop_delay_log(long j, int i);

    private static native void log_producer_config_set_drop_unauthorized_log(long j, int i);

    private static native void log_producer_config_set_endpoint(long j, String str);

    private static native void log_producer_config_set_get_time_unix_func(LogProducerTimeUnixFunc logProducerTimeUnixFunc);

    private static native void log_producer_config_set_logstore(long j, String str);

    private static native void log_producer_config_set_max_buffer_limit(long j, int i);

    private static native void log_producer_config_set_max_log_delay_time(long j, int i);

    private static native void log_producer_config_set_net_interface(long j, String str);

    private static native void log_producer_config_set_ntp_time_offset(long j, int i);

    private static native void log_producer_config_set_packet_log_bytes(long j, int i);

    private static native void log_producer_config_set_packet_log_count(long j, int i);

    private static native void log_producer_config_set_packet_timeout(long j, int i);

    private static native void log_producer_config_set_persistent(long j, int i);

    private static native void log_producer_config_set_persistent_file_path(long j, String str);

    private static native void log_producer_config_set_persistent_force_flush(long j, int i);

    private static native void log_producer_config_set_persistent_max_file_count(long j, int i);

    private static native void log_producer_config_set_persistent_max_file_size(long j, int i);

    private static native void log_producer_config_set_persistent_max_log_count(long j, int i);

    private static native void log_producer_config_set_project(long j, String str);

    private static native void log_producer_config_set_send_thread_count(long j, int i);

    private static native void log_producer_config_set_send_timeout_sec(long j, int i);

    private static native void log_producer_config_set_source(long j, String str);

    private static native void log_producer_config_set_topic(long j, String str);

    private static native void log_producer_config_set_using_http(long j, int i);

    private static native void log_producer_debug();

    private static native int log_producer_persistent_config_is_enabled(long j);

    @Deprecated
    public LogProducerConfig(String str, String str2, String str3, String str4, String str5) throws LogProducerException {
        this(str, str2, str3, str4, str5, (String) null);
    }

    @Deprecated
    public LogProducerConfig(String str, String str2, String str3, String str4, String str5, String str6) throws LogProducerException {
        this((Context) null, str, str2, str3, str4, str5, str6);
    }

    public LogProducerConfig(Context context2, String str, String str2, String str3) throws LogProducerException {
        this(context2, str, str2, str3, (String) null, (String) null);
    }

    public LogProducerConfig(Context context2, String str, String str2, String str3, String str4, String str5) throws LogProducerException {
        this(context2, str, str2, str3, str4, str5, (String) null);
    }

    public LogProducerConfig(Context context2, String str, String str2, String str3, String str4, String str5, String str6) throws LogProducerException {
        if (!hasSoLoaded) {
            SoLoader.instance().loadLibrary(context2, "sls_producer");
            hasSoLoaded = true;
        }
        this.context = context2;
        long create_log_producer_config = create_log_producer_config();
        this.config = create_log_producer_config;
        if (create_log_producer_config != 0) {
            setSource("Android");
            setPacketTimeout(PathInterpolatorCompat.MAX_NUM_POINTS);
            setPacketLogCount(1024);
            setPacketLogBytes(1048576);
            setSendThreadCount(1);
            setDropUnauthorizedLog(0);
            setDropDelayLog(0);
            setGetTimeUnixFunc(new LogProducerTimeUnixFunc() {
                public long getTimeUnix() {
                    return TimeUtils.getTimeInMillis();
                }
            });
            setEndpoint(str);
            setProject(str2);
            setLogstore(str3);
            setAccessKeyId(str4);
            setAccessKeySecret(str5);
            if (!TextUtils.isEmpty(str6)) {
                resetSecurityToken(str4, str5, str6);
                return;
            }
            return;
        }
        throw new LogProducerException("Can not create log producer config");
    }

    public Context getContext() {
        return this.context;
    }

    public void setEndpoint(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "please_set_endpoint";
        }
        this.endpoint = str;
        log_producer_config_set_endpoint(this.config, str);
    }

    public String getEndpoint() {
        return this.endpoint;
    }

    public void setProject(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "please_set_project";
        }
        this.project = str;
        log_producer_config_set_project(this.config, str);
    }

    public String getProject() {
        return this.project;
    }

    public void setLogstore(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "please_set_logstore";
        }
        this.logstore = str;
        log_producer_config_set_logstore(this.config, str);
    }

    public String getLogstore() {
        return this.logstore;
    }

    public void setTopic(String str) {
        log_producer_config_set_topic(this.config, str);
    }

    public void addTag(String str, String str2) {
        log_producer_config_add_tag(this.config, str, str2);
    }

    public void setAccessKeyId(String str) {
        log_producer_config_set_access_id(this.config, str);
    }

    public void setAccessKeySecret(String str) {
        log_producer_config_set_access_key(this.config, str);
    }

    public void setPacketLogBytes(int i) {
        log_producer_config_set_packet_log_bytes(this.config, i);
    }

    public void setPacketLogCount(int i) {
        log_producer_config_set_packet_log_count(this.config, i);
    }

    public void setPacketTimeout(int i) {
        log_producer_config_set_packet_timeout(this.config, i);
    }

    public void setMaxBufferLimit(int i) {
        log_producer_config_set_max_buffer_limit(this.config, i);
    }

    public void setSendThreadCount(int i) {
        log_producer_config_set_send_thread_count(this.config, i);
    }

    public void setPersistent(int i) {
        log_producer_config_set_persistent(this.config, i);
    }

    public void setPersistentFilePath(String str) {
        log_producer_config_set_persistent_file_path(this.config, str);
    }

    public void setPersistentForceFlush(int i) {
        log_producer_config_set_persistent_force_flush(this.config, i);
    }

    public void setPersistentMaxFileCount(int i) {
        log_producer_config_set_persistent_max_file_count(this.config, i);
    }

    public void setPersistentMaxFileSize(int i) {
        log_producer_config_set_persistent_max_file_size(this.config, i);
    }

    public void setPersistentMaxLogCount(int i) {
        log_producer_config_set_persistent_max_log_count(this.config, i);
    }

    public void setUsingHttp(int i) {
        log_producer_config_set_using_http(this.config, i);
    }

    public void setNetInterface(String str) {
        log_producer_config_set_net_interface(this.config, str);
    }

    public void setConnectTimeoutSec(int i) {
        log_producer_config_set_connect_timeout_sec(this.config, i);
    }

    public void setSendTimeoutSec(int i) {
        log_producer_config_set_send_timeout_sec(this.config, i);
    }

    public void setDestroyFlusherWaitSec(int i) {
        log_producer_config_set_destroy_flusher_wait_sec(this.config, i);
    }

    public void setDestroySenderWaitSec(int i) {
        log_producer_config_set_destroy_sender_wait_sec(this.config, i);
    }

    public void setCompressType(int i) {
        log_producer_config_set_compress_type(this.config, i);
    }

    public void setNtpTimeOffset(int i) {
        log_producer_config_set_ntp_time_offset(this.config, i);
    }

    public void setMaxLogDelayTime(int i) {
        log_producer_config_set_max_log_delay_time(this.config, i);
    }

    public void setDropDelayLog(int i) {
        log_producer_config_set_drop_delay_log(this.config, i);
    }

    public void setDropUnauthorizedLog(int i) {
        log_producer_config_set_drop_unauthorized_log(this.config, i);
    }

    public void setGetTimeUnixFunc(LogProducerTimeUnixFunc logProducerTimeUnixFunc) {
        log_producer_config_set_get_time_unix_func(logProducerTimeUnixFunc);
    }

    public void setSource(String str) {
        log_producer_config_set_source(this.config, str);
    }

    public void resetSecurityToken(String str, String str2, String str3) {
        log_producer_config_reset_security_token(this.config, str, str2, str3);
    }

    public void logProducerDebug() {
        log_producer_debug();
    }

    /* access modifiers changed from: package-private */
    public long getConfig() {
        return this.config;
    }

    public int isValid() {
        return log_producer_config_is_valid(this.config);
    }

    public int isEnabled() {
        return log_producer_persistent_config_is_enabled(this.config);
    }
}
