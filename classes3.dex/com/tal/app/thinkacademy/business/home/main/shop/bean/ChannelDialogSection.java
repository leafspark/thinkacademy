package com.tal.app.thinkacademy.business.home.main.shop.bean;

import com.chad.library.adapter.base.entity.SectionEntity;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/tal/app/thinkacademy/business/home/main/shop/bean/ChannelDialogSection;", "Lcom/chad/library/adapter/base/entity/SectionEntity;", "isHeader", "", "(Z)V", "()Z", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChannelDialogSection.kt */
public class ChannelDialogSection implements SectionEntity {
    private final boolean isHeader;

    public ChannelDialogSection(boolean z) {
        this.isHeader = z;
    }

    public int getItemType() {
        return SectionEntity.DefaultImpls.getItemType((SectionEntity) this);
    }

    public boolean isHeader() {
        return this.isHeader;
    }
}
