package com.tal.app.thinkacademy.business.login.view;

import com.tal.app.thinkacademy.common.utils.LeanplumUtil;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SettingsActivity.kt */
final class SettingsActivity$selectSchool$3 extends Lambda implements Function0<Unit> {
    public static final SettingsActivity$selectSchool$3 INSTANCE = new SettingsActivity$selectSchool$3();

    SettingsActivity$selectSchool$3() {
        super(0);
    }

    public final void invoke() {
        LeanplumUtil.commonTrack$default("click_school_selector_close", (HashMap) null, 2, (Object) null);
    }
}
