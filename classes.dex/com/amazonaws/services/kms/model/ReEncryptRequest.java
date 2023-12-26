package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReEncryptRequest extends AmazonWebServiceRequest implements Serializable {
    private ByteBuffer ciphertextBlob;
    private String destinationEncryptionAlgorithm;
    private Map<String, String> destinationEncryptionContext = new HashMap();
    private String destinationKeyId;
    private List<String> grantTokens = new ArrayList();
    private String sourceEncryptionAlgorithm;
    private Map<String, String> sourceEncryptionContext = new HashMap();
    private String sourceKeyId;

    public ByteBuffer getCiphertextBlob() {
        return this.ciphertextBlob;
    }

    public void setCiphertextBlob(ByteBuffer byteBuffer) {
        this.ciphertextBlob = byteBuffer;
    }

    public ReEncryptRequest withCiphertextBlob(ByteBuffer byteBuffer) {
        this.ciphertextBlob = byteBuffer;
        return this;
    }

    public Map<String, String> getSourceEncryptionContext() {
        return this.sourceEncryptionContext;
    }

    public void setSourceEncryptionContext(Map<String, String> map) {
        this.sourceEncryptionContext = map;
    }

    public ReEncryptRequest withSourceEncryptionContext(Map<String, String> map) {
        this.sourceEncryptionContext = map;
        return this;
    }

    public ReEncryptRequest addSourceEncryptionContextEntry(String str, String str2) {
        if (this.sourceEncryptionContext == null) {
            this.sourceEncryptionContext = new HashMap();
        }
        if (!this.sourceEncryptionContext.containsKey(str)) {
            this.sourceEncryptionContext.put(str, str2);
            return this;
        }
        throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
    }

    public ReEncryptRequest clearSourceEncryptionContextEntries() {
        this.sourceEncryptionContext = null;
        return this;
    }

    public String getSourceKeyId() {
        return this.sourceKeyId;
    }

    public void setSourceKeyId(String str) {
        this.sourceKeyId = str;
    }

    public ReEncryptRequest withSourceKeyId(String str) {
        this.sourceKeyId = str;
        return this;
    }

    public String getDestinationKeyId() {
        return this.destinationKeyId;
    }

    public void setDestinationKeyId(String str) {
        this.destinationKeyId = str;
    }

    public ReEncryptRequest withDestinationKeyId(String str) {
        this.destinationKeyId = str;
        return this;
    }

    public Map<String, String> getDestinationEncryptionContext() {
        return this.destinationEncryptionContext;
    }

    public void setDestinationEncryptionContext(Map<String, String> map) {
        this.destinationEncryptionContext = map;
    }

    public ReEncryptRequest withDestinationEncryptionContext(Map<String, String> map) {
        this.destinationEncryptionContext = map;
        return this;
    }

    public ReEncryptRequest addDestinationEncryptionContextEntry(String str, String str2) {
        if (this.destinationEncryptionContext == null) {
            this.destinationEncryptionContext = new HashMap();
        }
        if (!this.destinationEncryptionContext.containsKey(str)) {
            this.destinationEncryptionContext.put(str, str2);
            return this;
        }
        throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
    }

    public ReEncryptRequest clearDestinationEncryptionContextEntries() {
        this.destinationEncryptionContext = null;
        return this;
    }

    public String getSourceEncryptionAlgorithm() {
        return this.sourceEncryptionAlgorithm;
    }

    public void setSourceEncryptionAlgorithm(String str) {
        this.sourceEncryptionAlgorithm = str;
    }

    public ReEncryptRequest withSourceEncryptionAlgorithm(String str) {
        this.sourceEncryptionAlgorithm = str;
        return this;
    }

    public void setSourceEncryptionAlgorithm(EncryptionAlgorithmSpec encryptionAlgorithmSpec) {
        this.sourceEncryptionAlgorithm = encryptionAlgorithmSpec.toString();
    }

    public ReEncryptRequest withSourceEncryptionAlgorithm(EncryptionAlgorithmSpec encryptionAlgorithmSpec) {
        this.sourceEncryptionAlgorithm = encryptionAlgorithmSpec.toString();
        return this;
    }

    public String getDestinationEncryptionAlgorithm() {
        return this.destinationEncryptionAlgorithm;
    }

    public void setDestinationEncryptionAlgorithm(String str) {
        this.destinationEncryptionAlgorithm = str;
    }

    public ReEncryptRequest withDestinationEncryptionAlgorithm(String str) {
        this.destinationEncryptionAlgorithm = str;
        return this;
    }

    public void setDestinationEncryptionAlgorithm(EncryptionAlgorithmSpec encryptionAlgorithmSpec) {
        this.destinationEncryptionAlgorithm = encryptionAlgorithmSpec.toString();
    }

    public ReEncryptRequest withDestinationEncryptionAlgorithm(EncryptionAlgorithmSpec encryptionAlgorithmSpec) {
        this.destinationEncryptionAlgorithm = encryptionAlgorithmSpec.toString();
        return this;
    }

    public List<String> getGrantTokens() {
        return this.grantTokens;
    }

    public void setGrantTokens(Collection<String> collection) {
        if (collection == null) {
            this.grantTokens = null;
        } else {
            this.grantTokens = new ArrayList(collection);
        }
    }

    public ReEncryptRequest withGrantTokens(String... strArr) {
        if (getGrantTokens() == null) {
            this.grantTokens = new ArrayList(strArr.length);
        }
        for (String add : strArr) {
            this.grantTokens.add(add);
        }
        return this;
    }

    public ReEncryptRequest withGrantTokens(Collection<String> collection) {
        setGrantTokens(collection);
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getCiphertextBlob() != null) {
            sb.append("CiphertextBlob: " + getCiphertextBlob() + ",");
        }
        if (getSourceEncryptionContext() != null) {
            sb.append("SourceEncryptionContext: " + getSourceEncryptionContext() + ",");
        }
        if (getSourceKeyId() != null) {
            sb.append("SourceKeyId: " + getSourceKeyId() + ",");
        }
        if (getDestinationKeyId() != null) {
            sb.append("DestinationKeyId: " + getDestinationKeyId() + ",");
        }
        if (getDestinationEncryptionContext() != null) {
            sb.append("DestinationEncryptionContext: " + getDestinationEncryptionContext() + ",");
        }
        if (getSourceEncryptionAlgorithm() != null) {
            sb.append("SourceEncryptionAlgorithm: " + getSourceEncryptionAlgorithm() + ",");
        }
        if (getDestinationEncryptionAlgorithm() != null) {
            sb.append("DestinationEncryptionAlgorithm: " + getDestinationEncryptionAlgorithm() + ",");
        }
        if (getGrantTokens() != null) {
            sb.append("GrantTokens: " + getGrantTokens());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5 = 0;
        int hashCode = ((getCiphertextBlob() == null ? 0 : getCiphertextBlob().hashCode()) + 31) * 31;
        if (getSourceEncryptionContext() == null) {
            i = 0;
        } else {
            i = getSourceEncryptionContext().hashCode();
        }
        int hashCode2 = (((((hashCode + i) * 31) + (getSourceKeyId() == null ? 0 : getSourceKeyId().hashCode())) * 31) + (getDestinationKeyId() == null ? 0 : getDestinationKeyId().hashCode())) * 31;
        if (getDestinationEncryptionContext() == null) {
            i2 = 0;
        } else {
            i2 = getDestinationEncryptionContext().hashCode();
        }
        int i6 = (hashCode2 + i2) * 31;
        if (getSourceEncryptionAlgorithm() == null) {
            i3 = 0;
        } else {
            i3 = getSourceEncryptionAlgorithm().hashCode();
        }
        int i7 = (i6 + i3) * 31;
        if (getDestinationEncryptionAlgorithm() == null) {
            i4 = 0;
        } else {
            i4 = getDestinationEncryptionAlgorithm().hashCode();
        }
        int i8 = (i7 + i4) * 31;
        if (getGrantTokens() != null) {
            i5 = getGrantTokens().hashCode();
        }
        return i8 + i5;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ReEncryptRequest)) {
            return false;
        }
        ReEncryptRequest reEncryptRequest = (ReEncryptRequest) obj;
        if ((reEncryptRequest.getCiphertextBlob() == null) ^ (getCiphertextBlob() == null)) {
            return false;
        }
        if (reEncryptRequest.getCiphertextBlob() != null && !reEncryptRequest.getCiphertextBlob().equals(getCiphertextBlob())) {
            return false;
        }
        if ((reEncryptRequest.getSourceEncryptionContext() == null) ^ (getSourceEncryptionContext() == null)) {
            return false;
        }
        if (reEncryptRequest.getSourceEncryptionContext() != null && !reEncryptRequest.getSourceEncryptionContext().equals(getSourceEncryptionContext())) {
            return false;
        }
        if ((reEncryptRequest.getSourceKeyId() == null) ^ (getSourceKeyId() == null)) {
            return false;
        }
        if (reEncryptRequest.getSourceKeyId() != null && !reEncryptRequest.getSourceKeyId().equals(getSourceKeyId())) {
            return false;
        }
        if ((reEncryptRequest.getDestinationKeyId() == null) ^ (getDestinationKeyId() == null)) {
            return false;
        }
        if (reEncryptRequest.getDestinationKeyId() != null && !reEncryptRequest.getDestinationKeyId().equals(getDestinationKeyId())) {
            return false;
        }
        if ((reEncryptRequest.getDestinationEncryptionContext() == null) ^ (getDestinationEncryptionContext() == null)) {
            return false;
        }
        if (reEncryptRequest.getDestinationEncryptionContext() != null && !reEncryptRequest.getDestinationEncryptionContext().equals(getDestinationEncryptionContext())) {
            return false;
        }
        if ((reEncryptRequest.getSourceEncryptionAlgorithm() == null) ^ (getSourceEncryptionAlgorithm() == null)) {
            return false;
        }
        if (reEncryptRequest.getSourceEncryptionAlgorithm() != null && !reEncryptRequest.getSourceEncryptionAlgorithm().equals(getSourceEncryptionAlgorithm())) {
            return false;
        }
        if ((reEncryptRequest.getDestinationEncryptionAlgorithm() == null) ^ (getDestinationEncryptionAlgorithm() == null)) {
            return false;
        }
        if (reEncryptRequest.getDestinationEncryptionAlgorithm() != null && !reEncryptRequest.getDestinationEncryptionAlgorithm().equals(getDestinationEncryptionAlgorithm())) {
            return false;
        }
        if ((reEncryptRequest.getGrantTokens() == null) ^ (getGrantTokens() == null)) {
            return false;
        }
        return reEncryptRequest.getGrantTokens() == null || reEncryptRequest.getGrantTokens().equals(getGrantTokens());
    }
}
