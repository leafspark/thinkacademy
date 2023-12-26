package com.tal.app.thinkacademy.business.shop.bean;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J9\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u001a"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/bean/UserLeaveInfoBean;", "", "componentData", "Lcom/tal/app/thinkacademy/business/shop/bean/UserLeaveComponent;", "componentName", "", "componentTitle", "componentType", "(Lcom/tal/app/thinkacademy/business/shop/bean/UserLeaveComponent;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getComponentData", "()Lcom/tal/app/thinkacademy/business/shop/bean/UserLeaveComponent;", "getComponentName", "()Ljava/lang/String;", "getComponentTitle", "getComponentType", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: UserLeaveInfoBean.kt */
public final class UserLeaveInfoBean {
    private final UserLeaveComponent componentData;
    private final String componentName;
    private final String componentTitle;
    private final String componentType;

    public UserLeaveInfoBean() {
        this((UserLeaveComponent) null, (String) null, (String) null, (String) null, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ UserLeaveInfoBean copy$default(UserLeaveInfoBean userLeaveInfoBean, UserLeaveComponent userLeaveComponent, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            userLeaveComponent = userLeaveInfoBean.componentData;
        }
        if ((i & 2) != 0) {
            str = userLeaveInfoBean.componentName;
        }
        if ((i & 4) != 0) {
            str2 = userLeaveInfoBean.componentTitle;
        }
        if ((i & 8) != 0) {
            str3 = userLeaveInfoBean.componentType;
        }
        return userLeaveInfoBean.copy(userLeaveComponent, str, str2, str3);
    }

    public final UserLeaveComponent component1() {
        return this.componentData;
    }

    public final String component2() {
        return this.componentName;
    }

    public final String component3() {
        return this.componentTitle;
    }

    public final String component4() {
        return this.componentType;
    }

    public final UserLeaveInfoBean copy(UserLeaveComponent userLeaveComponent, String str, String str2, String str3) {
        return new UserLeaveInfoBean(userLeaveComponent, str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserLeaveInfoBean)) {
            return false;
        }
        UserLeaveInfoBean userLeaveInfoBean = (UserLeaveInfoBean) obj;
        return Intrinsics.areEqual((Object) this.componentData, (Object) userLeaveInfoBean.componentData) && Intrinsics.areEqual((Object) this.componentName, (Object) userLeaveInfoBean.componentName) && Intrinsics.areEqual((Object) this.componentTitle, (Object) userLeaveInfoBean.componentTitle) && Intrinsics.areEqual((Object) this.componentType, (Object) userLeaveInfoBean.componentType);
    }

    public int hashCode() {
        UserLeaveComponent userLeaveComponent = this.componentData;
        int i = 0;
        int hashCode = (userLeaveComponent == null ? 0 : userLeaveComponent.hashCode()) * 31;
        String str = this.componentName;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.componentTitle;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.componentType;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "UserLeaveInfoBean(componentData=" + this.componentData + ", componentName=" + this.componentName + ", componentTitle=" + this.componentTitle + ", componentType=" + this.componentType + ')';
    }

    public UserLeaveInfoBean(UserLeaveComponent userLeaveComponent, String str, String str2, String str3) {
        this.componentData = userLeaveComponent;
        this.componentName = str;
        this.componentTitle = str2;
        this.componentType = str3;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UserLeaveInfoBean(UserLeaveComponent userLeaveComponent, String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new UserLeaveComponent((String) null, (List) null, (String) null, (String) null, (String) null, (String) null, 63, (DefaultConstructorMarker) null) : userLeaveComponent, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? "" : str2, (i & 8) != 0 ? "" : str3);
    }

    public final UserLeaveComponent getComponentData() {
        return this.componentData;
    }

    public final String getComponentName() {
        return this.componentName;
    }

    public final String getComponentTitle() {
        return this.componentTitle;
    }

    public final String getComponentType() {
        return this.componentType;
    }
}
