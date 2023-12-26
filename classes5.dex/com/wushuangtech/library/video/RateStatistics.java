package com.wushuangtech.library.video;

public class RateStatistics {
    private static final float kBpsScale = 8000.0f;
    private int accumulated_count_ = 0;
    private Bucket[] buckets_;
    private int current_window_size_ms_;
    private int max_window_size_ms_;
    private int num_samples_ = 0;
    private int oldest_index_;
    private long oldest_time_;
    private float scale_;

    private class Bucket {
        int samples;
        int sum;

        private Bucket() {
        }
    }

    public RateStatistics(int i, float f) {
        this.oldest_time_ = (long) (-i);
        this.oldest_index_ = 0;
        this.scale_ = f;
        this.max_window_size_ms_ = i;
        this.current_window_size_ms_ = i;
        this.buckets_ = new Bucket[i];
    }

    public void Reset() {
        this.accumulated_count_ = 0;
        this.num_samples_ = 0;
        int i = this.max_window_size_ms_;
        this.oldest_time_ = (long) (-i);
        this.oldest_index_ = 0;
        this.current_window_size_ms_ = i;
        for (int i2 = 0; i2 < this.max_window_size_ms_; i2++) {
            this.buckets_[i2] = new Bucket();
        }
    }

    public void Update(int i, long j) {
        if (j >= this.oldest_time_) {
            EraseOld(j);
            if (!IsInitialized()) {
                this.oldest_time_ = j;
            }
            int i2 = this.oldest_index_ + ((int) (j - this.oldest_time_));
            int i3 = this.max_window_size_ms_;
            if (i2 >= i3) {
                i2 -= i3;
            }
            this.buckets_[i2].sum += i;
            this.buckets_[i2].samples++;
            this.accumulated_count_ += i;
            this.num_samples_++;
        }
    }

    public int Rate(long j) {
        EraseOld(j);
        long j2 = (j - this.oldest_time_) + 1;
        int i = this.num_samples_;
        if (i == 0 || j2 <= 1) {
            return -1;
        }
        if (i <= 1 && j2 < ((long) this.current_window_size_ms_)) {
            return -1;
        }
        return (int) ((((float) this.accumulated_count_) * (this.scale_ / ((float) j2))) + 0.5f);
    }

    public boolean SetWindowSize(int i, long j) {
        if (i <= 0 || i > this.max_window_size_ms_) {
            return false;
        }
        this.current_window_size_ms_ = i;
        EraseOld(j);
        return true;
    }

    private void EraseOld(long j) {
        if (IsInitialized()) {
            long j2 = (j - ((long) this.current_window_size_ms_)) + 1;
            if (j2 > this.oldest_time_) {
                while (this.num_samples_ > 0 && this.oldest_time_ < j2) {
                    Bucket bucket = this.buckets_[this.oldest_index_];
                    this.accumulated_count_ -= bucket.sum;
                    this.num_samples_ -= bucket.samples;
                    this.buckets_[this.oldest_index_] = new Bucket();
                    int i = this.oldest_index_ + 1;
                    this.oldest_index_ = i;
                    if (i >= this.max_window_size_ms_) {
                        this.oldest_index_ = 0;
                    }
                    this.oldest_time_++;
                }
                this.oldest_time_ = j2;
            }
        }
    }

    private boolean IsInitialized() {
        return this.oldest_time_ != ((long) (-this.max_window_size_ms_));
    }
}
