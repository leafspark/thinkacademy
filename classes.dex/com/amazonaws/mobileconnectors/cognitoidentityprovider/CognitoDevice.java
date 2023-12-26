package com.amazonaws.mobileconnectors.cognitoidentityprovider;

import android.content.Context;
import android.os.Handler;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.exceptions.CognitoInternalErrorException;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.exceptions.CognitoNotAuthorizedException;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.exceptions.CognitoParameterInvalidException;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.GenericHandler;
import com.amazonaws.services.cognitoidentityprovider.model.DeviceType;
import com.amazonaws.services.cognitoidentityprovider.model.ForgetDeviceRequest;
import com.amazonaws.services.cognitoidentityprovider.model.GetDeviceRequest;
import com.amazonaws.services.cognitoidentityprovider.model.GetDeviceResult;
import com.amazonaws.services.cognitoidentityprovider.model.UpdateDeviceStatusRequest;
import com.amazonaws.services.cognitoidentityprovider.model.UpdateDeviceStatusResult;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import java.util.Date;

public class CognitoDevice {
    private static final String DEVICE_NAME_ATTRIBUTE = "device_name";
    private static final String DEVICE_TYPE_NOT_REMEMBERED = "not_remembered";
    private static final String DEVICE_TYPE_REMEMBERED = "remembered";
    /* access modifiers changed from: private */
    public final Context context;
    private final Date createDate;
    private CognitoUserAttributes deviceAttributes;
    private final String deviceKey;
    private Date lastAccessedDate;
    private Date lastModifiedDate;
    /* access modifiers changed from: private */
    public final CognitoUser user;

    public CognitoDevice(String str, CognitoUserAttributes cognitoUserAttributes, Date date, Date date2, Date date3, CognitoUser cognitoUser, Context context2) {
        this.deviceKey = str;
        this.deviceAttributes = cognitoUserAttributes;
        this.createDate = date;
        this.lastModifiedDate = date2;
        this.lastAccessedDate = date3;
        this.user = cognitoUser;
        this.context = context2;
    }

    public CognitoDevice(DeviceType deviceType, CognitoUser cognitoUser, Context context2) {
        this.deviceKey = deviceType.getDeviceKey();
        this.deviceAttributes = new CognitoUserAttributes(deviceType.getDeviceAttributes());
        this.createDate = deviceType.getDeviceCreateDate();
        this.lastModifiedDate = deviceType.getDeviceLastModifiedDate();
        this.lastAccessedDate = deviceType.getDeviceLastModifiedDate();
        this.user = cognitoUser;
        this.context = context2;
    }

    public String getDeviceKey() {
        return this.deviceKey;
    }

    public CognitoUserAttributes getDeviceAttributes() {
        return this.deviceAttributes;
    }

    public String getDeviceAttribute(String str) {
        try {
            return this.deviceAttributes.getAttributes().get(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public String getDeviceName() {
        return getDeviceAttribute(DEVICE_NAME_ATTRIBUTE);
    }

    public Date getCreateDate() {
        return this.createDate;
    }

    public Date getLastModifiedDate() {
        return this.lastModifiedDate;
    }

    public Date getLastAccessedDate() {
        return this.lastAccessedDate;
    }

    public void getDeviceInBackground(final GenericHandler genericHandler) {
        if (genericHandler != null) {
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    Runnable runnable;
                    Handler handler = new Handler(CognitoDevice.this.context.getMainLooper());
                    try {
                        CognitoDevice cognitoDevice = CognitoDevice.this;
                        CognitoDevice.this.updateThis(cognitoDevice.getDeviceInternal(cognitoDevice.user.getCachedSession()).getDevice());
                        runnable = new Runnable() {
                            public void run() {
                                genericHandler.onSuccess();
                            }
                        };
                    } catch (Exception e) {
                        runnable = new Runnable() {
                            public void run() {
                                genericHandler.onFailure(e);
                            }
                        };
                    }
                    if (!(handler instanceof Handler)) {
                        handler.post(runnable);
                    } else {
                        AsynchronousInstrumentation.handlerPost(handler, runnable);
                    }
                }
            });
            if (!(thread instanceof Thread)) {
                thread.start();
            } else {
                AsynchronousInstrumentation.threadStart(thread);
            }
        } else {
            throw new CognitoParameterInvalidException("callback is null");
        }
    }

