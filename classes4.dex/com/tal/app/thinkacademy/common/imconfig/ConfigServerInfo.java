package com.tal.app.thinkacademy.common.imconfig;

import java.io.Serializable;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u0012B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0013"}, d2 = {"Lcom/tal/app/thinkacademy/common/imconfig/ConfigServerInfo;", "Ljava/io/Serializable;", "entries", "Lcom/tal/app/thinkacademy/common/imconfig/ConfigServerInfo$Servers;", "(Lcom/tal/app/thinkacademy/common/imconfig/ConfigServerInfo$Servers;)V", "getEntries", "()Lcom/tal/app/thinkacademy/common/imconfig/ConfigServerInfo$Servers;", "setEntries", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "Servers", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConfigServerInfo.kt */
public final class ConfigServerInfo implements Serializable {
    private Servers entries;

    public static /* synthetic */ ConfigServerInfo copy$default(ConfigServerInfo configServerInfo, Servers servers, int i, Object obj) {
        if ((i & 1) != 0) {
            servers = configServerInfo.entries;
        }
        return configServerInfo.copy(servers);
    }

    public final Servers component1() {
        return this.entries;
    }

    public final ConfigServerInfo copy(Servers servers) {
        Intrinsics.checkNotNullParameter(servers, "entries");
        return new ConfigServerInfo(servers);
    }

    public ConfigServerInfo(Servers servers) {
        Intrinsics.checkNotNullParameter(servers, "entries");
        this.entries = servers;
    }

    public final Servers getEntries() {
        return this.entries;
    }

    public final void setEntries(Servers servers) {
        Intrinsics.checkNotNullParameter(servers, "<set-?>");
        this.entries = servers;
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001:\u0001!B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J1\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0007\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\f¨\u0006\""}, d2 = {"Lcom/tal/app/thinkacademy/common/imconfig/ConfigServerInfo$Servers;", "Ljava/io/Serializable;", "ircServer", "Lcom/tal/app/thinkacademy/common/imconfig/ConfigServerInfo$Servers$IRcProperty;", "liveClass", "", "overseaApi", "h5Domain", "(Lcom/tal/app/thinkacademy/common/imconfig/ConfigServerInfo$Servers$IRcProperty;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getH5Domain", "()Ljava/lang/String;", "setH5Domain", "(Ljava/lang/String;)V", "getIrcServer", "()Lcom/tal/app/thinkacademy/common/imconfig/ConfigServerInfo$Servers$IRcProperty;", "setIrcServer", "(Lcom/tal/app/thinkacademy/common/imconfig/ConfigServerInfo$Servers$IRcProperty;)V", "getLiveClass", "setLiveClass", "getOverseaApi", "setOverseaApi", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "IRcProperty", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ConfigServerInfo.kt */
    public static final class Servers implements Serializable {
        private String h5Domain;
        private IRcProperty ircServer;
        private String liveClass;
        private String overseaApi;

        public static /* synthetic */ Servers copy$default(Servers servers, IRcProperty iRcProperty, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                iRcProperty = servers.ircServer;
            }
            if ((i & 2) != 0) {
                str = servers.liveClass;
            }
            if ((i & 4) != 0) {
                str2 = servers.overseaApi;
            }
            if ((i & 8) != 0) {
                str3 = servers.h5Domain;
            }
            return servers.copy(iRcProperty, str, str2, str3);
        }

        public final IRcProperty component1() {
            return this.ircServer;
        }

        public final String component2() {
            return this.liveClass;
        }

        public final String component3() {
            return this.overseaApi;
        }

        public final String component4() {
            return this.h5Domain;
        }

        public final Servers copy(IRcProperty iRcProperty, String str, String str2, String str3) {
            Intrinsics.checkNotNullParameter(iRcProperty, "ircServer");
            Intrinsics.checkNotNullParameter(str, "liveClass");
            Intrinsics.checkNotNullParameter(str2, "overseaApi");
            Intrinsics.checkNotNullParameter(str3, "h5Domain");
            return new Servers(iRcProperty, str, str2, str3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Servers)) {
                return false;
            }
            Servers servers = (Servers) obj;
            return Intrinsics.areEqual(this.ircServer, servers.ircServer) && Intrinsics.areEqual(this.liveClass, servers.liveClass) && Intrinsics.areEqual(this.overseaApi, servers.overseaApi) && Intrinsics.areEqual(this.h5Domain, servers.h5Domain);
        }

