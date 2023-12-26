package com.tal.app.thinkacademy.common.entity;

import com.tal.app.thinkacademy.lib.player.track.VideoPlayerSceneType;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u0011\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/tal/app/thinkacademy/common/entity/HwCommonPlayerParams;", "Ljava/io/Serializable;", "videoName", "", "sceneType", "Lcom/tal/app/thinkacademy/lib/player/track/VideoPlayerSceneType;", "urls", "", "(Ljava/lang/String;Lcom/tal/app/thinkacademy/lib/player/track/VideoPlayerSceneType;Ljava/util/List;)V", "getSceneType", "()Lcom/tal/app/thinkacademy/lib/player/track/VideoPlayerSceneType;", "getUrls", "()Ljava/util/List;", "getVideoName", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HwCommonPlayerParams.kt */
public final class HwCommonPlayerParams implements Serializable {
    private final VideoPlayerSceneType sceneType;
    private final List<String> urls;
    private final String videoName;

    public HwCommonPlayerParams() {
        this((String) null, (VideoPlayerSceneType) null, (List) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ HwCommonPlayerParams copy$default(HwCommonPlayerParams hwCommonPlayerParams, String str, VideoPlayerSceneType videoPlayerSceneType, List<String> list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = hwCommonPlayerParams.videoName;
        }
        if ((i & 2) != 0) {
            videoPlayerSceneType = hwCommonPlayerParams.sceneType;
        }
        if ((i & 4) != 0) {
            list = hwCommonPlayerParams.urls;
        }
        return hwCommonPlayerParams.copy(str, videoPlayerSceneType, list);
    }

    public final String component1() {
        return this.videoName;
    }

    public final VideoPlayerSceneType component2() {
        return this.sceneType;
    }

    public final List<String> component3() {
        return this.urls;
    }

    public final HwCommonPlayerParams copy(String str, VideoPlayerSceneType videoPlayerSceneType, List<String> list) {
        Intrinsics.checkNotNullParameter(videoPlayerSceneType, "sceneType");
        return new HwCommonPlayerParams(str, videoPlayerSceneType, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HwCommonPlayerParams)) {
            return false;
        }
        HwCommonPlayerParams hwCommonPlayerParams = (HwCommonPlayerParams) obj;
        return Intrinsics.areEqual(this.videoName, hwCommonPlayerParams.videoName) && this.sceneType == hwCommonPlayerParams.sceneType && Intrinsics.areEqual(this.urls, hwCommonPlayerParams.urls);
    }

    public int hashCode() {
        String str = this.videoName;
        int i = 0;
        int hashCode = (((str == null ? 0 : str.hashCode()) * 31) + this.sceneType.hashCode()) * 31;
        List<String> list = this.urls;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "HwCommonPlayerParams(videoName=" + this.videoName + ", sceneType=" + this.sceneType + ", urls=" + this.urls + ')';
    }

    public HwCommonPlayerParams(String str, VideoPlayerSceneType videoPlayerSceneType, List<String> list) {
        Intrinsics.checkNotNullParameter(videoPlayerSceneType, "sceneType");
        this.videoName = str;
        this.sceneType = videoPlayerSceneType;
        this.urls = list;
    }

    public final String getVideoName() {
        return this.videoName;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HwCommonPlayerParams(String str, VideoPlayerSceneType videoPlayerSceneType, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? VideoPlayerSceneType.UNKNOWN : videoPlayerSceneType, (i & 4) != 0 ? null : list);
    }

    public final VideoPlayerSceneType getSceneType() {
        return this.sceneType;
    }

    public final List<String> getUrls() {
        return this.urls;
    }
}
