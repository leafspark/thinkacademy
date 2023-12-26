package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.live.business.R;

public final class LiveBusinessLayoutRandowCallPhotoWallPadBinding implements ViewBinding {
    public final ConstraintLayout clRandomCallPhotoWall;
    public final ConstraintLayout clRandomCallPhotoWallSelect;
    public final ImageView ivBgRandomCallPhotoWall;
    public final ImageView ivBgRandomCallPhotoWallSelect;
    public final ImageView ivRandomCallPhotoWallTitle;
    public final ImageView ivRandomCallPhotoWallTitleSelect;
    public final ImageView ivStudentLevel;
    public final ImageView ivUserAvatarSelect;
    public final ConstraintLayout randomCallPhotoWallRootView;
    public final RelativeLayout rlLevel;
    public final RelativeLayout rlRandomCallPhotoWallSelectClose;
    public final RelativeLayout rlUserAvatarSelect;
    private final ConstraintLayout rootView;
    public final RecyclerView rvRandomCallPhotoWall;
    public final FrameLayout studentVideoContainerSelect;
    public final TextView tvSelectStudentLevel;
    public final TextView tvSelectStudentNickname;

    private LiveBusinessLayoutRandowCallPhotoWallPadBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, ConstraintLayout constraintLayout4, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, RecyclerView recyclerView, FrameLayout frameLayout, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.clRandomCallPhotoWall = constraintLayout2;
        this.clRandomCallPhotoWallSelect = constraintLayout3;
        this.ivBgRandomCallPhotoWall = imageView;
        this.ivBgRandomCallPhotoWallSelect = imageView2;
        this.ivRandomCallPhotoWallTitle = imageView3;
        this.ivRandomCallPhotoWallTitleSelect = imageView4;
        this.ivStudentLevel = imageView5;
        this.ivUserAvatarSelect = imageView6;
        this.randomCallPhotoWallRootView = constraintLayout4;
        this.rlLevel = relativeLayout;
        this.rlRandomCallPhotoWallSelectClose = relativeLayout2;
        this.rlUserAvatarSelect = relativeLayout3;
        this.rvRandomCallPhotoWall = recyclerView;
        this.studentVideoContainerSelect = frameLayout;
        this.tvSelectStudentLevel = textView;
        this.tvSelectStudentNickname = textView2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LiveBusinessLayoutRandowCallPhotoWallPadBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveBusinessLayoutRandowCallPhotoWallPadBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_business_layout_randow_call_photo_wall_pad;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x007f, code lost:
        r1 = com.tal.app.thinkacademy.live.business.R.id.rv_random_call_photo_wall;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000d, code lost:
        r1 = com.tal.app.thinkacademy.live.business.R.id.cl_random_call_photo_wall_select;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.live.business.databinding.LiveBusinessLayoutRandowCallPhotoWallPadBinding bind(android.view.View r21) {
        /*
            r0 = r21
            int r1 = com.tal.app.thinkacademy.live.business.R.id.cl_random_call_photo_wall
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            androidx.constraintlayout.widget.ConstraintLayout r5 = (androidx.constraintlayout.widget.ConstraintLayout) r5
            if (r5 == 0) goto L_0x00b7
            int r1 = com.tal.app.thinkacademy.live.business.R.id.cl_random_call_photo_wall_select
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r6 = r2
            androidx.constraintlayout.widget.ConstraintLayout r6 = (androidx.constraintlayout.widget.ConstraintLayout) r6
            if (r6 == 0) goto L_0x00b7
            int r1 = com.tal.app.thinkacademy.live.business.R.id.iv_bg_random_call_photo_wall
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r7 = r2
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            if (r7 == 0) goto L_0x00b7
            int r1 = com.tal.app.thinkacademy.live.business.R.id.iv_bg_random_call_photo_wall_select
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r8 = r2
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            if (r8 == 0) goto L_0x00b7
            int r1 = com.tal.app.thinkacademy.live.business.R.id.iv_random_call_photo_wall_title
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r9 = r2
            android.widget.ImageView r9 = (android.widget.ImageView) r9
            if (r9 == 0) goto L_0x00b7
            int r1 = com.tal.app.thinkacademy.live.business.R.id.iv_random_call_photo_wall_title_select
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r10 = r2
            android.widget.ImageView r10 = (android.widget.ImageView) r10
            if (r10 == 0) goto L_0x00b7
            int r1 = com.tal.app.thinkacademy.live.business.R.id.iv_student_level
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r11 = r2
            android.widget.ImageView r11 = (android.widget.ImageView) r11
            if (r11 == 0) goto L_0x00b7
            int r1 = com.tal.app.thinkacademy.live.business.R.id.iv_user_avatar_select
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r12 = r2
            android.widget.ImageView r12 = (android.widget.ImageView) r12
            if (r12 == 0) goto L_0x00b7
            r13 = r0
            androidx.constraintlayout.widget.ConstraintLayout r13 = (androidx.constraintlayout.widget.ConstraintLayout) r13
            int r1 = com.tal.app.thinkacademy.live.business.R.id.rl_level
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r14 = r2
            android.widget.RelativeLayout r14 = (android.widget.RelativeLayout) r14
            if (r14 == 0) goto L_0x00b7
            int r1 = com.tal.app.thinkacademy.live.business.R.id.rl_random_call_photo_wall_select_close
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r15 = r2
            android.widget.RelativeLayout r15 = (android.widget.RelativeLayout) r15
            if (r15 == 0) goto L_0x00b7
            int r1 = com.tal.app.thinkacademy.live.business.R.id.rl_user_avatar_select
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r16 = r2
            android.widget.RelativeLayout r16 = (android.widget.RelativeLayout) r16
            if (r16 == 0) goto L_0x00b7
            int r1 = com.tal.app.thinkacademy.live.business.R.id.rv_random_call_photo_wall
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r17 = r2
            androidx.recyclerview.widget.RecyclerView r17 = (androidx.recyclerview.widget.RecyclerView) r17
            if (r17 == 0) goto L_0x00b7
            int r1 = com.tal.app.thinkacademy.live.business.R.id.student_video_container_select
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r18 = r2
            android.widget.FrameLayout r18 = (android.widget.FrameLayout) r18
            if (r18 == 0) goto L_0x00b7
            int r1 = com.tal.app.thinkacademy.live.business.R.id.tv_select_student_level
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r19 = r2
            android.widget.TextView r19 = (android.widget.TextView) r19
            if (r19 == 0) goto L_0x00b7
            int r1 = com.tal.app.thinkacademy.live.business.R.id.tv_select_student_nickname
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r20 = r2
            android.widget.TextView r20 = (android.widget.TextView) r20
            if (r20 == 0) goto L_0x00b7
            com.tal.app.thinkacademy.live.business.databinding.LiveBusinessLayoutRandowCallPhotoWallPadBinding r0 = new com.tal.app.thinkacademy.live.business.databinding.LiveBusinessLayoutRandowCallPhotoWallPadBinding
            r3 = r0
            r4 = r13
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return r0
        L_0x00b7:
            android.content.res.Resources r0 = r21.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.databinding.LiveBusinessLayoutRandowCallPhotoWallPadBinding.bind(android.view.View):com.tal.app.thinkacademy.live.business.databinding.LiveBusinessLayoutRandowCallPhotoWallPadBinding");
    }
}
