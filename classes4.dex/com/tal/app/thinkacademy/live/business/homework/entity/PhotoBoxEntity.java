package com.tal.app.thinkacademy.live.business.homework.entity;

import java.util.List;

public class PhotoBoxEntity {
    public boolean canCorrect;
    public List<HomeworkEntity> list;

    public boolean isCanCorrect() {
        return this.canCorrect;
    }

    public void setCanCorrect(boolean z) {
        this.canCorrect = z;
    }

    public List<HomeworkEntity> getList() {
        return this.list;
    }

    public void setList(List<HomeworkEntity> list2) {
        this.list = list2;
    }
}
