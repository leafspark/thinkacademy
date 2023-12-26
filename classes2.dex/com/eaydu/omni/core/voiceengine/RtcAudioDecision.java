package com.eaydu.omni.core.voiceengine;

public abstract class RtcAudioDecision {
    private static RtcAudioDecision defaultDecision;
    private static RtcAudioDecision standardDecision;

    public enum DecisionType {
        Momo,
        Standard
    }

    public abstract void chooseRecAudioSource(boolean z);

    public abstract boolean playStreamTypeUsingVoip();

    /* renamed from: com.eaydu.omni.core.voiceengine.RtcAudioDecision$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$eaydu$omni$core$voiceengine$RtcAudioDecision$DecisionType;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.eaydu.omni.core.voiceengine.RtcAudioDecision$DecisionType[] r0 = com.eaydu.omni.core.voiceengine.RtcAudioDecision.DecisionType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$eaydu$omni$core$voiceengine$RtcAudioDecision$DecisionType = r0
                com.eaydu.omni.core.voiceengine.RtcAudioDecision$DecisionType r1 = com.eaydu.omni.core.voiceengine.RtcAudioDecision.DecisionType.Standard     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$eaydu$omni$core$voiceengine$RtcAudioDecision$DecisionType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.eaydu.omni.core.voiceengine.RtcAudioDecision$DecisionType r1 = com.eaydu.omni.core.voiceengine.RtcAudioDecision.DecisionType.Momo     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.eaydu.omni.core.voiceengine.RtcAudioDecision.AnonymousClass1.<clinit>():void");
        }
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public static synchronized com.eaydu.omni.core.voiceengine.RtcAudioDecision getInstance(com.eaydu.omni.core.voiceengine.RtcAudioDecision.DecisionType r2) {
        /*
            java.lang.Class<com.eaydu.omni.core.voiceengine.RtcAudioDecision> r0 = com.eaydu.omni.core.voiceengine.RtcAudioDecision.class
            monitor-enter(r0)
            int[] r1 = com.eaydu.omni.core.voiceengine.RtcAudioDecision.AnonymousClass1.$SwitchMap$com$eaydu$omni$core$voiceengine$RtcAudioDecision$DecisionType     // Catch:{ all -> 0x0040 }
            int r2 = r2.ordinal()     // Catch:{ all -> 0x0040 }
            r2 = r1[r2]     // Catch:{ all -> 0x0040 }
            r1 = 1
            if (r2 == r1) goto L_0x0027
            com.eaydu.omni.core.voiceengine.RtcAudioDecision r2 = defaultDecision     // Catch:{ all -> 0x0040 }
            if (r2 != 0) goto L_0x0023
            monitor-enter(r0)     // Catch:{ all -> 0x0040 }
            com.eaydu.omni.core.voiceengine.RtcAudioDecision r2 = defaultDecision     // Catch:{ all -> 0x0020 }
            if (r2 != 0) goto L_0x001e
            com.eaydu.omni.core.voiceengine.RtcAudioDefaultDecision r2 = new com.eaydu.omni.core.voiceengine.RtcAudioDefaultDecision     // Catch:{ all -> 0x0020 }
            r2.<init>()     // Catch:{ all -> 0x0020 }
            defaultDecision = r2     // Catch:{ all -> 0x0020 }
        L_0x001e:
            monitor-exit(r0)     // Catch:{ all -> 0x0020 }
            goto L_0x0023
        L_0x0020:
            r2 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0020 }
            throw r2     // Catch:{ all -> 0x0040 }
        L_0x0023:
            com.eaydu.omni.core.voiceengine.RtcAudioDecision r2 = defaultDecision     // Catch:{ all -> 0x0040 }
            monitor-exit(r0)
            return r2
        L_0x0027:
            com.eaydu.omni.core.voiceengine.RtcAudioDecision r2 = standardDecision     // Catch:{ all -> 0x0040 }
            if (r2 != 0) goto L_0x003c
            monitor-enter(r0)     // Catch:{ all -> 0x0040 }
            com.eaydu.omni.core.voiceengine.RtcAudioDecision r2 = standardDecision     // Catch:{ all -> 0x0039 }
            if (r2 != 0) goto L_0x0037
            com.eaydu.omni.core.voiceengine.RtcAudioStandardDecision r2 = new com.eaydu.omni.core.voiceengine.RtcAudioStandardDecision     // Catch:{ all -> 0x0039 }
            r2.<init>()     // Catch:{ all -> 0x0039 }
            standardDecision = r2     // Catch:{ all -> 0x0039 }
        L_0x0037:
            monitor-exit(r0)     // Catch:{ all -> 0x0039 }
            goto L_0x003c
        L_0x0039:
            r2 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0039 }
            throw r2     // Catch:{ all -> 0x0040 }
        L_0x003c:
            com.eaydu.omni.core.voiceengine.RtcAudioDecision r2 = standardDecision     // Catch:{ all -> 0x0040 }
            monitor-exit(r0)
            return r2
        L_0x0040:
            r2 = move-exception
            monitor-exit(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.eaydu.omni.core.voiceengine.RtcAudioDecision.getInstance(com.eaydu.omni.core.voiceengine.RtcAudioDecision$DecisionType):com.eaydu.omni.core.voiceengine.RtcAudioDecision");
    }
}
