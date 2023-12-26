package com.wushuangtech.api;

import com.wushuangtech.bean.DataStreamBean;
import com.wushuangtech.bean.DataStreamPayloadBean;
import java.util.concurrent.ConcurrentHashMap;

public class RtcDataStreamManager extends RtcBaseManager {
    private ConcurrentHashMap<DataStreamBean, DataStreamPayloadBean> mDataStreamArray = new ConcurrentHashMap<>();
    private final long mUid;

    public RtcDataStreamManager(String str, Long l) {
        super(str);
        this.mUid = l.longValue();
    }

    public int createDataStream(boolean z, boolean z2) {
        int size;
        ConcurrentHashMap<DataStreamBean, DataStreamPayloadBean> concurrentHashMap = this.mDataStreamArray;
        if (concurrentHashMap == null || (size = concurrentHashMap.size()) > 5) {
            return -1;
        }
        int i = size + 1;
        DataStreamBean dataStreamBean = new DataStreamBean();
        dataStreamBean.mStreamId = i;
        dataStreamBean.mReliable = z;
        dataStreamBean.mOrdered = z2;
        concurrentHashMap.put(dataStreamBean, new DataStreamPayloadBean());
        return i;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: com.wushuangtech.bean.DataStreamPayloadBean} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean sendStreamMessage(int r9, byte[] r10) {
        /*
            r8 = this;
            java.util.concurrent.ConcurrentHashMap<com.wushuangtech.bean.DataStreamBean, com.wushuangtech.bean.DataStreamPayloadBean> r0 = r8.mDataStreamArray
            r1 = 1
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            r2 = 0
            java.util.Set r3 = r0.entrySet()
            java.util.Iterator r3 = r3.iterator()
            r4 = 0
            r5 = r4
        L_0x0011:
            boolean r6 = r3.hasNext()
            if (r6 == 0) goto L_0x0045
            java.lang.Object r5 = r3.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            java.lang.Object r6 = r5.getKey()
            com.wushuangtech.bean.DataStreamBean r6 = (com.wushuangtech.bean.DataStreamBean) r6
            int r7 = r6.mStreamId
            if (r9 != r7) goto L_0x0043
            java.lang.Object r3 = r5.getValue()
            r4 = r3
            com.wushuangtech.bean.DataStreamPayloadBean r4 = (com.wushuangtech.bean.DataStreamPayloadBean) r4
            boolean r3 = r4.mInited
            if (r3 != 0) goto L_0x003f
            r4.mDataStreamBean = r6
            java.lang.String r2 = r8.mChannelName
            r4.mChannelName = r2
            long r2 = r8.mUid
            r4.mUid = r2
            r4.mInited = r1
            r2 = r1
        L_0x003f:
            r4.mStreamData = r10
            r5 = r6
            goto L_0x0045
        L_0x0043:
            r5 = r6
            goto L_0x0011
        L_0x0045:
            if (r2 == 0) goto L_0x004a
            r0.put(r5, r4)
        L_0x004a:
            com.wushuangtech.jni.RoomJni r0 = com.wushuangtech.jni.RoomJni.getInstance()
            java.lang.String r2 = r8.mChannelName
            r0.SendCustomizedAudioMsg(r2, r9, r10)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.api.RtcDataStreamManager.sendStreamMessage(int, byte[]):boolean");
    }

    public void clearResource() {
        ConcurrentHashMap<DataStreamBean, DataStreamPayloadBean> concurrentHashMap = this.mDataStreamArray;
        if (concurrentHashMap != null) {
            concurrentHashMap.clear();
            this.mDataStreamArray = null;
        }
    }
}
