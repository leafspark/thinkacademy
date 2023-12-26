package com.wushuangtech.library.video;

public class RenderSmooth {
    private double draw_frame;
    private double last_real_fps;
    private long last_time;
    private long prev_ts;
    private double real_fps = 15.0d;
    private long smooth_ts;

    public RenderSmooth(int i) {
        this.real_fps = (double) i;
    }

    public void setRenderFps(int i) {
        double d = (double) i;
        if (this.real_fps != d) {
            this.real_fps = d;
        }
    }

    public void reset() {
        this.last_time = 0;
        this.draw_frame = 0.0d;
        this.last_real_fps = 0.0d;
    }

    public long smoothTimestamp() {
        long currentTimeMillis = System.currentTimeMillis();
        boolean z = currentTimeMillis - this.prev_ts > 1000;
        this.prev_ts = currentTimeMillis;
        double d = this.last_real_fps;
        double d2 = this.real_fps;
        if (d != d2 || z) {
            this.last_real_fps = d2;
            this.last_time = currentTimeMillis;
            this.draw_frame = 1.0d;
            this.smooth_ts = currentTimeMillis;
            return currentTimeMillis;
        }
        double d3 = this.draw_frame;
        if (((double) (currentTimeMillis - this.last_time)) < (d3 * 1000.0d) / d2) {
            return -1;
        }
        this.draw_frame = d3 + 1.0d;
        long j = (long) (((double) this.smooth_ts) + (1000.0d / d2));
        this.smooth_ts = j;
        long j2 = currentTimeMillis - j;
        if (((double) Math.abs(j2)) > 200.0d / d2) {
            this.smooth_ts += j2;
        }
        return this.smooth_ts;
    }
}
