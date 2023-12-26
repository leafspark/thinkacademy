package com.tal.app.thinkacademy.business.login.view.devicetest.driver;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.business.login.R;
import com.tal.app.thinkacademy.business.login.view.customview.CountdownTextView;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000  2\u00020\u0001:\u0001 B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0018H\u0016J\b\u0010\u001c\u001a\u00020\u0018H\u0002J\b\u0010\u001d\u001a\u00020\u0018H\u0002J\b\u0010\u001e\u001a\u00020\u0018H\u0002J\b\u0010\u001f\u001a\u00020\u0018H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/view/devicetest/driver/CameraTestDriver;", "Lcom/tal/app/thinkacademy/business/login/view/devicetest/driver/BaseTestDriver;", "owner", "Lcom/tal/app/thinkacademy/business/login/view/devicetest/driver/DeviceTestDriverOwner;", "(Lcom/tal/app/thinkacademy/business/login/view/devicetest/driver/DeviceTestDriverOwner;)V", "mGroupBottomState", "Landroid/view/View;", "mGroupCameraPreview", "mIvCameraState", "Landroid/widget/ImageView;", "mLayoutCameraContainer", "Landroid/widget/FrameLayout;", "mLayoutCameraState", "Landroid/widget/TextView;", "mLine", "mTvCameraMsg", "mTvCameraPassNext", "Lcom/tal/app/thinkacademy/business/login/view/customview/CountdownTextView;", "mTvCameraPreviewTitle", "mTvCameraResultNo", "mTvCameraResultYes", "mTvErrorNext", "mTvErrorRetest", "load", "", "group", "Landroid/view/ViewGroup;", "release", "showCameraError", "showCameraOk", "showCameraPreview", "showNoPermissionView", "Companion", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CameraTestDriver.kt */
public final class CameraTestDriver extends BaseTestDriver {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TAG = "DeviceTest_camera";
    private View mGroupBottomState;
    private View mGroupCameraPreview;
    private ImageView mIvCameraState;
    /* access modifiers changed from: private */
    public FrameLayout mLayoutCameraContainer;
    private TextView mLayoutCameraState;
    private View mLine;
    private TextView mTvCameraMsg;
    /* access modifiers changed from: private */
    public CountdownTextView mTvCameraPassNext;
    private TextView mTvCameraPreviewTitle;
    private TextView mTvCameraResultNo;
    private TextView mTvCameraResultYes;
    private TextView mTvErrorNext;
    private TextView mTvErrorRetest;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CameraTestDriver(DeviceTestDriverOwner deviceTestDriverOwner) {
        super(deviceTestDriverOwner);
        Intrinsics.checkNotNullParameter(deviceTestDriverOwner, "owner");
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/view/devicetest/driver/CameraTestDriver$Companion;", "", "()V", "TAG", "", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CameraTestDriver.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public void load(ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "group");
        super.load(viewGroup);
        LayoutInflater from = LayoutInflater.from(getMDriverOwner().getContext());
        int i = R.layout.layout_device_test_camera_driver;
        View inflate = !(from instanceof LayoutInflater) ? from.inflate(i, viewGroup) : XMLParseInstrumentation.inflate(from, i, viewGroup);
        this.mGroupBottomState = inflate.findViewById(R.id.group_camera_state);
        this.mGroupCameraPreview = inflate.findViewById(R.id.group_camera_preview);
        this.mIvCameraState = (ImageView) inflate.findViewById(R.id.iv_camera_state);
        this.mTvCameraMsg = (TextView) inflate.findViewById(R.id.tv_camera_msg);
        this.mLayoutCameraContainer = (FrameLayout) inflate.findViewById(R.id.layout_camera_container);
        this.mLine = inflate.findViewById(R.id.line_content);
        this.mLayoutCameraState = (TextView) inflate.findViewById(R.id.layout_camera_state);
        this.mTvCameraPassNext = (CountdownTextView) inflate.findViewById(R.id.tv_camera_pass_next);
        this.mTvErrorRetest = (TextView) inflate.findViewById(R.id.tv_error_retest);
        this.mTvErrorNext = (TextView) inflate.findViewById(R.id.tv_error_next);
        this.mTvCameraPreviewTitle = (TextView) inflate.findViewById(R.id.tv_camera_preview_title);
        this.mTvCameraResultNo = (TextView) inflate.findViewById(R.id.tv_camera_result_no);
        this.mTvCameraResultYes = (TextView) inflate.findViewById(R.id.tv_camera_result_yes);
        FrameLayout frameLayout = this.mLayoutCameraContainer;
        if (frameLayout != null) {
            frameLayout.setOutlineProvider(new CameraTestDriver$load$1());
        }
        FrameLayout frameLayout2 = this.mLayoutCameraContainer;
        if (frameLayout2 != null) {
            frameLayout2.setClipToOutline(true);
        }
        getMDriverOwner().requestPermission("android.permission.CAMERA", new CameraTestDriver$load$2(this));
    }

