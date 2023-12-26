package com.tal.app.thinkacademy.business.shop.bean;

import com.kwai.koom.javaoom.monitor.tracker.model.SystemInfo$JavaHeap$;
import java.util.List;
import kotlin.Metadata;
import kotlin.io.ConstantsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\br\b\b\u0018\u00002\u00020\u0001B\u0004\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\f\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0015\u001a\u00020\f\u0012\b\b\u0002\u0010\u0016\u001a\u00020\f\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0019\u001a\u00020\f\u0012\b\b\u0002\u0010\u001a\u001a\u00020\f\u0012\b\b\u0002\u0010\u001b\u001a\u00020\f\u0012\b\b\u0002\u0010\u001c\u001a\u00020\f\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0006\u0012\b\b\u0002\u0010 \u001a\u00020\u0006\u0012\b\b\u0002\u0010!\u001a\u00020\f\u0012\b\b\u0002\u0010\"\u001a\u00020#\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010%\u001a\u00020\u0006\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010'\u001a\u00020\u0006\u0012\b\b\u0002\u0010(\u001a\u00020\u0006\u0012\b\b\u0002\u0010)\u001a\u00020\u0006\u0012\b\b\u0002\u0010*\u001a\u00020\u0006\u0012\b\b\u0002\u0010+\u001a\u00020\u0006\u0012\b\b\u0002\u0010,\u001a\u00020\u0006\u0012\b\b\u0002\u0010-\u001a\u00020\u0006\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/\u0012\b\b\u0002\u00100\u001a\u00020\u0006\u0012\b\b\u0002\u00101\u001a\u00020\u0006\u0012\b\b\u0002\u00102\u001a\u00020\u0006\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u00105\u001a\u00020\u0006\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u000107\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u000109\u0012\u0010\b\u0002\u0010:\u001a\n\u0012\u0004\u0012\u00020<\u0018\u00010;¢\u0006\u0002\u0010=J\u0011\u0010z\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010{\u001a\u00020\fHÆ\u0003J\t\u0010|\u001a\u00020\u0006HÆ\u0003J\u000b\u0010}\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010~\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001a\u00020\fHÆ\u0003J\n\u0010\u0001\u001a\u00020\fHÆ\u0003J\n\u0010\u0001\u001a\u00020\u0006HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0006HÆ\u0003J\n\u0010\u0001\u001a\u00020\fHÆ\u0003J\n\u0010\u0001\u001a\u00020\fHÆ\u0003J\n\u0010\u0001\u001a\u00020\u0006HÆ\u0003J\n\u0010\u0001\u001a\u00020\fHÆ\u0003J\n\u0010\u0001\u001a\u00020\fHÆ\u0003J\f\u0010\u0001\u001a\u0004\u0018\u00010\bHÆ\u0003J\n\u0010\u0001\u001a\u00020\u0006HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0006HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0006HÆ\u0003J\n\u0010\u0001\u001a\u00020\fHÆ\u0003J\n\u0010\u0001\u001a\u00020#HÆ\u0003J\f\u0010\u0001\u001a\u0004\u0018\u00010\bHÆ\u0003J\n\u0010\u0001\u001a\u00020\u0006HÆ\u0003J\u0012\u0010\u0001\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0001\u001a\u0004\u0018\u00010\bHÆ\u0003J\n\u0010\u0001\u001a\u00020\u0006HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0006HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0006HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0006HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0006HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0006HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0006HÆ\u0003J\f\u0010\u0001\u001a\u0004\u0018\u00010/HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0006HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0006HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0006HÆ\u0003J\n\u0010\u0001\u001a\u00020\u0006HÆ\u0003J\f\u0010\u0001\u001a\u0004\u0018\u00010\bHÆ\u0003J\f\u0010\u0001\u001a\u0004\u0018\u00010\bHÆ\u0003J\n\u0010 \u0001\u001a\u00020\u0006HÆ\u0003J\f\u0010¡\u0001\u001a\u0004\u0018\u000107HÆ\u0003J\f\u0010¢\u0001\u001a\u0004\u0018\u000109HÆ\u0003J\u0012\u0010£\u0001\u001a\n\u0012\u0004\u0012\u00020<\u0018\u00010;HÆ\u0003J\f\u0010¤\u0001\u001a\u0004\u0018\u00010\bHÆ\u0003J\n\u0010¥\u0001\u001a\u00020\fHÆ\u0003J\f\u0010¦\u0001\u001a\u0004\u0018\u00010\bHÆ\u0003J\f\u0010§\u0001\u001a\u0004\u0018\u00010\bHÆ\u0003J\f\u0010¨\u0001\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u0004\u0010©\u0001\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\f2\b\b\u0002\u0010\u0012\u001a\u00020\u00062\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0014\u001a\u00020\u00062\b\b\u0002\u0010\u0015\u001a\u00020\f2\b\b\u0002\u0010\u0016\u001a\u00020\f2\b\b\u0002\u0010\u0017\u001a\u00020\u00062\b\b\u0002\u0010\u0018\u001a\u00020\u00062\b\b\u0002\u0010\u0019\u001a\u00020\f2\b\b\u0002\u0010\u001a\u001a\u00020\f2\b\b\u0002\u0010\u001b\u001a\u00020\f2\b\b\u0002\u0010\u001c\u001a\u00020\f2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u001e\u001a\u00020\u00062\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010 \u001a\u00020\u00062\b\b\u0002\u0010!\u001a\u00020\f2\b\b\u0002\u0010\"\u001a\u00020#2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010%\u001a\u00020\u00062\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010'\u001a\u00020\u00062\b\b\u0002\u0010(\u001a\u00020\u00062\b\b\u0002\u0010)\u001a\u00020\u00062\b\b\u0002\u0010*\u001a\u00020\u00062\b\b\u0002\u0010+\u001a\u00020\u00062\b\b\u0002\u0010,\u001a\u00020\u00062\b\b\u0002\u0010-\u001a\u00020\u00062\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/2\b\b\u0002\u00100\u001a\u00020\u00062\b\b\u0002\u00101\u001a\u00020\u00062\b\b\u0002\u00102\u001a\u00020\u00062\n\b\u0002\u00103\u001a\u0004\u0018\u00010\b2\n\b\u0002\u00104\u001a\u0004\u0018\u00010\b2\b\b\u0002\u00105\u001a\u00020\u00062\n\b\u0002\u00106\u001a\u0004\u0018\u0001072\n\b\u0002\u00108\u001a\u0004\u0018\u0001092\u0010\b\u0002\u0010:\u001a\n\u0012\u0004\u0012\u00020<\u0018\u00010;HÆ\u0001J\u0015\u0010ª\u0001\u001a\u00020\f2\t\u0010«\u0001\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\n\u0010¬\u0001\u001a\u00020\u0006HÖ\u0001J\n\u0010­\u0001\u001a\u00020\bHÖ\u0001R\u0013\u00106\u001a\u0004\u0018\u000107¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b@\u0010AR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\bB\u0010CR\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bD\u0010AR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\bE\u0010CR\u0013\u0010\n\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\bF\u0010GR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\bH\u0010IR\u0013\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010GR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\bK\u0010GR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\bL\u0010MR\u0011\u0010\u0011\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\bN\u0010IR\u0011\u0010\u0012\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\bO\u0010CR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\bP\u0010GR\u0011\u0010\u0014\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010CR\u0011\u0010\u0015\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\bR\u0010IR\u0011\u0010\u0016\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\bS\u0010IR\u001c\u00108\u001a\u0004\u0018\u000109X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR\"\u0010:\u001a\n\u0012\u0004\u0012\u00020<\u0018\u00010;X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010A\"\u0004\bY\u0010ZR\u0011\u0010\u0017\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b[\u0010CR\u0011\u0010\u0018\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010CR\u0011\u0010\u0019\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b]\u0010IR\u0011\u0010\u001a\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b^\u0010IR\u0011\u0010\u001b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b_\u0010IR\u0011\u0010\u001c\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b`\u0010IR\u0013\u0010\u001d\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\ba\u0010GR\u0011\u0010\u001e\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\bb\u0010CR\u0011\u0010\u001f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\bc\u0010CR\u0011\u0010 \u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\bd\u0010CR\u0011\u0010(\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\be\u0010CR\u0011\u0010)\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\bf\u0010CR\u0011\u0010!\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\bg\u0010IR\u0011\u0010\"\u001a\u00020#¢\u0006\b\n\u0000\u001a\u0004\bh\u0010iR\u0013\u0010$\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\bj\u0010GR\u0011\u0010%\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\bk\u0010CR\u0013\u0010&\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\bl\u0010GR\u0011\u0010'\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\bm\u0010CR\u0011\u0010*\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\bn\u0010CR\u0011\u0010+\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\bo\u0010CR\u0011\u0010,\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\bp\u0010CR\u0011\u0010-\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\bq\u0010CR\u0013\u0010.\u001a\u0004\u0018\u00010/¢\u0006\b\n\u0000\u001a\u0004\br\u0010sR\u0011\u00100\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\bt\u0010CR\u0011\u00101\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\bu\u0010CR\u0011\u00102\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\bv\u0010CR\u0013\u00103\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\bw\u0010GR\u0011\u00105\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\bx\u0010CR\u0013\u00104\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\by\u0010G¨\u0006®\u0001"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassDetailInfoBean;", "", "attachedItems", "", "Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassDetailAttachedItem;", "attachedShowPrices", "", "banners", "", "clazzCategory", "clazzFeeName", "configStage", "", "description", "detailPic", "examEntrance", "Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassDetailExamEntrance;", "existStage", "goodsCategoryId", "goodsFeeName", "id", "inCart", "inWish", "makePriceIsInclude", "needPostAdd", "onSell", "onShow", "oneOffPayment", "online", "operation", "orgPrice", "origin", "packagePrice", "purchased", "remainSellTime", "", "sellEndTime", "sellPrice", "sellStartTime", "sellStore", "perOrgPrice", "perShowPrice", "showPrice", "showPriceIsInclude", "singleOrgPrice", "singleSellPrice", "spec", "Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassDetailSpec;", "spuId", "standardPrice", "store", "subTitle", "title", "subscriptionsStatus", "activityInfo", "Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassDetailActivityInfo;", "local_class_detail_operation", "Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassDetailOperation;", "local_class_detail_position", "", "Lcom/tal/app/thinkacademy/business/shop/bean/ShopDetailPositionLocationInfo;", "(Ljava/util/List;ILjava/util/List;ILjava/lang/String;ZLjava/lang/String;Ljava/lang/String;Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassDetailExamEntrance;ZILjava/lang/String;IZZIIZZZZLjava/lang/String;IIIZJLjava/lang/String;ILjava/lang/String;IIIIIIILcom/tal/app/thinkacademy/business/shop/bean/ShopClassDetailSpec;IIILjava/lang/String;Ljava/lang/String;ILcom/tal/app/thinkacademy/business/shop/bean/ShopClassDetailActivityInfo;Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassDetailOperation;Ljava/util/List;)V", "getActivityInfo", "()Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassDetailActivityInfo;", "getAttachedItems", "()Ljava/util/List;", "getAttachedShowPrices", "()I", "getBanners", "getClazzCategory", "getClazzFeeName", "()Ljava/lang/String;", "getConfigStage", "()Z", "getDescription", "getDetailPic", "getExamEntrance", "()Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassDetailExamEntrance;", "getExistStage", "getGoodsCategoryId", "getGoodsFeeName", "getId", "getInCart", "getInWish", "getLocal_class_detail_operation", "()Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassDetailOperation;", "setLocal_class_detail_operation", "(Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassDetailOperation;)V", "getLocal_class_detail_position", "setLocal_class_detail_position", "(Ljava/util/List;)V", "getMakePriceIsInclude", "getNeedPostAdd", "getOnSell", "getOnShow", "getOneOffPayment", "getOnline", "getOperation", "getOrgPrice", "getOrigin", "getPackagePrice", "getPerOrgPrice", "getPerShowPrice", "getPurchased", "getRemainSellTime", "()J", "getSellEndTime", "getSellPrice", "getSellStartTime", "getSellStore", "getShowPrice", "getShowPriceIsInclude", "getSingleOrgPrice", "getSingleSellPrice", "getSpec", "()Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassDetailSpec;", "getSpuId", "getStandardPrice", "getStore", "getSubTitle", "getSubscriptionsStatus", "getTitle", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component4", "component40", "component41", "component42", "component43", "component44", "component45", "component46", "component47", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShopClassDetailInfoBean.kt */
public final class ShopClassDetailInfoBean {
    private final ShopClassDetailActivityInfo activityInfo;
    private final List<ShopClassDetailAttachedItem> attachedItems;
    private final int attachedShowPrices;
    private final List<String> banners;
    private final int clazzCategory;
    private final String clazzFeeName;
    private final boolean configStage;
    private final String description;
    private final String detailPic;
    private final ShopClassDetailExamEntrance examEntrance;
    private final boolean existStage;
    private final int goodsCategoryId;
    private final String goodsFeeName;
    private final int id;
    private final boolean inCart;
    private final boolean inWish;
    private ShopClassDetailOperation local_class_detail_operation;
    private List<ShopDetailPositionLocationInfo> local_class_detail_position;
    private final int makePriceIsInclude;
    private final int needPostAdd;
    private final boolean onSell;
    private final boolean onShow;
    private final boolean oneOffPayment;
    private final boolean online;
    private final String operation;
    private final int orgPrice;
    private final int origin;
    private final int packagePrice;
    private final int perOrgPrice;
    private final int perShowPrice;
    private final boolean purchased;
    private final long remainSellTime;
    private final String sellEndTime;
    private final int sellPrice;
    private final String sellStartTime;
    private final int sellStore;
    private final int showPrice;
    private final int showPriceIsInclude;
    private final int singleOrgPrice;
    private final int singleSellPrice;
    private final ShopClassDetailSpec spec;
    private final int spuId;
    private final int standardPrice;
    private final int store;
    private final String subTitle;
    private final int subscriptionsStatus;
    private final String title;

