package com.tal.app.thinkacademy.business.login.view.devicetest.driver;

import android.content.Context;
import android.view.SurfaceView;
import com.tal.app.thinkacademy.business.login.entity.DeviceTestResult;
import com.tal.app.thinkacademy.business.login.entity.NetTestBean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0005H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u0003H&J\b\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\u000eH&JU\u0010\u000f\u001a\u00020\u00032K\u0010\u0004\u001aG\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00030\u0010H&J\u001a\u0010\u0017\u001a\u00020\u00112\b\b\u0001\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u0011H&J$\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001c2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00030\u0005H&J\b\u0010\u001e\u001a\u00020\u0003H&J\u001e\u0010\u001f\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010 \u0012\u0004\u0012\u00020\u00030\u0005H&J\u001c\u0010!\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u00030\u0005H&J\b\u0010#\u001a\u00020\u0003H&J\u0010\u0010$\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u0011H&J\b\u0010&\u001a\u00020\u0003H&¨\u0006'"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/view/devicetest/driver/DeviceTestDriverOwner;", "", "addNetCallback", "", "block", "Lkotlin/Function1;", "Lcom/tal/app/thinkacademy/business/login/entity/NetTestBean;", "checkDownloadNet", "checkIrcNet", "checkRtcNet", "checkServerNet", "getContext", "Landroid/content/Context;", "getDeviceTestResult", "Lcom/tal/app/thinkacademy/business/login/entity/DeviceTestResult;", "obtainSystemMediaVoiceSize", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "current", "max", "min", "playVoice", "id", "repeatCount", "requestPermission", "permission", "", "", "saveStateAndToSystemSettings", "startCameraPreview", "Landroid/view/SurfaceView;", "startRecord", "", "stopCameraPreview", "stopPlayVoice", "soundId", "stopRecord", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DeviceTestDriverOwner.kt */
public interface DeviceTestDriverOwner {
    void addNetCallback(Function1<? super NetTestBean, Unit> function1);

    void checkDownloadNet();

    void checkIrcNet();

    void checkRtcNet();

    void checkServerNet();

    Context getContext();

    DeviceTestResult getDeviceTestResult();

    void obtainSystemMediaVoiceSize(Function3<? super Integer, ? super Integer, ? super Integer, Unit> function3);

    int playVoice(int i, int i2);

    void requestPermission(String str, Function1<? super Boolean, Unit> function1);

    void saveStateAndToSystemSettings();

    void startCameraPreview(Function1<? super SurfaceView, Unit> function1);

    void startRecord(Function1<? super Double, Unit> function1);

    void stopCameraPreview();

    void stopPlayVoice(int i);

    void stopRecord();
}
