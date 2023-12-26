package com.amazonaws.cognito.clientcontext.datacollection;

import android.content.Context;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContextDataAggregator {
    private final List<DataCollector> dataCollectors;

    private static class InstanceHolder {
        /* access modifiers changed from: private */
        public static final ContextDataAggregator INSTANCE = new ContextDataAggregator();

        private InstanceHolder() {
        }
    }

    private ContextDataAggregator() {
        this.dataCollectors = getDataCollectors();
    }

    protected ContextDataAggregator(List<DataCollector> list) {
        this.dataCollectors = list;
    }

    public static ContextDataAggregator getInstance() {
        return InstanceHolder.INSTANCE;
    }

    public Map<String, String> getAggregatedData(Context context) {
        HashMap hashMap = new HashMap();
        for (DataCollector collect : this.dataCollectors) {
            hashMap.putAll(collect.collect(context));
        }
        removerNullEntries(hashMap);
        return hashMap;
    }

    private void removerNullEntries(Map<String, String> map) {
        for (Map.Entry next : map.entrySet()) {
            if (next.getValue() == null) {
                map.remove(next.getKey());
            }
        }
    }

    private List<DataCollector> getDataCollectors() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ApplicationDataCollector());
        arrayList.add(new BuildDataCollector());
        arrayList.add(new DeviceDataCollector());
        arrayList.add(new TelephonyDataCollector());
        return arrayList;
    }
}
