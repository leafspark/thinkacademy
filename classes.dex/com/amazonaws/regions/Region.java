package com.amazonaws.regions;

import com.amazonaws.AmazonWebServiceClient;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentialsProvider;
import java.util.HashMap;
import java.util.Map;

public final class Region {
    private static final String DEFAULT_DOMAIN = "amazonaws.com";
    private final String domain;
    private final Map<String, Boolean> httpSupport = new HashMap();
    private final Map<String, Boolean> httpsSupport = new HashMap();
    private final String name;
    private final Map<String, String> serviceEndpoints = new HashMap();

    Region(String str, String str2) {
        this.name = str;
        if (str2 == null || str2.isEmpty()) {
            this.domain = DEFAULT_DOMAIN;
        } else {
            this.domain = str2;
        }
    }

    public static Region getRegion(Regions regions) {
        return RegionUtils.getRegion(regions.getName());
    }

    public static Region getRegion(String str) {
        return RegionUtils.getRegion(str);
    }

    public String getName() {
        return this.name;
    }

    public String getDomain() {
        return this.domain;
    }

    /* access modifiers changed from: package-private */
    public Map<String, String> getServiceEndpoints() {
        return this.serviceEndpoints;
    }

    /* access modifiers changed from: package-private */
    public Map<String, Boolean> getHttpSupport() {
        return this.httpSupport;
    }

    /* access modifiers changed from: package-private */
    public Map<String, Boolean> getHttpsSupport() {
        return this.httpsSupport;
    }

    public String getServiceEndpoint(String str) {
        return this.serviceEndpoints.get(str);
    }

    public boolean isServiceSupported(String str) {
        return this.serviceEndpoints.containsKey(str);
    }

    public boolean hasHttpsEndpoint(String str) {
        return this.httpsSupport.containsKey(str) && this.httpsSupport.get(str).booleanValue();
    }

    public boolean hasHttpEndpoint(String str) {
        return this.httpSupport.containsKey(str) && this.httpSupport.get(str).booleanValue();
    }

    public <T extends AmazonWebServiceClient> T createClient(Class<T> cls, AWSCredentialsProvider aWSCredentialsProvider, ClientConfiguration clientConfiguration) {
        T t;
        if (aWSCredentialsProvider == null && clientConfiguration == null) {
            try {
                t = (AmazonWebServiceClient) cls.getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Exception e) {
                throw new RuntimeException("Couldn't instantiate instance of " + cls, e);
            }
        } else if (aWSCredentialsProvider == null) {
            t = (AmazonWebServiceClient) cls.getConstructor(new Class[]{ClientConfiguration.class}).newInstance(new Object[]{clientConfiguration});
        } else if (clientConfiguration == null) {
            t = (AmazonWebServiceClient) cls.getConstructor(new Class[]{AWSCredentialsProvider.class}).newInstance(new Object[]{aWSCredentialsProvider});
        } else {
            t = (AmazonWebServiceClient) cls.getConstructor(new Class[]{AWSCredentialsProvider.class, ClientConfiguration.class}).newInstance(new Object[]{aWSCredentialsProvider, clientConfiguration});
        }
        t.setRegion(this);
        return t;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Region)) {
            return false;
        }
        return getName().equals(((Region) obj).getName());
    }

    public int hashCode() {
        return getName().hashCode();
    }

    public String toString() {
        return getName();
    }
}
