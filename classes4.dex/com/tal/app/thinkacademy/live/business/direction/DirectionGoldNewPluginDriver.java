package com.tal.app.thinkacademy.live.business.direction;

import android.content.Context;
import android.util.Log;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.tal.app.thinkacademy.annotation.plugin.PluginAnnotation;
import com.tal.app.thinkacademy.annotation.plugin.ViewLevel;
import com.tal.app.thinkacademy.annotation.plugin.ViewLevels;
import com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager;
import com.tal.app.thinkacademy.lib.interfaces.route.DataBusKey;
import com.tal.app.thinkacademy.lib.interfaces.route.ShareDataKey;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.network.exception.HandlerException;
import com.tal.app.thinkacademy.live.Tag;
import com.tal.app.thinkacademy.live.abilitypack.coincenter.CoinEventData;
import com.tal.app.thinkacademy.live.business.GoldSource;
import com.tal.app.thinkacademy.live.business.redpackagerain.RedPackageRainPluginDriver;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import com.tal.app.thinkacademy.live.core.plugin.BaseLivePluginDriver;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventBus;
import com.tal.app.thinkacademy.live.core.plugin.PluginEventData;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import org.json.JSONObject;

@PluginAnnotation(classType = 10086, desc = "定向金币", ircType = {"distribute_coins"}, moduleId = "222")
@ViewLevels({@ViewLevel(level = 30, name = "DirectionGoldNewPluginView")})
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u001e\u001a\u00020\u001fH\u0002J\u001e\u0010 \u001a\u00020\u001f2\b\u0010!\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0010H\u0002J\u0014\u0010#\u001a\u00020\u001f2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0010H\u0002J\b\u0010$\u001a\u00020\u001fH\u0016J\b\u0010%\u001a\u00020\u001fH\u0016J\u001c\u0010&\u001a\u00020\u001f2\b\u0010'\u001a\u0004\u0018\u00010\u00102\b\u0010(\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010)\u001a\u00020\u001fH\u0016R\u0012\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0004\n\u0002\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0019\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0004\n\u0002\u0010\nR\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/direction/DirectionGoldNewPluginDriver;", "Lcom/tal/app/thinkacademy/live/core/plugin/BaseLivePluginDriver;", "Lcom/tal/app/thinkacademy/live/business/direction/DirectionGoldListener;", "mLiveRoomProvider", "Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;", "bundle", "Landroid/os/Bundle;", "(Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;Landroid/os/Bundle;)V", "mClassId", "", "Ljava/lang/Integer;", "mContext", "Landroid/content/Context;", "mDirectionBean", "Lcom/tal/app/thinkacademy/live/business/direction/DirectionBean;", "mInteractId", "", "mInteractType", "getMLiveRoomProvider", "()Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;", "setMLiveRoomProvider", "(Lcom/tal/app/thinkacademy/live/core/interfaces/ILiveRoomProvider;)V", "mNoReport", "", "mParentsInteractId", "mPlanId", "mPluginView", "Lcom/tal/app/thinkacademy/live/business/direction/DirectionGoldNewPluginView;", "mSmallPadPluginView", "Lcom/tal/app/thinkacademy/live/business/direction/DirectionGoldSmallClassPadPluginView;", "destroyView", "", "getDirectionGold", "interactId", "type", "loadView", "onDestroy", "onDirectionGoldAnimationEnd", "onMessage", "ircTypeKey", "message", "updateUserCoins", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DirectionGoldNewPluginDriver.kt */
public final class DirectionGoldNewPluginDriver extends BaseLivePluginDriver implements DirectionGoldListener {
    private Integer mClassId;
    private Context mContext;
    /* access modifiers changed from: private */
    public DirectionBean mDirectionBean;
    private String mInteractId;
    private String mInteractType;
    private ILiveRoomProvider mLiveRoomProvider;
    private boolean mNoReport;
    private String mParentsInteractId;
    /* access modifiers changed from: private */
    public Integer mPlanId;
    private DirectionGoldNewPluginView mPluginView;
    private DirectionGoldSmallClassPadPluginView mSmallPadPluginView;

