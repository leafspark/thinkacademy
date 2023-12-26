package com.tal.app.thinkacademy.business.home.main.shop.bean;

import com.tal.app.thinkacademy.business.shop.bean.ShopItemClassCardNode;
import java.util.List;
import kotlin.Metadata;
import kotlin.io.ConstantsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\bQ\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B\u0003\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010(J\u0011\u0010P\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010Q\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010,J\u0010\u0010R\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010,J\u0010\u0010S\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010,J\u0010\u0010T\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0002\u0010:J\u0010\u0010U\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0002\u0010:J\u0010\u0010V\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0002\u0010:J\u0010\u0010W\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010,J\u0010\u0010X\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010,J\u0010\u0010Y\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010,J\u0010\u0010Z\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0002\u0010:J\u0010\u0010[\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010,J\u0010\u0010\\\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010,J\u000b\u0010]\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010^\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010,J\u000b\u0010_\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010`\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010,J\u0010\u0010a\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010,J\u0010\u0010b\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010,J\u000b\u0010c\u001a\u0004\u0018\u00010\"HÆ\u0003J\u0010\u0010d\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010,J\u0010\u0010e\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010,J\u0011\u0010f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003HÆ\u0003J\u0010\u0010g\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010,J\u000b\u0010h\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010i\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010j\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010,J\u000b\u0010k\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010l\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010m\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010n\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010,J\u000b\u0010o\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0003\u0010p\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010qJ\u0013\u0010r\u001a\u00020\u00132\b\u0010s\u001a\u0004\u0018\u00010tHÖ\u0003J\t\u0010u\u001a\u00020\u0006HÖ\u0001J\t\u0010v\u001a\u00020\bHÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010-\u001a\u0004\b+\u0010,R\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010*R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010-\u001a\u0004\b/\u0010,R\u0013\u0010\n\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b2\u00101R\u0013\u0010\f\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b3\u00101R\u0015\u0010\r\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010-\u001a\u0004\b4\u0010,R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b5\u00101R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010-\u001a\u0004\b6\u0010,R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010-\u001a\u0004\b7\u0010,R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010-\u001a\u0004\b8\u0010,R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\n\n\u0002\u0010;\u001a\u0004\b9\u0010:R\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u0013¢\u0006\n\n\u0002\u0010;\u001a\u0004\b<\u0010:R\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u0013¢\u0006\n\n\u0002\u0010;\u001a\u0004\b=\u0010:R\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010-\u001a\u0004\b>\u0010,R\u0015\u0010\u0017\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010-\u001a\u0004\b?\u0010,R\u0015\u0010\u0018\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010-\u001a\u0004\b@\u0010,R\u0015\u0010\u0019\u001a\u0004\u0018\u00010\u0013¢\u0006\n\n\u0002\u0010;\u001a\u0004\bA\u0010:R\u0015\u0010\u001a\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010-\u001a\u0004\bB\u0010,R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\bC\u00101R\u0015\u0010\u001c\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010-\u001a\u0004\bD\u0010,R\u0013\u0010\u001d\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\bE\u00101R\u0015\u0010\u001e\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010-\u001a\u0004\bF\u0010,R\u0015\u0010\u001f\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010-\u001a\u0004\bG\u0010,R\u0015\u0010 \u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010-\u001a\u0004\bH\u0010,R\u0013\u0010!\u001a\u0004\u0018\u00010\"¢\u0006\b\n\u0000\u001a\u0004\bI\u0010JR\u0015\u0010#\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010-\u001a\u0004\bK\u0010,R\u0015\u0010$\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010-\u001a\u0004\bL\u0010,R\u0015\u0010%\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010-\u001a\u0004\bM\u0010,R\u0013\u0010&\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\bN\u00101R\u0013\u0010'\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\bO\u00101¨\u0006w"}, d2 = {"Lcom/tal/app/thinkacademy/business/home/main/shop/bean/ShopHomeDataType2Clazz;", "Lcom/tal/app/thinkacademy/business/shop/bean/ShopItemClassCardNode;", "attachedItems", "", "Lcom/tal/app/thinkacademy/business/home/main/shop/bean/AttachedItem;", "attachedShowPrices", "", "banners", "", "clazzCategory", "clazzFeeName", "description", "detailPic", "goodsCategoryId", "goodsFeeName", "id", "makePriceIsInclude", "needPostAdd", "onSell", "", "onShow", "online", "orgPrice", "origin", "packagePrice", "purchased", "remainSellTime", "sellEndTime", "sellPrice", "sellStartTime", "sellStore", "showPrice", "showPriceIsInclude", "spec", "Lcom/tal/app/thinkacademy/business/home/main/shop/bean/Spec;", "spuId", "standardPrice", "store", "subTitle", "title", "(Ljava/util/List;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/tal/app/thinkacademy/business/home/main/shop/bean/Spec;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getAttachedItems", "()Ljava/util/List;", "getAttachedShowPrices", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getBanners", "getClazzCategory", "getClazzFeeName", "()Ljava/lang/String;", "getDescription", "getDetailPic", "getGoodsCategoryId", "getGoodsFeeName", "getId", "getMakePriceIsInclude", "getNeedPostAdd", "getOnSell", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getOnShow", "getOnline", "getOrgPrice", "getOrigin", "getPackagePrice", "getPurchased", "getRemainSellTime", "getSellEndTime", "getSellPrice", "getSellStartTime", "getSellStore", "getShowPrice", "getShowPriceIsInclude", "getSpec", "()Lcom/tal/app/thinkacademy/business/home/main/shop/bean/Spec;", "getSpuId", "getStandardPrice", "getStore", "getSubTitle", "getTitle", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/util/List;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/tal/app/thinkacademy/business/home/main/shop/bean/Spec;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/tal/app/thinkacademy/business/home/main/shop/bean/ShopHomeDataType2Clazz;", "equals", "other", "", "hashCode", "toString", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShopHomeDataType2.kt */
public final class ShopHomeDataType2Clazz extends ShopItemClassCardNode {
    private final List<AttachedItem> attachedItems;
    private final Integer attachedShowPrices;
    private final List<String> banners;
    private final Integer clazzCategory;
    private final String clazzFeeName;
    private final String description;
    private final String detailPic;
    private final Integer goodsCategoryId;
    private final String goodsFeeName;
    private final Integer id;
    private final Integer makePriceIsInclude;
    private final Integer needPostAdd;
    private final Boolean onSell;
    private final Boolean onShow;
    private final Boolean online;
    private final Integer orgPrice;
    private final Integer origin;
    private final Integer packagePrice;
    private final Boolean purchased;
    private final Integer remainSellTime;
    private final String sellEndTime;
    private final Integer sellPrice;
    private final String sellStartTime;
    private final Integer sellStore;
    private final Integer showPrice;
    private final Integer showPriceIsInclude;
    private final Spec spec;
    private final Integer spuId;
    private final Integer standardPrice;
    private final Integer store;
    private final String subTitle;
    private final String title;

    public ShopHomeDataType2Clazz() {
        this((List) null, (Integer) null, (List) null, (Integer) null, (String) null, (String) null, (String) null, (Integer) null, (String) null, (Integer) null, (Integer) null, (Integer) null, (Boolean) null, (Boolean) null, (Boolean) null, (Integer) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (String) null, (Integer) null, (String) null, (Integer) null, (Integer) null, (Integer) null, (Spec) null, (Integer) null, (Integer) null, (Integer) null, (String) null, (String) null, -1, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ShopHomeDataType2Clazz copy$default(ShopHomeDataType2Clazz shopHomeDataType2Clazz, List list, Integer num, List list2, Integer num2, String str, String str2, String str3, Integer num3, String str4, Integer num4, Integer num5, Integer num6, Boolean bool, Boolean bool2, Boolean bool3, Integer num7, Integer num8, Integer num9, Boolean bool4, Integer num10, String str5, Integer num11, String str6, Integer num12, Integer num13, Integer num14, Spec spec2, Integer num15, Integer num16, Integer num17, String str7, String str8, int i, Object obj) {
        ShopHomeDataType2Clazz shopHomeDataType2Clazz2 = shopHomeDataType2Clazz;
        int i2 = i;
        return shopHomeDataType2Clazz.copy((i2 & 1) != 0 ? shopHomeDataType2Clazz2.attachedItems : list, (i2 & 2) != 0 ? shopHomeDataType2Clazz2.attachedShowPrices : num, (i2 & 4) != 0 ? shopHomeDataType2Clazz2.banners : list2, (i2 & 8) != 0 ? shopHomeDataType2Clazz2.clazzCategory : num2, (i2 & 16) != 0 ? shopHomeDataType2Clazz2.clazzFeeName : str, (i2 & 32) != 0 ? shopHomeDataType2Clazz2.description : str2, (i2 & 64) != 0 ? shopHomeDataType2Clazz2.detailPic : str3, (i2 & 128) != 0 ? shopHomeDataType2Clazz2.goodsCategoryId : num3, (i2 & 256) != 0 ? shopHomeDataType2Clazz2.goodsFeeName : str4, (i2 & ConstantsKt.MINIMUM_BLOCK_SIZE) != 0 ? shopHomeDataType2Clazz2.id : num4, (i2 & 1024) != 0 ? shopHomeDataType2Clazz2.makePriceIsInclude : num5, (i2 & 2048) != 0 ? shopHomeDataType2Clazz2.needPostAdd : num6, (i2 & ConstantsKt.DEFAULT_BLOCK_SIZE) != 0 ? shopHomeDataType2Clazz2.onSell : bool, (i2 & ConstantsKt.DEFAULT_BUFFER_SIZE) != 0 ? shopHomeDataType2Clazz2.onShow : bool2, (i2 & 16384) != 0 ? shopHomeDataType2Clazz2.online : bool3, (i2 & 32768) != 0 ? shopHomeDataType2Clazz2.orgPrice : num7, (i2 & 65536) != 0 ? shopHomeDataType2Clazz2.origin : num8, (i2 & 131072) != 0 ? shopHomeDataType2Clazz2.packagePrice : num9, (i2 & 262144) != 0 ? shopHomeDataType2Clazz2.purchased : bool4, (i2 & 524288) != 0 ? shopHomeDataType2Clazz2.remainSellTime : num10, (i2 & 1048576) != 0 ? shopHomeDataType2Clazz2.sellEndTime : str5, (i2 & 2097152) != 0 ? shopHomeDataType2Clazz2.sellPrice : num11, (i2 & 4194304) != 0 ? shopHomeDataType2Clazz2.sellStartTime : str6, (i2 & 8388608) != 0 ? shopHomeDataType2Clazz2.sellStore : num12, (i2 & 16777216) != 0 ? shopHomeDataType2Clazz2.showPrice : num13, (i2 & 33554432) != 0 ? shopHomeDataType2Clazz2.showPriceIsInclude : num14, (i2 & 67108864) != 0 ? shopHomeDataType2Clazz2.spec : spec2, (i2 & 134217728) != 0 ? shopHomeDataType2Clazz2.spuId : num15, (i2 & 268435456) != 0 ? shopHomeDataType2Clazz2.standardPrice : num16, (i2 & 536870912) != 0 ? shopHomeDataType2Clazz2.store : num17, (i2 & 1073741824) != 0 ? shopHomeDataType2Clazz2.subTitle : str7, (i2 & IntCompanionObject.MIN_VALUE) != 0 ? shopHomeDataType2Clazz2.title : str8);
    }

    public final List<AttachedItem> component1() {
        return this.attachedItems;
    }

    public final Integer component10() {
        return this.id;
    }

    public final Integer component11() {
        return this.makePriceIsInclude;
    }

    public final Integer component12() {
        return this.needPostAdd;
    }

    public final Boolean component13() {
        return this.onSell;
    }

    public final Boolean component14() {
        return this.onShow;
    }

    public final Boolean component15() {
        return this.online;
    }

    public final Integer component16() {
        return this.orgPrice;
    }

    public final Integer component17() {
        return this.origin;
    }

    public final Integer component18() {
        return this.packagePrice;
    }

    public final Boolean component19() {
        return this.purchased;
    }

    public final Integer component2() {
        return this.attachedShowPrices;
    }

    public final Integer component20() {
        return this.remainSellTime;
    }

    public final String component21() {
        return this.sellEndTime;
    }

    public final Integer component22() {
        return this.sellPrice;
    }

    public final String component23() {
        return this.sellStartTime;
    }

    public final Integer component24() {
        return this.sellStore;
    }

    public final Integer component25() {
        return this.showPrice;
    }

    public final Integer component26() {
        return this.showPriceIsInclude;
    }

    public final Spec component27() {
        return this.spec;
    }

    public final Integer component28() {
        return this.spuId;
    }

    public final Integer component29() {
        return this.standardPrice;
    }

    public final List<String> component3() {
        return this.banners;
    }

    public final Integer component30() {
        return this.store;
    }

    public final String component31() {
        return this.subTitle;
    }

    public final String component32() {
        return this.title;
    }

    public final Integer component4() {
        return this.clazzCategory;
    }

    public final String component5() {
        return this.clazzFeeName;
    }

    public final String component6() {
        return this.description;
    }

    public final String component7() {
        return this.detailPic;
    }

    public final Integer component8() {
        return this.goodsCategoryId;
    }

    public final String component9() {
        return this.goodsFeeName;
    }

    public final ShopHomeDataType2Clazz copy(List<AttachedItem> list, Integer num, List<String> list2, Integer num2, String str, String str2, String str3, Integer num3, String str4, Integer num4, Integer num5, Integer num6, Boolean bool, Boolean bool2, Boolean bool3, Integer num7, Integer num8, Integer num9, Boolean bool4, Integer num10, String str5, Integer num11, String str6, Integer num12, Integer num13, Integer num14, Spec spec2, Integer num15, Integer num16, Integer num17, String str7, String str8) {
        return new ShopHomeDataType2Clazz(list, num, list2, num2, str, str2, str3, num3, str4, num4, num5, num6, bool, bool2, bool3, num7, num8, num9, bool4, num10, str5, num11, str6, num12, num13, num14, spec2, num15, num16, num17, str7, str8);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShopHomeDataType2Clazz)) {
            return false;
        }
        ShopHomeDataType2Clazz shopHomeDataType2Clazz = (ShopHomeDataType2Clazz) obj;
        return Intrinsics.areEqual((Object) this.attachedItems, (Object) shopHomeDataType2Clazz.attachedItems) && Intrinsics.areEqual((Object) this.attachedShowPrices, (Object) shopHomeDataType2Clazz.attachedShowPrices) && Intrinsics.areEqual((Object) this.banners, (Object) shopHomeDataType2Clazz.banners) && Intrinsics.areEqual((Object) this.clazzCategory, (Object) shopHomeDataType2Clazz.clazzCategory) && Intrinsics.areEqual((Object) this.clazzFeeName, (Object) shopHomeDataType2Clazz.clazzFeeName) && Intrinsics.areEqual((Object) this.description, (Object) shopHomeDataType2Clazz.description) && Intrinsics.areEqual((Object) this.detailPic, (Object) shopHomeDataType2Clazz.detailPic) && Intrinsics.areEqual((Object) this.goodsCategoryId, (Object) shopHomeDataType2Clazz.goodsCategoryId) && Intrinsics.areEqual((Object) this.goodsFeeName, (Object) shopHomeDataType2Clazz.goodsFeeName) && Intrinsics.areEqual((Object) this.id, (Object) shopHomeDataType2Clazz.id) && Intrinsics.areEqual((Object) this.makePriceIsInclude, (Object) shopHomeDataType2Clazz.makePriceIsInclude) && Intrinsics.areEqual((Object) this.needPostAdd, (Object) shopHomeDataType2Clazz.needPostAdd) && Intrinsics.areEqual((Object) this.onSell, (Object) shopHomeDataType2Clazz.onSell) && Intrinsics.areEqual((Object) this.onShow, (Object) shopHomeDataType2Clazz.onShow) && Intrinsics.areEqual((Object) this.online, (Object) shopHomeDataType2Clazz.online) && Intrinsics.areEqual((Object) this.orgPrice, (Object) shopHomeDataType2Clazz.orgPrice) && Intrinsics.areEqual((Object) this.origin, (Object) shopHomeDataType2Clazz.origin) && Intrinsics.areEqual((Object) this.packagePrice, (Object) shopHomeDataType2Clazz.packagePrice) && Intrinsics.areEqual((Object) this.purchased, (Object) shopHomeDataType2Clazz.purchased) && Intrinsics.areEqual((Object) this.remainSellTime, (Object) shopHomeDataType2Clazz.remainSellTime) && Intrinsics.areEqual((Object) this.sellEndTime, (Object) shopHomeDataType2Clazz.sellEndTime) && Intrinsics.areEqual((Object) this.sellPrice, (Object) shopHomeDataType2Clazz.sellPrice) && Intrinsics.areEqual((Object) this.sellStartTime, (Object) shopHomeDataType2Clazz.sellStartTime) && Intrinsics.areEqual((Object) this.sellStore, (Object) shopHomeDataType2Clazz.sellStore) && Intrinsics.areEqual((Object) this.showPrice, (Object) shopHomeDataType2Clazz.showPrice) && Intrinsics.areEqual((Object) this.showPriceIsInclude, (Object) shopHomeDataType2Clazz.showPriceIsInclude) && Intrinsics.areEqual((Object) this.spec, (Object) shopHomeDataType2Clazz.spec) && Intrinsics.areEqual((Object) this.spuId, (Object) shopHomeDataType2Clazz.spuId) && Intrinsics.areEqual((Object) this.standardPrice, (Object) shopHomeDataType2Clazz.standardPrice) && Intrinsics.areEqual((Object) this.store, (Object) shopHomeDataType2Clazz.store) && Intrinsics.areEqual((Object) this.subTitle, (Object) shopHomeDataType2Clazz.subTitle) && Intrinsics.areEqual((Object) this.title, (Object) shopHomeDataType2Clazz.title);
    }

    public int hashCode() {
        List<AttachedItem> list = this.attachedItems;
        int i = 0;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        Integer num = this.attachedShowPrices;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        List<String> list2 = this.banners;
        int hashCode3 = (hashCode2 + (list2 == null ? 0 : list2.hashCode())) * 31;
        Integer num2 = this.clazzCategory;
        int hashCode4 = (hashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str = this.clazzFeeName;
        int hashCode5 = (hashCode4 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.description;
        int hashCode6 = (hashCode5 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.detailPic;
        int hashCode7 = (hashCode6 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num3 = this.goodsCategoryId;
        int hashCode8 = (hashCode7 + (num3 == null ? 0 : num3.hashCode())) * 31;
        String str4 = this.goodsFeeName;
        int hashCode9 = (hashCode8 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Integer num4 = this.id;
        int hashCode10 = (hashCode9 + (num4 == null ? 0 : num4.hashCode())) * 31;
        Integer num5 = this.makePriceIsInclude;
        int hashCode11 = (hashCode10 + (num5 == null ? 0 : num5.hashCode())) * 31;
        Integer num6 = this.needPostAdd;
        int hashCode12 = (hashCode11 + (num6 == null ? 0 : num6.hashCode())) * 31;
        Boolean bool = this.onSell;
        int hashCode13 = (hashCode12 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.onShow;
        int hashCode14 = (hashCode13 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.online;
        int hashCode15 = (hashCode14 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        Integer num7 = this.orgPrice;
        int hashCode16 = (hashCode15 + (num7 == null ? 0 : num7.hashCode())) * 31;
        Integer num8 = this.origin;
        int hashCode17 = (hashCode16 + (num8 == null ? 0 : num8.hashCode())) * 31;
        Integer num9 = this.packagePrice;
        int hashCode18 = (hashCode17 + (num9 == null ? 0 : num9.hashCode())) * 31;
        Boolean bool4 = this.purchased;
        int hashCode19 = (hashCode18 + (bool4 == null ? 0 : bool4.hashCode())) * 31;
        Integer num10 = this.remainSellTime;
        int hashCode20 = (hashCode19 + (num10 == null ? 0 : num10.hashCode())) * 31;
        String str5 = this.sellEndTime;
        int hashCode21 = (hashCode20 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Integer num11 = this.sellPrice;
        int hashCode22 = (hashCode21 + (num11 == null ? 0 : num11.hashCode())) * 31;
        String str6 = this.sellStartTime;
        int hashCode23 = (hashCode22 + (str6 == null ? 0 : str6.hashCode())) * 31;
        Integer num12 = this.sellStore;
        int hashCode24 = (hashCode23 + (num12 == null ? 0 : num12.hashCode())) * 31;
        Integer num13 = this.showPrice;
        int hashCode25 = (hashCode24 + (num13 == null ? 0 : num13.hashCode())) * 31;
        Integer num14 = this.showPriceIsInclude;
        int hashCode26 = (hashCode25 + (num14 == null ? 0 : num14.hashCode())) * 31;
        Spec spec2 = this.spec;
        int hashCode27 = (hashCode26 + (spec2 == null ? 0 : spec2.hashCode())) * 31;
        Integer num15 = this.spuId;
        int hashCode28 = (hashCode27 + (num15 == null ? 0 : num15.hashCode())) * 31;
        Integer num16 = this.standardPrice;
        int hashCode29 = (hashCode28 + (num16 == null ? 0 : num16.hashCode())) * 31;
        Integer num17 = this.store;
        int hashCode30 = (hashCode29 + (num17 == null ? 0 : num17.hashCode())) * 31;
        String str7 = this.subTitle;
        int hashCode31 = (hashCode30 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.title;
        if (str8 != null) {
            i = str8.hashCode();
        }
        return hashCode31 + i;
    }

    public String toString() {
        return "ShopHomeDataType2Clazz(attachedItems=" + this.attachedItems + ", attachedShowPrices=" + this.attachedShowPrices + ", banners=" + this.banners + ", clazzCategory=" + this.clazzCategory + ", clazzFeeName=" + this.clazzFeeName + ", description=" + this.description + ", detailPic=" + this.detailPic + ", goodsCategoryId=" + this.goodsCategoryId + ", goodsFeeName=" + this.goodsFeeName + ", id=" + this.id + ", makePriceIsInclude=" + this.makePriceIsInclude + ", needPostAdd=" + this.needPostAdd + ", onSell=" + this.onSell + ", onShow=" + this.onShow + ", online=" + this.online + ", orgPrice=" + this.orgPrice + ", origin=" + this.origin + ", packagePrice=" + this.packagePrice + ", purchased=" + this.purchased + ", remainSellTime=" + this.remainSellTime + ", sellEndTime=" + this.sellEndTime + ", sellPrice=" + this.sellPrice + ", sellStartTime=" + this.sellStartTime + ", sellStore=" + this.sellStore + ", showPrice=" + this.showPrice + ", showPriceIsInclude=" + this.showPriceIsInclude + ", spec=" + this.spec + ", spuId=" + this.spuId + ", standardPrice=" + this.standardPrice + ", store=" + this.store + ", subTitle=" + this.subTitle + ", title=" + this.title + ')';
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ShopHomeDataType2Clazz(java.util.List r70, java.lang.Integer r71, java.util.List r72, java.lang.Integer r73, java.lang.String r74, java.lang.String r75, java.lang.String r76, java.lang.Integer r77, java.lang.String r78, java.lang.Integer r79, java.lang.Integer r80, java.lang.Integer r81, java.lang.Boolean r82, java.lang.Boolean r83, java.lang.Boolean r84, java.lang.Integer r85, java.lang.Integer r86, java.lang.Integer r87, java.lang.Boolean r88, java.lang.Integer r89, java.lang.String r90, java.lang.Integer r91, java.lang.String r92, java.lang.Integer r93, java.lang.Integer r94, java.lang.Integer r95, com.tal.app.thinkacademy.business.home.main.shop.bean.Spec r96, java.lang.Integer r97, java.lang.Integer r98, java.lang.Integer r99, java.lang.String r100, java.lang.String r101, int r102, kotlin.jvm.internal.DefaultConstructorMarker r103) {
        /*
            r69 = this;
            r0 = r102
            r1 = r0 & 1
            if (r1 == 0) goto L_0x000b
            java.util.List r1 = kotlin.collections.CollectionsKt.emptyList()
            goto L_0x000d
        L_0x000b:
            r1 = r70
        L_0x000d:
            r2 = r0 & 2
            r3 = 0
            if (r2 == 0) goto L_0x0017
            java.lang.Integer r2 = java.lang.Integer.valueOf(r3)
            goto L_0x0019
        L_0x0017:
            r2 = r71
        L_0x0019:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0022
            java.util.List r4 = kotlin.collections.CollectionsKt.emptyList()
            goto L_0x0024
        L_0x0022:
            r4 = r72
        L_0x0024:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x002d
            java.lang.Integer r5 = java.lang.Integer.valueOf(r3)
            goto L_0x002f
        L_0x002d:
            r5 = r73
        L_0x002f:
            r6 = r0 & 16
            java.lang.String r7 = ""
            if (r6 == 0) goto L_0x0037
            r6 = r7
            goto L_0x0039
        L_0x0037:
            r6 = r74
        L_0x0039:
            r8 = r0 & 32
            if (r8 == 0) goto L_0x003f
            r8 = r7
            goto L_0x0041
        L_0x003f:
            r8 = r75
        L_0x0041:
            r9 = r0 & 64
            if (r9 == 0) goto L_0x0047
            r9 = r7
            goto L_0x0049
        L_0x0047:
            r9 = r76
        L_0x0049:
            r10 = r0 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x0052
            java.lang.Integer r10 = java.lang.Integer.valueOf(r3)
            goto L_0x0054
        L_0x0052:
            r10 = r77
        L_0x0054:
            r11 = r0 & 256(0x100, float:3.59E-43)
            if (r11 == 0) goto L_0x005a
            r11 = r7
            goto L_0x005c
        L_0x005a:
            r11 = r78
        L_0x005c:
            r12 = r0 & 512(0x200, float:7.175E-43)
            if (r12 == 0) goto L_0x0065
            java.lang.Integer r12 = java.lang.Integer.valueOf(r3)
            goto L_0x0067
        L_0x0065:
            r12 = r79
        L_0x0067:
            r13 = r0 & 1024(0x400, float:1.435E-42)
            if (r13 == 0) goto L_0x0070
            java.lang.Integer r13 = java.lang.Integer.valueOf(r3)
            goto L_0x0072
        L_0x0070:
            r13 = r80
        L_0x0072:
            r14 = r0 & 2048(0x800, float:2.87E-42)
            if (r14 == 0) goto L_0x007b
            java.lang.Integer r14 = java.lang.Integer.valueOf(r3)
            goto L_0x007d
        L_0x007b:
            r14 = r81
        L_0x007d:
            r15 = r0 & 4096(0x1000, float:5.74E-42)
            if (r15 == 0) goto L_0x0086
            java.lang.Boolean r15 = java.lang.Boolean.valueOf(r3)
            goto L_0x0088
        L_0x0086:
            r15 = r82
        L_0x0088:
            r70 = r7
            r7 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r7 == 0) goto L_0x0093
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r3)
            goto L_0x0095
        L_0x0093:
            r7 = r83
        L_0x0095:
            r103 = r7
            r7 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r7 == 0) goto L_0x00a0
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r3)
            goto L_0x00a2
        L_0x00a0:
            r7 = r84
        L_0x00a2:
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r0 & r16
            if (r16 == 0) goto L_0x00ae
            java.lang.Integer r16 = java.lang.Integer.valueOf(r3)
            goto L_0x00b0
        L_0x00ae:
            r16 = r85
        L_0x00b0:
            r17 = 65536(0x10000, float:9.18355E-41)
            r17 = r0 & r17
            if (r17 == 0) goto L_0x00bb
            java.lang.Integer r17 = java.lang.Integer.valueOf(r3)
            goto L_0x00bd
        L_0x00bb:
            r17 = r86
        L_0x00bd:
            r18 = 131072(0x20000, float:1.83671E-40)
            r18 = r0 & r18
            if (r18 == 0) goto L_0x00c8
            java.lang.Integer r18 = java.lang.Integer.valueOf(r3)
            goto L_0x00ca
        L_0x00c8:
            r18 = r87
        L_0x00ca:
            r19 = 262144(0x40000, float:3.67342E-40)
            r19 = r0 & r19
            if (r19 == 0) goto L_0x00d5
            java.lang.Boolean r19 = java.lang.Boolean.valueOf(r3)
            goto L_0x00d7
        L_0x00d5:
            r19 = r88
        L_0x00d7:
            r20 = 524288(0x80000, float:7.34684E-40)
            r20 = r0 & r20
            if (r20 == 0) goto L_0x00e2
            java.lang.Integer r20 = java.lang.Integer.valueOf(r3)
            goto L_0x00e4
        L_0x00e2:
            r20 = r89
        L_0x00e4:
            r21 = 1048576(0x100000, float:1.469368E-39)
            r21 = r0 & r21
            if (r21 == 0) goto L_0x00ed
            r21 = r70
            goto L_0x00ef
        L_0x00ed:
            r21 = r90
        L_0x00ef:
            r22 = 2097152(0x200000, float:2.938736E-39)
            r22 = r0 & r22
            if (r22 == 0) goto L_0x00fa
            java.lang.Integer r22 = java.lang.Integer.valueOf(r3)
            goto L_0x00fc
        L_0x00fa:
            r22 = r91
        L_0x00fc:
            r23 = 4194304(0x400000, float:5.877472E-39)
            r23 = r0 & r23
            if (r23 == 0) goto L_0x0105
            r23 = r70
            goto L_0x0107
        L_0x0105:
            r23 = r92
        L_0x0107:
            r24 = 8388608(0x800000, float:1.17549435E-38)
            r24 = r0 & r24
            if (r24 == 0) goto L_0x0112
            java.lang.Integer r24 = java.lang.Integer.valueOf(r3)
            goto L_0x0114
        L_0x0112:
            r24 = r93
        L_0x0114:
            r25 = 16777216(0x1000000, float:2.3509887E-38)
            r25 = r0 & r25
            if (r25 == 0) goto L_0x011f
            java.lang.Integer r25 = java.lang.Integer.valueOf(r3)
            goto L_0x0121
        L_0x011f:
            r25 = r94
        L_0x0121:
            r26 = 33554432(0x2000000, float:9.403955E-38)
            r26 = r0 & r26
            if (r26 == 0) goto L_0x012c
            java.lang.Integer r26 = java.lang.Integer.valueOf(r3)
            goto L_0x012e
        L_0x012c:
            r26 = r95
        L_0x012e:
            r27 = 67108864(0x4000000, float:1.5046328E-36)
            r27 = r0 & r27
            if (r27 == 0) goto L_0x018c
            com.tal.app.thinkacademy.business.home.main.shop.bean.Spec r27 = new com.tal.app.thinkacademy.business.home.main.shop.bean.Spec
            r28 = r27
            r29 = 0
            r30 = 0
            r31 = 0
            r32 = 0
            r33 = 0
            r34 = 0
            r35 = 0
            r36 = 0
            r37 = 0
            r38 = 0
            r39 = 0
            r40 = 0
            r41 = 0
            r42 = 0
            r43 = 0
            r44 = 0
            r45 = 0
            r46 = 0
            r47 = 0
            r48 = 0
            r49 = 0
            r50 = 0
            r51 = 0
            r52 = 0
            r53 = 0
            r54 = 0
            r55 = 0
            r56 = 0
            r57 = 0
            r58 = 0
            r59 = 0
            r60 = 0
            r61 = 0
            r62 = 0
            r63 = 0
            r64 = 0
            r65 = 0
            r66 = -1
            r67 = 31
            r68 = 0
            r28.<init>(r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64, r65, r66, r67, r68)
            goto L_0x018e
        L_0x018c:
            r27 = r96
        L_0x018e:
            r28 = 134217728(0x8000000, float:3.85186E-34)
            r28 = r0 & r28
            if (r28 == 0) goto L_0x0199
            java.lang.Integer r28 = java.lang.Integer.valueOf(r3)
            goto L_0x019b
        L_0x0199:
            r28 = r97
        L_0x019b:
            r29 = 268435456(0x10000000, float:2.5243549E-29)
            r29 = r0 & r29
            if (r29 == 0) goto L_0x01a6
            java.lang.Integer r29 = java.lang.Integer.valueOf(r3)
            goto L_0x01a8
        L_0x01a6:
            r29 = r98
        L_0x01a8:
            r30 = 536870912(0x20000000, float:1.0842022E-19)
            r30 = r0 & r30
            if (r30 == 0) goto L_0x01b3
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x01b5
        L_0x01b3:
            r3 = r99
        L_0x01b5:
            r30 = 1073741824(0x40000000, float:2.0)
            r30 = r0 & r30
            if (r30 == 0) goto L_0x01be
            r30 = r70
            goto L_0x01c0
        L_0x01be:
            r30 = r100
        L_0x01c0:
            r31 = -2147483648(0xffffffff80000000, float:-0.0)
            r0 = r0 & r31
            if (r0 == 0) goto L_0x01c9
            r0 = r70
            goto L_0x01cb
        L_0x01c9:
            r0 = r101
        L_0x01cb:
            r70 = r69
            r71 = r1
            r72 = r2
            r73 = r4
            r74 = r5
            r75 = r6
            r76 = r8
            r77 = r9
            r78 = r10
            r79 = r11
            r80 = r12
            r81 = r13
            r82 = r14
            r83 = r15
            r84 = r103
            r85 = r7
            r86 = r16
            r87 = r17
            r88 = r18
            r89 = r19
            r90 = r20
            r91 = r21
            r92 = r22
            r93 = r23
            r94 = r24
            r95 = r25
            r96 = r26
            r97 = r27
            r98 = r28
            r99 = r29
            r100 = r3
            r101 = r30
            r102 = r0
            r70.<init>(r71, r72, r73, r74, r75, r76, r77, r78, r79, r80, r81, r82, r83, r84, r85, r86, r87, r88, r89, r90, r91, r92, r93, r94, r95, r96, r97, r98, r99, r100, r101, r102)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.home.main.shop.bean.ShopHomeDataType2Clazz.<init>(java.util.List, java.lang.Integer, java.util.List, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.String, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Boolean, java.lang.Boolean, java.lang.Boolean, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Boolean, java.lang.Integer, java.lang.String, java.lang.Integer, java.lang.String, java.lang.Integer, java.lang.Integer, java.lang.Integer, com.tal.app.thinkacademy.business.home.main.shop.bean.Spec, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final List<AttachedItem> getAttachedItems() {
        return this.attachedItems;
    }

    public final Integer getAttachedShowPrices() {
        return this.attachedShowPrices;
    }

    public final List<String> getBanners() {
        return this.banners;
    }

    public final Integer getClazzCategory() {
        return this.clazzCategory;
    }

    public final String getClazzFeeName() {
        return this.clazzFeeName;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getDetailPic() {
        return this.detailPic;
    }

    public final Integer getGoodsCategoryId() {
        return this.goodsCategoryId;
    }

    public final String getGoodsFeeName() {
        return this.goodsFeeName;
    }

    public final Integer getId() {
        return this.id;
    }

    public final Integer getMakePriceIsInclude() {
        return this.makePriceIsInclude;
    }

    public final Integer getNeedPostAdd() {
        return this.needPostAdd;
    }

    public final Boolean getOnSell() {
        return this.onSell;
    }

    public final Boolean getOnShow() {
        return this.onShow;
    }

    public final Boolean getOnline() {
        return this.online;
    }

    public final Integer getOrgPrice() {
        return this.orgPrice;
    }

    public final Integer getOrigin() {
        return this.origin;
    }

    public final Integer getPackagePrice() {
        return this.packagePrice;
    }

    public final Boolean getPurchased() {
        return this.purchased;
    }

    public final Integer getRemainSellTime() {
        return this.remainSellTime;
    }

    public final String getSellEndTime() {
        return this.sellEndTime;
    }

    public final Integer getSellPrice() {
        return this.sellPrice;
    }

    public final String getSellStartTime() {
        return this.sellStartTime;
    }

    public final Integer getSellStore() {
        return this.sellStore;
    }

    public final Integer getShowPrice() {
        return this.showPrice;
    }

    public final Integer getShowPriceIsInclude() {
        return this.showPriceIsInclude;
    }

    public final Spec getSpec() {
        return this.spec;
    }

    public final Integer getSpuId() {
        return this.spuId;
    }

    public final Integer getStandardPrice() {
        return this.standardPrice;
    }

    public final Integer getStore() {
        return this.store;
    }

    public final String getSubTitle() {
        return this.subTitle;
    }

    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ShopHomeDataType2Clazz(List<AttachedItem> list, Integer num, List<String> list2, Integer num2, String str, String str2, String str3, Integer num3, String str4, Integer num4, Integer num5, Integer num6, Boolean bool, Boolean bool2, Boolean bool3, Integer num7, Integer num8, Integer num9, Boolean bool4, Integer num10, String str5, Integer num11, String str6, Integer num12, Integer num13, Integer num14, Spec spec2, Integer num15, Integer num16, Integer num17, String str7, String str8) {
        super((List) null, 1, (DefaultConstructorMarker) null);
        this.attachedItems = list;
        this.attachedShowPrices = num;
        this.banners = list2;
        this.clazzCategory = num2;
        this.clazzFeeName = str;
        this.description = str2;
        this.detailPic = str3;
        this.goodsCategoryId = num3;
        this.goodsFeeName = str4;
        this.id = num4;
        this.makePriceIsInclude = num5;
        this.needPostAdd = num6;
        this.onSell = bool;
        this.onShow = bool2;
        this.online = bool3;
        this.orgPrice = num7;
        this.origin = num8;
        this.packagePrice = num9;
        this.purchased = bool4;
        this.remainSellTime = num10;
        this.sellEndTime = str5;
        this.sellPrice = num11;
        this.sellStartTime = str6;
        this.sellStore = num12;
        this.showPrice = num13;
        this.showPriceIsInclude = num14;
        this.spec = spec2;
        this.spuId = num15;
        this.standardPrice = num16;
        this.store = num17;
        this.subTitle = str7;
        this.title = str8;
    }
}
