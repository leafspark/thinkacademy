package com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.drawing.DrawTools;
import com.tal.app.thinkacademy.live.core.plugin.pluginview.BaseLivePluginView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0016\u001a\u00020\bJ\u0010\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u000eH\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\bH\u0002J\b\u0010\u001c\u001a\u00020\bH\u0016R(\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/canvastriplescreen/graffiti/GraffitiDrawToolsView;", "Lcom/tal/app/thinkacademy/live/core/plugin/pluginview/BaseLivePluginView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "callback", "Lkotlin/Function1;", "Lcom/tal/app/thinkacademy/live/business/drawing/DrawTools;", "", "getCallback", "()Lkotlin/jvm/functions/Function1;", "setCallback", "(Lkotlin/jvm/functions/Function1;)V", "currTools", "Landroid/view/View;", "eraser", "Landroid/widget/ImageView;", "eraserTools", "redPaint", "redPaintTools", "yellowPaint", "yellowPaintTools", "chooseDefault", "clickTools", "tools", "getLayoutId", "", "initClickListener", "initViews", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GraffitiPluginView.kt */
public final class GraffitiDrawToolsView extends BaseLivePluginView {
    private Function1<? super DrawTools, Unit> callback;
    private View currTools;
    private ImageView eraser;
    private final DrawTools eraserTools = new DrawTools(1, (String) null);
    private ImageView redPaint;
    private final DrawTools redPaintTools = new DrawTools(0, "#FFFF503F");
    private ImageView yellowPaint;
    private final DrawTools yellowPaintTools = new DrawTools(0, "#FFFFCF1B");

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GraffitiDrawToolsView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final Function1<DrawTools, Unit> getCallback() {
        return this.callback;
    }

    public final void setCallback(Function1<? super DrawTools, Unit> function1) {
        this.callback = function1;
    }

    private final void clickTools(View view) {
        DrawTools drawTools;
        int id = view.getId();
        View view2 = this.currTools;
        boolean z = false;
        if (view2 != null && id == view2.getId()) {
            z = true;
        }
        if (!z && !Intrinsics.areEqual(this.currTools, view)) {
            view.setTranslationY((float) SizeUtils.dp2px(0.0f));
            View view3 = this.currTools;
            if (view3 != null) {
                view3.setTranslationY((float) SizeUtils.dp2px(14.0f));
            }
            this.currTools = view;
            Function1<? super DrawTools, Unit> function1 = this.callback;
            if (function1 != null) {
                ImageView imageView = this.yellowPaint;
                ImageView imageView2 = null;
                if (imageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("yellowPaint");
                    imageView = null;
                }
                if (Intrinsics.areEqual(view, imageView)) {
                    drawTools = this.yellowPaintTools;
                } else {
                    ImageView imageView3 = this.redPaint;
                    if (imageView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("redPaint");
                    } else {
                        imageView2 = imageView3;
                    }
                    if (Intrinsics.areEqual(view, imageView2)) {
                        drawTools = this.redPaintTools;
                    } else {
                        drawTools = this.eraserTools;
                    }
                }
                function1.invoke(drawTools);
            }
        }
    }

    public final void chooseDefault() {
        ImageView imageView = this.yellowPaint;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("yellowPaint");
            imageView = null;
        }
        clickTools(imageView);
    }

    public int getLayoutId() {
        return R.layout.layout_graffiti_plugin_view_tool;
    }

    public void initViews() {
        View findViewById = findViewById(R.id.live_business_iv_yellow_paint);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.live_business_iv_yellow_paint)");
        this.yellowPaint = (ImageView) findViewById;
        View findViewById2 = findViewById(R.id.live_business_iv_red_paint);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.live_business_iv_red_paint)");
        this.redPaint = (ImageView) findViewById2;
        View findViewById3 = findViewById(R.id.live_business_iv_eraser);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.live_business_iv_eraser)");
        this.eraser = (ImageView) findViewById3;
        initClickListener();
    }

    private final void initClickListener() {
        ImageView imageView = this.yellowPaint;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("yellowPaint");
            imageView = null;
        }
        imageView.setOnClickListener(new GraffitiDrawToolsView$$ExternalSyntheticLambda0(this));
        ImageView imageView3 = this.redPaint;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("redPaint");
            imageView3 = null;
        }
        imageView3.setOnClickListener(new GraffitiDrawToolsView$$ExternalSyntheticLambda1(this));
        ImageView imageView4 = this.eraser;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("eraser");
        } else {
            imageView2 = imageView4;
        }
        imageView2.setOnClickListener(new GraffitiDrawToolsView$$ExternalSyntheticLambda2(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: initClickListener$lambda-0  reason: not valid java name */
    public static final void m187initClickListener$lambda0(GraffitiDrawToolsView graffitiDrawToolsView, View view) {
        Intrinsics.checkNotNullParameter(graffitiDrawToolsView, "this$0");
        Intrinsics.checkNotNullExpressionValue(view, "it");
        graffitiDrawToolsView.clickTools(view);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: initClickListener$lambda-1  reason: not valid java name */
    public static final void m188initClickListener$lambda1(GraffitiDrawToolsView graffitiDrawToolsView, View view) {
        Intrinsics.checkNotNullParameter(graffitiDrawToolsView, "this$0");
        Intrinsics.checkNotNullExpressionValue(view, "it");
        graffitiDrawToolsView.clickTools(view);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: initClickListener$lambda-2  reason: not valid java name */
    public static final void m189initClickListener$lambda2(GraffitiDrawToolsView graffitiDrawToolsView, View view) {
        Intrinsics.checkNotNullParameter(graffitiDrawToolsView, "this$0");
        Intrinsics.checkNotNullExpressionValue(view, "it");
        graffitiDrawToolsView.clickTools(view);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
