package com.tal.app.thinkacademy.live.business.praise.bean;

public class ClassroomPraiseEntity {
    private ClassroomPraise classroom_praise;
    private Long sendTime;

    public Long getSendTime() {
        return this.sendTime;
    }

    public void setSendTime(Long l) {
        this.sendTime = l;
    }

    public ClassroomPraise getClassroom_praise() {
        return this.classroom_praise;
    }

    public void setClassroom_praise(ClassroomPraise classroomPraise) {
        this.classroom_praise = classroomPraise;
    }

    public static class ClassroomPraise {
        private Long beginTime;
        private String interactId;
        private Integer planId;
        private Boolean pub;

        public String getInteractId() {
            return this.interactId;
        }

        public void setInteractId(String str) {
            this.interactId = str;
        }

        public Boolean getPub() {
            return this.pub;
        }

        public void setPub(Boolean bool) {
            this.pub = bool;
        }

        public Long getBeginTime() {
            return this.beginTime;
        }

        public void setBeginTime(Long l) {
            this.beginTime = l;
        }

        public Integer getPlanId() {
            return this.planId;
        }

        public void setPlanId(Integer num) {
            this.planId = num;
        }
    }
}
