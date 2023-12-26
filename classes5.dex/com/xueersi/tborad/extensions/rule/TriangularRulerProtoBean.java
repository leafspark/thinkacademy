package com.xueersi.tborad.extensions.rule;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import com.yalantis.ucrop.view.CropImageView;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

public final class TriangularRulerProtoBean {

    public interface TriangularRulerConfigOrBuilder extends MessageLiteOrBuilder {
        boolean getEnable();

        String getFillText();

        ByteString getFillTextBytes();

        float getRotate();

        Vector getV1();

        Vector getV2();

        Vector getV3();

        boolean hasV1();

        boolean hasV2();

        boolean hasV3();
    }

    public interface VectorOrBuilder extends MessageLiteOrBuilder {
        float getX();

        float getY();
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }

    private TriangularRulerProtoBean() {
    }

    public static final class TriangularRulerConfig extends GeneratedMessageLite<TriangularRulerConfig, Builder> implements TriangularRulerConfigOrBuilder {
        /* access modifiers changed from: private */
        public static final TriangularRulerConfig DEFAULT_INSTANCE;
        public static final int ENABLE_FIELD_NUMBER = 1;
        public static final int FILLTEXT_FIELD_NUMBER = 6;
        private static volatile Parser<TriangularRulerConfig> PARSER = null;
        public static final int ROTATE_FIELD_NUMBER = 5;
        public static final int V1_FIELD_NUMBER = 2;
        public static final int V2_FIELD_NUMBER = 3;
        public static final int V3_FIELD_NUMBER = 4;
        private boolean enable_;
        private String fillText_ = "";
        private float rotate_;
        private Vector v1_;
        private Vector v2_;
        private Vector v3_;

        private TriangularRulerConfig() {
        }

        public boolean getEnable() {
            return this.enable_;
        }

        /* access modifiers changed from: private */
        public void setEnable(boolean z) {
            this.enable_ = z;
        }

        /* access modifiers changed from: private */
        public void clearEnable() {
            this.enable_ = false;
        }

        public boolean hasV1() {
            return this.v1_ != null;
        }

        public Vector getV1() {
            Vector vector = this.v1_;
            return vector == null ? Vector.getDefaultInstance() : vector;
        }

        /* access modifiers changed from: private */
        public void setV1(Vector vector) {
            Objects.requireNonNull(vector);
            this.v1_ = vector;
        }

        /* access modifiers changed from: private */
        public void setV1(Vector.Builder builder) {
            this.v1_ = builder.build();
        }

        /* access modifiers changed from: private */
        public void mergeV1(Vector vector) {
            Vector vector2 = this.v1_;
            if (vector2 == null || vector2 == Vector.getDefaultInstance()) {
                this.v1_ = vector;
            } else {
                this.v1_ = Vector.newBuilder(this.v1_).mergeFrom(vector).buildPartial();
            }
        }

        /* access modifiers changed from: private */
        public void clearV1() {
            this.v1_ = null;
        }

        public boolean hasV2() {
            return this.v2_ != null;
        }

        public Vector getV2() {
            Vector vector = this.v2_;
            return vector == null ? Vector.getDefaultInstance() : vector;
        }

        /* access modifiers changed from: private */
        public void setV2(Vector vector) {
            Objects.requireNonNull(vector);
            this.v2_ = vector;
        }

        /* access modifiers changed from: private */
        public void setV2(Vector.Builder builder) {
            this.v2_ = builder.build();
        }

        /* access modifiers changed from: private */
        public void mergeV2(Vector vector) {
            Vector vector2 = this.v2_;
            if (vector2 == null || vector2 == Vector.getDefaultInstance()) {
                this.v2_ = vector;
            } else {
                this.v2_ = Vector.newBuilder(this.v2_).mergeFrom(vector).buildPartial();
            }
        }

        /* access modifiers changed from: private */
        public void clearV2() {
            this.v2_ = null;
        }

        public boolean hasV3() {
            return this.v3_ != null;
        }

        public Vector getV3() {
            Vector vector = this.v3_;
            return vector == null ? Vector.getDefaultInstance() : vector;
        }

