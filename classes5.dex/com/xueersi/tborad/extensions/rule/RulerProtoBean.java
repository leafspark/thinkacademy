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

public final class RulerProtoBean {

    public interface RulerConfigOrBuilder extends MessageLiteOrBuilder {
        boolean getEnable();

        String getFillText();

        ByteString getFillTextBytes();

        float getLeft();

        float getLength();

        float getRotate();

        float getTop();
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }

    private RulerProtoBean() {
    }

    public static final class RulerConfig extends GeneratedMessageLite<RulerConfig, Builder> implements RulerConfigOrBuilder {
        /* access modifiers changed from: private */
        public static final RulerConfig DEFAULT_INSTANCE;
        public static final int ENABLE_FIELD_NUMBER = 1;
        public static final int FILLTEXT_FIELD_NUMBER = 6;
        public static final int LEFT_FIELD_NUMBER = 2;
        public static final int LENGTH_FIELD_NUMBER = 4;
        private static volatile Parser<RulerConfig> PARSER = null;
        public static final int ROTATE_FIELD_NUMBER = 5;
        public static final int TOP_FIELD_NUMBER = 3;
        private boolean enable_;
        private String fillText_ = "";
        private float left_;
        private float length_;
        private float rotate_;
        private float top_;

        private RulerConfig() {
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

        public float getLeft() {
            return this.left_;
        }

        /* access modifiers changed from: private */
        public void setLeft(float f) {
            this.left_ = f;
        }

        /* access modifiers changed from: private */
        public void clearLeft() {
            this.left_ = CropImageView.DEFAULT_ASPECT_RATIO;
        }

        public float getTop() {
            return this.top_;
        }

        /* access modifiers changed from: private */
        public void setTop(float f) {
            this.top_ = f;
        }

        /* access modifiers changed from: private */
        public void clearTop() {
            this.top_ = CropImageView.DEFAULT_ASPECT_RATIO;
        }

        public float getLength() {
            return this.length_;
        }

        /* access modifiers changed from: private */
        public void setLength(float f) {
            this.length_ = f;
        }

        /* access modifiers changed from: private */
        public void clearLength() {
            this.length_ = CropImageView.DEFAULT_ASPECT_RATIO;
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
            float f = this.left_;
            if (f != CropImageView.DEFAULT_ASPECT_RATIO) {
                codedOutputStream.writeFloat(2, f);
            }
            float f2 = this.top_;
            if (f2 != CropImageView.DEFAULT_ASPECT_RATIO) {
                codedOutputStream.writeFloat(3, f2);
            }
            float f3 = this.length_;
            if (f3 != CropImageView.DEFAULT_ASPECT_RATIO) {
                codedOutputStream.writeFloat(4, f3);
            }
            float f4 = this.rotate_;
            if (f4 != CropImageView.DEFAULT_ASPECT_RATIO) {
                codedOutputStream.writeFloat(5, f4);
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
            float f = this.left_;
            if (f != CropImageView.DEFAULT_ASPECT_RATIO) {
                i2 += CodedOutputStream.computeFloatSize(2, f);
            }
            float f2 = this.top_;
            if (f2 != CropImageView.DEFAULT_ASPECT_RATIO) {
                i2 += CodedOutputStream.computeFloatSize(3, f2);
            }
            float f3 = this.length_;
            if (f3 != CropImageView.DEFAULT_ASPECT_RATIO) {
                i2 += CodedOutputStream.computeFloatSize(4, f3);
            }
            float f4 = this.rotate_;
            if (f4 != CropImageView.DEFAULT_ASPECT_RATIO) {
                i2 += CodedOutputStream.computeFloatSize(5, f4);
            }
            if (!this.fillText_.isEmpty()) {
                i2 += CodedOutputStream.computeStringSize(6, getFillText());
            }
            this.memoizedSerializedSize = i2;
            return i2;
        }

        public static RulerConfig parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static RulerConfig parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static RulerConfig parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static RulerConfig parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static RulerConfig parseFrom(InputStream inputStream) throws IOException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static RulerConfig parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static RulerConfig parseDelimitedFrom(InputStream inputStream) throws IOException {
            return parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static RulerConfig parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static RulerConfig parseFrom(CodedInputStream codedInputStream) throws IOException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static RulerConfig parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(RulerConfig rulerConfig) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(rulerConfig);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<RulerConfig, Builder> implements RulerConfigOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 r1) {
                this();
            }

            private Builder() {
                super(RulerConfig.DEFAULT_INSTANCE);
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

            public float getLeft() {
                return this.instance.getLeft();
            }

            public Builder setLeft(float f) {
                copyOnWrite();
                this.instance.setLeft(f);
                return this;
            }

            public Builder clearLeft() {
                copyOnWrite();
                this.instance.clearLeft();
                return this;
            }

            public float getTop() {
                return this.instance.getTop();
            }

            public Builder setTop(float f) {
                copyOnWrite();
                this.instance.setTop(f);
                return this;
            }

            public Builder clearTop() {
                copyOnWrite();
                this.instance.clearTop();
                return this;
            }

            public float getLength() {
                return this.instance.getLength();
            }

            public Builder setLength(float f) {
                copyOnWrite();
                this.instance.setLength(f);
                return this;
            }

            public Builder clearLength() {
                copyOnWrite();
                this.instance.clearLength();
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
                    return new RulerConfig();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    return null;
                case 4:
                    return new Builder((AnonymousClass1) null);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    RulerConfig rulerConfig = (RulerConfig) obj2;
                    boolean z2 = this.enable_;
                    boolean z3 = rulerConfig.enable_;
                    this.enable_ = visitor.visitBoolean(z2, z2, z3, z3);
                    float f = this.left_;
                    boolean z4 = f != CropImageView.DEFAULT_ASPECT_RATIO;
                    float f2 = rulerConfig.left_;
                    this.left_ = visitor.visitFloat(z4, f, f2 != CropImageView.DEFAULT_ASPECT_RATIO, f2);
                    float f3 = this.top_;
                    boolean z5 = f3 != CropImageView.DEFAULT_ASPECT_RATIO;
                    float f4 = rulerConfig.top_;
                    this.top_ = visitor.visitFloat(z5, f3, f4 != CropImageView.DEFAULT_ASPECT_RATIO, f4);
                    float f5 = this.length_;
                    boolean z6 = f5 != CropImageView.DEFAULT_ASPECT_RATIO;
                    float f6 = rulerConfig.length_;
                    this.length_ = visitor.visitFloat(z6, f5, f6 != CropImageView.DEFAULT_ASPECT_RATIO, f6);
                    float f7 = this.rotate_;
                    boolean z7 = f7 != CropImageView.DEFAULT_ASPECT_RATIO;
                    float f8 = rulerConfig.rotate_;
                    if (f8 != CropImageView.DEFAULT_ASPECT_RATIO) {
                        z = true;
                    }
                    this.rotate_ = visitor.visitFloat(z7, f7, z, f8);
                    this.fillText_ = visitor.visitString(!this.fillText_.isEmpty(), this.fillText_, !rulerConfig.fillText_.isEmpty(), rulerConfig.fillText_);
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
                                } else if (readTag == 21) {
                                    this.left_ = codedInputStream.readFloat();
                                } else if (readTag == 29) {
                                    this.top_ = codedInputStream.readFloat();
                                } else if (readTag == 37) {
                                    this.length_ = codedInputStream.readFloat();
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
                        synchronized (RulerConfig.class) {
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
            RulerConfig rulerConfig = new RulerConfig();
            DEFAULT_INSTANCE = rulerConfig;
            rulerConfig.makeImmutable();
        }

        public static RulerConfig getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<RulerConfig> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* renamed from: com.xueersi.tborad.extensions.rule.RulerProtoBean$1  reason: invalid class name */
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
            throw new UnsupportedOperationException("Method not decompiled: com.xueersi.tborad.extensions.rule.RulerProtoBean.AnonymousClass1.<clinit>():void");
        }
    }
}
