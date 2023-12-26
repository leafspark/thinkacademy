package io.flutter.embedding.engine.systemchannels;

import com.tekartik.sqflite.Constant;
import io.flutter.Log;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.StandardMethodCodec;
import java.util.HashMap;
import java.util.Map;

public class RestorationChannel {
    private static final String TAG = "RestorationChannel";
    private MethodChannel channel;
    /* access modifiers changed from: private */
    public boolean engineHasProvidedData;
    /* access modifiers changed from: private */
    public boolean frameworkHasRequestedData;
    private final MethodChannel.MethodCallHandler handler;
    /* access modifiers changed from: private */
    public MethodChannel.Result pendingFrameworkRestorationChannelRequest;
    /* access modifiers changed from: private */
    public byte[] restorationData;
    public final boolean waitForRestorationData;

    public RestorationChannel(DartExecutor dartExecutor, boolean z) {
        this(new MethodChannel(dartExecutor, "flutter/restoration", StandardMethodCodec.INSTANCE), z);
    }

    RestorationChannel(MethodChannel methodChannel, boolean z) {
        this.engineHasProvidedData = false;
        this.frameworkHasRequestedData = false;
        AnonymousClass2 r0 = new MethodChannel.MethodCallHandler() {
            public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
                String str = methodCall.method;
                Object obj = methodCall.arguments;
                str.hashCode();
                if (str.equals("get")) {
                    boolean unused = RestorationChannel.this.frameworkHasRequestedData = true;
                    if (RestorationChannel.this.engineHasProvidedData || !RestorationChannel.this.waitForRestorationData) {
                        RestorationChannel restorationChannel = RestorationChannel.this;
                        result.success(restorationChannel.packageData(restorationChannel.restorationData));
                        return;
                    }
                    MethodChannel.Result unused2 = RestorationChannel.this.pendingFrameworkRestorationChannelRequest = result;
                } else if (!str.equals("put")) {
                    result.notImplemented();
                } else {
                    byte[] unused3 = RestorationChannel.this.restorationData = (byte[]) obj;
                    result.success((Object) null);
                }
            }
        };
        this.handler = r0;
        this.channel = methodChannel;
        this.waitForRestorationData = z;
        methodChannel.setMethodCallHandler(r0);
    }

    public byte[] getRestorationData() {
        return this.restorationData;
    }

    public void setRestorationData(final byte[] bArr) {
        this.engineHasProvidedData = true;
        MethodChannel.Result result = this.pendingFrameworkRestorationChannelRequest;
        if (result != null) {
            result.success(packageData(bArr));
            this.pendingFrameworkRestorationChannelRequest = null;
            this.restorationData = bArr;
        } else if (this.frameworkHasRequestedData) {
            this.channel.invokeMethod("push", packageData(bArr), new MethodChannel.Result() {
                public void notImplemented() {
                }

                public void success(Object obj) {
                    byte[] unused = RestorationChannel.this.restorationData = bArr;
                }

                public void error(String str, String str2, Object obj) {
                    Log.e(RestorationChannel.TAG, "Error " + str + " while sending restoration data to framework: " + str2);
                }
            });
        } else {
            this.restorationData = bArr;
        }
    }

    public void clearData() {
        this.restorationData = null;
    }

    /* access modifiers changed from: private */
    public Map<String, Object> packageData(byte[] bArr) {
        HashMap hashMap = new HashMap();
        hashMap.put("enabled", true);
        hashMap.put(Constant.PARAM_ERROR_DATA, bArr);
        return hashMap;
    }
}
