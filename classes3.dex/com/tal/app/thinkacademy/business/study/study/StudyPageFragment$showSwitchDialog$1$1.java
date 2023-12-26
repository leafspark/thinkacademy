package com.tal.app.thinkacademy.business.study.study;

import android.content.Context;
import com.tal.app.thinkacademy.business.study.study.entity.SwitchOptionsEntity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "entity", "Lcom/tal/app/thinkacademy/business/study/study/entity/SwitchOptionsEntity;", "type", "Lcom/tal/app/thinkacademy/business/study/study/SwitchType;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: StudyPageFragment.kt */
final class StudyPageFragment$showSwitchDialog$1$1 extends Lambda implements Function2<SwitchOptionsEntity, SwitchType, Unit> {
    final /* synthetic */ Context $context;
    final /* synthetic */ boolean $isHaveCourse;
    final /* synthetic */ ShowTab $showTab;
    final /* synthetic */ StudyPageFragment this$0;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: StudyPageFragment.kt */
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
    StudyPageFragment$showSwitchDialog$1$1(StudyPageFragment studyPageFragment, boolean z, ShowTab showTab, Context context) {
        super(2);
        this.this$0 = studyPageFragment;
        this.$isHaveCourse = z;
        this.$showTab = showTab;
        this.$context = context;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((SwitchOptionsEntity) obj, (SwitchType) obj2);
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00ac  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(com.tal.app.thinkacademy.business.study.study.entity.SwitchOptionsEntity r8, com.tal.app.thinkacademy.business.study.study.SwitchType r9) {
        /*
            r7 = this;
            java.lang.String r0 = "entity"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "type"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            com.tal.app.thinkacademy.business.study.study.StudyTrack r0 = com.tal.app.thinkacademy.business.study.study.StudyTrack.INSTANCE
            com.tal.app.thinkacademy.business.study.study.StudyPageFragment r1 = r7.this$0
            com.tal.app.thinkacademy.business.study.study.dialog.SwitchDialog r1 = r1.mSwitchDialog
            java.lang.String r2 = ""
            if (r1 != 0) goto L_0x0017
            goto L_0x0026
        L_0x0017:
            com.tal.app.thinkacademy.business.study.study.SwitchType r1 = r1.getSwitchType()
            if (r1 != 0) goto L_0x001e
            goto L_0x0026
        L_0x001e:
            java.lang.String r1 = r1.getAliasName()
            if (r1 != 0) goto L_0x0025
            goto L_0x0026
        L_0x0025:
            r2 = r1
        L_0x0026:
            com.tal.app.thinkacademy.business.study.study.StudyPageFragment r1 = r7.this$0
            com.tal.app.thinkacademy.business.study.study.dialog.SwitchDialog r1 = r1.mSwitchDialog
            if (r1 != 0) goto L_0x0030
            r1 = 0
            goto L_0x0034
        L_0x0030:
            com.tal.app.thinkacademy.business.study.study.SwitchType r1 = r1.getSwitchType()
        L_0x0034:
            if (r1 != 0) goto L_0x0038
            r1 = -1
            goto L_0x0040
        L_0x0038:
            int[] r3 = com.tal.app.thinkacademy.business.study.study.StudyPageFragment$showSwitchDialog$1$1.WhenMappings.$EnumSwitchMapping$0
            int r1 = r1.ordinal()
            r1 = r3[r1]
        L_0x0040:
            r3 = 2
            r4 = 1
            if (r1 == r4) goto L_0x0064
            if (r1 == r3) goto L_0x0048
            r1 = 0
            goto L_0x0080
        L_0x0048:
            com.tal.app.thinkacademy.business.study.study.StudyPageFragment r1 = r7.this$0
            com.tal.app.thinkacademy.business.study.study.dialog.SwitchDialog r1 = r1.mSwitchDialog
            if (r1 != 0) goto L_0x0051
            goto L_0x006c
        L_0x0051:
            com.tal.app.thinkacademy.business.study.study.entity.SwitchOptionsList r1 = r1.getMSwitchOptions()
            if (r1 != 0) goto L_0x0058
            goto L_0x006c
        L_0x0058:
            java.util.List r1 = r1.getSchoolList()
            if (r1 != 0) goto L_0x005f
            goto L_0x006c
        L_0x005f:
            int r1 = r1.size()
            goto L_0x0080
        L_0x0064:
            com.tal.app.thinkacademy.business.study.study.StudyPageFragment r1 = r7.this$0
            com.tal.app.thinkacademy.business.study.study.dialog.SwitchDialog r1 = r1.mSwitchDialog
            if (r1 != 0) goto L_0x006e
        L_0x006c:
            r1 = r4
            goto L_0x0080
        L_0x006e:
            com.tal.app.thinkacademy.business.study.study.entity.SwitchOptionsList r1 = r1.getMSwitchOptions()
            if (r1 != 0) goto L_0x0075
            goto L_0x006c
        L_0x0075:
            java.util.List r1 = r1.getAccountList()
            if (r1 != 0) goto L_0x007c
            goto L_0x006c
        L_0x007c:
            int r1 = r1.size()
        L_0x0080:
            boolean r5 = r7.$isHaveCourse
            if (r5 == 0) goto L_0x0087
            java.lang.String r5 = "有班级"
            goto L_0x0089
        L_0x0087:
            java.lang.String r5 = "无班级"
        L_0x0089:
            com.tal.app.thinkacademy.business.study.study.ShowTab r6 = r7.$showTab
            java.lang.String r6 = r6.getAliasName()
            r0.hw_user_switcher_pop_click(r2, r1, r5, r6)
            int[] r0 = com.tal.app.thinkacademy.business.study.study.StudyPageFragment$showSwitchDialog$1$1.WhenMappings.$EnumSwitchMapping$0
            int r9 = r9.ordinal()
            r9 = r0[r9]
            if (r9 == r4) goto L_0x00ac
            if (r9 == r3) goto L_0x009f
            goto L_0x00b1
        L_0x009f:
            com.tal.app.thinkacademy.business.study.study.StudyPageFragment r9 = r7.this$0
            android.content.Context r0 = r7.$context
            java.lang.String r1 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r9.switchSchool(r0, r8)
            goto L_0x00b1
        L_0x00ac:
            com.tal.app.thinkacademy.business.study.study.StudyPageFragment r9 = r7.this$0
            r9.switchAccount(r8)
        L_0x00b1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.study.study.StudyPageFragment$showSwitchDialog$1$1.invoke(com.tal.app.thinkacademy.business.study.study.entity.SwitchOptionsEntity, com.tal.app.thinkacademy.business.study.study.SwitchType):void");
    }
}
