package com.tal.app.thinkacademy.common.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Build;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00152\u00020\u0001:\u0002\u0015\u0016B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\f\u001a\u00020\nJ)\u0010\r\u001a\u00020\u000e2!\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u000e0\u0010J\u0006\u0010\u0014\u001a\u00020\u000eR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0018\u00010\bR\u00020\u0000X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/tal/app/thinkacademy/common/utils/VolumeChangeHelper;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "audioManager", "Landroid/media/AudioManager;", "mVolumeBroadCastReceiver", "Lcom/tal/app/thinkacademy/common/utils/VolumeChangeHelper$VolumeBroadCastReceiver;", "getCurrentVolume", "", "getMaxVolume", "getMinVolume", "registerVolumeChangeListener", "", "block", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "current", "unregisterReceiver", "Companion", "VolumeBroadCastReceiver", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VolumeChangeHelper.kt */
public final class VolumeChangeHelper {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String EXTRA_VOLUME_STREAM_TYPE = "android.media.EXTRA_VOLUME_STREAM_TYPE";
    public static final String EXTRA_VOLUME_STREAM_VALUE = "android.media.EXTRA_VOLUME_STREAM_VALUE";
    public static final String TAG = "VolumeChangeHelper";
    public static final String VOLUME_CHANGE_ACTION = "android.media.VOLUME_CHANGED_ACTION";
    private AudioManager audioManager;
    private final Context context;
    private VolumeBroadCastReceiver mVolumeBroadCastReceiver;

    public VolumeChangeHelper(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
        Object systemService = context2.getSystemService("audio");
        this.audioManager = systemService instanceof AudioManager ? (AudioManager) systemService : null;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/tal/app/thinkacademy/common/utils/VolumeChangeHelper$Companion;", "", "()V", "EXTRA_VOLUME_STREAM_TYPE", "", "EXTRA_VOLUME_STREAM_VALUE", "TAG", "VOLUME_CHANGE_ACTION", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: VolumeChangeHelper.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final int getCurrentVolume() {
        try {
            AudioManager audioManager2 = this.audioManager;
            if (audioManager2 == null) {
                return -1;
            }
            return audioManager2.getStreamVolume(3);
        } catch (Exception e) {
            XesLog.et(TAG, Intrinsics.stringPlus("getCurrentVolume出错=", e));
            return 0;
        }
    }

    public final int getMaxVolume() {
        try {
            AudioManager audioManager2 = this.audioManager;
            if (audioManager2 == null) {
                return -1;
            }
            return audioManager2.getStreamMaxVolume(3);
        } catch (Exception e) {
            XesLog.et(TAG, Intrinsics.stringPlus("getCurrentVolume 出错=", e));
            return -1;
        }
    }

    public final int getMinVolume() {
        if (Build.VERSION.SDK_INT < 28) {
            return 0;
        }
        try {
            AudioManager audioManager2 = this.audioManager;
            if (audioManager2 == null) {
                return 0;
            }
            return audioManager2.getStreamMinVolume(3);
        } catch (Exception e) {
            XesLog.et(TAG, Intrinsics.stringPlus("getMinVolume 出错=", e));
            return 0;
        }
    }

    public final void registerVolumeChangeListener(Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        this.mVolumeBroadCastReceiver = new VolumeBroadCastReceiver(this, function1);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(VOLUME_CHANGE_ACTION);
        VolumeBroadCastReceiver volumeBroadCastReceiver = this.mVolumeBroadCastReceiver;
        if (volumeBroadCastReceiver != null) {
            this.context.registerReceiver(volumeBroadCastReceiver, intentFilter);
        }
    }

    public final void unregisterReceiver() {
        VolumeBroadCastReceiver volumeBroadCastReceiver = this.mVolumeBroadCastReceiver;
        if (volumeBroadCastReceiver != null) {
            this.context.unregisterReceiver(volumeBroadCastReceiver);
        }
        this.mVolumeBroadCastReceiver = null;
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\u0006J\u001c\u0010\u0007\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/tal/app/thinkacademy/common/utils/VolumeChangeHelper$VolumeBroadCastReceiver;", "Landroid/content/BroadcastReceiver;", "block", "Lkotlin/Function1;", "", "", "(Lcom/tal/app/thinkacademy/common/utils/VolumeChangeHelper;Lkotlin/jvm/functions/Function1;)V", "onReceive", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: VolumeChangeHelper.kt */
    private final class VolumeBroadCastReceiver extends BroadcastReceiver {
        private final Function1<Integer, Unit> block;
        final /* synthetic */ VolumeChangeHelper this$0;

        public VolumeBroadCastReceiver(VolumeChangeHelper volumeChangeHelper, Function1<? super Integer, Unit> function1) {
            Intrinsics.checkNotNullParameter(volumeChangeHelper, "this$0");
            Intrinsics.checkNotNullParameter(function1, "block");
            this.this$0 = volumeChangeHelper;
            this.block = function1;
        }

        public void onReceive(Context context, Intent intent) {
            PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
            if (intent != null && Intrinsics.areEqual(intent.getAction(), VolumeChangeHelper.VOLUME_CHANGE_ACTION) && intent.getIntExtra(VolumeChangeHelper.EXTRA_VOLUME_STREAM_TYPE, -1) == 3) {
                this.block.invoke(Integer.valueOf(intent.getIntExtra(VolumeChangeHelper.EXTRA_VOLUME_STREAM_VALUE, -1)));
            }
        }
    }
}
