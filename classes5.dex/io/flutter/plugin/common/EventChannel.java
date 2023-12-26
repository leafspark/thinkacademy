package io.flutter.plugin.common;

import com.tekartik.sqflite.Constant;
import io.flutter.Log;
import io.flutter.plugin.common.BinaryMessenger;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class EventChannel {
    private static final String TAG = "EventChannel#";
    /* access modifiers changed from: private */
    public final MethodCodec codec;
    /* access modifiers changed from: private */
    public final BinaryMessenger messenger;
    /* access modifiers changed from: private */
    public final String name;
    private final BinaryMessenger.TaskQueue taskQueue;

    public interface EventSink {
        void endOfStream();

        void error(String str, String str2, Object obj);

        void success(Object obj);
    }

    public interface StreamHandler {
        void onCancel(Object obj);

        void onListen(Object obj, EventSink eventSink);
    }

    public EventChannel(BinaryMessenger binaryMessenger, String str) {
        this(binaryMessenger, str, StandardMethodCodec.INSTANCE);
    }

    public EventChannel(BinaryMessenger binaryMessenger, String str, MethodCodec methodCodec) {
        this(binaryMessenger, str, methodCodec, (BinaryMessenger.TaskQueue) null);
    }

    public EventChannel(BinaryMessenger binaryMessenger, String str, MethodCodec methodCodec, BinaryMessenger.TaskQueue taskQueue2) {
        this.messenger = binaryMessenger;
        this.name = str;
        this.codec = methodCodec;
        this.taskQueue = taskQueue2;
    }

    public void setStreamHandler(StreamHandler streamHandler) {
        IncomingStreamRequestHandler incomingStreamRequestHandler = null;
        if (this.taskQueue != null) {
            BinaryMessenger binaryMessenger = this.messenger;
            String str = this.name;
            if (streamHandler != null) {
                incomingStreamRequestHandler = new IncomingStreamRequestHandler(streamHandler);
            }
            binaryMessenger.setMessageHandler(str, incomingStreamRequestHandler, this.taskQueue);
            return;
        }
        BinaryMessenger binaryMessenger2 = this.messenger;
        String str2 = this.name;
        if (streamHandler != null) {
            incomingStreamRequestHandler = new IncomingStreamRequestHandler(streamHandler);
        }
        binaryMessenger2.setMessageHandler(str2, incomingStreamRequestHandler);
    }

    private final class IncomingStreamRequestHandler implements BinaryMessenger.BinaryMessageHandler {
        /* access modifiers changed from: private */
        public final AtomicReference<EventSink> activeSink = new AtomicReference<>((Object) null);
        private final StreamHandler handler;

        IncomingStreamRequestHandler(StreamHandler streamHandler) {
            this.handler = streamHandler;
        }

        public void onMessage(ByteBuffer byteBuffer, BinaryMessenger.BinaryReply binaryReply) {
            MethodCall decodeMethodCall = EventChannel.this.codec.decodeMethodCall(byteBuffer);
            if (decodeMethodCall.method.equals("listen")) {
                onListen(decodeMethodCall.arguments, binaryReply);
            } else if (decodeMethodCall.method.equals(Constant.PARAM_CANCEL)) {
                onCancel(decodeMethodCall.arguments, binaryReply);
            } else {
                binaryReply.reply((ByteBuffer) null);
            }
        }

        private void onListen(Object obj, BinaryMessenger.BinaryReply binaryReply) {
            EventSinkImplementation eventSinkImplementation = new EventSinkImplementation();
            if (this.activeSink.getAndSet(eventSinkImplementation) != null) {
                try {
                    this.handler.onCancel((Object) null);
                } catch (RuntimeException e) {
                    Log.e(EventChannel.TAG + EventChannel.this.name, "Failed to close existing event stream", e);
                }
            }
            try {
                this.handler.onListen(obj, eventSinkImplementation);
                binaryReply.reply(EventChannel.this.codec.encodeSuccessEnvelope((Object) null));
            } catch (RuntimeException e2) {
                this.activeSink.set((Object) null);
                Log.e(EventChannel.TAG + EventChannel.this.name, "Failed to open event stream", e2);
                binaryReply.reply(EventChannel.this.codec.encodeErrorEnvelope(Constant.PARAM_ERROR, e2.getMessage(), (Object) null));
            }
        }

        private void onCancel(Object obj, BinaryMessenger.BinaryReply binaryReply) {
            if (this.activeSink.getAndSet((Object) null) != null) {
                try {
                    this.handler.onCancel(obj);
                    binaryReply.reply(EventChannel.this.codec.encodeSuccessEnvelope((Object) null));
                } catch (RuntimeException e) {
                    Log.e(EventChannel.TAG + EventChannel.this.name, "Failed to close event stream", e);
                    binaryReply.reply(EventChannel.this.codec.encodeErrorEnvelope(Constant.PARAM_ERROR, e.getMessage(), (Object) null));
                }
            } else {
                binaryReply.reply(EventChannel.this.codec.encodeErrorEnvelope(Constant.PARAM_ERROR, "No active stream to cancel", (Object) null));
            }
        }

        private final class EventSinkImplementation implements EventSink {
            final AtomicBoolean hasEnded;

            private EventSinkImplementation() {
                this.hasEnded = new AtomicBoolean(false);
            }

            public void success(Object obj) {
                if (!this.hasEnded.get() && IncomingStreamRequestHandler.this.activeSink.get() == this) {
                    EventChannel.this.messenger.send(EventChannel.this.name, EventChannel.this.codec.encodeSuccessEnvelope(obj));
                }
            }

            public void error(String str, String str2, Object obj) {
                if (!this.hasEnded.get() && IncomingStreamRequestHandler.this.activeSink.get() == this) {
                    EventChannel.this.messenger.send(EventChannel.this.name, EventChannel.this.codec.encodeErrorEnvelope(str, str2, obj));
                }
            }

            public void endOfStream() {
                if (!this.hasEnded.getAndSet(true) && IncomingStreamRequestHandler.this.activeSink.get() == this) {
                    EventChannel.this.messenger.send(EventChannel.this.name, (ByteBuffer) null);
                }
            }
        }
    }
}
