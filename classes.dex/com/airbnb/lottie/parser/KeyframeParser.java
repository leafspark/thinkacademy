package com.airbnb.lottie.parser;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.collection.SparseArrayCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.Keyframe;
import java.io.IOException;
import java.lang.ref.WeakReference;

class KeyframeParser {
    static JsonReader.Options INTERPOLATOR_NAMES = JsonReader.Options.of("x", "y");
    private static final Interpolator LINEAR_INTERPOLATOR = new LinearInterpolator();
    private static final float MAX_CP_VALUE = 100.0f;
    static JsonReader.Options NAMES = JsonReader.Options.of("t", "s", "e", "o", "i", "h", "to", "ti");
    private static SparseArrayCompat<WeakReference<Interpolator>> pathInterpolatorCache;

    KeyframeParser() {
    }

    private static SparseArrayCompat<WeakReference<Interpolator>> pathInterpolatorCache() {
        if (pathInterpolatorCache == null) {
            pathInterpolatorCache = new SparseArrayCompat<>();
        }
        return pathInterpolatorCache;
    }

    private static WeakReference<Interpolator> getInterpolator(int i) {
        WeakReference<Interpolator> weakReference;
        synchronized (KeyframeParser.class) {
            weakReference = pathInterpolatorCache().get(i);
        }
        return weakReference;
    }

    private static void putInterpolator(int i, WeakReference<Interpolator> weakReference) {
        synchronized (KeyframeParser.class) {
            pathInterpolatorCache.put(i, weakReference);
        }
    }

    static <T> Keyframe<T> parse(JsonReader jsonReader, LottieComposition lottieComposition, float f, ValueParser<T> valueParser, boolean z, boolean z2) throws IOException {
        if (z && z2) {
            return parseMultiDimensionalKeyframe(lottieComposition, jsonReader, f, valueParser);
        }
        if (z) {
            return parseKeyframe(lottieComposition, jsonReader, f, valueParser);
        }
        return parseStaticValue(jsonReader, f, valueParser);
    }

