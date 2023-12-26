package io.flutter.embedding.engine.systemchannels;

import com.tekartik.sqflite.Constant;
import io.flutter.Log;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.StandardMethodCodec;
import java.util.HashMap;

public class MouseCursorChannel {
    private static final String TAG = "MouseCursorChannel";
    public final MethodChannel channel;
    /* access modifiers changed from: private */
    public MouseCursorMethodHandler mouseCursorMethodHandler;
    private final MethodChannel.MethodCallHandler parsingMethodCallHandler;

    public interface MouseCursorMethodHandler {
        void activateSystemCursor(String str);
    }

    public MouseCursorChannel(DartExecutor dartExecutor) {
        AnonymousClass1 r0 = new MethodChannel.MethodCallHandler() {
            public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
                if (MouseCursorChannel.this.mouseCursorMethodHandler != null) {
                    String str = methodCall.method;
                    Log.v(MouseCursorChannel.TAG, "Received '" + str + "' message.");
                    char c = 65535;
                    try {
                        if (str.hashCode() == -1307105544) {
                            if (str.equals("activateSystemCursor")) {
                                c = 0;
                            }
                        }
                        if (c == 0) {
                            try {
                                MouseCursorChannel.this.mouseCursorMethodHandler.activateSystemCursor((String) ((HashMap) methodCall.arguments).get("kind"));
                                result.success(true);
                            } catch (Exception e) {
                                result.error(Constant.PARAM_ERROR, "Error when setting cursors: " + e.getMessage(), (Object) null);
                            }
                        }
                    } catch (Exception e2) {
                        result.error(Constant.PARAM_ERROR, "Unhandled error: " + e2.getMessage(), (Object) null);
                    }
                }
            }
        };
        this.parsingMethodCallHandler = r0;
        MethodChannel methodChannel = new MethodChannel(dartExecutor, "flutter/mousecursor", StandardMethodCodec.INSTANCE);
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(r0);
    }

    public void setMethodHandler(MouseCursorMethodHandler mouseCursorMethodHandler2) {
        this.mouseCursorMethodHandler = mouseCursorMethodHandler2;
    }

    public void synthesizeMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        this.parsingMethodCallHandler.onMethodCall(methodCall, result);
    }
}
