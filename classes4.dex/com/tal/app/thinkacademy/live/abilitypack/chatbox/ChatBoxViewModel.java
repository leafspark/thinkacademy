package com.tal.app.thinkacademy.live.abilitypack.chatbox;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bonree.sdk.agent.engine.external.JSONObjectInstrumentation;
import com.bonree.sdk.agent.engine.external.Retrofit2Instrumentation;
import com.tal.app.thinkacademy.common.appmonitor.HWEventTracking;
import com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager;
import com.tal.app.thinkacademy.common.imconfig.ImConfig;
import com.tal.app.thinkacademy.common.user.UserInfo;
import com.tal.app.thinkacademy.common.user.UserInfoBll;
import com.tal.app.thinkacademy.common.util.PadUtils;
import com.tal.app.thinkacademy.common.utils.LeanplumUtil;
import com.tal.app.thinkacademy.lib.interfaces.route.DataBusKey;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.network.Api;
import com.tal.app.thinkacademy.lib.restful.HiResponse;
import com.tal.app.thinkacademy.lib.util.DeviceUtils;
import com.tal.app.thinkacademy.lib.util.GsonUtil;
import com.tal.app.thinkacademy.lib.util.GsonUtils;
import com.tal.app.thinkacademy.lib.util.ParseUtils;
import com.tal.app.thinkacademy.lib.util.SizeUtils;
import com.tal.app.thinkacademy.lib.util.StringUtils;
import com.tal.app.thinkacademy.lib.util.ToastUtils;
import com.tal.app.thinkacademy.lib.util.Utils;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.abilitypack.chatbox.listenbody.ChangeChatStatus;
import com.tal.app.thinkacademy.live.abilitypack.chatbox.listenbody.ChangeTeacherControlStatus;
import com.tal.app.thinkacademy.live.abilitypack.chatbox.listenbody.ChatBoxListenerBody;
import com.tal.app.thinkacademy.live.abilitypack.chatbox.listenbody.ChatBoxViewClosed;
import com.tal.app.thinkacademy.live.abilitypack.chatbox.listenbody.CloseChatBox;
import com.tal.app.thinkacademy.live.abilitypack.chatbox.listenbody.HistoryPrivateMessage;
import com.tal.app.thinkacademy.live.abilitypack.chatbox.listenbody.IrcConnectSuccess;
import com.tal.app.thinkacademy.live.abilitypack.chatbox.listenbody.IrcDisConnect;
import com.tal.app.thinkacademy.live.abilitypack.chatbox.listenbody.OnlyPrivateChatMessage;
import com.tal.app.thinkacademy.live.abilitypack.chatbox.listenbody.OpenChatBox;
import com.tal.app.thinkacademy.live.abilitypack.chatbox.listenbody.PlayBackMessage;
import com.tal.app.thinkacademy.live.abilitypack.chatbox.listenbody.PrivateMessage;
import com.tal.app.thinkacademy.live.abilitypack.chatbox.listenbody.ReceiveChatHistoryMessage;
import com.tal.app.thinkacademy.live.abilitypack.chatbox.listenbody.ReceiveChatMessage;
import com.tal.app.thinkacademy.live.abilitypack.chatbox.listenbody.ShowChatBoxRedRot;
import com.tal.app.thinkacademy.live.abilitypack.chatbox.listenbody.UpdateSendMsgStatus;
import com.tal.app.thinkacademy.live.abilitypack.chatbox.listenbody.UpdateSendPrivateMsgStatus;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.chatbox.bean.ChatBoxConfigBean;
import com.tal.app.thinkacademy.live.business.chatbox.bean.ChatBoxEmojiMsgBean;
import com.tal.app.thinkacademy.live.business.chatbox.bean.ChatBoxItemBean;
import com.tal.app.thinkacademy.live.business.chatbox.bean.ChatBoxMsgType;
import com.tal.app.thinkacademy.live.business.chatbox.bean.ChatBoxSendMsgStatus;
import com.tal.app.thinkacademy.live.business.chatbox.bean.ChatBoxSendToType;
import com.tal.app.thinkacademy.live.business.chatbox.bean.ChatBoxTextMsgBean;
import com.tal.app.thinkacademy.live.business.chatbox.bean.ChatBoxTipMsgBean;
import com.tal.app.thinkacademy.live.business.chatbox.bean.TeacherControlChatBean;
import com.tal.app.thinkacademy.live.business.emoji.bean.EmojiAssembleBean;
import com.tal.app.thinkacademy.live.business.emoji.bean.EmojiBean;
import com.tal.app.thinkacademy.live.business.emoji.util.EmojiBeanUtil;
import com.tal.app.thinkacademy.live.business.emoji.util.EmojiUtil;
import com.tal.app.thinkacademy.live.business.function.bean.EnterRoomMuteData;
import com.tal.app.thinkacademy.live.business.livemessage.entity.LiveBackMessageEntity;
import com.tal.app.thinkacademy.live.business.livemessage.entity.LiveMessagePrivateEntity;
import com.tal.app.thinkacademy.live.business.livemessage.entity.PlayBackMsgBean;
import com.tal.app.thinkacademy.live.business.livemessage.entity.PlayBackMsgEntity;
import com.tal.app.thinkacademy.live.business.livemessage.entity.body.LivePrivateMsgBody;
import com.tal.app.thinkacademy.live.business.livemessage.entity.body.PlayBackMsgBody;
import com.tal.app.thinkacademy.live.business.livemessage.http.LiveMsgApi;
import com.tal.app.thinkacademy.live.business.topic.driver.TopicPluginLiveDriver;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import com.tal.app.thinkacademy.live.core.interfaces.IircControllerProvider;
import com.tal.app.thinkacademy.live.core.irc.entity.MsgBean;
import com.tal.app.thinkacademy.live.core.irc.listener.IIrcListener;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaContext;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaLayoutParams;
import com.tal.app.thinkacademy.live.core.live.abilitypack.AbilityViewModel;
import com.tal.app.thinkacademy.live.core.live.abilitypack.livedata.listener.ListenerData;
import com.tal.app.thinkacademy.live.core.live.datastorage.DataStorage;
import com.tal.app.thinkacademy.live.core.live.http.bean.CourseInfoProxy;
import com.tal.app.thinkacademy.live.core.live.http.bean.EnterConfigProxy;
import com.tal.app.thinkacademy.live.core.live.http.bean.PlanInfoProxy;
import com.tal.app.thinkacademy.live.core.live.http.bean.RtcConfig;
import com.tal.app.thinkacademy.live.core.live.http.bean.TeacherInfo;
import com.tal.app.thinkacademy.live.core.live.http.bean.UserInfoProxy;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventBus;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventData;
import java.lang.ref.WeakReference;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;

