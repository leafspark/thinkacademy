package com.tal.app.thinkacademy.live.business.photosonthewall.util;

import com.tal.app.thinkacademy.lib.interfaces.route.DataBusKey;
import com.tal.app.thinkacademy.lib.utils.XesDataBus;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\b\u0010\u0005\u001a\u00020\u0004H\u0007¨\u0006\u0006"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/photosonthewall/util/TakePhotoStateUtil;", "", "()V", "finishTakePhoto", "", "startTakePhoto", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TakePhotoStateUtil.kt */
public final class TakePhotoStateUtil {
    public static final TakePhotoStateUtil INSTANCE = new TakePhotoStateUtil();

    private TakePhotoStateUtil() {
    }

    @JvmStatic
    public static final void startTakePhoto() {
        XesDataBus.with(DataBusKey.TAKE_PHOTO_STATE).postStickyData("start");
    }

    @JvmStatic
    public static final void finishTakePhoto() {
        XesDataBus.with(DataBusKey.TAKE_PHOTO_STATE).postStickyData("end");
    }
}
