package com.tal.app.thinkacademy.common.dialog;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.listener.OnResultCallbackListener;
import com.tal.app.thinkacademy.common.business.browser.agent.AgentConfig;
import com.tal.app.thinkacademy.common.business.browser.agent.WebAgent;
import com.tal.app.thinkacademy.common.databinding.DialogBrowserBinding;
import com.tal.app.thinkacademy.common.utils.PictureSelectorHelper;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseBindDialog;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.BaseDialog;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.ChoosePicDialog;
import com.tal.app.thinkacademy.lib.commui.baseview.dialog.ChoosePicType;
import com.tal.app.thinkacademy.lib.interfaces.route.DataBusKey;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.utils.XesDataBus;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\u0018\u0000 32\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u00013B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u0018H\u0002J\u0010\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001cH\u0014J\b\u0010\u001d\u001a\u00020\u0018H\u0002J\b\u0010\u001e\u001a\u00020\u0018H\u0002J\b\u0010\u001f\u001a\u00020\u0018H\u0016J\b\u0010 \u001a\u00020!H\u0016J\u000e\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0002J\b\u0010#\u001a\u00020\u0018H\u0002J\u000e\u0010$\u001a\u00020\u00002\u0006\u0010%\u001a\u00020&J\u0012\u0010'\u001a\u00020\u00182\b\u0010(\u001a\u0004\u0018\u00010\u0003H\u0007J\u000e\u0010)\u001a\u00020\u00002\u0006\u0010*\u001a\u00020+J\u000e\u0010,\u001a\u00020\u00002\u0006\u0010-\u001a\u00020.J\b\u0010/\u001a\u00020\u0018H\u0016J\u001e\u00100\u001a\u00020\u00182\u0014\u00101\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u00130\u0012H\u0002J\b\u00102\u001a\u00020\u0018H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u0012\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0013\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/tal/app/thinkacademy/common/dialog/BrowserDialog;", "Lcom/tal/app/thinkacademy/lib/commui/baseview/dialog/BaseBindDialog;", "Lcom/tal/app/thinkacademy/common/databinding/DialogBrowserBinding;", "Landroidx/lifecycle/LifecycleOwner;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "isChoose", "", "isTakePhoto", "mActivity", "Landroidx/fragment/app/FragmentActivity;", "mChooseDialog", "Lcom/tal/app/thinkacademy/lib/commui/baseview/dialog/BaseDialog;", "mOnResultCallbackListener", "Lcom/luck/picture/lib/listener/OnResultCallbackListener;", "Lcom/luck/picture/lib/entity/LocalMedia;", "mUploadMsg", "Landroid/webkit/ValueCallback;", "", "Landroid/net/Uri;", "mWebAgent", "Lcom/tal/app/thinkacademy/common/business/browser/agent/WebAgent;", "choosePhoto", "", "clearUploadMessage", "createViewBinding", "inflater", "Landroid/view/LayoutInflater;", "createWebAgent", "destroy", "dismiss", "getLifecycle", "Landroidx/lifecycle/Lifecycle;", "getOnResultCallbackListener", "initObservers", "loadUrl", "url", "", "onLifecycleDestroy", "owner", "setContainerBgColor", "color", "", "setContainerRadius", "radius", "", "show", "showFileChooser", "valueCallback", "takePhoto", "Companion", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BrowserDialog.kt */
public final class BrowserDialog extends BaseBindDialog<DialogBrowserBinding> implements LifecycleOwner {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "BrowserDialog";
    /* access modifiers changed from: private */
    public boolean isChoose;
    /* access modifiers changed from: private */
    public final boolean isTakePhoto;
    private final FragmentActivity mActivity;
    /* access modifiers changed from: private */
    public BaseDialog mChooseDialog;
    private OnResultCallbackListener<LocalMedia> mOnResultCallbackListener;
    /* access modifiers changed from: private */
    public ValueCallback<Uri[]> mUploadMsg;
    private WebAgent mWebAgent;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BrowserDialog(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mActivity = (FragmentActivity) context;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/tal/app/thinkacademy/common/dialog/BrowserDialog$Companion;", "", "()V", "TAG", "", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: BrowserDialog.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final BrowserDialog setContainerRadius(float f) {
        this.binding.container.setRadius(f);
        return this;
    }

    public final BrowserDialog setContainerBgColor(int i) {
        this.binding.container.setCardBackgroundColor(i);
        return this;
    }

