package com.tal.app.thinkacademy.business.study.study.adapter;

import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tal.app.thinkacademy.business.study.study.entity.RecordedCourse;
import com.tal.app.thinkacademy.business.study.study.entity.RecordedTeacher;
import com.tal.app.thinkacademy.business.studycenter.R;
import com.tal.app.thinkacademy.common.utils.TextHighLightUtil;
import com.tal.app.thinkacademy.lib.imageloader.XesImageLoader;
import com.tal.app.thinkacademy.lib.imageloader.transformation.RoundedCornersTransformation;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0015\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0014J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016J\u001c\u0010\u000e\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002J\u0018\u0010\u0013\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0002J \u0010\u0014\u001a\u00020\b2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\b\u0010\t\u001a\u0004\u0018\u00010\u0003H\u0002J*\u0010\u0018\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J \u0010\u001d\u001a\u00020\b2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\b\u0010\t\u001a\u0004\u0018\u00010\u0003H\u0002¨\u0006\u001e"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/adapter/RecordedListAdapter;", "Lcom/chad/library/adapter/base/BaseMultiItemQuickAdapter;", "Lcom/tal/app/thinkacademy/business/study/study/entity/RecordedCourse;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "data", "", "(Ljava/util/List;)V", "convert", "", "holder", "item", "getItemViewType", "", "position", "loadTeacherImage", "imgUrl", "", "iv", "Landroid/widget/ImageView;", "setNormalItem", "setTeacherInfo", "list", "", "Lcom/tal/app/thinkacademy/business/study/study/entity/RecordedTeacher;", "showTeacherInfo", "teacher", "tvName", "Landroid/widget/TextView;", "tvTitle", "showTeacherPhoto", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RecordedListAdapter.kt */
public final class RecordedListAdapter extends BaseMultiItemQuickAdapter<RecordedCourse, BaseViewHolder> {
    public RecordedListAdapter(List<RecordedCourse> list) {
        super(list);
        addItemType(0, R.layout.item_study_recorded_course);
        addItemType(2, R.layout.item_study_switch);
        addItemType(4, R.layout.global_footview_height_110dp);
    }

    /* access modifiers changed from: protected */
    public void convert(BaseViewHolder baseViewHolder, RecordedCourse recordedCourse) {
        Intrinsics.checkNotNullParameter(baseViewHolder, "holder");
        Intrinsics.checkNotNullParameter(recordedCourse, "item");
        int itemViewType = baseViewHolder.getItemViewType();
        if (itemViewType == 0) {
            setNormalItem(baseViewHolder, recordedCourse);
        } else if (itemViewType == 2) {
            baseViewHolder.setText(R.id.tvSwitchTip, recordedCourse.getSwitchTip());
            baseViewHolder.setText(R.id.tvSwitchBtn, recordedCourse.getSwitchBtn());
        }
    }

    private final void setNormalItem(BaseViewHolder baseViewHolder, RecordedCourse recordedCourse) {
        int i;
        baseViewHolder.setText(R.id.tv_item_study_course_name, recordedCourse.getName());
        List arrayList = new ArrayList();
        CharSequence subjectTag = recordedCourse.getSubjectTag();
        if (!(subjectTag == null || StringsKt.isBlank(subjectTag))) {
            String subjectTag2 = recordedCourse.getSubjectTag();
            Intrinsics.checkNotNull(subjectTag2);
            arrayList.add(subjectTag2);
        }
        baseViewHolder.getView(R.id.tv_item_study_course_name).setTagStart(arrayList, recordedCourse.getName());
        if (!Intrinsics.areEqual((Object) recordedCourse.getExpired(), (Object) true)) {
            baseViewHolder.setGone(R.id.iv_study_item_tag_expired, true);
            baseViewHolder.setGone(R.id.tv_item_study_course_duration, true);
            baseViewHolder.setGone(R.id.ll_item_study_status, false);
            if (Intrinsics.areEqual((Object) recordedCourse.getPermanent(), (Object) true)) {
                baseViewHolder.setGone(R.id.tvTimeOne, true);
                baseViewHolder.setText(R.id.tvTimeTwo, R.string.courses_valid_permanently);
            } else {
                baseViewHolder.setGone(R.id.tvTimeOne, false);
                baseViewHolder.setText(R.id.tvTimeTwo, recordedCourse.getExpirationTime());
            }
        } else {
            baseViewHolder.setGone(R.id.iv_study_item_tag_expired, false);
            baseViewHolder.setGone(R.id.tv_item_study_course_duration, false);
            baseViewHolder.setGone(R.id.ll_item_study_status, true);
        }
        TextHighLightUtil.INSTANCE.setTextFirstHighLightColorSize((TextView) baseViewHolder.getView(R.id.tv_item_study_course_duration), getContext().getString(R.string.expiration_date) + ' ' + recordedCourse.getExpirationTime(), Intrinsics.stringPlus(" ", recordedCourse.getExpirationTime()), getContext().getColor(R.color.color_172b4d), SizeUtils.dp2px(12.0f), true);
        List<RecordedTeacher> teachers = recordedCourse.getTeachers();
        if (teachers == null) {
            i = 0;
        } else {
            i = teachers.size();
        }
        Collection collection = teachers;
        if (collection == null || collection.isEmpty()) {
            baseViewHolder.setVisible(R.id.layout_item_two_teachers, false);
            baseViewHolder.setGone(R.id.layout_item_many_teachers, true);
        } else if (i < 3) {
            baseViewHolder.setGone(R.id.layout_item_two_teachers, false);
            baseViewHolder.setGone(R.id.layout_item_many_teachers, true);
            setTeacherInfo(teachers, baseViewHolder);
            Unit unit = Unit.INSTANCE;
        } else {
            showTeacherPhoto(teachers, baseViewHolder);
            baseViewHolder.setGone(R.id.layout_item_two_teachers, true);
            baseViewHolder.setGone(R.id.layout_item_many_teachers, false);
        }
    }

