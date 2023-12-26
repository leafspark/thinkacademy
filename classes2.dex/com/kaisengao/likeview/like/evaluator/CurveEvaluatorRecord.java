package com.kaisengao.likeview.like.evaluator;

import android.animation.TypeEvaluator;
import android.graphics.PointF;
import android.util.SparseArray;
import java.util.Random;

public class CurveEvaluatorRecord {
    private static final int MAX_PATH_COUNTS = 100;
    private int mCurrentPathCounts;
    private SparseArray<TypeEvaluator<PointF>> mPathArray = new SparseArray<>();
    private final Random mRandom = new Random();

    public TypeEvaluator<PointF> getCurrentPath(PointF pointF, PointF pointF2) {
        int i = this.mCurrentPathCounts + 1;
        this.mCurrentPathCounts = i;
        if (i > 100) {
            return this.mPathArray.get(Math.abs(this.mRandom.nextInt() % 100) + 1);
        }
        TypeEvaluator<PointF> createPath = createPath(pointF, pointF2);
        this.mPathArray.put(this.mCurrentPathCounts, createPath);
        return createPath;
    }

    private TypeEvaluator<PointF> createPath(PointF pointF, PointF pointF2) {
        return new ThreeCurveEvaluator(pointF, pointF2);
    }

    public void destroy() {
        SparseArray<TypeEvaluator<PointF>> sparseArray = this.mPathArray;
        if (sparseArray != null) {
            sparseArray.clear();
            this.mPathArray = null;
        }
    }
}
