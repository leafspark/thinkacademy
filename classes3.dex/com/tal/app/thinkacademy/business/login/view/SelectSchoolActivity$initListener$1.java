package com.tal.app.thinkacademy.business.login.view;

import com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager;
import com.tal.app.thinkacademy.common.imconfig.ImConfig;
import com.tal.app.thinkacademy.common.util.ChooseSchoolUtil;
import com.tal.app.thinkacademy.common.utils.LeanplumUtil;
import com.tal.app.thinkacademy.lib.route.XesRoute;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SelectSchoolActivity.kt */
final class SelectSchoolActivity$initListener$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ SelectSchoolActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SelectSchoolActivity$initListener$1(SelectSchoolActivity selectSchoolActivity) {
        super(0);
        this.this$0 = selectSchoolActivity;
    }

    public final void invoke() {
        ShareDataManager.getInstance().put("school_code", String.valueOf(this.this$0.schoolCode), ShareDataManager.SHAREDATA_NOT_CLEAR);
        ShareDataManager.getInstance().saveCacheGsonEntity(ChooseSchoolUtil.INSTANCE.getChosenSchoolBean(this.this$0.schoolCode), "current_school_info", ShareDataManager.SHAREDATA_NOT_CLEAR);
        boolean z = true;
        ImConfig.getHostUrlsConfig$default(ImConfig.INSTANCE, (String) null, 1, (Object) null);
        XesRoute.getInstance().navigation("/login/select_grade_activity");
        CharSequence access$getMPath$p = this.this$0.mPath;
        if (!(access$getMPath$p == null || access$getMPath$p.length() == 0)) {
            z = false;
        }
        LeanplumUtil.longTrack$default("click_school_card_submit", (String) null, (String) null, (String) null, (String) null, z ? "others" : this.this$0.mPath, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 16350, (Object) null);
        this.this$0.finish();
    }
}
