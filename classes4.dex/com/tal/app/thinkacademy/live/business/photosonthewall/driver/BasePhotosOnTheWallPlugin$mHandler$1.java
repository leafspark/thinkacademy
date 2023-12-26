package com.tal.app.thinkacademy.live.business.photosonthewall.driver;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import com.tal.app.thinkacademy.live.business.photosonthewall.view.PhotosOnTheWallView;
import com.tal.app.thinkacademy.live.business.photosonthewall.view.PhotosOnTheWallViewState;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/tal/app/thinkacademy/live/business/photosonthewall/driver/BasePhotosOnTheWallPlugin$mHandler$1", "Landroid/os/Handler;", "handleMessage", "", "msg", "Landroid/os/Message;", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BasePhotosOnTheWallPlugin.kt */
public final class BasePhotosOnTheWallPlugin$mHandler$1 extends Handler {
    final /* synthetic */ ILiveRoomProvider $mLiveRoomProvider;
    final /* synthetic */ BasePhotosOnTheWallPlugin this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BasePhotosOnTheWallPlugin$mHandler$1(BasePhotosOnTheWallPlugin basePhotosOnTheWallPlugin, ILiveRoomProvider iLiveRoomProvider, Looper looper) {
        super(looper);
        this.this$0 = basePhotosOnTheWallPlugin;
        this.$mLiveRoomProvider = iLiveRoomProvider;
    }

    public void handleMessage(Message message) {
        AsynchronousInstrumentation.handlerMessageBegin(this, message);
        Intrinsics.checkNotNullParameter(message, "msg");
        int i = message.what;
        if (i == this.this$0.KCLOSESUCCESS) {
            PhotosOnTheWallView access$getMPhotosOnTheWallView$p = this.this$0.mPhotosOnTheWallView;
            if (access$getMPhotosOnTheWallView$p != null) {
                access$getMPhotosOnTheWallView$p.loadView(PhotosOnTheWallViewState.OnlyCountdown);
            }
        } else if (i == this.this$0.KCLOSE) {
            if (this.this$0.mPhotosUploadResult == PhotosUploadResult.SubmissionFailed) {
                PhotosOnTheWallView access$getMPhotosOnTheWallView$p2 = this.this$0.mPhotosOnTheWallView;
                if (access$getMPhotosOnTheWallView$p2 != null) {
                    access$getMPhotosOnTheWallView$p2.loadView(PhotosOnTheWallViewState.SubmitFailed);
                }
                this.this$0.mPhotosUploadResult = PhotosUploadResult.UnKnow;
                this.this$0.removePlugin(3000);
            } else {
                PhotosOnTheWallView access$getMPhotosOnTheWallView$p3 = this.this$0.mPhotosOnTheWallView;
                if (access$getMPhotosOnTheWallView$p3 != null) {
                    access$getMPhotosOnTheWallView$p3.onDestroy();
                }
                ILiveRoomProvider iLiveRoomProvider = this.$mLiveRoomProvider;
                if (iLiveRoomProvider != null) {
                    iLiveRoomProvider.removeView((View) this.this$0.mPhotosOnTheWallView);
                }
                this.this$0.mPhotosOnTheWallView = null;
                this.this$0.onDestroy();
            }
        }
        AsynchronousInstrumentation.handlerMessageEnd();
    }
}
