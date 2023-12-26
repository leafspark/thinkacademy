package com.xueersi.lib.graffiti;

import android.os.SystemClock;
import com.xueersi.lib.graffiti.EngineViewInterface;
import com.xueersi.lib.graffiti.WXTGraffitiEngine;
import com.xueersi.lib.graffiti.WXWBAction;
import com.xueersi.lib.graffiti.db.DBOperator;
import com.xueersi.lib.graffiti.utils.ListUtil;
import com.xueersi.lib.graffiti.utils.XesLog;
import com.yalantis.ucrop.view.CropImageView;
import java.util.ArrayList;
import java.util.List;

public class ActionProducer implements EngineViewInterface.ProduceCallBack {
    private long lastSenderTimeStamp = 0;
    private final DBOperator mDBOperator;
    /* access modifiers changed from: private */
    public final WXTGraffitiEngineImpl mEngine;
    private final GraffitiActionBuilder mGraffitiActionBuilder;
    private final UniqueTimeStampGenerator mLineIndexGenerator = new UniqueTimeStampGenerator();
    private final UniqueTimeStampGenerator mMsgIdGenerator = new UniqueTimeStampGenerator();
    private final WorkExecutor mWorkExecutor;
    private final List<WXWBAction.PointData> senderBuffer = new ArrayList();

    public ActionProducer(WXTGraffitiEngineImpl wXTGraffitiEngineImpl, WorkExecutor workExecutor, DBOperator dBOperator) {
        this.mEngine = wXTGraffitiEngineImpl;
        this.mWorkExecutor = workExecutor;
        this.mDBOperator = dBOperator;
        this.mGraffitiActionBuilder = new GraffitiActionBuilder();
    }

