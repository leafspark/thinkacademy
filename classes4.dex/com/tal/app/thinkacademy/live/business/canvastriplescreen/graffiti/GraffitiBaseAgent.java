package com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaCompat;
import com.tal.app.thinkacademy.live.core.live.datastorage.RoomData;
import com.tal.app.thinkacademy.live.core.plugin.BaseLivePluginDriver;
import com.xueersi.lib.graffiti.WXTGraffitiEngine;
import com.xueersi.lib.graffiti.WXTGraffitiEngineImpl;
import com.xueersi.lib.graffiti.WXWBAction;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0010H\u0016J\b\u0010\u0015\u001a\u00020\u0013H\u0002R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0016"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/canvastriplescreen/graffiti/GraffitiBaseAgent;", "Lcom/tal/app/thinkacademy/live/business/canvastriplescreen/graffiti/GraffitiAgent;", "context", "Landroid/content/Context;", "driver", "Lcom/tal/app/thinkacademy/live/core/plugin/BaseLivePluginDriver;", "provider", "Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;", "(Landroid/content/Context;Lcom/tal/app/thinkacademy/live/core/plugin/BaseLivePluginDriver;Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;)V", "mGraffitiPluginView", "Lcom/tal/app/thinkacademy/live/business/canvastriplescreen/graffiti/GraffitiPluginView;", "getMGraffitiPluginView", "()Lcom/tal/app/thinkacademy/live/business/canvastriplescreen/graffiti/GraffitiPluginView;", "setMGraffitiPluginView", "(Lcom/tal/app/thinkacademy/live/business/canvastriplescreen/graffiti/GraffitiPluginView;)V", "getPageKeyByDBKey", "", "dbkey", "initGraffiti", "", "specifKey", "testFun", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GraffitiBaseAgent.kt */
public abstract class GraffitiBaseAgent extends GraffitiAgent {
    private GraffitiPluginView mGraffitiPluginView = new GraffitiPluginView(getMContext());

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GraffitiBaseAgent(Context context, BaseLivePluginDriver baseLivePluginDriver, ILiveRoomProvider iLiveRoomProvider) {
        super(context, baseLivePluginDriver, iLiveRoomProvider);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(baseLivePluginDriver, "driver");
        Intrinsics.checkNotNullParameter(iLiveRoomProvider, "provider");
    }

    /* access modifiers changed from: protected */
    public final GraffitiPluginView getMGraffitiPluginView() {
        return this.mGraffitiPluginView;
    }

    /* access modifiers changed from: protected */
    public final void setMGraffitiPluginView(GraffitiPluginView graffitiPluginView) {
        Intrinsics.checkNotNullParameter(graffitiPluginView, "<set-?>");
        this.mGraffitiPluginView = graffitiPluginView;
    }

    public void initGraffiti(String str) {
        Intrinsics.checkNotNullParameter(str, "specifKey");
        super.initGraffiti(str);
        this.mGraffitiPluginView = new GraffitiPluginView(getMContext());
        RoomData roomData = getMLiveRoomProvider().getDataStorage().getRoomData();
        LiveAreaCompat.CourseRate courseRate = roomData.getCourseRate();
        boolean graffitiUseCourseRate = roomData.getGraffitiUseCourseRate();
        Intrinsics.checkNotNullExpressionValue(courseRate, "rate");
        bindPluginView(this.mGraffitiPluginView, courseRate, graffitiUseCourseRate, "graffitiLayout");
    }

    public String getPageKeyByDBKey(String str) {
        Integer num;
        CharSequence charSequence = str;
        if (TextUtils.equals(charSequence, getMPageKey())) {
            return getMPageKey();
        }
        if (str == null) {
            num = null;
        } else {
            int i = 0;
            for (int i2 = 0; i2 < charSequence.length(); i2++) {
                if (charSequence.charAt(i2) == '_') {
                    i++;
                }
            }
            num = Integer.valueOf(i);
        }
        return ((num != null && num.intValue() == 4) || num == null || num.intValue() != 5) ? str : StringsKt.substringAfter(str, "_", "");
    }

    private final void testFun() {
        LinearLayout linearLayout = new LinearLayout(getMContext());
        linearLayout.setOrientation(0);
        Button button = new Button(getMContext());
        button.setText("清屏");
        button.setOnClickListener(new GraffitiBaseAgent$$ExternalSyntheticLambda0(this));
        linearLayout.addView(button);
        this.mGraffitiPluginView.addView(linearLayout, new FrameLayout.LayoutParams(-2, -2));
    }

    /* access modifiers changed from: private */
    /* renamed from: testFun$lambda-1  reason: not valid java name */
    public static final void m185testFun$lambda1(GraffitiBaseAgent graffitiBaseAgent, View view) {
        Intrinsics.checkNotNullParameter(graffitiBaseAgent, "this$0");
        WXTGraffitiEngineImpl mGraffitiEngine = graffitiBaseAgent.getMGraffitiEngine();
        WXWBAction wXWBAction = null;
        WXTGraffitiEngine.Setting setting = mGraffitiEngine == null ? null : mGraffitiEngine.getSetting();
        if (setting != null) {
            setting.setRejectRecoverClean(false);
        }
        WXTGraffitiEngineImpl mGraffitiEngine2 = graffitiBaseAgent.getMGraffitiEngine();
        if (mGraffitiEngine2 != null) {
            WXTGraffitiEngineImpl mGraffitiEngine3 = graffitiBaseAgent.getMGraffitiEngine();
            if (mGraffitiEngine3 != null) {
                wXWBAction = mGraffitiEngine3.actionForActionType(5);
            }
            mGraffitiEngine2.addAction(wXWBAction);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