        public int hashCode() {
            return (((((this.ircServer.hashCode() * 31) + this.liveClass.hashCode()) * 31) + this.overseaApi.hashCode()) * 31) + this.h5Domain.hashCode();
        }

        public String toString() {
            return "Servers(ircServer=" + this.ircServer + ", liveClass=" + this.liveClass + ", overseaApi=" + this.overseaApi + ", h5Domain=" + this.h5Domain + ')';
        }

        public Servers(IRcProperty iRcProperty, String str, String str2, String str3) {
            Intrinsics.checkNotNullParameter(iRcProperty, "ircServer");
            Intrinsics.checkNotNullParameter(str, "liveClass");
            Intrinsics.checkNotNullParameter(str2, "overseaApi");
            Intrinsics.checkNotNullParameter(str3, "h5Domain");
            this.ircServer = iRcProperty;
            this.liveClass = str;
            this.overseaApi = str2;
            this.h5Domain = str3;
        }

        public final IRcProperty getIrcServer() {
            return this.ircServer;
        }

        public final void setIrcServer(IRcProperty iRcProperty) {
            Intrinsics.checkNotNullParameter(iRcProperty, "<set-?>");
            this.ircServer = iRcProperty;
        }

        public final String getLiveClass() {
            return this.liveClass;
        }

        public final void setLiveClass(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.liveClass = str;
        }

        public final String getOverseaApi() {
            return this.overseaApi;
        }

        public final void setOverseaApi(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.overseaApi = str;
        }

        public final String getH5Domain() {
            return this.h5Domain;
        }

        public final void setH5Domain(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.h5Domain = str;
        }

        @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001:\u0002,-BA\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\bHÆ\u0003JQ\u0010$\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(HÖ\u0003J\t\u0010)\u001a\u00020*HÖ\u0001J\t\u0010+\u001a\u00020\bHÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR\u001c\u0010\t\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015R\u001c\u0010\n\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006."}, d2 = {"Lcom/tal/app/thinkacademy/common/imconfig/ConfigServerInfo$Servers$IRcProperty;", "Ljava/io/Serializable;", "confService", "Lcom/tal/app/thinkacademy/common/imconfig/ConfigServerInfo$Servers$IRcProperty$ConfService;", "confServiceV3", "logService", "Lcom/tal/app/thinkacademy/common/imconfig/ConfigServerInfo$Servers$IRcProperty$LogService;", "location", "", "ircLocation", "locationV3", "(Lcom/tal/app/thinkacademy/common/imconfig/ConfigServerInfo$Servers$IRcProperty$ConfService;Lcom/tal/app/thinkacademy/common/imconfig/ConfigServerInfo$Servers$IRcProperty$ConfService;Lcom/tal/app/thinkacademy/common/imconfig/ConfigServerInfo$Servers$IRcProperty$LogService;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getConfService", "()Lcom/tal/app/thinkacademy/common/imconfig/ConfigServerInfo$Servers$IRcProperty$ConfService;", "setConfService", "(Lcom/tal/app/thinkacademy/common/imconfig/ConfigServerInfo$Servers$IRcProperty$ConfService;)V", "getConfServiceV3", "setConfServiceV3", "getIrcLocation", "()Ljava/lang/String;", "setIrcLocation", "(Ljava/lang/String;)V", "getLocation", "setLocation", "getLocationV3", "setLocationV3", "getLogService", "()Lcom/tal/app/thinkacademy/common/imconfig/ConfigServerInfo$Servers$IRcProperty$LogService;", "setLogService", "(Lcom/tal/app/thinkacademy/common/imconfig/ConfigServerInfo$Servers$IRcProperty$LogService;)V", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ConfService", "LogService", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: ConfigServerInfo.kt */
        public static final class IRcProperty implements Serializable {
            private ConfService confService;
            private ConfService confServiceV3;
            private String ircLocation;
            private String location;
            private String locationV3;
            private LogService logService;

            public static /* synthetic */ IRcProperty copy$default(IRcProperty iRcProperty, ConfService confService2, ConfService confService3, LogService logService2, String str, String str2, String str3, int i, Object obj) {
                if ((i & 1) != 0) {
                    confService2 = iRcProperty.confService;
                }
                if ((i & 2) != 0) {
                    confService3 = iRcProperty.confServiceV3;
                }
                ConfService confService4 = confService3;
                if ((i & 4) != 0) {
                    logService2 = iRcProperty.logService;
                }
                LogService logService3 = logService2;
                if ((i & 8) != 0) {
                    str = iRcProperty.location;
                }
                String str4 = str;
                if ((i & 16) != 0) {
                    str2 = iRcProperty.ircLocation;
                }
                String str5 = str2;
                if ((i & 32) != 0) {
                    str3 = iRcProperty.locationV3;
                }
                return iRcProperty.copy(confService2, confService4, logService3, str4, str5, str3);
            }

            public final ConfService component1() {
                return this.confService;
            }

            public final ConfService component2() {
                return this.confServiceV3;
            }

            public final LogService component3() {
                return this.logService;
            }

            public final String component4() {
                return this.location;
            }

            public final String component5() {
                return this.ircLocation;
            }

            public final String component6() {
                return this.locationV3;
            }

            public final IRcProperty copy(ConfService confService2, ConfService confService3, LogService logService2, String str, String str2, String str3) {
                return new IRcProperty(confService2, confService3, logService2, str, str2, str3);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof IRcProperty)) {
                    return false;
                }
                IRcProperty iRcProperty = (IRcProperty) obj;
                return Intrinsics.areEqual(this.confService, iRcProperty.confService) && Intrinsics.areEqual(this.confServiceV3, iRcProperty.confServiceV3) && Intrinsics.areEqual(this.logService, iRcProperty.logService) && Intrinsics.areEqual(this.location, iRcProperty.location) && Intrinsics.areEqual(this.ircLocation, iRcProperty.ircLocation) && Intrinsics.areEqual(this.locationV3, iRcProperty.locationV3);
            }

