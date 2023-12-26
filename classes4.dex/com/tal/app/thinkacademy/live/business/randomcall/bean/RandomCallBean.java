package com.tal.app.thinkacademy.live.business.randomcall.bean;

import java.util.List;

public class RandomCallBean {
    private int pub;
    private String sendTime;
    private List<Student> students;
    private String timestamp;

    public int getPub() {
        return this.pub;
    }

    public String getTimestamp() {
        return this.timestamp;
    }

    public List<Student> getStudents() {
        return this.students;
    }

    public String getSendTime() {
        return this.sendTime;
    }

    public void setStudents(List<Student> list) {
        this.students = list;
    }

    public static class Student {
        private String avatar;
        private int level;
        private String name;
        private String teacherIrcName;
        private String title = "";
        private long userId;

        public String getTeacherIrcName() {
            return this.teacherIrcName;
        }

        public String getAvatar() {
            return this.avatar;
        }

        public String getName() {
            return this.name;
        }

        public int getLevel() {
            return this.level;
        }

        public String getTitle() {
            return this.title;
        }

        public long getUserId() {
            return this.userId;
        }
    }
}
