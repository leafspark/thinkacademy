package com.amazonaws.util;

import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.metrics.MetricType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Deprecated
public class AWSRequestMetricsFullSupport extends AWSRequestMetrics {
    private static final Object COMMA_SEPARATOR = ", ";
    private static final Object KEY_VALUE_SEPARATOR = "=";
    private static final Log LATENCY_LOGGER = LogFactory.getLog("com.amazonaws.latency");
    private final Map<String, TimingInfo> eventsBeingProfiled = new HashMap();
    private final Map<String, List<Object>> properties = new HashMap();

    public final boolean isEnabled() {
        return true;
    }

    public AWSRequestMetricsFullSupport() {
        super(TimingInfo.startTimingFullSupport());
    }

    public void startEvent(String str) {
        this.eventsBeingProfiled.put(str, TimingInfo.startTimingFullSupport(System.nanoTime()));
    }

    public void startEvent(MetricType metricType) {
        startEvent(metricType.name());
    }

    public void endEvent(String str) {
        TimingInfo timingInfo = this.eventsBeingProfiled.get(str);
        if (timingInfo == null) {
            Log log = LogFactory.getLog(getClass());
            log.warn("Trying to end an event which was never started: " + str);
            return;
        }
        timingInfo.endTiming();
        this.timingInfo.addSubMeasurement(str, TimingInfo.unmodifiableTimingInfo(timingInfo.getStartTimeNano(), Long.valueOf(timingInfo.getEndTimeNano())));
    }

    public void endEvent(MetricType metricType) {
        endEvent(metricType.name());
    }

    public void incrementCounter(String str) {
        this.timingInfo.incrementCounter(str);
    }

    public void incrementCounter(MetricType metricType) {
        incrementCounter(metricType.name());
    }

    public void setCounter(String str, long j) {
        this.timingInfo.setCounter(str, j);
    }

    public void setCounter(MetricType metricType, long j) {
        setCounter(metricType.name(), j);
    }

    public void addProperty(String str, Object obj) {
        List list = this.properties.get(str);
        if (list == null) {
            list = new ArrayList();
            this.properties.put(str, list);
        }
        list.add(obj);
    }

    public void addProperty(MetricType metricType, Object obj) {
        addProperty(metricType.name(), obj);
    }

    public void log() {
        if (LATENCY_LOGGER.isInfoEnabled()) {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry next : this.properties.entrySet()) {
                keyValueFormat(next.getKey(), next.getValue(), sb);
            }
            for (Map.Entry next2 : this.timingInfo.getAllCounters().entrySet()) {
                keyValueFormat(next2.getKey(), next2.getValue(), sb);
            }
            for (Map.Entry next3 : this.timingInfo.getSubMeasurementsByName().entrySet()) {
                keyValueFormat(next3.getKey(), next3.getValue(), sb);
            }
            LATENCY_LOGGER.info(sb.toString());
        }
    }

    private void keyValueFormat(Object obj, Object obj2, StringBuilder sb) {
        sb.append(obj);
        sb.append(KEY_VALUE_SEPARATOR);
        sb.append(obj2);
        sb.append(COMMA_SEPARATOR);
    }

    public List<Object> getProperty(String str) {
        return this.properties.get(str);
    }

    public List<Object> getProperty(MetricType metricType) {
        return getProperty(metricType.name());
    }
}
