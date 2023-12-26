package com.tal.app.thinkacademy.live.business.gift;

import com.tal.app.thinkacademy.live.business.gift.bean.GiftBean;

public interface IActionListener {
    void initGiftList();

    void sendGift(GiftBean.GiftListBean giftListBean);
}
