package com.tal.app.thinkacademy.business.login.view;

import com.tal.app.thinkacademy.business.login.business.LoginTrack;
import com.tal.app.thinkacademy.common.constants.SchoolConstants;
import com.tal.app.thinkacademy.common.utils.LeanplumUtil;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "index", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SettingsActivity.kt */
final class SettingsActivity$selectSchool$2 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ Ref.IntRef $currentIndex;
    final /* synthetic */ SettingsActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SettingsActivity$selectSchool$2(Ref.IntRef intRef, SettingsActivity settingsActivity) {
        super(1);
        this.$currentIndex = intRef;
        this.this$0 = settingsActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i) {
        this.$currentIndex.element = i;
        Integer num = (Integer) this.this$0.mSchoolMap.get(Integer.valueOf(this.$currentIndex.element));
        if (num != null) {
            SettingsActivity settingsActivity = this.this$0;
            Ref.IntRef intRef = this.$currentIndex;
            LoginTrack.INSTANCE.switchSchoolPopClick(SchoolConstants.INSTANCE.getSchoolNameShort(num.intValue()));
            LeanplumUtil.commonTrack$default("click_school_selector_submit", (HashMap) null, 2, (Object) null);
            if (settingsActivity.mOldIndex != intRef.element) {
                settingsActivity.getBinding().tvCountryName.setText((CharSequence) settingsActivity.mNameList.get(intRef.element));
                settingsActivity.updateSchoolInfo(num.intValue());
                settingsActivity.showLoading();
                settingsActivity.getMViewModel().accountSwitchSchool(num.intValue());
            }
        }
    }
}
