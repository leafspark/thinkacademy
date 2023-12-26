package com.amazonaws.util;

final class TimingInfoUnmodifiable extends TimingInfo {
    TimingInfoUnmodifiable(Long l, long j, Long l2) {
        super(l, j, l2);
    }

    public void setEndTime(long j) {
        throw new UnsupportedOperationException();
    }

    public void setEndTimeNano(long j) {
        throw new UnsupportedOperationException();
    }

    public TimingInfo endTiming() {
        throw new UnsupportedOperationException();
    }
}
