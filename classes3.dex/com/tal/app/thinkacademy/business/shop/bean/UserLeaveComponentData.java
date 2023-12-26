package com.tal.app.thinkacademy.business.shop.bean;

import com.chad.library.adapter.base.entity.node.BaseNode;
import com.tal.app.thinkacademy.business.login.widget.PatternUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.io.ConstantsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\bK\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001Bï\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\n\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0003¢\u0006\u0002\u0010\u001cJ\u0006\u0010I\u001a\u00020\u0003J\u0006\u0010J\u001a\u00020\u0003J\t\u0010K\u001a\u00020\u0003HÆ\u0003J\t\u0010L\u001a\u00020\u0003HÆ\u0003J\t\u0010M\u001a\u00020\u0011HÆ\u0003J\u0011\u0010N\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\nHÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\t\u0010R\u001a\u00020\u0011HÆ\u0003J\t\u0010S\u001a\u00020\u0011HÆ\u0003J\t\u0010T\u001a\u00020\u0005HÆ\u0003J\t\u0010U\u001a\u00020\u0011HÆ\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010W\u001a\u00020\u0003HÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010Y\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010Z\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010[\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nHÆ\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010]\u001a\u00020\u0003HÆ\u0003J\u000b\u0010^\u001a\u0004\u0018\u00010\u0005HÆ\u0003Jó\u0001\u0010_\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\r\u001a\u00020\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\n2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00112\b\b\u0002\u0010\u0018\u001a\u00020\u00112\b\b\u0002\u0010\u0019\u001a\u00020\u00052\b\b\u0002\u0010\u001a\u001a\u00020\u00112\b\b\u0002\u0010\u001b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010`\u001a\u00020\u00032\b\u0010a\u001a\u0004\u0018\u00010bHÖ\u0003J\t\u0010c\u001a\u00020\u0011HÖ\u0001J\t\u0010d\u001a\u00020\u0005HÖ\u0001R\u001c\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b$\u0010#R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b%\u0010#R\"\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001f\"\u0004\b'\u0010(R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010#\"\u0004\b*\u0010+R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001a\u0010\u001b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010!\"\u0004\b1\u00102R\u001a\u0010\u001a\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001a\u0010\u0019\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010#\"\u0004\b8\u0010+R\u001a\u0010\u0017\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u00104\"\u0004\b:\u00106R\u001a\u0010\u0018\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u00104\"\u0004\b<\u00106R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010#\"\u0004\b>\u0010+R\u001a\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u00104\"\u0004\b@\u00106R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\bA\u0010#R\u0019\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\bB\u0010\u001fR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010#\"\u0004\bD\u0010+R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bE\u0010!R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\bF\u0010#R\u001a\u0010\u000f\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010!\"\u0004\bH\u00102¨\u0006e"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/bean/UserLeaveComponentData;", "Lcom/chad/library/adapter/base/entity/node/BaseNode;", "custom", "", "def", "", "index", "key", "name", "options", "", "Lcom/tal/app/thinkacademy/business/shop/bean/UserLeaveComponentDataOption;", "optionsType", "required", "rowUuid", "show", "mLocalType", "", "mLocalButtonTypeChild", "mLocalSelectText", "mLocalDisplaySelectText", "mLocalLeaveButtonData", "Lcom/tal/app/thinkacademy/business/shop/bean/UserLeaveButtonData;", "mLocalPhoneLengthMax", "mLocalPhoneLengthMin", "mLocalPhoneAreaNum", "mLocalPhoneAreaIndex", "mLocalMulti", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;ZLjava/lang/String;ZILjava/util/List;Ljava/lang/String;Ljava/lang/String;Lcom/tal/app/thinkacademy/business/shop/bean/UserLeaveButtonData;IILjava/lang/String;IZ)V", "childNode", "getChildNode", "()Ljava/util/List;", "getCustom", "()Z", "getDef", "()Ljava/lang/String;", "getIndex", "getKey", "getMLocalButtonTypeChild", "setMLocalButtonTypeChild", "(Ljava/util/List;)V", "getMLocalDisplaySelectText", "setMLocalDisplaySelectText", "(Ljava/lang/String;)V", "getMLocalLeaveButtonData", "()Lcom/tal/app/thinkacademy/business/shop/bean/UserLeaveButtonData;", "setMLocalLeaveButtonData", "(Lcom/tal/app/thinkacademy/business/shop/bean/UserLeaveButtonData;)V", "getMLocalMulti", "setMLocalMulti", "(Z)V", "getMLocalPhoneAreaIndex", "()I", "setMLocalPhoneAreaIndex", "(I)V", "getMLocalPhoneAreaNum", "setMLocalPhoneAreaNum", "getMLocalPhoneLengthMax", "setMLocalPhoneLengthMax", "getMLocalPhoneLengthMin", "setMLocalPhoneLengthMin", "getMLocalSelectText", "setMLocalSelectText", "getMLocalType", "setMLocalType", "getName", "getOptions", "getOptionsType", "setOptionsType", "getRequired", "getRowUuid", "getShow", "setShow", "checkEmailIsValid", "checkPhoneIsValid", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "hashCode", "toString", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: UserLeaveInfoBean.kt */
public final class UserLeaveComponentData extends BaseNode {
    private final boolean custom;
    private final String def;
    private final String index;
    private final String key;
    private List<UserLeaveComponentData> mLocalButtonTypeChild;
    private String mLocalDisplaySelectText;
    private UserLeaveButtonData mLocalLeaveButtonData;
    private boolean mLocalMulti;
    private int mLocalPhoneAreaIndex;
    private String mLocalPhoneAreaNum;
    private int mLocalPhoneLengthMax;
    private int mLocalPhoneLengthMin;
    private String mLocalSelectText;
    private int mLocalType;
    private final String name;
    private final List<UserLeaveComponentDataOption> options;
    private String optionsType;
    private final boolean required;
    private final String rowUuid;
    private boolean show;

    public UserLeaveComponentData() {
        this(false, (String) null, (String) null, (String) null, (String) null, (List) null, (String) null, false, (String) null, false, 0, (List) null, (String) null, (String) null, (UserLeaveButtonData) null, 0, 0, (String) null, 0, false, 1048575, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ UserLeaveComponentData copy$default(UserLeaveComponentData userLeaveComponentData, boolean z, String str, String str2, String str3, String str4, List list, String str5, boolean z2, String str6, boolean z3, int i, List list2, String str7, String str8, UserLeaveButtonData userLeaveButtonData, int i2, int i3, String str9, int i4, boolean z4, int i5, Object obj) {
        UserLeaveComponentData userLeaveComponentData2 = userLeaveComponentData;
        int i6 = i5;
        return userLeaveComponentData.copy((i6 & 1) != 0 ? userLeaveComponentData2.custom : z, (i6 & 2) != 0 ? userLeaveComponentData2.def : str, (i6 & 4) != 0 ? userLeaveComponentData2.index : str2, (i6 & 8) != 0 ? userLeaveComponentData2.key : str3, (i6 & 16) != 0 ? userLeaveComponentData2.name : str4, (i6 & 32) != 0 ? userLeaveComponentData2.options : list, (i6 & 64) != 0 ? userLeaveComponentData2.optionsType : str5, (i6 & 128) != 0 ? userLeaveComponentData2.required : z2, (i6 & 256) != 0 ? userLeaveComponentData2.rowUuid : str6, (i6 & ConstantsKt.MINIMUM_BLOCK_SIZE) != 0 ? userLeaveComponentData2.show : z3, (i6 & 1024) != 0 ? userLeaveComponentData2.mLocalType : i, (i6 & 2048) != 0 ? userLeaveComponentData2.mLocalButtonTypeChild : list2, (i6 & ConstantsKt.DEFAULT_BLOCK_SIZE) != 0 ? userLeaveComponentData2.mLocalSelectText : str7, (i6 & ConstantsKt.DEFAULT_BUFFER_SIZE) != 0 ? userLeaveComponentData2.mLocalDisplaySelectText : str8, (i6 & 16384) != 0 ? userLeaveComponentData2.mLocalLeaveButtonData : userLeaveButtonData, (i6 & 32768) != 0 ? userLeaveComponentData2.mLocalPhoneLengthMax : i2, (i6 & 65536) != 0 ? userLeaveComponentData2.mLocalPhoneLengthMin : i3, (i6 & 131072) != 0 ? userLeaveComponentData2.mLocalPhoneAreaNum : str9, (i6 & 262144) != 0 ? userLeaveComponentData2.mLocalPhoneAreaIndex : i4, (i6 & 524288) != 0 ? userLeaveComponentData2.mLocalMulti : z4);
    }

    public final boolean component1() {
        return this.custom;
    }

    public final boolean component10() {
        return this.show;
    }

    public final int component11() {
        return this.mLocalType;
    }

    public final List<UserLeaveComponentData> component12() {
        return this.mLocalButtonTypeChild;
    }

    public final String component13() {
        return this.mLocalSelectText;
    }

    public final String component14() {
        return this.mLocalDisplaySelectText;
    }

    public final UserLeaveButtonData component15() {
        return this.mLocalLeaveButtonData;
    }

    public final int component16() {
        return this.mLocalPhoneLengthMax;
    }

    public final int component17() {
        return this.mLocalPhoneLengthMin;
    }

    public final String component18() {
        return this.mLocalPhoneAreaNum;
    }

    public final int component19() {
        return this.mLocalPhoneAreaIndex;
    }

    public final String component2() {
        return this.def;
    }

    public final boolean component20() {
        return this.mLocalMulti;
    }

    public final String component3() {
        return this.index;
    }

    public final String component4() {
        return this.key;
    }

    public final String component5() {
        return this.name;
    }

    public final List<UserLeaveComponentDataOption> component6() {
        return this.options;
    }

    public final String component7() {
        return this.optionsType;
    }

    public final boolean component8() {
        return this.required;
    }

    public final String component9() {
        return this.rowUuid;
    }

    public final UserLeaveComponentData copy(boolean z, String str, String str2, String str3, String str4, List<UserLeaveComponentDataOption> list, String str5, boolean z2, String str6, boolean z3, int i, List<UserLeaveComponentData> list2, String str7, String str8, UserLeaveButtonData userLeaveButtonData, int i2, int i3, String str9, int i4, boolean z4) {
        boolean z5 = z;
        Intrinsics.checkNotNullParameter(str9, "mLocalPhoneAreaNum");
        return new UserLeaveComponentData(z, str, str2, str3, str4, list, str5, z2, str6, z3, i, list2, str7, str8, userLeaveButtonData, i2, i3, str9, i4, z4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserLeaveComponentData)) {
            return false;
        }
        UserLeaveComponentData userLeaveComponentData = (UserLeaveComponentData) obj;
        return this.custom == userLeaveComponentData.custom && Intrinsics.areEqual((Object) this.def, (Object) userLeaveComponentData.def) && Intrinsics.areEqual((Object) this.index, (Object) userLeaveComponentData.index) && Intrinsics.areEqual((Object) this.key, (Object) userLeaveComponentData.key) && Intrinsics.areEqual((Object) this.name, (Object) userLeaveComponentData.name) && Intrinsics.areEqual((Object) this.options, (Object) userLeaveComponentData.options) && Intrinsics.areEqual((Object) this.optionsType, (Object) userLeaveComponentData.optionsType) && this.required == userLeaveComponentData.required && Intrinsics.areEqual((Object) this.rowUuid, (Object) userLeaveComponentData.rowUuid) && this.show == userLeaveComponentData.show && this.mLocalType == userLeaveComponentData.mLocalType && Intrinsics.areEqual((Object) this.mLocalButtonTypeChild, (Object) userLeaveComponentData.mLocalButtonTypeChild) && Intrinsics.areEqual((Object) this.mLocalSelectText, (Object) userLeaveComponentData.mLocalSelectText) && Intrinsics.areEqual((Object) this.mLocalDisplaySelectText, (Object) userLeaveComponentData.mLocalDisplaySelectText) && Intrinsics.areEqual((Object) this.mLocalLeaveButtonData, (Object) userLeaveComponentData.mLocalLeaveButtonData) && this.mLocalPhoneLengthMax == userLeaveComponentData.mLocalPhoneLengthMax && this.mLocalPhoneLengthMin == userLeaveComponentData.mLocalPhoneLengthMin && Intrinsics.areEqual((Object) this.mLocalPhoneAreaNum, (Object) userLeaveComponentData.mLocalPhoneAreaNum) && this.mLocalPhoneAreaIndex == userLeaveComponentData.mLocalPhoneAreaIndex && this.mLocalMulti == userLeaveComponentData.mLocalMulti;
    }

    public List<BaseNode> getChildNode() {
        return null;
    }

    public int hashCode() {
        boolean z = this.custom;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i = (z ? 1 : 0) * true;
        String str = this.def;
        int i2 = 0;
        int hashCode = (i + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.index;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.key;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.name;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        List<UserLeaveComponentDataOption> list = this.options;
        int hashCode5 = (hashCode4 + (list == null ? 0 : list.hashCode())) * 31;
        String str5 = this.optionsType;
        int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        boolean z3 = this.required;
        if (z3) {
            z3 = true;
        }
        int i3 = (hashCode6 + (z3 ? 1 : 0)) * 31;
        String str6 = this.rowUuid;
        int hashCode7 = (i3 + (str6 == null ? 0 : str6.hashCode())) * 31;
        boolean z4 = this.show;
        if (z4) {
            z4 = true;
        }
        int i4 = (((hashCode7 + (z4 ? 1 : 0)) * 31) + this.mLocalType) * 31;
        List<UserLeaveComponentData> list2 = this.mLocalButtonTypeChild;
        int hashCode8 = (i4 + (list2 == null ? 0 : list2.hashCode())) * 31;
        String str7 = this.mLocalSelectText;
        int hashCode9 = (hashCode8 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.mLocalDisplaySelectText;
        int hashCode10 = (hashCode9 + (str8 == null ? 0 : str8.hashCode())) * 31;
        UserLeaveButtonData userLeaveButtonData = this.mLocalLeaveButtonData;
        if (userLeaveButtonData != null) {
            i2 = userLeaveButtonData.hashCode();
        }
        int hashCode11 = (((((((((hashCode10 + i2) * 31) + this.mLocalPhoneLengthMax) * 31) + this.mLocalPhoneLengthMin) * 31) + this.mLocalPhoneAreaNum.hashCode()) * 31) + this.mLocalPhoneAreaIndex) * 31;
        boolean z5 = this.mLocalMulti;
        if (!z5) {
            z2 = z5;
        }
        return hashCode11 + (z2 ? 1 : 0);
    }

    public String toString() {
        return "UserLeaveComponentData(custom=" + this.custom + ", def=" + this.def + ", index=" + this.index + ", key=" + this.key + ", name=" + this.name + ", options=" + this.options + ", optionsType=" + this.optionsType + ", required=" + this.required + ", rowUuid=" + this.rowUuid + ", show=" + this.show + ", mLocalType=" + this.mLocalType + ", mLocalButtonTypeChild=" + this.mLocalButtonTypeChild + ", mLocalSelectText=" + this.mLocalSelectText + ", mLocalDisplaySelectText=" + this.mLocalDisplaySelectText + ", mLocalLeaveButtonData=" + this.mLocalLeaveButtonData + ", mLocalPhoneLengthMax=" + this.mLocalPhoneLengthMax + ", mLocalPhoneLengthMin=" + this.mLocalPhoneLengthMin + ", mLocalPhoneAreaNum=" + this.mLocalPhoneAreaNum + ", mLocalPhoneAreaIndex=" + this.mLocalPhoneAreaIndex + ", mLocalMulti=" + this.mLocalMulti + ')';
    }

    public final boolean getCustom() {
        return this.custom;
    }

    public final String getDef() {
        return this.def;
    }

    public final String getIndex() {
        return this.index;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getName() {
        return this.name;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ UserLeaveComponentData(boolean r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, java.util.List r27, java.lang.String r28, boolean r29, java.lang.String r30, boolean r31, int r32, java.util.List r33, java.lang.String r34, java.lang.String r35, com.tal.app.thinkacademy.business.shop.bean.UserLeaveButtonData r36, int r37, int r38, java.lang.String r39, int r40, boolean r41, int r42, kotlin.jvm.internal.DefaultConstructorMarker r43) {
        /*
            r21 = this;
            r0 = r42
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0008
            r1 = 0
            goto L_0x000a
        L_0x0008:
            r1 = r22
        L_0x000a:
            r3 = r0 & 2
            java.lang.String r4 = ""
            if (r3 == 0) goto L_0x0012
            r3 = r4
            goto L_0x0014
        L_0x0012:
            r3 = r23
        L_0x0014:
            r5 = r0 & 4
            if (r5 == 0) goto L_0x001a
            r5 = r4
            goto L_0x001c
        L_0x001a:
            r5 = r24
        L_0x001c:
            r6 = r0 & 8
            if (r6 == 0) goto L_0x0022
            r6 = r4
            goto L_0x0024
        L_0x0022:
            r6 = r25
        L_0x0024:
            r7 = r0 & 16
            if (r7 == 0) goto L_0x002a
            r7 = r4
            goto L_0x002c
        L_0x002a:
            r7 = r26
        L_0x002c:
            r8 = r0 & 32
            if (r8 == 0) goto L_0x0038
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.List r8 = (java.util.List) r8
            goto L_0x003a
        L_0x0038:
            r8 = r27
        L_0x003a:
            r9 = r0 & 64
            if (r9 == 0) goto L_0x0040
            r9 = r4
            goto L_0x0042
        L_0x0040:
            r9 = r28
        L_0x0042:
            r10 = r0 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x0048
            r10 = 0
            goto L_0x004a
        L_0x0048:
            r10 = r29
        L_0x004a:
            r11 = r0 & 256(0x100, float:3.59E-43)
            if (r11 == 0) goto L_0x004f
            goto L_0x0051
        L_0x004f:
            r4 = r30
        L_0x0051:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x0057
            r11 = 0
            goto L_0x0059
        L_0x0057:
            r11 = r31
        L_0x0059:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x0064
            com.tal.app.thinkacademy.business.shop.bean.LeaveDataType r12 = com.tal.app.thinkacademy.business.shop.bean.LeaveDataType.DATA_NORMAL
            int r12 = r12.getValue()
            goto L_0x0066
        L_0x0064:
            r12 = r32
        L_0x0066:
            r13 = r0 & 2048(0x800, float:2.87E-42)
            if (r13 == 0) goto L_0x006c
            r13 = 0
            goto L_0x006e
        L_0x006c:
            r13 = r33
        L_0x006e:
            r15 = r0 & 4096(0x1000, float:5.74E-42)
            if (r15 == 0) goto L_0x0074
            r15 = 0
            goto L_0x0076
        L_0x0074:
            r15 = r34
        L_0x0076:
            r2 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r2 == 0) goto L_0x007c
            r2 = 0
            goto L_0x007e
        L_0x007c:
            r2 = r35
        L_0x007e:
            r14 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r14 == 0) goto L_0x0084
            r14 = 0
            goto L_0x0086
        L_0x0084:
            r14 = r36
        L_0x0086:
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r0 & r16
            if (r16 == 0) goto L_0x0090
            r16 = 99
            goto L_0x0092
        L_0x0090:
            r16 = r37
        L_0x0092:
            r17 = 65536(0x10000, float:9.18355E-41)
            r17 = r0 & r17
            if (r17 == 0) goto L_0x009b
            r17 = 1
            goto L_0x009d
        L_0x009b:
            r17 = r38
        L_0x009d:
            r18 = 131072(0x20000, float:1.83671E-40)
            r18 = r0 & r18
            if (r18 == 0) goto L_0x00a6
            java.lang.String r18 = "1"
            goto L_0x00a8
        L_0x00a6:
            r18 = r39
        L_0x00a8:
            r19 = 262144(0x40000, float:3.67342E-40)
            r19 = r0 & r19
            if (r19 == 0) goto L_0x00b1
            r19 = 0
            goto L_0x00b3
        L_0x00b1:
            r19 = r40
        L_0x00b3:
            r20 = 524288(0x80000, float:7.34684E-40)
            r0 = r0 & r20
            if (r0 == 0) goto L_0x00bb
            r0 = 0
            goto L_0x00bd
        L_0x00bb:
            r0 = r41
        L_0x00bd:
            r22 = r21
            r23 = r1
            r24 = r3
            r25 = r5
            r26 = r6
            r27 = r7
            r28 = r8
            r29 = r9
            r30 = r10
            r31 = r4
            r32 = r11
            r33 = r12
            r34 = r13
            r35 = r15
            r36 = r2
            r37 = r14
            r38 = r16
            r39 = r17
            r40 = r18
            r41 = r19
            r42 = r0
            r22.<init>(r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.shop.bean.UserLeaveComponentData.<init>(boolean, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.List, java.lang.String, boolean, java.lang.String, boolean, int, java.util.List, java.lang.String, java.lang.String, com.tal.app.thinkacademy.business.shop.bean.UserLeaveButtonData, int, int, java.lang.String, int, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final List<UserLeaveComponentDataOption> getOptions() {
        return this.options;
    }

    public final String getOptionsType() {
        return this.optionsType;
    }

    public final void setOptionsType(String str) {
        this.optionsType = str;
    }

    public final boolean getRequired() {
        return this.required;
    }

    public final String getRowUuid() {
        return this.rowUuid;
    }

    public final boolean getShow() {
        return this.show;
    }

    public final void setShow(boolean z) {
        this.show = z;
    }

    public final int getMLocalType() {
        return this.mLocalType;
    }

    public final void setMLocalType(int i) {
        this.mLocalType = i;
    }

    public final List<UserLeaveComponentData> getMLocalButtonTypeChild() {
        return this.mLocalButtonTypeChild;
    }

    public final void setMLocalButtonTypeChild(List<UserLeaveComponentData> list) {
        this.mLocalButtonTypeChild = list;
    }

    public final String getMLocalSelectText() {
        return this.mLocalSelectText;
    }

    public final void setMLocalSelectText(String str) {
        this.mLocalSelectText = str;
    }

    public final String getMLocalDisplaySelectText() {
        return this.mLocalDisplaySelectText;
    }

    public final void setMLocalDisplaySelectText(String str) {
        this.mLocalDisplaySelectText = str;
    }

    public final UserLeaveButtonData getMLocalLeaveButtonData() {
        return this.mLocalLeaveButtonData;
    }

    public final void setMLocalLeaveButtonData(UserLeaveButtonData userLeaveButtonData) {
        this.mLocalLeaveButtonData = userLeaveButtonData;
    }

    public final int getMLocalPhoneLengthMax() {
        return this.mLocalPhoneLengthMax;
    }

    public final void setMLocalPhoneLengthMax(int i) {
        this.mLocalPhoneLengthMax = i;
    }

    public final int getMLocalPhoneLengthMin() {
        return this.mLocalPhoneLengthMin;
    }

    public final void setMLocalPhoneLengthMin(int i) {
        this.mLocalPhoneLengthMin = i;
    }

    public final String getMLocalPhoneAreaNum() {
        return this.mLocalPhoneAreaNum;
    }

    public final void setMLocalPhoneAreaNum(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mLocalPhoneAreaNum = str;
    }

    public final int getMLocalPhoneAreaIndex() {
        return this.mLocalPhoneAreaIndex;
    }

    public final void setMLocalPhoneAreaIndex(int i) {
        this.mLocalPhoneAreaIndex = i;
    }

    public final boolean getMLocalMulti() {
        return this.mLocalMulti;
    }

    public final void setMLocalMulti(boolean z) {
        this.mLocalMulti = z;
    }

    public UserLeaveComponentData(boolean z, String str, String str2, String str3, String str4, List<UserLeaveComponentDataOption> list, String str5, boolean z2, String str6, boolean z3, int i, List<UserLeaveComponentData> list2, String str7, String str8, UserLeaveButtonData userLeaveButtonData, int i2, int i3, String str9, int i4, boolean z4) {
        String str10 = str9;
        Intrinsics.checkNotNullParameter(str10, "mLocalPhoneAreaNum");
        this.custom = z;
        this.def = str;
        this.index = str2;
        this.key = str3;
        this.name = str4;
        this.options = list;
        this.optionsType = str5;
        this.required = z2;
        this.rowUuid = str6;
        this.show = z3;
        this.mLocalType = i;
        this.mLocalButtonTypeChild = list2;
        this.mLocalSelectText = str7;
        this.mLocalDisplaySelectText = str8;
        this.mLocalLeaveButtonData = userLeaveButtonData;
        this.mLocalPhoneLengthMax = i2;
        this.mLocalPhoneLengthMin = i3;
        this.mLocalPhoneAreaNum = str10;
        this.mLocalPhoneAreaIndex = i4;
        this.mLocalMulti = z4;
    }

    public final boolean checkPhoneIsValid() {
        String str = this.mLocalSelectText;
        int length = str == null ? 0 : str.length();
        int i = this.mLocalPhoneLengthMin;
        if (length > this.mLocalPhoneLengthMax || i > length) {
            return false;
        }
        return true;
    }

    public final boolean checkEmailIsValid() {
        return PatternUtil.INSTANCE.emailIsCompliance(this.mLocalSelectText);
    }
}
