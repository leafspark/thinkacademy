package com.tal.user.global.trade.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.tal.user.global.trade.R;
import java.util.Formatter;
import java.util.Locale;

public class TimeCountDownTextView extends AppCompatTextView {
    private final String DEFCOLOR;
    private int mCountDownTextColor;
    private int mDuration;
    StringBuilder mFormatBuilder;
    Formatter mFormatter;
    TimeCountDownListener mListener;
    private TimeCountDowTask mTask;
    /* access modifiers changed from: private */
    public String mTextAfter;
    private String mTextBefor;
    /* access modifiers changed from: private */
    public int mTextColor;
    /* access modifiers changed from: private */
    public String mTimePrefix;
    /* access modifiers changed from: private */
    public String mTimeSuffix;
    /* access modifiers changed from: private */
    public boolean timeCountdowning;

    public interface TimeCountDownListener {
        void onFinish();
    }

    public TimeCountDownTextView(Context context) {
        this(context, (AttributeSet) null);
    }

    public TimeCountDownTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TimeCountDownTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.DEFCOLOR = "#212832";
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TimeCountDownTextView);
        this.mTextBefor = obtainStyledAttributes.getString(R.styleable.TimeCountDownTextView_text_befor);
        this.mTextAfter = obtainStyledAttributes.getString(R.styleable.TimeCountDownTextView_text_after);
        this.mTimePrefix = obtainStyledAttributes.getString(R.styleable.TimeCountDownTextView_time_prefix);
        this.mTimeSuffix = obtainStyledAttributes.getString(R.styleable.TimeCountDownTextView_time_suffix);
        this.mTextColor = obtainStyledAttributes.getColor(R.styleable.TimeCountDownTextView_text_color, Color.parseColor("#212832"));
        this.mCountDownTextColor = obtainStyledAttributes.getColor(R.styleable.TimeCountDownTextView_count_down_text_color, Color.parseColor("#212832"));
        obtainStyledAttributes.recycle();
        initView();
    }

    private void initView() {
        this.mFormatBuilder = new StringBuilder();
        this.mFormatter = new Formatter(this.mFormatBuilder, Locale.getDefault());
        if (!TextUtils.isEmpty(this.mTextBefor)) {
            setText(this.mTextBefor);
        }
        setTextColor(this.mTextColor);
    }

    public void setTimeDuration(int i) {
        this.mDuration = i;
    }

    public void setTimePrefix(String str) {
        this.mTimePrefix = str;
    }

    public void setTimeSuffix(String str) {
        this.mTimeSuffix = str;
    }

    public void setTextAfter(String str) {
        this.mTextAfter = str;
    }

    public void setTextBefor(String str) {
        this.mTextBefor = str;
    }

    class TimeCountDowTask implements Runnable {
        int mTime;

        TimeCountDowTask(int i) {
            this.mTime = i;
        }

        public void run() {
            if (this.mTime > 0) {
                String str = "";
                String access$000 = TextUtils.isEmpty(TimeCountDownTextView.this.mTimePrefix) ? str : TimeCountDownTextView.this.mTimePrefix;
                if (!TextUtils.isEmpty(TimeCountDownTextView.this.mTimeSuffix)) {
                    str = TimeCountDownTextView.this.mTimeSuffix;
                }
                String access$200 = TimeCountDownTextView.this.stringForTime(this.mTime);
                TimeCountDownTextView timeCountDownTextView = TimeCountDownTextView.this;
                timeCountDownTextView.setText(access$000 + access$200 + str);
                this.mTime = this.mTime - 1;
                TimeCountDownTextView.this.postDelayed(this, 1000);
                return;
            }
            if (!TextUtils.isEmpty(TimeCountDownTextView.this.mTextAfter)) {
                TimeCountDownTextView timeCountDownTextView2 = TimeCountDownTextView.this;
                timeCountDownTextView2.setText(timeCountDownTextView2.mTextAfter);
            }
            if (TimeCountDownTextView.this.mListener != null) {
                TimeCountDownTextView.this.mListener.onFinish();
            }
            boolean unused = TimeCountDownTextView.this.timeCountdowning = false;
            TimeCountDownTextView.this.setClickable(true);
            TimeCountDownTextView timeCountDownTextView3 = TimeCountDownTextView.this;
            timeCountDownTextView3.setTextColor(timeCountDownTextView3.mTextColor);
        }
    }

    public boolean isOnCountDowning() {
        return this.timeCountdowning;
    }

    public void startCountDow() {
        TimeCountDowTask timeCountDowTask = this.mTask;
        if (timeCountDowTask != null) {
            removeCallbacks(timeCountDowTask);
            this.mTask = null;
        }
        this.mTask = new TimeCountDowTask(this.mDuration);
        setClickable(false);
        this.timeCountdowning = true;
        setTextColor(this.mCountDownTextColor);
        post(this.mTask);
    }

    public void startCountDow(long j) {
        TimeCountDowTask timeCountDowTask = this.mTask;
        if (timeCountDowTask != null) {
            removeCallbacks(timeCountDowTask);
            this.mTask = null;
        }
        this.mTask = new TimeCountDowTask(this.mDuration);
        setTextColor(this.mCountDownTextColor);
        setClickable(false);
        this.timeCountdowning = true;
        postDelayed(this.mTask, j);
    }

    public void cancleCountDown() {
        TimeCountDowTask timeCountDowTask = this.mTask;
        if (timeCountDowTask != null) {
            removeCallbacks(timeCountDowTask);
            this.mTask = null;
        }
        this.timeCountdowning = false;
        setClickable(true);
        setTextColor(this.mTextColor);
        String str = this.mTextBefor;
        if (str != null) {
            setText(str);
        }
    }

    public void setTimeCountDowListener(TimeCountDownListener timeCountDownListener) {
        this.mListener = timeCountDownListener;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        TimeCountDownTextView.super.onDetachedFromWindow();
        TimeCountDowTask timeCountDowTask = this.mTask;
        if (timeCountDowTask != null) {
            removeCallbacks(timeCountDowTask);
        }
        this.mListener = null;
        this.timeCountdowning = false;
    }

    /* access modifiers changed from: private */
    public String stringForTime(int i) {
        this.mFormatBuilder.setLength(0);
        return this.mFormatter.format("%02d:%02d:%02d", new Object[]{Integer.valueOf(i / 3600), Integer.valueOf((i / 60) % 60), Integer.valueOf(i % 60)}).toString();
    }
}
