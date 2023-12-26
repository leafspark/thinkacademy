package com.xueersi.lib.graffiti.draw;

import com.xueersi.lib.graffiti.WXWBAction;
import com.yalantis.ucrop.view.CropImageView;
import java.util.ArrayList;
import java.util.List;

public class PointData {
    private int fillColor;
    private int lineType;
    private float lineWidth;
    private List<Point> pointList;
    private float rotation;
    private int strokeColor;

    public PointData(WXWBAction wXWBAction) {
        this.strokeColor = wXWBAction.getStrokeColor();
        this.fillColor = wXWBAction.getFillColor();
        this.rotation = wXWBAction.getRotation();
        this.lineWidth = wXWBAction.getLineWidth();
        this.lineType = wXWBAction.getLineType();
        List<WXWBAction.PointData> pointList2 = wXWBAction.getPointList();
        this.pointList = new ArrayList();
        if (pointList2 != null) {
            for (WXWBAction.PointData next : pointList2) {
                this.pointList.add(new Point(next.getPointAction(), next.getX(), next.getY(), CropImageView.DEFAULT_ASPECT_RATIO));
            }
        }
    }

    public PointData(int i, int i2, float f, float f2, int i3, List<Point> list) {
        this.strokeColor = i;
        this.fillColor = i2;
        this.rotation = f;
        this.lineWidth = f2;
        this.lineType = i3;
        this.pointList = list;
    }

    public List<Point> getPointList() {
        return this.pointList;
    }

    public int getFillColor() {
        return this.fillColor;
    }

    public float getLineWidth() {
        return this.lineWidth;
    }

    public float getRotation() {
        return this.rotation;
    }

    public int getLineType() {
        return this.lineType;
    }

    public int getStrokeColor() {
        return this.strokeColor;
    }

    public static class Point {
        int action;
        float lineWidth;
        float x;
        float y;

        public Point(int i, float f, float f2, float f3) {
            this.action = i;
            this.x = f;
            this.y = f2;
            this.lineWidth = f3;
        }

        public int getAction() {
            return this.action;
        }

        public float getX() {
            return this.x;
        }

        public float getY() {
            return this.y;
        }

        public float getLineWidth() {
            return this.lineWidth;
        }
    }
}
