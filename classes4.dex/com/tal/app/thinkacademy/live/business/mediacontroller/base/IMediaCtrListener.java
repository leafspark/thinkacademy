package com.tal.app.thinkacademy.live.business.mediacontroller.base;

import android.view.View;
import android.widget.SeekBar;

public interface IMediaCtrListener {
    void onForwardClickListener(View view);

    void onKeyTipClickListener();

    void onModeChangeListener(String str);

    void onNextClickListener(View view);

    void onPauseClickListener();

    void onPlayClickListener();

    void onProgressChanged(SeekBar seekBar, long j);

    void onScreenshotClickListener(View view);

    void onSeekProcessListener();

    void onSpeedChangeListener(float f);

    void onStartTrackingTouch(SeekBar seekBar);

    void onStopTrackingTouch(SeekBar seekBar);
}
