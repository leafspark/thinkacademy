package com.tal.app.thinkacademy.common.dialog;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintSet;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.common.R;
import com.tal.app.thinkacademy.common.Tag;
import com.tal.app.thinkacademy.common.appmonitor.HWEventTracking;
import com.tal.app.thinkacademy.common.business.AppVersionBll;
import com.tal.app.thinkacademy.common.databinding.DialogUpdateVersionBinding;
import com.tal.app.thinkacademy.common.entity.UpdateVersionEntity;
import com.tal.app.thinkacademy.common.utils.ChannelUtil;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.FileUtils;
import com.tal.app.thinkacademy.lib.util.NetworkUtils;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import com.tal.app.thinkacademy.lib.util.ToastUtils;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\nH\u0014J\u0010\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J \u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0011H\u0002J \u0010\u0017\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0011H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/tal/app/thinkacademy/common/dialog/UpdateVersionDialog;", "Lcom/tal/app/thinkacademy/lib/commui/baseview/dialog/BaseBindDialog;", "Lcom/tal/app/thinkacademy/common/databinding/DialogUpdateVersionBinding;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "tag", "Lcom/tal/app/thinkacademy/common/Tag;", "createViewBinding", "inflater", "Landroid/view/LayoutInflater;", "initData", "", "updateVersionEntity", "Lcom/tal/app/thinkacademy/common/entity/UpdateVersionEntity;", "jumpMarket", "marketUrl", "", "update", "downLoadUrl", "localForceUpgrade", "", "md5", "updateLocal", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: UpdateVersionDialog.kt */
public final class UpdateVersionDialog extends BaseBindDialog<DialogUpdateVersionBinding> {
    private final Tag tag = Tag.APP_UPGRADE;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UpdateVersionDialog(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        layoutParams(new ViewGroup.LayoutParams(SizeUtils.dp2px(279.0f), -2));
        this.binding.tvContent.setMovementMethod(ScrollingMovementMethod.getInstance());
        canceledOnTouchOutside(false);
    }

