package com.tal.app.thinkacademy.business.study.study.speaker;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tal.app.thinkacademy.business.study.study.StudyTrack;
import com.tal.app.thinkacademy.business.study.study.entity.ContactInfo;
import com.tal.app.thinkacademy.business.study.study.entity.Teacher;
import com.tal.app.thinkacademy.business.study.study.speaker.adapter.ContactInformationAdapter;
import com.tal.app.thinkacademy.business.studycenter.R;
import com.tal.app.thinkacademy.business.studycenter.databinding.ActivityContactInformationBinding;
import com.tal.app.thinkacademy.common.base.BaseBindActivity;
import com.tal.app.thinkacademy.common.util.HwHummerUtil;
import com.tal.app.thinkacademy.lib.util.GsonUtil;
import com.tal.app.thinkacademy.lib.util.ParseUtils;
import com.tal.app.thinkacademy.lib.utils.XesStatusBar;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001bB\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0014J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u000bH\u0002J\u0012\u0010\u0018\u001a\u00020\u00152\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0014R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/speaker/ContactInformationActivity;", "Lcom/tal/app/thinkacademy/common/base/BaseBindActivity;", "Lcom/tal/app/thinkacademy/business/studycenter/databinding/ActivityContactInformationBinding;", "()V", "mAdapter", "Lcom/tal/app/thinkacademy/business/study/study/speaker/adapter/ContactInformationAdapter;", "mHeadView", "Landroid/view/View;", "mIvTeacherAvatar", "Landroid/widget/ImageView;", "mTeacherInfo", "Lcom/tal/app/thinkacademy/business/study/study/entity/Teacher;", "mTvTeacherIdentity", "Landroid/widget/TextView;", "mTvTeacherName", "createViewBinding", "group", "Landroid/view/ViewGroup;", "attach", "", "initData", "", "initHeadView", "teacher", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ContactInformationActivity.kt */
public final class ContactInformationActivity extends BaseBindActivity<ActivityContactInformationBinding> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private ContactInformationAdapter mAdapter;
    private View mHeadView;
    private ImageView mIvTeacherAvatar;
    private Teacher mTeacherInfo;
    private TextView mTvTeacherIdentity;
    private TextView mTvTeacherName;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b¨\u0006\t"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/speaker/ContactInformationActivity$Companion;", "", "()V", "startActivity", "", "context", "Landroid/content/Context;", "teacherInfo", "Lcom/tal/app/thinkacademy/business/study/study/entity/Teacher;", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ContactInformationActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void startActivity(Context context, Teacher teacher) {
            if (teacher != null) {
                if (HwHummerUtil.isHummerPageEnable()) {
                    HwHummerUtil.startHwHummerActivity("teacher_contact_info/teacher_contact_detail.js", GsonUtil.getInstance().objToJson(teacher));
                } else if (context != null) {
                    Intent intent = new Intent(context, ContactInformationActivity.class);
                    intent.putExtra(ClassParamsKt.TEACHER_INFO, teacher);
                    context.startActivity(intent);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public ActivityContactInformationBinding createViewBinding(ViewGroup viewGroup, boolean z) {
        Intrinsics.checkNotNullParameter(viewGroup, "group");
        ActivityContactInformationBinding inflate = ActivityContactInformationBinding.inflate(getLayoutInflater(), viewGroup, z);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater, group, attach)");
        return inflate;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        ContactInformationActivity.super.onCreate(bundle);
        XesStatusBar.INSTANCE.setStatusBar((Activity) this, true, getColor(R.color.color_ffffff), false);
        getBinding().tbContactInformation.setLineVisible(false);
        getBinding().tbContactInformation.setTitle(getString(R.string.contact_teacher));
        getBinding().tbContactInformation.setOnTitleBarListener(new ContactInformationActivity$onCreate$1(this));
        Intent intent = getIntent();
        if (intent != null) {
            this.mTeacherInfo = (Teacher) intent.getSerializableExtra(ClassParamsKt.TEACHER_INFO);
            initData();
        }
        StudyTrack studyTrack = StudyTrack.INSTANCE;
        Teacher teacher = this.mTeacherInfo;
        studyTrack.hw_contact_teacher_pv(ParseUtils.tryParseInt(teacher == null ? null : teacher.getIdentityType(), 1));
    }

    private final void initData() {
        Teacher teacher = this.mTeacherInfo;
        if (teacher != null) {
            List<ContactInfo> contactInfoListV2 = teacher.getContactInfoListV2();
            Objects.requireNonNull(contactInfoListV2, "null cannot be cast to non-null type kotlin.collections.MutableList<com.tal.app.thinkacademy.business.study.study.entity.ContactInfo>");
            this.mAdapter = new ContactInformationAdapter(TypeIntrinsics.asMutableList(contactInfoListV2), new ContactInformationActivity$initData$1$1(this));
            getBinding().recyclerView.setAdapter(this.mAdapter);
            initHeadView(teacher);
        }
    }

    /* JADX WARNING: type inference failed for: r0v9, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void initHeadView(com.tal.app.thinkacademy.business.study.study.entity.Teacher r11) {
        /*
            r10 = this;
            android.view.LayoutInflater r0 = r10.getLayoutInflater()
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.layout.activity_contact_information_head
            androidx.viewbinding.ViewBinding r2 = r10.getBinding()
            com.tal.app.thinkacademy.business.studycenter.databinding.ActivityContactInformationBinding r2 = (com.tal.app.thinkacademy.business.studycenter.databinding.ActivityContactInformationBinding) r2
            androidx.recyclerview.widget.RecyclerView r2 = r2.recyclerView
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2
            boolean r3 = r0 instanceof android.view.LayoutInflater
            r4 = 0
            if (r3 != 0) goto L_0x001a
            android.view.View r0 = r0.inflate(r1, r2, r4)
            goto L_0x0020
        L_0x001a:
            android.view.LayoutInflater r0 = (android.view.LayoutInflater) r0
            android.view.View r0 = com.bonree.sdk.agent.engine.external.XMLParseInstrumentation.inflate(r0, r1, r2, r4)
        L_0x0020:
            r10.mHeadView = r0
            r1 = 0
            if (r0 != 0) goto L_0x0027
            r0 = r1
            goto L_0x002f
        L_0x0027:
            int r2 = com.tal.app.thinkacademy.business.studycenter.R.id.ivTeacherAvatar
            android.view.View r0 = r0.findViewById(r2)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
        L_0x002f:
            r10.mIvTeacherAvatar = r0
            android.view.View r0 = r10.mHeadView
            if (r0 != 0) goto L_0x0037
            r0 = r1
            goto L_0x003f
        L_0x0037:
            int r2 = com.tal.app.thinkacademy.business.studycenter.R.id.tvTeacherName
            android.view.View r0 = r0.findViewById(r2)
            android.widget.TextView r0 = (android.widget.TextView) r0
        L_0x003f:
            r10.mTvTeacherName = r0
            android.view.View r0 = r10.mHeadView
            if (r0 != 0) goto L_0x0046
            goto L_0x004f
        L_0x0046:
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.tvTeacherIdentity
            android.view.View r0 = r0.findViewById(r1)
            r1 = r0
            android.widget.TextView r1 = (android.widget.TextView) r1
        L_0x004f:
            r10.mTvTeacherIdentity = r1
            android.widget.ImageView r3 = r10.mIvTeacherAvatar
            if (r3 != 0) goto L_0x0056
            goto L_0x006c
        L_0x0056:
            com.tal.app.thinkacademy.lib.imageloader.XesImageLoader r2 = com.tal.app.thinkacademy.lib.imageloader.XesImageLoader.INSTANCE
            r4 = r10
            android.content.Context r4 = (android.content.Context) r4
            java.lang.String r5 = r11.getAvatar()
            r6 = 1
            int r0 = com.tal.app.thinkacademy.business.studycenter.R.color.color_e3e5e9
            int r7 = r10.getColor(r0)
            int r8 = com.tal.app.thinkacademy.business.studycenter.R.drawable.circle_user_default_image
            r9 = 0
            r2.loadCircleWithBorderImage(r3, r4, r5, r6, r7, r8, r9)
        L_0x006c:
            android.widget.TextView r0 = r10.mTvTeacherName
            if (r0 != 0) goto L_0x0071
            goto L_0x007a
        L_0x0071:
            java.lang.String r1 = r11.getName()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
        L_0x007a:
            android.widget.TextView r0 = r10.mTvTeacherIdentity
            if (r0 != 0) goto L_0x007f
            goto L_0x0088
        L_0x007f:
            java.lang.String r11 = r11.getIdentityName()
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            r0.setText(r11)
        L_0x0088:
            android.view.View r2 = r10.mHeadView
            if (r2 != 0) goto L_0x008d
            goto L_0x009c
        L_0x008d:
            com.tal.app.thinkacademy.business.study.study.speaker.adapter.ContactInformationAdapter r11 = r10.mAdapter
            if (r11 != 0) goto L_0x0092
            goto L_0x009c
        L_0x0092:
            r1 = r11
            com.chad.library.adapter.base.BaseQuickAdapter r1 = (com.chad.library.adapter.base.BaseQuickAdapter) r1
            r3 = 0
            r4 = 0
            r5 = 6
            r6 = 0
            com.chad.library.adapter.base.BaseQuickAdapter.addHeaderView$default(r1, r2, r3, r4, r5, r6)
        L_0x009c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.study.study.speaker.ContactInformationActivity.initHeadView(com.tal.app.thinkacademy.business.study.study.entity.Teacher):void");
    }
}