        /* access modifiers changed from: private */
        public void setV3(Vector vector) {
            Objects.requireNonNull(vector);
            this.v3_ = vector;
        }

        /* access modifiers changed from: private */
        public void setV3(Vector.Builder builder) {
            this.v3_ = builder.build();
        }

        /* access modifiers changed from: private */
        public void mergeV3(Vector vector) {
            Vector vector2 = this.v3_;
            if (vector2 == null || vector2 == Vector.getDefaultInstance()) {
                this.v3_ = vector;
            } else {
                this.v3_ = Vector.newBuilder(this.v3_).mergeFrom(vector).buildPartial();
            }
        }

        /* access modifiers changed from: private */
        public void clearV3() {
            this.v3_ = null;
        }

        public float getRotate() {
            return this.rotate_;
        }

        /* access modifiers changed from: private */
        public void setRotate(float f) {
            this.rotate_ = f;
        }

        /* access modifiers changed from: private */
        public void clearRotate() {
            this.rotate_ = CropImageView.DEFAULT_ASPECT_RATIO;
        }

        public String getFillText() {
            return this.fillText_;
        }

        public ByteString getFillTextBytes() {
            return ByteString.copyFromUtf8(this.fillText_);
        }

        /* access modifiers changed from: private */
        public void setFillText(String str) {
            Objects.requireNonNull(str);
            this.fillText_ = str;
        }

        /* access modifiers changed from: private */
        public void clearFillText() {
            this.fillText_ = getDefaultInstance().getFillText();
        }

        /* access modifiers changed from: private */
        public void setFillTextBytes(ByteString byteString) {
            Objects.requireNonNull(byteString);
            checkByteStringIsUtf8(byteString);
            this.fillText_ = byteString.toStringUtf8();
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            boolean z = this.enable_;
            if (z) {
                codedOutputStream.writeBool(1, z);
            }
            if (this.v1_ != null) {
                codedOutputStream.writeMessage(2, getV1());
            }
            if (this.v2_ != null) {
                codedOutputStream.writeMessage(3, getV2());
            }
            if (this.v3_ != null) {
                codedOutputStream.writeMessage(4, getV3());
            }
            float f = this.rotate_;
            if (f != CropImageView.DEFAULT_ASPECT_RATIO) {
                codedOutputStream.writeFloat(5, f);
            }
            if (!this.fillText_.isEmpty()) {
                codedOutputStream.writeString(6, getFillText());
            }
        }

        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            boolean z = this.enable_;
            if (z) {
                i2 = 0 + CodedOutputStream.computeBoolSize(1, z);
            }
            if (this.v1_ != null) {
                i2 += CodedOutputStream.computeMessageSize(2, getV1());
            }
            if (this.v2_ != null) {
                i2 += CodedOutputStream.computeMessageSize(3, getV2());
            }
            if (this.v3_ != null) {
                i2 += CodedOutputStream.computeMessageSize(4, getV3());
            }
            float f = this.rotate_;
            if (f != CropImageView.DEFAULT_ASPECT_RATIO) {
                i2 += CodedOutputStream.computeFloatSize(5, f);
            }
            if (!this.fillText_.isEmpty()) {
                i2 += CodedOutputStream.computeStringSize(6, getFillText());
            }
            this.memoizedSerializedSize = i2;
            return i2;
        }

        public static TriangularRulerConfig parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static TriangularRulerConfig parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static TriangularRulerConfig parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static TriangularRulerConfig parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static TriangularRulerConfig parseFrom(InputStream inputStream) throws IOException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static TriangularRulerConfig parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static TriangularRulerConfig parseDelimitedFrom(InputStream inputStream) throws IOException {
            return parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static TriangularRulerConfig parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static TriangularRulerConfig parseFrom(CodedInputStream codedInputStream) throws IOException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static TriangularRulerConfig parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(TriangularRulerConfig triangularRulerConfig) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(triangularRulerConfig);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<TriangularRulerConfig, Builder> implements TriangularRulerConfigOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 r1) {
                this();
            }

