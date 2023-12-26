package com.tal.app.thinkacademy.live.business.gift.bean;

import java.util.List;

public class GiftBean {
    private String activityId;
    private String activityName;
    private List<GiftListBean> giftList;

    public String getActivityId() {
        return this.activityId;
    }

    public void setActivityId(String str) {
        this.activityId = str;
    }

    public String getActivityName() {
        return this.activityName;
    }

    public void setActivityName(String str) {
        this.activityName = str;
    }

    public List<GiftListBean> getGiftList() {
        return this.giftList;
    }

    public void setGiftList(List<GiftListBean> list) {
        this.giftList = list;
    }

    public static class GiftListBean {
        private int coin;
        private int giftId;
        private String giftName;
        private String iconApp;
        private String iconPc;
        private String imageApp;
        private String imagePc;
        private boolean isSelect;
        private int order;
        private String text;

        public int getGiftId() {
            return this.giftId;
        }

        public void setGiftId(int i) {
            this.giftId = i;
        }

        public String getGiftName() {
            return this.giftName;
        }

        public void setGiftName(String str) {
            this.giftName = str;
        }

        public int getCoin() {
            return this.coin;
        }

        public void setCoin(int i) {
            this.coin = i;
        }

        public String getIconPc() {
            return this.iconPc;
        }

        public void setIconPc(String str) {
            this.iconPc = str;
        }

        public String getIconApp() {
            return this.iconApp;
        }

        public void setIconApp(String str) {
            this.iconApp = str;
        }

        public String getText() {
            return this.text;
        }

        public void setText(String str) {
            this.text = str;
        }

        public int getOrder() {
            return this.order;
        }

        public void setOrder(int i) {
            this.order = i;
        }

        public String getImagePc() {
            return this.imagePc;
        }

        public void setImagePc(String str) {
            this.imagePc = str;
        }

        public String getImageApp() {
            return this.imageApp;
        }

        public void setImageApp(String str) {
            this.imageApp = str;
        }

        public boolean isSelect() {
            return this.isSelect;
        }

        public void setSelect(boolean z) {
            this.isSelect = z;
        }
    }
}
