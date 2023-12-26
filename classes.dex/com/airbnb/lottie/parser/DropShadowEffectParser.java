package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

public class DropShadowEffectParser {
    private static final JsonReader.Options DROP_SHADOW_EFFECT_NAMES = JsonReader.Options.of("ef");
    private static final JsonReader.Options INNER_EFFECT_NAMES = JsonReader.Options.of("nm", "v");
    private AnimatableColorValue color;
    private AnimatableFloatValue direction;
    private AnimatableFloatValue distance;
    private AnimatableFloatValue opacity;
    private AnimatableFloatValue radius;

    /* access modifiers changed from: package-private */
    public DropShadowEffect parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        AnimatableFloatValue animatableFloatValue;
        AnimatableFloatValue animatableFloatValue2;
        AnimatableFloatValue animatableFloatValue3;
        AnimatableFloatValue animatableFloatValue4;
        while (jsonReader.hasNext()) {
            if (jsonReader.selectName(DROP_SHADOW_EFFECT_NAMES) != 0) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    maybeParseInnerEffect(jsonReader, lottieComposition);
                }
                jsonReader.endArray();
            }
        }
        AnimatableColorValue animatableColorValue = this.color;
        if (animatableColorValue == null || (animatableFloatValue = this.opacity) == null || (animatableFloatValue2 = this.direction) == null || (animatableFloatValue3 = this.distance) == null || (animatableFloatValue4 = this.radius) == null) {
            return null;
        }
        return new DropShadowEffect(animatableColorValue, animatableFloatValue, animatableFloatValue2, animatableFloatValue3, animatableFloatValue4);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0052, code lost:
        if (r0.equals("Opacity") == false) goto L_0x0029;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void maybeParseInnerEffect(com.airbnb.lottie.parser.moshi.JsonReader r6, com.airbnb.lottie.LottieComposition r7) throws java.io.IOException {
        /*
            r5 = this;
            r6.beginObject()
            java.lang.String r0 = ""
        L_0x0005:
            boolean r1 = r6.hasNext()
            if (r1 == 0) goto L_0x0090
            com.airbnb.lottie.parser.moshi.JsonReader$Options r1 = INNER_EFFECT_NAMES
            int r1 = r6.selectName(r1)
            if (r1 == 0) goto L_0x008a
            r2 = 1
            if (r1 == r2) goto L_0x001d
            r6.skipName()
            r6.skipValue()
            goto L_0x0005
        L_0x001d:
            r0.hashCode()
            r1 = -1
            int r3 = r0.hashCode()
            r4 = 0
            switch(r3) {
                case 353103893: goto L_0x0055;
                case 397447147: goto L_0x004c;
                case 1041377119: goto L_0x0041;
                case 1379387491: goto L_0x0036;
                case 1383710113: goto L_0x002b;
                default: goto L_0x0029;
            }
        L_0x0029:
            r2 = r1
            goto L_0x005f
        L_0x002b:
            java.lang.String r2 = "Softness"
            boolean r2 = r0.equals(r2)
            if (r2 != 0) goto L_0x0034
            goto L_0x0029
        L_0x0034:
            r2 = 4
            goto L_0x005f
        L_0x0036:
            java.lang.String r2 = "Shadow Color"
            boolean r2 = r0.equals(r2)
            if (r2 != 0) goto L_0x003f
            goto L_0x0029
        L_0x003f:
            r2 = 3
            goto L_0x005f
        L_0x0041:
            java.lang.String r2 = "Direction"
            boolean r2 = r0.equals(r2)
            if (r2 != 0) goto L_0x004a
            goto L_0x0029
        L_0x004a:
            r2 = 2
            goto L_0x005f
        L_0x004c:
            java.lang.String r3 = "Opacity"
            boolean r3 = r0.equals(r3)
            if (r3 != 0) goto L_0x005f
            goto L_0x0029
        L_0x0055:
            java.lang.String r2 = "Distance"
            boolean r2 = r0.equals(r2)
            if (r2 != 0) goto L_0x005e
            goto L_0x0029
        L_0x005e:
            r2 = r4
        L_0x005f:
            switch(r2) {
                case 0: goto L_0x0082;
                case 1: goto L_0x007b;
                case 2: goto L_0x0074;
                case 3: goto L_0x006d;
                case 4: goto L_0x0066;
                default: goto L_0x0062;
            }
        L_0x0062:
            r6.skipValue()
            goto L_0x0005
        L_0x0066:
            com.airbnb.lottie.model.animatable.AnimatableFloatValue r1 = com.airbnb.lottie.parser.AnimatableValueParser.parseFloat(r6, r7)
            r5.radius = r1
            goto L_0x0005
        L_0x006d:
            com.airbnb.lottie.model.animatable.AnimatableColorValue r1 = com.airbnb.lottie.parser.AnimatableValueParser.parseColor(r6, r7)
            r5.color = r1
            goto L_0x0005
        L_0x0074:
            com.airbnb.lottie.model.animatable.AnimatableFloatValue r1 = com.airbnb.lottie.parser.AnimatableValueParser.parseFloat(r6, r7, r4)
            r5.direction = r1
            goto L_0x0005
        L_0x007b:
            com.airbnb.lottie.model.animatable.AnimatableFloatValue r1 = com.airbnb.lottie.parser.AnimatableValueParser.parseFloat(r6, r7, r4)
            r5.opacity = r1
            goto L_0x0005
        L_0x0082:
            com.airbnb.lottie.model.animatable.AnimatableFloatValue r1 = com.airbnb.lottie.parser.AnimatableValueParser.parseFloat(r6, r7)
            r5.distance = r1
            goto L_0x0005
        L_0x008a:
            java.lang.String r0 = r6.nextString()
            goto L_0x0005
        L_0x0090:
            r6.endObject()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.parser.DropShadowEffectParser.maybeParseInnerEffect(com.airbnb.lottie.parser.moshi.JsonReader, com.airbnb.lottie.LottieComposition):void");
    }
}
