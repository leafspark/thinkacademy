package io.ktor.utils.io.charsets;

import io.flutter.embedding.android.KeyboardMap;
import java.nio.ByteBuffer;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\b\u0002\u001a\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0001H\u0000\u001a\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u0007H\u0000\u001a\u0010\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u0001H\u0002\u001a \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0001H\u0002\u001a\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\u0001H\u0002\u001a\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0001H\u0002\u001a\u0010\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u0001H\u0002\u001a\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0001H\u0002\u001a\u0010\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002\u001a\"\u0010\u001f\u001a\u00020\u0007*\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0001\u001a&\u0010#\u001a\u00020\u0007*\u00020 2\u0006\u0010!\u001a\u00020\"2\b\b\u0002\u0010\u0011\u001a\u00020\u00012\b\b\u0002\u0010\u0012\u001a\u00020\u0001\u001a$\u0010$\u001a\u00020\u0007*\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0001H\u0002\u001a$\u0010%\u001a\u00020\u0007*\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0001H\u0002\u001a$\u0010&\u001a\u00020\u0007*\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0001H\u0002\u001a9\u0010&\u001a\u00020\u0007*\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00012\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u00150(H\b\u001a$\u0010*\u001a\u00020\u0007*\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0001H\u0002\u001a9\u0010*\u001a\u00020\u0007*\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00012\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u00150(H\b\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"HighSurrogateMagic", "", "MaxCodePoint", "MinHighSurrogate", "MinLowSurrogate", "MinSupplementary", "decodeUtf8Result", "", "numberOfChars", "requireBytes", "decodeUtf8ResultAcc", "preDecoded", "result", "highSurrogate", "cp", "indexOutOfBounds", "", "offset", "length", "arrayLength", "isBmpCodePoint", "", "isValidCodePoint", "codePoint", "lowSurrogate", "malformedCodePoint", "", "value", "unsupportedByteCount", "b", "", "decodeUTF", "Ljava/nio/ByteBuffer;", "out", "", "decodeUTF8Line", "decodeUTF8Line_array", "decodeUTF8Line_buffer", "decodeUTF8_array", "predicate", "Lkotlin/Function1;", "", "decodeUTF8_buffer", "ktor-io"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: UTF.kt */
public final class UTFKt {
    private static final int HighSurrogateMagic = 55232;
    private static final int MaxCodePoint = 1114111;
    private static final int MinHighSurrogate = 55296;
    private static final int MinLowSurrogate = 56320;
    private static final int MinSupplementary = 65536;

    public static final long decodeUtf8Result(int i, int i2) {
        return (((long) i2) & KeyboardMap.kValueMask) | (((long) i) << 32);
    }

    private static final int highSurrogate(int i) {
        return (i >>> 10) + HighSurrogateMagic;
    }

    private static final boolean isBmpCodePoint(int i) {
        return (i >>> 16) == 0;
    }

    private static final boolean isValidCodePoint(int i) {
        return i <= MaxCodePoint;
    }

    private static final int lowSurrogate(int i) {
        return (i & 1023) + MinLowSurrogate;
    }

    public static final long decodeUtf8ResultAcc(int i, long j) {
        return decodeUtf8Result(i + ((int) (j >> 32)), (int) (j & KeyboardMap.kValueMask));
    }

    public static final long decodeUTF(ByteBuffer byteBuffer, char[] cArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(byteBuffer, "<this>");
        Intrinsics.checkNotNullParameter(cArr, "out");
        int decodeASCII = StringsKt.decodeASCII(byteBuffer, cArr, i, i2);
        if (!byteBuffer.hasRemaining() || decodeASCII == i2) {
            return decodeUtf8Result(decodeASCII, 0);
        }
        if (byteBuffer.hasArray()) {
            return decodeUtf8ResultAcc(decodeASCII, decodeUTF8_array(byteBuffer, cArr, i + decodeASCII, i2 - decodeASCII));
        }
        return decodeUtf8ResultAcc(decodeASCII, decodeUTF8_buffer(byteBuffer, cArr, i + decodeASCII, i2 - decodeASCII));
    }

