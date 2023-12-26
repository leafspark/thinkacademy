package com.tal.app.thinkacademy.live.core.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.tal.app.thinkacademy.common.util.PadUtils;
import com.tal.app.thinkacademy.lib.util.BarUtils;
import com.tal.app.thinkacademy.lib.util.ScreenUtils;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import com.tal.app.thinkacademy.lib.util.Utils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

@Deprecated
public class LiveVideoPoint {
    public static final float PPT_RATIO = 1.3333334f;
    public static final float VIDEO_HEAD_RATIO = 1.3333334f;
    public static final float VIDEO_MAX_RATIO = 1.8888888f;
    public static final float VIDEO_RATIO = 1.7777778f;
    /* access modifiers changed from: private */
    public static LiveVideoPoint instance;
    private int GroupVideoCallHeight;
    HashMap<Context, ArrayList<VideoSizeChange>> contextArrayListHashMap = new HashMap<>();
    private int headHeight;
    private int headWidth;
    private boolean isPad;
    private boolean isSmallClass;
    private int mVideoChatToggleHeight;
    private int msgHeight;
    private int navBarHeight;
    private int pptHeight;
    private int pptWidth;
    private int screenHeight;
    private int screenWidth;
    private int videoHeight;
    private int videoWidth;
    WeakReference<Activity> weakObjReference;
    private final int x1 = 0;
    private int x2;
    private int x3;
    private int x4;
    private final int y1 = 0;
    private int y2;
    private int y3;
    private int y4;
    private int y5;
    private int y6;

    public interface VideoSizeChange {
        void videoSizeChange(LiveVideoPoint liveVideoPoint);
    }

    public int getX1() {
        return 0;
    }

    public int getY1() {
        return 0;
    }

    private LiveVideoPoint(Activity activity) {
        WeakReference<Activity> weakReference = new WeakReference<>(activity);
        this.weakObjReference = weakReference;
        initLiveVideoPoint((Activity) weakReference.get(), this, getVideoLayoutParams());
        addOnGlobalLayoutListener();
        this.isPad = PadUtils.isPad(Utils.getApp());
    }

    public static LiveVideoPoint getInstance(Activity activity) {
        LiveVideoPoint liveVideoPoint = instance;
        if (liveVideoPoint != null) {
            return liveVideoPoint;
        }
        LiveVideoPoint liveVideoPoint2 = new LiveVideoPoint(activity);
        instance = liveVideoPoint2;
        return liveVideoPoint2;
    }

