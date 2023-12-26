package com.tal.app.thinkacademy.business.bus_hummer;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.SystemClock;
import com.didi.hummer.adapter.navigator.NavPage;
import com.didi.hummer.context.HummerContext;
import com.didi.hummer.core.engine.JSValue;
import com.didi.hummer.register.HummerRegister$;
import com.tal.app.thinkacademy.business.bus_hummer.base.HwBaseHummerActivity;
import com.tal.app.thinkacademy.business.bus_hummer.track.HummerTrack;
import com.tal.app.thinkacademy.common.util.HwLanguageUtil;
import com.tal.app.thinkacademy.lib.commui.widget.bar.TitleBar;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0014J\b\u0010\u0007\u001a\u00020\u0006H\u0014J\u0012\u0010\b\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0014J\u0014\u0010\u000b\u001a\u00020\u00062\n\u0010\f\u001a\u00060\rj\u0002`\u000eH\u0014J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0012H\u0014J\u001a\u0010\u0013\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/tal/app/thinkacademy/business/bus_hummer/HwHummerActivity;", "Lcom/tal/app/thinkacademy/business/bus_hummer/base/HwBaseHummerActivity;", "()V", "mPageStartTime", "", "initData", "", "initHummer", "initHummerRegister", "context", "Lcom/didi/hummer/context/HummerContext;", "onPageRenderFailed", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onPageRenderSucceed", "hmContext", "jsPage", "Lcom/didi/hummer/core/engine/JSValue;", "setTopBarTitle", "str", "", "color", "Companion", "bus_hummer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HwHummerActivity.kt */
public final class HwHummerActivity extends HwBaseHummerActivity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Tag TAG = Tag.HUMMER_PAGE;
    private long mPageStartTime;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: HwHummerActivity.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[HwLanguageUtil.HwLanguageInfo.values().length];
            iArr[HwLanguageUtil.HwLanguageInfo.CHINESE.ordinal()] = 1;
            iArr[HwLanguageUtil.HwLanguageInfo.ENGLISH.ordinal()] = 2;
            iArr[HwLanguageUtil.HwLanguageInfo.CHINESE_HK.ordinal()] = 3;
            iArr[HwLanguageUtil.HwLanguageInfo.ENGLISH_UK.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nJ$\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/tal/app/thinkacademy/business/bus_hummer/HwHummerActivity$Companion;", "", "()V", "TAG", "Lcom/tal/app/thinkacademy/business/bus_hummer/Tag;", "startHwHummerActivity", "", "context", "Landroid/content/Context;", "page", "Lcom/didi/hummer/adapter/navigator/NavPage;", "url", "", "data", "bus_hummer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: HwHummerActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void startHwHummerActivity(Context context, NavPage navPage) {
            Unit unit;
            Intrinsics.checkNotNullParameter(navPage, "page");
            if (context == null) {
                unit = null;
            } else {
                Intent intent = new Intent(context, HwHummerActivity.class);
                intent.putExtra("PAGE_ID", navPage.id);
                intent.putExtra("PAGE_MODEL", (Serializable) navPage);
                context.startActivity(intent);
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                Companion companion = this;
                XesLog.e(HwHummerActivity.TAG, new Object[]{"启动hummer页面失败，context is null"});
            }
        }

        public final void startHwHummerActivity(Context context, String str, String str2) {
            Unit unit;
            if (context == null) {
                unit = null;
            } else {
                Intent intent = new Intent(context, HwHummerActivity.class);
                Serializable navPage = new NavPage(str);
                navPage.params = new HashMap();
                navPage.params.put("hwData", str2);
                intent.putExtra("PAGE_ID", navPage.id);
                intent.putExtra("PAGE_MODEL", navPage);
                context.startActivity(intent);
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                Companion companion = this;
                XesLog.e(HwHummerActivity.TAG, new Object[]{"启动hummer页面失败，context is null"});
            }
        }
    }

    /* access modifiers changed from: protected */
    public void initHummerRegister(HummerContext hummerContext) {
        Unit unit;
        String str;
        super.initHummerRegister(hummerContext);
        if (hummerContext == null) {
            unit = null;
        } else {
            HummerRegister$.bus_hummer.init(hummerContext);
            int i = WhenMappings.$EnumSwitchMapping$0[HwLanguageUtil.INSTANCE.getCurrentLanguage().ordinal()];
            if (i == 1) {
                str = "zh";
            } else if (i == 2) {
                str = "en";
            } else if (i == 3) {
                str = "zhHK";
            } else if (i == 4) {
                str = "enGB";
            } else {
                throw new NoWhenBranchMatchedException();
            }
            hummerContext.updateEnv("language", str);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            HwHummerActivity hwHummerActivity = this;
            XesLog.e(TAG, new Object[]{"initHummerRegister context is null"});
        }
    }

    /* access modifiers changed from: protected */
    public void initHummer() {
        super.initHummer();
    }

    /* access modifiers changed from: protected */
    public void initData() {
        Unit unit;
        super.initData();
        this.mPageStartTime = SystemClock.elapsedRealtime();
        if (this.page == null) {
            unit = null;
        } else {
            XesLog.i(TAG, new Object[]{Intrinsics.stringPlus("page = ", this.page)});
            HummerTrack.hw_hummer_page$default(HummerTrack.INSTANCE, HummerTrack.HummerPageActionType.START, this.page.url, 0, (String) null, 8, (Object) null);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            HwHummerActivity hwHummerActivity = this;
            XesLog.e(TAG, new Object[]{"page is null"});
        }
    }

    /* access modifiers changed from: protected */
    public void onPageRenderSucceed(HummerContext hummerContext, JSValue jSValue) {
        Intrinsics.checkNotNullParameter(hummerContext, "hmContext");
        Intrinsics.checkNotNullParameter(jSValue, "jsPage");
        super.onPageRenderSucceed(hummerContext, jSValue);
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.mPageStartTime;
        XesLog.s(TAG, new Object[]{Intrinsics.stringPlus("渲染成功,耗时=", Long.valueOf(elapsedRealtime))});
        HummerTrack.hw_hummer_page$default(HummerTrack.INSTANCE, HummerTrack.HummerPageActionType.SUCCESS, this.page.url, elapsedRealtime, (String) null, 8, (Object) null);
    }

    /* access modifiers changed from: protected */
    public void onPageRenderFailed(Exception exc) {
        Intrinsics.checkNotNullParameter(exc, "e");
        super.onPageRenderFailed(exc);
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.mPageStartTime;
        XesLog.e(TAG, new Object[]{"渲染失败,耗时=" + elapsedRealtime + ",错误信息=" + exc});
        HummerTrack.INSTANCE.hw_hummer_page(HummerTrack.HummerPageActionType.FAILED, this.page.url, elapsedRealtime, String.valueOf(exc));
    }

    public final void setTopBarTitle(String str, String str2) {
        TitleBar titleBar = this.mTitleBar;
        if (titleBar != null) {
            titleBar.setTitle(str);
        }
        if (str2 != null) {
            try {
                int parseColor = Color.parseColor(str2);
                TitleBar titleBar2 = this.mTitleBar;
                if (titleBar2 != null) {
                    titleBar2.setBackgroundColor(parseColor);
                    Unit unit = Unit.INSTANCE;
                }
            } catch (Exception e) {
                XesLog.e(TAG, new Object[]{Intrinsics.stringPlus("设置topbar背景颜色失败:", e)});
                Unit unit2 = Unit.INSTANCE;
            }
        }
    }
}
