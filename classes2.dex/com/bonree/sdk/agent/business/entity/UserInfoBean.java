package com.bonree.sdk.agent.business.entity;

import com.bonree.sdk.common.gson.annotations.SerializedName;
import java.util.Objects;

public class UserInfoBean {
    @SerializedName("ei")
    public String extraInfo;
    @SerializedName("ui")
    public String userId;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            UserInfoBean userInfoBean = (UserInfoBean) obj;
            return equals(this.userId, userInfoBean.userId) && equals(this.extraInfo, userInfoBean.extraInfo);
        }
    }

    public static boolean equals(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.userId, this.extraInfo});
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("UserInfoBean{");
        stringBuffer.append("userId='");
        stringBuffer.append(this.userId);
        stringBuffer.append('\'');
        stringBuffer.append(", extraInfo='");
        stringBuffer.append(this.extraInfo);
        stringBuffer.append('\'');
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
