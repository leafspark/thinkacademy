package org.bouncycastle.x509;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import org.apache.commons.io.IOUtils;

public class X509CollectionStoreParameters implements X509StoreParameters {
    private Collection collection;

    public X509CollectionStoreParameters(Collection collection2) {
        Objects.requireNonNull(collection2, "collection cannot be null");
        this.collection = collection2;
    }

    public Object clone() {
        return new X509CollectionStoreParameters(this.collection);
    }

    public Collection getCollection() {
        return new ArrayList(this.collection);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("X509CollectionStoreParameters: [\n");
        stringBuffer.append("  collection: " + this.collection + IOUtils.LINE_SEPARATOR_UNIX);
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}
