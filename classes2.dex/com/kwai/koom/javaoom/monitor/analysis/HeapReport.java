package com.kwai.koom.javaoom.monitor.analysis;

import java.util.ArrayList;
import java.util.List;

public class HeapReport {
    public Boolean analysisDone;
    public List<ClassInfo> classInfos = new ArrayList();
    public List<GCPath> gcPaths = new ArrayList();
    public List<LeakObject> leakObjects = new ArrayList();
    public Integer reAnalysisTimes;
    public RunningInfo runningInfo = new RunningInfo();

    public static class ClassInfo {
        public String className;
        public String instanceCount;
        public String leakInstanceCount;
    }

    public static class GCPath {
        public String gcRoot;
        public Integer instanceCount;
        public String leakReason;
        public List<PathItem> path = new ArrayList();
        public String signature;

        public static class PathItem {
            String declaredClass;
            String reference;
            String referenceType;
        }
    }

    public static class LeakObject {
        public String className;
        public String extDetail;
        public String objectId;
        public String size;
    }

    public static class RunningInfo {
        public String analysisReason;
        public String appVersion;
        public String buildModel;
        public String currentPage;
        public String deviceMemAvaliable;
        public String deviceMemTotal;
        public String dumpReason;
        public String fdCount;
        public List<String> fdList = new ArrayList();
        public String filterInstanceTime;
        public String findGCPathTime;
        public String jvmMax;
        public String jvmUsed;
        public String koomVersion;
        public String manufacture;
        public String nowTime;
        public String pss;
        public String rss;
        public String sdkInt;
        public String threadCount;
        public List<String> threadList = new ArrayList();
        public String usageSeconds;
        public String vss;
    }
}