    private void addOnGlobalLayoutListener() {
        WeakReference<Activity> weakReference = this.weakObjReference;
        if (weakReference != null && weakReference.get() != null) {
            final View findViewById = ((Activity) this.weakObjReference.get()).findViewById(16908290);
            findViewById.postDelayed(new Runnable() {
                public void run() {
                    findViewById.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                        public void onGlobalLayout() {
                            if (((Activity) LiveVideoPoint.this.weakObjReference.get()).getResources().getConfiguration().orientation == 2) {
                                boolean unused = LiveVideoPoint.this.initLiveVideoPoint((Activity) LiveVideoPoint.this.weakObjReference.get(), LiveVideoPoint.instance, LiveVideoPoint.this.getVideoLayoutParams());
                            }
                        }
                    });
                }
            }, 10);
        }
    }

    /* access modifiers changed from: private */
    public ViewGroup.LayoutParams getVideoLayoutParams() {
        if (this.weakObjReference.get() == null) {
            return null;
        }
        Rect rect = new Rect();
        ((View) ((Activity) this.weakObjReference.get()).findViewById(16908290).getParent()).getWindowVisibleDisplayFrame(rect);
        int i = rect.right - rect.left;
        int screenHeight2 = ScreenUtils.getScreenHeight();
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        float f = (float) i;
        float f2 = (float) screenHeight2;
        float f3 = (1.0f * f) / f2;
        if (this.isPad) {
            this.navBarHeight = BarUtils.getNavBarHeight();
            if (BarUtils.isNavBarVisible((Activity) this.weakObjReference.get())) {
                layoutParams.width = i;
                layoutParams.height = screenHeight2 - this.navBarHeight;
            } else {
                layoutParams.width = i;
                layoutParams.height = screenHeight2;
            }
        } else if (f3 > 1.7777778f && f3 <= 1.8888888f) {
            layoutParams.width = i;
            layoutParams.height = screenHeight2;
        } else if (f3 > 1.8888888f) {
            layoutParams.height = screenHeight2;
            layoutParams.width = (int) (f2 * 1.8888888f);
        } else {
            layoutParams.width = i;
            layoutParams.height = (int) (f / 1.7777778f);
        }
        return layoutParams;
    }

    /* access modifiers changed from: private */
    public boolean initLiveVideoPoint(Activity activity, LiveVideoPoint liveVideoPoint, ViewGroup.LayoutParams layoutParams) {
        if (layoutParams == null) {
            return false;
        }
        Rect rect = new Rect();
        ((View) activity.findViewById(16908290).getParent()).getWindowVisibleDisplayFrame(rect);
        int i = rect.right - rect.left;
        int screenHeight2 = ScreenUtils.getScreenHeight();
        if (liveVideoPoint.screenWidth == i && liveVideoPoint.videoWidth == layoutParams.width && liveVideoPoint.videoHeight == layoutParams.height) {
            return false;
        }
        if (this.isPad && liveVideoPoint.screenWidth == i && liveVideoPoint.videoWidth == layoutParams.width && liveVideoPoint.videoHeight == layoutParams.height - SizeUtils.dp2px(61.0f)) {
            return false;
        }
        liveVideoPoint.x2 = (i - layoutParams.width) / 2;
        liveVideoPoint.videoWidth = layoutParams.width;
        liveVideoPoint.screenWidth = i;
        if (this.isPad) {
            liveVideoPoint.pptWidth = (int) (((float) (layoutParams.height - SizeUtils.dp2px(61.0f))) * 1.3333334f);
        } else {
            liveVideoPoint.pptWidth = (int) (((float) layoutParams.height) * 1.3333334f);
        }
        liveVideoPoint.pptHeight = (this.pptWidth / 4) * 3;
        int i2 = liveVideoPoint.videoWidth;
        int i3 = liveVideoPoint.pptWidth;
        liveVideoPoint.headWidth = i2 - i3;
        int i4 = liveVideoPoint.x2;
        liveVideoPoint.x3 = i3 + i4;
        liveVideoPoint.x4 = i4 + layoutParams.width;
        if (this.isPad) {
            liveVideoPoint.y2 = (screenHeight2 - layoutParams.height) / 2;
            if (this.weakObjReference.get() == null) {
                return false;
            }
            if (BarUtils.isNavBarVisible((Activity) this.weakObjReference.get())) {
                liveVideoPoint.y2 = 0;
            }
        } else {
            liveVideoPoint.y2 = (screenHeight2 - layoutParams.height) / 2;
        }
        liveVideoPoint.headHeight = (int) (((float) liveVideoPoint.headWidth) / 1.3333334f);
        if (this.isPad) {
            liveVideoPoint.videoHeight = layoutParams.height - SizeUtils.dp2px(61.0f);
        } else {
            liveVideoPoint.videoHeight = layoutParams.height;
        }
        this.GroupVideoCallHeight = layoutParams.height;
        liveVideoPoint.mVideoChatToggleHeight = SizeUtils.dp2px(65.0f);
        int i5 = layoutParams.height;
        int i6 = liveVideoPoint.headHeight;
        liveVideoPoint.msgHeight = i5 - i6;
        int i7 = liveVideoPoint.y2;
        liveVideoPoint.y3 = i6 + i7;
        liveVideoPoint.y4 = i7 + layoutParams.height;
        int i8 = liveVideoPoint.y2;
        int i9 = liveVideoPoint.headHeight;
        int i10 = liveVideoPoint.mVideoChatToggleHeight;
        liveVideoPoint.y5 = i8 + i9 + i10;
        liveVideoPoint.y6 = i8 + i9 + i10;
        liveVideoPoint.screenHeight = screenHeight2;
        liveVideoPoint.toString();
        ArrayList arrayList = liveVideoPoint.contextArrayListHashMap.get(activity);
        if (arrayList == null) {
            return true;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((VideoSizeChange) it.next()).videoSizeChange(liveVideoPoint);
        }
        return true;
    }

    public String toString() {
        return "ppt左侧,屏幕到ppt右侧,直播间右侧=" + this.x2 + "," + this.x3 + "," + this.x4 + ",屏幕宽=" + this.screenWidth + ",直播间宽=" + this.videoWidth + ",ppt宽=" + this.pptWidth + ",老师头像宽=" + this.headWidth + ",ppt上边,老师头像底部到上方,直播间底部=" + this.y2 + "," + this.y3 + "," + this.y4 + ",屏幕高=" + this.screenHeight + ",直播间高=" + this.videoHeight + ",老师头像高=" + this.headHeight + ",消息高=" + this.msgHeight;
    }

    public int getX2() {
        return this.x2;
    }

    public int getX3() {
        return this.x3;
    }

    public int getX4() {
        return this.x4;
    }

    public int getScreenWidth() {
        return this.screenWidth;
    }

    public int getVideoWidth() {
        return this.videoWidth;
    }

    public int getPptWidth() {
        return this.pptWidth;
    }

    public int getPptHeight() {
        return this.pptHeight;
    }

    public int getHeadWidth() {
        return this.headWidth;
    }

    public int getVideoChatToggleHeight() {
        return this.mVideoChatToggleHeight;
    }

    public int getY2() {
        return this.y2;
    }

    public int getY3() {
        return this.y3;
    }

    public int getY4() {
        return this.y4;
    }

    public int getY5() {
        return this.y5;
    }

    public int getScreenHeight() {
        return this.screenHeight;
    }

    public int getVideoHeight() {
        return this.videoHeight;
    }

    public int getGroupVideoCallHeight() {
        return this.GroupVideoCallHeight;
    }

    public int getHeadHeight() {
        return this.headHeight;
    }

    public int getMsgHeight() {
        return this.msgHeight;
    }

    public static void onDestroy() {
        instance = null;
    }

    public void addVideoSizeChange(Context context, VideoSizeChange videoSizeChange) {
        ArrayList arrayList = this.contextArrayListHashMap.get(context);
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.contextArrayListHashMap.put(context, arrayList);
        }
        arrayList.add(videoSizeChange);
    }

    public void addVideoSizeChangeAndCall(Context context, VideoSizeChange videoSizeChange) {
        addVideoSizeChange(context, videoSizeChange);
        videoSizeChange.videoSizeChange(this);
    }

    public void removeVideoSizeChange(Context context, VideoSizeChange videoSizeChange) {
        ArrayList arrayList = this.contextArrayListHashMap.get(context);
        if (arrayList != null) {
            arrayList.remove(videoSizeChange);
        }
    }
}