    private static <T> Keyframe<T> parseKeyframe(LottieComposition lottieComposition, JsonReader jsonReader, float f, ValueParser<T> valueParser) throws IOException {
        Interpolator interpolator;
        T t;
        Interpolator interpolator2;
        jsonReader.beginObject();
        PointF pointF = null;
        boolean z = false;
        T t2 = null;
        T t3 = null;
        PointF pointF2 = null;
        PointF pointF3 = null;
        float f2 = 0.0f;
        PointF pointF4 = null;
        while (jsonReader.hasNext()) {
            switch (jsonReader.selectName(NAMES)) {
                case 0:
                    f2 = (float) jsonReader.nextDouble();
                    break;
                case 1:
                    t3 = valueParser.parse(jsonReader, f);
                    break;
                case 2:
                    t2 = valueParser.parse(jsonReader, f);
                    break;
                case 3:
                    pointF = JsonUtils.jsonToPoint(jsonReader, 1.0f);
                    break;
                case 4:
                    pointF4 = JsonUtils.jsonToPoint(jsonReader, 1.0f);
                    break;
                case 5:
                    if (jsonReader.nextInt() != 1) {
                        z = false;
                        break;
                    } else {
                        z = true;
                        break;
                    }
                case 6:
                    pointF2 = JsonUtils.jsonToPoint(jsonReader, f);
                    break;
                case 7:
                    pointF3 = JsonUtils.jsonToPoint(jsonReader, f);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        if (z) {
            interpolator = LINEAR_INTERPOLATOR;
            t = t3;
        } else {
            if (pointF == null || pointF4 == null) {
                interpolator2 = LINEAR_INTERPOLATOR;
            } else {
                interpolator2 = interpolatorFor(pointF, pointF4);
            }
            interpolator = interpolator2;
            t = t2;
        }
        Keyframe keyframe = new Keyframe(lottieComposition, t3, t, interpolator, f2, (Float) null);
        keyframe.pathCp1 = pointF2;
        keyframe.pathCp2 = pointF3;
        return keyframe;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x017b, code lost:
        r14 = r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static <T> com.airbnb.lottie.value.Keyframe<T> parseMultiDimensionalKeyframe(com.airbnb.lottie.LottieComposition r20, com.airbnb.lottie.parser.moshi.JsonReader r21, float r22, com.airbnb.lottie.parser.ValueParser<T> r23) throws java.io.IOException {
        /*
            r0 = r21
            r1 = r22
            r2 = r23
            r21.beginObject()
            r3 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
        L_0x0016:
            boolean r17 = r21.hasNext()
            if (r17 == 0) goto L_0x01a6
            com.airbnb.lottie.parser.moshi.JsonReader$Options r4 = NAMES
            int r4 = r0.selectName(r4)
            r5 = 1
            switch(r4) {
                case 0: goto L_0x0199;
                case 1: goto L_0x018f;
                case 2: goto L_0x0185;
                case 3: goto L_0x00ed;
                case 4: goto L_0x0044;
                case 5: goto L_0x003a;
                case 6: goto L_0x0035;
                case 7: goto L_0x0030;
                default: goto L_0x0026;
            }
        L_0x0026:
            r19 = r3
            r3 = r14
            r18 = r15
            r21.skipValue()
            goto L_0x01a2
        L_0x0030:
            android.graphics.PointF r3 = com.airbnb.lottie.parser.JsonUtils.jsonToPoint(r21, r22)
            goto L_0x0016
        L_0x0035:
            android.graphics.PointF r15 = com.airbnb.lottie.parser.JsonUtils.jsonToPoint(r21, r22)
            goto L_0x0016
        L_0x003a:
            int r4 = r21.nextInt()
            if (r4 != r5) goto L_0x0042
            r6 = r5
            goto L_0x0016
        L_0x0042:
            r6 = 0
            goto L_0x0016
        L_0x0044:
            com.airbnb.lottie.parser.moshi.JsonReader$Token r4 = r21.peek()
            com.airbnb.lottie.parser.moshi.JsonReader$Token r5 = com.airbnb.lottie.parser.moshi.JsonReader.Token.BEGIN_OBJECT
            if (r4 != r5) goto L_0x00e2
            r21.beginObject()
            r4 = 0
            r5 = 0
            r12 = 0
            r13 = 0
        L_0x0053:
            boolean r18 = r21.hasNext()
            if (r18 == 0) goto L_0x00cc
            r18 = r15
            com.airbnb.lottie.parser.moshi.JsonReader$Options r15 = INTERPOLATOR_NAMES
            int r15 = r0.selectName(r15)
            if (r15 == 0) goto L_0x009d
            r19 = r3
            r3 = 1
            if (r15 == r3) goto L_0x0070
            r21.skipValue()
        L_0x006b:
            r15 = r18
            r3 = r19
            goto L_0x0053
        L_0x0070:
            com.airbnb.lottie.parser.moshi.JsonReader$Token r3 = r21.peek()
            com.airbnb.lottie.parser.moshi.JsonReader$Token r5 = com.airbnb.lottie.parser.moshi.JsonReader.Token.NUMBER
            if (r3 != r5) goto L_0x0081
            r3 = r14
            double r13 = r21.nextDouble()
            float r13 = (float) r13
            r14 = r3
            r5 = r13
            goto L_0x006b
        L_0x0081:
            r3 = r14
            r21.beginArray()
            double r13 = r21.nextDouble()
            float r5 = (float) r13
            com.airbnb.lottie.parser.moshi.JsonReader$Token r13 = r21.peek()
            com.airbnb.lottie.parser.moshi.JsonReader$Token r14 = com.airbnb.lottie.parser.moshi.JsonReader.Token.NUMBER
            if (r13 != r14) goto L_0x0098
            double r13 = r21.nextDouble()
            float r13 = (float) r13
            goto L_0x0099
        L_0x0098:
            r13 = r5
        L_0x0099:
            r21.endArray()
            goto L_0x00ca
        L_0x009d:
            r19 = r3
            r3 = r14
            com.airbnb.lottie.parser.moshi.JsonReader$Token r4 = r21.peek()
            com.airbnb.lottie.parser.moshi.JsonReader$Token r12 = com.airbnb.lottie.parser.moshi.JsonReader.Token.NUMBER
            if (r4 != r12) goto L_0x00b0
            double r14 = r21.nextDouble()
            float r12 = (float) r14
            r14 = r3
            r4 = r12
            goto L_0x006b
        L_0x00b0:
            r21.beginArray()
            double r14 = r21.nextDouble()
            float r4 = (float) r14
            com.airbnb.lottie.parser.moshi.JsonReader$Token r12 = r21.peek()
            com.airbnb.lottie.parser.moshi.JsonReader$Token r14 = com.airbnb.lottie.parser.moshi.JsonReader.Token.NUMBER
            if (r12 != r14) goto L_0x00c6
            double r14 = r21.nextDouble()
            float r12 = (float) r14
            goto L_0x00c7
        L_0x00c6:
            r12 = r4
        L_0x00c7:
            r21.endArray()
        L_0x00ca:
            r14 = r3
            goto L_0x006b
        L_0x00cc:
            r19 = r3
            r3 = r14
            r18 = r15
            android.graphics.PointF r14 = new android.graphics.PointF
            r14.<init>(r4, r5)
            android.graphics.PointF r4 = new android.graphics.PointF
            r4.<init>(r12, r13)
            r21.endObject()
            r13 = r4
            r12 = r14
            goto L_0x017b
        L_0x00e2:
            r19 = r3
            r3 = r14
            r18 = r15
            android.graphics.PointF r8 = com.airbnb.lottie.parser.JsonUtils.jsonToPoint(r21, r22)
            goto L_0x01a2
        L_0x00ed:
            r19 = r3
            r3 = r14
            r18 = r15
            com.airbnb.lottie.parser.moshi.JsonReader$Token r4 = r21.peek()
            com.airbnb.lottie.parser.moshi.JsonReader$Token r5 = com.airbnb.lottie.parser.moshi.JsonReader.Token.BEGIN_OBJECT
            if (r4 != r5) goto L_0x017d
            r21.beginObject()
            r4 = 0
            r5 = 0
            r9 = 0
            r11 = 0
        L_0x0101:
            boolean r14 = r21.hasNext()
            if (r14 == 0) goto L_0x016a
            com.airbnb.lottie.parser.moshi.JsonReader$Options r14 = INTERPOLATOR_NAMES
            int r14 = r0.selectName(r14)
            if (r14 == 0) goto L_0x0140
            r15 = 1
            if (r14 == r15) goto L_0x0116
            r21.skipValue()
            goto L_0x0101
        L_0x0116:
            com.airbnb.lottie.parser.moshi.JsonReader$Token r5 = r21.peek()
            com.airbnb.lottie.parser.moshi.JsonReader$Token r11 = com.airbnb.lottie.parser.moshi.JsonReader.Token.NUMBER
            if (r5 != r11) goto L_0x0125
            double r14 = r21.nextDouble()
            float r11 = (float) r14
            r5 = r11
            goto L_0x0101
        L_0x0125:
            r21.beginArray()
            double r14 = r21.nextDouble()
            float r5 = (float) r14
            com.airbnb.lottie.parser.moshi.JsonReader$Token r11 = r21.peek()
            com.airbnb.lottie.parser.moshi.JsonReader$Token r14 = com.airbnb.lottie.parser.moshi.JsonReader.Token.NUMBER
            if (r11 != r14) goto L_0x013b
            double r14 = r21.nextDouble()
            float r11 = (float) r14
            goto L_0x013c
        L_0x013b:
            r11 = r5
        L_0x013c:
            r21.endArray()
            goto L_0x0101
        L_0x0140:
            com.airbnb.lottie.parser.moshi.JsonReader$Token r4 = r21.peek()
            com.airbnb.lottie.parser.moshi.JsonReader$Token r9 = com.airbnb.lottie.parser.moshi.JsonReader.Token.NUMBER
            if (r4 != r9) goto L_0x014f
            double r14 = r21.nextDouble()
            float r9 = (float) r14
            r4 = r9
            goto L_0x0101
        L_0x014f:
            r21.beginArray()
            double r14 = r21.nextDouble()
            float r4 = (float) r14
            com.airbnb.lottie.parser.moshi.JsonReader$Token r9 = r21.peek()
            com.airbnb.lottie.parser.moshi.JsonReader$Token r14 = com.airbnb.lottie.parser.moshi.JsonReader.Token.NUMBER
            if (r9 != r14) goto L_0x0165
            double r14 = r21.nextDouble()
            float r9 = (float) r14
            goto L_0x0166
        L_0x0165:
            r9 = r4
        L_0x0166:
            r21.endArray()
            goto L_0x0101
        L_0x016a:
            android.graphics.PointF r14 = new android.graphics.PointF
            r14.<init>(r4, r5)
            android.graphics.PointF r4 = new android.graphics.PointF
            r4.<init>(r9, r11)
            r21.endObject()
            r11 = r4
            r9 = r14
            r15 = r18
        L_0x017b:
            r14 = r3
            goto L_0x01a2
        L_0x017d:
            android.graphics.PointF r7 = com.airbnb.lottie.parser.JsonUtils.jsonToPoint(r21, r22)
            r14 = r3
            r15 = r18
            goto L_0x01a2
        L_0x0185:
            r19 = r3
            r3 = r14
            r18 = r15
            java.lang.Object r16 = r2.parse(r0, r1)
            goto L_0x01a2
        L_0x018f:
            r19 = r3
            r3 = r14
            r18 = r15
            java.lang.Object r10 = r2.parse(r0, r1)
            goto L_0x01a2
        L_0x0199:
            r19 = r3
            r18 = r15
            double r3 = r21.nextDouble()
            float r14 = (float) r3
        L_0x01a2:
            r3 = r19
            goto L_0x0016
        L_0x01a6:
            r19 = r3
            r3 = r14
            r18 = r15
            r21.endObject()
            if (r6 == 0) goto L_0x01b6
            android.view.animation.Interpolator r0 = LINEAR_INTERPOLATOR
            r11 = r10
        L_0x01b3:
            r12 = 0
            r13 = 0
            goto L_0x01da
        L_0x01b6:
            if (r7 == 0) goto L_0x01bf
            if (r8 == 0) goto L_0x01bf
            android.view.animation.Interpolator r0 = interpolatorFor(r7, r8)
            goto L_0x01d7
        L_0x01bf:
            if (r9 == 0) goto L_0x01d5
            if (r11 == 0) goto L_0x01d5
            if (r12 == 0) goto L_0x01d5
            if (r13 == 0) goto L_0x01d5
            android.view.animation.Interpolator r0 = interpolatorFor(r9, r12)
            android.view.animation.Interpolator r1 = interpolatorFor(r11, r13)
            r12 = r0
            r13 = r1
            r11 = r16
            r0 = 0
            goto L_0x01da
        L_0x01d5:
            android.view.animation.Interpolator r0 = LINEAR_INTERPOLATOR
        L_0x01d7:
            r11 = r16
            goto L_0x01b3
        L_0x01da:
            if (r12 == 0) goto L_0x01eb
            if (r13 == 0) goto L_0x01eb
            com.airbnb.lottie.value.Keyframe r0 = new com.airbnb.lottie.value.Keyframe
            r15 = 0
            r8 = r0
            r9 = r20
            r14 = r3
            r5 = r18
            r8.<init>(r9, r10, r11, r12, r13, r14, r15)
            goto L_0x01f9
        L_0x01eb:
            r5 = r18
            com.airbnb.lottie.value.Keyframe r1 = new com.airbnb.lottie.value.Keyframe
            r14 = 0
            r8 = r1
            r9 = r20
            r12 = r0
            r13 = r3
            r8.<init>(r9, r10, r11, r12, r13, r14)
            r0 = r1
        L_0x01f9:
            r0.pathCp1 = r5
            r3 = r19
            r0.pathCp2 = r3
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.parser.KeyframeParser.parseMultiDimensionalKeyframe(com.airbnb.lottie.LottieComposition, com.airbnb.lottie.parser.moshi.JsonReader, float, com.airbnb.lottie.parser.ValueParser):com.airbnb.lottie.value.Keyframe");
    }

    private static Interpolator interpolatorFor(PointF pointF, PointF pointF2) {
        Interpolator interpolator;
        pointF.x = MiscUtils.clamp(pointF.x, -1.0f, 1.0f);
        pointF.y = MiscUtils.clamp(pointF.y, -100.0f, (float) MAX_CP_VALUE);
        pointF2.x = MiscUtils.clamp(pointF2.x, -1.0f, 1.0f);
        pointF2.y = MiscUtils.clamp(pointF2.y, -100.0f, (float) MAX_CP_VALUE);
        int hashFor = Utils.hashFor(pointF.x, pointF.y, pointF2.x, pointF2.y);
        WeakReference<Interpolator> interpolator2 = getInterpolator(hashFor);
        Interpolator interpolator3 = interpolator2 != null ? (Interpolator) interpolator2.get() : null;
        if (interpolator2 == null || interpolator3 == null) {
            try {
                interpolator = PathInterpolatorCompat.create(pointF.x, pointF.y, pointF2.x, pointF2.y);
            } catch (IllegalArgumentException e) {
                if ("The Path cannot loop back on itself.".equals(e.getMessage())) {
                    interpolator = PathInterpolatorCompat.create(Math.min(pointF.x, 1.0f), pointF.y, Math.max(pointF2.x, 0.0f), pointF2.y);
                } else {
                    interpolator = new LinearInterpolator();
                }
            }
            interpolator3 = interpolator;
            try {
                putInterpolator(hashFor, new WeakReference(interpolator3));
            } catch (ArrayIndexOutOfBoundsException unused) {
            }
        }
        return interpolator3;
    }

    private static <T> Keyframe<T> parseStaticValue(JsonReader jsonReader, float f, ValueParser<T> valueParser) throws IOException {
        return new Keyframe<>(valueParser.parse(jsonReader, f));
    }
}
