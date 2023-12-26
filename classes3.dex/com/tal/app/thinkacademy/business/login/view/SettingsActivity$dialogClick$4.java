package com.tal.app.thinkacademy.business.login.view;

import android.content.Context;
import com.tal.app.thinkacademy.business.login.widget.SwitchLanguageDialog;
import com.tal.app.thinkacademy.common.util.HwLanguageUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SettingsActivity.kt */
final class SettingsActivity$dialogClick$4 extends Lambda implements Function0<Unit> {
    final /* synthetic */ SettingsActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SettingsActivity$dialogClick$4(SettingsActivity settingsActivity) {
        super(0);
        this.this$0 = settingsActivity;
    }

    public final void invoke() {
        if (this.this$0.mSelectLanguageDialog == null) {
            SettingsActivity settingsActivity = this.this$0;
            final SettingsActivity settingsActivity2 = this.this$0;
            settingsActivity.mSelectLanguageDialog = new SwitchLanguageDialog((Context) this.this$0, new Function1<HwLanguageUtil.HwLanguageInfo, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((HwLanguageUtil.HwLanguageInfo) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(HwLanguageUtil.HwLanguageInfo hwLanguageInfo) {
                    Intrinsics.checkNotNullParameter(hwLanguageInfo, "it");
                    settingsActivity2.getBinding().tvSelectLanguage.setText(hwLanguageInfo.getNameDesc());
                }
            });
        }
        SwitchLanguageDialog access$getMSelectLanguageDialog$p = this.this$0.mSelectLanguageDialog;
        if (access$getMSelectLanguageDialog$p != null) {
            access$getMSelectLanguageDialog$p.setCurrentIndex();
        }
        SwitchLanguageDialog access$getMSelectLanguageDialog$p2 = this.this$0.mSelectLanguageDialog;
        if (access$getMSelectLanguageDialog$p2 != null) {
            access$getMSelectLanguageDialog$p2.show();
        }
    }
}
