package com.tal.app.thinkacademy.business.study.study.speaker.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseSectionQuickAdapter;
import com.chad.library.adapter.base.module.LoadMoreModule;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.flyco.roundview.RoundLinearLayout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.business.study.study.entity.CalendarItem;
import com.tal.app.thinkacademy.business.study.study.entity.ExamDetails;
import com.tal.app.thinkacademy.business.study.study.entity.LessonDetails;
import com.tal.app.thinkacademy.business.study.study.speaker.ClassParamsKt;
import com.tal.app.thinkacademy.business.study.study.speaker.ClickType;
import com.tal.app.thinkacademy.business.studycenter.R;
import com.tal.app.thinkacademy.lib.utils.RxUnDoubleUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B3\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006\u0012\u001c\b\u0002\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n\u0018\u00010\b¢\u0006\u0002\u0010\u000bJ\u0018\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0002H\u0014J\u0018\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0002H\u0014J\b\u0010\u0016\u001a\u00020\rH\u0002J \u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0018\u0010\u001e\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0002H\u0002J\u0018\u0010\u001f\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0002H\u0002R\"\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n\u0018\u00010\bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006 "}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/speaker/adapter/CalendarAdapter;", "Lcom/chad/library/adapter/base/BaseSectionQuickAdapter;", "Lcom/tal/app/thinkacademy/business/study/study/entity/CalendarItem;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "Lcom/chad/library/adapter/base/module/LoadMoreModule;", "listData", "", "listener", "Lkotlin/Function2;", "Lcom/tal/app/thinkacademy/business/study/study/speaker/ClickType;", "", "(Ljava/util/List;Lkotlin/jvm/functions/Function2;)V", "mIsOpenParentAudit", "", "getMIsOpenParentAudit", "()Z", "setMIsOpenParentAudit", "(Z)V", "convert", "holder", "item", "convertHeader", "getOpenParentAudit", "showBottomView", "rlSpeakerState", "Lcom/flyco/roundview/RoundLinearLayout;", "ivSpeakerUnfold", "Landroid/widget/ImageView;", "details", "Lcom/tal/app/thinkacademy/business/study/study/entity/LessonDetails;", "showExamItem", "showLessonItem", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CalendarAdapter.kt */
public final class CalendarAdapter extends BaseSectionQuickAdapter<CalendarItem, BaseViewHolder> implements LoadMoreModule {
    /* access modifiers changed from: private */
    public final Function2<ClickType, CalendarItem, Unit> listener;
    private boolean mIsOpenParentAudit;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CalendarAdapter(List list, Function2 function2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i & 2) != 0 ? null : function2);
    }

    public CalendarAdapter(List<CalendarItem> list, Function2<? super ClickType, ? super CalendarItem, Unit> function2) {
        super(R.layout.item_plan_list_date, list);
        this.listener = function2;
        this.mIsOpenParentAudit = getOpenParentAudit();
        addItemType(-100, R.layout.item_plan_list_lesson);
        addItemType(ClassParamsKt.TYPE_EXAM, R.layout.item_plan_list_exam);
    }

    public final boolean getMIsOpenParentAudit() {
        return this.mIsOpenParentAudit;
    }

    public final void setMIsOpenParentAudit(boolean z) {
        this.mIsOpenParentAudit = z;
    }

    /* access modifiers changed from: protected */
    public void convertHeader(BaseViewHolder baseViewHolder, CalendarItem calendarItem) {
        Intrinsics.checkNotNullParameter(baseViewHolder, "holder");
        Intrinsics.checkNotNullParameter(calendarItem, "item");
        baseViewHolder.setText(R.id.tvSpeakerDate, calendarItem.getDate());
    }

    /* access modifiers changed from: protected */
    public void convert(BaseViewHolder baseViewHolder, CalendarItem calendarItem) {
        Intrinsics.checkNotNullParameter(baseViewHolder, "holder");
        Intrinsics.checkNotNullParameter(calendarItem, "item");
        if (calendarItem.getItemType() == -100) {
            showLessonItem(baseViewHolder, calendarItem);
        } else {
            showExamItem(baseViewHolder, calendarItem);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x001b, code lost:
        r0 = r0.getSchool();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean getOpenParentAudit() {
        /*
            r5 = this;
            com.tal.app.thinkacademy.common.business.cloudcontrol.HwCloudControlHelper$Companion r0 = com.tal.app.thinkacademy.common.business.cloudcontrol.HwCloudControlHelper.Companion
            com.tal.app.thinkacademy.common.business.cloudcontrol.HwCloudControlHelper r0 = r0.get()
            com.tal.app.thinkacademy.common.entity.ParentAuditCloudData r0 = r0.getParentAuditParam()
            com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager r1 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.getInstance()
            int r2 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.SHAREDATA_NOT_CLEAR
            java.lang.String r3 = "school_code"
            java.lang.String r4 = "415"
            java.lang.String r1 = r1.getString(r3, r4, r2)
            if (r0 != 0) goto L_0x001b
            goto L_0x002a
        L_0x001b:
            java.util.List r0 = r0.getSchool()
            if (r0 != 0) goto L_0x0022
            goto L_0x002a
        L_0x0022:
            boolean r0 = r0.contains(r1)
            if (r0 == 0) goto L_0x002a
            r0 = 1
            return r0
        L_0x002a:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.study.study.speaker.adapter.CalendarAdapter.getOpenParentAudit():boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:104:0x0440  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x04f1  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x04f8  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x062e  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x0630  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x063e  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x0642  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x066a  */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x066f  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x02d4  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x02d8  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x02e1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void showLessonItem(com.chad.library.adapter.base.viewholder.BaseViewHolder r29, com.tal.app.thinkacademy.business.study.study.entity.CalendarItem r30) {
        /*
            r28 = this;
            r0 = r28
            r1 = r29
            r2 = r30
            com.tal.app.thinkacademy.business.study.study.entity.LessonDetails r3 = r30.getLessonDetails()
            if (r3 != 0) goto L_0x000e
            goto L_0x078e
        L_0x000e:
            int r4 = com.tal.app.thinkacademy.business.studycenter.R.id.tvSpeakerOrder
            java.lang.String r5 = r3.orderNum()
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r1.setText(r4, r5)
            int r4 = com.tal.app.thinkacademy.business.studycenter.R.id.tvSpeakerTitle
            java.lang.String r5 = r3.getLessonName()
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r1.setText(r4, r5)
            int r4 = com.tal.app.thinkacademy.business.studycenter.R.id.tvSpeakerStateTime
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = r3.getStartTime()
            r5.append(r6)
            java.lang.String r6 = " - "
            r5.append(r6)
            java.lang.String r6 = r3.getEndTime()
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r1.setText(r4, r5)
            int r4 = com.tal.app.thinkacademy.business.studycenter.R.id.tvAssignmentStateTime
            com.tal.app.thinkacademy.business.study.study.entity.AssignmentEntity r5 = r3.getAssignment()
            if (r5 != 0) goto L_0x0051
            r5 = 0
            goto L_0x0055
        L_0x0051:
            java.lang.String r5 = r5.getEndTime()
        L_0x0055:
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r1.setText(r4, r5)
            java.lang.String r4 = r3.getLessonFlag()
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            com.tal.app.thinkacademy.common.entity.LessonType r5 = com.tal.app.thinkacademy.common.entity.LessonType.TRANSFERRED
            java.lang.String r5 = r5.name()
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            boolean r4 = android.text.TextUtils.equals(r4, r5)
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L_0x008e
            int r4 = com.tal.app.thinkacademy.business.studycenter.R.id.tvLessonType
            int r7 = com.tal.app.thinkacademy.business.studycenter.R.drawable.icon_lesson_type_green
            r1.setBackgroundResource(r4, r7)
            int r4 = com.tal.app.thinkacademy.business.studycenter.R.id.tvLessonType
            android.content.Context r7 = r28.getContext()
            int r8 = com.tal.app.thinkacademy.business.studycenter.R.string.transfered
            java.lang.String r7 = r7.getString(r8)
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r1.setText(r4, r7)
            int r4 = com.tal.app.thinkacademy.business.studycenter.R.id.tvLessonType
            r1.setGone(r4, r6)
            goto L_0x00f7
        L_0x008e:
            java.lang.String r4 = r3.getLessonFlag()
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            com.tal.app.thinkacademy.common.entity.LessonType r7 = com.tal.app.thinkacademy.common.entity.LessonType.PLAYBACK
            java.lang.String r7 = r7.name()
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            boolean r4 = android.text.TextUtils.equals(r4, r7)
            if (r4 == 0) goto L_0x00c0
            int r4 = com.tal.app.thinkacademy.business.studycenter.R.id.tvLessonType
            int r7 = com.tal.app.thinkacademy.business.studycenter.R.drawable.icon_lesson_type_blue
            r1.setBackgroundResource(r4, r7)
            int r4 = com.tal.app.thinkacademy.business.studycenter.R.id.tvLessonType
            android.content.Context r7 = r28.getContext()
            int r8 = com.tal.app.thinkacademy.business.studycenter.R.string.playback_only
            java.lang.String r7 = r7.getString(r8)
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r1.setText(r4, r7)
            int r4 = com.tal.app.thinkacademy.business.studycenter.R.id.tvLessonType
            r1.setGone(r4, r6)
            goto L_0x00f7
        L_0x00c0:
            java.lang.String r4 = r3.getLessonFlag()
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            com.tal.app.thinkacademy.common.entity.LessonType r7 = com.tal.app.thinkacademy.common.entity.LessonType.AUDITION
            java.lang.String r7 = r7.name()
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            boolean r4 = android.text.TextUtils.equals(r4, r7)
            if (r4 == 0) goto L_0x00f2
            int r4 = com.tal.app.thinkacademy.business.studycenter.R.id.tvLessonType
            int r7 = com.tal.app.thinkacademy.business.studycenter.R.drawable.icon_lesson_type_blue
            r1.setBackgroundResource(r4, r7)
            int r4 = com.tal.app.thinkacademy.business.studycenter.R.id.tvLessonType
            android.content.Context r7 = r28.getContext()
            int r8 = com.tal.app.thinkacademy.business.studycenter.R.string.audit_class
            java.lang.String r7 = r7.getString(r8)
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r1.setText(r4, r7)
            int r4 = com.tal.app.thinkacademy.business.studycenter.R.id.tvLessonType
            r1.setGone(r4, r6)
            goto L_0x00f7
        L_0x00f2:
            int r4 = com.tal.app.thinkacademy.business.studycenter.R.id.tvLessonType
            r1.setGone(r4, r5)
        L_0x00f7:
            int r4 = com.tal.app.thinkacademy.business.studycenter.R.id.ivSpeakerUnfold
            android.view.View r4 = r1.getView(r4)
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            int r7 = com.tal.app.thinkacademy.business.studycenter.R.id.rlSpeakerState
            android.view.View r7 = r1.getView(r7)
            com.flyco.roundview.RoundLinearLayout r7 = (com.flyco.roundview.RoundLinearLayout) r7
            r0.showBottomView(r7, r4, r3)
            com.tal.app.thinkacademy.business.study.study.speaker.adapter.CalendarAdapter$$ExternalSyntheticLambda0 r8 = new com.tal.app.thinkacademy.business.study.study.speaker.adapter.CalendarAdapter$$ExternalSyntheticLambda0
            r8.<init>(r3, r0, r7, r4)
            r4.setOnClickListener(r8)
            int r4 = com.tal.app.thinkacademy.business.studycenter.R.id.tvSpeakerParentEnter
            android.view.View r4 = r1.getView(r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            int r7 = com.tal.app.thinkacademy.business.studycenter.R.id.tvSpeakerStateNameEnter
            android.view.View r7 = r1.getView(r7)
            android.widget.TextView r7 = (android.widget.TextView) r7
            int r8 = com.tal.app.thinkacademy.business.studycenter.R.id.tvSpeakerStateName
            android.view.View r8 = r1.getView(r8)
            com.flyco.roundview.RoundTextView r8 = (com.flyco.roundview.RoundTextView) r8
            int r9 = com.tal.app.thinkacademy.business.studycenter.R.id.tvSpeakerStateNameGray
            android.view.View r9 = r1.getView(r9)
            android.widget.TextView r9 = (android.widget.TextView) r9
            int r10 = com.tal.app.thinkacademy.business.studycenter.R.id.tvAssignmentStateName
            android.view.View r10 = r1.getView(r10)
            com.flyco.roundview.RoundTextView r10 = (com.flyco.roundview.RoundTextView) r10
            int r11 = com.tal.app.thinkacademy.business.studycenter.R.id.tvAssignmentStateNameGray
            android.view.View r11 = r1.getView(r11)
            android.widget.TextView r11 = (android.widget.TextView) r11
            java.lang.String r12 = r3.getPlatformType()
            com.tal.app.thinkacademy.business.study.study.speaker.OutsideOfClassType r13 = com.tal.app.thinkacademy.business.study.study.speaker.OutsideOfClassType.BIG_ONLINE
            java.lang.String r13 = r13.getAliasName()
            boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r12, (java.lang.Object) r13)
            r13 = 8
            if (r12 == 0) goto L_0x02b9
            java.lang.Integer r12 = r3.getStatus()
            com.tal.app.thinkacademy.business.study.study.speaker.PlanState r14 = com.tal.app.thinkacademy.business.study.study.speaker.PlanState.ToStart
            int r14 = r14.getCode()
            if (r12 != 0) goto L_0x0161
            goto L_0x0181
        L_0x0161:
            int r15 = r12.intValue()
            if (r15 != r14) goto L_0x0181
            r7.setVisibility(r13)
            r8.setVisibility(r13)
            r9.setVisibility(r6)
            android.content.Context r12 = r28.getContext()
            int r14 = com.tal.app.thinkacademy.business.studycenter.R.string.plan_to_start
            java.lang.String r12 = r12.getString(r14)
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            r9.setText(r12)
            goto L_0x02d1
        L_0x0181:
            com.tal.app.thinkacademy.business.study.study.speaker.PlanState r14 = com.tal.app.thinkacademy.business.study.study.speaker.PlanState.Live
            int r14 = r14.getCode()
            if (r12 != 0) goto L_0x018a
            goto L_0x01f4
        L_0x018a:
            int r15 = r12.intValue()
            if (r15 != r14) goto L_0x01f4
            r7.setVisibility(r6)
            r8.setVisibility(r13)
            r9.setVisibility(r13)
            boolean r9 = r3.isAudition()
            if (r9 == 0) goto L_0x01b0
            android.content.Context r9 = r28.getContext()
            int r12 = com.tal.app.thinkacademy.business.studycenter.R.string.start_auditing
            java.lang.String r9 = r9.getString(r12)
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            r7.setText(r9)
            goto L_0x02d1
        L_0x01b0:
            android.content.Context r9 = r28.getContext()
            int r12 = com.tal.app.thinkacademy.business.studycenter.R.string.plan_live
            java.lang.String r9 = r9.getString(r12)
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            r7.setText(r9)
            boolean r9 = r28.getMIsOpenParentAudit()
            if (r9 == 0) goto L_0x02d1
            com.tal.app.thinkacademy.business.study.study.entity.LessonDetails r9 = r30.getLessonDetails()
            java.lang.String r9 = r9.getLessonType()
            com.tal.app.thinkacademy.common.entity.LessonType r12 = com.tal.app.thinkacademy.common.entity.LessonType.TEMPORARY
            java.lang.String r12 = r12.name()
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r12)
            if (r9 != 0) goto L_0x02d1
            java.lang.Integer r9 = r3.getSubPlatformType()
            if (r9 != 0) goto L_0x01e0
            goto L_0x01e6
        L_0x01e0:
            int r9 = r9.intValue()
            if (r9 == r5) goto L_0x02d1
        L_0x01e6:
            java.lang.Object[] r9 = new java.lang.Object[r5]
            java.lang.String r12 = "非伪小班，显示家长旁听按钮"
            r9[r6] = r12
            java.lang.String r12 = "旁听"
            com.tal.app.thinkacademy.lib.logger.XesLog.dt(r12, r9)
            r9 = r5
            goto L_0x02d2
        L_0x01f4:
            com.tal.app.thinkacademy.business.study.study.speaker.PlanState r14 = com.tal.app.thinkacademy.business.study.study.speaker.PlanState.PlaybackGenerating
            int r14 = r14.getCode()
            if (r12 != 0) goto L_0x01fd
            goto L_0x021d
        L_0x01fd:
            int r15 = r12.intValue()
            if (r15 != r14) goto L_0x021d
            r7.setVisibility(r13)
            r8.setVisibility(r6)
            r9.setVisibility(r13)
            android.content.Context r9 = r28.getContext()
            int r12 = com.tal.app.thinkacademy.business.studycenter.R.string.plan_playback_generating
            java.lang.String r9 = r9.getString(r12)
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            r8.setText(r9)
            goto L_0x02d1
        L_0x021d:
            com.tal.app.thinkacademy.business.study.study.speaker.PlanState r14 = com.tal.app.thinkacademy.business.study.study.speaker.PlanState.Playback
            int r14 = r14.getCode()
            if (r12 != 0) goto L_0x0226
            goto L_0x0246
        L_0x0226:
            int r15 = r12.intValue()
            if (r15 != r14) goto L_0x0246
            r7.setVisibility(r13)
            r8.setVisibility(r6)
            r9.setVisibility(r13)
            android.content.Context r9 = r28.getContext()
            int r12 = com.tal.app.thinkacademy.business.studycenter.R.string.plan_playback
            java.lang.String r9 = r9.getString(r12)
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            r8.setText(r9)
            goto L_0x02d1
        L_0x0246:
            com.tal.app.thinkacademy.business.study.study.speaker.PlanState r14 = com.tal.app.thinkacademy.business.study.study.speaker.PlanState.PlaybackExpired
            int r14 = r14.getCode()
            if (r12 != 0) goto L_0x024f
            goto L_0x026e
        L_0x024f:
            int r15 = r12.intValue()
            if (r15 != r14) goto L_0x026e
            r7.setVisibility(r13)
            r8.setVisibility(r13)
            r9.setVisibility(r6)
            android.content.Context r12 = r28.getContext()
            int r14 = com.tal.app.thinkacademy.business.studycenter.R.string.plan_playback_expired
            java.lang.String r12 = r12.getString(r14)
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            r9.setText(r12)
            goto L_0x02d1
        L_0x026e:
            com.tal.app.thinkacademy.business.study.study.speaker.PlanState r14 = com.tal.app.thinkacademy.business.study.study.speaker.PlanState.Unpaid
            int r14 = r14.getCode()
            if (r12 != 0) goto L_0x0277
            goto L_0x0296
        L_0x0277:
            int r15 = r12.intValue()
            if (r15 != r14) goto L_0x0296
            r7.setVisibility(r13)
            r8.setVisibility(r13)
            r9.setVisibility(r6)
            android.content.Context r12 = r28.getContext()
            int r14 = com.tal.app.thinkacademy.business.studycenter.R.string.plan_unpaid
            java.lang.String r12 = r12.getString(r14)
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            r9.setText(r12)
            goto L_0x02d1
        L_0x0296:
            com.tal.app.thinkacademy.business.study.study.speaker.PlanState r14 = com.tal.app.thinkacademy.business.study.study.speaker.PlanState.NotShow
            int r14 = r14.getCode()
            if (r12 != 0) goto L_0x029f
            goto L_0x02af
        L_0x029f:
            int r12 = r12.intValue()
            if (r12 != r14) goto L_0x02af
            r7.setVisibility(r13)
            r8.setVisibility(r13)
            r9.setVisibility(r13)
            goto L_0x02d1
        L_0x02af:
            r7.setVisibility(r13)
            r8.setVisibility(r13)
            r9.setVisibility(r13)
            goto L_0x02d1
        L_0x02b9:
            r7.setVisibility(r13)
            r8.setVisibility(r6)
            r9.setVisibility(r13)
            android.content.Context r9 = r28.getContext()
            int r12 = com.tal.app.thinkacademy.business.studycenter.R.string.check_the_class_mode
            java.lang.String r9 = r9.getString(r12)
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            r8.setText(r9)
        L_0x02d1:
            r9 = r6
        L_0x02d2:
            if (r9 == 0) goto L_0x02d8
            r4.setVisibility(r6)
            goto L_0x02db
        L_0x02d8:
            r4.setVisibility(r13)
        L_0x02db:
            com.tal.app.thinkacademy.business.study.study.entity.AssignmentEntity r9 = r3.getAssignment()
            if (r9 == 0) goto L_0x03c2
            com.tal.app.thinkacademy.business.study.study.entity.AssignmentEntity r9 = r3.getAssignment()
            java.lang.Integer r9 = r9.getStatus()
            com.tal.app.thinkacademy.business.study.study.speaker.AssignmentType r12 = com.tal.app.thinkacademy.business.study.study.speaker.AssignmentType.Hid
            int r12 = r12.getCode()
            if (r9 != 0) goto L_0x02f2
            goto L_0x02fa
        L_0x02f2:
            int r9 = r9.intValue()
            if (r9 != r12) goto L_0x02fa
            goto L_0x03c2
        L_0x02fa:
            int r9 = com.tal.app.thinkacademy.business.studycenter.R.id.lyAssignment
            r1.setGone(r9, r6)
            com.tal.app.thinkacademy.business.study.study.entity.AssignmentEntity r9 = r3.getAssignment()
            java.lang.Integer r9 = r9.getStatus()
            com.tal.app.thinkacademy.business.study.study.speaker.AssignmentType r12 = com.tal.app.thinkacademy.business.study.study.speaker.AssignmentType.UnPub
            int r12 = r12.getCode()
            if (r9 != 0) goto L_0x0310
            goto L_0x032d
        L_0x0310:
            int r14 = r9.intValue()
            if (r14 != r12) goto L_0x032d
            r10.setVisibility(r13)
            r11.setVisibility(r6)
            android.content.Context r9 = r28.getContext()
            int r12 = com.tal.app.thinkacademy.business.studycenter.R.string.assignment_unpublished
            java.lang.String r9 = r9.getString(r12)
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            r11.setText(r9)
            goto L_0x03c7
        L_0x032d:
            com.tal.app.thinkacademy.business.study.study.speaker.AssignmentType r12 = com.tal.app.thinkacademy.business.study.study.speaker.AssignmentType.UnSub
            int r12 = r12.getCode()
            if (r9 != 0) goto L_0x0336
            goto L_0x0353
        L_0x0336:
            int r14 = r9.intValue()
            if (r14 != r12) goto L_0x0353
            r10.setVisibility(r6)
            r11.setVisibility(r13)
            android.content.Context r9 = r28.getContext()
            int r12 = com.tal.app.thinkacademy.business.studycenter.R.string.assignment_unsubmitted
            java.lang.String r9 = r9.getString(r12)
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            r10.setText(r9)
            goto L_0x03c7
        L_0x0353:
            com.tal.app.thinkacademy.business.study.study.speaker.AssignmentType r12 = com.tal.app.thinkacademy.business.study.study.speaker.AssignmentType.Review
            int r12 = r12.getCode()
            if (r9 != 0) goto L_0x035c
            goto L_0x0378
        L_0x035c:
            int r14 = r9.intValue()
            if (r14 != r12) goto L_0x0378
            r10.setVisibility(r6)
            r11.setVisibility(r13)
            android.content.Context r9 = r28.getContext()
            int r12 = com.tal.app.thinkacademy.business.studycenter.R.string.assignment_reviewed
            java.lang.String r9 = r9.getString(r12)
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            r10.setText(r9)
            goto L_0x03c7
        L_0x0378:
            com.tal.app.thinkacademy.business.study.study.speaker.AssignmentType r12 = com.tal.app.thinkacademy.business.study.study.speaker.AssignmentType.Sumb
            int r12 = r12.getCode()
            if (r9 != 0) goto L_0x0381
            goto L_0x039d
        L_0x0381:
            int r14 = r9.intValue()
            if (r14 != r12) goto L_0x039d
            r10.setVisibility(r6)
            r11.setVisibility(r13)
            android.content.Context r9 = r28.getContext()
            int r12 = com.tal.app.thinkacademy.business.studycenter.R.string.assignment_submitted
            java.lang.String r9 = r9.getString(r12)
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            r10.setText(r9)
            goto L_0x03c7
        L_0x039d:
            com.tal.app.thinkacademy.business.study.study.speaker.AssignmentType r12 = com.tal.app.thinkacademy.business.study.study.speaker.AssignmentType.Expired
            int r12 = r12.getCode()
            if (r9 != 0) goto L_0x03a6
            goto L_0x03c7
        L_0x03a6:
            int r9 = r9.intValue()
            if (r9 != r12) goto L_0x03c7
            r10.setVisibility(r13)
            r11.setVisibility(r6)
            android.content.Context r9 = r28.getContext()
            int r12 = com.tal.app.thinkacademy.business.studycenter.R.string.expired
            java.lang.String r9 = r9.getString(r12)
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            r11.setText(r9)
            goto L_0x03c7
        L_0x03c2:
            int r9 = com.tal.app.thinkacademy.business.studycenter.R.id.lyAssignment
            r1.setGone(r9, r5)
        L_0x03c7:
            com.tal.app.thinkacademy.lib.utils.RxUnDoubleUtil r14 = com.tal.app.thinkacademy.lib.utils.RxUnDoubleUtil.INSTANCE
            r15 = r4
            android.view.View r15 = (android.view.View) r15
            r16 = 0
            com.tal.app.thinkacademy.business.study.study.speaker.adapter.CalendarAdapter$showLessonItem$1$2 r4 = new com.tal.app.thinkacademy.business.study.study.speaker.adapter.CalendarAdapter$showLessonItem$1$2
            r4.<init>(r0, r2)
            r18 = r4
            kotlin.jvm.functions.Function0 r18 = (kotlin.jvm.functions.Function0) r18
            r19 = 1
            r20 = 0
            com.tal.app.thinkacademy.lib.utils.RxUnDoubleUtil.setOnUnDoubleClickListener$default(r14, r15, r16, r18, r19, r20)
            com.tal.app.thinkacademy.lib.utils.RxUnDoubleUtil r21 = com.tal.app.thinkacademy.lib.utils.RxUnDoubleUtil.INSTANCE
            r22 = r7
            android.view.View r22 = (android.view.View) r22
            r23 = 0
            com.tal.app.thinkacademy.business.study.study.speaker.adapter.CalendarAdapter$showLessonItem$1$3 r4 = new com.tal.app.thinkacademy.business.study.study.speaker.adapter.CalendarAdapter$showLessonItem$1$3
            r4.<init>(r1, r2, r0)
            r25 = r4
            kotlin.jvm.functions.Function0 r25 = (kotlin.jvm.functions.Function0) r25
            r26 = 1
            r27 = 0
            com.tal.app.thinkacademy.lib.utils.RxUnDoubleUtil.setOnUnDoubleClickListener$default(r21, r22, r23, r25, r26, r27)
            com.tal.app.thinkacademy.lib.utils.RxUnDoubleUtil r14 = com.tal.app.thinkacademy.lib.utils.RxUnDoubleUtil.INSTANCE
            r15 = r8
            android.view.View r15 = (android.view.View) r15
            com.tal.app.thinkacademy.business.study.study.speaker.adapter.CalendarAdapter$showLessonItem$1$4 r4 = new com.tal.app.thinkacademy.business.study.study.speaker.adapter.CalendarAdapter$showLessonItem$1$4
            r4.<init>(r0, r2)
            r18 = r4
            kotlin.jvm.functions.Function0 r18 = (kotlin.jvm.functions.Function0) r18
            com.tal.app.thinkacademy.lib.utils.RxUnDoubleUtil.setOnUnDoubleClickListener$default(r14, r15, r16, r18, r19, r20)
            com.tal.app.thinkacademy.lib.utils.RxUnDoubleUtil r21 = com.tal.app.thinkacademy.lib.utils.RxUnDoubleUtil.INSTANCE
            r22 = r11
            android.view.View r22 = (android.view.View) r22
            com.tal.app.thinkacademy.business.study.study.speaker.adapter.CalendarAdapter$showLessonItem$1$5 r4 = new com.tal.app.thinkacademy.business.study.study.speaker.adapter.CalendarAdapter$showLessonItem$1$5
            r4.<init>(r0, r2)
            r25 = r4
            kotlin.jvm.functions.Function0 r25 = (kotlin.jvm.functions.Function0) r25
            com.tal.app.thinkacademy.lib.utils.RxUnDoubleUtil.setOnUnDoubleClickListener$default(r21, r22, r23, r25, r26, r27)
            com.tal.app.thinkacademy.lib.utils.RxUnDoubleUtil r14 = com.tal.app.thinkacademy.lib.utils.RxUnDoubleUtil.INSTANCE
            r15 = r10
            android.view.View r15 = (android.view.View) r15
            com.tal.app.thinkacademy.business.study.study.speaker.adapter.CalendarAdapter$showLessonItem$1$6 r4 = new com.tal.app.thinkacademy.business.study.study.speaker.adapter.CalendarAdapter$showLessonItem$1$6
            r4.<init>(r3, r0, r2)
            r18 = r4
            kotlin.jvm.functions.Function0 r18 = (kotlin.jvm.functions.Function0) r18
            com.tal.app.thinkacademy.lib.utils.RxUnDoubleUtil.setOnUnDoubleClickListener$default(r14, r15, r16, r18, r19, r20)
            int r4 = com.tal.app.thinkacademy.business.studycenter.R.id.lyMaterials
            android.view.View r4 = r1.getView(r4)
            int r7 = com.tal.app.thinkacademy.business.studycenter.R.id.tvMaterialsButton
            android.view.View r7 = r1.getView(r7)
            com.flyco.roundview.RoundTextView r7 = (com.flyco.roundview.RoundTextView) r7
            com.tal.app.thinkacademy.business.study.study.entity.MaterialEntity r8 = r3.getMaterial()
            if (r8 != 0) goto L_0x0440
            goto L_0x04b9
        L_0x0440:
            java.lang.Integer r9 = r8.getCount()
            if (r9 != 0) goto L_0x0447
            goto L_0x0451
        L_0x0447:
            int r10 = r9.intValue()
            if (r10 != 0) goto L_0x0451
            r4.setVisibility(r13)
            goto L_0x04b5
        L_0x0451:
            java.lang.String r10 = "format(format, *args)"
            if (r9 != 0) goto L_0x0456
            goto L_0x0489
        L_0x0456:
            int r9 = r9.intValue()
            if (r9 != r5) goto L_0x0489
            r4.setVisibility(r6)
            kotlin.jvm.internal.StringCompanionObject r4 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            android.content.Context r4 = r28.getContext()
            int r9 = com.tal.app.thinkacademy.business.studycenter.R.string.single_file
            java.lang.String r4 = r4.getString(r9)
            java.lang.String r9 = "context.getString(R.string.single_file)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r9)
            java.lang.Object[] r9 = new java.lang.Object[r5]
            java.lang.Integer r8 = r8.getCount()
            r9[r6] = r8
            java.lang.Object[] r8 = java.util.Arrays.copyOf(r9, r5)
            java.lang.String r4 = java.lang.String.format(r4, r8)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r10)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r7.setText(r4)
            goto L_0x04b5
        L_0x0489:
            r4.setVisibility(r6)
            kotlin.jvm.internal.StringCompanionObject r4 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            android.content.Context r4 = r28.getContext()
            int r9 = com.tal.app.thinkacademy.business.studycenter.R.string.multi_file
            java.lang.String r4 = r4.getString(r9)
            java.lang.String r9 = "context.getString(R.string.multi_file)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r9)
            java.lang.Object[] r9 = new java.lang.Object[r5]
            java.lang.Integer r8 = r8.getCount()
            r9[r6] = r8
            java.lang.Object[] r8 = java.util.Arrays.copyOf(r9, r5)
            java.lang.String r4 = java.lang.String.format(r4, r8)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r10)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r7.setText(r4)
        L_0x04b5:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
        L_0x04b9:
            int r4 = com.tal.app.thinkacademy.business.studycenter.R.id.tvMaterialsTitle
            android.view.View r4 = r1.getView(r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            android.content.Context r8 = r28.getContext()
            int r9 = com.tal.app.thinkacademy.business.studycenter.R.string.study_material_list_title
            java.lang.String r8 = r8.getString(r9)
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            r4.setText(r8)
            com.tal.app.thinkacademy.lib.utils.RxUnDoubleUtil r14 = com.tal.app.thinkacademy.lib.utils.RxUnDoubleUtil.INSTANCE
            r15 = r7
            android.view.View r15 = (android.view.View) r15
            r16 = 0
            com.tal.app.thinkacademy.business.study.study.speaker.adapter.CalendarAdapter$showLessonItem$1$8 r4 = new com.tal.app.thinkacademy.business.study.study.speaker.adapter.CalendarAdapter$showLessonItem$1$8
            r4.<init>(r3, r0)
            r18 = r4
            kotlin.jvm.functions.Function0 r18 = (kotlin.jvm.functions.Function0) r18
            r19 = 1
            r20 = 0
            com.tal.app.thinkacademy.lib.utils.RxUnDoubleUtil.setOnUnDoubleClickListener$default(r14, r15, r16, r18, r19, r20)
            com.tal.app.thinkacademy.business.study.study.entity.ExamDetails r4 = r3.getExam()
            r7 = 5
            r8 = 4
            r9 = 3
            r10 = 2
            if (r4 != 0) goto L_0x04f8
            int r4 = com.tal.app.thinkacademy.business.studycenter.R.id.lyExam
            r1.setGone(r4, r5)
            goto L_0x0620
        L_0x04f8:
            int r4 = com.tal.app.thinkacademy.business.studycenter.R.id.lyExam
            r1.setGone(r4, r6)
            int r4 = com.tal.app.thinkacademy.business.studycenter.R.id.tvExamTitle
            com.tal.app.thinkacademy.business.study.study.entity.ExamDetails r11 = r3.getExam()
            java.lang.String r11 = r11.getExamName()
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            r1.setText(r4, r11)
            com.tal.app.thinkacademy.business.study.study.entity.ExamDetails r4 = r3.getExam()
            java.lang.Boolean r4 = r4.getSupportAfterAnswer()
            java.lang.Boolean r11 = java.lang.Boolean.valueOf(r5)
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r11)
            if (r4 == 0) goto L_0x0566
            com.tal.app.thinkacademy.business.study.study.entity.ExamDetails r4 = r3.getExam()
            java.lang.Integer r4 = r4.getStatus()
            if (r4 != 0) goto L_0x0529
            goto L_0x0566
        L_0x0529:
            int r4 = r4.intValue()
            if (r4 != r10) goto L_0x0566
            int r4 = com.tal.app.thinkacademy.business.studycenter.R.id.tvExamReportTime
            r1.setGone(r4, r5)
            int r4 = com.tal.app.thinkacademy.business.studycenter.R.id.tvExamButton
            r1.setGone(r4, r6)
            int r4 = com.tal.app.thinkacademy.business.studycenter.R.id.tvExamButton
            android.content.Context r11 = r28.getContext()
            int r12 = com.tal.app.thinkacademy.business.studycenter.R.string.go_to_test
            java.lang.String r11 = r11.getString(r12)
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            r1.setText(r4, r11)
            com.tal.app.thinkacademy.lib.utils.RxUnDoubleUtil r14 = com.tal.app.thinkacademy.lib.utils.RxUnDoubleUtil.INSTANCE
            int r4 = com.tal.app.thinkacademy.business.studycenter.R.id.tvExamButton
            android.view.View r15 = r1.getView(r4)
            r16 = 0
            com.tal.app.thinkacademy.business.study.study.speaker.adapter.CalendarAdapter$showLessonItem$1$9 r4 = new com.tal.app.thinkacademy.business.study.study.speaker.adapter.CalendarAdapter$showLessonItem$1$9
            r4.<init>(r0, r2)
            r18 = r4
            kotlin.jvm.functions.Function0 r18 = (kotlin.jvm.functions.Function0) r18
            r19 = 1
            r20 = 0
            com.tal.app.thinkacademy.lib.utils.RxUnDoubleUtil.setOnUnDoubleClickListener$default(r14, r15, r16, r18, r19, r20)
            goto L_0x0620
        L_0x0566:
            com.tal.app.thinkacademy.business.study.study.entity.ExamDetails r4 = r3.getExam()
            java.lang.Boolean r4 = r4.getCanViewReport()
            java.lang.Boolean r11 = java.lang.Boolean.valueOf(r5)
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r11)
            if (r4 == 0) goto L_0x05f9
            int r4 = com.tal.app.thinkacademy.business.studycenter.R.id.tvExamReportTime
            r1.setGone(r4, r5)
            int r4 = com.tal.app.thinkacademy.business.studycenter.R.id.tvExamButton
            r1.setGone(r4, r6)
            com.tal.app.thinkacademy.business.study.study.entity.ExamDetails r4 = r3.getExam()
            java.lang.Integer r4 = r4.getStatus()
            if (r4 != 0) goto L_0x058d
            goto L_0x05a3
        L_0x058d:
            int r11 = r4.intValue()
            if (r11 != r9) goto L_0x05a3
            android.content.Context r4 = r28.getContext()
            int r11 = com.tal.app.thinkacademy.business.studycenter.R.string.submitted
            java.lang.String r4 = r4.getString(r11)
            java.lang.String r11 = "context.getString(R.string.submitted)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r11)
            goto L_0x05d7
        L_0x05a3:
            if (r4 != 0) goto L_0x05a6
            goto L_0x05bc
        L_0x05a6:
            int r11 = r4.intValue()
            if (r11 != r8) goto L_0x05bc
            android.content.Context r4 = r28.getContext()
            int r11 = com.tal.app.thinkacademy.business.studycenter.R.string.reviewed
            java.lang.String r4 = r4.getString(r11)
            java.lang.String r11 = "context.getString(R.string.reviewed)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r11)
            goto L_0x05d7
        L_0x05bc:
            if (r4 != 0) goto L_0x05bf
            goto L_0x05d5
        L_0x05bf:
            int r4 = r4.intValue()
            if (r4 != r7) goto L_0x05d5
            android.content.Context r4 = r28.getContext()
            int r11 = com.tal.app.thinkacademy.business.studycenter.R.string.expired
            java.lang.String r4 = r4.getString(r11)
            java.lang.String r11 = "context.getString(R.string.expired)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r11)
            goto L_0x05d7
        L_0x05d5:
            java.lang.String r4 = ""
        L_0x05d7:
            int r11 = com.tal.app.thinkacademy.business.studycenter.R.id.tvExamButton
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r1.setText(r11, r4)
            com.tal.app.thinkacademy.lib.utils.RxUnDoubleUtil r14 = com.tal.app.thinkacademy.lib.utils.RxUnDoubleUtil.INSTANCE
            int r4 = com.tal.app.thinkacademy.business.studycenter.R.id.tvExamButton
            android.view.View r15 = r1.getView(r4)
            r16 = 0
            com.tal.app.thinkacademy.business.study.study.speaker.adapter.CalendarAdapter$showLessonItem$1$10 r4 = new com.tal.app.thinkacademy.business.study.study.speaker.adapter.CalendarAdapter$showLessonItem$1$10
            r4.<init>(r0, r2)
            r18 = r4
            kotlin.jvm.functions.Function0 r18 = (kotlin.jvm.functions.Function0) r18
            r19 = 1
            r20 = 0
            com.tal.app.thinkacademy.lib.utils.RxUnDoubleUtil.setOnUnDoubleClickListener$default(r14, r15, r16, r18, r19, r20)
            goto L_0x0620
        L_0x05f9:
            int r4 = com.tal.app.thinkacademy.business.studycenter.R.id.tvExamReportTime
            android.content.Context r11 = r28.getContext()
            int r12 = com.tal.app.thinkacademy.business.studycenter.R.string.lesson_report_check_time
            java.lang.Object[] r14 = new java.lang.Object[r5]
            com.tal.app.thinkacademy.business.study.study.entity.ExamDetails r15 = r3.getExam()
            java.lang.String r15 = r15.getCanViewTime()
            r14[r6] = r15
            java.lang.String r11 = r11.getString(r12, r14)
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            r1.setText(r4, r11)
            int r4 = com.tal.app.thinkacademy.business.studycenter.R.id.tvExamReportTime
            r1.setGone(r4, r6)
            int r4 = com.tal.app.thinkacademy.business.studycenter.R.id.tvExamButton
            r1.setGone(r4, r5)
        L_0x0620:
            int r4 = com.tal.app.thinkacademy.business.studycenter.R.id.tvLessonReport
            android.view.View r4 = r1.getView(r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            com.tal.app.thinkacademy.business.study.study.entity.Performance r11 = r3.getPerformance()
            if (r11 != 0) goto L_0x0630
            r11 = r6
            goto L_0x063c
        L_0x0630:
            java.lang.Boolean r11 = r11.getAvailable()
            java.lang.Boolean r12 = java.lang.Boolean.valueOf(r5)
            boolean r11 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r11, (java.lang.Object) r12)
        L_0x063c:
            if (r11 == 0) goto L_0x0642
            r4.setVisibility(r6)
            goto L_0x0645
        L_0x0642:
            r4.setVisibility(r13)
        L_0x0645:
            com.tal.app.thinkacademy.lib.utils.RxUnDoubleUtil r14 = com.tal.app.thinkacademy.lib.utils.RxUnDoubleUtil.INSTANCE
            r15 = r4
            android.view.View r15 = (android.view.View) r15
            r16 = 0
            com.tal.app.thinkacademy.business.study.study.speaker.adapter.CalendarAdapter$showLessonItem$1$11 r4 = new com.tal.app.thinkacademy.business.study.study.speaker.adapter.CalendarAdapter$showLessonItem$1$11
            r4.<init>(r3)
            r18 = r4
            kotlin.jvm.functions.Function0 r18 = (kotlin.jvm.functions.Function0) r18
            r19 = 1
            r20 = 0
            com.tal.app.thinkacademy.lib.utils.RxUnDoubleUtil.setOnUnDoubleClickListener$default(r14, r15, r16, r18, r19, r20)
            int r4 = com.tal.app.thinkacademy.business.studycenter.R.id.llPreQuestion
            android.view.View r4 = r1.getView(r4)
            android.widget.LinearLayout r4 = (android.widget.LinearLayout) r4
            com.tal.app.thinkacademy.business.study.study.entity.AssignmentEntity r11 = r3.getPreviewQuestion()
            if (r11 != 0) goto L_0x066f
            r4.setVisibility(r13)
            goto L_0x078a
        L_0x066f:
            com.tal.app.thinkacademy.business.study.study.entity.AssignmentEntity r11 = r3.getPreviewQuestion()
            java.lang.Integer r11 = r11.getStatus()
            if (r11 != 0) goto L_0x067a
            goto L_0x0685
        L_0x067a:
            int r12 = r11.intValue()
            if (r12 != r5) goto L_0x0685
            r4.setVisibility(r13)
            goto L_0x078a
        L_0x0685:
            r4.setVisibility(r6)
            int r4 = com.tal.app.thinkacademy.business.studycenter.R.id.tvPreQuestionName
            com.tal.app.thinkacademy.business.study.study.entity.AssignmentEntity r5 = r3.getPreviewQuestion()
            java.lang.String r5 = r5.getTitle()
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r1.setText(r4, r5)
            int r4 = com.tal.app.thinkacademy.business.studycenter.R.id.tvPreQuestionEndTime
            com.tal.app.thinkacademy.business.study.study.entity.AssignmentEntity r3 = r3.getPreviewQuestion()
            java.lang.String r3 = r3.getEndTime()
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r1.setText(r4, r3)
            int r3 = com.tal.app.thinkacademy.business.studycenter.R.id.tvPreQuestionGray
            android.view.View r3 = r1.getView(r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            int r4 = com.tal.app.thinkacademy.business.studycenter.R.id.ivPreQuestionFinished
            android.view.View r4 = r1.getView(r4)
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            int r5 = com.tal.app.thinkacademy.business.studycenter.R.id.tvDoPretest
            android.view.View r1 = r1.getView(r5)
            com.flyco.roundview.RoundTextView r1 = (com.flyco.roundview.RoundTextView) r1
            if (r11 != 0) goto L_0x06c1
            goto L_0x06e1
        L_0x06c1:
            int r5 = r11.intValue()
            if (r5 != r10) goto L_0x06e1
            r3.setVisibility(r6)
            r4.setVisibility(r13)
            r1.setVisibility(r13)
            android.content.Context r4 = r28.getContext()
            int r5 = com.tal.app.thinkacademy.business.studycenter.R.string.unpublished
            java.lang.String r4 = r4.getString(r5)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r3.setText(r4)
            goto L_0x075f
        L_0x06e1:
            if (r11 != 0) goto L_0x06e4
            goto L_0x0703
        L_0x06e4:
            int r5 = r11.intValue()
            if (r5 != r9) goto L_0x0703
            r3.setVisibility(r13)
            r4.setVisibility(r13)
            r1.setVisibility(r6)
            android.content.Context r4 = r28.getContext()
            int r5 = com.tal.app.thinkacademy.business.studycenter.R.string.start_test
            java.lang.String r4 = r4.getString(r5)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r1.setText(r4)
            goto L_0x075f
        L_0x0703:
            if (r11 != 0) goto L_0x0706
            goto L_0x0725
        L_0x0706:
            int r5 = r11.intValue()
            if (r5 != r8) goto L_0x0725
            r3.setVisibility(r6)
            r4.setVisibility(r6)
            r1.setVisibility(r13)
            android.content.Context r4 = r28.getContext()
            int r5 = com.tal.app.thinkacademy.business.studycenter.R.string.reviewed
            java.lang.String r4 = r4.getString(r5)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r3.setText(r4)
            goto L_0x075f
        L_0x0725:
            if (r11 != 0) goto L_0x0728
            goto L_0x0747
        L_0x0728:
            int r5 = r11.intValue()
            if (r5 != r7) goto L_0x0747
            r3.setVisibility(r6)
            r4.setVisibility(r6)
            r1.setVisibility(r13)
            android.content.Context r4 = r28.getContext()
            int r5 = com.tal.app.thinkacademy.business.studycenter.R.string.submitted
            java.lang.String r4 = r4.getString(r5)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r3.setText(r4)
            goto L_0x075f
        L_0x0747:
            r3.setVisibility(r6)
            r4.setVisibility(r6)
            r1.setVisibility(r13)
            android.content.Context r4 = r28.getContext()
            int r5 = com.tal.app.thinkacademy.business.studycenter.R.string.expired
            java.lang.String r4 = r4.getString(r5)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r3.setText(r4)
        L_0x075f:
            com.tal.app.thinkacademy.lib.utils.RxUnDoubleUtil r5 = com.tal.app.thinkacademy.lib.utils.RxUnDoubleUtil.INSTANCE
            r6 = r3
            android.view.View r6 = (android.view.View) r6
            r7 = 0
            com.tal.app.thinkacademy.business.study.study.speaker.adapter.CalendarAdapter$showLessonItem$1$12 r3 = new com.tal.app.thinkacademy.business.study.study.speaker.adapter.CalendarAdapter$showLessonItem$1$12
            r3.<init>(r0, r2)
            r9 = r3
            kotlin.jvm.functions.Function0 r9 = (kotlin.jvm.functions.Function0) r9
            r10 = 1
            r11 = 0
            com.tal.app.thinkacademy.lib.utils.RxUnDoubleUtil.setOnUnDoubleClickListener$default(r5, r6, r7, r9, r10, r11)
            com.tal.app.thinkacademy.lib.utils.RxUnDoubleUtil r12 = com.tal.app.thinkacademy.lib.utils.RxUnDoubleUtil.INSTANCE
            r13 = r1
            android.view.View r13 = (android.view.View) r13
            r14 = 0
            com.tal.app.thinkacademy.business.study.study.speaker.adapter.CalendarAdapter$showLessonItem$1$13 r1 = new com.tal.app.thinkacademy.business.study.study.speaker.adapter.CalendarAdapter$showLessonItem$1$13
            r1.<init>(r0, r2)
            r16 = r1
            kotlin.jvm.functions.Function0 r16 = (kotlin.jvm.functions.Function0) r16
            r17 = 1
            r18 = 0
            com.tal.app.thinkacademy.lib.utils.RxUnDoubleUtil.setOnUnDoubleClickListener$default(r12, r13, r14, r16, r17, r18)
        L_0x078a:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
        L_0x078e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.study.study.speaker.adapter.CalendarAdapter.showLessonItem(com.chad.library.adapter.base.viewholder.BaseViewHolder, com.tal.app.thinkacademy.business.study.study.entity.CalendarItem):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: showLessonItem$lambda-4$lambda-2  reason: not valid java name */
    public static final void m490showLessonItem$lambda4$lambda2(LessonDetails lessonDetails, CalendarAdapter calendarAdapter, RoundLinearLayout roundLinearLayout, ImageView imageView, View view) {
        Intrinsics.checkNotNullParameter(lessonDetails, "$this_run");
        Intrinsics.checkNotNullParameter(calendarAdapter, "this$0");
        Intrinsics.checkNotNullParameter(roundLinearLayout, "$rlSpeakerState");
        Intrinsics.checkNotNullParameter(imageView, "$ivSpeakerUnfold");
        lessonDetails.setShow(!lessonDetails.isShow());
        calendarAdapter.showBottomView(roundLinearLayout, imageView, lessonDetails);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    private final void showExamItem(BaseViewHolder baseViewHolder, CalendarItem calendarItem) {
        Integer num;
        CharSequence charSequence;
        ExamDetails examDetails = calendarItem.getExamDetails();
        Integer num2 = null;
        baseViewHolder.setText(R.id.tvExamName, examDetails == null ? null : examDetails.getExamName());
        if (examDetails == null) {
            num = null;
        } else {
            num = examDetails.getExamStatus();
        }
        TextView textView = (TextView) baseViewHolder.getView(R.id.tvExamStatus);
        if (num != null) {
            textView.setSelected(num.intValue() > 1);
        }
        if (examDetails != null) {
            num2 = examDetails.getExamStatus();
        }
        if (num2 != null && num2.intValue() == 1) {
            charSequence = getContext().getString(R.string.exam_unpublished);
        } else if (num2 != null && num2.intValue() == 2) {
            charSequence = getContext().getString(R.string.go_to_test);
        } else if (num2 != null && num2.intValue() == 3) {
            charSequence = getContext().getString(R.string.answer_submitted);
        } else if (num2 != null && num2.intValue() == 4) {
            charSequence = getContext().getString(R.string.test_reviewed);
        } else {
            charSequence = getContext().getString(R.string.test_expired);
        }
        textView.setText(charSequence);
        RxUnDoubleUtil.setOnUnDoubleClickListener$default(RxUnDoubleUtil.INSTANCE, textView, 0, new CalendarAdapter$showExamItem$1$1(this, calendarItem), 1, (Object) null);
    }

    private final void showBottomView(RoundLinearLayout roundLinearLayout, ImageView imageView, LessonDetails lessonDetails) {
        if (lessonDetails.isShow()) {
            roundLinearLayout.setVisibility(0);
            imageView.setImageResource(R.drawable.icon_speaker_arrow_up);
            return;
        }
        roundLinearLayout.setVisibility(8);
        imageView.setImageResource(R.drawable.icon_speaker_arrow_down);
    }
}
