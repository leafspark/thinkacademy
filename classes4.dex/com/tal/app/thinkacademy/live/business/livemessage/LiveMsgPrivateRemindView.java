package com.tal.app.thinkacademy.live.business.livemessage;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager;
import com.tal.app.thinkacademy.common.constants.SchoolConstants;
import com.tal.app.thinkacademy.lib.imageloader.XesImageLoader;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.chatbox.bean.ChatBoxTextMsgBean;
import com.tal.app.thinkacademy.live.business.databinding.LayoutLiveMsgPrivateRemindBinding;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import com.tal.app.thinkacademy.live.core.live.datastorage.DataStorage;
import com.tal.app.thinkacademy.live.core.live.http.bean.CounselorInfoProxy;
import com.tal.app.thinkacademy.live.core.plugin.pluginview.BaseVBLivePluginView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001eB\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\"\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0014J\u0006\u0010\u0017\u001a\u00020\nJ\u0014\u0010\u0018\u001a\u00020\n2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\n0\tJ\u0014\u0010\u001a\u001a\u00020\n2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\n0\tJ\u000e\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001dR\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001f"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/livemessage/LiveMsgPrivateRemindView;", "Lcom/tal/app/thinkacademy/live/core/plugin/pluginview/BaseVBLivePluginView;", "Lcom/tal/app/thinkacademy/live/business/databinding/LayoutLiveMsgPrivateRemindBinding;", "context", "Landroid/content/Context;", "provider", "Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;", "(Landroid/content/Context;Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;)V", "mGotItTutorMsgBlock", "Lkotlin/Function0;", "", "mHandler", "Landroid/os/Handler;", "mReplyTutorMsgBlock", "getProvider", "()Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;", "createViewBinding", "inflater", "Landroid/view/LayoutInflater;", "group", "Landroid/view/ViewGroup;", "attach", "", "hide", "onGotItTutorMsg", "block", "onReplyTutorMsg", "receiveTutorMsg", "item", "Lcom/tal/app/thinkacademy/live/business/chatbox/bean/ChatBoxTextMsgBean;", "Companion", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LiveMsgPrivateRemindView.kt */
public final class LiveMsgPrivateRemindView extends BaseVBLivePluginView<LayoutLiveMsgPrivateRemindBinding> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int MSG_WHAT_HIDE = 4097;
    public static final long REMIND_SHOW_TIME = 10000;
    private Function0<Unit> mGotItTutorMsgBlock;
    private final Handler mHandler;
    private Function0<Unit> mReplyTutorMsgBlock;
    private final ILiveRoomProvider provider;

    public final ILiveRoomProvider getProvider() {
        return this.provider;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LiveMsgPrivateRemindView(Context context, ILiveRoomProvider iLiveRoomProvider) {
        super(context);
        CounselorInfoProxy counselorInfo;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(iLiveRoomProvider, "provider");
        this.provider = iLiveRoomProvider;
        Looper myLooper = Looper.myLooper();
        Intrinsics.checkNotNull(myLooper);
        this.mHandler = new Handler(myLooper, new LiveMsgPrivateRemindView$$ExternalSyntheticLambda0(this));
        DataStorage dataStorage = iLiveRoomProvider.getDataStorage();
        if (!(dataStorage == null || (counselorInfo = dataStorage.getCounselorInfo()) == null)) {
            this.mBinding.tvTutorName.setText(counselorInfo.getName());
            XesImageLoader xesImageLoader = XesImageLoader.INSTANCE;
            ImageView imageView = this.mBinding.ivTutorAvatar;
            Intrinsics.checkNotNullExpressionValue(imageView, "mBinding.ivTutorAvatar");
            Context context2 = this.mContext;
            Intrinsics.checkNotNullExpressionValue(context2, "mContext");
            XesImageLoader.loadCircleWithBorderImage$default(xesImageLoader, imageView, context2, counselorInfo.getAvatar(), 2, context.getColor(R.color.color_ffffff), R.drawable.circle_user_default_image, false, 32, (Object) null);
            String string = ShareDataManager.getInstance().getString("school_code", "415", ShareDataManager.SHAREDATA_NOT_CLEAR);
            TextView textView = this.mBinding.tvTutorRole;
            SchoolConstants schoolConstants = SchoolConstants.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(string, "schoolCode");
            textView.setText(schoolConstants.getSchoolTeacherName(string).getAssistantTitle());
        }
        this.mBinding.btnTutorMsgReply.setOnClickListener(new LiveMsgPrivateRemindView$$ExternalSyntheticLambda2(this));
        this.mBinding.btnTutorMsgGotIt.setOnClickListener(new LiveMsgPrivateRemindView$$ExternalSyntheticLambda1(this));
        setVisibility(8);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/livemessage/LiveMsgPrivateRemindView$Companion;", "", "()V", "MSG_WHAT_HIDE", "", "REMIND_SHOW_TIME", "", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: LiveMsgPrivateRemindView.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: mHandler$lambda-0  reason: not valid java name */
    public static final boolean m324mHandler$lambda0(LiveMsgPrivateRemindView liveMsgPrivateRemindView, Message message) {
        Intrinsics.checkNotNullParameter(liveMsgPrivateRemindView, "this$0");
        Intrinsics.checkNotNullParameter(message, "it");
        if (message.what != 4097) {
            return false;
        }
        liveMsgPrivateRemindView.hide();
        return false;
    }

    /* access modifiers changed from: protected */
    public LayoutLiveMsgPrivateRemindBinding createViewBinding(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        LayoutLiveMsgPrivateRemindBinding inflate = LayoutLiveMsgPrivateRemindBinding.inflate(layoutInflater, viewGroup, z);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, group, attach)");
        return inflate;
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-2  reason: not valid java name */
    public static final void m322_init_$lambda2(LiveMsgPrivateRemindView liveMsgPrivateRemindView, View view) {
        Intrinsics.checkNotNullParameter(liveMsgPrivateRemindView, "this$0");
        liveMsgPrivateRemindView.hide();
        Function0<Unit> function0 = liveMsgPrivateRemindView.mReplyTutorMsgBlock;
        if (function0 != null) {
            function0.invoke();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-3  reason: not valid java name */
    public static final void m323_init_$lambda3(LiveMsgPrivateRemindView liveMsgPrivateRemindView, View view) {
        Intrinsics.checkNotNullParameter(liveMsgPrivateRemindView, "this$0");
        liveMsgPrivateRemindView.hide();
        Function0<Unit> function0 = liveMsgPrivateRemindView.mGotItTutorMsgBlock;
        if (function0 != null) {
            function0.invoke();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void receiveTutorMsg(ChatBoxTextMsgBean chatBoxTextMsgBean) {
        Intrinsics.checkNotNullParameter(chatBoxTextMsgBean, "item");
        setVisibility(0);
        this.mBinding.tvTutorMsg.setText(chatBoxTextMsgBean.getMsg());
        this.mHandler.removeMessages(MSG_WHAT_HIDE);
        this.mHandler.sendEmptyMessageDelayed(MSG_WHAT_HIDE, REMIND_SHOW_TIME);
    }

    public final void onReplyTutorMsg(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        this.mReplyTutorMsgBlock = function0;
    }

    public final void onGotItTutorMsg(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        this.mGotItTutorMsgBlock = function0;
    }

    public final void hide() {
        this.mHandler.removeMessages(MSG_WHAT_HIDE);
        setVisibility(8);
    }
}