    public final BrowserDialog loadUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "url");
        XesLog.it(TAG, Intrinsics.stringPlus("加载url：", str));
        if (this.mWebAgent == null) {
            createWebAgent();
            Unit unit = Unit.INSTANCE;
        }
        WebAgent webAgent = this.mWebAgent;
        if (webAgent != null) {
            webAgent.loadUrl(str);
        }
        return this;
    }

    public void show() {
        super.show();
        XesLog.it(TAG, "展示弹窗");
        initObservers();
    }

    private final void createWebAgent() {
        this.mWebAgent = new WebAgent(this.mActivity).applyConfig(new AgentConfig.Builder().build()).setWebAgentParent(this.binding.container, new ViewGroup.LayoutParams(-1, -1));
    }

    private final void initObservers() {
        XesLog.it(TAG, "注册事件监听");
        LifecycleOwner lifecycleOwner = (LifecycleOwner) this;
        XesDataBus.with(DataBusKey.SHOW_FILE_CHOOSER).observe(lifecycleOwner, new BrowserDialog$$ExternalSyntheticLambda0(this));
        XesDataBus.with(DataBusKey.WEB_DISMISS_VIEW).observe(lifecycleOwner, new BrowserDialog$$ExternalSyntheticLambda1(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: initObservers$lambda-1  reason: not valid java name */
    public static final void m37initObservers$lambda1(BrowserDialog browserDialog, ValueCallback valueCallback) {
        Intrinsics.checkNotNullParameter(browserDialog, "this$0");
        if (valueCallback != null) {
            XesLog.it(TAG, "收到选择文件事件");
            browserDialog.showFileChooser(valueCallback);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: initObservers$lambda-2  reason: not valid java name */
    public static final void m38initObservers$lambda2(BrowserDialog browserDialog, Object obj) {
        Intrinsics.checkNotNullParameter(browserDialog, "this$0");
        XesLog.it(TAG, "收到关闭弹窗事件");
        browserDialog.dismiss();
    }

    private final void showFileChooser(ValueCallback<Uri[]> valueCallback) {
        this.mUploadMsg = valueCallback;
        this.isChoose = false;
        if (this.mChooseDialog == null) {
            this.mChooseDialog = new ChoosePicDialog(this.mActivity, (Function1<? super ChoosePicType, Unit>) new BrowserDialog$showFileChooser$1(this));
        }
        BaseDialog baseDialog = this.mChooseDialog;
        if (baseDialog != null) {
            baseDialog.show();
        }
        BaseDialog baseDialog2 = this.mChooseDialog;
        if (baseDialog2 != null) {
            baseDialog2.setDismissListener(new BrowserDialog$$ExternalSyntheticLambda2(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: showFileChooser$lambda-3  reason: not valid java name */
    public static final void m39showFileChooser$lambda3(BrowserDialog browserDialog) {
        Intrinsics.checkNotNullParameter(browserDialog, "this$0");
        if (!browserDialog.isChoose) {
            XesLog.it(TAG, "选择照片弹窗消失，未跳转选择或拍照");
            browserDialog.clearUploadMessage();
        }
    }

    /* access modifiers changed from: private */
    public final void takePhoto() {
        XesDataBus.with(DataBusKey.TAKE_PHOTO_STATE).postStickyData("start");
        XesLog.it(TAG, "发起拍照，通知关闭自己的推流");
        if (this.mOnResultCallbackListener == null) {
            this.mOnResultCallbackListener = getOnResultCallbackListener();
        }
        PictureSelectorHelper.Companion.get().takePhoto(this.mActivity, 1, false, false, 0, this.mOnResultCallbackListener);
    }

    /* access modifiers changed from: private */
    public final void choosePhoto() {
        if (this.mOnResultCallbackListener == null) {
            this.mOnResultCallbackListener = getOnResultCallbackListener();
        }
        PictureSelectorHelper.Companion.get().choosePhoto(this.mActivity, 10, false, false, 0, this.mOnResultCallbackListener);
    }

    private final OnResultCallbackListener<LocalMedia> getOnResultCallbackListener() {
        return (OnResultCallbackListener) new BrowserDialog$getOnResultCallbackListener$1(this);
    }

    /* access modifiers changed from: private */
    public final void clearUploadMessage() {
        XesLog.it(TAG, "通知WebView释放监听");
        ValueCallback<Uri[]> valueCallback = this.mUploadMsg;
        if (valueCallback != null) {
            valueCallback.onReceiveValue((Object) null);
        }
        this.mUploadMsg = null;
    }

    /* access modifiers changed from: protected */
    public DialogBrowserBinding createViewBinding(LayoutInflater layoutInflater) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        DialogBrowserBinding inflate = DialogBrowserBinding.inflate(layoutInflater);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater)");
        return inflate;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onLifecycleDestroy(LifecycleOwner lifecycleOwner) {
        XesLog.it(TAG, "Activity销毁，隐藏弹窗");
        dismiss();
    }

    private final void destroy() {
        XesLog.it(TAG, "弹窗销毁");
        WebAgent webAgent = this.mWebAgent;
        if (webAgent != null) {
            webAgent.onDestroy();
        }
        this.mWebAgent = null;
        LifecycleOwner lifecycleOwner = (LifecycleOwner) this;
        XesDataBus.with(DataBusKey.SHOW_FILE_CHOOSER).removeObservers(lifecycleOwner);
        XesDataBus.with(DataBusKey.WEB_DISMISS_VIEW).removeObservers(lifecycleOwner);
    }

    public Lifecycle getLifecycle() {
        Lifecycle lifecycle = this.mActivity.getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle, "mActivity.lifecycle");
        return lifecycle;
    }

    public void dismiss() {
        super.dismiss();
        destroy();
    }
}
