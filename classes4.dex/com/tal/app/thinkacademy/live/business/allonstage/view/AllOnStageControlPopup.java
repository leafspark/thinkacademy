package com.tal.app.thinkacademy.live.business.allonstage.view;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.common.util.PadUtils;
import com.tal.app.thinkacademy.lib.commui.baseview.popupwindow.EasyPopup;
import com.tal.app.thinkacademy.lib.util.Utils;
import com.tal.app.thinkacademy.live.abilitypack.allonstage.Type;
import com.tal.app.thinkacademy.live.business.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J)\u0010\u0014\u001a\u00020\u000b2!\u0010\u0015\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u000b0\bR+\u0010\u0007\u001a\u001f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00020\u000b\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/allonstage/view/AllOnStageControlPopup;", "Lcom/tal/app/thinkacademy/lib/commui/baseview/popupwindow/EasyPopup;", "mContext", "Landroid/content/Context;", "type", "Lcom/tal/app/thinkacademy/live/abilitypack/allonstage/Type;", "(Landroid/content/Context;Lcom/tal/app/thinkacademy/live/abilitypack/allonstage/Type;)V", "mAgreeClickBlock", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "getType", "()Lcom/tal/app/thinkacademy/live/abilitypack/allonstage/Type;", "setType", "(Lcom/tal/app/thinkacademy/live/abilitypack/allonstage/Type;)V", "setOnAgreeClick", "block", "Companion", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AllOnStageControlPopup.kt */
public final class AllOnStageControlPopup extends EasyPopup {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TAG = "AllOnStageControlPopup";
    private Function1<? super Type, Unit> mAgreeClickBlock;
    private Context mContext;
    private Type type;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AllOnStageControlPopup.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Type.values().length];
            iArr[Type.RECORD.ordinal()] = 1;
            iArr[Type.CAMERA.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AllOnStageControlPopup(Context context, Type type2) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "mContext");
        Intrinsics.checkNotNullParameter(type2, "type");
        this.mContext = context;
        this.type = type2;
        setContentView(PadUtils.isPad(Utils.getApp()) ? R.layout.layout_contorl_open : R.layout.layout_mic_contorl_open_phone).setFocusAndOutsideEnable(false).setKeyCodeBack(false).setBackgroundDimEnable(false).setWidth(this.mContext.getResources().getDimensionPixelOffset(PadUtils.isPad(Utils.getApp()) ? R.dimen.size_450dp : R.dimen.size_253dp)).setHeight(this.mContext.getResources().getDimensionPixelOffset(PadUtils.isPad(Utils.getApp()) ? R.dimen.size_114dp : R.dimen.size_94dp)).createPopup();
        View contentView = getContentView();
        if (contentView != null) {
            int i = WhenMappings.$EnumSwitchMapping$0[getType().ordinal()];
            if (i == 1) {
                ((ImageView) contentView.findViewById(R.id.iv_icon)).setImageResource(R.drawable.icon_microphone);
                ((TextView) contentView.findViewById(R.id.tv_title)).setText(R.string.teacher_control_microphone);
                ((TextView) contentView.findViewById(R.id.tv_deny)).setTextColor(getMContext().getColor(R.color.color_A2AAB8));
                ((TextView) contentView.findViewById(R.id.tv_agree)).setTextColor(getMContext().getColor(R.color.white));
            } else if (i == 2) {
                ((ImageView) contentView.findViewById(R.id.iv_icon)).setImageResource(R.drawable.icon_camera);
                ((TextView) contentView.findViewById(R.id.tv_title)).setText(R.string.teacher_control_camera);
                ((TextView) contentView.findViewById(R.id.tv_deny)).setTextColor(getMContext().getColor(R.color.color_A2AAB8));
                ((TextView) contentView.findViewById(R.id.tv_agree)).setTextColor(getMContext().getColor(R.color.white));
            }
            ((TextView) contentView.findViewById(R.id.tv_deny)).setOnClickListener(new AllOnStageControlPopup$$ExternalSyntheticLambda1(this));
            ((TextView) contentView.findViewById(R.id.tv_agree)).setOnClickListener(new AllOnStageControlPopup$$ExternalSyntheticLambda0(this));
        }
    }

    public final Context getMContext() {
        return this.mContext;
    }

    public final Type getType() {
        return this.type;
    }

    public final void setMContext(Context context) {
        Intrinsics.checkNotNullParameter(context, "<set-?>");
        this.mContext = context;
    }

    public final void setType(Type type2) {
        Intrinsics.checkNotNullParameter(type2, "<set-?>");
        this.type = type2;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/allonstage/view/AllOnStageControlPopup$Companion;", "", "()V", "TAG", "", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AllOnStageControlPopup.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: lambda-2$lambda-0  reason: not valid java name */
    public static final void m180lambda2$lambda0(AllOnStageControlPopup allOnStageControlPopup, View view) {
        Intrinsics.checkNotNullParameter(allOnStageControlPopup, "this$0");
        allOnStageControlPopup.dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: lambda-2$lambda-1  reason: not valid java name */
    public static final void m181lambda2$lambda1(AllOnStageControlPopup allOnStageControlPopup, View view) {
        Intrinsics.checkNotNullParameter(allOnStageControlPopup, "this$0");
        Function1<? super Type, Unit> function1 = allOnStageControlPopup.mAgreeClickBlock;
        if (function1 != null) {
            function1.invoke(allOnStageControlPopup.type);
        }
        allOnStageControlPopup.dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void setOnAgreeClick(Function1<? super Type, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        this.mAgreeClickBlock = function1;
    }
}
