package com.tal.app.thinkacademy.business.study.study.speaker.adapter;

import android.view.View;
import android.widget.ImageView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.module.LoadMoreModule;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.flyco.roundview.RoundLinearLayout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.business.study.study.entity.RecordHomework;
import com.tal.app.thinkacademy.business.study.study.entity.RecordLesson;
import com.tal.app.thinkacademy.business.study.study.entity.RecordResource;
import com.tal.app.thinkacademy.business.study.study.entity.RecordedSchedule;
import com.tal.app.thinkacademy.business.study.study.speaker.RecordedCalendarStatus;
import com.tal.app.thinkacademy.business.study.study.speaker.RecordedClickType;
import com.tal.app.thinkacademy.business.study.study.speaker.RecordedFinalExamStatus;
import com.tal.app.thinkacademy.business.studycenter.R;
import com.tal.app.thinkacademy.lib.utils.RxUnDoubleUtil;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004BJ\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006\u00121\b\u0002\u0010\u0007\u001a+\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0002\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\b¢\u0006\u0002\u0010\u000fJ\u0018\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0002H\u0014J \u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002R7\u0010\u0007\u001a+\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0002\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/speaker/adapter/RecordedCalendarAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/tal/app/thinkacademy/business/study/study/entity/RecordedSchedule;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "Lcom/chad/library/adapter/base/module/LoadMoreModule;", "data", "", "listener", "Lkotlin/Function3;", "Lcom/tal/app/thinkacademy/business/study/study/speaker/RecordedClickType;", "", "Lkotlin/ParameterName;", "name", "position", "", "(Ljava/util/List;Lkotlin/jvm/functions/Function3;)V", "convert", "holder", "item", "showBottomView", "rlSpeakerState", "Lcom/flyco/roundview/RoundLinearLayout;", "ivSpeakerUnfold", "Landroid/widget/ImageView;", "expand", "", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RecordedCalendarAdapter.kt */
public final class RecordedCalendarAdapter extends BaseQuickAdapter<RecordedSchedule, BaseViewHolder> implements LoadMoreModule {
    /* access modifiers changed from: private */
    public final Function3<RecordedClickType, RecordedSchedule, Integer, Unit> listener;

