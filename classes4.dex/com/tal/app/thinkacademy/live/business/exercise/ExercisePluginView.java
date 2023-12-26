package com.tal.app.thinkacademy.live.business.exercise;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.tal.app.thinkacademy.common.business.browser.agent.AgentConfig;
import com.tal.app.thinkacademy.common.business.browser.agent.WebAgent;
import com.tal.app.thinkacademy.common.business.browser.server.ServerManager;
import com.tal.app.thinkacademy.common.imconfig.ConfigInfo;
import com.tal.app.thinkacademy.common.imconfig.ImConfig;
import com.tal.app.thinkacademy.common.util.PadUtils;
import com.tal.app.thinkacademy.lib.interfaces.route.DataBusKey;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.GsonUtils;
import com.tal.app.thinkacademy.lib.utils.XesDataBus;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.business.continuous.ResultFactory;
import com.tal.app.thinkacademy.live.business.continuous.window.IWindowManager;
import com.tal.app.thinkacademy.live.business.continuous.window.SubmitResultView;
import com.tal.app.thinkacademy.live.business.databinding.LiveBusinessExerciseBinding;
import com.tal.app.thinkacademy.live.business.topic.bean.AnswerBean;
import com.tal.app.thinkacademy.live.core.plugin.pluginview.BaseInteractBoxPluginView;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B%\b\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u0018\u001a\u00020\u0019H\u0016J\"\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0014J\u001d\u0010!\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010%J\u0010\u0010&\u001a\u00020\u00192\b\u0010'\u001a\u0004\u0018\u00010\u0014J\u001a\u0010(\u001a\u00020\u00192\u0006\u0010)\u001a\u00020\u00142\b\u0010'\u001a\u0004\u0018\u00010\u0014H\u0002J\u0006\u0010*\u001a\u00020\u0019J\u000e\u0010+\u001a\u00020\u00192\u0006\u0010,\u001a\u00020\u0014J\u0015\u0010-\u001a\u00020\u00192\b\u0010.\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010/R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/exercise/ExercisePluginView;", "Lcom/tal/app/thinkacademy/live/core/plugin/pluginview/BaseInteractBoxPluginView;", "Lcom/tal/app/thinkacademy/live/business/databinding/LiveBusinessExerciseBinding;", "Lcom/tal/app/thinkacademy/live/business/continuous/window/IWindowManager;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "Lcom/tal/app/thinkacademy/live/Tag;", "driver", "Lcom/tal/app/thinkacademy/live/business/exercise/ExerciseBasePluginDriver;", "getDriver", "()Lcom/tal/app/thinkacademy/live/business/exercise/ExerciseBasePluginDriver;", "setDriver", "(Lcom/tal/app/thinkacademy/live/business/exercise/ExerciseBasePluginDriver;)V", "mJs", "", "mLiveType", "mWebAgent", "Lcom/tal/app/thinkacademy/common/business/browser/agent/WebAgent;", "close", "", "createViewBinding", "inflater", "Landroid/view/LayoutInflater;", "group", "Landroid/view/ViewGroup;", "attach", "", "drawResultView", "answerBean", "Lcom/tal/app/thinkacademy/live/business/topic/bean/AnswerBean;", "isRight", "(Lcom/tal/app/thinkacademy/live/business/topic/bean/AnswerBean;Ljava/lang/Integer;)V", "initLoadUrl", "js", "loadView", "loadUrl", "onDestroy", "setLiveType", "type", "showCoinsView", "userCoins", "(Ljava/lang/Integer;)V", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ExercisePluginView.kt */
public final class ExercisePluginView extends BaseInteractBoxPluginView<LiveBusinessExerciseBinding> implements IWindowManager {
    /* access modifiers changed from: private */
    public final Tag TAG;
    private ExerciseBasePluginDriver driver;
    /* access modifiers changed from: private */
    public String mJs;
    /* access modifiers changed from: private */
    public String mLiveType;
    /* access modifiers changed from: private */
    public WebAgent mWebAgent;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ExercisePluginView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ExercisePluginView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final ExerciseBasePluginDriver getDriver() {
        return this.driver;
    }

