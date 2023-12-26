package com.tal.app.thinkacademy.live.business.function;

import com.tal.app.thinkacademy.live.abilitypack.rtc.listenbody.RtcPlayerListenerBody;
import com.tal.app.thinkacademy.live.business.function.bean.EnterRoomMuteData;
import com.tal.app.thinkacademy.live.business.function.view.AbsFunctionPluginView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/tal/app/thinkacademy/live/abilitypack/rtc/listenbody/RtcPlayerListenerBody;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: FunctionPluginDriver.kt */
final class FunctionPluginDriver$listenerVolumeOfSpeaker$1 extends Lambda implements Function1<RtcPlayerListenerBody, Unit> {
    final /* synthetic */ FunctionPluginDriver this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FunctionPluginDriver$listenerVolumeOfSpeaker$1(FunctionPluginDriver functionPluginDriver) {
        super(1);
        this.this$0 = functionPluginDriver;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((RtcPlayerListenerBody) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(RtcPlayerListenerBody rtcPlayerListenerBody) {
        Intrinsics.checkNotNullParameter(rtcPlayerListenerBody, "$this$observeListener");
        final FunctionPluginDriver functionPluginDriver = this.this$0;
        rtcPlayerListenerBody.onVolumeChange(new Function2<Long, Integer, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke(((Number) obj).longValue(), ((Number) obj2).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(long j, int i) {
                AbsFunctionPluginView access$getFunctionPluginView$p;
                if (Intrinsics.areEqual(String.valueOf(j), EnterRoomMuteData.STATUS_UN_MUTE) && (access$getFunctionPluginView$p = functionPluginDriver.functionPluginView) != null) {
                    access$getFunctionPluginView$p.reportAudioVolumeOfSpeaker(j, i);
                }
            }
        });
        final FunctionPluginDriver functionPluginDriver2 = this.this$0;
        rtcPlayerListenerBody.onLocalVideoChanged(new Function1<Boolean, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Boolean) obj).booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                AbsFunctionPluginView access$getFunctionPluginView$p = functionPluginDriver2.functionPluginView;
                if (access$getFunctionPluginView$p != null) {
                    access$getFunctionPluginView$p.cameraOn(z);
                }
                functionPluginDriver2.cameraOn = z ? "1" : EnterRoomMuteData.STATUS_UN_MUTE;
            }
        });
        final FunctionPluginDriver functionPluginDriver3 = this.this$0;
        rtcPlayerListenerBody.onLocalAudioChanged(new Function1<Boolean, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Boolean) obj).booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                AbsFunctionPluginView access$getFunctionPluginView$p = functionPluginDriver3.functionPluginView;
                if (access$getFunctionPluginView$p != null) {
                    access$getFunctionPluginView$p.muteMic(!z);
                }
                functionPluginDriver3.micOn = z ? "1" : EnterRoomMuteData.STATUS_UN_MUTE;
            }
        });
    }
}