            private Builder() {
                super(TriangularRulerConfig.DEFAULT_INSTANCE);
            }

            public boolean getEnable() {
                return this.instance.getEnable();
            }

            public Builder setEnable(boolean z) {
                copyOnWrite();
                this.instance.setEnable(z);
                return this;
            }

            public Builder clearEnable() {
                copyOnWrite();
                this.instance.clearEnable();
                return this;
            }

            public boolean hasV1() {
                return this.instance.hasV1();
            }

            public Vector getV1() {
                return this.instance.getV1();
            }

            public Builder setV1(Vector vector) {
                copyOnWrite();
                this.instance.setV1(vector);
                return this;
            }

            public Builder setV1(Vector.Builder builder) {
                copyOnWrite();
                this.instance.setV1(builder);
                return this;
            }

            public Builder mergeV1(Vector vector) {
                copyOnWrite();
                this.instance.mergeV1(vector);
                return this;
            }

            public Builder clearV1() {
                copyOnWrite();
                this.instance.clearV1();
                return this;
            }

            public boolean hasV2() {
                return this.instance.hasV2();
            }

            public Vector getV2() {
                return this.instance.getV2();
            }

            public Builder setV2(Vector vector) {
                copyOnWrite();
                this.instance.setV2(vector);
                return this;
            }

            public Builder setV2(Vector.Builder builder) {
                copyOnWrite();
                this.instance.setV2(builder);
                return this;
            }

            public Builder mergeV2(Vector vector) {
                copyOnWrite();
                this.instance.mergeV2(vector);
                return this;
            }

            public Builder clearV2() {
                copyOnWrite();
                this.instance.clearV2();
                return this;
            }

            public boolean hasV3() {
                return this.instance.hasV3();
            }

            public Vector getV3() {
                return this.instance.getV3();
            }

            public Builder setV3(Vector vector) {
                copyOnWrite();
                this.instance.setV3(vector);
                return this;
            }

            public Builder setV3(Vector.Builder builder) {
                copyOnWrite();
                this.instance.setV3(builder);
                return this;
            }

            public Builder mergeV3(Vector vector) {
                copyOnWrite();
                this.instance.mergeV3(vector);
                return this;
            }

            public Builder clearV3() {
                copyOnWrite();
                this.instance.clearV3();
                return this;
            }

            public float getRotate() {
                return this.instance.getRotate();
            }

            public Builder setRotate(float f) {
                copyOnWrite();
                this.instance.setRotate(f);
                return this;
            }

            public Builder clearRotate() {
                copyOnWrite();
                this.instance.clearRotate();
                return this;
            }

            public String getFillText() {
                return this.instance.getFillText();
            }

            public ByteString getFillTextBytes() {
                return this.instance.getFillTextBytes();
            }

            public Builder setFillText(String str) {
                copyOnWrite();
                this.instance.setFillText(str);
                return this;
            }

            public Builder clearFillText() {
                copyOnWrite();
                this.instance.clearFillText();
                return this;
            }

