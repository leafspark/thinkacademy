package com.tal.app.thinkacademy;

import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import com.tal.app.thinkacademy.business.study.study.speaker.ClassParamsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0005\b\b\u0018\u00002\u00020\u0001:\u0001&B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001f\u001a\u00020\tHÆ\u0003J;\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\u0007HÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0010\"\u0004\b\u001a\u0010\u0012¨\u0006'"}, d2 = {"Lcom/tal/app/thinkacademy/TestData;", "", "dataVersion", "", "appVersion", "dataEnv", "allData", "", "data", "Lcom/tal/app/thinkacademy/TestData$Data;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILcom/tal/app/thinkacademy/TestData$Data;)V", "getAllData", "()I", "setAllData", "(I)V", "getAppVersion", "()Ljava/lang/String;", "setAppVersion", "(Ljava/lang/String;)V", "getData", "()Lcom/tal/app/thinkacademy/TestData$Data;", "setData", "(Lcom/tal/app/thinkacademy/TestData$Data;)V", "getDataEnv", "setDataEnv", "getDataVersion", "setDataVersion", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "Data", "app_googleRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TestData.kt */
public final class TestData {
    private int allData;
    private String appVersion;
    private Data data;
    private String dataEnv;
    private String dataVersion;

    public static /* synthetic */ TestData copy$default(TestData testData, String str, String str2, String str3, int i, Data data2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = testData.dataVersion;
        }
        if ((i2 & 2) != 0) {
            str2 = testData.appVersion;
        }
        String str4 = str2;
        if ((i2 & 4) != 0) {
            str3 = testData.dataEnv;
        }
        String str5 = str3;
        if ((i2 & 8) != 0) {
            i = testData.allData;
        }
        int i3 = i;
        if ((i2 & 16) != 0) {
            data2 = testData.data;
        }
        return testData.copy(str, str4, str5, i3, data2);
    }

    public final String component1() {
        return this.dataVersion;
    }

    public final String component2() {
        return this.appVersion;
    }

    public final String component3() {
        return this.dataEnv;
    }

    public final int component4() {
        return this.allData;
    }

    public final Data component5() {
        return this.data;
    }

    public final TestData copy(String str, String str2, String str3, int i, Data data2) {
        Intrinsics.checkNotNullParameter(str, "dataVersion");
        Intrinsics.checkNotNullParameter(str2, "appVersion");
        Intrinsics.checkNotNullParameter(str3, "dataEnv");
        Intrinsics.checkNotNullParameter(data2, DbParams.KEY_DATA);
        return new TestData(str, str2, str3, i, data2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TestData)) {
            return false;
        }
        TestData testData = (TestData) obj;
        return Intrinsics.areEqual((Object) this.dataVersion, (Object) testData.dataVersion) && Intrinsics.areEqual((Object) this.appVersion, (Object) testData.appVersion) && Intrinsics.areEqual((Object) this.dataEnv, (Object) testData.dataEnv) && this.allData == testData.allData && Intrinsics.areEqual((Object) this.data, (Object) testData.data);
    }

    public int hashCode() {
        return (((((((this.dataVersion.hashCode() * 31) + this.appVersion.hashCode()) * 31) + this.dataEnv.hashCode()) * 31) + this.allData) * 31) + this.data.hashCode();
    }

    public String toString() {
        return "TestData(dataVersion=" + this.dataVersion + ", appVersion=" + this.appVersion + ", dataEnv=" + this.dataEnv + ", allData=" + this.allData + ", data=" + this.data + ')';
    }

    public TestData(String str, String str2, String str3, int i, Data data2) {
        Intrinsics.checkNotNullParameter(str, "dataVersion");
        Intrinsics.checkNotNullParameter(str2, "appVersion");
        Intrinsics.checkNotNullParameter(str3, "dataEnv");
        Intrinsics.checkNotNullParameter(data2, DbParams.KEY_DATA);
        this.dataVersion = str;
        this.appVersion = str2;
        this.dataEnv = str3;
        this.allData = i;
        this.data = data2;
    }

    public final String getDataVersion() {
        return this.dataVersion;
    }

    public final void setDataVersion(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.dataVersion = str;
    }

    public final String getAppVersion() {
        return this.appVersion;
    }

    public final void setAppVersion(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.appVersion = str;
    }

    public final String getDataEnv() {
        return this.dataEnv;
    }

    public final void setDataEnv(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.dataEnv = str;
    }

    public final int getAllData() {
        return this.allData;
    }

    public final void setAllData(int i) {
        this.allData = i;
    }

    public final Data getData() {
        return this.data;
    }

    public final void setData(Data data2) {
        Intrinsics.checkNotNullParameter(data2, "<set-?>");
        this.data = data2;
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u0011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0012"}, d2 = {"Lcom/tal/app/thinkacademy/TestData$Data;", "", "monitor", "Lcom/tal/app/thinkacademy/TestData$Data$Monitor;", "(Lcom/tal/app/thinkacademy/TestData$Data$Monitor;)V", "getMonitor", "()Lcom/tal/app/thinkacademy/TestData$Data$Monitor;", "setMonitor", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Monitor", "app_googleRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: TestData.kt */
    public static final class Data {
        private Monitor monitor;

        public static /* synthetic */ Data copy$default(Data data, Monitor monitor2, int i, Object obj) {
            if ((i & 1) != 0) {
                monitor2 = data.monitor;
            }
            return data.copy(monitor2);
        }

        public final Monitor component1() {
            return this.monitor;
        }

        public final Data copy(Monitor monitor2) {
            Intrinsics.checkNotNullParameter(monitor2, "monitor");
            return new Data(monitor2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Data) && Intrinsics.areEqual((Object) this.monitor, (Object) ((Data) obj).monitor);
        }

        public int hashCode() {
            return this.monitor.hashCode();
        }

        public String toString() {
            return "Data(monitor=" + this.monitor + ')';
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001:\u0001(B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003JE\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\t\u0010'\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u001a\u0010\b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\u001a\u0010\t\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0007\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000e¨\u0006)"}, d2 = {"Lcom/tal/app/thinkacademy/TestData$Data$Monitor;", "", "appconfigkey", "", "appconfigdesc", "configdata", "Lcom/tal/app/thinkacademy/TestData$Data$Monitor$Configdata;", "updatetime", "appversionbegin", "appversionend", "(Ljava/lang/String;Ljava/lang/String;Lcom/tal/app/thinkacademy/TestData$Data$Monitor$Configdata;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppconfigdesc", "()Ljava/lang/String;", "setAppconfigdesc", "(Ljava/lang/String;)V", "getAppconfigkey", "setAppconfigkey", "getAppversionbegin", "setAppversionbegin", "getAppversionend", "setAppversionend", "getConfigdata", "()Lcom/tal/app/thinkacademy/TestData$Data$Monitor$Configdata;", "setConfigdata", "(Lcom/tal/app/thinkacademy/TestData$Data$Monitor$Configdata;)V", "getUpdatetime", "setUpdatetime", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "Configdata", "app_googleRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: TestData.kt */
        public static final class Monitor {
            private String appconfigdesc;
            private String appconfigkey;
            private String appversionbegin;
            private String appversionend;
            private Configdata configdata;
            private String updatetime;

            public static /* synthetic */ Monitor copy$default(Monitor monitor, String str, String str2, Configdata configdata2, String str3, String str4, String str5, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = monitor.appconfigkey;
                }
                if ((i & 2) != 0) {
                    str2 = monitor.appconfigdesc;
                }
                String str6 = str2;
                if ((i & 4) != 0) {
                    configdata2 = monitor.configdata;
                }
                Configdata configdata3 = configdata2;
                if ((i & 8) != 0) {
                    str3 = monitor.updatetime;
                }
                String str7 = str3;
                if ((i & 16) != 0) {
                    str4 = monitor.appversionbegin;
                }
                String str8 = str4;
                if ((i & 32) != 0) {
                    str5 = monitor.appversionend;
                }
                return monitor.copy(str, str6, configdata3, str7, str8, str5);
            }

            public final String component1() {
                return this.appconfigkey;
            }

            public final String component2() {
                return this.appconfigdesc;
            }

            public final Configdata component3() {
                return this.configdata;
            }

            public final String component4() {
                return this.updatetime;
            }

            public final String component5() {
                return this.appversionbegin;
            }

            public final String component6() {
                return this.appversionend;
            }

            public final Monitor copy(String str, String str2, Configdata configdata2, String str3, String str4, String str5) {
                Intrinsics.checkNotNullParameter(str, "appconfigkey");
                Intrinsics.checkNotNullParameter(str2, "appconfigdesc");
                Intrinsics.checkNotNullParameter(configdata2, "configdata");
                Intrinsics.checkNotNullParameter(str3, "updatetime");
                Intrinsics.checkNotNullParameter(str4, "appversionbegin");
                Intrinsics.checkNotNullParameter(str5, "appversionend");
                return new Monitor(str, str2, configdata2, str3, str4, str5);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Monitor)) {
                    return false;
                }
                Monitor monitor = (Monitor) obj;
                return Intrinsics.areEqual((Object) this.appconfigkey, (Object) monitor.appconfigkey) && Intrinsics.areEqual((Object) this.appconfigdesc, (Object) monitor.appconfigdesc) && Intrinsics.areEqual((Object) this.configdata, (Object) monitor.configdata) && Intrinsics.areEqual((Object) this.updatetime, (Object) monitor.updatetime) && Intrinsics.areEqual((Object) this.appversionbegin, (Object) monitor.appversionbegin) && Intrinsics.areEqual((Object) this.appversionend, (Object) monitor.appversionend);
            }

            public int hashCode() {
                return (((((((((this.appconfigkey.hashCode() * 31) + this.appconfigdesc.hashCode()) * 31) + this.configdata.hashCode()) * 31) + this.updatetime.hashCode()) * 31) + this.appversionbegin.hashCode()) * 31) + this.appversionend.hashCode();
            }

            public String toString() {
                return "Monitor(appconfigkey=" + this.appconfigkey + ", appconfigdesc=" + this.appconfigdesc + ", configdata=" + this.configdata + ", updatetime=" + this.updatetime + ", appversionbegin=" + this.appversionbegin + ", appversionend=" + this.appversionend + ')';
            }

            public Monitor(String str, String str2, Configdata configdata2, String str3, String str4, String str5) {
                Intrinsics.checkNotNullParameter(str, "appconfigkey");
                Intrinsics.checkNotNullParameter(str2, "appconfigdesc");
                Intrinsics.checkNotNullParameter(configdata2, "configdata");
                Intrinsics.checkNotNullParameter(str3, "updatetime");
                Intrinsics.checkNotNullParameter(str4, "appversionbegin");
                Intrinsics.checkNotNullParameter(str5, "appversionend");
                this.appconfigkey = str;
                this.appconfigdesc = str2;
                this.configdata = configdata2;
                this.updatetime = str3;
                this.appversionbegin = str4;
                this.appversionend = str5;
            }

            public final String getAppconfigkey() {
                return this.appconfigkey;
            }

            public final void setAppconfigkey(String str) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.appconfigkey = str;
            }

            public final String getAppconfigdesc() {
                return this.appconfigdesc;
            }

            public final void setAppconfigdesc(String str) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.appconfigdesc = str;
            }

            public final Configdata getConfigdata() {
                return this.configdata;
            }

            public final void setConfigdata(Configdata configdata2) {
                Intrinsics.checkNotNullParameter(configdata2, "<set-?>");
                this.configdata = configdata2;
            }

            public final String getUpdatetime() {
                return this.updatetime;
            }

            public final void setUpdatetime(String str) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.updatetime = str;
            }

            public final String getAppversionbegin() {
                return this.appversionbegin;
            }

            public final void setAppversionbegin(String str) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.appversionbegin = str;
            }

            public final String getAppversionend() {
                return this.appversionend;
            }

            public final void setAppversionend(String str) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.appversionend = str;
            }

            @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/tal/app/thinkacademy/TestData$Data$Monitor$Configdata;", "", "type", "", "data", "(Ljava/lang/String;Ljava/lang/String;)V", "getData", "()Ljava/lang/String;", "setData", "(Ljava/lang/String;)V", "getType", "setType", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_googleRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
            /* compiled from: TestData.kt */
            public static final class Configdata {
                private String data;
                private String type;

                public static /* synthetic */ Configdata copy$default(Configdata configdata, String str, String str2, int i, Object obj) {
                    if ((i & 1) != 0) {
                        str = configdata.type;
                    }
                    if ((i & 2) != 0) {
                        str2 = configdata.data;
                    }
                    return configdata.copy(str, str2);
                }

                public final String component1() {
                    return this.type;
                }

                public final String component2() {
                    return this.data;
                }

                public final Configdata copy(String str, String str2) {
                    Intrinsics.checkNotNullParameter(str, ClassParamsKt.TYPE);
                    Intrinsics.checkNotNullParameter(str2, DbParams.KEY_DATA);
                    return new Configdata(str, str2);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof Configdata)) {
                        return false;
                    }
                    Configdata configdata = (Configdata) obj;
                    return Intrinsics.areEqual((Object) this.type, (Object) configdata.type) && Intrinsics.areEqual((Object) this.data, (Object) configdata.data);
                }

                public int hashCode() {
                    return (this.type.hashCode() * 31) + this.data.hashCode();
                }

                public String toString() {
                    return "Configdata(type=" + this.type + ", data=" + this.data + ')';
                }

                public Configdata(String str, String str2) {
                    Intrinsics.checkNotNullParameter(str, ClassParamsKt.TYPE);
                    Intrinsics.checkNotNullParameter(str2, DbParams.KEY_DATA);
                    this.type = str;
                    this.data = str2;
                }

                public final String getType() {
                    return this.type;
                }

                public final void setType(String str) {
                    Intrinsics.checkNotNullParameter(str, "<set-?>");
                    this.type = str;
                }

                public final String getData() {
                    return this.data;
                }

                public final void setData(String str) {
                    Intrinsics.checkNotNullParameter(str, "<set-?>");
                    this.data = str;
                }
            }
        }

        public Data(Monitor monitor2) {
            Intrinsics.checkNotNullParameter(monitor2, "monitor");
            this.monitor = monitor2;
        }

        public final Monitor getMonitor() {
            return this.monitor;
        }

        public final void setMonitor(Monitor monitor2) {
            Intrinsics.checkNotNullParameter(monitor2, "<set-?>");
            this.monitor = monitor2;
        }
    }
}
