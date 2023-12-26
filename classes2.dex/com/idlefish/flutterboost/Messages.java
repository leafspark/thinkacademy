package com.idlefish.flutterboost;

import android.util.Log;
import com.google.firebase.messaging.Constants;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import io.flutter.plugin.common.StandardMessageCodec;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Messages {

    public interface Result<T> {
        void error(Throwable th);

        void success(T t);
    }

    public static class CommonParams {
        private Map<String, Object> arguments;
        private String key;
        private Boolean opaque;
        private String pageName;
        private String uniqueId;

        public Boolean getOpaque() {
            return this.opaque;
        }

        public void setOpaque(Boolean bool) {
            this.opaque = bool;
        }

        public String getKey() {
            return this.key;
        }

        public void setKey(String str) {
            this.key = str;
        }

        public String getPageName() {
            return this.pageName;
        }

        public void setPageName(String str) {
            this.pageName = str;
        }

        public String getUniqueId() {
            return this.uniqueId;
        }

        public void setUniqueId(String str) {
            this.uniqueId = str;
        }

        public Map<String, Object> getArguments() {
            return this.arguments;
        }

        public void setArguments(Map<String, Object> map) {
            this.arguments = map;
        }

        public static final class Builder {
            private Map<String, Object> arguments;
            private String key;
            private Boolean opaque;
            private String pageName;
            private String uniqueId;

            public Builder setOpaque(Boolean bool) {
                this.opaque = bool;
                return this;
            }

            public Builder setKey(String str) {
                this.key = str;
                return this;
            }

            public Builder setPageName(String str) {
                this.pageName = str;
                return this;
            }

            public Builder setUniqueId(String str) {
                this.uniqueId = str;
                return this;
            }

            public Builder setArguments(Map<String, Object> map) {
                this.arguments = map;
                return this;
            }

            public CommonParams build() {
                CommonParams commonParams = new CommonParams();
                commonParams.setOpaque(this.opaque);
                commonParams.setKey(this.key);
                commonParams.setPageName(this.pageName);
                commonParams.setUniqueId(this.uniqueId);
                commonParams.setArguments(this.arguments);
                return commonParams;
            }
        }

        /* access modifiers changed from: package-private */
        public Map<String, Object> toMap() {
            HashMap hashMap = new HashMap();
            hashMap.put("opaque", this.opaque);
            hashMap.put("key", this.key);
            hashMap.put("pageName", this.pageName);
            hashMap.put("uniqueId", this.uniqueId);
            hashMap.put("arguments", this.arguments);
            return hashMap;
        }

        static CommonParams fromMap(Map<String, Object> map) {
            CommonParams commonParams = new CommonParams();
            commonParams.setOpaque((Boolean) map.get("opaque"));
            commonParams.setKey((String) map.get("key"));
            commonParams.setPageName((String) map.get("pageName"));
            commonParams.setUniqueId((String) map.get("uniqueId"));
            commonParams.setArguments((Map) map.get("arguments"));
            return commonParams;
        }
    }

    public static class StackInfo {
        private Map<String, FlutterContainer> containers;
        private List<String> ids;

        public List<String> getIds() {
            return this.ids;
        }

        public void setIds(List<String> list) {
            this.ids = list;
        }

        public Map<String, FlutterContainer> getContainers() {
            return this.containers;
        }

        public void setContainers(Map<String, FlutterContainer> map) {
            this.containers = map;
        }

        public static final class Builder {
            private Map<String, FlutterContainer> containers;
            private List<String> ids;

            public Builder setIds(List<String> list) {
                this.ids = list;
                return this;
            }

            public Builder setContainers(Map<String, FlutterContainer> map) {
                this.containers = map;
                return this;
            }

            public StackInfo build() {
                StackInfo stackInfo = new StackInfo();
                stackInfo.setIds(this.ids);
                stackInfo.setContainers(this.containers);
                return stackInfo;
            }
        }

        /* access modifiers changed from: package-private */
        public Map<String, Object> toMap() {
            HashMap hashMap = new HashMap();
            hashMap.put("ids", this.ids);
            hashMap.put("containers", this.containers);
            return hashMap;
        }

        static StackInfo fromMap(Map<String, Object> map) {
            StackInfo stackInfo = new StackInfo();
            stackInfo.setIds((List) map.get("ids"));
            stackInfo.setContainers((Map) map.get("containers"));
            return stackInfo;
        }
    }

    public static class FlutterContainer {
        private List<FlutterPage> pages;

        public List<FlutterPage> getPages() {
            return this.pages;
        }

        public void setPages(List<FlutterPage> list) {
            this.pages = list;
        }

        public static final class Builder {
            private List<FlutterPage> pages;

            public Builder setPages(List<FlutterPage> list) {
                this.pages = list;
                return this;
            }

            public FlutterContainer build() {
                FlutterContainer flutterContainer = new FlutterContainer();
                flutterContainer.setPages(this.pages);
                return flutterContainer;
            }
        }

        /* access modifiers changed from: package-private */
        public Map<String, Object> toMap() {
            HashMap hashMap = new HashMap();
            hashMap.put("pages", this.pages);
            return hashMap;
        }

        static FlutterContainer fromMap(Map<String, Object> map) {
            FlutterContainer flutterContainer = new FlutterContainer();
            flutterContainer.setPages((List) map.get("pages"));
            return flutterContainer;
        }
    }

    public static class FlutterPage {
        private Map<String, Object> arguments;
        private String pageName;
        private String uniqueId;
        private Boolean withContainer;

        public Boolean getWithContainer() {
            return this.withContainer;
        }

        public void setWithContainer(Boolean bool) {
            this.withContainer = bool;
        }

        public String getPageName() {
            return this.pageName;
        }

        public void setPageName(String str) {
            this.pageName = str;
        }

        public String getUniqueId() {
            return this.uniqueId;
        }

        public void setUniqueId(String str) {
            this.uniqueId = str;
        }

        public Map<String, Object> getArguments() {
            return this.arguments;
        }

        public void setArguments(Map<String, Object> map) {
            this.arguments = map;
        }

        public static final class Builder {
            private Map<String, Object> arguments;
            private String pageName;
            private String uniqueId;
            private Boolean withContainer;

            public Builder setWithContainer(Boolean bool) {
                this.withContainer = bool;
                return this;
            }

            public Builder setPageName(String str) {
                this.pageName = str;
                return this;
            }

            public Builder setUniqueId(String str) {
                this.uniqueId = str;
                return this;
            }

            public Builder setArguments(Map<String, Object> map) {
                this.arguments = map;
                return this;
            }

            public FlutterPage build() {
                FlutterPage flutterPage = new FlutterPage();
                flutterPage.setWithContainer(this.withContainer);
                flutterPage.setPageName(this.pageName);
                flutterPage.setUniqueId(this.uniqueId);
                flutterPage.setArguments(this.arguments);
                return flutterPage;
            }
        }

        /* access modifiers changed from: package-private */
        public Map<String, Object> toMap() {
            HashMap hashMap = new HashMap();
            hashMap.put("withContainer", this.withContainer);
            hashMap.put("pageName", this.pageName);
            hashMap.put("uniqueId", this.uniqueId);
            hashMap.put("arguments", this.arguments);
            return hashMap;
        }

        static FlutterPage fromMap(Map<String, Object> map) {
            FlutterPage flutterPage = new FlutterPage();
            flutterPage.setWithContainer((Boolean) map.get("withContainer"));
            flutterPage.setPageName((String) map.get("pageName"));
            flutterPage.setUniqueId((String) map.get("uniqueId"));
            flutterPage.setArguments((Map) map.get("arguments"));
            return flutterPage;
        }
    }

    private static class NativeRouterApiCodec extends StandardMessageCodec {
        public static final NativeRouterApiCodec INSTANCE = new NativeRouterApiCodec();

        private NativeRouterApiCodec() {
        }

        /* access modifiers changed from: protected */
        public Object readValueOfType(byte b, ByteBuffer byteBuffer) {
            switch (b) {
                case Byte.MIN_VALUE:
                    return CommonParams.fromMap((Map) readValue(byteBuffer));
                case -127:
                    return FlutterContainer.fromMap((Map) readValue(byteBuffer));
                case -126:
                    return FlutterPage.fromMap((Map) readValue(byteBuffer));
                case -125:
                    return StackInfo.fromMap((Map) readValue(byteBuffer));
                default:
                    return Messages.super.readValueOfType(b, byteBuffer);
            }
        }

        /* access modifiers changed from: protected */
        public void writeValue(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
            if (obj instanceof CommonParams) {
                byteArrayOutputStream.write(128);
                writeValue(byteArrayOutputStream, ((CommonParams) obj).toMap());
            } else if (obj instanceof FlutterContainer) {
                byteArrayOutputStream.write(129);
                writeValue(byteArrayOutputStream, ((FlutterContainer) obj).toMap());
            } else if (obj instanceof FlutterPage) {
                byteArrayOutputStream.write(130);
                writeValue(byteArrayOutputStream, ((FlutterPage) obj).toMap());
            } else if (obj instanceof StackInfo) {
                byteArrayOutputStream.write(131);
                writeValue(byteArrayOutputStream, ((StackInfo) obj).toMap());
            } else {
                Messages.super.writeValue(byteArrayOutputStream, obj);
            }
        }
    }

    public interface NativeRouterApi {
        StackInfo getStackFromHost();

        void popRoute(CommonParams commonParams, Result<Void> result);

        void pushFlutterRoute(CommonParams commonParams);

        void pushNativeRoute(CommonParams commonParams);

        void saveStackToHost(StackInfo stackInfo);

        void sendEventToNative(CommonParams commonParams);

        /* renamed from: com.idlefish.flutterboost.Messages$NativeRouterApi$-CC  reason: invalid class name */
        public final /* synthetic */ class CC {
            public static MessageCodec<Object> getCodec() {
                return NativeRouterApiCodec.INSTANCE;
            }

            public static void setup(BinaryMessenger binaryMessenger, NativeRouterApi nativeRouterApi) {
                BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.NativeRouterApi.pushNativeRoute", getCodec());
                if (nativeRouterApi != null) {
                    basicMessageChannel.setMessageHandler(new Messages$NativeRouterApi$$ExternalSyntheticLambda0(nativeRouterApi));
                } else {
                    basicMessageChannel.setMessageHandler((BasicMessageChannel.MessageHandler) null);
                }
                BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.NativeRouterApi.pushFlutterRoute", getCodec());
                if (nativeRouterApi != null) {
                    basicMessageChannel2.setMessageHandler(new Messages$NativeRouterApi$$ExternalSyntheticLambda1(nativeRouterApi));
                } else {
                    basicMessageChannel2.setMessageHandler((BasicMessageChannel.MessageHandler) null);
                }
                BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.NativeRouterApi.popRoute", getCodec());
                if (nativeRouterApi != null) {
                    basicMessageChannel3.setMessageHandler(new Messages$NativeRouterApi$$ExternalSyntheticLambda2(nativeRouterApi));
                } else {
                    basicMessageChannel3.setMessageHandler((BasicMessageChannel.MessageHandler) null);
                }
                BasicMessageChannel basicMessageChannel4 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.NativeRouterApi.getStackFromHost", getCodec());
                if (nativeRouterApi != null) {
                    basicMessageChannel4.setMessageHandler(new Messages$NativeRouterApi$$ExternalSyntheticLambda3(nativeRouterApi));
                } else {
                    basicMessageChannel4.setMessageHandler((BasicMessageChannel.MessageHandler) null);
                }
                BasicMessageChannel basicMessageChannel5 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.NativeRouterApi.saveStackToHost", getCodec());
                if (nativeRouterApi != null) {
                    basicMessageChannel5.setMessageHandler(new Messages$NativeRouterApi$$ExternalSyntheticLambda4(nativeRouterApi));
                } else {
                    basicMessageChannel5.setMessageHandler((BasicMessageChannel.MessageHandler) null);
                }
                BasicMessageChannel basicMessageChannel6 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.NativeRouterApi.sendEventToNative", getCodec());
                if (nativeRouterApi != null) {
                    basicMessageChannel6.setMessageHandler(new Messages$NativeRouterApi$$ExternalSyntheticLambda5(nativeRouterApi));
                } else {
                    basicMessageChannel6.setMessageHandler((BasicMessageChannel.MessageHandler) null);
                }
            }

            public static /* synthetic */ void lambda$setup$0(NativeRouterApi nativeRouterApi, Object obj, BasicMessageChannel.Reply reply) {
                HashMap hashMap = new HashMap();
                try {
                    CommonParams commonParams = (CommonParams) ((ArrayList) obj).get(0);
                    if (commonParams != null) {
                        nativeRouterApi.pushNativeRoute(commonParams);
                        hashMap.put("result", (Object) null);
                        reply.reply(hashMap);
                        return;
                    }
                    throw new NullPointerException("paramArg unexpectedly null.");
                } catch (Error | RuntimeException e) {
                    hashMap.put(Constants.IPC_BUNDLE_KEY_SEND_ERROR, Messages.wrapError(e));
                }
            }

            public static /* synthetic */ void lambda$setup$1(NativeRouterApi nativeRouterApi, Object obj, BasicMessageChannel.Reply reply) {
                HashMap hashMap = new HashMap();
                try {
                    CommonParams commonParams = (CommonParams) ((ArrayList) obj).get(0);
                    if (commonParams != null) {
                        nativeRouterApi.pushFlutterRoute(commonParams);
                        hashMap.put("result", (Object) null);
                        reply.reply(hashMap);
                        return;
                    }
                    throw new NullPointerException("paramArg unexpectedly null.");
                } catch (Error | RuntimeException e) {
                    hashMap.put(Constants.IPC_BUNDLE_KEY_SEND_ERROR, Messages.wrapError(e));
                }
            }

            public static /* synthetic */ void lambda$setup$2(NativeRouterApi nativeRouterApi, Object obj, BasicMessageChannel.Reply reply) {
                HashMap hashMap = new HashMap();
                try {
                    CommonParams commonParams = (CommonParams) ((ArrayList) obj).get(0);
                    if (commonParams != null) {
                        nativeRouterApi.popRoute(commonParams, new Result<Void>(hashMap, reply) {
                            final /* synthetic */ BasicMessageChannel.Reply val$reply;
                            final /* synthetic */ Map val$wrapped;

                            {
                                this.val$wrapped = r1;
                                this.val$reply = r2;
                            }

                            public void success(Void voidR) {
                                this.val$wrapped.put("result", (Object) null);
                                this.val$reply.reply(this.val$wrapped);
                            }

                            public void error(Throwable th) {
                                this.val$wrapped.put(Constants.IPC_BUNDLE_KEY_SEND_ERROR, Messages.wrapError(th));
                                this.val$reply.reply(this.val$wrapped);
                            }
                        });
                        return;
                    }
                    throw new NullPointerException("paramArg unexpectedly null.");
                } catch (Error | RuntimeException e) {
                    hashMap.put(Constants.IPC_BUNDLE_KEY_SEND_ERROR, Messages.wrapError(e));
                    reply.reply(hashMap);
                }
            }

            public static /* synthetic */ void lambda$setup$3(NativeRouterApi nativeRouterApi, Object obj, BasicMessageChannel.Reply reply) {
                HashMap hashMap = new HashMap();
                try {
                    hashMap.put("result", nativeRouterApi.getStackFromHost());
                } catch (Error | RuntimeException e) {
                    hashMap.put(Constants.IPC_BUNDLE_KEY_SEND_ERROR, Messages.wrapError(e));
                }
                reply.reply(hashMap);
            }

            public static /* synthetic */ void lambda$setup$4(NativeRouterApi nativeRouterApi, Object obj, BasicMessageChannel.Reply reply) {
                HashMap hashMap = new HashMap();
                try {
                    StackInfo stackInfo = (StackInfo) ((ArrayList) obj).get(0);
                    if (stackInfo != null) {
                        nativeRouterApi.saveStackToHost(stackInfo);
                        hashMap.put("result", (Object) null);
                        reply.reply(hashMap);
                        return;
                    }
                    throw new NullPointerException("stackArg unexpectedly null.");
                } catch (Error | RuntimeException e) {
                    hashMap.put(Constants.IPC_BUNDLE_KEY_SEND_ERROR, Messages.wrapError(e));
                }
            }

            public static /* synthetic */ void lambda$setup$5(NativeRouterApi nativeRouterApi, Object obj, BasicMessageChannel.Reply reply) {
                HashMap hashMap = new HashMap();
                try {
                    CommonParams commonParams = (CommonParams) ((ArrayList) obj).get(0);
                    if (commonParams != null) {
                        nativeRouterApi.sendEventToNative(commonParams);
                        hashMap.put("result", (Object) null);
                        reply.reply(hashMap);
                        return;
                    }
                    throw new NullPointerException("paramsArg unexpectedly null.");
                } catch (Error | RuntimeException e) {
                    hashMap.put(Constants.IPC_BUNDLE_KEY_SEND_ERROR, Messages.wrapError(e));
                }
            }
        }
    }

    private static class FlutterRouterApiCodec extends StandardMessageCodec {
        public static final FlutterRouterApiCodec INSTANCE = new FlutterRouterApiCodec();

        private FlutterRouterApiCodec() {
        }

        /* access modifiers changed from: protected */
        public Object readValueOfType(byte b, ByteBuffer byteBuffer) {
            if (b != Byte.MIN_VALUE) {
                return Messages.super.readValueOfType(b, byteBuffer);
            }
            return CommonParams.fromMap((Map) readValue(byteBuffer));
        }

        /* access modifiers changed from: protected */
        public void writeValue(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
            if (obj instanceof CommonParams) {
                byteArrayOutputStream.write(128);
                writeValue(byteArrayOutputStream, ((CommonParams) obj).toMap());
                return;
            }
            Messages.super.writeValue(byteArrayOutputStream, obj);
        }
    }

    public static class FlutterRouterApi {
        private final BinaryMessenger binaryMessenger;

        public interface Reply<T> {
            void reply(T t);
        }

        public FlutterRouterApi(BinaryMessenger binaryMessenger2) {
            this.binaryMessenger = binaryMessenger2;
        }

        static MessageCodec<Object> getCodec() {
            return FlutterRouterApiCodec.INSTANCE;
        }

        public void pushRoute(CommonParams commonParams, Reply<Void> reply) {
            new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.FlutterRouterApi.pushRoute", getCodec()).send(new ArrayList(Arrays.asList(new CommonParams[]{commonParams})), new Messages$FlutterRouterApi$$ExternalSyntheticLambda7(reply));
        }

        public void popRoute(CommonParams commonParams, Reply<Void> reply) {
            new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.FlutterRouterApi.popRoute", getCodec()).send(new ArrayList(Arrays.asList(new CommonParams[]{commonParams})), new Messages$FlutterRouterApi$$ExternalSyntheticLambda6(reply));
        }

        public void removeRoute(CommonParams commonParams, Reply<Void> reply) {
            new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.FlutterRouterApi.removeRoute", getCodec()).send(new ArrayList(Arrays.asList(new CommonParams[]{commonParams})), new Messages$FlutterRouterApi$$ExternalSyntheticLambda8(reply));
        }

        public void onForeground(CommonParams commonParams, Reply<Void> reply) {
            new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.FlutterRouterApi.onForeground", getCodec()).send(new ArrayList(Arrays.asList(new CommonParams[]{commonParams})), new Messages$FlutterRouterApi$$ExternalSyntheticLambda4(reply));
        }

        public void onBackground(CommonParams commonParams, Reply<Void> reply) {
            new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.FlutterRouterApi.onBackground", getCodec()).send(new ArrayList(Arrays.asList(new CommonParams[]{commonParams})), new Messages$FlutterRouterApi$$ExternalSyntheticLambda1(reply));
        }

        public void onNativeResult(CommonParams commonParams, Reply<Void> reply) {
            new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.FlutterRouterApi.onNativeResult", getCodec()).send(new ArrayList(Arrays.asList(new CommonParams[]{commonParams})), new Messages$FlutterRouterApi$$ExternalSyntheticLambda5(reply));
        }

        public void onContainerShow(CommonParams commonParams, Reply<Void> reply) {
            new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.FlutterRouterApi.onContainerShow", getCodec()).send(new ArrayList(Arrays.asList(new CommonParams[]{commonParams})), new Messages$FlutterRouterApi$$ExternalSyntheticLambda3(reply));
        }

        public void onContainerHide(CommonParams commonParams, Reply<Void> reply) {
            new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.FlutterRouterApi.onContainerHide", getCodec()).send(new ArrayList(Arrays.asList(new CommonParams[]{commonParams})), new Messages$FlutterRouterApi$$ExternalSyntheticLambda2(reply));
        }

        public void sendEventToFlutter(CommonParams commonParams, Reply<Void> reply) {
            new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.FlutterRouterApi.sendEventToFlutter", getCodec()).send(new ArrayList(Arrays.asList(new CommonParams[]{commonParams})), new Messages$FlutterRouterApi$$ExternalSyntheticLambda9(reply));
        }

        public void onBackPressed(Reply<Void> reply) {
            new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.FlutterRouterApi.onBackPressed", getCodec()).send((Object) null, new Messages$FlutterRouterApi$$ExternalSyntheticLambda0(reply));
        }
    }

    /* access modifiers changed from: private */
    public static Map<String, Object> wrapError(Throwable th) {
        HashMap hashMap = new HashMap();
        hashMap.put("message", th.toString());
        hashMap.put("code", th.getClass().getSimpleName());
        hashMap.put("details", "Cause: " + th.getCause() + ", Stacktrace: " + Log.getStackTraceString(th));
        return hashMap;
    }
}
