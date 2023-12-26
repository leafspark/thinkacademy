package com.tal.app.thinkacademy.lib.player.rtcplayer;

import android.content.Context;
import android.os.Handler;
import android.view.SurfaceView;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import com.eaydu.omni.RTCChannel;
import com.eaydu.omni.RTCEngine;
import com.eaydu.omni.listener.RTCConnectionStateType;
import com.google.gson.JsonObject;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.player.Tag;
import com.tal.app.thinkacademy.lib.player.rtcplayer.entity.RtcUserState;
import com.tal.app.thinkacademy.lib.player.track.RtcFailEventType;
import com.tal.app.thinkacademy.lib.player.track.RtcTrackUtil;
import com.tal.app.thinkacademy.lib.util.PathUtils;
import com.tal.app.thinkacademy.lib.util.ThreadUtils;
import com.tal.app.thinkacademy.live.business.livemessage.entity.LiveMessageCode;
import io.agora.rtc.plugin.rawdata.MediaDataObserverPlugin;
import io.agora.rtc.plugin.rawdata.MediaPreProcessing;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata(d1 = {"\u0000Æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\bC\n\u0002\u0010\u0007\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0011\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u0017J\u001a\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020C2\u0007\u0010\u0001\u001a\u00020hJ\u0013\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u001eH\u0002J\u001a\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020C2\u0007\u0010\u0001\u001a\u00020DJ\u001a\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020C2\u0007\u0010\u0001\u001a\u00020eJ\u0011\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020uJ\u0007\u0010\u0001\u001a\u00020\bJ\u0013\u0010\u0001\u001a\u00030\u00012\t\u0010\u0001\u001a\u0004\u0018\u00010CJ\n\u0010\u0001\u001a\u00030\u0001H\u0002J\u0013\u0010\u0001\u001a\u00030\u00012\t\u0010\u0001\u001a\u0004\u0018\u00010YJ\t\u0010\u0001\u001a\u0004\u0018\u00010SJ\n\u0010\u0001\u001a\u00030\u0001H\u0016J#\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u001e2\u0007\u0010\u0001\u001a\u00020$2\u0007\u0010\u0001\u001a\u00020$J\b\u0010\u0001\u001a\u00030\u0001J$\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030 \u00012\u0007\u0010¡\u0001\u001a\u00020C2\u0007\u0010¢\u0001\u001a\u00020CJ#\u0010£\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u001e2\u0007\u0010¤\u0001\u001a\u00020\b2\u0007\u0010¢\u0001\u001a\u00020CJ#\u0010¥\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u001e2\u0007\u0010¤\u0001\u001a\u00020\b2\u0007\u0010¢\u0001\u001a\u00020CJ\u001a\u0010¦\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u001e2\u0007\u0010¢\u0001\u001a\u00020CJ\u001a\u0010§\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u001e2\u0007\u0010¢\u0001\u001a\u00020CJ\u001a\u0010¨\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u001e2\u0007\u0010¢\u0001\u001a\u00020CJ\u001a\u0010©\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u001e2\u0007\u0010¢\u0001\u001a\u00020CJ#\u0010ª\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u001e2\u0007\u0010\u0001\u001a\u00020$2\u0007\u0010¢\u0001\u001a\u00020CJ\u001a\u0010«\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u001e2\u0007\u0010¬\u0001\u001a\u00020$J\u001a\u0010­\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u001e2\u0007\u0010¢\u0001\u001a\u00020CJ\b\u0010®\u0001\u001a\u00030\u0001J\u0011\u0010¯\u0001\u001a\u00030\u00012\u0007\u0010°\u0001\u001a\u00020\bJ\u0007\u0010±\u0001\u001a\u00020$J\t\u0010²\u0001\u001a\u0004\u0018\u00010YJ\t\u0010³\u0001\u001a\u0004\u0018\u00010_J\u0010\u0010´\u0001\u001a\u00020G2\u0007\u0010\u0001\u001a\u00020\u001eJ\u0010\u0010µ\u0001\u001a\u00020\b2\u0007\u0010\u0001\u001a\u00020\u001eJ\u0010\u0010¶\u0001\u001a\u00020\b2\u0007\u0010\u0001\u001a\u00020\u001eJ\u0010\u0010·\u0001\u001a\u00020\b2\u0007\u0010\u0001\u001a\u00020\u001eJ\u0012\u0010¸\u0001\u001a\u0004\u0018\u00010S2\u0007\u0010\u0001\u001a\u00020\u001eJ\u0017\u0010¹\u0001\u001a\u0012\u0012\u0004\u0012\u00020\u001e0\u0016j\b\u0012\u0004\u0012\u00020\u001e`\u0018J\n\u0010º\u0001\u001a\u00030\u0001H\u0002J'\u0010»\u0001\u001a\u00030\u00012\t\u0010\u0001\u001a\u0004\u0018\u00010C2\t\u0010¼\u0001\u001a\u0004\u0018\u00010C2\u0007\u0010½\u0001\u001a\u00020\bJ\u001a\u0010¾\u0001\u001a\u00030\u00012\u0007\u0010¿\u0001\u001a\u00020\u001e2\u0007\u0010À\u0001\u001a\u00020CJ\t\u0010Á\u0001\u001a\u00020\bH\u0016J\t\u0010Â\u0001\u001a\u00020\bH\u0016J\u0010\u0010Ã\u0001\u001a\u00020\b2\u0007\u0010\u0001\u001a\u00020\u001eJ\t\u0010Ä\u0001\u001a\u00020\bH\u0016J\u0010\u0010Å\u0001\u001a\u00020\b2\u0007\u0010\u0001\u001a\u00020\u001eJ\u0010\u0010Æ\u0001\u001a\u00020\b2\u0007\u0010\u0001\u001a\u00020\u001eJ\u0010\u0010Ç\u0001\u001a\u00020\b2\u0007\u0010\u0001\u001a\u00020\u001eJ\u001a\u0010È\u0001\u001a\u00030\u00012\u0007\u0010É\u0001\u001a\u00020$2\u0007\u0010¢\u0001\u001a\u00020CJ\n\u0010Ê\u0001\u001a\u00030\u0001H\u0016J.\u0010Ë\u0001\u001a\u00030\u00012\u0007\u0010Ì\u0001\u001a\u00020\u001e2\u0007\u0010Í\u0001\u001a\u00020\u001e2\t\u0010\u0001\u001a\u0004\u0018\u00010<2\u0007\u0010Î\u0001\u001a\u00020\bJ\n\u0010Ï\u0001\u001a\u00030\u0001H\u0016J\b\u0010Ð\u0001\u001a\u00030\u0001J\b\u0010Ñ\u0001\u001a\u00030\u0001J\u0011\u0010Ò\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u0017J\u0013\u0010Ó\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u001eH\u0002J\u0013\u0010Ô\u0001\u001a\u00030\u00012\t\u0010\u0001\u001a\u0004\u0018\u00010CJ\u0013\u0010Õ\u0001\u001a\u00030\u00012\t\u0010\u0001\u001a\u0004\u0018\u00010CJ\u0011\u0010Ö\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020CJ\u0011\u0010×\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020uJ\u0013\u0010Ø\u0001\u001a\u00030\u00012\t\u0010Ù\u0001\u001a\u0004\u0018\u000106J\u001c\u0010Ú\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u001e2\u0007\u0010\u0001\u001a\u00020GH\u0002J\u001c\u0010Û\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u001e2\u0007\u0010Ü\u0001\u001a\u00020\bH\u0002J'\u0010Ý\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u001e2\u0007\u0010Þ\u0001\u001a\u00020\b2\t\b\u0002\u0010ß\u0001\u001a\u00020\bH\u0002J\u001c\u0010à\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u001e2\u0007\u0010Þ\u0001\u001a\u00020\bH\u0002J\u0011\u0010á\u0001\u001a\u00030\u00012\u0007\u0010â\u0001\u001a\u00020\bJ\u0014\u0010ã\u0001\u001a\u00030\u00012\b\u0010¬\u0001\u001a\u00030ä\u0001H\u0016J\n\u0010å\u0001\u001a\u00030\u0001H\u0016J\u0011\u0010æ\u0001\u001a\u00030\u00012\u0007\u0010ç\u0001\u001a\u00020SJ\b\u0010è\u0001\u001a\u00030\u0001J\u0011\u0010é\u0001\u001a\u00030\u00012\u0007\u0010ê\u0001\u001a\u00020\bJ\u001c\u0010ë\u0001\u001a\u00030\u00012\u0007\u0010ì\u0001\u001a\u00020C2\u0007\u0010í\u0001\u001a\u00020CH\u0002J\u0007\u0010î\u0001\u001a\u00020\bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\u001a\u0010\u0011\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u001a\u0010\u0013\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\fR*\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00170\u0016j\b\u0012\u0004\u0012\u00020\u0017`\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u000e\u0010)\u001a\u00020*X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010,\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\n\"\u0004\b.\u0010\fR\u001a\u0010/\u001a\u00020$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010&\"\u0004\b1\u0010(R\u001a\u00102\u001a\u00020\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010 \"\u0004\b4\u0010\"R\u001c\u00105\u001a\u0004\u0018\u000106X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001c\u0010;\u001a\u0004\u0018\u00010<X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001a\u0010A\u001a\u000e\u0012\u0004\u0012\u00020C\u0012\u0004\u0012\u00020D0BX\u0004¢\u0006\u0002\n\u0000R6\u0010E\u001a\u001e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020G0Fj\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020G`HX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u000e\u0010M\u001a\u00020NX\u000e¢\u0006\u0002\n\u0000R*\u0010O\u001a\u0012\u0012\u0004\u0012\u00020\u001e0\u0016j\b\u0012\u0004\u0012\u00020\u001e`\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010\u001a\"\u0004\bQ\u0010\u001cR\u001c\u0010R\u001a\u0004\u0018\u00010SX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR\u001c\u0010X\u001a\u0004\u0018\u00010YX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R\u001c\u0010^\u001a\u0004\u0018\u00010_X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR\u000e\u0010d\u001a\u00020eX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010f\u001a\u000e\u0012\u0004\u0012\u00020C\u0012\u0004\u0012\u00020e0BX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010g\u001a\u000e\u0012\u0004\u0012\u00020C\u0012\u0004\u0012\u00020h0BX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010i\u001a\u0004\u0018\u00010CX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bj\u0010k\"\u0004\bl\u0010mR\u001c\u0010n\u001a\u0004\u0018\u00010CX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bo\u0010k\"\u0004\bp\u0010mR\u001a\u0010q\u001a\u00020\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\br\u0010 \"\u0004\bs\u0010\"R*\u0010t\u001a\u0012\u0012\u0004\u0012\u00020u0\u0016j\b\u0012\u0004\u0012\u00020u`\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bv\u0010\u001a\"\u0004\bw\u0010\u001cR\u001a\u0010x\u001a\u00020\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\by\u0010 \"\u0004\bz\u0010\"R\u001a\u0010{\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b|\u0010\n\"\u0004\b}\u0010\fR\u001d\u0010~\u001a\u00020NX\u000e¢\u0006\u0011\n\u0000\u001a\u0005\b\u0010\u0001\"\u0006\b\u0001\u0010\u0001R\u001d\u0010\u0001\u001a\u00020\bX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\n\"\u0005\b\u0001\u0010\f¨\u0006ï\u0001"}, d2 = {"Lcom/tal/app/thinkacademy/lib/player/rtcplayer/RtcPlayer;", "Lcom/tal/app/thinkacademy/lib/player/rtcplayer/IRTCMediaPlayer;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "TAG", "Lcom/tal/app/thinkacademy/lib/player/Tag;", "audioTeacherJoined", "", "getAudioTeacherJoined", "()Z", "setAudioTeacherJoined", "(Z)V", "getContext", "()Landroid/content/Context;", "isRtcInit", "setRtcInit", "isRtcPause", "setRtcPause", "isRtcPlaying", "setRtcPlaying", "mAudioProcessListener", "Ljava/util/ArrayList;", "Lcom/tal/app/thinkacademy/lib/player/rtcplayer/IRTCMediaAudioProcess;", "Lkotlin/collections/ArrayList;", "getMAudioProcessListener", "()Ljava/util/ArrayList;", "setMAudioProcessListener", "(Ljava/util/ArrayList;)V", "mAudioTeacherId", "", "getMAudioTeacherId", "()J", "setMAudioTeacherId", "(J)V", "mCurrentVolume", "", "getMCurrentVolume", "()I", "setMCurrentVolume", "(I)V", "mIRtcEngineEventListener", "Lcom/eaydu/omni/RTCEngine$IRtcEngineEventListener;", "mIsAuditor", "mIsExquisite", "getMIsExquisite", "setMIsExquisite", "mNetworkQuality", "getMNetworkQuality", "setMNetworkQuality", "mPcTeacherUid", "getMPcTeacherUid", "setMPcTeacherUid", "mPlayEventListener", "Lcom/tal/app/thinkacademy/lib/player/rtcplayer/RtcPlayEventListener;", "getMPlayEventListener", "()Lcom/tal/app/thinkacademy/lib/player/rtcplayer/RtcPlayEventListener;", "setMPlayEventListener", "(Lcom/tal/app/thinkacademy/lib/player/rtcplayer/RtcPlayEventListener;)V", "mPrePlayEventListener", "Lcom/tal/app/thinkacademy/lib/player/rtcplayer/RtcPlayPrePlayEventListener;", "getMPrePlayEventListener", "()Lcom/tal/app/thinkacademy/lib/player/rtcplayer/RtcPlayPrePlayEventListener;", "setMPrePlayEventListener", "(Lcom/tal/app/thinkacademy/lib/player/rtcplayer/RtcPlayPrePlayEventListener;)V", "mRTCEngineCreateListener", "", "", "Lcom/tal/app/thinkacademy/lib/player/rtcplayer/RTCEngineCreateListener;", "mRemoteHashMap", "Ljava/util/HashMap;", "Lcom/tal/app/thinkacademy/lib/player/rtcplayer/entity/RtcUserState;", "Lkotlin/collections/HashMap;", "getMRemoteHashMap", "()Ljava/util/HashMap;", "setMRemoteHashMap", "(Ljava/util/HashMap;)V", "mRemoteMapSync", "", "mRemoteUserList", "getMRemoteUserList", "setMRemoteUserList", "mRendererView", "Landroid/view/SurfaceView;", "getMRendererView", "()Landroid/view/SurfaceView;", "setMRendererView", "(Landroid/view/SurfaceView;)V", "mRtcEngine", "Lcom/eaydu/omni/RTCEngine;", "getMRtcEngine", "()Lcom/eaydu/omni/RTCEngine;", "setMRtcEngine", "(Lcom/eaydu/omni/RTCEngine;)V", "mRtcEngineChannel", "Lcom/eaydu/omni/RTCChannel;", "getMRtcEngineChannel", "()Lcom/eaydu/omni/RTCChannel;", "setMRtcEngineChannel", "(Lcom/eaydu/omni/RTCChannel;)V", "mRtcEngineEventObserver", "Lcom/eaydu/omni/RTCEngine$RtcEngineEventObserver;", "mRtcEngineEventObservers", "mRtcEngineListeners", "Lcom/tal/app/thinkacademy/lib/player/rtcplayer/RtcPlayerEngineEventListener;", "mStuToken", "getMStuToken", "()Ljava/lang/String;", "setMStuToken", "(Ljava/lang/String;)V", "mToken", "getMToken", "setMToken", "mTutorUid", "getMTutorUid", "setMTutorUid", "mVideoProcessListener", "Lcom/tal/app/thinkacademy/lib/player/rtcplayer/IRTCMediaVideoProcess;", "getMVideoProcessListener", "setMVideoProcessListener", "mVideoTeacherId", "getMVideoTeacherId", "setMVideoTeacherId", "rtcIsReconnecting", "getRtcIsReconnecting", "setRtcIsReconnecting", "userSyncObject", "getUserSyncObject", "()Ljava/lang/Object;", "setUserSyncObject", "(Ljava/lang/Object;)V", "videoTeacherJoined", "getVideoTeacherJoined", "setVideoTeacherJoined", "addAudioProcessObserver", "", "audioProcessListener", "addEtcEngineEventListener", "tag", "listener", "addRemoteUser", "uid", "addRtcEngineCreateListener", "addRtcEngineEventObserver", "addVideoProcessObserver", "videoProcessListener", "audioTeacherIsJoined", "changeMode", "token", "clearRemoteUser", "createRtcPlayerEngine", "rtcEngine", "createSurfaceView", "destroyPlayer", "disPatchNetworkQuality", "txQuality", "rxQuality", "disableLastMileProbeTest", "dispatchConnectionState", "state", "Lcom/eaydu/omni/listener/RTCConnectionStateType;", "reason", "type", "dispatchDidAudioMuted", "muted", "dispatchDidVideoMuted", "dispatchOfflineOfUid", "dispatchRemoteFirstAudioRecvWithUid", "dispatchRemoteFirstVideoRecvWithUid", "dispatchRemoteUserJoinWitnUid", "dispatchRemoteVideoStateChanged", "dispatchReportAudioVolumeOfSpeaker", "volume", "dispatchlocalUserJoindWithUid", "enableLastMileProbeTest", "enableLocalStream", "enable", "getOnceLastMileQuality", "getRTCEngine", "getRTCEngineChannel", "getRemoteState", "getRemoteStateOnLine", "getRemoteStateOpenCamera", "getRemoteStateOpenMic", "getRemoteSurfaceView", "getRemoteUsers", "initEngineChannel", "initPlay", "stuToken", "isExquisite", "initPlayWithoutToken", "userId", "appId", "isInit", "isPause", "isPcTeacher", "isPlaying", "isTargeAudioUser", "isTargeTutorUser", "isTargeVideotUser", "onRtcEngineOnceLastMileQuality", "quality", "pausePlay", "prePlay", "videoTeacherId", "audioTeacherId", "isAuditor", "reStart", "removeAllAudioProcessObserver", "removeAllVideoProcessObserver", "removeAudioProcessObserver", "removeRemoteUser", "removeRtcEngineCreateListener", "removeRtcEngineEventListener", "removeRtcEngineEventObserver", "removeVideoProcessObserver", "setPlayEventListener", "eventListener", "setRemoteState", "setRemoteStateOnLine", "isOnline", "setRemoteStateOpenCamera", "isOpen", "isFore", "setRemoteStateOpenMic", "setVideoBitrate", "isHigh", "setVolume", "", "startPlay", "startPreview", "surfaceView", "stopPreview", "switchTeacherModel", "isPc", "trackLog", "property", "value", "videoTeacherIsJoined", "lib_player_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RtcPlayer.kt */
public final class RtcPlayer implements IRTCMediaPlayer {
    /* access modifiers changed from: private */
    public final Tag TAG = Tag.RTC_BASE;
    private boolean audioTeacherJoined;
    private final Context context;
    private boolean isRtcInit;
    private boolean isRtcPause;
    private boolean isRtcPlaying;
    private ArrayList<IRTCMediaAudioProcess> mAudioProcessListener = new ArrayList<>();
    private long mAudioTeacherId;
    private int mCurrentVolume = 100;
    private final RTCEngine.IRtcEngineEventListener mIRtcEngineEventListener = new RtcPlayer$mIRtcEngineEventListener$1(this);
    private boolean mIsAuditor;
    private boolean mIsExquisite;
    private int mNetworkQuality = 1;
    private long mPcTeacherUid = -1;
    private RtcPlayEventListener mPlayEventListener;
    private RtcPlayPrePlayEventListener mPrePlayEventListener;
    private final Map<String, RTCEngineCreateListener> mRTCEngineCreateListener = new ConcurrentHashMap();
    private HashMap<Long, RtcUserState> mRemoteHashMap = new HashMap<>();
    private Object mRemoteMapSync = new Object();
    private ArrayList<Long> mRemoteUserList = new ArrayList<>();
    private SurfaceView mRendererView;
    private RTCEngine mRtcEngine;
    private RTCChannel mRtcEngineChannel;
    private final RTCEngine.RtcEngineEventObserver mRtcEngineEventObserver = new RtcPlayer$mRtcEngineEventObserver$1(this);
    private final Map<String, RTCEngine.RtcEngineEventObserver> mRtcEngineEventObservers = new ConcurrentHashMap();
    private final Map<String, RtcPlayerEngineEventListener> mRtcEngineListeners = new ConcurrentHashMap();
    private String mStuToken;
    private String mToken;
    private long mTutorUid = -1;
    private ArrayList<IRTCMediaVideoProcess> mVideoProcessListener = new ArrayList<>();
    private long mVideoTeacherId;
    private boolean rtcIsReconnecting;
    private Object userSyncObject = new Object();
    private boolean videoTeacherJoined;

    public RtcPlayer(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    public final Context getContext() {
        return this.context;
    }

    public final RtcPlayEventListener getMPlayEventListener() {
        return this.mPlayEventListener;
    }

    public final void setMPlayEventListener(RtcPlayEventListener rtcPlayEventListener) {
        this.mPlayEventListener = rtcPlayEventListener;
    }

    public final boolean getMIsExquisite() {
        return this.mIsExquisite;
    }

    public final void setMIsExquisite(boolean z) {
        this.mIsExquisite = z;
    }

    public final long getMPcTeacherUid() {
        return this.mPcTeacherUid;
    }

    public final void setMPcTeacherUid(long j) {
        this.mPcTeacherUid = j;
    }

    public final long getMTutorUid() {
        return this.mTutorUid;
    }

    public final void setMTutorUid(long j) {
        this.mTutorUid = j;
    }

    public final String getMToken() {
        return this.mToken;
    }

    public final void setMToken(String str) {
        this.mToken = str;
    }

    public final String getMStuToken() {
        return this.mStuToken;
    }

    public final void setMStuToken(String str) {
        this.mStuToken = str;
    }

    public final long getMVideoTeacherId() {
        return this.mVideoTeacherId;
    }

    public final void setMVideoTeacherId(long j) {
        this.mVideoTeacherId = j;
    }

    public final long getMAudioTeacherId() {
        return this.mAudioTeacherId;
    }

    public final void setMAudioTeacherId(long j) {
        this.mAudioTeacherId = j;
    }

    public final RTCEngine getMRtcEngine() {
        return this.mRtcEngine;
    }

    public final void setMRtcEngine(RTCEngine rTCEngine) {
        this.mRtcEngine = rTCEngine;
    }

    public final RTCChannel getMRtcEngineChannel() {
        return this.mRtcEngineChannel;
    }

    public final void setMRtcEngineChannel(RTCChannel rTCChannel) {
        this.mRtcEngineChannel = rTCChannel;
    }

    public final SurfaceView getMRendererView() {
        return this.mRendererView;
    }

    public final void setMRendererView(SurfaceView surfaceView) {
        this.mRendererView = surfaceView;
    }

    public final boolean isRtcPause() {
        return this.isRtcPause;
    }

    public final void setRtcPause(boolean z) {
        this.isRtcPause = z;
    }

    public final boolean getAudioTeacherJoined() {
        return this.audioTeacherJoined;
    }

    public final void setAudioTeacherJoined(boolean z) {
        this.audioTeacherJoined = z;
    }

    public final boolean getVideoTeacherJoined() {
        return this.videoTeacherJoined;
    }

    public final void setVideoTeacherJoined(boolean z) {
        this.videoTeacherJoined = z;
    }

    public final RtcPlayPrePlayEventListener getMPrePlayEventListener() {
        return this.mPrePlayEventListener;
    }

    public final void setMPrePlayEventListener(RtcPlayPrePlayEventListener rtcPlayPrePlayEventListener) {
        this.mPrePlayEventListener = rtcPlayPrePlayEventListener;
    }

    public final boolean isRtcInit() {
        return this.isRtcInit;
    }

    public final void setRtcInit(boolean z) {
        this.isRtcInit = z;
    }

    public final int getMCurrentVolume() {
        return this.mCurrentVolume;
    }

    public final void setMCurrentVolume(int i) {
        this.mCurrentVolume = i;
    }

    public final int getMNetworkQuality() {
        return this.mNetworkQuality;
    }

    public final void setMNetworkQuality(int i) {
        this.mNetworkQuality = i;
    }

    public final boolean getRtcIsReconnecting() {
        return this.rtcIsReconnecting;
    }

    public final void setRtcIsReconnecting(boolean z) {
        this.rtcIsReconnecting = z;
    }

    public final boolean isRtcPlaying() {
        return this.isRtcPlaying;
    }

    public final void setRtcPlaying(boolean z) {
        this.isRtcPlaying = z;
    }

    public final ArrayList<IRTCMediaVideoProcess> getMVideoProcessListener() {
        return this.mVideoProcessListener;
    }

    public final void setMVideoProcessListener(ArrayList<IRTCMediaVideoProcess> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.mVideoProcessListener = arrayList;
    }

    public final ArrayList<IRTCMediaAudioProcess> getMAudioProcessListener() {
        return this.mAudioProcessListener;
    }

    public final void setMAudioProcessListener(ArrayList<IRTCMediaAudioProcess> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.mAudioProcessListener = arrayList;
    }

    public final ArrayList<Long> getMRemoteUserList() {
        return this.mRemoteUserList;
    }

    public final void setMRemoteUserList(ArrayList<Long> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.mRemoteUserList = arrayList;
    }

    public final Object getUserSyncObject() {
        return this.userSyncObject;
    }

    public final void setUserSyncObject(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "<set-?>");
        this.userSyncObject = obj;
    }

    public final HashMap<Long, RtcUserState> getMRemoteHashMap() {
        return this.mRemoteHashMap;
    }

    public final void setMRemoteHashMap(HashMap<Long, RtcUserState> hashMap) {
        Intrinsics.checkNotNullParameter(hashMap, "<set-?>");
        this.mRemoteHashMap = hashMap;
    }

    public final RtcUserState getRemoteState(long j) {
        RtcUserState rtcUserState;
        synchronized (this.mRemoteMapSync) {
            rtcUserState = getMRemoteHashMap().get(Long.valueOf(j));
            if (rtcUserState == null) {
                rtcUserState = new RtcUserState(false, false, 0, 7, (DefaultConstructorMarker) null);
                getMRemoteHashMap().put(Long.valueOf(j), rtcUserState);
            }
        }
        return rtcUserState;
    }

    public final SurfaceView getRemoteSurfaceView(long j) {
        SurfaceView mSurfaceView;
        synchronized (this.mRemoteMapSync) {
            RtcUserState rtcUserState = getMRemoteHashMap().get(Long.valueOf(j));
            if (rtcUserState == null) {
                rtcUserState = new RtcUserState(false, false, 0, 7, (DefaultConstructorMarker) null);
                getMRemoteHashMap().put(Long.valueOf(j), rtcUserState);
            }
            if (rtcUserState.getMSurfaceView() == null) {
                RTCEngine mRtcEngine2 = getMRtcEngine();
                rtcUserState.setMSurfaceView(mRtcEngine2 == null ? null : mRtcEngine2.createRendererView());
            }
            SurfaceView mSurfaceView2 = rtcUserState.getMSurfaceView();
            if (mSurfaceView2 != null) {
                mSurfaceView2.setZOrderMediaOverlay(false);
            }
            mSurfaceView = rtcUserState.getMSurfaceView();
        }
        return mSurfaceView;
    }

    private final void setRemoteState(long j, RtcUserState rtcUserState) {
        synchronized (this.mRemoteMapSync) {
            getMRemoteHashMap().put(Long.valueOf(j), rtcUserState);
        }
    }

    public final boolean getRemoteStateOnLine(long j) {
        return getRemoteState(j).getMIsOnline();
    }

    public final boolean getRemoteStateOpenMic(long j) {
        return getRemoteState(j).getMIsOpenMic();
    }

    public final boolean getRemoteStateOpenCamera(long j) {
        return getRemoteState(j).getMIsOpenCamera();
    }

    /* access modifiers changed from: private */
    public final void setRemoteStateOnLine(long j, boolean z) {
        synchronized (this.mRemoteMapSync) {
            RtcUserState rtcUserState = getMRemoteHashMap().get(Long.valueOf(j));
            if (rtcUserState == null) {
                rtcUserState = new RtcUserState(false, false, 0, 7, (DefaultConstructorMarker) null);
            }
            rtcUserState.setMUid(j);
            rtcUserState.setMIsOnline(z);
            if (!z) {
                rtcUserState.setMIsOpenMic(false);
                rtcUserState.setMIsOpenCamera(false);
                rtcUserState.setMIsVideoMute(false);
            }
            getMRemoteHashMap().put(Long.valueOf(j), rtcUserState);
            Unit unit = Unit.INSTANCE;
        }
    }

    /* access modifiers changed from: private */
    public final void setRemoteStateOpenMic(long j, boolean z) {
        synchronized (this.mRemoteMapSync) {
            RtcUserState rtcUserState = getMRemoteHashMap().get(Long.valueOf(j));
            if (rtcUserState == null) {
                rtcUserState = new RtcUserState(false, false, 0, 7, (DefaultConstructorMarker) null);
            }
            rtcUserState.setMUid(j);
            rtcUserState.setMIsOpenMic(z);
            getMRemoteHashMap().put(Long.valueOf(j), rtcUserState);
            Unit unit = Unit.INSTANCE;
        }
    }

    static /* synthetic */ void setRemoteStateOpenCamera$default(RtcPlayer rtcPlayer, long j, boolean z, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            z2 = false;
        }
        rtcPlayer.setRemoteStateOpenCamera(j, z, z2);
    }

    /* access modifiers changed from: private */
    public final void setRemoteStateOpenCamera(long j, boolean z, boolean z2) {
        synchronized (this.mRemoteMapSync) {
            RtcUserState rtcUserState = getMRemoteHashMap().get(Long.valueOf(j));
            if (rtcUserState == null) {
                rtcUserState = new RtcUserState(false, false, 0, 7, (DefaultConstructorMarker) null);
            }
            rtcUserState.setMUid(j);
            if (z2) {
                rtcUserState.setMIsOpenCamera(z);
                rtcUserState.setMIsVideoMute(!z);
            } else if (!rtcUserState.getMIsVideoMute()) {
                rtcUserState.setMIsOpenCamera(z);
            }
            getMRemoteHashMap().put(Long.valueOf(j), rtcUserState);
            Unit unit = Unit.INSTANCE;
        }
    }

    /* access modifiers changed from: private */
    public final void addRemoteUser(long j) {
        synchronized (this.userSyncObject) {
            if (!getMRemoteUserList().contains(Long.valueOf(j))) {
                getMRemoteUserList().add(Long.valueOf(j));
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* access modifiers changed from: private */
    public final void removeRemoteUser(long j) {
        synchronized (this.userSyncObject) {
            getMRemoteUserList().remove(Long.valueOf(j));
        }
    }

    private final void clearRemoteUser() {
        synchronized (this.userSyncObject) {
            getMRemoteUserList().clear();
            Unit unit = Unit.INSTANCE;
        }
    }

    public final ArrayList<Long> getRemoteUsers() {
        ArrayList<Long> mRemoteUserList2;
        synchronized (this.userSyncObject) {
            mRemoteUserList2 = getMRemoteUserList();
        }
        return mRemoteUserList2;
    }

    public final void switchTeacherModel(boolean z) {
        RTCEngine rTCEngine;
        if (this.mIsExquisite && this.mRtcEngine != null) {
            if (z) {
                XesLog.s(this.TAG, "切换到pc老师模式");
                RTCEngine rTCEngine2 = this.mRtcEngine;
                if (rTCEngine2 != null) {
                    rTCEngine2.muteRemoteVideo(this.mVideoTeacherId, true);
                }
                RTCEngine rTCEngine3 = this.mRtcEngine;
                if (rTCEngine3 != null) {
                    rTCEngine3.muteRemoteAudio(this.mAudioTeacherId, true);
                }
                RTCEngine rTCEngine4 = this.mRtcEngine;
                if (rTCEngine4 != null) {
                    rTCEngine4.muteRemoteVideo(this.mPcTeacherUid, false);
                }
                RTCEngine rTCEngine5 = this.mRtcEngine;
                if (rTCEngine5 != null) {
                    rTCEngine5.muteRemoteAudio(this.mPcTeacherUid, false);
                    return;
                }
                return;
            }
            XesLog.s(this.TAG, "切换到ipad老师模式");
            RTCEngine rTCEngine6 = this.mRtcEngine;
            if (rTCEngine6 != null) {
                rTCEngine6.muteRemoteAudio(this.mPcTeacherUid, true);
            }
            long j = this.mVideoTeacherId;
            long j2 = this.mPcTeacherUid;
            if (!(j == j2 || (rTCEngine = this.mRtcEngine) == null)) {
                rTCEngine.muteRemoteVideo(j2, true);
            }
            RTCEngine rTCEngine7 = this.mRtcEngine;
            if (rTCEngine7 != null) {
                rTCEngine7.muteRemoteVideo(this.mVideoTeacherId, false);
            }
            RTCEngine rTCEngine8 = this.mRtcEngine;
            if (rTCEngine8 != null) {
                rTCEngine8.muteRemoteAudio(this.mAudioTeacherId, false);
            }
        }
    }

    public final SurfaceView createSurfaceView() {
        RTCEngine rTCEngine = this.mRtcEngine;
        if (rTCEngine == null || rTCEngine == null) {
            return null;
        }
        return rTCEngine.createRendererView();
    }

    public final void initPlay(String str, String str2, boolean z) {
        this.mIsExquisite = z;
        this.mToken = str;
        if (!z) {
            str = str2;
        }
        this.mStuToken = str;
        Context context2 = this.context;
        RTCEngine rTCEngine = new RTCEngine(context2 == null ? null : context2.getApplicationContext(), this.mIRtcEngineEventListener);
        this.mRtcEngine = rTCEngine;
        createRtcPlayerEngine(rTCEngine);
        RTCEngine rTCEngine2 = this.mRtcEngine;
        Integer valueOf = rTCEngine2 == null ? null : Integer.valueOf(rTCEngine2.initWithToken(this.mStuToken));
        RTCEngine rTCEngine3 = this.mRtcEngine;
        if (rTCEngine3 != null) {
            rTCEngine3.setRtcEngineLog(PathUtils.getExternalAppCachePath(), RTCEngine.RTCEngineLogLevel.RTCENGINE_LOG_FILTER_INFO);
        }
        RTCEngine rTCEngine4 = this.mRtcEngine;
        if (rTCEngine4 != null) {
            rTCEngine4.setParams("{\"rtc.min_playout_delay\":0}");
        }
        setVideoBitrate(false);
        RTCEngine rTCEngine5 = this.mRtcEngine;
        if (rTCEngine5 != null) {
            rTCEngine5.setParams("{\"che.audio.specify.codec\":\"OPUSFB\",\"che.audio.bitrate.force\":16000}");
        }
        if (valueOf != null && valueOf.intValue() == 0) {
            trackLog("RtcPlayerEngine", Intrinsics.stringPlus("初始化rtc 引擎成功 - initWithToken code  ", valueOf));
            XesLog.s(this.TAG, Intrinsics.stringPlus("初始化rtc 引擎成功 - initWithToken code  ", valueOf));
            if (!this.mIsExquisite) {
                initEngineChannel();
            }
        } else {
            this.mRtcEngine = null;
            RtcPlayEventListener rtcPlayEventListener = this.mPlayEventListener;
            if (!(rtcPlayEventListener == null || rtcPlayEventListener == null)) {
                rtcPlayEventListener.onPlayFaild();
            }
            trackLog("RtcPlayerEngine", Intrinsics.stringPlus("初始化rtc 引擎失败 - initWithToken code  ", valueOf));
            XesLog.e(this.TAG, "初始化rtc 引擎失败 - initWithToken code 0 ");
        }
        RTCEngine rTCEngine6 = this.mRtcEngine;
        if (rTCEngine6 != null) {
            rTCEngine6.setRtcEngineEventObserver(this.mRtcEngineEventObserver);
        }
        this.isRtcInit = true;
        XesLog.i(this.TAG, Intrinsics.stringPlus("外挂so 是否已加载 :", Boolean.valueOf(MediaPreProcessing.isLoad())));
    }

    public final void initPlayWithoutToken(long j, String str) {
        Intrinsics.checkNotNullParameter(str, "appId");
        Context context2 = this.context;
        RTCEngine rTCEngine = new RTCEngine(context2 == null ? null : context2.getApplicationContext(), this.mIRtcEngineEventListener);
        this.mRtcEngine = rTCEngine;
        createRtcPlayerEngine(rTCEngine);
        RTCEngine rTCEngine2 = this.mRtcEngine;
        Integer valueOf = rTCEngine2 == null ? null : Integer.valueOf(rTCEngine2.init(RTCEngine.EngineType.Agora, j, str, ""));
        RTCEngine rTCEngine3 = this.mRtcEngine;
        if (rTCEngine3 != null) {
            rTCEngine3.setRtcEngineLog(PathUtils.getExternalAppCachePath(), RTCEngine.RTCEngineLogLevel.RTCENGINE_LOG_FILTER_DEBUG);
        }
        RTCEngine rTCEngine4 = this.mRtcEngine;
        if (rTCEngine4 != null) {
            rTCEngine4.setParams("{\"rtc.min_playout_delay\":0}");
        }
        setVideoBitrate(false);
        if (valueOf != null && valueOf.intValue() == 0) {
            trackLog("RtcPlayerEngine", Intrinsics.stringPlus("初始化rtc 引擎成功 - initWithToken code  ", valueOf));
            XesLog.i(this.TAG, Intrinsics.stringPlus("初始化rtc 引擎成功 - initWithToken code  ", valueOf));
        } else {
            this.mRtcEngine = null;
            RtcPlayEventListener rtcPlayEventListener = this.mPlayEventListener;
            if (!(rtcPlayEventListener == null || rtcPlayEventListener == null)) {
                rtcPlayEventListener.onPlayFaild();
            }
            trackLog("RtcPlayerEngine", Intrinsics.stringPlus("初始化rtc 引擎失败 - initWithToken code  ", valueOf));
            XesLog.i(this.TAG, "初始化rtc 引擎失败 - initWithToken code 0 ");
        }
        this.isRtcInit = true;
        XesLog.i(this.TAG, Intrinsics.stringPlus("外挂so 是否已加载 :", Boolean.valueOf(MediaPreProcessing.isLoad())));
    }

    /* access modifiers changed from: private */
    public final void trackLog(String str, String str2) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty(str, str2);
        XesLog.ut("RtcPlayLog", jsonObject);
    }

    private final void initEngineChannel() {
        XesLog.i(this.TAG, "大班，初始化initEngineChannel");
        if (this.mRtcEngine != null) {
            RTCChannel rTCChannel = new RTCChannel(this.mRtcEngine);
            this.mRtcEngineChannel = rTCChannel;
            Intrinsics.checkNotNull(rTCChannel);
            int initWithToken = rTCChannel.initWithToken(this.mToken);
            RTCChannel rTCChannel2 = this.mRtcEngineChannel;
            Intrinsics.checkNotNull(rTCChannel2);
            rTCChannel2.setEventListener(new RtcPlayer$initEngineChannel$1(this));
            if (initWithToken != 0) {
                this.mRtcEngine = null;
                trackLog("RtcPlayerChannel", Intrinsics.stringPlus("initEngineChannel非0初始化失败 - onPlayFaild ", Integer.valueOf(initWithToken)));
                RtcPlayEventListener rtcPlayEventListener = this.mPlayEventListener;
                if (!(rtcPlayEventListener == null || rtcPlayEventListener == null)) {
                    rtcPlayEventListener.onPlayFaild();
                }
                XesLog.e(this.TAG, Intrinsics.stringPlus("大班，初始化initEngineChannel 失败 code = ", Integer.valueOf(initWithToken)));
                return;
            }
            XesLog.s(this.TAG, "大班，初始化initEngineChannel 成功");
        }
    }

    public final void disableLastMileProbeTest() {
        XesLog.i(this.TAG, "关闭 Rtc 网络监控");
        RTCEngine rTCEngine = this.mRtcEngine;
        if (rTCEngine != null) {
            rTCEngine.disableLastmileProbeTest();
        }
    }

    public final void enableLastMileProbeTest() {
        XesLog.i(this.TAG, "开启 Rtc 网络监控");
        RTCEngine rTCEngine = this.mRtcEngine;
        if (rTCEngine != null) {
            rTCEngine.enableLastmileProbeTest();
        }
    }

    public final void startPreview(SurfaceView surfaceView) {
        Intrinsics.checkNotNullParameter(surfaceView, "surfaceView");
        XesLog.i(this.TAG, "开启 Rtc 摄像头预览");
        RTCEngine rTCEngine = this.mRtcEngine;
        if (rTCEngine != null) {
            rTCEngine.enableVideo();
        }
        RTCEngine rTCEngine2 = this.mRtcEngine;
        if (rTCEngine2 != null) {
            rTCEngine2.setupLocalVideo(surfaceView);
        }
        RTCEngine rTCEngine3 = this.mRtcEngine;
        if (rTCEngine3 != null) {
            rTCEngine3.startPreview();
        }
    }

    public final void stopPreview() {
        XesLog.i(this.TAG, "预览 Rtc 摄像头预览");
        RTCEngine rTCEngine = this.mRtcEngine;
        if (rTCEngine != null) {
            rTCEngine.stopPreview();
        }
    }

    public final void prePlay(long j, long j2, RtcPlayPrePlayEventListener rtcPlayPrePlayEventListener, boolean z) {
        RTCChannel rTCChannel;
        this.mPrePlayEventListener = rtcPlayPrePlayEventListener;
        this.mIsAuditor = z;
        trackLog("RtcPlayer", "准备rtc 播放 videoTeacherId :" + j + "  audioTeacherId:" + j2);
        XesLog.i(this.TAG, "准备rtc 播放 videoTeacherId :" + j + "  audioTeacherId:" + j2);
        this.mAudioTeacherId = j2;
        this.mVideoTeacherId = j;
        RTCEngine rTCEngine = this.mRtcEngine;
        if (rTCEngine != null) {
            if (rTCEngine != null) {
                rTCEngine.setMediaVideoProcessListener(new RtcPlayer$prePlay$1(this));
            }
            RTCEngine rTCEngine2 = this.mRtcEngine;
            if (rTCEngine2 != null) {
                rTCEngine2.setMediaAudioProcessListener(new RtcPlayer$prePlay$2(this));
            }
            if (!z) {
                RTCEngine rTCEngine3 = this.mRtcEngine;
                if (rTCEngine3 != null) {
                    rTCEngine3.setRole(RTCEngine.RTCRole.RTCRoleBroadcaster);
                }
                RTCEngine rTCEngine4 = this.mRtcEngine;
                Intrinsics.checkNotNull(rTCEngine4);
                rTCEngine4.muteLocalVideo(false);
                RTCEngine rTCEngine5 = this.mRtcEngine;
                Intrinsics.checkNotNull(rTCEngine5);
                rTCEngine5.muteLocalAudio(false);
            } else {
                RTCEngine rTCEngine6 = this.mRtcEngine;
                if (rTCEngine6 != null) {
                    rTCEngine6.setRole(RTCEngine.RTCRole.RTCRoleAudience);
                }
            }
            XesLog.i(Tag.RTC_MONITOR, "开始调用加入房间接口");
            RtcTrackUtil.INSTANCE.trackStartEvent();
            RTCEngine rTCEngine7 = this.mRtcEngine;
            Integer valueOf = rTCEngine7 == null ? null : Integer.valueOf(rTCEngine7.joinRoom());
            Intrinsics.checkNotNull(valueOf);
            int intValue = valueOf.intValue();
            RTCEngine rTCEngine8 = this.mRtcEngine;
            if (rTCEngine8 != null) {
                rTCEngine8.setDefaultMuteAllRemoteAudioStreams(true);
            }
            RTCEngine rTCEngine9 = this.mRtcEngine;
            if (rTCEngine9 != null) {
                rTCEngine9.setDefaultMuteAllRemoteVideoStreams(true);
            }
            if (this.mIsExquisite) {
                RTCEngine rTCEngine10 = this.mRtcEngine;
                if (rTCEngine10 != null) {
                    rTCEngine10.muteRemoteAudio(this.mAudioTeacherId, false);
                }
                RTCEngine rTCEngine11 = this.mRtcEngine;
                if (rTCEngine11 != null) {
                    rTCEngine11.muteRemoteVideo(this.mVideoTeacherId, false);
                }
            }
            if (!this.mIsExquisite && (rTCChannel = this.mRtcEngineChannel) != null) {
                Intrinsics.checkNotNull(rTCChannel);
                rTCChannel.setRole(RTCEngine.RTCRole.RTCRoleAudience);
                RTCChannel rTCChannel2 = this.mRtcEngineChannel;
                if (rTCChannel2 != null) {
                    rTCChannel2.joinChannel();
                }
            }
            if (intValue != 0) {
                XesLog.e(Tag.RTC_MONITOR, Intrinsics.stringPlus("调用加入房间接口失败,错误码=", Integer.valueOf(intValue)));
                RtcTrackUtil.INSTANCE.trackFailEvent(RtcFailEventType.CALL_JOIN_ROOM_METHOD_FAIL, Intrinsics.stringPlus("RTC调用加入房间接口失败,错误码=", Integer.valueOf(intValue)));
                if (rtcPlayPrePlayEventListener != null) {
                    this.mRtcEngine = null;
                    rtcPlayPrePlayEventListener.onInitChannelError();
                }
            }
        }
    }

    public void startPlay() {
        RTCEngine rTCEngine;
        RTCChannel rTCChannel;
        trackLog("RtcPlayer", "开始播放");
        XesLog.i(this.TAG, "开始播放");
        boolean z = this.mIsExquisite;
        if (!z && (rTCChannel = this.mRtcEngineChannel) != null) {
            if (rTCChannel != null) {
                rTCChannel.setupRemoteVideo(this.mRendererView, this.mVideoTeacherId);
            }
            RTCChannel rTCChannel2 = this.mRtcEngineChannel;
            if (rTCChannel2 != null) {
                rTCChannel2.setRemoteRenderMode(this.mVideoTeacherId, RTCEngine.RTCVideoRenderMode.RTCVideoRenderModeHidden);
            }
            this.isRtcPlaying = true;
            this.isRtcPause = false;
            XesLog.i(this.TAG, "播放成功");
            trackLog("RtcPlayerChannel", "播放成功");
            if (this.mPlayEventListener != null) {
                ThreadUtils.runOnUiThread(new RtcPlayer$$ExternalSyntheticLambda1(this));
            }
        } else if (z && (rTCEngine = this.mRtcEngine) != null) {
            if (rTCEngine != null) {
                rTCEngine.setupRemoteVideo(this.mRendererView, this.mVideoTeacherId);
            }
            RTCEngine rTCEngine2 = this.mRtcEngine;
            if (rTCEngine2 != null) {
                rTCEngine2.setRemoteRenderMode(this.mVideoTeacherId, RTCEngine.RTCVideoRenderMode.RTCVideoRenderModeHidden);
            }
            this.isRtcPlaying = true;
            this.isRtcPause = false;
            XesLog.i(this.TAG, "播放成功");
            trackLog("RtcPlayerEngine", "播放成功");
            if (this.mPlayEventListener != null) {
                ThreadUtils.runOnUiThread(new RtcPlayer$$ExternalSyntheticLambda0(this));
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: startPlay$lambda-10  reason: not valid java name */
    public static final void m100startPlay$lambda10(RtcPlayer rtcPlayer) {
        Intrinsics.checkNotNullParameter(rtcPlayer, "this$0");
        RtcPlayEventListener rtcPlayEventListener = rtcPlayer.mPlayEventListener;
        if (rtcPlayEventListener != null) {
            rtcPlayEventListener.onVideoPlaySuceess();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: startPlay$lambda-11  reason: not valid java name */
    public static final void m101startPlay$lambda11(RtcPlayer rtcPlayer) {
        Intrinsics.checkNotNullParameter(rtcPlayer, "this$0");
        RtcPlayEventListener rtcPlayEventListener = rtcPlayer.mPlayEventListener;
        if (rtcPlayEventListener != null) {
            rtcPlayEventListener.onVideoPlaySuceess();
        }
    }

    public final void changeMode(String str) {
        String str2 = this.mToken;
        Boolean valueOf = str2 == null ? null : Boolean.valueOf(str2.equals(str));
        Intrinsics.checkNotNull(valueOf);
        if (!valueOf.booleanValue()) {
            destroyPlayer();
            initPlay(str, this.mStuToken, this.mIsExquisite);
        }
    }

    public void setVolume(float f) {
        XesLog.i(this.TAG, Intrinsics.stringPlus("设置声音： volume: ", Float.valueOf(f)));
        boolean z = this.mIsExquisite;
        int i = 100;
        if (!z && this.mRtcEngineChannel != null) {
            if (f <= 100.0f) {
                i = (int) f;
            }
            int max = Math.max(0, i);
            this.mCurrentVolume = max;
            RTCChannel rTCChannel = this.mRtcEngineChannel;
            if (rTCChannel != null) {
                rTCChannel.setRemoteVolume(this.mAudioTeacherId, max);
            }
        } else if (z && this.mRtcEngine != null) {
            if (f <= 100.0f) {
                i = (int) f;
            }
            int max2 = Math.max(0, i);
            this.mCurrentVolume = max2;
            RTCEngine rTCEngine = this.mRtcEngine;
            if (rTCEngine != null) {
                rTCEngine.setRemoteVolume(this.mAudioTeacherId, max2);
            }
        }
    }

    public final RTCEngine getRTCEngine() {
        XesLog.i(this.TAG, Intrinsics.stringPlus("获取rtc引擎： ", Boolean.valueOf(this.mRtcEngine == null)));
        return this.mRtcEngine;
    }

    public final RTCChannel getRTCEngineChannel() {
        XesLog.i(this.TAG, Intrinsics.stringPlus("获取rtc引擎： ", Boolean.valueOf(this.mRtcEngineChannel == null)));
        return this.mRtcEngineChannel;
    }

    public final boolean isTargeVideotUser(long j) {
        boolean z = this.mVideoTeacherId == j;
        XesLog.i(this.TAG, "isTargetVideoUser:uid=" + j + ':' + this.mVideoTeacherId);
        return z;
    }

    public final boolean isTargeAudioUser(long j) {
        boolean z = this.mAudioTeacherId == j;
        XesLog.i(this.TAG, "isTargetAudioUser:uid=" + j + ':' + this.mAudioTeacherId);
        return z;
    }

    public final boolean isPcTeacher(long j) {
        return this.mPcTeacherUid == j;
    }

    public final boolean isTargeTutorUser(long j) {
        return this.mTutorUid == j;
    }

    public void destroyPlayer() {
        XesLog.i(this.TAG, "销毁rtc 引擎： ");
        if (this.isRtcInit) {
            this.audioTeacherJoined = false;
            this.videoTeacherJoined = false;
            RTCEngine rTCEngine = this.mRtcEngine;
            if (rTCEngine != null) {
                rTCEngine.muteRemoteVideo(this.mVideoTeacherId, true);
            }
            RTCEngine rTCEngine2 = this.mRtcEngine;
            if (rTCEngine2 != null) {
                rTCEngine2.muteRemoteAudio(this.mVideoTeacherId, true);
            }
            RTCEngine rTCEngine3 = this.mRtcEngine;
            if (rTCEngine3 != null) {
                rTCEngine3.setMediaVideoProcessListener((RTCEngine.IRTCMediaVideoProcess) null);
            }
            RTCEngine rTCEngine4 = this.mRtcEngine;
            if (rTCEngine4 != null) {
                rTCEngine4.setMediaAudioProcessListener((RTCEngine.IRTCMediaAudioProcess) null);
            }
            RTCEngine rTCEngine5 = this.mRtcEngine;
            if (rTCEngine5 != null) {
                rTCEngine5.leaveRoom();
            }
            RTCEngine rTCEngine6 = this.mRtcEngine;
            if (rTCEngine6 != null) {
                rTCEngine6.destory();
            }
            RTCChannel rTCChannel = this.mRtcEngineChannel;
            if (rTCChannel != null) {
                rTCChannel.leaveChannel();
            }
            RTCChannel rTCChannel2 = this.mRtcEngineChannel;
            if (rTCChannel2 != null) {
                rTCChannel2.destroy();
            }
            MediaDataObserverPlugin.the().removeAllBuffers();
            this.mRtcEngine = null;
            this.isRtcInit = false;
            this.isRtcPlaying = false;
        }
    }

    public void pausePlay() {
        XesLog.i(this.TAG, "暂停rtc 播放");
        if (this.mRtcEngine != null) {
            this.isRtcPause = true;
            this.isRtcPlaying = false;
            destroyPlayer();
        }
    }

    public void reStart() {
        XesLog.i(this.TAG, "重新开始rtc 播放 ");
        if (this.isRtcPause) {
            this.isRtcPause = false;
            this.isRtcPlaying = true;
            this.audioTeacherJoined = false;
            this.videoTeacherJoined = false;
            initPlay(this.mToken, this.mStuToken, this.mIsExquisite);
            prePlay(this.mVideoTeacherId, this.mAudioTeacherId, this.mPrePlayEventListener, this.mIsAuditor);
        }
    }

    public final void setPlayEventListener(RtcPlayEventListener rtcPlayEventListener) {
        this.mPlayEventListener = rtcPlayEventListener;
    }

    public final void addRtcEngineCreateListener(String str, RTCEngineCreateListener rTCEngineCreateListener) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(rTCEngineCreateListener, "listener");
        this.mRTCEngineCreateListener.put(str, rTCEngineCreateListener);
        RTCEngine rTCEngine = this.mRtcEngine;
        if (rTCEngine != null) {
            rTCEngineCreateListener.createRtcPlayerEngine(rTCEngine);
        }
    }

    public final void removeRtcEngineCreateListener(String str) {
        TypeIntrinsics.asMutableMap(this.mRTCEngineCreateListener).remove(str);
    }

    public final void addRtcEngineEventObserver(String str, RTCEngine.RtcEngineEventObserver rtcEngineEventObserver) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(rtcEngineEventObserver, "listener");
        this.mRtcEngineEventObservers.put(str, rtcEngineEventObserver);
    }

    public final void removeRtcEngineEventObserver(String str) {
        Intrinsics.checkNotNullParameter(str, "tag");
        this.mRtcEngineEventObservers.remove(str);
    }

    public final void addEtcEngineEventListener(String str, RtcPlayerEngineEventListener rtcPlayerEngineEventListener) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(rtcPlayerEngineEventListener, "listener");
        this.mRtcEngineListeners.put(str, rtcPlayerEngineEventListener);
        if (this.mIsExquisite) {
            Handler mainHandler = ThreadUtils.getMainHandler();
            RtcPlayer$$ExternalSyntheticLambda3 rtcPlayer$$ExternalSyntheticLambda3 = new RtcPlayer$$ExternalSyntheticLambda3(rtcPlayerEngineEventListener, this);
            if (!(mainHandler instanceof Handler)) {
                mainHandler.post(rtcPlayer$$ExternalSyntheticLambda3);
            } else {
                AsynchronousInstrumentation.handlerPost(mainHandler, rtcPlayer$$ExternalSyntheticLambda3);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: addEtcEngineEventListener$lambda-15  reason: not valid java name */
    public static final void m98addEtcEngineEventListener$lambda15(RtcPlayerEngineEventListener rtcPlayerEngineEventListener, RtcPlayer rtcPlayer) {
        Intrinsics.checkNotNullParameter(rtcPlayerEngineEventListener, "$listener");
        Intrinsics.checkNotNullParameter(rtcPlayer, "this$0");
        synchronized (rtcPlayer.userSyncObject) {
            for (Number longValue : rtcPlayer.getMRemoteUserList()) {
                rtcPlayerEngineEventListener.remoteUserJoinWitnUid(longValue.longValue(), "Engine");
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void removeRtcEngineEventListener(String str) {
        TypeIntrinsics.asMutableMap(this.mRtcEngineListeners).remove(str);
    }

    public final void createRtcPlayerEngine(RTCEngine rTCEngine) {
        Map<String, RTCEngineCreateListener> map = this.mRTCEngineCreateListener;
        if (!(map == null || map.isEmpty())) {
            for (String str : this.mRTCEngineCreateListener.keySet()) {
                RTCEngineCreateListener rTCEngineCreateListener = this.mRTCEngineCreateListener.get(str);
                if (rTCEngineCreateListener != null) {
                    rTCEngineCreateListener.createRtcPlayerEngine(rTCEngine);
                }
            }
        }
    }

    public final void onRtcEngineOnceLastMileQuality(int i, String str) {
        Intrinsics.checkNotNullParameter(str, "type");
        if (!this.mRtcEngineListeners.isEmpty()) {
            for (String str2 : this.mRtcEngineListeners.keySet()) {
                RtcPlayerEngineEventListener rtcPlayerEngineEventListener = this.mRtcEngineListeners.get(str2);
                if (rtcPlayerEngineEventListener != null) {
                    rtcPlayerEngineEventListener.onOnceLastMileQuality(i, str);
                }
            }
        }
    }

    public final void dispatchOfflineOfUid(long j, String str) {
        Intrinsics.checkNotNullParameter(str, "type");
        if (!this.mRtcEngineListeners.isEmpty()) {
            for (String str2 : this.mRtcEngineListeners.keySet()) {
                RtcPlayerEngineEventListener rtcPlayerEngineEventListener = this.mRtcEngineListeners.get(str2);
                if (rtcPlayerEngineEventListener != null) {
                    rtcPlayerEngineEventListener.didOfflineOfUid(j, str);
                }
            }
        }
    }

    public final void dispatchConnectionState(RTCConnectionStateType rTCConnectionStateType, String str, String str2) {
        Intrinsics.checkNotNullParameter(rTCConnectionStateType, "state");
        Intrinsics.checkNotNullParameter(str, "reason");
        Intrinsics.checkNotNullParameter(str2, "type");
        if (!this.mRtcEngineListeners.isEmpty()) {
            for (String str3 : this.mRtcEngineListeners.keySet()) {
                RtcPlayerEngineEventListener rtcPlayerEngineEventListener = this.mRtcEngineListeners.get(str3);
                if (rtcPlayerEngineEventListener != null) {
                    rtcPlayerEngineEventListener.dispatchConnectionState(rTCConnectionStateType, str, str2);
                }
            }
        }
    }

    public final void dispatchRemoteFirstVideoRecvWithUid(long j, String str) {
        Intrinsics.checkNotNullParameter(str, "type");
        if (!this.mRtcEngineListeners.isEmpty()) {
            for (String str2 : this.mRtcEngineListeners.keySet()) {
                RtcPlayerEngineEventListener rtcPlayerEngineEventListener = this.mRtcEngineListeners.get(str2);
                if (rtcPlayerEngineEventListener != null) {
                    rtcPlayerEngineEventListener.remotefirstVideoRecvWithUid(j, str);
                }
            }
        }
    }

    public final void dispatchRemoteUserJoinWitnUid(long j, String str) {
        Intrinsics.checkNotNullParameter(str, "type");
        if (!this.mRtcEngineListeners.isEmpty()) {
            XesLog.i(this.TAG, Intrinsics.stringPlus("dispatchRemoteUserJoinWitnUid ", Integer.valueOf(this.mRtcEngineListeners.size())));
            for (String next : this.mRtcEngineListeners.keySet()) {
                XesLog.i(this.TAG, Intrinsics.stringPlus("dispatchRemoteUserJoinWitnUid key= ", next));
                RtcPlayerEngineEventListener rtcPlayerEngineEventListener = this.mRtcEngineListeners.get(next);
                if (rtcPlayerEngineEventListener != null) {
                    rtcPlayerEngineEventListener.remoteUserJoinWitnUid(j, str);
                }
            }
            return;
        }
        XesLog.i(this.TAG, "dispatchRemoteUserJoinWitnUid empty");
    }

    public final void dispatchRemoteFirstAudioRecvWithUid(long j, String str) {
        Intrinsics.checkNotNullParameter(str, "type");
        if (!this.mRtcEngineListeners.isEmpty()) {
            for (String str2 : this.mRtcEngineListeners.keySet()) {
                RtcPlayerEngineEventListener rtcPlayerEngineEventListener = this.mRtcEngineListeners.get(str2);
                if (rtcPlayerEngineEventListener != null) {
                    rtcPlayerEngineEventListener.remotefirstAudioRecvWithUid(j, str);
                }
            }
        }
    }

    public final void dispatchDidAudioMuted(long j, boolean z, String str) {
        Intrinsics.checkNotNullParameter(str, "type");
        if (!this.mRtcEngineListeners.isEmpty()) {
            for (String str2 : this.mRtcEngineListeners.keySet()) {
                RtcPlayerEngineEventListener rtcPlayerEngineEventListener = this.mRtcEngineListeners.get(str2);
                if (rtcPlayerEngineEventListener != null) {
                    rtcPlayerEngineEventListener.didAudioMuted(j, z, str);
                }
            }
        }
    }

    public final void dispatchDidVideoMuted(long j, boolean z, String str) {
        Intrinsics.checkNotNullParameter(str, "type");
        if (!this.mRtcEngineListeners.isEmpty()) {
            for (String str2 : this.mRtcEngineListeners.keySet()) {
                RtcPlayerEngineEventListener rtcPlayerEngineEventListener = this.mRtcEngineListeners.get(str2);
                if (rtcPlayerEngineEventListener != null) {
                    rtcPlayerEngineEventListener.didVideoMuted(j, z, str);
                }
            }
        }
    }

    public final void dispatchRemoteVideoStateChanged(long j, int i, String str) {
        Intrinsics.checkNotNullParameter(str, "type");
        if (!this.mRtcEngineListeners.isEmpty()) {
            for (String str2 : this.mRtcEngineListeners.keySet()) {
                RtcPlayerEngineEventListener rtcPlayerEngineEventListener = this.mRtcEngineListeners.get(str2);
                if (rtcPlayerEngineEventListener != null) {
                    rtcPlayerEngineEventListener.onRemoteVideoStateChanged(j, i, str);
                }
            }
        }
    }

    public final void dispatchlocalUserJoindWithUid(long j, String str) {
        Intrinsics.checkNotNullParameter(str, "type");
        if (!this.mRtcEngineListeners.isEmpty()) {
            for (String str2 : this.mRtcEngineListeners.keySet()) {
                RtcPlayerEngineEventListener rtcPlayerEngineEventListener = this.mRtcEngineListeners.get(str2);
                if (rtcPlayerEngineEventListener != null) {
                    rtcPlayerEngineEventListener.localUserJoindWithUid(j, str);
                }
            }
        }
    }

    public final void dispatchReportAudioVolumeOfSpeaker(long j, int i) {
        if (!this.mRtcEngineListeners.isEmpty()) {
            for (String str : this.mRtcEngineListeners.keySet()) {
                RtcPlayerEngineEventListener rtcPlayerEngineEventListener = this.mRtcEngineListeners.get(str);
                if (rtcPlayerEngineEventListener != null) {
                    rtcPlayerEngineEventListener.reportAudioVolumeOfSpeaker(j, i);
                }
            }
        }
    }

    public final void enableLocalStream(boolean z) {
        if (this.mRtcEngine != null) {
            XesLog.i(this.TAG, "关闭rtc推流");
            RTCEngine rTCEngine = this.mRtcEngine;
            if (rTCEngine != null) {
                rTCEngine.muteLocalVideo(!z);
            }
            RTCEngine rTCEngine2 = this.mRtcEngine;
            if (rTCEngine2 != null) {
                rTCEngine2.muteLocalAudio(!z);
            }
        }
    }

    public final boolean videoTeacherIsJoined() {
        XesLog.i(this.TAG, Intrinsics.stringPlus("安卓手机 是否已经加入房间 ：", Boolean.valueOf(this.videoTeacherJoined)));
        return this.videoTeacherJoined;
    }

    public final boolean audioTeacherIsJoined() {
        XesLog.i(this.TAG, Intrinsics.stringPlus("pad 是否已经加入房间 ：", Boolean.valueOf(this.audioTeacherJoined)));
        return this.audioTeacherJoined;
    }

    public boolean isInit() {
        return this.isRtcInit;
    }

    public boolean isPause() {
        return this.isRtcPause;
    }

    public boolean isPlaying() {
        return this.isRtcPlaying;
    }

    public final int getOnceLastMileQuality() {
        return this.mNetworkQuality;
    }

    public final void addVideoProcessObserver(IRTCMediaVideoProcess iRTCMediaVideoProcess) {
        Intrinsics.checkNotNullParameter(iRTCMediaVideoProcess, "videoProcessListener");
        this.mVideoProcessListener.add(iRTCMediaVideoProcess);
    }

    public final void removeVideoProcessObserver(IRTCMediaVideoProcess iRTCMediaVideoProcess) {
        Intrinsics.checkNotNullParameter(iRTCMediaVideoProcess, "videoProcessListener");
        this.mVideoProcessListener.remove(iRTCMediaVideoProcess);
    }

    public final void addAudioProcessObserver(IRTCMediaAudioProcess iRTCMediaAudioProcess) {
        Intrinsics.checkNotNullParameter(iRTCMediaAudioProcess, "audioProcessListener");
        this.mAudioProcessListener.add(iRTCMediaAudioProcess);
    }

    public final void removeAudioProcessObserver(IRTCMediaAudioProcess iRTCMediaAudioProcess) {
        Intrinsics.checkNotNullParameter(iRTCMediaAudioProcess, "audioProcessListener");
        this.mAudioProcessListener.remove(iRTCMediaAudioProcess);
    }

    public final void removeAllVideoProcessObserver() {
        this.mVideoProcessListener.clear();
    }

    public final void removeAllAudioProcessObserver() {
        this.mAudioProcessListener.clear();
    }

    public final void disPatchNetworkQuality(long j, int i, int i2) {
        ThreadUtils.runOnUiThread(new RtcPlayer$$ExternalSyntheticLambda2(this, j, i, i2));
    }

    /* access modifiers changed from: private */
    /* renamed from: disPatchNetworkQuality$lambda-16  reason: not valid java name */
    public static final void m99disPatchNetworkQuality$lambda16(RtcPlayer rtcPlayer, long j, int i, int i2) {
        Intrinsics.checkNotNullParameter(rtcPlayer, "this$0");
        if (!rtcPlayer.mRtcEngineEventObservers.isEmpty()) {
            for (String str : rtcPlayer.mRtcEngineEventObservers.keySet()) {
                RTCEngine.RtcEngineEventObserver rtcEngineEventObserver = rtcPlayer.mRtcEngineEventObservers.get(str);
                if (rtcEngineEventObserver != null) {
                    rtcEngineEventObserver.onNetworkQuality(j, i, i2);
                }
            }
        }
    }

    public final void setVideoBitrate(boolean z) {
        XesLog.i(this.TAG, Intrinsics.stringPlus("设置码率是否为高码率（即上台码率） ：", Boolean.valueOf(z)));
        if (z) {
            RTCEngine rTCEngine = this.mRtcEngine;
            if (rTCEngine != null) {
                rTCEngine.setVideoEncoderConfiguration(320, 240, 10, 120, RTCEngine.RTC_ORIENTATION_MODE.RTC_ORIENTATION_MODE_ADAPTIVE);
                return;
            }
            return;
        }
        RTCEngine rTCEngine2 = this.mRtcEngine;
        if (rTCEngine2 != null) {
            rTCEngine2.setVideoEncoderConfiguration(LiveMessageCode.LIVE_BUSINESS_HANDUP_MESSAGE, 120, 10, 80, RTCEngine.RTC_ORIENTATION_MODE.RTC_ORIENTATION_MODE_ADAPTIVE);
        }
    }
}
