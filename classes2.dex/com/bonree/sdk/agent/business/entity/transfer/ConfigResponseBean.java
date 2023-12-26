package com.bonree.sdk.agent.business.entity.transfer;

import com.bonree.sdk.common.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConfigResponseBean {
    @SerializedName("cbbk")
    public String[] mCustomBusinessBodyKeys;
    @SerializedName("cbhk")
    public String[] mCustomBusinessHeaderKeys;
    @SerializedName("cbqk")
    public String[] mCustomBusinessQueryKeys;
    @SerializedName("cp")
    public String mCustomerParam;
    @SerializedName("di")
    public String mDeviceIP;
    @SerializedName("gdia")
    public String mGetDeviceIPAddress;
    @SerializedName("gpa")
    public String mGetPingAddress;
    @SerializedName("hcs")
    public int mHeaderCollectionStrategy = 1;
    @SerializedName("mc")
    public List<ModuleConfiguration> mModuleConfiguration;
    @SerializedName("irhtc")
    public NetworkTraceConfig mNetworkTraceConfig;
    @SerializedName("brss")
    public boolean mOpenDataMerge;
    @SerializedName("rct")
    public int mRecoveryCycleTime;
    @SerializedName("reqhtk")
    public String[] mRequestHeaderTraceKeys;
    @SerializedName("rc")
    public int mResponseCode = -1;
    @SerializedName("reshtk")
    public String[] mResponseHeaderTraceKeys;
    @SerializedName("sat")
    public int mSaveTime;
    @SerializedName("st")
    public long mServerTime;
    @SerializedName("s")
    public String mSession;
    @SerializedName("sp")
    public int mStartProbability;
    @SerializedName("spt")
    public int mStartProbabilityTime;
    @SerializedName("trt")
    public int mTraceThreshold;
    @SerializedName("ua")
    public String mUploadAddress;
    @SerializedName("usc")
    public int mUploadScenario;

    public static class NetworkTraceConfig {
        @SerializedName("ubl")
        public List<HostRule> mUrlBlackList;
        @SerializedName("utl")
        public List<RequestHeaderRule> mUrlTotalList;
        @SerializedName("uwl")
        public List<HostRule> mUrlWhiteList;

        public String toString() {
            return "NetworkTraceConfig{mUrlWhiteList=" + this.mUrlWhiteList + ", mUrlBlackList=" + this.mUrlBlackList + ", mUrlTotalList=" + this.mUrlTotalList + '}';
        }

        public static Map toMap(NetworkTraceConfig networkTraceConfig) {
            if (networkTraceConfig == null) {
                return null;
            }
            HashMap hashMap = new HashMap();
            List<HostRule> list = networkTraceConfig.mUrlWhiteList;
            if (list != null && list.size() > 0) {
                hashMap.put("uwl", getRuleList(networkTraceConfig.mUrlWhiteList));
            }
            List<HostRule> list2 = networkTraceConfig.mUrlBlackList;
            if (list2 != null && list2.size() > 0) {
                hashMap.put("ubl", getRuleList(networkTraceConfig.mUrlBlackList));
            }
            HashMap hashMap2 = new HashMap();
            hashMap2.put("networkTraceConfig", hashMap);
            return hashMap2;
        }

        private static List<Map> getRuleList(List<HostRule> list) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                HostRule hostRule = list.get(i);
                if (hostRule != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("r", hostRule.mRule);
                    hashMap.put("t", Integer.valueOf(hostRule.mType));
                    arrayList.add(hashMap);
                }
            }
            return arrayList;
        }
    }

    public static class HostRule {
        public static final transient int RULE_TYPE_0 = 0;
        public static final transient int RULE_TYPE_1 = 1;
        public static final transient int RULE_TYPE_2 = 2;
        public static final transient int RULE_TYPE_3 = 3;
        public static final transient int RULE_TYPE_4 = 4;
        @SerializedName("n")
        public String mName;
        @SerializedName("rhr")
        public List<RequestHeaderRule> mReqHeaderRuleList;
        @SerializedName("r")
        public String mRule;
        @SerializedName("t")
        public int mType;

        public String toString() {
            return "HostRule{mName='" + this.mName + '\'' + ", mType=" + this.mType + ", mRule='" + this.mRule + '\'' + '}';
        }
    }

    public static class RequestHeaderRule {
        public static final transient int REQ_HEADER_RULE_TYPE_1 = 1;
        public static final transient int REQ_HEADER_RULE_TYPE_2 = 2;
        public static final transient int REQ_HEADER_RULE_TYPE_3 = 3;
        public static final transient int REQ_HEADER_RULE_TYPE_4 = 4;
        public static final transient int REQ_HEADER_RULE_TYPE_5 = 5;
        public static final transient int REQ_HEADER_RULE_TYPE_6 = 6;
        @SerializedName("rhk")
        public String reqHeaderKey;
        @SerializedName("rht")
        public int reqHeaderType;
        @SerializedName("rhv")
        public String reqHeaderValue;

        public String toString() {
            return "RequestHeaderRule{reqHeaderKey='" + this.reqHeaderKey + '\'' + ", reqHeaderType=" + this.reqHeaderType + ", reqHeaderValue='" + this.reqHeaderValue + '\'' + '}';
        }
    }

    public static class ModuleConfiguration {
        @SerializedName("ac")
        public ActionAnalyseConfiguration mActionAnalyseConfiguration;
        @SerializedName("c")
        public int mConfiguration;
        @SerializedName("dft")
        public Integer mDropFrameTime;
        @SerializedName("n")
        public String mModuleName;
        @SerializedName("tv")
        public int mThresholdValue;

        public String toString() {
            return "ModuleConfiguration{mModuleName='" + this.mModuleName + '\'' + ", mConfiguration='" + this.mConfiguration + '\'' + ", mThresholdValue='" + this.mThresholdValue + '\'' + ", mDropFrameTime='" + this.mDropFrameTime + '\'' + ", mActionAnalyseConfiguration='" + this.mActionAnalyseConfiguration + '\'' + '}';
        }

        public class ActionAnalyseConfiguration {
            @SerializedName("ac")
            public boolean mActionAnalyse;
            @SerializedName("aot")
            public int mAsynchronousOperationTimeout;
            @SerializedName("cp")
            public int mCollectionProbability;
            @SerializedName("mmd")
            public int mMethodMaxDepth;

            public ActionAnalyseConfiguration() {
            }

            public String toString() {
                return "ActionAnalyseConfiguration{mActionAnalyse=" + this.mActionAnalyse + ", mCollectionProbability=" + this.mCollectionProbability + ", mMethodMaxDepth=" + this.mMethodMaxDepth + ", mAsynchronousOperationTimeout=" + this.mAsynchronousOperationTimeout + '}';
            }
        }
    }

    public String toString() {
        return "ConfigResponseBean{mResponseCode=" + this.mResponseCode + ", mSession='" + this.mSession + '\'' + ", mServerTime=" + this.mServerTime + ", mRecoveryCycleTime=" + this.mRecoveryCycleTime + ", mSaveTime=" + this.mSaveTime + ", mUploadAddress='" + this.mUploadAddress + '\'' + ", mDeviceIP='" + this.mDeviceIP + '\'' + ", mGetDeviceIPAddress='" + this.mGetDeviceIPAddress + '\'' + ", mGetPingAddress='" + this.mGetPingAddress + '\'' + ", mStartProbability=" + this.mStartProbability + ", mStartProbabilityTime=" + this.mStartProbabilityTime + ", mOpenDataMerge=" + this.mOpenDataMerge + ", mModuleConfiguration=" + this.mModuleConfiguration + ", mCustomerParam='" + this.mCustomerParam + '\'' + ", mCustomBusinessHeaderKeys='" + Arrays.toString(this.mCustomBusinessHeaderKeys) + '\'' + ", mCustomBusinessBodyKeys='" + Arrays.toString(this.mCustomBusinessBodyKeys) + '\'' + ", mCustomBusinessQueryKeys='" + Arrays.toString(this.mCustomBusinessQueryKeys) + '\'' + ", mResponseHeaderTraceKeys='" + Arrays.toString(this.mResponseHeaderTraceKeys) + '\'' + ", mUploadScenario='" + this.mUploadScenario + '\'' + ", mThresholdValue='" + this.mTraceThreshold + '\'' + ", mHeaderCollectionStrategy='" + this.mHeaderCollectionStrategy + '\'' + '}';
    }
}
