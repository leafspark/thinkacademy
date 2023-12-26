package com.tal.app.thinkacademy.business.login.widget;

import android.content.Context;
import android.view.View;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.common.util.ChooseSchoolUtil;
import com.tal.app.thinkacademy.common.util.HwLanguageUtil;
import com.tal.app.thinkacademy.lib.commui.wheel.adapter.WheelAdapter;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\u0010\bJ\u0006\u0010\u000e\u001a\u00020\u0007R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/widget/SwitchLanguageDialog;", "Lcom/tal/app/thinkacademy/business/login/widget/WheelDialog;", "context", "Landroid/content/Context;", "listen", "Lkotlin/Function1;", "Lcom/tal/app/thinkacademy/common/util/HwLanguageUtil$HwLanguageInfo;", "", "(Landroid/content/Context;Lkotlin/jvm/functions/Function1;)V", "mNameList", "", "", "mOldIndex", "", "setCurrentIndex", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SwitchLanguageDialog.kt */
public final class SwitchLanguageDialog extends WheelDialog {
    /* access modifiers changed from: private */
    public final List<String> mNameList = new ArrayList();
    private int mOldIndex;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SwitchLanguageDialog(Context context, Function1<? super HwLanguageUtil.HwLanguageInfo, Unit> function1) {
        super(context, (Function1) null, (Function0) null, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(function1, "listen");
        int i = 0;
        for (Object next : HwLanguageUtil.INSTANCE.getSupportLanguageList()) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            this.mNameList.add(((HwLanguageUtil.HwLanguageInfo) next).getNameDesc());
            i = i2;
        }
        setWheelAdapter(new WheelAdapter<String>(this) {
            final /* synthetic */ SwitchLanguageDialog this$0;

            {
                this.this$0 = r1;
            }

            public int getItemsCount() {
                return this.this$0.mNameList.size();
            }

            public String getItem(int i) {
                return (String) this.this$0.mNameList.get(i);
            }

            public int indexOf(String str) {
                return CollectionsKt.indexOf(this.this$0.mNameList, str);
            }
        });
        this.binding.ivConfirm.setOnClickListener(new SwitchLanguageDialog$$ExternalSyntheticLambda0(this, function1));
        setCurrentIndex();
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-1  reason: not valid java name */
    public static final void m176_init_$lambda1(SwitchLanguageDialog switchLanguageDialog, Function1 function1, View view) {
        Intrinsics.checkNotNullParameter(switchLanguageDialog, "this$0");
        Intrinsics.checkNotNullParameter(function1, "$listen");
        int currentItem = switchLanguageDialog.getCurrentItem();
        if (switchLanguageDialog.mOldIndex != currentItem) {
            XesLog.dt("语言", new Object[]{Intrinsics.stringPlus("当前选中的语言index=", Integer.valueOf(currentItem))});
            switchLanguageDialog.dismiss();
            try {
                HwLanguageUtil.HwLanguageInfo hwLanguageInfo = (HwLanguageUtil.HwLanguageInfo) HwLanguageUtil.INSTANCE.getSupportLanguageList().get(currentItem);
                HwLanguageUtil hwLanguageUtil = HwLanguageUtil.INSTANCE;
                Context context = switchLanguageDialog.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext()");
                hwLanguageUtil.changeLanguage(context, hwLanguageInfo);
                function1.invoke(hwLanguageInfo);
                ChooseSchoolUtil.INSTANCE.finishAllActivitiesToMain();
            } catch (Exception e) {
                XesLog.dt("语言", new Object[]{Intrinsics.stringPlus("选择语言失败 = ", e)});
            }
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void setCurrentIndex() {
        int currentLanguageIndex = HwLanguageUtil.INSTANCE.getCurrentLanguageIndex();
        this.mOldIndex = currentLanguageIndex;
        setCurrentItem(currentLanguageIndex);
    }
}
