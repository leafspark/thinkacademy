package com.xueersi.tborad.extensions.protractor;

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

public final class ProtractorProtoBean {

    public interface PositionVectorOrBuilder extends MessageLiteOrBuilder {
        float getX();

        float getY();
    }

    public interface ProtractorConfigOrBuilder extends MessageLiteOrBuilder {
        PositionVector getCenterPos();

        boolean getEnable();

        String getFillText();

        ByteString getFillTextBytes();

        String getFillTextColor();

        ByteString getFillTextColorBytes();

        float getFirCircleAngle();

        float getRadius();

        float getRotate();

        float getSecCircleAngle();

        boolean hasCenterPos();
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }

    private ProtractorProtoBean() {
    }

    public static final class ProtractorConfig extends GeneratedMessageLite<ProtractorConfig, Builder> implements ProtractorConfigOrBuilder {
        public static final int CENTER_POS_FIELD_NUMBER = 2;
        /* access modifiers changed from: private */
        public static final ProtractorConfig DEFAULT_INSTANCE;
        public static final int ENABLE_FIELD_NUMBER = 1;
        public static final int FILL_TEXT_COLOR_FIELD_NUMBER = 8;
        public static final int FILL_TEXT_FIELD_NUMBER = 5;
        public static final int FIR_CIRCLE_ANGLE_FIELD_NUMBER = 6;
        private static volatile Parser<ProtractorConfig> PARSER = null;
        public static final int RADIUS_FIELD_NUMBER = 3;
        public static final int ROTATE_FIELD_NUMBER = 4;
        public static final int SEC_CIRCLE_ANGLE_FIELD_NUMBER = 7;
        private PositionVector centerPos_;
        private boolean enable_;
        private String fillTextColor_ = "";
        private String fillText_ = "";
        private float firCircleAngle_;
        private float radius_;
        private float rotate_;
        private float secCircleAngle_;

