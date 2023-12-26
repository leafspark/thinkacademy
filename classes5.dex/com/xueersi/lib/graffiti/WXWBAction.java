package com.xueersi.lib.graffiti;

import android.text.TextUtils;
import com.google.protobuf.Internal;
import com.google.protobuf.MessageLite;
import com.xueersi.lib.graffiti.protobean.WXWBTCPPacketDataOuterClass;
import com.xueersi.lib.graffiti.utils.ListUtil;
import com.yalantis.ucrop.view.CropImageView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface WXWBAction {
    boolean checkPointEnd();

    <T extends MessageLite> T getBusiness(Class<T> cls) throws Exception;

    int getBusinessType();

    int getCanvasId();

    CanvasInfo getCanvasInfo();

    String getCourseId();

    PointData getCursorPosition();

    int getFillColor();

    long getLineIndex();

    int getLineType();

    float getLineWidth();

    int getMessageType();

    long getMsgId();

    byte[] getOriginData();

    String getPageKey();

    List<PointData> getPointList();

    int getPointType();

    RefConfig getRefConfig();

    float getRotation();

    SelectAreaConfig getSelectAreaConfig();

    int getStrokeColor();

    long getTimestamp();

    String getUid();

    String getUniqueKey();

    UserInfo getUserInfo();

    public static class Factory {
        public static WXWBAction actionForData(byte[] bArr, String str) throws Exception {
            if (bArr != null && !TextUtils.isEmpty(str)) {
                return new ReceiveImpl(bArr, str);
            }
            throw new IllegalArgumentException("actionForData() params must not be null");
        }
    }

    public static class SelectAreaConfig {
        private Map<Long, Offset> layerOffsetMap;
        private long[] lineIndexs;
        private Map<Long, Offset> lineOffsetMap;
        private long[] shapeIndexs;

        public void setLineIndexs(long[] jArr) {
            this.lineIndexs = jArr;
        }

        public void setShapeIndexs(long[] jArr) {
            this.shapeIndexs = jArr;
        }

        public void setLayerOffsetMap(Map<Long, Offset> map) {
            this.layerOffsetMap = map;
        }

        public void setLineOffsetMap(Map<Long, Offset> map) {
            this.lineOffsetMap = map;
        }

        public Map<Long, Offset> getLineOffsetMap() {
            return this.lineOffsetMap;
        }

        public long[] getLineIndexs() {
            return this.lineIndexs;
        }

        public Map<Long, Offset> getLayerOffsetMap() {
            return this.layerOffsetMap;
        }

        public long[] getShapeIndexs() {
            return this.shapeIndexs;
        }
    }

    public static class CanvasInfo {
        /* access modifiers changed from: private */
        public int canvasId = 1;
        private int fillColor;
        /* access modifiers changed from: private */
        public float height = 5.0f;
        /* access modifiers changed from: private */
        public float lineWidth;
        private int strokeColor;
        /* access modifiers changed from: private */
        public float width = 4.0f;
        /* access modifiers changed from: private */
        public float x = 2.0f;
        /* access modifiers changed from: private */
        public float y = 3.0f;

        public CanvasInfo(int i, float f, float f2, float f3, float f4, float f5, int i2, int i3) {
            this.canvasId = i;
            this.x = f;
            this.y = f2;
            this.width = f3;
            this.height = f4;
            this.lineWidth = f5;
            this.strokeColor = i2;
            this.fillColor = i3;
        }

        public int getCanvasId() {
            return this.canvasId;
        }

        public float getX() {
            return this.x;
        }

        public float getY() {
            return this.y;
        }

        public float getWidth() {
            return this.width;
        }

        public float getHeight() {
            return this.height;
        }

        public float getLineWidth() {
            return this.lineWidth;
        }

        public int getFillColor() {
            return this.fillColor;
        }

        public int getStrokeColor() {
            return this.strokeColor;
        }

        public String toString() {
            return "CanvasInfo{canvasId=" + this.canvasId + ", x=" + this.x + ", y=" + this.y + ", width=" + this.width + ", height=" + this.height + ", lineWidth=" + this.lineWidth + ", strokeColor=" + this.strokeColor + ", fillColor=" + this.fillColor + '}';
        }
    }

    public static class UserInfo {
        private String uname;

        public UserInfo(String str) {
            this.uname = str;
        }

        public String getUname() {
            return this.uname;
        }

        public void setUname(String str) {
            this.uname = str;
        }

        public String toString() {
            return "UserInfo{uname='" + this.uname + '\'' + '}';
        }
    }

    public static class RefConfig {
        /* access modifiers changed from: private */
        public String imgUrl;
        /* access modifiers changed from: private */
        public String refId;
        /* access modifiers changed from: private */
        public String text;

        public String getRefId() {
            return this.refId;
        }

        public void setRefId(String str) {
            this.refId = str;
        }

        public String getText() {
            return this.text;
        }

        public void setText(String str) {
            this.text = str;
        }

        public void setImgUrl(String str) {
            this.imgUrl = str;
        }

        public String getImgUrl() {
            return this.imgUrl;
        }

        public String toString() {
            return "WXWBRefConfig{refId='" + this.refId + '\'' + ", text='" + this.text + '\'' + ", imgUrl='" + this.imgUrl + '\'' + '}';
        }
    }

    public static class PointData {
        float lineWidth;
        /* access modifiers changed from: private */
        public int pointAction = 0;
        private float x;
        private float y;

        public PointData(int i, float f, float f2, float f3) {
            this.pointAction = i;
            this.x = f;
            this.y = f2;
            this.lineWidth = f3;
        }

        public float getX() {
            return this.x;
        }

        public float getY() {
            return this.y;
        }

        public void setX(float f) {
            this.x = f;
        }

        public void setY(float f) {
            this.y = f;
        }

        public int getPointAction() {
            return this.pointAction;
        }

        public float getLineWidth() {
            return this.lineWidth;
        }

        public String toString() {
            return "PointData{pointAction=" + this.pointAction + ", x=" + this.x + ", y=" + this.y + ", lineWidth=" + this.lineWidth + '}';
        }
    }

    public static class Offset {
        float offsetX = CropImageView.DEFAULT_ASPECT_RATIO;
        float offsetY = CropImageView.DEFAULT_ASPECT_RATIO;

        public Offset(float f, float f2) {
            this.offsetX = f;
            this.offsetY = f2;
        }

        public float getOffsetX() {
            return this.offsetX;
        }

        public float getOffsetY() {
            return this.offsetY;
        }
    }

    public static abstract class BaseWXWBAction implements WXWBAction {
        private boolean hasPointEnd = false;

        public PointData getCursorPosition() {
            return null;
        }

        public String getUniqueKey() {
            return getUid() + "_" + getCanvasId() + "_" + getMsgId() + "_" + getTimestamp();
        }

        public int getCanvasId() {
            CanvasInfo canvasInfo = getCanvasInfo();
            if (canvasInfo != null) {
                return canvasInfo.canvasId;
            }
            return 0;
        }

        public boolean checkPointEnd() {
            if (this.hasPointEnd) {
                return true;
            }
            List<PointData> pointList = getPointList();
            if (!ListUtil.isNotEmpty(pointList)) {
                return false;
            }
            for (PointData next : pointList) {
                if (next != null && next.pointAction == 2) {
                    this.hasPointEnd = true;
                    return true;
                }
            }
            return false;
        }
    }

    public static class ReceiveImpl extends BaseWXWBAction {
        private Object businessObj;
        private CanvasInfo canvasInfo;
        private PointData mCursorPosition;
        private String mCustomPageKey;
        private final String mPageKey;
        private final byte[] originData;
        private final WXWBTCPPacketDataOuterClass.WXWBTCPPacketData pbData;
        private volatile List<PointData> pointList;
        private RefConfig refConfig;
        private volatile SelectAreaConfig selectAreaConfig;
        private UserInfo userInfo;

        public ReceiveImpl(byte[] bArr) throws Exception {
            this(bArr, (String) null);
        }

        public ReceiveImpl(byte[] bArr, String str) throws Exception {
            this.originData = bArr;
            this.pbData = WXWBTCPPacketDataOuterClass.WXWBTCPPacketData.parseFrom(bArr);
            this.mPageKey = str;
        }

        public int getMessageType() {
            return this.pbData.getTypeValue();
        }

        public int getPointType() {
            return this.pbData.getPointTypeValue();
        }

        public String getPageKey() {
            if (!TextUtils.isEmpty(this.mPageKey)) {
                return this.mPageKey;
            }
            return this.pbData.getPageId();
        }

        public long getMsgId() {
            return this.pbData.getMsgId();
        }

        public byte[] getOriginData() {
            return this.originData;
        }

        public long getTimestamp() {
            return this.pbData.getDataCreateTimestamp();
        }

        public float getRotation() {
            return this.pbData.getRotation();
        }

        public float getLineWidth() {
            return this.pbData.getLineWidth();
        }

        public int getStrokeColor() {
            return this.pbData.getStrokeColor();
        }

        public int getLineType() {
            return this.pbData.getLineTypeValue();
        }

        public long getLineIndex() {
            return this.pbData.getLineIndex();
        }

        public int getFillColor() {
            return this.pbData.getFillColor();
        }

        public String getUid() {
            return this.pbData.getUid();
        }

        public List<PointData> getPointList() {
            if (this.pointList == null) {
                synchronized (this) {
                    if (this.pointList == null) {
                        ArrayList arrayList = new ArrayList();
                        if (this.pbData.getPointListCount() > 0) {
                            for (WXWBTCPPacketDataOuterClass.WXWBPoint next : this.pbData.getPointListList()) {
                                arrayList.add(new PointData(next.getActionValue(), next.getX(), next.getY(), next.getLineWidth()));
                            }
                        }
                        this.pointList = arrayList;
                    }
                }
            }
            return this.pointList;
        }

        public CanvasInfo getCanvasInfo() {
            WXWBTCPPacketDataOuterClass.WXWBCanvasInfo canvasInfo2;
            if (this.canvasInfo == null && (canvasInfo2 = this.pbData.getCanvasInfo()) != null) {
                this.canvasInfo = new CanvasInfo(canvasInfo2.getCanvasId(), canvasInfo2.getX(), canvasInfo2.getY(), canvasInfo2.getWidth(), canvasInfo2.getHeight(), canvasInfo2.getLineWidth(), canvasInfo2.getStrokeColor(), canvasInfo2.getFillColor());
            }
            return this.canvasInfo;
        }

        public SelectAreaConfig getSelectAreaConfig() {
            WXWBTCPPacketDataOuterClass.WXWBTCPPacketData wXWBTCPPacketData;
            WXWBTCPPacketDataOuterClass.WXWBSelectAreaConfig selectConfig;
            if (!(this.selectAreaConfig != null || (wXWBTCPPacketData = this.pbData) == null || (selectConfig = wXWBTCPPacketData.getSelectConfig()) == null)) {
                SelectAreaConfig selectAreaConfig2 = new SelectAreaConfig();
                long[] longArrayDataFromPbData = getLongArrayDataFromPbData(selectConfig.getLineIndexsList());
                if (longArrayDataFromPbData != null && longArrayDataFromPbData.length > 0) {
                    selectAreaConfig2.setLineIndexs(longArrayDataFromPbData);
                }
                Map<Long, Offset> lineOffMapDataFromPbData = getLineOffMapDataFromPbData(selectConfig.getLineOffsetsMap());
                if (lineOffMapDataFromPbData != null && !lineOffMapDataFromPbData.isEmpty()) {
                    selectAreaConfig2.setLineOffsetMap(lineOffMapDataFromPbData);
                }
                long[] longArrayDataFromPbData2 = getLongArrayDataFromPbData(selectConfig.getShapeIndexsList());
                if (longArrayDataFromPbData2 != null && longArrayDataFromPbData2.length > 0) {
                    selectAreaConfig2.setShapeIndexs(longArrayDataFromPbData2);
                }
                Map<Long, Offset> shapeMapDataFromPbData = getShapeMapDataFromPbData(selectConfig.getLayerLocsMap());
                if (shapeMapDataFromPbData != null && !shapeMapDataFromPbData.isEmpty()) {
                    selectAreaConfig2.setLayerOffsetMap(shapeMapDataFromPbData);
                }
                this.selectAreaConfig = selectAreaConfig2;
            }
            return this.selectAreaConfig;
        }

        private long[] getLongArrayDataFromPbData(List<Long> list) {
            if (list == null || list.isEmpty()) {
                return new long[0];
            }
            long[] jArr = new long[list.size()];
            for (int i = 0; i < list.size(); i++) {
                jArr[i] = list.get(i).longValue();
            }
            return jArr;
        }

        private Map<Long, Offset> getLineOffMapDataFromPbData(Map<Long, WXWBTCPPacketDataOuterClass.WXWBOffset> map) {
            if (map == null || map.isEmpty()) {
                return null;
            }
            HashMap hashMap = new HashMap();
            for (Map.Entry next : map.entrySet()) {
                if (next != null) {
                    WXWBTCPPacketDataOuterClass.WXWBOffset wXWBOffset = (WXWBTCPPacketDataOuterClass.WXWBOffset) next.getValue();
                    Long l = (Long) next.getKey();
                    if (wXWBOffset != null) {
                        hashMap.put(l, new Offset(wXWBOffset.getOffsetX(), wXWBOffset.getOffsetY()));
                    }
                }
            }
            return hashMap;
        }

        private Map<Long, Offset> getShapeMapDataFromPbData(Map<Long, WXWBTCPPacketDataOuterClass.WXWBChooseShapeOffset> map) {
            if (map == null || map.isEmpty()) {
                return null;
            }
            HashMap hashMap = new HashMap();
            for (Map.Entry next : map.entrySet()) {
                if (next != null) {
                    WXWBTCPPacketDataOuterClass.WXWBChooseShapeOffset wXWBChooseShapeOffset = (WXWBTCPPacketDataOuterClass.WXWBChooseShapeOffset) next.getValue();
                    Long l = (Long) next.getKey();
                    if (wXWBChooseShapeOffset != null) {
                        hashMap.put(l, new Offset(wXWBChooseShapeOffset.getStartOffsetX(), wXWBChooseShapeOffset.getStartOffsetY()));
                    }
                }
            }
            return hashMap;
        }

        public String getCourseId() {
            return this.pbData.getCourseId();
        }

        public UserInfo getUserInfo() {
            WXWBTCPPacketDataOuterClass.WXWBUserInfo userInfo2;
            if (this.userInfo == null && (userInfo2 = this.pbData.getUserInfo()) != null) {
                this.userInfo = new UserInfo(userInfo2.getUname());
            }
            return this.userInfo;
        }

        public RefConfig getRefConfig() {
            if (this.refConfig == null) {
                synchronized (this) {
                    WXWBTCPPacketDataOuterClass.WXWBRefConfig refConfig2 = this.pbData.getRefConfig();
                    if (this.refConfig == null && refConfig2 != null) {
                        RefConfig refConfig3 = new RefConfig();
                        String unused = refConfig3.refId = refConfig2.getRefId();
                        String unused2 = refConfig3.text = refConfig2.getText();
                        String unused3 = refConfig3.imgUrl = refConfig3.getImgUrl();
                        this.refConfig = refConfig3;
                    }
                }
            }
            return this.refConfig;
        }

        public synchronized PointData getCursorPosition() {
            WXWBTCPPacketDataOuterClass.WXWBPoint cursorPosition;
            if (this.mCursorPosition == null && (cursorPosition = this.pbData.getCursorPosition()) != null) {
                this.mCursorPosition = new PointData(cursorPosition.getActionValue(), cursorPosition.getX(), cursorPosition.getY(), cursorPosition.getLineWidth());
            }
            return this.mCursorPosition;
        }

        public String toString() {
            return "ReceiveImpl:pbData:" + this.pbData.toString();
        }

        public <T extends MessageLite> T getBusiness(Class<T> cls) throws Exception {
            Object obj = this.businessObj;
            if (obj != null && obj.getClass() == cls) {
                return (MessageLite) this.businessObj;
            }
            if (this.pbData.getMyBusiness() != null) {
                T t = (MessageLite) Internal.getDefaultInstance(cls).getParserForType().parseFrom(this.pbData.getMyBusiness().getValue());
                this.businessObj = t;
                return (MessageLite) t;
            }
            throw new IllegalArgumentException("pb's member 'myBusiness' is null");
        }

        public int getBusinessType() {
            return this.pbData.getBusinessType();
        }
    }

    public static class SendImpl extends BaseWXWBAction {
        public byte[] byteData;
        public CanvasInfo canvasInfo;
        public String courseId;
        public long dataCreateTimestamp;
        public int fillColor;
        public int height;
        public long lineIndex;
        public int lineType;
        public float lineWidth;
        public int messageType;
        public long msgId;
        public String pageId;
        String pageKey;
        public List<PointData> pointList;
        public int pointType;
        public RefConfig refConfig;
        public float rotation;
        private SelectAreaConfig selectAreaConfig;
        public int strokeColor;
        public String uid;
        public UserInfo userInfo;
        public int width;

        public <T extends MessageLite> T getBusiness(Class<T> cls) {
            return null;
        }

        public int getBusinessType() {
            return 0;
        }

        /* access modifiers changed from: package-private */
        public void addPoint(int i, float f, float f2, float f3) {
            if (this.pointList == null) {
                this.pointList = new ArrayList();
            }
            this.pointList.add(new PointData(i, f, f2, f3));
        }

        /* access modifiers changed from: package-private */
        public void setPoints(List<PointData> list) {
            if (this.pointList == null) {
                this.pointList = new ArrayList();
            }
            this.pointList.addAll(list);
        }

        public int getMessageType() {
            return this.messageType;
        }

        public int getPointType() {
            return this.pointType;
        }

        public String getPageKey() {
            return this.pageKey;
        }

        public long getMsgId() {
            return this.msgId;
        }

        public synchronized byte[] getOriginData() {
            if (this.byteData == null) {
                this.byteData = encode();
            }
            return this.byteData;
        }

        public long getTimestamp() {
            return this.dataCreateTimestamp;
        }

        public float getRotation() {
            return this.rotation;
        }

        public float getLineWidth() {
            return this.lineWidth;
        }

        public int getStrokeColor() {
            return this.strokeColor;
        }

        public int getLineType() {
            return this.lineType;
        }

        public long getLineIndex() {
            return this.lineIndex;
        }

        public int getFillColor() {
            return this.fillColor;
        }

        public String getUid() {
            return this.uid;
        }

        public List<PointData> getPointList() {
            return this.pointList;
        }

        public CanvasInfo getCanvasInfo() {
            return this.canvasInfo;
        }

        public void setSelectAreaConfig(SelectAreaConfig selectAreaConfig2) {
            this.selectAreaConfig = selectAreaConfig2;
        }

        public SelectAreaConfig getSelectAreaConfig() {
            return this.selectAreaConfig;
        }

        public String getCourseId() {
            return this.courseId;
        }

        public UserInfo getUserInfo() {
            return this.userInfo;
        }

        public RefConfig getRefConfig() {
            return this.refConfig;
        }

        /* access modifiers changed from: package-private */
        public byte[] encode() {
            WXWBTCPPacketDataOuterClass.WXWBTCPPacketData.Builder newBuilder = WXWBTCPPacketDataOuterClass.WXWBTCPPacketData.newBuilder();
            newBuilder.setTypeValue(this.messageType);
            newBuilder.setPointTypeValue(this.pointType);
            newBuilder.setPageId(this.pageKey);
            newBuilder.setWidth(this.width);
            newBuilder.setHeight(this.height);
            newBuilder.setLineIndex(this.lineIndex);
            newBuilder.setMsgId(this.msgId);
            newBuilder.setLineWidth(this.lineWidth);
            newBuilder.setStrokeColor(this.strokeColor);
            newBuilder.setFillColor(this.fillColor);
            newBuilder.setDataCreateTimestamp(this.dataCreateTimestamp);
            newBuilder.setLineTypeValue(this.lineType);
            String str = this.uid;
            if (str != null) {
                newBuilder.setUid(str);
            }
            String str2 = this.courseId;
            if (str2 != null) {
                newBuilder.setCourseId(str2);
            }
            String str3 = this.pageId;
            if (str3 != null) {
                newBuilder.setPageId(str3);
            }
            if (this.pointList != null) {
                for (int i = 0; i < this.pointList.size(); i++) {
                    PointData pointData = this.pointList.get(i);
                    WXWBTCPPacketDataOuterClass.WXWBPoint.Builder newBuilder2 = WXWBTCPPacketDataOuterClass.WXWBPoint.newBuilder();
                    newBuilder2.setActionValue(pointData.getPointAction());
                    newBuilder2.setX(pointData.getX());
                    newBuilder2.setY(pointData.getY());
                    newBuilder2.setLineWidth(pointData.getLineWidth());
                    newBuilder.addPointList(i, newBuilder2);
                }
            }
            if (this.canvasInfo != null) {
                WXWBTCPPacketDataOuterClass.WXWBCanvasInfo.Builder newBuilder3 = WXWBTCPPacketDataOuterClass.WXWBCanvasInfo.newBuilder();
                newBuilder3.setCanvasId(this.canvasInfo.canvasId);
                newBuilder3.setWidth(this.canvasInfo.width);
                newBuilder3.setHeight(this.canvasInfo.height);
                newBuilder3.setX(this.canvasInfo.x);
                newBuilder3.setY(this.canvasInfo.y);
                newBuilder3.setLineWidth(this.canvasInfo.lineWidth);
                newBuilder3.setStrokeColor(this.canvasInfo.getStrokeColor());
                newBuilder3.setFillColor(this.canvasInfo.getFillColor());
                newBuilder.setCanvasInfo(newBuilder3);
            }
            SelectAreaConfig selectAreaConfig2 = this.selectAreaConfig;
            if (!(selectAreaConfig2 == null || selectAreaConfig2.getLineIndexs() == null)) {
                WXWBTCPPacketDataOuterClass.WXWBSelectAreaConfig.Builder newBuilder4 = WXWBTCPPacketDataOuterClass.WXWBSelectAreaConfig.newBuilder();
                for (long addLineIndexs : this.selectAreaConfig.getLineIndexs()) {
                    newBuilder4.addLineIndexs(addLineIndexs);
                }
                newBuilder.setSelectConfig(newBuilder4);
            }
            if (this.userInfo != null) {
                WXWBTCPPacketDataOuterClass.WXWBUserInfo.Builder newBuilder5 = WXWBTCPPacketDataOuterClass.WXWBUserInfo.newBuilder();
                if (this.userInfo.getUname() != null) {
                    newBuilder5.setUname(this.userInfo.getUname());
                }
                newBuilder.setUserInfo(newBuilder5);
            }
            if (this.refConfig != null) {
                WXWBTCPPacketDataOuterClass.WXWBRefConfig.Builder newBuilder6 = WXWBTCPPacketDataOuterClass.WXWBRefConfig.newBuilder();
                if (this.refConfig.refId != null) {
                    newBuilder6.setRefId(this.refConfig.refId);
                }
                if (this.refConfig.text != null) {
                    newBuilder6.setText(this.refConfig.text);
                }
                if (this.refConfig.imgUrl != null) {
                    newBuilder6.setImgUrl(this.refConfig.imgUrl);
                }
                newBuilder.setRefConfig(newBuilder6);
            }
            return newBuilder.build().toByteArray();
        }
    }
}
