package com.tal.app.thinkacademy.common.user;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/tal/app/thinkacademy/common/user/BaseLogBean;", "", "()V", "userId", "", "getUserId", "()Ljava/lang/String;", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BaseLogBean.kt */
public class BaseLogBean {
    public final String getUserId() {
        UserInfo userInfoEntity = UserInfoBll.Companion.getInstance().getUserInfoEntity();
        if (userInfoEntity == null) {
            return null;
        }
        return userInfoEntity.getUid();
    }
}