    public void getDevice(GenericHandler genericHandler) {
        if (genericHandler != null) {
            try {
                updateThis(getDeviceInternal(this.user.getCachedSession()).getDevice());
                genericHandler.onSuccess();
            } catch (Exception e) {
                genericHandler.onFailure(e);
            }
        } else {
            throw new CognitoParameterInvalidException("callback is null");
        }
    }

    public void forgetDeviceInBackground(final GenericHandler genericHandler) {
        if (genericHandler != null) {
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    Runnable runnable;
                    Handler handler = new Handler(CognitoDevice.this.context.getMainLooper());
                    try {
                        CognitoDevice cognitoDevice = CognitoDevice.this;
                        cognitoDevice.forgetDeviceInternal(cognitoDevice.user.getCachedSession());
                        runnable = new Runnable() {
                            public void run() {
                                genericHandler.onSuccess();
                            }
                        };
                    } catch (Exception e) {
                        runnable = new Runnable() {
                            public void run() {
                                genericHandler.onFailure(e);
                            }
                        };
                    }
                    if (!(handler instanceof Handler)) {
                        handler.post(runnable);
                    } else {
                        AsynchronousInstrumentation.handlerPost(handler, runnable);
                    }
                }
            });
            if (!(thread instanceof Thread)) {
                thread.start();
            } else {
                AsynchronousInstrumentation.threadStart(thread);
            }
        } else {
            throw new CognitoParameterInvalidException("callback is null");
        }
    }

    public void forgetDevice(GenericHandler genericHandler) {
        if (genericHandler != null) {
            try {
                forgetDeviceInternal(this.user.getCachedSession());
                genericHandler.onSuccess();
            } catch (Exception e) {
                genericHandler.onFailure(e);
            }
        } else {
            throw new CognitoParameterInvalidException("callback is null");
        }
    }

    public void rememberThisDeviceInBackground(final GenericHandler genericHandler) {
        if (genericHandler != null) {
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    Runnable runnable;
                    Handler handler = new Handler(CognitoDevice.this.context.getMainLooper());
                    try {
                        CognitoDevice cognitoDevice = CognitoDevice.this;
                        UpdateDeviceStatusResult unused = cognitoDevice.updateDeviceStatusInternal(cognitoDevice.user.getCachedSession(), CognitoDevice.DEVICE_TYPE_REMEMBERED);
                        runnable = new Runnable() {
                            public void run() {
                                genericHandler.onSuccess();
                            }
                        };
                    } catch (Exception e) {
                        runnable = new Runnable() {
                            public void run() {
                                genericHandler.onFailure(e);
                            }
                        };
                    }
                    if (!(handler instanceof Handler)) {
                        handler.post(runnable);
                    } else {
                        AsynchronousInstrumentation.handlerPost(handler, runnable);
                    }
                }
            });
            if (!(thread instanceof Thread)) {
                thread.start();
            } else {
                AsynchronousInstrumentation.threadStart(thread);
            }
        } else {
            throw new CognitoParameterInvalidException("callback is null");
        }
    }

    public void rememberThisDevice(GenericHandler genericHandler) {
        if (genericHandler != null) {
            try {
                updateDeviceStatusInternal(this.user.getCachedSession(), DEVICE_TYPE_REMEMBERED);
            } catch (Exception e) {
                genericHandler.onFailure(e);
            }
        } else {
            throw new CognitoParameterInvalidException("callback is null");
        }
    }

    public void doNotRememberThisDeviceInBackground(final GenericHandler genericHandler) {
        if (genericHandler != null) {
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    Runnable runnable;
                    Handler handler = new Handler(CognitoDevice.this.context.getMainLooper());
                    try {
                        CognitoDevice cognitoDevice = CognitoDevice.this;
                        UpdateDeviceStatusResult unused = cognitoDevice.updateDeviceStatusInternal(cognitoDevice.user.getCachedSession(), CognitoDevice.DEVICE_TYPE_NOT_REMEMBERED);
                        runnable = new Runnable() {
                            public void run() {
                                genericHandler.onSuccess();
                            }
                        };
                    } catch (Exception e) {
                        runnable = new Runnable() {
                            public void run() {
                                genericHandler.onFailure(e);
                            }
                        };
                    }
                    if (!(handler instanceof Handler)) {
                        handler.post(runnable);
                    } else {
                        AsynchronousInstrumentation.handlerPost(handler, runnable);
                    }
                }
            });
            if (!(thread instanceof Thread)) {
                thread.start();
            } else {
                AsynchronousInstrumentation.threadStart(thread);
            }
        } else {
            throw new CognitoParameterInvalidException("callback is null");
        }
    }

    public void doNotRememberThisDevice(GenericHandler genericHandler) {
        if (genericHandler != null) {
            try {
                updateDeviceStatusInternal(this.user.getCachedSession(), DEVICE_TYPE_NOT_REMEMBERED);
            } catch (Exception e) {
                genericHandler.onFailure(e);
            }
        } else {
            throw new CognitoParameterInvalidException("callback is null");
        }
    }

    /* access modifiers changed from: private */
    public void forgetDeviceInternal(CognitoUserSession cognitoUserSession) {
        if (cognitoUserSession == null || !cognitoUserSession.isValid()) {
            throw new CognitoNotAuthorizedException("User is not authorized");
        } else if (this.deviceKey != null) {
            ForgetDeviceRequest forgetDeviceRequest = new ForgetDeviceRequest();
            forgetDeviceRequest.setAccessToken(cognitoUserSession.getAccessToken().getJWTToken());
            forgetDeviceRequest.setDeviceKey(this.deviceKey);
            this.user.getCognitoIdentityProviderClient().forgetDevice(forgetDeviceRequest);
        } else {
            throw new CognitoParameterInvalidException("Device key is null");
        }
    }

    /* access modifiers changed from: private */
    public GetDeviceResult getDeviceInternal(CognitoUserSession cognitoUserSession) {
        if (cognitoUserSession == null || !cognitoUserSession.isValid()) {
            throw new CognitoNotAuthorizedException("User is not authorized");
        } else if (this.deviceKey != null) {
            GetDeviceRequest getDeviceRequest = new GetDeviceRequest();
            getDeviceRequest.setAccessToken(cognitoUserSession.getAccessToken().getJWTToken());
            getDeviceRequest.setDeviceKey(this.deviceKey);
            return this.user.getCognitoIdentityProviderClient().getDevice(getDeviceRequest);
        } else {
            throw new CognitoParameterInvalidException("Device key is null");
        }
    }

    /* access modifiers changed from: private */
    public UpdateDeviceStatusResult updateDeviceStatusInternal(CognitoUserSession cognitoUserSession, String str) {
        if (cognitoUserSession == null || !cognitoUserSession.isValid()) {
            throw new CognitoNotAuthorizedException("User is not authorized");
        } else if (this.deviceKey != null) {
            UpdateDeviceStatusRequest updateDeviceStatusRequest = new UpdateDeviceStatusRequest();
            updateDeviceStatusRequest.setAccessToken(cognitoUserSession.getAccessToken().getJWTToken());
            updateDeviceStatusRequest.setDeviceKey(this.deviceKey);
            updateDeviceStatusRequest.setDeviceRememberedStatus(str);
            return this.user.getCognitoIdentityProviderClient().updateDeviceStatus(updateDeviceStatusRequest);
        } else {
            throw new CognitoParameterInvalidException("Device key is invalid");
        }
    }

    /* access modifiers changed from: private */
    public void updateThis(DeviceType deviceType) {
        if (deviceType == null) {
            throw new CognitoInternalErrorException("Service returned null object, this object was not updated");
        } else if (deviceType.getDeviceKey().equals(this.deviceKey)) {
            this.deviceAttributes = new CognitoUserAttributes(deviceType.getDeviceAttributes());
            this.lastModifiedDate = deviceType.getDeviceLastModifiedDate();
            this.lastAccessedDate = deviceType.getDeviceLastModifiedDate();
        } else {
            throw new CognitoInternalErrorException("Service error, this object was not updated");
        }
    }
}
