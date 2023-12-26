package com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import com.xueersi.lib.graffiti.WXWBAction;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0018B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u000eJ\b\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u0018\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\bH\u0002R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/canvastriplescreen/graffiti/GraffitiTagView;", "Landroid/widget/FrameLayout;", "mContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "dataMap", "", "", "Lcom/tal/app/thinkacademy/live/business/canvastriplescreen/graffiti/GraffitiTagView$GraffitiTag;", "getMContext", "()Landroid/content/Context;", "mHandler", "Landroid/os/Handler;", "clear", "", "destroy", "getTagBg", "Landroid/graphics/drawable/Drawable;", "updateGraffitiTag", "action", "Lcom/xueersi/lib/graffiti/WXWBAction;", "updateTagView", "name", "tag", "GraffitiTag", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GraffitiPluginView.kt */
public final class GraffitiTagView extends FrameLayout {
    private Map<String, GraffitiTag> dataMap = new LinkedHashMap();
    private final Context mContext;
    private Handler mHandler = new Handler(Looper.getMainLooper());

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GraffitiTagView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "mContext");
        this.mContext = context;
    }

    public final Context getMContext() {
        return this.mContext;
    }

    private final Drawable getTagBg() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius((float) SizeUtils.dp2px(4.0f));
        gradientDrawable.setColor(-256);
        return gradientDrawable;
    }

    public final void updateGraffitiTag(WXWBAction wXWBAction) {
        String uname;
        if (wXWBAction != null) {
            String uid = wXWBAction.getUid();
            Intrinsics.checkNotNullExpressionValue(uid, "it.uid");
            WXWBAction.UserInfo userInfo = wXWBAction.getUserInfo();
            String str = "";
            if (!(userInfo == null || (uname = userInfo.getUname()) == null)) {
                str = uname;
            }
            if (!TextUtils.isEmpty(uid) && !TextUtils.isEmpty(str)) {
                Handler handler = this.mHandler;
                GraffitiTagView$$ExternalSyntheticLambda0 graffitiTagView$$ExternalSyntheticLambda0 = new GraffitiTagView$$ExternalSyntheticLambda0(this, uid, wXWBAction, str);
                if (!(handler instanceof Handler)) {
                    handler.post(graffitiTagView$$ExternalSyntheticLambda0);
                } else {
                    AsynchronousInstrumentation.handlerPost(handler, graffitiTagView$$ExternalSyntheticLambda0);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: updateGraffitiTag$lambda-3$lambda-2  reason: not valid java name */
    public static final void m190updateGraffitiTag$lambda3$lambda2(GraffitiTagView graffitiTagView, String str, WXWBAction wXWBAction, String str2) {
        Unit unit;
        Intrinsics.checkNotNullParameter(graffitiTagView, "this$0");
        Intrinsics.checkNotNullParameter(str, "$uid");
        Intrinsics.checkNotNullParameter(str2, "$name");
        GraffitiTag graffitiTag = graffitiTagView.dataMap.get(str);
        if (graffitiTag == null) {
            unit = null;
        } else {
            if (wXWBAction.getMsgId() >= graffitiTag.getAction().getMsgId()) {
                graffitiTag.setAction(wXWBAction);
                graffitiTagView.updateTagView(str2, graffitiTag);
            }
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            GraffitiTag graffitiTag2 = new GraffitiTag(str2, -16777216, wXWBAction, (TextView) null);
            graffitiTagView.dataMap.put(str, graffitiTag2);
            graffitiTagView.updateTagView(str2, graffitiTag2);
        }
    }

    private final void updateTagView(String str, GraffitiTag graffitiTag) {
        WXWBAction.PointData pointData;
        TextView tagView = graffitiTag.getTagView();
        if (tagView == null) {
            tagView = new TextView(this.mContext);
            tagView.setPadding(SizeUtils.dp2px(2.0f), 0, SizeUtils.dp2px(2.0f), 0);
            tagView.setTextColor(-1);
            tagView.setBackground(getTagBg());
            tagView.setGravity(17);
            tagView.setText(graffitiTag.getName());
            tagView.setTextSize(12.0f);
            tagView.setLines(1);
            tagView.setEllipsize(TextUtils.TruncateAt.END);
            tagView.setMaxWidth(SizeUtils.dp2px(100.0f));
            graffitiTag.setTagView(tagView);
            addView(tagView, new FrameLayout.LayoutParams(-2, -2));
        }
        List pointList = graffitiTag.getAction().getPointList();
        if (!(pointList == null || pointList.size() <= 0 || (pointData = (WXWBAction.PointData) pointList.get(pointList.size() - 1)) == null || pointData.getPointAction() == 0)) {
            float width = ((float) getWidth()) * pointData.getX();
            float height = ((float) getHeight()) * pointData.getY();
            if (tagView.getVisibility() != 0) {
                tagView.setVisibility(0);
            }
            tagView.setTranslationX(width);
            tagView.setTranslationY(height);
            Runnable runnable = graffitiTag;
            this.mHandler.removeCallbacks(runnable);
            this.mHandler.postDelayed(runnable, 2000);
        }
        if (graffitiTag.getColor() != graffitiTag.getAction().getStrokeColor()) {
            Drawable background = tagView.getBackground();
            GradientDrawable gradientDrawable = background instanceof GradientDrawable ? (GradientDrawable) background : null;
            if (gradientDrawable != null) {
                gradientDrawable.setColor(graffitiTag.getAction().getStrokeColor());
                tagView.setBackground(gradientDrawable);
            }
        }
    }

    public final void clear() {
        this.mHandler.removeCallbacksAndMessages((Object) null);
        if (!this.dataMap.isEmpty()) {
            this.dataMap.clear();
        }
        removeAllViews();
    }

    public final void destroy() {
        this.mHandler.removeCallbacksAndMessages((Object) null);
        if (!this.dataMap.isEmpty()) {
            this.dataMap.clear();
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/canvastriplescreen/graffiti/GraffitiTagView$GraffitiTag;", "Ljava/lang/Runnable;", "name", "", "color", "", "action", "Lcom/xueersi/lib/graffiti/WXWBAction;", "tagView", "Landroid/widget/TextView;", "(Ljava/lang/String;ILcom/xueersi/lib/graffiti/WXWBAction;Landroid/widget/TextView;)V", "getAction", "()Lcom/xueersi/lib/graffiti/WXWBAction;", "setAction", "(Lcom/xueersi/lib/graffiti/WXWBAction;)V", "getColor", "()I", "getName", "()Ljava/lang/String;", "getTagView", "()Landroid/widget/TextView;", "setTagView", "(Landroid/widget/TextView;)V", "run", "", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: GraffitiPluginView.kt */
    public static final class GraffitiTag implements Runnable {
        private WXWBAction action;
        private final int color;
        private final String name;
        private TextView tagView;

        public GraffitiTag(String str, int i, WXWBAction wXWBAction, TextView textView) {
            Intrinsics.checkNotNullParameter(str, "name");
            Intrinsics.checkNotNullParameter(wXWBAction, "action");
            this.name = str;
            this.color = i;
            this.action = wXWBAction;
            this.tagView = textView;
        }

        public final String getName() {
            return this.name;
        }

        public final int getColor() {
            return this.color;
        }

        public final WXWBAction getAction() {
            return this.action;
        }

        public final void setAction(WXWBAction wXWBAction) {
            Intrinsics.checkNotNullParameter(wXWBAction, "<set-?>");
            this.action = wXWBAction;
        }

        public final TextView getTagView() {
            return this.tagView;
        }

        public final void setTagView(TextView textView) {
            this.tagView = textView;
        }

        public void run() {
            TextView textView = this.tagView;
            if (textView != null && textView.getVisibility() == 0) {
                textView.setVisibility(4);
            }
        }
    }
}