@Metadata(d1 = {"\u0000ø\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u001c\u0018\u0000 ¸\u00012\u00020\u0001:\u0002¸\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020\tH\u0002J\u001a\u0010I\u001a\u00020J2\b\u0010K\u001a\u0004\u0018\u00010\t2\u0006\u0010L\u001a\u00020\u0011H\u0002J\"\u0010I\u001a\u00020J2\u0010\u0010M\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010N2\u0006\u0010L\u001a\u00020\u0011H\u0002J\u0010\u0010O\u001a\u00020J2\b\u0010P\u001a\u0004\u0018\u00010\u0006J\u0010\u0010Q\u001a\u00020J2\b\u0010R\u001a\u0004\u0018\u00010SJ\u0010\u0010T\u001a\u00020J2\b\u0010P\u001a\u0004\u0018\u00010\u0006J\u000e\u0010U\u001a\u00020J2\u0006\u0010V\u001a\u00020%J\u0010\u0010W\u001a\u00020J2\u0006\u0010K\u001a\u00020\tH\u0002J\u001a\u0010W\u001a\u00020J2\b\u0010K\u001a\u0004\u0018\u00010\t2\u0006\u0010L\u001a\u00020\u0011H\u0002J\"\u0010W\u001a\u00020J2\u0010\u0010M\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010N2\u0006\u0010L\u001a\u00020\u0011H\u0002J\u0006\u0010X\u001a\u00020\u0011J\b\u0010Y\u001a\u00020\u0011H\u0002J\u001c\u0010Z\u001a\u00020\u00112\b\u0010[\u001a\u0004\u0018\u00010\u00062\b\u0010\\\u001a\u0004\u0018\u00010\u0006H\u0002J\u0006\u0010]\u001a\u00020\u0011J\u0010\u0010^\u001a\u00020\u00112\b\u0010_\u001a\u0004\u0018\u00010\u0006J\u000e\u0010`\u001a\u00020\u00112\u0006\u0010V\u001a\u00020%J\u0006\u0010a\u001a\u00020JJ\u0010\u0010b\u001a\u00020J2\u0006\u0010c\u001a\u00020\u0011H\u0002J&\u0010d\u001a\u00020J2\u0006\u0010e\u001a\u00020\u00062\u0016\b\u0002\u0010f\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020J\u0018\u00010gJ\u0012\u0010h\u001a\u0004\u0018\u00010\u00062\u0006\u0010K\u001a\u00020iH\u0002J\n\u0010j\u001a\u0004\u0018\u00010\u0006H\u0002J\u0006\u0010k\u001a\u000205J\u0018\u0010l\u001a\u00020\u00062\u0006\u0010P\u001a\u00020\u00062\u0006\u0010m\u001a\u00020nH\u0002J\u0018\u0010o\u001a\u00020\u00062\u0006\u0010P\u001a\u00020\u00062\u0006\u0010m\u001a\u00020nH\u0002J\b\u0010p\u001a\u00020\u0006H\u0002J\u0010\u0010q\u001a\u00020\u00062\u0006\u0010r\u001a\u00020\u001bH\u0002J\u0010\u0010s\u001a\u00020\u00062\u0006\u0010K\u001a\u00020iH\u0002J\b\u0010t\u001a\u00020\u0011H\u0002J\u0012\u0010u\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020%0vJ\u0010\u0010w\u001a\u00020\u00112\b\u0010K\u001a\u0004\u0018\u00010\tJ\u0006\u0010x\u001a\u00020JJ\u0006\u0010y\u001a\u00020JJ\u0012\u0010z\u001a\u0004\u0018\u00010\t2\u0006\u0010P\u001a\u000200H\u0002J\u0016\u0010{\u001a\u00020J2\u0006\u0010|\u001a\u00020\u00062\u0006\u0010}\u001a\u00020\u0006J\u0016\u0010~\u001a\u00020J2\u0006\u0010|\u001a\u00020\u00062\u0006\u0010P\u001a\u00020\u0006J\u000e\u0010\u001a\u00020J2\u0006\u0010}\u001a\u00020\u0006J\u000f\u0010\u0001\u001a\u00020J2\u0006\u0010}\u001a\u00020\u0006J\u000f\u0010\u0001\u001a\u00020J2\u0006\u0010}\u001a\u00020\u0006J\u000f\u0010\u0001\u001a\u00020J2\u0006\u0010P\u001a\u00020\u0006J\u000f\u0010\u0001\u001a\u00020J2\u0006\u0010P\u001a\u00020\u0006J\u000f\u0010\u0001\u001a\u00020J2\u0006\u0010P\u001a\u00020\u0006J\t\u0010\u0001\u001a\u00020JH\u0014J\u0007\u0010\u0001\u001a\u00020JJ \u0010\u0001\u001a\u0005\u0018\u00010\u00012\u0007\u0010\u0001\u001a\u00020\u00062\t\u0010\u0001\u001a\u0004\u0018\u00010\u0006H\u0002J\u001f\u0010\u0001\u001a\u0004\u0018\u00010i2\u0007\u0010\u0001\u001a\u00020\u00062\t\u0010\u0001\u001a\u0004\u0018\u00010\u0006H\u0002J \u0010\u0001\u001a\u00020J2\u0017\u0010\u0001\u001a\u0012\u0012\f\u0012\n\u0018\u00010\u0001R\u00030\u0001\u0018\u00010NJ\u0014\u0010\u0001\u001a\u0005\u0018\u00010\u00012\u0006\u0010}\u001a\u00020\u0006H\u0002J\u0013\u0010\u0001\u001a\u0004\u0018\u00010i2\u0006\u0010}\u001a\u00020\u0006H\u0002J\u0013\u0010\u0001\u001a\u0004\u0018\u00010i2\u0006\u0010}\u001a\u00020\u0006H\u0002J\t\u0010\u0001\u001a\u00020JH\u0002J\t\u0010\u0001\u001a\u00020JH\u0002J\u0007\u0010\u0001\u001a\u00020JJ\u001d\u0010\u0001\u001a\u00020J2\u0007\u0010\u0001\u001a\u00020\u00112\t\u0010\u0001\u001a\u0004\u0018\u00010\u0006H\u0002J\u0018\u0010\u0001\u001a\u00020J2\r\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\t0NH\u0002J\u0010\u0010\u0001\u001a\u00020J2\u0007\u0010\u0001\u001a\u00020iJ\u001b\u0010\u0001\u001a\f\u0012\u0005\u0012\u00030\u0001\u0018\u00010\u00012\b\u0010\u0001\u001a\u00030\u0001J\u0017\u0010\u0001\u001a\u00020J2\u0006\u0010P\u001a\u00020\u00062\u0006\u0010m\u001a\u00020nJ\u0017\u0010 \u0001\u001a\u00020J2\u0006\u0010P\u001a\u00020\u00062\u0006\u0010m\u001a\u00020nJ\u0018\u0010¡\u0001\u001a\u00020J2\r\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\t0NH\u0002J\u0018\u0010¢\u0001\u001a\u00020J2\r\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\t0NH\u0002J\t\u0010£\u0001\u001a\u00020JH\u0002J\t\u0010¤\u0001\u001a\u00020JH\u0002J\u0017\u0010¥\u0001\u001a\u00020J2\b\u0010r\u001a\u0004\u0018\u00010\u001b¢\u0006\u0003\u0010¦\u0001J\u0011\u0010§\u0001\u001a\u00020J2\u0006\u0010K\u001a\u00020\tH\u0002J\u0012\u0010¨\u0001\u001a\u00020J2\u0007\u0010©\u0001\u001a\u00020\u0011H\u0002J\u0018\u0010ª\u0001\u001a\u00020J2\r\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\t0NH\u0002J\u0010\u0010«\u0001\u001a\u00020J2\u0007\u0010\u0001\u001a\u00020iJ\u0011\u0010¬\u0001\u001a\u00020J2\u0006\u0010K\u001a\u00020\tH\u0002J\u0011\u0010­\u0001\u001a\u00020J2\u0006\u0010K\u001a\u00020\tH\u0002J\u0011\u0010®\u0001\u001a\u00020J2\u0006\u0010K\u001a\u00020\tH\u0002J\u0012\u0010¯\u0001\u001a\u00020J2\t\u0010°\u0001\u001a\u0004\u0018\u000105J\t\u0010±\u0001\u001a\u00020JH\u0002J\u0007\u0010²\u0001\u001a\u00020JJ\u0010\u0010³\u0001\u001a\u00020J2\u0007\u0010´\u0001\u001a\u00020\u0011J\u0007\u0010µ\u0001\u001a\u00020JJ\u0013\u0010¶\u0001\u001a\u00020J2\b\u0010K\u001a\u0004\u0018\u00010\tH\u0002J\u0013\u0010·\u0001\u001a\u00020J2\b\u0010K\u001a\u0004\u0018\u00010\tH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0004\n\u0002\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R\u0017\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u000e\u0010+\u001a\u00020%XD¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u000e¢\u0006\u0002\n\u0000R&\u0010.\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u000100\u0018\u00010/j\f\u0012\u0006\u0012\u0004\u0018\u000100\u0018\u0001`1X\u000e¢\u0006\u0002\n\u0000R\u0014\u00102\u001a\b\u0012\u0004\u0012\u00020%03X\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000205X\u000e¢\u0006\u0002\n\u0000R\u001a\u00106\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\t07X\u0004¢\u0006\u0002\n\u0000R\u001a\u00108\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\t07X\u0004¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u0004\u0018\u00010;X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010<\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0004\n\u0002\u0010=R\u001c\u0010>\u001a\u0004\u0018\u00010?X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR \u0010D\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\u000b\"\u0004\bF\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bG\u0010H¨\u0006¹\u0001"}, d2 = {"Lcom/tal/app/thinkacademy/live/abilitypack/chatbox/ChatBoxViewModel;", "Lcom/tal/app/thinkacademy/live/core/live/abilitypack/AbilityViewModel;", "provider", "Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;", "(Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;)V", "PRIVATE_MESSAGE_HISTORY_URL", "", "data", "", "Lcom/tal/app/thinkacademy/live/business/chatbox/bean/ChatBoxItemBean;", "getData", "()Ljava/util/List;", "setData", "(Ljava/util/List;)V", "ircListener", "Lcom/tal/app/thinkacademy/live/core/irc/listener/IIrcListener;", "mAllCloseChat", "", "mCloseChat", "Ljava/lang/Boolean;", "mConfigData", "Lcom/tal/app/thinkacademy/live/business/chatbox/bean/ChatBoxConfigBean;", "mContext", "Landroid/content/Context;", "mCourseInfoProxy", "Lcom/tal/app/thinkacademy/live/core/live/http/bean/CourseInfoProxy;", "mCurPage", "", "mEnterConfig", "Lcom/tal/app/thinkacademy/live/core/live/http/bean/EnterConfigProxy;", "mIrcControllerProvider", "Lcom/tal/app/thinkacademy/live/core/interfaces/IircControllerProvider;", "mIsAdding", "mIsAlsoRequestHistory", "mIsOnlySeeTeacherMsg", "mIsRequesting", "mLastSendMsgTime", "", "mListenerBody", "Lcom/tal/app/thinkacademy/live/core/live/abilitypack/livedata/listener/ListenerData;", "Lcom/tal/app/thinkacademy/live/abilitypack/chatbox/listenbody/ChatBoxListenerBody;", "getMListenerBody", "()Lcom/tal/app/thinkacademy/live/core/live/abilitypack/livedata/listener/ListenerData;", "mMsgIntervalControl", "mPlanInfoProxy", "Lcom/tal/app/thinkacademy/live/core/live/http/bean/PlanInfoProxy;", "mPlayBackMsgList", "Ljava/util/ArrayList;", "Lcom/tal/app/thinkacademy/live/business/livemessage/entity/PlayBackMsgEntity;", "Lkotlin/collections/ArrayList;", "mSendQueue", "Ljava/util/ArrayDeque;", "mSendTo", "Lcom/tal/app/thinkacademy/live/business/chatbox/bean/ChatBoxSendToType;", "mSendingMessages", "Ljava/util/HashMap;", "mSendingPrivateMessages", "mSingleCloseChat", "mTeacherInfo", "Lcom/tal/app/thinkacademy/live/core/live/http/bean/TeacherInfo;", "mTotalPage", "Ljava/lang/Integer;", "mUserInfo", "Lcom/tal/app/thinkacademy/live/core/live/http/bean/UserInfoProxy;", "getMUserInfo", "()Lcom/tal/app/thinkacademy/live/core/live/http/bean/UserInfoProxy;", "setMUserInfo", "(Lcom/tal/app/thinkacademy/live/core/live/http/bean/UserInfoProxy;)V", "privateData", "getPrivateData", "setPrivateData", "getProvider", "()Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;", "addData", "", "bean", "isNeedSync", "beans", "", "addMyChatMessage", "msg", "addMyEmojiMessage", "emojiAssembleBean", "Lcom/tal/app/thinkacademy/live/business/emoji/bean/EmojiAssembleBean;", "addMyPrivateChatMessage", "addPlayBackMessage", "seiTimestamp", "addPrivateData", "checkIsCloseChat", "checkIsHasNextPage", "checkIsMyPrivateMsg", "sender", "toUid", "checkIsOnlyPrivate", "checkIsTeacher", "uid", "checkSeiTimestamp", "closeChatBox", "createMuteMsgTips", "isAllStateChanged", "formatInitData", "json", "block", "Lkotlin/Function1;", "getChatGroupMessage", "Lcom/tal/app/thinkacademy/live/business/chatbox/bean/ChatBoxTextMsgBean;", "getChatName", "getCurrentSendTo", "getFeedbackMessage", "parameter", "Lorg/json/JSONObject;", "getHandUpMessage", "getIRCRoomId", "getLevelUpMessage", "level", "getPrivateMessage", "isBigClass", "isFrequently", "Lkotlin/Pair;", "isNeedFilter", "onIrcConnect", "onIrcDisconnect", "onParsePlayBackMessage", "onReceiveLevelMsg", "ircTypeKey", "message", "onReceiveOpenChatMsg", "onReceivePrivateMsg", "onReceiveRoomEmojiMessage", "onReceiveRoomTextMessage", "onReceiveSmallMuteChatMsg", "onReceiveTutorOpenChatMsg", "onTeacherControlMsg", "onVmDestroy", "openChatBox", "parsePlayBackEmojiMessage", "Lcom/tal/app/thinkacademy/live/business/chatbox/bean/ChatBoxEmojiMsgBean;", "text", "ircNickname", "parsePlayBackTextMessage", "parsePrivateHistoryMessage", "list", "Lcom/tal/app/thinkacademy/live/business/livemessage/entity/LiveMessagePrivateEntity$PrivateMessageEntity;", "Lcom/tal/app/thinkacademy/live/business/livemessage/entity/LiveMessagePrivateEntity;", "parseRoomEmojiMessage", "parseRoomPrivateTextMessage", "parseRoomTextMessage", "requestHistoryMessage", "requestHistoryPrivateMessage", "requestPlayBackMessage", "sendChangeChatStatusEvent", "isOpenChat", "sendChangeTeacherControlStatusEvent", "sendChatMessage", "chatBoxItemBean", "sendEmojiMessage", "Lcom/tal/app/thinkacademy/live/business/emoji/bean/EmojiBean;", "", "chatBoxEmojiMsgBean", "sendFeedbackMsg", "sendHandUpMsg", "sendHistoryMessagesEvent", "sendHistoryPrivateMessageEvent", "sendIrcConnectSuccessEvent", "sendIrcDisConnectEvent", "sendLevelUpMsg", "(Ljava/lang/Integer;)V", "sendNewMsgEvent", "sendOnlyPrivateChatEvent", "isOnlyPrivateChat", "sendPlayBackMessageEvent", "sendPrivateChatMessage", "sendPrivateMessageEvent", "sendUpdateMsgStatusEvent", "sendUpdatePrivateMsgStatusEvent", "setSendTo", "sendTo", "showChatBoxRedRot", "showIrcDisconnectStatus", "switchOnlyLookTeacher", "isOnlySeeTeacherMsg", "syncChatBoxViewClosed", "updateSendMsgStatus", "updateSendPrivateMsgStatus", "Companion", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChatBoxViewModel.kt */
public final class ChatBoxViewModel extends AbilityViewModel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Tag TAG = Tag.CHAT_BOX;
    private final String PRIVATE_MESSAGE_HISTORY_URL = "/classroom-hub/classroom/student/peerMessageHistory";
    private List<ChatBoxItemBean> data = new ArrayList();
    private final IIrcListener ircListener;
    private boolean mAllCloseChat;
    private Boolean mCloseChat;
    /* access modifiers changed from: private */
    public ChatBoxConfigBean mConfigData;
    private Context mContext;
    private CourseInfoProxy mCourseInfoProxy;
    /* access modifiers changed from: private */
    public int mCurPage;
    private EnterConfigProxy mEnterConfig;
    private IircControllerProvider mIrcControllerProvider;
    private boolean mIsAdding;
    private boolean mIsAlsoRequestHistory;
    private boolean mIsOnlySeeTeacherMsg;
    /* access modifiers changed from: private */
    public boolean mIsRequesting;
    private long mLastSendMsgTime;
    private final ListenerData<ChatBoxListenerBody> mListenerBody = new ListenerData<>();
    private final long mMsgIntervalControl = 3000;
    private PlanInfoProxy mPlanInfoProxy;
    /* access modifiers changed from: private */
    public ArrayList<PlayBackMsgEntity> mPlayBackMsgList;
    private ArrayDeque<Long> mSendQueue = new ArrayDeque<>();
    private ChatBoxSendToType mSendTo = ChatBoxSendToType.ALL;
    /* access modifiers changed from: private */
    public final HashMap<Long, ChatBoxItemBean> mSendingMessages = new HashMap<>();
    /* access modifiers changed from: private */
    public final HashMap<Long, ChatBoxItemBean> mSendingPrivateMessages = new HashMap<>();
    private boolean mSingleCloseChat;
    private TeacherInfo mTeacherInfo;
    /* access modifiers changed from: private */
    public Integer mTotalPage;
    private UserInfoProxy mUserInfo;
    private List<ChatBoxItemBean> privateData = new ArrayList();
    private final ILiveRoomProvider provider;

    /* access modifiers changed from: protected */
    public void onVmDestroy() {
    }

    public final ILiveRoomProvider getProvider() {
        return this.provider;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChatBoxViewModel(ILiveRoomProvider iLiveRoomProvider) {
        super(iLiveRoomProvider);
        Intrinsics.checkNotNullParameter(iLiveRoomProvider, "provider");
        this.provider = iLiveRoomProvider;
        WeakReference<Context> weakRefContext = iLiveRoomProvider.getWeakRefContext();
        TeacherInfo teacherInfo = null;
        this.mContext = weakRefContext == null ? null : (Context) weakRefContext.get();
        DataStorage dataStorage = iLiveRoomProvider.getDataStorage();
        this.mUserInfo = dataStorage == null ? null : dataStorage.getUserInfo();
        DataStorage dataStorage2 = iLiveRoomProvider.getDataStorage();
        this.mEnterConfig = dataStorage2 == null ? null : dataStorage2.getEnterConfig();
        DataStorage dataStorage3 = iLiveRoomProvider.getDataStorage();
        this.mPlanInfoProxy = dataStorage3 == null ? null : dataStorage3.getPlanInfo();
        DataStorage dataStorage4 = iLiveRoomProvider.getDataStorage();
        this.mCourseInfoProxy = dataStorage4 == null ? null : dataStorage4.getCourseInfo();
        DataStorage dataStorage5 = iLiveRoomProvider.getDataStorage();
        this.mTeacherInfo = dataStorage5 != null ? dataStorage5.getTeacherInfo() : teacherInfo;
        this.ircListener = new ChatBoxViewModel$ircListener$1(this);
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/tal/app/thinkacademy/live/abilitypack/chatbox/ChatBoxViewModel$Companion;", "", "()V", "TAG", "Lcom/tal/app/thinkacademy/live/Tag;", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ChatBoxViewModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final ListenerData<ChatBoxListenerBody> getMListenerBody() {
        return this.mListenerBody;
    }

    public final UserInfoProxy getMUserInfo() {
        return this.mUserInfo;
    }

    public final void setMUserInfo(UserInfoProxy userInfoProxy) {
        this.mUserInfo = userInfoProxy;
    }

    public final List<ChatBoxItemBean> getData() {
        return this.data;
    }

    public final void setData(List<ChatBoxItemBean> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.data = list;
    }

    public final List<ChatBoxItemBean> getPrivateData() {
        return this.privateData;
    }

    public final void setPrivateData(List<ChatBoxItemBean> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.privateData = list;
    }

    public static /* synthetic */ void formatInitData$default(ChatBoxViewModel chatBoxViewModel, String str, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        chatBoxViewModel.formatInitData(str, function1);
    }

    public final void formatInitData(String str, Function1<? super ChatBoxConfigBean, Unit> function1) {
        Intrinsics.checkNotNullParameter(str, "json");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), Dispatchers.getIO(), (CoroutineStart) null, new ChatBoxViewModel$formatInitData$1(str, this, function1, (Continuation<? super ChatBoxViewModel$formatInitData$1>) null), 2, (Object) null);
    }

    public final void openChatBox() {
        XesLog.i(TAG, "打开ChatBox");
        this.mListenerBody.setStickyData(new OpenChatBox());
    }

    public final void closeChatBox() {
        XesLog.i(TAG, "关闭ChatBox");
        this.mListenerBody.setStickyData(new CloseChatBox());
    }

    public final void addMyChatMessage(String str) {
        XesLog.i(TAG, Intrinsics.stringPlus("添加自己的文本群聊消息>>>", str));
        if (str != null) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.mLastSendMsgTime = elapsedRealtime;
            this.mSendQueue.addLast(Long.valueOf(elapsedRealtime));
            ChatBoxTextMsgBean chatBoxTextMsgBean = new ChatBoxTextMsgBean();
            chatBoxTextMsgBean.setMsg(str);
            chatBoxTextMsgBean.setName(getChatName());
            UserInfoProxy mUserInfo2 = getMUserInfo();
            String str2 = null;
            chatBoxTextMsgBean.setPath(mUserInfo2 == null ? null : mUserInfo2.getAvatar());
            chatBoxTextMsgBean.setMsgType(ChatBoxMsgType.ME.name());
            chatBoxTextMsgBean.setSendStatus(ChatBoxSendMsgStatus.DEFAULT.name());
            if (ChatBoxSendToType.PRIVATE == this.mSendTo) {
                chatBoxTextMsgBean.setSendToType(ChatBoxSendToType.PRIVATE);
                TeacherInfo teacherInfo = this.mTeacherInfo;
                if (teacherInfo != null) {
                    str2 = teacherInfo.getId();
                }
                chatBoxTextMsgBean.setToUid(str2);
                HWEventTracking.Companion.get().ostaCbSendMsg("private", "text", str);
            } else if (ChatBoxSendToType.ALL == this.mSendTo) {
                chatBoxTextMsgBean.setSendToType(ChatBoxSendToType.ALL);
                HWEventTracking.Companion.get().ostaCbSendMsg("group", "text", str);
            }
            addData(chatBoxTextMsgBean);
            sendChatMessage(chatBoxTextMsgBean);
        }
    }

    public final void addMyEmojiMessage(EmojiAssembleBean emojiAssembleBean) {
        XesLog.i(TAG, Intrinsics.stringPlus("添加自己的表情群聊消息>>>", GsonUtil.getInstance().objToJson(emojiAssembleBean)));
        if (emojiAssembleBean != null) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.mLastSendMsgTime = elapsedRealtime;
            this.mSendQueue.addLast(Long.valueOf(elapsedRealtime));
            ChatBoxEmojiMsgBean chatBoxEmojiMsgBean = new ChatBoxEmojiMsgBean();
            chatBoxEmojiMsgBean.setEmojiAssembleBean(emojiAssembleBean);
            chatBoxEmojiMsgBean.setEmojiJsonString(GsonUtils.toJson(sendEmojiMessage(chatBoxEmojiMsgBean)));
            chatBoxEmojiMsgBean.setLoop(true);
            chatBoxEmojiMsgBean.setName(getChatName());
            UserInfoProxy mUserInfo2 = getMUserInfo();
            chatBoxEmojiMsgBean.setPath(mUserInfo2 == null ? null : mUserInfo2.getAvatar());
            chatBoxEmojiMsgBean.setMsgType(ChatBoxMsgType.ME_EMOJI.name());
            chatBoxEmojiMsgBean.setSendStatus(ChatBoxSendMsgStatus.DEFAULT.name());
            addData(chatBoxEmojiMsgBean);
            HWEventTracking hWEventTracking = HWEventTracking.Companion.get();
            String emojiName = emojiAssembleBean.getEmojiName();
            if (emojiName == null) {
                emojiName = "";
            }
            hWEventTracking.ostaCbSendMsg("group", "emoji", emojiName);
        }
    }

    public final void addMyPrivateChatMessage(String str) {
        XesLog.i(TAG, Intrinsics.stringPlus("添加辅导私聊消息>>>", str));
        if (str != null) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.mLastSendMsgTime = elapsedRealtime;
            this.mSendQueue.addLast(Long.valueOf(elapsedRealtime));
            ChatBoxTextMsgBean chatBoxTextMsgBean = new ChatBoxTextMsgBean();
            chatBoxTextMsgBean.setMsg(str);
            chatBoxTextMsgBean.setName(getChatName());
            UserInfoProxy mUserInfo2 = getMUserInfo();
            chatBoxTextMsgBean.setPath(mUserInfo2 == null ? null : mUserInfo2.getAvatar());
            chatBoxTextMsgBean.setMsgType(ChatBoxMsgType.ME.name());
            chatBoxTextMsgBean.setSendStatus(ChatBoxSendMsgStatus.DEFAULT.name());
            addPrivateData(chatBoxTextMsgBean);
            sendPrivateChatMessage(chatBoxTextMsgBean);
            HWEventTracking.Companion.get().ostaCbSendMsg("private", "text", str);
        }
    }

    public final Pair<Boolean, Long> isFrequently() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        ChatBoxConfigBean chatBoxConfigBean = this.mConfigData;
        if (chatBoxConfigBean != null) {
            Intrinsics.checkNotNull(chatBoxConfigBean);
            if (chatBoxConfigBean.hasSendControl()) {
                XesLog.i(TAG, "消息配置频控逻辑");
                while (true) {
                    int size = this.mSendQueue.size();
                    ChatBoxConfigBean chatBoxConfigBean2 = this.mConfigData;
                    Intrinsics.checkNotNull(chatBoxConfigBean2);
                    if (size <= chatBoxConfigBean2.getSendMsgCount()) {
                        break;
                    }
                    this.mSendQueue.removeFirst();
                }
                Long first = this.mSendQueue.isEmpty() ? 0L : this.mSendQueue.getFirst();
                int size2 = this.mSendQueue.size();
                Intrinsics.checkNotNullExpressionValue(first, "startSendTimeP");
                ChatBoxConfigBean chatBoxConfigBean3 = this.mConfigData;
                Intrinsics.checkNotNull(chatBoxConfigBean3);
                if (elapsedRealtime - first.longValue() <= ((long) (chatBoxConfigBean3.getSendMsgGap() * 1000))) {
                    ChatBoxConfigBean chatBoxConfigBean4 = this.mConfigData;
                    Intrinsics.checkNotNull(chatBoxConfigBean4);
                    if (size2 >= chatBoxConfigBean4.getSendMsgCount()) {
                        XesLog.i(TAG, "发消息太频繁>>>时间范围" + first + '-' + elapsedRealtime + ",到达" + size2);
                        HWEventTracking.Companion.get().ostaCbInputCooling();
                        ChatBoxConfigBean chatBoxConfigBean5 = this.mConfigData;
                        Intrinsics.checkNotNull(chatBoxConfigBean5);
                        return new Pair<>(true, Long.valueOf(((long) chatBoxConfigBean5.getSendMsgFrozenTime()) * 1000));
                    }
                }
                return new Pair<>(false, 0L);
            }
        }
        Tag tag = TAG;
        XesLog.i(tag, "消息本地频控逻辑");
        if (elapsedRealtime - this.mLastSendMsgTime < this.mMsgIntervalControl) {
            XesLog.i(tag, "发消息太频繁>>>当前时间=" + elapsedRealtime + "，上次发送时间=" + this.mLastSendMsgTime);
            HWEventTracking.Companion.get().ostaCbInputCooling();
            return new Pair<>(true, Long.valueOf(this.mMsgIntervalControl - (elapsedRealtime - this.mLastSendMsgTime)));
        }
        return new Pair<>(false, 0L);
    }

    public final void sendChatMessage(ChatBoxTextMsgBean chatBoxTextMsgBean) {
        Unit unit;
        Intrinsics.checkNotNullParameter(chatBoxTextMsgBean, "chatBoxItemBean");
        Tag tag = TAG;
        XesLog.i(tag, Intrinsics.stringPlus("文本群聊消息>>>", GsonUtil.getInstance().objToJson(chatBoxTextMsgBean)));
        String iRCRoomId = getIRCRoomId();
        if (TextUtils.isEmpty(iRCRoomId)) {
            XesLog.i(tag, "获取聊天Room Id失败");
            return;
        }
        IircControllerProvider iircControllerProvider = this.mIrcControllerProvider;
        if (iircControllerProvider == null) {
            unit = null;
        } else {
            chatBoxTextMsgBean.setSendStatus(ChatBoxSendMsgStatus.SENDING.name());
            long[] jArr = new long[1];
            String chatGroupMessage = getChatGroupMessage(chatBoxTextMsgBean);
            boolean sendMessage = iircControllerProvider.sendMessage(iRCRoomId, chatGroupMessage, jArr);
            XesLog.i(tag, "发送文本群聊消息>>>msg=" + chatGroupMessage + "，preMsgId=" + jArr);
            if (sendMessage) {
                this.mSendingMessages.put(Long.valueOf(jArr[0]), chatBoxTextMsgBean);
            } else {
                XesLog.i(tag, "发送文本群聊消息失败>>>msg=" + chatGroupMessage + "，preMsgId=" + jArr);
                chatBoxTextMsgBean.setSendStatus(ChatBoxSendMsgStatus.FAIL.name());
            }
            updateSendMsgStatus(chatBoxTextMsgBean);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            ChatBoxViewModel chatBoxViewModel = this;
            XesLog.i(tag, "未连接到IRC服务器");
        }
    }

    public final void sendPrivateChatMessage(ChatBoxTextMsgBean chatBoxTextMsgBean) {
        Intrinsics.checkNotNullParameter(chatBoxTextMsgBean, "chatBoxItemBean");
        Tag tag = TAG;
        XesLog.i(tag, Intrinsics.stringPlus("文本私聊消息>>>", GsonUtil.getInstance().objToJson(chatBoxTextMsgBean)));
        EnterConfigProxy enterConfigProxy = this.mEnterConfig;
        String str = null;
        if (TextUtils.isEmpty(enterConfigProxy == null ? null : enterConfigProxy.getTutorIrcId())) {
            XesLog.i(tag, "未获取到辅导老师的昵称");
            return;
        }
        IircControllerProvider iircControllerProvider = this.mIrcControllerProvider;
        if (iircControllerProvider != null) {
            chatBoxTextMsgBean.setSendStatus(ChatBoxSendMsgStatus.SENDING.name());
            long[] jArr = new long[1];
            String privateMessage = getPrivateMessage(chatBoxTextMsgBean);
            EnterConfigProxy enterConfigProxy2 = this.mEnterConfig;
            if (enterConfigProxy2 != null) {
                str = enterConfigProxy2.getTutorIrcId();
            }
            boolean sendPeerMessage = iircControllerProvider.sendPeerMessage(str, privateMessage, 99, jArr);
            XesLog.i(tag, "发送文本私聊消息>>>msg=" + privateMessage + "，preMsgId=" + jArr);
            if (sendPeerMessage) {
                this.mSendingPrivateMessages.put(Long.valueOf(jArr[0]), chatBoxTextMsgBean);
            } else {
                XesLog.i(tag, "发送文本私聊消息失败>>>msg=" + privateMessage + "，preMsgId=" + jArr);
                chatBoxTextMsgBean.setSendStatus(ChatBoxSendMsgStatus.FAIL.name());
            }
            updateSendPrivateMsgStatus(chatBoxTextMsgBean);
            str = Unit.INSTANCE;
        }
        if (str == null) {
            ChatBoxViewModel chatBoxViewModel = this;
            XesLog.i(tag, "未连接到IRC服务器");
        }
    }

    public final EmojiBean<Object> sendEmojiMessage(ChatBoxEmojiMsgBean chatBoxEmojiMsgBean) {
        Intrinsics.checkNotNullParameter(chatBoxEmojiMsgBean, "chatBoxEmojiMsgBean");
        XesLog.i(TAG, Intrinsics.stringPlus("发送表情群聊消息>>>", GsonUtil.getInstance().objToJson(chatBoxEmojiMsgBean)));
        long[] jArr = new long[1];
        chatBoxEmojiMsgBean.setSendStatus(ChatBoxSendMsgStatus.SENDING.name());
        EmojiBean<Object> sendPadEmojiMsg = EmojiUtil.sendPadEmojiMsg(this.provider, chatBoxEmojiMsgBean.getEmojiAssembleBean(), jArr);
        this.mSendingMessages.put(Long.valueOf(jArr[0]), chatBoxEmojiMsgBean);
        updateSendMsgStatus(chatBoxEmojiMsgBean);
        return sendPadEmojiMsg;
    }

    private final void sendNewMsgEvent(ChatBoxItemBean chatBoxItemBean) {
        XesLog.i(TAG, Intrinsics.stringPlus("发送群聊消息通知>>>", GsonUtil.getInstance().objToJson(chatBoxItemBean)));
        this.mListenerBody.setStickyData(new ReceiveChatMessage(chatBoxItemBean));
    }

    private final void sendChangeChatStatusEvent(boolean z, String str) {
        XesLog.i(TAG, "发送开启、关闭聊天通知>>>isOpenChat=" + z + ", text=" + str);
        this.mListenerBody.setStickyData(new ChangeChatStatus(z, str));
    }

    private final void sendChangeTeacherControlStatusEvent(List<? extends ChatBoxItemBean> list) {
        this.mListenerBody.setStickyData(new ChangeTeacherControlStatus(list));
    }

    private final void sendOnlyPrivateChatEvent(boolean z) {
        this.mListenerBody.setStickyData(new OnlyPrivateChatMessage(z));
    }

    private final void sendHistoryPrivateMessageEvent(List<? extends ChatBoxItemBean> list) {
        XesLog.i(TAG, Intrinsics.stringPlus("发送私聊历史消息通知>>>", GsonUtil.getInstance().objToJson(list)));
        this.mListenerBody.setStickyData(new HistoryPrivateMessage(list));
    }

    private final void sendPrivateMessageEvent(ChatBoxItemBean chatBoxItemBean) {
        XesLog.i(TAG, Intrinsics.stringPlus("发送私聊消息通知>>>", GsonUtil.getInstance().objToJson(chatBoxItemBean)));
        this.mListenerBody.setStickyData(new PrivateMessage(chatBoxItemBean));
    }

    private final void sendIrcConnectSuccessEvent() {
        XesLog.i(TAG, "发送IRC连接成功通知");
        this.mListenerBody.setStickyData(new IrcConnectSuccess());
    }

    private final void sendIrcDisConnectEvent() {
        XesLog.i(TAG, "发送IRC断开连接通知");
        this.mListenerBody.setStickyData(new IrcDisConnect());
    }

    private final void sendUpdateMsgStatusEvent(ChatBoxItemBean chatBoxItemBean) {
        XesLog.i(TAG, Intrinsics.stringPlus("发送群聊消息发送状态通知>>>", GsonUtil.getInstance().objToJson(chatBoxItemBean)));
        this.mListenerBody.setStickyData(new UpdateSendMsgStatus(chatBoxItemBean));
    }

    private final void sendUpdatePrivateMsgStatusEvent(ChatBoxItemBean chatBoxItemBean) {
        XesLog.i(TAG, Intrinsics.stringPlus("发送私聊消息发送状态通知>>>", GsonUtil.getInstance().objToJson(chatBoxItemBean)));
        this.mListenerBody.setStickyData(new UpdateSendPrivateMsgStatus(chatBoxItemBean));
    }

    /* access modifiers changed from: private */
    public final void sendHistoryMessagesEvent(List<? extends ChatBoxItemBean> list) {
        XesLog.i(TAG, Intrinsics.stringPlus("发送群聊历史消息通知>>>", GsonUtil.getInstance().objToJson(list)));
        this.mListenerBody.setStickyData(new ReceiveChatHistoryMessage(list));
    }

    public final void syncChatBoxViewClosed() {
        XesLog.i(TAG, "发送ChatBox已关闭通知");
        this.mListenerBody.setStickyData(new ChatBoxViewClosed());
    }

    private final void showChatBoxRedRot() {
        XesLog.i(TAG, "发送显示群聊消息红点通知");
        this.mListenerBody.setStickyData(new ShowChatBoxRedRot());
    }

    public final void onIrcConnect() {
        XesLog.i(TAG, "加入房间成功");
        if (this.mIrcControllerProvider == null) {
            ChatBoxViewModel chatBoxViewModel = this;
            IircControllerProvider ircControllerProvider = getProvider().getIrcControllerProvider();
            this.mIrcControllerProvider = ircControllerProvider;
            if (ircControllerProvider != null) {
                ircControllerProvider.addIrcListener(this.ircListener);
            }
        }
        ChatBoxTipMsgBean chatBoxTipMsgBean = new ChatBoxTipMsgBean();
        chatBoxTipMsgBean.setMsgType(ChatBoxMsgType.SYSTEM.name());
        Context context = this.mContext;
        chatBoxTipMsgBean.setTip(context == null ? null : context.getString(R.string.sucess_con_chat_server));
        addData(chatBoxTipMsgBean);
        sendIrcConnectSuccessEvent();
        if (!this.mIsAlsoRequestHistory) {
            this.mIsAlsoRequestHistory = true;
            requestHistoryMessage();
            requestHistoryPrivateMessage();
        }
    }

    public final void onIrcDisconnect() {
        XesLog.i(TAG, "IRC断开链接");
        ChatBoxTipMsgBean chatBoxTipMsgBean = new ChatBoxTipMsgBean();
        chatBoxTipMsgBean.setMsgType(ChatBoxMsgType.SYSTEM.name());
        Context context = this.mContext;
        chatBoxTipMsgBean.setTip(context == null ? null : context.getString(R.string.disconnecte_server));
        addData(chatBoxTipMsgBean);
        sendIrcDisConnectEvent();
    }

    public final void onReceiveRoomTextMessage(String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        XesLog.i(TAG, Intrinsics.stringPlus("收到群聊消息>>>", str));
        ChatBoxTextMsgBean parseRoomTextMessage = parseRoomTextMessage(str);
        if (parseRoomTextMessage != null) {
            addData(parseRoomTextMessage);
        }
        showChatBoxRedRot();
    }

    public final void onReceivePrivateMsg(String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        XesLog.i(TAG, Intrinsics.stringPlus("收到私聊消息>>>", str));
        ChatBoxTextMsgBean parseRoomPrivateTextMessage = parseRoomPrivateTextMessage(str);
        if (parseRoomPrivateTextMessage != null) {
            addPrivateData(parseRoomPrivateTextMessage);
        }
    }

    private final ChatBoxTextMsgBean parseRoomPrivateTextMessage(String str) {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("peer_chat_msg");
            String optString = optJSONObject.optString("sender");
            JSONObject jSONObject = new JSONObject(optJSONObject.optString("content"));
            String optString2 = jSONObject.optString("msg");
            String optString3 = jSONObject.optString("tutor_avatar");
            String optString4 = jSONObject.optString("name");
            ChatBoxTextMsgBean chatBoxTextMsgBean = new ChatBoxTextMsgBean();
            chatBoxTextMsgBean.setMsg(optString2);
            chatBoxTextMsgBean.setName(optString4);
            chatBoxTextMsgBean.setPath(optString3);
            if (!TextUtils.isEmpty(optString)) {
                EnterConfigProxy enterConfigProxy = this.mEnterConfig;
                if (Intrinsics.areEqual(optString, enterConfigProxy == null ? null : enterConfigProxy.getStuIrcId())) {
                    chatBoxTextMsgBean.setMsgType(ChatBoxMsgType.ME.name());
                    return chatBoxTextMsgBean;
                }
            }
            if (!TextUtils.isEmpty(optString)) {
                Intrinsics.checkNotNullExpressionValue(optString, "sender");
                if (StringsKt.startsWith$default(optString, "s", false, 2, (Object) null)) {
                    chatBoxTextMsgBean.setMsgType(ChatBoxMsgType.OTHER_STUDENT.name());
                    return chatBoxTextMsgBean;
                }
            }
            if (!TextUtils.isEmpty(optString)) {
                Intrinsics.checkNotNullExpressionValue(optString, "sender");
                if (StringsKt.startsWith$default(optString, "t", false, 2, (Object) null)) {
                    chatBoxTextMsgBean.setMsgType(ChatBoxMsgType.TEACHER.name());
                    return chatBoxTextMsgBean;
                }
            }
            if (!TextUtils.isEmpty(optString)) {
                Intrinsics.checkNotNullExpressionValue(optString, "sender");
                if (StringsKt.startsWith$default(optString, "f", false, 2, (Object) null)) {
                    chatBoxTextMsgBean.setMsgType(ChatBoxMsgType.TUTOR.name());
                }
            }
            return chatBoxTextMsgBean;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final void onReceiveRoomEmojiMessage(String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        XesLog.i(TAG, Intrinsics.stringPlus("收到表情群聊消息>>>", str));
        ChatBoxEmojiMsgBean parseRoomEmojiMessage = parseRoomEmojiMessage(str);
        if (parseRoomEmojiMessage != null) {
            addData(parseRoomEmojiMessage);
        }
        showChatBoxRedRot();
    }

    public final void onReceiveTutorOpenChatMsg(String str) {
        String str2;
        Intrinsics.checkNotNullParameter(str, "msg");
        XesLog.i(TAG, Intrinsics.stringPlus("收到辅导禁言某个学员消息>>>", str));
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("peer_mute_chat");
            String str3 = null;
            if (optJSONObject == null) {
                str2 = null;
            } else {
                str2 = optJSONObject.optString("stuId");
            }
            UserInfoProxy userInfoProxy = this.mUserInfo;
            if (userInfoProxy != null) {
                str3 = userInfoProxy.getId();
            }
            if (Intrinsics.areEqual(str2, str3) && optJSONObject.has("mute")) {
                this.mSingleCloseChat = optJSONObject.optBoolean("mute");
                createMuteMsgTips(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0056 A[Catch:{ Exception -> 0x005d }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0057 A[Catch:{ Exception -> 0x005d }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onReceiveSmallMuteChatMsg(java.lang.String r7) {
        /*
            r6 = this;
            java.lang.String r0 = "msg"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            com.tal.app.thinkacademy.live.Tag r0 = TAG
            com.tal.app.thinkacademy.lib.logger.XesLogTag r0 = (com.tal.app.thinkacademy.lib.logger.XesLogTag) r0
            r1 = 1
            java.lang.Object[] r2 = new java.lang.Object[r1]
            java.lang.String r3 = "收到小班禁言某个学员消息>>>"
            java.lang.String r3 = kotlin.jvm.internal.Intrinsics.stringPlus(r3, r7)
            r4 = 0
            r2[r4] = r3
            com.tal.app.thinkacademy.lib.logger.XesLog.i(r0, r2)
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x005d }
            r0.<init>(r7)     // Catch:{ Exception -> 0x005d }
            java.lang.String r7 = "data"
            org.json.JSONObject r7 = r0.optJSONObject(r7)     // Catch:{ Exception -> 0x005d }
            if (r7 != 0) goto L_0x0026
            goto L_0x002e
        L_0x0026:
            java.lang.String r0 = "ids"
            org.json.JSONArray r7 = r7.optJSONArray(r0)     // Catch:{ Exception -> 0x005d }
            if (r7 != 0) goto L_0x0030
        L_0x002e:
            r1 = r4
            goto L_0x0052
        L_0x0030:
            int r0 = r7.length()     // Catch:{ Exception -> 0x005d }
            r2 = r4
        L_0x0035:
            if (r2 >= r0) goto L_0x002e
            int r3 = r2 + 1
            java.lang.String r2 = r7.optString(r2)     // Catch:{ Exception -> 0x005d }
            com.tal.app.thinkacademy.live.core.live.http.bean.UserInfoProxy r5 = r6.getMUserInfo()     // Catch:{ Exception -> 0x005d }
            if (r5 != 0) goto L_0x0045
            r5 = 0
            goto L_0x0049
        L_0x0045:
            java.lang.String r5 = r5.getId()     // Catch:{ Exception -> 0x005d }
        L_0x0049:
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r5)     // Catch:{ Exception -> 0x005d }
            if (r2 == 0) goto L_0x0050
            goto L_0x0052
        L_0x0050:
            r2 = r3
            goto L_0x0035
        L_0x0052:
            boolean r7 = r6.mSingleCloseChat     // Catch:{ Exception -> 0x005d }
            if (r1 != r7) goto L_0x0057
            return
        L_0x0057:
            r6.mSingleCloseChat = r1     // Catch:{ Exception -> 0x005d }
            r6.createMuteMsgTips(r4)     // Catch:{ Exception -> 0x005d }
            goto L_0x0061
        L_0x005d:
            r7 = move-exception
            r7.printStackTrace()
        L_0x0061:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.abilitypack.chatbox.ChatBoxViewModel.onReceiveSmallMuteChatMsg(java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0049, code lost:
        r0 = r0.getRoomData();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onReceiveOpenChatMsg(java.lang.String r6, java.lang.String r7) {
        /*
            r5 = this;
            java.lang.String r0 = "ircTypeKey"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "msg"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            com.tal.app.thinkacademy.live.Tag r0 = TAG
            com.tal.app.thinkacademy.lib.logger.XesLogTag r0 = (com.tal.app.thinkacademy.lib.logger.XesLogTag) r0
            r1 = 1
            java.lang.Object[] r2 = new java.lang.Object[r1]
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "收到老师开启、关闭聊天功能消息>>>msg="
            r3.append(r4)
            r3.append(r7)
            java.lang.String r4 = "，ircTypeKey="
            r3.append(r4)
            r3.append(r6)
            java.lang.String r3 = r3.toString()
            r4 = 0
            r2[r4] = r3
            com.tal.app.thinkacademy.lib.logger.XesLog.i(r0, r2)
            boolean r0 = r5.isBigClass()
            if (r0 == 0) goto L_0x0082
            java.lang.String r0 = "openchat_f"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r6)
            r2 = 0
            if (r0 == 0) goto L_0x005d
            com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider r0 = r5.provider
            com.tal.app.thinkacademy.live.core.live.datastorage.DataStorage r0 = r0.getDataStorage()
            if (r0 != 0) goto L_0x0049
        L_0x0047:
            r0 = r2
            goto L_0x0054
        L_0x0049:
            com.tal.app.thinkacademy.live.core.live.datastorage.RoomData r0 = r0.getRoomData()
            if (r0 != 0) goto L_0x0050
            goto L_0x0047
        L_0x0050:
            java.lang.String r0 = r0.getMode()
        L_0x0054:
            java.lang.String r3 = "in-class"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r0)
            if (r0 == 0) goto L_0x005d
            return
        L_0x005d:
            java.lang.String r0 = "openchat"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r6)
            if (r0 == 0) goto L_0x0082
            com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider r0 = r5.provider
            com.tal.app.thinkacademy.live.core.live.datastorage.DataStorage r0 = r0.getDataStorage()
            if (r0 != 0) goto L_0x006e
            goto L_0x0079
        L_0x006e:
            com.tal.app.thinkacademy.live.core.live.datastorage.RoomData r0 = r0.getRoomData()
            if (r0 != 0) goto L_0x0075
            goto L_0x0079
        L_0x0075:
            java.lang.String r2 = r0.getMode()
        L_0x0079:
            java.lang.String r0 = "in-training"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r2)
            if (r0 == 0) goto L_0x0082
            return
        L_0x0082:
            r0 = r7
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x008c
            return
        L_0x008c:
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x00ab }
            r0.<init>(r7)     // Catch:{ Exception -> 0x00ab }
            boolean r7 = r0.has(r6)     // Catch:{ Exception -> 0x00ab }
            if (r7 == 0) goto L_0x00af
            boolean r6 = r0.optBoolean(r6)     // Catch:{ Exception -> 0x00ab }
            boolean r7 = r5.mAllCloseChat     // Catch:{ Exception -> 0x00ab }
            r0 = r6 ^ 1
            if (r7 != r0) goto L_0x00a2
            return
        L_0x00a2:
            if (r6 != 0) goto L_0x00a5
            r4 = r1
        L_0x00a5:
            r5.mAllCloseChat = r4     // Catch:{ Exception -> 0x00ab }
            r5.createMuteMsgTips(r1)     // Catch:{ Exception -> 0x00ab }
            goto L_0x00af
        L_0x00ab:
            r6 = move-exception
            r6.printStackTrace()
        L_0x00af:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.abilitypack.chatbox.ChatBoxViewModel.onReceiveOpenChatMsg(java.lang.String, java.lang.String):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:65:0x010f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void createMuteMsgTips(boolean r10) {
        /*
            r9 = this;
            boolean r0 = r9.isBigClass()
            r1 = 0
            r2 = 1
            r3 = 0
            if (r0 != 0) goto L_0x00c3
            boolean r0 = r9.mSingleCloseChat
            if (r0 != 0) goto L_0x0014
            boolean r0 = r9.mAllCloseChat
            if (r0 == 0) goto L_0x0012
            goto L_0x0014
        L_0x0012:
            r0 = r1
            goto L_0x0015
        L_0x0014:
            r0 = r2
        L_0x0015:
            com.tal.app.thinkacademy.live.business.chatbox.bean.ChatBoxTipMsgBean r4 = new com.tal.app.thinkacademy.live.business.chatbox.bean.ChatBoxTipMsgBean
            r4.<init>()
            com.tal.app.thinkacademy.live.business.chatbox.bean.ChatBoxMsgType r5 = com.tal.app.thinkacademy.live.business.chatbox.bean.ChatBoxMsgType.TIP
            java.lang.String r5 = r5.name()
            r4.setMsgType(r5)
            java.lang.String r5 = "禁言"
            java.lang.String r6 = "解除禁言"
            if (r10 == 0) goto L_0x0060
            com.tal.app.thinkacademy.live.Tag r10 = TAG
            com.tal.app.thinkacademy.lib.logger.XesLogTag r10 = (com.tal.app.thinkacademy.lib.logger.XesLogTag) r10
            java.lang.Object[] r7 = new java.lang.Object[r2]
            boolean r8 = r9.mSingleCloseChat
            if (r8 == 0) goto L_0x0034
            goto L_0x0035
        L_0x0034:
            r5 = r6
        L_0x0035:
            java.lang.String r6 = "全员禁言状态改变："
            java.lang.String r5 = kotlin.jvm.internal.Intrinsics.stringPlus(r6, r5)
            r7[r1] = r5
            com.tal.app.thinkacademy.lib.logger.XesLog.i(r10, r7)
            boolean r10 = r9.mAllCloseChat
            if (r10 == 0) goto L_0x0050
            android.content.Context r10 = r9.mContext
            if (r10 != 0) goto L_0x0049
            goto L_0x0054
        L_0x0049:
            int r1 = com.tal.app.thinkacademy.live.business.R.string.chatbox_closed_tip
            java.lang.String r10 = r10.getString(r1)
            goto L_0x005c
        L_0x0050:
            android.content.Context r10 = r9.mContext
            if (r10 != 0) goto L_0x0056
        L_0x0054:
            r10 = r3
            goto L_0x005c
        L_0x0056:
            int r1 = com.tal.app.thinkacademy.live.business.R.string.chatbox_open_tip
            java.lang.String r10 = r10.getString(r1)
        L_0x005c:
            r4.setTip(r10)
            goto L_0x0096
        L_0x0060:
            com.tal.app.thinkacademy.live.Tag r10 = TAG
            com.tal.app.thinkacademy.lib.logger.XesLogTag r10 = (com.tal.app.thinkacademy.lib.logger.XesLogTag) r10
            java.lang.Object[] r7 = new java.lang.Object[r2]
            boolean r8 = r9.mSingleCloseChat
            if (r8 == 0) goto L_0x006b
            goto L_0x006c
        L_0x006b:
            r5 = r6
        L_0x006c:
            java.lang.String r6 = "学生个人禁言状态改变："
            java.lang.String r5 = kotlin.jvm.internal.Intrinsics.stringPlus(r6, r5)
            r7[r1] = r5
            com.tal.app.thinkacademy.lib.logger.XesLog.i(r10, r7)
            boolean r10 = r9.mSingleCloseChat
            if (r10 == 0) goto L_0x0087
            android.content.Context r10 = r9.mContext
            if (r10 != 0) goto L_0x0080
            goto L_0x008b
        L_0x0080:
            int r1 = com.tal.app.thinkacademy.live.business.R.string.chatbox_mute_tips
            java.lang.String r10 = r10.getString(r1)
            goto L_0x0093
        L_0x0087:
            android.content.Context r10 = r9.mContext
            if (r10 != 0) goto L_0x008d
        L_0x008b:
            r10 = r3
            goto L_0x0093
        L_0x008d:
            int r1 = com.tal.app.thinkacademy.live.business.R.string.chatbox_unmute_tips
            java.lang.String r10 = r10.getString(r1)
        L_0x0093:
            r4.setTip(r10)
        L_0x0096:
            boolean r10 = r9.mAllCloseChat
            if (r10 == 0) goto L_0x00a6
            android.content.Context r10 = r9.mContext
            if (r10 != 0) goto L_0x009f
            goto L_0x00b8
        L_0x009f:
            int r1 = com.tal.app.thinkacademy.live.business.R.string.chatbox_close
            java.lang.String r3 = r10.getString(r1)
            goto L_0x00b8
        L_0x00a6:
            boolean r10 = r9.mSingleCloseChat
            if (r10 == 0) goto L_0x00b6
            android.content.Context r10 = r9.mContext
            if (r10 != 0) goto L_0x00af
            goto L_0x00b8
        L_0x00af:
            int r1 = com.tal.app.thinkacademy.live.business.R.string.chatbox_input_mute
            java.lang.String r3 = r10.getString(r1)
            goto L_0x00b8
        L_0x00b6:
            java.lang.String r3 = (java.lang.String) r3
        L_0x00b8:
            com.tal.app.thinkacademy.live.business.chatbox.bean.ChatBoxItemBean r4 = (com.tal.app.thinkacademy.live.business.chatbox.bean.ChatBoxItemBean) r4
            r9.addData(r4)
            r10 = r0 ^ 1
            r9.sendChangeChatStatusEvent(r10, r3)
            goto L_0x0118
        L_0x00c3:
            boolean r10 = r9.mSingleCloseChat
            if (r10 != 0) goto L_0x00cb
            boolean r10 = r9.mAllCloseChat
            if (r10 == 0) goto L_0x00cc
        L_0x00cb:
            r1 = r2
        L_0x00cc:
            java.lang.Boolean r10 = r9.mCloseChat
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r1)
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual(r10, r0)
            if (r10 != 0) goto L_0x0118
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r1)
            r9.mCloseChat = r10
            com.tal.app.thinkacademy.live.business.chatbox.bean.ChatBoxTipMsgBean r10 = new com.tal.app.thinkacademy.live.business.chatbox.bean.ChatBoxTipMsgBean
            r10.<init>()
            com.tal.app.thinkacademy.live.business.chatbox.bean.ChatBoxMsgType r0 = com.tal.app.thinkacademy.live.business.chatbox.bean.ChatBoxMsgType.TIP
            java.lang.String r0 = r0.name()
            r10.setMsgType(r0)
            android.content.Context r0 = r9.mContext
            if (r1 != 0) goto L_0x00f6
            if (r0 != 0) goto L_0x00f3
            goto L_0x00f8
        L_0x00f3:
            int r4 = com.tal.app.thinkacademy.live.business.R.string.chatbox_open_tip
            goto L_0x00fc
        L_0x00f6:
            if (r0 != 0) goto L_0x00fa
        L_0x00f8:
            r0 = r3
            goto L_0x0100
        L_0x00fa:
            int r4 = com.tal.app.thinkacademy.live.business.R.string.chatbox_closed_tip
        L_0x00fc:
            java.lang.String r0 = r0.getString(r4)
        L_0x0100:
            r10.setTip(r0)
            com.tal.app.thinkacademy.live.business.chatbox.bean.ChatBoxItemBean r10 = (com.tal.app.thinkacademy.live.business.chatbox.bean.ChatBoxItemBean) r10
            r9.addData(r10)
            r10 = r1 ^ 1
            android.content.Context r0 = r9.mContext
            if (r0 != 0) goto L_0x010f
            goto L_0x0115
        L_0x010f:
            int r1 = com.tal.app.thinkacademy.live.business.R.string.chatbox_close
            java.lang.String r3 = r0.getString(r1)
        L_0x0115:
            r9.sendChangeChatStatusEvent(r10, r3)
        L_0x0118:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.abilitypack.chatbox.ChatBoxViewModel.createMuteMsgTips(boolean):void");
    }

    private final boolean isBigClass() {
        return Intrinsics.areEqual(this.provider.getClassType(), EnterRoomMuteData.STATUS_UN_MUTE) || Intrinsics.areEqual(this.provider.getClassType(), "1");
    }

    public final void onTeacherControlMsg(String str) {
        Intrinsics.checkNotNullParameter(str, "msg");
        XesLog.i(TAG, Intrinsics.stringPlus("收到老师设置学员是否仅可看到老师消息>>>", str));
        if (!TextUtils.isEmpty(str)) {
            try {
                MsgBean msgBean = (MsgBean) GsonUtil.getInstance().fromJson(str, new ChatBoxViewModel$onTeacherControlMsg$type$1().getType());
                if (msgBean != null) {
                    TeacherControlChatBean teacherControlChatBean = (TeacherControlChatBean) msgBean.getData();
                    if (teacherControlChatBean != null) {
                        if (Intrinsics.areEqual(TeacherControlChatBean.STATUS_TEACHER, teacherControlChatBean.getStatus())) {
                            switchOnlyLookTeacher(true);
                            sendOnlyPrivateChatEvent(true);
                        } else if (Intrinsics.areEqual(TeacherControlChatBean.STATUS_ALL, teacherControlChatBean.getStatus())) {
                            switchOnlyLookTeacher(false);
                            sendOnlyPrivateChatEvent(false);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: private */
    public final void updateSendMsgStatus(ChatBoxItemBean chatBoxItemBean) {
        if (chatBoxItemBean != null) {
            sendUpdateMsgStatusEvent(chatBoxItemBean);
        }
    }

    /* access modifiers changed from: private */
    public final void updateSendPrivateMsgStatus(ChatBoxItemBean chatBoxItemBean) {
        if (chatBoxItemBean != null) {
            sendUpdatePrivateMsgStatusEvent(chatBoxItemBean);
        }
    }

    private final String getIRCRoomId() {
        List ircRooms;
        EnterConfigProxy enterConfigProxy = this.mEnterConfig;
        Object obj = "";
        if (!(enterConfigProxy == null || (ircRooms = enterConfigProxy.getIrcRooms()) == null || ircRooms.size() <= 0)) {
            Object obj2 = ircRooms.get(0);
            Intrinsics.checkNotNullExpressionValue(obj2, "ircRooms[0]");
            obj = obj2;
        }
        return (String) obj;
    }

    private final String getChatName() {
        UserInfoProxy userInfoProxy = this.mUserInfo;
        if (!StringUtils.isEmpty(userInfoProxy == null ? null : userInfoProxy.getNickName())) {
            UserInfoProxy userInfoProxy2 = this.mUserInfo;
            if (userInfoProxy2 == null) {
                return null;
            }
            return userInfoProxy2.getNickName();
        }
        UserInfoProxy userInfoProxy3 = this.mUserInfo;
        if (!StringUtils.isEmpty(userInfoProxy3 == null ? null : userInfoProxy3.getName())) {
            UserInfoProxy userInfoProxy4 = this.mUserInfo;
            if (userInfoProxy4 == null) {
                return null;
            }
            return userInfoProxy4.getName();
        }
        UserInfoProxy userInfoProxy5 = this.mUserInfo;
        if (userInfoProxy5 == null) {
            return null;
        }
        return userInfoProxy5.getEnglishName();
    }

    private final String getChatGroupMessage(ChatBoxTextMsgBean chatBoxTextMsgBean) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (chatBoxTextMsgBean.getSendToType() == ChatBoxSendToType.ALL) {
                jSONObject.put("type", LiveBackMessageEntity.MESSAGE_TYPE);
            } else if (chatBoxTextMsgBean.getSendToType() == ChatBoxSendToType.PRIVATE) {
                jSONObject.put("type", "139");
                jSONObject.put("to_uid", chatBoxTextMsgBean.getToUid());
            }
            jSONObject.put("name", chatBoxTextMsgBean.getName());
            jSONObject.put("path", chatBoxTextMsgBean.getPath());
            jSONObject.put("msg", chatBoxTextMsgBean.getMsg());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return !(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject);
    }

    private final void requestHistoryMessage() {
        String iRCRoomId = getIRCRoomId();
        XesLog.i(TAG, Intrinsics.stringPlus("请求群聊历史消息,roomId=", iRCRoomId));
        IircControllerProvider iircControllerProvider = this.mIrcControllerProvider;
        if (iircControllerProvider != null) {
            iircControllerProvider.requestRoomHistoryMessages(iRCRoomId, 0);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0088 A[Catch:{ Exception -> 0x0117 }] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0097 A[Catch:{ Exception -> 0x0117 }] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00a5 A[Catch:{ Exception -> 0x0117 }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00c8 A[Catch:{ Exception -> 0x0117 }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00e6 A[Catch:{ Exception -> 0x0117 }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0104 A[Catch:{ Exception -> 0x0117 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tal.app.thinkacademy.live.business.chatbox.bean.ChatBoxTextMsgBean parseRoomTextMessage(java.lang.String r13) {
        /*
            r12 = this;
            java.lang.String r0 = "ircNickname"
            r1 = 0
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Exception -> 0x0117 }
            r2.<init>(r13)     // Catch:{ Exception -> 0x0117 }
            java.lang.String r13 = "local_chat_msg"
            org.json.JSONObject r13 = r2.optJSONObject(r13)     // Catch:{ Exception -> 0x0117 }
            java.lang.String r2 = "from"
            org.json.JSONObject r2 = r13.optJSONObject(r2)     // Catch:{ Exception -> 0x0117 }
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ Exception -> 0x0117 }
            java.lang.String r4 = "content"
            java.lang.String r13 = r13.optString(r4)     // Catch:{ Exception -> 0x0117 }
            r3.<init>(r13)     // Catch:{ Exception -> 0x0117 }
            java.lang.String r13 = "type"
            java.lang.String r13 = r3.optString(r13)     // Catch:{ Exception -> 0x0117 }
            java.lang.String r4 = "msg"
            java.lang.String r4 = r3.optString(r4)     // Catch:{ Exception -> 0x0117 }
            java.lang.String r5 = "name"
            java.lang.String r5 = r3.optString(r5)     // Catch:{ Exception -> 0x0117 }
            java.lang.String r2 = r2.optString(r0)     // Catch:{ Exception -> 0x0117 }
            r6 = r2
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6     // Catch:{ Exception -> 0x0117 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x0117 }
            java.lang.String r7 = "f"
            java.lang.String r8 = "content.optString(\"path\")"
            java.lang.String r9 = "path"
            r10 = 2
            r11 = 0
            if (r6 != 0) goto L_0x006b
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r0)     // Catch:{ Exception -> 0x0117 }
            boolean r6 = kotlin.text.StringsKt.startsWith$default(r2, r7, r11, r10, r1)     // Catch:{ Exception -> 0x0117 }
            if (r6 == 0) goto L_0x006b
            java.lang.String r6 = r3.optString(r9)     // Catch:{ Exception -> 0x0117 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r8)     // Catch:{ Exception -> 0x0117 }
            r8 = r6
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8     // Catch:{ Exception -> 0x0117 }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ Exception -> 0x0117 }
            if (r8 == 0) goto L_0x0072
            java.lang.String r6 = "tutor_avatar"
            java.lang.String r6 = r3.optString(r6)     // Catch:{ Exception -> 0x0117 }
            java.lang.String r8 = "content.optString(\"tutor_avatar\")"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r8)     // Catch:{ Exception -> 0x0117 }
            goto L_0x0072
        L_0x006b:
            java.lang.String r6 = r3.optString(r9)     // Catch:{ Exception -> 0x0117 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r8)     // Catch:{ Exception -> 0x0117 }
        L_0x0072:
            com.tal.app.thinkacademy.live.business.chatbox.bean.ChatBoxTextMsgBean r8 = new com.tal.app.thinkacademy.live.business.chatbox.bean.ChatBoxTextMsgBean     // Catch:{ Exception -> 0x0117 }
            r8.<init>()     // Catch:{ Exception -> 0x0117 }
            r8.setMsg(r4)     // Catch:{ Exception -> 0x0117 }
            r8.setName(r5)     // Catch:{ Exception -> 0x0117 }
            r8.setPath(r6)     // Catch:{ Exception -> 0x0117 }
            java.lang.String r4 = "139"
            boolean r13 = kotlin.jvm.internal.Intrinsics.areEqual(r13, r4)     // Catch:{ Exception -> 0x0117 }
            if (r13 == 0) goto L_0x0097
            com.tal.app.thinkacademy.live.business.chatbox.bean.ChatBoxSendToType r13 = com.tal.app.thinkacademy.live.business.chatbox.bean.ChatBoxSendToType.PRIVATE     // Catch:{ Exception -> 0x0117 }
            r8.setSendToType(r13)     // Catch:{ Exception -> 0x0117 }
            java.lang.String r13 = "to_uid"
            java.lang.String r13 = r3.optString(r13)     // Catch:{ Exception -> 0x0117 }
            r8.setToUid(r13)     // Catch:{ Exception -> 0x0117 }
            goto L_0x009c
        L_0x0097:
            com.tal.app.thinkacademy.live.business.chatbox.bean.ChatBoxSendToType r13 = com.tal.app.thinkacademy.live.business.chatbox.bean.ChatBoxSendToType.ALL     // Catch:{ Exception -> 0x0117 }
            r8.setSendToType(r13)     // Catch:{ Exception -> 0x0117 }
        L_0x009c:
            r13 = r2
            java.lang.CharSequence r13 = (java.lang.CharSequence) r13     // Catch:{ Exception -> 0x0117 }
            boolean r13 = android.text.TextUtils.isEmpty(r13)     // Catch:{ Exception -> 0x0117 }
            if (r13 != 0) goto L_0x00bf
            com.tal.app.thinkacademy.live.core.live.http.bean.EnterConfigProxy r13 = r12.mEnterConfig     // Catch:{ Exception -> 0x0117 }
            if (r13 != 0) goto L_0x00ab
            r13 = r1
            goto L_0x00af
        L_0x00ab:
            java.lang.String r13 = r13.getStuIrcId()     // Catch:{ Exception -> 0x0117 }
        L_0x00af:
            boolean r13 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r13)     // Catch:{ Exception -> 0x0117 }
            if (r13 == 0) goto L_0x00bf
            com.tal.app.thinkacademy.live.business.chatbox.bean.ChatBoxMsgType r13 = com.tal.app.thinkacademy.live.business.chatbox.bean.ChatBoxMsgType.ME     // Catch:{ Exception -> 0x0117 }
            java.lang.String r13 = r13.name()     // Catch:{ Exception -> 0x0117 }
            r8.setMsgType(r13)     // Catch:{ Exception -> 0x0117 }
            goto L_0x0116
        L_0x00bf:
            r13 = r2
            java.lang.CharSequence r13 = (java.lang.CharSequence) r13     // Catch:{ Exception -> 0x0117 }
            boolean r13 = android.text.TextUtils.isEmpty(r13)     // Catch:{ Exception -> 0x0117 }
            if (r13 != 0) goto L_0x00dd
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r0)     // Catch:{ Exception -> 0x0117 }
            java.lang.String r13 = "s"
            boolean r13 = kotlin.text.StringsKt.startsWith$default(r2, r13, r11, r10, r1)     // Catch:{ Exception -> 0x0117 }
            if (r13 == 0) goto L_0x00dd
            com.tal.app.thinkacademy.live.business.chatbox.bean.ChatBoxMsgType r13 = com.tal.app.thinkacademy.live.business.chatbox.bean.ChatBoxMsgType.OTHER_STUDENT     // Catch:{ Exception -> 0x0117 }
            java.lang.String r13 = r13.name()     // Catch:{ Exception -> 0x0117 }
            r8.setMsgType(r13)     // Catch:{ Exception -> 0x0117 }
            goto L_0x0116
        L_0x00dd:
            r13 = r2
            java.lang.CharSequence r13 = (java.lang.CharSequence) r13     // Catch:{ Exception -> 0x0117 }
            boolean r13 = android.text.TextUtils.isEmpty(r13)     // Catch:{ Exception -> 0x0117 }
            if (r13 != 0) goto L_0x00fb
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r0)     // Catch:{ Exception -> 0x0117 }
            java.lang.String r13 = "t"
            boolean r13 = kotlin.text.StringsKt.startsWith$default(r2, r13, r11, r10, r1)     // Catch:{ Exception -> 0x0117 }
            if (r13 == 0) goto L_0x00fb
            com.tal.app.thinkacademy.live.business.chatbox.bean.ChatBoxMsgType r13 = com.tal.app.thinkacademy.live.business.chatbox.bean.ChatBoxMsgType.TEACHER     // Catch:{ Exception -> 0x0117 }
            java.lang.String r13 = r13.name()     // Catch:{ Exception -> 0x0117 }
            r8.setMsgType(r13)     // Catch:{ Exception -> 0x0117 }
            goto L_0x0116
        L_0x00fb:
            r13 = r2
            java.lang.CharSequence r13 = (java.lang.CharSequence) r13     // Catch:{ Exception -> 0x0117 }
            boolean r13 = android.text.TextUtils.isEmpty(r13)     // Catch:{ Exception -> 0x0117 }
            if (r13 != 0) goto L_0x0116
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r0)     // Catch:{ Exception -> 0x0117 }
            boolean r13 = kotlin.text.StringsKt.startsWith$default(r2, r7, r11, r10, r1)     // Catch:{ Exception -> 0x0117 }
            if (r13 == 0) goto L_0x0116
            com.tal.app.thinkacademy.live.business.chatbox.bean.ChatBoxMsgType r13 = com.tal.app.thinkacademy.live.business.chatbox.bean.ChatBoxMsgType.TUTOR     // Catch:{ Exception -> 0x0117 }
            java.lang.String r13 = r13.name()     // Catch:{ Exception -> 0x0117 }
            r8.setMsgType(r13)     // Catch:{ Exception -> 0x0117 }
        L_0x0116:
            return r8
        L_0x0117:
            r13 = move-exception
            r13.printStackTrace()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.abilitypack.chatbox.ChatBoxViewModel.parseRoomTextMessage(java.lang.String):com.tal.app.thinkacademy.live.business.chatbox.bean.ChatBoxTextMsgBean");
    }

    /* access modifiers changed from: private */
    public final ChatBoxEmojiMsgBean parseRoomEmojiMessage(String str) {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("from");
            String optString = optJSONObject.optString("ircNickname");
            String optString2 = optJSONObject.optString("path");
            String optString3 = optJSONObject.optString("username");
            ChatBoxEmojiMsgBean chatBoxEmojiMsgBean = new ChatBoxEmojiMsgBean();
            chatBoxEmojiMsgBean.setName(optString3);
            chatBoxEmojiMsgBean.setPath(optString2);
            if (!TextUtils.isEmpty(optString)) {
                EnterConfigProxy enterConfigProxy = this.mEnterConfig;
                if (Intrinsics.areEqual(optString, enterConfigProxy == null ? null : enterConfigProxy.getStuIrcId())) {
                    chatBoxEmojiMsgBean.setMsgType(ChatBoxMsgType.ME_EMOJI.name());
                    chatBoxEmojiMsgBean.setEmojiJsonString(GsonUtils.toJson(EmojiBeanUtil.INSTANCE.toEmojiBean(str)));
                    chatBoxEmojiMsgBean.setLoop(true);
                    return chatBoxEmojiMsgBean;
                }
            }
            if (!TextUtils.isEmpty(optString)) {
                Intrinsics.checkNotNullExpressionValue(optString, "ircNickname");
                if (StringsKt.startsWith$default(optString, "s", false, 2, (Object) null)) {
                    chatBoxEmojiMsgBean.setMsgType(ChatBoxMsgType.OTHER_STUDENT_EMOJI.name());
                    chatBoxEmojiMsgBean.setEmojiJsonString(GsonUtils.toJson(EmojiBeanUtil.INSTANCE.toEmojiBean(str)));
                    chatBoxEmojiMsgBean.setLoop(true);
                    return chatBoxEmojiMsgBean;
                }
            }
            if (!TextUtils.isEmpty(optString)) {
                Intrinsics.checkNotNullExpressionValue(optString, "ircNickname");
                if (StringsKt.startsWith$default(optString, "t", false, 2, (Object) null)) {
                    chatBoxEmojiMsgBean.setMsgType(ChatBoxMsgType.TEACHER_EMOJI.name());
                    chatBoxEmojiMsgBean.setEmojiJsonString(GsonUtils.toJson(EmojiBeanUtil.INSTANCE.toEmojiBean(str)));
                    chatBoxEmojiMsgBean.setLoop(true);
                    return chatBoxEmojiMsgBean;
                }
            }
            if (!TextUtils.isEmpty(optString)) {
                Intrinsics.checkNotNullExpressionValue(optString, "ircNickname");
                if (StringsKt.startsWith$default(optString, "f", false, 2, (Object) null)) {
                    chatBoxEmojiMsgBean.setMsgType(ChatBoxMsgType.TUTOR_EMOJI.name());
                }
            }
            chatBoxEmojiMsgBean.setEmojiJsonString(GsonUtils.toJson(EmojiBeanUtil.INSTANCE.toEmojiBean(str)));
            chatBoxEmojiMsgBean.setLoop(true);
            return chatBoxEmojiMsgBean;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final void switchOnlyLookTeacher(boolean z) {
        XesLog.i(TAG, Intrinsics.stringPlus("切换是否仅看老师消息>>>", Boolean.valueOf(z)));
        this.mIsOnlySeeTeacherMsg = z;
    }

    private final void addData(ChatBoxItemBean chatBoxItemBean) {
        addData(chatBoxItemBean, true);
    }

    /* access modifiers changed from: private */
    public final void addData(List<? extends ChatBoxItemBean> list, boolean z) {
        if (list != null && (!list.isEmpty())) {
            for (ChatBoxItemBean chatBoxItemBean : list) {
                if (chatBoxItemBean != null) {
                    addData(chatBoxItemBean, z);
                }
            }
        }
    }

    private final void addPrivateData(List<? extends ChatBoxItemBean> list, boolean z) {
        if (list != null && (!list.isEmpty())) {
            for (ChatBoxItemBean chatBoxItemBean : list) {
                if (chatBoxItemBean != null) {
                    addPrivateData(chatBoxItemBean, z);
                }
            }
        }
    }

    private final void addData(ChatBoxItemBean chatBoxItemBean, boolean z) {
        if (chatBoxItemBean != null) {
            if (this.data == null) {
                this.data = new ArrayList();
            }
            XesLog.i(TAG, Intrinsics.stringPlus("添加群聊消息>>>", GsonUtil.getInstance().objToJson(chatBoxItemBean)));
            this.data.add(chatBoxItemBean);
            if ((!this.mIsOnlySeeTeacherMsg || (!Intrinsics.areEqual(ChatBoxMsgType.OTHER_STUDENT.name(), chatBoxItemBean.getMsgType()) && !Intrinsics.areEqual(ChatBoxMsgType.OTHER_STUDENT_EMOJI.name(), chatBoxItemBean.getMsgType()))) && z) {
                sendNewMsgEvent(chatBoxItemBean);
            }
        }
    }

    public final boolean isNeedFilter(ChatBoxItemBean chatBoxItemBean) {
        if (chatBoxItemBean != null && this.mIsOnlySeeTeacherMsg) {
            return Intrinsics.areEqual(ChatBoxMsgType.OTHER_STUDENT.name(), chatBoxItemBean.getMsgType()) || Intrinsics.areEqual(ChatBoxMsgType.OTHER_STUDENT_EMOJI.name(), chatBoxItemBean.getMsgType());
        }
        return false;
    }

    private final void addPrivateData(ChatBoxItemBean chatBoxItemBean) {
        addPrivateData(chatBoxItemBean, true);
    }

    private final void addPrivateData(ChatBoxItemBean chatBoxItemBean, boolean z) {
        if (chatBoxItemBean != null) {
            if (this.privateData == null) {
                this.privateData = new ArrayList();
            }
            XesLog.i(TAG, Intrinsics.stringPlus("添加私聊消息>>>", GsonUtil.getInstance().objToJson(chatBoxItemBean)));
            this.privateData.add(chatBoxItemBean);
            if ((!this.mIsOnlySeeTeacherMsg || (!Intrinsics.areEqual(ChatBoxMsgType.OTHER_STUDENT.name(), chatBoxItemBean.getMsgType()) && !Intrinsics.areEqual(ChatBoxMsgType.OTHER_STUDENT_EMOJI.name(), chatBoxItemBean.getMsgType()))) && z) {
                sendPrivateMessageEvent(chatBoxItemBean);
            }
        }
    }

    public final void sendLevelUpMsg(Integer num) {
        if (num != null) {
            int intValue = num.intValue();
            String iRCRoomId = getIRCRoomId();
            if (TextUtils.isEmpty(iRCRoomId)) {
                XesLog.i(TAG, "获取聊天Room Id失败");
            }
            IircControllerProvider iircControllerProvider = this.mIrcControllerProvider;
            if (iircControllerProvider != null) {
                String levelUpMessage = getLevelUpMessage(intValue);
                XesLog.i(TAG, Intrinsics.stringPlus("发送徽章等级消息:", levelUpMessage));
                iircControllerProvider.sendMessage(iRCRoomId, levelUpMessage);
            }
        }
    }

    private final String getLevelUpMessage(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "142");
            jSONObject.put("name", getChatName());
            UserInfoProxy userInfoProxy = this.mUserInfo;
            String str = null;
            jSONObject.put("path", userInfoProxy == null ? null : userInfoProxy.getAvatar());
            jSONObject.put("msg", "");
            UserInfo userInfoEntity = UserInfoBll.Companion.getInstance().getUserInfoEntity();
            if (userInfoEntity != null) {
                str = userInfoEntity.getUid();
            }
            jSONObject.put("userId", str);
            jSONObject.put("level", i);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String jSONObject2 = !(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject);
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonObject.toString()");
        return jSONObject2;
    }

    public final void sendHandUpMsg(String str, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(str, "msg");
        Intrinsics.checkNotNullParameter(jSONObject, "parameter");
        EnterConfigProxy enterConfigProxy = this.mEnterConfig;
        String str2 = null;
        if (TextUtils.isEmpty(enterConfigProxy == null ? null : enterConfigProxy.getTutorIrcId())) {
            XesLog.i(TAG, "未获取到辅导老师的昵称");
            return;
        }
        IircControllerProvider iircControllerProvider = this.mIrcControllerProvider;
        if (iircControllerProvider != null) {
            String handUpMessage = getHandUpMessage(str, jSONObject);
            XesLog.i(TAG, Intrinsics.stringPlus("发送举手消息>>>msg=", handUpMessage));
            EnterConfigProxy enterConfigProxy2 = this.mEnterConfig;
            if (enterConfigProxy2 != null) {
                str2 = enterConfigProxy2.getTutorIrcId();
            }
            iircControllerProvider.sendPeerMessage(str2, handUpMessage, 99);
        }
    }

    private final String getHandUpMessage(String str, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("type", "160");
            jSONObject2.put("name", getChatName());
            jSONObject.put("schoolCode", ShareDataManager.getInstance().getString("school_code", "", ShareDataManager.SHAREDATA_NOT_CLEAR));
            PlanInfoProxy planInfoProxy = this.mPlanInfoProxy;
            String str2 = null;
            jSONObject.put("planId", planInfoProxy == null ? null : planInfoProxy.getId());
            CourseInfoProxy courseInfoProxy = this.mCourseInfoProxy;
            jSONObject.put("roomId", courseInfoProxy == null ? null : Integer.valueOf(courseInfoProxy.getClassId()));
            EnterConfigProxy enterConfigProxy = this.mEnterConfig;
            jSONObject.put("studentId", enterConfigProxy == null ? null : enterConfigProxy.getStuIrcId());
            UserInfoProxy userInfoProxy = this.mUserInfo;
            jSONObject.put(LeanplumUtil.uid, userInfoProxy == null ? null : userInfoProxy.getId());
            TeacherInfo teacherInfo = this.mTeacherInfo;
            jSONObject.put("teacherId", teacherInfo == null ? null : teacherInfo.getId());
            TeacherInfo teacherInfo2 = this.mTeacherInfo;
            jSONObject.put("teacherName", teacherInfo2 == null ? null : teacherInfo2.getNickName());
            EnterConfigProxy enterConfigProxy2 = this.mEnterConfig;
            if (enterConfigProxy2 != null) {
                RtcConfig rtcConfig = enterConfigProxy2.getRtcConfig();
                if (rtcConfig != null) {
                    str2 = rtcConfig.getTeacherRoomId();
                }
            }
            jSONObject.put("teacherRoomId", str2);
            jSONObject.put("device", DeviceUtils.getModel());
            jSONObject.put("deviceVersion", DeviceUtils.getSDKVersionName());
            jSONObject.put("AppVersion", "2.19.1");
            jSONObject2.put("parameter", jSONObject);
            jSONObject2.put("msg", str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String jSONObject3 = !(jSONObject2 instanceof JSONObject) ? jSONObject2.toString() : JSONObjectInstrumentation.toString(jSONObject2);
        Intrinsics.checkNotNullExpressionValue(jSONObject3, "jsonObject.toString()");
        return jSONObject3;
    }

    public final void sendFeedbackMsg(String str, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(str, "msg");
        Intrinsics.checkNotNullParameter(jSONObject, "parameter");
        EnterConfigProxy enterConfigProxy = this.mEnterConfig;
        String str2 = null;
        if (TextUtils.isEmpty(enterConfigProxy == null ? null : enterConfigProxy.getTutorIrcId())) {
            XesLog.i(TAG, "未获取到辅导老师的昵称");
            return;
        }
        IircControllerProvider iircControllerProvider = this.mIrcControllerProvider;
        if (iircControllerProvider != null) {
            String feedbackMessage = getFeedbackMessage(str, jSONObject);
            XesLog.i(TAG, Intrinsics.stringPlus("发送问题反馈消息>>>msg=", feedbackMessage));
            EnterConfigProxy enterConfigProxy2 = this.mEnterConfig;
            if (enterConfigProxy2 != null) {
                str2 = enterConfigProxy2.getTutorIrcId();
            }
            iircControllerProvider.sendPeerMessage(str2, feedbackMessage, 99);
        }
    }

    private final String getFeedbackMessage(String str, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("type", "150");
            jSONObject2.put("name", getChatName());
            jSONObject.put("schoolCode", ShareDataManager.getInstance().getString("school_code", "", ShareDataManager.SHAREDATA_NOT_CLEAR));
            PlanInfoProxy planInfoProxy = this.mPlanInfoProxy;
            String str2 = null;
            jSONObject.put("planId", planInfoProxy == null ? null : planInfoProxy.getId());
            CourseInfoProxy courseInfoProxy = this.mCourseInfoProxy;
            jSONObject.put("roomId", courseInfoProxy == null ? null : Integer.valueOf(courseInfoProxy.getClassId()));
            EnterConfigProxy enterConfigProxy = this.mEnterConfig;
            jSONObject.put("studentId", enterConfigProxy == null ? null : enterConfigProxy.getStuIrcId());
            UserInfoProxy userInfoProxy = this.mUserInfo;
            jSONObject.put(LeanplumUtil.uid, userInfoProxy == null ? null : userInfoProxy.getId());
            TeacherInfo teacherInfo = this.mTeacherInfo;
            jSONObject.put("teacherId", teacherInfo == null ? null : teacherInfo.getId());
            TeacherInfo teacherInfo2 = this.mTeacherInfo;
            jSONObject.put("teacherName", teacherInfo2 == null ? null : teacherInfo2.getNickName());
            EnterConfigProxy enterConfigProxy2 = this.mEnterConfig;
            if (enterConfigProxy2 != null) {
                RtcConfig rtcConfig = enterConfigProxy2.getRtcConfig();
                if (rtcConfig != null) {
                    str2 = rtcConfig.getTeacherRoomId();
                }
            }
            jSONObject.put("teacherRoomId", str2);
            jSONObject.put("device", DeviceUtils.getModel());
            jSONObject.put("deviceVersion", DeviceUtils.getSDKVersionName());
            jSONObject.put("AppVersion", "2.19.1");
            jSONObject2.put("parameter", jSONObject);
            jSONObject2.put("msg", str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String jSONObject3 = !(jSONObject2 instanceof JSONObject) ? jSONObject2.toString() : JSONObjectInstrumentation.toString(jSONObject2);
        Intrinsics.checkNotNullExpressionValue(jSONObject3, "jsonObject.toString()");
        return jSONObject3;
    }

    public final void onReceiveLevelMsg(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "ircTypeKey");
        Intrinsics.checkNotNullParameter(str2, "message");
        XesLog.i(TAG, Intrinsics.stringPlus("收到其他学生连对激励等级消息>>>", str2));
        try {
            JSONObject jSONObject = new JSONObject(new JSONObject(str2).optJSONObject(str).optString("content"));
            if (jSONObject.optInt("type") == 142) {
                PluginEventBus.onEvent(DataBusKey.SHOW_OTHER_LEVEL_KEY, new PluginEventData(TopicPluginLiveDriver.class, DataBusKey.SHOW_OTHER_LEVEL_KEY, !(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject)));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private final void requestHistoryPrivateMessage() {
        PlanInfoProxy planInfoProxy = this.mPlanInfoProxy;
        Integer num = null;
        int tryParseInt = ParseUtils.tryParseInt(planInfoProxy == null ? null : planInfoProxy.getId(), 0);
        CourseInfoProxy courseInfoProxy = this.mCourseInfoProxy;
        if (courseInfoProxy != null) {
            num = Integer.valueOf(courseInfoProxy.getTutorId());
        }
        XesLog.i(TAG, "请求私聊历史消息>>>planId=" + tryParseInt + ",tutorId=" + num);
        String stringPlus = Intrinsics.stringPlus(ImConfig.INSTANCE.getOverseaApi(), this.PRIVATE_MESSAGE_HISTORY_URL);
        if (num != null) {
            Call<HiResponse<LiveMessagePrivateEntity>> livePrivateMsg = ((LiveMsgApi) Api.create(LiveMsgApi.class)).getLivePrivateMsg(stringPlus, new LivePrivateMsgBody(tryParseInt, num.intValue()));
            Callback chatBoxViewModel$requestHistoryPrivateMessage$1$1 = new ChatBoxViewModel$requestHistoryPrivateMessage$1$1(this);
            if (!(livePrivateMsg instanceof Call)) {
                livePrivateMsg.enqueue(chatBoxViewModel$requestHistoryPrivateMessage$1$1);
            } else {
                Retrofit2Instrumentation.enqueue((Call) livePrivateMsg, chatBoxViewModel$requestHistoryPrivateMessage$1$1);
            }
        }
    }

    public final void parsePrivateHistoryMessage(List<? extends LiveMessagePrivateEntity.PrivateMessageEntity> list) {
        if (list != null && (!list.isEmpty())) {
            List arrayList = new ArrayList();
            for (LiveMessagePrivateEntity.PrivateMessageEntity privateMessageEntity : list) {
                if (privateMessageEntity != null) {
                    try {
                        JSONObject jSONObject = new JSONObject(privateMessageEntity.getMessage());
                        String optString = jSONObject.optString("type", "");
                        if (Intrinsics.areEqual("131", optString) || Intrinsics.areEqual(LiveBackMessageEntity.MESSAGE_TYPE, optString)) {
                            String optString2 = jSONObject.optString("by", "");
                            String optString3 = jSONObject.optString("name", "");
                            String optString4 = jSONObject.optString("msg", "");
                            String optString5 = jSONObject.optString("tutor_avatar", "");
                            ChatBoxTextMsgBean chatBoxTextMsgBean = new ChatBoxTextMsgBean();
                            chatBoxTextMsgBean.setMsg(optString4);
                            chatBoxTextMsgBean.setName(optString3);
                            chatBoxTextMsgBean.setPath(optString5);
                            if (!TextUtils.isEmpty(optString2)) {
                                EnterConfigProxy enterConfigProxy = this.mEnterConfig;
                                if (Intrinsics.areEqual(optString2, enterConfigProxy == null ? null : enterConfigProxy.getStuIrcId())) {
                                    chatBoxTextMsgBean.setMsgType(ChatBoxMsgType.ME.name());
                                    arrayList.add(chatBoxTextMsgBean);
                                }
                            }
                            if (!TextUtils.isEmpty(optString2)) {
                                Intrinsics.checkNotNullExpressionValue(optString2, "sender");
                                if (StringsKt.startsWith$default(optString2, "s", false, 2, (Object) null)) {
                                    chatBoxTextMsgBean.setMsgType(ChatBoxMsgType.OTHER_STUDENT.name());
                                    arrayList.add(chatBoxTextMsgBean);
                                }
                            }
                            if (!TextUtils.isEmpty(optString2)) {
                                Intrinsics.checkNotNullExpressionValue(optString2, "sender");
                                if (StringsKt.startsWith$default(optString2, "t", false, 2, (Object) null)) {
                                    chatBoxTextMsgBean.setMsgType(ChatBoxMsgType.TEACHER.name());
                                    arrayList.add(chatBoxTextMsgBean);
                                }
                            }
                            if (!TextUtils.isEmpty(optString2)) {
                                Intrinsics.checkNotNullExpressionValue(optString2, "sender");
                                if (StringsKt.startsWith$default(optString2, "f", false, 2, (Object) null)) {
                                    chatBoxTextMsgBean.setMsgType(ChatBoxMsgType.TUTOR.name());
                                }
                            }
                            arrayList.add(chatBoxTextMsgBean);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            if (arrayList.size() > 0) {
                addPrivateData((List<? extends ChatBoxItemBean>) arrayList, false);
                sendHistoryPrivateMessageEvent(arrayList);
            }
        }
    }

    public final void showIrcDisconnectStatus() {
        XesLog.i(TAG, "显示IRC断连状态");
        LiveAreaLayoutParams msgLp = LiveAreaContext.get().getMsgLp();
        if (PadUtils.isPad(Utils.getApp())) {
            ToastUtils.setGravity(48, (-msgLp.width) / 2, -SizeUtils.dp2px(61.0f));
        } else {
            ToastUtils.setGravity(48, (-msgLp.width) / 2, 0);
        }
        Context context = this.mContext;
        if (context != null) {
            ToastUtils.setBgColor(ContextCompat.getColor(context, R.color.color_000000));
            ToastUtils.setMsgColor(ContextCompat.getColor(context, R.color.color_ffffff));
            ToastUtils.showLong(context.getString(R.string.disconnecte_server), new Object[0]);
            ToastUtils.setBgColor(ToastUtils.COLOR_DEFAULT);
        }
    }

    private final String getPrivateMessage(ChatBoxTextMsgBean chatBoxTextMsgBean) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "131");
            jSONObject.put("name", getChatName());
            UserInfoProxy userInfoProxy = this.mUserInfo;
            jSONObject.put("path", userInfoProxy == null ? null : userInfoProxy.getAvatar());
            jSONObject.put("msg", chatBoxTextMsgBean.getMsg());
        } catch (Exception e) {
            e.printStackTrace();
        }
        String jSONObject2 = !(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject);
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonObject.toString()");
        return jSONObject2;
    }

    public final void requestPlayBackMessage() {
        if (!this.mIsRequesting && checkIsHasNextPage()) {
            this.mIsRequesting = true;
            PlanInfoProxy planInfoProxy = this.mPlanInfoProxy;
            String str = null;
            int tryParseInt = ParseUtils.tryParseInt(planInfoProxy == null ? null : planInfoProxy.getId(), 0);
            EnterConfigProxy enterConfigProxy = this.mEnterConfig;
            if (enterConfigProxy != null) {
                str = enterConfigProxy.getIrcRoomId();
            }
            int i = this.mCurPage + 1;
            XesLog.i(TAG, "请求回放群聊消息>>>planId=" + tryParseInt + ",ircRoomId=" + str + ",page=" + i);
            Call<HiResponse<PlayBackMsgBean>> playBackMsg = ((LiveMsgApi) Api.create(LiveMsgApi.class)).getPlayBackMsg(Intrinsics.stringPlus(ImConfig.INSTANCE.getOverseaApi(), "/classroom-hub/playback/student/getRoomHistoryMessage"), new PlayBackMsgBody(str, Integer.valueOf(i), Integer.valueOf(tryParseInt)));
            Callback chatBoxViewModel$requestPlayBackMessage$1 = new ChatBoxViewModel$requestPlayBackMessage$1(this, new ChatBoxViewModel$requestPlayBackMessage$2(this));
            if (!(playBackMsg instanceof Call)) {
                playBackMsg.enqueue(chatBoxViewModel$requestPlayBackMessage$1);
            } else {
                Retrofit2Instrumentation.enqueue((Call) playBackMsg, chatBoxViewModel$requestPlayBackMessage$1);
            }
        }
    }

    public final void addPlayBackMessage(long j) {
        ArrayList<PlayBackMsgEntity> arrayList;
        Long l;
        if (!this.mIsAdding) {
            this.mIsAdding = true;
            List arrayList2 = new ArrayList();
            List arrayList3 = new ArrayList();
            ArrayList<PlayBackMsgEntity> arrayList4 = this.mPlayBackMsgList;
            if (arrayList4 != null) {
                Iterator<PlayBackMsgEntity> it = arrayList4.iterator();
                while (it.hasNext()) {
                    PlayBackMsgEntity next = it.next();
                    if (next == null) {
                        l = null;
                    } else {
                        l = next.getTs();
                    }
                    if (l != null) {
                        if (j < next.getTs().longValue()) {
                            break;
                        }
                        Intrinsics.checkNotNullExpressionValue(next, "playBackMsgEntity");
                        arrayList3.add(next);
                        ChatBoxItemBean onParsePlayBackMessage = onParsePlayBackMessage(next);
                        if (onParsePlayBackMessage != null) {
                            arrayList2.add(onParsePlayBackMessage);
                        }
                    }
                }
            }
            if (arrayList3.size() > 0 && (arrayList = this.mPlayBackMsgList) != null) {
                arrayList.removeAll(arrayList3);
            }
            if (arrayList2.size() > 0) {
                sendPlayBackMessageEvent(arrayList2);
            }
            this.mIsAdding = false;
        }
    }

    private final boolean checkIsHasNextPage() {
        Integer num = this.mTotalPage;
        if (num != null && this.mCurPage >= num.intValue()) {
            return false;
        }
        return true;
    }

    public final boolean checkSeiTimestamp(long j) {
        PlayBackMsgEntity playBackMsgEntity;
        Long ts;
        ArrayList<PlayBackMsgEntity> arrayList = this.mPlayBackMsgList;
        if (arrayList == null || arrayList.size() <= 0 || (playBackMsgEntity = arrayList.get(arrayList.size() - 1)) == null || (ts = playBackMsgEntity.getTs()) == null || ts.longValue() <= j + ((long) 180000)) {
            return true;
        }
        return false;
    }

    private final ChatBoxItemBean onParsePlayBackMessage(PlayBackMsgEntity playBackMsgEntity) {
        String text = playBackMsgEntity.getText();
        if (text == null || TextUtils.isEmpty(text)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(text);
            String optString = jSONObject.optString("type");
            Intrinsics.checkNotNullExpressionValue(optString, "msgJson.optString(\"type\")");
            String optString2 = jSONObject.optString("to_uid");
            Intrinsics.checkNotNullExpressionValue(optString2, "msgJson.optString(\"to_uid\")");
            if (!Intrinsics.areEqual(optString, LiveBackMessageEntity.MESSAGE_TYPE)) {
                if (!Intrinsics.areEqual(optString, "139") || !checkIsMyPrivateMsg(playBackMsgEntity.getSender(), optString2)) {
                    String optString3 = jSONObject.optString("ircType");
                    if (TextUtils.isEmpty(optString3)) {
                        return null;
                    }
                    if (Intrinsics.areEqual(DataBusKey.SEND_EMOJI, optString3) || Intrinsics.areEqual("animation_emoji", optString3)) {
                        return parsePlayBackEmojiMessage(text, playBackMsgEntity.getSender());
                    }
                    return null;
                }
            }
            return parsePlayBackTextMessage(text, playBackMsgEntity.getSender());
        } catch (Throwable th) {
            th.printStackTrace();
            XesLog.i(TAG, "解析回放消息异常");
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037 A[Catch:{ Exception -> 0x010b }] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0070 A[Catch:{ Exception -> 0x010b }] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x007f A[Catch:{ Exception -> 0x010b }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x008d A[Catch:{ Exception -> 0x010b }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00b1 A[Catch:{ Exception -> 0x010b }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00d3 A[Catch:{ Exception -> 0x010b }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00f5 A[ADDED_TO_REGION, Catch:{ Exception -> 0x010b }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.tal.app.thinkacademy.live.business.chatbox.bean.ChatBoxTextMsgBean parsePlayBackTextMessage(java.lang.String r12, java.lang.String r13) {
        /*
            r11 = this;
            r0 = 0
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ Exception -> 0x010b }
            r1.<init>(r12)     // Catch:{ Exception -> 0x010b }
            java.lang.String r12 = "msg"
            java.lang.String r12 = r1.optString(r12)     // Catch:{ Exception -> 0x010b }
            java.lang.String r2 = "type"
            java.lang.String r2 = r1.optString(r2)     // Catch:{ Exception -> 0x010b }
            java.lang.String r3 = "name"
            java.lang.String r3 = r1.optString(r3)     // Catch:{ Exception -> 0x010b }
            r4 = r13
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4     // Catch:{ Exception -> 0x010b }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x010b }
            java.lang.String r5 = "json.optString(\"path\")"
            java.lang.String r6 = "f"
            java.lang.String r7 = "path"
            r8 = 2
            r9 = 1
            r10 = 0
            if (r4 != 0) goto L_0x0053
            if (r13 != 0) goto L_0x002e
        L_0x002c:
            r4 = r10
            goto L_0x0035
        L_0x002e:
            boolean r4 = kotlin.text.StringsKt.startsWith$default(r13, r6, r10, r8, r0)     // Catch:{ Exception -> 0x010b }
            if (r4 != r9) goto L_0x002c
            r4 = r9
        L_0x0035:
            if (r4 == 0) goto L_0x0053
            java.lang.String r4 = r1.optString(r7)     // Catch:{ Exception -> 0x010b }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)     // Catch:{ Exception -> 0x010b }
            r5 = r4
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5     // Catch:{ Exception -> 0x010b }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x010b }
            if (r5 == 0) goto L_0x005a
            java.lang.String r4 = "tutor_avatar"
            java.lang.String r4 = r1.optString(r4)     // Catch:{ Exception -> 0x010b }
            java.lang.String r5 = "json.optString(\"tutor_avatar\")"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)     // Catch:{ Exception -> 0x010b }
            goto L_0x005a
        L_0x0053:
            java.lang.String r4 = r1.optString(r7)     // Catch:{ Exception -> 0x010b }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)     // Catch:{ Exception -> 0x010b }
        L_0x005a:
            com.tal.app.thinkacademy.live.business.chatbox.bean.ChatBoxTextMsgBean r5 = new com.tal.app.thinkacademy.live.business.chatbox.bean.ChatBoxTextMsgBean     // Catch:{ Exception -> 0x010b }
            r5.<init>()     // Catch:{ Exception -> 0x010b }
            r5.setMsg(r12)     // Catch:{ Exception -> 0x010b }
            r5.setName(r3)     // Catch:{ Exception -> 0x010b }
            r5.setPath(r4)     // Catch:{ Exception -> 0x010b }
            java.lang.String r12 = "139"
            boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r12)     // Catch:{ Exception -> 0x010b }
            if (r12 == 0) goto L_0x007f
            com.tal.app.thinkacademy.live.business.chatbox.bean.ChatBoxSendToType r12 = com.tal.app.thinkacademy.live.business.chatbox.bean.ChatBoxSendToType.PRIVATE     // Catch:{ Exception -> 0x010b }
            r5.setSendToType(r12)     // Catch:{ Exception -> 0x010b }
            java.lang.String r12 = "to_uid"
            java.lang.String r12 = r1.optString(r12)     // Catch:{ Exception -> 0x010b }
            r5.setToUid(r12)     // Catch:{ Exception -> 0x010b }
            goto L_0x0084
        L_0x007f:
            com.tal.app.thinkacademy.live.business.chatbox.bean.ChatBoxSendToType r12 = com.tal.app.thinkacademy.live.business.chatbox.bean.ChatBoxSendToType.ALL     // Catch:{ Exception -> 0x010b }
            r5.setSendToType(r12)     // Catch:{ Exception -> 0x010b }
        L_0x0084:
            r12 = r13
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12     // Catch:{ Exception -> 0x010b }
            boolean r12 = android.text.TextUtils.isEmpty(r12)     // Catch:{ Exception -> 0x010b }
            if (r12 != 0) goto L_0x00a8
            com.tal.app.thinkacademy.live.core.live.http.bean.EnterConfigProxy r12 = r11.mEnterConfig     // Catch:{ Exception -> 0x010b }
            if (r12 != 0) goto L_0x0093
            r12 = r0
            goto L_0x0097
        L_0x0093:
            java.lang.String r12 = r12.getStuIrcId()     // Catch:{ Exception -> 0x010b }
        L_0x0097:
            boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual(r13, r12)     // Catch:{ Exception -> 0x010b }
            if (r12 == 0) goto L_0x00a8
            com.tal.app.thinkacademy.live.business.chatbox.bean.ChatBoxMsgType r12 = com.tal.app.thinkacademy.live.business.chatbox.bean.ChatBoxMsgType.ME     // Catch:{ Exception -> 0x010b }
            java.lang.String r12 = r12.name()     // Catch:{ Exception -> 0x010b }
            r5.setMsgType(r12)     // Catch:{ Exception -> 0x010b }
            goto L_0x010a
        L_0x00a8:
            r12 = r13
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12     // Catch:{ Exception -> 0x010b }
            boolean r12 = android.text.TextUtils.isEmpty(r12)     // Catch:{ Exception -> 0x010b }
            if (r12 != 0) goto L_0x00ca
            if (r13 != 0) goto L_0x00b5
        L_0x00b3:
            r12 = r10
            goto L_0x00be
        L_0x00b5:
            java.lang.String r12 = "s"
            boolean r12 = kotlin.text.StringsKt.startsWith$default(r13, r12, r10, r8, r0)     // Catch:{ Exception -> 0x010b }
            if (r12 != r9) goto L_0x00b3
            r12 = r9
        L_0x00be:
            if (r12 == 0) goto L_0x00ca
            com.tal.app.thinkacademy.live.business.chatbox.bean.ChatBoxMsgType r12 = com.tal.app.thinkacademy.live.business.chatbox.bean.ChatBoxMsgType.OTHER_STUDENT     // Catch:{ Exception -> 0x010b }
            java.lang.String r12 = r12.name()     // Catch:{ Exception -> 0x010b }
            r5.setMsgType(r12)     // Catch:{ Exception -> 0x010b }
            goto L_0x010a
        L_0x00ca:
            r12 = r13
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12     // Catch:{ Exception -> 0x010b }
            boolean r12 = android.text.TextUtils.isEmpty(r12)     // Catch:{ Exception -> 0x010b }
            if (r12 != 0) goto L_0x00ec
            if (r13 != 0) goto L_0x00d7
        L_0x00d5:
            r12 = r10
            goto L_0x00e0
        L_0x00d7:
            java.lang.String r12 = "t"
            boolean r12 = kotlin.text.StringsKt.startsWith$default(r13, r12, r10, r8, r0)     // Catch:{ Exception -> 0x010b }
            if (r12 != r9) goto L_0x00d5
            r12 = r9
        L_0x00e0:
            if (r12 == 0) goto L_0x00ec
            com.tal.app.thinkacademy.live.business.chatbox.bean.ChatBoxMsgType r12 = com.tal.app.thinkacademy.live.business.chatbox.bean.ChatBoxMsgType.TEACHER     // Catch:{ Exception -> 0x010b }
            java.lang.String r12 = r12.name()     // Catch:{ Exception -> 0x010b }
            r5.setMsgType(r12)     // Catch:{ Exception -> 0x010b }
            goto L_0x010a
        L_0x00ec:
            r12 = r13
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12     // Catch:{ Exception -> 0x010b }
            boolean r12 = android.text.TextUtils.isEmpty(r12)     // Catch:{ Exception -> 0x010b }
            if (r12 != 0) goto L_0x010a
            if (r13 != 0) goto L_0x00f9
        L_0x00f7:
            r9 = r10
            goto L_0x00ff
        L_0x00f9:
            boolean r12 = kotlin.text.StringsKt.startsWith$default(r13, r6, r10, r8, r0)     // Catch:{ Exception -> 0x010b }
            if (r12 != r9) goto L_0x00f7
        L_0x00ff:
            if (r9 == 0) goto L_0x010a
            com.tal.app.thinkacademy.live.business.chatbox.bean.ChatBoxMsgType r12 = com.tal.app.thinkacademy.live.business.chatbox.bean.ChatBoxMsgType.TUTOR     // Catch:{ Exception -> 0x010b }
            java.lang.String r12 = r12.name()     // Catch:{ Exception -> 0x010b }
            r5.setMsgType(r12)     // Catch:{ Exception -> 0x010b }
        L_0x010a:
            return r5
        L_0x010b:
            r12 = move-exception
            r12.printStackTrace()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.abilitypack.chatbox.ChatBoxViewModel.parsePlayBackTextMessage(java.lang.String, java.lang.String):com.tal.app.thinkacademy.live.business.chatbox.bean.ChatBoxTextMsgBean");
    }

    private final ChatBoxEmojiMsgBean parsePlayBackEmojiMessage(String str, String str2) {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("from");
            String optString = optJSONObject.optString("path");
            String optString2 = optJSONObject.optString("username");
            ChatBoxEmojiMsgBean chatBoxEmojiMsgBean = new ChatBoxEmojiMsgBean();
            chatBoxEmojiMsgBean.setName(optString2);
            chatBoxEmojiMsgBean.setPath(optString);
            if (!TextUtils.isEmpty(str2)) {
                EnterConfigProxy enterConfigProxy = this.mEnterConfig;
                if (Intrinsics.areEqual(str2, enterConfigProxy == null ? null : enterConfigProxy.getStuIrcId())) {
                    chatBoxEmojiMsgBean.setMsgType(ChatBoxMsgType.ME_EMOJI.name());
                    chatBoxEmojiMsgBean.setEmojiJsonString(GsonUtils.toJson(EmojiBeanUtil.INSTANCE.toEmojiBean(str)));
                    chatBoxEmojiMsgBean.setLoop(true);
                    return chatBoxEmojiMsgBean;
                }
            }
            boolean z = false;
            if (!TextUtils.isEmpty(str2)) {
                if (str2 != null && StringsKt.startsWith$default(str2, "s", false, 2, (Object) null)) {
                    chatBoxEmojiMsgBean.setMsgType(ChatBoxMsgType.OTHER_STUDENT_EMOJI.name());
                    chatBoxEmojiMsgBean.setEmojiJsonString(GsonUtils.toJson(EmojiBeanUtil.INSTANCE.toEmojiBean(str)));
                    chatBoxEmojiMsgBean.setLoop(true);
                    return chatBoxEmojiMsgBean;
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                if (str2 != null && StringsKt.startsWith$default(str2, "t", false, 2, (Object) null)) {
                    chatBoxEmojiMsgBean.setMsgType(ChatBoxMsgType.TEACHER_EMOJI.name());
                    chatBoxEmojiMsgBean.setEmojiJsonString(GsonUtils.toJson(EmojiBeanUtil.INSTANCE.toEmojiBean(str)));
                    chatBoxEmojiMsgBean.setLoop(true);
                    return chatBoxEmojiMsgBean;
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                if (str2 != null) {
                    if (StringsKt.startsWith$default(str2, "f", false, 2, (Object) null)) {
                        z = true;
                    }
                }
                if (z) {
                    chatBoxEmojiMsgBean.setMsgType(ChatBoxMsgType.TUTOR_EMOJI.name());
                }
            }
            chatBoxEmojiMsgBean.setEmojiJsonString(GsonUtils.toJson(EmojiBeanUtil.INSTANCE.toEmojiBean(str)));
            chatBoxEmojiMsgBean.setLoop(true);
            return chatBoxEmojiMsgBean;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private final void sendPlayBackMessageEvent(List<? extends ChatBoxItemBean> list) {
        XesLog.i(TAG, Intrinsics.stringPlus("发送回放消息通知>>>", GsonUtil.getInstance().objToJson(list)));
        this.mListenerBody.setStickyData(new PlayBackMessage(list));
    }

    public final void setSendTo(ChatBoxSendToType chatBoxSendToType) {
        if (chatBoxSendToType != null) {
            this.mSendTo = chatBoxSendToType;
        }
    }

    public final ChatBoxSendToType getCurrentSendTo() {
        return this.mSendTo;
    }

    public final boolean checkIsTeacher(String str) {
        if (str == null) {
            return false;
        }
        TeacherInfo teacherInfo = this.mTeacherInfo;
        return Intrinsics.areEqual(teacherInfo == null ? null : teacherInfo.getId(), str);
    }

    private final boolean checkIsMyPrivateMsg(String str, String str2) {
        String id;
        boolean z;
        UserInfoProxy userInfoProxy = this.mUserInfo;
        if (userInfoProxy == null || (id = userInfoProxy.getId()) == null) {
            return false;
        }
        if (str != null && StringsKt.contains$default(str, id, false, 2, (Object) null)) {
            z = true;
        } else {
            z = false;
        }
        if (z || Intrinsics.areEqual(id, str2)) {
            return true;
        }
        return false;
    }

    public final boolean checkIsOnlyPrivate() {
        return this.mIsOnlySeeTeacherMsg;
    }

    public final boolean checkIsCloseChat() {
        Boolean bool = this.mCloseChat;
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }
}
