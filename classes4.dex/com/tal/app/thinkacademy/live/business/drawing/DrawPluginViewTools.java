package com.tal.app.thinkacademy.live.business.drawing;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import com.tal.app.thinkacademy.lib.util.TimeUtils;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.continuous.window.AwardType;
import com.tal.app.thinkacademy.live.business.continuous.window.SubmitResultParams;
import com.tal.app.thinkacademy.live.business.continuous.window.SubmitResultView;
import com.tal.app.thinkacademy.live.core.plugin.pluginview.BaseLivePluginView;
import java.lang.ref.WeakReference;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0013\u0018\u0000 42\u00020\u0001:\u000245B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u001f\u001a\u00020 J\u0006\u0010!\u001a\u00020 J\b\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020 H\u0002J\u0006\u0010%\u001a\u00020 J\b\u0010&\u001a\u00020 H\u0002J\b\u0010'\u001a\u00020 H\u0016J\u0010\u0010(\u001a\u00020 2\u0006\u0010)\u001a\u00020\nH\u0002J\u000e\u0010*\u001a\u00020 2\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010+\u001a\u00020 2\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010,\u001a\u00020 J!\u0010-\u001a\u00020 2\b\u0010.\u001a\u0004\u0018\u00010#2\b\u0010/\u001a\u0004\u0018\u00010#H\u0007¢\u0006\u0002\u00100J!\u00101\u001a\u00020 2\b\u0010.\u001a\u0004\u0018\u00010#2\b\u0010/\u001a\u0004\u0018\u00010#H\u0007¢\u0006\u0002\u00100J\b\u00102\u001a\u00020 H\u0002J\b\u00103\u001a\u00020 H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0017X.¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/drawing/DrawPluginViewTools;", "Lcom/tal/app/thinkacademy/live/core/plugin/pluginview/BaseLivePluginView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "bluePaint", "Landroid/widget/ImageView;", "bluePaintTools", "Lcom/tal/app/thinkacademy/live/business/drawing/DrawTools;", "currTools", "Landroid/view/View;", "driver", "Lcom/tal/app/thinkacademy/live/business/drawing/DrawPluginDriver;", "eraser", "eraserTools", "graffitiBean", "Lcom/tal/app/thinkacademy/live/business/drawing/GraffitiBean;", "layout_failed", "mSubmitResultView", "Lcom/tal/app/thinkacademy/live/business/continuous/window/SubmitResultView;", "redPaint", "redPaintTools", "tv_min", "Landroid/widget/TextView;", "tv_sec", "tv_submit", "v_right", "vis_group", "Landroidx/constraintlayout/widget/Group;", "yellowPaint", "yellowPaintTools", "destroy", "", "destroyPlugin", "getLayoutId", "", "initClickListener", "initDefaultTools", "initViewData", "initViews", "selectNewDrawTools", "tools", "setBean", "setDriver", "showFailed", "showHandsUpView", "userLatestCoin", "coins", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "showResult", "startCountDown", "updateTime", "Companion", "TimeHandle", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DrawPluginViewTools.kt */
public final class DrawPluginViewTools extends BaseLivePluginView {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final int msg_countdown = 1;
    /* access modifiers changed from: private */
    public static final int msg_failed = 3;
    /* access modifiers changed from: private */
    public static final int msg_handsup = 4;
    /* access modifiers changed from: private */
    public static final int msg_result = 2;
    /* access modifiers changed from: private */
    public static int realTime;
    /* access modifiers changed from: private */
    public static TimeHandle timeHandle;
    private ImageView bluePaint;
    private final DrawTools bluePaintTools;
    private View currTools;
    private DrawPluginDriver driver;
    private ImageView eraser;
    private final DrawTools eraserTools;
    private GraffitiBean graffitiBean;
    private View layout_failed;
    /* access modifiers changed from: private */
    public SubmitResultView mSubmitResultView;
    private ImageView redPaint;
    private final DrawTools redPaintTools;
    private TextView tv_min;
    private TextView tv_sec;
    private TextView tv_submit;
    private View v_right;
    private Group vis_group;
    private ImageView yellowPaint;
    private final DrawTools yellowPaintTools;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DrawPluginViewTools(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        ImageView imageView = this.yellowPaint;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("yellowPaint");
            imageView = null;
        }
        this.currTools = imageView;
        this.yellowPaintTools = new DrawTools(0, "#FFFFCF1B");
        this.redPaintTools = new DrawTools(0, "#FFFF503F");
        this.bluePaintTools = new DrawTools(0, "#FF1572FF");
        this.eraserTools = new DrawTools(1, (String) null);
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\r\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0006\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/drawing/DrawPluginViewTools$Companion;", "", "()V", "msg_countdown", "", "getMsg_countdown", "()I", "msg_failed", "getMsg_failed", "msg_handsup", "getMsg_handsup", "msg_result", "getMsg_result", "realTime", "getRealTime", "setRealTime", "(I)V", "timeHandle", "Lcom/tal/app/thinkacademy/live/business/drawing/DrawPluginViewTools$TimeHandle;", "getTimeHandle", "()Lcom/tal/app/thinkacademy/live/business/drawing/DrawPluginViewTools$TimeHandle;", "setTimeHandle", "(Lcom/tal/app/thinkacademy/live/business/drawing/DrawPluginViewTools$TimeHandle;)V", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: DrawPluginViewTools.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final TimeHandle getTimeHandle() {
            return DrawPluginViewTools.timeHandle;
        }

        public final void setTimeHandle(TimeHandle timeHandle) {
            DrawPluginViewTools.timeHandle = timeHandle;
        }

        public final int getRealTime() {
            return DrawPluginViewTools.realTime;
        }

        public final void setRealTime(int i) {
            DrawPluginViewTools.realTime = i;
        }

        public final int getMsg_countdown() {
            return DrawPluginViewTools.msg_countdown;
        }

        public final int getMsg_result() {
            return DrawPluginViewTools.msg_result;
        }

        public final int getMsg_failed() {
            return DrawPluginViewTools.msg_failed;
        }

        public final int getMsg_handsup() {
            return DrawPluginViewTools.msg_handsup;
        }
    }

    public int getLayoutId() {
        return R.layout.live_business_drawing_tools;
    }

    public void initViews() {
        DrawPluginViewTools.super.initViews();
        View findViewById = findViewById(R.id.live_business_v_draw_right);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.live_business_v_draw_right)");
        this.v_right = findViewById;
        View findViewById2 = findViewById(R.id.live_business_iv_yellow_paint);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.live_business_iv_yellow_paint)");
        this.yellowPaint = (ImageView) findViewById2;
        View findViewById3 = findViewById(R.id.live_business_iv_red_paint);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.live_business_iv_red_paint)");
        this.redPaint = (ImageView) findViewById3;
        View findViewById4 = findViewById(R.id.live_business_iv_blue_paint);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.live_business_iv_blue_paint)");
        this.bluePaint = (ImageView) findViewById4;
        View findViewById5 = findViewById(R.id.live_business_iv_eraser);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.live_business_iv_eraser)");
        this.eraser = (ImageView) findViewById5;
        View findViewById6 = findViewById(R.id.live_business_tv_draw_min);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.live_business_tv_draw_min)");
        this.tv_min = (TextView) findViewById6;
        View findViewById7 = findViewById(R.id.live_business_tv_draw_sec);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.live_business_tv_draw_sec)");
        this.tv_sec = (TextView) findViewById7;
        View findViewById8 = findViewById(R.id.live_business_tv_draw_submit);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.live_business_tv_draw_submit)");
        this.tv_submit = (TextView) findViewById8;
        Group findViewById9 = findViewById(R.id.live_business_group_draw);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById(R.id.live_business_group_draw)");
        this.vis_group = findViewById9;
        this.mSubmitResultView = (SubmitResultView) findViewById(R.id.submit_result_view);
        View findViewById10 = findViewById(R.id.live_business_layout_failed);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "findViewById(R.id.live_business_layout_failed)");
        this.layout_failed = findViewById10;
        initClickListener();
        Looper mainLooper = Looper.getMainLooper();
        Intrinsics.checkNotNullExpressionValue(mainLooper, "getMainLooper()");
        timeHandle = new TimeHandle(mainLooper);
    }

    private final void initClickListener() {
        ImageView imageView = this.yellowPaint;
        TextView textView = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("yellowPaint");
            imageView = null;
        }
        imageView.setOnClickListener(new DrawPluginViewTools$$ExternalSyntheticLambda1(this));
        ImageView imageView2 = this.redPaint;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("redPaint");
            imageView2 = null;
        }
        imageView2.setOnClickListener(new DrawPluginViewTools$$ExternalSyntheticLambda4(this));
        ImageView imageView3 = this.bluePaint;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bluePaint");
            imageView3 = null;
        }
        imageView3.setOnClickListener(new DrawPluginViewTools$$ExternalSyntheticLambda0(this));
        ImageView imageView4 = this.eraser;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("eraser");
            imageView4 = null;
        }
        imageView4.setOnClickListener(new DrawPluginViewTools$$ExternalSyntheticLambda2(this));
        TextView textView2 = this.tv_submit;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tv_submit");
        } else {
            textView = textView2;
        }
        textView.setOnClickListener(new DrawPluginViewTools$$ExternalSyntheticLambda3(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: initClickListener$lambda-0  reason: not valid java name */
    public static final void m214initClickListener$lambda0(DrawPluginViewTools drawPluginViewTools, View view) {
        Intrinsics.checkNotNullParameter(drawPluginViewTools, "this$0");
        if (Intrinsics.areEqual(drawPluginViewTools.currTools, view)) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        DrawPluginDriver drawPluginDriver = drawPluginViewTools.driver;
        if (drawPluginDriver == null) {
            Intrinsics.throwUninitializedPropertyAccessException("driver");
            drawPluginDriver = null;
        }
        drawPluginDriver.setDrawTools(drawPluginViewTools.yellowPaintTools);
        Intrinsics.checkNotNullExpressionValue(view, "it");
        drawPluginViewTools.selectNewDrawTools(view);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: initClickListener$lambda-1  reason: not valid java name */
    public static final void m215initClickListener$lambda1(DrawPluginViewTools drawPluginViewTools, View view) {
        Intrinsics.checkNotNullParameter(drawPluginViewTools, "this$0");
        if (Intrinsics.areEqual(drawPluginViewTools.currTools, view)) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        DrawPluginDriver drawPluginDriver = drawPluginViewTools.driver;
        if (drawPluginDriver == null) {
            Intrinsics.throwUninitializedPropertyAccessException("driver");
            drawPluginDriver = null;
        }
        drawPluginDriver.setDrawTools(drawPluginViewTools.redPaintTools);
        Intrinsics.checkNotNullExpressionValue(view, "it");
        drawPluginViewTools.selectNewDrawTools(view);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: initClickListener$lambda-2  reason: not valid java name */
    public static final void m216initClickListener$lambda2(DrawPluginViewTools drawPluginViewTools, View view) {
        Intrinsics.checkNotNullParameter(drawPluginViewTools, "this$0");
        if (Intrinsics.areEqual(drawPluginViewTools.currTools, view)) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        DrawPluginDriver drawPluginDriver = drawPluginViewTools.driver;
        if (drawPluginDriver == null) {
            Intrinsics.throwUninitializedPropertyAccessException("driver");
            drawPluginDriver = null;
        }
        drawPluginDriver.setDrawTools(drawPluginViewTools.bluePaintTools);
        Intrinsics.checkNotNullExpressionValue(view, "it");
        drawPluginViewTools.selectNewDrawTools(view);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: initClickListener$lambda-3  reason: not valid java name */
    public static final void m217initClickListener$lambda3(DrawPluginViewTools drawPluginViewTools, View view) {
        Intrinsics.checkNotNullParameter(drawPluginViewTools, "this$0");
        if (Intrinsics.areEqual(drawPluginViewTools.currTools, view)) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        DrawPluginDriver drawPluginDriver = drawPluginViewTools.driver;
        if (drawPluginDriver == null) {
            Intrinsics.throwUninitializedPropertyAccessException("driver");
            drawPluginDriver = null;
        }
        drawPluginDriver.setDrawTools(drawPluginViewTools.eraserTools);
        Intrinsics.checkNotNullExpressionValue(view, "it");
        drawPluginViewTools.selectNewDrawTools(view);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: initClickListener$lambda-4  reason: not valid java name */
    public static final void m218initClickListener$lambda4(DrawPluginViewTools drawPluginViewTools, View view) {
        Intrinsics.checkNotNullParameter(drawPluginViewTools, "this$0");
        DrawPluginDriver drawPluginDriver = drawPluginViewTools.driver;
        if (drawPluginDriver == null) {
            Intrinsics.throwUninitializedPropertyAccessException("driver");
            drawPluginDriver = null;
        }
        drawPluginDriver.submit();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    private final void selectNewDrawTools(View view) {
        if (view.getId() != this.currTools.getId()) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ViewGroup.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            layoutParams2.topMargin = SizeUtils.dp2px(10.0f);
            view.setLayoutParams(layoutParams2);
            ViewGroup.LayoutParams layoutParams3 = this.currTools.getLayoutParams();
            Objects.requireNonNull(layoutParams3, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ViewGroup.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) layoutParams3;
            layoutParams4.topMargin = SizeUtils.dp2px(25.0f);
            this.currTools.setLayoutParams(layoutParams4);
            this.currTools = view;
        }
    }

    public final void setBean(GraffitiBean graffitiBean2) {
        Intrinsics.checkNotNullParameter(graffitiBean2, "graffitiBean");
        this.graffitiBean = graffitiBean2;
        initViewData();
        startCountDown();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: com.tal.app.thinkacademy.live.business.drawing.GraffitiBean} */
    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v1, types: [android.view.View] */
    /* JADX WARNING: type inference failed for: r2v2 */
    /* JADX WARNING: type inference failed for: r2v4 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void initViewData() {
        /*
            r4 = this;
            com.tal.app.thinkacademy.live.business.drawing.GraffitiBean r0 = r4.graffitiBean
            java.lang.String r1 = "graffitiBean"
            r2 = 0
            if (r0 != 0) goto L_0x000b
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r0 = r2
        L_0x000b:
            boolean r0 = r0.isRevise()
            java.lang.String r3 = "vis_group"
            if (r0 != 0) goto L_0x006d
            androidx.constraintlayout.widget.Group r0 = r4.vis_group
            if (r0 != 0) goto L_0x001b
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            r0 = r2
        L_0x001b:
            r3 = 0
            r0.setVisibility(r3)
            com.tal.app.thinkacademy.live.business.drawing.GraffitiBean r0 = r4.graffitiBean
            if (r0 != 0) goto L_0x0027
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r0 = r2
        L_0x0027:
            int r0 = r0.getRealCountDownTime()
            realTime = r0
            android.widget.TextView r0 = r4.tv_min
            if (r0 != 0) goto L_0x0037
            java.lang.String r0 = "tv_min"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            r0 = r2
        L_0x0037:
            com.tal.app.thinkacademy.live.business.drawing.GraffitiBean r3 = r4.graffitiBean
            if (r3 != 0) goto L_0x003f
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r3 = r2
        L_0x003f:
            int r3 = r3.getRealCountDownTime()
            java.lang.String r3 = com.tal.app.thinkacademy.lib.util.TimeUtils.generateTime_min(r3)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r0.setText(r3)
            android.widget.TextView r0 = r4.tv_sec
            if (r0 != 0) goto L_0x0056
            java.lang.String r0 = "tv_sec"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            r0 = r2
        L_0x0056:
            com.tal.app.thinkacademy.live.business.drawing.GraffitiBean r3 = r4.graffitiBean
            if (r3 != 0) goto L_0x005e
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            goto L_0x005f
        L_0x005e:
            r2 = r3
        L_0x005f:
            int r1 = r2.getRealCountDownTime()
            java.lang.String r1 = com.tal.app.thinkacademy.lib.util.TimeUtils.generateTime_sec(r1)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
            goto L_0x009c
        L_0x006d:
            androidx.constraintlayout.widget.Group r0 = r4.vis_group
            if (r0 != 0) goto L_0x0075
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            r0 = r2
        L_0x0075:
            r1 = 8
            r0.setVisibility(r1)
            android.view.View r0 = r4.v_right
            java.lang.String r1 = "v_right"
            if (r0 != 0) goto L_0x0084
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r0 = r2
        L_0x0084:
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            r3 = 1118437376(0x42aa0000, float:85.0)
            int r3 = com.tal.app.thinkacademy.lib.util.SizeUtils.dp2px(r3)
            r0.width = r3
            android.view.View r3 = r4.v_right
            if (r3 != 0) goto L_0x0098
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            goto L_0x0099
        L_0x0098:
            r2 = r3
        L_0x0099:
            r2.setLayoutParams(r0)
        L_0x009c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.drawing.DrawPluginViewTools.initViewData():void");
    }

    private final void startCountDown() {
        WeakReference weakReference = new WeakReference(this);
        TimeHandle timeHandle2 = timeHandle;
        if (timeHandle2 != null) {
            timeHandle2.setView((DrawPluginViewTools) weakReference.get());
            timeHandle2.sendEmptyMessage(msg_countdown);
        }
    }

    public final void showResult(Integer num, Integer num2) {
        int i;
        if (num2 != null && num2.intValue() > 0) {
            SubmitResultView submitResultView = this.mSubmitResultView;
            if (submitResultView != null) {
                submitResultView.setLogTag(Tag.GRAFFITI_DRAW_BOARD);
            }
            SubmitResultView submitResultView2 = this.mSubmitResultView;
            if (submitResultView2 != null) {
                AwardType awardType = AwardType.UPLOAD;
                if (num == null) {
                    i = 0;
                } else {
                    i = num.intValue();
                }
                submitResultView2.setParams(new SubmitResultParams(awardType, i, num2.intValue(), 0, false, 24, (DefaultConstructorMarker) null));
            }
            SubmitResultView submitResultView3 = this.mSubmitResultView;
            if (submitResultView3 != null) {
                SubmitResultView.show$default(submitResultView3, (Function0) null, 1, (Object) null);
            }
            TimeHandle timeHandle2 = timeHandle;
            if (timeHandle2 != null) {
                timeHandle2.sendEmptyMessageDelayed(msg_result, 3000);
            }
        }
    }

    public final void showHandsUpView(Integer num, Integer num2) {
        TextView textView = this.tv_submit;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tv_submit");
            textView = null;
        }
        int i = 0;
        textView.setEnabled(false);
        TextView textView2 = this.tv_submit;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tv_submit");
            textView2 = null;
        }
        textView2.setText("");
        TextView textView3 = this.tv_submit;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tv_submit");
            textView3 = null;
        }
        textView3.setBackgroundResource(R.drawable.bg_live_business_draw_handsup_success);
        if (num2 != null && num2.intValue() > 0) {
            SubmitResultView submitResultView = this.mSubmitResultView;
            if (submitResultView != null) {
                submitResultView.setLogTag(Tag.GRAFFITI_DRAW_BOARD);
            }
            SubmitResultView submitResultView2 = this.mSubmitResultView;
            if (submitResultView2 != null) {
                AwardType awardType = AwardType.UPLOAD;
                if (num != null) {
                    i = num.intValue();
                }
                submitResultView2.setParams(new SubmitResultParams(awardType, i, num2.intValue(), 0, false, 24, (DefaultConstructorMarker) null));
            }
            SubmitResultView submitResultView3 = this.mSubmitResultView;
            if (submitResultView3 != null) {
                SubmitResultView.show$default(submitResultView3, (Function0) null, 1, (Object) null);
            }
            TimeHandle timeHandle2 = timeHandle;
            if (timeHandle2 != null) {
                timeHandle2.sendEmptyMessageDelayed(msg_handsup, 3000);
            }
        }
    }

    public final void destroyPlugin() {
        DrawPluginDriver drawPluginDriver = this.driver;
        if (drawPluginDriver == null) {
            Intrinsics.throwUninitializedPropertyAccessException("driver");
            drawPluginDriver = null;
        }
        drawPluginDriver.destroyPlugin();
    }

    public final void showFailed() {
        View view = this.layout_failed;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layout_failed");
            view = null;
        }
        view.setVisibility(0);
        TimeHandle timeHandle2 = timeHandle;
        if (timeHandle2 != null) {
            timeHandle2.sendEmptyMessageDelayed(msg_failed, 3000);
        }
    }

    /* access modifiers changed from: private */
    public final void updateTime() {
        if (realTime < 0) {
            realTime = 0;
        }
        TextView textView = this.tv_min;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tv_min");
            textView = null;
        }
        textView.setText(TimeUtils.generateTime_min(realTime));
        TextView textView3 = this.tv_sec;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tv_sec");
        } else {
            textView2 = textView3;
        }
        textView2.setText(TimeUtils.generateTime_sec(realTime));
    }

    public final void setDriver(DrawPluginDriver drawPluginDriver) {
        Intrinsics.checkNotNullParameter(drawPluginDriver, "driver");
        this.driver = drawPluginDriver;
    }

    public final void initDefaultTools() {
        DrawPluginDriver drawPluginDriver = this.driver;
        if (drawPluginDriver == null) {
            Intrinsics.throwUninitializedPropertyAccessException("driver");
            drawPluginDriver = null;
        }
        drawPluginDriver.setDrawTools(this.yellowPaintTools);
    }

    public final void destroy() {
        TimeHandle timeHandle2 = timeHandle;
        if (timeHandle2 != null) {
            timeHandle2.removeCallbacksAndMessages((Object) null);
        }
        timeHandle = null;
        removeAllViews();
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/drawing/DrawPluginViewTools$TimeHandle;", "Landroid/os/Handler;", "loop", "Landroid/os/Looper;", "(Landroid/os/Looper;)V", "view", "Lcom/tal/app/thinkacademy/live/business/drawing/DrawPluginViewTools;", "getView", "()Lcom/tal/app/thinkacademy/live/business/drawing/DrawPluginViewTools;", "setView", "(Lcom/tal/app/thinkacademy/live/business/drawing/DrawPluginViewTools;)V", "handleMessage", "", "msg", "Landroid/os/Message;", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: DrawPluginViewTools.kt */
    public static final class TimeHandle extends Handler {
        private DrawPluginViewTools view;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public TimeHandle(Looper looper) {
            super(looper);
            Intrinsics.checkNotNullParameter(looper, "loop");
        }

        public final DrawPluginViewTools getView() {
            return this.view;
        }

        public final void setView(DrawPluginViewTools drawPluginViewTools) {
            this.view = drawPluginViewTools;
        }

        public void handleMessage(Message message) {
            AsynchronousInstrumentation.handlerMessageBegin(this, message);
            Intrinsics.checkNotNullParameter(message, "msg");
            super.handleMessage(message);
            int i = message.what;
            if (i == DrawPluginViewTools.Companion.getMsg_countdown()) {
                Companion companion = DrawPluginViewTools.Companion;
                int realTime = companion.getRealTime();
                companion.setRealTime(realTime - 1);
                if (realTime >= 1) {
                    DrawPluginViewTools drawPluginViewTools = this.view;
                    if (drawPluginViewTools != null) {
                        drawPluginViewTools.updateTime();
                    }
                    sendEmptyMessageDelayed(DrawPluginViewTools.Companion.getMsg_countdown(), 1000);
                }
            } else if (i == DrawPluginViewTools.Companion.getMsg_result()) {
                DrawPluginViewTools drawPluginViewTools2 = this.view;
                if (drawPluginViewTools2 != null) {
                    drawPluginViewTools2.destroyPlugin();
                }
            } else if (i == DrawPluginViewTools.Companion.getMsg_failed()) {
                DrawPluginViewTools drawPluginViewTools3 = this.view;
                if (drawPluginViewTools3 != null) {
                    drawPluginViewTools3.destroyPlugin();
                }
            } else if (i == DrawPluginViewTools.Companion.getMsg_handsup()) {
                DrawPluginViewTools drawPluginViewTools4 = this.view;
                SubmitResultView access$getMSubmitResultView$p = drawPluginViewTools4 == null ? null : drawPluginViewTools4.mSubmitResultView;
                if (access$getMSubmitResultView$p != null) {
                    access$getMSubmitResultView$p.setVisibility(8);
                }
            }
            AsynchronousInstrumentation.handlerMessageEnd();
        }
    }
}
