package com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti;

import android.content.Context;
import android.text.TextUtils;
import com.tal.app.thinkacademy.lib.util.constant.AppConfig;
import com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti.GraffitiIRCCallbackAdapter;
import com.tal.app.thinkacademy.live.business.canvastriplescreen.http.CanvasRepository;
import com.tal.app.thinkacademy.live.business.vote.entity.VoteNoticeCode;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import com.tal.app.thinkacademy.live.core.interfaces.IircControllerProvider;
import com.tal.app.thinkacademy.live.core.irc.entity.BatchBinaryMessage;
import com.tal.app.thinkacademy.live.core.irc.entity.BinaryMessage;
import com.tal.app.thinkacademy.live.core.irc.entity.BinaryMessageInfo;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaContext;
import com.tal.app.thinkacademy.live.core.live.datastorage.DataStorage;
import com.tal.app.thinkacademy.live.core.live.datastorage.RoomData;
import com.tal.app.thinkacademy.live.core.live.http.bean.StuGraffitiPage;
import com.tal.app.thinkacademy.live.core.plugin.BaseLivePluginDriver;
import com.xueersi.lib.graffiti.WXTGraffitiEngineImpl;
import com.xueersi.lib.graffiti.WXWBAction;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\u000bJ\b\u0010$\u001a\u00020\"H\u0016J\u0010\u0010%\u001a\u00020\"2\u0006\u0010&\u001a\u00020\u000bH\u0016J\u0006\u0010'\u001a\u00020\u0011J\u0006\u0010(\u001a\u00020\"J'\u0010)\u001a\b\u0012\u0004\u0012\u00020*0\u001b2\u0006\u0010+\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020\u0019H@ø\u0001\u0000¢\u0006\u0002\u0010-J\u0012\u0010.\u001a\u00020\"2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\u0012\u00101\u001a\u00020\"2\b\u00102\u001a\u0004\u0018\u000103H\u0016J\u0012\u00104\u001a\u00020\"2\b\u00105\u001a\u0004\u0018\u00010\u000bH\u0016J\"\u00106\u001a\u00020\"2\u0006\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010\u000b2\u0006\u0010:\u001a\u00020\u0019H\u0016J\u0018\u0010;\u001a\u00020\"2\u0006\u00105\u001a\u00020\u000b2\u0006\u0010<\u001a\u000208H\u0016J\u0006\u0010=\u001a\u00020\"J\u0018\u0010>\u001a\b\u0012\u0004\u0012\u00020*0?2\b\u0010@\u001a\u0004\u0018\u00010AH\u0002J\b\u0010B\u001a\u00020\"H\u0002R\u0014\u0010\n\u001a\u00020\u000bXD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006C"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/canvastriplescreen/graffiti/GraffitiLiveAgent;", "Lcom/tal/app/thinkacademy/live/business/canvastriplescreen/graffiti/GraffitiBaseAgent;", "Lcom/tal/app/thinkacademy/live/business/canvastriplescreen/graffiti/GraffitiIRCCallbackAdapter;", "context", "Landroid/content/Context;", "driver", "Lcom/tal/app/thinkacademy/live/core/plugin/BaseLivePluginDriver;", "provider", "Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;", "(Landroid/content/Context;Lcom/tal/app/thinkacademy/live/core/plugin/BaseLivePluginDriver;Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "canvasRepository", "Lcom/tal/app/thinkacademy/live/business/canvastriplescreen/http/CanvasRepository;", "mAuthTouch", "", "mGraffitiTagView", "Lcom/tal/app/thinkacademy/live/business/canvastriplescreen/graffiti/GraffitiTagView;", "mIrcControllerProvider", "Lcom/tal/app/thinkacademy/live/core/interfaces/IircControllerProvider;", "mJob", "Lkotlinx/coroutines/Job;", "mLoadHistoryTime", "", "mPageKeyList", "", "Lcom/tal/app/thinkacademy/live/core/live/http/bean/StuGraffitiPage;", "mScope", "Lkotlinx/coroutines/CoroutineScope;", "mToolsPluginView", "Lcom/tal/app/thinkacademy/live/business/canvastriplescreen/graffiti/GraffitiDrawToolsView;", "closeAuth", "", "reason", "destroy", "initGraffiti", "specifKey", "isAuthTouch", "joinRoom", "loadHistoryMsg", "Lcom/xueersi/lib/graffiti/WXWBAction;", "dbkey", "lastMsgId", "(Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onBatchHistoryBinaryMessage", "batchBinaryMessage", "Lcom/tal/app/thinkacademy/live/core/irc/entity/BatchBinaryMessage;", "onBinaryMessage", "binaryMessageInfo", "Lcom/tal/app/thinkacademy/live/core/irc/entity/BinaryMessageInfo;", "onHistoryLoaded", "pageKey", "onSendRoomBinaryMessageFailed", "errorCode", "", "errorMsg", "preMsgId", "onTurnPage", "style", "openAuth", "receiveHistoryBinaryMessage", "", "binaryMessage", "Lcom/tal/app/thinkacademy/live/core/irc/entity/BinaryMessage;", "setListener", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GraffitiLiveAgent.kt */
public final class GraffitiLiveAgent extends GraffitiBaseAgent implements GraffitiIRCCallbackAdapter {
    private final String TAG = "直播";
    /* access modifiers changed from: private */
    public final CanvasRepository canvasRepository = new CanvasRepository();
    private boolean mAuthTouch;
    private GraffitiTagView mGraffitiTagView;
    /* access modifiers changed from: private */
    public IircControllerProvider mIrcControllerProvider;
    /* access modifiers changed from: private */
    public Job mJob;
    /* access modifiers changed from: private */
    public long mLoadHistoryTime;
    /* access modifiers changed from: private */
    public List<StuGraffitiPage> mPageKeyList;
    /* access modifiers changed from: private */
    public CoroutineScope mScope;
    private GraffitiDrawToolsView mToolsPluginView;

    public void onBatchHistoryBinaryMessage(BatchBinaryMessage batchBinaryMessage) {
    }

    public void onBinaryMessage(BinaryMessage binaryMessage) {
        GraffitiIRCCallbackAdapter.DefaultImpls.onBinaryMessage((GraffitiIRCCallbackAdapter) this, binaryMessage);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GraffitiLiveAgent(Context context, BaseLivePluginDriver baseLivePluginDriver, ILiveRoomProvider iLiveRoomProvider) {
        super(context, baseLivePluginDriver, iLiveRoomProvider);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(baseLivePluginDriver, "driver");
        Intrinsics.checkNotNullParameter(iLiveRoomProvider, "provider");
    }

    /* access modifiers changed from: protected */
    public String getTAG() {
        return this.TAG;
    }

    public void initGraffiti(String str) {
        Intrinsics.checkNotNullParameter(str, "specifKey");
        super.initGraffiti(str);
        if (this.mGraffitiTagView == null) {
            this.mGraffitiTagView = new GraffitiTagView(getMContext());
            getMGraffitiPluginView().addView(this.mGraffitiTagView);
        }
        setListener();
    }

    public final void joinRoom() {
        IircControllerProvider ircControllerProvider = getMLiveRoomProvider().getIrcControllerProvider();
        this.mIrcControllerProvider = ircControllerProvider;
        if (ircControllerProvider != null) {
            ircControllerProvider.addBinaryMessageCallback(this);
        }
    }

    private final void setListener() {
        setBaseListener(new GraffitiLiveAgent$setListener$1(this));
        setSendListener(new GraffitiLiveAgent$setListener$2(this));
    }

    public final boolean isAuthTouch() {
        return this.mAuthTouch;
    }

    public final void openAuth() {
        if (!isAuthTouch()) {
            log("开启授权涂鸦");
            this.mAuthTouch = true;
            if (this.mToolsPluginView == null) {
                this.mToolsPluginView = new GraffitiDrawToolsView(getMContext());
                getMLiveRoomProvider().addView(getMDriver(), this.mToolsPluginView, "graffitiTools", LiveAreaContext.get().getPptLp().newLp());
                GraffitiDrawToolsView graffitiDrawToolsView = this.mToolsPluginView;
                if (graffitiDrawToolsView != null) {
                    graffitiDrawToolsView.setCallback(new GraffitiLiveAgent$openAuth$1(this));
                }
            }
            GraffitiDrawToolsView graffitiDrawToolsView2 = this.mToolsPluginView;
            if (graffitiDrawToolsView2 != null) {
                graffitiDrawToolsView2.chooseDefault();
            }
            WXTGraffitiEngineImpl mGraffitiEngine = getMGraffitiEngine();
            if (!(mGraffitiEngine == null || mGraffitiEngine.getSetting() == null)) {
                setTouchAble(true);
            }
            GraffitiDrawToolsView graffitiDrawToolsView3 = this.mToolsPluginView;
            if (graffitiDrawToolsView3 != null) {
                graffitiDrawToolsView3.setVisibility(0);
            }
        }
    }

    public static /* synthetic */ void closeAuth$default(GraffitiLiveAgent graffitiLiveAgent, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        graffitiLiveAgent.closeAuth(str);
    }

    public final void closeAuth(String str) {
        Intrinsics.checkNotNullParameter(str, "reason");
        log(Intrinsics.stringPlus("关闭授权涂鸦 ", str));
        this.mAuthTouch = false;
        setTouchAble(false);
        GraffitiDrawToolsView graffitiDrawToolsView = this.mToolsPluginView;
        if (graffitiDrawToolsView != null) {
            graffitiDrawToolsView.setVisibility(8);
        }
    }

    public void onBinaryMessage(BinaryMessageInfo binaryMessageInfo) {
        RoomData roomData;
        RoomData roomData2;
        String str = null;
        if ((binaryMessageInfo == null ? null : binaryMessageInfo.key) != null) {
            String str2 = binaryMessageInfo.key;
            Intrinsics.checkNotNullExpressionValue(str2, "binaryMessageInfo.key");
            if (!StringsKt.contains$default(str2, GraffitiAgentKt.BLACK_BOARD_TAG, false, 2, (Object) null)) {
                String str3 = binaryMessageInfo.from;
                if (!TextUtils.isEmpty(str3)) {
                    Intrinsics.checkNotNullExpressionValue(str3, "from");
                    if (StringsKt.startsWith$default(str3, "t", false, 2, (Object) null)) {
                        DataStorage dataStorage = getMLiveRoomProvider().getDataStorage();
                        if (Intrinsics.areEqual("in-training", (dataStorage == null || (roomData2 = dataStorage.getRoomData()) == null) ? null : roomData2.getMode())) {
                            return;
                        }
                    } else if (StringsKt.startsWith$default(str3, "f", false, 2, (Object) null)) {
                        DataStorage dataStorage2 = getMLiveRoomProvider().getDataStorage();
                        if (Intrinsics.areEqual(VoteNoticeCode.MODE_CLASS, (dataStorage2 == null || (roomData = dataStorage2.getRoomData()) == null) ? null : roomData.getMode())) {
                            return;
                        }
                    }
                }
                try {
                    WXWBAction actionForData = WXWBAction.Factory.actionForData(binaryMessageInfo.content, getPageKeyByDBKey(binaryMessageInfo.key));
                    if (actionForData != null) {
                        log(Intrinsics.stringPlus("收到实时涂鸦 ", actionForData.getUniqueKey()), String.valueOf(binaryMessageInfo));
                        CharSequence pageKey = actionForData.getPageKey();
                        WXTGraffitiEngineImpl mGraffitiEngine = getMGraffitiEngine();
                        if (mGraffitiEngine != null) {
                            str = mGraffitiEngine.getPageKey();
                        }
                        if (TextUtils.equals(pageKey, str)) {
                            if (AppConfig.DEBUG) {
                                printAction(actionForData);
                            }
                            syncAddAction(actionForData);
                            GraffitiTagView graffitiTagView = this.mGraffitiTagView;
                            if (graffitiTagView != null) {
                                graffitiTagView.updateGraffitiTag(actionForData);
                                return;
                            }
                            return;
                        }
                        log(Intrinsics.stringPlus("收到实时涂鸦 非本页 ", binaryMessageInfo));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private final List<WXWBAction> receiveHistoryBinaryMessage(BinaryMessage binaryMessage) {
        List<WXWBAction> arrayList = new ArrayList<>();
        if (binaryMessage != null) {
            String str = binaryMessage.key;
            Intrinsics.checkNotNullExpressionValue(str, "msg.key");
            Integer num = null;
            if (StringsKt.contains$default(str, GraffitiAgentKt.BLACK_BOARD_TAG, false, 2, (Object) null)) {
                log("小黑板数据，非直播");
            } else {
                String pageKeyByDBKey = getPageKeyByDBKey(binaryMessage.key);
                CharSequence charSequence = pageKeyByDBKey;
                WXTGraffitiEngineImpl mGraffitiEngine = getMGraffitiEngine();
                if (!TextUtils.equals(charSequence, mGraffitiEngine == null ? null : mGraffitiEngine.getPageKey())) {
                    log("收到历史涂鸦回调, key => " + binaryMessage.key + "，非本页");
                } else {
                    if (binaryMessage.code == 0) {
                        Collection collection = binaryMessage.contents;
                        if (!(collection == null || collection.isEmpty())) {
                            log("收到历史涂鸦, key => " + binaryMessage.key + "，共" + binaryMessage.contents.size() + 26465);
                            List<BinaryMessageInfo> list = binaryMessage.contents;
                            Intrinsics.checkNotNullExpressionValue(list, "msg.contents");
                            for (BinaryMessageInfo binaryMessageInfo : list) {
                                String str2 = binaryMessageInfo.from;
                                if (!TextUtils.isEmpty(str2)) {
                                    Intrinsics.checkNotNullExpressionValue(str2, "from");
                                    if (StringsKt.startsWith$default(str2, "t", false, 2, (Object) null)) {
                                        if (Intrinsics.areEqual("in-training", getMLiveRoomProvider().getDataStorage().getRoomData().getMode())) {
                                        }
                                    } else if (StringsKt.startsWith$default(str2, "f", false, 2, (Object) null) && Intrinsics.areEqual(VoteNoticeCode.MODE_CLASS, getMLiveRoomProvider().getDataStorage().getRoomData().getMode())) {
                                    }
                                }
                                try {
                                    WXWBAction actionForData = WXWBAction.Factory.actionForData(binaryMessageInfo.content, pageKeyByDBKey);
                                    if (actionForData != null) {
                                        if (AppConfig.DEBUG) {
                                            StringBuilder sb = new StringBuilder();
                                            sb.append(binaryMessageInfo);
                                            sb.append(' ');
                                            log(Intrinsics.stringPlus("历史涂鸦数据 ", actionForData.getUniqueKey()), sb.toString());
                                        }
                                        CharSequence charSequence2 = pageKeyByDBKey;
                                        WXTGraffitiEngineImpl mGraffitiEngine2 = getMGraffitiEngine();
                                        if (TextUtils.equals(charSequence2, mGraffitiEngine2 == null ? null : mGraffitiEngine2.getPageKey())) {
                                            arrayList.add(actionForData);
                                        }
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                    Object[] objArr = new Object[1];
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("历史涂鸦为空，key => ");
                    sb2.append(binaryMessage.key);
                    sb2.append("，code => ");
                    sb2.append(binaryMessage.code);
                    sb2.append("，历史条数 => ");
                    List list2 = binaryMessage.contents;
                    if (list2 != null) {
                        num = Integer.valueOf(list2.size());
                    }
                    sb2.append(num);
                    objArr[0] = sb2.toString();
                    log(objArr);
                }
            }
        }
        return arrayList;
    }

    public void onSendRoomBinaryMessageFailed(int i, String str, long j) {
        log(Intrinsics.stringPlus("发送涂鸦失败 ", Long.valueOf(j)));
    }

    public void onTurnPage(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "pageKey");
        setTouchAble(false);
        WXTGraffitiEngineImpl mGraffitiEngine = getMGraffitiEngine();
        if (mGraffitiEngine != null) {
            mGraffitiEngine.turnPageTo(str, i);
        }
        setMLastSendMsgId(-1);
        GraffitiAgent.cancel$default(this, (String) null, 1, (Object) null);
        Job job = this.mJob;
        if (job != null) {
            JobKt.cancel$default(job, "取消查询pagekeylist", (Throwable) null, 2, (Object) null);
        }
        GraffitiTagView graffitiTagView = this.mGraffitiTagView;
        if (graffitiTagView != null) {
            graffitiTagView.clear();
        }
    }

    public void onHistoryLoaded(String str) {
        if (this.mAuthTouch) {
            setTouchAble(true);
        }
    }

    public Object loadHistoryMsg(String str, long j, Continuation<? super List<? extends WXWBAction>> continuation) {
        return loadHistoryMsgFromNet(str, j + 1, 1, continuation);
    }

    public void destroy() {
        super.destroy();
        IircControllerProvider iircControllerProvider = this.mIrcControllerProvider;
        if (iircControllerProvider != null) {
            iircControllerProvider.removeBinaryMessageCallback(this);
        }
        GraffitiTagView graffitiTagView = this.mGraffitiTagView;
        if (graffitiTagView != null) {
            graffitiTagView.destroy();
        }
        CoroutineScope coroutineScope = this.mScope;
        if (coroutineScope != null) {
            CoroutineScopeKt.cancel$default(coroutineScope, (CancellationException) null, 1, (Object) null);
        }
        this.mScope = null;
    }
}