            public Builder setFillTextBytes(ByteString byteString) {
                copyOnWrite();
                this.instance.setFillTextBytes(byteString);
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            boolean z = false;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new TriangularRulerConfig();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    return null;
                case 4:
                    return new Builder((AnonymousClass1) null);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    TriangularRulerConfig triangularRulerConfig = (TriangularRulerConfig) obj2;
                    boolean z2 = this.enable_;
                    boolean z3 = triangularRulerConfig.enable_;
                    this.enable_ = visitor.visitBoolean(z2, z2, z3, z3);
                    this.v1_ = visitor.visitMessage(this.v1_, triangularRulerConfig.v1_);
                    this.v2_ = visitor.visitMessage(this.v2_, triangularRulerConfig.v2_);
                    this.v3_ = visitor.visitMessage(this.v3_, triangularRulerConfig.v3_);
                    float f = this.rotate_;
                    boolean z4 = f != CropImageView.DEFAULT_ASPECT_RATIO;
                    float f2 = triangularRulerConfig.rotate_;
                    if (f2 != CropImageView.DEFAULT_ASPECT_RATIO) {
                        z = true;
                    }
                    this.rotate_ = visitor.visitFloat(z4, f, z, f2);
                    this.fillText_ = visitor.visitString(!this.fillText_.isEmpty(), this.fillText_, !triangularRulerConfig.fillText_.isEmpty(), triangularRulerConfig.fillText_);
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    while (!z) {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 8) {
                                    this.enable_ = codedInputStream.readBool();
                                } else if (readTag == 18) {
                                    Vector vector = this.v1_;
                                    Vector.Builder builder = vector != null ? (Vector.Builder) vector.toBuilder() : null;
                                    Vector readMessage = codedInputStream.readMessage(Vector.parser(), extensionRegistryLite);
                                    this.v1_ = readMessage;
                                    if (builder != null) {
                                        builder.mergeFrom(readMessage);
                                        this.v1_ = builder.buildPartial();
                                    }
                                } else if (readTag == 26) {
                                    Vector vector2 = this.v2_;
                                    Vector.Builder builder2 = vector2 != null ? (Vector.Builder) vector2.toBuilder() : null;
                                    Vector readMessage2 = codedInputStream.readMessage(Vector.parser(), extensionRegistryLite);
                                    this.v2_ = readMessage2;
                                    if (builder2 != null) {
                                        builder2.mergeFrom(readMessage2);
                                        this.v2_ = builder2.buildPartial();
                                    }
                                } else if (readTag == 34) {
                                    Vector vector3 = this.v3_;
                                    Vector.Builder builder3 = vector3 != null ? (Vector.Builder) vector3.toBuilder() : null;
                                    Vector readMessage3 = codedInputStream.readMessage(Vector.parser(), extensionRegistryLite);
                                    this.v3_ = readMessage3;
                                    if (builder3 != null) {
                                        builder3.mergeFrom(readMessage3);
                                        this.v3_ = builder3.buildPartial();
                                    }
                                } else if (readTag == 45) {
                                    this.rotate_ = codedInputStream.readFloat();
                                } else if (readTag == 50) {
                                    this.fillText_ = codedInputStream.readStringRequireUtf8();
                                } else if (!codedInputStream.skipField(readTag)) {
                                }
                            }
                            z = true;
                        } catch (InvalidProtocolBufferException e) {
                            throw new RuntimeException(e.setUnfinishedMessage(this));
                        } catch (IOException e2) {
                            throw new RuntimeException(new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this));
                        }
                    }
                    break;
                case 7:
                    break;
                case 8:
                    if (PARSER == null) {
                        synchronized (TriangularRulerConfig.class) {
                            if (PARSER == null) {
                                PARSER = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            }
                        }
                    }
                    return PARSER;
                default:
                    throw new UnsupportedOperationException();
            }
            return DEFAULT_INSTANCE;
        }

        static {
            TriangularRulerConfig triangularRulerConfig = new TriangularRulerConfig();
            DEFAULT_INSTANCE = triangularRulerConfig;
            triangularRulerConfig.makeImmutable();
        }

        public static TriangularRulerConfig getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<TriangularRulerConfig> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* renamed from: com.xueersi.tborad.extensions.rule.TriangularRulerProtoBean$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke[] r0 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke = r0
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.MAKE_IMMUTABLE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_BUILDER     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x003e }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.VISIT     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.MERGE_FROM_STREAM     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.GET_PARSER     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xueersi.tborad.extensions.rule.TriangularRulerProtoBean.AnonymousClass1.<clinit>():void");
        }
    }

    public static final class Vector extends GeneratedMessageLite<Vector, Builder> implements VectorOrBuilder {
        /* access modifiers changed from: private */
        public static final Vector DEFAULT_INSTANCE;
        private static volatile Parser<Vector> PARSER = null;
        public static final int X_FIELD_NUMBER = 1;
        public static final int Y_FIELD_NUMBER = 2;
        private float x_;
        private float y_;

        private Vector() {
        }

        public float getX() {
            return this.x_;
        }

        /* access modifiers changed from: private */
        public void setX(float f) {
            this.x_ = f;
        }

        /* access modifiers changed from: private */
        public void clearX() {
            this.x_ = CropImageView.DEFAULT_ASPECT_RATIO;
        }

        public float getY() {
            return this.y_;
        }

        /* access modifiers changed from: private */
        public void setY(float f) {
            this.y_ = f;
        }

        /* access modifiers changed from: private */
        public void clearY() {
            this.y_ = CropImageView.DEFAULT_ASPECT_RATIO;
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            float f = this.x_;
            if (f != CropImageView.DEFAULT_ASPECT_RATIO) {
                codedOutputStream.writeFloat(1, f);
            }
            float f2 = this.y_;
            if (f2 != CropImageView.DEFAULT_ASPECT_RATIO) {
                codedOutputStream.writeFloat(2, f2);
            }
        }

        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            float f = this.x_;
            if (f != CropImageView.DEFAULT_ASPECT_RATIO) {
                i2 = 0 + CodedOutputStream.computeFloatSize(1, f);
            }
            float f2 = this.y_;
            if (f2 != CropImageView.DEFAULT_ASPECT_RATIO) {
                i2 += CodedOutputStream.computeFloatSize(2, f2);
            }
            this.memoizedSerializedSize = i2;
            return i2;
        }

        public static Vector parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Vector parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static Vector parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static Vector parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Vector parseFrom(InputStream inputStream) throws IOException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Vector parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Vector parseDelimitedFrom(InputStream inputStream) throws IOException {
            return parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Vector parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Vector parseFrom(CodedInputStream codedInputStream) throws IOException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static Vector parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Vector vector) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(vector);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<Vector, Builder> implements VectorOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 r1) {
                this();
            }

            private Builder() {
                super(Vector.DEFAULT_INSTANCE);
            }

            public float getX() {
                return this.instance.getX();
            }

            public Builder setX(float f) {
                copyOnWrite();
                this.instance.setX(f);
                return this;
            }

            public Builder clearX() {
                copyOnWrite();
                this.instance.clearX();
                return this;
            }

            public float getY() {
                return this.instance.getY();
            }

            public Builder setY(float f) {
                copyOnWrite();
                this.instance.setY(f);
                return this;
            }

            public Builder clearY() {
                copyOnWrite();
                this.instance.clearY();
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            boolean z = false;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new Vector();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    return null;
                case 4:
                    return new Builder((AnonymousClass1) null);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    Vector vector = (Vector) obj2;
                    float f = this.x_;
                    boolean z2 = f != CropImageView.DEFAULT_ASPECT_RATIO;
                    float f2 = vector.x_;
                    this.x_ = visitor.visitFloat(z2, f, f2 != CropImageView.DEFAULT_ASPECT_RATIO, f2);
                    float f3 = this.y_;
                    boolean z3 = f3 != CropImageView.DEFAULT_ASPECT_RATIO;
                    float f4 = vector.y_;
                    if (f4 != CropImageView.DEFAULT_ASPECT_RATIO) {
                        z = true;
                    }
                    this.y_ = visitor.visitFloat(z3, f3, z, f4);
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    while (!z) {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 13) {
                                    this.x_ = codedInputStream.readFloat();
                                } else if (readTag == 21) {
                                    this.y_ = codedInputStream.readFloat();
                                } else if (!codedInputStream.skipField(readTag)) {
                                }
                            }
                            z = true;
                        } catch (InvalidProtocolBufferException e) {
                            throw new RuntimeException(e.setUnfinishedMessage(this));
                        } catch (IOException e2) {
                            throw new RuntimeException(new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this));
                        }
                    }
                    break;
                case 7:
                    break;
                case 8:
                    if (PARSER == null) {
                        synchronized (Vector.class) {
                            if (PARSER == null) {
                                PARSER = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            }
                        }
                    }
                    return PARSER;
                default:
                    throw new UnsupportedOperationException();
            }
            return DEFAULT_INSTANCE;
        }

        static {
            Vector vector = new Vector();
            DEFAULT_INSTANCE = vector;
            vector.makeImmutable();
        }

        public static Vector getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Vector> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }
}
