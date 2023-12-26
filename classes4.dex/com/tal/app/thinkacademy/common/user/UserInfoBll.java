package com.tal.app.thinkacademy.common.user;

import android.text.TextUtils;
import com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager;
import com.tal.app.thinkacademy.common.bonree.BonreeInit;
import com.tal.app.thinkacademy.common.entity.ChannelSaveData;
import com.tal.app.thinkacademy.common.entity.ShopChannelData;
import com.tal.app.thinkacademy.common.sensors.HwTrackUtil;
import com.tal.app.thinkacademy.common.util.PadUtils;
import com.tal.app.thinkacademy.common.utils.ChannelUtil;
import com.tal.app.thinkacademy.lib.interfaces.route.ShareDataKey;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.AppUtils;
import com.tal.app.thinkacademy.lib.util.GsonUtils;
import com.tal.app.thinkacademy.lib.util.Utils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 *2\u00020\u0001:\u0001*B\u0007\b\u0016¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0012\u001a\u00020\u0013J\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\u0006\u0010\u0016\u001a\u00020\u0017J\b\u0010\u0018\u001a\u0004\u0018\u00010\u0011J\u0012\u0010\u0019\u001a\u00020\u00112\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u0017H\u0002J\u0006\u0010\u001d\u001a\u00020\u0017J\b\u0010\u001e\u001a\u00020\u0017H\u0002J\u0006\u0010\u001f\u001a\u00020\u0017J\u000e\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\bJ\u0010\u0010\"\u001a\u00020\u00132\b\u0010#\u001a\u0004\u0018\u00010\u0015J\u0010\u0010$\u001a\u00020\u00132\b\u0010%\u001a\u0004\u0018\u00010\u001bJ\u000e\u0010&\u001a\u00020\u00132\u0006\u0010'\u001a\u00020\u0017J\u0012\u0010(\u001a\u00020\u00132\b\u0010)\u001a\u0004\u0018\u00010\u0011H\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/tal/app/thinkacademy/common/user/UserInfoBll;", "", "()V", "TPYE", "", "getTPYE", "()Ljava/lang/String;", "TPYE_YOUKE", "", "getTPYE_YOUKE", "()I", "mShareDataManager", "Lcom/tal/app/thinkacademy/common/base/sharedata/ShareDataManager;", "mShopChannelData", "Lcom/tal/app/thinkacademy/common/entity/ShopChannelData;", "mShoppingStoreReviewedKey", "mUserInfo", "Lcom/tal/app/thinkacademy/common/user/UserInfo;", "clearUserInfo", "", "getSelectedChannel", "Lcom/tal/app/thinkacademy/common/entity/ChannelSaveData;", "getShoppingMallReviewed", "", "getUserInfoEntity", "initUserCenterUser", "user", "Lcom/tal/app/thinkacademy/common/user/UserBean;", "initUserInfoEntity", "isGuest", "isHaveUserInfo", "isLogin", "isLoginFromYouke", "type", "putSelectedChannel", "data", "saveUserInfo", "mUserBean", "setShoppingMallReviewed", "value", "setUserInfoEntity", "entity", "Companion", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: UserInfoBll.kt */
public final class UserInfoBll {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Lazy<UserInfoBll> instance$delegate = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, UserInfoBll$Companion$instance$2.INSTANCE);
    private final String TPYE = "login_user_type";
    private final int TPYE_YOUKE = 1;
    private ShareDataManager mShareDataManager;
    private ShopChannelData mShopChannelData = new ShopChannelData(false, (ChannelSaveData) null, (String) null, 4, (DefaultConstructorMarker) null);
    private String mShoppingStoreReviewedKey;
    private UserInfo mUserInfo;

    public static final UserInfoBll getInstance() {
        return Companion.getInstance();
    }

    public UserInfoBll() {
        ShareDataManager instance = ShareDataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "getInstance()");
        this.mShareDataManager = instance;
        String appVersionName = AppUtils.getAppVersionName();
        this.mShoppingStoreReviewedKey = appVersionName;
        boolean isEmpty = TextUtils.isEmpty(appVersionName);
        String str = ShareDataKey.SHOPPING_MALL_REVIEWED;
        this.mShoppingStoreReviewedKey = !isEmpty ? Intrinsics.stringPlus(str, this.mShoppingStoreReviewedKey) : str;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R!\u0010\u0003\u001a\u00020\u00048FX\u0002¢\u0006\u0012\n\u0004\b\b\u0010\t\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/tal/app/thinkacademy/common/user/UserInfoBll$Companion;", "", "()V", "instance", "Lcom/tal/app/thinkacademy/common/user/UserInfoBll;", "getInstance$annotations", "getInstance", "()Lcom/tal/app/thinkacademy/common/user/UserInfoBll;", "instance$delegate", "Lkotlin/Lazy;", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: UserInfoBll.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getInstance$annotations() {
        }

        private Companion() {
        }

        public final UserInfoBll getInstance() {
            return (UserInfoBll) UserInfoBll.instance$delegate.getValue();
        }
    }

    public final String getTPYE() {
        return this.TPYE;
    }

    public final int getTPYE_YOUKE() {
        return this.TPYE_YOUKE;
    }

    public final boolean isLoginFromYouke(int i) {
        return this.TPYE_YOUKE == i;
    }

    public final boolean isGuest() {
        CharSequence string = ShareDataManager.getInstance().getString(ShareDataKey.USER_UID, "", ShareDataManager.SHAREDATA_NOT_CLEAR);
        if (!(string == null || StringsKt.isBlank(string))) {
            UserInfo userInfoEntity = getUserInfoEntity();
            CharSequence unifiedAccessToken = userInfoEntity == null ? null : userInfoEntity.getUnifiedAccessToken();
            if (!(unifiedAccessToken == null || StringsKt.isBlank(unifiedAccessToken))) {
                return false;
            }
        }
        return true;
    }

    public final boolean isLogin() {
        CharSequence string = ShareDataManager.getInstance().getString(ShareDataKey.USER_UID, "", ShareDataManager.SHAREDATA_NOT_CLEAR);
        if (string == null || StringsKt.isBlank(string)) {
            return false;
        }
        UserInfo userInfoEntity = getUserInfoEntity();
        CharSequence unifiedAccessToken = userInfoEntity == null ? null : userInfoEntity.getUnifiedAccessToken();
        if (!(unifiedAccessToken == null || StringsKt.isBlank(unifiedAccessToken))) {
            return true;
        }
        return false;
    }

    public final UserInfo getUserInfoEntity() {
        if (isHaveUserInfo()) {
            synchronized (this) {
                if (isHaveUserInfo()) {
                    initUserInfoEntity();
                }
                if (this.mUserInfo == null) {
                    this.mUserInfo = new UserInfo();
                }
                Unit unit = Unit.INSTANCE;
            }
        }
        return this.mUserInfo;
    }

    private final synchronized void setUserInfoEntity(UserInfo userInfo) {
        this.mUserInfo = userInfo;
        XesLog.dt("UserInfoBll", Intrinsics.stringPlus("用户信息", userInfo));
    }

    public final void clearUserInfo() {
        setUserInfoEntity((UserInfo) null);
    }

    private final boolean isHaveUserInfo() {
        UserInfo userInfo = this.mUserInfo;
        return TextUtils.isEmpty(userInfo == null ? null : userInfo.getUid());
    }

    private final boolean initUserInfoEntity() {
        if (this.mShareDataManager.getSelectSP(ShareDataManager.SHAREDATA_USER) == null) {
            String string = this.mShareDataManager.getString(ShareDataKey.USER_UID, "", ShareDataManager.SHAREDATA_NOT_CLEAR);
            XesLog.dt("UserInfoBll", Intrinsics.stringPlus("uid的值是", string));
            if (TextUtils.isEmpty(string)) {
                return false;
            }
            this.mShareDataManager.initUserSP(string);
        }
        synchronized (this) {
            setUserInfoEntity(initUserCenterUser((UserBean) null));
            Unit unit = Unit.INSTANCE;
        }
        return true;
    }

    public final void saveUserInfo(UserBean userBean) {
        if (userBean != null) {
            synchronized (this) {
                if (!TextUtils.isEmpty(userBean.getUnifiedAccessToken())) {
                    ShareDataManager.getInstance().put(ShareDataKey.TOKEN, userBean.getUnifiedAccessToken(), ShareDataManager.SHAREDATA_USER);
                }
                ShareDataManager.getInstance().put(ShareDataKey.USER_PHONE, userBean.getPhone(), ShareDataManager.SHAREDATA_USER);
                ShareDataManager.getInstance().put(ShareDataKey.USER_AVATAR, userBean.getAvatar(), ShareDataManager.SHAREDATA_USER);
                ShareDataManager.getInstance().put(ShareDataKey.USER_UID, String.valueOf(userBean.getUid()), ShareDataManager.SHAREDATA_NOT_CLEAR);
                ShareDataManager.getInstance().put(ShareDataKey.USER_COUNTRY_CALL_CODE, userBean.getCountryCallingCode(), ShareDataManager.SHAREDATA_USER);
                ShareDataManager.getInstance().put(ShareDataKey.USER_EMAIL, userBean.getEmail(), ShareDataManager.SHAREDATA_USER);
                ShareDataManager.getInstance().put(ShareDataKey.USER_NICKNAME, userBean.getNickName(), ShareDataManager.SHAREDATA_USER);
                ShareDataManager.getInstance().put(ShareDataKey.USER_CARD, userBean.getCard(), ShareDataManager.SHAREDATA_USER);
                setUserInfoEntity(initUserCenterUser(userBean));
                Unit unit = Unit.INSTANCE;
            }
            HwTrackUtil.INSTANCE.userLogin();
            HwTrackUtil.INSTANCE.setUserInfo();
            BonreeInit.INSTANCE.updateUserInfo();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0064, code lost:
        if ((r0 == null || kotlin.text.StringsKt.isBlank(r0)) != false) goto L_0x0066;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00f8, code lost:
        if ((r0 == null || kotlin.text.StringsKt.isBlank(r0)) != false) goto L_0x00fa;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.tal.app.thinkacademy.common.user.UserInfo initUserCenterUser(com.tal.app.thinkacademy.common.user.UserBean r9) {
        /*
            r8 = this;
            java.lang.String r0 = "user_uid"
            java.lang.String r1 = "unified_Access_Token"
            r2 = 0
            r3 = 1
            java.lang.String r4 = ""
            if (r9 == 0) goto L_0x0095
            com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager r5 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.getInstance()
            int r6 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.SHAREDATA_USER
            java.lang.String r1 = r5.getString(r1, r4, r6)
            r9.setUnifiedAccessToken(r1)
            com.tal.app.thinkacademy.common.user.UserInfo$Build r1 = new com.tal.app.thinkacademy.common.user.UserInfo$Build
            r1.<init>()
            java.lang.String r5 = r9.getUnifiedAccessToken()
            com.tal.app.thinkacademy.common.user.UserInfo$Build r1 = r1.unifiedAccessToken(r5)
            java.lang.Integer r5 = r9.getUid()
            java.lang.String r5 = java.lang.String.valueOf(r5)
            com.tal.app.thinkacademy.common.user.UserInfo$Build r1 = r1.uid(r5)
            java.lang.String r5 = r9.getPhone()
            com.tal.app.thinkacademy.common.user.UserInfo$Build r1 = r1.phone(r5)
            com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager r5 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.getInstance()
            int r6 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.SHAREDATA_NOT_CLEAR
            java.lang.String r0 = r5.getString(r0, r4, r6)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L_0x004f
            boolean r0 = kotlin.text.StringsKt.isBlank(r0)
            if (r0 == 0) goto L_0x004d
            goto L_0x004f
        L_0x004d:
            r0 = r2
            goto L_0x0050
        L_0x004f:
            r0 = r3
        L_0x0050:
            if (r0 != 0) goto L_0x0066
            java.lang.String r0 = r9.getUnifiedAccessToken()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L_0x0063
            boolean r0 = kotlin.text.StringsKt.isBlank(r0)
            if (r0 == 0) goto L_0x0061
            goto L_0x0063
        L_0x0061:
            r0 = r2
            goto L_0x0064
        L_0x0063:
            r0 = r3
        L_0x0064:
            if (r0 == 0) goto L_0x0067
        L_0x0066:
            r2 = r3
        L_0x0067:
            com.tal.app.thinkacademy.common.user.UserInfo$Build r0 = r1.isGuest(r2)
            java.lang.String r1 = r9.getAvatar()
            com.tal.app.thinkacademy.common.user.UserInfo$Build r0 = r0.avatar(r1)
            java.lang.String r1 = r9.getCountryCallingCode()
            com.tal.app.thinkacademy.common.user.UserInfo$Build r0 = r0.countryCallingCode(r1)
            java.lang.String r1 = r9.getEmail()
            com.tal.app.thinkacademy.common.user.UserInfo$Build r0 = r0.email(r1)
            java.lang.String r1 = r9.getNickName()
            com.tal.app.thinkacademy.common.user.UserInfo$Build r0 = r0.nickName(r1)
            java.lang.String r9 = r9.getCard()
            com.tal.app.thinkacademy.common.user.UserInfo$Build r9 = r0.card(r9)
            goto L_0x014f
        L_0x0095:
            com.tal.app.thinkacademy.common.user.UserInfo$Build r9 = new com.tal.app.thinkacademy.common.user.UserInfo$Build
            r9.<init>()
            com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager r5 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.getInstance()
            int r6 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.SHAREDATA_USER
            java.lang.String r5 = r5.getString(r1, r4, r6)
            com.tal.app.thinkacademy.common.user.UserInfo$Build r9 = r9.unifiedAccessToken(r5)
            com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager r5 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.getInstance()
            int r6 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.SHAREDATA_NOT_CLEAR
            java.lang.String r5 = r5.getString(r0, r4, r6)
            com.tal.app.thinkacademy.common.user.UserInfo$Build r9 = r9.uid(r5)
            com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager r5 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.getInstance()
            int r6 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.SHAREDATA_USER
            java.lang.String r7 = "user_phone"
            java.lang.String r5 = r5.getString(r7, r4, r6)
            com.tal.app.thinkacademy.common.user.UserInfo$Build r9 = r9.phone(r5)
            com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager r5 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.getInstance()
            int r6 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.SHAREDATA_NOT_CLEAR
            java.lang.String r0 = r5.getString(r0, r4, r6)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L_0x00dd
            boolean r0 = kotlin.text.StringsKt.isBlank(r0)
            if (r0 == 0) goto L_0x00db
            goto L_0x00dd
        L_0x00db:
            r0 = r2
            goto L_0x00de
        L_0x00dd:
            r0 = r3
        L_0x00de:
            if (r0 != 0) goto L_0x00fa
            com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager r0 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.getInstance()
            int r5 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.SHAREDATA_USER
            java.lang.String r0 = r0.getString(r1, r4, r5)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L_0x00f7
            boolean r0 = kotlin.text.StringsKt.isBlank(r0)
            if (r0 == 0) goto L_0x00f5
            goto L_0x00f7
        L_0x00f5:
            r0 = r2
            goto L_0x00f8
        L_0x00f7:
            r0 = r3
        L_0x00f8:
            if (r0 == 0) goto L_0x00fb
        L_0x00fa:
            r2 = r3
        L_0x00fb:
            com.tal.app.thinkacademy.common.user.UserInfo$Build r9 = r9.isGuest(r2)
            com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager r0 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.getInstance()
            int r1 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.SHAREDATA_USER
            java.lang.String r2 = "user_avatar"
            java.lang.String r0 = r0.getString(r2, r4, r1)
            com.tal.app.thinkacademy.common.user.UserInfo$Build r9 = r9.avatar(r0)
            com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager r0 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.getInstance()
            int r1 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.SHAREDATA_USER
            java.lang.String r2 = "user_country_calling_code"
            java.lang.String r0 = r0.getString(r2, r4, r1)
            com.tal.app.thinkacademy.common.user.UserInfo$Build r9 = r9.countryCallingCode(r0)
            com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager r0 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.getInstance()
            int r1 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.SHAREDATA_USER
            java.lang.String r2 = "user_email"
            java.lang.String r0 = r0.getString(r2, r4, r1)
            com.tal.app.thinkacademy.common.user.UserInfo$Build r9 = r9.email(r0)
            com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager r0 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.getInstance()
            int r1 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.SHAREDATA_USER
            java.lang.String r2 = "nick_name"
            java.lang.String r0 = r0.getString(r2, r4, r1)
            com.tal.app.thinkacademy.common.user.UserInfo$Build r9 = r9.nickName(r0)
            com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager r0 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.getInstance()
            int r1 = com.tal.app.thinkacademy.common.base.sharedata.ShareDataManager.SHAREDATA_USER
            java.lang.String r2 = "user_card"
            java.lang.String r0 = r0.getString(r2, r4, r1)
            com.tal.app.thinkacademy.common.user.UserInfo$Build r9 = r9.card(r0)
        L_0x014f:
            com.tal.app.thinkacademy.common.user.UserInfo r9 = r9.build()
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.common.user.UserInfoBll.initUserCenterUser(com.tal.app.thinkacademy.common.user.UserBean):com.tal.app.thinkacademy.common.user.UserInfo");
    }

    public final void setShoppingMallReviewed(boolean z) {
        if (!PadUtils.isPad(Utils.getApp()) && z != getShoppingMallReviewed()) {
            ShareDataManager.getInstance().put(this.mShoppingStoreReviewedKey, z, ShareDataManager.SHAREDATA_NOT_CLEAR);
        }
    }

    public final boolean getShoppingMallReviewed() {
        if (PadUtils.isPad(Utils.getApp())) {
            return false;
        }
        if (ChannelUtil.INSTANCE.isGoogleChannel()) {
            return ShareDataManager.getInstance().getBoolean(this.mShoppingStoreReviewedKey, false, ShareDataManager.SHAREDATA_NOT_CLEAR);
        }
        XesLog.dt("商城开关", "这是强制打开商城审核开关的版本,不是google渠道就打开");
        return true;
    }

    public final ChannelSaveData getSelectedChannel() {
        if (this.mShopChannelData.isInit()) {
            return this.mShopChannelData.getData();
        }
        this.mShopChannelData.setInit(true);
        String string = ShareDataManager.getInstance().getString(ShareDataKey.SHOP_CHANNEL_KEY, "", ShareDataManager.SHAREDATA_NOT_CLEAR);
        Intrinsics.checkNotNullExpressionValue(string, "getInstance()\n          …ager.SHAREDATA_NOT_CLEAR)");
        String string2 = ShareDataManager.getInstance().getString("school_code", "415", ShareDataManager.SHAREDATA_NOT_CLEAR);
        try {
            this.mShopChannelData.setData((ChannelSaveData) GsonUtils.fromJson(string, ChannelSaveData.class));
            ChannelSaveData data = this.mShopChannelData.getData();
            if (!string2.equals(data == null ? null : data.getSchoolCode())) {
                this.mShopChannelData.getData();
            }
        } catch (Exception unused) {
        }
        return this.mShopChannelData.getData();
    }

    public final void putSelectedChannel(ChannelSaveData channelSaveData) {
        this.mShopChannelData.setInit(true);
        this.mShopChannelData.setData(channelSaveData);
        ChannelSaveData data = this.mShopChannelData.getData();
        if (data != null) {
            data.setSchoolCode(ShareDataManager.getInstance().getString("school_code", "415", ShareDataManager.SHAREDATA_NOT_CLEAR));
        }
        try {
            ShareDataManager.getInstance().put(ShareDataKey.SHOP_CHANNEL_KEY, GsonUtils.toJson(channelSaveData), ShareDataManager.SHAREDATA_NOT_CLEAR);
        } catch (Exception unused) {
        }
    }
}