    /* access modifiers changed from: private */
    public final void showCameraPreview() {
        XesLog.it(TAG, new Object[]{"开始摄像头预览"});
        View view = this.mGroupBottomState;
        if (view != null) {
            view.setVisibility(8);
        }
        View view2 = this.mGroupCameraPreview;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        View view3 = this.mLine;
        if (view3 != null) {
            view3.setVisibility(8);
        }
        FrameLayout frameLayout = this.mLayoutCameraContainer;
        if (frameLayout != null) {
            frameLayout.setVisibility(0);
        }
        ImageView imageView = this.mIvCameraState;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        TextView textView = this.mTvCameraMsg;
        if (textView != null) {
            textView.setVisibility(8);
        }
        TextView textView2 = this.mTvCameraResultNo;
        if (textView2 != null) {
            textView2.setOnClickListener(new CameraTestDriver$$ExternalSyntheticLambda2(this));
        }
        TextView textView3 = this.mTvCameraResultYes;
        if (textView3 != null) {
            textView3.setOnClickListener(new CameraTestDriver$$ExternalSyntheticLambda3(this));
        }
        getMDriverOwner().startCameraPreview(new CameraTestDriver$showCameraPreview$3(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: showCameraPreview$lambda-0  reason: not valid java name */
    public static final void m149showCameraPreview$lambda0(CameraTestDriver cameraTestDriver, View view) {
        Intrinsics.checkNotNullParameter(cameraTestDriver, "this$0");
        XesLog.it(TAG, new Object[]{"摄像头预览，检测不通过"});
        cameraTestDriver.getMDriverOwner().stopCameraPreview();
        Function1<Boolean, Unit> mResultCallBlock = cameraTestDriver.getMResultCallBlock();
        if (mResultCallBlock != null) {
            mResultCallBlock.invoke(false);
        }
        cameraTestDriver.showCameraError();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: showCameraPreview$lambda-1  reason: not valid java name */
    public static final void m150showCameraPreview$lambda1(CameraTestDriver cameraTestDriver, View view) {
        Intrinsics.checkNotNullParameter(cameraTestDriver, "this$0");
        XesLog.it(TAG, new Object[]{"摄像头预览，检测通过"});
        cameraTestDriver.getMDriverOwner().stopCameraPreview();
        Function1<Boolean, Unit> mResultCallBlock = cameraTestDriver.getMResultCallBlock();
        if (mResultCallBlock != null) {
            mResultCallBlock.invoke(true);
        }
        cameraTestDriver.showCameraOk();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    private final void showCameraOk() {
        XesLog.it(TAG, new Object[]{"摄像头检测完成"});
        View view = this.mGroupBottomState;
        if (view != null) {
            view.setVisibility(0);
        }
        View view2 = this.mGroupCameraPreview;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        View view3 = this.mLine;
        if (view3 != null) {
            view3.setVisibility(0);
        }
        FrameLayout frameLayout = this.mLayoutCameraContainer;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
        ImageView imageView = this.mIvCameraState;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        TextView textView = this.mTvCameraMsg;
        if (textView != null) {
            textView.setVisibility(0);
        }
        CountdownTextView countdownTextView = this.mTvCameraPassNext;
        if (countdownTextView != null) {
            countdownTextView.setVisibility(0);
        }
        TextView textView2 = this.mTvErrorRetest;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        TextView textView3 = this.mTvErrorNext;
        if (textView3 != null) {
            textView3.setVisibility(8);
        }
        ImageView imageView2 = this.mIvCameraState;
        if (imageView2 != null) {
            imageView2.setSelected(false);
        }
        TextView textView4 = this.mTvCameraMsg;
        if (textView4 != null) {
            textView4.setText(getMDriverOwner().getContext().getString(R.string.camera_test_complete));
        }
        TextView textView5 = this.mLayoutCameraState;
        if (textView5 != null) {
            textView5.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_device_test_state_pass_big, 0, 0);
            textView5.setText(getMDriverOwner().getContext().getString(R.string.your_camera_is_working_properly));
        }
        CountdownTextView countdownTextView2 = this.mTvCameraPassNext;
        if (countdownTextView2 != null) {
            countdownTextView2.setOnClickListener(new CameraTestDriver$$ExternalSyntheticLambda4(this));
        }
        CountdownTextView countdownTextView3 = this.mTvCameraPassNext;
        if (countdownTextView3 != null) {
            CountdownTextView.start$default(countdownTextView3, 5500, 0, new CameraTestDriver$showCameraOk$3(this), 2, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: showCameraOk$lambda-3  reason: not valid java name */
    public static final void m148showCameraOk$lambda3(CameraTestDriver cameraTestDriver, View view) {
        Intrinsics.checkNotNullParameter(cameraTestDriver, "this$0");
        XesLog.it(TAG, new Object[]{"摄像头检测完成，主动点击下一项"});
        Function0<Unit> mFinishCallBlock = cameraTestDriver.getMFinishCallBlock();
        if (mFinishCallBlock != null) {
            mFinishCallBlock.invoke();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    private final void showCameraError() {
        XesLog.it(TAG, new Object[]{"摄像头反显异常"});
        View view = this.mGroupBottomState;
        if (view != null) {
            view.setVisibility(0);
        }
        View view2 = this.mGroupCameraPreview;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        View view3 = this.mLine;
        if (view3 != null) {
            view3.setVisibility(0);
        }
        FrameLayout frameLayout = this.mLayoutCameraContainer;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
        ImageView imageView = this.mIvCameraState;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        TextView textView = this.mTvCameraMsg;
        if (textView != null) {
            textView.setVisibility(0);
        }
        CountdownTextView countdownTextView = this.mTvCameraPassNext;
        if (countdownTextView != null) {
            countdownTextView.setVisibility(8);
        }
        TextView textView2 = this.mTvErrorRetest;
        if (textView2 != null) {
            textView2.setVisibility(0);
        }
        TextView textView3 = this.mTvErrorNext;
        if (textView3 != null) {
            textView3.setVisibility(0);
        }
        ImageView imageView2 = this.mIvCameraState;
        if (imageView2 != null) {
            imageView2.setSelected(true);
        }
        TextView textView4 = this.mTvCameraMsg;
        if (textView4 != null) {
            textView4.setText(getMDriverOwner().getContext().getString(R.string.there_seems_to_be_a_problem_with_your_camera));
        }
        TextView textView5 = this.mLayoutCameraState;
        if (textView5 != null) {
            textView5.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_device_test_state_error_big, 0, 0);
            textView5.setText(getMDriverOwner().getContext().getString(R.string.check_camera_device));
        }
        TextView textView6 = this.mTvErrorRetest;
        if (textView6 != null) {
            textView6.setText(getMDriverOwner().getContext().getString(R.string.retest));
        }
        TextView textView7 = this.mTvErrorRetest;
        if (textView7 != null) {
            textView7.setOnClickListener(new CameraTestDriver$$ExternalSyntheticLambda0(this));
        }
        TextView textView8 = this.mTvErrorNext;
        if (textView8 != null) {
            textView8.setOnClickListener(new CameraTestDriver$$ExternalSyntheticLambda5(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: showCameraError$lambda-5  reason: not valid java name */
    public static final void m146showCameraError$lambda5(CameraTestDriver cameraTestDriver, View view) {
        Intrinsics.checkNotNullParameter(cameraTestDriver, "this$0");
        XesLog.it(TAG, new Object[]{"重新测试"});
        cameraTestDriver.showCameraPreview();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: showCameraError$lambda-6  reason: not valid java name */
    public static final void m147showCameraError$lambda6(CameraTestDriver cameraTestDriver, View view) {
        Intrinsics.checkNotNullParameter(cameraTestDriver, "this$0");
        XesLog.it(TAG, new Object[]{"摄像头反显异常，跳转下一项检测"});
        Function0<Unit> mFinishCallBlock = cameraTestDriver.getMFinishCallBlock();
        if (mFinishCallBlock != null) {
            mFinishCallBlock.invoke();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public final void showNoPermissionView() {
        XesLog.it(TAG, new Object[]{"无摄像头权限异常页面"});
        View view = this.mGroupBottomState;
        if (view != null) {
            view.setVisibility(0);
        }
        View view2 = this.mGroupCameraPreview;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        View view3 = this.mLine;
        if (view3 != null) {
            view3.setVisibility(0);
        }
        FrameLayout frameLayout = this.mLayoutCameraContainer;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
        ImageView imageView = this.mIvCameraState;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        TextView textView = this.mTvCameraMsg;
        if (textView != null) {
            textView.setVisibility(0);
        }
        CountdownTextView countdownTextView = this.mTvCameraPassNext;
        if (countdownTextView != null) {
            countdownTextView.setVisibility(8);
        }
        TextView textView2 = this.mTvErrorRetest;
        if (textView2 != null) {
            textView2.setVisibility(0);
        }
        TextView textView3 = this.mTvErrorNext;
        if (textView3 != null) {
            textView3.setVisibility(0);
        }
        ImageView imageView2 = this.mIvCameraState;
        if (imageView2 != null) {
            imageView2.setSelected(true);
        }
        TextView textView4 = this.mTvCameraMsg;
        if (textView4 != null) {
            textView4.setText(getMDriverOwner().getContext().getString(R.string.thinkAcademy_cannot_use_your_camera));
        }
        TextView textView5 = this.mLayoutCameraState;
        if (textView5 != null) {
            textView5.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_device_test_state_error_big, 0, 0);
            textView5.setText(getMDriverOwner().getContext().getString(R.string.access_camera_in_the_system_settings));
        }
        TextView textView6 = this.mTvErrorRetest;
        if (textView6 != null) {
            textView6.setText(getMDriverOwner().getContext().getString(R.string.settings));
        }
        TextView textView7 = this.mTvErrorRetest;
        if (textView7 != null) {
            textView7.setOnClickListener(new CameraTestDriver$$ExternalSyntheticLambda6(this));
        }
        TextView textView8 = this.mTvErrorNext;
        if (textView8 != null) {
            textView8.setOnClickListener(new CameraTestDriver$$ExternalSyntheticLambda1(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: showNoPermissionView$lambda-8  reason: not valid java name */
    public static final void m151showNoPermissionView$lambda8(CameraTestDriver cameraTestDriver, View view) {
        Intrinsics.checkNotNullParameter(cameraTestDriver, "this$0");
        XesLog.it(TAG, new Object[]{"摄像头无权限，跳转系统settings"});
        cameraTestDriver.getMDriverOwner().saveStateAndToSystemSettings();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: showNoPermissionView$lambda-9  reason: not valid java name */
    public static final void m152showNoPermissionView$lambda9(CameraTestDriver cameraTestDriver, View view) {
        Intrinsics.checkNotNullParameter(cameraTestDriver, "this$0");
        XesLog.it(TAG, new Object[]{"摄像头无权限，跳转下一项检测"});
        Function0<Unit> mFinishCallBlock = cameraTestDriver.getMFinishCallBlock();
        if (mFinishCallBlock != null) {
            mFinishCallBlock.invoke();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void release() {
        super.release();
        getMDriverOwner().stopCameraPreview();
        FrameLayout frameLayout = this.mLayoutCameraContainer;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
        CountdownTextView countdownTextView = this.mTvCameraPassNext;
        if (countdownTextView != null) {
            countdownTextView.release();
        }
    }
}
