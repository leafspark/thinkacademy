package com.tal.app.thinkacademy.live.business.parentaudit;

import android.content.Context;
import android.view.SurfaceView;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import com.tal.app.thinkacademy.live.core.plugin.pluginview.BaseLivePluginView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/parentaudit/BaseParentAuditPluginView;", "Lcom/tal/app/thinkacademy/live/core/plugin/pluginview/BaseLivePluginView;", "Lcom/tal/app/thinkacademy/live/business/parentaudit/ParentAuditInterface;", "context", "Landroid/content/Context;", "liveRoomProvider", "Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;", "(Landroid/content/Context;Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;)V", "getLiveRoomProvider", "()Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;", "setLiveRoomProvider", "(Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;)V", "mSurfaceView", "Landroid/view/SurfaceView;", "getMSurfaceView", "()Landroid/view/SurfaceView;", "setMSurfaceView", "(Landroid/view/SurfaceView;)V", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BaseParentAuditPluginView.kt */
public abstract class BaseParentAuditPluginView extends BaseLivePluginView implements ParentAuditInterface {
    private ILiveRoomProvider liveRoomProvider;
    private SurfaceView mSurfaceView;

    /* access modifiers changed from: protected */
    public final ILiveRoomProvider getLiveRoomProvider() {
        return this.liveRoomProvider;
    }

    /* access modifiers changed from: protected */
    public final void setLiveRoomProvider(ILiveRoomProvider iLiveRoomProvider) {
        Intrinsics.checkNotNullParameter(iLiveRoomProvider, "<set-?>");
        this.liveRoomProvider = iLiveRoomProvider;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BaseParentAuditPluginView(Context context, ILiveRoomProvider iLiveRoomProvider) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(iLiveRoomProvider, "liveRoomProvider");
        this.liveRoomProvider = iLiveRoomProvider;
    }

    public SurfaceView getMSurfaceView() {
        return this.mSurfaceView;
    }

    public void setMSurfaceView(SurfaceView surfaceView) {
        this.mSurfaceView = surfaceView;
    }
}
