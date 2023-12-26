package com.tal.app.thinkacademy.live.business.bulletscreen;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.tal.app.thinkacademy.annotation.plugin.PluginAnnotation;
import com.tal.app.thinkacademy.annotation.plugin.ViewLevel;
import com.tal.app.thinkacademy.annotation.plugin.ViewLevels;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.GsonUtil;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaContext;
import com.tal.app.thinkacademy.live.core.plugin.BaseLivePluginDriver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@PluginAnnotation(classType = 1, desc = "氛围工具", deviceType = 1, ircType = {"Ambiance_Tools"}, launchType = "enter", moduleId = "0")
@ViewLevels({@ViewLevel(level = 140, name = "BulletScreenView")})
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u001c\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u0010H\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/bulletscreen/BulletScreenDriver;", "Lcom/tal/app/thinkacademy/live/core/plugin/BaseLivePluginDriver;", "mLiveRoomProvider", "Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;", "bundle", "Landroid/os/Bundle;", "(Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;Landroid/os/Bundle;)V", "mContext", "Landroid/content/Context;", "getMLiveRoomProvider", "()Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;", "setMLiveRoomProvider", "(Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;)V", "mPluginView", "Lcom/tal/app/thinkacademy/live/business/bulletscreen/BulletScreenView;", "onDestroy", "", "onMessage", "ircTypeKey", "", "message", "removePluginView", "Companion", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BulletScreenDriver.kt */
public final class BulletScreenDriver extends BaseLivePluginDriver {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final Tag TAG = Tag.BULLET_SCREEN;
    private Context mContext;
    private ILiveRoomProvider mLiveRoomProvider;
    private BulletScreenView mPluginView;

    public final ILiveRoomProvider getMLiveRoomProvider() {
        return this.mLiveRoomProvider;
    }

    public final void setMLiveRoomProvider(ILiveRoomProvider iLiveRoomProvider) {
        Intrinsics.checkNotNullParameter(iLiveRoomProvider, "<set-?>");
        this.mLiveRoomProvider = iLiveRoomProvider;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BulletScreenDriver(ILiveRoomProvider iLiveRoomProvider, Bundle bundle) {
        super(iLiveRoomProvider, bundle);
        Intrinsics.checkNotNullParameter(iLiveRoomProvider, "mLiveRoomProvider");
        this.mLiveRoomProvider = iLiveRoomProvider;
        this.mContext = (Context) iLiveRoomProvider.getWeakRefContext().get();
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/bulletscreen/BulletScreenDriver$Companion;", "", "()V", "TAG", "Lcom/tal/app/thinkacademy/live/Tag;", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: BulletScreenDriver.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public void onMessage(String str, String str2) {
        if (StringsKt.equals$default(str, BulletScreenDriverKt.AMBIANCE_TOOLS_IRC, false, 2, (Object) null) && str2 != null) {
            try {
                BulletScreenBean bulletScreenBean = (BulletScreenBean) GsonUtil.getInstance().fromJson(str2, BulletScreenBean.class);
                removePluginView();
                Context context = this.mContext;
                if (context != null) {
                    this.mPluginView = new BulletScreenView(context, new BulletScreenDriver$onMessage$1$1$1(this));
                    this.mLiveRoomProvider.addView((BaseLivePluginDriver) this, this.mPluginView, BulletScreenDriverKt.AMBIANCE_TOOLS_VIEW, LiveAreaContext.get().getPptLp().newLp());
                    if (bulletScreenBean != null) {
                        BulletScreenView bulletScreenView = this.mPluginView;
                        if (bulletScreenView != null) {
                            bulletScreenView.play(bulletScreenBean.getData().getAmbianceId());
                            Unit unit = Unit.INSTANCE;
                        }
                    }
                }
            } catch (Throwable th) {
                XesLog.e(TAG, Intrinsics.stringPlus("氛围工具信令解析异常=", Log.getStackTraceString(th)));
                Unit unit2 = Unit.INSTANCE;
            }
        }
    }

    /* access modifiers changed from: private */
    public final void removePluginView() {
        BulletScreenView bulletScreenView = this.mPluginView;
        if (bulletScreenView != null) {
            if (bulletScreenView != null) {
                bulletScreenView.destroy();
            }
            this.mLiveRoomProvider.removeView((View) this.mPluginView);
            this.mPluginView = null;
        }
    }

    public void onDestroy() {
        removePluginView();
    }
}
