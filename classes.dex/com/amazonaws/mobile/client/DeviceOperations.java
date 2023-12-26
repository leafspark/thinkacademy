package com.amazonaws.mobile.client;

import com.amazonaws.mobile.client.internal.ReturningRunnable;
import com.amazonaws.mobile.client.results.Device;
import com.amazonaws.mobile.client.results.ListDevicesResult;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoDevice;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserAttributes;
import com.amazonaws.services.cognitoidentityprovider.AmazonCognitoIdentityProvider;
import com.amazonaws.services.cognitoidentityprovider.model.AttributeType;
import com.amazonaws.services.cognitoidentityprovider.model.DeviceRememberedStatusType;
import com.amazonaws.services.cognitoidentityprovider.model.DeviceType;
import com.amazonaws.services.cognitoidentityprovider.model.ForgetDeviceRequest;
import com.amazonaws.services.cognitoidentityprovider.model.GetDeviceRequest;
import com.amazonaws.services.cognitoidentityprovider.model.ListDevicesRequest;
import com.amazonaws.services.cognitoidentityprovider.model.UpdateDeviceStatusRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class DeviceOperations {
    /* access modifiers changed from: private */
    public final AWSMobileClient mobileClient;
    /* access modifiers changed from: private */
    public final AmazonCognitoIdentityProvider userpoolLL;

    DeviceOperations(AWSMobileClient aWSMobileClient, AmazonCognitoIdentityProvider amazonCognitoIdentityProvider) {
        this.mobileClient = aWSMobileClient;
        this.userpoolLL = amazonCognitoIdentityProvider;
    }

    public Device get() throws Exception {
        return _getDevice((String) null).await();
    }

    public void get(Callback<Device> callback) {
        _getDevice((String) null).async(callback);
    }

    public Device get(String str) throws Exception {
        return _getDevice(str).await();
    }

    public void get(String str, Callback<Device> callback) {
        _getDevice(str).async(callback);
    }

    private ReturningRunnable<Device> _getDevice(final String str) {
        return new ReturningRunnable<Device>() {
            public Device run() throws Exception {
                CognitoDevice access$000 = DeviceOperations.this.getCognitoDevice(str);
                GetDeviceRequest getDeviceRequest = new GetDeviceRequest();
                getDeviceRequest.setAccessToken(DeviceOperations.this.mobileClient.getTokens().getAccessToken().getTokenString());
                getDeviceRequest.setDeviceKey(access$000.getDeviceKey());
                return DeviceOperations.this.marshallDeviceTypeToDevice(DeviceOperations.this.userpoolLL.getDevice(getDeviceRequest).getDevice());
            }
        };
    }

    public ListDevicesResult list() throws Exception {
        return _listDevices(60, (String) null).await();
    }

    public void list(Callback<ListDevicesResult> callback) {
        _listDevices(60, (String) null).async(callback);
    }

    public ListDevicesResult list(Integer num, String str) throws Exception {
        return _listDevices(num, str).await();
    }

    public void list(Integer num, String str, Callback<ListDevicesResult> callback) {
        _listDevices(num, str).async(callback);
    }

    private ReturningRunnable<ListDevicesResult> _listDevices(final Integer num, final String str) {
        return new ReturningRunnable<ListDevicesResult>() {
            public ListDevicesResult run() throws Exception {
                ListDevicesRequest listDevicesRequest = new ListDevicesRequest();
                listDevicesRequest.setAccessToken(DeviceOperations.this.mobileClient.getTokens().getAccessToken().getTokenString());
                listDevicesRequest.setLimit(num);
                listDevicesRequest.setPaginationToken(str);
                com.amazonaws.services.cognitoidentityprovider.model.ListDevicesResult listDevices = DeviceOperations.this.userpoolLL.listDevices(listDevicesRequest);
                ArrayList arrayList = new ArrayList(num.intValue());
                for (DeviceType access$300 : listDevices.getDevices()) {
                    arrayList.add(DeviceOperations.this.marshallDeviceTypeToDevice(access$300));
                }
                return new ListDevicesResult(arrayList, listDevices.getPaginationToken());
            }
        };
    }

    /* access modifiers changed from: private */
    public Device marshallDeviceTypeToDevice(DeviceType deviceType) {
        HashMap hashMap = new HashMap();
        for (AttributeType next : deviceType.getDeviceAttributes()) {
            hashMap.put(next.getName(), next.getValue());
        }
        return new Device(deviceType.getDeviceKey(), hashMap, deviceType.getDeviceCreateDate(), deviceType.getDeviceLastModifiedDate(), deviceType.getDeviceLastAuthenticatedDate());
    }

    public void updateStatus(boolean z) throws Exception {
        _rememberDevice((String) null, z).await();
    }

    public void updateStatus(boolean z, Callback<Void> callback) {
        _rememberDevice((String) null, z).async(callback);
    }

    public void updateStatus(String str, boolean z) throws Exception {
        _rememberDevice(str, z).await();
    }

    public void updateStatus(String str, boolean z, Callback<Void> callback) {
        _rememberDevice(str, z).async(callback);
    }

    private ReturningRunnable<Void> _rememberDevice(final String str, final boolean z) {
        return new ReturningRunnable<Void>() {
            public Void run() throws Exception {
                DeviceOperations.this.userpoolLL.updateDeviceStatus(new UpdateDeviceStatusRequest().withAccessToken(DeviceOperations.this.mobileClient.getTokens().getAccessToken().getTokenString()).withDeviceKey(DeviceOperations.this.getCognitoDevice(str).getDeviceKey()).withDeviceRememberedStatus(z ? DeviceRememberedStatusType.Remembered : DeviceRememberedStatusType.Not_remembered));
                return null;
            }
        };
    }

    public void forget() throws Exception {
        _forgetDevice((String) null).await();
    }

    public void forget(Callback<Void> callback) {
        _forgetDevice((String) null).async(callback);
    }

    public void forget(String str) throws Exception {
        _forgetDevice(str).await();
    }

    public void forget(String str, Callback<Void> callback) {
        _forgetDevice(str).async(callback);
    }

    private ReturningRunnable<Void> _forgetDevice(final String str) {
        return new ReturningRunnable<Void>() {
            public Void run() throws Exception {
                DeviceOperations.this.userpoolLL.forgetDevice(new ForgetDeviceRequest().withAccessToken(DeviceOperations.this.mobileClient.getTokens().getAccessToken().getTokenString()).withDeviceKey(DeviceOperations.this.getCognitoDevice(str).getDeviceKey()));
                return null;
            }
        };
    }

    /* access modifiers changed from: private */
    public CognitoDevice getCognitoDevice(String str) {
        if (str == null) {
            str = this.mobileClient.userpool.getCurrentUser().thisDevice().getDeviceKey();
        }
        return new CognitoDevice(str, (CognitoUserAttributes) null, (Date) null, (Date) null, (Date) null, this.mobileClient.userpool.getCurrentUser(), this.mobileClient.mContext);
    }
}
