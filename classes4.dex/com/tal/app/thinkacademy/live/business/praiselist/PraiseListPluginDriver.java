package com.tal.app.thinkacademy.live.business.praiselist;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.Observer;
import com.bonree.sdk.agent.engine.external.JSONObjectInstrumentation;
import com.tal.app.thinkacademy.annotation.plugin.PluginAnnotation;
import com.tal.app.thinkacademy.annotation.plugin.ViewLevel;
import com.tal.app.thinkacademy.annotation.plugin.ViewLevels;
import com.tal.app.thinkacademy.common.aws.AwsS3Util;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.GsonUtils;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.abilitypack.praiselist.PraiseListViewModel;
import com.tal.app.thinkacademy.live.abilitypack.praiselist.PraiseListViewModelKt;
import com.tal.app.thinkacademy.live.abilitypack.praiselist.listenbody.PraiseListListenerBody;
import com.tal.app.thinkacademy.live.business.praiselist.bean.PraiseListData;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaContext;
import com.tal.app.thinkacademy.live.core.live.abilitypack.AbilityPack;
import com.tal.app.thinkacademy.live.core.live.abilitypack.livedata.listener.ListenerData;
import com.tal.app.thinkacademy.live.core.plugin.BaseLivePluginDriver;
import com.tal.app.thinkacademy.live.core.plugin.pluginview.BaseLivePluginView;
import com.tal.app.thinkacademy.live.util.InteractLogReport;
import com.tal.app.thinkcademy.lib.commui.widget.likegroup.LikeMessage;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@PluginAnnotation(desc = "课堂表扬榜", ircType = {"class_praise_list", "praise_list_point_like"}, moduleId = "255")
@ViewLevels({@ViewLevel(level = 30, name = "classroom_praise_list")})
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u0015H\u0016J\u001c\u0010\u001a\u001a\u00020\u00152\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001e\u001a\u00020\u0015H\u0002R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u0004\u0018\u00010\bX\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/tal/app/thinkacademy/live/business/praiselist/PraiseListPluginDriver;", "Lcom/tal/app/thinkacademy/live/core/plugin/BaseLivePluginDriver;", "provider", "Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;", "bundle", "Landroid/os/Bundle;", "(Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;Landroid/os/Bundle;)V", "mClassId", "", "Ljava/lang/Integer;", "mContext", "Landroid/content/Context;", "mLayoutChange", "Landroidx/lifecycle/Observer;", "Lcom/tal/app/thinkacademy/live/core/layout/LiveAreaContext;", "mPlanId", "mPraiseListPluginView", "Lcom/tal/app/thinkacademy/live/business/praiselist/PraiseListPluginView;", "mPraiseListViewModel", "Lcom/tal/app/thinkacademy/live/abilitypack/praiselist/PraiseListViewModel;", "destroyDriver", "", "loadView", "data", "Lcom/tal/app/thinkacademy/live/business/praiselist/bean/PraiseListData;", "onDestroy", "onMessage", "ircTypeKey", "", "message", "removeView", "Companion", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PraiseListPluginDriver.kt */
public final class PraiseListPluginDriver extends BaseLivePluginDriver {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final Tag TAG = Tag.PRAISE_LIST;
    private static final String TARGET = "PraiseList";
    private final Integer mClassId;
    private final Context mContext;
    private final Observer<LiveAreaContext> mLayoutChange;
    private final Integer mPlanId;
    /* access modifiers changed from: private */
    public PraiseListPluginView mPraiseListPluginView;
    private PraiseListViewModel mPraiseListViewModel = PraiseListViewModelKt.getPraiseListViewModel(AbilityPack.Companion.get());

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x005e, code lost:
        r4 = (r4 = (r4 = r4.getDataStorage()).getPlanInfo()).getId();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public PraiseListPluginDriver(com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider r4, android.os.Bundle r5) {
        /*
            r3 = this;
            java.lang.String r0 = "provider"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "bundle"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            r3.<init>(r4, r5)
            com.tal.app.thinkacademy.live.core.live.abilitypack.AbilityPack$Companion r4 = com.tal.app.thinkacademy.live.core.live.abilitypack.AbilityPack.Companion
            com.tal.app.thinkacademy.live.core.live.abilitypack.AbilityPack r4 = r4.get()
            com.tal.app.thinkacademy.live.abilitypack.praiselist.PraiseListViewModel r4 = com.tal.app.thinkacademy.live.abilitypack.praiselist.PraiseListViewModelKt.getPraiseListViewModel(r4)
            r3.mPraiseListViewModel = r4
            com.tal.app.thinkacademy.live.business.praiselist.PraiseListPluginDriver$$ExternalSyntheticLambda0 r4 = new com.tal.app.thinkacademy.live.business.praiselist.PraiseListPluginDriver$$ExternalSyntheticLambda0
            r4.<init>(r3)
            r3.mLayoutChange = r4
            com.tal.app.thinkacademy.live.Tag r5 = TAG
            com.tal.app.thinkacademy.lib.logger.XesLogTag r5 = (com.tal.app.thinkacademy.lib.logger.XesLogTag) r5
            r0 = 1
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.String r1 = "init"
            r2 = 0
            r0[r2] = r1
            com.tal.app.thinkacademy.lib.logger.XesLog.i(r5, r0)
            com.tal.app.thinkacademy.live.core.layout.LiveAreaContext r5 = com.tal.app.thinkacademy.live.core.layout.LiveAreaContext.get()
            com.tal.app.thinkacademy.live.core.layout.LayoutLiveData r5 = r5.layoutObserver
            r0 = r3
            androidx.lifecycle.LifecycleOwner r0 = (androidx.lifecycle.LifecycleOwner) r0
            r5.observe(r0, r4)
            com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider r4 = r3.mLiveRoomProvider
            java.lang.ref.WeakReference r4 = r4.getWeakRefContext()
            java.lang.Object r4 = r4.get()
            android.content.Context r4 = (android.content.Context) r4
            r3.mContext = r4
            com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider r4 = r3.mLiveRoomProvider
            r5 = 0
            if (r4 != 0) goto L_0x0050
        L_0x004e:
            r4 = r5
            goto L_0x006d
        L_0x0050:
            com.tal.app.thinkacademy.live.core.live.datastorage.DataStorage r4 = r4.getDataStorage()
            if (r4 != 0) goto L_0x0057
            goto L_0x004e
        L_0x0057:
            com.tal.app.thinkacademy.live.core.live.http.bean.PlanInfoProxy r4 = r4.getPlanInfo()
            if (r4 != 0) goto L_0x005e
            goto L_0x004e
        L_0x005e:
            java.lang.String r4 = r4.getId()
            if (r4 != 0) goto L_0x0065
            goto L_0x004e
        L_0x0065:
            int r4 = java.lang.Integer.parseInt(r4)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
        L_0x006d:
            r3.mPlanId = r4
            com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider r4 = r3.mLiveRoomProvider
            if (r4 != 0) goto L_0x0074
            goto L_0x008a
        L_0x0074:
            com.tal.app.thinkacademy.live.core.live.datastorage.DataStorage r4 = r4.getDataStorage()
            if (r4 != 0) goto L_0x007b
            goto L_0x008a
        L_0x007b:
            com.tal.app.thinkacademy.live.core.live.http.bean.CourseInfoProxy r4 = r4.getCourseInfo()
            if (r4 != 0) goto L_0x0082
            goto L_0x008a
        L_0x0082:
            int r4 = r4.getClassId()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r4)
        L_0x008a:
            r3.mClassId = r5
            com.tal.app.thinkacademy.live.abilitypack.praiselist.PraiseListViewModel r4 = r3.mPraiseListViewModel
            if (r4 != 0) goto L_0x0091
            goto L_0x00a4
        L_0x0091:
            com.tal.app.thinkacademy.live.core.live.abilitypack.livedata.listener.ListenerData r4 = r4.getMListenerData()
            if (r4 != 0) goto L_0x0098
            goto L_0x00a4
        L_0x0098:
            com.tal.app.thinkacademy.live.business.praiselist.PraiseListPluginDriver$1 r5 = new com.tal.app.thinkacademy.live.business.praiselist.PraiseListPluginDriver$1
            r5.<init>(r3)
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            java.lang.String r1 = "PraiseList"
            r4.observeListener(r0, r2, r1, r5)
        L_0x00a4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.praiselist.PraiseListPluginDriver.<init>(com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider, android.os.Bundle):void");
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/praiselist/PraiseListPluginDriver$Companion;", "", "()V", "TAG", "Lcom/tal/app/thinkacademy/live/Tag;", "TARGET", "", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PraiseListPluginDriver.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: mLayoutChange$lambda-2  reason: not valid java name */
    public static final void m383mLayoutChange$lambda2(PraiseListPluginDriver praiseListPluginDriver, LiveAreaContext liveAreaContext) {
        Intrinsics.checkNotNullParameter(praiseListPluginDriver, "this$0");
        XesLog.e(TAG, "布局大小变化");
        PraiseListPluginView praiseListPluginView = praiseListPluginDriver.mPraiseListPluginView;
        if (praiseListPluginView != null) {
            ViewGroup.LayoutParams layoutParams = praiseListPluginView.getLayoutParams();
            FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : null;
            if (layoutParams2 != null) {
                liveAreaContext.getPptLp().mergeLp(layoutParams2);
                praiseListPluginView.setLayoutParams(layoutParams2);
            }
            praiseListPluginView.refreshLayout(liveAreaContext.getPptLp().height);
        }
    }

    public void onMessage(String str, String str2) {
        if (str2 == null) {
            XesLog.e(TAG, Intrinsics.stringPlus("信令消息为空：", str));
        } else if (Intrinsics.areEqual(str, "class_praise_list")) {
            try {
                JSONObject optJSONObject = new JSONObject(str2).optJSONObject("data");
                PraiseListData praiseListData = (PraiseListData) GsonUtils.fromJson(optJSONObject == null ? null : !(optJSONObject instanceof JSONObject) ? optJSONObject.toString() : JSONObjectInstrumentation.toString(optJSONObject), PraiseListData.class);
                if (praiseListData != null) {
                    if (praiseListData.getPub()) {
                        Tag tag = TAG;
                        XesLog.i(tag, Intrinsics.stringPlus("开启互动 interactId:", praiseListData.getInteractId()));
                        if (praiseListData.getPublishType() == 1) {
                            XesLog.i(tag, Intrinsics.stringPlus("新互动 移除当前视图，isUpdate:", Boolean.valueOf(praiseListData.isUpdate())));
                            removeView();
                            if (this.mPraiseListPluginView == null) {
                                XesLog.i(tag, "初始化视图");
                                loadView(praiseListData);
                                return;
                            }
                            return;
                        }
                        if (!praiseListData.isUpdate()) {
                            XesLog.i(tag, Intrinsics.stringPlus("新互动 移除当前视图，isUpdate:", Boolean.valueOf(praiseListData.isUpdate())));
                            removeView();
                        }
                        if (this.mPraiseListPluginView == null) {
                            XesLog.i(tag, "初始化视图");
                            loadView(praiseListData);
                        }
                        if (praiseListData.isUpdate()) {
                            boolean areEqual = Intrinsics.areEqual(praiseListData.getPosition(), "forward");
                            XesLog.i(tag, "更新榜单 isForward:" + areEqual + ", showStudentNum:" + praiseListData.getShowStudentNum());
                            PraiseListPluginView praiseListPluginView = this.mPraiseListPluginView;
                            if (praiseListPluginView != null) {
                                praiseListPluginView.update(areEqual, praiseListData.getShowStudentNum());
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    XesLog.i(TAG, "关闭互动");
                    destroyDriver();
                }
            } catch (Exception e) {
                XesLog.e(TAG, Intrinsics.stringPlus("信令处理错误：", e));
            }
        } else if (Intrinsics.areEqual(str, "praise_list_point_like")) {
            XesLog.i(TAG, Intrinsics.stringPlus("点赞消息信令:", str2));
            try {
                JSONObject jSONObject = new JSONObject(str2);
                String optString = jSONObject.optString(AwsS3Util.scene_avatar);
                int optInt = jSONObject.optInt("likeNum");
                String optString2 = jSONObject.optString("interactId");
                Intrinsics.checkNotNullExpressionValue(optString, AwsS3Util.scene_avatar);
                LikeMessage likeMessage = new LikeMessage(optString, optInt, System.currentTimeMillis());
                PraiseListPluginView praiseListPluginView2 = this.mPraiseListPluginView;
                if (praiseListPluginView2 != null) {
                    Intrinsics.checkNotNullExpressionValue(optString2, "interactId");
                    praiseListPluginView2.addLikeMessage(optString2, likeMessage);
                }
            } catch (Exception e2) {
                XesLog.e(TAG, Intrinsics.stringPlus("点赞信令处理错误：", e2));
            }
        }
    }

    private final void loadView(PraiseListData praiseListData) {
        Context context = this.mContext;
        if (context != null) {
            BaseLivePluginView praiseListPluginView = new PraiseListPluginView(context, praiseListData);
            this.mPraiseListPluginView = praiseListPluginView;
            FrameLayout.LayoutParams newLp = LiveAreaContext.get().getPptLp().newLp();
            this.mLiveRoomProvider.addView((BaseLivePluginDriver) this, praiseListPluginView, "classroom_praise_list", newLp);
            praiseListPluginView.refreshLayout(newLp.height);
            Integer num = this.mPlanId;
            if (num != null) {
                int intValue = num.intValue();
                Integer num2 = this.mClassId;
                if (num2 != null) {
                    InteractLogReport.uploadLog(praiseListData.getInteractId(), intValue, num2.intValue());
                }
            }
        }
    }

    private final void destroyDriver() {
        removeView();
        destroy();
    }

    private final void removeView() {
        PraiseListPluginView praiseListPluginView = this.mPraiseListPluginView;
        if (praiseListPluginView != null) {
            XesLog.i(TAG, "移除视图");
            praiseListPluginView.destroy();
            this.mLiveRoomProvider.removeView((View) praiseListPluginView);
        }
        this.mPraiseListPluginView = null;
    }

    public void onDestroy() {
        ListenerData<PraiseListListenerBody> mListenerData;
        XesLog.i(TAG, "插件销毁");
        LiveAreaContext.get().layoutObserver.removeObserver(this.mLayoutChange);
        PraiseListViewModel praiseListViewModel = this.mPraiseListViewModel;
        if (!(praiseListViewModel == null || (mListenerData = praiseListViewModel.getMListenerData()) == null)) {
            mListenerData.removeListener(TARGET);
        }
        removeView();
    }
}
