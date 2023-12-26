package com.tal.app.thinkacademy.live.business.groupvideocall.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.TextureView;
import android.widget.FrameLayout;
import com.tal.app.thinkacademy.live.business.groupvideocall.VideoCallBean;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH&J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH&J\b\u0010\u0010\u001a\u00020\nH&J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u000fH&J\u0010\u0010\u0013\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH&J\u0012\u0010\u0014\u001a\u00020\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H&J\u0010\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0019H&J\u0012\u0010\u001a\u001a\u00020\n2\b\b\u0003\u0010\u001b\u001a\u00020\u0007H&J\u0010\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u0007H&¨\u0006\u001e"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/groupvideocall/view/BaseVideoWindow;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "addCoin", "", "studentInform", "Lcom/tal/app/thinkacademy/live/business/groupvideocall/VideoCallBean;", "authPen", "boolean", "", "release", "remotefirstVideoRecvWithUid", "isShow", "setStudentInform", "setSurfaceView", "surfaceView", "Landroid/view/TextureView;", "showFace", "emojiString", "", "updateLevel", "level", "updateMic", "volume", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BaseVideoWindow.kt */
public abstract class BaseVideoWindow extends FrameLayout {
    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BaseVideoWindow(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BaseVideoWindow(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public abstract void addCoin(VideoCallBean videoCallBean);

    public abstract void authPen(boolean z);

    public abstract void release();

    public abstract void remotefirstVideoRecvWithUid(boolean z);

    public abstract void setStudentInform(VideoCallBean videoCallBean);

    public abstract void setSurfaceView(TextureView textureView);

    public abstract void showFace(String str);

    public abstract void updateLevel(int i);

    public abstract void updateMic(int i);

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BaseVideoWindow(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BaseVideoWindow(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public static /* synthetic */ void updateLevel$default(BaseVideoWindow baseVideoWindow, int i, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                i = 0;
            }
            baseVideoWindow.updateLevel(i);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateLevel");
    }
}
