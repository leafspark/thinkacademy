package io.flutter.embedding.android;

import android.view.KeyEvent;
import io.flutter.embedding.android.KeyData;
import io.flutter.embedding.android.KeyboardManager;
import io.flutter.embedding.android.KeyboardMap;
import io.flutter.plugin.common.BinaryMessenger;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;

public class KeyEmbedderResponder implements KeyboardManager.Responder {
    private static final String TAG = "KeyEmbedderResponder";
    private final KeyboardManager.CharacterCombiner characterCombiner = new KeyboardManager.CharacterCombiner();
    private final BinaryMessenger messenger;
    private final HashMap<Long, Long> pressingRecords = new HashMap<>();
    private final HashMap<Long, KeyboardMap.TogglingGoal> togglingGoals = new HashMap<>();

    private static long keyOfPlane(long j, long j2) {
        return (j & KeyboardMap.kValueMask) | j2;
    }

    private static KeyData.Type getEventType(KeyEvent keyEvent) {
        boolean z = keyEvent.getRepeatCount() > 0;
        int action = keyEvent.getAction();
        if (action == 0) {
            return z ? KeyData.Type.kRepeat : KeyData.Type.kDown;
        }
        if (action == 1) {
            return KeyData.Type.kUp;
        }
        throw new AssertionError("Unexpected event type");
    }

    public KeyEmbedderResponder(BinaryMessenger binaryMessenger) {
        this.messenger = binaryMessenger;
        for (KeyboardMap.TogglingGoal togglingGoal : KeyboardMap.getTogglingGoals()) {
            this.togglingGoals.put(Long.valueOf(togglingGoal.logicalKey), togglingGoal);
        }
    }

    private Long getPhysicalKey(KeyEvent keyEvent) {
        long scanCode = (long) keyEvent.getScanCode();
        if (scanCode == 0) {
            return Long.valueOf(keyOfPlane((long) keyEvent.getKeyCode(), KeyboardMap.kAndroidPlane));
        }
        Long l = KeyboardMap.scanCodeToPhysical.get(Long.valueOf(scanCode));
        if (l != null) {
            return l;
        }
        return Long.valueOf(keyOfPlane((long) keyEvent.getScanCode(), KeyboardMap.kAndroidPlane));
    }

    private Long getLogicalKey(KeyEvent keyEvent) {
        Long l = KeyboardMap.keyCodeToLogical.get(Long.valueOf((long) keyEvent.getKeyCode()));
        if (l != null) {
            return l;
        }
        return Long.valueOf(keyOfPlane((long) keyEvent.getKeyCode(), KeyboardMap.kAndroidPlane));
    }

    /* access modifiers changed from: package-private */
    public void updatePressingState(Long l, Long l2) {
        if (l2 != null) {
            if (this.pressingRecords.put(l, l2) != null) {
                throw new AssertionError("The key was not empty");
            }
        } else if (this.pressingRecords.remove(l) == null) {
            throw new AssertionError("The key was empty");
        }
    }

