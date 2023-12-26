package com.tal.app.thinkacademy.live.business.livemessage.entity;

import java.util.ArrayList;
import java.util.List;

public class LiveMessagePrivateEntity {
    private List<PrivateMessageEntity> list;

    public List<PrivateMessageEntity> getList() {
        return this.list;
    }

    public void setList(ArrayList<PrivateMessageEntity> arrayList) {
        this.list = arrayList;
    }

    public class PrivateMessageEntity {
        private long ctime;
        private String message;
        private int sendTo;
        private long studentId;

        public PrivateMessageEntity() {
        }

        public long getStudentId() {
            return this.studentId;
        }

        public void setStudentId(long j) {
            this.studentId = j;
        }

        public int getSendTo() {
            return this.sendTo;
        }

        public void setSendTo(int i) {
            this.sendTo = i;
        }

        public long getCtime() {
            return this.ctime;
        }

        public void setCtime(long j) {
            this.ctime = j;
        }

        public String getMessage() {
            return this.message;
        }

        public void setMessage(String str) {
            this.message = str;
        }
    }

    public class MessageEntity {
        private String by;
        private String msg;
        private String name;
        private String tutor_avatar;
        private String type;

        public MessageEntity() {
        }

        public String getBy() {
            return this.by;
        }

        public void setBy(String str) {
            this.by = str;
        }

        public String getMsg() {
            return this.msg;
        }

        public void setMsg(String str) {
            this.msg = str;
        }

        public String getType() {
            return this.type;
        }

        public void setType(String str) {
            this.type = str;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String str) {
            this.name = str;
        }

        public String getTutor_avatar() {
            return this.tutor_avatar;
        }

        public void setTutor_avatar(String str) {
            this.tutor_avatar = str;
        }
    }
}
