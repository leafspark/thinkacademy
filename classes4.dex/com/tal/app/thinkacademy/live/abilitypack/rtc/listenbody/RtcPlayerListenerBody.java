package com.tal.app.thinkacademy.live.abilitypack.rtc.listenbody;

import com.kwai.koom.javaoom.monitor.tracker.model.SystemInfo$JavaHeap$;
import com.tal.app.thinkacademy.lib.player.rtcplayer.entity.RtcUserState;
import com.tal.app.thinkacademy.live.business.studentvideo.bean.StudentVideoBean;
import com.tal.app.thinkacademy.live.core.live.abilitypack.livedata.listener.ListenerBody;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0007 !\"#$%&B\u0007\b\u0004¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0000H\u0016J>\u0010\u0006\u001a\u00020\u000426\u0010\u0007\u001a2\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00040\bJ)\u0010\u000f\u001a\u00020\u00042!\u0010\u0007\u001a\u001d\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00040\u0010J)\u0010\u0013\u001a\u00020\u00042!\u0010\u0007\u001a\u001d\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00040\u0010JS\u0010\u0014\u001a\u00020\u00042K\u0010\u0007\u001aG\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00040\u0015J>\u0010\u0019\u001a\u00020\u000426\u0010\u0007\u001a2\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00040\bJ/\u0010\u001a\u001a\u00020\u00042'\u0010\u0007\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u001c0\u001b¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u00040\u0010J>\u0010\u001e\u001a\u00020\u000426\u0010\u0007\u001a2\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u00040\b\u0001\u0007'()*+,-¨\u0006."}, d2 = {"Lcom/tal/app/thinkacademy/live/abilitypack/rtc/listenbody/RtcPlayerListenerBody;", "Lcom/tal/app/thinkacademy/live/core/live/abilitypack/livedata/listener/ListenerBody;", "()V", "dispatch", "", "listener", "isOnline", "action", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "uid", "Lcom/tal/app/thinkacademy/lib/player/rtcplayer/entity/RtcUserState;", "state", "onLocalAudioChanged", "Lkotlin/Function1;", "", "enable", "onLocalVideoChanged", "onNetworkQuality", "Lkotlin/Function3;", "", "upQuality", "downQuality", "onRtcStateChanged", "onStudentListUpdate", "", "Lcom/tal/app/thinkacademy/live/business/studentvideo/bean/StudentVideoBean$ListBean;", "list", "onVolumeChange", "volume", "IsOnline", "LocalAudioChanged", "LocalVideoChanged", "NetworkQuality", "OnRtcStateChanged", "StudentListUpdate", "VolumeChange", "Lcom/tal/app/thinkacademy/live/abilitypack/rtc/listenbody/RtcPlayerListenerBody$OnRtcStateChanged;", "Lcom/tal/app/thinkacademy/live/abilitypack/rtc/listenbody/RtcPlayerListenerBody$IsOnline;", "Lcom/tal/app/thinkacademy/live/abilitypack/rtc/listenbody/RtcPlayerListenerBody$VolumeChange;", "Lcom/tal/app/thinkacademy/live/abilitypack/rtc/listenbody/RtcPlayerListenerBody$LocalAudioChanged;", "Lcom/tal/app/thinkacademy/live/abilitypack/rtc/listenbody/RtcPlayerListenerBody$LocalVideoChanged;", "Lcom/tal/app/thinkacademy/live/abilitypack/rtc/listenbody/RtcPlayerListenerBody$NetworkQuality;", "Lcom/tal/app/thinkacademy/live/abilitypack/rtc/listenbody/RtcPlayerListenerBody$StudentListUpdate;", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RtcPlayerListenerBody.kt */
public abstract class RtcPlayerListenerBody extends ListenerBody<RtcPlayerListenerBody> {
    public /* synthetic */ RtcPlayerListenerBody(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public void dispatch(RtcPlayerListenerBody rtcPlayerListenerBody) {
        Intrinsics.checkNotNullParameter(rtcPlayerListenerBody, "listener");
    }

    private RtcPlayerListenerBody() {
    }

    public final void isOnline(Function2<? super Long, ? super RtcUserState, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "action");
        if (this instanceof IsOnline) {
            IsOnline isOnline = (IsOnline) this;
            function2.invoke(Long.valueOf(isOnline.getUid()), isOnline.getState());
        }
    }

    public final void onRtcStateChanged(Function2<? super Long, ? super RtcUserState, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "action");
        if (this instanceof OnRtcStateChanged) {
            OnRtcStateChanged onRtcStateChanged = (OnRtcStateChanged) this;
            function2.invoke(Long.valueOf(onRtcStateChanged.getUid()), onRtcStateChanged.getState());
        }
    }

    public final void onVolumeChange(Function2<? super Long, ? super Integer, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "action");
        if (this instanceof VolumeChange) {
            VolumeChange volumeChange = (VolumeChange) this;
            function2.invoke(Long.valueOf(volumeChange.getUid()), Integer.valueOf(volumeChange.getVolume()));
        }
    }

    public final void onLocalVideoChanged(Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "action");
        if (this instanceof LocalVideoChanged) {
            function1.invoke(Boolean.valueOf(((LocalVideoChanged) this).getEnable()));
        }
    }

    public final void onLocalAudioChanged(Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "action");
        if (this instanceof LocalAudioChanged) {
            function1.invoke(Boolean.valueOf(((LocalAudioChanged) this).getEnable()));
        }
    }

    public final void onNetworkQuality(Function3<? super Long, ? super Integer, ? super Integer, Unit> function3) {
        Intrinsics.checkNotNullParameter(function3, "action");
        if (this instanceof NetworkQuality) {
            NetworkQuality networkQuality = (NetworkQuality) this;
            function3.invoke(Long.valueOf(networkQuality.getUid()), Integer.valueOf(networkQuality.getUpQuality()), Integer.valueOf(networkQuality.getDownQuality()));
        }
    }

    public final void onStudentListUpdate(Function1<? super List<StudentVideoBean.ListBean>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "action");
        if (this instanceof StudentListUpdate) {
            function1.invoke(((StudentListUpdate) this).getList());
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/tal/app/thinkacademy/live/abilitypack/rtc/listenbody/RtcPlayerListenerBody$OnRtcStateChanged;", "Lcom/tal/app/thinkacademy/live/abilitypack/rtc/listenbody/RtcPlayerListenerBody;", "uid", "", "state", "Lcom/tal/app/thinkacademy/lib/player/rtcplayer/entity/RtcUserState;", "(JLcom/tal/app/thinkacademy/lib/player/rtcplayer/entity/RtcUserState;)V", "getState", "()Lcom/tal/app/thinkacademy/lib/player/rtcplayer/entity/RtcUserState;", "setState", "(Lcom/tal/app/thinkacademy/lib/player/rtcplayer/entity/RtcUserState;)V", "getUid", "()J", "setUid", "(J)V", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: RtcPlayerListenerBody.kt */
    public static final class OnRtcStateChanged extends RtcPlayerListenerBody {
        private RtcUserState state;
        private long uid;

        public static /* synthetic */ OnRtcStateChanged copy$default(OnRtcStateChanged onRtcStateChanged, long j, RtcUserState rtcUserState, int i, Object obj) {
            if ((i & 1) != 0) {
                j = onRtcStateChanged.uid;
            }
            if ((i & 2) != 0) {
                rtcUserState = onRtcStateChanged.state;
            }
            return onRtcStateChanged.copy(j, rtcUserState);
        }

        public final long component1() {
            return this.uid;
        }

        public final RtcUserState component2() {
            return this.state;
        }

        public final OnRtcStateChanged copy(long j, RtcUserState rtcUserState) {
            Intrinsics.checkNotNullParameter(rtcUserState, "state");
            return new OnRtcStateChanged(j, rtcUserState);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof OnRtcStateChanged)) {
                return false;
            }
            OnRtcStateChanged onRtcStateChanged = (OnRtcStateChanged) obj;
            return this.uid == onRtcStateChanged.uid && Intrinsics.areEqual(this.state, onRtcStateChanged.state);
        }

        public int hashCode() {
            return (SystemInfo$JavaHeap$.ExternalSyntheticBackport0.m(this.uid) * 31) + this.state.hashCode();
        }

        public String toString() {
            return "OnRtcStateChanged(uid=" + this.uid + ", state=" + this.state + ')';
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public OnRtcStateChanged(long j, RtcUserState rtcUserState) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(rtcUserState, "state");
            this.uid = j;
            this.state = rtcUserState;
        }

        public final RtcUserState getState() {
            return this.state;
        }

        public final long getUid() {
            return this.uid;
        }

        public final void setState(RtcUserState rtcUserState) {
            Intrinsics.checkNotNullParameter(rtcUserState, "<set-?>");
            this.state = rtcUserState;
        }

        public final void setUid(long j) {
            this.uid = j;
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/tal/app/thinkacademy/live/abilitypack/rtc/listenbody/RtcPlayerListenerBody$IsOnline;", "Lcom/tal/app/thinkacademy/live/abilitypack/rtc/listenbody/RtcPlayerListenerBody;", "uid", "", "state", "Lcom/tal/app/thinkacademy/lib/player/rtcplayer/entity/RtcUserState;", "(JLcom/tal/app/thinkacademy/lib/player/rtcplayer/entity/RtcUserState;)V", "getState", "()Lcom/tal/app/thinkacademy/lib/player/rtcplayer/entity/RtcUserState;", "setState", "(Lcom/tal/app/thinkacademy/lib/player/rtcplayer/entity/RtcUserState;)V", "getUid", "()J", "setUid", "(J)V", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: RtcPlayerListenerBody.kt */
    public static final class IsOnline extends RtcPlayerListenerBody {
        private RtcUserState state;
        private long uid;

        public static /* synthetic */ IsOnline copy$default(IsOnline isOnline, long j, RtcUserState rtcUserState, int i, Object obj) {
            if ((i & 1) != 0) {
                j = isOnline.uid;
            }
            if ((i & 2) != 0) {
                rtcUserState = isOnline.state;
            }
            return isOnline.copy(j, rtcUserState);
        }

        public final long component1() {
            return this.uid;
        }

        public final RtcUserState component2() {
            return this.state;
        }

        public final IsOnline copy(long j, RtcUserState rtcUserState) {
            Intrinsics.checkNotNullParameter(rtcUserState, "state");
            return new IsOnline(j, rtcUserState);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof IsOnline)) {
                return false;
            }
            IsOnline isOnline = (IsOnline) obj;
            return this.uid == isOnline.uid && Intrinsics.areEqual(this.state, isOnline.state);
        }

        public int hashCode() {
            return (SystemInfo$JavaHeap$.ExternalSyntheticBackport0.m(this.uid) * 31) + this.state.hashCode();
        }

        public String toString() {
            return "IsOnline(uid=" + this.uid + ", state=" + this.state + ')';
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public IsOnline(long j, RtcUserState rtcUserState) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(rtcUserState, "state");
            this.uid = j;
            this.state = rtcUserState;
        }

        public final RtcUserState getState() {
            return this.state;
        }

        public final long getUid() {
            return this.uid;
        }

        public final void setState(RtcUserState rtcUserState) {
            Intrinsics.checkNotNullParameter(rtcUserState, "<set-?>");
            this.state = rtcUserState;
        }

        public final void setUid(long j) {
            this.uid = j;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/tal/app/thinkacademy/live/abilitypack/rtc/listenbody/RtcPlayerListenerBody$VolumeChange;", "Lcom/tal/app/thinkacademy/live/abilitypack/rtc/listenbody/RtcPlayerListenerBody;", "uid", "", "volume", "", "(JI)V", "getUid", "()J", "setUid", "(J)V", "getVolume", "()I", "setVolume", "(I)V", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: RtcPlayerListenerBody.kt */
    public static final class VolumeChange extends RtcPlayerListenerBody {
        private long uid;
        private int volume;

        public static /* synthetic */ VolumeChange copy$default(VolumeChange volumeChange, long j, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                j = volumeChange.uid;
            }
            if ((i2 & 2) != 0) {
                i = volumeChange.volume;
            }
            return volumeChange.copy(j, i);
        }

        public final long component1() {
            return this.uid;
        }

        public final int component2() {
            return this.volume;
        }

        public final VolumeChange copy(long j, int i) {
            return new VolumeChange(j, i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof VolumeChange)) {
                return false;
            }
            VolumeChange volumeChange = (VolumeChange) obj;
            return this.uid == volumeChange.uid && this.volume == volumeChange.volume;
        }

        public int hashCode() {
            return (SystemInfo$JavaHeap$.ExternalSyntheticBackport0.m(this.uid) * 31) + this.volume;
        }

        public String toString() {
            return "VolumeChange(uid=" + this.uid + ", volume=" + this.volume + ')';
        }

        public VolumeChange(long j, int i) {
            super((DefaultConstructorMarker) null);
            this.uid = j;
            this.volume = i;
        }

        public final long getUid() {
            return this.uid;
        }

        public final int getVolume() {
            return this.volume;
        }

        public final void setUid(long j) {
            this.uid = j;
        }

        public final void setVolume(int i) {
            this.volume = i;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0011"}, d2 = {"Lcom/tal/app/thinkacademy/live/abilitypack/rtc/listenbody/RtcPlayerListenerBody$LocalAudioChanged;", "Lcom/tal/app/thinkacademy/live/abilitypack/rtc/listenbody/RtcPlayerListenerBody;", "enable", "", "(Z)V", "getEnable", "()Z", "setEnable", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: RtcPlayerListenerBody.kt */
    public static final class LocalAudioChanged extends RtcPlayerListenerBody {
        private boolean enable;

        public static /* synthetic */ LocalAudioChanged copy$default(LocalAudioChanged localAudioChanged, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = localAudioChanged.enable;
            }
            return localAudioChanged.copy(z);
        }

        public final boolean component1() {
            return this.enable;
        }

        public final LocalAudioChanged copy(boolean z) {
            return new LocalAudioChanged(z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof LocalAudioChanged) && this.enable == ((LocalAudioChanged) obj).enable;
        }

        public int hashCode() {
            boolean z = this.enable;
            if (z) {
                return 1;
            }
            return z ? 1 : 0;
        }

        public String toString() {
            return "LocalAudioChanged(enable=" + this.enable + ')';
        }

        public LocalAudioChanged(boolean z) {
            super((DefaultConstructorMarker) null);
            this.enable = z;
        }

        public final boolean getEnable() {
            return this.enable;
        }

        public final void setEnable(boolean z) {
            this.enable = z;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0011"}, d2 = {"Lcom/tal/app/thinkacademy/live/abilitypack/rtc/listenbody/RtcPlayerListenerBody$LocalVideoChanged;", "Lcom/tal/app/thinkacademy/live/abilitypack/rtc/listenbody/RtcPlayerListenerBody;", "enable", "", "(Z)V", "getEnable", "()Z", "setEnable", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: RtcPlayerListenerBody.kt */
    public static final class LocalVideoChanged extends RtcPlayerListenerBody {
        private boolean enable;

        public static /* synthetic */ LocalVideoChanged copy$default(LocalVideoChanged localVideoChanged, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = localVideoChanged.enable;
            }
            return localVideoChanged.copy(z);
        }

        public final boolean component1() {
            return this.enable;
        }

        public final LocalVideoChanged copy(boolean z) {
            return new LocalVideoChanged(z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof LocalVideoChanged) && this.enable == ((LocalVideoChanged) obj).enable;
        }

        public int hashCode() {
            boolean z = this.enable;
            if (z) {
                return 1;
            }
            return z ? 1 : 0;
        }

        public String toString() {
            return "LocalVideoChanged(enable=" + this.enable + ')';
        }

        public LocalVideoChanged(boolean z) {
            super((DefaultConstructorMarker) null);
            this.enable = z;
        }

        public final boolean getEnable() {
            return this.enable;
        }

        public final void setEnable(boolean z) {
            this.enable = z;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J'\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/tal/app/thinkacademy/live/abilitypack/rtc/listenbody/RtcPlayerListenerBody$NetworkQuality;", "Lcom/tal/app/thinkacademy/live/abilitypack/rtc/listenbody/RtcPlayerListenerBody;", "uid", "", "upQuality", "", "downQuality", "(JII)V", "getDownQuality", "()I", "setDownQuality", "(I)V", "getUid", "()J", "setUid", "(J)V", "getUpQuality", "setUpQuality", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: RtcPlayerListenerBody.kt */
    public static final class NetworkQuality extends RtcPlayerListenerBody {
        private int downQuality;
        private long uid;
        private int upQuality;

        public static /* synthetic */ NetworkQuality copy$default(NetworkQuality networkQuality, long j, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                j = networkQuality.uid;
            }
            if ((i3 & 2) != 0) {
                i = networkQuality.upQuality;
            }
            if ((i3 & 4) != 0) {
                i2 = networkQuality.downQuality;
            }
            return networkQuality.copy(j, i, i2);
        }

        public final long component1() {
            return this.uid;
        }

        public final int component2() {
            return this.upQuality;
        }

        public final int component3() {
            return this.downQuality;
        }

        public final NetworkQuality copy(long j, int i, int i2) {
            return new NetworkQuality(j, i, i2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof NetworkQuality)) {
                return false;
            }
            NetworkQuality networkQuality = (NetworkQuality) obj;
            return this.uid == networkQuality.uid && this.upQuality == networkQuality.upQuality && this.downQuality == networkQuality.downQuality;
        }

        public int hashCode() {
            return (((SystemInfo$JavaHeap$.ExternalSyntheticBackport0.m(this.uid) * 31) + this.upQuality) * 31) + this.downQuality;
        }

        public String toString() {
            return "NetworkQuality(uid=" + this.uid + ", upQuality=" + this.upQuality + ", downQuality=" + this.downQuality + ')';
        }

        public NetworkQuality(long j, int i, int i2) {
            super((DefaultConstructorMarker) null);
            this.uid = j;
            this.upQuality = i;
            this.downQuality = i2;
        }

        public final int getDownQuality() {
            return this.downQuality;
        }

        public final long getUid() {
            return this.uid;
        }

        public final int getUpQuality() {
            return this.upQuality;
        }

        public final void setDownQuality(int i) {
            this.downQuality = i;
        }

        public final void setUid(long j) {
            this.uid = j;
        }

        public final void setUpQuality(int i) {
            this.upQuality = i;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u0013"}, d2 = {"Lcom/tal/app/thinkacademy/live/abilitypack/rtc/listenbody/RtcPlayerListenerBody$StudentListUpdate;", "Lcom/tal/app/thinkacademy/live/abilitypack/rtc/listenbody/RtcPlayerListenerBody;", "list", "", "Lcom/tal/app/thinkacademy/live/business/studentvideo/bean/StudentVideoBean$ListBean;", "(Ljava/util/List;)V", "getList", "()Ljava/util/List;", "setList", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: RtcPlayerListenerBody.kt */
    public static final class StudentListUpdate extends RtcPlayerListenerBody {
        private List<StudentVideoBean.ListBean> list;

        public static /* synthetic */ StudentListUpdate copy$default(StudentListUpdate studentListUpdate, List<StudentVideoBean.ListBean> list2, int i, Object obj) {
            if ((i & 1) != 0) {
                list2 = studentListUpdate.list;
            }
            return studentListUpdate.copy(list2);
        }

        public final List<StudentVideoBean.ListBean> component1() {
            return this.list;
        }

        public final StudentListUpdate copy(List<StudentVideoBean.ListBean> list2) {
            Intrinsics.checkNotNullParameter(list2, "list");
            return new StudentListUpdate(list2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof StudentListUpdate) && Intrinsics.areEqual(this.list, ((StudentListUpdate) obj).list);
        }

        public int hashCode() {
            return this.list.hashCode();
        }

        public String toString() {
            return "StudentListUpdate(list=" + this.list + ')';
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public StudentListUpdate(List<StudentVideoBean.ListBean> list2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(list2, "list");
            this.list = list2;
        }

        public final List<StudentVideoBean.ListBean> getList() {
            return this.list;
        }

        public final void setList(List<StudentVideoBean.ListBean> list2) {
            Intrinsics.checkNotNullParameter(list2, "<set-?>");
            this.list = list2;
        }
    }
}