    /* access modifiers changed from: package-private */
    public void synchronizePressingKey(KeyboardMap.PressingGoal pressingGoal, boolean z, long j, long j2, KeyEvent keyEvent, ArrayList<Runnable> arrayList) {
        int i;
        KeyboardMap.PressingGoal pressingGoal2 = pressingGoal;
        ArrayList<Runnable> arrayList2 = arrayList;
        boolean[] zArr = new boolean[pressingGoal2.keys.length];
        Boolean[] boolArr = new Boolean[pressingGoal2.keys.length];
        boolean z2 = false;
        int i2 = 0;
        while (true) {
            boolean z3 = true;
            if (i2 >= pressingGoal2.keys.length) {
                break;
            }
            KeyboardMap.KeyPair keyPair = pressingGoal2.keys[i2];
            zArr[i2] = this.pressingRecords.containsKey(Long.valueOf(keyPair.physicalKey));
            if (keyPair.logicalKey == j) {
                int i3 = AnonymousClass1.$SwitchMap$io$flutter$embedding$android$KeyData$Type[getEventType(keyEvent).ordinal()];
                if (i3 != 1) {
                    if (i3 == 2) {
                        KeyEvent keyEvent2 = keyEvent;
                        boolArr[i2] = Boolean.valueOf(zArr[i2]);
                    } else if (i3 != 3) {
                        KeyEvent keyEvent3 = keyEvent;
                    } else {
                        if (!z) {
                            arrayList2.add(new KeyEmbedderResponder$$ExternalSyntheticLambda2(this, keyPair, keyEvent));
                        } else {
                            KeyEvent keyEvent4 = keyEvent;
                        }
                        boolArr[i2] = Boolean.valueOf(zArr[i2]);
                    }
                    i2++;
                } else {
                    KeyEvent keyEvent5 = keyEvent;
                    boolArr[i2] = false;
                    if (!z) {
                        KeyEmbedderResponder$$ExternalSyntheticLambda1 keyEmbedderResponder$$ExternalSyntheticLambda1 = r0;
                        KeyEmbedderResponder$$ExternalSyntheticLambda1 keyEmbedderResponder$$ExternalSyntheticLambda12 = new KeyEmbedderResponder$$ExternalSyntheticLambda1(this, keyPair, j2, keyEvent);
                        arrayList2.add(keyEmbedderResponder$$ExternalSyntheticLambda1);
                    }
                }
            } else {
                KeyEvent keyEvent6 = keyEvent;
                if (!z2 && !zArr[i2]) {
                    z3 = false;
                }
            }
            z2 = z3;
            i2++;
        }
        KeyEvent keyEvent7 = keyEvent;
        if (z) {
            for (int i4 = 0; i4 < pressingGoal2.keys.length; i4++) {
                if (boolArr[i4] == null) {
                    if (z2) {
                        boolArr[i4] = Boolean.valueOf(zArr[i4]);
                    } else {
                        boolArr[i4] = true;
                        z2 = true;
                    }
                }
            }
            if (!z2) {
                i = 0;
                boolArr[0] = true;
            } else {
                i = 0;
            }
        } else {
            i = 0;
            for (int i5 = 0; i5 < pressingGoal2.keys.length; i5++) {
                if (boolArr[i5] == null) {
                    boolArr[i5] = false;
                }
            }
        }
        for (int i6 = i; i6 < pressingGoal2.keys.length; i6++) {
            if (zArr[i6] != boolArr[i6].booleanValue()) {
                KeyboardMap.KeyPair keyPair2 = pressingGoal2.keys[i6];
                synthesizeEvent(boolArr[i6].booleanValue(), Long.valueOf(keyPair2.logicalKey), Long.valueOf(keyPair2.physicalKey), keyEvent.getEventTime());
            }
        }
    }

    /* renamed from: io.flutter.embedding.android.KeyEmbedderResponder$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$flutter$embedding$android$KeyData$Type;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                io.flutter.embedding.android.KeyData$Type[] r0 = io.flutter.embedding.android.KeyData.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$io$flutter$embedding$android$KeyData$Type = r0
                io.flutter.embedding.android.KeyData$Type r1 = io.flutter.embedding.android.KeyData.Type.kDown     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$io$flutter$embedding$android$KeyData$Type     // Catch:{ NoSuchFieldError -> 0x001d }
                io.flutter.embedding.android.KeyData$Type r1 = io.flutter.embedding.android.KeyData.Type.kUp     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$io$flutter$embedding$android$KeyData$Type     // Catch:{ NoSuchFieldError -> 0x0028 }
                io.flutter.embedding.android.KeyData$Type r1 = io.flutter.embedding.android.KeyData.Type.kRepeat     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.flutter.embedding.android.KeyEmbedderResponder.AnonymousClass1.<clinit>():void");
        }
    }

    public /* synthetic */ void lambda$synchronizePressingKey$0$KeyEmbedderResponder(KeyboardMap.KeyPair keyPair, long j, KeyEvent keyEvent) {
        synthesizeEvent(false, Long.valueOf(keyPair.logicalKey), Long.valueOf(j), keyEvent.getEventTime());
    }

    public /* synthetic */ void lambda$synchronizePressingKey$1$KeyEmbedderResponder(KeyboardMap.KeyPair keyPair, KeyEvent keyEvent) {
        synthesizeEvent(false, Long.valueOf(keyPair.logicalKey), Long.valueOf(keyPair.physicalKey), keyEvent.getEventTime());
    }

