package com.tal.app.thinkacademy.business.login.view;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import com.tal.app.thinkacademy.business.login.business.LoginTrack;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChooseTimeZoneActivity.kt */
final class ChooseTimeZoneActivity$initListener$3 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ChooseTimeZoneActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChooseTimeZoneActivity$initListener$3(ChooseTimeZoneActivity chooseTimeZoneActivity) {
        super(0);
        this.this$0 = chooseTimeZoneActivity;
    }

    public final void invoke() {
        ChooseTimeZoneActivity chooseTimeZoneActivity = this.this$0;
        Intent intent = new Intent((Context) this.this$0, SearchTimeZoneActivity.class);
        ChooseTimeZoneActivity chooseTimeZoneActivity2 = this.this$0;
        chooseTimeZoneActivity.startActivity(intent, ActivityOptions.makeSceneTransitionAnimation((Activity) chooseTimeZoneActivity2, chooseTimeZoneActivity2.getBinding().llInput, "searchName").toBundle());
        LoginTrack.INSTANCE.hw_time_zone_search_click();
    }
}
