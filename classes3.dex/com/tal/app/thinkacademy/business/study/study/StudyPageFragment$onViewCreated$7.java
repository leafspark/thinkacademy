package com.tal.app.thinkacademy.business.study.study;

import android.os.Bundle;
import com.tal.app.thinkacademy.lib.route.XesRoute;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: StudyPageFragment.kt */
final class StudyPageFragment$onViewCreated$7 extends Lambda implements Function0<Unit> {
    public static final StudyPageFragment$onViewCreated$7 INSTANCE = new StudyPageFragment$onViewCreated$7();

    StudyPageFragment$onViewCreated$7() {
        super(0);
    }

    public final void invoke() {
        Bundle bundle = new Bundle();
        bundle.putString("login_page_path", "learning_portal");
        bundle.putString("login_source", "我的课程");
        XesRoute.getInstance().navigation("/login/login_activity", bundle);
    }
}