            public int hashCode() {
                ConfService confService2 = this.confService;
                int i = 0;
                int hashCode = (confService2 == null ? 0 : confService2.hashCode()) * 31;
                ConfService confService3 = this.confServiceV3;
                int hashCode2 = (hashCode + (confService3 == null ? 0 : confService3.hashCode())) * 31;
                LogService logService2 = this.logService;
                int hashCode3 = (hashCode2 + (logService2 == null ? 0 : logService2.hashCode())) * 31;
                String str = this.location;
                int hashCode4 = (hashCode3 + (str == null ? 0 : str.hashCode())) * 31;
                String str2 = this.ircLocation;
                int hashCode5 = (hashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
                String str3 = this.locationV3;
                if (str3 != null) {
                    i = str3.hashCode();
                }
                return hashCode5 + i;
            }

            public String toString() {
                return "IRcProperty(confService=" + this.confService + ", confServiceV3=" + this.confServiceV3 + ", logService=" + this.logService + ", location=" + this.location + ", ircLocation=" + this.ircLocation + ", locationV3=" + this.locationV3 + ')';
            }

            public IRcProperty(ConfService confService2, ConfService confService3, LogService logService2, String str, String str2, String str3) {
                this.confService = confService2;
                this.confServiceV3 = confService3;
                this.logService = logService2;
                this.location = str;
                this.ircLocation = str2;
                this.locationV3 = str3;
            }

            public final ConfService getConfService() {
                return this.confService;
            }

            public final void setConfService(ConfService confService2) {
                this.confService = confService2;
            }

            public final ConfService getConfServiceV3() {
                return this.confServiceV3;
            }

            public final void setConfServiceV3(ConfService confService2) {
                this.confServiceV3 = confService2;
            }

            public final LogService getLogService() {
                return this.logService;
            }

            public final void setLogService(LogService logService2) {
                this.logService = logService2;
            }

            public final String getLocation() {
                return this.location;
            }

            public final void setLocation(String str) {
                this.location = str;
            }

            public final String getIrcLocation() {
                return this.ircLocation;
            }

            public final void setIrcLocation(String str) {
                this.ircLocation = str;
            }

            public final String getLocationV3() {
                return this.locationV3;
            }

            public final void setLocationV3(String str) {
                this.locationV3 = str;
            }

            @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\bHÆ\u0003J;\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\bHÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\rR\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\r¨\u0006$"}, d2 = {"Lcom/tal/app/thinkacademy/common/imconfig/ConfigServerInfo$Servers$IRcProperty$ConfService;", "Ljava/io/Serializable;", "protocol", "", "hostname", "backupIp", "url", "port", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getBackupIp", "()Ljava/lang/String;", "setBackupIp", "(Ljava/lang/String;)V", "getHostname", "setHostname", "getPort", "()I", "setPort", "(I)V", "getProtocol", "setProtocol", "getUrl", "setUrl", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
            /* compiled from: ConfigServerInfo.kt */
            public static final class ConfService implements Serializable {
                private String backupIp;
                private String hostname;
                private int port;
                private String protocol;
                private String url;

                public static /* synthetic */ ConfService copy$default(ConfService confService, String str, String str2, String str3, String str4, int i, int i2, Object obj) {
                    if ((i2 & 1) != 0) {
                        str = confService.protocol;
                    }
                    if ((i2 & 2) != 0) {
                        str2 = confService.hostname;
                    }
                    String str5 = str2;
                    if ((i2 & 4) != 0) {
                        str3 = confService.backupIp;
                    }
                    String str6 = str3;
                    if ((i2 & 8) != 0) {
                        str4 = confService.url;
                    }
                    String str7 = str4;
                    if ((i2 & 16) != 0) {
                        i = confService.port;
                    }
                    return confService.copy(str, str5, str6, str7, i);
                }

                public final String component1() {
                    return this.protocol;
                }

                public final String component2() {
                    return this.hostname;
                }

                public final String component3() {
                    return this.backupIp;
                }

                public final String component4() {
                    return this.url;
                }

                public final int component5() {
                    return this.port;
                }

                public final ConfService copy(String str, String str2, String str3, String str4, int i) {
                    Intrinsics.checkNotNullParameter(str, "protocol");
                    Intrinsics.checkNotNullParameter(str2, "hostname");
                    Intrinsics.checkNotNullParameter(str3, "backupIp");
                    Intrinsics.checkNotNullParameter(str4, "url");
                    return new ConfService(str, str2, str3, str4, i);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof ConfService)) {
                        return false;
                    }
                    ConfService confService = (ConfService) obj;
                    return Intrinsics.areEqual(this.protocol, confService.protocol) && Intrinsics.areEqual(this.hostname, confService.hostname) && Intrinsics.areEqual(this.backupIp, confService.backupIp) && Intrinsics.areEqual(this.url, confService.url) && this.port == confService.port;
                }

