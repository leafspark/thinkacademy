package com.tal.app.thinkacademy.live.abilitypack.playback.listenbody;

import com.tal.app.thinkacademy.live.abilitypack.playback.bean.PageIndexData;
import com.tal.app.thinkacademy.live.core.live.abilitypack.livedata.listener.ListenerBody;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0004\u001a\u001b\u001c\u001dB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0000H\u0016J/\u0010\u000f\u001a\u00020\u00072'\u0010\u0010\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00070\u0004J)\u0010\u0014\u001a\u00020\u00072!\u0010\u0010\u001a\u001d\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00070\u0004J)\u0010\u0016\u001a\u00020\u00072!\u0010\u0010\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00070\u0004J)\u0010\u0018\u001a\u00020\u00072!\u0010\u0010\u001a\u001d\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00070\u0004R\"\u0010\u0003\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/tal/app/thinkacademy/live/abilitypack/playback/listenbody/PlaybackListenerBody;", "Lcom/tal/app/thinkacademy/live/core/live/abilitypack/livedata/listener/ListenerBody;", "()V", "mOnObtainPageIndexDataBlock", "Lkotlin/Function1;", "", "Lcom/tal/app/thinkacademy/live/abilitypack/playback/bean/PageIndexData;", "", "mPageIndexChangedBlock", "", "mPageIndexSelectedBlock", "mPageIndexVisibleBlock", "", "dispatch", "listener", "onObtainPageIndexData", "block", "Lkotlin/ParameterName;", "name", "list", "onPageIndexChanged", "index", "onPageIndexSelected", "data", "onPageIndexVisible", "visible", "ObtainPageIndexData", "PageIndexChanged", "PageIndexSelected", "PageIndexVisible", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PlaybackListenerBody.kt */
public class PlaybackListenerBody extends ListenerBody<PlaybackListenerBody> {
    private Function1<? super List<PageIndexData>, Unit> mOnObtainPageIndexDataBlock;
    private Function1<? super Integer, Unit> mPageIndexChangedBlock;
    private Function1<? super PageIndexData, Unit> mPageIndexSelectedBlock;
    private Function1<? super Boolean, Unit> mPageIndexVisibleBlock;

    public void dispatch(PlaybackListenerBody playbackListenerBody) {
        Function1<? super List<PageIndexData>, Unit> function1;
        Intrinsics.checkNotNullParameter(playbackListenerBody, "listener");
        if (playbackListenerBody instanceof PageIndexVisible) {
            Function1<? super Boolean, Unit> function12 = this.mPageIndexVisibleBlock;
            if (function12 != null) {
                function12.invoke(Boolean.valueOf(((PageIndexVisible) playbackListenerBody).getVisible()));
            }
        } else if (playbackListenerBody instanceof PageIndexSelected) {
            Function1<? super PageIndexData, Unit> function13 = this.mPageIndexSelectedBlock;
            if (function13 != null) {
                function13.invoke(((PageIndexSelected) playbackListenerBody).getData());
            }
        } else if (playbackListenerBody instanceof PageIndexChanged) {
            Function1<? super Integer, Unit> function14 = this.mPageIndexChangedBlock;
            if (function14 != null) {
                function14.invoke(Integer.valueOf(((PageIndexChanged) playbackListenerBody).getIndex()));
            }
        } else if ((playbackListenerBody instanceof ObtainPageIndexData) && (function1 = this.mOnObtainPageIndexDataBlock) != null) {
            function1.invoke(((ObtainPageIndexData) playbackListenerBody).getList());
        }
    }

    public final void onPageIndexVisible(Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        this.mPageIndexVisibleBlock = function1;
    }

    public final void onPageIndexSelected(Function1<? super PageIndexData, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        this.mPageIndexSelectedBlock = function1;
    }

    public final void onPageIndexChanged(Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        this.mPageIndexChangedBlock = function1;
    }

