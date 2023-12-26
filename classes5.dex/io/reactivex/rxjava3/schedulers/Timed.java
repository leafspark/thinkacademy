package io.reactivex.rxjava3.schedulers;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public final class Timed<T> {
    final long time;
    final TimeUnit unit;
    final T value;

    public Timed(T t, long j, TimeUnit timeUnit) {
        Objects.requireNonNull(t, "value is null");
        this.value = t;
        this.time = j;
        Objects.requireNonNull(timeUnit, "unit is null");
        this.unit = timeUnit;
    }

    public T value() {
        return this.value;
    }

    public TimeUnit unit() {
        return this.unit;
    }

    public long time() {
        return this.time;
    }

    public long time(TimeUnit timeUnit) {
        return timeUnit.convert(this.time, this.unit);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Timed)) {
            return false;
        }
        Timed timed = (Timed) obj;
        if (!Objects.equals(this.value, timed.value) || this.time != timed.time || !Objects.equals(this.unit, timed.unit)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        long j = this.time;
        return (((this.value.hashCode() * 31) + ((int) (j ^ (j >>> 31)))) * 31) + this.unit.hashCode();
    }

    public String toString() {
        return "Timed[time=" + this.time + ", unit=" + this.unit + ", value=" + this.value + "]";
    }
}