                public int hashCode() {
                    return (((((((this.protocol.hashCode() * 31) + this.hostname.hashCode()) * 31) + this.backupIp.hashCode()) * 31) + this.url.hashCode()) * 31) + this.port;
                }

                public String toString() {
                    return "ConfService(protocol=" + this.protocol + ", hostname=" + this.hostname + ", backupIp=" + this.backupIp + ", url=" + this.url + ", port=" + this.port + ')';
                }

                public ConfService(String str, String str2, String str3, String str4, int i) {
                    Intrinsics.checkNotNullParameter(str, "protocol");
                    Intrinsics.checkNotNullParameter(str2, "hostname");
                    Intrinsics.checkNotNullParameter(str3, "backupIp");
                    Intrinsics.checkNotNullParameter(str4, "url");
                    this.protocol = str;
                    this.hostname = str2;
                    this.backupIp = str3;
                    this.url = str4;
                    this.port = i;
                }

                public final String getProtocol() {
                    return this.protocol;
                }

                public final void setProtocol(String str) {
                    Intrinsics.checkNotNullParameter(str, "<set-?>");
                    this.protocol = str;
                }

                public final String getHostname() {
                    return this.hostname;
                }

                public final void setHostname(String str) {
                    Intrinsics.checkNotNullParameter(str, "<set-?>");
                    this.hostname = str;
                }

                public final String getBackupIp() {
                    return this.backupIp;
                }

                public final void setBackupIp(String str) {
                    Intrinsics.checkNotNullParameter(str, "<set-?>");
                    this.backupIp = str;
                }

                public final String getUrl() {
                    return this.url;
                }

                public final void setUrl(String str) {
                    Intrinsics.checkNotNullParameter(str, "<set-?>");
                    this.url = str;
                }

                public final int getPort() {
                    return this.port;
                }

