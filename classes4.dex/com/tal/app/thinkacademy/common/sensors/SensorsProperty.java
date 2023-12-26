package com.tal.app.thinkacademy.common.sensors;

import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import com.tal.app.thinkacademy.common.utils.ChannelUtil;
import com.tal.app.thinkacademy.common.utils.LeanplumUtil;
import com.tal.app.thinkacademy.lib.util.DeviceUtils;
import com.tal.app.thinkacademy.lib.utils.TableUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0006\u0010\u0007\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\u0004J\u0006\u0010\n\u001a\u00020\u0004J\u0006\u0010\u000b\u001a\u00020\u0004J\u0006\u0010\f\u001a\u00020\u0004J\u0006\u0010\r\u001a\u00020\u0004¨\u0006\u000f"}, d2 = {"Lcom/tal/app/thinkacademy/common/sensors/SensorsProperty;", "", "()V", "addSourceTypeId", "", "jsonObject", "Lorg/json/JSONObject;", "dynamicSuperProperties", "login", "logout", "profileSet", "profileSetOnce", "superProperties", "trackAppInstall", "Companion", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SensorsProperty.kt */
public final class SensorsProperty {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TAG = "SensorsProperty";
    /* access modifiers changed from: private */
    public static final Lazy<SensorsProperty> instance$delegate = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, SensorsProperty$Companion$instance$2.INSTANCE);

    public static final SensorsProperty getInstance() {
        return Companion.getInstance();
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R!\u0010\u0005\u001a\u00020\u00068FX\u0002¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u0012\u0004\b\u0007\u0010\u0002\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/tal/app/thinkacademy/common/sensors/SensorsProperty$Companion;", "", "()V", "TAG", "", "instance", "Lcom/tal/app/thinkacademy/common/sensors/SensorsProperty;", "getInstance$annotations", "getInstance", "()Lcom/tal/app/thinkacademy/common/sensors/SensorsProperty;", "instance$delegate", "Lkotlin/Lazy;", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SensorsProperty.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getInstance$annotations() {
        }

        private Companion() {
        }

        public final SensorsProperty getInstance() {
            return (SensorsProperty) SensorsProperty.instance$delegate.getValue();
        }
    }

    public final void superProperties() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("event_belong", "海外学生端");
            jSONObject.put("hw_device_id", DeviceUtils.getUniqueDeviceId());
            jSONObject.put(LeanplumUtil.device_type, TableUtils.isTable() ? "Pad" : "Phone");
            jSONObject.put("hw_user_role", "student");
            SensorsDataAPI.sharedInstance().registerSuperProperties(jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void dynamicSuperProperties() {
        SensorsDataAPI.sharedInstance().registerDynamicSuperProperties(new SensorsProperty$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x002e A[Catch:{ Exception -> 0x00a3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x004d A[Catch:{ Exception -> 0x00a3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x006c A[Catch:{ Exception -> 0x00a3 }] */
    /* renamed from: dynamicSuperProperties$lambda-0  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final org.json.JSONObject m58dynamicSuperProperties$lambda0(com.tal.app.thinkacademy.common.sensors.SensorsProperty r7) {
        /*
            java.lang.String r0 = "school_code"
            java.lang.String r1 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r1)
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ Exception -> 0x00a3 }
            r1.<init>()     // Catch:{ Exception -> 0x00a3 }
            com.tal.app.thinkacademy.common.user.UserInfoBll$Companion r2 = com.tal.app.thinkacademy.common.user.UserInfoBll.Companion     // Catch:{ Exception -> 0x00a3 }
            com.tal.app.thinkacademy.common.user.UserInfoBll r2 = r2.getInstance()     // Catch:{ Exception -> 0x00a3 }
            com.tal.app.thinkacademy.common.user.UserInfo r2 = r2.getUserInfoEntity()     // Catch:{ Exception -> 0x00a3 }
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x0037
            java.lang.String r5 = r2.getUid()     // Catch:{ Exception -> 0x00a3 }
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5     // Catch:{ Exception -> 0x00a3 }
            if (r5 == 0) goto L_0x002b
            int r5 = r5.length()     // Catch:{ Exception -> 0x00a3 }
            if (r5 != 0) goto L_0x0029
            goto L_0x002b
        L_0x0029:
            r5 = r3
            goto L_0x002c
        L_0x002b:
            r5 = r4
        L_0x002c:
            if (r5 != 0) goto L_0x0037
            java.lang.String r5 = "hw_user_id"
            java.lang.String r6 = r2.getUid()     // Catch:{ Exception -> 0x00a3 }
            r1.put(r5, r6)     // Catch:{ Exception -> 0x00a3 }
        L_0x0037:
            if (r2 == 0) goto L_0x0056
            java.lang.String r5 = r2.getCard()     // Catch:{ Exception -> 0x00a3 }
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5     // Catch:{ Exception -> 0x00a3 }
            if (r5 == 0) goto L_0x004a
            int r5 = r5.length()     // Catch:{ Exception -> 0x00a3 }
            if (r5 != 0) goto L_0x0048
            goto L_0x004a
        L_0x0048:
            r5 = r3
            goto L_0x004b
        L_0x004a:
            r5 = r4
        L_0x004b:
            if (r5 != 0) goto L_0x0056
            java.lang.String r5 = "card"
            java.lang.String r6 = r2.getCard()     // Catch:{ Exception -> 0x00a3 }
            r1.put(r5, r6)     // Catch:{ Exception -> 0x00a3 }
        L_0x0056:
            if (r2 == 0) goto L_0x0075
            java.lang.String r5 = r2.getNickName()     // Catch:{ Exception -> 0x00a3 }
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5     // Catch:{ Exception -> 0x00a3 }
            if (r5 == 0) goto L_0x0069
            int r5 = r5.length()     // Catch:{ Exception -> 0x00a3 }
            if (r5 != 0) goto L_0x0067
            goto L_0x0069
        L_0x0067:
            r5 = r3
            goto L_0x006a
        L_0x0069:
            r5 = r4
        L_0x006a:
            if (r5 != 0) goto L_0x0075
            java.lang.String r5 = "nick_name"
            java.lang.String r2 = r2.getNickName()     // Catch:{ Exception -> 0x00a3 }
            r1.put(r5, r2)     // Catch:{ Exception -> 0x00a3 }
        L_0x0075:
            com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager r2 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.getInstance()     // Catch:{ Exception -> 0x00a3 }
            java.lang.String r5 = "未知"
            int r6 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.SHAREDATA_NOT_CLEAR     // Catch:{ Exception -> 0x00a3 }
            java.lang.String r2 = r2.getString(r0, r5, r6)     // Catch:{ Exception -> 0x00a3 }
            r1.put(r0, r2)     // Catch:{ Exception -> 0x00a3 }
            java.lang.String r0 = "is_login"
            com.tal.app.thinkacademy.common.user.UserInfoBll$Companion r2 = com.tal.app.thinkacademy.common.user.UserInfoBll.Companion     // Catch:{ Exception -> 0x00a3 }
            com.tal.app.thinkacademy.common.user.UserInfoBll r2 = r2.getInstance()     // Catch:{ Exception -> 0x00a3 }
            boolean r2 = r2.isGuest()     // Catch:{ Exception -> 0x00a3 }
            if (r2 != 0) goto L_0x0093
            r3 = r4
        L_0x0093:
            r1.put(r0, r3)     // Catch:{ Exception -> 0x00a3 }
            com.tal.app.thinkacademy.common.appmonitor.HWEventTracking$Companion r0 = com.tal.app.thinkacademy.common.appmonitor.HWEventTracking.Companion     // Catch:{ Exception -> 0x00a3 }
            com.tal.app.thinkacademy.common.appmonitor.HWEventTracking r0 = r0.get()     // Catch:{ Exception -> 0x00a3 }
            r0.setGlobalProperties(r1)     // Catch:{ Exception -> 0x00a3 }
            r7.addSourceTypeId(r1)     // Catch:{ Exception -> 0x00a3 }
            return r1
        L_0x00a3:
            r7 = move-exception
            r7.printStackTrace()
            r7 = 0
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.common.sensors.SensorsProperty.m58dynamicSuperProperties$lambda0(com.tal.app.thinkacademy.common.sensors.SensorsProperty):org.json.JSONObject");
    }

    public final void profileSetOnce() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("AppInstallChannel", ChannelUtil.INSTANCE.getChannel().getType());
            SensorsDataAPI.sharedInstance().profileSetOnce(jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0029 A[Catch:{ Exception -> 0x00b5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x003a A[Catch:{ Exception -> 0x00b5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0046 A[Catch:{ Exception -> 0x00b5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0057 A[Catch:{ Exception -> 0x00b5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0063 A[Catch:{ Exception -> 0x00b5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0082 A[SYNTHETIC, Splitter:B:39:0x0082] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x008a A[Catch:{ Exception -> 0x00b5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x009c A[Catch:{ Exception -> 0x00b5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00a1 A[Catch:{ Exception -> 0x00b5 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void profileSet() {
        /*
            r6 = this;
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x00b5 }
            r0.<init>()     // Catch:{ Exception -> 0x00b5 }
            com.tal.app.thinkacademy.common.user.UserInfoBll$Companion r1 = com.tal.app.thinkacademy.common.user.UserInfoBll.Companion     // Catch:{ Exception -> 0x00b5 }
            com.tal.app.thinkacademy.common.user.UserInfoBll r1 = r1.getInstance()     // Catch:{ Exception -> 0x00b5 }
            com.tal.app.thinkacademy.common.user.UserInfo r1 = r1.getUserInfoEntity()     // Catch:{ Exception -> 0x00b5 }
            if (r1 != 0) goto L_0x0013
            goto L_0x00b9
        L_0x0013:
            java.lang.String r2 = r1.getNickName()     // Catch:{ Exception -> 0x00b5 }
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ Exception -> 0x00b5 }
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x0026
            int r2 = r2.length()     // Catch:{ Exception -> 0x00b5 }
            if (r2 != 0) goto L_0x0024
            goto L_0x0026
        L_0x0024:
            r2 = r3
            goto L_0x0027
        L_0x0026:
            r2 = r4
        L_0x0027:
            if (r2 != 0) goto L_0x0032
            java.lang.String r2 = "nick_name"
            java.lang.String r5 = r1.getNickName()     // Catch:{ Exception -> 0x00b5 }
            r0.put(r2, r5)     // Catch:{ Exception -> 0x00b5 }
        L_0x0032:
            java.lang.String r2 = r1.getCountryCallingCode()     // Catch:{ Exception -> 0x00b5 }
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ Exception -> 0x00b5 }
            if (r2 == 0) goto L_0x0043
            int r2 = r2.length()     // Catch:{ Exception -> 0x00b5 }
            if (r2 != 0) goto L_0x0041
            goto L_0x0043
        L_0x0041:
            r2 = r3
            goto L_0x0044
        L_0x0043:
            r2 = r4
        L_0x0044:
            if (r2 != 0) goto L_0x004f
            java.lang.String r2 = "country_calling_code"
            java.lang.String r5 = r1.getCountryCallingCode()     // Catch:{ Exception -> 0x00b5 }
            r0.put(r2, r5)     // Catch:{ Exception -> 0x00b5 }
        L_0x004f:
            java.lang.String r2 = r1.getCard()     // Catch:{ Exception -> 0x00b5 }
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ Exception -> 0x00b5 }
            if (r2 == 0) goto L_0x0060
            int r2 = r2.length()     // Catch:{ Exception -> 0x00b5 }
            if (r2 != 0) goto L_0x005e
            goto L_0x0060
        L_0x005e:
            r2 = r3
            goto L_0x0061
        L_0x0060:
            r2 = r4
        L_0x0061:
            if (r2 != 0) goto L_0x006c
            java.lang.String r2 = "card"
            java.lang.String r5 = r1.getCard()     // Catch:{ Exception -> 0x00b5 }
            r0.put(r2, r5)     // Catch:{ Exception -> 0x00b5 }
        L_0x006c:
            java.lang.String r2 = r1.getUid()     // Catch:{ Exception -> 0x00b5 }
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ Exception -> 0x00b5 }
            if (r2 == 0) goto L_0x007d
            int r2 = r2.length()     // Catch:{ Exception -> 0x00b5 }
            if (r2 != 0) goto L_0x007b
            goto L_0x007d
        L_0x007b:
            r2 = r3
            goto L_0x007e
        L_0x007d:
            r2 = r4
        L_0x007e:
            java.lang.String r5 = "hw_user_id"
            if (r2 != 0) goto L_0x008a
            java.lang.String r1 = r1.getUid()     // Catch:{ Exception -> 0x00b5 }
            r0.put(r5, r1)     // Catch:{ Exception -> 0x00b5 }
            goto L_0x008f
        L_0x008a:
            java.lang.String r1 = "未登录"
            r0.put(r5, r1)     // Catch:{ Exception -> 0x00b5 }
        L_0x008f:
            java.lang.String r1 = "SensorsProperty"
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x00b5 }
            java.lang.String r5 = "用户属性={}"
            r2[r3] = r5     // Catch:{ Exception -> 0x00b5 }
            boolean r3 = r0 instanceof org.json.JSONObject     // Catch:{ Exception -> 0x00b5 }
            if (r3 != 0) goto L_0x00a1
            java.lang.String r3 = r0.toString()     // Catch:{ Exception -> 0x00b5 }
            goto L_0x00a8
        L_0x00a1:
            r3 = r0
            org.json.JSONObject r3 = (org.json.JSONObject) r3     // Catch:{ Exception -> 0x00b5 }
            java.lang.String r3 = com.bonree.sdk.agent.engine.external.JSONObjectInstrumentation.toString(r3)     // Catch:{ Exception -> 0x00b5 }
        L_0x00a8:
            r2[r4] = r3     // Catch:{ Exception -> 0x00b5 }
            com.tal.app.thinkacademy.lib.logger.XesLog.it(r1, r2)     // Catch:{ Exception -> 0x00b5 }
            com.sensorsdata.analytics.android.sdk.SensorsDataAPI r1 = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance()     // Catch:{ Exception -> 0x00b5 }
            r1.profileSet(r0)     // Catch:{ Exception -> 0x00b5 }
            goto L_0x00b9
        L_0x00b5:
            r0 = move-exception
            r0.printStackTrace()
        L_0x00b9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.common.sensors.SensorsProperty.profileSet():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0020 A[Catch:{ Exception -> 0x002c }] */
    /* JADX WARNING: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void login() {
        /*
            r2 = this;
            com.tal.app.thinkacademy.common.user.UserInfoBll$Companion r0 = com.tal.app.thinkacademy.common.user.UserInfoBll.Companion     // Catch:{ Exception -> 0x002c }
            com.tal.app.thinkacademy.common.user.UserInfoBll r0 = r0.getInstance()     // Catch:{ Exception -> 0x002c }
            com.tal.app.thinkacademy.common.user.UserInfo r0 = r0.getUserInfoEntity()     // Catch:{ Exception -> 0x002c }
            if (r0 == 0) goto L_0x0030
            java.lang.String r1 = r0.getUid()     // Catch:{ Exception -> 0x002c }
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch:{ Exception -> 0x002c }
            if (r1 == 0) goto L_0x001d
            int r1 = r1.length()     // Catch:{ Exception -> 0x002c }
            if (r1 != 0) goto L_0x001b
            goto L_0x001d
        L_0x001b:
            r1 = 0
            goto L_0x001e
        L_0x001d:
            r1 = 1
        L_0x001e:
            if (r1 != 0) goto L_0x0030
            com.sensorsdata.analytics.android.sdk.SensorsDataAPI r1 = com.sensorsdata.analytics.android.sdk.SensorsDataAPI.sharedInstance()     // Catch:{ Exception -> 0x002c }
            java.lang.String r0 = r0.getUid()     // Catch:{ Exception -> 0x002c }
            r1.login(r0)     // Catch:{ Exception -> 0x002c }
            goto L_0x0030
        L_0x002c:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0030:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.common.sensors.SensorsProperty.login():void");
    }

    public final void logout() {
        try {
            SensorsDataAPI.sharedInstance().logout();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final void addSourceTypeId(JSONObject jSONObject) {
        ChannelUtil.ChannelType channel = ChannelUtil.INSTANCE.getChannel();
        jSONObject.put("source_id", channel.getId());
        jSONObject.put("source_name", channel.getType());
    }

    public final void trackAppInstall() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("DownloadChannel", ChannelUtil.INSTANCE.getChannel().getType());
            SensorsDataAPI.sharedInstance().trackAppInstall(jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
