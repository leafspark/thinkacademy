package com.tal.app.thinkacademy.business.study.study.adapter;

import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tal.app.thinkacademy.business.study.study.entity.Course;
import com.tal.app.thinkacademy.business.study.study.entity.Record;
import com.tal.app.thinkacademy.business.study.study.entity.Teacher;
import com.tal.app.thinkacademy.business.studycenter.R;
import com.tal.app.thinkacademy.common.entity.LessonType;
import com.tal.app.thinkacademy.lib.commui.widget.TagTextView;
import com.tal.app.thinkacademy.lib.imageloader.XesImageLoader;
import com.tal.app.thinkacademy.lib.imageloader.transformation.RoundedCornersTransformation;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import com.tal.app.thinkacademy.lib.utils.RxUnDoubleUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B<\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005\u0012%\b\u0002\u0010\u0006\u001a\u001f\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007¢\u0006\u0002\u0010\rJ\u0018\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0002H\u0014J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u001c\u0010\u0018\u001a\u00020\f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002J\u0018\u0010\u001d\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0002H\u0002J \u0010\u001e\u001a\u00020\f2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003H\u0002J*\u0010\"\u001a\u00020\f2\b\u0010#\u001a\u0004\u0018\u00010!2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%H\u0002J \u0010'\u001a\u00020\f2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003H\u0002R7\u0010\u0006\u001a\u001f\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006("}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/adapter/ClassAdapter;", "Lcom/chad/library/adapter/base/BaseMultiItemQuickAdapter;", "Lcom/tal/app/thinkacademy/business/study/study/entity/Record;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "data", "", "listener", "Lkotlin/Function1;", "Lcom/tal/app/thinkacademy/business/study/study/adapter/ChildClick;", "Lkotlin/ParameterName;", "name", "type", "", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "getListener", "()Lkotlin/jvm/functions/Function1;", "setListener", "(Lkotlin/jvm/functions/Function1;)V", "convert", "holder", "item", "getItemViewType", "", "position", "loadTeacherImage", "imgUrl", "", "iv", "Landroid/widget/ImageView;", "setNormalItem", "setTeacherInfo", "list", "", "Lcom/tal/app/thinkacademy/business/study/study/entity/Teacher;", "showTeacherInfo", "teacher", "tvName", "Landroid/widget/TextView;", "tvTitle", "showTeacherPhoto", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ClassAdapter.kt */
public final class ClassAdapter extends BaseMultiItemQuickAdapter<Record, BaseViewHolder> {
    private Function1<? super ChildClick, Unit> listener;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ClassAdapter(List list, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i & 2) != 0 ? null : function1);
    }

    public final Function1<ChildClick, Unit> getListener() {
        return this.listener;
    }

    public final void setListener(Function1<? super ChildClick, Unit> function1) {
        this.listener = function1;
    }

    public ClassAdapter(List<Record> list, Function1<? super ChildClick, Unit> function1) {
        super(list);
        this.listener = function1;
        addItemType(0, R.layout.item_study_course);
        addItemType(1, R.layout.item_study_testing);
        addItemType(2, R.layout.item_study_switch);
        addItemType(3, R.layout.item_study_parent_title);
        addItemType(4, R.layout.global_footview_height_110dp);
    }

    /* access modifiers changed from: protected */
    public void convert(BaseViewHolder baseViewHolder, Record record) {
        Intrinsics.checkNotNullParameter(baseViewHolder, "holder");
        Intrinsics.checkNotNullParameter(record, "item");
        int itemViewType = baseViewHolder.getItemViewType();
        if (itemViewType == 0) {
            setNormalItem(baseViewHolder, record);
        } else if (itemViewType == 1) {
            RxUnDoubleUtil.INSTANCE.setOnUnDoubleClickListener(baseViewHolder.getView(R.id.ivDeviceTestClose), 500, new ClassAdapter$convert$1(this));
        } else if (itemViewType == 2) {
            baseViewHolder.setText(R.id.tvSwitchTip, record.getSwitchTip());
            baseViewHolder.setText(R.id.tvSwitchBtn, record.getSwitchBtn());
        } else if (itemViewType == 3) {
            baseViewHolder.setText(R.id.tvPartenTitle, record.getParentTitle());
        }
    }

    private final void setNormalItem(BaseViewHolder baseViewHolder, Record record) {
        baseViewHolder.setText(R.id.tv_item_study_course_name, record.getClassName());
        baseViewHolder.getView(R.id.iv_study_item_tag_new).setVisibility(8);
        List arrayList = new ArrayList();
        if (!TextUtils.isEmpty(record.getTag())) {
            arrayList.add(record.getTag());
        }
        TagTextView view = baseViewHolder.getView(R.id.tv_item_study_course_name);
        if (view != null) {
            view.setTagStart(arrayList, record.getClassName());
        }
        if (!TextUtils.isEmpty(record.getTimeDesc())) {
            baseViewHolder.setText(R.id.tv_item_study_course_duration, record.getTimeDesc());
            baseViewHolder.setGone(R.id.tv_item_study_course_duration, false);
        } else {
            baseViewHolder.setGone(R.id.tv_item_study_course_duration, true);
        }
        if (!TextUtils.isEmpty(record.getTimeDesc2())) {
            baseViewHolder.setText(R.id.tv_item_study_course_time, record.getTimeDesc2());
            baseViewHolder.setGone(R.id.tv_item_study_course_time, false);
        } else {
            baseViewHolder.setGone(R.id.tv_item_study_course_time, true);
        }
        List<Teacher> teachers = record.getTeachers();
        int size = teachers.size();
        Collection collection = teachers;
        if (collection == null || collection.isEmpty()) {
            baseViewHolder.setGone(R.id.layout_item_two_teachers, true);
            baseViewHolder.setGone(R.id.layout_item_many_teachers, true);
        } else if (size < 3) {
            baseViewHolder.setGone(R.id.layout_item_two_teachers, false);
            baseViewHolder.setGone(R.id.layout_item_many_teachers, true);
            setTeacherInfo(teachers, baseViewHolder);
        } else {
            showTeacherPhoto(teachers, baseViewHolder);
            baseViewHolder.setGone(R.id.layout_item_two_teachers, true);
            baseViewHolder.setGone(R.id.layout_item_many_teachers, false);
        }
        Course currentLesson = record.getCurrentLesson();
        String str = null;
        String lessonType = currentLesson == null ? null : currentLesson.getLessonType();
        if (Intrinsics.areEqual((Object) lessonType, (Object) LessonType.AUDITION.name())) {
            baseViewHolder.setText(R.id.tv_item_study_course_type, getContext().getString(R.string.audit_class));
        } else if (Intrinsics.areEqual((Object) lessonType, (Object) LessonType.TEMPORARY.name())) {
            baseViewHolder.setText(R.id.tv_item_study_course_type, getContext().getString(R.string.office_hour));
        } else if (Intrinsics.areEqual((Object) lessonType, (Object) LessonType.FORMAL.name())) {
            baseViewHolder.setText(R.id.tv_item_study_course_type, getContext().getString(R.string.purchased_class));
        } else if (Intrinsics.areEqual((Object) lessonType, (Object) LessonType.PLAYBACK.name())) {
            baseViewHolder.setText(R.id.tv_item_study_course_type, getContext().getString(R.string.playback_only));
        }
        int cardStyle = record.getCardStyle();
        if (cardStyle == 3 || cardStyle == 4) {
            baseViewHolder.setGone(R.id.iv_item_study_refund, false);
            int i = R.drawable.study_ic_completed;
            if (cardStyle == 4) {
                i = R.drawable.study_ic_refund;
            }
            baseViewHolder.setImageResource(R.id.iv_item_study_refund, i);
        } else {
            baseViewHolder.setGone(R.id.iv_item_study_refund, true);
        }
        if (cardStyle == 1) {
            baseViewHolder.setGone(R.id.ll_item_study_status, false);
            baseViewHolder.setGone(R.id.tv_item_study_start_class_order, !Intrinsics.areEqual((Object) record.getPlatformType(), (Object) "BIG_ONLINE"));
            baseViewHolder.setGone(R.id.tv_item_study_next_class, true);
            int i2 = R.id.tv_item_study_start_class_order;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string = baseViewHolder.itemView.getContext().getString(R.string.lesson_order_has_start);
            Intrinsics.checkNotNullExpressionValue(string, "holder.itemView.context.…g.lesson_order_has_start)");
            Object[] objArr = new Object[1];
            Course currentLesson2 = record.getCurrentLesson();
            if (currentLesson2 != null) {
                str = currentLesson2.getOrderNum();
            }
            objArr[0] = str;
            String format = String.format(string, Arrays.copyOf(objArr, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            baseViewHolder.setText(i2, format);
        } else if (cardStyle != 2) {
            baseViewHolder.setGone(R.id.ll_item_study_status, true);
        } else {
            baseViewHolder.setGone(R.id.ll_item_study_status, false);
            baseViewHolder.setGone(R.id.tv_item_study_start_class_order, true);
            baseViewHolder.setGone(R.id.tv_item_study_next_class, !Intrinsics.areEqual((Object) record.getPlatformType(), (Object) "BIG_ONLINE"));
            int i3 = R.id.tv_item_study_next_class;
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String string2 = baseViewHolder.itemView.getContext().getString(R.string.study_next_lesson);
            Intrinsics.checkNotNullExpressionValue(string2, "holder.itemView.context.…string.study_next_lesson)");
            String format2 = String.format(string2, Arrays.copyOf(new Object[]{record.getNextLessonTime()}, 1));
            Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
            baseViewHolder.setText(i3, format2);
        }
    }

    private final void setTeacherInfo(List<Teacher> list, BaseViewHolder baseViewHolder) {
        Intrinsics.checkNotNull(baseViewHolder);
        showTeacherInfo(list.get(0), (ImageView) baseViewHolder.getView(R.id.iv_item_study_teacher_one), (TextView) baseViewHolder.getView(R.id.tv_item_study_teacher_name_one), (TextView) baseViewHolder.getView(R.id.tv_item_study_teacher_title_one));
        if (list.size() > 1) {
            baseViewHolder.setVisible(R.id.layout_item_study_teacher_two, true);
            showTeacherInfo(list.get(1), (ImageView) baseViewHolder.getView(R.id.iv_item_study_teacher_two), (TextView) baseViewHolder.getView(R.id.tv_item_study_teacher_name_two), (TextView) baseViewHolder.getView(R.id.tv_item_study_teacher_title_two));
            return;
        }
        baseViewHolder.setVisible(R.id.layout_item_study_teacher_two, false);
    }

    private final void showTeacherInfo(Teacher teacher, ImageView imageView, TextView textView, TextView textView2) {
        String str;
        String str2;
        String str3 = null;
        loadTeacherImage(teacher == null ? null : teacher.getAvatar(), imageView);
        if (teacher == null) {
            str = null;
        } else {
            str = teacher.getName();
        }
        textView.setText(str);
        if (teacher == null) {
            str2 = null;
        } else {
            str2 = teacher.getIdentityName();
        }
        if (!TextUtils.isEmpty(str2)) {
            if (teacher != null) {
                str3 = teacher.getIdentityName();
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
    private final void showTeacherPhoto(java.util.List<com.tal.app.thinkacademy.business.study.study.entity.Teacher> r7, com.chad.library.adapter.base.viewholder.BaseViewHolder r8) {
        /*
            r6 = this;
            int r0 = r7.size()
            r1 = 0
            java.lang.Object r2 = r7.get(r1)
            com.tal.app.thinkacademy.business.study.study.entity.Teacher r2 = (com.tal.app.thinkacademy.business.study.study.entity.Teacher) r2
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
            com.tal.app.thinkacademy.business.study.study.entity.Teacher r4 = (com.tal.app.thinkacademy.business.study.study.entity.Teacher) r4
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
            com.tal.app.thinkacademy.business.study.study.entity.Teacher r4 = (com.tal.app.thinkacademy.business.study.study.entity.Teacher) r4
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
            com.tal.app.thinkacademy.business.study.study.entity.Teacher r0 = (com.tal.app.thinkacademy.business.study.study.entity.Teacher) r0
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
            com.tal.app.thinkacademy.business.study.study.entity.Teacher r7 = (com.tal.app.thinkacademy.business.study.study.entity.Teacher) r7
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
            com.tal.app.thinkacademy.business.study.study.entity.Teacher r7 = (com.tal.app.thinkacademy.business.study.study.entity.Teacher) r7
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
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.study.study.adapter.ClassAdapter.showTeacherPhoto(java.util.List, com.chad.library.adapter.base.viewholder.BaseViewHolder):void");
    }

    private final void loadTeacherImage(String str, ImageView imageView) {
        if (imageView != null) {
            XesImageLoader.loadRoundCornerImage$default(XesImageLoader.INSTANCE, imageView, getContext(), str, SizeUtils.dp2px(6.0f), 0, R.drawable.shape_avatar_bg, (RoundedCornersTransformation.CornerType) null, 40, (Object) null);
        }
    }

    public int getItemViewType(int i) {
        return ((Record) getData().get(i)).getItemType();
    }
}
