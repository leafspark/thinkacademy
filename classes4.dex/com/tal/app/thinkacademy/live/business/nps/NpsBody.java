package com.tal.app.thinkacademy.live.business.nps;

import com.tal.app.thinkacademy.common.util.HwLanguageUtil;
import com.tal.app.thinkacademy.lib.language.LanguageUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\b\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/nps/NpsBody;", "", "planId", "", "languageType", "", "(ILjava/lang/String;)V", "getLanguageType", "()Ljava/lang/String;", "getPlanId", "()I", "setPlanId", "(I)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NpsBody.kt */
public final class NpsBody {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final String languageType;
    private int planId;

    public static /* synthetic */ NpsBody copy$default(NpsBody npsBody, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = npsBody.planId;
        }
        if ((i2 & 2) != 0) {
            str = npsBody.languageType;
        }
        return npsBody.copy(i, str);
    }

    public final int component1() {
        return this.planId;
    }

    public final String component2() {
        return this.languageType;
    }

    public final NpsBody copy(int i, String str) {
        Intrinsics.checkNotNullParameter(str, "languageType");
        return new NpsBody(i, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NpsBody)) {
            return false;
        }
        NpsBody npsBody = (NpsBody) obj;
        return this.planId == npsBody.planId && Intrinsics.areEqual(this.languageType, npsBody.languageType);
    }

    public int hashCode() {
        return (this.planId * 31) + this.languageType.hashCode();
    }

    public String toString() {
        return "NpsBody(planId=" + this.planId + ", languageType=" + this.languageType + ')';
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/nps/NpsBody$Companion;", "", "()V", "createRequest", "Lcom/tal/app/thinkacademy/live/business/nps/NpsBody;", "planId", "", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: NpsBody.kt */
    public static final class Companion {

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: NpsBody.kt */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[HwLanguageUtil.HwLanguageInfo.values().length];
                iArr[HwLanguageUtil.HwLanguageInfo.CHINESE.ordinal()] = 1;
                iArr[HwLanguageUtil.HwLanguageInfo.CHINESE_HK.ordinal()] = 2;
                iArr[HwLanguageUtil.HwLanguageInfo.ENGLISH.ordinal()] = 3;
                iArr[HwLanguageUtil.HwLanguageInfo.ENGLISH_UK.ordinal()] = 4;
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final NpsBody createRequest(int i) {
            int i2 = WhenMappings.$EnumSwitchMapping$0[HwLanguageUtil.INSTANCE.getCurrentLanguage().ordinal()];
            String str = LanguageUtil.EN;
            if (i2 == 1) {
                str = "zh-CN";
            } else if (i2 == 2) {
                str = "zh-HK";
            } else if (i2 != 3 && i2 == 4) {
                str = "en-GB";
            }
            return new NpsBody(i, str);
        }
    }

    public NpsBody(int i, String str) {
        Intrinsics.checkNotNullParameter(str, "languageType");
        this.planId = i;
        this.languageType = str;
    }

    public final String getLanguageType() {
        return this.languageType;
    }

    public final int getPlanId() {
        return this.planId;
    }

    public final void setPlanId(int i) {
        this.planId = i;
    }
}
