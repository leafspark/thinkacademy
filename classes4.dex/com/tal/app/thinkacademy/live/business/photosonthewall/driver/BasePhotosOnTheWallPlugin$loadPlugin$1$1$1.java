package com.tal.app.thinkacademy.live.business.photosonthewall.driver;

import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.live.business.photosonthewall.view.PhotosOnTheWallView;
import com.tal.app.thinkacademy.live.business.photosonthewall.view.PhotosOnTheWallViewState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "hasPermission", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: BasePhotosOnTheWallPlugin.kt */
final class BasePhotosOnTheWallPlugin$loadPlugin$1$1$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ BasePhotosOnTheWallPlugin this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BasePhotosOnTheWallPlugin$loadPlugin$1$1$1(BasePhotosOnTheWallPlugin basePhotosOnTheWallPlugin) {
        super(1);
        this.this$0 = basePhotosOnTheWallPlugin;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z) {
        XesLog.s(this.this$0.TAG, Intrinsics.stringPlus("授权回调 --> ", Boolean.valueOf(z)));
        PhotosOnTheWallView access$getMPhotosOnTheWallView$p = this.this$0.mPhotosOnTheWallView;
        if ((access$getMPhotosOnTheWallView$p == null ? null : access$getMPhotosOnTheWallView$p.getPhotosOnTheWallViewState()) == PhotosOnTheWallViewState.StopAnswer) {
            XesLog.s(this.this$0.TAG, "授权回调 , 已停止作答了");
        } else if (z) {
            PhotosOnTheWallView access$getMPhotosOnTheWallView$p2 = this.this$0.mPhotosOnTheWallView;
            if (access$getMPhotosOnTheWallView$p2 != null) {
                access$getMPhotosOnTheWallView$p2.loadView(PhotosOnTheWallViewState.HavaPermission);
            }
            XesLog.s(this.this$0.TAG, "已经获取了相机和存储 --> true");
        } else {
            PhotosOnTheWallView access$getMPhotosOnTheWallView$p3 = this.this$0.mPhotosOnTheWallView;
            if (access$getMPhotosOnTheWallView$p3 != null) {
                access$getMPhotosOnTheWallView$p3.loadView(PhotosOnTheWallViewState.NoHavaPermission);
            }
            XesLog.e(this.this$0.TAG, "没有相机或者存储权限 --> false");
        }
    }
}
