package com.xueersi.lib.graffiti;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.xueersi.lib.graffiti.WXWBAction;
import com.xueersi.lib.graffiti.core.ExtensionFactory;
import com.xueersi.lib.graffiti.draw.DrawableObject;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.util.List;

public interface WXTGraffitiEngine {

    @Target({ElementType.PARAMETER})
    public @interface ActionFrom {
        public static final int DRAW = 1;
        public static final int LOCAL_DB = 2;
        public static final int REMOTE = 3;
        public static final int REMOTE_HISTORY = 4;
    }

    public interface ImageLoader {

        public static class Adapter implements ImageLoader {
            public Drawable globalPlaceHolder() {
                return null;
            }

            public void onLoadImage(String str, ResultHandler resultHandler) {
            }
        }

        public interface ResultHandler {
            void placeHolder(Drawable drawable);

            void ready(Drawable drawable);
        }

        Drawable globalPlaceHolder();

        void onLoadImage(String str, ResultHandler resultHandler);
    }

    public interface Listener {

        public static class Adapter implements Listener {
            public void onFetchedDBActionList(String str, List<WXWBAction> list) {
            }

            public void onGraffitiStackUpdate(boolean z, boolean z2) {
            }

            public void onUnSupportActionList(List<WXWBAction> list) {
            }

            public void onUnSupportActionList(List<WXWBAction> list, boolean z) {
            }
        }

        void onFetchedDBActionList(String str, List<WXWBAction> list);

        void onGraffitiStackUpdate(boolean z, boolean z2);

        @Deprecated
        void onUnSupportActionList(List<WXWBAction> list);

        void onUnSupportActionList(List<WXWBAction> list, boolean z);
    }

    @Target({ElementType.PARAMETER})
    public @interface Role {
        public static final int STUDENT = 2;
        public static final int TEACHER = 1;
    }

    @Target({ElementType.PARAMETER})
    public @interface TurnPageStyle {
        public static final int LOCAL = 1;
        public static final int WAIT_REMOTE = 2;
    }

    public enum UniqueIdType {
        MSG_ID,
        LINE_INDEX
    }

    WXWBAction actionForActionType(int i);

    WXWBAction actionForData(byte[] bArr, String str) throws Exception;

    @Deprecated
    void addAction(WXWBAction wXWBAction);

    void addAction(WXWBAction wXWBAction, int i);

    @Deprecated
    void addActionList(List<WXWBAction> list);

    void addActionList(List<WXWBAction> list, int i);

    void addGraphicFactory(int i, DrawableObject.Factory factory);

    void beginDrawWithTimestamp(long j);

    View createCanvasView(Context context, String str);

    void debugMode(boolean z);

    void destroy();

    void disableSaveDBCurrentPage();

    CustomUI getCustomUI();

    RunningStatus getRunningStatus();

    Setting getSetting();

    String getTeacherId();

    void initWithUid(int i, String str, String str2);

    void registerExtensionFactory(ExtensionFactory extensionFactory);

    void setCanvasTag(String str);

    void setCourseId(String str);

    void setImageLoader(ImageLoader imageLoader);

    void setListener(Listener listener);

    void setPageId(String str);

    void setSenderListener(SenderListener senderListener);

    void setTeacherId(String str);

    void setUserInfo(WXWBAction.UserInfo userInfo);

    @Deprecated
    void turnPageTo(String str);

    void turnPageTo(String str, int i);

    void useTimeStampAlign(boolean z);

    public static class RunningStatus {
        public int actionCount;
        public String curPage;
        public boolean destroyed = false;
        public String lastActionInfo;
        public int viewHeight;
        public boolean viewReady;
        public int viewWidth;
        public List<String> workExceptions;

        public String toString() {
            return "RunningStatus{viewReady=" + this.viewReady + ", viewWidth=" + this.viewWidth + ", viewHeight=" + this.viewHeight + ", curPage='" + this.curPage + '\'' + ", destroyed=" + this.destroyed + ", lastActionInfo='" + this.lastActionInfo + '\'' + ", actionCount=" + this.actionCount + ", workExceptions=" + this.workExceptions + '}';
        }
    }

    public static abstract class CustomUI {
        private DrawableDesc erasePointDrawable;
        private boolean hideLaserTail;
        private boolean hideShapeCenterDot;
        private int laserPointerColor = Color.parseColor("#1890FF");
        private DrawableDesc laserPointerDrawable;
        private DrawableDesc penPointDrawable;
        private DrawableDesc pointDrawable;
        private DrawableDesc shapeCursorDrawable;

        public static class DrawableDesc {
            public Drawable drawable;
            public float offsetX;
            public float offsetY;

            public DrawableDesc(Drawable drawable2, float f, float f2) {
                this.drawable = drawable2;
                this.offsetX = f;
                this.offsetY = f2;
            }