    private final void setTeacherInfo(List<RecordedTeacher> list, BaseViewHolder baseViewHolder) {
        Intrinsics.checkNotNull(baseViewHolder);
        showTeacherInfo(list.get(0), (ImageView) baseViewHolder.getView(R.id.iv_item_study_teacher_one), (TextView) baseViewHolder.getView(R.id.tv_item_study_teacher_name_one), (TextView) baseViewHolder.getView(R.id.tv_item_study_teacher_title_one));
        if (list.size() > 1) {
            baseViewHolder.setVisible(R.id.layout_item_study_teacher_two, true);
            showTeacherInfo(list.get(1), (ImageView) baseViewHolder.getView(R.id.iv_item_study_teacher_two), (TextView) baseViewHolder.getView(R.id.tv_item_study_teacher_name_two), (TextView) baseViewHolder.getView(R.id.tv_item_study_teacher_title_two));
            return;
        }
        baseViewHolder.setVisible(R.id.layout_item_study_teacher_two, false);
    }

    private final void showTeacherInfo(RecordedTeacher recordedTeacher, ImageView imageView, TextView textView, TextView textView2) {
        String str;
        String str2;
        String str3 = null;
        loadTeacherImage(recordedTeacher == null ? null : recordedTeacher.getAvatar(), imageView);
        if (recordedTeacher == null) {
            str = null;
        } else {
            str = recordedTeacher.getName();
        }
        textView.setText(str);
        if (recordedTeacher == null) {
            str2 = null;
        } else {
            str2 = recordedTeacher.getIdentityName();
        }
        if (!TextUtils.isEmpty(str2)) {
            if (recordedTeacher != null) {
                str3 = recordedTeacher.getIdentityName();
            }
            textView2.setText(str3);
            textView2.setVisibility(0);
            return;
        }
        textView2.setVisibility(8);
    }