    public final void setDriver(ExerciseBasePluginDriver exerciseBasePluginDriver) {
        this.driver = exerciseBasePluginDriver;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ExercisePluginView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.TAG = Tag.EXERCISE;
        this.mLiveType = "直播";
        FragmentActivity context2 = getContext();
        Objects.requireNonNull(context2, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        WebAgent webAgent = new WebAgent(context2);
        AgentConfig.Builder builder = new AgentConfig.Builder();
        builder.setShowProgressBar(false);
        builder.setShowTitle(false);
        Unit unit = Unit.INSTANCE;
        this.mWebAgent = webAgent.applyConfig(builder.build()).setWebAgentParent(this.mBinding.getRoot(), new ViewGroup.LayoutParams(-1, -1));
        LifecycleOwner context3 = getContext();
        Objects.requireNonNull(context3, "null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
        XesDataBus.with(DataBusKey.EXERCISE_VIEW_CONTENT).observe(context3, new ExercisePluginView$special$$inlined$observe$1(this));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ExercisePluginView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final void setLiveType(String str) {
        Intrinsics.checkNotNullParameter(str, "type");
        this.mLiveType = str;
    }

    public final void initLoadUrl(String str) {
        String onlineUrl;
        this.mJs = str;
        if (!ServerManager.getInstance().isServerRunning() || ImConfig.INSTANCE.isUpDataCommonPackage()) {
            ConfigInfo.CourseWares commonDistInfo = ImConfig.INSTANCE.getCommonDistInfo();
            String str2 = "https://sszt-mgr.oss-cn-beijing.aliyuncs.com/courseware/";
            if (!(commonDistInfo == null || (onlineUrl = commonDistInfo.getOnlineUrl()) == null)) {
                str2 = onlineUrl;
            }
            loadView(str2, str);
            return;
        }
        loadView("http://localhost:8080/", str);
    }

    private final void loadView(String str, String str2) {
        String str3 = PadUtils.isPad(getContext()) ? "pad" : "phone";
        WebAgent webAgent = this.mWebAgent;
        if (webAgent != null) {
            webAgent.loadUrl(str + "dist/fillblanks.html?client=" + str3);
        }
        XesLog.i(this.TAG, this.mLiveType, "开始加载打开填空互动的webview");
    }

    public final void drawResultView(AnswerBean answerBean, Integer num) {
        Intrinsics.checkNotNullParameter(answerBean, "answerBean");
        if (num != null) {
            int intValue = num.intValue();
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            SubmitResultView createWindow = ResultFactory.createWindow(intValue, context, answerBean, this);
            if (createWindow != null) {
                this.mBinding.getRoot().addView((View) createWindow, new FrameLayout.LayoutParams(-1, -1));
                createWindow.setBackground((Drawable) null);
                SubmitResultView.show$default(createWindow, (Function0) null, 1, (Object) null);
            }
        }
    }

    public void close() {
        ExerciseBasePluginDriver exerciseBasePluginDriver = this.driver;
        if (exerciseBasePluginDriver != null) {
            exerciseBasePluginDriver.removePlugin(0);
        }
    }

    public final void showCoinsView(Integer num) {
        if (num != null) {
            num.intValue();
            WebAgent webAgent = this.mWebAgent;
            if (webAgent != null) {
                Intrinsics.checkNotNull(webAgent);
                webAgent.jsCallBack("window.clientMessageHandlers", GsonUtils.toJson(new InteractionJsBean("showCoin", new InteractionData(0L, (String) null, (String) null, num))));
                XesLog.i(this.TAG, "请求接口拿到答题赢得的金币数通知JS展示结果页和金币奖励页");
                return;
            }
            XesLog.i(this.TAG, "请求接口拿到答题赢得的金币数未能通知JS展示结果页和金币奖励页");
        }
    }

    public final void onDestroy() {
        WebAgent webAgent = this.mWebAgent;
        if (webAgent != null) {
            webAgent.onDestroy();
        }
        this.mWebAgent = null;
    }

    /* access modifiers changed from: protected */
    public LiveBusinessExerciseBinding createViewBinding(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        LiveBusinessExerciseBinding inflate = LiveBusinessExerciseBinding.inflate(layoutInflater, viewGroup, z);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, group, attach)");
        return inflate;
    }
}
