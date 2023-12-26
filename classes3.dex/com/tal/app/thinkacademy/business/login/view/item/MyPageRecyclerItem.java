package com.tal.app.thinkacademy.business.login.view.item;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0016\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\t\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0018\"\u0004\b\u001c\u0010\u001aR\u001e\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0018\"\u0004\b\u001e\u0010\u001aR\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u000e\"\u0004\b \u0010\u0010¨\u0006!"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/view/item/MyPageRecyclerItem;", "", "key", "", "resId", "", "detail", "rightResId", "tvRightContent", "local_round_type", "local_item_divider", "", "(Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;IZ)V", "getDetail", "()Ljava/lang/String;", "setDetail", "(Ljava/lang/String;)V", "getKey", "setKey", "getLocal_item_divider", "()Z", "setLocal_item_divider", "(Z)V", "getLocal_round_type", "()I", "setLocal_round_type", "(I)V", "getResId", "setResId", "getRightResId", "setRightResId", "getTvRightContent", "setTvRightContent", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MyPageRecyclerItem.kt */
public final class MyPageRecyclerItem {
    private String detail;
    private String key;
    private boolean local_item_divider;
    private int local_round_type;
    private int resId;
    private int rightResId;
    private String tvRightContent;

    public MyPageRecyclerItem(String str, int i, String str2, int i2, String str3, int i3, boolean z) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(str2, "detail");
        this.key = str;
        this.resId = i;
        this.detail = str2;
        this.rightResId = i2;
        this.tvRightContent = str3;
        this.local_round_type = i3;
        this.local_item_divider = z;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MyPageRecyclerItem(String str, int i, String str2, int i2, String str3, int i3, boolean z, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, str2, (i4 & 8) != 0 ? -1 : i2, (i4 & 16) != 0 ? "" : str3, (i4 & 32) != 0 ? 0 : i3, (i4 & 64) != 0 ? false : z);
    }

    public final String getKey() {
        return this.key;
    }

    public final void setKey(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.key = str;
    }

    public final int getResId() {
        return this.resId;
    }

    public final void setResId(int i) {
        this.resId = i;
    }

    public final String getDetail() {
        return this.detail;
    }

    public final void setDetail(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.detail = str;
    }

    public final int getRightResId() {
        return this.rightResId;
    }

    public final void setRightResId(int i) {
        this.rightResId = i;
    }

    public final String getTvRightContent() {
        return this.tvRightContent;
    }

    public final void setTvRightContent(String str) {
        this.tvRightContent = str;
    }

    public final int getLocal_round_type() {
        return this.local_round_type;
    }

    public final void setLocal_round_type(int i) {
        this.local_round_type = i;
    }

    public final boolean getLocal_item_divider() {
        return this.local_item_divider;
    }

    public final void setLocal_item_divider(boolean z) {
        this.local_item_divider = z;
    }
}
