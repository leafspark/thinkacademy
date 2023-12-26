package com.amazonaws.util;

import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TimingInfoFullSupport extends TimingInfo {
    private final Map<String, Number> countersByName = new HashMap();
    private final Map<String, List<TimingInfo>> subMeasurementsByName = new HashMap();

    TimingInfoFullSupport(Long l, long j, Long l2) {
        super(l, j, l2);
    }

    public void addSubMeasurement(String str, TimingInfo timingInfo) {
        List list = this.subMeasurementsByName.get(str);
        if (list == null) {
            list = new ArrayList();
            this.subMeasurementsByName.put(str, list);
        }
        if (timingInfo.isEndTimeKnown()) {
            list.add(timingInfo);
            return;
        }
        Log log = LogFactory.getLog(getClass());
        log.debug("Skip submeasurement timing info with no end time for " + str);
    }

    public TimingInfo getSubMeasurement(String str) {
        return getSubMeasurement(str, 0);
    }

    public TimingInfo getSubMeasurement(String str, int i) {
        List list = this.subMeasurementsByName.get(str);
        if (i < 0 || list == null || list.size() == 0 || i >= list.size()) {
            return null;
        }
        return (TimingInfo) list.get(i);
    }

    public TimingInfo getLastSubMeasurement(String str) {
        List list;
        Map<String, List<TimingInfo>> map = this.subMeasurementsByName;
        if (map == null || map.size() == 0 || (list = this.subMeasurementsByName.get(str)) == null || list.size() == 0) {
            return null;
        }
        return (TimingInfo) list.get(list.size() - 1);
    }

    public List<TimingInfo> getAllSubMeasurements(String str) {
        return this.subMeasurementsByName.get(str);
    }

    public Map<String, List<TimingInfo>> getSubMeasurementsByName() {
        return this.subMeasurementsByName;
    }

    public Number getCounter(String str) {
        return this.countersByName.get(str);
    }

    public Map<String, Number> getAllCounters() {
        return this.countersByName;
    }

    public void setCounter(String str, long j) {
        this.countersByName.put(str, Long.valueOf(j));
    }

    public void incrementCounter(String str) {
        Number counter = getCounter(str);
        setCounter(str, (long) ((counter != null ? counter.intValue() : 0) + 1));
    }
}
