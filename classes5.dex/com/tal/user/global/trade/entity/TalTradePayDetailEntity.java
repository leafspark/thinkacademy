package com.tal.user.global.trade.entity;

import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001:\u0002>?B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR\u001a\u0010$\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\bR\u001a\u0010'\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\bR\u001a\u0010*\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0006\"\u0004\b,\u0010\bR\u001a\u0010-\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0006\"\u0004\b/\u0010\bR*\u00100\u001a\u0012\u0012\u0004\u0012\u00020201j\b\u0012\u0004\u0012\u000202`3X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001a\u00108\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u0006\"\u0004\b:\u0010\bR\u001a\u0010;\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u0018\"\u0004\b=\u0010\u001a¨\u0006@"}, d2 = {"Lcom/tal/user/global/trade/entity/TalTradePayDetailEntity;", "Ljava/io/Serializable;", "()V", "businessCode", "", "getBusinessCode", "()Ljava/lang/String;", "setBusinessCode", "(Ljava/lang/String;)V", "channelConfig", "Lcom/tal/user/global/trade/entity/TalTradePayDetailEntity$ExtendConfig;", "getChannelConfig", "()Lcom/tal/user/global/trade/entity/TalTradePayDetailEntity$ExtendConfig;", "setChannelConfig", "(Lcom/tal/user/global/trade/entity/TalTradePayDetailEntity$ExtendConfig;)V", "currency", "getCurrency", "setCurrency", "currencySymbol", "getCurrencySymbol", "setCurrencySymbol", "expireTime", "", "getExpireTime", "()I", "setExpireTime", "(I)V", "finalStatus", "", "getFinalStatus", "()Z", "setFinalStatus", "(Z)V", "goodsDetail", "getGoodsDetail", "setGoodsDetail", "goodsName", "getGoodsName", "setGoodsName", "merchantCode", "getMerchantCode", "setMerchantCode", "merchantOrderNo", "getMerchantOrderNo", "setMerchantOrderNo", "payOrderNo", "getPayOrderNo", "setPayOrderNo", "payWayConfig", "Ljava/util/ArrayList;", "Lcom/tal/user/global/trade/entity/TalTradePayDetailEntity$PayWayConfig;", "Lkotlin/collections/ArrayList;", "getPayWayConfig", "()Ljava/util/ArrayList;", "setPayWayConfig", "(Ljava/util/ArrayList;)V", "showFee", "getShowFee", "setShowFee", "status", "getStatus", "setStatus", "ExtendConfig", "PayWayConfig", "android_taltradeglobal_release"}, k = 1, mv = {1, 4, 2})
/* compiled from: TalTradePayDetailEntity.kt */
public final class TalTradePayDetailEntity implements Serializable {
    private String businessCode = "";
    private ExtendConfig channelConfig;
    private String currency = "";
    private String currencySymbol = "";
    private int expireTime;
    private boolean finalStatus;
    private String goodsDetail = "";
    private String goodsName = "";
    private String merchantCode = "";
    private String merchantOrderNo = "";
    private String payOrderNo = "";
    private ArrayList<PayWayConfig> payWayConfig = new ArrayList<>();
    private String showFee = "";
    private int status;

    public final String getBusinessCode() {
        return this.businessCode;
    }

    public final void setBusinessCode(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.businessCode = str;
    }

    public final String getCurrency() {
        return this.currency;
    }

    public final void setCurrency(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.currency = str;
    }

    public final String getCurrencySymbol() {
        return this.currencySymbol;
    }

    public final void setCurrencySymbol(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.currencySymbol = str;
    }

    public final boolean getFinalStatus() {
        return this.finalStatus;
    }

    public final void setFinalStatus(boolean z) {
        this.finalStatus = z;
    }

    public final String getMerchantCode() {
        return this.merchantCode;
    }

    public final void setMerchantCode(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.merchantCode = str;
    }

    public final String getMerchantOrderNo() {
        return this.merchantOrderNo;
    }

    public final void setMerchantOrderNo(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.merchantOrderNo = str;
    }

    public final String getPayOrderNo() {
        return this.payOrderNo;
    }

    public final void setPayOrderNo(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.payOrderNo = str;
    }