    /* access modifiers changed from: protected */
    public DialogUpdateVersionBinding createViewBinding(LayoutInflater layoutInflater) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        DialogUpdateVersionBinding inflate = DialogUpdateVersionBinding.inflate(layoutInflater);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater)");
        return inflate;
    }

    public final void initData(UpdateVersionEntity updateVersionEntity) {
        if (updateVersionEntity != null) {
            if (updateVersionEntity.getLocalForceUpgrade()) {
                this.binding.ivClose.setVisibility(8);
                setCancelable(false);
            } else {
                this.binding.ivClose.setVisibility(0);
                this.binding.ivClose.setOnClickListener(new UpdateVersionDialog$$ExternalSyntheticLambda1(updateVersionEntity, this));
            }
            this.binding.tvVersionNumber.setText(Intrinsics.stringPlus("v", updateVersionEntity.getNewVersion()));
            this.binding.tvContent.setText(Html.fromHtml(updateVersionEntity.getDesc()));
            if (!FileUtils.isFileExists(AppVersionBll.Companion.getInstance().getAppVersionFile())) {
                this.binding.btnUpdate.setText(getContext().getResources().getString(R.string.update_now));
            } else {
                this.binding.btnUpdate.setText(getContext().getString(R.string.installation));
            }
            if (updateVersionEntity.isGray()) {
                this.binding.tvVersionGray.setVisibility(0);
            } else {
                this.binding.tvVersionGray.setVisibility(8);
            }
            this.binding.btnUpdate.setOnClickListener(new UpdateVersionDialog$$ExternalSyntheticLambda0(this, updateVersionEntity, updateVersionEntity));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: initData$lambda-2$lambda-0  reason: not valid java name */
    public static final void m46initData$lambda2$lambda0(UpdateVersionEntity updateVersionEntity, UpdateVersionDialog updateVersionDialog, View view) {
        Intrinsics.checkNotNullParameter(updateVersionDialog, "this$0");
        HWEventTracking.Companion.get().ostaUpdateSkip(updateVersionEntity.getNewVersion());
        updateVersionDialog.cancel();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: initData$lambda-2$lambda-1  reason: not valid java name */
    public static final void m47initData$lambda2$lambda1(UpdateVersionDialog updateVersionDialog, UpdateVersionEntity updateVersionEntity, UpdateVersionEntity updateVersionEntity2, View view) {
        Intrinsics.checkNotNullParameter(updateVersionDialog, "this$0");
        Intrinsics.checkNotNullParameter(updateVersionEntity, "$this_run");
        if (Intrinsics.areEqual(updateVersionDialog.getContext().getString(R.string.installation), updateVersionDialog.binding.btnUpdate.getText()) && FileUtils.isFileExists(AppVersionBll.Companion.getInstance().getAppVersionFile())) {
            XesLog.a(updateVersionDialog.tag, "用户点击 安装App");
            File appVersionFile = AppVersionBll.Companion.getInstance().getAppVersionFile();
            if (appVersionFile != null && appVersionFile.exists()) {
                AppVersionBll instance = AppVersionBll.Companion.getInstance();
                String absolutePath = appVersionFile.getAbsolutePath();
                Intrinsics.checkNotNullExpressionValue(absolutePath, "file.absolutePath");
                instance.installApk(absolutePath);
            }
        } else if (Intrinsics.areEqual(updateVersionDialog.getContext().getString(R.string.update_now), updateVersionDialog.binding.btnUpdate.getText())) {
            XesLog.a(updateVersionDialog.tag, "用户点击 立即升级");
            updateVersionDialog.update(updateVersionEntity.getPackageUrl(), updateVersionEntity.getLocalForceUpgrade(), updateVersionEntity.getPackageMd5());
            HWEventTracking.Companion.get().ostaUpdateInstall(updateVersionEntity2.getNewVersion());
        } else if (Intrinsics.areEqual(updateVersionDialog.getContext().getString(R.string.retry), updateVersionDialog.binding.btnUpdate.getText())) {
            XesLog.a(updateVersionDialog.tag, "用户点击 重试");
            updateVersionDialog.update(updateVersionEntity.getPackageUrl(), updateVersionEntity.getLocalForceUpgrade(), updateVersionEntity.getPackageMd5());
        } else if (Intrinsics.areEqual(updateVersionDialog.getContext().getString(R.string.run_in_background), updateVersionDialog.binding.btnUpdate.getText())) {
            XesLog.a(updateVersionDialog.tag, "用户点击 后台下载");
            updateVersionDialog.cancel();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    private final void update(String str, boolean z, String str2) {
        if (ChannelUtil.INSTANCE.isGoogleChannel()) {
            jumpMarket(str);
        } else {
            updateLocal(str, z, str2);
        }
    }

    private final void jumpMarket(String str) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent.addFlags(268435456);
        try {
            XesLog.i(this.tag, Intrinsics.stringPlus("跳转google市场 APP URL：", str));
            getContext().startActivity(intent);
        } catch (Exception e) {
            ToastUtils.showLong(R.string.jump_play_error);
            XesLog.e(this.tag, Intrinsics.stringPlus("跳转失败：", e.getMessage()));
        }
    }

    private final void updateLocal(String str, boolean z, String str2) {
        if (!NetworkUtils.isConnected()) {
            ToastUtils.showShort(getContext().getText(R.string.net_fail));
            return;
        }
        this.binding.updateGroup.setVisibility(0);
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(this.binding.clUpdate);
        constraintSet.connect(R.id.btn_update, 3, R.id.tv_process, 4);
        constraintSet.applyTo(this.binding.clUpdate);
        if (z) {
            this.binding.btnUpdate.setVisibility(8);
        } else {
            this.binding.btnUpdate.setText(getContext().getString(R.string.run_in_background));
            this.binding.btnUpdate.setBackground(getContext().getResources().getDrawable(R.drawable.bg_ffffff_34_corners));
            this.binding.btnUpdate.setTextColor(getContext().getResources().getColor(R.color.color_ffaa0a));
        }
        this.binding.tvContent.setVisibility(8);
        this.binding.tvProcess.setText("0%");
        this.binding.pbUpdateVersionProcess.setProgress(10);
        AppVersionBll instance = AppVersionBll.Companion.getInstance();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        instance.startUpdateApp(context, str, str2, new UpdateVersionDialog$updateLocal$1(this), new UpdateVersionDialog$updateLocal$2(this), new UpdateVersionDialog$updateLocal$3(this));
    }
}
