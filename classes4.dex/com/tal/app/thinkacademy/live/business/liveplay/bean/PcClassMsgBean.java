package com.tal.app.thinkacademy.live.business.liveplay.bean;

public class PcClassMsgBean {
    private ClassmodeDTO classmode;

    public ClassmodeDTO getClassmode() {
        return this.classmode;
    }

    public void setClassmode(ClassmodeDTO classmodeDTO) {
        this.classmode = classmodeDTO;
    }

    public static class ClassmodeDTO {
        private String action;
        private String client;

        public String getAction() {
            return this.action;
        }

        public void setAction(String str) {
            this.action = str;
        }

        public String getClient() {
            return this.client;
        }

        public void setClient(String str) {
            this.client = str;
        }
    }
}
