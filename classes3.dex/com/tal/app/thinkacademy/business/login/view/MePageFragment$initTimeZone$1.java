package com.tal.app.thinkacademy.business.login.view;

import com.tal.app.thinkacademy.business.login.business.LoginTrack;
import com.tal.app.thinkacademy.lib.route.XesRoute;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: MePageFragment.kt */
final class MePageFragment$initTimeZone$1 extends Lambda implements Function0<Unit> {
    public static final MePageFragment$initTimeZone$1 INSTANCE = new MePageFragment$initTimeZone$1();

    MePageFragment$initTimeZone$1() {
        super(0);
    }

    public final void invoke() {
        LoginTrack.INSTANCE.hw_time_zone_switch_click();
        XesRoute.getInstance().navigation("/login/choose_time_zone");
    }
}