    public ShopClassDetailInfoBean() {
        this((List) null, 0, (List) null, 0, (String) null, false, (String) null, (String) null, (ShopClassDetailExamEntrance) null, false, 0, (String) null, 0, false, false, 0, 0, false, false, false, false, (String) null, 0, 0, 0, false, 0, (String) null, 0, (String) null, 0, 0, 0, 0, 0, 0, 0, (ShopClassDetailSpec) null, 0, 0, 0, (String) null, (String) null, 0, (ShopClassDetailActivityInfo) null, (ShopClassDetailOperation) null, (List) null, -1, 32767, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ShopClassDetailInfoBean copy$default(ShopClassDetailInfoBean shopClassDetailInfoBean, List list, int i, List list2, int i2, String str, boolean z, String str2, String str3, ShopClassDetailExamEntrance shopClassDetailExamEntrance, boolean z2, int i3, String str4, int i4, boolean z3, boolean z4, int i5, int i6, boolean z5, boolean z6, boolean z7, boolean z8, String str5, int i7, int i8, int i9, boolean z9, long j, String str6, int i10, String str7, int i11, int i12, int i13, int i14, int i15, int i16, int i17, ShopClassDetailSpec shopClassDetailSpec, int i18, int i19, int i20, String str8, String str9, int i21, ShopClassDetailActivityInfo shopClassDetailActivityInfo, ShopClassDetailOperation shopClassDetailOperation, List list3, int i22, int i23, Object obj) {
        ShopClassDetailInfoBean shopClassDetailInfoBean2 = shopClassDetailInfoBean;
        int i24 = i22;
        int i25 = i23;
        return shopClassDetailInfoBean.copy((i24 & 1) != 0 ? shopClassDetailInfoBean2.attachedItems : list, (i24 & 2) != 0 ? shopClassDetailInfoBean2.attachedShowPrices : i, (i24 & 4) != 0 ? shopClassDetailInfoBean2.banners : list2, (i24 & 8) != 0 ? shopClassDetailInfoBean2.clazzCategory : i2, (i24 & 16) != 0 ? shopClassDetailInfoBean2.clazzFeeName : str, (i24 & 32) != 0 ? shopClassDetailInfoBean2.configStage : z, (i24 & 64) != 0 ? shopClassDetailInfoBean2.description : str2, (i24 & 128) != 0 ? shopClassDetailInfoBean2.detailPic : str3, (i24 & 256) != 0 ? shopClassDetailInfoBean2.examEntrance : shopClassDetailExamEntrance, (i24 & ConstantsKt.MINIMUM_BLOCK_SIZE) != 0 ? shopClassDetailInfoBean2.existStage : z2, (i24 & 1024) != 0 ? shopClassDetailInfoBean2.goodsCategoryId : i3, (i24 & 2048) != 0 ? shopClassDetailInfoBean2.goodsFeeName : str4, (i24 & ConstantsKt.DEFAULT_BLOCK_SIZE) != 0 ? shopClassDetailInfoBean2.id : i4, (i24 & ConstantsKt.DEFAULT_BUFFER_SIZE) != 0 ? shopClassDetailInfoBean2.inCart : z3, (i24 & 16384) != 0 ? shopClassDetailInfoBean2.inWish : z4, (i24 & 32768) != 0 ? shopClassDetailInfoBean2.makePriceIsInclude : i5, (i24 & 65536) != 0 ? shopClassDetailInfoBean2.needPostAdd : i6, (i24 & 131072) != 0 ? shopClassDetailInfoBean2.onSell : z5, (i24 & 262144) != 0 ? shopClassDetailInfoBean2.onShow : z6, (i24 & 524288) != 0 ? shopClassDetailInfoBean2.oneOffPayment : z7, (i24 & 1048576) != 0 ? shopClassDetailInfoBean2.online : z8, (i24 & 2097152) != 0 ? shopClassDetailInfoBean2.operation : str5, (i24 & 4194304) != 0 ? shopClassDetailInfoBean2.orgPrice : i7, (i24 & 8388608) != 0 ? shopClassDetailInfoBean2.origin : i8, (i24 & 16777216) != 0 ? shopClassDetailInfoBean2.packagePrice : i9, (i24 & 33554432) != 0 ? shopClassDetailInfoBean2.purchased : z9, (i24 & 67108864) != 0 ? shopClassDetailInfoBean2.remainSellTime : j, (i24 & 134217728) != 0 ? shopClassDetailInfoBean2.sellEndTime : str6, (268435456 & i24) != 0 ? shopClassDetailInfoBean2.sellPrice : i10, (i24 & 536870912) != 0 ? shopClassDetailInfoBean2.sellStartTime : str7, (i24 & 1073741824) != 0 ? shopClassDetailInfoBean2.sellStore : i11, (i24 & IntCompanionObject.MIN_VALUE) != 0 ? shopClassDetailInfoBean2.perOrgPrice : i12, (i25 & 1) != 0 ? shopClassDetailInfoBean2.perShowPrice : i13, (i25 & 2) != 0 ? shopClassDetailInfoBean2.showPrice : i14, (i25 & 4) != 0 ? shopClassDetailInfoBean2.showPriceIsInclude : i15, (i25 & 8) != 0 ? shopClassDetailInfoBean2.singleOrgPrice : i16, (i25 & 16) != 0 ? shopClassDetailInfoBean2.singleSellPrice : i17, (i25 & 32) != 0 ? shopClassDetailInfoBean2.spec : shopClassDetailSpec, (i25 & 64) != 0 ? shopClassDetailInfoBean2.spuId : i18, (i25 & 128) != 0 ? shopClassDetailInfoBean2.standardPrice : i19, (i25 & 256) != 0 ? shopClassDetailInfoBean2.store : i20, (i25 & ConstantsKt.MINIMUM_BLOCK_SIZE) != 0 ? shopClassDetailInfoBean2.subTitle : str8, (i25 & 1024) != 0 ? shopClassDetailInfoBean2.title : str9, (i25 & 2048) != 0 ? shopClassDetailInfoBean2.subscriptionsStatus : i21, (i25 & ConstantsKt.DEFAULT_BLOCK_SIZE) != 0 ? shopClassDetailInfoBean2.activityInfo : shopClassDetailActivityInfo, (i25 & ConstantsKt.DEFAULT_BUFFER_SIZE) != 0 ? shopClassDetailInfoBean2.local_class_detail_operation : shopClassDetailOperation, (i25 & 16384) != 0 ? shopClassDetailInfoBean2.local_class_detail_position : list3);
    }

    public final List<ShopClassDetailAttachedItem> component1() {
        return this.attachedItems;
    }

    public final boolean component10() {
        return this.existStage;
    }

    public final int component11() {
        return this.goodsCategoryId;
    }

    public final String component12() {
        return this.goodsFeeName;
    }

    public final int component13() {
        return this.id;
    }

    public final boolean component14() {
        return this.inCart;
    }

    public final boolean component15() {
        return this.inWish;
    }

    public final int component16() {
        return this.makePriceIsInclude;
    }

    public final int component17() {
        return this.needPostAdd;
    }

    public final boolean component18() {
        return this.onSell;
    }

    public final boolean component19() {
        return this.onShow;
    }

    public final int component2() {
        return this.attachedShowPrices;
    }

    public final boolean component20() {
        return this.oneOffPayment;
    }

    public final boolean component21() {
        return this.online;
    }

    public final String component22() {
        return this.operation;
    }

    public final int component23() {
        return this.orgPrice;
    }

    public final int component24() {
        return this.origin;
    }

    public final int component25() {
        return this.packagePrice;
    }

    public final boolean component26() {
        return this.purchased;
    }

    public final long component27() {
        return this.remainSellTime;
    }

    public final String component28() {
        return this.sellEndTime;
    }

    public final int component29() {
        return this.sellPrice;
    }

    public final List<String> component3() {
        return this.banners;
    }

    public final String component30() {
        return this.sellStartTime;
    }

    public final int component31() {
        return this.sellStore;
    }

    public final int component32() {
        return this.perOrgPrice;
    }

    public final int component33() {
        return this.perShowPrice;
    }

    public final int component34() {
        return this.showPrice;
    }

    public final int component35() {
        return this.showPriceIsInclude;
    }

    public final int component36() {
        return this.singleOrgPrice;
    }

    public final int component37() {
        return this.singleSellPrice;
    }

    public final ShopClassDetailSpec component38() {
        return this.spec;
    }

    public final int component39() {
        return this.spuId;
    }

    public final int component4() {
        return this.clazzCategory;
    }

    public final int component40() {
        return this.standardPrice;
    }

    public final int component41() {
        return this.store;
    }

    public final String component42() {
        return this.subTitle;
    }

    public final String component43() {
        return this.title;
    }

    public final int component44() {
        return this.subscriptionsStatus;
    }

    public final ShopClassDetailActivityInfo component45() {
        return this.activityInfo;
    }

    public final ShopClassDetailOperation component46() {
        return this.local_class_detail_operation;
    }

    public final List<ShopDetailPositionLocationInfo> component47() {
        return this.local_class_detail_position;
    }

    public final String component5() {
        return this.clazzFeeName;
    }

    public final boolean component6() {
        return this.configStage;
    }

    public final String component7() {
        return this.description;
    }

    public final String component8() {
        return this.detailPic;
    }

    public final ShopClassDetailExamEntrance component9() {
        return this.examEntrance;
    }

    public final ShopClassDetailInfoBean copy(List<ShopClassDetailAttachedItem> list, int i, List<String> list2, int i2, String str, boolean z, String str2, String str3, ShopClassDetailExamEntrance shopClassDetailExamEntrance, boolean z2, int i3, String str4, int i4, boolean z3, boolean z4, int i5, int i6, boolean z5, boolean z6, boolean z7, boolean z8, String str5, int i7, int i8, int i9, boolean z9, long j, String str6, int i10, String str7, int i11, int i12, int i13, int i14, int i15, int i16, int i17, ShopClassDetailSpec shopClassDetailSpec, int i18, int i19, int i20, String str8, String str9, int i21, ShopClassDetailActivityInfo shopClassDetailActivityInfo, ShopClassDetailOperation shopClassDetailOperation, List<ShopDetailPositionLocationInfo> list3) {
        return new ShopClassDetailInfoBean(list, i, list2, i2, str, z, str2, str3, shopClassDetailExamEntrance, z2, i3, str4, i4, z3, z4, i5, i6, z5, z6, z7, z8, str5, i7, i8, i9, z9, j, str6, i10, str7, i11, i12, i13, i14, i15, i16, i17, shopClassDetailSpec, i18, i19, i20, str8, str9, i21, shopClassDetailActivityInfo, shopClassDetailOperation, list3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShopClassDetailInfoBean)) {
            return false;
        }
        ShopClassDetailInfoBean shopClassDetailInfoBean = (ShopClassDetailInfoBean) obj;
        return Intrinsics.areEqual((Object) this.attachedItems, (Object) shopClassDetailInfoBean.attachedItems) && this.attachedShowPrices == shopClassDetailInfoBean.attachedShowPrices && Intrinsics.areEqual((Object) this.banners, (Object) shopClassDetailInfoBean.banners) && this.clazzCategory == shopClassDetailInfoBean.clazzCategory && Intrinsics.areEqual((Object) this.clazzFeeName, (Object) shopClassDetailInfoBean.clazzFeeName) && this.configStage == shopClassDetailInfoBean.configStage && Intrinsics.areEqual((Object) this.description, (Object) shopClassDetailInfoBean.description) && Intrinsics.areEqual((Object) this.detailPic, (Object) shopClassDetailInfoBean.detailPic) && Intrinsics.areEqual((Object) this.examEntrance, (Object) shopClassDetailInfoBean.examEntrance) && this.existStage == shopClassDetailInfoBean.existStage && this.goodsCategoryId == shopClassDetailInfoBean.goodsCategoryId && Intrinsics.areEqual((Object) this.goodsFeeName, (Object) shopClassDetailInfoBean.goodsFeeName) && this.id == shopClassDetailInfoBean.id && this.inCart == shopClassDetailInfoBean.inCart && this.inWish == shopClassDetailInfoBean.inWish && this.makePriceIsInclude == shopClassDetailInfoBean.makePriceIsInclude && this.needPostAdd == shopClassDetailInfoBean.needPostAdd && this.onSell == shopClassDetailInfoBean.onSell && this.onShow == shopClassDetailInfoBean.onShow && this.oneOffPayment == shopClassDetailInfoBean.oneOffPayment && this.online == shopClassDetailInfoBean.online && Intrinsics.areEqual((Object) this.operation, (Object) shopClassDetailInfoBean.operation) && this.orgPrice == shopClassDetailInfoBean.orgPrice && this.origin == shopClassDetailInfoBean.origin && this.packagePrice == shopClassDetailInfoBean.packagePrice && this.purchased == shopClassDetailInfoBean.purchased && this.remainSellTime == shopClassDetailInfoBean.remainSellTime && Intrinsics.areEqual((Object) this.sellEndTime, (Object) shopClassDetailInfoBean.sellEndTime) && this.sellPrice == shopClassDetailInfoBean.sellPrice && Intrinsics.areEqual((Object) this.sellStartTime, (Object) shopClassDetailInfoBean.sellStartTime) && this.sellStore == shopClassDetailInfoBean.sellStore && this.perOrgPrice == shopClassDetailInfoBean.perOrgPrice && this.perShowPrice == shopClassDetailInfoBean.perShowPrice && this.showPrice == shopClassDetailInfoBean.showPrice && this.showPriceIsInclude == shopClassDetailInfoBean.showPriceIsInclude && this.singleOrgPrice == shopClassDetailInfoBean.singleOrgPrice && this.singleSellPrice == shopClassDetailInfoBean.singleSellPrice && Intrinsics.areEqual((Object) this.spec, (Object) shopClassDetailInfoBean.spec) && this.spuId == shopClassDetailInfoBean.spuId && this.standardPrice == shopClassDetailInfoBean.standardPrice && this.store == shopClassDetailInfoBean.store && Intrinsics.areEqual((Object) this.subTitle, (Object) shopClassDetailInfoBean.subTitle) && Intrinsics.areEqual((Object) this.title, (Object) shopClassDetailInfoBean.title) && this.subscriptionsStatus == shopClassDetailInfoBean.subscriptionsStatus && Intrinsics.areEqual((Object) this.activityInfo, (Object) shopClassDetailInfoBean.activityInfo) && Intrinsics.areEqual((Object) this.local_class_detail_operation, (Object) shopClassDetailInfoBean.local_class_detail_operation) && Intrinsics.areEqual((Object) this.local_class_detail_position, (Object) shopClassDetailInfoBean.local_class_detail_position);
    }

    public int hashCode() {
        List<ShopClassDetailAttachedItem> list = this.attachedItems;
        int i = 0;
        int hashCode = (((list == null ? 0 : list.hashCode()) * 31) + this.attachedShowPrices) * 31;
        List<String> list2 = this.banners;
        int hashCode2 = (((hashCode + (list2 == null ? 0 : list2.hashCode())) * 31) + this.clazzCategory) * 31;
        String str = this.clazzFeeName;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        boolean z = this.configStage;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i2 = (hashCode3 + (z ? 1 : 0)) * 31;
        String str2 = this.description;
        int hashCode4 = (i2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.detailPic;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        ShopClassDetailExamEntrance shopClassDetailExamEntrance = this.examEntrance;
        int hashCode6 = (hashCode5 + (shopClassDetailExamEntrance == null ? 0 : shopClassDetailExamEntrance.hashCode())) * 31;
        boolean z3 = this.existStage;
        if (z3) {
            z3 = true;
        }
        int i3 = (((hashCode6 + (z3 ? 1 : 0)) * 31) + this.goodsCategoryId) * 31;
        String str4 = this.goodsFeeName;
        int hashCode7 = (((i3 + (str4 == null ? 0 : str4.hashCode())) * 31) + this.id) * 31;
        boolean z4 = this.inCart;
        if (z4) {
            z4 = true;
        }
        int i4 = (hashCode7 + (z4 ? 1 : 0)) * 31;
        boolean z5 = this.inWish;
        if (z5) {
            z5 = true;
        }
        int i5 = (((((i4 + (z5 ? 1 : 0)) * 31) + this.makePriceIsInclude) * 31) + this.needPostAdd) * 31;
        boolean z6 = this.onSell;
        if (z6) {
            z6 = true;
        }
        int i6 = (i5 + (z6 ? 1 : 0)) * 31;
        boolean z7 = this.onShow;
        if (z7) {
            z7 = true;
        }
        int i7 = (i6 + (z7 ? 1 : 0)) * 31;
        boolean z8 = this.oneOffPayment;
        if (z8) {
            z8 = true;
        }
        int i8 = (i7 + (z8 ? 1 : 0)) * 31;
        boolean z9 = this.online;
        if (z9) {
            z9 = true;
        }
        int i9 = (i8 + (z9 ? 1 : 0)) * 31;
        String str5 = this.operation;
        int hashCode8 = (((((((i9 + (str5 == null ? 0 : str5.hashCode())) * 31) + this.orgPrice) * 31) + this.origin) * 31) + this.packagePrice) * 31;
        boolean z10 = this.purchased;
        if (!z10) {
            z2 = z10;
        }
        int m = (((hashCode8 + (z2 ? 1 : 0)) * 31) + SystemInfo$JavaHeap$.ExternalSyntheticBackport0.m(this.remainSellTime)) * 31;
        String str6 = this.sellEndTime;
        int hashCode9 = (((m + (str6 == null ? 0 : str6.hashCode())) * 31) + this.sellPrice) * 31;
        String str7 = this.sellStartTime;
        int hashCode10 = (((((((((((((((hashCode9 + (str7 == null ? 0 : str7.hashCode())) * 31) + this.sellStore) * 31) + this.perOrgPrice) * 31) + this.perShowPrice) * 31) + this.showPrice) * 31) + this.showPriceIsInclude) * 31) + this.singleOrgPrice) * 31) + this.singleSellPrice) * 31;
        ShopClassDetailSpec shopClassDetailSpec = this.spec;
        int hashCode11 = (((((((hashCode10 + (shopClassDetailSpec == null ? 0 : shopClassDetailSpec.hashCode())) * 31) + this.spuId) * 31) + this.standardPrice) * 31) + this.store) * 31;
        String str8 = this.subTitle;
        int hashCode12 = (hashCode11 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.title;
        int hashCode13 = (((hashCode12 + (str9 == null ? 0 : str9.hashCode())) * 31) + this.subscriptionsStatus) * 31;
        ShopClassDetailActivityInfo shopClassDetailActivityInfo = this.activityInfo;
        int hashCode14 = (hashCode13 + (shopClassDetailActivityInfo == null ? 0 : shopClassDetailActivityInfo.hashCode())) * 31;
        ShopClassDetailOperation shopClassDetailOperation = this.local_class_detail_operation;
        int hashCode15 = (hashCode14 + (shopClassDetailOperation == null ? 0 : shopClassDetailOperation.hashCode())) * 31;
        List<ShopDetailPositionLocationInfo> list3 = this.local_class_detail_position;
        if (list3 != null) {
            i = list3.hashCode();
        }
        return hashCode15 + i;
    }

    public String toString() {
        return "ShopClassDetailInfoBean(attachedItems=" + this.attachedItems + ", attachedShowPrices=" + this.attachedShowPrices + ", banners=" + this.banners + ", clazzCategory=" + this.clazzCategory + ", clazzFeeName=" + this.clazzFeeName + ", configStage=" + this.configStage + ", description=" + this.description + ", detailPic=" + this.detailPic + ", examEntrance=" + this.examEntrance + ", existStage=" + this.existStage + ", goodsCategoryId=" + this.goodsCategoryId + ", goodsFeeName=" + this.goodsFeeName + ", id=" + this.id + ", inCart=" + this.inCart + ", inWish=" + this.inWish + ", makePriceIsInclude=" + this.makePriceIsInclude + ", needPostAdd=" + this.needPostAdd + ", onSell=" + this.onSell + ", onShow=" + this.onShow + ", oneOffPayment=" + this.oneOffPayment + ", online=" + this.online + ", operation=" + this.operation + ", orgPrice=" + this.orgPrice + ", origin=" + this.origin + ", packagePrice=" + this.packagePrice + ", purchased=" + this.purchased + ", remainSellTime=" + this.remainSellTime + ", sellEndTime=" + this.sellEndTime + ", sellPrice=" + this.sellPrice + ", sellStartTime=" + this.sellStartTime + ", sellStore=" + this.sellStore + ", perOrgPrice=" + this.perOrgPrice + ", perShowPrice=" + this.perShowPrice + ", showPrice=" + this.showPrice + ", showPriceIsInclude=" + this.showPriceIsInclude + ", singleOrgPrice=" + this.singleOrgPrice + ", singleSellPrice=" + this.singleSellPrice + ", spec=" + this.spec + ", spuId=" + this.spuId + ", standardPrice=" + this.standardPrice + ", store=" + this.store + ", subTitle=" + this.subTitle + ", title=" + this.title + ", subscriptionsStatus=" + this.subscriptionsStatus + ", activityInfo=" + this.activityInfo + ", local_class_detail_operation=" + this.local_class_detail_operation + ", local_class_detail_position=" + this.local_class_detail_position + ')';
    }

    public ShopClassDetailInfoBean(List<ShopClassDetailAttachedItem> list, int i, List<String> list2, int i2, String str, boolean z, String str2, String str3, ShopClassDetailExamEntrance shopClassDetailExamEntrance, boolean z2, int i3, String str4, int i4, boolean z3, boolean z4, int i5, int i6, boolean z5, boolean z6, boolean z7, boolean z8, String str5, int i7, int i8, int i9, boolean z9, long j, String str6, int i10, String str7, int i11, int i12, int i13, int i14, int i15, int i16, int i17, ShopClassDetailSpec shopClassDetailSpec, int i18, int i19, int i20, String str8, String str9, int i21, ShopClassDetailActivityInfo shopClassDetailActivityInfo, ShopClassDetailOperation shopClassDetailOperation, List<ShopDetailPositionLocationInfo> list3) {
        this.attachedItems = list;
        this.attachedShowPrices = i;
        this.banners = list2;
        this.clazzCategory = i2;
        this.clazzFeeName = str;
        this.configStage = z;
        this.description = str2;
        this.detailPic = str3;
        this.examEntrance = shopClassDetailExamEntrance;
        this.existStage = z2;
        this.goodsCategoryId = i3;
        this.goodsFeeName = str4;
        this.id = i4;
        this.inCart = z3;
        this.inWish = z4;
        this.makePriceIsInclude = i5;
        this.needPostAdd = i6;
        this.onSell = z5;
        this.onShow = z6;
        this.oneOffPayment = z7;
        this.online = z8;
        this.operation = str5;
        this.orgPrice = i7;
        this.origin = i8;
        this.packagePrice = i9;
        this.purchased = z9;
        this.remainSellTime = j;
        this.sellEndTime = str6;
        this.sellPrice = i10;
        this.sellStartTime = str7;
        this.sellStore = i11;
        this.perOrgPrice = i12;
        this.perShowPrice = i13;
        this.showPrice = i14;
        this.showPriceIsInclude = i15;
        this.singleOrgPrice = i16;
        this.singleSellPrice = i17;
        this.spec = shopClassDetailSpec;
        this.spuId = i18;
        this.standardPrice = i19;
        this.store = i20;
        this.subTitle = str8;
        this.title = str9;
        this.subscriptionsStatus = i21;
        this.activityInfo = shopClassDetailActivityInfo;
        this.local_class_detail_operation = shopClassDetailOperation;
        this.local_class_detail_position = list3;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ShopClassDetailInfoBean(java.util.List r48, int r49, java.util.List r50, int r51, java.lang.String r52, boolean r53, java.lang.String r54, java.lang.String r55, com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailExamEntrance r56, boolean r57, int r58, java.lang.String r59, int r60, boolean r61, boolean r62, int r63, int r64, boolean r65, boolean r66, boolean r67, boolean r68, java.lang.String r69, int r70, int r71, int r72, boolean r73, long r74, java.lang.String r76, int r77, java.lang.String r78, int r79, int r80, int r81, int r82, int r83, int r84, int r85, com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailSpec r86, int r87, int r88, int r89, java.lang.String r90, java.lang.String r91, int r92, com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailActivityInfo r93, com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailOperation r94, java.util.List r95, int r96, int r97, kotlin.jvm.internal.DefaultConstructorMarker r98) {
        /*
            r47 = this;
            r0 = r96
            r1 = r97
            r2 = r0 & 1
            if (r2 == 0) goto L_0x000a
            r2 = 0
            goto L_0x000c
        L_0x000a:
            r2 = r48
        L_0x000c:
            r4 = r0 & 2
            if (r4 == 0) goto L_0x0012
            r4 = 0
            goto L_0x0014
        L_0x0012:
            r4 = r49
        L_0x0014:
            r6 = r0 & 4
            if (r6 == 0) goto L_0x001a
            r6 = 0
            goto L_0x001c
        L_0x001a:
            r6 = r50
        L_0x001c:
            r7 = r0 & 8
            if (r7 == 0) goto L_0x0022
            r7 = 0
            goto L_0x0024
        L_0x0022:
            r7 = r51
        L_0x0024:
            r8 = r0 & 16
            if (r8 == 0) goto L_0x002a
            r8 = 0
            goto L_0x002c
        L_0x002a:
            r8 = r52
        L_0x002c:
            r9 = r0 & 32
            if (r9 == 0) goto L_0x0032
            r9 = 0
            goto L_0x0034
        L_0x0032:
            r9 = r53
        L_0x0034:
            r10 = r0 & 64
            if (r10 == 0) goto L_0x003a
            r10 = 0
            goto L_0x003c
        L_0x003a:
            r10 = r54
        L_0x003c:
            r11 = r0 & 128(0x80, float:1.794E-43)
            if (r11 == 0) goto L_0x0042
            r11 = 0
            goto L_0x0044
        L_0x0042:
            r11 = r55
        L_0x0044:
            r12 = r0 & 256(0x100, float:3.59E-43)
            if (r12 == 0) goto L_0x004a
            r12 = 0
            goto L_0x004c
        L_0x004a:
            r12 = r56
        L_0x004c:
            r13 = r0 & 512(0x200, float:7.175E-43)
            if (r13 == 0) goto L_0x0052
            r13 = 0
            goto L_0x0054
        L_0x0052:
            r13 = r57
        L_0x0054:
            r14 = r0 & 1024(0x400, float:1.435E-42)
            if (r14 == 0) goto L_0x005a
            r14 = 0
            goto L_0x005c
        L_0x005a:
            r14 = r58
        L_0x005c:
            r15 = r0 & 2048(0x800, float:2.87E-42)
            if (r15 == 0) goto L_0x0062
            r15 = 0
            goto L_0x0064
        L_0x0062:
            r15 = r59
        L_0x0064:
            r3 = r0 & 4096(0x1000, float:5.74E-42)
            if (r3 == 0) goto L_0x006a
            r3 = 0
            goto L_0x006c
        L_0x006a:
            r3 = r60
        L_0x006c:
            r5 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r5 == 0) goto L_0x0072
            r5 = 0
            goto L_0x0074
        L_0x0072:
            r5 = r61
        L_0x0074:
            r16 = r5
            r5 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r5 == 0) goto L_0x007c
            r5 = 0
            goto L_0x007e
        L_0x007c:
            r5 = r62
        L_0x007e:
            r17 = 32768(0x8000, float:4.5918E-41)
            r17 = r0 & r17
            if (r17 == 0) goto L_0x0088
            r17 = 0
            goto L_0x008a
        L_0x0088:
            r17 = r63
        L_0x008a:
            r18 = 65536(0x10000, float:9.18355E-41)
            r18 = r0 & r18
            if (r18 == 0) goto L_0x0093
            r18 = 0
            goto L_0x0095
        L_0x0093:
            r18 = r64
        L_0x0095:
            r19 = 131072(0x20000, float:1.83671E-40)
            r19 = r0 & r19
            if (r19 == 0) goto L_0x009e
            r19 = 0
            goto L_0x00a0
        L_0x009e:
            r19 = r65
        L_0x00a0:
            r20 = 262144(0x40000, float:3.67342E-40)
            r20 = r0 & r20
            if (r20 == 0) goto L_0x00a9
            r20 = 0
            goto L_0x00ab
        L_0x00a9:
            r20 = r66
        L_0x00ab:
            r21 = 524288(0x80000, float:7.34684E-40)
            r21 = r0 & r21
            if (r21 == 0) goto L_0x00b4
            r21 = 0
            goto L_0x00b6
        L_0x00b4:
            r21 = r67
        L_0x00b6:
            r22 = 1048576(0x100000, float:1.469368E-39)
            r22 = r0 & r22
            if (r22 == 0) goto L_0x00bf
            r22 = 0
            goto L_0x00c1
        L_0x00bf:
            r22 = r68
        L_0x00c1:
            r23 = 2097152(0x200000, float:2.938736E-39)
            r23 = r0 & r23
            if (r23 == 0) goto L_0x00ca
            r23 = 0
            goto L_0x00cc
        L_0x00ca:
            r23 = r69
        L_0x00cc:
            r24 = 4194304(0x400000, float:5.877472E-39)
            r24 = r0 & r24
            if (r24 == 0) goto L_0x00d5
            r24 = 0
            goto L_0x00d7
        L_0x00d5:
            r24 = r70
        L_0x00d7:
            r25 = 8388608(0x800000, float:1.17549435E-38)
            r25 = r0 & r25
            if (r25 == 0) goto L_0x00e0
            r25 = 0
            goto L_0x00e2
        L_0x00e0:
            r25 = r71
        L_0x00e2:
            r26 = 16777216(0x1000000, float:2.3509887E-38)
            r26 = r0 & r26
            if (r26 == 0) goto L_0x00eb
            r26 = 0
            goto L_0x00ed
        L_0x00eb:
            r26 = r72
        L_0x00ed:
            r27 = 33554432(0x2000000, float:9.403955E-38)
            r27 = r0 & r27
            if (r27 == 0) goto L_0x00f6
            r27 = 0
            goto L_0x00f8
        L_0x00f6:
            r27 = r73
        L_0x00f8:
            r28 = 67108864(0x4000000, float:1.5046328E-36)
            r28 = r0 & r28
            if (r28 == 0) goto L_0x0101
            r28 = 0
            goto L_0x0103
        L_0x0101:
            r28 = r74
        L_0x0103:
            r30 = 134217728(0x8000000, float:3.85186E-34)
            r30 = r0 & r30
            if (r30 == 0) goto L_0x010c
            r30 = 0
            goto L_0x010e
        L_0x010c:
            r30 = r76
        L_0x010e:
            r31 = 268435456(0x10000000, float:2.5243549E-29)
            r31 = r0 & r31
            if (r31 == 0) goto L_0x0117
            r31 = 0
            goto L_0x0119
        L_0x0117:
            r31 = r77
        L_0x0119:
            r32 = 536870912(0x20000000, float:1.0842022E-19)
            r32 = r0 & r32
            if (r32 == 0) goto L_0x0122
            r32 = 0
            goto L_0x0124
        L_0x0122:
            r32 = r78
        L_0x0124:
            r33 = 1073741824(0x40000000, float:2.0)
            r33 = r0 & r33
            if (r33 == 0) goto L_0x012d
            r33 = 0
            goto L_0x012f
        L_0x012d:
            r33 = r79
        L_0x012f:
            r34 = -2147483648(0xffffffff80000000, float:-0.0)
            r0 = r0 & r34
            if (r0 == 0) goto L_0x0137
            r0 = 0
            goto L_0x0139
        L_0x0137:
            r0 = r80
        L_0x0139:
            r34 = r1 & 1
            if (r34 == 0) goto L_0x0140
            r34 = 0
            goto L_0x0142
        L_0x0140:
            r34 = r81
        L_0x0142:
            r35 = r1 & 2
            if (r35 == 0) goto L_0x0149
            r35 = 0
            goto L_0x014b
        L_0x0149:
            r35 = r82
        L_0x014b:
            r36 = r1 & 4
            if (r36 == 0) goto L_0x0152
            r36 = 0
            goto L_0x0154
        L_0x0152:
            r36 = r83
        L_0x0154:
            r37 = r1 & 8
            if (r37 == 0) goto L_0x015b
            r37 = 0
            goto L_0x015d
        L_0x015b:
            r37 = r84
        L_0x015d:
            r38 = r1 & 16
            if (r38 == 0) goto L_0x0164
            r38 = 0
            goto L_0x0166
        L_0x0164:
            r38 = r85
        L_0x0166:
            r39 = r1 & 32
            if (r39 == 0) goto L_0x016d
            r39 = 0
            goto L_0x016f
        L_0x016d:
            r39 = r86
        L_0x016f:
            r40 = r1 & 64
            if (r40 == 0) goto L_0x0176
            r40 = 0
            goto L_0x0178
        L_0x0176:
            r40 = r87
        L_0x0178:
            r96 = r0
            r0 = r1 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0180
            r0 = 0
            goto L_0x0182
        L_0x0180:
            r0 = r88
        L_0x0182:
            r41 = r0
            r0 = r1 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x018a
            r0 = 0
            goto L_0x018c
        L_0x018a:
            r0 = r89
        L_0x018c:
            r42 = r0
            r0 = r1 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x0194
            r0 = 0
            goto L_0x0196
        L_0x0194:
            r0 = r90
        L_0x0196:
            r43 = r0
            r0 = r1 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x019e
            r0 = 0
            goto L_0x01a0
        L_0x019e:
            r0 = r91
        L_0x01a0:
            r44 = r0
            r0 = r1 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x01a8
            r0 = 0
            goto L_0x01aa
        L_0x01a8:
            r0 = r92
        L_0x01aa:
            r45 = r0
            r0 = r1 & 4096(0x1000, float:5.74E-42)
            if (r0 == 0) goto L_0x01b2
            r0 = 0
            goto L_0x01b4
        L_0x01b2:
            r0 = r93
        L_0x01b4:
            r46 = r0
            r0 = r1 & 8192(0x2000, float:1.14794E-41)
            if (r0 == 0) goto L_0x01bc
            r0 = 0
            goto L_0x01be
        L_0x01bc:
            r0 = r94
        L_0x01be:
            r1 = r1 & 16384(0x4000, float:2.2959E-41)
            if (r1 == 0) goto L_0x01c4
            r1 = 0
            goto L_0x01c6
        L_0x01c4:
            r1 = r95
        L_0x01c6:
            r48 = r47
            r49 = r2
            r50 = r4
            r51 = r6
            r52 = r7
            r53 = r8
            r54 = r9
            r55 = r10
            r56 = r11
            r57 = r12
            r58 = r13
            r59 = r14
            r60 = r15
            r61 = r3
            r62 = r16
            r63 = r5
            r64 = r17
            r65 = r18
            r66 = r19
            r67 = r20
            r68 = r21
            r69 = r22
            r70 = r23
            r71 = r24
            r72 = r25
            r73 = r26
            r74 = r27
            r75 = r28
            r77 = r30
            r78 = r31
            r79 = r32
            r80 = r33
            r81 = r96
            r82 = r34
            r83 = r35
            r84 = r36
            r85 = r37
            r86 = r38
            r87 = r39
            r88 = r40
            r89 = r41
            r90 = r42
            r91 = r43
            r92 = r44
            r93 = r45
            r94 = r46
            r95 = r0
            r96 = r1
            r48.<init>(r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64, r65, r66, r67, r68, r69, r70, r71, r72, r73, r74, r75, r77, r78, r79, r80, r81, r82, r83, r84, r85, r86, r87, r88, r89, r90, r91, r92, r93, r94, r95, r96)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailInfoBean.<init>(java.util.List, int, java.util.List, int, java.lang.String, boolean, java.lang.String, java.lang.String, com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailExamEntrance, boolean, int, java.lang.String, int, boolean, boolean, int, int, boolean, boolean, boolean, boolean, java.lang.String, int, int, int, boolean, long, java.lang.String, int, java.lang.String, int, int, int, int, int, int, int, com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailSpec, int, int, int, java.lang.String, java.lang.String, int, com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailActivityInfo, com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailOperation, java.util.List, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final List<ShopClassDetailAttachedItem> getAttachedItems() {
        return this.attachedItems;
    }

    public final int getAttachedShowPrices() {
        return this.attachedShowPrices;
    }

    public final List<String> getBanners() {
        return this.banners;
    }

    public final int getClazzCategory() {
        return this.clazzCategory;
    }

    public final String getClazzFeeName() {
        return this.clazzFeeName;
    }

    public final boolean getConfigStage() {
        return this.configStage;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getDetailPic() {
        return this.detailPic;
    }

    public final ShopClassDetailExamEntrance getExamEntrance() {
        return this.examEntrance;
    }

    public final boolean getExistStage() {
        return this.existStage;
    }

    public final int getGoodsCategoryId() {
        return this.goodsCategoryId;
    }

    public final String getGoodsFeeName() {
        return this.goodsFeeName;
    }

    public final int getId() {
        return this.id;
    }

    public final boolean getInCart() {
        return this.inCart;
    }

    public final boolean getInWish() {
        return this.inWish;
    }

    public final int getMakePriceIsInclude() {
        return this.makePriceIsInclude;
    }

    public final int getNeedPostAdd() {
        return this.needPostAdd;
    }

    public final boolean getOnSell() {
        return this.onSell;
    }

    public final boolean getOnShow() {
        return this.onShow;
    }

    public final boolean getOneOffPayment() {
        return this.oneOffPayment;
    }

    public final boolean getOnline() {
        return this.online;
    }

    public final String getOperation() {
        return this.operation;
    }

    public final int getOrgPrice() {
        return this.orgPrice;
    }

    public final int getOrigin() {
        return this.origin;
    }

    public final int getPackagePrice() {
        return this.packagePrice;
    }

    public final boolean getPurchased() {
        return this.purchased;
    }

    public final long getRemainSellTime() {
        return this.remainSellTime;
    }

    public final String getSellEndTime() {
        return this.sellEndTime;
    }

    public final int getSellPrice() {
        return this.sellPrice;
    }

    public final String getSellStartTime() {
        return this.sellStartTime;
    }

    public final int getSellStore() {
        return this.sellStore;
    }

    public final int getPerOrgPrice() {
        return this.perOrgPrice;
    }

    public final int getPerShowPrice() {
        return this.perShowPrice;
    }

    public final int getShowPrice() {
        return this.showPrice;
    }

    public final int getShowPriceIsInclude() {
        return this.showPriceIsInclude;
    }

    public final int getSingleOrgPrice() {
        return this.singleOrgPrice;
    }

    public final int getSingleSellPrice() {
        return this.singleSellPrice;
    }

    public final ShopClassDetailSpec getSpec() {
        return this.spec;
    }

    public final int getSpuId() {
        return this.spuId;
    }

    public final int getStandardPrice() {
        return this.standardPrice;
    }

    public final int getStore() {
        return this.store;
    }

    public final String getSubTitle() {
        return this.subTitle;
    }

    public final String getTitle() {
        return this.title;
    }

    public final int getSubscriptionsStatus() {
        return this.subscriptionsStatus;
    }

    public final ShopClassDetailActivityInfo getActivityInfo() {
        return this.activityInfo;
    }

    public final ShopClassDetailOperation getLocal_class_detail_operation() {
        return this.local_class_detail_operation;
    }

    public final void setLocal_class_detail_operation(ShopClassDetailOperation shopClassDetailOperation) {
        this.local_class_detail_operation = shopClassDetailOperation;
    }

    public final List<ShopDetailPositionLocationInfo> getLocal_class_detail_position() {
        return this.local_class_detail_position;
    }

    public final void setLocal_class_detail_position(List<ShopDetailPositionLocationInfo> list) {
        this.local_class_detail_position = list;
    }
}
