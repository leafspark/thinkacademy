package com.tal.app.thinkacademy.lib.commui.widget.pad;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tal.app.thinkacademy.lib.commui.R;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseDialog;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.AdaptScreenUtils;
import com.tal.app.thinkacademy.lib.util.constant.AppConfig;
import com.tal.app.thinkacademy.lib.utils.TableUtils;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0005\u001a\u00020\u0006\"\b\b\u0000\u0010\u0007*\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\n2\u0006\u0010\u000b\u001a\u00020\u0006H\u0007J\b\u0010\f\u001a\u00020\u0004H\u0007J\b\u0010\r\u001a\u00020\u0004H\u0007J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\bH\u0007J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\bH\u0007J\u000e\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0004J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017H\u0007J\u001a\u0010\u0019\u001a\u00020\u000f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0007J\u0010\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/tal/app/thinkacademy/lib/commui/widget/pad/PadAutoUtil;", "", "()V", "mCloseScreenLandscape", "", "adaptScreenResources", "Landroid/content/res/Resources;", "T", "Landroid/app/Activity;", "target", "Ljava/lang/Class;", "oldResult", "isAdaptPad", "isCloseScreenLandscape", "setupAutoScreenOrientation", "", "activity", "setupAutoViewCenter", "Landroid/view/View;", "view", "setupCloseScreenLandscape", "closeScreenLandscape", "setupDialogAutoLayoutGravity", "", "gravity", "setupDialogAutoLayoutParamsCenter", "params", "Landroid/view/ViewGroup$LayoutParams;", "dialog", "Lcom/tal/app/thinkacademy/lib/commui/baseview/dialog/BaseDialog;", "setupDialogAutoViewCenter", "lib_commui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PadAutoUtil.kt */
public final class PadAutoUtil {
    public static final PadAutoUtil INSTANCE = new PadAutoUtil();
    private static boolean mCloseScreenLandscape;

    private PadAutoUtil() {
    }

    public final void setupCloseScreenLandscape(boolean z) {
        mCloseScreenLandscape = z;
    }

    @JvmStatic
    public static final boolean isCloseScreenLandscape() {
        return mCloseScreenLandscape;
    }

    @JvmStatic
    public static final boolean isAdaptPad() {
        return !isCloseScreenLandscape() && TableUtils.isTable();
    }

    @JvmStatic
    public static final <T extends Activity> Resources adaptScreenResources(Class<T> cls, Resources resources) {
        Resources resources2;
        Intrinsics.checkNotNullParameter(cls, "target");
        Intrinsics.checkNotNullParameter(resources, "oldResult");
        if (resources.getConfiguration().orientation == 1) {
            Resources adaptRangeWidth = AdaptScreenUtils.adaptRangeWidth(resources, AppConfig.SCREEN_RESOLUTION_PORTRAIT_MAX, AppConfig.SCREEN_RESOLUTION_PORTRAIT_MIN);
            Intrinsics.checkNotNullExpressionValue(adaptRangeWidth, "{\n            //适配设计尺寸 w…N_PORTRAIT_MIN)\n        }");
            return adaptRangeWidth;
        }
        if (!isCloseScreenLandscape() && TableUtils.isTable() && cls.getAnnotation(NotPadAutoScreen.class) == null) {
            resources2 = AdaptScreenUtils.adaptWidth(resources, AppConfig.SCREEN_RESOLUTION_LANDSCAPE_PAD);
        } else if (TableUtils.isTable()) {
            resources2 = AdaptScreenUtils.adaptHeight(resources, AppConfig.SCREEN_RESOLUTION_PORTRAIT_PAD);
        } else {
            resources2 = AdaptScreenUtils.adaptRangeWidth(resources, 1000, 640);
        }
        Intrinsics.checkNotNullExpressionValue(resources2, "{\n            //NotPadAu…}\n            }\n        }");
        return resources2;
    }

    @JvmStatic
    public static final void setupAutoScreenOrientation(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (activity.getClass().getAnnotation(NotPadAutoScreen.class) != null) {
            return;
        }
        if (isCloseScreenLandscape() || !TableUtils.isTable()) {
            activity.setRequestedOrientation(1);
        } else {
            activity.setRequestedOrientation(0);
        }
    }

    @JvmStatic
    public static final View setupAutoViewCenter(View view, Activity activity) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(activity, "activity");
        PadAutoCenterScreen padAutoCenterScreen = (PadAutoCenterScreen) activity.getClass().getAnnotation(PadAutoCenterScreen.class);
        if (isCloseScreenLandscape() || !TableUtils.isTable() || padAutoCenterScreen == null) {
            return view;
        }
        PadAutoCenterView padAutoCenterView = new PadAutoCenterView(activity, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        padAutoCenterView.setCenterScale(padAutoCenterScreen.scale());
        padAutoCenterView.setDesignHeight(padAutoCenterScreen.designHeight());
        padAutoCenterView.addView(view);
        return padAutoCenterView;
    }

    @JvmStatic
    public static final void setupDialogAutoViewCenter(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        PadAutoUtil padAutoUtil = INSTANCE;
        if (!isCloseScreenLandscape()) {
            try {
                if (((view instanceof RelativeLayout) && ((RelativeLayout) view).getChildCount() == 1 ? padAutoUtil : null) != null) {
                    ViewGroup.LayoutParams layoutParams = ((RelativeLayout) view).getChildAt(0).getLayoutParams();
                    if (layoutParams != null) {
                        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                        if (layoutParams2.getRule(12) == -1) {
                            layoutParams2.removeRule(12);
                            layoutParams2.bottomMargin = 0;
                            view.setLayoutParams(layoutParams2);
                        }
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                    }
                }
                if (!(view.getBackground() instanceof ColorDrawable)) {
                    padAutoUtil = null;
                }
                if (padAutoUtil != null) {
                    view.setBackground((Drawable) null);
                }
            } catch (Exception e) {
                XesLog.et("pad横屏", Intrinsics.stringPlus("手动适配dialog view异常: ", e.getMessage()));
            }
        }
    }

    @JvmStatic
    public static final void setupDialogAutoLayoutParamsCenter(ViewGroup.LayoutParams layoutParams, BaseDialog baseDialog) {
        int i;
        Intrinsics.checkNotNullParameter(baseDialog, "dialog");
        if (!isCloseScreenLandscape()) {
            if (layoutParams == null) {
                i = 0;
            } else {
                if (layoutParams.width == -1) {
                    layoutParams.width = baseDialog.getContext().getResources().getDimensionPixelSize(R.dimen.size_343dp);
                    i = 1;
                } else {
                    i = 0;
                }
                if (layoutParams.height == -1) {
                    layoutParams.height = -2;
                    i++;
                }
            }
            if (i > 1) {
                baseDialog.canceledOnTouchOutside(false);
            }
        }
    }

    @JvmStatic
    public static final int setupDialogAutoLayoutGravity(int i) {
        if (!isCloseScreenLandscape() && i == 80) {
            return 17;
        }
        return i;
    }
}
