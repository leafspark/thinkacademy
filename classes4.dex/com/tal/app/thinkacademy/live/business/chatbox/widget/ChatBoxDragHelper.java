package com.tal.app.thinkacademy.live.business.chatbox.widget;

import android.view.MotionEvent;
import android.view.View;

public class ChatBoxDragHelper {
    private int mAreaHeight;
    private int mAreaWidth;
    private View mDragView;
    private float mLastActionX;
    private float mLastActionY;
    private int mLeftMarget;
    private int mTopMarget;

    public static void setDrag(View view, View view2, int i, int i2, int i3, int i4) {
        ChatBoxDragHelper chatBoxDragHelper = new ChatBoxDragHelper(view);
        chatBoxDragHelper.setDragView(view2);
        chatBoxDragHelper.setDragMargin(i, i2, i3, i4);
    }

    private ChatBoxDragHelper(View view) {
        view.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return ChatBoxDragHelper.this.onTouchEvent(view, motionEvent);
            }
        });
    }

    private void setDragView(View view) {
        this.mDragView = view;
    }

    private void setDragMargin(int i, int i2, int i3, int i4) {
        this.mLeftMarget = i;
        this.mTopMarget = i2;
        this.mAreaWidth = i3;
        this.mAreaHeight = i4;
    }

    /* access modifiers changed from: private */
    public boolean onTouchEvent(View view, MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        if (motionEvent.getAction() == 2) {
            float f = rawX - this.mLastActionX;
            float f2 = rawY - this.mLastActionY;
            float x = this.mDragView.getX() + f;
            float y = this.mDragView.getY() + f2;
            int i = this.mLeftMarget;
            if (x < ((float) i)) {
                f = ((float) i) - this.mDragView.getX();
            }
            float width = x + ((float) this.mDragView.getWidth());
            int i2 = this.mLeftMarget;
            int i3 = this.mAreaWidth;
            if (width > ((float) (i2 + i3))) {
                f = ((float) ((i2 + i3) - this.mDragView.getWidth())) - this.mDragView.getX();
            }
            int i4 = this.mTopMarget;
            if (y < ((float) i4)) {
                f2 = ((float) i4) - this.mDragView.getY();
            }
            float height = y + ((float) this.mDragView.getHeight());
            int i5 = this.mTopMarget;
            int i6 = this.mAreaHeight;
            if (height > ((float) (i5 + i6))) {
                f2 = ((float) ((i5 + i6) - this.mDragView.getHeight())) - this.mDragView.getY();
            }
            float translationX = this.mDragView.getTranslationX() + f;
            float translationY = this.mDragView.getTranslationY() + f2;
            this.mDragView.setTranslationX(translationX);
            this.mDragView.setTranslationY(translationY);
        }
        this.mLastActionX = rawX;
        this.mLastActionY = rawY;
        return true;
    }
}
