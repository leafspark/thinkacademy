package com.tal.app.thinkacademy.common.util;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.bonree.sdk.agent.engine.external.BitmapFactoryInstrumentation;
import com.tal.app.thinkacademy.common.R;
import com.tal.app.thinkacademy.common.Tag;
import com.tal.app.thinkacademy.common.entity.HwShareWebPageUrlBean;
import com.tal.app.thinkacademy.lib.interfaces.route.DataBusKey;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.Base64Util;
import com.tal.app.thinkacademy.lib.util.ImageUtils;
import com.tal.app.thinkacademy.lib.util.Utils;
import com.tal.app.thinkacademy.lib.utils.XesDataBus;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u000f\u001a\u0004\u0018\u00010\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\bH\u0002J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u0010\u0010\u0017\u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/tal/app/thinkacademy/common/util/WxShareUtil;", "", "()V", "TAG", "Lcom/tal/app/thinkacademy/common/Tag;", "THUMB_SIZE", "", "WeAppId", "", "api", "Lcom/tencent/mm/opensdk/openapi/IWXAPI;", "getApi", "()Lcom/tencent/mm/opensdk/openapi/IWXAPI;", "setApi", "(Lcom/tencent/mm/opensdk/openapi/IWXAPI;)V", "buildTransaction", "type", "getDefaultImageByte", "", "sendShareResult", "", "isSuccess", "", "shareWebPageMsg", "pageBean", "Lcom/tal/app/thinkacademy/common/entity/HwShareWebPageUrlBean;", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: WxShareUtil.kt */
public final class WxShareUtil {
    public static final WxShareUtil INSTANCE = new WxShareUtil();
    private static final Tag TAG = Tag.WECHAT_SDK;
    private static final int THUMB_SIZE = 150;
    public static final String WeAppId = "wx40f1268c6dcc7e97";
    private static IWXAPI api;

    private WxShareUtil() {
    }

    static {
        IWXAPI createWXAPI = WXAPIFactory.createWXAPI(Utils.getApp(), WeAppId, false);
        api = createWXAPI;
        if (createWXAPI != null) {
            createWXAPI.registerApp(WeAppId);
        }
    }

    public final IWXAPI getApi() {
        return api;
    }

    public final void setApi(IWXAPI iwxapi) {
        api = iwxapi;
    }

    public final void shareWebPageMsg(HwShareWebPageUrlBean hwShareWebPageUrlBean) {
        byte[] bArr;
        int i = 0;
        if (hwShareWebPageUrlBean == null || TextUtils.isEmpty(hwShareWebPageUrlBean.getWebpageUrl())) {
            sendShareResult(false);
            XesLog.i(TAG, "分享网址为空，请重试");
            return;
        }
        IWXAPI iwxapi = api;
        if (iwxapi != null) {
            if (iwxapi != null && iwxapi.isWXAppInstalled()) {
                WXMediaMessage.IMediaObject wXWebpageObject = new WXWebpageObject();
                wXWebpageObject.webpageUrl = hwShareWebPageUrlBean.getWebpageUrl();
                WXMediaMessage wXMediaMessage = new WXMediaMessage(wXWebpageObject);
                wXMediaMessage.title = hwShareWebPageUrlBean.getTitle();
                wXMediaMessage.description = hwShareWebPageUrlBean.getDescription();
                Tag tag = TAG;
                XesLog.i(tag, "开始加缩略图");
                CharSequence thumbData = hwShareWebPageUrlBean.getThumbData();
                if (thumbData == null || thumbData.length() == 0) {
                    bArr = getDefaultImageByte();
                } else {
                    byte[] base64ToBitmapBytes = Base64Util.base64ToBitmapBytes(hwShareWebPageUrlBean.getThumbData());
                    if (base64ToBitmapBytes != null) {
                        if (!(base64ToBitmapBytes.length == 0)) {
                            try {
                                XesLog.i(tag, "base64转换图成功，开始压缩图片");
                                Bitmap decodeByteArray = BitmapFactoryInstrumentation.decodeByteArray(base64ToBitmapBytes, 0, base64ToBitmapBytes.length);
                                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(decodeByteArray, 150, 150, true);
                                decodeByteArray.recycle();
                                bArr = ImageUtils.bitmap2Bytes(createScaledBitmap);
                            } catch (Exception unused) {
                                XesLog.i(TAG, "压缩图片失败，开始加载默认图");
                                bArr = getDefaultImageByte();
                            }
                        }
                    }
                    byte[] defaultImageByte = getDefaultImageByte();
                    XesLog.i(tag, "base64转换图片失败，开始加载默认图");
                    bArr = defaultImageByte;
                }
                wXMediaMessage.thumbData = bArr;
                BaseReq req = new SendMessageToWX.Req();
                req.transaction = buildTransaction("webpage");
                req.message = wXMediaMessage;
                if (hwShareWebPageUrlBean.getType() != 1) {
                    i = 1;
                }
                req.scene = i;
                IWXAPI iwxapi2 = api;
                if (iwxapi2 != null) {
                    iwxapi2.sendReq(req);
                }
                sendShareResult(true);
                return;
            }
        }
        sendShareResult(false);
        XesLog.i(TAG, "未安装微信");
    }

    private final byte[] getDefaultImageByte() {
        try {
            Bitmap decodeResource = BitmapFactoryInstrumentation.decodeResource(Utils.getApp().getResources(), R.drawable.icon_think_launch);
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(decodeResource, 150, 150, true);
            decodeResource.recycle();
            return ImageUtils.bitmap2Bytes(createScaledBitmap);
        } catch (Exception e) {
            XesLog.i(TAG, Intrinsics.stringPlus("获取默认分享图标失败 = ", e));
            return null;
        }
    }

    private final String buildTransaction(String str) {
        return str == null ? String.valueOf(System.currentTimeMillis()) : Intrinsics.stringPlus(str, Long.valueOf(System.currentTimeMillis()));
    }

    public final void sendShareResult(boolean z) {
        XesDataBus.with(DataBusKey.BRIDGE_GET_WECHAT_SHARE_RESULT).postStickyData(Integer.valueOf(z ? 1 : 0));
    }
}