    public final ILiveRoomProvider getMLiveRoomProvider() {
        return this.mLiveRoomProvider;
    }

    public final void setMLiveRoomProvider(ILiveRoomProvider iLiveRoomProvider) {
        Intrinsics.checkNotNullParameter(iLiveRoomProvider, "<set-?>");
        this.mLiveRoomProvider = iLiveRoomProvider;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x002b, code lost:
        r2 = (r2 = (r2 = r2.getDataStorage()).getPlanInfo()).getId();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DirectionGoldNewPluginDriver(com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider r2, android.os.Bundle r3) {
        /*
            r1 = this;
            java.lang.String r0 = "mLiveRoomProvider"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            r1.<init>(r2, r3)
            r1.mLiveRoomProvider = r2
            java.lang.ref.WeakReference r2 = r2.getWeakRefContext()
            java.lang.Object r2 = r2.get()
            android.content.Context r2 = (android.content.Context) r2
            r1.mContext = r2
            com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider r2 = r1.mLiveRoomProvider
            r3 = 0
            if (r2 != 0) goto L_0x001d
        L_0x001b:
            r2 = r3
            goto L_0x003a
        L_0x001d:
            com.tal.app.thinkacademy.live.core.live.datastorage.DataStorage r2 = r2.getDataStorage()
            if (r2 != 0) goto L_0x0024
            goto L_0x001b
        L_0x0024:
            com.tal.app.thinkacademy.live.core.live.http.bean.PlanInfoProxy r2 = r2.getPlanInfo()
            if (r2 != 0) goto L_0x002b
            goto L_0x001b
        L_0x002b:
            java.lang.String r2 = r2.getId()
            if (r2 != 0) goto L_0x0032
            goto L_0x001b
        L_0x0032:
            int r2 = java.lang.Integer.parseInt(r2)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
        L_0x003a:
            r1.mPlanId = r2
            com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider r2 = r1.mLiveRoomProvider
            if (r2 != 0) goto L_0x0041
            goto L_0x0057
        L_0x0041:
            com.tal.app.thinkacademy.live.core.live.datastorage.DataStorage r2 = r2.getDataStorage()
            if (r2 != 0) goto L_0x0048
            goto L_0x0057
        L_0x0048:
            com.tal.app.thinkacademy.live.core.live.http.bean.CourseInfoProxy r2 = r2.getCourseInfo()
            if (r2 != 0) goto L_0x004f
            goto L_0x0057
        L_0x004f:
            int r2 = r2.getClassId()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)
        L_0x0057:
            r1.mClassId = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.direction.DirectionGoldNewPluginDriver.<init>(com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider, android.os.Bundle):void");
    }

    public void onMessage(String str, String str2) {
        if (Intrinsics.areEqual(str, DirectionGoldNewPluginDriverKt.DISTRIBUTE_COINS_IRC_TYPE)) {
            XesLog.i(Tag.DIRECTION_GOLD, Intrinsics.stringPlus("收到定向金币信令=", str2));
            if (str2 != null) {
                Boolean bool = null;
                try {
                    JSONObject jSONObject = new JSONObject(str2).getJSONObject(DirectionGoldNewPluginDriverKt.DISTRIBUTE_COINS_IRC_TYPE);
                    this.mInteractId = jSONObject.optString("interactId", "");
                    this.mNoReport = jSONObject.optBoolean("noReport", false);
                    this.mParentsInteractId = jSONObject.optString("parentsInteractId", "");
                    this.mInteractType = jSONObject.optString("interactType", "");
                    bool = Boolean.valueOf(jSONObject.optBoolean("pub"));
                } catch (Throwable th) {
                    XesLog.e(Tag.DIRECTION_GOLD, Intrinsics.stringPlus("定向金币信令解析异常=", Log.getStackTraceString(th)));
                }
                if (Intrinsics.areEqual(bool, true) && !Intrinsics.areEqual(ShareDataManager.getInstance().getString(ShareDataKey.DIRECTION_GOLD_INTERACTID, "", ShareDataManager.SHAREDATA_USER), this.mInteractId)) {
                    if (Intrinsics.areEqual(this.mInteractType, "classroomPraise")) {
                        XesLog.i(Tag.DIRECTION_GOLD, Intrinsics.stringPlus("定向金币关联互动 ", this.mInteractType));
                        getDirectionGold(this.mParentsInteractId, this.mInteractType);
                        return;
                    }
                    getDirectionGold(this.mInteractId, this.mInteractType);
                }
            }
        }
    }

    static /* synthetic */ void getDirectionGold$default(DirectionGoldNewPluginDriver directionGoldNewPluginDriver, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        directionGoldNewPluginDriver.getDirectionGold(str, str2);
    }

    private final void getDirectionGold(String str, String str2) {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), new HandlerException(new DirectionGoldNewPluginDriver$getDirectionGold$1()), (CoroutineStart) null, new DirectionGoldNewPluginDriver$getDirectionGold$2(this, new DirectionRepository(), str, str2, (Continuation<? super DirectionGoldNewPluginDriver$getDirectionGold$2>) null), 2, (Object) null);
    }

