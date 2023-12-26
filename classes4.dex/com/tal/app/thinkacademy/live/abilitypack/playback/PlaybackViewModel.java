package com.tal.app.thinkacademy.live.abilitypack.playback;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.tal.app.thinkacademy.common.entity.PlaybackUrlEntity;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.abilitypack.playback.bean.CourseWarePointBean;
import com.tal.app.thinkacademy.live.abilitypack.playback.bean.InteractPointBean;
import com.tal.app.thinkacademy.live.abilitypack.playback.bean.PageIndexData;
import com.tal.app.thinkacademy.live.abilitypack.playback.listenbody.PlaybackListenerBody;
import com.tal.app.thinkacademy.live.core.backplay.http.bean.MetaDataEvent;
import com.tal.app.thinkacademy.live.core.backplay.http.response.MetaDataEntity;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import com.tal.app.thinkacademy.live.core.live.abilitypack.AbilityViewModel;
import com.tal.app.thinkacademy.live.core.live.abilitypack.livedata.listener.ListenerData;
import com.tal.app.thinkacademy.live.core.live.datastorage.DataStorage;
import com.tal.app.thinkacademy.live.core.live.http.bean.PlanInfoProxy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0010\u0018\u0000 72\u00020\u0001:\u00017B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u001c\u001a\u00020\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fH\u0002J\u000e\u0010!\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u0015J(\u0010#\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020\r2\u0016\u0010%\u001a\u0012\u0012\u0004\u0012\u00020\r0\bj\b\u0012\u0004\u0012\u00020\r`\nH\u0002J\u0018\u0010&\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020(H\u0002J\u000e\u0010*\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u0015J\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018J\u0006\u0010,\u001a\u00020\u0006J\u0016\u0010-\u001a\u00020\u001d2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020 0\u0018H\u0002J\b\u0010/\u001a\u00020\u001dH\u0014J\u0006\u00100\u001a\u00020\u001dJ\u000e\u00101\u001a\u00020\u001d2\u0006\u00102\u001a\u00020\u0019J\u000e\u00103\u001a\u00020\u001d2\u0006\u00104\u001a\u00020\u0006J\u000e\u00105\u001a\u00020\u001d2\u0006\u00106\u001a\u00020\u0015R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\"\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\r\u0018\u0001`\nX\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lcom/tal/app/thinkacademy/live/abilitypack/playback/PlaybackViewModel;", "Lcom/tal/app/thinkacademy/live/core/live/abilitypack/AbilityViewModel;", "provider", "Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;", "(Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;)V", "isRefresh", "", "mCourseWarePointBeans", "Ljava/util/ArrayList;", "Lcom/tal/app/thinkacademy/live/abilitypack/playback/bean/CourseWarePointBean;", "Lkotlin/collections/ArrayList;", "mCurrentCourseWare", "mCurrentInteractPoint", "Lcom/tal/app/thinkacademy/live/abilitypack/playback/bean/InteractPointBean;", "mInteractPointBeans", "mListenerData", "Lcom/tal/app/thinkacademy/live/core/live/abilitypack/livedata/listener/ListenerData;", "Lcom/tal/app/thinkacademy/live/abilitypack/playback/listenbody/PlaybackListenerBody;", "getMListenerData", "()Lcom/tal/app/thinkacademy/live/core/live/abilitypack/livedata/listener/ListenerData;", "mOldSeiTimestamp", "", "mOpenPageIndex", "mPageIndexList", "", "Lcom/tal/app/thinkacademy/live/abilitypack/playback/bean/PageIndexData;", "mPlanInfo", "Lcom/tal/app/thinkacademy/live/core/live/http/bean/PlanInfoProxy;", "buildCourseWarePoints", "", "metaDataList", "", "Lcom/tal/app/thinkacademy/live/core/backplay/http/bean/MetaDataEvent;", "checkCoursewareState", "currentSeiTimestamp", "closeInteract", "currentPoint", "pointBeans", "dispatchIrcMessage", "ircType", "", "ircMsg", "dispatchMetaInfoWithSei", "getPageIndexList", "isOpenPageIndex", "obtainPageIndexList", "metadataList", "onVmDestroy", "refresh", "selectPageIndex", "data", "showPageIndexes", "show", "updatePlayProgress", "progress", "Companion", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PlaybackViewModel.kt */
public final class PlaybackViewModel extends AbilityViewModel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int INTERACT_HIT_OFFSET = 1000;
    private static final int METADATA_TIME_INTERVAL = 400;
    private static final Tag TAG_COURSE = Tag.COURSE_WARE;
    private static final Tag TAG_INTERACT = Tag.PLAYBACK_INTERACT;
    /* access modifiers changed from: private */
    public static final Tag TAG_PAGE = Tag.PLAYBACK_PAGE_INDEX;
    private boolean isRefresh;
    private ArrayList<CourseWarePointBean> mCourseWarePointBeans;
    private CourseWarePointBean mCurrentCourseWare;
    private InteractPointBean mCurrentInteractPoint;
    private ArrayList<InteractPointBean> mInteractPointBeans;
    private final ListenerData<PlaybackListenerBody> mListenerData = new ListenerData<>();
    private long mOldSeiTimestamp;
    private boolean mOpenPageIndex;
    /* access modifiers changed from: private */
    public List<PageIndexData> mPageIndexList;
    private PlanInfoProxy mPlanInfo;

    /* access modifiers changed from: protected */
    public void onVmDestroy() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PlaybackViewModel(ILiveRoomProvider iLiveRoomProvider) {
        super(iLiveRoomProvider);
        PlaybackUrlEntity playbackUrlResp;
        Intrinsics.checkNotNullParameter(iLiveRoomProvider, "provider");
        this.mPlanInfo = iLiveRoomProvider.getDataStorage().getPlanInfo();
        iLiveRoomProvider.addFrameworkRequestCallBack(new PlaybackViewModel$$ExternalSyntheticLambda0(iLiveRoomProvider, this));
        this.mPageIndexList = new ArrayList();
        DataStorage dataStorage = iLiveRoomProvider.getDataStorage();
        boolean z = false;
        if (!(dataStorage == null || (playbackUrlResp = dataStorage.getPlaybackUrlResp()) == null)) {
            z = playbackUrlResp.metadataAvailable;
        }
        this.mOpenPageIndex = z;
    }

    public final ListenerData<PlaybackListenerBody> getMListenerData() {
        return this.mListenerData;
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/tal/app/thinkacademy/live/abilitypack/playback/PlaybackViewModel$Companion;", "", "()V", "INTERACT_HIT_OFFSET", "", "METADATA_TIME_INTERVAL", "TAG_COURSE", "Lcom/tal/app/thinkacademy/live/Tag;", "TAG_INTERACT", "TAG_PAGE", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PlaybackViewModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-1  reason: not valid java name */
    public static final void m140_init_$lambda1(ILiveRoomProvider iLiveRoomProvider, PlaybackViewModel playbackViewModel) {
        List<MetaDataEvent> list;
        Intrinsics.checkNotNullParameter(iLiveRoomProvider, "$provider");
        Intrinsics.checkNotNullParameter(playbackViewModel, "this$0");
        MetaDataEntity metadataResp = iLiveRoomProvider.getDataStorage().getMetadataResp();
        if (metadataResp != null && (list = metadataResp.event) != null) {
            playbackViewModel.obtainPageIndexList(list);
            playbackViewModel.buildCourseWarePoints(list);
        }
    }

    public final boolean isOpenPageIndex() {
        return this.mOpenPageIndex;
    }

    private final void obtainPageIndexList(List<MetaDataEvent> list) {
        if (isOpenPageIndex()) {
            XesLog.i(TAG_PAGE, "回放翻页索功能开启");
            BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), (CoroutineContext) null, (CoroutineStart) null, new PlaybackViewModel$obtainPageIndexList$1(list, this, (Continuation<? super PlaybackViewModel$obtainPageIndexList$1>) null), 3, (Object) null);
        }
    }

    public final List<PageIndexData> getPageIndexList() {
        return this.mPageIndexList;
    }

    public final void showPageIndexes(boolean z) {
        if (isOpenPageIndex()) {
            this.mListenerData.postStickyData(new PlaybackListenerBody.PageIndexVisible(z));
        }
    }

    public final void updatePlayProgress(long j) {
        if (isOpenPageIndex()) {
            Collection collection = this.mPageIndexList;
            int i = 0;
            if (!(collection == null || collection.isEmpty())) {
                int i2 = -1;
                for (Object next : this.mPageIndexList) {
                    int i3 = i + 1;
                    if (i < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    if (j / ((long) 1000) >= ((PageIndexData) next).getOffsetTs()) {
                        i2 = i;
                    }
                    i = i3;
                }
                this.mListenerData.postStickyData(new PlaybackListenerBody.PageIndexChanged(i2));
            }
        }
    }

    public final void selectPageIndex(PageIndexData pageIndexData) {
        Intrinsics.checkNotNullParameter(pageIndexData, "data");
        if (isOpenPageIndex()) {
            this.mListenerData.postStickyData(new PlaybackListenerBody.PageIndexSelected(pageIndexData));
        }
    }

    public final void refresh() {
        this.isRefresh = true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x006a, code lost:
        r0 = new org.json.JSONObject(r0.getProperties()).optJSONObject(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0077, code lost:
        if (r0 != null) goto L_0x007a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x007a, code lost:
        r3 = r0.optJSONObject(r13);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, "ircType");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0083, code lost:
        if (r3 != null) goto L_0x0087;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0085, code lost:
        r14 = "";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0087, code lost:
        r3 = r3.optString("interactId");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x008d, code lost:
        if (r3 != null) goto L_0x0090;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0090, code lost:
        r14 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0091, code lost:
        r3 = com.tal.app.thinkacademy.live.abilitypack.playback.InteractDataFormat.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0095, code lost:
        if ((r0 instanceof org.json.JSONObject) != false) goto L_0x009c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0097, code lost:
        r5 = r0.toString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x009c, code lost:
        r5 = com.bonree.sdk.agent.engine.external.JSONObjectInstrumentation.toString(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00a3, code lost:
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, "toString()");
        r3 = r3.format(r13, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00aa, code lost:
        if (r3 != null) goto L_0x00ae;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00ac, code lost:
        r3 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00ae, code lost:
        r3 = r3.getPub();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00b2, code lost:
        r16 = r0.optLong("beginTime");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00ba, code lost:
        if ((r0 instanceof org.json.JSONObject) != false) goto L_0x00c1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00bc, code lost:
        r0 = r0.toString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00c1, code lost:
        r0 = com.bonree.sdk.agent.engine.external.JSONObjectInstrumentation.toString(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00c7, code lost:
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, "toString()");
        r12 = new com.tal.app.thinkacademy.live.abilitypack.playback.bean.InteractPointBean(r13, r14, r3, r16, r0);
        r0 = r1.mInteractPointBeans;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00d3, code lost:
        if (r0 != null) goto L_0x00d7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00d7, code lost:
        r0.add(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00f0, code lost:
        r0 = new org.json.JSONObject(r0.getProperties()).optJSONObject(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00fd, code lost:
        if (r0 != null) goto L_0x0101;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0101, code lost:
        r12 = r0.optJSONObject(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0105, code lost:
        if (r12 != null) goto L_0x0109;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0107, code lost:
        r8 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0109, code lost:
        r8 = r12.optJSONObject("currentCourseWare");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x010d, code lost:
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, "ircType");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0112, code lost:
        if (r8 != null) goto L_0x0116;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0114, code lost:
        r14 = "";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0116, code lost:
        r4 = r8.optString("pageId");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x011a, code lost:
        if (r4 != null) goto L_0x011d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x011d, code lost:
        r14 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x011e, code lost:
        if (r8 != null) goto L_0x0123;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0120, code lost:
        r4 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0123, code lost:
        r4 = r8.optLong("timestamp");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0129, code lost:
        if ((r0 instanceof org.json.JSONObject) != false) goto L_0x0130;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x012b, code lost:
        r0 = r0.toString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0130, code lost:
        r0 = com.bonree.sdk.agent.engine.external.JSONObjectInstrumentation.toString(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0136, code lost:
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, "toString()");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0139, code lost:
        if (r8 != null) goto L_0x013e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x013b, code lost:
        r18 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x013e, code lost:
        r18 = r8.optInt("blackBoardType");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0144, code lost:
        if (r8 != null) goto L_0x0149;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0146, code lost:
        r19 = "";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0149, code lost:
        r3 = r8.optString("specificLiveKey");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x014d, code lost:
        if (r3 != null) goto L_0x0150;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0150, code lost:
        r19 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0152, code lost:
        r12 = new com.tal.app.thinkacademy.live.abilitypack.playback.bean.CourseWarePointBean(r13, r14, r4, r0, r18, r19);
        r0 = r1.mCourseWarePointBeans;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x015b, code lost:
        if (r0 != null) goto L_0x015f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x015f, code lost:
        r0.add(r12);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void buildCourseWarePoints(java.util.List<? extends com.tal.app.thinkacademy.live.core.backplay.http.bean.MetaDataEvent> r24) {
        /*
            r23 = this;
            r1 = r23
            r0 = r24
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = com.xueersi.lib.graffiti.utils.ListUtil.isEmpty(r0)
            if (r0 == 0) goto L_0x000d
            return
        L_0x000d:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1.mCourseWarePointBeans = r0
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1.mInteractPointBeans = r0
            java.util.Iterator r2 = r24.iterator()
        L_0x001f:
            boolean r0 = r2.hasNext()
            java.lang.String r3 = "specificLiveKey"
            java.lang.String r4 = "pageId"
            java.lang.String r5 = "timestamp"
            java.lang.String r6 = "blackBoardType"
            java.lang.String r7 = "currentCourseWare"
            java.lang.String r9 = ""
            r10 = 1
            r11 = 0
            if (r0 == 0) goto L_0x0192
            java.lang.Object r0 = r2.next()
            com.tal.app.thinkacademy.live.core.backplay.http.bean.MetaDataEvent r0 = (com.tal.app.thinkacademy.live.core.backplay.http.bean.MetaDataEvent) r0
            java.lang.String r13 = r0.getIrcType()
            if (r13 == 0) goto L_0x0164
            int r12 = r13.hashCode()     // Catch:{ JSONException -> 0x0177 }
            java.lang.String r14 = "ircType"
            java.lang.String r15 = "toString()"
            switch(r12) {
                case -2122121021: goto L_0x00e6;
                case -1003324452: goto L_0x00dc;
                case -825898013: goto L_0x0060;
                case -249005160: goto L_0x0056;
                case 570398262: goto L_0x004c;
                default: goto L_0x004a;
            }
        L_0x004a:
            goto L_0x0164
        L_0x004c:
            java.lang.String r3 = "interact"
            boolean r3 = r13.equals(r3)     // Catch:{ JSONException -> 0x0177 }
            if (r3 != 0) goto L_0x006a
            goto L_0x0164
        L_0x0056:
            java.lang.String r3 = "fill_blank"
            boolean r3 = r13.equals(r3)     // Catch:{ JSONException -> 0x0177 }
            if (r3 != 0) goto L_0x006a
            goto L_0x0164
        L_0x0060:
            java.lang.String r3 = "game_interact"
            boolean r3 = r13.equals(r3)     // Catch:{ JSONException -> 0x0177 }
            if (r3 != 0) goto L_0x006a
            goto L_0x0164
        L_0x006a:
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0177 }
            java.lang.String r0 = r0.getProperties()     // Catch:{ JSONException -> 0x0177 }
            r3.<init>(r0)     // Catch:{ JSONException -> 0x0177 }
            org.json.JSONObject r0 = r3.optJSONObject(r13)     // Catch:{ JSONException -> 0x0177 }
            if (r0 != 0) goto L_0x007a
            goto L_0x001f
        L_0x007a:
            org.json.JSONObject r3 = r0.optJSONObject(r13)     // Catch:{ JSONException -> 0x0177 }
            com.tal.app.thinkacademy.live.abilitypack.playback.bean.InteractPointBean r4 = new com.tal.app.thinkacademy.live.abilitypack.playback.bean.InteractPointBean     // Catch:{ JSONException -> 0x0177 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, r14)     // Catch:{ JSONException -> 0x0177 }
            if (r3 != 0) goto L_0x0087
        L_0x0085:
            r14 = r9
            goto L_0x0091
        L_0x0087:
            java.lang.String r5 = "interactId"
            java.lang.String r3 = r3.optString(r5)     // Catch:{ JSONException -> 0x0177 }
            if (r3 != 0) goto L_0x0090
            goto L_0x0085
        L_0x0090:
            r14 = r3
        L_0x0091:
            com.tal.app.thinkacademy.live.abilitypack.playback.InteractDataFormat r3 = com.tal.app.thinkacademy.live.abilitypack.playback.InteractDataFormat.INSTANCE     // Catch:{ JSONException -> 0x0177 }
            boolean r5 = r0 instanceof org.json.JSONObject     // Catch:{ JSONException -> 0x0177 }
            if (r5 != 0) goto L_0x009c
            java.lang.String r5 = r0.toString()     // Catch:{ JSONException -> 0x0177 }
            goto L_0x00a3
        L_0x009c:
            r5 = r0
            org.json.JSONObject r5 = (org.json.JSONObject) r5     // Catch:{ JSONException -> 0x0177 }
            java.lang.String r5 = com.bonree.sdk.agent.engine.external.JSONObjectInstrumentation.toString(r5)     // Catch:{ JSONException -> 0x0177 }
        L_0x00a3:
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r15)     // Catch:{ JSONException -> 0x0177 }
            com.tal.app.thinkacademy.live.abilitypack.playback.bean.InteractData r3 = r3.format(r13, r5)     // Catch:{ JSONException -> 0x0177 }
            if (r3 != 0) goto L_0x00ae
            r3 = r11
            goto L_0x00b2
        L_0x00ae:
            boolean r3 = r3.getPub()     // Catch:{ JSONException -> 0x0177 }
        L_0x00b2:
            java.lang.String r5 = "beginTime"
            long r16 = r0.optLong(r5)     // Catch:{ JSONException -> 0x0177 }
            boolean r5 = r0 instanceof org.json.JSONObject     // Catch:{ JSONException -> 0x0177 }
            if (r5 != 0) goto L_0x00c1
            java.lang.String r0 = r0.toString()     // Catch:{ JSONException -> 0x0177 }
            goto L_0x00c7
        L_0x00c1:
            org.json.JSONObject r0 = (org.json.JSONObject) r0     // Catch:{ JSONException -> 0x0177 }
            java.lang.String r0 = com.bonree.sdk.agent.engine.external.JSONObjectInstrumentation.toString(r0)     // Catch:{ JSONException -> 0x0177 }
        L_0x00c7:
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r15)     // Catch:{ JSONException -> 0x0177 }
            r12 = r4
            r15 = r3
            r18 = r0
            r12.<init>(r13, r14, r15, r16, r18)     // Catch:{ JSONException -> 0x0177 }
            java.util.ArrayList<com.tal.app.thinkacademy.live.abilitypack.playback.bean.InteractPointBean> r0 = r1.mInteractPointBeans     // Catch:{ JSONException -> 0x0177 }
            if (r0 != 0) goto L_0x00d7
            goto L_0x001f
        L_0x00d7:
            r0.add(r4)     // Catch:{ JSONException -> 0x0177 }
            goto L_0x001f
        L_0x00dc:
            java.lang.String r12 = "canvas_switch_courseware"
            boolean r12 = r13.equals(r12)     // Catch:{ JSONException -> 0x0177 }
            if (r12 != 0) goto L_0x00f0
            goto L_0x0164
        L_0x00e6:
            java.lang.String r12 = "canvas_switch_courseware_f"
            boolean r12 = r13.equals(r12)     // Catch:{ JSONException -> 0x0177 }
            if (r12 != 0) goto L_0x00f0
            goto L_0x0164
        L_0x00f0:
            org.json.JSONObject r12 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0177 }
            java.lang.String r0 = r0.getProperties()     // Catch:{ JSONException -> 0x0177 }
            r12.<init>(r0)     // Catch:{ JSONException -> 0x0177 }
            org.json.JSONObject r0 = r12.optJSONObject(r13)     // Catch:{ JSONException -> 0x0177 }
            if (r0 != 0) goto L_0x0101
            goto L_0x001f
        L_0x0101:
            org.json.JSONObject r12 = r0.optJSONObject(r13)     // Catch:{ JSONException -> 0x0177 }
            if (r12 != 0) goto L_0x0109
            r8 = 0
            goto L_0x010d
        L_0x0109:
            org.json.JSONObject r8 = r12.optJSONObject(r7)     // Catch:{ JSONException -> 0x0177 }
        L_0x010d:
            com.tal.app.thinkacademy.live.abilitypack.playback.bean.CourseWarePointBean r7 = new com.tal.app.thinkacademy.live.abilitypack.playback.bean.CourseWarePointBean     // Catch:{ JSONException -> 0x0177 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, r14)     // Catch:{ JSONException -> 0x0177 }
            if (r8 != 0) goto L_0x0116
        L_0x0114:
            r14 = r9
            goto L_0x011e
        L_0x0116:
            java.lang.String r4 = r8.optString(r4)     // Catch:{ JSONException -> 0x0177 }
            if (r4 != 0) goto L_0x011d
            goto L_0x0114
        L_0x011d:
            r14 = r4
        L_0x011e:
            if (r8 != 0) goto L_0x0123
            r4 = 0
            goto L_0x0127
        L_0x0123:
            long r4 = r8.optLong(r5)     // Catch:{ JSONException -> 0x0177 }
        L_0x0127:
            boolean r12 = r0 instanceof org.json.JSONObject     // Catch:{ JSONException -> 0x0177 }
            if (r12 != 0) goto L_0x0130
            java.lang.String r0 = r0.toString()     // Catch:{ JSONException -> 0x0177 }
            goto L_0x0136
        L_0x0130:
            org.json.JSONObject r0 = (org.json.JSONObject) r0     // Catch:{ JSONException -> 0x0177 }
            java.lang.String r0 = com.bonree.sdk.agent.engine.external.JSONObjectInstrumentation.toString(r0)     // Catch:{ JSONException -> 0x0177 }
        L_0x0136:
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r15)     // Catch:{ JSONException -> 0x0177 }
            if (r8 != 0) goto L_0x013e
            r18 = r11
            goto L_0x0144
        L_0x013e:
            int r6 = r8.optInt(r6)     // Catch:{ JSONException -> 0x0177 }
            r18 = r6
        L_0x0144:
            if (r8 != 0) goto L_0x0149
        L_0x0146:
            r19 = r9
            goto L_0x0152
        L_0x0149:
            java.lang.String r3 = r8.optString(r3)     // Catch:{ JSONException -> 0x0177 }
            if (r3 != 0) goto L_0x0150
            goto L_0x0146
        L_0x0150:
            r19 = r3
        L_0x0152:
            r12 = r7
            r15 = r4
            r17 = r0
            r12.<init>(r13, r14, r15, r17, r18, r19)     // Catch:{ JSONException -> 0x0177 }
            java.util.ArrayList<com.tal.app.thinkacademy.live.abilitypack.playback.bean.CourseWarePointBean> r0 = r1.mCourseWarePointBeans     // Catch:{ JSONException -> 0x0177 }
            if (r0 != 0) goto L_0x015f
            goto L_0x001f
        L_0x015f:
            r0.add(r7)     // Catch:{ JSONException -> 0x0177 }
            goto L_0x001f
        L_0x0164:
            com.tal.app.thinkacademy.live.Tag r0 = TAG_INTERACT     // Catch:{ JSONException -> 0x0177 }
            com.tal.app.thinkacademy.lib.logger.XesLogTag r0 = (com.tal.app.thinkacademy.lib.logger.XesLogTag) r0     // Catch:{ JSONException -> 0x0177 }
            java.lang.Object[] r3 = new java.lang.Object[r10]     // Catch:{ JSONException -> 0x0177 }
            java.lang.String r4 = "不识别Irc类型 "
            java.lang.String r4 = kotlin.jvm.internal.Intrinsics.stringPlus(r4, r13)     // Catch:{ JSONException -> 0x0177 }
            r3[r11] = r4     // Catch:{ JSONException -> 0x0177 }
            com.tal.app.thinkacademy.lib.logger.XesLog.e(r0, r3)     // Catch:{ JSONException -> 0x0177 }
            goto L_0x001f
        L_0x0177:
            r0 = move-exception
            com.tal.app.thinkacademy.live.Tag r3 = TAG_INTERACT
            com.tal.app.thinkacademy.lib.logger.XesLogTag r3 = (com.tal.app.thinkacademy.lib.logger.XesLogTag) r3
            java.lang.Object[] r4 = new java.lang.Object[r10]
            java.lang.String r5 = r0.getMessage()
            java.lang.String r6 = "metadata 解析失败=="
            java.lang.String r5 = kotlin.jvm.internal.Intrinsics.stringPlus(r6, r5)
            r4[r11] = r5
            com.tal.app.thinkacademy.lib.logger.XesLog.e(r3, r4)
            r0.printStackTrace()
            goto L_0x001f
        L_0x0192:
            java.util.ArrayList<com.tal.app.thinkacademy.live.abilitypack.playback.bean.InteractPointBean> r0 = r1.mInteractPointBeans
            if (r0 != 0) goto L_0x0197
            goto L_0x01ef
        L_0x0197:
            r2 = r11
        L_0x0198:
            int r12 = r0.size()
            if (r2 >= r12) goto L_0x01ef
            java.lang.Object r12 = r0.get(r2)
            java.lang.String r13 = "pointBeans[i]"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r13)
            com.tal.app.thinkacademy.live.abilitypack.playback.bean.InteractPointBean r12 = (com.tal.app.thinkacademy.live.abilitypack.playback.bean.InteractPointBean) r12
            int r13 = r2 + 1
            int r14 = r0.size()
            if (r13 >= r14) goto L_0x01b8
            java.lang.Object r14 = r0.get(r13)
            com.tal.app.thinkacademy.live.abilitypack.playback.bean.InteractPointBean r14 = (com.tal.app.thinkacademy.live.abilitypack.playback.bean.InteractPointBean) r14
            goto L_0x01b9
        L_0x01b8:
            r14 = 0
        L_0x01b9:
            if (r14 == 0) goto L_0x01d6
            java.lang.String r15 = r14.getInteractId()
            java.lang.String r8 = r12.getInteractId()
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual(r15, r8)
            if (r8 == 0) goto L_0x01d6
            boolean r8 = r12.getPub()
            if (r8 == 0) goto L_0x01d6
            boolean r8 = r14.getPub()
            if (r8 != 0) goto L_0x01d6
            goto L_0x01ec
        L_0x01d6:
            r0.remove(r12)
            int r13 = r2 + -1
            com.tal.app.thinkacademy.live.Tag r2 = TAG_INTERACT
            com.tal.app.thinkacademy.lib.logger.XesLogTag r2 = (com.tal.app.thinkacademy.lib.logger.XesLogTag) r2
            java.lang.Object[] r8 = new java.lang.Object[r10]
            java.lang.String r14 = "删除互动点不对称，"
            java.lang.String r12 = kotlin.jvm.internal.Intrinsics.stringPlus(r14, r12)
            r8[r11] = r12
            com.tal.app.thinkacademy.lib.logger.XesLog.e(r2, r8)
        L_0x01ec:
            int r2 = r13 + 1
            goto L_0x0198
        L_0x01ef:
            java.util.ArrayList<com.tal.app.thinkacademy.live.abilitypack.playback.bean.CourseWarePointBean> r0 = r1.mCourseWarePointBeans
            if (r0 != 0) goto L_0x01f5
            goto L_0x0285
        L_0x01f5:
            r2 = r0
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r2.isEmpty()
            r2 = r2 ^ r10
            if (r2 == 0) goto L_0x0201
            r8 = r0
            goto L_0x0202
        L_0x0201:
            r8 = 0
        L_0x0202:
            if (r8 != 0) goto L_0x0206
            goto L_0x0285
        L_0x0206:
            java.lang.Object r0 = r8.get(r11)
            java.lang.String r2 = "it[0]"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            com.tal.app.thinkacademy.live.abilitypack.playback.bean.CourseWarePointBean r0 = (com.tal.app.thinkacademy.live.abilitypack.playback.bean.CourseWarePointBean) r0
            int r2 = r0.getBlackBoardType()
            r12 = 9
            if (r2 != r12) goto L_0x0285
            org.json.JSONObject r2 = new org.json.JSONObject
            r2.<init>()
            org.json.JSONObject r12 = new org.json.JSONObject
            r12.<init>()
            java.lang.String r13 = r0.getIrcType()
            org.json.JSONObject r14 = new org.json.JSONObject
            r14.<init>()
            org.json.JSONObject r7 = r14.put(r7, r12)
            r2.put(r13, r7)
            r7 = -10086(0xffffffffffffd89a, float:NaN)
            r12.put(r6, r7)
            long r6 = r0.getBeginTime()
            r13 = 10000(0x2710, float:1.4013E-41)
            long r13 = (long) r13
            long r6 = r6 - r13
            r12.put(r5, r6)
            java.lang.String r5 = "courseWareId"
            r12.put(r5, r9)
            java.lang.String r5 = "hw_empty_page"
            r12.put(r4, r5)
            java.lang.String r4 = r0.getSpecificLiveKey()
            r12.put(r3, r4)
            com.tal.app.thinkacademy.live.abilitypack.playback.bean.CourseWarePointBean r3 = new com.tal.app.thinkacademy.live.abilitypack.playback.bean.CourseWarePointBean
            java.lang.String r16 = r0.getIrcType()
            long r4 = r0.getBeginTime()
            long r18 = r4 - r13
            boolean r4 = r2 instanceof org.json.JSONObject
            if (r4 != 0) goto L_0x0269
            java.lang.String r2 = r2.toString()
            goto L_0x026f
        L_0x0269:
            org.json.JSONObject r2 = (org.json.JSONObject) r2
            java.lang.String r2 = com.bonree.sdk.agent.engine.external.JSONObjectInstrumentation.toString(r2)
        L_0x026f:
            java.lang.String r4 = "ircMsgObj.toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r4)
            r21 = -10086(0xffffffffffffd89a, float:NaN)
            java.lang.String r22 = r0.getSpecificLiveKey()
            java.lang.String r17 = "hw_empty_page"
            r15 = r3
            r20 = r2
            r15.<init>(r16, r17, r18, r20, r21, r22)
            r8.add(r11, r3)
        L_0x0285:
            com.tal.app.thinkacademy.lib.util.GsonUtil r0 = com.tal.app.thinkacademy.lib.util.GsonUtil.getInstance()
            java.util.ArrayList<com.tal.app.thinkacademy.live.abilitypack.playback.bean.CourseWarePointBean> r2 = r1.mCourseWarePointBeans
            java.lang.String r0 = r0.objToJson(r2)
            com.tal.app.thinkacademy.live.Tag r2 = TAG_INTERACT
            r3 = r2
            com.tal.app.thinkacademy.lib.logger.XesLogTag r3 = (com.tal.app.thinkacademy.lib.logger.XesLogTag) r3
            java.lang.Object[] r4 = new java.lang.Object[r10]
            java.lang.String r5 = "metadata翻页数据 装载成功=="
            java.lang.String r0 = kotlin.jvm.internal.Intrinsics.stringPlus(r5, r0)
            r4[r11] = r0
            com.tal.app.thinkacademy.lib.logger.XesLog.s(r3, r4)
            com.tal.app.thinkacademy.lib.util.GsonUtil r0 = com.tal.app.thinkacademy.lib.util.GsonUtil.getInstance()
            java.util.ArrayList<com.tal.app.thinkacademy.live.abilitypack.playback.bean.InteractPointBean> r3 = r1.mInteractPointBeans
            java.lang.String r0 = r0.objToJson(r3)
            com.tal.app.thinkacademy.lib.logger.XesLogTag r2 = (com.tal.app.thinkacademy.lib.logger.XesLogTag) r2
            java.lang.Object[] r3 = new java.lang.Object[r10]
            java.lang.String r4 = "metadata互动数据 装载成功=="
            java.lang.String r0 = kotlin.jvm.internal.Intrinsics.stringPlus(r4, r0)
            r3[r11] = r0
            com.tal.app.thinkacademy.lib.logger.XesLog.s(r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.abilitypack.playback.PlaybackViewModel.buildCourseWarePoints(java.util.List):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.tal.app.thinkacademy.live.abilitypack.playback.bean.CourseWarePointBean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.tal.app.thinkacademy.live.abilitypack.playback.bean.CourseWarePointBean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: com.tal.app.thinkacademy.live.abilitypack.playback.bean.CourseWarePointBean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v9, resolved type: com.tal.app.thinkacademy.live.abilitypack.playback.bean.CourseWarePointBean} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void checkCoursewareState(long r12) {
        /*
            r11 = this;
            java.util.ArrayList<com.tal.app.thinkacademy.live.abilitypack.playback.bean.CourseWarePointBean> r0 = r11.mCourseWarePointBeans
            if (r0 != 0) goto L_0x0006
            goto L_0x00b2
        L_0x0006:
            r1 = r0
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            r2 = 1
            r1 = r1 ^ r2
            r3 = 0
            if (r1 == 0) goto L_0x0013
            goto L_0x0014
        L_0x0013:
            r0 = r3
        L_0x0014:
            if (r0 != 0) goto L_0x0018
            goto L_0x00b2
        L_0x0018:
            r1 = r0
            java.util.List r1 = (java.util.List) r1
            int r4 = r1.size()
            java.util.ListIterator r1 = r1.listIterator(r4)
        L_0x0023:
            boolean r4 = r1.hasPrevious()
            r5 = 0
            if (r4 == 0) goto L_0x003f
            java.lang.Object r4 = r1.previous()
            r6 = r4
            com.tal.app.thinkacademy.live.abilitypack.playback.bean.CourseWarePointBean r6 = (com.tal.app.thinkacademy.live.abilitypack.playback.bean.CourseWarePointBean) r6
            long r6 = r6.getBeginTime()
            int r6 = (r6 > r12 ? 1 : (r6 == r12 ? 0 : -1))
            if (r6 > 0) goto L_0x003b
            r6 = r2
            goto L_0x003c
        L_0x003b:
            r6 = r5
        L_0x003c:
            if (r6 == 0) goto L_0x0023
            r3 = r4
        L_0x003f:
            com.tal.app.thinkacademy.live.abilitypack.playback.bean.CourseWarePointBean r3 = (com.tal.app.thinkacademy.live.abilitypack.playback.bean.CourseWarePointBean) r3
            r1 = 2
            java.lang.String r4 = "检测课件状态"
            java.lang.String r6 = "回放"
            r7 = 3
            if (r3 != 0) goto L_0x0075
            r3 = r11
            com.tal.app.thinkacademy.live.abilitypack.playback.PlaybackViewModel r3 = (com.tal.app.thinkacademy.live.abilitypack.playback.PlaybackViewModel) r3
            java.lang.Object r0 = r0.get(r5)
            java.lang.String r3 = "pointBeans[0]"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)
            r3 = r0
            com.tal.app.thinkacademy.live.abilitypack.playback.bean.CourseWarePointBean r3 = (com.tal.app.thinkacademy.live.abilitypack.playback.bean.CourseWarePointBean) r3
            com.tal.app.thinkacademy.live.abilitypack.playback.bean.CourseWarePointBean r0 = r11.mCurrentCourseWare
            if (r3 == r0) goto L_0x0075
            com.tal.app.thinkacademy.live.Tag r0 = TAG_COURSE
            com.tal.app.thinkacademy.lib.logger.XesLogTag r0 = (com.tal.app.thinkacademy.lib.logger.XesLogTag) r0
            java.lang.Object[] r8 = new java.lang.Object[r7]
            r8[r5] = r6
            r8[r2] = r4
            java.lang.Long r9 = java.lang.Long.valueOf(r12)
            java.lang.String r10 = "未命中查找第一页课件 sei:"
            java.lang.String r9 = kotlin.jvm.internal.Intrinsics.stringPlus(r10, r9)
            r8[r1] = r9
            com.tal.app.thinkacademy.lib.logger.XesLog.i(r0, r8)
        L_0x0075:
            com.tal.app.thinkacademy.live.abilitypack.playback.bean.CourseWarePointBean r0 = r11.mCurrentCourseWare
            if (r3 == r0) goto L_0x00b2
            com.tal.app.thinkacademy.live.Tag r0 = TAG_COURSE
            com.tal.app.thinkacademy.lib.logger.XesLogTag r0 = (com.tal.app.thinkacademy.lib.logger.XesLogTag) r0
            java.lang.Object[] r7 = new java.lang.Object[r7]
            r7[r5] = r6
            r7[r2] = r4
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "分发课件翻页信令 pageId:"
            r2.append(r4)
            java.lang.String r4 = r3.getPageId()
            r2.append(r4)
            java.lang.String r4 = " sei:"
            r2.append(r4)
            r2.append(r12)
            java.lang.String r12 = r2.toString()
            r7[r1] = r12
            com.tal.app.thinkacademy.lib.logger.XesLog.i(r0, r7)
            java.lang.String r12 = r3.getIrcType()
            java.lang.String r13 = r3.getIrcMsg()
            r11.dispatchIrcMessage(r12, r13)
            r11.mCurrentCourseWare = r3
        L_0x00b2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.abilitypack.playback.PlaybackViewModel.checkCoursewareState(long):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.tal.app.thinkacademy.live.abilitypack.playback.bean.InteractPointBean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.tal.app.thinkacademy.live.abilitypack.playback.bean.InteractPointBean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v5, resolved type: com.tal.app.thinkacademy.live.abilitypack.playback.bean.InteractPointBean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: com.tal.app.thinkacademy.live.abilitypack.playback.bean.InteractPointBean} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void dispatchMetaInfoWithSei(long r11) {
        /*
            r10 = this;
            long r0 = r10.mOldSeiTimestamp
            int r2 = (r11 > r0 ? 1 : (r11 == r0 ? 0 : -1))
            if (r2 < 0) goto L_0x0010
            long r0 = r11 - r0
            r2 = 400(0x190, double:1.976E-321)
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 < 0) goto L_0x000f
            goto L_0x0010
        L_0x000f:
            return
        L_0x0010:
            r10.mOldSeiTimestamp = r11
            com.tal.app.thinkacademy.live.Tag r0 = TAG_INTERACT
            com.tal.app.thinkacademy.lib.logger.XesLogTag r0 = (com.tal.app.thinkacademy.lib.logger.XesLogTag) r0
            r1 = 2
            java.lang.Object[] r2 = new java.lang.Object[r1]
            java.lang.String r3 = "2797badc9c86"
            r4 = 0
            r2[r4] = r3
            java.lang.Long r3 = java.lang.Long.valueOf(r11)
            java.lang.String r5 = "视频sei回调 2次/秒 "
            java.lang.String r3 = kotlin.jvm.internal.Intrinsics.stringPlus(r5, r3)
            r5 = 1
            r2[r5] = r3
            com.tal.app.thinkacademy.lib.logger.XesLog.i(r0, r2)
            java.util.ArrayList<com.tal.app.thinkacademy.live.abilitypack.playback.bean.InteractPointBean> r0 = r10.mInteractPointBeans
            if (r0 != 0) goto L_0x0034
            goto L_0x00fe
        L_0x0034:
            r2 = r0
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r2.isEmpty()
            r2 = r2 ^ r5
            r3 = 0
            if (r2 == 0) goto L_0x0040
            goto L_0x0041
        L_0x0040:
            r0 = r3
        L_0x0041:
            if (r0 != 0) goto L_0x0045
            goto L_0x00fe
        L_0x0045:
            r2 = r0
            java.util.List r2 = (java.util.List) r2
            int r6 = r2.size()
            java.util.ListIterator r2 = r2.listIterator(r6)
        L_0x0050:
            boolean r6 = r2.hasPrevious()
            if (r6 == 0) goto L_0x006b
            java.lang.Object r6 = r2.previous()
            r7 = r6
            com.tal.app.thinkacademy.live.abilitypack.playback.bean.InteractPointBean r7 = (com.tal.app.thinkacademy.live.abilitypack.playback.bean.InteractPointBean) r7
            long r7 = r7.getBeginTime()
            int r7 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r7 > 0) goto L_0x0067
            r7 = r5
            goto L_0x0068
        L_0x0067:
            r7 = r4
        L_0x0068:
            if (r7 == 0) goto L_0x0050
            r3 = r6
        L_0x006b:
            com.tal.app.thinkacademy.live.abilitypack.playback.bean.InteractPointBean r3 = (com.tal.app.thinkacademy.live.abilitypack.playback.bean.InteractPointBean) r3
            com.tal.app.thinkacademy.live.Tag r2 = TAG_INTERACT
            r6 = r2
            com.tal.app.thinkacademy.lib.logger.XesLogTag r6 = (com.tal.app.thinkacademy.lib.logger.XesLogTag) r6
            java.lang.Object[] r7 = new java.lang.Object[r1]
            java.lang.String r8 = "77eccb01491a"
            r7[r4] = r8
            java.lang.String r8 = "向左查找互动点 "
            java.lang.String r8 = kotlin.jvm.internal.Intrinsics.stringPlus(r8, r3)
            r7[r5] = r8
            com.tal.app.thinkacademy.lib.logger.XesLog.i(r6, r7)
            com.tal.app.thinkacademy.live.abilitypack.playback.bean.InteractPointBean r6 = r10.mCurrentInteractPoint
            if (r6 == 0) goto L_0x00ad
            r7 = r2
            com.tal.app.thinkacademy.lib.logger.XesLogTag r7 = (com.tal.app.thinkacademy.lib.logger.XesLogTag) r7
            java.lang.Object[] r8 = new java.lang.Object[r1]
            java.lang.String r9 = "744325859630"
            r8[r4] = r9
            java.lang.String r9 = "当前点是否存在 - 存在"
            r8[r5] = r9
            com.tal.app.thinkacademy.lib.logger.XesLog.i(r7, r8)
            if (r6 != r3) goto L_0x009a
            return
        L_0x009a:
            r7 = r2
            com.tal.app.thinkacademy.lib.logger.XesLogTag r7 = (com.tal.app.thinkacademy.lib.logger.XesLogTag) r7
            java.lang.Object[] r8 = new java.lang.Object[r1]
            java.lang.String r9 = "cec653d089fb"
            r8[r4] = r9
            java.lang.String r9 = "命中点与当前点是否一致 - 不一致"
            r8[r5] = r9
            com.tal.app.thinkacademy.lib.logger.XesLog.i(r7, r8)
            r10.closeInteract(r6, r0)
        L_0x00ad:
            if (r3 == 0) goto L_0x00fe
            long r6 = r3.getBeginTime()
            long r11 = r11 - r6
            r6 = 1000(0x3e8, double:4.94E-321)
            int r11 = (r11 > r6 ? 1 : (r11 == r6 ? 0 : -1))
            if (r11 >= 0) goto L_0x00fe
            com.tal.app.thinkacademy.live.abilitypack.playback.bean.InteractPointBean r11 = r10.mCurrentInteractPoint
            if (r11 == r3) goto L_0x00fe
            r11 = r2
            com.tal.app.thinkacademy.lib.logger.XesLogTag r11 = (com.tal.app.thinkacademy.lib.logger.XesLogTag) r11
            java.lang.Object[] r12 = new java.lang.Object[r1]
            java.lang.String r0 = "26a89b5f5502"
            r12[r4] = r0
            java.lang.String r0 = "判断命中点是否符合条件 - 是"
            r12[r5] = r0
            com.tal.app.thinkacademy.lib.logger.XesLog.s(r11, r12)
            r11 = r2
            com.tal.app.thinkacademy.lib.logger.XesLogTag r11 = (com.tal.app.thinkacademy.lib.logger.XesLogTag) r11
            java.lang.Object[] r12 = new java.lang.Object[r1]
            java.lang.String r0 = "b329a28539a8"
            r12[r4] = r0
            java.lang.String r0 = "分发命中点 "
            java.lang.String r0 = kotlin.jvm.internal.Intrinsics.stringPlus(r0, r3)
            r12[r5] = r0
            com.tal.app.thinkacademy.lib.logger.XesLog.i(r11, r12)
            java.lang.String r11 = r3.getIrcType()
            java.lang.String r12 = r3.getIrcMsg()
            r10.dispatchIrcMessage(r11, r12)
            com.tal.app.thinkacademy.lib.logger.XesLogTag r2 = (com.tal.app.thinkacademy.lib.logger.XesLogTag) r2
            java.lang.Object[] r11 = new java.lang.Object[r1]
            java.lang.String r12 = "b73bc627a3cc"
            r11[r4] = r12
            java.lang.String r12 = "命中点记为当前点"
            r11[r5] = r12
            com.tal.app.thinkacademy.lib.logger.XesLog.i(r2, r11)
            r10.mCurrentInteractPoint = r3
        L_0x00fe:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.abilitypack.playback.PlaybackViewModel.dispatchMetaInfoWithSei(long):void");
    }

    private final void closeInteract(InteractPointBean interactPointBean, ArrayList<InteractPointBean> arrayList) {
        if (interactPointBean.getPub()) {
            Tag tag = TAG_INTERACT;
            XesLog.i(tag, "174c8afdf0a5", "当前互动点是否为开启点 - 是开启点");
            int indexOf = arrayList.indexOf(interactPointBean) + 1;
            InteractPointBean interactPointBean2 = indexOf < arrayList.size() ? arrayList.get(indexOf) : null;
            if (interactPointBean2 == null || !Intrinsics.areEqual(interactPointBean2.getInteractId(), interactPointBean.getInteractId()) || interactPointBean2.getPub()) {
                XesLog.e(tag, "8acbee229c8b", "查找当前互动点的关闭点 - 未找到");
                return;
            }
            XesLog.i(tag, "adec15cdba42", "查找当前互动点的关闭点 - 找到");
            XesLog.i(tag, "099fb501293b", "分发关闭点");
            dispatchIrcMessage(interactPointBean2.getIrcType(), interactPointBean2.getIrcMsg());
            XesLog.i(tag, "a2262a4e7354", "关闭点记为当前点");
            this.mCurrentInteractPoint = interactPointBean2;
            return;
        }
        XesLog.i(TAG_INTERACT, "0ffbe9f8cf36", "当前互动点是否为开启点 - 不是开启点");
    }

    private final void dispatchIrcMessage(String str, String str2) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), (CoroutineContext) null, (CoroutineStart) null, new PlaybackViewModel$dispatchIrcMessage$1(this, str, str2, (Continuation<? super PlaybackViewModel$dispatchIrcMessage$1>) null), 3, (Object) null);
    }
}