    public final String getGoodsName() {
        return this.goodsName;
    }

    public final void setGoodsName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.goodsName = str;
    }

    public final String getGoodsDetail() {
        return this.goodsDetail;
    }

    public final void setGoodsDetail(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.goodsDetail = str;
    }

    public final ArrayList<PayWayConfig> getPayWayConfig() {
        return this.payWayConfig;
    }

    public final void setPayWayConfig(ArrayList<PayWayConfig> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.payWayConfig = arrayList;
    }

    public final int getStatus() {
        return this.status;
    }

    public final void setStatus(int i) {
        this.status = i;
    }

    public final int getExpireTime() {
        return this.expireTime;
    }

    public final void setExpireTime(int i) {
        this.expireTime = i;
    }

    public final String getShowFee() {
        return this.showFee;
    }

    public final void setShowFee(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.showFee = str;
    }

    public final ExtendConfig getChannelConfig() {
        return this.channelConfig;
    }

    public final void setChannelConfig(ExtendConfig extendConfig) {
        this.channelConfig = extendConfig;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R*\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR\u001a\u0010\u0019\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR\u001a\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\r\"\u0004\b$\u0010\u000fR\u001a\u0010%\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\r\"\u0004\b'\u0010\u000f¨\u0006("}, d2 = {"Lcom/tal/user/global/trade/entity/TalTradePayDetailEntity$PayWayConfig;", "Ljava/io/Serializable;", "()V", "brands", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getBrands", "()Ljava/util/ArrayList;", "setBrands", "(Ljava/util/ArrayList;)V", "channelCode", "getChannelCode", "()Ljava/lang/String;", "setChannelCode", "(Ljava/lang/String;)V", "checked", "", "getChecked", "()Z", "setChecked", "(Z)V", "logoUrl", "getLogoUrl", "setLogoUrl", "payBtnText", "getPayBtnText", "setPayBtnText", "payProduct", "", "getPayProduct", "()I", "setPayProduct", "(I)V", "payProductName", "getPayProductName", "setPayProductName", "type", "getType", "setType", "android_taltradeglobal_release"}, k = 1, mv = {1, 4, 2})
    /* compiled from: TalTradePayDetailEntity.kt */
    public static final class PayWayConfig implements Serializable {
        private ArrayList<String> brands = new ArrayList<>();
        private String channelCode = "";
        private boolean checked;
        private String logoUrl = "";
        private String payBtnText = "";
        private int payProduct;
        private String payProductName = "";
        private String type = "";

        public final int getPayProduct() {
            return this.payProduct;
        }

        public final void setPayProduct(int i) {
            this.payProduct = i;
        }

        public final String getPayProductName() {
            return this.payProductName;
        }

        public final void setPayProductName(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.payProductName = str;
        }

        public final String getLogoUrl() {
            return this.logoUrl;
        }

        public final void setLogoUrl(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.logoUrl = str;
        }

        public final String getChannelCode() {
            return this.channelCode;
        }

        public final void setChannelCode(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.channelCode = str;
        }

        public final String getType() {
            return this.type;
        }

        public final void setType(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.type = str;
        }

        public final String getPayBtnText() {
            return this.payBtnText;
        }

        public final void setPayBtnText(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.payBtnText = str;
        }

        public final boolean getChecked() {
            return this.checked;
        }

        public final void setChecked(boolean z) {
            this.checked = z;
        }

        public final ArrayList<String> getBrands() {
            return this.brands;
        }

        public final void setBrands(ArrayList<String> arrayList) {
            Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
            this.brands = arrayList;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/tal/user/global/trade/entity/TalTradePayDetailEntity$ExtendConfig;", "Ljava/io/Serializable;", "()V", "adyenClientKey", "", "getAdyenClientKey", "()Ljava/lang/String;", "setAdyenClientKey", "(Ljava/lang/String;)V", "android_taltradeglobal_release"}, k = 1, mv = {1, 4, 2})
    /* compiled from: TalTradePayDetailEntity.kt */
    public static final class ExtendConfig implements Serializable {
        private String adyenClientKey = "";

        public final String getAdyenClientKey() {
            return this.adyenClientKey;
        }

        public final void setAdyenClientKey(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.adyenClientKey = str;
        }
    }
}