        private ProtractorConfig() {
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

        public boolean hasCenterPos() {
            return this.centerPos_ != null;
        }

        public PositionVector getCenterPos() {
            PositionVector positionVector = this.centerPos_;
            return positionVector == null ? PositionVector.getDefaultInstance() : positionVector;
        }

        /* access modifiers changed from: private */
        public void setCenterPos(PositionVector positionVector) {
            Objects.requireNonNull(positionVector);
            this.centerPos_ = positionVector;
        }

        /* access modifiers changed from: private */
        public void setCenterPos(PositionVector.Builder builder) {
            this.centerPos_ = builder.build();
        }

        /* access modifiers changed from: private */
        public void mergeCenterPos(PositionVector positionVector) {
            PositionVector positionVector2 = this.centerPos_;
            if (positionVector2 == null || positionVector2 == PositionVector.getDefaultInstance()) {
                this.centerPos_ = positionVector;
            } else {
                this.centerPos_ = PositionVector.newBuilder(this.centerPos_).mergeFrom(positionVector).buildPartial();
            }
        }

        /* access modifiers changed from: private */
        public void clearCenterPos() {
            this.centerPos_ = null;
        }

        public float getRadius() {
            return this.radius_;
        }

        /* access modifiers changed from: private */
        public void setRadius(float f) {
            this.radius_ = f;
        }

        /* access modifiers changed from: private */
        public void clearRadius() {
            this.radius_ = CropImageView.DEFAULT_ASPECT_RATIO;
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

        public float getFirCircleAngle() {
            return this.firCircleAngle_;
        }

        /* access modifiers changed from: private */
        public void setFirCircleAngle(float f) {
            this.firCircleAngle_ = f;
        }

        /* access modifiers changed from: private */
        public void clearFirCircleAngle() {
            this.firCircleAngle_ = CropImageView.DEFAULT_ASPECT_RATIO;
        }

        public float getSecCircleAngle() {
            return this.secCircleAngle_;
        }

        /* access modifiers changed from: private */
        public void setSecCircleAngle(float f) {
            this.secCircleAngle_ = f;
        }

        /* access modifiers changed from: private */
        public void clearSecCircleAngle() {
            this.secCircleAngle_ = CropImageView.DEFAULT_ASPECT_RATIO;
        }

        public String getFillTextColor() {
            return this.fillTextColor_;
        }

        public ByteString getFillTextColorBytes() {
            return ByteString.copyFromUtf8(this.fillTextColor_);
        }

        /* access modifiers changed from: private */
        public void setFillTextColor(String str) {
            Objects.requireNonNull(str);
            this.fillTextColor_ = str;
        }

        /* access modifiers changed from: private */
        public void clearFillTextColor() {
            this.fillTextColor_ = getDefaultInstance().getFillTextColor();
        }

        /* access modifiers changed from: private */
        public void setFillTextColorBytes(ByteString byteString) {
            Objects.requireNonNull(byteString);
            checkByteStringIsUtf8(byteString);
            this.fillTextColor_ = byteString.toStringUtf8();
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            boolean z = this.enable_;
            if (z) {
                codedOutputStream.writeBool(1, z);
            }
            if (this.centerPos_ != null) {
                codedOutputStream.writeMessage(2, getCenterPos());
            }
            float f = this.radius_;
            if (f != CropImageView.DEFAULT_ASPECT_RATIO) {
                codedOutputStream.writeFloat(3, f);
            }
            float f2 = this.rotate_;
            if (f2 != CropImageView.DEFAULT_ASPECT_RATIO) {
                codedOutputStream.writeFloat(4, f2);
            }
            if (!this.fillText_.isEmpty()) {
                codedOutputStream.writeString(5, getFillText());
            }
            float f3 = this.firCircleAngle_;
            if (f3 != CropImageView.DEFAULT_ASPECT_RATIO) {
                codedOutputStream.writeFloat(6, f3);
            }
            float f4 = this.secCircleAngle_;
            if (f4 != CropImageView.DEFAULT_ASPECT_RATIO) {
                codedOutputStream.writeFloat(7, f4);
            }
            if (!this.fillTextColor_.isEmpty()) {
                codedOutputStream.writeString(8, getFillTextColor());
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
            if (this.centerPos_ != null) {
                i2 += CodedOutputStream.computeMessageSize(2, getCenterPos());
            }
            float f = this.radius_;
            if (f != CropImageView.DEFAULT_ASPECT_RATIO) {
                i2 += CodedOutputStream.computeFloatSize(3, f);
            }
            float f2 = this.rotate_;
            if (f2 != CropImageView.DEFAULT_ASPECT_RATIO) {
                i2 += CodedOutputStream.computeFloatSize(4, f2);
            }
            if (!this.fillText_.isEmpty()) {
                i2 += CodedOutputStream.computeStringSize(5, getFillText());
            }
            float f3 = this.firCircleAngle_;
            if (f3 != CropImageView.DEFAULT_ASPECT_RATIO) {
                i2 += CodedOutputStream.computeFloatSize(6, f3);
            }
            float f4 = this.secCircleAngle_;
            if (f4 != CropImageView.DEFAULT_ASPECT_RATIO) {
                i2 += CodedOutputStream.computeFloatSize(7, f4);
            }
            if (!this.fillTextColor_.isEmpty()) {
                i2 += CodedOutputStream.computeStringSize(8, getFillTextColor());
            }
            this.memoizedSerializedSize = i2;
            return i2;
        }

        public static ProtractorConfig parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static ProtractorConfig parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ProtractorConfig parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ProtractorConfig parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static ProtractorConfig parseFrom(InputStream inputStream) throws IOException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ProtractorConfig parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ProtractorConfig parseDelimitedFrom(InputStream inputStream) throws IOException {
            return parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ProtractorConfig parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ProtractorConfig parseFrom(CodedInputStream codedInputStream) throws IOException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ProtractorConfig parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ProtractorConfig protractorConfig) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(protractorConfig);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<ProtractorConfig, Builder> implements ProtractorConfigOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 r1) {
                this();
            }

            private Builder() {
                super(ProtractorConfig.DEFAULT_INSTANCE);
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

            public boolean hasCenterPos() {
                return this.instance.hasCenterPos();
            }

            public PositionVector getCenterPos() {
                return this.instance.getCenterPos();
            }

            public Builder setCenterPos(PositionVector positionVector) {
                copyOnWrite();
                this.instance.setCenterPos(positionVector);
                return this;
            }

            public Builder setCenterPos(PositionVector.Builder builder) {
                copyOnWrite();
                this.instance.setCenterPos(builder);
                return this;
            }

            public Builder mergeCenterPos(PositionVector positionVector) {
                copyOnWrite();
                this.instance.mergeCenterPos(positionVector);
                return this;
            }

            public Builder clearCenterPos() {
                copyOnWrite();
                this.instance.clearCenterPos();
                return this;
            }

            public float getRadius() {
                return this.instance.getRadius();
            }

            public Builder setRadius(float f) {
                copyOnWrite();
                this.instance.setRadius(f);
                return this;
            }

            public Builder clearRadius() {
                copyOnWrite();
                this.instance.clearRadius();
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

            public float getFirCircleAngle() {
                return this.instance.getFirCircleAngle();
            }

            public Builder setFirCircleAngle(float f) {
                copyOnWrite();
                this.instance.setFirCircleAngle(f);
                return this;
            }

            public Builder clearFirCircleAngle() {
                copyOnWrite();
                this.instance.clearFirCircleAngle();
                return this;
            }

            public float getSecCircleAngle() {
                return this.instance.getSecCircleAngle();
            }

            public Builder setSecCircleAngle(float f) {
                copyOnWrite();
                this.instance.setSecCircleAngle(f);
                return this;
            }

            public Builder clearSecCircleAngle() {
                copyOnWrite();
                this.instance.clearSecCircleAngle();
                return this;
            }

            public String getFillTextColor() {
                return this.instance.getFillTextColor();
            }

            public ByteString getFillTextColorBytes() {
                return this.instance.getFillTextColorBytes();
            }

            public Builder setFillTextColor(String str) {
                copyOnWrite();
                this.instance.setFillTextColor(str);
                return this;
            }

            public Builder clearFillTextColor() {
                copyOnWrite();
                this.instance.clearFillTextColor();
                return this;
            }

            public Builder setFillTextColorBytes(ByteString byteString) {
                copyOnWrite();
                this.instance.setFillTextColorBytes(byteString);
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            boolean z = false;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new ProtractorConfig();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    return null;
                case 4:
                    return new Builder((AnonymousClass1) null);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    ProtractorConfig protractorConfig = (ProtractorConfig) obj2;
                    boolean z2 = this.enable_;
                    boolean z3 = protractorConfig.enable_;
                    this.enable_ = visitor.visitBoolean(z2, z2, z3, z3);
                    this.centerPos_ = visitor.visitMessage(this.centerPos_, protractorConfig.centerPos_);
                    float f = this.radius_;
                    boolean z4 = f != CropImageView.DEFAULT_ASPECT_RATIO;
                    float f2 = protractorConfig.radius_;
                    this.radius_ = visitor.visitFloat(z4, f, f2 != CropImageView.DEFAULT_ASPECT_RATIO, f2);
                    float f3 = this.rotate_;
                    boolean z5 = f3 != CropImageView.DEFAULT_ASPECT_RATIO;
                    float f4 = protractorConfig.rotate_;
                    this.rotate_ = visitor.visitFloat(z5, f3, f4 != CropImageView.DEFAULT_ASPECT_RATIO, f4);
                    this.fillText_ = visitor.visitString(!this.fillText_.isEmpty(), this.fillText_, !protractorConfig.fillText_.isEmpty(), protractorConfig.fillText_);
                    float f5 = this.firCircleAngle_;
                    boolean z6 = f5 != CropImageView.DEFAULT_ASPECT_RATIO;
                    float f6 = protractorConfig.firCircleAngle_;
                    this.firCircleAngle_ = visitor.visitFloat(z6, f5, f6 != CropImageView.DEFAULT_ASPECT_RATIO, f6);
                    float f7 = this.secCircleAngle_;
                    boolean z7 = f7 != CropImageView.DEFAULT_ASPECT_RATIO;
                    float f8 = protractorConfig.secCircleAngle_;
                    if (f8 != CropImageView.DEFAULT_ASPECT_RATIO) {
                        z = true;
                    }
                    this.secCircleAngle_ = visitor.visitFloat(z7, f7, z, f8);
                    this.fillTextColor_ = visitor.visitString(!this.fillTextColor_.isEmpty(), this.fillTextColor_, !protractorConfig.fillTextColor_.isEmpty(), protractorConfig.fillTextColor_);
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
                                    PositionVector positionVector = this.centerPos_;
                                    PositionVector.Builder builder = positionVector != null ? (PositionVector.Builder) positionVector.toBuilder() : null;
                                    PositionVector readMessage = codedInputStream.readMessage(PositionVector.parser(), extensionRegistryLite);
                                    this.centerPos_ = readMessage;
                                    if (builder != null) {
                                        builder.mergeFrom(readMessage);
                                        this.centerPos_ = builder.buildPartial();
                                    }
                                } else if (readTag == 29) {
                                    this.radius_ = codedInputStream.readFloat();
                                } else if (readTag == 37) {
                                    this.rotate_ = codedInputStream.readFloat();
                                } else if (readTag == 42) {
                                    this.fillText_ = codedInputStream.readStringRequireUtf8();
                                } else if (readTag == 53) {
                                    this.firCircleAngle_ = codedInputStream.readFloat();
                                } else if (readTag == 61) {
                                    this.secCircleAngle_ = codedInputStream.readFloat();
                                } else if (readTag == 66) {
                                    this.fillTextColor_ = codedInputStream.readStringRequireUtf8();
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
                        synchronized (ProtractorConfig.class) {
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
            ProtractorConfig protractorConfig = new ProtractorConfig();
            DEFAULT_INSTANCE = protractorConfig;
            protractorConfig.makeImmutable();
        }

        public static ProtractorConfig getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ProtractorConfig> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* renamed from: com.xueersi.tborad.extensions.protractor.ProtractorProtoBean$1  reason: invalid class name */
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
            throw new UnsupportedOperationException("Method not decompiled: com.xueersi.tborad.extensions.protractor.ProtractorProtoBean.AnonymousClass1.<clinit>():void");
        }
    }

    public static final class PositionVector extends GeneratedMessageLite<PositionVector, Builder> implements PositionVectorOrBuilder {
        /* access modifiers changed from: private */
        public static final PositionVector DEFAULT_INSTANCE;
        private static volatile Parser<PositionVector> PARSER = null;
        public static final int X_FIELD_NUMBER = 1;
        public static final int Y_FIELD_NUMBER = 2;
        private float x_;
        private float y_;

        private PositionVector() {
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

        public static PositionVector parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static PositionVector parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static PositionVector parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static PositionVector parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static PositionVector parseFrom(InputStream inputStream) throws IOException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static PositionVector parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static PositionVector parseDelimitedFrom(InputStream inputStream) throws IOException {
            return parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static PositionVector parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static PositionVector parseFrom(CodedInputStream codedInputStream) throws IOException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static PositionVector parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(PositionVector positionVector) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(positionVector);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<PositionVector, Builder> implements PositionVectorOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 r1) {
                this();
            }

            private Builder() {
                super(PositionVector.DEFAULT_INSTANCE);
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
                    return new PositionVector();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    return null;
                case 4:
                    return new Builder((AnonymousClass1) null);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    PositionVector positionVector = (PositionVector) obj2;
                    float f = this.x_;
                    boolean z2 = f != CropImageView.DEFAULT_ASPECT_RATIO;
                    float f2 = positionVector.x_;
                    this.x_ = visitor.visitFloat(z2, f, f2 != CropImageView.DEFAULT_ASPECT_RATIO, f2);
                    float f3 = this.y_;
                    boolean z3 = f3 != CropImageView.DEFAULT_ASPECT_RATIO;
                    float f4 = positionVector.y_;
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
                        synchronized (PositionVector.class) {
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
            PositionVector positionVector = new PositionVector();
            DEFAULT_INSTANCE = positionVector;
            positionVector.makeImmutable();
        }

        public static PositionVector getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<PositionVector> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }
}
