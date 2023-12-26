package com.tal.app.thinkacademy.business.shop.classdetail;

import com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailOperation;
import com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailSyllabu;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00122\u00020\u0001:\u0002\u0012\u0013B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0010\u001a\u00020\u0011R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/classdetail/ShopClassDetailDataManager;", "", "()V", "mDetailOperation", "Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassDetailOperation;", "getMDetailOperation", "()Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassDetailOperation;", "setMDetailOperation", "(Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassDetailOperation;)V", "mSyllabusList", "", "Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassDetailSyllabu;", "getMSyllabusList", "()Ljava/util/List;", "setMSyllabusList", "(Ljava/util/List;)V", "clearData", "", "Companion", "Inner", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShopClassDetailDataManager.kt */
public final class ShopClassDetailDataManager {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private ShopClassDetailOperation mDetailOperation;
    private List<ShopClassDetailSyllabu> mSyllabusList;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/classdetail/ShopClassDetailDataManager$Companion;", "", "()V", "getInstance", "Lcom/tal/app/thinkacademy/business/shop/classdetail/ShopClassDetailDataManager;", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ShopClassDetailDataManager.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ShopClassDetailDataManager getInstance() {
            return Inner.INSTANCE.getInstance();
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/classdetail/ShopClassDetailDataManager$Inner;", "", "()V", "instance", "Lcom/tal/app/thinkacademy/business/shop/classdetail/ShopClassDetailDataManager;", "getInstance", "()Lcom/tal/app/thinkacademy/business/shop/classdetail/ShopClassDetailDataManager;", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ShopClassDetailDataManager.kt */
    private static final class Inner {
        public static final Inner INSTANCE = new Inner();
        private static final ShopClassDetailDataManager instance = new ShopClassDetailDataManager();

        private Inner() {
        }

        public final ShopClassDetailDataManager getInstance() {
            return instance;
        }
    }

    public final ShopClassDetailOperation getMDetailOperation() {
        return this.mDetailOperation;
    }

    public final void setMDetailOperation(ShopClassDetailOperation shopClassDetailOperation) {
        this.mDetailOperation = shopClassDetailOperation;
    }

    public final List<ShopClassDetailSyllabu> getMSyllabusList() {
        return this.mSyllabusList;
    }

    public final void setMSyllabusList(List<ShopClassDetailSyllabu> list) {
        this.mSyllabusList = list;
    }

    public final void clearData() {
        this.mDetailOperation = null;
        this.mSyllabusList = null;
    }
}