    public final void onObtainPageIndexData(Function1<? super List<PageIndexData>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        this.mOnObtainPageIndexDataBlock = function1;
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/tal/app/thinkacademy/live/abilitypack/playback/listenbody/PlaybackListenerBody$PageIndexVisible;", "Lcom/tal/app/thinkacademy/live/abilitypack/playback/listenbody/PlaybackListenerBody;", "visible", "", "(Z)V", "getVisible", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PlaybackListenerBody.kt */
    public static final class PageIndexVisible extends PlaybackListenerBody {
        private final boolean visible;

        public static /* synthetic */ PageIndexVisible copy$default(PageIndexVisible pageIndexVisible, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = pageIndexVisible.visible;
            }
            return pageIndexVisible.copy(z);
        }

        public final boolean component1() {
            return this.visible;
        }

        public final PageIndexVisible copy(boolean z) {
            return new PageIndexVisible(z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof PageIndexVisible) && this.visible == ((PageIndexVisible) obj).visible;
        }

        public int hashCode() {
            boolean z = this.visible;
            if (z) {
                return 1;
            }
            return z ? 1 : 0;
        }

        public String toString() {
            return "PageIndexVisible(visible=" + this.visible + ')';
        }

        public PageIndexVisible(boolean z) {
            this.visible = z;
        }

        public final boolean getVisible() {
            return this.visible;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/tal/app/thinkacademy/live/abilitypack/playback/listenbody/PlaybackListenerBody$PageIndexSelected;", "Lcom/tal/app/thinkacademy/live/abilitypack/playback/listenbody/PlaybackListenerBody;", "data", "Lcom/tal/app/thinkacademy/live/abilitypack/playback/bean/PageIndexData;", "(Lcom/tal/app/thinkacademy/live/abilitypack/playback/bean/PageIndexData;)V", "getData", "()Lcom/tal/app/thinkacademy/live/abilitypack/playback/bean/PageIndexData;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PlaybackListenerBody.kt */
    public static final class PageIndexSelected extends PlaybackListenerBody {
        private final PageIndexData data;

        public static /* synthetic */ PageIndexSelected copy$default(PageIndexSelected pageIndexSelected, PageIndexData pageIndexData, int i, Object obj) {
            if ((i & 1) != 0) {
                pageIndexData = pageIndexSelected.data;
            }
            return pageIndexSelected.copy(pageIndexData);
        }

        public final PageIndexData component1() {
            return this.data;
        }

        public final PageIndexSelected copy(PageIndexData pageIndexData) {
            Intrinsics.checkNotNullParameter(pageIndexData, "data");
            return new PageIndexSelected(pageIndexData);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof PageIndexSelected) && Intrinsics.areEqual(this.data, ((PageIndexSelected) obj).data);
        }

        public int hashCode() {
            return this.data.hashCode();
        }

        public String toString() {
            return "PageIndexSelected(data=" + this.data + ')';
        }

        public PageIndexSelected(PageIndexData pageIndexData) {
            Intrinsics.checkNotNullParameter(pageIndexData, "data");
            this.data = pageIndexData;
        }

        public final PageIndexData getData() {
            return this.data;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/tal/app/thinkacademy/live/abilitypack/playback/listenbody/PlaybackListenerBody$PageIndexChanged;", "Lcom/tal/app/thinkacademy/live/abilitypack/playback/listenbody/PlaybackListenerBody;", "index", "", "(I)V", "getIndex", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PlaybackListenerBody.kt */
    public static final class PageIndexChanged extends PlaybackListenerBody {
        private final int index;

        public static /* synthetic */ PageIndexChanged copy$default(PageIndexChanged pageIndexChanged, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = pageIndexChanged.index;
            }
            return pageIndexChanged.copy(i);
        }

        public final int component1() {
            return this.index;
        }

        public final PageIndexChanged copy(int i) {
            return new PageIndexChanged(i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof PageIndexChanged) && this.index == ((PageIndexChanged) obj).index;
        }

        public int hashCode() {
            return this.index;
        }

        public String toString() {
            return "PageIndexChanged(index=" + this.index + ')';
        }

        public PageIndexChanged(int i) {
            this.index = i;
        }

        public final int getIndex() {
            return this.index;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/tal/app/thinkacademy/live/abilitypack/playback/listenbody/PlaybackListenerBody$ObtainPageIndexData;", "Lcom/tal/app/thinkacademy/live/abilitypack/playback/listenbody/PlaybackListenerBody;", "list", "", "Lcom/tal/app/thinkacademy/live/abilitypack/playback/bean/PageIndexData;", "(Ljava/util/List;)V", "getList", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PlaybackListenerBody.kt */
    public static final class ObtainPageIndexData extends PlaybackListenerBody {
        private final List<PageIndexData> list;

        public static /* synthetic */ ObtainPageIndexData copy$default(ObtainPageIndexData obtainPageIndexData, List<PageIndexData> list2, int i, Object obj) {
            if ((i & 1) != 0) {
                list2 = obtainPageIndexData.list;
            }
            return obtainPageIndexData.copy(list2);
        }

        public final List<PageIndexData> component1() {
            return this.list;
        }

        public final ObtainPageIndexData copy(List<PageIndexData> list2) {
            Intrinsics.checkNotNullParameter(list2, "list");
            return new ObtainPageIndexData(list2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ObtainPageIndexData) && Intrinsics.areEqual(this.list, ((ObtainPageIndexData) obj).list);
        }

        public int hashCode() {
            return this.list.hashCode();
        }

        public String toString() {
            return "ObtainPageIndexData(list=" + this.list + ')';
        }

        public ObtainPageIndexData(List<PageIndexData> list2) {
            Intrinsics.checkNotNullParameter(list2, "list");
            this.list = list2;
        }

        public final List<PageIndexData> getList() {
            return this.list;
        }
    }
}
