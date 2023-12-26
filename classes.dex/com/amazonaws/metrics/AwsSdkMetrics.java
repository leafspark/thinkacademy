package com.amazonaws.metrics;

import com.amazonaws.SDKGlobalConfiguration;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.PropertiesCredentials;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.regions.Regions;
import com.amazonaws.util.AWSRequestMetrics;
import com.amazonaws.util.AWSServiceMetrics;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public enum AwsSdkMetrics {
    ;
    
    public static final String AWS_CREDENTAIL_PROPERTIES_FILE = "credentialFile";
    public static final String CLOUDWATCH_REGION = "cloudwatchRegion";
    private static final boolean DEFAULT_METRICS_ENABLED = false;
    private static final String DEFAULT_METRIC_COLLECTOR_FACTORY = "com.amazonaws.metrics.internal.cloudwatch.DefaultMetricCollectorFactory";
    public static final String DEFAULT_METRIC_NAMESPACE = "AWSSDK/Java";
    public static final String EXCLUDE_MACHINE_METRICS = "excludeMachineMetrics";
    public static final String HOST_METRIC_NAME = "hostMetricName";
    public static final String INCLUDE_PER_HOST_METRICS = "includePerHostMetrics";
    public static final String JVM_METRIC_NAME = "jvmMetricName";
    private static final String MBEAN_OBJECT_NAME = null;
    public static final String METRIC_NAME_SPACE = "metricNameSpace";
    public static final String METRIC_QUEUE_SIZE = "metricQueueSize";
    public static final String QUEUE_POLL_TIMEOUT_MILLI = "getQueuePollTimeoutMilli";
    private static final int QUEUE_POLL_TIMEOUT_MILLI_MINUMUM = 1000;
    private static final MetricRegistry REGISTRY = null;
    public static final String USE_SINGLE_METRIC_NAMESPACE = "useSingleMetricNamespace";
    private static volatile String credentialFile;
    private static volatile AWSCredentialsProvider credentialProvider;
    private static boolean dirtyEnabling;
    private static volatile String hostMetricName;
    private static volatile String jvmMetricName;
    private static volatile boolean machineMetricsExcluded;
    private static volatile MetricCollector mc;
    private static volatile String metricNameSpace;
    private static volatile Integer metricQueueSize;
    private static volatile boolean perHostMetricsIncluded;
    private static volatile Long queuePollTimeoutMilli;
    private static volatile Regions region;
    private static volatile boolean singleMetricNamespace;

    static {
        Class<AwsSdkMetrics> cls;
        MBEAN_OBJECT_NAME = "com.amazonaws.management:type=" + "AwsSdkMetrics";
        metricNameSpace = DEFAULT_METRIC_NAMESPACE;
        String property = System.getProperty(SDKGlobalConfiguration.DEFAULT_METRICS_SYSTEM_PROPERTY);
        boolean z = property != null;
        DEFAULT_METRICS_ENABLED = z;
        if (z) {
            boolean z2 = false;
            boolean z3 = false;
            boolean z4 = false;
            for (String trim : property.split(",")) {
                String trim2 = trim.trim();
                if (!z2 && EXCLUDE_MACHINE_METRICS.equals(trim2)) {
                    z2 = true;
                } else if (!z3 && INCLUDE_PER_HOST_METRICS.equals(trim2)) {
                    z3 = true;
                } else if (z4 || !USE_SINGLE_METRIC_NAMESPACE.equals(trim2)) {
                    String[] split = trim2.split("=");
                    if (split.length == 2) {
                        String trim3 = split[0].trim();
                        String trim4 = split[1].trim();
                        try {
                            if (AWS_CREDENTAIL_PROPERTIES_FILE.equals(trim3)) {
                                setCredentialFile0(trim4);
                            } else if (CLOUDWATCH_REGION.equals(trim3)) {
                                region = Regions.fromName(trim4);
                            } else if (METRIC_QUEUE_SIZE.equals(trim3)) {
                                Integer num = new Integer(trim4);
                                if (num.intValue() >= 1) {
                                    metricQueueSize = num;
                                } else {
                                    throw new IllegalArgumentException("metricQueueSize must be at least 1");
                                }
                            } else if (QUEUE_POLL_TIMEOUT_MILLI.equals(trim3)) {
                                Long l = new Long(trim4);
                                if (l.intValue() >= 1000) {
                                    queuePollTimeoutMilli = l;
                                } else {
                                    throw new IllegalArgumentException("getQueuePollTimeoutMilli must be at least 1000");
                                }
                            } else if (METRIC_NAME_SPACE.equals(trim3)) {
                                metricNameSpace = trim4;
                            } else if (JVM_METRIC_NAME.equals(trim3)) {
                                jvmMetricName = trim4;
                            } else if (HOST_METRIC_NAME.equals(trim3)) {
                                hostMetricName = trim4;
                            } else {
                                LogFactory.getLog((Class<?>) cls).debug("Ignoring unrecognized parameter: " + trim2);
                            }
                        } catch (Exception e) {
                            LogFactory.getLog((Class<?>) cls).debug("Ignoring failure", e);
                        }
                    } else {
                        continue;
                    }
                } else {
                    z4 = true;
                }
            }
            machineMetricsExcluded = z2;
            perHostMetricsIncluded = z3;
            singleMetricNamespace = z4;
        }
        REGISTRY = new MetricRegistry();
    }

    public static <T extends RequestMetricCollector> T getRequestMetricCollector() {
        if (mc == null && isDefaultMetricsEnabled()) {
            enableDefaultMetrics();
        }
        return mc == null ? RequestMetricCollector.NONE : mc.getRequestMetricCollector();
    }

    public static <T extends ServiceMetricCollector> T getServiceMetricCollector() {
        if (mc == null && isDefaultMetricsEnabled()) {
            enableDefaultMetrics();
        }
        return mc == null ? ServiceMetricCollector.NONE : mc.getServiceMetricCollector();
    }

    static MetricCollector getInternalMetricCollector() {
        return mc;
    }

    public static <T extends MetricCollector> T getMetricCollector() {
        if (mc == null && isDefaultMetricsEnabled()) {
            enableDefaultMetrics();
        }
        return mc == null ? MetricCollector.NONE : mc;
    }

    public static synchronized void setMetricCollector(MetricCollector metricCollector) {
        synchronized (AwsSdkMetrics.class) {
            MetricCollector metricCollector2 = mc;
            mc = metricCollector;
            if (metricCollector2 != null) {
                metricCollector2.stop();
            }
        }
    }

    public static void setMachineMetricsExcluded(boolean z) {
        machineMetricsExcluded = z;
    }

    public static void setPerHostMetricsIncluded(boolean z) {
        perHostMetricsIncluded = z;
    }

    public static boolean isDefaultMetricsEnabled() {
        return DEFAULT_METRICS_ENABLED;
    }

    public static boolean isSingleMetricNamespace() {
        return singleMetricNamespace;
    }

    public static void setSingleMetricNamespace(boolean z) {
        singleMetricNamespace = z;
    }

    public static boolean isMetricsEnabled() {
        MetricCollector metricCollector = mc;
        return metricCollector != null && metricCollector.isEnabled();
    }

    public static boolean isMachineMetricExcluded() {
        return machineMetricsExcluded;
    }

    public static boolean isPerHostMetricIncluded() {
        return perHostMetricsIncluded;
    }

    public static boolean isPerHostMetricEnabled() {
        String str;
        if (perHostMetricsIncluded) {
            return true;
        }
        String str2 = hostMetricName;
        if (str2 == null) {
            str = "";
        } else {
            str = str2.trim();
        }
        if (str.length() > 0) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0041, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized boolean enableDefaultMetrics() {
        /*
            java.lang.Class<com.amazonaws.metrics.AwsSdkMetrics> r0 = com.amazonaws.metrics.AwsSdkMetrics.class
            monitor-enter(r0)
            com.amazonaws.metrics.MetricCollector r1 = mc     // Catch:{ all -> 0x004d }
            r2 = 0
            if (r1 == 0) goto L_0x0010
            com.amazonaws.metrics.MetricCollector r1 = mc     // Catch:{ all -> 0x004d }
            boolean r1 = r1.isEnabled()     // Catch:{ all -> 0x004d }
            if (r1 != 0) goto L_0x0040
        L_0x0010:
            boolean r1 = dirtyEnabling     // Catch:{ all -> 0x004d }
            if (r1 != 0) goto L_0x0045
            r1 = 1
            dirtyEnabling = r1     // Catch:{ all -> 0x004d }
            java.lang.String r3 = "com.amazonaws.metrics.internal.cloudwatch.DefaultMetricCollectorFactory"
            java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch:{ Exception -> 0x0035 }
            java.lang.Object r3 = r3.newInstance()     // Catch:{ Exception -> 0x0035 }
            com.amazonaws.metrics.MetricCollector$Factory r3 = (com.amazonaws.metrics.MetricCollector.Factory) r3     // Catch:{ Exception -> 0x0035 }
            com.amazonaws.metrics.MetricCollector r3 = r3.getInstance()     // Catch:{ Exception -> 0x0035 }
            if (r3 == 0) goto L_0x0030
            setMetricCollector(r3)     // Catch:{ Exception -> 0x0035 }
            dirtyEnabling = r2     // Catch:{ all -> 0x004d }
            monitor-exit(r0)
            return r1
        L_0x0030:
            dirtyEnabling = r2     // Catch:{ all -> 0x004d }
            goto L_0x0040
        L_0x0033:
            r1 = move-exception
            goto L_0x0042
        L_0x0035:
            r1 = move-exception
            com.amazonaws.logging.Log r3 = com.amazonaws.logging.LogFactory.getLog((java.lang.Class<?>) r0)     // Catch:{ all -> 0x0033 }
            java.lang.String r4 = "Failed to enable the default metrics"
            r3.warn(r4, r1)     // Catch:{ all -> 0x0033 }
            goto L_0x0030
        L_0x0040:
            monitor-exit(r0)
            return r2
        L_0x0042:
            dirtyEnabling = r2     // Catch:{ all -> 0x004d }
            throw r1     // Catch:{ all -> 0x004d }
        L_0x0045:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException     // Catch:{ all -> 0x004d }
            java.lang.String r2 = "Reentrancy is not allowed"
            r1.<init>(r2)     // Catch:{ all -> 0x004d }
            throw r1     // Catch:{ all -> 0x004d }
        L_0x004d:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.metrics.AwsSdkMetrics.enableDefaultMetrics():boolean");
    }

    public static void disableMetrics() {
        setMetricCollector(MetricCollector.NONE);
    }

    public static boolean add(MetricType metricType) {
        if (metricType == null) {
            return false;
        }
        return REGISTRY.addMetricType(metricType);
    }

    public static <T extends MetricType> boolean addAll(Collection<T> collection) {
        if (collection == null || collection.size() == 0) {
            return false;
        }
        return REGISTRY.addMetricTypes(collection);
    }

    public static <T extends MetricType> void set(Collection<T> collection) {
        REGISTRY.setMetricTypes(collection);
    }

    public static boolean remove(MetricType metricType) {
        if (metricType == null) {
            return false;
        }
        return REGISTRY.removeMetricType(metricType);
    }

    public static Set<MetricType> getPredefinedMetrics() {
        return REGISTRY.predefinedMetrics();
    }

    public static AWSCredentialsProvider getCredentialProvider() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        for (StackTraceElement className : stackTrace) {
            if (className.getClassName().equals(DEFAULT_METRIC_COLLECTOR_FACTORY)) {
                return credentialProvider;
            }
        }
        SecurityException securityException = new SecurityException();
        LogFactory.getLog((Class<?>) AwsSdkMetrics.class).warn("Illegal attempt to access the credential provider", securityException);
        throw securityException;
    }

    public static synchronized void setCredentialProvider(AWSCredentialsProvider aWSCredentialsProvider) {
        synchronized (AwsSdkMetrics.class) {
            credentialProvider = aWSCredentialsProvider;
        }
    }

    public static Regions getRegion() {
        return region;
    }

    public static void setRegion(Regions regions) {
        region = regions;
    }

    public static String getCredentailFile() {
        return credentialFile;
    }

    public static void setCredentialFile(String str) throws IOException {
        setCredentialFile0(str);
    }

    private static void setCredentialFile0(String str) throws IOException {
        final PropertiesCredentials propertiesCredentials = new PropertiesCredentials(new File(str));
        synchronized (AwsSdkMetrics.class) {
            credentialProvider = new AWSCredentialsProvider() {
                public void refresh() {
                }

                public AWSCredentials getCredentials() {
                    return propertiesCredentials;
                }
            };
            credentialFile = str;
        }
    }

    public static Integer getMetricQueueSize() {
        return metricQueueSize;
    }

    public static void setMetricQueueSize(Integer num) {
        metricQueueSize = num;
    }

    public static Long getQueuePollTimeoutMilli() {
        return queuePollTimeoutMilli;
    }

    public static void setQueuePollTimeoutMilli(Long l) {
        queuePollTimeoutMilli = l;
    }

    public static String getMetricNameSpace() {
        return metricNameSpace;
    }

    public static void setMetricNameSpace(String str) {
        if (str == null || str.trim().length() == 0) {
            throw new IllegalArgumentException();
        }
        metricNameSpace = str;
    }

    public static String getJvmMetricName() {
        return jvmMetricName;
    }

    public static void setJvmMetricName(String str) {
        jvmMetricName = str;
    }

    public static String getHostMetricName() {
        return hostMetricName;
    }

    public static void setHostMetricName(String str) {
        hostMetricName = str;
    }

    private static class MetricRegistry {
        private final Set<MetricType> metricTypes;
        private volatile Set<MetricType> readOnly;

        MetricRegistry() {
            HashSet hashSet = new HashSet();
            this.metricTypes = hashSet;
            hashSet.add(AWSRequestMetrics.Field.ClientExecuteTime);
            hashSet.add(AWSRequestMetrics.Field.Exception);
            hashSet.add(AWSRequestMetrics.Field.HttpClientRetryCount);
            hashSet.add(AWSRequestMetrics.Field.HttpRequestTime);
            hashSet.add(AWSRequestMetrics.Field.RequestCount);
            hashSet.add(AWSRequestMetrics.Field.RetryCount);
            hashSet.add(AWSRequestMetrics.Field.HttpClientSendRequestTime);
            hashSet.add(AWSRequestMetrics.Field.HttpClientReceiveResponseTime);
            hashSet.add(AWSServiceMetrics.HttpClientGetConnectionTime);
            syncReadOnly();
        }

        private void syncReadOnly() {
            this.readOnly = Collections.unmodifiableSet(new HashSet(this.metricTypes));
        }

        public boolean addMetricType(MetricType metricType) {
            boolean add;
            synchronized (this.metricTypes) {
                add = this.metricTypes.add(metricType);
                if (add) {
                    syncReadOnly();
                }
            }
            return add;
        }

        public <T extends MetricType> boolean addMetricTypes(Collection<T> collection) {
            boolean addAll;
            synchronized (this.metricTypes) {
                addAll = this.metricTypes.addAll(collection);
                if (addAll) {
                    syncReadOnly();
                }
            }
            return addAll;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:0x002a, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:5:0x0009, code lost:
            if (r3.size() == 0) goto L_0x000b;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public <T extends com.amazonaws.metrics.MetricType> void setMetricTypes(java.util.Collection<T> r3) {
            /*
                r2 = this;
                java.util.Set<com.amazonaws.metrics.MetricType> r0 = r2.metricTypes
                monitor-enter(r0)
                if (r3 == 0) goto L_0x000b
                int r1 = r3.size()     // Catch:{ all -> 0x002b }
                if (r1 != 0) goto L_0x001b
            L_0x000b:
                java.util.Set<com.amazonaws.metrics.MetricType> r1 = r2.metricTypes     // Catch:{ all -> 0x002b }
                int r1 = r1.size()     // Catch:{ all -> 0x002b }
                if (r1 != 0) goto L_0x0015
                monitor-exit(r0)     // Catch:{ all -> 0x002b }
                return
            L_0x0015:
                if (r3 != 0) goto L_0x001b
                java.util.List r3 = java.util.Collections.emptyList()     // Catch:{ all -> 0x002b }
            L_0x001b:
                java.util.Set<com.amazonaws.metrics.MetricType> r1 = r2.metricTypes     // Catch:{ all -> 0x002b }
                r1.clear()     // Catch:{ all -> 0x002b }
                boolean r3 = r2.addMetricTypes(r3)     // Catch:{ all -> 0x002b }
                if (r3 != 0) goto L_0x0029
                r2.syncReadOnly()     // Catch:{ all -> 0x002b }
            L_0x0029:
                monitor-exit(r0)     // Catch:{ all -> 0x002b }
                return
            L_0x002b:
                r3 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x002b }
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.metrics.AwsSdkMetrics.MetricRegistry.setMetricTypes(java.util.Collection):void");
        }

        public boolean removeMetricType(MetricType metricType) {
            boolean remove;
            synchronized (this.metricTypes) {
                remove = this.metricTypes.remove(metricType);
                if (remove) {
                    syncReadOnly();
                }
            }
            return remove;
        }

        public Set<MetricType> predefinedMetrics() {
            return this.readOnly;
        }
    }
}
