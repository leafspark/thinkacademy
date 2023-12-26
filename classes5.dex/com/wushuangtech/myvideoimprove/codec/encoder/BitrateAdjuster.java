package com.wushuangtech.myvideoimprove.codec.encoder;

import com.wushuangtech.library.video.RateStatistics;
import com.wushuangtech.library.video.VideoErrorConstants;
import com.yalantis.ucrop.view.CropImageView;

public class BitrateAdjuster {
    private static final float kBitrateTolerancePct = 0.1f;
    private static final int kBitrateUpdateFrameInterval = 30;
    private static final int kBitrateUpdateIntervalMs = 1000;
    private static final float kBytesPerMsToBitsPerSecond = 8000.0f;
    private int adjusted_bitrate_bps_;
    private RateStatistics bitrate_tracker_;
    private int frames_since_last_update_;
    private int last_adjusted_target_bitrate_bps_;
    private int last_bitrate_update_time_ms_;
    private final Object lock_obj = new Object();
    private float max_adjusted_bitrate_pct_;
    private float min_adjusted_bitrate_pct_;
    private int target_bitrate_bps_;

    public BitrateAdjuster(float f, float f2) {
        this.min_adjusted_bitrate_pct_ = f;
        this.max_adjusted_bitrate_pct_ = f2;
        this.bitrate_tracker_ = new RateStatistics(VideoErrorConstants.RENDER_EGL_DISPLAY_ADD_SURFACE_FAILED, kBytesPerMsToBitsPerSecond);
        Reset();
    }

    public void SetTargetBitrateBps(int i) {
        synchronized (this.lock_obj) {
            if (!IsWithinTolerance(i, this.target_bitrate_bps_) || !IsWithinTolerance(i, this.last_adjusted_target_bitrate_bps_)) {
                this.adjusted_bitrate_bps_ = i;
                this.last_adjusted_target_bitrate_bps_ = i;
            }
            this.target_bitrate_bps_ = i;
        }
    }

    public int GetTargetBitrateBps() {
        int i;
        synchronized (this.lock_obj) {
            i = this.target_bitrate_bps_;
        }
        return i;
    }

    public int GetAdjustedBitrateBps() {
        int i;
        synchronized (this.lock_obj) {
            i = this.adjusted_bitrate_bps_;
        }
        return i;
    }

    public int GetEstimatedBitrateBps() {
        int Rate;
        synchronized (this.lock_obj) {
            Rate = this.bitrate_tracker_.Rate(System.currentTimeMillis());
        }
        return Rate;
    }

    public void Update(int i) {
        synchronized (this.lock_obj) {
            int currentTimeMillis = (int) System.currentTimeMillis();
            this.bitrate_tracker_.Update(i, (long) currentTimeMillis);
            UpdateBitrate(currentTimeMillis);
        }
    }

    private boolean IsWithinTolerance(int i, int i2) {
        if (i2 == 0) {
            return false;
        }
        float f = (float) i2;
        return Math.abs(((float) i) - f) / f < kBitrateTolerancePct;
    }

    private int GetMinAdjustedBitrateBps() {
        return (int) (this.min_adjusted_bitrate_pct_ * ((float) this.target_bitrate_bps_));
    }

    private int GetMaxAdjustedBitrateBps() {
        return (int) (this.max_adjusted_bitrate_pct_ * ((float) this.target_bitrate_bps_));
    }

    private void Reset() {
        synchronized (this.lock_obj) {
            this.target_bitrate_bps_ = 0;
            this.adjusted_bitrate_bps_ = 0;
            this.last_adjusted_target_bitrate_bps_ = 0;
            this.last_bitrate_update_time_ms_ = 0;
            this.frames_since_last_update_ = 0;
            this.bitrate_tracker_.Reset();
        }
    }

    private void UpdateBitrate(int i) {
        int i2 = i - this.last_bitrate_update_time_ms_;
        int i3 = this.frames_since_last_update_ + 1;
        this.frames_since_last_update_ = i3;
        if (i2 >= 1000 && i3 >= 30) {
            float f = (float) this.target_bitrate_bps_;
            float Rate = (float) this.bitrate_tracker_.Rate((long) i);
            if (Rate <= CropImageView.DEFAULT_ASPECT_RATIO) {
                Rate = f;
            }
            float f2 = f - Rate;
            if (Rate > f || f2 > kBitrateTolerancePct * f) {
                float min = Math.min(Math.max(f + (f2 * 0.5f), (float) GetMinAdjustedBitrateBps()), (float) GetMaxAdjustedBitrateBps());
                if (min != ((float) this.adjusted_bitrate_bps_)) {
                    this.adjusted_bitrate_bps_ = (int) min;
                }
            }
            this.last_bitrate_update_time_ms_ = i;
            this.frames_since_last_update_ = 0;
            this.last_adjusted_target_bitrate_bps_ = this.target_bitrate_bps_;
        }
    }
}