    /* JADX WARNING: type inference failed for: r0v2, types: [android.view.View] */
    /* JADX WARNING: type inference failed for: r0v7, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void showTeacherPhoto(java.util.List<com.tal.app.thinkacademy.business.study.study.entity.RecordedTeacher> r7, com.chad.library.adapter.base.viewholder.BaseViewHolder r8) {
        /*
            r6 = this;
            int r0 = r7.size()
            r1 = 0
            java.lang.Object r2 = r7.get(r1)
            com.tal.app.thinkacademy.business.study.study.entity.RecordedTeacher r2 = (com.tal.app.thinkacademy.business.study.study.entity.RecordedTeacher) r2
            java.lang.String r2 = r2.getAvatar()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            r3 = 0
            if (r8 != 0) goto L_0x0017
            r4 = r3
            goto L_0x001f
        L_0x0017:
            int r4 = com.tal.app.thinkacademy.business.studycenter.R.id.iv_item_study_teacher_photo_one
            android.view.View r4 = r8.getView(r4)
            android.widget.ImageView r4 = (android.widget.ImageView) r4
        L_0x001f:
            r6.loadTeacherImage(r2, r4)
            r2 = 1
            java.lang.Object r4 = r7.get(r2)
            com.tal.app.thinkacademy.business.study.study.entity.RecordedTeacher r4 = (com.tal.app.thinkacademy.business.study.study.entity.RecordedTeacher) r4
            java.lang.String r4 = r4.getAvatar()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            if (r8 != 0) goto L_0x0034
            r5 = r3
            goto L_0x003c
        L_0x0034:
            int r5 = com.tal.app.thinkacademy.business.studycenter.R.id.iv_item_study_teacher_photo_two
            android.view.View r5 = r8.getView(r5)
            android.widget.ImageView r5 = (android.widget.ImageView) r5
        L_0x003c:
            r6.loadTeacherImage(r4, r5)
            r4 = 2
            java.lang.Object r4 = r7.get(r4)
            com.tal.app.thinkacademy.business.study.study.entity.RecordedTeacher r4 = (com.tal.app.thinkacademy.business.study.study.entity.RecordedTeacher) r4
            java.lang.String r4 = r4.getAvatar()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            if (r8 != 0) goto L_0x0051
            r5 = r3
            goto L_0x0059
        L_0x0051:
            int r5 = com.tal.app.thinkacademy.business.studycenter.R.id.iv_item_study_teacher_photo_three
            android.view.View r5 = r8.getView(r5)
            android.widget.ImageView r5 = (android.widget.ImageView) r5
        L_0x0059:
            r6.loadTeacherImage(r4, r5)
            r4 = 3
            if (r0 == r4) goto L_0x00d8
            r5 = 4
            if (r0 == r5) goto L_0x00ab
            java.lang.Object r0 = r7.get(r4)
            com.tal.app.thinkacademy.business.study.study.entity.RecordedTeacher r0 = (com.tal.app.thinkacademy.business.study.study.entity.RecordedTeacher) r0
            java.lang.String r0 = r0.getAvatar()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            if (r8 != 0) goto L_0x0073
            r1 = r3
            goto L_0x007b
        L_0x0073:
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.iv_item_study_teacher_photo_four
            android.view.View r1 = r8.getView(r1)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
        L_0x007b:
            r6.loadTeacherImage(r0, r1)
            java.lang.Object r7 = r7.get(r5)
            com.tal.app.thinkacademy.business.study.study.entity.RecordedTeacher r7 = (com.tal.app.thinkacademy.business.study.study.entity.RecordedTeacher) r7
            java.lang.String r7 = r7.getAvatar()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)
            if (r8 != 0) goto L_0x008e
            goto L_0x0097
        L_0x008e:
            int r0 = com.tal.app.thinkacademy.business.studycenter.R.id.iv_item_study_teacher_photo_five
            android.view.View r0 = r8.getView(r0)
            r3 = r0
            android.widget.ImageView r3 = (android.widget.ImageView) r3
        L_0x0097:
            r6.loadTeacherImage(r7, r3)
            if (r8 != 0) goto L_0x009d
            goto L_0x00a2
        L_0x009d:
            int r7 = com.tal.app.thinkacademy.business.studycenter.R.id.iv_item_study_teacher_photo_four
            r8.setVisible(r7, r2)
        L_0x00a2:
            if (r8 != 0) goto L_0x00a5
            goto L_0x00e8
        L_0x00a5:
            int r7 = com.tal.app.thinkacademy.business.studycenter.R.id.iv_item_study_teacher_photo_five
            r8.setVisible(r7, r2)
            goto L_0x00e8
        L_0x00ab:
            java.lang.Object r7 = r7.get(r4)
            com.tal.app.thinkacademy.business.study.study.entity.RecordedTeacher r7 = (com.tal.app.thinkacademy.business.study.study.entity.RecordedTeacher) r7
            java.lang.String r7 = r7.getAvatar()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)
            if (r8 != 0) goto L_0x00bb
            goto L_0x00c4
        L_0x00bb:
            int r0 = com.tal.app.thinkacademy.business.studycenter.R.id.iv_item_study_teacher_photo_four
            android.view.View r0 = r8.getView(r0)
            r3 = r0
            android.widget.ImageView r3 = (android.widget.ImageView) r3
        L_0x00c4:
            r6.loadTeacherImage(r7, r3)
            if (r8 != 0) goto L_0x00ca
            goto L_0x00cf
        L_0x00ca:
            int r7 = com.tal.app.thinkacademy.business.studycenter.R.id.iv_item_study_teacher_photo_four
            r8.setVisible(r7, r2)
        L_0x00cf:
            if (r8 != 0) goto L_0x00d2
            goto L_0x00e8
        L_0x00d2:
            int r7 = com.tal.app.thinkacademy.business.studycenter.R.id.iv_item_study_teacher_photo_five
            r8.setVisible(r7, r1)
            goto L_0x00e8
        L_0x00d8:
            if (r8 != 0) goto L_0x00db
            goto L_0x00e0
        L_0x00db:
            int r7 = com.tal.app.thinkacademy.business.studycenter.R.id.iv_item_study_teacher_photo_four
            r8.setVisible(r7, r1)
        L_0x00e0:
            if (r8 != 0) goto L_0x00e3
            goto L_0x00e8
        L_0x00e3:
            int r7 = com.tal.app.thinkacademy.business.studycenter.R.id.iv_item_study_teacher_photo_five
            r8.setVisible(r7, r1)
        L_0x00e8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.study.study.adapter.RecordedListAdapter.showTeacherPhoto(java.util.List, com.chad.library.adapter.base.viewholder.BaseViewHolder):void");
    }

    private final void loadTeacherImage(String str, ImageView imageView) {
        if (imageView != null) {
            XesImageLoader.loadRoundCornerImage$default(XesImageLoader.INSTANCE, imageView, getContext(), str, SizeUtils.dp2px(6.0f), 0, R.drawable.shape_avatar_bg, (RoundedCornersTransformation.CornerType) null, 40, (Object) null);
        }
    }

    public int getItemViewType(int i) {
        return ((RecordedCourse) getData().get(i)).getItemType();
    }
}
