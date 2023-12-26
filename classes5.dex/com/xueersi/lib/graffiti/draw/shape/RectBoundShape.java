package com.xueersi.lib.graffiti.draw.shape;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.xueersi.lib.graffiti.WXWBAction;
import com.xueersi.lib.graffiti.utils.XesLog;
import java.util.List;

public class RectBoundShape extends BaseShape {
    private Paint mDebugPaint;
    protected Rect rect = new Rect();

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
    }

    /* access modifiers changed from: protected */
    public void updateActionData(WXWBAction wXWBAction) {
        List<WXWBAction.PointData> pointList = wXWBAction.getPointList();
        if (pointList != null && pointList.size() >= 2) {
            WXWBAction.PointData pointData = pointList.get(0);
            float relativeX = relativeX(pointData.getX());
            float relativeY = relativeY(pointData.getY());
            WXWBAction.PointData pointData2 = pointList.get(1);
            float relativeX2 = relativeX(pointData2.getX());
            float relativeY2 = relativeY(pointData2.getY());
            if (XesLog.isEnabled()) {
                XesLog.d("RectBoundShape=" + relativeX + "," + relativeY + "," + relativeX2 + "," + relativeY2 + " ," + this.mLineWidth);
            }
            this.rect.set((int) Math.min(relativeX, relativeX2), (int) Math.min(relativeY, relativeY2), (int) Math.max(relativeX, relativeX2), (int) Math.max(relativeY, relativeY2));
            setRotateCenter((float) this.rect.centerX(), (float) this.rect.centerY());
        }
    }
}
