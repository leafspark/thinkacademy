package com.tal.app.thinkacademy.business.study.study.service;

import com.tal.app.thinkacademy.business.study.study.SwitchType;
import com.tal.app.thinkacademy.business.study.study.entity.SwitchOptionsEntity;
import com.tal.app.thinkacademy.business.study.study.entity.SwitchOptionsList;
import com.tal.app.thinkacademy.common.base.XesBaseActivity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "entity", "Lcom/tal/app/thinkacademy/business/study/study/entity/SwitchOptionsEntity;", "type", "Lcom/tal/app/thinkacademy/business/study/study/SwitchType;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: StudyService.kt */
final class StudyService$showDialog$mSwitchDialog$1 extends Lambda implements Function2<SwitchOptionsEntity, SwitchType, Unit> {
    final /* synthetic */ XesBaseActivity $currentActivity;
    final /* synthetic */ String $currentTab;
    final /* synthetic */ boolean $hasCourse;
    final /* synthetic */ SwitchOptionsList $list;
    final /* synthetic */ SwitchType $switchType;
    final /* synthetic */ StudyService this$0;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: StudyService.kt */
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
    StudyService$showDialog$mSwitchDialog$1(SwitchType switchType, SwitchOptionsList switchOptionsList, boolean z, String str, StudyService studyService, XesBaseActivity xesBaseActivity) {
        super(2);
        this.$switchType = switchType;
        this.$list = switchOptionsList;
        this.$hasCourse = z;
        this.$currentTab = str;
        this.this$0 = studyService;
        this.$currentActivity = xesBaseActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((SwitchOptionsEntity) obj, (SwitchType) obj2);
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0078  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(com.tal.app.thinkacademy.business.study.study.entity.SwitchOptionsEntity r9, com.tal.app.thinkacademy.business.study.study.SwitchType r10) {
        /*
            r8 = this;
            java.lang.String r0 = "entity"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "type"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            com.tal.app.thinkacademy.business.study.study.StudyTrack r0 = com.tal.app.thinkacademy.business.study.study.StudyTrack.INSTANCE
            com.tal.app.thinkacademy.business.study.study.SwitchType r1 = r8.$switchType
            java.lang.String r1 = r1.getAliasName()
            com.tal.app.thinkacademy.business.study.study.SwitchType r2 = r8.$switchType
            int[] r3 = com.tal.app.thinkacademy.business.study.study.service.StudyService$showDialog$mSwitchDialog$1.WhenMappings.$EnumSwitchMapping$0
            int r2 = r2.ordinal()
            r2 = r3[r2]
            r3 = 2
            r4 = 1
            if (r2 == r4) goto L_0x0035
            if (r2 == r3) goto L_0x0024
            r2 = 0
            goto L_0x0046
        L_0x0024:
            com.tal.app.thinkacademy.business.study.study.entity.SwitchOptionsList r2 = r8.$list
            if (r2 != 0) goto L_0x0029
            goto L_0x0039
        L_0x0029:
            java.util.List r2 = r2.getSchoolList()
            if (r2 != 0) goto L_0x0030
            goto L_0x0039
        L_0x0030:
            int r2 = r2.size()
            goto L_0x0046
        L_0x0035:
            com.tal.app.thinkacademy.business.study.study.entity.SwitchOptionsList r2 = r8.$list
            if (r2 != 0) goto L_0x003b
        L_0x0039:
            r2 = r4
            goto L_0x0046
        L_0x003b:
            java.util.List r2 = r2.getAccountList()
            if (r2 != 0) goto L_0x0042
            goto L_0x0039
        L_0x0042:
            int r2 = r2.size()
        L_0x0046:
            boolean r5 = r8.$hasCourse
            if (r5 == 0) goto L_0x004d
            java.lang.String r5 = "有班级"
            goto L_0x004f
        L_0x004d:
            java.lang.String r5 = "无班级"
        L_0x004f:
            java.lang.String r6 = r8.$currentTab
            java.lang.String r7 = "live"
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r7)
            if (r6 == 0) goto L_0x005c
            java.lang.String r6 = "直播课"
            goto L_0x005e
        L_0x005c:
            java.lang.String r6 = "录播课"
        L_0x005e:
            r0.hw_user_switcher_pop_click(r1, r2, r5, r6)
            int[] r0 = com.tal.app.thinkacademy.business.study.study.service.StudyService$showDialog$mSwitchDialog$1.WhenMappings.$EnumSwitchMapping$0
            int r10 = r10.ordinal()
            r10 = r0[r10]
            if (r10 == r4) goto L_0x0078
            if (r10 == r3) goto L_0x006e
            goto L_0x007f
        L_0x006e:
            com.tal.app.thinkacademy.business.study.study.service.StudyService r10 = r8.this$0
            com.tal.app.thinkacademy.common.base.XesBaseActivity r0 = r8.$currentActivity
            android.app.Activity r0 = (android.app.Activity) r0
            r10.switchSchool(r0, r9)
            goto L_0x007f
        L_0x0078:
            com.tal.app.thinkacademy.business.study.study.service.StudyService r10 = r8.this$0
            com.tal.app.thinkacademy.common.base.XesBaseActivity r0 = r8.$currentActivity
            r10.switchAccount(r0, r9)
        L_0x007f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.study.study.service.StudyService$showDialog$mSwitchDialog$1.invoke(com.tal.app.thinkacademy.business.study.study.entity.SwitchOptionsEntity, com.tal.app.thinkacademy.business.study.study.SwitchType):void");
    }
}
