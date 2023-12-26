package com.tal.app.thinkacademy.live.business.redpackage.bean;

import java.util.List;

public class RedPacketRankBean {
    private int grabNum;
    private List<ListBean> list;
    private int redbagNum;

    public int getRedbagNum() {
        return this.redbagNum;
    }

    public void setRedbagNum(int i) {
        this.redbagNum = i;
    }

    public int getGrabNum() {
        return this.grabNum;
    }

    public void setGrabNum(int i) {
        this.grabNum = i;
    }

    public List<ListBean> getList() {
        return this.list;
    }

    public void setList(List<ListBean> list2) {
        this.list = list2;
    }

    public static class ListBean {
        private String avatar;
        private int coin;
        private int userId;
        private String userName;

        public String getUserName() {
            return this.userName;
        }

        public void setUserName(String str) {
            this.userName = str;
        }

        public int getUserId() {
            return this.userId;
        }

        public void setUserId(int i) {
            this.userId = i;
        }

        public int getCoin() {
            return this.coin;
        }

        public void setCoin(int i) {
            this.coin = i;
        }

        public String getAvatar() {
            return this.avatar;
        }

        public void setAvatar(String str) {
            this.avatar = str;
        }
    }
}
