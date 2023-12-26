package com.wushuangtech.jni;

import com.wushuangtech.expansion.bean.ChatInfo;
import com.wushuangtech.utils.OmniLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class ChatJni {
    public static final int CHATDATATYPE_AUDIO = 3;
    public static final int CHATDATATYPE_CUSTOM = 4;
    public static final int CHATDATATYPE_PICTURE = 2;
    public static final int CHATDATATYPE_SIGNAL = 5;
    public static final int CHATDATATYPE_TEXT = 1;
    private static ChatJni mChatJni;
    private List<WeakReference<ChatJniCallback>> mCallBacks = new ArrayList();
    private ChatInfoManager mChatInfoManager = new ChatInfoManager();

    public interface ChatJniCallback {
        void OnChatRecv(long j, ChatInfo chatInfo);

        void OnChatSend(ChatInfo chatInfo, int i);

        void onPlayChatAudioCompletion(String str);
    }

    private void OnChatRecv(long j, int i, String str, String str2, int i2) {
    }

    public void OnAudioDonwload(long j, int i, String str, String str2) {
    }

    public native void SendChat(long j, long j2, int i, String str, String str2, int i2);

    public native void SendSignal(long j, long j2, int i, String str, String str2, int i2);

    public native void enableChat();

    public native void enableSignal();

    public native boolean initialize(ChatJni chatJni);

    public native void unInitialize();

    private ChatJni() {
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
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public static synchronized com.wushuangtech.jni.ChatJni getInstance() {
        /*
            java.lang.Class<com.wushuangtech.jni.ChatJni> r0 = com.wushuangtech.jni.ChatJni.class
            monitor-enter(r0)
            com.wushuangtech.jni.ChatJni r1 = mChatJni     // Catch:{ all -> 0x002b }
            if (r1 != 0) goto L_0x0027
            monitor-enter(r0)     // Catch:{ all -> 0x002b }
            com.wushuangtech.jni.ChatJni r1 = mChatJni     // Catch:{ all -> 0x0024 }
            if (r1 != 0) goto L_0x0022
            com.wushuangtech.jni.ChatJni r1 = new com.wushuangtech.jni.ChatJni     // Catch:{ all -> 0x0024 }
            r1.<init>()     // Catch:{ all -> 0x0024 }
            mChatJni = r1     // Catch:{ all -> 0x0024 }
            boolean r1 = r1.initialize(r1)     // Catch:{ all -> 0x0024 }
            if (r1 == 0) goto L_0x001a
            goto L_0x0022
        L_0x001a:
            java.lang.RuntimeException r1 = new java.lang.RuntimeException     // Catch:{ all -> 0x0024 }
            java.lang.String r2 = "can't initilaize ChatJni"
            r1.<init>(r2)     // Catch:{ all -> 0x0024 }
            throw r1     // Catch:{ all -> 0x0024 }
        L_0x0022:
            monitor-exit(r0)     // Catch:{ all -> 0x0024 }
            goto L_0x0027
        L_0x0024:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0024 }
            throw r1     // Catch:{ all -> 0x002b }
        L_0x0027:
            com.wushuangtech.jni.ChatJni r1 = mChatJni     // Catch:{ all -> 0x002b }
            monitor-exit(r0)
            return r1
        L_0x002b:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.jni.ChatJni.getInstance():com.wushuangtech.jni.ChatJni");
    }

    public void addCallback(ChatJniCallback chatJniCallback) {
        this.mCallBacks.add(new WeakReference(chatJniCallback));
    }

    public void removeCallback(ChatJniCallback chatJniCallback) {
        int i = 0;
        while (i < this.mCallBacks.size()) {
            WeakReference weakReference = this.mCallBacks.get(i);
            if (weakReference == null || weakReference.get() == null || weakReference.get() != chatJniCallback) {
                i++;
            } else {
                this.mCallBacks.remove(weakReference);
                return;
            }
        }
    }

    public void sendChat(long j, long j2, int i, String str, String str2) {
        OmniLog.d(OmniLog.CHAT_SEND, "nGroupID : " + j + " | nDstUserID : " + j2 + " | type : " + i + " | sSeqID : " + str + " | sData : " + str2);
    }

    private void OnChatSend(int i, String str, int i2) {
        OmniLog.jniCall("OnChatSend", "type : " + i + " | sSeqID : " + str + " | error : " + i2);
        for (int i3 = 0; i3 < this.mCallBacks.size(); i3++) {
            WeakReference weakReference = this.mCallBacks.get(i3);
            if (!(weakReference == null || weakReference.get() == null)) {
                ((ChatJniCallback) weakReference.get()).OnChatSend(this.mChatInfoManager.pop(str), i2);
            }
        }
    }

    public void OnPlayCompletion(String str) {
        for (int i = 0; i < this.mCallBacks.size(); i++) {
            WeakReference weakReference = this.mCallBacks.get(i);
            if (!(weakReference == null || weakReference.get() == null)) {
                ((ChatJniCallback) weakReference.get()).onPlayChatAudioCompletion(str);
            }
        }
    }

    private class ChatInfoManager {
        private ArrayList<ChatInfo> chatInfos;

        private ChatInfoManager() {
            this.chatInfos = new ArrayList<>();
        }

        public void put(ChatInfo chatInfo) {
            this.chatInfos.add(chatInfo);
        }

        public ChatInfo pop(String str) {
            for (int i = 0; i < this.chatInfos.size(); i++) {
                if (this.chatInfos.get(i).seqID.equals(str)) {
                    return this.chatInfos.remove(i);
                }
            }
            return null;
        }
    }
}
