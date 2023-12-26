package com.tal.app.thinkacademy.lib.player.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001CB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u00100\u001a\u0004\u0018\u00010 J\u0016\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u00032\u0006\u00104\u001a\u00020\u001aJ\u0012\u00105\u001a\u0002022\b\u00106\u001a\u0004\u0018\u000107H\u0016J(\u00108\u001a\u0002022\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\u000b2\u0006\u0010<\u001a\u00020\u000b2\u0006\u0010=\u001a\u00020:H\u0002J.\u0010>\u001a\u0002022\u0006\u0010?\u001a\u00020\u000b2\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\u000b2\u0006\u0010<\u001a\u00020\u000b2\u0006\u0010@\u001a\u00020:J\u0010\u0010A\u001a\u0002022\u0006\u0010B\u001a\u00020\u000bH\u0016R\u000e\u0010\b\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000bXD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000bXD¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u000bXD¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000bXD¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0014\u0010\u0014\u001a\u00020\u000bXD¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\rR\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\r\"\u0004\b\u001d\u0010\u001eR\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010!\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\r\"\u0004\b#\u0010\u001eR\u001a\u0010$\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\r\"\u0004\b&\u0010\u001eR\u001a\u0010'\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\r\"\u0004\b)\u0010\u001eR\u001c\u0010*\u001a\u0004\u0018\u00010+X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/¨\u0006D"}, d2 = {"Lcom/tal/app/thinkacademy/lib/player/view/VideoView;", "Landroid/view/SurfaceView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "TAG", "", "VIDEO_LAYOUT_ORIGIN", "", "getVIDEO_LAYOUT_ORIGIN", "()I", "VIDEO_LAYOUT_SCALE", "getVIDEO_LAYOUT_SCALE", "VIDEO_LAYOUT_SCALE_ZOOM", "getVIDEO_LAYOUT_SCALE_ZOOM", "VIDEO_LAYOUT_STRETCH", "getVIDEO_LAYOUT_STRETCH", "VIDEO_LAYOUT_ZOOM", "getVIDEO_LAYOUT_ZOOM", "mActivity", "mCallback", "Landroid/view/SurfaceHolder$Callback;", "mListener", "Lcom/tal/app/thinkacademy/lib/player/view/SurfaceCallback;", "mSurfaceHeight", "getMSurfaceHeight", "setMSurfaceHeight", "(I)V", "mSurfaceHolder", "Landroid/view/SurfaceHolder;", "mSurfaceWidth", "getMSurfaceWidth", "setMSurfaceWidth", "mVideoHeight", "getMVideoHeight", "setMVideoHeight", "mVideoMode", "getMVideoMode", "setMVideoMode", "videoLayoutInter", "Lcom/tal/app/thinkacademy/lib/player/view/VideoView$VideoLayoutInter;", "getVideoLayoutInter", "()Lcom/tal/app/thinkacademy/lib/player/view/VideoView$VideoLayoutInter;", "setVideoLayoutInter", "(Lcom/tal/app/thinkacademy/lib/player/view/VideoView$VideoLayoutInter;)V", "getSurfaceHolder", "initialize", "", "activity", "l", "setLayoutParams", "params", "Landroid/view/ViewGroup$LayoutParams;", "setSurfaceLayout", "userRatio", "", "videoWidth", "videoHeight", "videoAspectRatio", "setVideoLayout", "layout", "videoRatio", "setVisibility", "visibility", "VideoLayoutInter", "lib_player_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoView.kt */
public final class VideoView extends SurfaceView {
    private final String TAG = "VideoViewLog";
    private final int VIDEO_LAYOUT_ORIGIN;
    private final int VIDEO_LAYOUT_SCALE = 1;
    private final int VIDEO_LAYOUT_SCALE_ZOOM = 4;
    private final int VIDEO_LAYOUT_STRETCH = 2;
    private final int VIDEO_LAYOUT_ZOOM = 3;
    private Context mActivity;
    private final SurfaceHolder.Callback mCallback;
    /* access modifiers changed from: private */
    public SurfaceCallback mListener;
    private int mSurfaceHeight;
    /* access modifiers changed from: private */
    public SurfaceHolder mSurfaceHolder;
    private int mSurfaceWidth;
    private int mVideoHeight;
    private int mVideoMode = 1;
    private VideoLayoutInter videoLayoutInter;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0007H&¨\u0006\u000b"}, d2 = {"Lcom/tal/app/thinkacademy/lib/player/view/VideoView$VideoLayoutInter;", "", "setVideoLayout", "", "layout", "", "userRatio", "", "videoWidth", "videoHeight", "videoRatio", "lib_player_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: VideoView.kt */
    public interface VideoLayoutInter {
        boolean setVideoLayout(int i, float f, int i2, int i3, float f2);
    }

    public final int getVIDEO_LAYOUT_ORIGIN() {
        return this.VIDEO_LAYOUT_ORIGIN;
    }

    public final int getVIDEO_LAYOUT_SCALE() {
        return this.VIDEO_LAYOUT_SCALE;
    }

    public final int getVIDEO_LAYOUT_STRETCH() {
        return this.VIDEO_LAYOUT_STRETCH;
    }

    public final int getVIDEO_LAYOUT_ZOOM() {
        return this.VIDEO_LAYOUT_ZOOM;
    }

    public final int getVIDEO_LAYOUT_SCALE_ZOOM() {
        return this.VIDEO_LAYOUT_SCALE_ZOOM;
    }

    public final int getMVideoHeight() {
        return this.mVideoHeight;
    }

    public final void setMVideoHeight(int i) {
        this.mVideoHeight = i;
    }

    /* access modifiers changed from: protected */
    public final int getMSurfaceWidth() {
        return this.mSurfaceWidth;
    }

    /* access modifiers changed from: protected */
    public final void setMSurfaceWidth(int i) {
        this.mSurfaceWidth = i;
    }

    /* access modifiers changed from: protected */
    public final int getMSurfaceHeight() {
        return this.mSurfaceHeight;
    }

    /* access modifiers changed from: protected */
    public final void setMSurfaceHeight(int i) {
        this.mSurfaceHeight = i;
    }

    /* access modifiers changed from: protected */
    public final int getMVideoMode() {
        return this.mVideoMode;
    }

    /* access modifiers changed from: protected */
    public final void setMVideoMode(int i) {
        this.mVideoMode = i;
    }

    public final VideoLayoutInter getVideoLayoutInter() {
        return this.videoLayoutInter;
    }

    public final void setVideoLayoutInter(VideoLayoutInter videoLayoutInter2) {
        this.videoLayoutInter = videoLayoutInter2;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VideoView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        SurfaceHolder.Callback videoView$mCallback$1 = new VideoView$mCallback$1(this);
        this.mCallback = videoView$mCallback$1;
        getHolder().addCallback(videoView$mCallback$1);
        getHolder().setFormat(1);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attrs");
        SurfaceHolder.Callback videoView$mCallback$1 = new VideoView$mCallback$1(this);
        this.mCallback = videoView$mCallback$1;
        getHolder().addCallback(videoView$mCallback$1);
        getHolder().setFormat(1);
    }

    public final void initialize(Context context, SurfaceCallback surfaceCallback) {
        Intrinsics.checkNotNullParameter(context, "activity");
        Intrinsics.checkNotNullParameter(surfaceCallback, "l");
        this.mActivity = context;
        this.mListener = surfaceCallback;
        if (this.mSurfaceHolder == null) {
            this.mSurfaceHolder = getHolder();
        }
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
    }

    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
    }

    public final SurfaceHolder getSurfaceHolder() {
        return this.mSurfaceHolder;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0063, code lost:
        if (r4 < r7) goto L_0x0065;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0067, code lost:
        r9 = (int) (r2 / r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0092, code lost:
        if (r4 <= r7) goto L_0x0067;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void setSurfaceLayout(float r7, int r8, int r9, float r10) {
        /*
            r6 = this;
            android.content.Context r0 = r6.getContext()
            java.lang.String r1 = "null cannot be cast to non-null type android.app.Activity"
            java.util.Objects.requireNonNull(r0, r1)
            android.app.Activity r0 = (android.app.Activity) r0
            int r1 = com.tal.app.thinkacademy.player.R.id.content
            android.view.View r0 = r0.findViewById(r1)
            if (r0 != 0) goto L_0x0014
            return
        L_0x0014:
            android.view.ViewParent r0 = r0.getParent()
            java.lang.String r1 = "null cannot be cast to non-null type android.view.View"
            java.util.Objects.requireNonNull(r0, r1)
            android.view.View r0 = (android.view.View) r0
            android.graphics.Rect r1 = new android.graphics.Rect
            r1.<init>()
            r0.getWindowVisibleDisplayFrame(r1)
            int r0 = com.tal.app.thinkacademy.lib.util.ScreenUtils.getScreenWidth()
            int r1 = com.tal.app.thinkacademy.lib.util.ScreenUtils.getScreenHeight()
            float r2 = (float) r0
            float r3 = (float) r1
            float r4 = r2 / r3
            r5 = 1008981770(0x3c23d70a, float:0.01)
            int r5 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r5 > 0) goto L_0x003b
            r7 = r10
        L_0x003b:
            r6.mSurfaceHeight = r9
            r6.mSurfaceWidth = r8
            int r10 = r6.VIDEO_LAYOUT_ORIGIN
            int r5 = r6.mVideoMode
            if (r10 != r5) goto L_0x004d
            if (r8 >= r0) goto L_0x004d
            if (r9 >= r1) goto L_0x004d
        L_0x0049:
            float r8 = (float) r9
            float r8 = r8 * r7
            int r7 = (int) r8
            goto L_0x0095
        L_0x004d:
            int r8 = r6.VIDEO_LAYOUT_ZOOM
            if (r5 != r8) goto L_0x006c
            int r8 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r8 <= 0) goto L_0x0056
            goto L_0x0061
        L_0x0056:
            float r3 = r3 * r7
            java.lang.Float r8 = java.lang.Float.valueOf(r3)
            java.lang.Integer r8 = (java.lang.Integer) r8
            int r0 = r8.intValue()
        L_0x0061:
            int r8 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r8 >= 0) goto L_0x0067
        L_0x0065:
            r9 = r1
            goto L_0x006a
        L_0x0067:
            float r2 = r2 / r7
            int r7 = (int) r2
            r9 = r7
        L_0x006a:
            r7 = r0
            goto L_0x0095
        L_0x006c:
            int r8 = r6.VIDEO_LAYOUT_SCALE_ZOOM
            if (r5 != r8) goto L_0x0075
            int r9 = r6.mVideoHeight
            if (r9 <= 0) goto L_0x0075
            goto L_0x0049
        L_0x0075:
            int r8 = r6.VIDEO_LAYOUT_STRETCH
            if (r5 != r8) goto L_0x007b
            r8 = 1
            goto L_0x007c
        L_0x007b:
            r8 = 0
        L_0x007c:
            if (r8 != 0) goto L_0x008e
            int r9 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r9 >= 0) goto L_0x0083
            goto L_0x008e
        L_0x0083:
            float r3 = r3 * r7
            java.lang.Float r9 = java.lang.Float.valueOf(r3)
            java.lang.Integer r9 = (java.lang.Integer) r9
            int r0 = r9.intValue()
        L_0x008e:
            if (r8 != 0) goto L_0x0065
            int r8 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r8 <= 0) goto L_0x0067
            goto L_0x0065
        L_0x0095:
            android.view.ViewGroup$LayoutParams r8 = r6.getLayoutParams()
            r6.mVideoHeight = r9
            int r10 = r8.width
            if (r10 != r7) goto L_0x00a3
            int r10 = r8.height
            if (r10 == r9) goto L_0x00aa
        L_0x00a3:
            r8.width = r7
            r8.height = r9
            r6.setLayoutParams(r8)
        L_0x00aa:
            android.view.SurfaceHolder r7 = r6.getHolder()
            int r8 = r6.mSurfaceWidth
            int r9 = r6.mSurfaceHeight
            r7.setFixedSize(r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.lib.player.view.VideoView.setSurfaceLayout(float, int, int, float):void");
    }

    public final void setVideoLayout(int i, float f, int i2, int i3, float f2) {
        Boolean bool;
        VideoLayoutInter videoLayoutInter2 = this.videoLayoutInter;
        if (videoLayoutInter2 != null) {
            if (videoLayoutInter2 == null) {
                bool = null;
            } else {
                bool = Boolean.valueOf(videoLayoutInter2.setVideoLayout(i, f, i2, i3, f2));
            }
            Intrinsics.checkNotNull(bool);
            if (bool.booleanValue()) {
                return;
            }
        }
        this.mVideoMode = i;
        setSurfaceLayout(f, i2, i3, f2);
    }
}
