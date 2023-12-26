package com.tal.app.thinkacademy.common.network.interceptor;

import android.text.TextUtils;
import com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager;
import com.tal.app.thinkacademy.common.network.CommonHeader;
import com.tal.app.thinkacademy.common.user.UserInfo;
import com.tal.app.thinkacademy.common.user.UserInfoBll;
import com.tal.app.thinkacademy.common.utils.LeanplumUtil;
import com.tal.app.thinkacademy.common.utils.TimeZoneUtil;
import com.tal.app.thinkacademy.common.utils.UUIDUtil;
import com.tal.app.thinkacademy.lib.util.AppUtils;
import com.tal.app.thinkacademy.lib.util.DeviceUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/tal/app/thinkacademy/common/network/interceptor/CommonHeaderInterceptor;", "Lokhttp3/Interceptor;", "()V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CommonHeaderInterceptor.kt */
public final class CommonHeaderInterceptor implements Interceptor {
    public Response intercept(Interceptor.Chain chain) {
        String unifiedAccessToken;
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request.Builder newBuilder = chain.request().newBuilder();
        CharSequence charSequence = chain.request().headers().get("schoolCode");
        if (charSequence == null || charSequence.length() == 0) {
            String string = ShareDataManager.getInstance().getString("school_code", "415", ShareDataManager.SHAREDATA_NOT_CLEAR);
            Intrinsics.checkNotNullExpressionValue(string, "getInstance().getString(…ager.SHAREDATA_NOT_CLEAR)");
            newBuilder.addHeader("schoolCode", string);
        }
        newBuilder.addHeader("clientType", CommonHeader.INSTANCE.clientType());
        UserInfo userInfoEntity = UserInfoBll.Companion.getInstance().getUserInfoEntity();
        String str = "";
        if (!(userInfoEntity == null || (unifiedAccessToken = userInfoEntity.getUnifiedAccessToken()) == null)) {
            str = unifiedAccessToken;
        }
        newBuilder.addHeader("Authorization", str);
        String appVersionName = AppUtils.getAppVersionName();
        Intrinsics.checkNotNullExpressionValue(appVersionName, "getAppVersionName()");
        newBuilder.addHeader("appVersion", appVersionName);
        newBuilder.addHeader("appName", "Think Collage");
        newBuilder.addHeader("x-tal-trace-id", UUIDUtil.INSTANCE.getUUID());
        newBuilder.addHeader(LeanplumUtil.platform, "android");
        String model = DeviceUtils.getModel();
        Intrinsics.checkNotNullExpressionValue(model, "getModel()");
        newBuilder.addHeader("deviceName", model);
        newBuilder.addHeader("systemVersion", String.valueOf(DeviceUtils.getSDKVersionCode()));
        String uniqueDeviceId = DeviceUtils.getUniqueDeviceId();
        Intrinsics.checkNotNullExpressionValue(uniqueDeviceId, "getUniqueDeviceId()");
        newBuilder.addHeader("deviceId", uniqueDeviceId);
        newBuilder.addHeader("timezone", TimeZoneUtil.INSTANCE.getTimeZone());
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("unifiedAccessToken");
        stringBuffer.append("=");
        UserInfo userInfoEntity2 = UserInfoBll.Companion.getInstance().getUserInfoEntity();
        stringBuffer.append(userInfoEntity2 == null ? null : userInfoEntity2.getUnifiedAccessToken());
        stringBuffer.append(";");
        if (!TextUtils.isEmpty(stringBuffer)) {
            String stringBuffer2 = stringBuffer.toString();
            Intrinsics.checkNotNullExpressionValue(stringBuffer2, "stringBuffer.toString()");
            newBuilder.addHeader("Cookie", stringBuffer2);
        }
        return chain.proceed(newBuilder.build());
    }
}