    public RecordedCalendarAdapter() {
        this((List) null, (Function3) null, 3, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RecordedCalendarAdapter(List list, Function3 function3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : function3);
    }

    public RecordedCalendarAdapter(List<RecordedSchedule> list, Function3<? super RecordedClickType, ? super RecordedSchedule, ? super Integer, Unit> function3) {
        super(R.layout.study_item_recorded_calendar, list);
        this.listener = function3;
    }

    /* access modifiers changed from: protected */
    public void convert(BaseViewHolder baseViewHolder, RecordedSchedule recordedSchedule) {
        RecordResource recordResource;
        Intrinsics.checkNotNullParameter(baseViewHolder, "holder");
        Intrinsics.checkNotNullParameter(recordedSchedule, "item");
        RecordLesson recordLesson = recordedSchedule.getRecordLesson();
        if (recordLesson != null) {
            RoundLinearLayout view = baseViewHolder.getView(R.id.rlSpeakerState);
            ImageView imageView = (ImageView) baseViewHolder.getView(R.id.ivSpeakerUnfold);
            showBottomView(view, imageView, Intrinsics.areEqual((Object) recordLesson.getExpand(), (Object) true));
            imageView.setOnClickListener(new RecordedCalendarAdapter$$ExternalSyntheticLambda0(recordLesson, this, view, imageView));
            if (Intrinsics.areEqual((Object) recordLesson.getExpand(), (Object) true)) {
                baseViewHolder.setGone(R.id.rlSpeakerState, false);
            } else {
                baseViewHolder.setGone(R.id.rlSpeakerState, true);
            }
            baseViewHolder.setText(R.id.tvSpeakerOrder, recordLesson.orderNum());
            baseViewHolder.setText(R.id.tvSpeakerTitle, recordLesson.getLessonName());
            Collection resourceList = recordLesson.getResourceList();
            String str = null;
            if (resourceList == null || resourceList.isEmpty()) {
                baseViewHolder.setGone(R.id.lyRecordedCourse, true);
            } else {
                baseViewHolder.setGone(R.id.lyRecordedCourse, false);
                baseViewHolder.setGone(R.id.tvRecordedCourseDuration, false);
                int i = R.id.tvRecordedCourseDuration;
                List<RecordResource> resourceList2 = recordLesson.getResourceList();
                baseViewHolder.setText(i, (resourceList2 == null || (recordResource = resourceList2.get(0)) == null) ? null : recordResource.getDuration());
                String displayStatus = recordLesson.getDisplayStatus();
                if (Intrinsics.areEqual((Object) displayStatus, (Object) RecordedCalendarStatus.NORMAL.getType())) {
                    baseViewHolder.setGone(R.id.tvRecordedCourseStateName, false);
                    baseViewHolder.setGone(R.id.tvRecordedCourseNameGray, true);
                } else if (Intrinsics.areEqual((Object) displayStatus, (Object) RecordedCalendarStatus.REFUND.getType())) {
                    baseViewHolder.setText(R.id.tvRecordedCourseNameGray, getContext().getString(R.string.refunded));
                    baseViewHolder.setGone(R.id.tvRecordedCourseStateName, true);
                    baseViewHolder.setGone(R.id.tvRecordedCourseNameGray, false);
                } else if (Intrinsics.areEqual((Object) displayStatus, (Object) RecordedCalendarStatus.EXPIRED.getType())) {
                    baseViewHolder.setText(R.id.tvRecordedCourseNameGray, getContext().getString(R.string.expired));
                    baseViewHolder.setGone(R.id.tvRecordedCourseStateName, true);
                    baseViewHolder.setGone(R.id.tvRecordedCourseNameGray, false);
                }
            }
            if (recordLesson.getHomework() == null) {
                baseViewHolder.setGone(R.id.lyFinalExam, true);
            } else {
                baseViewHolder.setGone(R.id.lyFinalExam, false);
                int i2 = R.id.tvFinalExamTitle;
                RecordHomework homework = recordLesson.getHomework();
                baseViewHolder.setText(i2, homework == null ? null : homework.getTitle());
                RecordHomework homework2 = recordLesson.getHomework();
                if (homework2 != null) {
                    str = homework2.getDisplayStatus();
                }
                if (Intrinsics.areEqual((Object) str, (Object) RecordedFinalExamStatus.TO_BE_SUBMIT.getType())) {
                    baseViewHolder.setText(R.id.tvFinalExamStateName, getContext().getString(R.string.recorded_go_to_test));
                    baseViewHolder.setGone(R.id.tvFinalExamStateName, false);
                    baseViewHolder.setGone(R.id.tvFinalExamStateNameGray, true);
                } else if (Intrinsics.areEqual((Object) str, (Object) RecordedFinalExamStatus.SUBMITTED.getType())) {
                    baseViewHolder.setText(R.id.tvFinalExamStateName, getContext().getString(R.string.report));
                    baseViewHolder.setGone(R.id.tvFinalExamStateName, false);
                    baseViewHolder.setGone(R.id.tvFinalExamStateNameGray, true);
                } else if (Intrinsics.areEqual((Object) str, (Object) RecordedFinalExamStatus.EXPIRED.getType())) {
                    baseViewHolder.setText(R.id.tvFinalExamStateNameGray, getContext().getString(R.string.expired));
                    baseViewHolder.setGone(R.id.tvFinalExamStateName, true);
                    baseViewHolder.setGone(R.id.tvFinalExamStateNameGray, false);
                } else if (Intrinsics.areEqual((Object) str, (Object) RecordedFinalExamStatus.REFUND.getType())) {
                    baseViewHolder.setText(R.id.tvFinalExamStateNameGray, getContext().getString(R.string.refunded));
                    baseViewHolder.setGone(R.id.tvFinalExamStateName, true);
                    baseViewHolder.setGone(R.id.tvFinalExamStateNameGray, false);
                }
            }
            RxUnDoubleUtil.INSTANCE.setOnUnDoubleClickListener(baseViewHolder.getView(R.id.tvRecordedCourseStateName), 500, new RecordedCalendarAdapter$convert$1$2(this, recordedSchedule, baseViewHolder));
            RxUnDoubleUtil.INSTANCE.setOnUnDoubleClickListener(baseViewHolder.getView(R.id.tvFinalExamStateName), 500, new RecordedCalendarAdapter$convert$1$3(this, recordedSchedule, baseViewHolder));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: convert$lambda-1$lambda-0  reason: not valid java name */
    public static final void m491convert$lambda1$lambda0(RecordLesson recordLesson, RecordedCalendarAdapter recordedCalendarAdapter, RoundLinearLayout roundLinearLayout, ImageView imageView, View view) {
        Intrinsics.checkNotNullParameter(recordLesson, "$this_run");
        Intrinsics.checkNotNullParameter(recordedCalendarAdapter, "this$0");
        Intrinsics.checkNotNullParameter(roundLinearLayout, "$rlSpeakerState");
        Intrinsics.checkNotNullParameter(imageView, "$ivSpeakerUnfold");
        Boolean expand = recordLesson.getExpand();
        recordLesson.setExpand(expand == null ? null : Boolean.valueOf(!expand.booleanValue()));
        recordedCalendarAdapter.showBottomView(roundLinearLayout, imageView, Intrinsics.areEqual((Object) recordLesson.getExpand(), (Object) true));
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    private final void showBottomView(RoundLinearLayout roundLinearLayout, ImageView imageView, boolean z) {
        if (z) {
            roundLinearLayout.setVisibility(0);
            imageView.setImageResource(R.drawable.icon_speaker_arrow_up);
            return;
        }
        roundLinearLayout.setVisibility(8);
        imageView.setImageResource(R.drawable.icon_speaker_arrow_down);
    }
}
