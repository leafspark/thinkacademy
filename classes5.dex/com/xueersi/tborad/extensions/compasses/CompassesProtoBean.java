package com.xueersi.tborad.extensions.compasses;

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

public final class CompassesProtoBean {

    public interface CompassesConfigOrBuilder extends MessageLiteOrBuilder {
        float getAngle();

        CompassesPosition getCompassPos();

        CompassesPosition getCompassPos1();

        CompassesPosition getCompassPos2();

        boolean getEnable();

        String getPenPointerColor();

        ByteString getPenPointerColorBytes();

        float getRotate();

        boolean hasCompassPos();

        boolean hasCompassPos1();

        boolean hasCompassPos2();
    }

    public interface CompassesPositionOrBuilder extends MessageLiteOrBuilder {
        float getX();

        float getY();
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }

    private CompassesProtoBean() {
    }

    public static final class CompassesConfig extends GeneratedMessageLite<CompassesConfig, Builder> implements CompassesConfigOrBuilder {
        public static final int ANGLE_FIELD_NUMBER = 8;
        public static final int COMPASS_POS1_FIELD_NUMBER = 3;
        public static final int COMPASS_POS2_FIELD_NUMBER = 4;
        public static final int COMPASS_POS_FIELD_NUMBER = 2;
        /* access modifiers changed from: private */
        public static final CompassesConfig DEFAULT_INSTANCE;
        public static final int ENABLE_FIELD_NUMBER = 1;
        private static volatile Parser<CompassesConfig> PARSER = null;
        public static final int PEN_POINTER_COLOR_FIELD_NUMBER = 9;
        public static final int ROTATE_FIELD_NUMBER = 7;
        private float angle_;
        private CompassesPosition compassPos1_;
        private CompassesPosition compassPos2_;
        private CompassesPosition compassPos_;
        private boolean enable_;
        private String penPointerColor_ = "";
        private float rotate_;

