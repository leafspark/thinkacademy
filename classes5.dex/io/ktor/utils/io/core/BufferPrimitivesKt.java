package io.ktor.utils.io.core;

import io.ktor.http.ContentDisposition;
import io.ktor.utils.io.bits.Memory;
import io.ktor.utils.io.bits.MemoryJvmKt;
import io.ktor.utils.io.bits.PrimitiveArraysJvmKt;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import java.io.EOFException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.UIntArray;
import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000®\u0001\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0013\n\u0002\u0010\u0014\n\u0002\u0010\u0015\n\u0002\u0010\u0016\n\u0002\u0010\u0017\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\t\n\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b!\u001a$\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004H\bø\u0001\u0000\u001a\u001c\u0010\u0006\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0007\u001a&\u0010\u0006\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007\u001a&\u0010\u0006\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\n\u001a\u00020\r2\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007\u001a&\u0010\u0006\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\n\u001a\u00020\u000e2\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007\u001a&\u0010\u0006\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\n\u001a\u00020\u000f2\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007\u001a&\u0010\u0006\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\n\u001a\u00020\u00102\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007\u001a&\u0010\u0006\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\n\u001a\u00020\u00112\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007\u001a3\u0010\u0006\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\n\u001a\u00020\u00122\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0013\u0010\u0014\u001a3\u0010\u0006\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\n\u001a\u00020\u00152\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0016\u0010\u0017\u001a3\u0010\u0006\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\n\u001a\u00020\u00182\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0019\u0010\u001a\u001a3\u0010\u0006\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\n\u001a\u00020\u001b2\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u001c\u0010\u001d\u001a)\u0010\u0006\u001a\u00020\u0007*\u00020\u001e2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007H\b\u001a\n\u0010\u001f\u001a\u00020 *\u00020\u0002\u001a\r\u0010\u001f\u001a\u00020 *\u00020\u001eH\b\u001as\u0010!\u001a\u0002H\"\"\u0004\b\u0000\u0010\"*\u00020\u00022\u0006\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020%26\u0010\u0003\u001a2\u0012\u0013\u0012\u00110'¢\u0006\f\b(\u0012\b\b$\u0012\u0004\b\b()\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b(\u0012\b\b$\u0012\u0004\b\b(\f\u0012\u0004\u0012\u0002H\"0&H\bø\u0001\u0001ø\u0001\u0000\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0003 \u0001¢\u0006\u0002\u0010*\u001a\n\u0010+\u001a\u00020,*\u00020\u0002\u001a\r\u0010+\u001a\u00020,*\u00020\u001eH\b\u001a\u001c\u0010-\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0007\u001a&\u0010-\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007\u001a&\u0010-\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\n\u001a\u00020\r2\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007\u001a&\u0010-\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\n\u001a\u00020\u000e2\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007\u001a&\u0010-\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\n\u001a\u00020\u000f2\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007\u001a&\u0010-\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\n\u001a\u00020\u00102\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007\u001a&\u0010-\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\n\u001a\u00020\u00112\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007\u001a3\u0010-\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\n\u001a\u00020\u00122\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b.\u0010/\u001a3\u0010-\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\n\u001a\u00020\u00152\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b0\u00101\u001a3\u0010-\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\n\u001a\u00020\u00182\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b2\u00103\u001a3\u0010-\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\n\u001a\u00020\u001b2\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b4\u00105\u001a)\u0010-\u001a\u00020\u0001*\u00020\u001e2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007H\b\u001a\n\u00106\u001a\u00020\u0007*\u00020\u0002\u001a\r\u00106\u001a\u00020\u0007*\u00020\u001eH\b\u001a\n\u00107\u001a\u000208*\u00020\u0002\u001a\r\u00107\u001a\u000208*\u00020\u001eH\b\u001a\n\u00109\u001a\u00020:*\u00020\u0002\u001a\r\u00109\u001a\u00020:*\u00020\u001eH\b\u001a\u0012\u0010;\u001a\u00020<*\u00020\u0002ø\u0001\u0001¢\u0006\u0002\u0010=\u001a\u0015\u0010;\u001a\u00020<*\u00020\u001eH\bø\u0001\u0001¢\u0006\u0002\u0010>\u001a\u0012\u0010?\u001a\u00020@*\u00020\u0002ø\u0001\u0001¢\u0006\u0002\u0010A\u001a\u0015\u0010?\u001a\u00020@*\u00020\u001eH\bø\u0001\u0001¢\u0006\u0002\u0010B\u001a\u0012\u0010C\u001a\u00020D*\u00020\u0002ø\u0001\u0001¢\u0006\u0002\u0010E\u001a\u0015\u0010C\u001a\u00020D*\u00020\u001eH\bø\u0001\u0001¢\u0006\u0002\u0010F\u001a\u0012\u0010G\u001a\u00020H*\u00020\u0002ø\u0001\u0001¢\u0006\u0002\u0010I\u001a\u0015\u0010G\u001a\u00020H*\u00020\u001eH\bø\u0001\u0001¢\u0006\u0002\u0010J\u001a\u0012\u0010K\u001a\u00020\u0001*\u00020\u00022\u0006\u0010L\u001a\u00020 \u001a\u0015\u0010K\u001a\u00020\u0001*\u00020\u001e2\u0006\u0010L\u001a\u00020 H\b\u001ah\u0010M\u001a\u00020\u0001*\u00020\u00022\u0006\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020%26\u0010\u0003\u001a2\u0012\u0013\u0012\u00110'¢\u0006\f\b(\u0012\b\b$\u0012\u0004\b\b()\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b(\u0012\b\b$\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00010&H\bø\u0001\u0001ø\u0001\u0000\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0003 \u0001\u001a\u0012\u0010N\u001a\u00020\u0001*\u00020\u00022\u0006\u0010L\u001a\u00020,\u001a\u0015\u0010N\u001a\u00020\u0001*\u00020\u001e2\u0006\u0010L\u001a\u00020,H\b\u001a\u0012\u0010O\u001a\u00020\u0001*\u00020\u00022\u0006\u0010P\u001a\u00020\u0002\u001a\u001a\u0010O\u001a\u00020\u0001*\u00020\u00022\u0006\u0010P\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0007\u001a&\u0010O\u001a\u00020\u0001*\u00020\u00022\u0006\u0010Q\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007\u001a&\u0010O\u001a\u00020\u0001*\u00020\u00022\u0006\u0010Q\u001a\u00020\r2\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007\u001a&\u0010O\u001a\u00020\u0001*\u00020\u00022\u0006\u0010Q\u001a\u00020\u000e2\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007\u001a&\u0010O\u001a\u00020\u0001*\u00020\u00022\u0006\u0010Q\u001a\u00020\u000f2\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007\u001a&\u0010O\u001a\u00020\u0001*\u00020\u00022\u0006\u0010Q\u001a\u00020\u00102\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007\u001a&\u0010O\u001a\u00020\u0001*\u00020\u00022\u0006\u0010Q\u001a\u00020\u00112\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007\u001a3\u0010O\u001a\u00020\u0001*\u00020\u00022\u0006\u0010Q\u001a\u00020\u00122\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\bR\u0010/\u001a3\u0010O\u001a\u00020\u0001*\u00020\u00022\u0006\u0010Q\u001a\u00020\u00152\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\bS\u00101\u001a3\u0010O\u001a\u00020\u0001*\u00020\u00022\u0006\u0010Q\u001a\u00020\u00182\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\bT\u00103\u001a3\u0010O\u001a\u00020\u0001*\u00020\u00022\u0006\u0010Q\u001a\u00020\u001b2\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\bU\u00105\u001a)\u0010O\u001a\u00020\u0001*\u00020\u001e2\u0006\u0010Q\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007H\b\u001a\u0012\u0010V\u001a\u00020\u0001*\u00020\u00022\u0006\u0010L\u001a\u00020\u0007\u001a\u0015\u0010V\u001a\u00020\u0001*\u00020\u001e2\u0006\u0010L\u001a\u00020\u0007H\b\u001a\u0012\u0010W\u001a\u00020\u0001*\u00020\u00022\u0006\u0010L\u001a\u000208\u001a\u0015\u0010W\u001a\u00020\u0001*\u00020\u001e2\u0006\u0010L\u001a\u000208H\b\u001a\u0012\u0010X\u001a\u00020\u0001*\u00020\u00022\u0006\u0010L\u001a\u00020:\u001a\u0015\u0010X\u001a\u00020\u0001*\u00020\u001e2\u0006\u0010L\u001a\u00020:H\b\u001a\u001f\u0010Y\u001a\u00020\u0001*\u00020\u00022\u0006\u0010L\u001a\u00020<ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\bZ\u0010[\u001a\u001f\u0010Y\u001a\u00020\u0001*\u00020\u001e2\u0006\u0010L\u001a\u00020<ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\bZ\u0010\\\u001a\u001f\u0010]\u001a\u00020\u0001*\u00020\u00022\u0006\u0010L\u001a\u00020@ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b^\u0010_\u001a\"\u0010]\u001a\u00020\u0001*\u00020\u001e2\u0006\u0010L\u001a\u00020@H\bø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b^\u0010`\u001a\u001f\u0010a\u001a\u00020\u0001*\u00020\u00022\u0006\u0010L\u001a\u00020Dø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\bb\u0010c\u001a\"\u0010a\u001a\u00020\u0001*\u00020\u001e2\u0006\u0010L\u001a\u00020DH\bø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\bb\u0010d\u001a\u001f\u0010e\u001a\u00020\u0001*\u00020\u00022\u0006\u0010L\u001a\u00020Hø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\bf\u0010g\u001a\"\u0010e\u001a\u00020\u0001*\u00020\u001e2\u0006\u0010L\u001a\u00020HH\bø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\bf\u0010h\u0002\u0012\n\u0005\b20\u0001\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006i"}, d2 = {"forEach", "", "Lio/ktor/utils/io/core/Buffer;", "block", "Lkotlin/Function1;", "", "readAvailable", "", "dst", "length", "destination", "", "offset", "", "", "", "", "", "Lkotlin/UByteArray;", "readAvailable-o1GoV1E", "(Lio/ktor/utils/io/core/Buffer;[BII)I", "Lkotlin/UIntArray;", "readAvailable-o2ZM2JE", "(Lio/ktor/utils/io/core/Buffer;[III)I", "Lkotlin/ULongArray;", "readAvailable-pqYNikA", "(Lio/ktor/utils/io/core/Buffer;[JII)I", "Lkotlin/UShortArray;", "readAvailable-Wt3Bwxc", "(Lio/ktor/utils/io/core/Buffer;[SII)I", "Lio/ktor/utils/io/core/internal/ChunkBuffer;", "readDouble", "", "readExact", "R", "size", "name", "", "Lkotlin/Function2;", "Lio/ktor/utils/io/bits/Memory;", "Lkotlin/ParameterName;", "memory", "(Lio/ktor/utils/io/core/Buffer;ILjava/lang/String;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "readFloat", "", "readFully", "readFully-o1GoV1E", "(Lio/ktor/utils/io/core/Buffer;[BII)V", "readFully-o2ZM2JE", "(Lio/ktor/utils/io/core/Buffer;[III)V", "readFully-pqYNikA", "(Lio/ktor/utils/io/core/Buffer;[JII)V", "readFully-Wt3Bwxc", "(Lio/ktor/utils/io/core/Buffer;[SII)V", "readInt", "readLong", "", "readShort", "", "readUByte", "Lkotlin/UByte;", "(Lio/ktor/utils/io/core/Buffer;)B", "(Lio/ktor/utils/io/core/internal/ChunkBuffer;)B", "readUInt", "Lkotlin/UInt;", "(Lio/ktor/utils/io/core/Buffer;)I", "(Lio/ktor/utils/io/core/internal/ChunkBuffer;)I", "readULong", "Lkotlin/ULong;", "(Lio/ktor/utils/io/core/Buffer;)J", "(Lio/ktor/utils/io/core/internal/ChunkBuffer;)J", "readUShort", "Lkotlin/UShort;", "(Lio/ktor/utils/io/core/Buffer;)S", "(Lio/ktor/utils/io/core/internal/ChunkBuffer;)S", "writeDouble", "value", "writeExact", "writeFloat", "writeFully", "src", "source", "writeFully-o1GoV1E", "writeFully-o2ZM2JE", "writeFully-pqYNikA", "writeFully-Wt3Bwxc", "writeInt", "writeLong", "writeShort", "writeUByte", "writeUByte-EK-6454", "(Lio/ktor/utils/io/core/Buffer;B)V", "(Lio/ktor/utils/io/core/internal/ChunkBuffer;B)V", "writeUInt", "writeUInt-Qn1smSk", "(Lio/ktor/utils/io/core/Buffer;I)V", "(Lio/ktor/utils/io/core/internal/ChunkBuffer;I)V", "writeULong", "writeULong-2TYgG_w", "(Lio/ktor/utils/io/core/Buffer;J)V", "(Lio/ktor/utils/io/core/internal/ChunkBuffer;J)V", "writeUShort", "writeUShort-i8woANY", "(Lio/ktor/utils/io/core/Buffer;S)V", "(Lio/ktor/utils/io/core/internal/ChunkBuffer;S)V", "ktor-io"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: BufferPrimitives.kt */
public final class BufferPrimitivesKt {
    public static final byte readUByte(Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        return UByte.m338constructorimpl(buffer.readByte());
    }

    public static final byte readUByte(ChunkBuffer chunkBuffer) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "<this>");
        return readUByte((Buffer) chunkBuffer);
    }

    /* renamed from: writeUByte-EK-6454  reason: not valid java name */
    public static final void m210writeUByteEK6454(Buffer buffer, byte b) {
        Intrinsics.checkNotNullParameter(buffer, "$this$writeUByte");
        buffer.writeByte(b);
    }

    /* renamed from: writeUByte-EK-6454  reason: not valid java name */
    public static final void m211writeUByteEK6454(ChunkBuffer chunkBuffer, byte b) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "$this$writeUByte");
        m210writeUByteEK6454((Buffer) chunkBuffer, b);
    }

    public static final short readShort(ChunkBuffer chunkBuffer) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "<this>");
        return readShort((Buffer) chunkBuffer);
    }

    public static final short readUShort(ChunkBuffer chunkBuffer) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "<this>");
        return readUShort((Buffer) chunkBuffer);
    }

    public static final int readInt(ChunkBuffer chunkBuffer) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "<this>");
        return readInt((Buffer) chunkBuffer);
    }

    public static final int readUInt(ChunkBuffer chunkBuffer) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "<this>");
        return readUInt((Buffer) chunkBuffer);
    }

    public static final long readLong(ChunkBuffer chunkBuffer) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "<this>");
        return readLong((Buffer) chunkBuffer);
    }

    public static final long readULong(ChunkBuffer chunkBuffer) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "<this>");
        return readULong((Buffer) chunkBuffer);
    }

    public static final float readFloat(ChunkBuffer chunkBuffer) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "<this>");
        return readFloat((Buffer) chunkBuffer);
    }

    public static final double readDouble(ChunkBuffer chunkBuffer) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "<this>");
        return readDouble((Buffer) chunkBuffer);
    }

    public static final void writeShort(ChunkBuffer chunkBuffer, short s) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "<this>");
        writeShort((Buffer) chunkBuffer, s);
    }

    /* renamed from: writeUShort-i8woANY  reason: not valid java name */
    public static final void m217writeUShorti8woANY(ChunkBuffer chunkBuffer, short s) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "$this$writeUShort");
        m216writeUShorti8woANY((Buffer) chunkBuffer, s);
    }

    public static final void writeInt(ChunkBuffer chunkBuffer, int i) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "<this>");
        writeInt((Buffer) chunkBuffer, i);
    }

    /* renamed from: writeUInt-Qn1smSk  reason: not valid java name */
    public static final void m213writeUIntQn1smSk(ChunkBuffer chunkBuffer, int i) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "$this$writeUInt");
        m212writeUIntQn1smSk((Buffer) chunkBuffer, i);
    }

    public static final void writeLong(ChunkBuffer chunkBuffer, long j) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "<this>");
        writeLong((Buffer) chunkBuffer, j);
    }

    /* renamed from: writeULong-2TYgG_w  reason: not valid java name */
    public static final void m215writeULong2TYgG_w(ChunkBuffer chunkBuffer, long j) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "$this$writeULong");
        m214writeULong2TYgG_w((Buffer) chunkBuffer, j);
    }

    public static final void writeFloat(ChunkBuffer chunkBuffer, float f) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "<this>");
        writeFloat((Buffer) chunkBuffer, f);
    }

    public static final void writeDouble(ChunkBuffer chunkBuffer, double d) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "<this>");
        writeDouble((Buffer) chunkBuffer, d);
    }

    public static /* synthetic */ void readFully$default(Buffer buffer, byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = bArr.length - i;
        }
        readFully(buffer, bArr, i, i2);
    }

    public static /* synthetic */ void readFully$default(ChunkBuffer chunkBuffer, byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = bArr.length - i;
        }
        Intrinsics.checkNotNullParameter(chunkBuffer, "<this>");
        Intrinsics.checkNotNullParameter(bArr, "destination");
        readFully((Buffer) chunkBuffer, bArr, i, i2);
    }

    public static final void readFully(ChunkBuffer chunkBuffer, byte[] bArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "<this>");
        Intrinsics.checkNotNullParameter(bArr, "destination");
        readFully((Buffer) chunkBuffer, bArr, i, i2);
    }

    /* renamed from: readFully-o1GoV1E$default  reason: not valid java name */
    public static /* synthetic */ void m197readFullyo1GoV1E$default(Buffer buffer, byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UByteArray.m396getSizeimpl(bArr) - i;
        }
        m196readFullyo1GoV1E(buffer, bArr, i, i2);
    }

    /* renamed from: readFully-o1GoV1E  reason: not valid java name */
    public static final void m196readFullyo1GoV1E(Buffer buffer, byte[] bArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "$this$readFully");
        Intrinsics.checkNotNullParameter(bArr, "destination");
        readFully(buffer, bArr, i, i2);
    }

    public static /* synthetic */ int readAvailable$default(Buffer buffer, byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = bArr.length - i;
        }
        return readAvailable(buffer, bArr, i, i2);
    }

    public static final int readAvailable(Buffer buffer, byte[] bArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(bArr, "destination");
        boolean z = true;
        if (i >= 0) {
            if (i2 >= 0) {
                if (i + i2 <= bArr.length) {
                    if (buffer.getWritePosition() <= buffer.getReadPosition()) {
                        z = false;
                    }
                    if (!z) {
                        return -1;
                    }
                    int min = Math.min(i2, buffer.getWritePosition() - buffer.getReadPosition());
                    readFully(buffer, bArr, i, min);
                    return min;
                }
                throw new IllegalArgumentException(("offset + length should be less than the destination size: " + i + " + " + i2 + " > " + bArr.length).toString());
            }
            throw new IllegalArgumentException(("length shouldn't be negative: " + i2).toString());
        }
        throw new IllegalArgumentException(("offset shouldn't be negative: " + i).toString());
    }

    public static /* synthetic */ int readAvailable$default(ChunkBuffer chunkBuffer, byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = bArr.length - i;
        }
        Intrinsics.checkNotNullParameter(chunkBuffer, "<this>");
        Intrinsics.checkNotNullParameter(bArr, "destination");
        return readAvailable((Buffer) chunkBuffer, bArr, i, i2);
    }

    public static final int readAvailable(ChunkBuffer chunkBuffer, byte[] bArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "<this>");
        Intrinsics.checkNotNullParameter(bArr, "destination");
        return readAvailable((Buffer) chunkBuffer, bArr, i, i2);
    }

    /* renamed from: readAvailable-o1GoV1E$default  reason: not valid java name */
    public static /* synthetic */ int m189readAvailableo1GoV1E$default(Buffer buffer, byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UByteArray.m396getSizeimpl(bArr) - i;
        }
        return m188readAvailableo1GoV1E(buffer, bArr, i, i2);
    }

    /* renamed from: readAvailable-o1GoV1E  reason: not valid java name */
    public static final int m188readAvailableo1GoV1E(Buffer buffer, byte[] bArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "$this$readAvailable");
        Intrinsics.checkNotNullParameter(bArr, "destination");
        return readAvailable(buffer, bArr, i, i2);
    }

    public static /* synthetic */ void writeFully$default(Buffer buffer, byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = bArr.length - i;
        }
        writeFully(buffer, bArr, i, i2);
    }

    public static /* synthetic */ void writeFully$default(ChunkBuffer chunkBuffer, byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = bArr.length - i;
        }
        Intrinsics.checkNotNullParameter(chunkBuffer, "<this>");
        Intrinsics.checkNotNullParameter(bArr, "source");
        writeFully((Buffer) chunkBuffer, bArr, i, i2);
    }

    public static final void writeFully(ChunkBuffer chunkBuffer, byte[] bArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "<this>");
        Intrinsics.checkNotNullParameter(bArr, "source");
        writeFully((Buffer) chunkBuffer, bArr, i, i2);
    }

    /* renamed from: writeFully-o1GoV1E$default  reason: not valid java name */
    public static /* synthetic */ void m205writeFullyo1GoV1E$default(Buffer buffer, byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UByteArray.m396getSizeimpl(bArr) - i;
        }
        m204writeFullyo1GoV1E(buffer, bArr, i, i2);
    }

    /* renamed from: writeFully-o1GoV1E  reason: not valid java name */
    public static final void m204writeFullyo1GoV1E(Buffer buffer, byte[] bArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "$this$writeFully");
        Intrinsics.checkNotNullParameter(bArr, "source");
        writeFully(buffer, bArr, i, i2);
    }

    public static /* synthetic */ void readFully$default(Buffer buffer, short[] sArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = sArr.length - i;
        }
        readFully(buffer, sArr, i, i2);
    }

    /* renamed from: readFully-Wt3Bwxc$default  reason: not valid java name */
    public static /* synthetic */ void m195readFullyWt3Bwxc$default(Buffer buffer, short[] sArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UShortArray.m656getSizeimpl(sArr) - i;
        }
        m194readFullyWt3Bwxc(buffer, sArr, i, i2);
    }

    /* renamed from: readFully-Wt3Bwxc  reason: not valid java name */
    public static final void m194readFullyWt3Bwxc(Buffer buffer, short[] sArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "$this$readFully");
        Intrinsics.checkNotNullParameter(sArr, "destination");
        readFully(buffer, sArr, i, i2);
    }

    public static /* synthetic */ int readAvailable$default(Buffer buffer, short[] sArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = sArr.length - i;
        }
        return readAvailable(buffer, sArr, i, i2);
    }

    public static final int readAvailable(Buffer buffer, short[] sArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(sArr, "destination");
        boolean z = true;
        if (i >= 0) {
            if (i2 >= 0) {
                if (i + i2 <= sArr.length) {
                    if (buffer.getWritePosition() <= buffer.getReadPosition()) {
                        z = false;
                    }
                    if (!z) {
                        return -1;
                    }
                    int min = Math.min(i2 / 2, buffer.getWritePosition() - buffer.getReadPosition());
                    readFully(buffer, sArr, i, min);
                    return min;
                }
                throw new IllegalArgumentException(("offset + length should be less than the destination size: " + i + " + " + i2 + " > " + sArr.length).toString());
            }
            throw new IllegalArgumentException(("length shouldn't be negative: " + i2).toString());
        }
        throw new IllegalArgumentException(("offset shouldn't be negative: " + i).toString());
    }

    /* renamed from: readAvailable-Wt3Bwxc$default  reason: not valid java name */
    public static /* synthetic */ int m187readAvailableWt3Bwxc$default(Buffer buffer, short[] sArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UShortArray.m656getSizeimpl(sArr) - i;
        }
        return m186readAvailableWt3Bwxc(buffer, sArr, i, i2);
    }

    /* renamed from: readAvailable-Wt3Bwxc  reason: not valid java name */
    public static final int m186readAvailableWt3Bwxc(Buffer buffer, short[] sArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "$this$readAvailable");
        Intrinsics.checkNotNullParameter(sArr, "destination");
        return readAvailable(buffer, sArr, i, i2);
    }

    public static /* synthetic */ void writeFully$default(Buffer buffer, short[] sArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = sArr.length - i;
        }
        writeFully(buffer, sArr, i, i2);
    }

    /* renamed from: writeFully-Wt3Bwxc$default  reason: not valid java name */
    public static /* synthetic */ void m203writeFullyWt3Bwxc$default(Buffer buffer, short[] sArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UShortArray.m656getSizeimpl(sArr) - i;
        }
        m202writeFullyWt3Bwxc(buffer, sArr, i, i2);
    }

    /* renamed from: writeFully-Wt3Bwxc  reason: not valid java name */
    public static final void m202writeFullyWt3Bwxc(Buffer buffer, short[] sArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "$this$writeFully");
        Intrinsics.checkNotNullParameter(sArr, "source");
        writeFully(buffer, sArr, i, i2);
    }

    public static /* synthetic */ void readFully$default(Buffer buffer, int[] iArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = iArr.length - i;
        }
        readFully(buffer, iArr, i, i2);
    }

    /* renamed from: readFully-o2ZM2JE$default  reason: not valid java name */
    public static /* synthetic */ void m199readFullyo2ZM2JE$default(Buffer buffer, int[] iArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UIntArray.m474getSizeimpl(iArr) - i;
        }
        m198readFullyo2ZM2JE(buffer, iArr, i, i2);
    }

    /* renamed from: readFully-o2ZM2JE  reason: not valid java name */
    public static final void m198readFullyo2ZM2JE(Buffer buffer, int[] iArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "$this$readFully");
        Intrinsics.checkNotNullParameter(iArr, "destination");
        readFully(buffer, iArr, i, i2);
    }

    public static /* synthetic */ int readAvailable$default(Buffer buffer, int[] iArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = iArr.length - i;
        }
        return readAvailable(buffer, iArr, i, i2);
    }

    public static final int readAvailable(Buffer buffer, int[] iArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(iArr, "destination");
        boolean z = true;
        if (i >= 0) {
            if (i2 >= 0) {
                if (i + i2 <= iArr.length) {
                    if (buffer.getWritePosition() <= buffer.getReadPosition()) {
                        z = false;
                    }
                    if (!z) {
                        return -1;
                    }
                    int min = Math.min(i2 / 4, buffer.getWritePosition() - buffer.getReadPosition());
                    readFully(buffer, iArr, i, min);
                    return min;
                }
                throw new IllegalArgumentException(("offset + length should be less than the destination size: " + i + " + " + i2 + " > " + iArr.length).toString());
            }
            throw new IllegalArgumentException(("length shouldn't be negative: " + i2).toString());
        }
        throw new IllegalArgumentException(("offset shouldn't be negative: " + i).toString());
    }

    /* renamed from: readAvailable-o2ZM2JE$default  reason: not valid java name */
    public static /* synthetic */ int m191readAvailableo2ZM2JE$default(Buffer buffer, int[] iArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UIntArray.m474getSizeimpl(iArr) - i;
        }
        return m190readAvailableo2ZM2JE(buffer, iArr, i, i2);
    }

    /* renamed from: readAvailable-o2ZM2JE  reason: not valid java name */
    public static final int m190readAvailableo2ZM2JE(Buffer buffer, int[] iArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "$this$readAvailable");
        Intrinsics.checkNotNullParameter(iArr, "destination");
        return readAvailable(buffer, iArr, i, i2);
    }

    public static /* synthetic */ void writeFully$default(Buffer buffer, int[] iArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = iArr.length - i;
        }
        writeFully(buffer, iArr, i, i2);
    }

    /* renamed from: writeFully-o2ZM2JE$default  reason: not valid java name */
    public static /* synthetic */ void m207writeFullyo2ZM2JE$default(Buffer buffer, int[] iArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UIntArray.m474getSizeimpl(iArr) - i;
        }
        m206writeFullyo2ZM2JE(buffer, iArr, i, i2);
    }

    /* renamed from: writeFully-o2ZM2JE  reason: not valid java name */
    public static final void m206writeFullyo2ZM2JE(Buffer buffer, int[] iArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "$this$writeFully");
        Intrinsics.checkNotNullParameter(iArr, "source");
        writeFully(buffer, iArr, i, i2);
    }

    public static /* synthetic */ void readFully$default(Buffer buffer, long[] jArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = jArr.length - i;
        }
        readFully(buffer, jArr, i, i2);
    }

    /* renamed from: readFully-pqYNikA$default  reason: not valid java name */
    public static /* synthetic */ void m201readFullypqYNikA$default(Buffer buffer, long[] jArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = ULongArray.m552getSizeimpl(jArr) - i;
        }
        m200readFullypqYNikA(buffer, jArr, i, i2);
    }

    /* renamed from: readFully-pqYNikA  reason: not valid java name */
    public static final void m200readFullypqYNikA(Buffer buffer, long[] jArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "$this$readFully");
        Intrinsics.checkNotNullParameter(jArr, "destination");
        readFully(buffer, jArr, i, i2);
    }

    public static /* synthetic */ int readAvailable$default(Buffer buffer, long[] jArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = jArr.length - i;
        }
        return readAvailable(buffer, jArr, i, i2);
    }

    public static final int readAvailable(Buffer buffer, long[] jArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(jArr, "destination");
        boolean z = true;
        if (i >= 0) {
            if (i2 >= 0) {
                if (i + i2 <= jArr.length) {
                    if (buffer.getWritePosition() <= buffer.getReadPosition()) {
                        z = false;
                    }
                    if (!z) {
                        return -1;
                    }
                    int min = Math.min(i2 / 8, buffer.getWritePosition() - buffer.getReadPosition());
                    readFully(buffer, jArr, i, min);
                    return min;
                }
                throw new IllegalArgumentException(("offset + length should be less than the destination size: " + i + " + " + i2 + " > " + jArr.length).toString());
            }
            throw new IllegalArgumentException(("length shouldn't be negative: " + i2).toString());
        }
        throw new IllegalArgumentException(("offset shouldn't be negative: " + i).toString());
    }

    /* renamed from: readAvailable-pqYNikA$default  reason: not valid java name */
    public static /* synthetic */ int m193readAvailablepqYNikA$default(Buffer buffer, long[] jArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = ULongArray.m552getSizeimpl(jArr) - i;
        }
        return m192readAvailablepqYNikA(buffer, jArr, i, i2);
    }

    /* renamed from: readAvailable-pqYNikA  reason: not valid java name */
    public static final int m192readAvailablepqYNikA(Buffer buffer, long[] jArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "$this$readAvailable");
        Intrinsics.checkNotNullParameter(jArr, "destination");
        return readAvailable(buffer, jArr, i, i2);
    }

    public static /* synthetic */ void writeFully$default(Buffer buffer, long[] jArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = jArr.length - i;
        }
        writeFully(buffer, jArr, i, i2);
    }

    /* renamed from: writeFully-pqYNikA$default  reason: not valid java name */
    public static /* synthetic */ void m209writeFullypqYNikA$default(Buffer buffer, long[] jArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = ULongArray.m552getSizeimpl(jArr) - i;
        }
        m208writeFullypqYNikA(buffer, jArr, i, i2);
    }

    /* renamed from: writeFully-pqYNikA  reason: not valid java name */
    public static final void m208writeFullypqYNikA(Buffer buffer, long[] jArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "$this$writeFully");
        Intrinsics.checkNotNullParameter(jArr, "source");
        writeFully(buffer, jArr, i, i2);
    }

    public static /* synthetic */ void readFully$default(Buffer buffer, float[] fArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = fArr.length - i;
        }
        readFully(buffer, fArr, i, i2);
    }

    public static /* synthetic */ int readAvailable$default(Buffer buffer, float[] fArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = fArr.length - i;
        }
        return readAvailable(buffer, fArr, i, i2);
    }

    public static final int readAvailable(Buffer buffer, float[] fArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(fArr, "destination");
        boolean z = true;
        if (i >= 0) {
            if (i2 >= 0) {
                if (i + i2 <= fArr.length) {
                    if (buffer.getWritePosition() <= buffer.getReadPosition()) {
                        z = false;
                    }
                    if (!z) {
                        return -1;
                    }
                    int min = Math.min(i2 / 4, buffer.getWritePosition() - buffer.getReadPosition());
                    readFully(buffer, fArr, i, min);
                    return min;
                }
                throw new IllegalArgumentException(("offset + length should be less than the destination size: " + i + " + " + i2 + " > " + fArr.length).toString());
            }
            throw new IllegalArgumentException(("length shouldn't be negative: " + i2).toString());
        }
        throw new IllegalArgumentException(("offset shouldn't be negative: " + i).toString());
    }

    public static /* synthetic */ void writeFully$default(Buffer buffer, float[] fArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = fArr.length - i;
        }
        writeFully(buffer, fArr, i, i2);
    }

    public static /* synthetic */ void readFully$default(Buffer buffer, double[] dArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = dArr.length - i;
        }
        readFully(buffer, dArr, i, i2);
    }

    public static /* synthetic */ int readAvailable$default(Buffer buffer, double[] dArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = dArr.length - i;
        }
        return readAvailable(buffer, dArr, i, i2);
    }

    public static final int readAvailable(Buffer buffer, double[] dArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(dArr, "destination");
        boolean z = true;
        if (i >= 0) {
            if (i2 >= 0) {
                if (i + i2 <= dArr.length) {
                    if (buffer.getWritePosition() <= buffer.getReadPosition()) {
                        z = false;
                    }
                    if (!z) {
                        return -1;
                    }
                    int min = Math.min(i2 / 8, buffer.getWritePosition() - buffer.getReadPosition());
                    readFully(buffer, dArr, i, min);
                    return min;
                }
                throw new IllegalArgumentException(("offset + length should be less than the destination size: " + i + " + " + i2 + " > " + dArr.length).toString());
            }
            throw new IllegalArgumentException(("length shouldn't be negative: " + i2).toString());
        }
        throw new IllegalArgumentException(("offset shouldn't be negative: " + i).toString());
    }

    public static /* synthetic */ void writeFully$default(Buffer buffer, double[] dArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = dArr.length - i;
        }
        writeFully(buffer, dArr, i, i2);
    }

    public static final void forEach(Buffer buffer, Function1<? super Byte, Unit> function1) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        ByteBuffer r0 = buffer.m184getMemorySK3TCg8();
        int readPosition = buffer.getReadPosition();
        int writePosition = buffer.getWritePosition();
        for (int i = readPosition; i < writePosition; i++) {
            function1.invoke(Byte.valueOf(r0.get(i)));
        }
        buffer.discardExact(writePosition - readPosition);
    }

    public static final short readShort(Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        ByteBuffer r0 = buffer.m184getMemorySK3TCg8();
        int readPosition = buffer.getReadPosition();
        if (buffer.getWritePosition() - readPosition >= 2) {
            Short valueOf = Short.valueOf(r0.getShort(readPosition));
            buffer.discardExact(2);
            return valueOf.shortValue();
        }
        throw new EOFException("Not enough bytes to read a " + "short integer" + " of size " + 2 + '.');
    }

    public static final short readUShort(Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        ByteBuffer r0 = buffer.m184getMemorySK3TCg8();
        int readPosition = buffer.getReadPosition();
        if (buffer.getWritePosition() - readPosition >= 2) {
            UShort r02 = UShort.m592boximpl(UShort.m598constructorimpl(r0.getShort(readPosition)));
            buffer.discardExact(2);
            return r02.m647unboximpl();
        }
        throw new EOFException("Not enough bytes to read a " + "short unsigned integer" + " of size " + 2 + '.');
    }

    public static final int readInt(Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        ByteBuffer r0 = buffer.m184getMemorySK3TCg8();
        int readPosition = buffer.getReadPosition();
        if (buffer.getWritePosition() - readPosition >= 4) {
            Integer valueOf = Integer.valueOf(r0.getInt(readPosition));
            buffer.discardExact(4);
            return valueOf.intValue();
        }
        throw new EOFException("Not enough bytes to read a " + "regular integer" + " of size " + 4 + '.');
    }

    public static final int readUInt(Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        ByteBuffer r0 = buffer.m184getMemorySK3TCg8();
        int readPosition = buffer.getReadPosition();
        if (buffer.getWritePosition() - readPosition >= 4) {
            UInt r02 = UInt.m408boximpl(UInt.m414constructorimpl(r0.getInt(readPosition)));
            buffer.discardExact(4);
            return r02.m465unboximpl();
        }
        throw new EOFException("Not enough bytes to read a " + "regular unsigned integer" + " of size " + 4 + '.');
    }

    public static final long readLong(Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        ByteBuffer r0 = buffer.m184getMemorySK3TCg8();
        int readPosition = buffer.getReadPosition();
        if (buffer.getWritePosition() - readPosition >= 8) {
            Long valueOf = Long.valueOf(r0.getLong(readPosition));
            buffer.discardExact(8);
            return valueOf.longValue();
        }
        throw new EOFException("Not enough bytes to read a " + "long integer" + " of size " + 8 + '.');
    }

    public static final long readULong(Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        ByteBuffer r0 = buffer.m184getMemorySK3TCg8();
        int readPosition = buffer.getReadPosition();
        if (buffer.getWritePosition() - readPosition >= 8) {
            ULong r02 = ULong.m486boximpl(ULong.m492constructorimpl(r0.getLong(readPosition)));
            buffer.discardExact(8);
            return r02.m543unboximpl();
        }
        throw new EOFException("Not enough bytes to read a " + "long unsigned integer" + " of size " + 8 + '.');
    }

    public static final float readFloat(Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        ByteBuffer r0 = buffer.m184getMemorySK3TCg8();
        int readPosition = buffer.getReadPosition();
        if (buffer.getWritePosition() - readPosition >= 4) {
            Float valueOf = Float.valueOf(r0.getFloat(readPosition));
            buffer.discardExact(4);
            return valueOf.floatValue();
        }
        throw new EOFException("Not enough bytes to read a " + "floating point number" + " of size " + 4 + '.');
    }

    public static final double readDouble(Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        ByteBuffer r0 = buffer.m184getMemorySK3TCg8();
        int readPosition = buffer.getReadPosition();
        if (buffer.getWritePosition() - readPosition >= 8) {
            Double valueOf = Double.valueOf(r0.getDouble(readPosition));
            buffer.discardExact(8);
            return valueOf.doubleValue();
        }
        throw new EOFException("Not enough bytes to read a " + "long floating point number" + " of size " + 8 + '.');
    }

    public static final void writeShort(Buffer buffer, short s) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        ByteBuffer r0 = buffer.m184getMemorySK3TCg8();
        int writePosition = buffer.getWritePosition();
        int limit = buffer.getLimit() - writePosition;
        if (limit >= 2) {
            r0.putShort(writePosition, s);
            buffer.commitWritten(2);
            return;
        }
        throw new InsufficientSpaceException("short integer", 2, limit);
    }

    /* renamed from: writeUShort-i8woANY  reason: not valid java name */
    public static final void m216writeUShorti8woANY(Buffer buffer, short s) {
        Intrinsics.checkNotNullParameter(buffer, "$this$writeUShort");
        ByteBuffer r0 = buffer.m184getMemorySK3TCg8();
        int writePosition = buffer.getWritePosition();
        int limit = buffer.getLimit() - writePosition;
        if (limit >= 2) {
            r0.putShort(writePosition, s);
            buffer.commitWritten(2);
            return;
        }
        throw new InsufficientSpaceException("short unsigned integer", 2, limit);
    }

    public static final void writeInt(Buffer buffer, int i) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        ByteBuffer r0 = buffer.m184getMemorySK3TCg8();
        int writePosition = buffer.getWritePosition();
        int limit = buffer.getLimit() - writePosition;
        if (limit >= 4) {
            r0.putInt(writePosition, i);
            buffer.commitWritten(4);
            return;
        }
        throw new InsufficientSpaceException("regular integer", 4, limit);
    }

    /* renamed from: writeUInt-Qn1smSk  reason: not valid java name */
    public static final void m212writeUIntQn1smSk(Buffer buffer, int i) {
        Intrinsics.checkNotNullParameter(buffer, "$this$writeUInt");
        ByteBuffer r0 = buffer.m184getMemorySK3TCg8();
        int writePosition = buffer.getWritePosition();
        int limit = buffer.getLimit() - writePosition;
        if (limit >= 4) {
            r0.putInt(writePosition, i);
            buffer.commitWritten(4);
            return;
        }
        throw new InsufficientSpaceException("regular unsigned integer", 4, limit);
    }

    public static final void writeLong(Buffer buffer, long j) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        ByteBuffer r0 = buffer.m184getMemorySK3TCg8();
        int writePosition = buffer.getWritePosition();
        int limit = buffer.getLimit() - writePosition;
        if (limit >= 8) {
            r0.putLong(writePosition, j);
            buffer.commitWritten(8);
            return;
        }
        throw new InsufficientSpaceException("long integer", 8, limit);
    }

    /* renamed from: writeULong-2TYgG_w  reason: not valid java name */
    public static final void m214writeULong2TYgG_w(Buffer buffer, long j) {
        Intrinsics.checkNotNullParameter(buffer, "$this$writeULong");
        ByteBuffer r0 = buffer.m184getMemorySK3TCg8();
        int writePosition = buffer.getWritePosition();
        int limit = buffer.getLimit() - writePosition;
        if (limit >= 8) {
            r0.putLong(writePosition, j);
            buffer.commitWritten(8);
            return;
        }
        throw new InsufficientSpaceException("long unsigned integer", 8, limit);
    }

    public static final void writeFloat(Buffer buffer, float f) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        ByteBuffer r0 = buffer.m184getMemorySK3TCg8();
        int writePosition = buffer.getWritePosition();
        int limit = buffer.getLimit() - writePosition;
        if (limit >= 4) {
            r0.putFloat(writePosition, f);
            buffer.commitWritten(4);
            return;
        }
        throw new InsufficientSpaceException("floating point number", 4, limit);
    }

    public static final void writeDouble(Buffer buffer, double d) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        ByteBuffer r0 = buffer.m184getMemorySK3TCg8();
        int writePosition = buffer.getWritePosition();
        int limit = buffer.getLimit() - writePosition;
        if (limit >= 8) {
            r0.putDouble(writePosition, d);
            buffer.commitWritten(8);
            return;
        }
        throw new InsufficientSpaceException("long floating point number", 8, limit);
    }

    public static final void readFully(Buffer buffer, byte[] bArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(bArr, "destination");
        ByteBuffer r0 = buffer.m184getMemorySK3TCg8();
        int readPosition = buffer.getReadPosition();
        if (buffer.getWritePosition() - readPosition >= i2) {
            MemoryJvmKt.m59copyTo9zorpBc(r0, bArr, readPosition, i2, i);
            Unit unit = Unit.INSTANCE;
            buffer.discardExact(i2);
            return;
        }
        throw new EOFException("Not enough bytes to read a " + "byte array" + " of size " + i2 + '.');
    }

    public static final void writeFully(Buffer buffer, byte[] bArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(bArr, "source");
        ByteBuffer r0 = buffer.m184getMemorySK3TCg8();
        int writePosition = buffer.getWritePosition();
        int limit = buffer.getLimit() - writePosition;
        if (limit >= i2) {
            ByteBuffer order = ByteBuffer.wrap(bArr, i, i2).slice().order(ByteOrder.BIG_ENDIAN);
            Intrinsics.checkNotNullExpressionValue(order, "wrap(this, offset, lengt…der(ByteOrder.BIG_ENDIAN)");
            Memory.m41copyToJT6ljtQ(Memory.m40constructorimpl(order), r0, 0, i2, writePosition);
            buffer.commitWritten(i2);
            return;
        }
        throw new InsufficientSpaceException("byte array", i2, limit);
    }

    public static final void readFully(Buffer buffer, short[] sArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(sArr, "destination");
        int i3 = i2 * 2;
        ByteBuffer r1 = buffer.m184getMemorySK3TCg8();
        int readPosition = buffer.getReadPosition();
        if (buffer.getWritePosition() - readPosition >= i3) {
            PrimitiveArraysJvmKt.m160loadShortArray9zorpBc(r1, readPosition, sArr, i, i2);
            Unit unit = Unit.INSTANCE;
            buffer.discardExact(i3);
            return;
        }
        throw new EOFException("Not enough bytes to read a " + "short integers array" + " of size " + i3 + '.');
    }

    public static final void writeFully(Buffer buffer, short[] sArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(sArr, "source");
        int i3 = i2 * 2;
        ByteBuffer r1 = buffer.m184getMemorySK3TCg8();
        int writePosition = buffer.getWritePosition();
        int limit = buffer.getLimit() - writePosition;
        if (limit >= i3) {
            PrimitiveArraysJvmKt.m180storeShortArray9zorpBc(r1, writePosition, sArr, i, i2);
            buffer.commitWritten(i3);
            return;
        }
        throw new InsufficientSpaceException("short integers array", i3, limit);
    }

    public static final void readFully(Buffer buffer, int[] iArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(iArr, "destination");
        int i3 = i2 * 4;
        ByteBuffer r1 = buffer.m184getMemorySK3TCg8();
        int readPosition = buffer.getReadPosition();
        if (buffer.getWritePosition() - readPosition >= i3) {
            PrimitiveArraysJvmKt.m152loadIntArray9zorpBc(r1, readPosition, iArr, i, i2);
            Unit unit = Unit.INSTANCE;
            buffer.discardExact(i3);
            return;
        }
        throw new EOFException("Not enough bytes to read a " + "integers array" + " of size " + i3 + '.');
    }

    public static final void writeFully(Buffer buffer, int[] iArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(iArr, "source");
        int i3 = i2 * 4;
        ByteBuffer r1 = buffer.m184getMemorySK3TCg8();
        int writePosition = buffer.getWritePosition();
        int limit = buffer.getLimit() - writePosition;
        if (limit >= i3) {
            PrimitiveArraysJvmKt.m172storeIntArray9zorpBc(r1, writePosition, iArr, i, i2);
            buffer.commitWritten(i3);
            return;
        }
        throw new InsufficientSpaceException("integers array", i3, limit);
    }

    public static final void readFully(Buffer buffer, long[] jArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(jArr, "destination");
        int i3 = i2 * 8;
        ByteBuffer r1 = buffer.m184getMemorySK3TCg8();
        int readPosition = buffer.getReadPosition();
        if (buffer.getWritePosition() - readPosition >= i3) {
            PrimitiveArraysJvmKt.m156loadLongArray9zorpBc(r1, readPosition, jArr, i, i2);
            Unit unit = Unit.INSTANCE;
            buffer.discardExact(i3);
            return;
        }
        throw new EOFException("Not enough bytes to read a " + "long integers array" + " of size " + i3 + '.');
    }

    public static final void writeFully(Buffer buffer, long[] jArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(jArr, "source");
        int i3 = i2 * 8;
        ByteBuffer r1 = buffer.m184getMemorySK3TCg8();
        int writePosition = buffer.getWritePosition();
        int limit = buffer.getLimit() - writePosition;
        if (limit >= i3) {
            PrimitiveArraysJvmKt.m176storeLongArray9zorpBc(r1, writePosition, jArr, i, i2);
            buffer.commitWritten(i3);
            return;
        }
        throw new InsufficientSpaceException("long integers array", i3, limit);
    }

    public static final void readFully(Buffer buffer, float[] fArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(fArr, "destination");
        int i3 = i2 * 4;
        ByteBuffer r1 = buffer.m184getMemorySK3TCg8();
        int readPosition = buffer.getReadPosition();
        if (buffer.getWritePosition() - readPosition >= i3) {
            PrimitiveArraysJvmKt.m148loadFloatArray9zorpBc(r1, readPosition, fArr, i, i2);
            Unit unit = Unit.INSTANCE;
            buffer.discardExact(i3);
            return;
        }
        throw new EOFException("Not enough bytes to read a " + "floating point numbers array" + " of size " + i3 + '.');
    }

    public static final void writeFully(Buffer buffer, float[] fArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(fArr, "source");
        int i3 = i2 * 4;
        ByteBuffer r1 = buffer.m184getMemorySK3TCg8();
        int writePosition = buffer.getWritePosition();
        int limit = buffer.getLimit() - writePosition;
        if (limit >= i3) {
            PrimitiveArraysJvmKt.m168storeFloatArray9zorpBc(r1, writePosition, fArr, i, i2);
            buffer.commitWritten(i3);
            return;
        }
        throw new InsufficientSpaceException("floating point numbers array", i3, limit);
    }

    public static final void readFully(Buffer buffer, double[] dArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(dArr, "destination");
        int i3 = i2 * 8;
        ByteBuffer r1 = buffer.m184getMemorySK3TCg8();
        int readPosition = buffer.getReadPosition();
        if (buffer.getWritePosition() - readPosition >= i3) {
            PrimitiveArraysJvmKt.m144loadDoubleArray9zorpBc(r1, readPosition, dArr, i, i2);
            Unit unit = Unit.INSTANCE;
            buffer.discardExact(i3);
            return;
        }
        throw new EOFException("Not enough bytes to read a " + "floating point numbers array" + " of size " + i3 + '.');
    }

    public static final void writeFully(Buffer buffer, double[] dArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(dArr, "source");
        int i3 = i2 * 8;
        ByteBuffer r1 = buffer.m184getMemorySK3TCg8();
        int writePosition = buffer.getWritePosition();
        int limit = buffer.getLimit() - writePosition;
        if (limit >= i3) {
            PrimitiveArraysJvmKt.m164storeDoubleArray9zorpBc(r1, writePosition, dArr, i, i2);
            buffer.commitWritten(i3);
            return;
        }
        throw new InsufficientSpaceException("floating point numbers array", i3, limit);
    }

    public static final int readFully(Buffer buffer, Buffer buffer2, int i) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(buffer2, "dst");
        boolean z = true;
        if (i >= 0) {
            if (i > buffer2.getLimit() - buffer2.getWritePosition()) {
                z = false;
            }
            if (z) {
                ByteBuffer r0 = buffer.m184getMemorySK3TCg8();
                int readPosition = buffer.getReadPosition();
                if (buffer.getWritePosition() - readPosition >= i) {
                    Memory.m41copyToJT6ljtQ(r0, buffer2.m184getMemorySK3TCg8(), readPosition, i, buffer2.getWritePosition());
                    buffer2.commitWritten(i);
                    Unit unit = Unit.INSTANCE;
                    buffer.discardExact(i);
                    return i;
                }
                throw new EOFException("Not enough bytes to read a " + "buffer content" + " of size " + i + '.');
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public static /* synthetic */ int readFully$default(Buffer buffer, Buffer buffer2, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = buffer2.getLimit() - buffer2.getWritePosition();
        }
        return readFully(buffer, buffer2, i);
    }

    public static final int readAvailable(Buffer buffer, Buffer buffer2, int i) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(buffer2, "dst");
        if (!(buffer.getWritePosition() > buffer.getReadPosition())) {
            return -1;
        }
        int min = Math.min(buffer2.getLimit() - buffer2.getWritePosition(), Math.min(buffer.getWritePosition() - buffer.getReadPosition(), i));
        ByteBuffer r0 = buffer.m184getMemorySK3TCg8();
        int readPosition = buffer.getReadPosition();
        if (buffer.getWritePosition() - readPosition >= min) {
            Memory.m41copyToJT6ljtQ(r0, buffer2.m184getMemorySK3TCg8(), readPosition, min, buffer2.getWritePosition());
            buffer2.commitWritten(min);
            Unit unit = Unit.INSTANCE;
            buffer.discardExact(min);
            return min;
        }
        throw new EOFException("Not enough bytes to read a " + "buffer content" + " of size " + min + '.');
    }

    public static /* synthetic */ int readAvailable$default(Buffer buffer, Buffer buffer2, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = buffer2.getLimit() - buffer2.getWritePosition();
        }
        return readAvailable(buffer, buffer2, i);
    }

    public static final void writeFully(Buffer buffer, Buffer buffer2) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(buffer2, "src");
        int writePosition = buffer2.getWritePosition() - buffer2.getReadPosition();
        ByteBuffer r1 = buffer.m184getMemorySK3TCg8();
        int writePosition2 = buffer.getWritePosition();
        int limit = buffer.getLimit() - writePosition2;
        if (limit >= writePosition) {
            Memory.m41copyToJT6ljtQ(buffer2.m184getMemorySK3TCg8(), r1, buffer2.getReadPosition(), writePosition, writePosition2);
            buffer2.discardExact(writePosition);
            buffer.commitWritten(writePosition);
            return;
        }
        throw new InsufficientSpaceException("buffer readable content", writePosition, limit);
    }

    public static final void writeFully(Buffer buffer, Buffer buffer2, int i) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(buffer2, "src");
        boolean z = true;
        if (i >= 0) {
            if (i <= buffer2.getWritePosition() - buffer2.getReadPosition()) {
                if (i > buffer.getLimit() - buffer.getWritePosition()) {
                    z = false;
                }
                if (z) {
                    ByteBuffer r0 = buffer.m184getMemorySK3TCg8();
                    int writePosition = buffer.getWritePosition();
                    int limit = buffer.getLimit() - writePosition;
                    if (limit >= i) {
                        Memory.m41copyToJT6ljtQ(buffer2.m184getMemorySK3TCg8(), r0, buffer2.getReadPosition(), i, writePosition);
                        buffer2.discardExact(i);
                        buffer.commitWritten(i);
                        return;
                    }
                    throw new InsufficientSpaceException("buffer readable content", i, limit);
                }
                throw new IllegalArgumentException(("length shouldn't be greater than the destination write remaining space: " + i + " > " + (buffer.getLimit() - buffer.getWritePosition())).toString());
            }
            throw new IllegalArgumentException(("length shouldn't be greater than the source read remaining: " + i + " > " + (buffer2.getWritePosition() - buffer2.getReadPosition())).toString());
        }
        throw new IllegalArgumentException(("length shouldn't be negative: " + i).toString());
    }

    public static final <R> R readExact(Buffer buffer, int i, String str, Function2<? super Memory, ? super Integer, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(str, ContentDisposition.Parameters.Name);
        Intrinsics.checkNotNullParameter(function2, "block");
        ByteBuffer r0 = buffer.m184getMemorySK3TCg8();
        int readPosition = buffer.getReadPosition();
        if (buffer.getWritePosition() - readPosition >= i) {
            R invoke = function2.invoke(Memory.m39boximpl(r0), Integer.valueOf(readPosition));
            buffer.discardExact(i);
            return invoke;
        }
        throw new EOFException("Not enough bytes to read a " + str + " of size " + i + '.');
    }

    public static final void writeExact(Buffer buffer, int i, String str, Function2<? super Memory, ? super Integer, Unit> function2) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        Intrinsics.checkNotNullParameter(str, ContentDisposition.Parameters.Name);
        Intrinsics.checkNotNullParameter(function2, "block");
        ByteBuffer r0 = buffer.m184getMemorySK3TCg8();
        int writePosition = buffer.getWritePosition();
        int limit = buffer.getLimit() - writePosition;
        if (limit >= i) {
            function2.invoke(Memory.m39boximpl(r0), Integer.valueOf(writePosition));
            buffer.commitWritten(i);
            return;
        }
        throw new InsufficientSpaceException(str, i, limit);
    }
}
