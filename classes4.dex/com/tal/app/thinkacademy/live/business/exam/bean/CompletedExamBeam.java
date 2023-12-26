package com.tal.app.thinkacademy.live.business.exam.bean;

public class CompletedExamBeam {
    private boolean submit;
    private int type;

    public CompletedExamBeam(int i, boolean z) {
        this.type = i;
        this.submit = z;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public boolean isSubmit() {
        return this.submit;
    }

    public void setSubmit(boolean z) {
        this.submit = z;
    }
}
