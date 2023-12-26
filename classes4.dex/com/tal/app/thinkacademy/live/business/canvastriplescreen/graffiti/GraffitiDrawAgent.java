package com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.tal.app.thinkacademy.lib.util.constant.AppConfig;
import com.tal.app.thinkacademy.lib.utils.HWCoroutineScopeKt;
import com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti.GraffitiIRCCallbackAdapter;
import com.tal.app.thinkacademy.live.business.drawing.DrawTools;
import com.tal.app.thinkacademy.live.business.vote.entity.VoteNoticeCode;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import com.tal.app.thinkacademy.live.core.interfaces.IircControllerProvider;
import com.tal.app.thinkacademy.live.core.irc.entity.BatchBinaryMessage;
import com.tal.app.thinkacademy.live.core.irc.entity.BinaryMessage;
import com.tal.app.thinkacademy.live.core.irc.entity.BinaryMessageInfo;
import com.tal.app.thinkacademy.live.core.live.datastorage.DataStorage;
import com.tal.app.thinkacademy.live.core.live.datastorage.RoomData;
import com.tal.app.thinkacademy.live.core.plugin.BaseLivePluginDriver;
import com.xueersi.lib.graffiti.WXTGraffitiEngine;
import com.xueersi.lib.graffiti.WXTGraffitiEngineImpl;
import com.xueersi.lib.graffiti.WXWBAction;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.SendChannel;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u001dH\u0016J\u0014\u0010!\u001a\u0004\u0018\u00010\u000b2\b\u0010\"\u001a\u0004\u0018\u00010\u000bH\u0016J\u0016\u0010#\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\u000fJ'\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00150'2\u0006\u0010\"\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020)H@ø\u0001\u0000¢\u0006\u0002\u0010*J\u0012\u0010+\u001a\u00020\u001d2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u0012\u0010.\u001a\u00020\u001d2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\u0012\u00101\u001a\u00020\u001d2\b\u00102\u001a\u0004\u0018\u00010\u000bH\u0016J\"\u00103\u001a\u00020\u001d2\u0006\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u00010\u000b2\u0006\u00107\u001a\u00020)H\u0016J\u0018\u00108\u001a\u00020\u001d2\u0006\u00102\u001a\u00020\u000b2\u0006\u00109\u001a\u000205H\u0016J\u0018\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00150;2\b\u0010<\u001a\u0004\u0018\u00010=H\u0002J\u000e\u0010>\u001a\u00020\u001d2\u0006\u0010?\u001a\u00020@J\b\u0010A\u001a\u00020\u001dH\u0002R\u0014\u0010\n\u001a\u00020\u000bXD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006B"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/canvastriplescreen/graffiti/GraffitiDrawAgent;", "Lcom/tal/app/thinkacademy/live/business/canvastriplescreen/graffiti/GraffitiAgent;", "Lcom/tal/app/thinkacademy/live/business/canvastriplescreen/graffiti/GraffitiIRCCallbackAdapter;", "context", "Landroid/content/Context;", "driver", "Lcom/tal/app/thinkacademy/live/core/plugin/BaseLivePluginDriver;", "provider", "Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;", "(Landroid/content/Context;Lcom/tal/app/thinkacademy/live/core/plugin/BaseLivePluginDriver;Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "isLook", "", "()Z", "setLook", "(Z)V", "mChannel", "Lkotlinx/coroutines/channels/Channel;", "Lcom/xueersi/lib/graffiti/WXWBAction;", "mGraffitiTagView", "Lcom/tal/app/thinkacademy/live/business/canvastriplescreen/graffiti/GraffitiTagView;", "mIrcControllerProvider", "Lcom/tal/app/thinkacademy/live/core/interfaces/IircControllerProvider;", "mScopeSender", "Lkotlinx/coroutines/CoroutineScope;", "bindCanvasView", "", "view", "Landroid/view/ViewGroup;", "destroy", "getPageKeyByDBKey", "dbkey", "initGraffiti", "specifKey", "isSync", "loadHistoryMsg", "", "lastMsgId", "", "(Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onBatchHistoryBinaryMessage", "batchBinaryMessage", "Lcom/tal/app/thinkacademy/live/core/irc/entity/BatchBinaryMessage;", "onBinaryMessage", "binaryMessageInfo", "Lcom/tal/app/thinkacademy/live/core/irc/entity/BinaryMessageInfo;", "onHistoryLoaded", "pageKey", "onSendRoomBinaryMessageFailed", "errorCode", "", "errorMsg", "preMsgId", "onTurnPage", "style", "receiveHistoryBinaryMessage", "", "binaryMessage", "Lcom/tal/app/thinkacademy/live/core/irc/entity/BinaryMessage;", "setDrawTools", "tool", "Lcom/tal/app/thinkacademy/live/business/drawing/DrawTools;", "setListener", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GraffitiDrawAgent.kt */
public final class GraffitiDrawAgent extends GraffitiAgent implements GraffitiIRCCallbackAdapter {
    private final String TAG = "小黑板";
    private boolean isLook;
    /* access modifiers changed from: private */
    public Channel<WXWBAction> mChannel;
    private GraffitiTagView mGraffitiTagView;
    /* access modifiers changed from: private */
    public IircControllerProvider mIrcControllerProvider;
    private CoroutineScope mScopeSender;

    public void onBatchHistoryBinaryMessage(BatchBinaryMessage batchBinaryMessage) {
    }

    public void onBinaryMessage(BinaryMessage binaryMessage) {
        GraffitiIRCCallbackAdapter.DefaultImpls.onBinaryMessage((GraffitiIRCCallbackAdapter) this, binaryMessage);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GraffitiDrawAgent(Context context, BaseLivePluginDriver baseLivePluginDriver, ILiveRoomProvider iLiveRoomProvider) {
        super(context, baseLivePluginDriver, iLiveRoomProvider);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(baseLivePluginDriver, "driver");
        Intrinsics.checkNotNullParameter(iLiveRoomProvider, "provider");
    }

    public final boolean isLook() {
        return this.isLook;
    }

    public final void setLook(boolean z) {
        this.isLook = z;
    }

    /* access modifiers changed from: protected */
    public String getTAG() {
        return this.TAG;
    }

    public final void initGraffiti(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "specifKey");
        super.initGraffiti(str);
        if (z) {
            log("新版主讲，将采用实时涂鸦方案");
            this.mChannel = ChannelKt.Channel$default(Integer.MAX_VALUE, (BufferOverflow) null, (Function1) null, 6, (Object) null);
            IircControllerProvider ircControllerProvider = getMLiveRoomProvider().getIrcControllerProvider();
            this.mIrcControllerProvider = ircControllerProvider;
            if (ircControllerProvider != null) {
                ircControllerProvider.addBinaryMessageCallback(this);
            }
            setListener();
            if (this.mScopeSender == null) {
                this.mScopeSender = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(new CoroutineName("sender")));
            }
            CoroutineScope coroutineScope = this.mScopeSender;
            if (coroutineScope != null) {
                HWCoroutineScopeKt.launchWithException(coroutineScope, new GraffitiDrawAgent$initGraffiti$1(this), new GraffitiDrawAgent$initGraffiti$2(this, (Continuation<? super GraffitiDrawAgent$initGraffiti$2>) null));
                return;
            }
            return;
        }
        log("旧版主讲，将采用本地绘制上传图片方案");
    }

    public void bindCanvasView(ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "view");
        super.bindCanvasView(viewGroup);
        if (this.mGraffitiTagView == null) {
            GraffitiTagView graffitiTagView = new GraffitiTagView(getMContext());
            this.mGraffitiTagView = graffitiTagView;
            viewGroup.addView(graffitiTagView);
        }
    }

    private final void setListener() {
        setBaseListener(new GraffitiDrawAgent$setListener$1(this));
        setSendListener(new GraffitiDrawAgent$setListener$2(this));
    }

    public void onBinaryMessage(BinaryMessageInfo binaryMessageInfo) {
        RoomData roomData;
        RoomData roomData2;
        String str = null;
        if ((binaryMessageInfo == null ? null : binaryMessageInfo.key) != null) {
            String str2 = binaryMessageInfo.key;
            Intrinsics.checkNotNullExpressionValue(str2, "binaryMessageInfo.key");
            if (StringsKt.contains$default(str2, GraffitiAgentKt.BLACK_BOARD_TAG, false, 2, (Object) null)) {
                String str3 = binaryMessageInfo.key;
                Intrinsics.checkNotNullExpressionValue(str3, "binaryMessageInfo.key");
                String substringAfter$default = StringsKt.substringAfter$default(str3, "#", (String) null, 2, (Object) null);
                if ((substringAfter$default.length() == 0) || Intrinsics.areEqual(substringAfter$default, getMUid())) {
                    String str4 = binaryMessageInfo.from;
                    if (!TextUtils.isEmpty(str4)) {
                        Intrinsics.checkNotNullExpressionValue(str4, "from");
                        if (StringsKt.startsWith$default(str4, "t", false, 2, (Object) null)) {
                            DataStorage dataStorage = getMLiveRoomProvider().getDataStorage();
                            if (Intrinsics.areEqual("in-training", (dataStorage == null || (roomData2 = dataStorage.getRoomData()) == null) ? null : roomData2.getMode())) {
                                return;
                            }
                        } else if (StringsKt.startsWith$default(str4, "f", false, 2, (Object) null)) {
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
    }

    private final List<WXWBAction> receiveHistoryBinaryMessage(BinaryMessage binaryMessage) {
        List<WXWBAction> arrayList = new ArrayList<>();
        if (binaryMessage != null) {
            String str = binaryMessage.key;
            Intrinsics.checkNotNullExpressionValue(str, "binaryMessage.key");
            Integer num = null;
            if (StringsKt.contains$default(str, GraffitiAgentKt.BLACK_BOARD_TAG, false, 2, (Object) null)) {
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

    public String getPageKeyByDBKey(String str) {
        if (TextUtils.equals(str, getMPageKey())) {
            return getMPageKey();
        }
        if (str == null) {
            return null;
        }
        return StringsKt.substringAfter(str, "_", "");
    }

    public void onHistoryLoaded(String str) {
        setTouchAble(true);
    }

    public Object loadHistoryMsg(String str, long j, Continuation<? super List<? extends WXWBAction>> continuation) {
        return loadHistoryMsgFromNet(str, j + 1, 1, continuation);
    }

    public void onSendRoomBinaryMessageFailed(int i, String str, long j) {
        log(Intrinsics.stringPlus("发送涂鸦失败 ", Long.valueOf(j)));
    }

    public void onTurnPage(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "pageKey");
        WXTGraffitiEngineImpl mGraffitiEngine = getMGraffitiEngine();
        if (!Intrinsics.areEqual(str, mGraffitiEngine == null ? null : mGraffitiEngine.getPageKey())) {
            setTouchAble(false);
            WXTGraffitiEngineImpl mGraffitiEngine2 = getMGraffitiEngine();
            if (mGraffitiEngine2 != null) {
                mGraffitiEngine2.turnPageTo(str, i);
            }
            setMLastSendMsgId(-1);
            GraffitiAgent.cancel$default(this, (String) null, 1, (Object) null);
            GraffitiTagView graffitiTagView = this.mGraffitiTagView;
            if (graffitiTagView != null) {
                graffitiTagView.clear();
            }
        }
    }

    public final void setDrawTools(DrawTools drawTools) {
        Intrinsics.checkNotNullParameter(drawTools, "tool");
        WXTGraffitiEngineImpl mGraffitiEngine = getMGraffitiEngine();
        WXTGraffitiEngine.Setting setting = null;
        WXTGraffitiEngine.Setting setting2 = mGraffitiEngine == null ? null : mGraffitiEngine.getSetting();
        if (setting2 != null) {
            setting2.setPenStyle(drawTools.getPenStyle());
        }
        if (drawTools.getPenStyle() == 1) {
            WXTGraffitiEngineImpl mGraffitiEngine2 = getMGraffitiEngine();
            WXTGraffitiEngine.Setting setting3 = mGraffitiEngine2 == null ? null : mGraffitiEngine2.getSetting();
            if (setting3 != null) {
                setting3.setPenWidth(0.05f);
            }
            WXTGraffitiEngineImpl mGraffitiEngine3 = getMGraffitiEngine();
            if (mGraffitiEngine3 != null) {
                setting = mGraffitiEngine3.getSetting();
            }
            if (setting != null) {
                setting.setEraseWidth(0.05f);
                return;
            }
            return;
        }
        WXTGraffitiEngineImpl mGraffitiEngine4 = getMGraffitiEngine();
        WXTGraffitiEngine.Setting setting4 = mGraffitiEngine4 == null ? null : mGraffitiEngine4.getSetting();
        if (setting4 != null) {
            setting4.setPenWidth(0.004f);
        }
        String strokeColor = drawTools.getStrokeColor();
        if (strokeColor != null) {
            WXTGraffitiEngineImpl mGraffitiEngine5 = getMGraffitiEngine();
            if (mGraffitiEngine5 != null) {
                setting = mGraffitiEngine5.getSetting();
            }
            if (setting != null) {
                setting.setStrokeColor(Color.parseColor(strokeColor));
            }
        }
    }

    public void destroy() {
        super.destroy();
        SendChannel sendChannel = this.mChannel;
        if (sendChannel != null) {
            SendChannel.DefaultImpls.close$default(sendChannel, (Throwable) null, 1, (Object) null);
        }
        this.mChannel = null;
        CoroutineScope coroutineScope = this.mScopeSender;
        if (coroutineScope != null) {
            CoroutineScopeKt.cancel$default(coroutineScope, "正常销毁", (Throwable) null, 2, (Object) null);
        }
        this.mScopeSender = null;
        IircControllerProvider iircControllerProvider = this.mIrcControllerProvider;
        if (iircControllerProvider != null) {
            iircControllerProvider.removeBinaryMessageCallback(this);
        }
        GraffitiTagView graffitiTagView = this.mGraffitiTagView;
        if (graffitiTagView != null) {
            graffitiTagView.destroy();
        }
    }
}
