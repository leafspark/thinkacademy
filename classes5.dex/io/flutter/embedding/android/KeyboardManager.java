package io.flutter.embedding.android;

import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import io.flutter.Log;
import io.flutter.embedding.engine.systemchannels.KeyEventChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.editing.InputConnectionAdaptor;
import java.util.HashSet;

public class KeyboardManager implements InputConnectionAdaptor.KeyboardDelegate {
    private static final String TAG = "KeyboardManager";
    private final HashSet<KeyEvent> redispatchedEvents = new HashSet<>();
    protected final Responder[] responders;
    private final ViewDelegate viewDelegate;

    public interface Responder {

        public interface OnKeyEventHandledCallback {
            void onKeyEventHandled(boolean z);
        }

        void handleEvent(KeyEvent keyEvent, OnKeyEventHandledCallback onKeyEventHandledCallback);
    }

    public interface ViewDelegate {
        BinaryMessenger getBinaryMessenger();

        boolean onTextInputKeyEvent(KeyEvent keyEvent);

        void redispatch(KeyEvent keyEvent);
    }

    public static class CharacterCombiner {
        private int combiningCharacter = 0;

        /* access modifiers changed from: package-private */
        public Character applyCombiningCharacterToBaseCharacter(int i) {
            char c = (char) i;
            if ((Integer.MIN_VALUE & i) != 0) {
                int i2 = i & Integer.MAX_VALUE;
                int i3 = this.combiningCharacter;
                if (i3 != 0) {
                    this.combiningCharacter = KeyCharacterMap.getDeadChar(i3, i2);
                } else {
                    this.combiningCharacter = i2;
                }
            } else {
                int i4 = this.combiningCharacter;
                if (i4 != 0) {
                    int deadChar = KeyCharacterMap.getDeadChar(i4, i);
                    if (deadChar > 0) {
                        c = (char) deadChar;
                    }
                    this.combiningCharacter = 0;
                }
            }
            return Character.valueOf(c);
        }
    }

    public KeyboardManager(ViewDelegate viewDelegate2) {
        this.viewDelegate = viewDelegate2;
        this.responders = new Responder[]{new KeyEmbedderResponder(viewDelegate2.getBinaryMessenger()), new KeyChannelResponder(new KeyEventChannel(viewDelegate2.getBinaryMessenger()))};
    }

    private class PerEventCallbackBuilder {
        boolean isEventHandled = false;
        final KeyEvent keyEvent;
        int unrepliedCount;

        private class Callback implements Responder.OnKeyEventHandledCallback {
            boolean isCalled;

            private Callback() {
                this.isCalled = false;
            }

            public void onKeyEventHandled(boolean z) {
                if (!this.isCalled) {
                    this.isCalled = true;
                    PerEventCallbackBuilder.this.unrepliedCount--;
                    PerEventCallbackBuilder perEventCallbackBuilder = PerEventCallbackBuilder.this;
                    perEventCallbackBuilder.isEventHandled = z | perEventCallbackBuilder.isEventHandled;
                    if (PerEventCallbackBuilder.this.unrepliedCount == 0 && !PerEventCallbackBuilder.this.isEventHandled) {
                        KeyboardManager.this.onUnhandled(PerEventCallbackBuilder.this.keyEvent);
                        return;
                    }
                    return;
                }
                throw new IllegalStateException("The onKeyEventHandledCallback should be called exactly once.");
            }
        }

        PerEventCallbackBuilder(KeyEvent keyEvent2) {
            this.unrepliedCount = KeyboardManager.this.responders.length;
            this.keyEvent = keyEvent2;
        }

        public Responder.OnKeyEventHandledCallback buildCallback() {
            return new Callback();
        }
    }

    public boolean handleEvent(KeyEvent keyEvent) {
        if (this.redispatchedEvents.remove(keyEvent)) {
            return false;
        }
        if (this.responders.length > 0) {
            PerEventCallbackBuilder perEventCallbackBuilder = new PerEventCallbackBuilder(keyEvent);
            for (Responder handleEvent : this.responders) {
                handleEvent.handleEvent(keyEvent, perEventCallbackBuilder.buildCallback());
            }
            return true;
        }
        onUnhandled(keyEvent);
        return true;
    }

    public void destroy() {
        int size = this.redispatchedEvents.size();
        if (size > 0) {
            Log.w(TAG, "A KeyboardManager was destroyed with " + String.valueOf(size) + " unhandled redispatch event(s).");
        }
    }

    /* access modifiers changed from: private */
    public void onUnhandled(KeyEvent keyEvent) {
        ViewDelegate viewDelegate2 = this.viewDelegate;
        if (viewDelegate2 != null && !viewDelegate2.onTextInputKeyEvent(keyEvent)) {
            this.redispatchedEvents.add(keyEvent);
            this.viewDelegate.redispatch(keyEvent);
            if (this.redispatchedEvents.remove(keyEvent)) {
                Log.w(TAG, "A redispatched key event was consumed before reaching KeyboardManager");
            }
        }
    }
}
