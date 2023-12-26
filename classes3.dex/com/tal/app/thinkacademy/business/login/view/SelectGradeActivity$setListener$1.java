package com.tal.app.thinkacademy.business.login.view;

import com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager;
import com.tal.app.thinkacademy.common.utils.LeanplumUtil;
import com.tal.app.thinkacademy.lib.route.XesRoute;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SelectGradeActivity.kt */
final class SelectGradeActivity$setListener$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ SelectGradeActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SelectGradeActivity$setListener$1(SelectGradeActivity selectGradeActivity) {
        super(0);
        this.this$0 = selectGradeActivity;
    }

    public final void invoke() {
        ShareDataManager.getInstance().put("grade_id", this.this$0.mGradeId, ShareDataManager.SHAREDATA_NOT_CLEAR);
        XesRoute.getInstance().navigation("/home/main_activity");
        HashMap hashMap = new HashMap();
        hashMap.put("grade_choice_id", this.this$0.mGradeId);
        LeanplumUtil.commonTrack("click_grade_choice_submit", hashMap);
        this.this$0.finish();
    }
}
