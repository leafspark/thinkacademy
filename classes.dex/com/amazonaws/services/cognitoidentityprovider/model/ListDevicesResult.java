package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ListDevicesResult implements Serializable {
    private List<DeviceType> devices;
    private String paginationToken;

    public List<DeviceType> getDevices() {
        return this.devices;
    }

    public void setDevices(Collection<DeviceType> collection) {
        if (collection == null) {
            this.devices = null;
        } else {
            this.devices = new ArrayList(collection);
        }
    }

    public ListDevicesResult withDevices(DeviceType... deviceTypeArr) {
        if (getDevices() == null) {
            this.devices = new ArrayList(deviceTypeArr.length);
        }
        for (DeviceType add : deviceTypeArr) {
            this.devices.add(add);
        }
        return this;
    }

    public ListDevicesResult withDevices(Collection<DeviceType> collection) {
        setDevices(collection);
        return this;
    }

    public String getPaginationToken() {
        return this.paginationToken;
    }

    public void setPaginationToken(String str) {
        this.paginationToken = str;
    }

    public ListDevicesResult withPaginationToken(String str) {
        this.paginationToken = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getDevices() != null) {
            sb.append("Devices: " + getDevices() + ",");
        }
        if (getPaginationToken() != null) {
            sb.append("PaginationToken: " + getPaginationToken());
        }
        sb.append("}");
        return sb.toString();
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getDevices() == null ? 0 : getDevices().hashCode()) + 31) * 31;
        if (getPaginationToken() != null) {
            i = getPaginationToken().hashCode();
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ListDevicesResult)) {
            return false;
        }
        ListDevicesResult listDevicesResult = (ListDevicesResult) obj;
        if ((listDevicesResult.getDevices() == null) ^ (getDevices() == null)) {
            return false;
        }
        if (listDevicesResult.getDevices() != null && !listDevicesResult.getDevices().equals(getDevices())) {
            return false;
        }
        if ((listDevicesResult.getPaginationToken() == null) ^ (getPaginationToken() == null)) {
            return false;
        }
        return listDevicesResult.getPaginationToken() == null || listDevicesResult.getPaginationToken().equals(getPaginationToken());
    }
}
