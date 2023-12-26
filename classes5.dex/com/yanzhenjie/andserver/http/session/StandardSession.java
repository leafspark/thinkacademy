package com.yanzhenjie.andserver.http.session;

import com.yanzhenjie.andserver.util.Assert;
import com.yanzhenjie.andserver.util.StringUtils;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class StandardSession implements Session {
    private static final String[] EMPTY_ARRAY = new String[0];
    private long createdTime;
    private String id;
    private boolean isNew;
    private boolean isValid;
    private long lastAccessedTime;
    private Map<String, Object> mAttributes = new ConcurrentHashMap();
    private int maxInactiveInterval = -1;

    public void setId(String str) {
        if (!StringUtils.isEmpty(str)) {
            this.id = str;
            return;
        }
        throw new IllegalArgumentException("The id can not be empty or null.");
    }

    public String getId() {
        return this.id;
    }

    public void setCreatedTime(long j) {
        this.createdTime = j;
    }

    public long getCreatedTime() {
        return this.createdTime;
    }

    public void setLastAccessedTime(long j) {
        this.lastAccessedTime = j;
    }

    public long getLastAccessedTime() {
        validate();
        return this.lastAccessedTime;
    }

    public void setMaxInactiveInterval(int i) {
        this.maxInactiveInterval = i;
    }

    public int getMaxInactiveInterval() {
        return this.maxInactiveInterval;
    }

    public Object getAttribute(String str) {
        validate();
        if (str == null) {
            return null;
        }
        return this.mAttributes.get(str);
    }

    public Enumeration<String> getAttributeNames() {
        validate();
        return Collections.enumeration(new HashSet(this.mAttributes.keySet()));
    }

    public void setAttribute(String str, Object obj) {
        validate();
        Assert.notNull(str, "The name cannot be null.");
        if (obj != null) {
            this.mAttributes.put(str, obj);
        }
    }

    public void removeAttribute(String str) {
        validate();
        if (str != null) {
            this.mAttributes.remove(str);
        }
    }

    public void invalidate() {
        validate();
        this.isValid = false;
    }

    public void setNew(boolean z) {
        this.isNew = z;
    }

    public boolean isNew() {
        validate();
        return this.isNew;
    }

    private void validate() {
        if (!isValid()) {
            throw new IllegalStateException("This session is invalid.");
        }
    }

    public void setValid(boolean z) {
        this.isValid = z;
    }

    public boolean isValid() {
        if (!this.isValid) {
            return false;
        }
        if (this.maxInactiveInterval <= 0) {
            this.isValid = true;
        } else if (((int) ((System.currentTimeMillis() - this.lastAccessedTime) / 1000)) >= this.maxInactiveInterval) {
            this.isValid = false;
        }
        return this.isValid;
    }

    public void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(this.id);
        objectOutputStream.writeLong(this.createdTime);
        objectOutputStream.writeLong(this.lastAccessedTime);
        objectOutputStream.writeInt(this.maxInactiveInterval);
        objectOutputStream.writeBoolean(this.isNew);
        objectOutputStream.writeBoolean(this.isValid);
        objectOutputStream.writeInt(this.mAttributes.size());
        for (String str : (String[]) this.mAttributes.keySet().toArray(EMPTY_ARRAY)) {
            Object obj = this.mAttributes.get(str);
            if (obj != null && (obj instanceof Serializable)) {
                objectOutputStream.writeObject(str);
                objectOutputStream.writeObject(obj);
            }
        }
    }

    public void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.id = (String) objectInputStream.readObject();
        this.createdTime = objectInputStream.readLong();
        this.lastAccessedTime = objectInputStream.readLong();
        this.maxInactiveInterval = objectInputStream.readInt();
        this.isNew = objectInputStream.readBoolean();
        this.isValid = objectInputStream.readBoolean();
        int readInt = objectInputStream.readInt();
        for (int i = 0; i < readInt; i++) {
            Object readObject = objectInputStream.readObject();
            this.mAttributes.put((String) objectInputStream.readObject(), readObject);
        }
    }
}
