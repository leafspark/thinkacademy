package com.tal.app.thinkacademy.business.home.main.shop.vm;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.chad.library.adapter.base.entity.node.BaseNode;
import com.tal.app.thinkacademy.business.home.main.shop.bean.ShopBannerDataBean;
import com.tal.app.thinkacademy.business.home.main.shop.bean.ShopDialogChannelData;
import com.tal.app.thinkacademy.business.home.main.shop.bean.TimeZoneCheckEntity;
import com.tal.app.thinkacademy.common.base.BaseViewModel;
import com.tal.app.thinkacademy.common.base.StateLiveData;
import com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager;
import com.tal.app.thinkacademy.lib.network.exception.HandlerException;
import com.tal.app.thinkacademy.live.core.live.constant.LiveUrls;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 (2\u00020\u0001:\u0001(B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0017\u001a\u00020\u0018J\u001d\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH@ø\u0001\u0000¢\u0006\u0002\u0010\u001dJ\u000e\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020 J\u001b\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010\u001f\u001a\u00020 H@ø\u0001\u0000¢\u0006\u0002\u0010#J\u000e\u0010$\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020 J!\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0006\u0010\u001f\u001a\u00020 H@ø\u0001\u0000¢\u0006\u0002\u0010#J\u000e\u0010\u0013\u001a\u00020\u00182\u0006\u0010&\u001a\u00020\u001cJ\u001b\u0010'\u001a\u0004\u0018\u00010\u00142\u0006\u0010&\u001a\u00020\u001cH@ø\u0001\u0000¢\u0006\u0002\u0010\u001dR(\u0010\u0003\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\nR(\u0010\u000f\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\b\"\u0004\b\u0012\u0010\nR\"\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\b\"\u0004\b\u0016\u0010\n\u0002\u0004\n\u0002\b\u0019¨\u0006)"}, d2 = {"Lcom/tal/app/thinkacademy/business/home/main/shop/vm/ShopHomeNativeVm;", "Lcom/tal/app/thinkacademy/common/base/BaseViewModel;", "()V", "mBannerData", "Lcom/tal/app/thinkacademy/common/base/StateLiveData;", "", "Lcom/tal/app/thinkacademy/business/home/main/shop/bean/ShopBannerDataBean;", "getMBannerData", "()Lcom/tal/app/thinkacademy/common/base/StateLiveData;", "setMBannerData", "(Lcom/tal/app/thinkacademy/common/base/StateLiveData;)V", "mChannelList", "Lcom/tal/app/thinkacademy/business/home/main/shop/bean/ShopDialogChannelData;", "getMChannelList", "setMChannelList", "mHomeDataList", "Lcom/chad/library/adapter/base/entity/node/BaseNode;", "getMHomeDataList", "setMHomeDataList", "timeZoneCheck", "Lcom/tal/app/thinkacademy/business/home/main/shop/bean/TimeZoneCheckEntity;", "getTimeZoneCheck", "setTimeZoneCheck", "getChannelList", "", "getChannelListReal", "Lcom/tal/app/thinkacademy/business/home/main/shop/bean/ChannelListData;", "schoolCode", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getHomeDataList", "channelId", "", "getHomeDataListReal", "Lcom/tal/app/thinkacademy/business/home/main/shop/bean/ShopHomeData;", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getShopHomeBannerList", "getShopHomeBannerReal", "timeZone", "timezoneCheck", "Companion", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShopHomeNativeVm.kt */
public final class ShopHomeNativeVm extends BaseViewModel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "ShopHomeNativeVm";
    private StateLiveData<List<ShopBannerDataBean>> mBannerData = new StateLiveData<>();
    private StateLiveData<ShopDialogChannelData> mChannelList = new StateLiveData<>();
    private StateLiveData<List<BaseNode>> mHomeDataList = new StateLiveData<>();
    private StateLiveData<TimeZoneCheckEntity> timeZoneCheck = new StateLiveData<>();

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/tal/app/thinkacademy/business/home/main/shop/vm/ShopHomeNativeVm$Companion;", "", "()V", "TAG", "", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ShopHomeNativeVm.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final StateLiveData<ShopDialogChannelData> getMChannelList() {
        return this.mChannelList;
    }

    public final void setMChannelList(StateLiveData<ShopDialogChannelData> stateLiveData) {
        Intrinsics.checkNotNullParameter(stateLiveData, "<set-?>");
        this.mChannelList = stateLiveData;
    }

    public final StateLiveData<List<BaseNode>> getMHomeDataList() {
        return this.mHomeDataList;
    }

    public final void setMHomeDataList(StateLiveData<List<BaseNode>> stateLiveData) {
        Intrinsics.checkNotNullParameter(stateLiveData, "<set-?>");
        this.mHomeDataList = stateLiveData;
    }

    public final StateLiveData<List<ShopBannerDataBean>> getMBannerData() {
        return this.mBannerData;
    }

    public final void setMBannerData(StateLiveData<List<ShopBannerDataBean>> stateLiveData) {
        Intrinsics.checkNotNullParameter(stateLiveData, "<set-?>");
        this.mBannerData = stateLiveData;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0092 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0093 A[PHI: r11 
      PHI: (r11v2 java.lang.Object) = (r11v5 java.lang.Object), (r11v1 java.lang.Object) binds: [B:22:0x0090, B:10:0x002a] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getChannelListReal(java.lang.String r10, kotlin.coroutines.Continuation<? super com.tal.app.thinkacademy.business.home.main.shop.bean.ChannelListData> r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof com.tal.app.thinkacademy.business.home.main.shop.vm.ShopHomeNativeVm$getChannelListReal$1
            if (r0 == 0) goto L_0x0014
            r0 = r11
            com.tal.app.thinkacademy.business.home.main.shop.vm.ShopHomeNativeVm$getChannelListReal$1 r0 = (com.tal.app.thinkacademy.business.home.main.shop.vm.ShopHomeNativeVm$getChannelListReal$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L_0x0019
        L_0x0014:
            com.tal.app.thinkacademy.business.home.main.shop.vm.ShopHomeNativeVm$getChannelListReal$1 r0 = new com.tal.app.thinkacademy.business.home.main.shop.vm.ShopHomeNativeVm$getChannelListReal$1
            r0.<init>(r9, r11)
        L_0x0019:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x003e
            if (r2 == r5) goto L_0x0036
            if (r2 != r4) goto L_0x002e
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x0093
        L_0x002e:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x0036:
            java.lang.Object r10 = r0.L$0
            com.tal.app.thinkacademy.common.network.NetData r10 = (com.tal.app.thinkacademy.common.network.NetData) r10
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x0086
        L_0x003e:
            kotlin.ResultKt.throwOnFailure(r11)
            com.tal.app.thinkacademy.common.user.UserInfoBll$Companion r11 = com.tal.app.thinkacademy.common.user.UserInfoBll.Companion
            com.tal.app.thinkacademy.common.user.UserInfoBll r11 = r11.getInstance()
            com.tal.app.thinkacademy.common.entity.ChannelSaveData r11 = r11.getSelectedChannel()
            if (r11 != 0) goto L_0x004f
            r11 = r3
            goto L_0x0053
        L_0x004f:
            java.lang.Integer r11 = r11.getId()
        L_0x0053:
            com.tal.app.thinkacademy.business.home.main.shop.bean.ChannelListBody r2 = new com.tal.app.thinkacademy.business.home.main.shop.bean.ChannelListBody
            com.tal.app.thinkacademy.business.home.main.shop.bean.ChannelListBodyHead r6 = new com.tal.app.thinkacademy.business.home.main.shop.bean.ChannelListBodyHead
            r6.<init>(r10)
            com.tal.app.thinkacademy.business.home.main.shop.bean.ChannelListBodyData r10 = new com.tal.app.thinkacademy.business.home.main.shop.bean.ChannelListBodyData
            java.lang.Integer r7 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r5)
            r8 = 0
            java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r8)
            r10.<init>(r7, r8, r11)
            r2.<init>(r6, r10)
            com.tal.app.thinkacademy.common.network.NetData r10 = com.tal.app.thinkacademy.common.network.NetData.INSTANCE
            com.tal.app.thinkacademy.common.ApiUrl r11 = com.tal.app.thinkacademy.common.ApiUrl.INSTANCE
            java.lang.String r11 = r11.getBASE_URL()
            java.lang.Class<com.tal.app.thinkacademy.business.shop.ShopApi> r6 = com.tal.app.thinkacademy.business.shop.ShopApi.class
            java.lang.Object r11 = com.tal.app.thinkacademy.lib.network.Api.create(r11, r6)
            com.tal.app.thinkacademy.business.shop.ShopApi r11 = (com.tal.app.thinkacademy.business.shop.ShopApi) r11
            r0.L$0 = r10
            r0.label = r5
            java.lang.Object r11 = r11.getChannelList(r2, r0)
            if (r11 != r1) goto L_0x0086
            return r1
        L_0x0086:
            com.tal.app.thinkacademy.lib.restful.HiResponse r11 = (com.tal.app.thinkacademy.lib.restful.HiResponse) r11
            r0.L$0 = r3
            r0.label = r4
            java.lang.Object r11 = r10.transform(r11, r0)
            if (r11 != r1) goto L_0x0093
            return r1
        L_0x0093:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.home.main.shop.vm.ShopHomeNativeVm.getChannelListReal(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void getChannelList() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), new HandlerException(new ShopHomeNativeVm$getChannelList$1(this)), (CoroutineStart) null, new ShopHomeNativeVm$getChannelList$2(this, ShareDataManager.getInstance().getString("school_code", LiveUrls.SCHOOL_CODE_US, ShareDataManager.SHAREDATA_NOT_CLEAR), (Continuation<? super ShopHomeNativeVm$getChannelList$2>) null), 2, (Object) null);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00a2 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00a3 A[PHI: r10 
      PHI: (r10v2 java.lang.Object) = (r10v5 java.lang.Object), (r10v1 java.lang.Object) binds: [B:19:0x00a0, B:10:0x0029] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getHomeDataListReal(int r9, kotlin.coroutines.Continuation<? super com.tal.app.thinkacademy.business.home.main.shop.bean.ShopHomeData> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof com.tal.app.thinkacademy.business.home.main.shop.vm.ShopHomeNativeVm$getHomeDataListReal$1
            if (r0 == 0) goto L_0x0014
            r0 = r10
            com.tal.app.thinkacademy.business.home.main.shop.vm.ShopHomeNativeVm$getHomeDataListReal$1 r0 = (com.tal.app.thinkacademy.business.home.main.shop.vm.ShopHomeNativeVm$getHomeDataListReal$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L_0x0019
        L_0x0014:
            com.tal.app.thinkacademy.business.home.main.shop.vm.ShopHomeNativeVm$getHomeDataListReal$1 r0 = new com.tal.app.thinkacademy.business.home.main.shop.vm.ShopHomeNativeVm$getHomeDataListReal$1
            r0.<init>(r8, r10)
        L_0x0019:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003e
            if (r2 == r4) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x00a3
        L_0x002e:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x0036:
            java.lang.Object r9 = r0.L$0
            com.tal.app.thinkacademy.common.network.NetData r9 = (com.tal.app.thinkacademy.common.network.NetData) r9
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0095
        L_0x003e:
            kotlin.ResultKt.throwOnFailure(r10)
            com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager r10 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.getInstance()
            int r2 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.SHAREDATA_NOT_CLEAR
            java.lang.String r5 = "school_code"
            java.lang.String r6 = "415"
            java.lang.String r10 = r10.getString(r5, r6, r2)
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.List r2 = (java.util.List) r2
            com.tal.app.thinkacademy.business.home.main.shop.bean.ShopHomeBodyDataSpecValue r5 = new com.tal.app.thinkacademy.business.home.main.shop.bean.ShopHomeBodyDataSpecValue
            r6 = 25
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r6)
            java.lang.Integer r9 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r9)
            r5.<init>(r6, r9)
            r2.add(r5)
            com.tal.app.thinkacademy.business.home.main.shop.bean.ShopHomeBody r9 = new com.tal.app.thinkacademy.business.home.main.shop.bean.ShopHomeBody
            com.tal.app.thinkacademy.business.home.main.shop.bean.ShopHomeBodyData r5 = new com.tal.app.thinkacademy.business.home.main.shop.bean.ShopHomeBodyData
            r5.<init>(r2)
            com.tal.app.thinkacademy.business.home.main.shop.bean.ShopHomeBodyHeader r2 = new com.tal.app.thinkacademy.business.home.main.shop.bean.ShopHomeBodyHeader
            r2.<init>(r10)
            r9.<init>(r5, r2)
            com.tal.app.thinkacademy.common.network.NetData r10 = com.tal.app.thinkacademy.common.network.NetData.INSTANCE
            com.tal.app.thinkacademy.common.ApiUrl r2 = com.tal.app.thinkacademy.common.ApiUrl.INSTANCE
            java.lang.String r2 = r2.getBASE_URL()
            java.lang.Class<com.tal.app.thinkacademy.business.shop.ShopApi> r5 = com.tal.app.thinkacademy.business.shop.ShopApi.class
            java.lang.Object r2 = com.tal.app.thinkacademy.lib.network.Api.create(r2, r5)
            com.tal.app.thinkacademy.business.shop.ShopApi r2 = (com.tal.app.thinkacademy.business.shop.ShopApi) r2
            r0.L$0 = r10
            r0.label = r4
            java.lang.Object r9 = r2.getShopHomeList(r9, r0)
            if (r9 != r1) goto L_0x0092
            return r1
        L_0x0092:
            r7 = r10
            r10 = r9
            r9 = r7
        L_0x0095:
            com.tal.app.thinkacademy.lib.restful.HiResponse r10 = (com.tal.app.thinkacademy.lib.restful.HiResponse) r10
            r2 = 0
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r10 = r9.transform(r10, r0)
            if (r10 != r1) goto L_0x00a3
            return r1
        L_0x00a3:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.home.main.shop.vm.ShopHomeNativeVm.getHomeDataListReal(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void getHomeDataList(int i) {
        Ref.LongRef longRef = new Ref.LongRef();
        longRef.element = System.currentTimeMillis();
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), new HandlerException(new ShopHomeNativeVm$getHomeDataList$1(this, longRef)), (CoroutineStart) null, new ShopHomeNativeVm$getHomeDataList$2(this, i, longRef, (Continuation<? super ShopHomeNativeVm$getHomeDataList$2>) null), 2, (Object) null);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x009d A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x009e A[PHI: r10 
      PHI: (r10v2 java.lang.Object) = (r10v5 java.lang.Object), (r10v1 java.lang.Object) binds: [B:18:0x009b, B:10:0x002a] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getShopHomeBannerReal(int r9, kotlin.coroutines.Continuation<? super java.util.List<com.tal.app.thinkacademy.business.home.main.shop.bean.ShopBannerDataBean>> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof com.tal.app.thinkacademy.business.home.main.shop.vm.ShopHomeNativeVm$getShopHomeBannerReal$1
            if (r0 == 0) goto L_0x0014
            r0 = r10
            com.tal.app.thinkacademy.business.home.main.shop.vm.ShopHomeNativeVm$getShopHomeBannerReal$1 r0 = (com.tal.app.thinkacademy.business.home.main.shop.vm.ShopHomeNativeVm$getShopHomeBannerReal$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L_0x0019
        L_0x0014:
            com.tal.app.thinkacademy.business.home.main.shop.vm.ShopHomeNativeVm$getShopHomeBannerReal$1 r0 = new com.tal.app.thinkacademy.business.home.main.shop.vm.ShopHomeNativeVm$getShopHomeBannerReal$1
            r0.<init>(r8, r10)
        L_0x0019:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            r5 = 2
            if (r2 == 0) goto L_0x003e
            if (r2 == r3) goto L_0x0036
            if (r2 != r5) goto L_0x002e
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x009e
        L_0x002e:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x0036:
            java.lang.Object r9 = r0.L$0
            com.tal.app.thinkacademy.common.network.NetData r9 = (com.tal.app.thinkacademy.common.network.NetData) r9
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0091
        L_0x003e:
            kotlin.ResultKt.throwOnFailure(r10)
            com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager r10 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.getInstance()
            int r2 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.SHAREDATA_NOT_CLEAR
            java.lang.String r6 = "school_code"
            java.lang.String r7 = "415"
            java.lang.String r10 = r10.getString(r6, r7, r2)
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.List r2 = (java.util.List) r2
            java.lang.Integer r9 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r9)
            r2.add(r9)
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            java.util.List r9 = (java.util.List) r9
            com.tal.app.thinkacademy.business.home.main.shop.bean.ShopBannerBodyData r6 = new com.tal.app.thinkacademy.business.home.main.shop.bean.ShopBannerBodyData
            r6.<init>(r2, r4, r5, r4)
            r9.add(r6)
            com.tal.app.thinkacademy.business.home.main.shop.bean.ShopBannerBody r2 = new com.tal.app.thinkacademy.business.home.main.shop.bean.ShopBannerBody
            com.tal.app.thinkacademy.business.home.main.shop.bean.ShopBannerBodyHead r6 = new com.tal.app.thinkacademy.business.home.main.shop.bean.ShopBannerBodyHead
            r6.<init>(r10)
            r2.<init>(r9, r6)
            com.tal.app.thinkacademy.common.network.NetData r9 = com.tal.app.thinkacademy.common.network.NetData.INSTANCE
            com.tal.app.thinkacademy.common.ApiUrl r10 = com.tal.app.thinkacademy.common.ApiUrl.INSTANCE
            java.lang.String r10 = r10.getBASE_URL()
            java.lang.Class<com.tal.app.thinkacademy.business.shop.ShopApi> r6 = com.tal.app.thinkacademy.business.shop.ShopApi.class
            java.lang.Object r10 = com.tal.app.thinkacademy.lib.network.Api.create(r10, r6)
            com.tal.app.thinkacademy.business.shop.ShopApi r10 = (com.tal.app.thinkacademy.business.shop.ShopApi) r10
            r0.L$0 = r9
            r0.label = r3
            java.lang.Object r10 = r10.getShopHomeBanner(r2, r0)
            if (r10 != r1) goto L_0x0091
            return r1
        L_0x0091:
            com.tal.app.thinkacademy.lib.restful.HiResponse r10 = (com.tal.app.thinkacademy.lib.restful.HiResponse) r10
            r0.L$0 = r4
            r0.label = r5
            java.lang.Object r10 = r9.transform(r10, r0)
            if (r10 != r1) goto L_0x009e
            return r1
        L_0x009e:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.home.main.shop.vm.ShopHomeNativeVm.getShopHomeBannerReal(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void getShopHomeBannerList(int i) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), new HandlerException(new ShopHomeNativeVm$getShopHomeBannerList$1(this)), (CoroutineStart) null, new ShopHomeNativeVm$getShopHomeBannerList$2(this, i, (Continuation<? super ShopHomeNativeVm$getShopHomeBannerList$2>) null), 2, (Object) null);
    }

    public final StateLiveData<TimeZoneCheckEntity> getTimeZoneCheck() {
        return this.timeZoneCheck;
    }

    public final void setTimeZoneCheck(StateLiveData<TimeZoneCheckEntity> stateLiveData) {
        Intrinsics.checkNotNullParameter(stateLiveData, "<set-?>");
        this.timeZoneCheck = stateLiveData;
    }

    public final void timeZoneCheck(String str) {
        Intrinsics.checkNotNullParameter(str, "timeZone");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel) this), new HandlerException(new ShopHomeNativeVm$timeZoneCheck$1(this)), (CoroutineStart) null, new ShopHomeNativeVm$timeZoneCheck$2(this, str, (Continuation<? super ShopHomeNativeVm$timeZoneCheck$2>) null), 2, (Object) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0075 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0076 A[PHI: r10 
      PHI: (r10v2 java.lang.Object) = (r10v5 java.lang.Object), (r10v1 java.lang.Object) binds: [B:19:0x0073, B:10:0x0029] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object timezoneCheck(java.lang.String r9, kotlin.coroutines.Continuation<? super com.tal.app.thinkacademy.business.home.main.shop.bean.TimeZoneCheckEntity> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof com.tal.app.thinkacademy.business.home.main.shop.vm.ShopHomeNativeVm$timezoneCheck$3
            if (r0 == 0) goto L_0x0014
            r0 = r10
            com.tal.app.thinkacademy.business.home.main.shop.vm.ShopHomeNativeVm$timezoneCheck$3 r0 = (com.tal.app.thinkacademy.business.home.main.shop.vm.ShopHomeNativeVm$timezoneCheck$3) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L_0x0019
        L_0x0014:
            com.tal.app.thinkacademy.business.home.main.shop.vm.ShopHomeNativeVm$timezoneCheck$3 r0 = new com.tal.app.thinkacademy.business.home.main.shop.vm.ShopHomeNativeVm$timezoneCheck$3
            r0.<init>(r8, r10)
        L_0x0019:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003d
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0076
        L_0x002d:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x0035:
            java.lang.Object r9 = r0.L$0
            com.tal.app.thinkacademy.common.network.NetData r9 = (com.tal.app.thinkacademy.common.network.NetData) r9
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0068
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r10)
            com.tal.app.thinkacademy.common.network.NetData r10 = com.tal.app.thinkacademy.common.network.NetData.INSTANCE
            com.tal.app.thinkacademy.common.ApiUrl r2 = com.tal.app.thinkacademy.common.ApiUrl.INSTANCE
            java.lang.String r2 = r2.getBASE_URL()
            java.lang.Class<com.tal.app.thinkacademy.business.shop.ShopApi> r5 = com.tal.app.thinkacademy.business.shop.ShopApi.class
            java.lang.Object r2 = com.tal.app.thinkacademy.lib.network.Api.create(r2, r5)
            com.tal.app.thinkacademy.business.shop.ShopApi r2 = (com.tal.app.thinkacademy.business.shop.ShopApi) r2
            com.tal.app.thinkacademy.business.home.main.shop.bean.TimeZoneCheckRequest r5 = new com.tal.app.thinkacademy.business.home.main.shop.bean.TimeZoneCheckRequest
            com.tal.app.thinkacademy.business.home.main.shop.bean.TimeZoneCheckRequestData r6 = new com.tal.app.thinkacademy.business.home.main.shop.bean.TimeZoneCheckRequestData
            r6.<init>(r9)
            r5.<init>(r6)
            r0.L$0 = r10
            r0.label = r4
            java.lang.Object r9 = r2.timeZoneCheck(r5, r0)
            if (r9 != r1) goto L_0x0065
            return r1
        L_0x0065:
            r7 = r10
            r10 = r9
            r9 = r7
        L_0x0068:
            com.tal.app.thinkacademy.lib.restful.HiResponse r10 = (com.tal.app.thinkacademy.lib.restful.HiResponse) r10
            r2 = 0
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r10 = r9.transform(r10, r0)
            if (r10 != r1) goto L_0x0076
            return r1
        L_0x0076:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.home.main.shop.vm.ShopHomeNativeVm.timezoneCheck(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