                public final void setPort(int i) {
                    this.port = i;
                }
            }

            @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\bHÆ\u0003J;\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\bHÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\rR\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\r¨\u0006$"}, d2 = {"Lcom/tal/app/thinkacademy/common/imconfig/ConfigServerInfo$Servers$IRcProperty$LogService;", "Ljava/io/Serializable;", "protocol", "", "hostname", "backupIp", "url", "port", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getBackupIp", "()Ljava/lang/String;", "setBackupIp", "(Ljava/lang/String;)V", "getHostname", "setHostname", "getPort", "()I", "setPort", "(I)V", "getProtocol", "setProtocol", "getUrl", "setUrl", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
            /* compiled from: ConfigServerInfo.kt */
            public static final class LogService implements Serializable {
                private String backupIp;
                private String hostname;
                private int port;
                private String protocol;
                private String url;

                public static /* synthetic */ LogService copy$default(LogService logService, String str, String str2, String str3, String str4, int i, int i2, Object obj) {
                    if ((i2 & 1) != 0) {
                        str = logService.protocol;
                    }
                    if ((i2 & 2) != 0) {
                        str2 = logService.hostname;
                    }
                    String str5 = str2;
                    if ((i2 & 4) != 0) {
                        str3 = logService.backupIp;
                    }
                    String str6 = str3;
                    if ((i2 & 8) != 0) {
                        str4 = logService.url;
                    }
                    String str7 = str4;
                    if ((i2 & 16) != 0) {
                        i = logService.port;
                    }
                    return logService.copy(str, str5, str6, str7, i);
                }

                public final String component1() {
                    return this.protocol;
                }

                public final String component2() {
                    return this.hostname;
                }

                public final String component3() {
                    return this.backupIp;
                }

                public final String component4() {
                    return this.url;
                }

                public final int component5() {
                    return this.port;
                }

                public final LogService copy(String str, String str2, String str3, String str4, int i) {
                    Intrinsics.checkNotNullParameter(str, "protocol");
                    Intrinsics.checkNotNullParameter(str2, "hostname");
                    Intrinsics.checkNotNullParameter(str3, "backupIp");
                    Intrinsics.checkNotNullParameter(str4, "url");
                    return new LogService(str, str2, str3, str4, i);
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof LogService)) {
                        return false;
                    }
                    LogService logService = (LogService) obj;
                    return Intrinsics.areEqual(this.protocol, logService.protocol) && Intrinsics.areEqual(this.hostname, logService.hostname) && Intrinsics.areEqual(this.backupIp, logService.backupIp) && Intrinsics.areEqual(this.url, logService.url) && this.port == logService.port;
                }

                public int hashCode() {
                    return (((((((this.protocol.hashCode() * 31) + this.hostname.hashCode()) * 31) + this.backupIp.hashCode()) * 31) + this.url.hashCode()) * 31) + this.port;
                }

                public String toString() {
                    return "LogService(protocol=" + this.protocol + ", hostname=" + this.hostname + ", backupIp=" + this.backupIp + ", url=" + this.url + ", port=" + this.port + ')';
                }

                public LogService(String str, String str2, String str3, String str4, int i) {
                    Intrinsics.checkNotNullParameter(str, "protocol");
                    Intrinsics.checkNotNullParameter(str2, "hostname");
                    Intrinsics.checkNotNullParameter(str3, "backupIp");
                    Intrinsics.checkNotNullParameter(str4, "url");
                    this.protocol = str;
                    this.hostname = str2;
                    this.backupIp = str3;
                    this.url = str4;
                    this.port = i;
                }

                public final String getProtocol() {
                    return this.protocol;
                }

                public final void setProtocol(String str) {
                    Intrinsics.checkNotNullParameter(str, "<set-?>");
                    this.protocol = str;
                }

                public final String getHostname() {
                    return this.hostname;
                }

                public final void setHostname(String str) {
                    Intrinsics.checkNotNullParameter(str, "<set-?>");
                    this.hostname = str;
                }

                public final String getBackupIp() {
                    return this.backupIp;
                }

                public final void setBackupIp(String str) {
                    Intrinsics.checkNotNullParameter(str, "<set-?>");
                    this.backupIp = str;
                }

                public final String getUrl() {
                    return this.url;
                }

                public final void setUrl(String str) {
                    Intrinsics.checkNotNullParameter(str, "<set-?>");
                    this.url = str;
                }

                public final int getPort() {
                    return this.port;
                }

                public final void setPort(int i) {
                    this.port = i;
                }
            }
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual(getClass(), obj == null ? null : obj.getClass())) {
            return false;
        }
        Objects.requireNonNull(obj, "null cannot be cast to non-null type com.tal.app.thinkacademy.common.imconfig.ConfigServerInfo");
        return this.entries.equals(((ConfigServerInfo) obj).entries);
    }

    public int hashCode() {
        return this.entries.hashCode();
    }

    public String toString() {
        return super.toString();
    }
}