    /* access modifiers changed from: package-private */
    public void synchronizeTogglingKey(KeyboardMap.TogglingGoal togglingGoal, boolean z, long j, KeyEvent keyEvent) {
        if (togglingGoal.logicalKey != j && togglingGoal.enabled != z) {
            boolean z2 = !this.pressingRecords.containsKey(Long.valueOf(togglingGoal.physicalKey));
            if (z2) {
                togglingGoal.enabled = !togglingGoal.enabled;
            }
            synthesizeEvent(z2, Long.valueOf(togglingGoal.logicalKey), Long.valueOf(togglingGoal.physicalKey), keyEvent.getEventTime());
            if (!z2) {
                togglingGoal.enabled = !togglingGoal.enabled;
            }
            synthesizeEvent(!z2, Long.valueOf(togglingGoal.logicalKey), Long.valueOf(togglingGoal.physicalKey), keyEvent.getEventTime());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x011a A[LOOP:2: B:53:0x0114->B:55:0x011a, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean handleEventImpl(android.view.KeyEvent r18, io.flutter.embedding.android.KeyboardManager.Responder.OnKeyEventHandledCallback r19) {
        /*
            r17 = this;
            r9 = r17
            int r0 = r18.getScanCode()
            r10 = 0
            if (r0 != 0) goto L_0x0010
            int r0 = r18.getKeyCode()
            if (r0 != 0) goto L_0x0010
            return r10
        L_0x0010:
            java.lang.Long r11 = r17.getPhysicalKey(r18)
            java.lang.Long r12 = r17.getLogicalKey(r18)
            java.util.ArrayList r13 = new java.util.ArrayList
            r13.<init>()
            io.flutter.embedding.android.KeyboardMap$PressingGoal[] r14 = io.flutter.embedding.android.KeyboardMap.pressingGoals
            int r15 = r14.length
            r8 = r10
        L_0x0021:
            r6 = 1
            if (r8 >= r15) goto L_0x0047
            r1 = r14[r8]
            int r0 = r18.getMetaState()
            int r2 = r1.mask
            r0 = r0 & r2
            if (r0 == 0) goto L_0x0031
            r2 = r6
            goto L_0x0032
        L_0x0031:
            r2 = r10
        L_0x0032:
            long r3 = r12.longValue()
            long r5 = r11.longValue()
            r0 = r17
            r7 = r18
            r16 = r8
            r8 = r13
            r0.synchronizePressingKey(r1, r2, r3, r5, r7, r8)
            int r8 = r16 + 1
            goto L_0x0021
        L_0x0047:
            java.util.HashMap<java.lang.Long, io.flutter.embedding.android.KeyboardMap$TogglingGoal> r0 = r9.togglingGoals
            java.util.Collection r0 = r0.values()
            java.util.Iterator r7 = r0.iterator()
        L_0x0051:
            boolean r0 = r7.hasNext()
            if (r0 == 0) goto L_0x0076
            java.lang.Object r0 = r7.next()
            r1 = r0
            io.flutter.embedding.android.KeyboardMap$TogglingGoal r1 = (io.flutter.embedding.android.KeyboardMap.TogglingGoal) r1
            int r0 = r18.getMetaState()
            int r2 = r1.mask
            r0 = r0 & r2
            if (r0 == 0) goto L_0x0069
            r2 = r6
            goto L_0x006a
        L_0x0069:
            r2 = r10
        L_0x006a:
            long r3 = r12.longValue()
            r0 = r17
            r5 = r18
            r0.synchronizeTogglingKey(r1, r2, r3, r5)
            goto L_0x0051
        L_0x0076:
            int r0 = r18.getAction()
            if (r0 == 0) goto L_0x0081
            if (r0 == r6) goto L_0x007f
            return r10
        L_0x007f:
            r7 = r10
            goto L_0x0082
        L_0x0081:
            r7 = r6
        L_0x0082:
            java.util.HashMap<java.lang.Long, java.lang.Long> r0 = r9.pressingRecords
            java.lang.Object r0 = r0.get(r11)
            r2 = r0
            java.lang.Long r2 = (java.lang.Long) r2
            r8 = 0
            if (r7 == 0) goto L_0x00cb
            if (r2 != 0) goto L_0x0093
            io.flutter.embedding.android.KeyData$Type r0 = io.flutter.embedding.android.KeyData.Type.kDown
            goto L_0x00a9
        L_0x0093:
            int r0 = r18.getRepeatCount()
            if (r0 <= 0) goto L_0x009c
            io.flutter.embedding.android.KeyData$Type r0 = io.flutter.embedding.android.KeyData.Type.kRepeat
            goto L_0x00a9
        L_0x009c:
            r1 = 0
            long r4 = r18.getEventTime()
            r0 = r17
            r3 = r11
            r0.synthesizeEvent(r1, r2, r3, r4)
            io.flutter.embedding.android.KeyData$Type r0 = io.flutter.embedding.android.KeyData.Type.kDown
        L_0x00a9:
            io.flutter.embedding.android.KeyboardManager$CharacterCombiner r1 = r9.characterCombiner
            int r2 = r18.getUnicodeChar()
            java.lang.Character r1 = r1.applyCombiningCharacterToBaseCharacter(r2)
            char r1 = r1.charValue()
            if (r1 == 0) goto L_0x00d0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = ""
            r2.append(r3)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            goto L_0x00d1
        L_0x00cb:
            if (r2 != 0) goto L_0x00ce
            return r10
        L_0x00ce:
            io.flutter.embedding.android.KeyData$Type r0 = io.flutter.embedding.android.KeyData.Type.kUp
        L_0x00d0:
            r1 = r8
        L_0x00d1:
            io.flutter.embedding.android.KeyData$Type r2 = io.flutter.embedding.android.KeyData.Type.kRepeat
            if (r0 == r2) goto L_0x00db
            if (r7 == 0) goto L_0x00d8
            r8 = r12
        L_0x00d8:
            r9.updatePressingState(r11, r8)
        L_0x00db:
            io.flutter.embedding.android.KeyData$Type r2 = io.flutter.embedding.android.KeyData.Type.kDown
            if (r0 != r2) goto L_0x00ee
            java.util.HashMap<java.lang.Long, io.flutter.embedding.android.KeyboardMap$TogglingGoal> r2 = r9.togglingGoals
            java.lang.Object r2 = r2.get(r12)
            io.flutter.embedding.android.KeyboardMap$TogglingGoal r2 = (io.flutter.embedding.android.KeyboardMap.TogglingGoal) r2
            if (r2 == 0) goto L_0x00ee
            boolean r3 = r2.enabled
            r3 = r3 ^ r6
            r2.enabled = r3
        L_0x00ee:
            io.flutter.embedding.android.KeyData r2 = new io.flutter.embedding.android.KeyData
            r2.<init>()
            long r3 = r18.getEventTime()
            r2.timestamp = r3
            r2.type = r0
            long r3 = r12.longValue()
            r2.logicalKey = r3
            long r3 = r11.longValue()
            r2.physicalKey = r3
            r2.character = r1
            r2.synthesized = r10
            r0 = r19
            r9.sendKeyEvent(r2, r0)
            java.util.Iterator r0 = r13.iterator()
        L_0x0114:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0124
            java.lang.Object r1 = r0.next()
            java.lang.Runnable r1 = (java.lang.Runnable) r1
            r1.run()
            goto L_0x0114
        L_0x0124:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.embedding.android.KeyEmbedderResponder.handleEventImpl(android.view.KeyEvent, io.flutter.embedding.android.KeyboardManager$Responder$OnKeyEventHandledCallback):boolean");
    }

    private void synthesizeEvent(boolean z, Long l, Long l2, long j) {
        KeyData keyData = new KeyData();
        keyData.timestamp = j;
        keyData.type = z ? KeyData.Type.kDown : KeyData.Type.kUp;
        keyData.logicalKey = l.longValue();
        keyData.physicalKey = l2.longValue();
        keyData.character = null;
        keyData.synthesized = true;
        if (!(l2.longValue() == 0 || l.longValue() == 0)) {
            if (!z) {
                l = null;
            }
            updatePressingState(l2, l);
        }
        sendKeyEvent(keyData, (KeyboardManager.Responder.OnKeyEventHandledCallback) null);
    }

    private void sendKeyEvent(KeyData keyData, KeyboardManager.Responder.OnKeyEventHandledCallback onKeyEventHandledCallback) {
        this.messenger.send(KeyData.CHANNEL, keyData.toBytes(), onKeyEventHandledCallback == null ? null : new KeyEmbedderResponder$$ExternalSyntheticLambda0(onKeyEventHandledCallback));
    }

    static /* synthetic */ void lambda$sendKeyEvent$2(KeyboardManager.Responder.OnKeyEventHandledCallback onKeyEventHandledCallback, ByteBuffer byteBuffer) {
        boolean z = false;
        Boolean bool = false;
        byteBuffer.rewind();
        if (byteBuffer.capacity() != 0) {
            if (byteBuffer.get() != 0) {
                z = true;
            }
            bool = Boolean.valueOf(z);
        }
        onKeyEventHandledCallback.onKeyEventHandled(bool.booleanValue());
    }

    public void handleEvent(KeyEvent keyEvent, KeyboardManager.Responder.OnKeyEventHandledCallback onKeyEventHandledCallback) {
        if (!handleEventImpl(keyEvent, onKeyEventHandledCallback)) {
            synthesizeEvent(true, (Long) null, 0L, 0);
            onKeyEventHandledCallback.onKeyEventHandled(true);
        }
    }
}