    public void onGraffitiUpdate(int i, int i2, float f, float f2) {
        WorkExecutor workExecutor = this.mWorkExecutor;
        if (workExecutor != null) {
            final int i3 = i;
            final int i4 = i2;
            final float f3 = f;
            final float f4 = f2;
            workExecutor.submitTask(new Runnable() {
                public void run() {
                    ActionProducer.this.onGraffitiUpdateSync(i3, i4, f3, f4);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void onGraffitiUpdateSync(int i, int i2, float f, float f2) {
        WXWBAction.SendImpl sendImpl;
        WXWBAction.SendImpl mergePoints;
        int i3 = i2;
        float f3 = f;
        float f4 = f2;
        int sendDuration = this.mEngine.getSetting().getSendDuration();
        float penWidth = this.mEngine.getSetting().getPenWidth();
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    if (ListUtil.isEmpty(this.senderBuffer)) {
                        sendImpl = this.mGraffitiActionBuilder.pointUp(f3, f4, penWidth);
                    } else {
                        this.senderBuffer.add(new WXWBAction.PointData(2, f3, f4, penWidth));
                        sendImpl = this.mGraffitiActionBuilder.mergePoints(this.senderBuffer);
                        this.senderBuffer.clear();
                    }
                    this.lastSenderTimeStamp = 0;
                }
            } else if (SystemClock.uptimeMillis() - this.lastSenderTimeStamp < ((long) sendDuration)) {
                this.senderBuffer.add(new WXWBAction.PointData(1, f3, f4, penWidth));
            } else {
                if (ListUtil.isEmpty(this.senderBuffer)) {
                    mergePoints = this.mGraffitiActionBuilder.pointMove(f3, f4, penWidth);
                } else {
                    this.senderBuffer.add(new WXWBAction.PointData(1, f3, f4, penWidth));
                    mergePoints = this.mGraffitiActionBuilder.mergePoints(this.senderBuffer);
                    this.senderBuffer.clear();
                }
                this.lastSenderTimeStamp = SystemClock.uptimeMillis();
            }
            sendImpl = null;
        } else {
            this.senderBuffer.clear();
            sendImpl = this.mGraffitiActionBuilder.pointDown(f3, f4, penWidth);
            this.lastSenderTimeStamp = SystemClock.uptimeMillis();
        }
        if (sendImpl != null) {
            if (i > 0) {
                sendImpl.canvasInfo = new WXWBAction.CanvasInfo(i, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 0, 0);
            }
            this.mEngine.addAction(sendImpl, 1);
            if (XesLog.isEnabled()) {
                XesLog.d("发送数据" + sendImpl.toString());
            }
        }
    }

    public WXWBAction.SendImpl actionForActionType(int i) {
        WXWBAction.SendImpl sendImpl = new WXWBAction.SendImpl();
        sendImpl.messageType = i;
        WXTGraffitiEngine.Setting setting = this.mEngine.getSetting();
        sendImpl.width = setting.getWidth();
        sendImpl.height = setting.getHeight();
        long currentTimeStampMillis = this.mEngine.getSenderListener().getCurrentTimeStampMillis();
        if (currentTimeStampMillis <= 0) {
            currentTimeStampMillis = System.currentTimeMillis();
        }
        sendImpl.dataCreateTimestamp = currentTimeStampMillis;
        sendImpl.strokeColor = setting.getStrokeColor();
        sendImpl.fillColor = setting.getFillColor();
        sendImpl.pointType = setting.getPenStyle();
        if (setting.getPenStyle() == 1) {
            sendImpl.lineWidth = setting.getEraseWidth();
        } else {
            sendImpl.lineWidth = setting.getPenWidth();
        }
        sendImpl.lineType = setting.getLineType();
        long generateUniqueId = this.mEngine.getSenderListener().generateUniqueId(WXTGraffitiEngine.UniqueIdType.MSG_ID);
        if (generateUniqueId < 0) {
            generateUniqueId = this.mMsgIdGenerator.generateOne();
        }
        sendImpl.msgId = generateUniqueId;
        sendImpl.pageKey = this.mEngine.getPageKey();
        sendImpl.courseId = this.mEngine.mCourseId;
        sendImpl.pageId = this.mEngine.mPageId;
        sendImpl.uid = this.mEngine.mUid;
        sendImpl.userInfo = this.mEngine.mUserInfo;
        if (XesLog.isEnabled()) {
            XesLog.d("产生的msgId:" + sendImpl.msgId);
        }
        return sendImpl;
    }

    class GraffitiActionBuilder {
        private long mLineIndex = 0;

        GraffitiActionBuilder() {
        }

        public WXWBAction.SendImpl pointDown(float f, float f2, float f3) {
            this.mLineIndex = ActionProducer.this.newLineIndex();
            ActionProducer actionProducer = ActionProducer.this;
            WXWBAction.SendImpl actionForActionType = actionProducer.actionForActionType(actionProducer.mEngine.getSetting().getActionType());
            actionForActionType.lineIndex = this.mLineIndex;
            actionForActionType.addPoint(0, f, f2, f3);
            return actionForActionType;
        }

        public WXWBAction.SendImpl pointMove(float f, float f2, float f3) {
            ActionProducer actionProducer = ActionProducer.this;
            WXWBAction.SendImpl actionForActionType = actionProducer.actionForActionType(actionProducer.mEngine.getSetting().getActionType());
            actionForActionType.lineIndex = this.mLineIndex;
            actionForActionType.addPoint(1, f, f2, f3);
            return actionForActionType;
        }

        public WXWBAction.SendImpl mergePoints(List<WXWBAction.PointData> list) {
            ActionProducer actionProducer = ActionProducer.this;
            WXWBAction.SendImpl actionForActionType = actionProducer.actionForActionType(actionProducer.mEngine.getSetting().getActionType());
            actionForActionType.lineIndex = this.mLineIndex;
            actionForActionType.setPoints(list);
            return actionForActionType;
        }

        public WXWBAction.SendImpl pointUp(float f, float f2, float f3) {
            ActionProducer actionProducer = ActionProducer.this;
            WXWBAction.SendImpl actionForActionType = actionProducer.actionForActionType(actionProducer.mEngine.getSetting().getActionType());
            actionForActionType.lineIndex = this.mLineIndex;
            actionForActionType.addPoint(2, f, f2, f3);
            return actionForActionType;
        }
    }

    public long newLineIndex() {
        long generateUniqueId = this.mEngine.getSenderListener().generateUniqueId(WXTGraffitiEngine.UniqueIdType.LINE_INDEX);
        return generateUniqueId < 0 ? this.mLineIndexGenerator.generateOne() : generateUniqueId;
    }

    private class UniqueTimeStampGenerator {
        private long lastOne;

        private UniqueTimeStampGenerator() {
        }

        /* access modifiers changed from: package-private */
        public long generateOne() {
            long bizTimeStampMillis = ActionProducer.this.mEngine.getSetting().getBizTimeStampMillis();
            if (bizTimeStampMillis == this.lastOne) {
                bizTimeStampMillis++;
            }
            this.lastOne = bizTimeStampMillis;
            return bizTimeStampMillis;
        }
    }
}