            public DrawableDesc(Drawable drawable2) {
                this(drawable2, 0.5f, 0.5f);
            }
        }

        public void setLaserPointerColor(int i) {
            this.laserPointerColor = i;
        }

        public int getLaserPointerColor() {
            return this.laserPointerColor;
        }

        public boolean isHideLaserTail() {
            return this.hideLaserTail;
        }

        public void setHideLaserTail(boolean z) {
            this.hideLaserTail = z;
        }

        public void setHideShapeCenterDot(boolean z) {
            this.hideShapeCenterDot = z;
        }

        public boolean isHideShapeCenterDot() {
            return this.hideShapeCenterDot;
        }

        public DrawableDesc getPointDrawable() {
            return this.pointDrawable;
        }

        public void setPointDrawable(DrawableDesc drawableDesc) {
            this.pointDrawable = drawableDesc;
        }

        public DrawableDesc getPenPointDrawable() {
            return this.penPointDrawable;
        }

        public void setPenPointDrawable(DrawableDesc drawableDesc) {
            this.penPointDrawable = drawableDesc;
        }

        public DrawableDesc getErasePointDrawable() {
            return this.erasePointDrawable;
        }

        public void setErasePointDrawable(DrawableDesc drawableDesc) {
            this.erasePointDrawable = drawableDesc;
        }

        public DrawableDesc getLaserPointerDrawable() {
            return this.laserPointerDrawable;
        }

        public void setLaserPointerDrawable(DrawableDesc drawableDesc) {
            this.laserPointerDrawable = drawableDesc;
        }

        public DrawableDesc getShapeCursorDrawable() {
            return this.shapeCursorDrawable;
        }

        public void setShapeCursorDrawable(DrawableDesc drawableDesc) {
            this.shapeCursorDrawable = drawableDesc;
        }
    }

    public static abstract class Setting {
        private int actionType = 3;
        private long dbExpireTime = 604800;
        private float eraseWidth;
        private int fillColor;
        private boolean keepFps = false;
        private int lineType;
        private int penStyle;
        private float penWidth;
        private boolean rejectRecoverClean;
        private int sendDuration = 30;
        private int strokeColor;
        private boolean touchable = false;
        private boolean useTextureView = false;

        public abstract long getBizTimeStampMillis();

        public abstract int getHeight();

        public abstract int getWidth();

        public void setKeepSystemFps(boolean z) {
            this.keepFps = z;
        }

        public long getDbExpireTime() {
            return this.dbExpireTime;
        }

        public void setDbExpireTime(long j) {
            this.dbExpireTime = j;
        }

        public boolean isTouchable() {
            return this.touchable;
        }

        public void setTouchable(boolean z) {
            this.touchable = z;
        }

        public void setSendDuration(int i) {
            this.sendDuration = i;
        }

        public int getSendDuration() {
            return this.sendDuration;
        }

        public void setRejectRecoverClean(boolean z) {
            this.rejectRecoverClean = z;
        }

        public boolean isRejectRecoverClean() {
            return this.rejectRecoverClean;
        }

        public void setEraseWidth(float f) {
            this.eraseWidth = f;
        }

        public float getEraseWidth() {
            return this.eraseWidth;
        }

        public float getPenWidth() {
            return this.penWidth;
        }

        public void setPenWidth(float f) {
            this.penWidth = f;
        }

        public int getStrokeColor() {
            return this.strokeColor;
        }

        public void setStrokeColor(int i) {
            this.strokeColor = i;
        }

        public int getFillColor() {
            return this.fillColor;
        }

        public void setFillColor(int i) {
            this.fillColor = i;
        }

        public int getLineType() {
            return this.lineType;
        }

        public void setLineType(int i) {
            this.lineType = i;
        }

        public int getPenStyle() {
            return this.penStyle;
        }

        public void setPenStyle(int i) {
            this.penStyle = i;
        }

        public void setActionType(int i) {
            this.actionType = i;
        }

        public int getActionType() {
            return this.actionType;
        }

        public boolean isUseTextureView() {
            return this.useTextureView;
        }

        public void setUseTextureView(boolean z) {
            this.useTextureView = z;
        }

        public boolean isKeepFps() {
            return this.keepFps;
        }
    }

    public interface SenderListener {
        long generateUniqueId(UniqueIdType uniqueIdType);

        long getCurrentTimeStampMillis();

        void onSendActionData(WXWBAction wXWBAction);

        public static class Adapter implements SenderListener {
            public long generateUniqueId(UniqueIdType uniqueIdType) {
                return -1;
            }

            public void onSendActionData(WXWBAction wXWBAction) {
            }

            public long getCurrentTimeStampMillis() {
                return System.currentTimeMillis();
            }
        }
    }
}
