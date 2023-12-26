package com.tal.app.thinkacademy.business.study.study.dialog;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.business.study.study.entity.TheOutsideEntity;
import com.tal.app.thinkacademy.business.study.study.speaker.OutsideOfClassType;
import com.tal.app.thinkacademy.business.studycenter.R;
import com.tal.app.thinkacademy.common.utils.TextHighLightUtil;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseDialog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B5\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u001c\b\u0002\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007¢\u0006\u0002\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/dialog/ThinkhubDialog;", "Lcom/tal/app/thinkacademy/lib/commui/baseview/dialog/BaseDialog;", "context", "Landroid/content/Context;", "entity", "Lcom/tal/app/thinkacademy/business/study/study/entity/TheOutsideEntity;", "listener", "Lkotlin/Function2;", "Lcom/tal/app/thinkacademy/business/study/study/speaker/OutsideOfClassType;", "", "(Landroid/content/Context;Lcom/tal/app/thinkacademy/business/study/study/entity/TheOutsideEntity;Lkotlin/jvm/functions/Function2;)V", "thinkhubPhone", "", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ThinkhubDialog.kt */
public final class ThinkhubDialog extends BaseDialog {
    private final String thinkhubPhone;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ThinkhubDialog(Context context, TheOutsideEntity theOutsideEntity, Function2 function2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, theOutsideEntity, (i & 4) != 0 ? null : function2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ThinkhubDialog(Context context, TheOutsideEntity theOutsideEntity, Function2<? super OutsideOfClassType, ? super TheOutsideEntity, Unit> function2) {
        super(context, true);
        String str;
        Intrinsics.checkNotNullParameter(theOutsideEntity, "entity");
        String phone = theOutsideEntity.getPhone();
        String str2 = phone == null ? "" : phone;
        this.thinkhubPhone = str2;
        contentView(R.layout.study_dialog_thinkhub);
        layoutParams(new LinearLayout.LayoutParams(-1, -1));
        View findViewById = findViewById(R.id.tvGotIt);
        if (findViewById != null) {
            findViewById.setOnClickListener(new ThinkhubDialog$$ExternalSyntheticLambda0(this));
        }
        TextHighLightUtil textHighLightUtil = TextHighLightUtil.INSTANCE;
        View findViewById2 = findViewById(R.id.tvPhone);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.tvPhone)");
        TextView textView = (TextView) findViewById2;
        if (context == null) {
            str = null;
        } else {
            str = context.getString(R.string.thinkhub_dialog_hint);
        }
        textHighLightUtil.setTextHighLightWithClick(textView, Intrinsics.stringPlus(str, str2), str2, R.color.color_3370FF, new ThinkhubDialog$$ExternalSyntheticLambda1(function2, this, theOutsideEntity));
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final void m426_init_$lambda0(ThinkhubDialog thinkhubDialog, View view) {
        Intrinsics.checkNotNullParameter(thinkhubDialog, "this$0");
        thinkhubDialog.dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-2  reason: not valid java name */
    public static final void m427_init_$lambda2(Function2 function2, ThinkhubDialog thinkhubDialog, TheOutsideEntity theOutsideEntity, View view) {
        Intrinsics.checkNotNullParameter(thinkhubDialog, "this$0");
        Intrinsics.checkNotNullParameter(theOutsideEntity, "$entity");
        if (function2 != null) {
            thinkhubDialog.dismiss();
            function2.invoke(OutsideOfClassType.ONLINE, theOutsideEntity);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
