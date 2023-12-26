package com.tal.app.thinkacademy.live.business.studentvideo;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.tal.app.thinkacademy.lib.imageloader.ImageLoaderJ;
import com.tal.app.thinkacademy.lib.utils.RxUnDoubleUtil;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.studentvideo.bean.StudentVideoBean;
import com.tal.app.thinkacademy.live.business.studentvideo.driver.StudentVideoPluginDriver;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B%\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ$\u0010U\u001a\u00020V2\b\u0010W\u001a\u0004\u0018\u00010X2\u0006\u0010Y\u001a\u00020\b2\b\u0010Z\u001a\u0004\u0018\u00010\u000bH\u0016J\u001a\u0010[\u001a\u00020V2\b\u0010W\u001a\u0004\u0018\u00010X2\u0006\u0010\\\u001a\u00020\u0012H\u0002J\b\u0010]\u001a\u00020\bH\u0016J\b\u0010^\u001a\u00020VH\u0016J\b\u0010_\u001a\u00020VH\u0016J\u0010\u0010`\u001a\u00020V2\u0006\u0010a\u001a\u00020\u0019H\u0016J\u0010\u0010b\u001a\u00020V2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0016\u0010c\u001a\u00020V2\f\u0010d\u001a\b\u0012\u0004\u0012\u00020\u000b0<H\u0016J\u0010\u0010e\u001a\u00020V2\u0006\u0010a\u001a\u00020\u0019H\u0016R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u000103X\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u000103X\u000e¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u000103X\u000e¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u000103X\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u000103X\u000e¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0004\u0018\u000103X\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010;\u001a\b\u0012\u0004\u0012\u00020\u000b0<X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010=\u001a\u0004\u0018\u00010>X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010?\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010@\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010A\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010B\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010C\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010D\u001a\u0004\u0018\u00010>X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010E\u001a\u0004\u0018\u00010>X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010F\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010G\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010H\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010I\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010J\u001a\u0004\u0018\u00010>X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010K\u001a\u0004\u0018\u00010>X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010L\u001a\u0004\u0018\u00010>X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010M\u001a\u0004\u0018\u00010NX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010O\u001a\u0004\u0018\u00010NX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010P\u001a\u0004\u0018\u00010NX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010Q\u001a\u0004\u0018\u00010NX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010R\u001a\u0004\u0018\u00010NX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010S\u001a\u0004\u0018\u00010NX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010T\u001a\u0004\u0018\u00010NX\u000e¢\u0006\u0002\n\u0000¨\u0006f"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/studentvideo/StudentVideoPluginViewPadSmallClassView;", "Lcom/tal/app/thinkacademy/live/business/studentvideo/AbstractStudentVideoPluginView;", "Lcom/tal/app/thinkacademy/live/business/studentvideo/driver/StudentVideoPluginDriver;", "cxt", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bean1", "Lcom/tal/app/thinkacademy/live/business/studentvideo/bean/StudentVideoBean$ListBean;", "bean2", "bean3", "bean4", "bean5", "bean6", "fl_live_business_student_1", "Landroid/widget/RelativeLayout;", "fl_live_business_student_2", "fl_live_business_student_3", "fl_live_business_student_4", "fl_live_business_student_5", "fl_live_business_student_6", "isCollectiveSpeech", "", "ivLeftPage", "Landroid/widget/ImageView;", "ivRightPage", "iv_live_business_camera_1", "iv_live_business_head1", "iv_live_business_head2", "iv_live_business_head3", "iv_live_business_head4", "iv_live_business_head5", "iv_live_business_head6", "iv_live_business_mic_1", "iv_live_business_my_level1", "iv_live_business_my_level2", "iv_live_business_my_level3", "iv_live_business_my_level4", "iv_live_business_my_level5", "iv_live_business_my_level6", "iv_live_business_video_2", "iv_live_business_video_3", "iv_live_business_video_4", "iv_live_business_video_5", "iv_live_business_video_6", "levelIcons", "", "liv_live_business_video_voice_1", "Lcom/airbnb/lottie/LottieAnimationView;", "liv_live_business_video_voice_2", "liv_live_business_video_voice_3", "liv_live_business_video_voice_4", "liv_live_business_video_voice_5", "liv_live_business_video_voice_6", "mCurrentPage", "mMaxPage", "mSmallClassVideoList", "", "rl_live_business_head_parent1", "Landroid/view/View;", "rl_live_business_head_parent2", "rl_live_business_head_parent3", "rl_live_business_head_parent4", "rl_live_business_head_parent5", "rl_live_business_head_parent6", "rl_live_business_student_1", "rl_live_business_student_2", "rl_live_business_student_3", "rl_live_business_student_4", "rl_live_business_student_5", "rl_live_business_student_6", "rl_live_business_student_empty", "rl_live_business_student_normal", "rl_live_business_student_root", "tvVideoPage", "Landroid/widget/TextView;", "tv_live_business_name_1", "tv_live_business_name_2", "tv_live_business_name_3", "tv_live_business_name_4", "tv_live_business_name_5", "tv_live_business_name_6", "addRenderView", "", "surfaceView", "Landroid/view/SurfaceView;", "index", "bean", "addSurfaceView", "layout", "getLayoutId", "initViews", "onDestroy", "rootViewIsShow", "isShow", "setCollectiveSpeech", "updateSmallClassVideoList", "list", "videoChatToggle", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: StudentVideoPluginViewPadSmallClassView.kt */
public final class StudentVideoPluginViewPadSmallClassView extends AbstractStudentVideoPluginView<StudentVideoPluginDriver> {
    /* access modifiers changed from: private */
    public StudentVideoBean.ListBean bean1;
    /* access modifiers changed from: private */
    public StudentVideoBean.ListBean bean2;
    /* access modifiers changed from: private */
    public StudentVideoBean.ListBean bean3;
    /* access modifiers changed from: private */
    public StudentVideoBean.ListBean bean4;
    /* access modifiers changed from: private */
    public StudentVideoBean.ListBean bean5;
    /* access modifiers changed from: private */
    public StudentVideoBean.ListBean bean6;
    private RelativeLayout fl_live_business_student_1;
    private RelativeLayout fl_live_business_student_2;
    private RelativeLayout fl_live_business_student_3;
    private RelativeLayout fl_live_business_student_4;
    private RelativeLayout fl_live_business_student_5;
    private RelativeLayout fl_live_business_student_6;
    private boolean isCollectiveSpeech;
    private ImageView ivLeftPage;
    private ImageView ivRightPage;
    private ImageView iv_live_business_camera_1;
    private ImageView iv_live_business_head1;
    private ImageView iv_live_business_head2;
    private ImageView iv_live_business_head3;
    private ImageView iv_live_business_head4;
    private ImageView iv_live_business_head5;
    private ImageView iv_live_business_head6;
    /* access modifiers changed from: private */
    public ImageView iv_live_business_mic_1;
    private ImageView iv_live_business_my_level1;
    private ImageView iv_live_business_my_level2;
    private ImageView iv_live_business_my_level3;
    private ImageView iv_live_business_my_level4;
    private ImageView iv_live_business_my_level5;
    private ImageView iv_live_business_my_level6;
    private ImageView iv_live_business_video_2;
    private ImageView iv_live_business_video_3;
    private ImageView iv_live_business_video_4;
    private ImageView iv_live_business_video_5;
    private ImageView iv_live_business_video_6;
    private int[] levelIcons;
    private LottieAnimationView liv_live_business_video_voice_1;
    private LottieAnimationView liv_live_business_video_voice_2;
    private LottieAnimationView liv_live_business_video_voice_3;
    private LottieAnimationView liv_live_business_video_voice_4;
    private LottieAnimationView liv_live_business_video_voice_5;
    private LottieAnimationView liv_live_business_video_voice_6;
    /* access modifiers changed from: private */
    public volatile int mCurrentPage;
    /* access modifiers changed from: private */
    public volatile int mMaxPage;
    private volatile List<? extends StudentVideoBean.ListBean> mSmallClassVideoList;
    private View rl_live_business_head_parent1;
    private RelativeLayout rl_live_business_head_parent2;
    private RelativeLayout rl_live_business_head_parent3;
    private RelativeLayout rl_live_business_head_parent4;
    private RelativeLayout rl_live_business_head_parent5;
    private RelativeLayout rl_live_business_head_parent6;
    private View rl_live_business_student_1;
    private View rl_live_business_student_2;
    private RelativeLayout rl_live_business_student_3;
    private RelativeLayout rl_live_business_student_4;
    private RelativeLayout rl_live_business_student_5;
    private RelativeLayout rl_live_business_student_6;
    private View rl_live_business_student_empty;
    private View rl_live_business_student_normal;
    private View rl_live_business_student_root;
    /* access modifiers changed from: private */
    public TextView tvVideoPage;
    private TextView tv_live_business_name_1;
    private TextView tv_live_business_name_2;
    private TextView tv_live_business_name_3;
    private TextView tv_live_business_name_4;
    private TextView tv_live_business_name_5;
    private TextView tv_live_business_name_6;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public StudentVideoPluginViewPadSmallClassView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "cxt");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public StudentVideoPluginViewPadSmallClassView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "cxt");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StudentVideoPluginViewPadSmallClassView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "cxt");
        this.mSmallClassVideoList = new ArrayList();
        this.mMaxPage = 1;
        this.mCurrentPage = 1;
        this.levelIcons = new int[]{R.drawable.icon_level1_iron_small, R.drawable.icon_level2_bronze_small, R.drawable.icon_level3_sliver_small, R.drawable.icon_level4_gold_small, R.drawable.icon_level5_platinum_small, R.drawable.icon_level6_diamond_small, R.drawable.icon_level7_crown_small};
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ StudentVideoPluginViewPadSmallClassView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public int getLayoutId() {
        return R.layout.live_business_studentvideo_small_class;
    }

    public void initViews() {
        super.initViews();
        this.ivLeftPage = (ImageView) findViewById(R.id.ivLeftPage);
        this.tvVideoPage = (TextView) findViewById(R.id.tvVideoPage);
        this.ivRightPage = (ImageView) findViewById(R.id.ivRightPage);
        this.iv_live_business_camera_1 = (ImageView) findViewById(R.id.iv_live_business_camera_1);
        this.iv_live_business_video_2 = (ImageView) findViewById(R.id.iv_live_business_video_2);
        this.iv_live_business_video_3 = (ImageView) findViewById(R.id.iv_live_business_video_3);
        this.iv_live_business_video_4 = (ImageView) findViewById(R.id.iv_live_business_video_4);
        this.iv_live_business_video_5 = (ImageView) findViewById(R.id.iv_live_business_video_5);
        this.iv_live_business_video_6 = (ImageView) findViewById(R.id.iv_live_business_video_6);
        this.iv_live_business_mic_1 = (ImageView) findViewById(R.id.iv_live_business_mic_1);
        this.rl_live_business_student_1 = findViewById(R.id.rl_live_business_student_1);
        this.tv_live_business_name_1 = (TextView) findViewById(R.id.tv_live_business_name_1);
        this.iv_live_business_head1 = (ImageView) findViewById(R.id.iv_live_business_head1);
        this.rl_live_business_head_parent1 = findViewById(R.id.rl_live_business_head_parent1);
        this.fl_live_business_student_1 = (RelativeLayout) findViewById(R.id.fl_live_business_student_1);
        this.liv_live_business_video_voice_1 = findViewById(R.id.liv_live_business_video_voice_1);
        this.liv_live_business_video_voice_2 = findViewById(R.id.liv_live_business_video_voice_2);
        this.liv_live_business_video_voice_3 = findViewById(R.id.liv_live_business_video_voice_3);
        this.liv_live_business_video_voice_4 = findViewById(R.id.liv_live_business_video_voice_4);
        this.liv_live_business_video_voice_5 = findViewById(R.id.liv_live_business_video_voice_5);
        this.liv_live_business_video_voice_6 = findViewById(R.id.liv_live_business_video_voice_6);
        this.iv_live_business_my_level1 = (ImageView) findViewById(R.id.iv_live_business_my_level1);
        this.rl_live_business_student_2 = findViewById(R.id.rl_live_business_student_2);
        this.tv_live_business_name_2 = (TextView) findViewById(R.id.tv_live_business_name_2);
        this.iv_live_business_head2 = (ImageView) findViewById(R.id.iv_live_business_head2);
        this.rl_live_business_head_parent2 = (RelativeLayout) findViewById(R.id.rl_live_business_head_parent2);
        this.fl_live_business_student_2 = (RelativeLayout) findViewById(R.id.fl_live_business_student_2);
        this.iv_live_business_my_level2 = (ImageView) findViewById(R.id.iv_live_business_my_level2);
        this.rl_live_business_student_3 = (RelativeLayout) findViewById(R.id.rl_live_business_student_3);
        this.tv_live_business_name_3 = (TextView) findViewById(R.id.tv_live_business_name_3);
        this.iv_live_business_head3 = (ImageView) findViewById(R.id.iv_live_business_head3);
        this.rl_live_business_head_parent3 = (RelativeLayout) findViewById(R.id.rl_live_business_head_parent3);
        this.iv_live_business_my_level3 = (ImageView) findViewById(R.id.iv_live_business_my_level3);
        this.fl_live_business_student_3 = (RelativeLayout) findViewById(R.id.fl_live_business_student_3);
        this.rl_live_business_student_4 = (RelativeLayout) findViewById(R.id.rl_live_business_student_4);
        this.tv_live_business_name_4 = (TextView) findViewById(R.id.tv_live_business_name_4);
        this.iv_live_business_head4 = (ImageView) findViewById(R.id.iv_live_business_head4);
        this.rl_live_business_head_parent4 = (RelativeLayout) findViewById(R.id.rl_live_business_head_parent4);
        this.fl_live_business_student_4 = (RelativeLayout) findViewById(R.id.fl_live_business_student_4);
        this.iv_live_business_my_level4 = (ImageView) findViewById(R.id.iv_live_business_my_level4);
        this.rl_live_business_student_5 = (RelativeLayout) findViewById(R.id.rl_live_business_student_5);
        this.tv_live_business_name_5 = (TextView) findViewById(R.id.tv_live_business_name_5);
        this.tv_live_business_name_6 = (TextView) findViewById(R.id.tv_live_business_name_6);
        this.iv_live_business_head5 = (ImageView) findViewById(R.id.iv_live_business_head5);
        this.iv_live_business_head6 = (ImageView) findViewById(R.id.iv_live_business_head6);
        this.rl_live_business_head_parent5 = (RelativeLayout) findViewById(R.id.rl_live_business_head_parent5);
        this.rl_live_business_head_parent6 = (RelativeLayout) findViewById(R.id.rl_live_business_head_parent6);
        this.fl_live_business_student_5 = (RelativeLayout) findViewById(R.id.fl_live_business_student_5);
        this.fl_live_business_student_6 = (RelativeLayout) findViewById(R.id.fl_live_business_student_6);
        this.iv_live_business_my_level5 = (ImageView) findViewById(R.id.iv_live_business_my_level5);
        this.iv_live_business_my_level6 = (ImageView) findViewById(R.id.iv_live_business_my_level6);
        this.rl_live_business_student_6 = (RelativeLayout) findViewById(R.id.rl_live_business_student_6);
        this.rl_live_business_student_root = findViewById(R.id.rl_live_business_student_root);
        this.rl_live_business_student_normal = findViewById(R.id.rl_live_business_student_normal);
        this.rl_live_business_student_empty = findViewById(R.id.rl_live_business_student_empty);
        ImageView imageView = this.ivLeftPage;
        if (imageView != null) {
            RxUnDoubleUtil.INSTANCE.setOnUnDoubleClickListener(imageView, 300, new StudentVideoPluginViewPadSmallClassView$initViews$1(this));
        }
        ImageView imageView2 = this.ivRightPage;
        if (imageView2 != null) {
            RxUnDoubleUtil.INSTANCE.setOnUnDoubleClickListener(imageView2, 300, new StudentVideoPluginViewPadSmallClassView$initViews$2(this));
        }
        ImageView imageView3 = this.iv_live_business_camera_1;
        if (imageView3 != null) {
            RxUnDoubleUtil.INSTANCE.setOnUnDoubleClickListener(imageView3, 100, new StudentVideoPluginViewPadSmallClassView$initViews$3(this));
        }
        ImageView imageView4 = this.iv_live_business_video_2;
        if (imageView4 != null) {
            RxUnDoubleUtil.INSTANCE.setOnUnDoubleClickListener(imageView4, 100, new StudentVideoPluginViewPadSmallClassView$initViews$4(this));
        }
        ImageView imageView5 = this.iv_live_business_video_3;
        if (imageView5 != null) {
            RxUnDoubleUtil.INSTANCE.setOnUnDoubleClickListener(imageView5, 100, new StudentVideoPluginViewPadSmallClassView$initViews$5(this));
        }
        ImageView imageView6 = this.iv_live_business_video_4;
        if (imageView6 != null) {
            RxUnDoubleUtil.INSTANCE.setOnUnDoubleClickListener(imageView6, 100, new StudentVideoPluginViewPadSmallClassView$initViews$6(this));
        }
        ImageView imageView7 = this.iv_live_business_video_5;
        if (imageView7 != null) {
            RxUnDoubleUtil.INSTANCE.setOnUnDoubleClickListener(imageView7, 100, new StudentVideoPluginViewPadSmallClassView$initViews$7(this));
        }
        ImageView imageView8 = this.iv_live_business_video_6;
        if (imageView8 != null) {
            RxUnDoubleUtil.INSTANCE.setOnUnDoubleClickListener(imageView8, 100, new StudentVideoPluginViewPadSmallClassView$initViews$8(this));
        }
        ImageView imageView9 = this.iv_live_business_mic_1;
        if (imageView9 != null) {
            RxUnDoubleUtil.INSTANCE.setOnUnDoubleClickListener(imageView9, 100, new StudentVideoPluginViewPadSmallClassView$initViews$9(this));
        }
    }

    public synchronized void updateSmallClassVideoList(List<? extends StudentVideoBean.ListBean> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        super.updateSmallClassVideoList(list);
        this.mSmallClassVideoList = list;
        this.mMaxPage = (int) Math.ceil(((double) this.mSmallClassVideoList.size()) / ((double) 6));
        if (this.mCurrentPage > this.mMaxPage) {
            this.mCurrentPage = this.mMaxPage;
        }
        StudentVideoPluginDriver studentVideoPluginDriver = (StudentVideoPluginDriver) this.driver;
        if (studentVideoPluginDriver != null) {
            studentVideoPluginDriver.updatesetCurrentPage(this.mCurrentPage, this.mMaxPage);
        }
        Context context = getContext();
        if (context != null) {
            ((Activity) context).runOnUiThread(new StudentVideoPluginViewPadSmallClassView$$ExternalSyntheticLambda1(this));
        } else {
            throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: updateSmallClassVideoList$lambda-0  reason: not valid java name */
    public static final void m442updateSmallClassVideoList$lambda0(StudentVideoPluginViewPadSmallClassView studentVideoPluginViewPadSmallClassView) {
        Intrinsics.checkNotNullParameter(studentVideoPluginViewPadSmallClassView, "this$0");
        TextView textView = studentVideoPluginViewPadSmallClassView.tvVideoPage;
        if (textView != null) {
            textView.setText(studentVideoPluginViewPadSmallClassView.mCurrentPage + " / " + studentVideoPluginViewPadSmallClassView.mMaxPage);
        }
    }

    public synchronized void addRenderView(SurfaceView surfaceView, int i, StudentVideoBean.ListBean listBean) {
        super.addRenderView(surfaceView, i, listBean);
        Context context = getContext();
        if (context != null) {
            ((Activity) context).runOnUiThread(new StudentVideoPluginViewPadSmallClassView$$ExternalSyntheticLambda0(i, this, listBean, surfaceView));
        } else {
            throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: addRenderView$lambda-7  reason: not valid java name */
    public static final void m441addRenderView$lambda7(int i, StudentVideoPluginViewPadSmallClassView studentVideoPluginViewPadSmallClassView, StudentVideoBean.ListBean listBean, SurfaceView surfaceView) {
        int i2;
        int i3;
        RelativeLayout relativeLayout;
        int i4;
        RelativeLayout relativeLayout2;
        int i5;
        RelativeLayout relativeLayout3;
        int i6;
        RelativeLayout relativeLayout4;
        int i7;
        RelativeLayout relativeLayout5;
        Intrinsics.checkNotNullParameter(studentVideoPluginViewPadSmallClassView, "this$0");
        boolean z = true;
        if (i == 0) {
            studentVideoPluginViewPadSmallClassView.bean1 = listBean;
            if (listBean == null) {
                View view = studentVideoPluginViewPadSmallClassView.rl_live_business_student_1;
                if (view != null) {
                    view.setVisibility(4);
                    return;
                }
                return;
            }
            View view2 = studentVideoPluginViewPadSmallClassView.rl_live_business_student_1;
            if (view2 != null) {
                view2.setVisibility(0);
            }
            TextView textView = studentVideoPluginViewPadSmallClassView.tv_live_business_name_1;
            if (textView != null) {
                textView.setText(listBean.getNickName());
            }
            ImageLoaderJ.loadCircle(studentVideoPluginViewPadSmallClassView.getContext(), listBean.getAvatar(), studentVideoPluginViewPadSmallClassView.iv_live_business_head1, R.drawable.common_self_image_user);
            View view3 = studentVideoPluginViewPadSmallClassView.rl_live_business_head_parent1;
            if (view3 != null) {
                if (listBean.getCameraPerm() == 1) {
                    long userId = listBean.getUserId();
                    Long l = studentVideoPluginViewPadSmallClassView.mUid;
                    if (l != null && userId == l.longValue() ? !listBean.isDisableTheVideo() && !listBean.isMyselfShowHeadBg() : !listBean.isDisableTheVideo() && !listBean.isOtherShowHeadBg()) {
                        i2 = 8;
                        view3.setVisibility(i2);
                    }
                }
                i2 = 0;
                view3.setVisibility(i2);
            }
            if (listBean.getCameraPerm() == 1) {
                RelativeLayout relativeLayout6 = studentVideoPluginViewPadSmallClassView.fl_live_business_student_1;
                if (relativeLayout6 != null) {
                    studentVideoPluginViewPadSmallClassView.addSurfaceView(surfaceView, relativeLayout6);
                    Unit unit = Unit.INSTANCE;
                    Unit unit2 = Unit.INSTANCE;
                }
                long userId2 = listBean.getUserId();
                Long l2 = studentVideoPluginViewPadSmallClassView.mUid;
                if (l2 != null && userId2 == l2.longValue()) {
                    ImageView imageView = studentVideoPluginViewPadSmallClassView.iv_live_business_camera_1;
                    if (imageView != null) {
                        imageView.setVisibility(listBean.isDisableTheVideo() ? 8 : 0);
                    }
                    ImageView imageView2 = studentVideoPluginViewPadSmallClassView.iv_live_business_camera_1;
                    if (imageView2 != null) {
                        imageView2.setImageResource(listBean.isMySelfOff() ? R.drawable.live_business_icon_camera_turnoff : R.drawable.live_business_icon_camera_turnon);
                        Unit unit3 = Unit.INSTANCE;
                    }
                } else {
                    ImageView imageView3 = studentVideoPluginViewPadSmallClassView.iv_live_business_camera_1;
                    if (imageView3 != null) {
                        imageView3.setVisibility(listBean.isDisableTheVideo() ? 8 : 0);
                    }
                    ImageView imageView4 = studentVideoPluginViewPadSmallClassView.iv_live_business_camera_1;
                    if (imageView4 != null) {
                        imageView4.setImageResource(listBean.isHerselfOff() ? R.drawable.live_business_icon_video_turnoff : R.drawable.live_business_icon_video_turnon);
                        Unit unit4 = Unit.INSTANCE;
                    }
                }
            } else {
                long userId3 = listBean.getUserId();
                Long l3 = studentVideoPluginViewPadSmallClassView.mUid;
                if (l3 != null && userId3 == l3.longValue()) {
                    ImageView imageView5 = studentVideoPluginViewPadSmallClassView.iv_live_business_camera_1;
                    if (imageView5 != null) {
                        imageView5.setVisibility(listBean.isDisableTheVideo() ? 8 : 0);
                    }
                    ImageView imageView6 = studentVideoPluginViewPadSmallClassView.iv_live_business_camera_1;
                    if (imageView6 != null) {
                        imageView6.setImageResource(R.drawable.live_business_icon_camera_turnoff);
                        Unit unit5 = Unit.INSTANCE;
                    }
                } else {
                    ImageView imageView7 = studentVideoPluginViewPadSmallClassView.iv_live_business_camera_1;
                    if (imageView7 != null) {
                        listBean.isDisableTheVideo();
                        imageView7.setVisibility(8);
                    }
                    ImageView imageView8 = studentVideoPluginViewPadSmallClassView.iv_live_business_camera_1;
                    if (imageView8 != null) {
                        imageView8.setImageResource(R.drawable.live_business_icon_video_turnoff);
                        Unit unit6 = Unit.INSTANCE;
                    }
                }
            }
            long userId4 = listBean.getUserId();
            Long l4 = studentVideoPluginViewPadSmallClassView.mUid;
            if (l4 != null && userId4 == l4.longValue()) {
                LottieAnimationView lottieAnimationView = studentVideoPluginViewPadSmallClassView.liv_live_business_video_voice_1;
                if (lottieAnimationView != null) {
                    lottieAnimationView.setVisibility(8);
                }
                LottieAnimationView lottieAnimationView2 = studentVideoPluginViewPadSmallClassView.liv_live_business_video_voice_1;
                if (lottieAnimationView2 != null) {
                    lottieAnimationView2.cancelAnimation();
                    Unit unit7 = Unit.INSTANCE;
                }
                if (listBean.getLevel() == 0) {
                    ImageView imageView9 = studentVideoPluginViewPadSmallClassView.iv_live_business_my_level1;
                    if (imageView9 != null) {
                        imageView9.setVisibility(8);
                    }
                } else {
                    ImageView imageView10 = studentVideoPluginViewPadSmallClassView.iv_live_business_my_level1;
                    if (imageView10 != null) {
                        imageView10.setImageResource(studentVideoPluginViewPadSmallClassView.levelIcons[listBean.getLevel() - 1]);
                        Unit unit8 = Unit.INSTANCE;
                    }
                    ImageView imageView11 = studentVideoPluginViewPadSmallClassView.iv_live_business_my_level1;
                    if (imageView11 != null) {
                        imageView11.setVisibility(0);
                    }
                }
            } else if (studentVideoPluginViewPadSmallClassView.isCollectiveSpeech) {
                LottieAnimationView lottieAnimationView3 = studentVideoPluginViewPadSmallClassView.liv_live_business_video_voice_1;
                if (lottieAnimationView3 != null) {
                    lottieAnimationView3.setVisibility(0);
                }
                LottieAnimationView lottieAnimationView4 = studentVideoPluginViewPadSmallClassView.liv_live_business_video_voice_1;
                if (lottieAnimationView4 != null) {
                    lottieAnimationView4.playAnimation();
                    Unit unit9 = Unit.INSTANCE;
                }
                ImageView imageView12 = studentVideoPluginViewPadSmallClassView.iv_live_business_my_level1;
                if (imageView12 != null) {
                    imageView12.setVisibility(8);
                }
            } else {
                LottieAnimationView lottieAnimationView5 = studentVideoPluginViewPadSmallClassView.liv_live_business_video_voice_1;
                if (lottieAnimationView5 != null) {
                    lottieAnimationView5.setVisibility(8);
                }
                LottieAnimationView lottieAnimationView6 = studentVideoPluginViewPadSmallClassView.liv_live_business_video_voice_1;
                if (lottieAnimationView6 != null) {
                    lottieAnimationView6.cancelAnimation();
                    Unit unit10 = Unit.INSTANCE;
                }
                if (listBean.getLevel() == 0) {
                    ImageView imageView13 = studentVideoPluginViewPadSmallClassView.iv_live_business_my_level1;
                    if (imageView13 != null) {
                        imageView13.setVisibility(8);
                    }
                } else {
                    ImageView imageView14 = studentVideoPluginViewPadSmallClassView.iv_live_business_my_level1;
                    if (imageView14 != null) {
                        imageView14.setImageResource(studentVideoPluginViewPadSmallClassView.levelIcons[listBean.getLevel() - 1]);
                        Unit unit11 = Unit.INSTANCE;
                    }
                    ImageView imageView15 = studentVideoPluginViewPadSmallClassView.iv_live_business_my_level1;
                    if (imageView15 != null) {
                        imageView15.setVisibility(0);
                    }
                }
            }
            if (Intrinsics.areEqual(studentVideoPluginViewPadSmallClassView.classType, "2")) {
                long userId5 = listBean.getUserId();
                Long l5 = studentVideoPluginViewPadSmallClassView.mUid;
                if (l5 != null && userId5 == l5.longValue()) {
                    StudentVideoPluginDriver studentVideoPluginDriver = (StudentVideoPluginDriver) studentVideoPluginViewPadSmallClassView.driver;
                    if (studentVideoPluginDriver == null || !studentVideoPluginDriver.isHasMicPermission()) {
                        z = false;
                    }
                    if (!z || !listBean.isOpenMic()) {
                        ImageView imageView16 = studentVideoPluginViewPadSmallClassView.iv_live_business_mic_1;
                        if (imageView16 != null) {
                            imageView16.setImageResource(R.drawable.live_business_icon_mic_turnoff);
                            Unit unit12 = Unit.INSTANCE;
                        }
                    } else {
                        ImageView imageView17 = studentVideoPluginViewPadSmallClassView.iv_live_business_mic_1;
                        if (imageView17 != null) {
                            imageView17.setImageResource(R.drawable.live_business_icon_mic_turnon);
                            Unit unit13 = Unit.INSTANCE;
                        }
                    }
                    ImageView imageView18 = studentVideoPluginViewPadSmallClassView.iv_live_business_mic_1;
                    if (imageView18 != null) {
                        imageView18.setVisibility(0);
                        return;
                    }
                    return;
                }
            }
            ImageView imageView19 = studentVideoPluginViewPadSmallClassView.iv_live_business_mic_1;
            if (imageView19 != null) {
                imageView19.setVisibility(8);
            }
        } else if (i == 1) {
            studentVideoPluginViewPadSmallClassView.bean2 = listBean;
            if (listBean == null) {
                View view4 = studentVideoPluginViewPadSmallClassView.rl_live_business_student_2;
                if (view4 != null) {
                    view4.setVisibility(4);
                    return;
                }
                return;
            }
            View view5 = studentVideoPluginViewPadSmallClassView.rl_live_business_student_2;
            if (view5 != null) {
                view5.setVisibility(0);
            }
            TextView textView2 = studentVideoPluginViewPadSmallClassView.tv_live_business_name_2;
            if (textView2 != null) {
                textView2.setText(listBean.getNickName());
            }
            ImageLoaderJ.loadCircle(studentVideoPluginViewPadSmallClassView.getContext(), listBean.getAvatar(), studentVideoPluginViewPadSmallClassView.iv_live_business_head2, R.drawable.common_self_image_user);
            RelativeLayout relativeLayout7 = studentVideoPluginViewPadSmallClassView.rl_live_business_head_parent2;
            if (relativeLayout7 != null) {
                relativeLayout7.setVisibility((listBean.getCameraPerm() != 1 || listBean.isDisableTheVideo() || listBean.isOtherShowHeadBg()) ? 0 : 8);
            }
            ImageView imageView20 = studentVideoPluginViewPadSmallClassView.iv_live_business_video_2;
            if (imageView20 != null) {
                imageView20.setVisibility((listBean.getCameraPerm() != 1 || listBean.isDisableTheVideo()) ? 8 : 0);
            }
            if (listBean.getCameraPerm() == 1 && (relativeLayout = studentVideoPluginViewPadSmallClassView.fl_live_business_student_2) != null) {
                studentVideoPluginViewPadSmallClassView.addSurfaceView(surfaceView, relativeLayout);
                Unit unit14 = Unit.INSTANCE;
                Unit unit15 = Unit.INSTANCE;
            }
            ImageView imageView21 = studentVideoPluginViewPadSmallClassView.iv_live_business_video_2;
            if (imageView21 != null) {
                if (listBean.getCameraPerm() == 1) {
                    i3 = listBean.isHerselfOff() ? R.drawable.live_business_icon_video_turnoff : R.drawable.live_business_icon_video_turnon;
                } else {
                    i3 = R.drawable.live_business_icon_video_turnoff;
                }
                imageView21.setImageResource(i3);
                Unit unit16 = Unit.INSTANCE;
            }
            if (studentVideoPluginViewPadSmallClassView.isCollectiveSpeech) {
                LottieAnimationView lottieAnimationView7 = studentVideoPluginViewPadSmallClassView.liv_live_business_video_voice_2;
                if (lottieAnimationView7 != null) {
                    lottieAnimationView7.setVisibility(0);
                }
                LottieAnimationView lottieAnimationView8 = studentVideoPluginViewPadSmallClassView.liv_live_business_video_voice_2;
                if (lottieAnimationView8 != null) {
                    lottieAnimationView8.playAnimation();
                    Unit unit17 = Unit.INSTANCE;
                }
                ImageView imageView22 = studentVideoPluginViewPadSmallClassView.iv_live_business_my_level2;
                if (imageView22 != null) {
                    imageView22.setVisibility(8);
                    return;
                }
                return;
            }
            LottieAnimationView lottieAnimationView9 = studentVideoPluginViewPadSmallClassView.liv_live_business_video_voice_2;
            if (lottieAnimationView9 != null) {
                lottieAnimationView9.setVisibility(8);
            }
            LottieAnimationView lottieAnimationView10 = studentVideoPluginViewPadSmallClassView.liv_live_business_video_voice_2;
            if (lottieAnimationView10 != null) {
                lottieAnimationView10.cancelAnimation();
                Unit unit18 = Unit.INSTANCE;
            }
            if (listBean.getLevel() == 0) {
                ImageView imageView23 = studentVideoPluginViewPadSmallClassView.iv_live_business_my_level2;
                if (imageView23 != null) {
                    imageView23.setVisibility(8);
                    return;
                }
                return;
            }
            ImageView imageView24 = studentVideoPluginViewPadSmallClassView.iv_live_business_my_level2;
            if (imageView24 != null) {
                imageView24.setImageResource(studentVideoPluginViewPadSmallClassView.levelIcons[listBean.getLevel() - 1]);
                Unit unit19 = Unit.INSTANCE;
            }
            ImageView imageView25 = studentVideoPluginViewPadSmallClassView.iv_live_business_my_level2;
            if (imageView25 != null) {
                imageView25.setVisibility(0);
            }
        } else if (i == 2) {
            studentVideoPluginViewPadSmallClassView.bean3 = listBean;
            if (listBean == null) {
                RelativeLayout relativeLayout8 = studentVideoPluginViewPadSmallClassView.rl_live_business_student_3;
                if (relativeLayout8 != null) {
                    relativeLayout8.setVisibility(4);
                    return;
                }
                return;
            }
            RelativeLayout relativeLayout9 = studentVideoPluginViewPadSmallClassView.rl_live_business_student_3;
            if (relativeLayout9 != null) {
                relativeLayout9.setVisibility(0);
            }
            TextView textView3 = studentVideoPluginViewPadSmallClassView.tv_live_business_name_3;
            if (textView3 != null) {
                textView3.setText(listBean.getNickName());
            }
            ImageLoaderJ.loadCircle(studentVideoPluginViewPadSmallClassView.getContext(), listBean.getAvatar(), studentVideoPluginViewPadSmallClassView.iv_live_business_head3, R.drawable.common_self_image_user);
            RelativeLayout relativeLayout10 = studentVideoPluginViewPadSmallClassView.rl_live_business_head_parent3;
            if (relativeLayout10 != null) {
                relativeLayout10.setVisibility((listBean.getCameraPerm() != 1 || listBean.isDisableTheVideo() || listBean.isOtherShowHeadBg()) ? 0 : 8);
            }
            ImageView imageView26 = studentVideoPluginViewPadSmallClassView.iv_live_business_video_3;
            if (imageView26 != null) {
                imageView26.setVisibility((listBean.getCameraPerm() != 1 || listBean.isDisableTheVideo()) ? 8 : 0);
            }
            if (listBean.getCameraPerm() == 1 && (relativeLayout2 = studentVideoPluginViewPadSmallClassView.fl_live_business_student_3) != null) {
                studentVideoPluginViewPadSmallClassView.addSurfaceView(surfaceView, relativeLayout2);
                Unit unit20 = Unit.INSTANCE;
                Unit unit21 = Unit.INSTANCE;
            }
            ImageView imageView27 = studentVideoPluginViewPadSmallClassView.iv_live_business_video_3;
            if (imageView27 != null) {
                if (listBean.getCameraPerm() == 1) {
                    i4 = listBean.isHerselfOff() ? R.drawable.live_business_icon_video_turnoff : R.drawable.live_business_icon_video_turnon;
                } else {
                    i4 = R.drawable.live_business_icon_video_turnoff;
                }
                imageView27.setImageResource(i4);
                Unit unit22 = Unit.INSTANCE;
            }
            if (studentVideoPluginViewPadSmallClassView.isCollectiveSpeech) {
                LottieAnimationView lottieAnimationView11 = studentVideoPluginViewPadSmallClassView.liv_live_business_video_voice_3;
                if (lottieAnimationView11 != null) {
                    lottieAnimationView11.setVisibility(0);
                }
                LottieAnimationView lottieAnimationView12 = studentVideoPluginViewPadSmallClassView.liv_live_business_video_voice_3;
                if (lottieAnimationView12 != null) {
                    lottieAnimationView12.playAnimation();
                    Unit unit23 = Unit.INSTANCE;
                }
                ImageView imageView28 = studentVideoPluginViewPadSmallClassView.iv_live_business_my_level3;
                if (imageView28 != null) {
                    imageView28.setVisibility(8);
                    return;
                }
                return;
            }
            LottieAnimationView lottieAnimationView13 = studentVideoPluginViewPadSmallClassView.liv_live_business_video_voice_3;
            if (lottieAnimationView13 != null) {
                lottieAnimationView13.setVisibility(8);
            }
            LottieAnimationView lottieAnimationView14 = studentVideoPluginViewPadSmallClassView.liv_live_business_video_voice_3;
            if (lottieAnimationView14 != null) {
                lottieAnimationView14.cancelAnimation();
                Unit unit24 = Unit.INSTANCE;
            }
            if (listBean.getLevel() == 0) {
                ImageView imageView29 = studentVideoPluginViewPadSmallClassView.iv_live_business_my_level3;
                if (imageView29 != null) {
                    imageView29.setVisibility(8);
                    return;
                }
                return;
            }
            ImageView imageView30 = studentVideoPluginViewPadSmallClassView.iv_live_business_my_level3;
            if (imageView30 != null) {
                imageView30.setImageResource(studentVideoPluginViewPadSmallClassView.levelIcons[listBean.getLevel() - 1]);
                Unit unit25 = Unit.INSTANCE;
            }
            ImageView imageView31 = studentVideoPluginViewPadSmallClassView.iv_live_business_my_level3;
            if (imageView31 != null) {
                imageView31.setVisibility(0);
            }
        } else if (i == 3) {
            studentVideoPluginViewPadSmallClassView.bean4 = listBean;
            if (listBean == null) {
                RelativeLayout relativeLayout11 = studentVideoPluginViewPadSmallClassView.rl_live_business_student_4;
                if (relativeLayout11 != null) {
                    relativeLayout11.setVisibility(4);
                    return;
                }
                return;
            }
            RelativeLayout relativeLayout12 = studentVideoPluginViewPadSmallClassView.rl_live_business_student_4;
            if (relativeLayout12 != null) {
                relativeLayout12.setVisibility(0);
            }
            TextView textView4 = studentVideoPluginViewPadSmallClassView.tv_live_business_name_4;
            if (textView4 != null) {
                textView4.setText(listBean.getNickName());
            }
            ImageLoaderJ.loadCircle(studentVideoPluginViewPadSmallClassView.getContext(), listBean.getAvatar(), studentVideoPluginViewPadSmallClassView.iv_live_business_head4, R.drawable.common_self_image_user);
            RelativeLayout relativeLayout13 = studentVideoPluginViewPadSmallClassView.rl_live_business_head_parent4;
            if (relativeLayout13 != null) {
                relativeLayout13.setVisibility((listBean.getCameraPerm() != 1 || listBean.isDisableTheVideo() || listBean.isOtherShowHeadBg()) ? 0 : 8);
            }
            ImageView imageView32 = studentVideoPluginViewPadSmallClassView.iv_live_business_video_4;
            if (imageView32 != null) {
                imageView32.setVisibility((listBean.getCameraPerm() != 1 || listBean.isDisableTheVideo()) ? 8 : 0);
            }
            if (listBean.getCameraPerm() == 1 && (relativeLayout3 = studentVideoPluginViewPadSmallClassView.fl_live_business_student_4) != null) {
                studentVideoPluginViewPadSmallClassView.addSurfaceView(surfaceView, relativeLayout3);
                Unit unit26 = Unit.INSTANCE;
                Unit unit27 = Unit.INSTANCE;
            }
            ImageView imageView33 = studentVideoPluginViewPadSmallClassView.iv_live_business_video_4;
            if (imageView33 != null) {
                if (listBean.getCameraPerm() == 1) {
                    i5 = listBean.isHerselfOff() ? R.drawable.live_business_icon_video_turnoff : R.drawable.live_business_icon_video_turnon;
                } else {
                    i5 = R.drawable.live_business_icon_video_turnoff;
                }
                imageView33.setImageResource(i5);
                Unit unit28 = Unit.INSTANCE;
            }
            if (studentVideoPluginViewPadSmallClassView.isCollectiveSpeech) {
                LottieAnimationView lottieAnimationView15 = studentVideoPluginViewPadSmallClassView.liv_live_business_video_voice_4;
                if (lottieAnimationView15 != null) {
                    lottieAnimationView15.setVisibility(0);
                }
                LottieAnimationView lottieAnimationView16 = studentVideoPluginViewPadSmallClassView.liv_live_business_video_voice_4;
                if (lottieAnimationView16 != null) {
                    lottieAnimationView16.playAnimation();
                    Unit unit29 = Unit.INSTANCE;
                }
                ImageView imageView34 = studentVideoPluginViewPadSmallClassView.iv_live_business_my_level4;
                if (imageView34 != null) {
                    imageView34.setVisibility(8);
                    return;
                }
                return;
            }
            LottieAnimationView lottieAnimationView17 = studentVideoPluginViewPadSmallClassView.liv_live_business_video_voice_4;
            if (lottieAnimationView17 != null) {
                lottieAnimationView17.setVisibility(8);
            }
            LottieAnimationView lottieAnimationView18 = studentVideoPluginViewPadSmallClassView.liv_live_business_video_voice_4;
            if (lottieAnimationView18 != null) {
                lottieAnimationView18.cancelAnimation();
                Unit unit30 = Unit.INSTANCE;
            }
            if (listBean.getLevel() == 0) {
                ImageView imageView35 = studentVideoPluginViewPadSmallClassView.iv_live_business_my_level4;
                if (imageView35 != null) {
                    imageView35.setVisibility(8);
                    return;
                }
                return;
            }
            ImageView imageView36 = studentVideoPluginViewPadSmallClassView.iv_live_business_my_level4;
            if (imageView36 != null) {
                imageView36.setImageResource(studentVideoPluginViewPadSmallClassView.levelIcons[listBean.getLevel() - 1]);
                Unit unit31 = Unit.INSTANCE;
            }
            ImageView imageView37 = studentVideoPluginViewPadSmallClassView.iv_live_business_my_level4;
            if (imageView37 != null) {
                imageView37.setVisibility(0);
            }
        } else if (i == 4) {
            studentVideoPluginViewPadSmallClassView.bean5 = listBean;
            if (listBean == null) {
                RelativeLayout relativeLayout14 = studentVideoPluginViewPadSmallClassView.rl_live_business_student_5;
                if (relativeLayout14 != null) {
                    relativeLayout14.setVisibility(4);
                    return;
                }
                return;
            }
            RelativeLayout relativeLayout15 = studentVideoPluginViewPadSmallClassView.rl_live_business_student_5;
            if (relativeLayout15 != null) {
                relativeLayout15.setVisibility(0);
            }
            TextView textView5 = studentVideoPluginViewPadSmallClassView.tv_live_business_name_5;
            if (textView5 != null) {
                textView5.setText(listBean.getNickName());
            }
            ImageLoaderJ.loadCircle(studentVideoPluginViewPadSmallClassView.getContext(), listBean.getAvatar(), studentVideoPluginViewPadSmallClassView.iv_live_business_head5, R.drawable.common_self_image_user);
            RelativeLayout relativeLayout16 = studentVideoPluginViewPadSmallClassView.rl_live_business_head_parent5;
            if (relativeLayout16 != null) {
                relativeLayout16.setVisibility((listBean.getCameraPerm() != 1 || listBean.isDisableTheVideo() || listBean.isOtherShowHeadBg()) ? 0 : 8);
            }
            ImageView imageView38 = studentVideoPluginViewPadSmallClassView.iv_live_business_video_5;
            if (imageView38 != null) {
                imageView38.setVisibility((listBean.getCameraPerm() != 1 || listBean.isDisableTheVideo()) ? 8 : 0);
            }
            if (listBean.getCameraPerm() == 1 && (relativeLayout4 = studentVideoPluginViewPadSmallClassView.fl_live_business_student_5) != null) {
                studentVideoPluginViewPadSmallClassView.addSurfaceView(surfaceView, relativeLayout4);
                Unit unit32 = Unit.INSTANCE;
                Unit unit33 = Unit.INSTANCE;
            }
            ImageView imageView39 = studentVideoPluginViewPadSmallClassView.iv_live_business_video_5;
            if (imageView39 != null) {
                if (listBean.getCameraPerm() == 1) {
                    i6 = listBean.isHerselfOff() ? R.drawable.live_business_icon_video_turnoff : R.drawable.live_business_icon_video_turnon;
                } else {
                    i6 = R.drawable.live_business_icon_video_turnoff;
                }
                imageView39.setImageResource(i6);
                Unit unit34 = Unit.INSTANCE;
            }
            if (studentVideoPluginViewPadSmallClassView.isCollectiveSpeech) {
                LottieAnimationView lottieAnimationView19 = studentVideoPluginViewPadSmallClassView.liv_live_business_video_voice_5;
                if (lottieAnimationView19 != null) {
                    lottieAnimationView19.setVisibility(0);
                }
                LottieAnimationView lottieAnimationView20 = studentVideoPluginViewPadSmallClassView.liv_live_business_video_voice_5;
                if (lottieAnimationView20 != null) {
                    lottieAnimationView20.playAnimation();
                    Unit unit35 = Unit.INSTANCE;
                }
                ImageView imageView40 = studentVideoPluginViewPadSmallClassView.iv_live_business_my_level5;
                if (imageView40 != null) {
                    imageView40.setVisibility(8);
                    return;
                }
                return;
            }
            LottieAnimationView lottieAnimationView21 = studentVideoPluginViewPadSmallClassView.liv_live_business_video_voice_5;
            if (lottieAnimationView21 != null) {
                lottieAnimationView21.setVisibility(8);
            }
            LottieAnimationView lottieAnimationView22 = studentVideoPluginViewPadSmallClassView.liv_live_business_video_voice_5;
            if (lottieAnimationView22 != null) {
                lottieAnimationView22.cancelAnimation();
                Unit unit36 = Unit.INSTANCE;
            }
            if (listBean.getLevel() == 0) {
                ImageView imageView41 = studentVideoPluginViewPadSmallClassView.iv_live_business_my_level5;
                if (imageView41 != null) {
                    imageView41.setVisibility(8);
                    return;
                }
                return;
            }
            ImageView imageView42 = studentVideoPluginViewPadSmallClassView.iv_live_business_my_level5;
            if (imageView42 != null) {
                imageView42.setImageResource(studentVideoPluginViewPadSmallClassView.levelIcons[listBean.getLevel() - 1]);
                Unit unit37 = Unit.INSTANCE;
            }
            ImageView imageView43 = studentVideoPluginViewPadSmallClassView.iv_live_business_my_level5;
            if (imageView43 != null) {
                imageView43.setVisibility(0);
            }
        } else if (i == 5) {
            studentVideoPluginViewPadSmallClassView.bean6 = listBean;
            if (listBean == null) {
                RelativeLayout relativeLayout17 = studentVideoPluginViewPadSmallClassView.rl_live_business_student_6;
                if (relativeLayout17 != null) {
                    relativeLayout17.setVisibility(4);
                    return;
                }
                return;
            }
            RelativeLayout relativeLayout18 = studentVideoPluginViewPadSmallClassView.rl_live_business_student_6;
            if (relativeLayout18 != null) {
                relativeLayout18.setVisibility(0);
            }
            TextView textView6 = studentVideoPluginViewPadSmallClassView.tv_live_business_name_6;
            if (textView6 != null) {
                textView6.setText(listBean.getNickName());
            }
            ImageLoaderJ.loadCircle(studentVideoPluginViewPadSmallClassView.getContext(), listBean.getAvatar(), studentVideoPluginViewPadSmallClassView.iv_live_business_head6, R.drawable.common_self_image_user);
            RelativeLayout relativeLayout19 = studentVideoPluginViewPadSmallClassView.rl_live_business_head_parent6;
            if (relativeLayout19 != null) {
                relativeLayout19.setVisibility((listBean.getCameraPerm() != 1 || listBean.isDisableTheVideo() || listBean.isOtherShowHeadBg()) ? 0 : 8);
            }
            ImageView imageView44 = studentVideoPluginViewPadSmallClassView.iv_live_business_video_6;
            if (imageView44 != null) {
                imageView44.setVisibility((listBean.getCameraPerm() != 1 || listBean.isDisableTheVideo()) ? 8 : 0);
            }
            if (listBean.getCameraPerm() == 1 && (relativeLayout5 = studentVideoPluginViewPadSmallClassView.fl_live_business_student_6) != null) {
                studentVideoPluginViewPadSmallClassView.addSurfaceView(surfaceView, relativeLayout5);
                Unit unit38 = Unit.INSTANCE;
                Unit unit39 = Unit.INSTANCE;
            }
            ImageView imageView45 = studentVideoPluginViewPadSmallClassView.iv_live_business_video_6;
            if (imageView45 != null) {
                if (listBean.getCameraPerm() == 1) {
                    i7 = listBean.isHerselfOff() ? R.drawable.live_business_icon_video_turnoff : R.drawable.live_business_icon_video_turnon;
                } else {
                    i7 = R.drawable.live_business_icon_video_turnoff;
                }
                imageView45.setImageResource(i7);
                Unit unit40 = Unit.INSTANCE;
            }
            if (studentVideoPluginViewPadSmallClassView.isCollectiveSpeech) {
                LottieAnimationView lottieAnimationView23 = studentVideoPluginViewPadSmallClassView.liv_live_business_video_voice_6;
                if (lottieAnimationView23 != null) {
                    lottieAnimationView23.setVisibility(0);
                }
                LottieAnimationView lottieAnimationView24 = studentVideoPluginViewPadSmallClassView.liv_live_business_video_voice_6;
                if (lottieAnimationView24 != null) {
                    lottieAnimationView24.playAnimation();
                    Unit unit41 = Unit.INSTANCE;
                }
                ImageView imageView46 = studentVideoPluginViewPadSmallClassView.iv_live_business_my_level6;
                if (imageView46 != null) {
                    imageView46.setVisibility(8);
                    return;
                }
                return;
            }
            LottieAnimationView lottieAnimationView25 = studentVideoPluginViewPadSmallClassView.liv_live_business_video_voice_6;
            if (lottieAnimationView25 != null) {
                lottieAnimationView25.setVisibility(8);
            }
            LottieAnimationView lottieAnimationView26 = studentVideoPluginViewPadSmallClassView.liv_live_business_video_voice_6;
            if (lottieAnimationView26 != null) {
                lottieAnimationView26.cancelAnimation();
                Unit unit42 = Unit.INSTANCE;
            }
            if (listBean.getLevel() == 0) {
                ImageView imageView47 = studentVideoPluginViewPadSmallClassView.iv_live_business_my_level6;
                if (imageView47 != null) {
                    imageView47.setVisibility(8);
                    return;
                }
                return;
            }
            ImageView imageView48 = studentVideoPluginViewPadSmallClassView.iv_live_business_my_level6;
            if (imageView48 != null) {
                imageView48.setImageResource(studentVideoPluginViewPadSmallClassView.levelIcons[listBean.getLevel() - 1]);
                Unit unit43 = Unit.INSTANCE;
            }
            ImageView imageView49 = studentVideoPluginViewPadSmallClassView.iv_live_business_my_level6;
            if (imageView49 != null) {
                imageView49.setVisibility(0);
            }
        }
    }

    private final void addSurfaceView(SurfaceView surfaceView, RelativeLayout relativeLayout) {
        if (surfaceView != null) {
            ViewGroup viewGroup = (ViewGroup) surfaceView.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(surfaceView);
            }
            relativeLayout.removeAllViews();
            relativeLayout.addView(surfaceView, 0);
            if (surfaceView.getVisibility() != 0) {
                surfaceView.setVisibility(0);
            }
            surfaceView.requestLayout();
        }
    }

    public void rootViewIsShow(boolean z) {
        super.rootViewIsShow(z);
        if (z) {
            View view = this.rl_live_business_student_root;
            if (view != null) {
                view.setVisibility(0);
            }
            View view2 = this.rl_live_business_student_normal;
            if (view2 != null) {
                view2.setVisibility(0);
            }
            View view3 = this.rl_live_business_student_empty;
            if (view3 != null) {
                view3.setVisibility(8);
                return;
            }
            return;
        }
        View view4 = this.rl_live_business_student_root;
        if (view4 != null) {
            view4.setVisibility(8);
        }
        View view5 = this.rl_live_business_student_normal;
        if (view5 != null) {
            view5.setVisibility(8);
        }
        View view6 = this.rl_live_business_student_empty;
        if (view6 != null) {
            view6.setVisibility(0);
        }
    }

    public void videoChatToggle(boolean z) {
        super.videoChatToggle(z);
        View view = this.rl_live_business_student_root;
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }

    public void setCollectiveSpeech(boolean z) {
        super.setCollectiveSpeech(z);
        this.isCollectiveSpeech = z;
    }

    public void onDestroy() {
        super.onDestroy();
        LottieAnimationView lottieAnimationView = this.liv_live_business_video_voice_1;
        if (lottieAnimationView != null) {
            lottieAnimationView.cancelAnimation();
        }
        LottieAnimationView lottieAnimationView2 = this.liv_live_business_video_voice_2;
        if (lottieAnimationView2 != null) {
            lottieAnimationView2.cancelAnimation();
        }
        LottieAnimationView lottieAnimationView3 = this.liv_live_business_video_voice_3;
        if (lottieAnimationView3 != null) {
            lottieAnimationView3.cancelAnimation();
        }
        LottieAnimationView lottieAnimationView4 = this.liv_live_business_video_voice_4;
        if (lottieAnimationView4 != null) {
            lottieAnimationView4.cancelAnimation();
        }
        LottieAnimationView lottieAnimationView5 = this.liv_live_business_video_voice_5;
        if (lottieAnimationView5 != null) {
            lottieAnimationView5.cancelAnimation();
        }
        LottieAnimationView lottieAnimationView6 = this.liv_live_business_video_voice_6;
        if (lottieAnimationView6 != null) {
            lottieAnimationView6.cancelAnimation();
        }
    }
}