        private CompassesConfig() {
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

        public boolean hasCompassPos() {
            return this.compassPos_ != null;
        }

        public CompassesPosition getCompassPos() {
            CompassesPosition compassesPosition = this.compassPos_;
            return compassesPosition == null ? CompassesPosition.getDefaultInstance() : compassesPosition;
        }

        /* access modifiers changed from: private */
        public void setCompassPos(CompassesPosition compassesPosition) {
            Objects.requireNonNull(compassesPosition);
            this.compassPos_ = compassesPosition;
        }

        /* access modifiers changed from: private */
        public void setCompassPos(CompassesPosition.Builder builder) {
            this.compassPos_ = builder.build();
        }

        /* access modifiers changed from: private */
        public void mergeCompassPos(CompassesPosition compassesPosition) {
            CompassesPosition compassesPosition2 = this.compassPos_;
            if (compassesPosition2 == null || compassesPosition2 == CompassesPosition.getDefaultInstance()) {
                this.compassPos_ = compassesPosition;
            } else {
                this.compassPos_ = CompassesPosition.newBuilder(this.compassPos_).mergeFrom(compassesPosition).buildPartial();
            }
        }

        /* access modifiers changed from: private */
        public void clearCompassPos() {
            this.compassPos_ = null;
        }

        public boolean hasCompassPos1() {
            return this.compassPos1_ != null;
        }

        public CompassesPosition getCompassPos1() {
            CompassesPosition compassesPosition = this.compassPos1_;
            return compassesPosition == null ? CompassesPosition.getDefaultInstance() : compassesPosition;
        }

        /* access modifiers changed from: private */
        public void setCompassPos1(CompassesPosition compassesPosition) {
            Objects.requireNonNull(compassesPosition);
            this.compassPos1_ = compassesPosition;
        }

        /* access modifiers changed from: private */
        public void setCompassPos1(CompassesPosition.Builder builder) {
            this.compassPos1_ = builder.build();
        }

        /* access modifiers changed from: private */
        public void mergeCompassPos1(CompassesPosition compassesPosition) {
            CompassesPosition compassesPosition2 = this.compassPos1_;
            if (compassesPosition2 == null || compassesPosition2 == CompassesPosition.getDefaultInstance()) {
                this.compassPos1_ = compassesPosition;
            } else {
                this.compassPos1_ = CompassesPosition.newBuilder(this.compassPos1_).mergeFrom(compassesPosition).buildPartial();
            }
        }

        /* access modifiers changed from: private */
        public void clearCompassPos1() {
            this.compassPos1_ = null;
        }

        public boolean hasCompassPos2() {
            return this.compassPos2_ != null;
        }

        public CompassesPosition getCompassPos2() {
            CompassesPosition compassesPosition = this.compassPos2_;
            return compassesPosition == null ? CompassesPosition.getDefaultInstance() : compassesPosition;
        }

        /* access modifiers changed from: private */
        public void setCompassPos2(CompassesPosition compassesPosition) {
            Objects.requireNonNull(compassesPosition);
            this.compassPos2_ = compassesPosition;
        }

        /* access modifiers changed from: private */
        public void setCompassPos2(CompassesPosition.Builder builder) {
            this.compassPos2_ = builder.build();
        }

        /* access modifiers changed from: private */
        public void mergeCompassPos2(CompassesPosition compassesPosition) {
            CompassesPosition compassesPosition2 = this.compassPos2_;
            if (compassesPosition2 == null || compassesPosition2 == CompassesPosition.getDefaultInstance()) {
                this.compassPos2_ = compassesPosition;
            } else {
                this.compassPos2_ = CompassesPosition.newBuilder(this.compassPos2_).mergeFrom(compassesPosition).buildPartial();
            }
        }

        /* access modifiers changed from: private */
        public void clearCompassPos2() {
            this.compassPos2_ = null;
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

        public float getAngle() {
            return this.angle_;
        }

        /* access modifiers changed from: private */
        public void setAngle(float f) {
            this.angle_ = f;
        }

        /* access modifiers changed from: private */
        public void clearAngle() {
            this.angle_ = CropImageView.DEFAULT_ASPECT_RATIO;
        }

        public String getPenPointerColor() {
            return this.penPointerColor_;
        }

        public ByteString getPenPointerColorBytes() {
            return ByteString.copyFromUtf8(this.penPointerColor_);
        }

        /* access modifiers changed from: private */
        public void setPenPointerColor(String str) {
            Objects.requireNonNull(str);
            this.penPointerColor_ = str;
        }

        /* access modifiers changed from: private */
        public void clearPenPointerColor() {
            this.penPointerColor_ = getDefaultInstance().getPenPointerColor();
        }

        /* access modifiers changed from: private */
        public void setPenPointerColorBytes(ByteString byteString) {
            Objects.requireNonNull(byteString);
            checkByteStringIsUtf8(byteString);
            this.penPointerColor_ = byteString.toStringUtf8();
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            boolean z = this.enable_;
            if (z) {
                codedOutputStream.writeBool(1, z);
            }
            if (this.compassPos_ != null) {
                codedOutputStream.writeMessage(2, getCompassPos());
            }
            if (this.compassPos1_ != null) {
                codedOutputStream.writeMessage(3, getCompassPos1());
            }
            if (this.compassPos2_ != null) {
                codedOutputStream.writeMessage(4, getCompassPos2());
            }
            float f = this.rotate_;
            if (f != CropImageView.DEFAULT_ASPECT_RATIO) {
                codedOutputStream.writeFloat(7, f);
            }
            float f2 = this.angle_;
            if (f2 != CropImageView.DEFAULT_ASPECT_RATIO) {
                codedOutputStream.writeFloat(8, f2);
            }
            if (!this.penPointerColor_.isEmpty()) {
                codedOutputStream.writeString(9, getPenPointerColor());
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
            if (this.compassPos_ != null) {
                i2 += CodedOutputStream.computeMessageSize(2, getCompassPos());
            }
            if (this.compassPos1_ != null) {
                i2 += CodedOutputStream.computeMessageSize(3, getCompassPos1());
            }
            if (this.compassPos2_ != null) {
                i2 += CodedOutputStream.computeMessageSize(4, getCompassPos2());
            }
            float f = this.rotate_;
            if (f != CropImageView.DEFAULT_ASPECT_RATIO) {
                i2 += CodedOutputStream.computeFloatSize(7, f);
            }
            float f2 = this.angle_;
            if (f2 != CropImageView.DEFAULT_ASPECT_RATIO) {
                i2 += CodedOutputStream.computeFloatSize(8, f2);
            }
            if (!this.penPointerColor_.isEmpty()) {
                i2 += CodedOutputStream.computeStringSize(9, getPenPointerColor());
            }
            this.memoizedSerializedSize = i2;
            return i2;
        }

        public static CompassesConfig parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static CompassesConfig parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static CompassesConfig parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static CompassesConfig parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static CompassesConfig parseFrom(InputStream inputStream) throws IOException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static CompassesConfig parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static CompassesConfig parseDelimitedFrom(InputStream inputStream) throws IOException {
            return parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static CompassesConfig parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static CompassesConfig parseFrom(CodedInputStream codedInputStream) throws IOException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static CompassesConfig parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(CompassesConfig compassesConfig) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(compassesConfig);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<CompassesConfig, Builder> implements CompassesConfigOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 r1) {
                this();
            }

            private Builder() {
                super(CompassesConfig.DEFAULT_INSTANCE);
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

            public boolean hasCompassPos() {
                return this.instance.hasCompassPos();
            }

            public CompassesPosition getCompassPos() {
                return this.instance.getCompassPos();
            }

            public Builder setCompassPos(CompassesPosition compassesPosition) {
                copyOnWrite();
                this.instance.setCompassPos(compassesPosition);
                return this;
            }

            public Builder setCompassPos(CompassesPosition.Builder builder) {
                copyOnWrite();
                this.instance.setCompassPos(builder);
                return this;
            }

            public Builder mergeCompassPos(CompassesPosition compassesPosition) {
                copyOnWrite();
                this.instance.mergeCompassPos(compassesPosition);
                return this;
            }

            public Builder clearCompassPos() {
                copyOnWrite();
                this.instance.clearCompassPos();
                return this;
            }

            public boolean hasCompassPos1() {
                return this.instance.hasCompassPos1();
            }

            public CompassesPosition getCompassPos1() {
                return this.instance.getCompassPos1();
            }

            public Builder setCompassPos1(CompassesPosition compassesPosition) {
                copyOnWrite();
                this.instance.setCompassPos1(compassesPosition);
                return this;
            }

            public Builder setCompassPos1(CompassesPosition.Builder builder) {
                copyOnWrite();
                this.instance.setCompassPos1(builder);
                return this;
            }

            public Builder mergeCompassPos1(CompassesPosition compassesPosition) {
                copyOnWrite();
                this.instance.mergeCompassPos1(compassesPosition);
                return this;
            }

            public Builder clearCompassPos1() {
                copyOnWrite();
                this.instance.clearCompassPos1();
                return this;
            }

            public boolean hasCompassPos2() {
                return this.instance.hasCompassPos2();
            }

            public CompassesPosition getCompassPos2() {
                return this.instance.getCompassPos2();
            }

            public Builder setCompassPos2(CompassesPosition compassesPosition) {
                copyOnWrite();
                this.instance.setCompassPos2(compassesPosition);
                return this;
            }

            public Builder setCompassPos2(CompassesPosition.Builder builder) {
                copyOnWrite();
                this.instance.setCompassPos2(builder);
                return this;
            }

            public Builder mergeCompassPos2(CompassesPosition compassesPosition) {
                copyOnWrite();
                this.instance.mergeCompassPos2(compassesPosition);
                return this;
            }

            public Builder clearCompassPos2() {
                copyOnWrite();
                this.instance.clearCompassPos2();
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

            public float getAngle() {
                return this.instance.getAngle();
            }

            public Builder setAngle(float f) {
                copyOnWrite();
                this.instance.setAngle(f);
                return this;
            }

            public Builder clearAngle() {
                copyOnWrite();
                this.instance.clearAngle();
                return this;
            }

            public String getPenPointerColor() {
                return this.instance.getPenPointerColor();
            }

            public ByteString getPenPointerColorBytes() {
                return this.instance.getPenPointerColorBytes();
            }

            public Builder setPenPointerColor(String str) {
                copyOnWrite();
                this.instance.setPenPointerColor(str);
                return this;
            }

            public Builder clearPenPointerColor() {
                copyOnWrite();
                this.instance.clearPenPointerColor();
                return this;
            }

            public Builder setPenPointerColorBytes(ByteString byteString) {
                copyOnWrite();
                this.instance.setPenPointerColorBytes(byteString);
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            boolean z = false;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new CompassesConfig();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    return null;
                case 4:
                    return new Builder((AnonymousClass1) null);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    CompassesConfig compassesConfig = (CompassesConfig) obj2;
                    boolean z2 = this.enable_;
                    boolean z3 = compassesConfig.enable_;
                    this.enable_ = visitor.visitBoolean(z2, z2, z3, z3);
                    this.compassPos_ = visitor.visitMessage(this.compassPos_, compassesConfig.compassPos_);
                    this.compassPos1_ = visitor.visitMessage(this.compassPos1_, compassesConfig.compassPos1_);
                    this.compassPos2_ = visitor.visitMessage(this.compassPos2_, compassesConfig.compassPos2_);
                    float f = this.rotate_;
                    boolean z4 = f != CropImageView.DEFAULT_ASPECT_RATIO;
                    float f2 = compassesConfig.rotate_;
                    this.rotate_ = visitor.visitFloat(z4, f, f2 != CropImageView.DEFAULT_ASPECT_RATIO, f2);
                    float f3 = this.angle_;
                    boolean z5 = f3 != CropImageView.DEFAULT_ASPECT_RATIO;
                    float f4 = compassesConfig.angle_;
                    if (f4 != CropImageView.DEFAULT_ASPECT_RATIO) {
                        z = true;
                    }
                    this.angle_ = visitor.visitFloat(z5, f3, z, f4);
                    this.penPointerColor_ = visitor.visitString(!this.penPointerColor_.isEmpty(), this.penPointerColor_, !compassesConfig.penPointerColor_.isEmpty(), compassesConfig.penPointerColor_);
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
                                    CompassesPosition compassesPosition = this.compassPos_;
                                    CompassesPosition.Builder builder = compassesPosition != null ? (CompassesPosition.Builder) compassesPosition.toBuilder() : null;
                                    CompassesPosition readMessage = codedInputStream.readMessage(CompassesPosition.parser(), extensionRegistryLite);
                                    this.compassPos_ = readMessage;
                                    if (builder != null) {
                                        builder.mergeFrom(readMessage);
                                        this.compassPos_ = builder.buildPartial();
                                    }
                                } else if (readTag == 26) {
                                    CompassesPosition compassesPosition2 = this.compassPos1_;
                                    CompassesPosition.Builder builder2 = compassesPosition2 != null ? (CompassesPosition.Builder) compassesPosition2.toBuilder() : null;
                                    CompassesPosition readMessage2 = codedInputStream.readMessage(CompassesPosition.parser(), extensionRegistryLite);
                                    this.compassPos1_ = readMessage2;
                                    if (builder2 != null) {
                                        builder2.mergeFrom(readMessage2);
                                        this.compassPos1_ = builder2.buildPartial();
                                    }
                                } else if (readTag == 34) {
                                    CompassesPosition compassesPosition3 = this.compassPos2_;
                                    CompassesPosition.Builder builder3 = compassesPosition3 != null ? (CompassesPosition.Builder) compassesPosition3.toBuilder() : null;
                                    CompassesPosition readMessage3 = codedInputStream.readMessage(CompassesPosition.parser(), extensionRegistryLite);
                                    this.compassPos2_ = readMessage3;
                                    if (builder3 != null) {
                                        builder3.mergeFrom(readMessage3);
                                        this.compassPos2_ = builder3.buildPartial();
                                    }
                                } else if (readTag == 61) {
                                    this.rotate_ = codedInputStream.readFloat();
                                } else if (readTag == 69) {
                                    this.angle_ = codedInputStream.readFloat();
                                } else if (readTag == 74) {
                                    this.penPointerColor_ = codedInputStream.readStringRequireUtf8();
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
                        synchronized (CompassesConfig.class) {
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
            CompassesConfig compassesConfig = new CompassesConfig();
            DEFAULT_INSTANCE = compassesConfig;
            compassesConfig.makeImmutable();
        }

        public static CompassesConfig getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<CompassesConfig> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* renamed from: com.xueersi.tborad.extensions.compasses.CompassesProtoBean$1  reason: invalid class name */
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
            throw new UnsupportedOperationException("Method not decompiled: com.xueersi.tborad.extensions.compasses.CompassesProtoBean.AnonymousClass1.<clinit>():void");
        }
    }

    public static final class CompassesPosition extends GeneratedMessageLite<CompassesPosition, Builder> implements CompassesPositionOrBuilder {
        /* access modifiers changed from: private */
        public static final CompassesPosition DEFAULT_INSTANCE;
        private static volatile Parser<CompassesPosition> PARSER = null;
        public static final int X_FIELD_NUMBER = 1;
        public static final int Y_FIELD_NUMBER = 2;
        private float x_;
        private float y_;

        private CompassesPosition() {
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

        public static CompassesPosition parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static CompassesPosition parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static CompassesPosition parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static CompassesPosition parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static CompassesPosition parseFrom(InputStream inputStream) throws IOException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static CompassesPosition parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static CompassesPosition parseDelimitedFrom(InputStream inputStream) throws IOException {
            return parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static CompassesPosition parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static CompassesPosition parseFrom(CodedInputStream codedInputStream) throws IOException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static CompassesPosition parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(CompassesPosition compassesPosition) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(compassesPosition);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<CompassesPosition, Builder> implements CompassesPositionOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 r1) {
                this();
            }

            private Builder() {
                super(CompassesPosition.DEFAULT_INSTANCE);
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
                    return new CompassesPosition();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    return null;
                case 4:
                    return new Builder((AnonymousClass1) null);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    CompassesPosition compassesPosition = (CompassesPosition) obj2;
                    float f = this.x_;
                    boolean z2 = f != CropImageView.DEFAULT_ASPECT_RATIO;
                    float f2 = compassesPosition.x_;
                    this.x_ = visitor.visitFloat(z2, f, f2 != CropImageView.DEFAULT_ASPECT_RATIO, f2);
                    float f3 = this.y_;
                    boolean z3 = f3 != CropImageView.DEFAULT_ASPECT_RATIO;
                    float f4 = compassesPosition.y_;
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
                        synchronized (CompassesPosition.class) {
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
            CompassesPosition compassesPosition = new CompassesPosition();
            DEFAULT_INSTANCE = compassesPosition;
            compassesPosition.makeImmutable();
        }

        public static CompassesPosition getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<CompassesPosition> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }
}