    static /* synthetic */ void loadView$default(DirectionGoldNewPluginDriver directionGoldNewPluginDriver, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        directionGoldNewPluginDriver.loadView(str);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00f5 A[LOOP:1: B:38:0x00f5->B:41:0x0111, LOOP_START] */
    /* JADX WARNING: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void loadView(java.lang.String r8) {
        /*
            r7 = this;
            android.content.Context r0 = r7.mContext
            if (r0 != 0) goto L_0x0006
            goto L_0x012c
        L_0x0006:
            com.tal.app.thinkacademy.live.business.direction.DirectionBean r1 = r7.mDirectionBean
            if (r1 != 0) goto L_0x000c
            goto L_0x012c
        L_0x000c:
            com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager r2 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.getInstance()
            java.lang.String r3 = r7.mInteractId
            int r4 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.SHAREDATA_USER
            java.lang.String r5 = "direction_gold_interactid"
            r2.put((java.lang.String) r5, (java.lang.String) r3, (int) r4)
            java.util.List r2 = r1.getUsers()
            int r2 = r2.size()
            r3 = 1
            r4 = 0
            if (r2 <= 0) goto L_0x005b
            java.util.List r2 = r1.getUsers()
            java.util.Iterator r2 = r2.iterator()
        L_0x002d:
            boolean r5 = r2.hasNext()
            if (r5 == 0) goto L_0x005b
            java.lang.Object r5 = r2.next()
            com.tal.app.thinkacademy.live.business.direction.UsersBean r5 = (com.tal.app.thinkacademy.live.business.direction.UsersBean) r5
            int r5 = r5.getUserId()
            java.lang.String r5 = java.lang.String.valueOf(r5)
            com.tal.app.thinkacademy.common.user.UserInfoBll$Companion r6 = com.tal.app.thinkacademy.common.user.UserInfoBll.Companion
            com.tal.app.thinkacademy.common.user.UserInfoBll r6 = r6.getInstance()
            com.tal.app.thinkacademy.common.user.UserInfo r6 = r6.getUserInfoEntity()
            if (r6 != 0) goto L_0x004f
            r6 = 0
            goto L_0x0053
        L_0x004f:
            java.lang.String r6 = r6.getUid()
        L_0x0053:
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r6)
            if (r5 == 0) goto L_0x002d
            r2 = r3
            goto L_0x005c
        L_0x005b:
            r2 = r4
        L_0x005c:
            boolean r5 = com.tal.app.thinkacademy.live.core.layout.LiveAreaCompat.isSmallPad()
            java.lang.String r6 = "DirectionGoldNewPluginView"
            if (r5 == 0) goto L_0x008e
            if (r2 == 0) goto L_0x00af
            r7.destroyView()
            com.tal.app.thinkacademy.live.business.direction.DirectionGoldSmallClassPadPluginView r2 = new com.tal.app.thinkacademy.live.business.direction.DirectionGoldSmallClassPadPluginView
            r5 = r7
            com.tal.app.thinkacademy.live.business.direction.DirectionGoldListener r5 = (com.tal.app.thinkacademy.live.business.direction.DirectionGoldListener) r5
            r2.<init>(r0, r1, r5, r8)
            r7.mSmallPadPluginView = r2
            com.tal.app.thinkacademy.live.core.layout.LiveAreaContext r8 = com.tal.app.thinkacademy.live.core.layout.LiveAreaContext.get()
            com.tal.app.thinkacademy.live.core.layout.LiveAreaLayoutParams r8 = r8.getPptLp()
            android.widget.FrameLayout$LayoutParams r8 = r8.newLp()
            com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider r0 = r7.mLiveRoomProvider
            r2 = r7
            com.tal.app.thinkacademy.live.core.plugin.BaseLivePluginDriver r2 = (com.tal.app.thinkacademy.live.core.plugin.BaseLivePluginDriver) r2
            com.tal.app.thinkacademy.live.business.direction.DirectionGoldSmallClassPadPluginView r5 = r7.mSmallPadPluginView
            com.tal.app.thinkacademy.live.core.plugin.pluginview.BaseLivePluginView r5 = (com.tal.app.thinkacademy.live.core.plugin.pluginview.BaseLivePluginView) r5
            android.view.ViewGroup$LayoutParams r8 = (android.view.ViewGroup.LayoutParams) r8
            r0.addView(r2, r5, r6, r8)
            goto L_0x00af
        L_0x008e:
            r7.destroyView()
            com.tal.app.thinkacademy.live.business.direction.DirectionGoldNewPluginView r2 = new com.tal.app.thinkacademy.live.business.direction.DirectionGoldNewPluginView
            r5 = r7
            com.tal.app.thinkacademy.live.business.direction.DirectionGoldListener r5 = (com.tal.app.thinkacademy.live.business.direction.DirectionGoldListener) r5
            r2.<init>(r0, r1, r5, r8)
            r7.mPluginView = r2
            android.widget.FrameLayout$LayoutParams r8 = new android.widget.FrameLayout$LayoutParams
            r0 = -1
            r8.<init>(r0, r0)
            com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider r0 = r7.mLiveRoomProvider
            r2 = r7
            com.tal.app.thinkacademy.live.core.plugin.BaseLivePluginDriver r2 = (com.tal.app.thinkacademy.live.core.plugin.BaseLivePluginDriver) r2
            com.tal.app.thinkacademy.live.business.direction.DirectionGoldNewPluginView r5 = r7.mPluginView
            com.tal.app.thinkacademy.live.core.plugin.pluginview.BaseLivePluginView r5 = (com.tal.app.thinkacademy.live.core.plugin.pluginview.BaseLivePluginView) r5
            android.view.ViewGroup$LayoutParams r8 = (android.view.ViewGroup.LayoutParams) r8
            r0.addView(r2, r5, r6, r8)
        L_0x00af:
            boolean r8 = r7.mNoReport
            if (r8 != 0) goto L_0x00ce
            java.lang.Integer r8 = r7.mPlanId
            if (r8 != 0) goto L_0x00b8
            goto L_0x00ce
        L_0x00b8:
            java.lang.Number r8 = (java.lang.Number) r8
            int r8 = r8.intValue()
            java.lang.Integer r0 = r7.mClassId
            if (r0 != 0) goto L_0x00c3
            goto L_0x00ce
        L_0x00c3:
            java.lang.Number r0 = (java.lang.Number) r0
            int r0 = r0.intValue()
            java.lang.String r2 = r7.mInteractId
            com.tal.app.thinkacademy.live.util.InteractLogReport.uploadLog(r2, r8, r0)
        L_0x00ce:
            java.lang.String r8 = r7.mInteractType
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            if (r8 == 0) goto L_0x00dc
            int r8 = r8.length()
            if (r8 != 0) goto L_0x00db
            goto L_0x00dc
        L_0x00db:
            r3 = r4
        L_0x00dc:
            if (r3 == 0) goto L_0x012c
            com.tal.app.thinkacademy.common.user.UserInfoBll$Companion r8 = com.tal.app.thinkacademy.common.user.UserInfoBll.Companion
            com.tal.app.thinkacademy.common.user.UserInfoBll r8 = r8.getInstance()
            com.tal.app.thinkacademy.common.user.UserInfo r8 = r8.getUserInfoEntity()
            if (r8 != 0) goto L_0x00eb
            goto L_0x012c
        L_0x00eb:
            java.util.List r0 = r1.getUsers()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x00f5:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0113
            java.lang.Object r2 = r0.next()
            com.tal.app.thinkacademy.live.business.direction.UsersBean r2 = (com.tal.app.thinkacademy.live.business.direction.UsersBean) r2
            int r2 = r2.getUserId()
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r3 = r8.getUid()
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r3)
            if (r2 == 0) goto L_0x00f5
        L_0x0113:
            com.tal.app.thinkacademy.common.appmonitor.HWEventTracking$Companion r8 = com.tal.app.thinkacademy.common.appmonitor.HWEventTracking.Companion
            com.tal.app.thinkacademy.common.appmonitor.HWEventTracking r8 = r8.get()
            java.lang.String r0 = r7.mInteractId
            if (r0 != 0) goto L_0x011f
            java.lang.String r0 = ""
        L_0x011f:
            int r1 = r1.getRewardCoinNum()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.Number r1 = (java.lang.Number) r1
            r8.ostaIaCoins(r0, r1)
        L_0x012c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.direction.DirectionGoldNewPluginDriver.loadView(java.lang.String):void");
    }

    private final void destroyView() {
        DirectionGoldNewPluginView directionGoldNewPluginView = this.mPluginView;
        if (directionGoldNewPluginView != null) {
            XesLog.i(Tag.DIRECTION_GOLD, "定向金币View销毁");
            directionGoldNewPluginView.destroy();
            this.mLiveRoomProvider.removeView((View) directionGoldNewPluginView);
            this.mPluginView = null;
        }
        DirectionGoldSmallClassPadPluginView directionGoldSmallClassPadPluginView = this.mSmallPadPluginView;
        if (directionGoldSmallClassPadPluginView != null) {
            XesLog.i(Tag.DIRECTION_GOLD, "定向金币View销毁");
            directionGoldSmallClassPadPluginView.destroy();
            this.mLiveRoomProvider.removeView((View) directionGoldSmallClassPadPluginView);
            this.mSmallPadPluginView = null;
        }
    }

    public void onDestroy() {
        destroyView();
    }

    public void onDirectionGoldAnimationEnd() {
        destroyView();
    }

    public void updateUserCoins() {
        DirectionBean directionBean = this.mDirectionBean;
        if (directionBean != null) {
            XesLog.i(Tag.DIRECTION_GOLD, "更新金币 latestCoin = " + directionBean.getLatestCoin() + " , addCoin = " + directionBean.getRewardCoinNum());
            this.mLiveRoomProvider.getDataStorage().getUserInfo().setGoldNum(directionBean.getLatestCoin());
            PluginEventBus.onEvent(DataBusKey.USERCOINS_KEY, new PluginEventData(RedPackageRainPluginDriver.class, DataBusKey.USERCOINS_KEY, String.valueOf(directionBean.getLatestCoin()), new CoinEventData(GoldSource.DIRECTION_GOLD, directionBean.getRewardCoinNum(), false, false, 12, (DefaultConstructorMarker) null)));
        }
    }
}
