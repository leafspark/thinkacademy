package com.tal.app.thinkacademy.live.business.redpackagerain.util;

import android.os.SystemClock;
import com.tal.app.thinkacademy.common.sensors.HwTrackUtil;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.live.Tag;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001f\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u000fJ\u0006\u0010\u0010\u001a\u00020\fJ\u0006\u0010\u0011\u001a\u00020\fJ\u0006\u0010\u0012\u001a\u00020\fJ\u001f\u0010\u0013\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u000fJ\u000e\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0016R\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0004\n\u0002\u0010\u0005R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0004\n\u0002\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/redpackagerain/util/RedPackageRainTrackUtil;", "", "()V", "mIsLocal", "", "Ljava/lang/Boolean;", "mStartLoadTime", "", "Ljava/lang/Long;", "mUrl", "", "loadRedPackageRain", "", "url", "isLocal", "(Ljava/lang/String;Ljava/lang/Boolean;)V", "loadRedPackageRainFail", "loadRedPackageRainSuccess", "loadRedPackageRainTimeout", "reLoadRedPackageRain", "redPackageRainDeviceLevel", "device_level", "", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RedPackageRainTrackUtil.kt */
public final class RedPackageRainTrackUtil {
    public static final RedPackageRainTrackUtil INSTANCE = new RedPackageRainTrackUtil();
    private static Boolean mIsLocal;
    private static Long mStartLoadTime;
    private static String mUrl;

    private RedPackageRainTrackUtil() {
    }

    public final void loadRedPackageRain(String str, Boolean bool) {
        mUrl = str;
        mIsLocal = bool;
        mStartLoadTime = Long.valueOf(SystemClock.elapsedRealtime());
        try {
            JSONObject jSONObject = new JSONObject();
            String str2 = mUrl;
            if (str2 != null) {
                jSONObject.put("url", str2);
            }
            Boolean bool2 = mIsLocal;
            if (bool2 != null) {
                jSONObject.put("is_local", bool2.booleanValue());
            }
            jSONObject.put("result", "start");
            HwTrackUtil.INSTANCE.track("hw_red_package_rain_load", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void reLoadRedPackageRain(String str, Boolean bool) {
        mUrl = str;
        mIsLocal = bool;
        mStartLoadTime = Long.valueOf(SystemClock.elapsedRealtime());
        try {
            JSONObject jSONObject = new JSONObject();
            String str2 = mUrl;
            if (str2 != null) {
                jSONObject.put("url", str2);
            }
            Boolean bool2 = mIsLocal;
            if (bool2 != null) {
                jSONObject.put("is_local", bool2.booleanValue());
            }
            jSONObject.put("result", "restart");
            HwTrackUtil.INSTANCE.track("hw_red_package_rain_load", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void loadRedPackageRainSuccess() {
        try {
            JSONObject jSONObject = new JSONObject();
            String str = mUrl;
            if (str != null) {
                jSONObject.put("url", str);
            }
            Boolean bool = mIsLocal;
            if (bool != null) {
                jSONObject.put("is_local", bool.booleanValue());
            }
            Long l = mStartLoadTime;
            if (l != null) {
                long elapsedRealtime = SystemClock.elapsedRealtime() - l.longValue();
                jSONObject.put("load_duration", elapsedRealtime);
                XesLog.i(Tag.RED_PACKAGE_RAIN, "红包雨加载耗时：" + elapsedRealtime + "毫秒");
            }
            jSONObject.put("result", "success");
            HwTrackUtil.INSTANCE.track("hw_red_package_rain_load", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void loadRedPackageRainFail() {
        try {
            JSONObject jSONObject = new JSONObject();
            String str = mUrl;
            if (str != null) {
                jSONObject.put("url", str);
            }
            Boolean bool = mIsLocal;
            if (bool != null) {
                jSONObject.put("is_local", bool.booleanValue());
            }
            jSONObject.put("result", "fail");
            HwTrackUtil.INSTANCE.track("hw_red_package_rain_load", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void loadRedPackageRainTimeout() {
        try {
            JSONObject jSONObject = new JSONObject();
            String str = mUrl;
            if (str != null) {
                jSONObject.put("url", str);
            }
            Boolean bool = mIsLocal;
            if (bool != null) {
                jSONObject.put("is_local", bool.booleanValue());
            }
            jSONObject.put("result", "timeout");
            HwTrackUtil.INSTANCE.track("hw_red_package_rain_load", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void redPackageRainDeviceLevel(int i) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("device_level", i);
            HwTrackUtil.INSTANCE.track("hw_red_package_rain_device_level", jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
