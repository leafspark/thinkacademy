package com.bonree.sdk.agent.engine.external;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class ProtoBufInstrumentation {
    private static final String PB_PARSEFROM = "parseFrom";
    private static final String PB_PARSEPARTIALFROM = "parsePartialFrom";

    public static class BrParser<ProtoType> implements Parser<ProtoType> {
        Parser<ProtoType> mOriginalParser;
        final String mProtoName;

        public BrParser(Parser<ProtoType> parser, String str) {
            this.mOriginalParser = parser;
            this.mProtoName = str;
        }

        public ProtoType parseFrom(CodedInputStream codedInputStream) throws InvalidProtocolBufferException {
            String access$000 = ProtoBufInstrumentation.getMethodName(this.mProtoName, ProtoBufInstrumentation.PB_PARSEFROM, "CodedInputStream");
            ProtoBufInstrumentation.beforeMethod(access$000);
            try {
                return this.mOriginalParser.parseFrom(codedInputStream);
            } finally {
                ProtoBufInstrumentation.afterMethod(access$000);
            }
        }

        public ProtoType parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            String access$000 = ProtoBufInstrumentation.getMethodName(this.mProtoName, ProtoBufInstrumentation.PB_PARSEFROM, "CodedInputStream,ExtensionRegistryLite");
            ProtoBufInstrumentation.beforeMethod(access$000);
            try {
                return this.mOriginalParser.parseFrom(codedInputStream, extensionRegistryLite);
            } finally {
                ProtoBufInstrumentation.afterMethod(access$000);
            }
        }

        public ProtoType parsePartialFrom(CodedInputStream codedInputStream) throws InvalidProtocolBufferException {
            return this.mOriginalParser.parsePartialFrom(codedInputStream);
        }

        public ProtoType parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return this.mOriginalParser.parsePartialFrom(codedInputStream, extensionRegistryLite);
        }

        public ProtoType parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            String access$000 = ProtoBufInstrumentation.getMethodName(this.mProtoName, ProtoBufInstrumentation.PB_PARSEFROM, "ByteBuffer");
            ProtoBufInstrumentation.beforeMethod(access$000);
            try {
                return this.mOriginalParser.parseFrom(byteBuffer);
            } finally {
                ProtoBufInstrumentation.afterMethod(access$000);
            }
        }

        public ProtoType parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            String access$000 = ProtoBufInstrumentation.getMethodName(this.mProtoName, ProtoBufInstrumentation.PB_PARSEFROM, "ByteBuffer,ExtensionRegistryLite");
            ProtoBufInstrumentation.beforeMethod(access$000);
            try {
                return this.mOriginalParser.parseFrom(byteBuffer, extensionRegistryLite);
            } finally {
                ProtoBufInstrumentation.afterMethod(access$000);
            }
        }

        public ProtoType parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            String access$000 = ProtoBufInstrumentation.getMethodName(this.mProtoName, ProtoBufInstrumentation.PB_PARSEFROM, "ByteString");
            ProtoBufInstrumentation.beforeMethod(access$000);
            try {
                return this.mOriginalParser.parseFrom(byteString);
            } finally {
                ProtoBufInstrumentation.afterMethod(access$000);
            }
        }

        public ProtoType parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            String access$000 = ProtoBufInstrumentation.getMethodName(this.mProtoName, ProtoBufInstrumentation.PB_PARSEFROM, "ByteString,ExtensionRegistryLite");
            ProtoBufInstrumentation.beforeMethod(access$000);
            try {
                return this.mOriginalParser.parseFrom(byteString, extensionRegistryLite);
            } finally {
                ProtoBufInstrumentation.afterMethod(access$000);
            }
        }

        public ProtoType parsePartialFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return this.mOriginalParser.parsePartialFrom(byteString);
        }

        public ProtoType parsePartialFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return this.mOriginalParser.parsePartialFrom(byteString, extensionRegistryLite);
        }

        public ProtoType parseFrom(byte[] bArr, int i, int i2) throws InvalidProtocolBufferException {
            String access$000 = ProtoBufInstrumentation.getMethodName(this.mProtoName, ProtoBufInstrumentation.PB_PARSEFROM, "byte[],int,int");
            ProtoBufInstrumentation.beforeMethod(access$000);
            try {
                return this.mOriginalParser.parseFrom(bArr, i, i2);
            } finally {
                ProtoBufInstrumentation.afterMethod(access$000);
            }
        }

        public ProtoType parseFrom(byte[] bArr, int i, int i2, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            String access$000 = ProtoBufInstrumentation.getMethodName(this.mProtoName, ProtoBufInstrumentation.PB_PARSEFROM, "byte[],int,int,ExtensionRegistryLite");
            ProtoBufInstrumentation.beforeMethod(access$000);
            try {
                return this.mOriginalParser.parseFrom(bArr, i, i2, extensionRegistryLite);
            } finally {
                ProtoBufInstrumentation.afterMethod(access$000);
            }
        }

        public ProtoType parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            String access$000 = ProtoBufInstrumentation.getMethodName(this.mProtoName, ProtoBufInstrumentation.PB_PARSEFROM, "byte[]");
            ProtoBufInstrumentation.beforeMethod(access$000);
            try {
                return this.mOriginalParser.parseFrom(bArr);
            } finally {
                ProtoBufInstrumentation.afterMethod(access$000);
            }
        }

        public ProtoType parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            String access$000 = ProtoBufInstrumentation.getMethodName(this.mProtoName, ProtoBufInstrumentation.PB_PARSEFROM, "byte[],ExtensionRegistryLite");
            ProtoBufInstrumentation.beforeMethod(access$000);
            try {
                return this.mOriginalParser.parseFrom(bArr, extensionRegistryLite);
            } finally {
                ProtoBufInstrumentation.afterMethod(access$000);
            }
        }

        public ProtoType parsePartialFrom(byte[] bArr, int i, int i2) throws InvalidProtocolBufferException {
            return this.mOriginalParser.parsePartialFrom(bArr, i, i2);
        }

        public ProtoType parsePartialFrom(byte[] bArr, int i, int i2, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return this.mOriginalParser.parsePartialFrom(bArr, i, i2, extensionRegistryLite);
        }

        public ProtoType parsePartialFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return this.mOriginalParser.parsePartialFrom(bArr);
        }

        public ProtoType parsePartialFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return this.mOriginalParser.parsePartialFrom(bArr, extensionRegistryLite);
        }

        public ProtoType parseFrom(InputStream inputStream) throws InvalidProtocolBufferException {
            String access$000 = ProtoBufInstrumentation.getMethodName(this.mProtoName, ProtoBufInstrumentation.PB_PARSEFROM, "InputStream");
            ProtoBufInstrumentation.beforeMethod(access$000);
            try {
                return this.mOriginalParser.parseFrom(inputStream);
            } finally {
                ProtoBufInstrumentation.afterMethod(access$000);
            }
        }

        public ProtoType parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            String access$000 = ProtoBufInstrumentation.getMethodName(this.mProtoName, ProtoBufInstrumentation.PB_PARSEFROM, "InputStream,ExtensionRegistryLite");
            ProtoBufInstrumentation.beforeMethod(access$000);
            try {
                return this.mOriginalParser.parseFrom(inputStream, extensionRegistryLite);
            } finally {
                ProtoBufInstrumentation.afterMethod(access$000);
            }
        }

        public ProtoType parsePartialFrom(InputStream inputStream) throws InvalidProtocolBufferException {
            return this.mOriginalParser.parsePartialFrom(inputStream);
        }

        public ProtoType parsePartialFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return this.mOriginalParser.parsePartialFrom(inputStream, extensionRegistryLite);
        }

        public ProtoType parseDelimitedFrom(InputStream inputStream) throws InvalidProtocolBufferException {
            return this.mOriginalParser.parseDelimitedFrom(inputStream);
        }

        public ProtoType parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return this.mOriginalParser.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public ProtoType parsePartialDelimitedFrom(InputStream inputStream) throws InvalidProtocolBufferException {
            return this.mOriginalParser.parsePartialDelimitedFrom(inputStream);
        }

        public ProtoType parsePartialDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return this.mOriginalParser.parsePartialDelimitedFrom(inputStream, extensionRegistryLite);
        }
    }

    public static void toByteArrayEnter(String str) {
        beforeMethod(getMethodName(str, (String) null, (String) null));
    }

    public static void toByteArrayExit(String str) {
        afterMethod(getMethodName(str, (String) null, (String) null));
    }

    /* access modifiers changed from: private */
    public static String getMethodName(String str, String str2, String str3) {
        if (str != null && str.contains("/")) {
            str = str.substring(str.lastIndexOf("/") + 1);
        }
        if (str2 != null) {
            return String.format("%s/%s(%s)", new Object[]{str, str2, str3});
        }
        return String.format("%s", new Object[]{str});
    }

    /* access modifiers changed from: private */
    public static void beforeMethod(String str) {
        MethodInfo.beforeMethod(str, 8);
    }

    /* access modifiers changed from: private */
    public static void afterMethod(String str) {
        MethodInfo.afterMethod(str, 8);
    }
}
