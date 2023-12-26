package com.amazonaws.services.s3.model;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ExtraMaterialsDescription implements Serializable {
    public static final ExtraMaterialsDescription NONE = new ExtraMaterialsDescription(Collections.EMPTY_MAP);
    private final Map<String, String> extra;
    private final ConflictResolution resolve;

    public enum ConflictResolution {
        FAIL_FAST,
        OVERRIDE,
        OVERRIDDEN
    }

    public ExtraMaterialsDescription(Map<String, String> map) {
        this(map, ConflictResolution.FAIL_FAST);
    }

    public ExtraMaterialsDescription(Map<String, String> map, ConflictResolution conflictResolution) {
        if (map == null || conflictResolution == null) {
            throw new IllegalArgumentException();
        }
        this.extra = Collections.unmodifiableMap(new HashMap(map));
        this.resolve = conflictResolution;
    }

    public Map<String, String> getMaterialDescription() {
        return this.extra;
    }

    public ConflictResolution getConflictResolution() {
        return this.resolve;
    }

    public Map<String, String> mergeInto(Map<String, String> map) {
        if (this.extra.size() == 0) {
            return map;
        }
        if (map == null || map.size() == 0) {
            return this.extra;
        }
        int i = AnonymousClass1.$SwitchMap$com$amazonaws$services$s3$model$ExtraMaterialsDescription$ConflictResolution[this.resolve.ordinal()];
        if (i == 1) {
            int size = map.size() + this.extra.size();
            HashMap hashMap = new HashMap(map);
            hashMap.putAll(this.extra);
            if (size == hashMap.size()) {
                return Collections.unmodifiableMap(hashMap);
            }
            throw new IllegalArgumentException("The supplemental material descriptions contains conflicting entries");
        } else if (i == 2) {
            HashMap hashMap2 = new HashMap(this.extra);
            hashMap2.putAll(map);
            return Collections.unmodifiableMap(hashMap2);
        } else if (i == 3) {
            HashMap hashMap3 = new HashMap(map);
            hashMap3.putAll(this.extra);
            return Collections.unmodifiableMap(hashMap3);
        } else {
            throw new UnsupportedOperationException();
        }
    }

    /* renamed from: com.amazonaws.services.s3.model.ExtraMaterialsDescription$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$amazonaws$services$s3$model$ExtraMaterialsDescription$ConflictResolution;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.amazonaws.services.s3.model.ExtraMaterialsDescription$ConflictResolution[] r0 = com.amazonaws.services.s3.model.ExtraMaterialsDescription.ConflictResolution.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$amazonaws$services$s3$model$ExtraMaterialsDescription$ConflictResolution = r0
                com.amazonaws.services.s3.model.ExtraMaterialsDescription$ConflictResolution r1 = com.amazonaws.services.s3.model.ExtraMaterialsDescription.ConflictResolution.FAIL_FAST     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$amazonaws$services$s3$model$ExtraMaterialsDescription$ConflictResolution     // Catch:{ NoSuchFieldError -> 0x001d }
                com.amazonaws.services.s3.model.ExtraMaterialsDescription$ConflictResolution r1 = com.amazonaws.services.s3.model.ExtraMaterialsDescription.ConflictResolution.OVERRIDDEN     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$amazonaws$services$s3$model$ExtraMaterialsDescription$ConflictResolution     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.amazonaws.services.s3.model.ExtraMaterialsDescription$ConflictResolution r1 = com.amazonaws.services.s3.model.ExtraMaterialsDescription.ConflictResolution.OVERRIDE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.s3.model.ExtraMaterialsDescription.AnonymousClass1.<clinit>():void");
        }
    }
}