    public static /* synthetic */ long decodeUTF8Line$default(ByteBuffer byteBuffer, char[] cArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = cArr.length;
        }
        return decodeUTF8Line(byteBuffer, cArr, i, i2);
    }

    public static final long decodeUTF8Line(ByteBuffer byteBuffer, char[] cArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(byteBuffer, "<this>");
        Intrinsics.checkNotNullParameter(cArr, "out");
        if (byteBuffer.hasArray()) {
            return decodeUTF8Line_array(byteBuffer, cArr, i, i2);
        }
        return decodeUTF8Line_buffer(byteBuffer, cArr, i, i2);
    }

    private static final long decodeUTF8_array(ByteBuffer byteBuffer, char[] cArr, int i, int i2) {
        byte[] array = byteBuffer.array();
        int arrayOffset = byteBuffer.arrayOffset() + byteBuffer.position();
        int remaining = byteBuffer.remaining() + arrayOffset;
        if (arrayOffset <= remaining) {
            if (remaining <= array.length) {
                int i3 = i + i2;
                if (i3 <= cArr.length) {
                    int i4 = i;
                    while (arrayOffset < remaining && i4 < i3) {
                        int i5 = arrayOffset + 1;
                        byte b = array[arrayOffset];
                        if (b >= 0) {
                            cArr[i4] = (char) b;
                            arrayOffset = i5;
                            i4++;
                        } else if ((b & 224) == 192) {
                            if (i5 >= remaining) {
                                byteBuffer.position((i5 - 1) - byteBuffer.arrayOffset());
                                return decodeUtf8Result(i4 - i, 2);
                            }
                            cArr[i4] = (char) (((b & 31) << 6) | (array[i5] & 63));
                            arrayOffset = i5 + 1;
                            i4++;
                        } else if ((b & 240) == 224) {
                            if (remaining - i5 < 2) {
                                byteBuffer.position((i5 - 1) - byteBuffer.arrayOffset());
                                return decodeUtf8Result(i4 - i, 3);
                            }
                            int i6 = i5 + 1;
                            int i7 = i6 + 1;
                            byte b2 = b & 15;
                            byte b3 = ((array[i5] & 63) << 6) | (b2 << 12) | (array[i6] & 63);
                            if (b2 == 0 || isBmpCodePoint(b3)) {
                                cArr[i4] = (char) b3;
                                i4++;
                                arrayOffset = i7;
                            } else {
                                malformedCodePoint(b3);
                                throw new KotlinNothingValueException();
                            }
                        } else if ((b & 248) != 240) {
                            unsupportedByteCount(b);
                            throw new KotlinNothingValueException();
                        } else if (remaining - i5 < 3) {
                            byteBuffer.position((i5 - 1) - byteBuffer.arrayOffset());
                            return decodeUtf8Result(i4 - i, 4);
                        } else {
                            int i8 = i5 + 1;
                            int i9 = i8 + 1;
                            int i10 = i9 + 1;
                            byte b4 = ((b & 7) << 18) | ((array[i5] & 63) << 12) | ((array[i8] & 63) << 6) | (array[i9] & 63);
                            if (!isValidCodePoint(b4)) {
                                malformedCodePoint(b4);
                                throw new KotlinNothingValueException();
                            } else if (i3 - i4 >= 2) {
                                int highSurrogate = highSurrogate(b4);
                                int lowSurrogate = lowSurrogate(b4);
                                int i11 = i4 + 1;
                                cArr[i4] = (char) highSurrogate;
                                i4 = i11 + 1;
                                cArr[i11] = (char) lowSurrogate;
                                arrayOffset = i10;
                            } else {
                                byteBuffer.position((i10 - 4) - byteBuffer.arrayOffset());
                                return decodeUtf8Result(i4 - i, 0);
                            }
                        }
                    }
                    byteBuffer.position(arrayOffset - byteBuffer.arrayOffset());
                    return decodeUtf8Result(i4 - i, 0);
                }
                throw indexOutOfBounds(i, i2, cArr.length);
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    private static final long decodeUTF8_buffer(ByteBuffer byteBuffer, char[] cArr, int i, int i2) {
        int i3 = i + i2;
        if (i3 <= cArr.length) {
            int i4 = i;
            while (byteBuffer.hasRemaining() && i4 < i3) {
                byte b = byteBuffer.get();
                if (b >= 0) {
                    cArr[i4] = (char) b;
                    i4++;
                } else if ((b & 224) == 192) {
                    if (byteBuffer.hasRemaining()) {
                        byteBuffer.position(byteBuffer.position() - 1);
                        return decodeUtf8Result(i4 - i, 2);
                    }
                    cArr[i4] = (char) (((b & 31) << 6) | (byteBuffer.get() & 63));
                    i4++;
                } else if ((b & 240) == 224) {
                    if (byteBuffer.remaining() < 2) {
                        byteBuffer.position(byteBuffer.position() - 1);
                        return decodeUtf8Result(i4 - i, 3);
                    }
                    byte b2 = b & 15;
                    byte b3 = ((byteBuffer.get() & 63) << 6) | (b2 << 12) | (byteBuffer.get() & 63);
                    if (b2 == 0 || isBmpCodePoint(b3)) {
                        cArr[i4] = (char) b3;
                        i4++;
                    } else {
                        malformedCodePoint(b3);
                        throw new KotlinNothingValueException();
                    }
                } else if ((b & 248) != 240) {
                    unsupportedByteCount(b);
                    throw new KotlinNothingValueException();
                } else if (byteBuffer.remaining() < 3) {
                    byteBuffer.position(byteBuffer.position() - 1);
                    return decodeUtf8Result(i4 - i, 4);
                } else {
                    byte b4 = ((b & 7) << 18) | ((byteBuffer.get() & 63) << 12) | ((byteBuffer.get() & 63) << 6) | (byteBuffer.get() & 63);
                    if (!isValidCodePoint(b4)) {
                        malformedCodePoint(b4);
                        throw new KotlinNothingValueException();
                    } else if (i3 - i4 >= 2) {
                        int highSurrogate = highSurrogate(b4);
                        int lowSurrogate = lowSurrogate(b4);
                        int i5 = i4 + 1;
                        cArr[i4] = (char) highSurrogate;
                        i4 = i5 + 1;
                        cArr[i5] = (char) lowSurrogate;
                    } else {
                        byteBuffer.position(byteBuffer.position() - 4);
                        return decodeUtf8Result(i4 - i, 0);
                    }
                }
            }
            return decodeUtf8Result(i4 - i, 0);
        }
        throw indexOutOfBounds(i, i2, cArr.length);
    }

    private static final long decodeUTF8_array(ByteBuffer byteBuffer, char[] cArr, int i, int i2, Function1<? super Character, Boolean> function1) {
        int i3;
        int i4;
        ByteBuffer byteBuffer2 = byteBuffer;
        char[] cArr2 = cArr;
        int i5 = i;
        int i6 = i2;
        Function1<? super Character, Boolean> function12 = function1;
        byte[] array = byteBuffer.array();
        int arrayOffset = byteBuffer.arrayOffset() + byteBuffer.position();
        int remaining = byteBuffer.remaining() + arrayOffset;
        if (arrayOffset <= remaining) {
            if (remaining <= array.length) {
                int i7 = i5 + i6;
                if (i7 <= cArr2.length) {
                    int i8 = i5;
                    while (arrayOffset < remaining && i8 < i7) {
                        int i9 = arrayOffset + 1;
                        byte b = array[arrayOffset];
                        if (b >= 0) {
                            char c = (char) b;
                            if (!((Boolean) function12.invoke(Character.valueOf(c))).booleanValue()) {
                                byteBuffer2.position((i9 - 1) - byteBuffer.arrayOffset());
                                return decodeUtf8Result(i8 - i5, -1);
                            }
                            cArr2[i8] = c;
                            arrayOffset = i9;
                            i8++;
                        } else {
                            if ((b & 224) == 192) {
                                if (i9 >= remaining) {
                                    byteBuffer2.position((i9 - 1) - byteBuffer.arrayOffset());
                                    return decodeUtf8Result(i8 - i5, 2);
                                }
                                i3 = i9 + 1;
                                char c2 = (char) (((b & 31) << 6) | (array[i9] & 63));
                                if (!((Boolean) function12.invoke(Character.valueOf(c2))).booleanValue()) {
                                    byteBuffer2.position((i3 - 2) - byteBuffer.arrayOffset());
                                    return decodeUtf8Result(i8 - i5, -1);
                                }
                                i4 = i8 + 1;
                                cArr2[i8] = c2;
                            } else if ((b & 240) == 224) {
                                if (remaining - i9 < 2) {
                                    byteBuffer2.position((i9 - 1) - byteBuffer.arrayOffset());
                                    return decodeUtf8Result(i8 - i5, 3);
                                }
                                int i10 = i9 + 1;
                                i3 = i10 + 1;
                                byte b2 = b & 15;
                                byte b3 = (array[i10] & 63) | ((array[i9] & 63) << 6) | (b2 << 12);
                                if (b2 == 0 || isBmpCodePoint(b3)) {
                                    char c3 = (char) b3;
                                    if (!((Boolean) function12.invoke(Character.valueOf(c3))).booleanValue()) {
                                        byteBuffer2.position((i3 - 4) - byteBuffer.arrayOffset());
                                        return decodeUtf8Result(i8 - i5, -1);
                                    }
                                    i4 = i8 + 1;
                                    cArr2[i8] = c3;
                                } else {
                                    malformedCodePoint(b3);
                                    throw new KotlinNothingValueException();
                                }
                            } else if ((b & 248) != 240) {
                                unsupportedByteCount(b);
                                throw new KotlinNothingValueException();
                            } else if (remaining - i9 < 3) {
                                byteBuffer2.position((i9 - 1) - byteBuffer.arrayOffset());
                                return decodeUtf8Result(i8 - i5, 4);
                            } else {
                                int i11 = i9 + 1;
                                int i12 = i11 + 1;
                                int i13 = i12 + 1;
                                byte b4 = ((b & 7) << 18) | ((array[i9] & 63) << 12) | ((array[i11] & 63) << 6) | (array[i12] & 63);
                                if (!isValidCodePoint(b4)) {
                                    malformedCodePoint(b4);
                                    throw new KotlinNothingValueException();
                                } else if (i7 - i8 >= 2) {
                                    char highSurrogate = (char) highSurrogate(b4);
                                    char lowSurrogate = (char) lowSurrogate(b4);
                                    if (!((Boolean) function12.invoke(Character.valueOf(highSurrogate))).booleanValue() || !((Boolean) function12.invoke(Character.valueOf(lowSurrogate))).booleanValue()) {
                                        byteBuffer2.position((i13 - 4) - byteBuffer.arrayOffset());
                                        return decodeUtf8Result(i8 - i5, -1);
                                    }
                                    int i14 = i8 + 1;
                                    cArr2[i8] = highSurrogate;
                                    i8 = i14 + 1;
                                    cArr2[i14] = lowSurrogate;
                                    arrayOffset = i13;
                                } else {
                                    byteBuffer2.position((i13 - 4) - byteBuffer.arrayOffset());
                                    return decodeUtf8Result(i8 - i5, 0);
                                }
                            }
                            i8 = i4;
                            arrayOffset = i3;
                        }
                    }
                    byteBuffer2.position(arrayOffset - byteBuffer.arrayOffset());
                    return decodeUtf8Result(i8 - i5, 0);
                }
                throw indexOutOfBounds(i5, i6, cArr2.length);
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    private static final long decodeUTF8_buffer(ByteBuffer byteBuffer, char[] cArr, int i, int i2, Function1<? super Character, Boolean> function1) {
        int i3;
        int i4 = i + i2;
        if (i4 <= cArr.length) {
            int i5 = i;
            while (byteBuffer.hasRemaining() && i5 < i4) {
                byte b = byteBuffer.get();
                if (b >= 0) {
                    char c = (char) b;
                    if (!((Boolean) function1.invoke(Character.valueOf(c))).booleanValue()) {
                        byteBuffer.position(byteBuffer.position() - 1);
                        return decodeUtf8Result(i5 - i, -1);
                    }
                    i3 = i5 + 1;
                    cArr[i5] = c;
                } else if ((b & 224) == 192) {
                    if (!byteBuffer.hasRemaining()) {
                        byteBuffer.position(byteBuffer.position() - 1);
                        return decodeUtf8Result(i5 - i, 2);
                    }
                    char c2 = (char) (((b & 31) << 6) | (byteBuffer.get() & 63));
                    if (!((Boolean) function1.invoke(Character.valueOf(c2))).booleanValue()) {
                        byteBuffer.position(byteBuffer.position() - 2);
                        return decodeUtf8Result(i5 - i, -1);
                    }
                    i3 = i5 + 1;
                    cArr[i5] = c2;
                } else if ((b & 240) == 224) {
                    if (byteBuffer.remaining() < 2) {
                        byteBuffer.position(byteBuffer.position() - 1);
                        return decodeUtf8Result(i5 - i, 3);
                    }
                    byte b2 = b & 15;
                    byte b3 = ((byteBuffer.get() & 63) << 6) | (b2 << 12) | (byteBuffer.get() & 63);
                    if (b2 == 0 || isBmpCodePoint(b3)) {
                        char c3 = (char) b3;
                        if (!((Boolean) function1.invoke(Character.valueOf(c3))).booleanValue()) {
                            byteBuffer.position(byteBuffer.position() - 3);
                            return decodeUtf8Result(i5 - i, -1);
                        }
                        i3 = i5 + 1;
                        cArr[i5] = c3;
                    } else {
                        malformedCodePoint(b3);
                        throw new KotlinNothingValueException();
                    }
                } else if ((b & 248) != 240) {
                    unsupportedByteCount(b);
                    throw new KotlinNothingValueException();
                } else if (byteBuffer.remaining() < 3) {
                    byteBuffer.position(byteBuffer.position() - 1);
                    return decodeUtf8Result(i5 - i, 4);
                } else {
                    byte b4 = ((b & 7) << 18) | ((byteBuffer.get() & 63) << 12) | ((byteBuffer.get() & 63) << 6) | (byteBuffer.get() & 63);
                    if (!isValidCodePoint(b4)) {
                        malformedCodePoint(b4);
                        throw new KotlinNothingValueException();
                    } else if (i4 - i5 >= 2) {
                        char highSurrogate = (char) highSurrogate(b4);
                        char lowSurrogate = (char) lowSurrogate(b4);
                        if (!((Boolean) function1.invoke(Character.valueOf(highSurrogate))).booleanValue() || !((Boolean) function1.invoke(Character.valueOf(lowSurrogate))).booleanValue()) {
                            byteBuffer.position(byteBuffer.position() - 4);
                            return decodeUtf8Result(i5 - i, -1);
                        }
                        int i6 = i5 + 1;
                        cArr[i5] = highSurrogate;
                        i5 = i6 + 1;
                        cArr[i6] = lowSurrogate;
                    } else {
                        byteBuffer.position(byteBuffer.position() - 4);
                        return decodeUtf8Result(i5 - i, 0);
                    }
                }
                i5 = i3;
            }
            return decodeUtf8Result(i5 - i, 0);
        }
        throw indexOutOfBounds(i, i2, cArr.length);
    }

    private static final Throwable indexOutOfBounds(int i, int i2, int i3) {
        return new IndexOutOfBoundsException(i + " (offset) + " + i2 + " (length) > " + i3 + " (array.length)");
    }

    private static final Void malformedCodePoint(int i) {
        throw new IllegalArgumentException("Malformed code-point " + Integer.toHexString(i) + " found");
    }

    private static final Void unsupportedByteCount(byte b) {
        StringBuilder sb = new StringBuilder();
        sb.append("Unsupported byte code, first byte is 0x");
        String num = Integer.toString(b & UByte.MAX_VALUE, CharsKt.checkRadix(16));
        Intrinsics.checkNotNullExpressionValue(num, "toString(this, checkRadix(radix))");
        sb.append(StringsKt.padStart(num, 2, '0'));
        throw new IllegalStateException(sb.toString().toString());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00ae, code lost:
        r2 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x01a7, code lost:
        r0.position((r15 - 4) - r17.arrayOffset());
        r3 = decodeUtf8Result(r3 - r2, -1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final long decodeUTF8Line_array(java.nio.ByteBuffer r17, char[] r18, int r19, int r20) {
        /*
            r0 = r17
            r1 = r18
            r2 = r19
            r3 = r20
            byte[] r4 = r17.array()
            int r5 = r17.arrayOffset()
            int r6 = r17.position()
            int r5 = r5 + r6
            int r6 = r17.remaining()
            int r6 = r6 + r5
            r8 = 1
            if (r5 > r6) goto L_0x001f
            r9 = r8
            goto L_0x0020
        L_0x001f:
            r9 = 0
        L_0x0020:
            java.lang.String r10 = "Failed requirement."
            if (r9 == 0) goto L_0x023b
            int r9 = r4.length
            if (r6 > r9) goto L_0x0029
            r9 = r8
            goto L_0x002a
        L_0x0029:
            r9 = 0
        L_0x002a:
            if (r9 == 0) goto L_0x0231
            int r9 = r2 + r3
            int r10 = r1.length
            if (r9 > r10) goto L_0x022b
            r3 = r2
            r10 = 0
        L_0x0033:
            r11 = 2
            r12 = 13
            r13 = -1
            if (r5 >= r6) goto L_0x01da
            if (r3 >= r9) goto L_0x01da
            int r14 = r5 + 1
            byte r5 = r4[r5]
            r15 = 10
            if (r5 < 0) goto L_0x006b
            char r5 = (char) r5
            if (r5 != r12) goto L_0x0049
            r10 = r8
            r15 = r10
            goto L_0x0052
        L_0x0049:
            if (r5 != r15) goto L_0x004e
            r10 = 0
        L_0x004c:
            r15 = 0
            goto L_0x0052
        L_0x004e:
            if (r10 == 0) goto L_0x0051
            goto L_0x004c
        L_0x0051:
            r15 = r8
        L_0x0052:
            if (r15 != 0) goto L_0x0064
            int r14 = r14 - r8
            int r4 = r17.arrayOffset()
            int r14 = r14 - r4
            r0.position(r14)
            int r3 = r3 - r2
            long r2 = decodeUtf8Result(r3, r13)
            goto L_0x01e8
        L_0x0064:
            int r11 = r3 + 1
            r1[r3] = r5
        L_0x0068:
            r3 = r11
            r5 = r14
            goto L_0x0033
        L_0x006b:
            r7 = r5 & 224(0xe0, float:3.14E-43)
            r13 = 192(0xc0, float:2.69E-43)
            if (r7 != r13) goto L_0x00b9
            if (r14 < r6) goto L_0x0083
            int r14 = r14 - r8
            int r4 = r17.arrayOffset()
            int r14 = r14 - r4
            r0.position(r14)
            int r3 = r3 - r2
            long r2 = decodeUtf8Result(r3, r11)
            goto L_0x01e8
        L_0x0083:
            int r7 = r14 + 1
            byte r13 = r4[r14]
            r5 = r5 & 31
            int r5 = r5 << 6
            r13 = r13 & 63
            r5 = r5 | r13
            char r5 = (char) r5
            if (r5 != r12) goto L_0x0094
            r10 = r8
            r13 = r10
            goto L_0x009d
        L_0x0094:
            if (r5 != r15) goto L_0x0099
            r10 = 0
        L_0x0097:
            r13 = 0
            goto L_0x009d
        L_0x0099:
            if (r10 == 0) goto L_0x009c
            goto L_0x0097
        L_0x009c:
            r13 = r8
        L_0x009d:
            if (r13 != 0) goto L_0x00b1
            int r7 = r7 - r11
            int r4 = r17.arrayOffset()
            int r7 = r7 - r4
            r0.position(r7)
            int r3 = r3 - r2
            r2 = -1
            long r3 = decodeUtf8Result(r3, r2)
        L_0x00ae:
            r2 = r3
            goto L_0x01e8
        L_0x00b1:
            int r11 = r3 + 1
            r1[r3] = r5
            r5 = r7
            r3 = r11
            goto L_0x0033
        L_0x00b9:
            r7 = r5 & 240(0xf0, float:3.36E-43)
            r13 = 3
            r15 = 224(0xe0, float:3.14E-43)
            r12 = 4
            if (r7 != r15) goto L_0x0127
            int r7 = r6 - r14
            if (r7 >= r11) goto L_0x00d5
            int r14 = r14 - r8
            int r4 = r17.arrayOffset()
            int r14 = r14 - r4
            r0.position(r14)
            int r3 = r3 - r2
            long r2 = decodeUtf8Result(r3, r13)
            goto L_0x01e8
        L_0x00d5:
            int r7 = r14 + 1
            byte r13 = r4[r14]
            int r14 = r7 + 1
            byte r7 = r4[r7]
            r5 = r5 & 15
            int r15 = r5 << 12
            r13 = r13 & 63
            int r13 = r13 << 6
            r13 = r13 | r15
            r7 = r7 & 63
            r7 = r7 | r13
            if (r5 == 0) goto L_0x00fb
            boolean r5 = isBmpCodePoint(r7)
            if (r5 == 0) goto L_0x00f2
            goto L_0x00fb
        L_0x00f2:
            malformedCodePoint(r7)
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException
            r0.<init>()
            throw r0
        L_0x00fb:
            char r5 = (char) r7
            r7 = 13
            if (r5 != r7) goto L_0x0103
            r7 = r8
            r10 = r7
            goto L_0x010f
        L_0x0103:
            r7 = 10
            if (r5 != r7) goto L_0x010a
            r7 = 0
            r10 = 0
            goto L_0x010f
        L_0x010a:
            if (r10 == 0) goto L_0x010e
            r7 = 0
            goto L_0x010f
        L_0x010e:
            r7 = r8
        L_0x010f:
            if (r7 != 0) goto L_0x0121
            int r14 = r14 - r12
            int r4 = r17.arrayOffset()
            int r14 = r14 - r4
            r0.position(r14)
            int r3 = r3 - r2
            r2 = -1
            long r3 = decodeUtf8Result(r3, r2)
            goto L_0x00ae
        L_0x0121:
            int r11 = r3 + 1
            r1[r3] = r5
            goto L_0x0068
        L_0x0127:
            r7 = r5 & 248(0xf8, float:3.48E-43)
            r15 = 240(0xf0, float:3.36E-43)
            if (r7 != r15) goto L_0x01d1
            int r7 = r6 - r14
            if (r7 >= r13) goto L_0x0141
            int r14 = r14 - r8
            int r4 = r17.arrayOffset()
            int r14 = r14 - r4
            r0.position(r14)
            int r3 = r3 - r2
            long r2 = decodeUtf8Result(r3, r12)
            goto L_0x01e8
        L_0x0141:
            int r7 = r14 + 1
            byte r13 = r4[r14]
            int r14 = r7 + 1
            byte r7 = r4[r7]
            int r15 = r14 + 1
            byte r14 = r4[r14]
            r5 = r5 & 7
            int r5 = r5 << 18
            r13 = r13 & 63
            int r13 = r13 << 12
            r5 = r5 | r13
            r7 = r7 & 63
            int r7 = r7 << 6
            r5 = r5 | r7
            r7 = r14 & 63
            r5 = r5 | r7
            boolean r7 = isValidCodePoint(r5)
            if (r7 == 0) goto L_0x01c8
            int r7 = r9 - r3
            if (r7 < r11) goto L_0x01b8
            int r7 = highSurrogate(r5)
            char r7 = (char) r7
            int r5 = lowSurrogate(r5)
            char r5 = (char) r5
            r13 = 13
            if (r7 != r13) goto L_0x017c
            r10 = r8
            r16 = r10
            r14 = 10
            goto L_0x0189
        L_0x017c:
            r14 = 10
            if (r7 != r14) goto L_0x0184
            r10 = 0
        L_0x0181:
            r16 = 0
            goto L_0x0189
        L_0x0184:
            if (r10 == 0) goto L_0x0187
            goto L_0x0181
        L_0x0187:
            r16 = r8
        L_0x0189:
            if (r16 == 0) goto L_0x01a7
            if (r5 != r13) goto L_0x0190
            r10 = r8
            r13 = r10
            goto L_0x0199
        L_0x0190:
            if (r5 != r14) goto L_0x0195
            r10 = 0
        L_0x0193:
            r13 = 0
            goto L_0x0199
        L_0x0195:
            if (r10 == 0) goto L_0x0198
            goto L_0x0193
        L_0x0198:
            r13 = r8
        L_0x0199:
            if (r13 != 0) goto L_0x019c
            goto L_0x01a7
        L_0x019c:
            int r11 = r3 + 1
            r1[r3] = r7
            int r3 = r11 + 1
            r1[r11] = r5
            r5 = r15
            goto L_0x0033
        L_0x01a7:
            int r15 = r15 - r12
            int r4 = r17.arrayOffset()
            int r15 = r15 - r4
            r0.position(r15)
            int r3 = r3 - r2
            r2 = -1
            long r3 = decodeUtf8Result(r3, r2)
            goto L_0x00ae
        L_0x01b8:
            int r15 = r15 - r12
            int r4 = r17.arrayOffset()
            int r15 = r15 - r4
            r0.position(r15)
            int r3 = r3 - r2
            r2 = 0
            long r2 = decodeUtf8Result(r3, r2)
            goto L_0x01e8
        L_0x01c8:
            malformedCodePoint(r5)
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException
            r0.<init>()
            throw r0
        L_0x01d1:
            unsupportedByteCount(r5)
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException
            r0.<init>()
            throw r0
        L_0x01da:
            int r4 = r17.arrayOffset()
            int r5 = r5 - r4
            r0.position(r5)
            int r3 = r3 - r2
            r2 = 0
            long r2 = decodeUtf8Result(r3, r2)
        L_0x01e8:
            r4 = 4294967295(0xffffffff, double:2.1219957905E-314)
            long r4 = r4 & r2
            int r4 = (int) r4
            r5 = 32
            r6 = -1
            if (r4 != r6) goto L_0x0215
            long r4 = r2 >> r5
            int r4 = (int) r4
            if (r10 == 0) goto L_0x01ff
            int r4 = r4 - r8
            long r0 = decodeUtf8Result(r4, r6)
            return r0
        L_0x01ff:
            int r5 = r17.position()
            int r5 = r5 + r8
            r0.position(r5)
            if (r4 <= 0) goto L_0x022a
            int r4 = r4 - r8
            char r0 = r1[r4]
            r1 = 13
            if (r0 != r1) goto L_0x022a
            long r0 = decodeUtf8Result(r4, r6)
            return r0
        L_0x0215:
            if (r4 != 0) goto L_0x022a
            if (r10 == 0) goto L_0x022a
            long r1 = r2 >> r5
            int r1 = (int) r1
            int r2 = r17.position()
            int r2 = r2 - r8
            r0.position(r2)
            int r1 = r1 - r8
            long r0 = decodeUtf8Result(r1, r11)
            return r0
        L_0x022a:
            return r2
        L_0x022b:
            int r0 = r1.length
            java.lang.Throwable r0 = indexOutOfBounds(r2, r3, r0)
            throw r0
        L_0x0231:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = r10.toString()
            r0.<init>(r1)
            throw r0
        L_0x023b:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = r10.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.charsets.UTFKt.decodeUTF8Line_array(java.nio.ByteBuffer, char[], int, int):long");
    }

    /* JADX WARNING: Removed duplicated region for block: B:117:0x0082 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x0036 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0177 A[EDGE_INSN: B:128:0x0177->B:90:0x0177 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x00ea A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x0177 A[EDGE_INSN: B:130:0x0177->B:90:0x0177 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x015c  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x016d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final long decodeUTF8Line_buffer(java.nio.ByteBuffer r17, char[] r18, int r19, int r20) {
        /*
            r0 = r17
            r1 = r18
            r2 = r19
            r3 = r20
            int r4 = r2 + r3
            int r5 = r1.length
            if (r4 > r5) goto L_0x01ea
            r3 = 0
            r5 = r2
            r6 = r3
        L_0x0010:
            boolean r7 = r17.hasRemaining()
            r8 = 2
            r9 = 13
            r10 = -1
            r11 = 1
            if (r7 == 0) goto L_0x01a5
            if (r5 >= r4) goto L_0x01a5
            byte r7 = r17.get()
            r12 = 10
            if (r7 < 0) goto L_0x004b
            char r7 = (char) r7
            if (r7 != r9) goto L_0x002b
            r6 = r11
        L_0x0029:
            r12 = r6
            goto L_0x0034
        L_0x002b:
            if (r7 != r12) goto L_0x002f
            r6 = r3
            goto L_0x0029
        L_0x002f:
            if (r6 == 0) goto L_0x0033
            r12 = r3
            goto L_0x0034
        L_0x0033:
            r12 = r11
        L_0x0034:
            if (r12 != 0) goto L_0x0045
            int r3 = r17.position()
            int r3 = r3 - r11
            r0.position(r3)
            int r5 = r5 - r2
            long r2 = decodeUtf8Result(r5, r10)
            goto L_0x01aa
        L_0x0045:
            int r8 = r5 + 1
            r1[r5] = r7
        L_0x0049:
            r5 = r8
            goto L_0x0010
        L_0x004b:
            r13 = r7 & 224(0xe0, float:3.14E-43)
            r14 = 192(0xc0, float:2.69E-43)
            if (r13 != r14) goto L_0x0096
            boolean r13 = r17.hasRemaining()
            if (r13 != 0) goto L_0x0066
            int r3 = r17.position()
            int r3 = r3 - r11
            r0.position(r3)
            int r5 = r5 - r2
            long r2 = decodeUtf8Result(r5, r8)
            goto L_0x01aa
        L_0x0066:
            byte r13 = r17.get()
            r7 = r7 & 31
            int r7 = r7 << 6
            r13 = r13 & 63
            r7 = r7 | r13
            char r7 = (char) r7
            if (r7 != r9) goto L_0x0077
            r6 = r11
        L_0x0075:
            r12 = r6
            goto L_0x0080
        L_0x0077:
            if (r7 != r12) goto L_0x007b
            r6 = r3
            goto L_0x0075
        L_0x007b:
            if (r6 == 0) goto L_0x007f
            r12 = r3
            goto L_0x0080
        L_0x007f:
            r12 = r11
        L_0x0080:
            if (r12 != 0) goto L_0x0091
            int r3 = r17.position()
            int r3 = r3 - r8
            r0.position(r3)
            int r5 = r5 - r2
            long r2 = decodeUtf8Result(r5, r10)
            goto L_0x01aa
        L_0x0091:
            int r8 = r5 + 1
            r1[r5] = r7
            goto L_0x0049
        L_0x0096:
            r13 = r7 & 240(0xf0, float:3.36E-43)
            r14 = 224(0xe0, float:3.14E-43)
            r15 = 3
            if (r13 != r14) goto L_0x00ff
            int r13 = r17.remaining()
            if (r13 >= r8) goto L_0x00b2
            int r3 = r17.position()
            int r3 = r3 - r11
            r0.position(r3)
            int r5 = r5 - r2
            long r2 = decodeUtf8Result(r5, r15)
            goto L_0x01aa
        L_0x00b2:
            byte r13 = r17.get()
            byte r14 = r17.get()
            r7 = r7 & 15
            int r16 = r7 << 12
            r13 = r13 & 63
            int r13 = r13 << 6
            r13 = r16 | r13
            r14 = r14 & 63
            r13 = r13 | r14
            if (r7 == 0) goto L_0x00d9
            boolean r7 = isBmpCodePoint(r13)
            if (r7 == 0) goto L_0x00d0
            goto L_0x00d9
        L_0x00d0:
            malformedCodePoint(r13)
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException
            r0.<init>()
            throw r0
        L_0x00d9:
            char r7 = (char) r13
            if (r7 != r9) goto L_0x00df
            r6 = r11
        L_0x00dd:
            r12 = r6
            goto L_0x00e8
        L_0x00df:
            if (r7 != r12) goto L_0x00e3
            r6 = r3
            goto L_0x00dd
        L_0x00e3:
            if (r6 == 0) goto L_0x00e7
            r12 = r3
            goto L_0x00e8
        L_0x00e7:
            r12 = r11
        L_0x00e8:
            if (r12 != 0) goto L_0x00f9
            int r3 = r17.position()
            int r3 = r3 - r15
            r0.position(r3)
            int r5 = r5 - r2
            long r2 = decodeUtf8Result(r5, r10)
            goto L_0x01aa
        L_0x00f9:
            int r8 = r5 + 1
            r1[r5] = r7
            goto L_0x0049
        L_0x00ff:
            r13 = r7 & 248(0xf8, float:3.48E-43)
            r14 = 240(0xf0, float:3.36E-43)
            if (r13 != r14) goto L_0x019c
            int r13 = r17.remaining()
            r14 = 4
            if (r13 >= r15) goto L_0x011b
            int r3 = r17.position()
            int r3 = r3 - r11
            r0.position(r3)
            int r5 = r5 - r2
            long r2 = decodeUtf8Result(r5, r14)
            goto L_0x01aa
        L_0x011b:
            byte r13 = r17.get()
            byte r15 = r17.get()
            byte r16 = r17.get()
            r7 = r7 & 7
            int r7 = r7 << 18
            r13 = r13 & 63
            int r13 = r13 << 12
            r7 = r7 | r13
            r13 = r15 & 63
            int r13 = r13 << 6
            r7 = r7 | r13
            r13 = r16 & 63
            r7 = r7 | r13
            boolean r13 = isValidCodePoint(r7)
            if (r13 == 0) goto L_0x0193
            int r13 = r4 - r5
            if (r13 < r8) goto L_0x0185
            int r13 = highSurrogate(r7)
            char r13 = (char) r13
            int r7 = lowSurrogate(r7)
            char r7 = (char) r7
            if (r13 != r9) goto L_0x0151
            r6 = r11
        L_0x014f:
            r15 = r6
            goto L_0x015a
        L_0x0151:
            if (r13 != r12) goto L_0x0155
            r6 = r3
            goto L_0x014f
        L_0x0155:
            if (r6 == 0) goto L_0x0159
            r15 = r3
            goto L_0x015a
        L_0x0159:
            r15 = r11
        L_0x015a:
            if (r15 == 0) goto L_0x0177
            if (r7 != r9) goto L_0x0161
            r6 = r11
        L_0x015f:
            r12 = r6
            goto L_0x016a
        L_0x0161:
            if (r7 != r12) goto L_0x0165
            r6 = r3
            goto L_0x015f
        L_0x0165:
            if (r6 == 0) goto L_0x0169
            r12 = r3
            goto L_0x016a
        L_0x0169:
            r12 = r11
        L_0x016a:
            if (r12 != 0) goto L_0x016d
            goto L_0x0177
        L_0x016d:
            int r8 = r5 + 1
            r1[r5] = r13
            int r5 = r8 + 1
            r1[r8] = r7
            goto L_0x0010
        L_0x0177:
            int r3 = r17.position()
            int r3 = r3 - r14
            r0.position(r3)
            int r5 = r5 - r2
            long r2 = decodeUtf8Result(r5, r10)
            goto L_0x01aa
        L_0x0185:
            int r4 = r17.position()
            int r4 = r4 - r14
            r0.position(r4)
            int r5 = r5 - r2
            long r2 = decodeUtf8Result(r5, r3)
            goto L_0x01aa
        L_0x0193:
            malformedCodePoint(r7)
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException
            r0.<init>()
            throw r0
        L_0x019c:
            unsupportedByteCount(r7)
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException
            r0.<init>()
            throw r0
        L_0x01a5:
            int r5 = r5 - r2
            long r2 = decodeUtf8Result(r5, r3)
        L_0x01aa:
            r4 = 4294967295(0xffffffff, double:2.1219957905E-314)
            long r4 = r4 & r2
            int r4 = (int) r4
            r5 = 32
            if (r4 != r10) goto L_0x01d4
            long r4 = r2 >> r5
            int r4 = (int) r4
            if (r6 == 0) goto L_0x01c0
            int r4 = r4 - r11
            long r0 = decodeUtf8Result(r4, r10)
            return r0
        L_0x01c0:
            int r5 = r17.position()
            int r5 = r5 + r11
            r0.position(r5)
            if (r4 <= 0) goto L_0x01e9
            int r4 = r4 - r11
            char r0 = r1[r4]
            if (r0 != r9) goto L_0x01e9
            long r0 = decodeUtf8Result(r4, r10)
            return r0
        L_0x01d4:
            if (r4 != 0) goto L_0x01e9
            if (r6 == 0) goto L_0x01e9
            long r1 = r2 >> r5
            int r1 = (int) r1
            int r2 = r17.position()
            int r2 = r2 - r11
            r0.position(r2)
            int r1 = r1 - r11
            long r0 = decodeUtf8Result(r1, r8)
            return r0
        L_0x01e9:
            return r2
        L_0x01ea:
            int r0 = r1.length
            java.lang.Throwable r0 = indexOutOfBounds(r2, r3, r0)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.charsets.UTFKt.decodeUTF8Line_buffer(java.nio.ByteBuffer, char[], int, int):long");
    }
}
