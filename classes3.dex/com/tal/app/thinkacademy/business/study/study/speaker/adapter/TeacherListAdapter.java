package com.tal.app.thinkacademy.business.study.study.speaker.adapter;

import android.widget.ImageView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tal.app.thinkacademy.business.study.study.entity.Teacher;
import com.tal.app.thinkacademy.business.studycenter.R;
import com.tal.app.thinkacademy.lib.imageloader.XesImageLoader;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \u00142\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0014B\u0015\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0002H\u0014J\u0016\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011J\u0006\u0010\u0013\u001a\u00020\fR\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/speaker/adapter/TeacherListAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/tal/app/thinkacademy/business/study/study/entity/Teacher;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "listData", "", "(Ljava/util/List;)V", "mIsHasMaster", "", "mIsHasTutor", "mIsTutorHasContact", "convert", "", "holder", "item", "exposureTraceTeacher", "first", "", "last", "resetExposure", "Companion", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TeacherListAdapter.kt */
public final class TeacherListAdapter extends BaseQuickAdapter<Teacher, BaseViewHolder> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "老师联系方式";
    private static final String TUTOR_TYPE = "2";
    private boolean mIsHasMaster;
    private boolean mIsHasTutor;
    private boolean mIsTutorHasContact;

    public TeacherListAdapter(List<Teacher> list) {
        super(R.layout.item_plan_teacher_list, list);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/speaker/adapter/TeacherListAdapter$Companion;", "", "()V", "TAG", "", "TUTOR_TYPE", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: TeacherListAdapter.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final void resetExposure() {
        this.mIsHasTutor = false;
        this.mIsHasMaster = false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x002d A[Catch:{ Exception -> 0x0059 }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x005c A[LOOP:0: B:3:0x000c->B:25:0x005c, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x005e A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void exposureTraceTeacher(int r5, int r6) {
        /*
            r4 = this;
            java.util.List r0 = r4.getData()
            int r0 = r0.size()
            if (r0 <= r6) goto L_0x005e
            if (r5 > r6) goto L_0x005e
        L_0x000c:
            int r0 = r5 + 1
            java.util.List r1 = r4.getData()     // Catch:{ Exception -> 0x0059 }
            java.lang.Object r1 = r1.get(r5)     // Catch:{ Exception -> 0x0059 }
            com.tal.app.thinkacademy.business.study.study.entity.Teacher r1 = (com.tal.app.thinkacademy.business.study.study.entity.Teacher) r1     // Catch:{ Exception -> 0x0059 }
            java.util.List r2 = r1.getContactInfoListV2()     // Catch:{ Exception -> 0x0059 }
            java.util.Collection r2 = (java.util.Collection) r2     // Catch:{ Exception -> 0x0059 }
            r3 = 1
            if (r2 == 0) goto L_0x002a
            boolean r2 = r2.isEmpty()     // Catch:{ Exception -> 0x0059 }
            if (r2 == 0) goto L_0x0028
            goto L_0x002a
        L_0x0028:
            r2 = 0
            goto L_0x002b
        L_0x002a:
            r2 = r3
        L_0x002b:
            if (r2 != 0) goto L_0x0059
            java.lang.String r1 = r1.getIdentityType()     // Catch:{ Exception -> 0x0059 }
            java.lang.String r2 = "1"
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)     // Catch:{ Exception -> 0x0059 }
            if (r2 == 0) goto L_0x0045
            boolean r1 = r4.mIsHasMaster     // Catch:{ Exception -> 0x0059 }
            if (r1 != 0) goto L_0x0059
            r4.mIsHasMaster = r3     // Catch:{ Exception -> 0x0059 }
            com.tal.app.thinkacademy.business.study.study.StudyTrack r1 = com.tal.app.thinkacademy.business.study.study.StudyTrack.INSTANCE     // Catch:{ Exception -> 0x0059 }
            r1.hw_contact_teacher_icon_show(r3)     // Catch:{ Exception -> 0x0059 }
            goto L_0x0059
        L_0x0045:
            java.lang.String r2 = "2"
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)     // Catch:{ Exception -> 0x0059 }
            if (r1 == 0) goto L_0x0059
            boolean r1 = r4.mIsHasTutor     // Catch:{ Exception -> 0x0059 }
            if (r1 != 0) goto L_0x0059
            r4.mIsHasTutor = r3     // Catch:{ Exception -> 0x0059 }
            com.tal.app.thinkacademy.business.study.study.StudyTrack r1 = com.tal.app.thinkacademy.business.study.study.StudyTrack.INSTANCE     // Catch:{ Exception -> 0x0059 }
            r2 = 2
            r1.hw_contact_teacher_icon_show(r2)     // Catch:{ Exception -> 0x0059 }
        L_0x0059:
            if (r5 != r6) goto L_0x005c
            goto L_0x005e
        L_0x005c:
            r5 = r0
            goto L_0x000c
        L_0x005e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.study.study.speaker.adapter.TeacherListAdapter.exposureTraceTeacher(int, int):void");
    }

    /* access modifiers changed from: protected */
    public void convert(BaseViewHolder baseViewHolder, Teacher teacher) {
        int i;
        Intrinsics.checkNotNullParameter(baseViewHolder, "holder");
        Intrinsics.checkNotNullParameter(teacher, "item");
        baseViewHolder.setText(R.id.tvTeacherName, teacher.getName());
        baseViewHolder.setText(R.id.tvTeacherIdentity, teacher.getIdentityName());
        XesImageLoader.INSTANCE.loadCircleWithBorderImage((ImageView) baseViewHolder.getView(R.id.ivTeacherIcon), getContext(), teacher.getAvatar(), 1, getContext().getColor(R.color.color_e3e5e9), R.drawable.circle_user_default_image, false);
        Collection contactInfoListV2 = teacher.getContactInfoListV2();
        if (contactInfoListV2 == null || contactInfoListV2.isEmpty()) {
            baseViewHolder.setGone(R.id.ivTeacherInformation, true);
            return;
        }
        ImageView imageView = (ImageView) baseViewHolder.getView(R.id.ivTeacherInformation);
        if (teacher.getContactInfoListV2().size() > 1) {
            i = R.drawable.icon_contact;
        } else {
            String type = teacher.getContactInfoListV2().get(0).getType();
            if (type != null) {
                int hashCode = type.hashCode();
                if (hashCode != -792723642) {
                    if (hashCode != 3321844) {
                        if (hashCode == 1934750066 && type.equals("whatsApp")) {
                            i = R.drawable.icon_whatsapp_big;
                        }
                    } else if (type.equals("line")) {
                        i = R.drawable.icon_line_big;
                    }
                } else if (type.equals("weChat")) {
                    i = R.drawable.icon_wechat_big;
                }
            }
            i = -1;
        }
        imageView.setImageResource(i);
        baseViewHolder.setGone(R.id.ivTeacherInformation, false);
    }
}
