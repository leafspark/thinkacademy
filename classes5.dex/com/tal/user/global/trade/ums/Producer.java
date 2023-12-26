package com.tal.user.global.trade.ums;

import android.content.Context;
import android.os.Build;
import com.aliyun.sls.android.producer.Log;
import com.aliyun.sls.android.producer.LogProducerClient;
import com.aliyun.sls.android.producer.LogProducerConfig;
import com.aliyun.sls.android.producer.LogProducerException;
import com.aliyun.sls.android.producer.LogProducerResult;
import com.tal.user.global.trade.BuildConfig;
import com.tal.user.global.trade.api.TalTradeSdk;
import com.tal.user.global.trade.util.TalDeviceUtils;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kbuild.autoconf;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0004J(\u0010\u0013\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015J\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0004J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0004R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u001b"}, d2 = {"Lcom/tal/user/global/trade/ums/Producer;", "", "()V", "orderNo", "", "getOrderNo", "()Ljava/lang/String;", "setOrderNo", "(Ljava/lang/String;)V", "commentLogContent", "", "log", "Lcom/aliyun/sls/android/producer/Log;", "initProducer", "mContext", "Landroid/content/Context;", "oneClickLog", "Lcom/aliyun/sls/android/producer/LogProducerResult;", "eventId", "onePvLog", "start", "", "duration", "end", "oneSDKLog", "eventValue", "oneSystemLog", "android_taltradeglobal_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: Producer.kt */
public final class Producer {
    public static final Producer INSTANCE = new Producer();
    private static String orderNo = "";

    private Producer() {
    }

    public final void initProducer(Context context) {
        Intrinsics.checkNotNullParameter(context, "mContext");
        try {
            LogProducerConfig logProducerConfig = new LogProducerConfig(context, "https://us-west-1.log.aliyuncs.com", "pa-web", TalTradeSdk.Companion.getInstance().getConfig().isDebug() ? "pa-pay-sdk-android-test" : "pa-pay-sdk-android-prod", "LTAI5tAuL8dp3jVAoeyTJRza", "Eaqls0WZFOvZXlxzEbzPXeBm8tgkfF");
            logProducerConfig.setTopic("tal_topic");
            logProducerConfig.addTag("tal", "talglobal_trade");
            logProducerConfig.setPacketLogBytes(1048576);
            logProducerConfig.setPacketLogCount(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            logProducerConfig.setPacketTimeout(3000);
            logProducerConfig.setMaxBufferLimit(67108864);
            logProducerConfig.setSendThreadCount(1);
            logProducerConfig.setConnectTimeoutSec(10);
            logProducerConfig.setSendTimeoutSec(10);
            logProducerConfig.setDestroyFlusherWaitSec(2);
            logProducerConfig.setDestroySenderWaitSec(2);
            logProducerConfig.setCompressType(1);
            logProducerConfig.setNtpTimeOffset(3);
            logProducerConfig.setMaxLogDelayTime(604800);
            logProducerConfig.setDropDelayLog(0);
            logProducerConfig.setDropUnauthorizedLog(0);
            logProducerConfig.setPersistent(1);
            logProducerConfig.setPersistentFilePath(context.getFilesDir() + String.format("%slog_data.dat", new Object[]{File.separator}));
            logProducerConfig.setPersistentForceFlush(0);
            logProducerConfig.setPersistentMaxFileCount(10);
            logProducerConfig.setPersistentMaxFileSize(1048576);
            logProducerConfig.setPersistentMaxLogCount(WXMediaMessage.THUMB_LENGTH_LIMIT);
            ProducerKt.client = new LogProducerClient(logProducerConfig, Producer$initProducer$callback$1.INSTANCE);
        } catch (LogProducerException e) {
            e.printStackTrace();
        }
    }

    public final LogProducerResult oneSDKLog(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "eventId");
        Intrinsics.checkNotNullParameter(str2, "eventValue");
        Log log = new Log();
        log.putContent("label", "TALGlobalTradeSDK");
        log.putContent("eventType", "sdklog");
        log.putContent("eventId", str);
        log.putContent("eventValue", str2);
        commentLogContent(log);
        LogProducerClient access$getClient$p = ProducerKt.client;
        if (access$getClient$p != null) {
            return access$getClient$p.addLog(log, 1);
        }
        return null;
    }

    public final LogProducerResult oneSystemLog(String str) {
        Intrinsics.checkNotNullParameter(str, "eventId");
        Log log = new Log();
        log.putContent("label", "TALGlobalTradeSDK");
        log.putContent("eventType", "system");
        log.putContent("eventId", str);
        commentLogContent(log);
        LogProducerClient access$getClient$p = ProducerKt.client;
        if (access$getClient$p != null) {
            return access$getClient$p.addLog(log, 1);
        }
        return null;
    }

    public final LogProducerResult oneClickLog(String str) {
        Intrinsics.checkNotNullParameter(str, "eventId");
        Log log = new Log();
        log.putContent("label", "TALGlobalTradeSDK");
        log.putContent("eventType", "click");
        log.putContent("eventId", str);
        commentLogContent(log);
        LogProducerClient access$getClient$p = ProducerKt.client;
        if (access$getClient$p != null) {
            return access$getClient$p.addLog(log, 1);
        }
        return null;
    }

    public final LogProducerResult onePvLog(String str, long j, long j2, long j3) {
        Intrinsics.checkNotNullParameter(str, "eventId");
        Log log = new Log();
        log.putContent("label", "TALGlobalTradeSDK");
        log.putContent("eventType", "pv");
        log.putContent("eventId", str);
        log.putContent("start", String.valueOf(j));
        log.putContent("duration", String.valueOf(j2));
        log.putContent("end", String.valueOf(j3));
        commentLogContent(log);
        LogProducerClient access$getClient$p = ProducerKt.client;
        if (access$getClient$p != null) {
            return access$getClient$p.addLog(log, 1);
        }
        return null;
    }

    public final String getOrderNo() {
        return orderNo;
    }

    public final void setOrderNo(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        orderNo = str;
    }

    public final void commentLogContent(Log log) {
        Intrinsics.checkNotNullParameter(log, "log");
        log.putContent("orderNo", orderNo);
        log.putContent("app_version", TalDeviceUtils.getVersionName(TalTradeSdk.Companion.getInstance().getApplication()));
        log.putContent("sdk_version", BuildConfig.VERSION_NAME);
        log.putContent("system_name", autoconf.jvCONFIG_USERLAND_NAME);
        log.putContent("model_name", TalDeviceUtils.getDeviceName());
        String str = "";
        log.putContent("model_version", Build.VERSION.RELEASE == null ? str : Build.VERSION.RELEASE);
        log.putContent("model_api_version", String.valueOf(Build.VERSION.SDK_INT));
        if (Build.PRODUCT != null) {
            str = Build.PRODUCT;
        }
        log.putContent("model_product", str);
        long currentTimeMillis = System.currentTimeMillis();
        log.putContent("timestamp", String.valueOf(currentTimeMillis));
        log.putContent("date", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(new Date(currentTimeMillis)));
        log.putContent("package-name", TalTradeSdk.Companion.getInstance().getPackageName());
    }
}
