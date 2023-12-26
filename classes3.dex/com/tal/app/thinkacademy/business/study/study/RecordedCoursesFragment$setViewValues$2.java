package com.tal.app.thinkacademy.business.study.study;

import com.tal.app.thinkacademy.business.study.study.ISwitchAccount;
import com.tal.app.thinkacademy.business.study.study.entity.SwitchOptionsEntity;
import com.tal.app.thinkacademy.business.study.study.entity.SwitchOptionsList;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.GsonUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: RecordedCoursesFragment.kt */
final class RecordedCoursesFragment$setViewValues$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ RecordedCoursesFragment this$0;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: RecordedCoursesFragment.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SwitchType.values().length];
            iArr[SwitchType.Account.ordinal()] = 1;
            iArr[SwitchType.School.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RecordedCoursesFragment$setViewValues$2(RecordedCoursesFragment recordedCoursesFragment) {
        super(0);
        this.this$0 = recordedCoursesFragment;
    }

    public final void invoke() {
        List<SwitchOptionsEntity> accountList;
        List<SwitchOptionsEntity> schoolList;
        int i = 1;
        XesLog.i(Tag.RecordedCoursesFragment, new Object[]{Intrinsics.stringPlus("录播切换数据点击：", GsonUtil.getInstance().objToJson(this.this$0.mSwitchOptions))});
        StudyTrack studyTrack = StudyTrack.INSTANCE;
        String aliasName = this.this$0.mSwitchType.getAliasName();
        int i2 = WhenMappings.$EnumSwitchMapping$0[this.this$0.mSwitchType.ordinal()];
        if (i2 == 1) {
            SwitchOptionsList access$getMSwitchOptions$p = this.this$0.mSwitchOptions;
            if (!(access$getMSwitchOptions$p == null || (accountList = access$getMSwitchOptions$p.getAccountList()) == null)) {
                i = accountList.size();
            }
        } else if (i2 == 2) {
            SwitchOptionsList access$getMSwitchOptions$p2 = this.this$0.mSwitchOptions;
            if (!(access$getMSwitchOptions$p2 == null || (schoolList = access$getMSwitchOptions$p2.getSchoolList()) == null)) {
                i = schoolList.size();
            }
        } else {
            throw new NoWhenBranchMatchedException();
        }
        studyTrack.hw_user_switcher_tips_click(aliasName, i, "无班级", ShowTab.Recorded.getAliasName());
        ISwitchAccount access$getSwitchListener$p = this.this$0.switchListener;
        if (access$getSwitchListener$p != null) {
            ISwitchAccount.DefaultImpls.showSwitchDialog$default(access$getSwitchListener$p, this.this$0.mSwitchOptions, this.this$0.mSwitchType, ShowTab.Recorded, this.this$0.mHaveCourse, false, 16, (Object) null);
        }
    }
}
