package com.didi.hummer.devtools.utils;

import com.didi.hummer.debug.InvokeTracker;
import com.didi.hummer.debug.PerformanceTracker;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class PerformanceListFormat {
    public static String format(List<PerformanceTracker> list) {
        if (list == null || list.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (PerformanceTracker generatePerformanceFormat : list) {
            sb.append(generatePerformanceFormat(generatePerformanceFormat));
        }
        return sb.toString();
    }

    private static String generatePerformanceFormat(PerformanceTracker performanceTracker) {
        return "┌─────────────────────────\n│\t耗时统计\n├┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄\n" + generateSourceCallStackInfo(performanceTracker) + "├┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄\n" + generateSummaryPerformanceInfo(performanceTracker) + "├┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄\n" + generateInvokeTimeCostSortInfo(performanceTracker) + "├┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄\n" + generateInvokeCallStackInfo(performanceTracker) + "└─────────────────────────\n\n";
    }

    private static String generateSourceCallStackInfo(PerformanceTracker performanceTracker) {
        if (performanceTracker == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("│\t<Source Call Stack>\n");
        for (String str : performanceTracker.sourceCallStack) {
            sb.append("│\t" + str + "\n");
        }
        return sb.toString();
    }

    private static String generateSummaryPerformanceInfo(PerformanceTracker performanceTracker) {
        if (performanceTracker == null) {
            return "";
        }
        return "│\t" + String.format("totalCost: %d ms\n", new Object[]{Long.valueOf(performanceTracker.totalCost / 1000000)}) + "│\t" + String.format("invokeCost: %d ms\n", new Object[]{Long.valueOf(performanceTracker.invokeCost / 1000000)}) + "│\t" + String.format("otherCost: %d ms\n", new Object[]{Long.valueOf(performanceTracker.otherCost / 1000000)});
    }

    private static String generateInvokeTimeCostSortInfo(PerformanceTracker performanceTracker) {
        if (performanceTracker == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry next : performanceTracker.sortTimeCostList) {
            String str = (String) next.getKey();
            PerformanceTracker.TimeCost timeCost = (PerformanceTracker.TimeCost) next.getValue();
            if (!str.contains("constructor_end")) {
                sb.append("│\t");
                sb.append(String.format("[%.1f ms] %s - {%d}\n", new Object[]{Float.valueOf(((float) timeCost.cost) / 1000000.0f), str, Integer.valueOf(timeCost.count)}));
            }
        }
        return sb.toString();
    }

    private static String generateInvokeCallStackInfo(PerformanceTracker performanceTracker) {
        String str;
        if (performanceTracker == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (InvokeTracker next : performanceTracker.trackerList) {
            if (!next.methodName.equals("constructor_end")) {
                sb.append("│\t");
                Object[] objArr = new Object[5];
                objArr[0] = next.timeFormat;
                objArr[1] = Long.valueOf(next.objectID);
                objArr[2] = next.className;
                objArr[3] = next.methodName;
                if (next.params.length > 0) {
                    str = Arrays.toString(next.params);
                } else {
                    str = "";
                }
                objArr[4] = str;
                sb.append(String.format("[%s] (%d) %s.%s(%s)\n", objArr));
            }
        }
        return sb.toString();
    }
}
