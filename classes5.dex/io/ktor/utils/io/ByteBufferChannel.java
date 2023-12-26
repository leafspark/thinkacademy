package io.ktor.utils.io;

import io.flutter.embedding.android.KeyboardMap;
import io.ktor.utils.io.bits.Memory;
import io.ktor.utils.io.core.Buffer;
import io.ktor.utils.io.core.BufferUtilsJvmKt;
import io.ktor.utils.io.core.ByteBuffersKt;
import io.ktor.utils.io.core.BytePacketBuilder;
import io.ktor.utils.io.core.ByteReadPacket;
import io.ktor.utils.io.core.Output;
import io.ktor.utils.io.core.OutputArraysJVMKt;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.core.internal.UnsafeKt;
import io.ktor.utils.io.internal.CancellableReusableContinuation;
import io.ktor.utils.io.internal.ClosedElement;
import io.ktor.utils.io.internal.FailedLookAhead;
import io.ktor.utils.io.internal.JoiningState;
import io.ktor.utils.io.internal.ObjectPoolKt;
import io.ktor.utils.io.internal.ReadSessionImpl;
import io.ktor.utils.io.internal.ReadWriteBufferState;
import io.ktor.utils.io.internal.ReadWriteBufferStateKt;
import io.ktor.utils.io.internal.RingBufferCapacity;
import io.ktor.utils.io.internal.TerminatedLookAhead;
import io.ktor.utils.io.internal.WriteSessionImpl;
import io.ktor.utils.io.pool.ObjectPool;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000à\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0004\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\bB\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b\u0010\u0018\u0000 ÿ\u00022\u00030\u00032\u00030\u00032\u00030\u00032\u00020m2\u00030\u00032\u00030\u0003:\u0002ÿ\u0002B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004B)\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0003\u0010\fJ\u001f\u0010\u0010\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001b\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\u001b\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0019J\u0013\u0010\u001b\u001a\u00020\u0014H@ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u0014H@ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001cJ\u0013\u0010\u001e\u001a\u00020\u0014H@ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001cJ/\u0010\"\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\n2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00140 H@ø\u0001\u0000¢\u0006\u0004\b\"\u0010#J\u0011\u0010%\u001a\u0004\u0018\u00010$H\u0016¢\u0006\u0004\b%\u0010&J'\u0010*\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020\nH\u0000¢\u0006\u0004\b(\u0010)J\u0019\u0010-\u001a\u00020\u00052\b\u0010,\u001a\u0004\u0018\u00010+H\u0016¢\u0006\u0004\b-\u0010.J\u0019\u0010/\u001a\u00020\u00052\b\u0010,\u001a\u0004\u0018\u00010+H\u0016¢\u0006\u0004\b/\u0010.JP\u00105\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u000526\u00104\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(0\u0012\u0004\u0012\u00020\u000501H\b¢\u0006\u0004\b5\u00106JK\u00107\u001a\u00020\u001426\u00104\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(0\u0012\u0004\u0012\u00020\u000501H@ø\u0001\u0000¢\u0006\u0004\b7\u00108J\u0017\u00109\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\nH\u0016¢\u0006\u0004\b9\u0010:J-\u0010B\u001a\u00020<2\u0006\u0010;\u001a\u00020\u00002\u0006\u0010=\u001a\u00020<2\b\u0010?\u001a\u0004\u0018\u00010>H@ø\u0001\u0000¢\u0006\u0004\b@\u0010AJ\u000f\u0010F\u001a\u00020CH\u0000¢\u0006\u0004\bD\u0010EJ,\u0010I\u001a\u00020\u00142\u0017\u0010H\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00140 ¢\u0006\u0002\bGHHø\u0001\u0000¢\u0006\u0004\bI\u0010JJ4\u0010K\u001a\u00020\u00142\u0006\u0010?\u001a\u00020>2\u0017\u0010!\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00140 ¢\u0006\u0002\bGHHø\u0001\u0000¢\u0006\u0004\bK\u0010LJ\u001b\u0010N\u001a\u00020<2\u0006\u0010M\u001a\u00020<H@ø\u0001\u0000¢\u0006\u0004\bN\u0010OJ#\u0010Q\u001a\u00020<2\u0006\u0010P\u001a\u00020<2\u0006\u0010M\u001a\u00020<H@ø\u0001\u0000¢\u0006\u0004\bQ\u0010RJA\u0010U\u001a\u00020\u00142\u0006\u0010S\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u000e2\u0017\u0010T\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00140 ¢\u0006\u0002\bGH\b¢\u0006\u0004\bU\u0010VJ\u000f\u0010W\u001a\u00020\u0014H\u0016¢\u0006\u0004\bW\u0010XJ\u0017\u0010Z\u001a\u00020\u00142\u0006\u0010Y\u001a\u00020\nH\u0016¢\u0006\u0004\bZ\u0010:J\u0017\u0010[\u001a\u00020\u00142\u0006\u0010?\u001a\u00020>H\u0002¢\u0006\u0004\b[\u0010\\J\u000f\u0010]\u001a\u00020\u0014H\u0016¢\u0006\u0004\b]\u0010XJ\u0017\u0010_\u001a\u00020\u00142\u0006\u0010^\u001a\u00020\nH\u0002¢\u0006\u0004\b_\u0010:J\u0011\u0010b\u001a\u0004\u0018\u00010>H\u0000¢\u0006\u0004\b`\u0010aJ#\u0010f\u001a\u00020\u00142\u0006\u0010;\u001a\u00020\u00002\u0006\u0010c\u001a\u00020\u0005H@ø\u0001\u0000¢\u0006\u0004\bd\u0010eJ+\u0010g\u001a\u00020\u00142\u0006\u0010;\u001a\u00020\u00002\u0006\u0010c\u001a\u00020\u00052\u0006\u0010?\u001a\u00020>H@ø\u0001\u0000¢\u0006\u0004\bg\u0010hJ.\u0010k\u001a\u00028\u0000\"\u0004\b\u0000\u0010i2\u0017\u00104\u001a\u0013\u0012\u0004\u0012\u00020j\u0012\u0004\u0012\u00028\u00000 ¢\u0006\u0002\bGH\u0017¢\u0006\u0004\bk\u0010lJB\u0010p\u001a\u00028\u0000\"\u0004\b\u0000\u0010i2'\u00104\u001a#\b\u0001\u0012\u0004\u0012\u00020m\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000n\u0012\u0006\u0012\u0004\u0018\u00010o01¢\u0006\u0002\bGH@ø\u0001\u0000¢\u0006\u0004\bp\u00108J\u000f\u0010q\u001a\u00020\bH\u0002¢\u0006\u0004\bq\u0010rJA\u0010y\u001a\u00020<2\u0006\u0010t\u001a\u00020s2\u0006\u0010u\u001a\u00020<2\u0006\u0010v\u001a\u00020<2\u0006\u0010\u001f\u001a\u00020<2\u0006\u0010M\u001a\u00020<H@ø\u0001\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bw\u0010xJ\u001f\u0010}\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u00012\u0006\u0010z\u001a\u00020\nH\u0000¢\u0006\u0004\b{\u0010|J/\u0010\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\n2\u0012\u0010~\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00140 H@ø\u0001\u0000¢\u0006\u0004\b\u0010#J0\u0010\u0001\u001a\u00020\n2\b\u0010\u0001\u001a\u00030\u00012\b\b\u0002\u00109\u001a\u00020\n2\b\b\u0002\u0010M\u001a\u00020\nH\u0002¢\u0006\u0006\b\u0001\u0010\u0001J\u001b\u0010\u0001\u001a\u00020\n2\u0007\u0010\u0001\u001a\u00020\u0001H\u0002¢\u0006\u0006\b\u0001\u0010\u0001J-\u0010\u0001\u001a\u00020\n2\b\u0010\u0001\u001a\u00030\u00012\u0006\u0010v\u001a\u00020\n2\u0007\u0010\u0001\u001a\u00020\nH\u0002¢\u0006\u0006\b\u0001\u0010\u0001J \u0010\u0001\u001a\u00020\n2\b\u0010\u0001\u001a\u00030\u0001H@ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u001f\u0010\u0001\u001a\u00020\n2\u0007\u0010\u0001\u001a\u00020\u0001H@ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J1\u0010\u0001\u001a\u00020\n2\b\u0010\u0001\u001a\u00030\u00012\u0006\u0010v\u001a\u00020\n2\u0007\u0010\u0001\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J.\u0010\u0001\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\n2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00140 H\u0016¢\u0006\u0006\b\u0001\u0010\u0001J \u0010\u0001\u001a\u00020\n2\b\u0010\u0001\u001a\u00030\u0001H@ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u001f\u0010\u0001\u001a\u00020\n2\u0007\u0010\u0001\u001a\u00020\u0001H@ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J1\u0010\u0001\u001a\u00020\n2\b\u0010\u0001\u001a\u00030\u00012\u0006\u0010v\u001a\u00020\n2\u0007\u0010\u0001\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J1\u0010\u0001\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\n2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00140 H@ø\u0001\u0000¢\u0006\u0005\b\u0001\u0010#J\u0015\u0010\u0001\u001a\u00020\u0005H@ø\u0001\u0000¢\u0006\u0005\b\u0001\u0010\u001cJ\u0016\u0010\u0001\u001a\u00030\u0001H@ø\u0001\u0000¢\u0006\u0005\b\u0001\u0010\u001cJ\u0016\u0010\u0001\u001a\u00030\u0001H@ø\u0001\u0000¢\u0006\u0005\b\u0001\u0010\u001cJ\u0016\u0010\u0001\u001a\u00030\u0001H@ø\u0001\u0000¢\u0006\u0005\b\u0001\u0010\u001cJ(\u0010\u0001\u001a\u00020\u00142\b\u0010\u0001\u001a\u00030\u00012\u0006\u0010\u0017\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u001f\u0010\u0001\u001a\u00020\n2\u0007\u0010\u0001\u001a\u00020\u0001H@ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J1\u0010\u0001\u001a\u00020\u00142\b\u0010\u0001\u001a\u00030\u00012\u0006\u0010v\u001a\u00020\n2\u0007\u0010\u0001\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J(\u0010\u0001\u001a\u00020\u00142\b\u0010\u0001\u001a\u00030\u00012\u0006\u0010\u0017\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J(\u0010\u0001\u001a\u00020\n2\u0007\u0010\u0001\u001a\u00020\u00012\u0007\u0010\u0001\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J1\u0010\u0001\u001a\u00020\u00142\b\u0010\u0001\u001a\u00030\u00012\u0006\u0010v\u001a\u00020\n2\u0007\u0010\u0001\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u0015\u0010\u0001\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0005\b\u0001\u0010\u001cJ\u0015\u0010\u0001\u001a\u00020<H@ø\u0001\u0000¢\u0006\u0005\b\u0001\u0010\u001cJ\u001e\u0010\u0001\u001a\u00030\u00012\u0006\u0010S\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0005\b\u0001\u0010\u0019J1\u0010¢\u0001\u001a\u00030\u00012\u0006\u0010S\u001a\u00020\n2\b\u0010¡\u0001\u001a\u00030 \u00012\u0006\u0010\r\u001a\u00020\u0001H@ø\u0001\u0000¢\u0006\u0006\b¢\u0001\u0010£\u0001JC\u0010§\u0001\u001a\u00028\u0000\"\n\b\u0000\u0010¥\u0001*\u00030¤\u00012\u0006\u0010S\u001a\u00020\n2\u0018\u0010¦\u0001\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00028\u00000 ¢\u0006\u0002\bGHHø\u0001\u0000¢\u0006\u0005\b§\u0001\u0010#J\u001e\u0010¨\u0001\u001a\u00030\u00012\u0006\u0010=\u001a\u00020<H@ø\u0001\u0000¢\u0006\u0005\b¨\u0001\u0010OJ\u001e\u0010©\u0001\u001a\u00030\u00012\u0006\u0010=\u001a\u00020<H@ø\u0001\u0000¢\u0006\u0005\b©\u0001\u0010OJ,\u0010«\u0001\u001a\u00020\u00142\u0018\u0010~\u001a\u0014\u0012\u0005\u0012\u00030ª\u0001\u0012\u0004\u0012\u00020\u00140 ¢\u0006\u0002\bGH\u0017¢\u0006\u0006\b«\u0001\u0010¬\u0001J\u0016\u0010®\u0001\u001a\u00030­\u0001H@ø\u0001\u0000¢\u0006\u0005\b®\u0001\u0010\u001cJ\u001d\u0010¯\u0001\u001a\u00020\u00052\u0006\u0010S\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0005\b¯\u0001\u0010\u0019J\u001d\u0010°\u0001\u001a\u00020\u00052\u0006\u0010S\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0005\b°\u0001\u0010\u0019J\u001d\u0010±\u0001\u001a\u00020\u00052\u0006\u0010S\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0005\b±\u0001\u0010\u0019J\u001b\u0010²\u0001\u001a\u00020\u00052\u0006\u0010S\u001a\u00020\nH\b¢\u0006\u0006\b²\u0001\u0010³\u0001J?\u0010µ\u0001\u001a\u00020\u00142(\u0010~\u001a$\b\u0001\u0012\u0005\u0012\u00030´\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140n\u0012\u0006\u0012\u0004\u0018\u00010o01¢\u0006\u0002\bGH@ø\u0001\u0000¢\u0006\u0005\bµ\u0001\u00108J \u0010·\u0001\u001a\u0005\u0018\u00010¶\u00012\u0006\u0010=\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0005\b·\u0001\u0010\u0019J8\u0010¼\u0001\u001a\u00020\u0005\"\u000f\b\u0000\u0010º\u0001*\b0¸\u0001j\u0003`¹\u00012\u0007\u0010»\u0001\u001a\u00028\u00002\u0006\u0010=\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0006\b¼\u0001\u0010½\u0001J-\u0010¾\u0001\u001a\u00020\u00052\r\u0010»\u0001\u001a\b0¸\u0001j\u0003`¹\u00012\u0006\u0010=\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0006\b¾\u0001\u0010½\u0001JJ\u0010Ä\u0001\u001a\u00020\u00052\r\u0010»\u0001\u001a\b0¸\u0001j\u0003`¹\u00012\u0006\u0010=\u001a\u00020\n2\b\u0010À\u0001\u001a\u00030¿\u00012\b\u0010Â\u0001\u001a\u00030Á\u00012\u0007\u0010Ã\u0001\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0006\bÄ\u0001\u0010Å\u0001J2\u0010Æ\u0001\u001a\u00020\u00052\u001d\u0010!\u001a\u0019\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000501¢\u0006\u0002\bGH\b¢\u0006\u0006\bÆ\u0001\u0010Ç\u0001J\u001a\u0010È\u0001\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\bH\u0002¢\u0006\u0006\bÈ\u0001\u0010É\u0001J\u001b\u0010Ê\u0001\u001a\u00030\u00012\u0006\u0010=\u001a\u00020<H\u0002¢\u0006\u0006\bÊ\u0001\u0010Ë\u0001J&\u0010Î\u0001\u001a\u0004\u0018\u00010\u00012\u0007\u0010Ì\u0001\u001a\u00020\n2\u0007\u0010Í\u0001\u001a\u00020\nH\u0016¢\u0006\u0006\bÎ\u0001\u0010Ï\u0001J\u0012\u0010Ò\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0006\bÐ\u0001\u0010Ñ\u0001J&\u0010Õ\u0001\u001a\u0004\u0018\u00010\u00002\u0007\u0010Ó\u0001\u001a\u00020\u00002\u0007\u0010Ô\u0001\u001a\u00020>H\u0002¢\u0006\u0006\bÕ\u0001\u0010Ö\u0001J\u0011\u0010×\u0001\u001a\u00020\u0014H\u0002¢\u0006\u0005\b×\u0001\u0010XJ\u0011\u0010Ù\u0001\u001a\u00020\u0014H\u0000¢\u0006\u0005\bØ\u0001\u0010XJ\u001c\u0010Ú\u0001\u001a\u00020\u00142\b\u0010,\u001a\u0004\u0018\u00010+H\u0002¢\u0006\u0006\bÚ\u0001\u0010Û\u0001J\u0011\u0010Ü\u0001\u001a\u00020\u0014H\u0002¢\u0006\u0005\bÜ\u0001\u0010XJ#\u0010Ü\u0001\u001a\u00020\u00142\u000e\u0010Þ\u0001\u001a\t\u0012\u0004\u0012\u00020+0Ý\u0001H\b¢\u0006\u0006\bÜ\u0001\u0010ß\u0001J\u0011\u0010à\u0001\u001a\u00020\u0014H\u0002¢\u0006\u0005\bà\u0001\u0010XJ#\u0010â\u0001\u001a\u00020>2\u0007\u0010á\u0001\u001a\u00020\u00002\u0006\u0010c\u001a\u00020\u0005H\u0002¢\u0006\u0006\bâ\u0001\u0010ã\u0001J\u0014\u0010ä\u0001\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0006\bä\u0001\u0010å\u0001J\u0014\u0010ç\u0001\u001a\u0004\u0018\u00010\u0001H\u0000¢\u0006\u0006\bæ\u0001\u0010å\u0001J\u0012\u0010è\u0001\u001a\u00020\u0005H\u0002¢\u0006\u0006\bè\u0001\u0010é\u0001J\u0013\u0010ê\u0001\u001a\u00030´\u0001H\u0016¢\u0006\u0006\bê\u0001\u0010ë\u0001J(\u0010í\u0001\u001a\u00020o2\u0006\u0010S\u001a\u00020\n2\r\u0010ì\u0001\u001a\b\u0012\u0004\u0012\u00020\u00050nH\u0002¢\u0006\u0005\bí\u0001\u0010\u0019J\u0013\u0010î\u0001\u001a\u00030¶\u0001H\u0016¢\u0006\u0006\bî\u0001\u0010ï\u0001J\u001a\u0010ð\u0001\u001a\u00020\u00052\u0006\u0010?\u001a\u00020>H\u0002¢\u0006\u0006\bð\u0001\u0010ñ\u0001J\u001b\u0010ó\u0001\u001a\u00020\u00052\u0007\u0010ò\u0001\u001a\u00020\u0005H\u0002¢\u0006\u0006\bó\u0001\u0010ô\u0001J\u0012\u0010ö\u0001\u001a\u00020\u0005H\u0000¢\u0006\u0006\bõ\u0001\u0010é\u0001J\u001c\u0010ø\u0001\u001a\u00020\n2\b\u0010÷\u0001\u001a\u00030\u0001H\u0002¢\u0006\u0006\bø\u0001\u0010ù\u0001J\u001d\u0010û\u0001\u001a\u00020\u00142\u0006\u0010S\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0005\bú\u0001\u0010\u0019J1\u0010ü\u0001\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\n2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00140 H@ø\u0001\u0000¢\u0006\u0005\bü\u0001\u0010#J\u001b\u0010ý\u0001\u001a\u00020\n2\u0007\u0010;\u001a\u00030\u0001H\u0002¢\u0006\u0006\bý\u0001\u0010þ\u0001J\u001a\u0010ý\u0001\u001a\u00020\n2\u0006\u0010;\u001a\u00020\u0001H\u0002¢\u0006\u0006\bý\u0001\u0010\u0001J,\u0010ý\u0001\u001a\u00020\n2\u0007\u0010;\u001a\u00030\u00012\u0006\u0010v\u001a\u00020\n2\u0007\u0010\u0001\u001a\u00020\nH\u0002¢\u0006\u0006\bý\u0001\u0010\u0001J\u001f\u0010ÿ\u0001\u001a\u00020\n2\u0007\u0010;\u001a\u00030\u0001H@ø\u0001\u0000¢\u0006\u0006\bÿ\u0001\u0010\u0001J\u001e\u0010ÿ\u0001\u001a\u00020\n2\u0006\u0010;\u001a\u00020\u0001H@ø\u0001\u0000¢\u0006\u0006\bÿ\u0001\u0010\u0001J0\u0010ÿ\u0001\u001a\u00020\n2\u0007\u0010;\u001a\u00030\u00012\u0006\u0010v\u001a\u00020\n2\u0007\u0010\u0001\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0006\bÿ\u0001\u0010\u0001J.\u0010ÿ\u0001\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\n2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00140 H\u0016¢\u0006\u0006\bÿ\u0001\u0010\u0001J\u001f\u0010\u0002\u001a\u00020\n2\u0007\u0010;\u001a\u00030\u0001H@ø\u0001\u0000¢\u0006\u0006\b\u0002\u0010\u0001J\u001e\u0010\u0002\u001a\u00020\n2\u0006\u0010;\u001a\u00020\u0001H@ø\u0001\u0000¢\u0006\u0006\b\u0002\u0010\u0001J \u0010\u0002\u001a\u00020\u00142\b\u0010\u0002\u001a\u00030\u0001H@ø\u0001\u0000¢\u0006\u0006\b\u0002\u0010\u0002J \u0010\u0002\u001a\u00020\u00142\b\u0010\u0002\u001a\u00030\u0001H@ø\u0001\u0000¢\u0006\u0006\b\u0002\u0010\u0002J \u0010\u0002\u001a\u00020\u00142\b\u0010\u0002\u001a\u00030\u0001H@ø\u0001\u0000¢\u0006\u0006\b\u0002\u0010\u0002J7\u0010\u0002\u001a\u00020\u00142\u0007\u0010\u0002\u001a\u00020s2\u0007\u0010\u0002\u001a\u00020\n2\u0007\u0010\u0002\u001a\u00020\nH@ø\u0001\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\b\u0002\u0010\u0002J\u001f\u0010\u0002\u001a\u00020\u00142\u0007\u0010;\u001a\u00030\u0001H@ø\u0001\u0000¢\u0006\u0006\b\u0002\u0010\u0002J\u001e\u0010\u0002\u001a\u00020\u00142\u0006\u0010;\u001a\u00020\u0001H@ø\u0001\u0000¢\u0006\u0006\b\u0002\u0010\u0001J0\u0010\u0002\u001a\u00020\u00142\u0007\u0010;\u001a\u00030\u00012\u0006\u0010v\u001a\u00020\n2\u0007\u0010\u0001\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0006\b\u0002\u0010\u0001J\u001f\u0010\u0002\u001a\u00020\u00142\u0007\u0010;\u001a\u00030\u0001H@ø\u0001\u0000¢\u0006\u0006\b\u0002\u0010\u0002J\u001e\u0010\u0002\u001a\u00020\u00142\u0006\u0010;\u001a\u00020\u0001H@ø\u0001\u0000¢\u0006\u0006\b\u0002\u0010\u0001J0\u0010\u0002\u001a\u00020\u00142\u0007\u0010;\u001a\u00030\u00012\u0006\u0010v\u001a\u00020\n2\u0007\u0010\u0001\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0006\b\u0002\u0010\u0001J\u001e\u0010\u0002\u001a\u00020\u00142\u0007\u0010\u0002\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0005\b\u0002\u0010\u0019J\u001e\u0010\u0002\u001a\u00020\u00142\u0007\u0010\u0002\u001a\u00020<H@ø\u0001\u0000¢\u0006\u0005\b\u0002\u0010OJ \u0010\u0002\u001a\u00020\u00142\b\u0010÷\u0001\u001a\u00030\u0001H@ø\u0001\u0000¢\u0006\u0006\b\u0002\u0010\u0002J \u0010\u0002\u001a\u00020\u00142\b\u0010÷\u0001\u001a\u00030\u0001H@ø\u0001\u0000¢\u0006\u0006\b\u0002\u0010\u0002JQ\u0010\u0002\u001a\u00020\u00142\u0006\u0010S\u001a\u00020\n2\u0017\u0010H\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00140 ¢\u0006\u0002\bG2\u0018\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00140 ¢\u0006\u0002\bGHHø\u0001\u0000¢\u0006\u0006\b\u0002\u0010\u0002J \u0010\u0002\u001a\u00020\u00142\b\u0010\u0002\u001a\u00030­\u0001H@ø\u0001\u0000¢\u0006\u0006\b\u0002\u0010\u0002J0\u0010\u0002\u001a\u00020\n2\u0007\u0010;\u001a\u00030\u00012\u0006\u0010v\u001a\u00020\n2\u0007\u0010\u0001\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0006\b\u0002\u0010\u0001J\u001d\u0010\u0002\u001a\u00020\u00142\u0006\u0010S\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0005\b\u0002\u0010\u0019J*\u0010¢\u0002\u001a\u00020\u00142\u0006\u0010S\u001a\u00020\n2\u000e\u0010¡\u0002\u001a\t\u0012\u0004\u0012\u00020\u00140 \u0002H\u0002¢\u0006\u0006\b¢\u0002\u0010£\u0002J\u001a\u0010¤\u0002\u001a\u00020\u00052\u0006\u0010S\u001a\u00020\nH\u0002¢\u0006\u0006\b¤\u0002\u0010³\u0001J>\u0010¥\u0002\u001a\u00020\u00142'\u00104\u001a#\b\u0001\u0012\u0004\u0012\u00020$\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140n\u0012\u0006\u0012\u0004\u0018\u00010o01¢\u0006\u0002\bGH@ø\u0001\u0000¢\u0006\u0005\b¥\u0002\u00108J)\u0010¦\u0002\u001a\u00020\u00142\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00050 H@ø\u0001\u0000¢\u0006\u0005\b¦\u0002\u0010JJ7\u0010§\u0002\u001a\u00020\u00052\u0007\u0010\u0001\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u000e2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00050 H\u0002¢\u0006\u0006\b§\u0002\u0010¨\u0002J&\u0010©\u0002\u001a\u00020\u00052\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00050 H\u0002¢\u0006\u0006\b©\u0002\u0010ª\u0002J)\u0010«\u0002\u001a\u00020\u00142\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00050 H@ø\u0001\u0000¢\u0006\u0005\b«\u0002\u0010JJ9\u0010­\u0002\u001a\u00020\u00142$\u0010!\u001a \u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00140¬\u0002¢\u0006\u0002\bGH\b¢\u0006\u0006\b­\u0002\u0010®\u0002J%\u0010¯\u0002\u001a\u00020\u0014*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020\nH\u0002¢\u0006\u0005\b¯\u0002\u0010)J%\u0010°\u0002\u001a\u00020\u0014*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020\nH\u0002¢\u0006\u0005\b°\u0002\u0010)J\u0015\u0010±\u0002\u001a\u00020\u0014*\u00020\u0001H\u0002¢\u0006\u0005\b±\u0002\u0010\u0004J\u001f\u0010³\u0002\u001a\u00020\n*\u00020\u00012\u0007\u0010²\u0002\u001a\u00020\nH\u0002¢\u0006\u0006\b³\u0002\u0010´\u0002J(\u0010·\u0002\u001a\u00020\u0014*\u00020\u00012\u0007\u0010µ\u0002\u001a\u00020\n2\u0007\u0010¶\u0002\u001a\u00020\nH\u0002¢\u0006\u0006\b·\u0002\u0010¸\u0002Jy\u0010¼\u0002\u001a\u00020\u0005*\u00020j2\r\u0010»\u0001\u001a\b0¸\u0001j\u0003`¹\u00012\b\u0010À\u0001\u001a\u00030¿\u00012\b\u0010Â\u0001\u001a\u00030Á\u00012\u0013\u0010¹\u0002\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00050 2\u0013\u0010º\u0002\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00140 2\u0013\u0010»\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020<0 H\b¢\u0006\u0006\b¼\u0002\u0010½\u0002J\u001d\u0010¾\u0002\u001a\u00020\u0014*\u00020\u00012\u0006\u0010\u0017\u001a\u00020\nH\u0002¢\u0006\u0005\b¾\u0002\u0010|J@\u0010¿\u0002\u001a\u00020\u0005*\u00020\u00012\u0006\u0010S\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000e2\u0017\u0010T\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00140 ¢\u0006\u0002\bGH\b¢\u0006\u0006\b¿\u0002\u0010À\u0002J]\u0010Á\u0002\u001a\u00020\u0014*\u00020\u00012\u0006\u0010S\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000e2\u0017\u0010H\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00140 ¢\u0006\u0002\bG2\u0018\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00140 ¢\u0006\u0002\bGHHø\u0001\u0000¢\u0006\u0006\bÁ\u0002\u0010Â\u0002R\u001b\u0010Ã\u0002\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bÃ\u0002\u0010Ä\u0002R\u001d\u0010\u0006\u001a\u00020\u00058\u0016X\u0004¢\u0006\u000f\n\u0005\b\u0006\u0010Å\u0002\u001a\u0006\bÆ\u0002\u0010é\u0001R\u0017\u0010É\u0002\u001a\u00020\n8VX\u0004¢\u0006\b\u001a\u0006\bÇ\u0002\u0010È\u0002R\u0017\u0010Ë\u0002\u001a\u00020\n8VX\u0004¢\u0006\b\u001a\u0006\bÊ\u0002\u0010È\u0002R0\u0010Ò\u0002\u001a\u0005\u0018\u00010Ì\u00022\n\u0010Í\u0002\u001a\u0005\u0018\u00010Ì\u00028B@BX\u000e¢\u0006\u0010\u001a\u0006\bÎ\u0002\u0010Ï\u0002\"\u0006\bÐ\u0002\u0010Ñ\u0002R\u0019\u0010Õ\u0002\u001a\u0004\u0018\u00010+8VX\u0004¢\u0006\b\u001a\u0006\bÓ\u0002\u0010Ô\u0002R\u0017\u0010Ö\u0002\u001a\u00020\u00058VX\u0004¢\u0006\b\u001a\u0006\bÖ\u0002\u0010é\u0001R\u0017\u0010×\u0002\u001a\u00020\u00058VX\u0004¢\u0006\b\u001a\u0006\b×\u0002\u0010é\u0001R\u001b\u0010Ô\u0001\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bÔ\u0001\u0010Ø\u0002R\u001b\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0002X\u0004¢\u0006\u0007\n\u0005\b\t\u0010Ù\u0002R:\u0010Þ\u0002\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010n2\u000f\u0010Í\u0002\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010n8B@BX\u000e¢\u0006\u0010\u001a\u0006\bÚ\u0002\u0010Û\u0002\"\u0006\bÜ\u0002\u0010Ý\u0002R\u0019\u0010ß\u0002\u001a\u00020\n8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bß\u0002\u0010à\u0002R\u001f\u0010«\u0001\u001a\u00030á\u00028\u0002X\u0004¢\u0006\u000f\n\u0006\b«\u0001\u0010â\u0002\u0012\u0005\bã\u0002\u0010XR\u001e\u0010å\u0002\u001a\t\u0012\u0004\u0012\u00020\u00050ä\u00028\u0002X\u0004¢\u0006\b\n\u0006\bå\u0002\u0010æ\u0002R\u001d\u0010\u000b\u001a\u00020\n8\u0000X\u0004¢\u0006\u000f\n\u0005\b\u000b\u0010à\u0002\u001a\u0006\bç\u0002\u0010È\u0002R\u0016\u0010é\u0002\u001a\u00020C8BX\u0004¢\u0006\u0007\u001a\u0005\bè\u0002\u0010ER2\u0010ë\u0002\u001a\u00020<2\u0007\u0010ê\u0002\u001a\u00020<8\u0016@PX\u000e¢\u0006\u0018\n\u0006\bë\u0002\u0010ì\u0002\u001a\u0006\bí\u0002\u0010î\u0002\"\u0006\bï\u0002\u0010ð\u0002R2\u0010ñ\u0002\u001a\u00020<2\u0007\u0010ê\u0002\u001a\u00020<8\u0016@PX\u000e¢\u0006\u0018\n\u0006\bñ\u0002\u0010ì\u0002\u001a\u0006\bò\u0002\u0010î\u0002\"\u0006\bó\u0002\u0010ð\u0002R:\u0010ö\u0002\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010n2\u000f\u0010Í\u0002\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010n8B@BX\u000e¢\u0006\u0010\u001a\u0006\bô\u0002\u0010Û\u0002\"\u0006\bõ\u0002\u0010Ý\u0002R\u0019\u0010÷\u0002\u001a\u00020\n8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b÷\u0002\u0010à\u0002R\u0018\u0010ù\u0002\u001a\u00030ø\u00028\u0002X\u0004¢\u0006\b\n\u0006\bù\u0002\u0010ú\u0002R\u001e\u0010û\u0002\u001a\t\u0012\u0004\u0012\u00020\u00140ä\u00028\u0002X\u0004¢\u0006\b\n\u0006\bû\u0002\u0010æ\u0002R)\u0010ü\u0002\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140n\u0012\u0004\u0012\u00020o0 8\u0002X\u0004¢\u0006\b\n\u0006\bü\u0002\u0010ý\u0002R\u0019\u0010þ\u0002\u001a\u00020\n8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bþ\u0002\u0010à\u0002\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0003"}, d2 = {"Lio/ktor/utils/io/ByteBufferChannel;", "Ljava/nio/ByteBuffer;", "content", "<init>", "(Ljava/nio/ByteBuffer;)V", "", "autoFlush", "Lio/ktor/utils/io/pool/ObjectPool;", "Lio/ktor/utils/io/internal/ReadWriteBufferState$Initial;", "pool", "", "reservedSize", "(ZLio/ktor/utils/io/pool/ObjectPool;I)V", "buffer", "Lio/ktor/utils/io/internal/RingBufferCapacity;", "capacity", "afterBufferVisited", "(Ljava/nio/ByteBuffer;Lio/ktor/utils/io/internal/RingBufferCapacity;)I", "Lkotlinx/coroutines/Job;", "job", "", "attachJob", "(Lkotlinx/coroutines/Job;)V", "n", "awaitAtLeast", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitAtLeastSuspend", "awaitClose", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitContent", "awaitFreeSpace", "min", "Lkotlin/Function1;", "block", "awaitFreeSpaceOrDelegate", "(ILkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/utils/io/WriterSuspendSession;", "beginWriteSession", "()Lio/ktor/utils/io/WriterSuspendSession;", "count", "bytesWrittenFromSession$ktor_io", "(Ljava/nio/ByteBuffer;Lio/ktor/utils/io/internal/RingBufferCapacity;I)V", "bytesWrittenFromSession", "", "cause", "cancel", "(Ljava/lang/Throwable;)Z", "close", "last", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "visitor", "consumeEachBufferRangeFast", "(ZLkotlin/jvm/functions/Function2;)Z", "consumeEachBufferRangeSuspend", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "consumed", "(I)V", "src", "", "limit", "Lio/ktor/utils/io/internal/JoiningState;", "joined", "copyDirect$ktor_io", "(Lio/ktor/utils/io/ByteBufferChannel;JLio/ktor/utils/io/internal/JoiningState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "copyDirect", "Lio/ktor/utils/io/internal/ReadWriteBufferState;", "currentState$ktor_io", "()Lio/ktor/utils/io/internal/ReadWriteBufferState;", "currentState", "Lkotlin/ExtensionFunctionType;", "channelWriter", "delegatePrimitive", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "delegateSuspend", "(Lio/ktor/utils/io/internal/JoiningState;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "max", "discard", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "discarded0", "discardSuspend", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "size", "writer", "doWritePrimitive", "(ILjava/nio/ByteBuffer;Lio/ktor/utils/io/internal/RingBufferCapacity;Lkotlin/jvm/functions/Function1;)V", "endReadSession", "()V", "written", "endWriteSession", "ensureClosedJoined", "(Lio/ktor/utils/io/internal/JoiningState;)V", "flush", "minWriteSize", "flushImpl", "getJoining$ktor_io", "()Lio/ktor/utils/io/internal/JoiningState;", "getJoining", "delegateClose", "joinFrom$ktor_io", "(Lio/ktor/utils/io/ByteBufferChannel;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "joinFrom", "joinFromSuspend", "(Lio/ktor/utils/io/ByteBufferChannel;ZLio/ktor/utils/io/internal/JoiningState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "R", "Lio/ktor/utils/io/LookAheadSession;", "lookAhead", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Lio/ktor/utils/io/LookAheadSuspendSession;", "Lkotlin/coroutines/Continuation;", "", "lookAheadSuspend", "newBuffer", "()Lio/ktor/utils/io/internal/ReadWriteBufferState$Initial;", "Lio/ktor/utils/io/bits/Memory;", "destination", "destinationOffset", "offset", "peekTo-lBXzO7A", "(Ljava/nio/ByteBuffer;JJJJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "peekTo", "lockedSpace", "prepareWriteBuffer$ktor_io", "(Ljava/nio/ByteBuffer;I)V", "prepareWriteBuffer", "consumer", "read", "Lio/ktor/utils/io/core/Buffer;", "dst", "readAsMuchAsPossible", "(Lio/ktor/utils/io/core/Buffer;II)I", "(Ljava/nio/ByteBuffer;)I", "", "length", "([BII)I", "Lio/ktor/utils/io/core/internal/ChunkBuffer;", "readAvailable", "(Lio/ktor/utils/io/core/internal/ChunkBuffer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Ljava/nio/ByteBuffer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "([BIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(ILkotlin/jvm/functions/Function1;)I", "readAvailableSuspend", "readBlockSuspend", "readBoolean", "", "readByte", "", "readDouble", "", "readFloat", "readFully", "(Lio/ktor/utils/io/core/internal/ChunkBuffer;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readFullySuspend", "rc0", "(Ljava/nio/ByteBuffer;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readInt", "readLong", "Lio/ktor/utils/io/core/ByteReadPacket;", "readPacket", "Lio/ktor/utils/io/core/BytePacketBuilder;", "builder", "readPacketSuspend", "(ILio/ktor/utils/io/core/BytePacketBuilder;Ljava/nio/ByteBuffer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "T", "getter", "readPrimitive", "readRemaining", "readRemainingSuspend", "Lio/ktor/utils/io/ReadSession;", "readSession", "(Lkotlin/jvm/functions/Function1;)V", "", "readShort", "readSuspend", "readSuspendImpl", "readSuspendLoop", "readSuspendPredicate", "(I)Z", "Lio/ktor/utils/io/SuspendableReadSession;", "readSuspendableSession", "", "readUTF8Line", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "A", "out", "readUTF8LineTo", "(Ljava/lang/Appendable;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readUTF8LineToAscii", "", "ca", "Ljava/nio/CharBuffer;", "cb", "consumed0", "readUTF8LineToUtf8Suspend", "(Ljava/lang/Appendable;I[CLjava/nio/CharBuffer;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reading", "(Lkotlin/jvm/functions/Function2;)Z", "releaseBuffer", "(Lio/ktor/utils/io/internal/ReadWriteBufferState$Initial;)V", "remainingPacket", "(J)Lio/ktor/utils/io/core/ByteReadPacket;", "skip", "atLeast", "request", "(II)Ljava/nio/ByteBuffer;", "resolveChannelInstance$ktor_io", "()Lio/ktor/utils/io/ByteBufferChannel;", "resolveChannelInstance", "current", "joining", "resolveDelegation", "(Lio/ktor/utils/io/ByteBufferChannel;Lio/ktor/utils/io/internal/JoiningState;)Lio/ktor/utils/io/ByteBufferChannel;", "restoreStateAfterRead", "restoreStateAfterWrite$ktor_io", "restoreStateAfterWrite", "resumeClosed", "(Ljava/lang/Throwable;)V", "resumeReadOp", "Lkotlin/Function0;", "exception", "(Lkotlin/jvm/functions/Function0;)V", "resumeWriteOp", "delegate", "setupDelegateTo", "(Lio/ktor/utils/io/ByteBufferChannel;Z)Lio/ktor/utils/io/internal/JoiningState;", "setupStateForRead", "()Ljava/nio/ByteBuffer;", "setupStateForWrite$ktor_io", "setupStateForWrite", "shouldResumeReadOp", "()Z", "startReadSession", "()Lio/ktor/utils/io/SuspendableReadSession;", "continuation", "suspensionForSize", "toString", "()Ljava/lang/String;", "tryCompleteJoining", "(Lio/ktor/utils/io/internal/JoiningState;)Z", "forceTermination", "tryReleaseBuffer", "(Z)Z", "tryTerminate$ktor_io", "tryTerminate", "packet", "tryWritePacketPart", "(Lio/ktor/utils/io/core/ByteReadPacket;)I", "tryWriteSuspend$ktor_io", "tryWriteSuspend", "write", "writeAsMuchAsPossible", "(Lio/ktor/utils/io/core/Buffer;)I", "writeAvailable", "writeAvailableSuspend", "b", "writeByte", "(BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "d", "writeDouble", "(DLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "f", "writeFloat", "(FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "memory", "startIndex", "endIndex", "writeFully-JT6ljtQ", "(Ljava/nio/ByteBuffer;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeFully", "(Lio/ktor/utils/io/core/Buffer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeFullySuspend", "i", "writeInt", "l", "writeLong", "writePacket", "(Lio/ktor/utils/io/core/ByteReadPacket;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writePacketSuspend", "bufferWriter", "writePrimitive", "(ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "s", "writeShort", "(SLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeSuspend", "Lkotlinx/coroutines/CancellableContinuation;", "c", "writeSuspendBlock", "(ILkotlinx/coroutines/CancellableContinuation;)V", "writeSuspendPredicate", "writeSuspendSession", "writeWhile", "writeWhileLoop", "(Ljava/nio/ByteBuffer;Lio/ktor/utils/io/internal/RingBufferCapacity;Lkotlin/jvm/functions/Function1;)Z", "writeWhileNoSuspend", "(Lkotlin/jvm/functions/Function1;)Z", "writeWhileSuspend", "Lkotlin/Function3;", "writing", "(Lkotlin/jvm/functions/Function3;)V", "bytesRead", "bytesWritten", "carry", "idx", "carryIndex", "(Ljava/nio/ByteBuffer;I)I", "position", "available", "prepareBuffer", "(Ljava/nio/ByteBuffer;II)V", "await", "addConsumed", "decode", "readLineLoop", "(Lio/ktor/utils/io/LookAheadSession;Ljava/lang/Appendable;[CLjava/nio/CharBuffer;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Z", "rollBytes", "tryWritePrimitive", "(Ljava/nio/ByteBuffer;ILio/ktor/utils/io/internal/RingBufferCapacity;Lkotlin/jvm/functions/Function1;)Z", "writeSuspendPrimitive", "(Ljava/nio/ByteBuffer;ILio/ktor/utils/io/internal/RingBufferCapacity;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "attachedJob", "Lkotlinx/coroutines/Job;", "Z", "getAutoFlush", "getAvailableForRead", "()I", "availableForRead", "getAvailableForWrite", "availableForWrite", "Lio/ktor/utils/io/internal/ClosedElement;", "value", "getClosed", "()Lio/ktor/utils/io/internal/ClosedElement;", "setClosed", "(Lio/ktor/utils/io/internal/ClosedElement;)V", "closed", "getClosedCause", "()Ljava/lang/Throwable;", "closedCause", "isClosedForRead", "isClosedForWrite", "Lio/ktor/utils/io/internal/JoiningState;", "Lio/ktor/utils/io/pool/ObjectPool;", "getReadOp", "()Lkotlin/coroutines/Continuation;", "setReadOp", "(Lkotlin/coroutines/Continuation;)V", "readOp", "readPosition", "I", "Lio/ktor/utils/io/internal/ReadSessionImpl;", "Lio/ktor/utils/io/internal/ReadSessionImpl;", "getReadSession$annotations", "Lio/ktor/utils/io/internal/CancellableReusableContinuation;", "readSuspendContinuationCache", "Lio/ktor/utils/io/internal/CancellableReusableContinuation;", "getReservedSize$ktor_io", "getState", "state", "<set-?>", "totalBytesRead", "J", "getTotalBytesRead", "()J", "setTotalBytesRead$ktor_io", "(J)V", "totalBytesWritten", "getTotalBytesWritten", "setTotalBytesWritten$ktor_io", "getWriteOp", "setWriteOp", "writeOp", "writePosition", "Lio/ktor/utils/io/internal/WriteSessionImpl;", "writeSession", "Lio/ktor/utils/io/internal/WriteSessionImpl;", "writeSuspendContinuationCache", "writeSuspension", "Lkotlin/jvm/functions/Function1;", "writeSuspensionSize", "Companion", "ktor-io", "Lio/ktor/utils/io/ByteChannel;", "Lio/ktor/utils/io/ByteReadChannel;", "Lio/ktor/utils/io/ByteWriteChannel;", "Lio/ktor/utils/io/HasReadSession;", "Lio/ktor/utils/io/HasWriteSession;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ByteBufferChannel.kt */
public class ByteBufferChannel implements ByteChannel, ByteReadChannel, ByteWriteChannel, LookAheadSuspendSession, HasReadSession, HasWriteSession {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int ReservedLongIndex = -8;
    private static final /* synthetic */ AtomicReferenceFieldUpdater _closed$FU;
    private static final /* synthetic */ AtomicReferenceFieldUpdater _readOp$FU;
    private static final /* synthetic */ AtomicReferenceFieldUpdater _state$FU;
    static final /* synthetic */ AtomicReferenceFieldUpdater _writeOp$FU;
    private volatile /* synthetic */ Object _closed;
    private volatile /* synthetic */ Object _readOp;
    private volatile /* synthetic */ Object _state;
    volatile /* synthetic */ Object _writeOp;
    /* access modifiers changed from: private */
    public volatile Job attachedJob;
    private final boolean autoFlush;
    private volatile JoiningState joining;
    private final ObjectPool<ReadWriteBufferState.Initial> pool;
    private int readPosition;
    /* access modifiers changed from: private */
    public final ReadSessionImpl readSession;
    private final CancellableReusableContinuation<Boolean> readSuspendContinuationCache;
    private final int reservedSize;
    private volatile long totalBytesRead;
    private volatile long totalBytesWritten;
    private int writePosition;
    private final WriteSessionImpl writeSession;
    private final CancellableReusableContinuation<Unit> writeSuspendContinuationCache;
    private final Function1<Continuation<? super Unit>, Object> writeSuspension;
    /* access modifiers changed from: private */
    public volatile int writeSuspensionSize;

    static {
        Class<ByteBufferChannel> cls = ByteBufferChannel.class;
        _state$FU = AtomicReferenceFieldUpdater.newUpdater(cls, Object.class, "_state");
        _closed$FU = AtomicReferenceFieldUpdater.newUpdater(cls, Object.class, "_closed");
        _readOp$FU = AtomicReferenceFieldUpdater.newUpdater(cls, Object.class, "_readOp");
        _writeOp$FU = AtomicReferenceFieldUpdater.newUpdater(cls, Object.class, "_writeOp");
    }

    private static /* synthetic */ void getReadSession$annotations() {
    }

    public Object awaitContent(Continuation<? super Unit> continuation) {
        return awaitContent$suspendImpl(this, continuation);
    }

    public Object awaitFreeSpace(Continuation<? super Unit> continuation) {
        return awaitFreeSpace$suspendImpl(this, continuation);
    }

    public Object discard(long j, Continuation<? super Long> continuation) {
        return discard$suspendImpl(this, j, continuation);
    }

    @Deprecated(message = "Use read { } instead.")
    public <R> Object lookAheadSuspend(Function2<? super LookAheadSuspendSession, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super R> continuation) {
        return lookAheadSuspend$suspendImpl(this, function2, continuation);
    }

    /* renamed from: peekTo-lBXzO7A  reason: not valid java name */
    public Object m22peekTolBXzO7A(ByteBuffer byteBuffer, long j, long j2, long j3, long j4, Continuation<? super Long> continuation) {
        return m20peekTolBXzO7A$suspendImpl(this, byteBuffer, j, j2, j3, j4, continuation);
    }

    public Object read(int i, Function1<? super ByteBuffer, Unit> function1, Continuation<? super Unit> continuation) {
        return read$suspendImpl(this, i, function1, continuation);
    }

    public Object readAvailable(ChunkBuffer chunkBuffer, Continuation<? super Integer> continuation) {
        return readAvailable$suspendImpl(this, chunkBuffer, (Continuation) continuation);
    }

    public Object readAvailable(ByteBuffer byteBuffer, Continuation<? super Integer> continuation) {
        return readAvailable$suspendImpl(this, byteBuffer, (Continuation) continuation);
    }

    public Object readAvailable(byte[] bArr, int i, int i2, Continuation<? super Integer> continuation) {
        return readAvailable$suspendImpl(this, bArr, i, i2, continuation);
    }

    public Object readFully(ChunkBuffer chunkBuffer, int i, Continuation<? super Unit> continuation) {
        return readFully$suspendImpl(this, chunkBuffer, i, continuation);
    }

    public Object readPacket(int i, Continuation<? super ByteReadPacket> continuation) {
        return readPacket$suspendImpl(this, i, continuation);
    }

    public Object readRemaining(long j, Continuation<? super ByteReadPacket> continuation) {
        return readRemaining$suspendImpl(this, j, continuation);
    }

    @Deprecated(message = "Use read { } instead.")
    public Object readSuspendableSession(Function2<? super SuspendableReadSession, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        return readSuspendableSession$suspendImpl(this, function2, continuation);
    }

    public Object readUTF8Line(int i, Continuation<? super String> continuation) {
        return readUTF8Line$suspendImpl(this, i, continuation);
    }

    public <A extends Appendable> Object readUTF8LineTo(A a, int i, Continuation<? super Boolean> continuation) {
        return readUTF8LineToAscii(a, i, continuation);
    }

    public Object write(int i, Function1<? super ByteBuffer, Unit> function1, Continuation<? super Unit> continuation) {
        return write$suspendImpl(this, i, function1, continuation);
    }

    public Object writeAvailable(ChunkBuffer chunkBuffer, Continuation<? super Integer> continuation) {
        return writeAvailable$suspendImpl(this, chunkBuffer, (Continuation) continuation);
    }

    public Object writeAvailable(ByteBuffer byteBuffer, Continuation<? super Integer> continuation) {
        return writeAvailable$suspendImpl(this, byteBuffer, (Continuation) continuation);
    }

    public Object writeAvailable(byte[] bArr, int i, int i2, Continuation<? super Integer> continuation) {
        return writeAvailable$suspendImpl(this, bArr, i, i2, continuation);
    }

    public Object writeByte(byte b, Continuation<? super Unit> continuation) {
        return writeByte$suspendImpl(this, b, continuation);
    }

    public Object writeDouble(double d, Continuation<? super Unit> continuation) {
        return writeDouble$suspendImpl(this, d, continuation);
    }

    public Object writeFloat(float f, Continuation<? super Unit> continuation) {
        return writeFloat$suspendImpl(this, f, continuation);
    }

    public Object writeFully(Buffer buffer, Continuation<? super Unit> continuation) {
        return writeFully$suspendImpl(this, buffer, (Continuation) continuation);
    }

    public Object writeFully(ByteBuffer byteBuffer, Continuation<? super Unit> continuation) {
        return writeFully$suspendImpl(this, byteBuffer, (Continuation) continuation);
    }

    public Object writeFully(byte[] bArr, int i, int i2, Continuation<? super Unit> continuation) {
        return writeFully$suspendImpl(this, bArr, i, i2, continuation);
    }

    /* renamed from: writeFully-JT6ljtQ  reason: not valid java name */
    public Object m23writeFullyJT6ljtQ(ByteBuffer byteBuffer, int i, int i2, Continuation<? super Unit> continuation) {
        return m21writeFullyJT6ljtQ$suspendImpl(this, byteBuffer, i, i2, continuation);
    }

    public Object writeInt(int i, Continuation<? super Unit> continuation) {
        return writeInt$suspendImpl(this, i, continuation);
    }

    public Object writeLong(long j, Continuation<? super Unit> continuation) {
        return writeLong$suspendImpl(this, j, continuation);
    }

    public Object writePacket(ByteReadPacket byteReadPacket, Continuation<? super Unit> continuation) {
        return writePacket$suspendImpl(this, byteReadPacket, continuation);
    }

    public Object writeShort(short s, Continuation<? super Unit> continuation) {
        return writeShort$suspendImpl(this, s, continuation);
    }

    @Deprecated(message = "Use write { } instead.")
    public Object writeSuspendSession(Function2<? super WriterSuspendSession, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        return writeSuspendSession$suspendImpl(this, function2, continuation);
    }

    public Object writeWhile(Function1<? super ByteBuffer, Boolean> function1, Continuation<? super Unit> continuation) {
        return writeWhile$suspendImpl(this, function1, continuation);
    }

    public ByteBufferChannel(boolean z, ObjectPool<ReadWriteBufferState.Initial> objectPool, int i) {
        Intrinsics.checkNotNullParameter(objectPool, "pool");
        this.autoFlush = z;
        this.pool = objectPool;
        this.reservedSize = i;
        this._state = ReadWriteBufferState.IdleEmpty.INSTANCE;
        this._closed = null;
        this._readOp = null;
        this._writeOp = null;
        this.readSession = new ReadSessionImpl(this);
        this.writeSession = new WriteSessionImpl(this);
        this.readSuspendContinuationCache = new CancellableReusableContinuation<>();
        this.writeSuspendContinuationCache = new CancellableReusableContinuation<>();
        this.writeSuspension = (Function1) new ByteBufferChannel$writeSuspension$1(this);
    }

    public boolean getAutoFlush() {
        return this.autoFlush;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ByteBufferChannel(boolean z, ObjectPool<ReadWriteBufferState.Initial> objectPool, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, (i2 & 2) != 0 ? ObjectPoolKt.getBufferObjectPool() : objectPool, (i2 & 4) != 0 ? 8 : i);
    }

    public final int getReservedSize$ktor_io() {
        return this.reservedSize;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ByteBufferChannel(ByteBuffer byteBuffer) {
        this(false, ObjectPoolKt.getBufferObjectNoPool(), 0);
        Intrinsics.checkNotNullParameter(byteBuffer, "content");
        ByteBuffer slice = byteBuffer.slice();
        Intrinsics.checkNotNullExpressionValue(slice, "content.slice()");
        ReadWriteBufferState.Initial initial = new ReadWriteBufferState.Initial(slice, 0);
        initial.capacity.resetForRead();
        this._state = initial.startWriting$ktor_io();
        restoreStateAfterWrite$ktor_io();
        ByteWriteChannelKt.close(this);
        tryTerminate$ktor_io();
    }

    private final ReadWriteBufferState getState() {
        return (ReadWriteBufferState) this._state;
    }

    /* access modifiers changed from: private */
    public final ClosedElement getClosed() {
        return (ClosedElement) this._closed;
    }

    private final void setClosed(ClosedElement closedElement) {
        this._closed = closedElement;
    }

    private final Continuation<Boolean> getReadOp() {
        return (Continuation) this._readOp;
    }

    private final void setReadOp(Continuation<? super Boolean> continuation) {
        this._readOp = continuation;
    }

    /* access modifiers changed from: private */
    public final Continuation<Unit> getWriteOp() {
        return (Continuation) this._writeOp;
    }

    private final void setWriteOp(Continuation<? super Unit> continuation) {
        this._writeOp = continuation;
    }

    public final ReadWriteBufferState currentState$ktor_io() {
        return getState();
    }

    public final JoiningState getJoining$ktor_io() {
        return this.joining;
    }

    public void attachJob(Job job) {
        Intrinsics.checkNotNullParameter(job, "job");
        Job job2 = this.attachedJob;
        if (job2 != null) {
            Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
        }
        this.attachedJob = job;
        Job.DefaultImpls.invokeOnCompletion$default(job, true, false, new ByteBufferChannel$attachJob$1(this), 2, (Object) null);
    }

    public int getAvailableForRead() {
        return getState().capacity._availableForRead$internal;
    }

    public int getAvailableForWrite() {
        return getState().capacity._availableForWrite$internal;
    }

    public boolean isClosedForRead() {
        return getState() == ReadWriteBufferState.Terminated.INSTANCE && getClosed() != null;
    }

    public boolean isClosedForWrite() {
        return getClosed() != null;
    }

    public long getTotalBytesRead() {
        return this.totalBytesRead;
    }

    public void setTotalBytesRead$ktor_io(long j) {
        this.totalBytesRead = j;
    }

    public long getTotalBytesWritten() {
        return this.totalBytesWritten;
    }

    public void setTotalBytesWritten$ktor_io(long j) {
        this.totalBytesWritten = j;
    }

    public Throwable getClosedCause() {
        ClosedElement closed = getClosed();
        if (closed != null) {
            return closed.getCause();
        }
        return null;
    }

    public boolean close(Throwable th) {
        ClosedElement closedElement;
        JoiningState joiningState;
        if (getClosed() != null) {
            return false;
        }
        if (th == null) {
            closedElement = ClosedElement.Companion.getEmptyCause();
        } else {
            closedElement = new ClosedElement(th);
        }
        getState().capacity.flush();
        if (!_closed$FU.compareAndSet(this, (Object) null, closedElement)) {
            return false;
        }
        getState().capacity.flush();
        if (getState().capacity.isEmpty() || th != null) {
            tryTerminate$ktor_io();
        }
        resumeClosed(th);
        if (getState() == ReadWriteBufferState.Terminated.INSTANCE && (joiningState = this.joining) != null) {
            ensureClosedJoined(joiningState);
        }
        if (th != null) {
            Job job = this.attachedJob;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            this.readSuspendContinuationCache.close(th);
            this.writeSuspendContinuationCache.close(th);
            return true;
        }
        this.writeSuspendContinuationCache.close((Throwable) new ClosedWriteChannelException(ByteBufferChannelKt.DEFAULT_CLOSE_MESSAGE));
        this.readSuspendContinuationCache.close(Boolean.valueOf(getState().capacity.flush()));
        return true;
    }

    public boolean cancel(Throwable th) {
        if (th == null) {
            th = new CancellationException("Channel has been cancelled");
        }
        return close(th);
    }

    /* access modifiers changed from: private */
    public final void flushImpl(int i) {
        ReadWriteBufferState state;
        ByteBufferChannel delegatedTo;
        JoiningState joiningState = this.joining;
        if (!(joiningState == null || (delegatedTo = joiningState.getDelegatedTo()) == null)) {
            delegatedTo.flush();
        }
        do {
            state = getState();
            if (state != ReadWriteBufferState.Terminated.INSTANCE) {
                state.capacity.flush();
            } else {
                return;
            }
        } while (state != getState());
        int i2 = state.capacity._availableForWrite$internal;
        if (state.capacity._availableForRead$internal >= 1) {
            resumeReadOp();
        }
        JoiningState joiningState2 = this.joining;
        if (i2 < i) {
            return;
        }
        if (joiningState2 == null || getState() == ReadWriteBufferState.Terminated.INSTANCE) {
            resumeWriteOp();
        }
    }

    public void flush() {
        flushImpl(1);
    }

    public final void prepareWriteBuffer$ktor_io(ByteBuffer byteBuffer, int i) {
        Intrinsics.checkNotNullParameter(byteBuffer, "buffer");
        prepareBuffer(byteBuffer, this.writePosition, i);
    }

    private final void prepareBuffer(ByteBuffer byteBuffer, int i, int i2) {
        boolean z = true;
        if (i >= 0) {
            if (i2 < 0) {
                z = false;
            }
            if (z) {
                byteBuffer.limit(RangesKt.coerceAtMost(i2 + i, byteBuffer.capacity() - this.reservedSize));
                byteBuffer.position(i);
                return;
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public final ByteBuffer setupStateForWrite$ktor_io() {
        Object obj;
        ReadWriteBufferState readWriteBufferState;
        ReadWriteBufferState readWriteBufferState2;
        Continuation<Unit> writeOp = getWriteOp();
        if (writeOp == null) {
            ReadWriteBufferState readWriteBufferState3 = null;
            ReadWriteBufferState.Initial initial = null;
            do {
                obj = this._state;
                readWriteBufferState = (ReadWriteBufferState) obj;
                if (this.joining != null) {
                    if (initial != null) {
                        releaseBuffer(initial);
                    }
                    return null;
                } else if (getClosed() != null) {
                    if (initial != null) {
                        releaseBuffer(initial);
                    }
                    ClosedElement closed = getClosed();
                    Intrinsics.checkNotNull(closed);
                    Void unused = ByteBufferChannelKt.rethrowClosed(closed.getSendException());
                    throw new KotlinNothingValueException();
                } else if (readWriteBufferState == ReadWriteBufferState.IdleEmpty.INSTANCE) {
                    if (initial == null) {
                        initial = newBuffer();
                    }
                    readWriteBufferState2 = initial.startWriting$ktor_io();
                } else if (readWriteBufferState == ReadWriteBufferState.Terminated.INSTANCE) {
                    if (initial != null) {
                        releaseBuffer(initial);
                    }
                    if (this.joining != null) {
                        return null;
                    }
                    ClosedElement closed2 = getClosed();
                    Intrinsics.checkNotNull(closed2);
                    Void unused2 = ByteBufferChannelKt.rethrowClosed(closed2.getSendException());
                    throw new KotlinNothingValueException();
                } else {
                    readWriteBufferState2 = readWriteBufferState.startWriting$ktor_io();
                }
            } while (!_state$FU.compareAndSet(this, obj, readWriteBufferState2));
            if (getClosed() == null) {
                ByteBuffer writeBuffer = readWriteBufferState2.getWriteBuffer();
                if (initial != null) {
                    if (readWriteBufferState == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("old");
                    } else {
                        readWriteBufferState3 = readWriteBufferState;
                    }
                    if (readWriteBufferState3 != ReadWriteBufferState.IdleEmpty.INSTANCE) {
                        releaseBuffer(initial);
                    }
                }
                prepareBuffer(writeBuffer, this.writePosition, readWriteBufferState2.capacity._availableForWrite$internal);
                return writeBuffer;
            }
            restoreStateAfterWrite$ktor_io();
            tryTerminate$ktor_io();
            ClosedElement closed3 = getClosed();
            Intrinsics.checkNotNull(closed3);
            Void unused3 = ByteBufferChannelKt.rethrowClosed(closed3.getSendException());
            throw new KotlinNothingValueException();
        }
        throw new IllegalStateException("Write operation is already in progress: " + writeOp);
    }

    private final JoiningState setupDelegateTo(ByteBufferChannel byteBufferChannel, boolean z) {
        if (this != byteBufferChannel) {
            JoiningState joiningState = new JoiningState(byteBufferChannel, z);
            this.joining = joiningState;
            ClosedElement closed = getClosed();
            if (closed == null) {
                flush();
                return joiningState;
            }
            if (closed.getCause() != null) {
                byteBufferChannel.close(closed.getCause());
            } else if (!z || getState() != ReadWriteBufferState.Terminated.INSTANCE) {
                byteBufferChannel.flush();
            } else {
                ByteWriteChannelKt.close(byteBufferChannel);
            }
            return joiningState;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    private final boolean tryCompleteJoining(JoiningState joiningState) {
        if (!tryReleaseBuffer(true)) {
            return false;
        }
        ensureClosedJoined(joiningState);
        Continuation continuation = (Continuation) _readOp$FU.getAndSet(this, (Object) null);
        if (continuation != null) {
            Result.Companion companion = Result.Companion;
            continuation.resumeWith(Result.m320constructorimpl(ResultKt.createFailure(new IllegalStateException("Joining is in progress"))));
        }
        resumeWriteOp();
        return true;
    }

    public final boolean tryTerminate$ktor_io() {
        if (getClosed() == null || !tryReleaseBuffer(false)) {
            return false;
        }
        JoiningState joiningState = this.joining;
        if (joiningState != null) {
            ensureClosedJoined(joiningState);
        }
        resumeReadOp();
        resumeWriteOp();
        return true;
    }

    private final int carryIndex(ByteBuffer byteBuffer, int i) {
        return i >= byteBuffer.capacity() - this.reservedSize ? i - (byteBuffer.capacity() - this.reservedSize) : i;
    }

    private final void writing(Function3<? super ByteBufferChannel, ? super ByteBuffer, ? super RingBufferCapacity, Unit> function3) {
        ByteBufferChannel byteBufferChannel;
        JoiningState joiningState = this.joining;
        if (joiningState == null || (byteBufferChannel = resolveDelegation(this, joiningState)) == null) {
            byteBufferChannel = this;
        }
        ByteBuffer byteBuffer = byteBufferChannel.setupStateForWrite$ktor_io();
        if (byteBuffer != null) {
            RingBufferCapacity ringBufferCapacity = byteBufferChannel.getState().capacity;
            long totalBytesWritten2 = byteBufferChannel.getTotalBytesWritten();
            try {
                ClosedElement closed = byteBufferChannel.getClosed();
                if (closed == null) {
                    function3.invoke(byteBufferChannel, byteBuffer, ringBufferCapacity);
                } else {
                    Void unused = ByteBufferChannelKt.rethrowClosed(closed.getSendException());
                    throw new KotlinNothingValueException();
                }
            } finally {
                InlineMarker.finallyStart(1);
                if (ringBufferCapacity.isFull() || byteBufferChannel.getAutoFlush()) {
                    byteBufferChannel.flush();
                }
                if (byteBufferChannel != this) {
                    setTotalBytesWritten$ktor_io(getTotalBytesWritten() + (byteBufferChannel.getTotalBytesWritten() - totalBytesWritten2));
                }
                byteBufferChannel.restoreStateAfterWrite$ktor_io();
                byteBufferChannel.tryTerminate$ktor_io();
                InlineMarker.finallyEnd(1);
            }
        }
    }

    private final boolean reading(Function2<? super ByteBuffer, ? super RingBufferCapacity, Boolean> function2) {
        ByteBuffer byteBuffer = setupStateForRead();
        if (byteBuffer == null) {
            return false;
        }
        RingBufferCapacity ringBufferCapacity = getState().capacity;
        try {
            if (ringBufferCapacity._availableForRead$internal == 0) {
                return false;
            }
            boolean booleanValue = ((Boolean) function2.invoke(byteBuffer, ringBufferCapacity)).booleanValue();
            InlineMarker.finallyStart(1);
            restoreStateAfterRead();
            tryTerminate$ktor_io();
            InlineMarker.finallyEnd(1);
            return booleanValue;
        } finally {
            InlineMarker.finallyStart(1);
            restoreStateAfterRead();
            tryTerminate$ktor_io();
            InlineMarker.finallyEnd(1);
        }
    }

    public final Object readFully(byte[] bArr, int i, int i2, Continuation<? super Unit> continuation) {
        int readAsMuchAsPossible = readAsMuchAsPossible(bArr, i, i2);
        if (readAsMuchAsPossible >= i2) {
            return Unit.INSTANCE;
        }
        Object readFullySuspend = readFullySuspend(bArr, i + readAsMuchAsPossible, i2 - readAsMuchAsPossible, continuation);
        return readFullySuspend == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? readFullySuspend : Unit.INSTANCE;
    }

    public final Object readFully(ByteBuffer byteBuffer, Continuation<? super Integer> continuation) {
        int readAsMuchAsPossible = readAsMuchAsPossible(byteBuffer);
        if (!byteBuffer.hasRemaining()) {
            return Boxing.boxInt(readAsMuchAsPossible);
        }
        return readFullySuspend(byteBuffer, readAsMuchAsPossible, continuation);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object readFullySuspend(java.nio.ByteBuffer r6, int r7, kotlin.coroutines.Continuation<? super java.lang.Integer> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof io.ktor.utils.io.ByteBufferChannel$readFullySuspend$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            io.ktor.utils.io.ByteBufferChannel$readFullySuspend$1 r0 = (io.ktor.utils.io.ByteBufferChannel$readFullySuspend$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            io.ktor.utils.io.ByteBufferChannel$readFullySuspend$1 r0 = new io.ktor.utils.io.ByteBufferChannel$readFullySuspend$1
            r0.<init>(r5, r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003c
            if (r2 != r3) goto L_0x0034
            int r6 = r0.I$0
            java.lang.Object r7 = r0.L$1
            java.nio.ByteBuffer r7 = (java.nio.ByteBuffer) r7
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.ByteBufferChannel r2 = (io.ktor.utils.io.ByteBufferChannel) r2
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0058
        L_0x0034:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x003c:
            kotlin.ResultKt.throwOnFailure(r8)
            r2 = r5
        L_0x0040:
            boolean r8 = r6.hasRemaining()
            if (r8 == 0) goto L_0x0089
            r0.L$0 = r2
            r0.L$1 = r6
            r0.I$0 = r7
            r0.label = r3
            java.lang.Object r8 = r2.readSuspend(r3, r0)
            if (r8 != r1) goto L_0x0055
            return r1
        L_0x0055:
            r4 = r7
            r7 = r6
            r6 = r4
        L_0x0058:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto L_0x0069
            int r8 = r2.readAsMuchAsPossible(r7)
            int r6 = r6 + r8
            r4 = r7
            r7 = r6
            r6 = r4
            goto L_0x0040
        L_0x0069:
            kotlinx.coroutines.channels.ClosedReceiveChannelException r6 = new kotlinx.coroutines.channels.ClosedReceiveChannelException
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r0 = "Unexpected EOF: expected "
            r8.append(r0)
            int r7 = r7.remaining()
            r8.append(r7)
            java.lang.String r7 = " more bytes"
            r8.append(r7)
            java.lang.String r7 = r8.toString()
            r6.<init>(r7)
            throw r6
        L_0x0089:
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r7)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.readFullySuspend(java.nio.ByteBuffer, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object readFully$suspendImpl(ByteBufferChannel byteBufferChannel, ChunkBuffer chunkBuffer, int i, Continuation continuation) {
        int readAsMuchAsPossible$default = readAsMuchAsPossible$default(byteBufferChannel, chunkBuffer, 0, i, 2, (Object) null);
        if (readAsMuchAsPossible$default == i) {
            return Unit.INSTANCE;
        }
        Object readFullySuspend = byteBufferChannel.readFullySuspend(chunkBuffer, i - readAsMuchAsPossible$default, (Continuation<? super Unit>) continuation);
        return readFullySuspend == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? readFullySuspend : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object readFullySuspend(io.ktor.utils.io.core.internal.ChunkBuffer r19, int r20, kotlin.coroutines.Continuation<? super kotlin.Unit> r21) {
        /*
            r18 = this;
            r0 = r21
            boolean r1 = r0 instanceof io.ktor.utils.io.ByteBufferChannel$readFullySuspend$2
            if (r1 == 0) goto L_0x0018
            r1 = r0
            io.ktor.utils.io.ByteBufferChannel$readFullySuspend$2 r1 = (io.ktor.utils.io.ByteBufferChannel$readFullySuspend$2) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0018
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            r2 = r18
            goto L_0x001f
        L_0x0018:
            io.ktor.utils.io.ByteBufferChannel$readFullySuspend$2 r1 = new io.ktor.utils.io.ByteBufferChannel$readFullySuspend$2
            r2 = r18
            r1.<init>(r2, r0)
        L_0x001f:
            java.lang.Object r0 = r1.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r1.label
            r5 = 0
            r6 = 1
            if (r4 == 0) goto L_0x004c
            if (r4 != r6) goto L_0x0044
            int r4 = r1.I$1
            int r7 = r1.I$0
            java.lang.Object r8 = r1.L$1
            io.ktor.utils.io.core.internal.ChunkBuffer r8 = (io.ktor.utils.io.core.internal.ChunkBuffer) r8
            java.lang.Object r9 = r1.L$0
            io.ktor.utils.io.ByteBufferChannel r9 = (io.ktor.utils.io.ByteBufferChannel) r9
            kotlin.ResultKt.throwOnFailure(r0)
            r15 = r9
            r16 = r3
            r3 = r1
            r1 = r7
            r7 = r16
            goto L_0x0087
        L_0x0044:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x004c:
            kotlin.ResultKt.throwOnFailure(r0)
            r0 = r19
            r9 = r2
            r4 = r3
            r7 = r5
            r3 = r1
            r1 = r20
        L_0x0057:
            r8 = r0
            io.ktor.utils.io.core.Buffer r8 = (io.ktor.utils.io.core.Buffer) r8
            int r10 = r8.getLimit()
            int r8 = r8.getWritePosition()
            if (r10 <= r8) goto L_0x0066
            r8 = r6
            goto L_0x0067
        L_0x0066:
            r8 = r5
        L_0x0067:
            if (r8 == 0) goto L_0x00be
            if (r7 >= r1) goto L_0x00be
            r3.L$0 = r9
            r3.L$1 = r0
            r3.I$0 = r1
            r3.I$1 = r7
            r3.label = r6
            java.lang.Object r8 = r9.readSuspend(r6, r3)
            if (r8 != r4) goto L_0x007c
            return r4
        L_0x007c:
            r15 = r9
            r16 = r8
            r8 = r0
            r0 = r16
            r17 = r7
            r7 = r4
            r4 = r17
        L_0x0087:
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x00a1
            r10 = r8
            io.ktor.utils.io.core.Buffer r10 = (io.ktor.utils.io.core.Buffer) r10
            r11 = 0
            int r12 = r1 - r4
            r13 = 2
            r14 = 0
            r9 = r15
            int r0 = readAsMuchAsPossible$default(r9, r10, r11, r12, r13, r14)
            int r0 = r0 + r4
            r4 = r7
            r7 = r0
            r0 = r8
            goto L_0x0057
        L_0x00a1:
            kotlinx.coroutines.channels.ClosedReceiveChannelException r0 = new kotlinx.coroutines.channels.ClosedReceiveChannelException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = "Unexpected EOF: expected "
            r3.append(r5)
            int r1 = r1 - r4
            r3.append(r1)
            java.lang.String r1 = " more bytes"
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r0.<init>(r1)
            throw r0
        L_0x00be:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.readFullySuspend(io.ktor.utils.io.core.internal.ChunkBuffer, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object readFullySuspend(byte[] r8, int r9, int r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            r7 = this;
            boolean r0 = r11 instanceof io.ktor.utils.io.ByteBufferChannel$readFullySuspend$3
            if (r0 == 0) goto L_0x0014
            r0 = r11
            io.ktor.utils.io.ByteBufferChannel$readFullySuspend$3 r0 = (io.ktor.utils.io.ByteBufferChannel$readFullySuspend$3) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L_0x0019
        L_0x0014:
            io.ktor.utils.io.ByteBufferChannel$readFullySuspend$3 r0 = new io.ktor.utils.io.ByteBufferChannel$readFullySuspend$3
            r0.<init>(r7, r11)
        L_0x0019:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0040
            if (r2 != r3) goto L_0x0038
            int r8 = r0.I$2
            int r9 = r0.I$1
            int r10 = r0.I$0
            java.lang.Object r2 = r0.L$1
            byte[] r2 = (byte[]) r2
            java.lang.Object r4 = r0.L$0
            io.ktor.utils.io.ByteBufferChannel r4 = (io.ktor.utils.io.ByteBufferChannel) r4
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x005f
        L_0x0038:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0040:
            kotlin.ResultKt.throwOnFailure(r11)
            r11 = 0
            r4 = r7
        L_0x0045:
            r0.L$0 = r4
            r0.L$1 = r8
            r0.I$0 = r9
            r0.I$1 = r10
            r0.I$2 = r11
            r0.label = r3
            java.lang.Object r2 = r4.readSuspend(r3, r0)
            if (r2 != r1) goto L_0x0058
            return r1
        L_0x0058:
            r5 = r2
            r2 = r8
            r8 = r11
            r11 = r5
            r6 = r10
            r10 = r9
            r9 = r6
        L_0x005f:
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r11 = r11.booleanValue()
            if (r11 == 0) goto L_0x0077
            int r10 = r10 + r8
            int r8 = r9 - r8
            int r11 = r4.readAsMuchAsPossible((byte[]) r2, (int) r10, (int) r8)
            if (r11 < r8) goto L_0x0073
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        L_0x0073:
            r9 = r10
            r10 = r8
            r8 = r2
            goto L_0x0045
        L_0x0077:
            kotlinx.coroutines.channels.ClosedReceiveChannelException r8 = new kotlinx.coroutines.channels.ClosedReceiveChannelException
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "Unexpected EOF: expected "
            r10.append(r11)
            r10.append(r9)
            java.lang.String r9 = " more bytes"
            r10.append(r9)
            java.lang.String r9 = r10.toString()
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.readFullySuspend(byte[], int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object readAvailable$suspendImpl(ByteBufferChannel byteBufferChannel, byte[] bArr, int i, int i2, Continuation continuation) {
        int readAsMuchAsPossible = byteBufferChannel.readAsMuchAsPossible(bArr, i, i2);
        if (readAsMuchAsPossible == 0 && byteBufferChannel.getClosed() != null) {
            readAsMuchAsPossible = byteBufferChannel.getState().capacity.flush() ? byteBufferChannel.readAsMuchAsPossible(bArr, i, i2) : -1;
        } else if (readAsMuchAsPossible <= 0 && i2 != 0) {
            return byteBufferChannel.readAvailableSuspend(bArr, i, i2, continuation);
        }
        return Boxing.boxInt(readAsMuchAsPossible);
    }

    static /* synthetic */ Object readAvailable$suspendImpl(ByteBufferChannel byteBufferChannel, ByteBuffer byteBuffer, Continuation continuation) {
        int readAsMuchAsPossible = byteBufferChannel.readAsMuchAsPossible(byteBuffer);
        if (readAsMuchAsPossible == 0 && byteBufferChannel.getClosed() != null) {
            readAsMuchAsPossible = byteBufferChannel.getState().capacity.flush() ? byteBufferChannel.readAsMuchAsPossible(byteBuffer) : -1;
        } else if (readAsMuchAsPossible <= 0 && byteBuffer.hasRemaining()) {
            return byteBufferChannel.readAvailableSuspend(byteBuffer, (Continuation<? super Integer>) continuation);
        }
        return Boxing.boxInt(readAsMuchAsPossible);
    }

    static /* synthetic */ Object readAvailable$suspendImpl(ByteBufferChannel byteBufferChannel, ChunkBuffer chunkBuffer, Continuation continuation) {
        Buffer buffer = chunkBuffer;
        int readAsMuchAsPossible$default = readAsMuchAsPossible$default(byteBufferChannel, buffer, 0, 0, 6, (Object) null);
        if (readAsMuchAsPossible$default == 0 && byteBufferChannel.getClosed() != null) {
            readAsMuchAsPossible$default = byteBufferChannel.getState().capacity.flush() ? readAsMuchAsPossible$default(byteBufferChannel, buffer, 0, 0, 6, (Object) null) : -1;
        } else if (readAsMuchAsPossible$default <= 0) {
            if (buffer.getLimit() > buffer.getWritePosition()) {
                return byteBufferChannel.readAvailableSuspend(chunkBuffer, (Continuation<? super Integer>) continuation);
            }
        }
        return Boxing.boxInt(readAsMuchAsPossible$default);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object readAvailableSuspend(byte[] r6, int r7, int r8, kotlin.coroutines.Continuation<? super java.lang.Integer> r9) {
        /*
            r5 = this;
            boolean r0 = r9 instanceof io.ktor.utils.io.ByteBufferChannel$readAvailableSuspend$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            io.ktor.utils.io.ByteBufferChannel$readAvailableSuspend$1 r0 = (io.ktor.utils.io.ByteBufferChannel$readAvailableSuspend$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            io.ktor.utils.io.ByteBufferChannel$readAvailableSuspend$1 r0 = new io.ktor.utils.io.ByteBufferChannel$readAvailableSuspend$1
            r0.<init>(r5, r9)
        L_0x0019:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0045
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0076
        L_0x002d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0035:
            int r8 = r0.I$1
            int r7 = r0.I$0
            java.lang.Object r6 = r0.L$1
            byte[] r6 = (byte[]) r6
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.ByteBufferChannel r2 = (io.ktor.utils.io.ByteBufferChannel) r2
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x005a
        L_0x0045:
            kotlin.ResultKt.throwOnFailure(r9)
            r0.L$0 = r5
            r0.L$1 = r6
            r0.I$0 = r7
            r0.I$1 = r8
            r0.label = r4
            java.lang.Object r9 = r5.readSuspend(r4, r0)
            if (r9 != r1) goto L_0x0059
            return r1
        L_0x0059:
            r2 = r5
        L_0x005a:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 != 0) goto L_0x0068
            r6 = -1
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r6)
            return r6
        L_0x0068:
            r9 = 0
            r0.L$0 = r9
            r0.L$1 = r9
            r0.label = r3
            java.lang.Object r9 = r2.readAvailable(r6, r7, r8, r0)
            if (r9 != r1) goto L_0x0076
            return r1
        L_0x0076:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.readAvailableSuspend(byte[], int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object readAvailableSuspend(java.nio.ByteBuffer r6, kotlin.coroutines.Continuation<? super java.lang.Integer> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof io.ktor.utils.io.ByteBufferChannel$readAvailableSuspend$2
            if (r0 == 0) goto L_0x0014
            r0 = r7
            io.ktor.utils.io.ByteBufferChannel$readAvailableSuspend$2 r0 = (io.ktor.utils.io.ByteBufferChannel$readAvailableSuspend$2) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            io.ktor.utils.io.ByteBufferChannel$readAvailableSuspend$2 r0 = new io.ktor.utils.io.ByteBufferChannel$readAvailableSuspend$2
            r0.<init>(r5, r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0041
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x006e
        L_0x002d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0035:
            java.lang.Object r6 = r0.L$1
            java.nio.ByteBuffer r6 = (java.nio.ByteBuffer) r6
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.ByteBufferChannel r2 = (io.ktor.utils.io.ByteBufferChannel) r2
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0052
        L_0x0041:
            kotlin.ResultKt.throwOnFailure(r7)
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r4
            java.lang.Object r7 = r5.readSuspend(r4, r0)
            if (r7 != r1) goto L_0x0051
            return r1
        L_0x0051:
            r2 = r5
        L_0x0052:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 != 0) goto L_0x0060
            r6 = -1
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r6)
            return r6
        L_0x0060:
            r7 = 0
            r0.L$0 = r7
            r0.L$1 = r7
            r0.label = r3
            java.lang.Object r7 = r2.readAvailable((java.nio.ByteBuffer) r6, (kotlin.coroutines.Continuation<? super java.lang.Integer>) r0)
            if (r7 != r1) goto L_0x006e
            return r1
        L_0x006e:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.readAvailableSuspend(java.nio.ByteBuffer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object readAvailableSuspend(io.ktor.utils.io.core.internal.ChunkBuffer r6, kotlin.coroutines.Continuation<? super java.lang.Integer> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof io.ktor.utils.io.ByteBufferChannel$readAvailableSuspend$3
            if (r0 == 0) goto L_0x0014
            r0 = r7
            io.ktor.utils.io.ByteBufferChannel$readAvailableSuspend$3 r0 = (io.ktor.utils.io.ByteBufferChannel$readAvailableSuspend$3) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            io.ktor.utils.io.ByteBufferChannel$readAvailableSuspend$3 r0 = new io.ktor.utils.io.ByteBufferChannel$readAvailableSuspend$3
            r0.<init>(r5, r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0041
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x006e
        L_0x002d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0035:
            java.lang.Object r6 = r0.L$1
            io.ktor.utils.io.core.internal.ChunkBuffer r6 = (io.ktor.utils.io.core.internal.ChunkBuffer) r6
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.ByteBufferChannel r2 = (io.ktor.utils.io.ByteBufferChannel) r2
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0052
        L_0x0041:
            kotlin.ResultKt.throwOnFailure(r7)
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r4
            java.lang.Object r7 = r5.readSuspend(r4, r0)
            if (r7 != r1) goto L_0x0051
            return r1
        L_0x0051:
            r2 = r5
        L_0x0052:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 != 0) goto L_0x0060
            r6 = -1
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r6)
            return r6
        L_0x0060:
            r7 = 0
            r0.L$0 = r7
            r0.L$1 = r7
            r0.label = r3
            java.lang.Object r7 = r2.readAvailable((io.ktor.utils.io.core.internal.ChunkBuffer) r6, (kotlin.coroutines.Continuation<? super java.lang.Integer>) r0)
            if (r7 != r1) goto L_0x006e
            return r1
        L_0x006e:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.readAvailableSuspend(io.ktor.utils.io.core.internal.ChunkBuffer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object readPacket$suspendImpl(ByteBufferChannel byteBufferChannel, int i, Continuation continuation) {
        Throwable cause;
        ClosedElement closed = byteBufferChannel.getClosed();
        if (closed != null && (cause = closed.getCause()) != null) {
            Void unused = ByteBufferChannelKt.rethrowClosed(cause);
            throw new KotlinNothingValueException();
        } else if (i == 0) {
            return ByteReadPacket.Companion.getEmpty();
        } else {
            BytePacketBuilder bytePacketBuilder = new BytePacketBuilder((ObjectPool) null, 1, (DefaultConstructorMarker) null);
            ByteBuffer borrow = ObjectPoolKt.getBufferPool().borrow();
            while (i > 0) {
                try {
                    borrow.clear();
                    if (borrow.remaining() > i) {
                        borrow.limit(i);
                    }
                    int readAsMuchAsPossible = byteBufferChannel.readAsMuchAsPossible(borrow);
                    if (readAsMuchAsPossible == 0) {
                        break;
                    }
                    borrow.flip();
                    OutputArraysJVMKt.writeFully(bytePacketBuilder, borrow);
                    i -= readAsMuchAsPossible;
                } catch (Throwable th) {
                    ObjectPoolKt.getBufferPool().recycle(borrow);
                    bytePacketBuilder.release();
                    throw th;
                }
            }
            if (i != 0) {
                return byteBufferChannel.readPacketSuspend(i, bytePacketBuilder, borrow, continuation);
            }
            ObjectPoolKt.getBufferPool().recycle(borrow);
            return bytePacketBuilder.build();
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x004b A[SYNTHETIC, Splitter:B:18:0x004b] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object readPacketSuspend(int r7, io.ktor.utils.io.core.BytePacketBuilder r8, java.nio.ByteBuffer r9, kotlin.coroutines.Continuation<? super io.ktor.utils.io.core.ByteReadPacket> r10) {
        /*
            r6 = this;
            boolean r0 = r10 instanceof io.ktor.utils.io.ByteBufferChannel$readPacketSuspend$1
            if (r0 == 0) goto L_0x0014
            r0 = r10
            io.ktor.utils.io.ByteBufferChannel$readPacketSuspend$1 r0 = (io.ktor.utils.io.ByteBufferChannel$readPacketSuspend$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L_0x0019
        L_0x0014:
            io.ktor.utils.io.ByteBufferChannel$readPacketSuspend$1 r0 = new io.ktor.utils.io.ByteBufferChannel$readPacketSuspend$1
            r0.<init>(r6, r10)
        L_0x0019:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0045
            if (r2 != r3) goto L_0x003d
            int r7 = r0.I$0
            java.lang.Object r8 = r0.L$2
            java.nio.ByteBuffer r8 = (java.nio.ByteBuffer) r8
            java.lang.Object r9 = r0.L$1
            io.ktor.utils.io.core.BytePacketBuilder r9 = (io.ktor.utils.io.core.BytePacketBuilder) r9
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.ByteBufferChannel r2 = (io.ktor.utils.io.ByteBufferChannel) r2
            kotlin.ResultKt.throwOnFailure(r10)     // Catch:{ all -> 0x003b }
            r5 = r9
            r9 = r8
            r8 = r5
            goto L_0x0068
        L_0x003b:
            r7 = move-exception
            goto L_0x0089
        L_0x003d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0045:
            kotlin.ResultKt.throwOnFailure(r10)
            r2 = r6
        L_0x0049:
            if (r7 <= 0) goto L_0x0079
            r9.clear()     // Catch:{ all -> 0x0085 }
            int r10 = r9.remaining()     // Catch:{ all -> 0x0085 }
            if (r10 <= r7) goto L_0x0057
            r9.limit(r7)     // Catch:{ all -> 0x0085 }
        L_0x0057:
            r0.L$0 = r2     // Catch:{ all -> 0x0085 }
            r0.L$1 = r8     // Catch:{ all -> 0x0085 }
            r0.L$2 = r9     // Catch:{ all -> 0x0085 }
            r0.I$0 = r7     // Catch:{ all -> 0x0085 }
            r0.label = r3     // Catch:{ all -> 0x0085 }
            java.lang.Object r10 = r2.readFully(r9, r0)     // Catch:{ all -> 0x0085 }
            if (r10 != r1) goto L_0x0068
            return r1
        L_0x0068:
            java.lang.Number r10 = (java.lang.Number) r10     // Catch:{ all -> 0x0085 }
            int r10 = r10.intValue()     // Catch:{ all -> 0x0085 }
            r9.flip()     // Catch:{ all -> 0x0085 }
            r4 = r8
            io.ktor.utils.io.core.Output r4 = (io.ktor.utils.io.core.Output) r4     // Catch:{ all -> 0x0085 }
            io.ktor.utils.io.core.OutputArraysJVMKt.writeFully(r4, r9)     // Catch:{ all -> 0x0085 }
            int r7 = r7 - r10
            goto L_0x0049
        L_0x0079:
            io.ktor.utils.io.core.ByteReadPacket r7 = r8.build()     // Catch:{ all -> 0x0085 }
            io.ktor.utils.io.pool.ObjectPool r8 = io.ktor.utils.io.internal.ObjectPoolKt.getBufferPool()
            r8.recycle(r9)
            return r7
        L_0x0085:
            r7 = move-exception
            r5 = r9
            r9 = r8
            r8 = r5
        L_0x0089:
            r9.release()     // Catch:{ all -> 0x008d }
            throw r7     // Catch:{ all -> 0x008d }
        L_0x008d:
            r7 = move-exception
            io.ktor.utils.io.pool.ObjectPool r9 = io.ktor.utils.io.internal.ObjectPoolKt.getBufferPool()
            r9.recycle(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.readPacketSuspend(int, io.ktor.utils.io.core.BytePacketBuilder, java.nio.ByteBuffer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object readBoolean(kotlin.coroutines.Continuation<? super java.lang.Boolean> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof io.ktor.utils.io.ByteBufferChannel$readBoolean$1
            if (r0 == 0) goto L_0x0014
            r0 = r5
            io.ktor.utils.io.ByteBufferChannel$readBoolean$1 r0 = (io.ktor.utils.io.ByteBufferChannel$readBoolean$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L_0x0019
        L_0x0014:
            io.ktor.utils.io.ByteBufferChannel$readBoolean$1 r0 = new io.ktor.utils.io.ByteBufferChannel$readBoolean$1
            r0.<init>(r4, r5)
        L_0x0019:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x003e
        L_0x002a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r5)
            r0.label = r3
            java.lang.Object r5 = r4.readByte(r0)
            if (r5 != r1) goto L_0x003e
            return r1
        L_0x003e:
            java.lang.Number r5 = (java.lang.Number) r5
            byte r5 = r5.byteValue()
            if (r5 == 0) goto L_0x0047
            goto L_0x0048
        L_0x0047:
            r3 = 0
        L_0x0048:
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.readBoolean(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object readByte(kotlin.coroutines.Continuation<? super java.lang.Byte> r10) {
        /*
            r9 = this;
            boolean r0 = r10 instanceof io.ktor.utils.io.ByteBufferChannel$readByte$1
            if (r0 == 0) goto L_0x0014
            r0 = r10
            io.ktor.utils.io.ByteBufferChannel$readByte$1 r0 = (io.ktor.utils.io.ByteBufferChannel$readByte$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L_0x0019
        L_0x0014:
            io.ktor.utils.io.ByteBufferChannel$readByte$1 r0 = new io.ktor.utils.io.ByteBufferChannel$readByte$1
            r0.<init>(r9, r10)
        L_0x0019:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0039
            if (r2 != r3) goto L_0x0031
            int r2 = r0.I$0
            java.lang.Object r4 = r0.L$0
            io.ktor.utils.io.ByteBufferChannel r4 = (io.ktor.utils.io.ByteBufferChannel) r4
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x009a
        L_0x0031:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L_0x0039:
            kotlin.ResultKt.throwOnFailure(r10)
            r4 = r9
            r2 = r3
        L_0x003e:
            kotlin.jvm.internal.Ref$ObjectRef r10 = new kotlin.jvm.internal.Ref$ObjectRef
            r10.<init>()
            java.nio.ByteBuffer r5 = r4.setupStateForRead()
            r6 = 0
            if (r5 != 0) goto L_0x004b
            goto L_0x007b
        L_0x004b:
            io.ktor.utils.io.internal.ReadWriteBufferState r7 = r4.getState()
            io.ktor.utils.io.internal.RingBufferCapacity r7 = r7.capacity
            int r8 = r7._availableForRead$internal     // Catch:{ all -> 0x00bf }
            if (r8 != 0) goto L_0x005c
        L_0x0055:
            r4.restoreStateAfterRead()
            r4.tryTerminate$ktor_io()
            goto L_0x007b
        L_0x005c:
            boolean r8 = r7.tryReadExact(r2)     // Catch:{ all -> 0x00bf }
            if (r8 != 0) goto L_0x0063
            goto L_0x0055
        L_0x0063:
            int r6 = r5.remaining()     // Catch:{ all -> 0x00bf }
            if (r6 >= r2) goto L_0x006c
            r4.rollBytes(r5, r2)     // Catch:{ all -> 0x00bf }
        L_0x006c:
            byte r6 = r5.get()     // Catch:{ all -> 0x00bf }
            java.lang.Byte r6 = kotlin.coroutines.jvm.internal.Boxing.boxByte(r6)     // Catch:{ all -> 0x00bf }
            r10.element = r6     // Catch:{ all -> 0x00bf }
            r4.bytesRead(r5, r7, r2)     // Catch:{ all -> 0x00bf }
            r6 = r3
            goto L_0x0055
        L_0x007b:
            if (r6 == 0) goto L_0x008d
            java.lang.Object r0 = r10.element
            if (r0 != 0) goto L_0x0088
            java.lang.String r10 = "result"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r10)
            r10 = 0
            goto L_0x008c
        L_0x0088:
            java.lang.Object r10 = r10.element
            java.lang.Number r10 = (java.lang.Number) r10
        L_0x008c:
            return r10
        L_0x008d:
            r0.L$0 = r4
            r0.I$0 = r2
            r0.label = r3
            java.lang.Object r10 = r4.readSuspend(r2, r0)
            if (r10 != r1) goto L_0x009a
            return r1
        L_0x009a:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto L_0x00a3
            goto L_0x003e
        L_0x00a3:
            kotlinx.coroutines.channels.ClosedReceiveChannelException r10 = new kotlinx.coroutines.channels.ClosedReceiveChannelException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "EOF while "
            r0.append(r1)
            r0.append(r2)
            java.lang.String r1 = " bytes expected"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r10.<init>(r0)
            throw r10
        L_0x00bf:
            r10 = move-exception
            r4.restoreStateAfterRead()
            r4.tryTerminate$ktor_io()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.readByte(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object readShort(kotlin.coroutines.Continuation<? super java.lang.Short> r10) {
        /*
            r9 = this;
            boolean r0 = r10 instanceof io.ktor.utils.io.ByteBufferChannel$readShort$1
            if (r0 == 0) goto L_0x0014
            r0 = r10
            io.ktor.utils.io.ByteBufferChannel$readShort$1 r0 = (io.ktor.utils.io.ByteBufferChannel$readShort$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L_0x0019
        L_0x0014:
            io.ktor.utils.io.ByteBufferChannel$readShort$1 r0 = new io.ktor.utils.io.ByteBufferChannel$readShort$1
            r0.<init>(r9, r10)
        L_0x0019:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0039
            if (r2 != r3) goto L_0x0031
            int r2 = r0.I$0
            java.lang.Object r4 = r0.L$0
            io.ktor.utils.io.ByteBufferChannel r4 = (io.ktor.utils.io.ByteBufferChannel) r4
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x009b
        L_0x0031:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L_0x0039:
            kotlin.ResultKt.throwOnFailure(r10)
            r10 = 2
            r4 = r9
            r2 = r10
        L_0x003f:
            kotlin.jvm.internal.Ref$ObjectRef r10 = new kotlin.jvm.internal.Ref$ObjectRef
            r10.<init>()
            java.nio.ByteBuffer r5 = r4.setupStateForRead()
            r6 = 0
            if (r5 != 0) goto L_0x004c
            goto L_0x007c
        L_0x004c:
            io.ktor.utils.io.internal.ReadWriteBufferState r7 = r4.getState()
            io.ktor.utils.io.internal.RingBufferCapacity r7 = r7.capacity
            int r8 = r7._availableForRead$internal     // Catch:{ all -> 0x00c0 }
            if (r8 != 0) goto L_0x005d
        L_0x0056:
            r4.restoreStateAfterRead()
            r4.tryTerminate$ktor_io()
            goto L_0x007c
        L_0x005d:
            boolean r8 = r7.tryReadExact(r2)     // Catch:{ all -> 0x00c0 }
            if (r8 != 0) goto L_0x0064
            goto L_0x0056
        L_0x0064:
            int r6 = r5.remaining()     // Catch:{ all -> 0x00c0 }
            if (r6 >= r2) goto L_0x006d
            r4.rollBytes(r5, r2)     // Catch:{ all -> 0x00c0 }
        L_0x006d:
            short r6 = r5.getShort()     // Catch:{ all -> 0x00c0 }
            java.lang.Short r6 = kotlin.coroutines.jvm.internal.Boxing.boxShort(r6)     // Catch:{ all -> 0x00c0 }
            r10.element = r6     // Catch:{ all -> 0x00c0 }
            r4.bytesRead(r5, r7, r2)     // Catch:{ all -> 0x00c0 }
            r6 = r3
            goto L_0x0056
        L_0x007c:
            if (r6 == 0) goto L_0x008e
            java.lang.Object r0 = r10.element
            if (r0 != 0) goto L_0x0089
            java.lang.String r10 = "result"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r10)
            r10 = 0
            goto L_0x008d
        L_0x0089:
            java.lang.Object r10 = r10.element
            java.lang.Number r10 = (java.lang.Number) r10
        L_0x008d:
            return r10
        L_0x008e:
            r0.L$0 = r4
            r0.I$0 = r2
            r0.label = r3
            java.lang.Object r10 = r4.readSuspend(r2, r0)
            if (r10 != r1) goto L_0x009b
            return r1
        L_0x009b:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto L_0x00a4
            goto L_0x003f
        L_0x00a4:
            kotlinx.coroutines.channels.ClosedReceiveChannelException r10 = new kotlinx.coroutines.channels.ClosedReceiveChannelException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "EOF while "
            r0.append(r1)
            r0.append(r2)
            java.lang.String r1 = " bytes expected"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r10.<init>(r0)
            throw r10
        L_0x00c0:
            r10 = move-exception
            r4.restoreStateAfterRead()
            r4.tryTerminate$ktor_io()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.readShort(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object readInt(kotlin.coroutines.Continuation<? super java.lang.Integer> r10) {
        /*
            r9 = this;
            boolean r0 = r10 instanceof io.ktor.utils.io.ByteBufferChannel$readInt$1
            if (r0 == 0) goto L_0x0014
            r0 = r10
            io.ktor.utils.io.ByteBufferChannel$readInt$1 r0 = (io.ktor.utils.io.ByteBufferChannel$readInt$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L_0x0019
        L_0x0014:
            io.ktor.utils.io.ByteBufferChannel$readInt$1 r0 = new io.ktor.utils.io.ByteBufferChannel$readInt$1
            r0.<init>(r9, r10)
        L_0x0019:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0039
            if (r2 != r3) goto L_0x0031
            int r2 = r0.I$0
            java.lang.Object r4 = r0.L$0
            io.ktor.utils.io.ByteBufferChannel r4 = (io.ktor.utils.io.ByteBufferChannel) r4
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x009b
        L_0x0031:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L_0x0039:
            kotlin.ResultKt.throwOnFailure(r10)
            r10 = 4
            r4 = r9
            r2 = r10
        L_0x003f:
            kotlin.jvm.internal.Ref$ObjectRef r10 = new kotlin.jvm.internal.Ref$ObjectRef
            r10.<init>()
            java.nio.ByteBuffer r5 = r4.setupStateForRead()
            r6 = 0
            if (r5 != 0) goto L_0x004c
            goto L_0x007c
        L_0x004c:
            io.ktor.utils.io.internal.ReadWriteBufferState r7 = r4.getState()
            io.ktor.utils.io.internal.RingBufferCapacity r7 = r7.capacity
            int r8 = r7._availableForRead$internal     // Catch:{ all -> 0x00c0 }
            if (r8 != 0) goto L_0x005d
        L_0x0056:
            r4.restoreStateAfterRead()
            r4.tryTerminate$ktor_io()
            goto L_0x007c
        L_0x005d:
            boolean r8 = r7.tryReadExact(r2)     // Catch:{ all -> 0x00c0 }
            if (r8 != 0) goto L_0x0064
            goto L_0x0056
        L_0x0064:
            int r6 = r5.remaining()     // Catch:{ all -> 0x00c0 }
            if (r6 >= r2) goto L_0x006d
            r4.rollBytes(r5, r2)     // Catch:{ all -> 0x00c0 }
        L_0x006d:
            int r6 = r5.getInt()     // Catch:{ all -> 0x00c0 }
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r6)     // Catch:{ all -> 0x00c0 }
            r10.element = r6     // Catch:{ all -> 0x00c0 }
            r4.bytesRead(r5, r7, r2)     // Catch:{ all -> 0x00c0 }
            r6 = r3
            goto L_0x0056
        L_0x007c:
            if (r6 == 0) goto L_0x008e
            java.lang.Object r0 = r10.element
            if (r0 != 0) goto L_0x0089
            java.lang.String r10 = "result"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r10)
            r10 = 0
            goto L_0x008d
        L_0x0089:
            java.lang.Object r10 = r10.element
            java.lang.Number r10 = (java.lang.Number) r10
        L_0x008d:
            return r10
        L_0x008e:
            r0.L$0 = r4
            r0.I$0 = r2
            r0.label = r3
            java.lang.Object r10 = r4.readSuspend(r2, r0)
            if (r10 != r1) goto L_0x009b
            return r1
        L_0x009b:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto L_0x00a4
            goto L_0x003f
        L_0x00a4:
            kotlinx.coroutines.channels.ClosedReceiveChannelException r10 = new kotlinx.coroutines.channels.ClosedReceiveChannelException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "EOF while "
            r0.append(r1)
            r0.append(r2)
            java.lang.String r1 = " bytes expected"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r10.<init>(r0)
            throw r10
        L_0x00c0:
            r10 = move-exception
            r4.restoreStateAfterRead()
            r4.tryTerminate$ktor_io()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.readInt(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object readLong(kotlin.coroutines.Continuation<? super java.lang.Long> r11) {
        /*
            r10 = this;
            boolean r0 = r11 instanceof io.ktor.utils.io.ByteBufferChannel$readLong$1
            if (r0 == 0) goto L_0x0014
            r0 = r11
            io.ktor.utils.io.ByteBufferChannel$readLong$1 r0 = (io.ktor.utils.io.ByteBufferChannel$readLong$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L_0x0019
        L_0x0014:
            io.ktor.utils.io.ByteBufferChannel$readLong$1 r0 = new io.ktor.utils.io.ByteBufferChannel$readLong$1
            r0.<init>(r10, r11)
        L_0x0019:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0039
            if (r2 != r3) goto L_0x0031
            int r2 = r0.I$0
            java.lang.Object r4 = r0.L$0
            io.ktor.utils.io.ByteBufferChannel r4 = (io.ktor.utils.io.ByteBufferChannel) r4
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x009c
        L_0x0031:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L_0x0039:
            kotlin.ResultKt.throwOnFailure(r11)
            r11 = 8
            r4 = r10
            r2 = r11
        L_0x0040:
            kotlin.jvm.internal.Ref$ObjectRef r11 = new kotlin.jvm.internal.Ref$ObjectRef
            r11.<init>()
            java.nio.ByteBuffer r5 = r4.setupStateForRead()
            r6 = 0
            if (r5 != 0) goto L_0x004d
            goto L_0x007d
        L_0x004d:
            io.ktor.utils.io.internal.ReadWriteBufferState r7 = r4.getState()
            io.ktor.utils.io.internal.RingBufferCapacity r7 = r7.capacity
            int r8 = r7._availableForRead$internal     // Catch:{ all -> 0x00c1 }
            if (r8 != 0) goto L_0x005e
        L_0x0057:
            r4.restoreStateAfterRead()
            r4.tryTerminate$ktor_io()
            goto L_0x007d
        L_0x005e:
            boolean r8 = r7.tryReadExact(r2)     // Catch:{ all -> 0x00c1 }
            if (r8 != 0) goto L_0x0065
            goto L_0x0057
        L_0x0065:
            int r6 = r5.remaining()     // Catch:{ all -> 0x00c1 }
            if (r6 >= r2) goto L_0x006e
            r4.rollBytes(r5, r2)     // Catch:{ all -> 0x00c1 }
        L_0x006e:
            long r8 = r5.getLong()     // Catch:{ all -> 0x00c1 }
            java.lang.Long r6 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r8)     // Catch:{ all -> 0x00c1 }
            r11.element = r6     // Catch:{ all -> 0x00c1 }
            r4.bytesRead(r5, r7, r2)     // Catch:{ all -> 0x00c1 }
            r6 = r3
            goto L_0x0057
        L_0x007d:
            if (r6 == 0) goto L_0x008f
            java.lang.Object r0 = r11.element
            if (r0 != 0) goto L_0x008a
            java.lang.String r11 = "result"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r11)
            r11 = 0
            goto L_0x008e
        L_0x008a:
            java.lang.Object r11 = r11.element
            java.lang.Number r11 = (java.lang.Number) r11
        L_0x008e:
            return r11
        L_0x008f:
            r0.L$0 = r4
            r0.I$0 = r2
            r0.label = r3
            java.lang.Object r11 = r4.readSuspend(r2, r0)
            if (r11 != r1) goto L_0x009c
            return r1
        L_0x009c:
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r11 = r11.booleanValue()
            if (r11 == 0) goto L_0x00a5
            goto L_0x0040
        L_0x00a5:
            kotlinx.coroutines.channels.ClosedReceiveChannelException r11 = new kotlinx.coroutines.channels.ClosedReceiveChannelException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "EOF while "
            r0.append(r1)
            r0.append(r2)
            java.lang.String r1 = " bytes expected"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r11.<init>(r0)
            throw r11
        L_0x00c1:
            r11 = move-exception
            r4.restoreStateAfterRead()
            r4.tryTerminate$ktor_io()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.readLong(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object readFloat(kotlin.coroutines.Continuation<? super java.lang.Float> r10) {
        /*
            r9 = this;
            boolean r0 = r10 instanceof io.ktor.utils.io.ByteBufferChannel$readFloat$1
            if (r0 == 0) goto L_0x0014
            r0 = r10
            io.ktor.utils.io.ByteBufferChannel$readFloat$1 r0 = (io.ktor.utils.io.ByteBufferChannel$readFloat$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L_0x0019
        L_0x0014:
            io.ktor.utils.io.ByteBufferChannel$readFloat$1 r0 = new io.ktor.utils.io.ByteBufferChannel$readFloat$1
            r0.<init>(r9, r10)
        L_0x0019:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0039
            if (r2 != r3) goto L_0x0031
            int r2 = r0.I$0
            java.lang.Object r4 = r0.L$0
            io.ktor.utils.io.ByteBufferChannel r4 = (io.ktor.utils.io.ByteBufferChannel) r4
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x00a7
        L_0x0031:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L_0x0039:
            kotlin.ResultKt.throwOnFailure(r10)
            r10 = 4
            r4 = r9
            r2 = r10
        L_0x003f:
            kotlin.jvm.internal.Ref$ObjectRef r10 = new kotlin.jvm.internal.Ref$ObjectRef
            r10.<init>()
            java.nio.ByteBuffer r5 = r4.setupStateForRead()
            r6 = 0
            if (r5 != 0) goto L_0x004c
            goto L_0x007c
        L_0x004c:
            io.ktor.utils.io.internal.ReadWriteBufferState r7 = r4.getState()
            io.ktor.utils.io.internal.RingBufferCapacity r7 = r7.capacity
            int r8 = r7._availableForRead$internal     // Catch:{ all -> 0x00cc }
            if (r8 != 0) goto L_0x005d
        L_0x0056:
            r4.restoreStateAfterRead()
            r4.tryTerminate$ktor_io()
            goto L_0x007c
        L_0x005d:
            boolean r8 = r7.tryReadExact(r2)     // Catch:{ all -> 0x00cc }
            if (r8 != 0) goto L_0x0064
            goto L_0x0056
        L_0x0064:
            int r6 = r5.remaining()     // Catch:{ all -> 0x00cc }
            if (r6 >= r2) goto L_0x006d
            r4.rollBytes(r5, r2)     // Catch:{ all -> 0x00cc }
        L_0x006d:
            int r6 = r5.getInt()     // Catch:{ all -> 0x00cc }
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r6)     // Catch:{ all -> 0x00cc }
            r10.element = r6     // Catch:{ all -> 0x00cc }
            r4.bytesRead(r5, r7, r2)     // Catch:{ all -> 0x00cc }
            r6 = r3
            goto L_0x0056
        L_0x007c:
            if (r6 == 0) goto L_0x009a
            java.lang.Object r0 = r10.element
            if (r0 != 0) goto L_0x0089
            java.lang.String r10 = "result"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r10)
            r10 = 0
            goto L_0x008d
        L_0x0089:
            java.lang.Object r10 = r10.element
            java.lang.Number r10 = (java.lang.Number) r10
        L_0x008d:
            int r10 = r10.intValue()
            float r10 = java.lang.Float.intBitsToFloat(r10)
            java.lang.Float r10 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r10)
            return r10
        L_0x009a:
            r0.L$0 = r4
            r0.I$0 = r2
            r0.label = r3
            java.lang.Object r10 = r4.readSuspend(r2, r0)
            if (r10 != r1) goto L_0x00a7
            return r1
        L_0x00a7:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto L_0x00b0
            goto L_0x003f
        L_0x00b0:
            kotlinx.coroutines.channels.ClosedReceiveChannelException r10 = new kotlinx.coroutines.channels.ClosedReceiveChannelException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "EOF while "
            r0.append(r1)
            r0.append(r2)
            java.lang.String r1 = " bytes expected"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r10.<init>(r0)
            throw r10
        L_0x00cc:
            r10 = move-exception
            r4.restoreStateAfterRead()
            r4.tryTerminate$ktor_io()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.readFloat(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object readDouble(kotlin.coroutines.Continuation<? super java.lang.Double> r11) {
        /*
            r10 = this;
            boolean r0 = r11 instanceof io.ktor.utils.io.ByteBufferChannel$readDouble$1
            if (r0 == 0) goto L_0x0014
            r0 = r11
            io.ktor.utils.io.ByteBufferChannel$readDouble$1 r0 = (io.ktor.utils.io.ByteBufferChannel$readDouble$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L_0x0019
        L_0x0014:
            io.ktor.utils.io.ByteBufferChannel$readDouble$1 r0 = new io.ktor.utils.io.ByteBufferChannel$readDouble$1
            r0.<init>(r10, r11)
        L_0x0019:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0039
            if (r2 != r3) goto L_0x0031
            int r2 = r0.I$0
            java.lang.Object r4 = r0.L$0
            io.ktor.utils.io.ByteBufferChannel r4 = (io.ktor.utils.io.ByteBufferChannel) r4
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x00a8
        L_0x0031:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L_0x0039:
            kotlin.ResultKt.throwOnFailure(r11)
            r11 = 8
            r4 = r10
            r2 = r11
        L_0x0040:
            kotlin.jvm.internal.Ref$ObjectRef r11 = new kotlin.jvm.internal.Ref$ObjectRef
            r11.<init>()
            java.nio.ByteBuffer r5 = r4.setupStateForRead()
            r6 = 0
            if (r5 != 0) goto L_0x004d
            goto L_0x007d
        L_0x004d:
            io.ktor.utils.io.internal.ReadWriteBufferState r7 = r4.getState()
            io.ktor.utils.io.internal.RingBufferCapacity r7 = r7.capacity
            int r8 = r7._availableForRead$internal     // Catch:{ all -> 0x00cd }
            if (r8 != 0) goto L_0x005e
        L_0x0057:
            r4.restoreStateAfterRead()
            r4.tryTerminate$ktor_io()
            goto L_0x007d
        L_0x005e:
            boolean r8 = r7.tryReadExact(r2)     // Catch:{ all -> 0x00cd }
            if (r8 != 0) goto L_0x0065
            goto L_0x0057
        L_0x0065:
            int r6 = r5.remaining()     // Catch:{ all -> 0x00cd }
            if (r6 >= r2) goto L_0x006e
            r4.rollBytes(r5, r2)     // Catch:{ all -> 0x00cd }
        L_0x006e:
            long r8 = r5.getLong()     // Catch:{ all -> 0x00cd }
            java.lang.Long r6 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r8)     // Catch:{ all -> 0x00cd }
            r11.element = r6     // Catch:{ all -> 0x00cd }
            r4.bytesRead(r5, r7, r2)     // Catch:{ all -> 0x00cd }
            r6 = r3
            goto L_0x0057
        L_0x007d:
            if (r6 == 0) goto L_0x009b
            java.lang.Object r0 = r11.element
            if (r0 != 0) goto L_0x008a
            java.lang.String r11 = "result"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r11)
            r11 = 0
            goto L_0x008e
        L_0x008a:
            java.lang.Object r11 = r11.element
            java.lang.Number r11 = (java.lang.Number) r11
        L_0x008e:
            long r0 = r11.longValue()
            double r0 = java.lang.Double.longBitsToDouble(r0)
            java.lang.Double r11 = kotlin.coroutines.jvm.internal.Boxing.boxDouble(r0)
            return r11
        L_0x009b:
            r0.L$0 = r4
            r0.I$0 = r2
            r0.label = r3
            java.lang.Object r11 = r4.readSuspend(r2, r0)
            if (r11 != r1) goto L_0x00a8
            return r1
        L_0x00a8:
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r11 = r11.booleanValue()
            if (r11 == 0) goto L_0x00b1
            goto L_0x0040
        L_0x00b1:
            kotlinx.coroutines.channels.ClosedReceiveChannelException r11 = new kotlinx.coroutines.channels.ClosedReceiveChannelException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "EOF while "
            r0.append(r1)
            r0.append(r2)
            java.lang.String r1 = " bytes expected"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r11.<init>(r0)
            throw r11
        L_0x00cd:
            r11 = move-exception
            r4.restoreStateAfterRead()
            r4.tryTerminate$ktor_io()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.readDouble(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final void rollBytes(ByteBuffer byteBuffer, int i) {
        int remaining = byteBuffer.remaining();
        byteBuffer.limit(byteBuffer.position() + i);
        int i2 = i - remaining;
        for (int i3 = 0; i3 < i2; i3++) {
            byteBuffer.put(byteBuffer.capacity() + ReservedLongIndex + i3, byteBuffer.get(i3));
        }
    }

    private final void carry(ByteBuffer byteBuffer) {
        int capacity = byteBuffer.capacity() - this.reservedSize;
        int position = byteBuffer.position();
        for (int i = capacity; i < position; i++) {
            byteBuffer.put(i - capacity, byteBuffer.get(i));
        }
    }

    public final void bytesWrittenFromSession$ktor_io(ByteBuffer byteBuffer, RingBufferCapacity ringBufferCapacity, int i) {
        Intrinsics.checkNotNullParameter(byteBuffer, "buffer");
        Intrinsics.checkNotNullParameter(ringBufferCapacity, "capacity");
        bytesWritten(byteBuffer, ringBufferCapacity, i);
    }

    private final void bytesWritten(ByteBuffer byteBuffer, RingBufferCapacity ringBufferCapacity, int i) {
        if (i >= 0) {
            this.writePosition = carryIndex(byteBuffer, this.writePosition + i);
            ringBufferCapacity.completeWrite(i);
            setTotalBytesWritten$ktor_io(getTotalBytesWritten() + ((long) i));
            return;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    private final void bytesRead(ByteBuffer byteBuffer, RingBufferCapacity ringBufferCapacity, int i) {
        if (i >= 0) {
            this.readPosition = carryIndex(byteBuffer, this.readPosition + i);
            ringBufferCapacity.completeRead(i);
            setTotalBytesRead$ktor_io(getTotalBytesRead() + ((long) i));
            resumeWriteOp();
            return;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = resolveDelegation(r1, r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final io.ktor.utils.io.ByteBufferChannel resolveChannelInstance$ktor_io() {
        /*
            r1 = this;
            io.ktor.utils.io.internal.JoiningState r0 = r1.joining
            if (r0 == 0) goto L_0x000a
            io.ktor.utils.io.ByteBufferChannel r0 = r1.resolveDelegation(r1, r0)
            if (r0 != 0) goto L_0x000b
        L_0x000a:
            r0 = r1
        L_0x000b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.resolveChannelInstance$ktor_io():io.ktor.utils.io.ByteBufferChannel");
    }

    private final ByteBufferChannel resolveDelegation(ByteBufferChannel byteBufferChannel, JoiningState joiningState) {
        while (byteBufferChannel.getState() == ReadWriteBufferState.Terminated.INSTANCE) {
            byteBufferChannel = joiningState.getDelegatedTo();
            joiningState = byteBufferChannel.joining;
            if (joiningState == null) {
                return byteBufferChannel;
            }
        }
        return null;
    }

    private final Object delegateSuspend(JoiningState joiningState, Function1<? super ByteBufferChannel, Unit> function1, Continuation<? super Unit> continuation) {
        while (getState() != ReadWriteBufferState.Terminated.INSTANCE) {
            InlineMarker.mark(0);
            writeSuspend(1, continuation);
            InlineMarker.mark(1);
        }
        function1.invoke(joiningState.getDelegatedTo());
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00b2, code lost:
        if (r9.getState() != io.ktor.utils.io.internal.ReadWriteBufferState.Terminated.INSTANCE) goto L_0x00c7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00b4, code lost:
        r0.L$0 = null;
        r0.L$1 = null;
        r0.label = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00c4, code lost:
        if (r2.getDelegatedTo().writeByte((byte) r10, r0) != r1) goto L_0x01da;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00c6, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00c7, code lost:
        r0.L$0 = r2;
        r0.L$1 = r9;
        r0.B$0 = r10;
        r0.label = 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00d4, code lost:
        if (r9.writeSuspend(1, r0) != r1) goto L_0x00ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00d6, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:?, code lost:
        r0.L$0 = r7;
        r0.L$1 = r9;
        r0.L$2 = r2;
        r0.B$0 = r11;
        r0.I$0 = r10;
        r0.label = 5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0131, code lost:
        if (r9.writeSuspend(r10, r0) != r1) goto L_0x0134;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0133, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0136, code lost:
        if (r9.joining == null) goto L_0x0190;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0138, code lost:
        r9.restoreStateAfterWrite$ktor_io();
        r10 = r9.joining;
        kotlin.jvm.internal.Intrinsics.checkNotNull(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0146, code lost:
        if (r9.getState() != io.ktor.utils.io.internal.ReadWriteBufferState.Terminated.INSTANCE) goto L_0x015d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0148, code lost:
        r0.L$0 = null;
        r0.L$1 = null;
        r0.L$2 = null;
        r0.label = 6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x015a, code lost:
        if (r10.getDelegatedTo().writeByte((byte) r11, r0) != r1) goto L_0x01da;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x015c, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x015d, code lost:
        r2 = r10;
        r10 = r9;
        r9 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0166, code lost:
        if (r10.getState() != io.ktor.utils.io.internal.ReadWriteBufferState.Terminated.INSTANCE) goto L_0x017d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0168, code lost:
        r0.L$0 = null;
        r0.L$1 = null;
        r0.L$2 = null;
        r0.label = 7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x017a, code lost:
        if (r2.getDelegatedTo().writeByte((byte) r9, r0) != r1) goto L_0x01da;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x017c, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x017d, code lost:
        r0.L$0 = r2;
        r0.L$1 = r10;
        r0.L$2 = null;
        r0.B$0 = r9;
        r0.label = 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x018d, code lost:
        if (r10.writeSuspend(1, r0) != r1) goto L_0x0160;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x018f, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0194, code lost:
        if (r7.tryWriteExact(r10) != false) goto L_0x0198;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0196, code lost:
        r6 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0198, code lost:
        r9.prepareWriteBuffer$ktor_io(r2, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x019f, code lost:
        if (r2.remaining() >= r10) goto L_0x01b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01a1, code lost:
        r2.limit(r2.capacity());
        r2.put((byte) r11);
        r9.carry(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x01b0, code lost:
        r2.put((byte) r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x01b4, code lost:
        r9.bytesWritten(r2, r7, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x01bb, code lost:
        if (r7.isFull() != false) goto L_0x01c3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x01c1, code lost:
        if (r9.getAutoFlush() == false) goto L_0x01c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x01c3, code lost:
        r9.flush();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x01c6, code lost:
        r9.restoreStateAfterWrite$ktor_io();
        r9.tryTerminate$ktor_io();
        r6 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x01cd, code lost:
        if (r6 == false) goto L_0x0120;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x01d0, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x01d1, code lost:
        r6 = r9;
        r9 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x01dc, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ java.lang.Object writeByte$suspendImpl(io.ktor.utils.io.ByteBufferChannel r9, byte r10, kotlin.coroutines.Continuation r11) {
        /*
            boolean r0 = r11 instanceof io.ktor.utils.io.ByteBufferChannel$writeByte$1
            if (r0 == 0) goto L_0x0014
            r0 = r11
            io.ktor.utils.io.ByteBufferChannel$writeByte$1 r0 = (io.ktor.utils.io.ByteBufferChannel$writeByte$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L_0x0019
        L_0x0014:
            io.ktor.utils.io.ByteBufferChannel$writeByte$1 r0 = new io.ktor.utils.io.ByteBufferChannel$writeByte$1
            r0.<init>(r9, r11)
        L_0x0019:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            r5 = 0
            switch(r2) {
                case 0: goto L_0x006f;
                case 1: goto L_0x006a;
                case 2: goto L_0x006a;
                case 3: goto L_0x006a;
                case 4: goto L_0x0059;
                case 5: goto L_0x003e;
                case 6: goto L_0x006a;
                case 7: goto L_0x006a;
                case 8: goto L_0x002f;
                default: goto L_0x0027;
            }
        L_0x0027:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x002f:
            byte r9 = r0.B$0
            java.lang.Object r10 = r0.L$1
            io.ktor.utils.io.ByteBufferChannel r10 = (io.ktor.utils.io.ByteBufferChannel) r10
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.internal.JoiningState r2 = (io.ktor.utils.io.internal.JoiningState) r2
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x0160
        L_0x003e:
            int r9 = r0.I$0
            byte r10 = r0.B$0
            java.lang.Object r2 = r0.L$2
            java.nio.ByteBuffer r2 = (java.nio.ByteBuffer) r2
            java.lang.Object r6 = r0.L$1
            io.ktor.utils.io.ByteBufferChannel r6 = (io.ktor.utils.io.ByteBufferChannel) r6
            java.lang.Object r7 = r0.L$0
            io.ktor.utils.io.internal.RingBufferCapacity r7 = (io.ktor.utils.io.internal.RingBufferCapacity) r7
            kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ all -> 0x0056 }
            r11 = r10
            r10 = r9
            r9 = r6
            goto L_0x0134
        L_0x0056:
            r9 = move-exception
            goto L_0x01d3
        L_0x0059:
            byte r9 = r0.B$0
            java.lang.Object r10 = r0.L$1
            io.ktor.utils.io.ByteBufferChannel r10 = (io.ktor.utils.io.ByteBufferChannel) r10
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.internal.JoiningState r2 = (io.ktor.utils.io.internal.JoiningState) r2
            kotlin.ResultKt.throwOnFailure(r11)
            r8 = r10
            r10 = r9
            r9 = r8
            goto L_0x00ac
        L_0x006a:
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x01da
        L_0x006f:
            kotlin.ResultKt.throwOnFailure(r11)
            io.ktor.utils.io.internal.JoiningState r11 = r9.joining
            if (r11 == 0) goto L_0x0089
            io.ktor.utils.io.ByteBufferChannel r11 = r9.resolveDelegation(r9, r11)
            if (r11 == 0) goto L_0x0086
            byte r9 = (byte) r10
            r0.label = r4
            java.lang.Object r9 = r11.writeByte(r9, r0)
            if (r9 != r1) goto L_0x01da
            return r1
        L_0x0086:
            r11 = r5
            java.lang.Void r11 = (java.lang.Void) r11
        L_0x0089:
            java.nio.ByteBuffer r11 = r9.setupStateForWrite$ktor_io()
            if (r11 != 0) goto L_0x00d7
            io.ktor.utils.io.internal.JoiningState r11 = r9.joining
            kotlin.jvm.internal.Intrinsics.checkNotNull(r11)
            io.ktor.utils.io.internal.ReadWriteBufferState r2 = r9.getState()
            io.ktor.utils.io.internal.ReadWriteBufferState$Terminated r3 = io.ktor.utils.io.internal.ReadWriteBufferState.Terminated.INSTANCE
            if (r2 != r3) goto L_0x00ab
            io.ktor.utils.io.ByteBufferChannel r9 = r11.getDelegatedTo()
            byte r10 = (byte) r10
            r11 = 2
            r0.label = r11
            java.lang.Object r9 = r9.writeByte(r10, r0)
            if (r9 != r1) goto L_0x01da
            return r1
        L_0x00ab:
            r2 = r11
        L_0x00ac:
            io.ktor.utils.io.internal.ReadWriteBufferState r11 = r9.getState()
            io.ktor.utils.io.internal.ReadWriteBufferState$Terminated r3 = io.ktor.utils.io.internal.ReadWriteBufferState.Terminated.INSTANCE
            if (r11 != r3) goto L_0x00c7
            io.ktor.utils.io.ByteBufferChannel r9 = r2.getDelegatedTo()
            byte r10 = (byte) r10
            r0.L$0 = r5
            r0.L$1 = r5
            r11 = 3
            r0.label = r11
            java.lang.Object r9 = r9.writeByte(r10, r0)
            if (r9 != r1) goto L_0x01da
            return r1
        L_0x00c7:
            r0.L$0 = r2
            r0.L$1 = r9
            r0.B$0 = r10
            r11 = 4
            r0.label = r11
            java.lang.Object r11 = r9.writeSuspend(r4, r0)
            if (r11 != r1) goto L_0x00ac
            return r1
        L_0x00d7:
            io.ktor.utils.io.internal.ReadWriteBufferState r2 = r9.getState()
            io.ktor.utils.io.internal.RingBufferCapacity r2 = r2.capacity
            boolean r6 = r2.tryWriteExact(r4)
            if (r6 != 0) goto L_0x00e5
            r6 = r3
            goto L_0x011a
        L_0x00e5:
            r9.prepareWriteBuffer$ktor_io(r11, r4)
            int r6 = r11.remaining()
            if (r6 >= r4) goto L_0x00fd
            int r6 = r11.capacity()
            r11.limit(r6)
            byte r6 = (byte) r10
            r11.put(r6)
            r9.carry(r11)
            goto L_0x0101
        L_0x00fd:
            byte r6 = (byte) r10
            r11.put(r6)
        L_0x0101:
            r9.bytesWritten(r11, r2, r4)
            boolean r6 = r2.isFull()
            if (r6 != 0) goto L_0x0110
            boolean r6 = r9.getAutoFlush()
            if (r6 == 0) goto L_0x0113
        L_0x0110:
            r9.flush()
        L_0x0113:
            r9.restoreStateAfterWrite$ktor_io()
            r9.tryTerminate$ktor_io()
            r6 = r4
        L_0x011a:
            if (r6 != 0) goto L_0x01da
            r7 = r2
            r2 = r11
            r11 = r10
            r10 = r4
        L_0x0120:
            r0.L$0 = r7     // Catch:{ all -> 0x01d0 }
            r0.L$1 = r9     // Catch:{ all -> 0x01d0 }
            r0.L$2 = r2     // Catch:{ all -> 0x01d0 }
            r0.B$0 = r11     // Catch:{ all -> 0x01d0 }
            r0.I$0 = r10     // Catch:{ all -> 0x01d0 }
            r6 = 5
            r0.label = r6     // Catch:{ all -> 0x01d0 }
            java.lang.Object r6 = r9.writeSuspend(r10, r0)     // Catch:{ all -> 0x01d0 }
            if (r6 != r1) goto L_0x0134
            return r1
        L_0x0134:
            io.ktor.utils.io.internal.JoiningState r6 = r9.joining
            if (r6 == 0) goto L_0x0190
            r9.restoreStateAfterWrite$ktor_io()
            io.ktor.utils.io.internal.JoiningState r10 = r9.joining
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10)
            io.ktor.utils.io.internal.ReadWriteBufferState r2 = r9.getState()
            io.ktor.utils.io.internal.ReadWriteBufferState$Terminated r3 = io.ktor.utils.io.internal.ReadWriteBufferState.Terminated.INSTANCE
            if (r2 != r3) goto L_0x015d
            io.ktor.utils.io.ByteBufferChannel r9 = r10.getDelegatedTo()
            byte r10 = (byte) r11
            r0.L$0 = r5
            r0.L$1 = r5
            r0.L$2 = r5
            r11 = 6
            r0.label = r11
            java.lang.Object r9 = r9.writeByte(r10, r0)
            if (r9 != r1) goto L_0x01da
            return r1
        L_0x015d:
            r2 = r10
            r10 = r9
            r9 = r11
        L_0x0160:
            io.ktor.utils.io.internal.ReadWriteBufferState r11 = r10.getState()
            io.ktor.utils.io.internal.ReadWriteBufferState$Terminated r3 = io.ktor.utils.io.internal.ReadWriteBufferState.Terminated.INSTANCE
            if (r11 != r3) goto L_0x017d
            io.ktor.utils.io.ByteBufferChannel r10 = r2.getDelegatedTo()
            byte r9 = (byte) r9
            r0.L$0 = r5
            r0.L$1 = r5
            r0.L$2 = r5
            r11 = 7
            r0.label = r11
            java.lang.Object r9 = r10.writeByte(r9, r0)
            if (r9 != r1) goto L_0x01da
            return r1
        L_0x017d:
            r0.L$0 = r2
            r0.L$1 = r10
            r0.L$2 = r5
            r0.B$0 = r9
            r11 = 8
            r0.label = r11
            java.lang.Object r11 = r10.writeSuspend(r4, r0)
            if (r11 != r1) goto L_0x0160
            return r1
        L_0x0190:
            boolean r6 = r7.tryWriteExact(r10)
            if (r6 != 0) goto L_0x0198
            r6 = r3
            goto L_0x01cd
        L_0x0198:
            r9.prepareWriteBuffer$ktor_io(r2, r10)
            int r6 = r2.remaining()
            if (r6 >= r10) goto L_0x01b0
            int r6 = r2.capacity()
            r2.limit(r6)
            byte r6 = (byte) r11
            r2.put(r6)
            r9.carry(r2)
            goto L_0x01b4
        L_0x01b0:
            byte r6 = (byte) r11
            r2.put(r6)
        L_0x01b4:
            r9.bytesWritten(r2, r7, r10)
            boolean r6 = r7.isFull()
            if (r6 != 0) goto L_0x01c3
            boolean r6 = r9.getAutoFlush()
            if (r6 == 0) goto L_0x01c6
        L_0x01c3:
            r9.flush()
        L_0x01c6:
            r9.restoreStateAfterWrite$ktor_io()
            r9.tryTerminate$ktor_io()
            r6 = r4
        L_0x01cd:
            if (r6 == 0) goto L_0x0120
            goto L_0x01da
        L_0x01d0:
            r10 = move-exception
            r6 = r9
            r9 = r10
        L_0x01d3:
            r6.restoreStateAfterWrite$ktor_io()
            r6.tryTerminate$ktor_io()
            throw r9
        L_0x01da:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.writeByte$suspendImpl(io.ktor.utils.io.ByteBufferChannel, byte, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00b2, code lost:
        if (r9.getState() != io.ktor.utils.io.internal.ReadWriteBufferState.Terminated.INSTANCE) goto L_0x00c7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00b4, code lost:
        r0.L$0 = null;
        r0.L$1 = null;
        r0.label = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00c4, code lost:
        if (r2.getDelegatedTo().writeShort((short) r10, r0) != r1) goto L_0x01d9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00c6, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00c7, code lost:
        r0.L$0 = r2;
        r0.L$1 = r9;
        r0.S$0 = r10;
        r0.label = 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00d4, code lost:
        if (r9.writeSuspend(1, r0) != r1) goto L_0x00ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00d6, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:?, code lost:
        r0.L$0 = r7;
        r0.L$1 = r9;
        r0.L$2 = r2;
        r0.S$0 = r10;
        r0.I$0 = r4;
        r0.label = 5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x012f, code lost:
        if (r9.writeSuspend(r4, r0) != r1) goto L_0x0132;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0131, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0134, code lost:
        if (r9.joining == null) goto L_0x018f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0136, code lost:
        r9.restoreStateAfterWrite$ktor_io();
        r11 = r9.joining;
        kotlin.jvm.internal.Intrinsics.checkNotNull(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0144, code lost:
        if (r9.getState() != io.ktor.utils.io.internal.ReadWriteBufferState.Terminated.INSTANCE) goto L_0x015b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0146, code lost:
        r0.L$0 = null;
        r0.L$1 = null;
        r0.L$2 = null;
        r0.label = 6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0158, code lost:
        if (r11.getDelegatedTo().writeShort((short) r10, r0) != r1) goto L_0x01d9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x015a, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x015b, code lost:
        r2 = r11;
        r8 = r10;
        r10 = r9;
        r9 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0165, code lost:
        if (r10.getState() != io.ktor.utils.io.internal.ReadWriteBufferState.Terminated.INSTANCE) goto L_0x017c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0167, code lost:
        r0.L$0 = null;
        r0.L$1 = null;
        r0.L$2 = null;
        r0.label = 7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0179, code lost:
        if (r2.getDelegatedTo().writeShort((short) r9, r0) != r1) goto L_0x01d9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x017b, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x017c, code lost:
        r0.L$0 = r2;
        r0.L$1 = r10;
        r0.L$2 = null;
        r0.S$0 = r9;
        r0.label = 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x018c, code lost:
        if (r10.writeSuspend(1, r0) != r1) goto L_0x015f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x018e, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0193, code lost:
        if (r7.tryWriteExact(r4) != false) goto L_0x0197;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0195, code lost:
        r11 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0197, code lost:
        r9.prepareWriteBuffer$ktor_io(r2, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x019e, code lost:
        if (r2.remaining() >= r4) goto L_0x01af;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01a0, code lost:
        r2.limit(r2.capacity());
        r2.putShort((short) r10);
        r9.carry(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x01af, code lost:
        r2.putShort((short) r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x01b3, code lost:
        r9.bytesWritten(r2, r7, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x01ba, code lost:
        if (r7.isFull() != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x01c0, code lost:
        if (r9.getAutoFlush() == false) goto L_0x01c5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x01c2, code lost:
        r9.flush();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x01c5, code lost:
        r9.restoreStateAfterWrite$ktor_io();
        r9.tryTerminate$ktor_io();
        r11 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x01cc, code lost:
        if (r11 == false) goto L_0x011e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x01cf, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x01d0, code lost:
        r4 = r9;
        r9 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x01db, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0030  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ java.lang.Object writeShort$suspendImpl(io.ktor.utils.io.ByteBufferChannel r9, short r10, kotlin.coroutines.Continuation r11) {
        /*
            boolean r0 = r11 instanceof io.ktor.utils.io.ByteBufferChannel$writeShort$1
            if (r0 == 0) goto L_0x0014
            r0 = r11
            io.ktor.utils.io.ByteBufferChannel$writeShort$1 r0 = (io.ktor.utils.io.ByteBufferChannel$writeShort$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L_0x0019
        L_0x0014:
            io.ktor.utils.io.ByteBufferChannel$writeShort$1 r0 = new io.ktor.utils.io.ByteBufferChannel$writeShort$1
            r0.<init>(r9, r11)
        L_0x0019:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 2
            r5 = 1
            r6 = 0
            switch(r2) {
                case 0: goto L_0x0070;
                case 1: goto L_0x006b;
                case 2: goto L_0x006b;
                case 3: goto L_0x006b;
                case 4: goto L_0x005a;
                case 5: goto L_0x003f;
                case 6: goto L_0x006b;
                case 7: goto L_0x006b;
                case 8: goto L_0x0030;
                default: goto L_0x0028;
            }
        L_0x0028:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x0030:
            short r9 = r0.S$0
            java.lang.Object r10 = r0.L$1
            io.ktor.utils.io.ByteBufferChannel r10 = (io.ktor.utils.io.ByteBufferChannel) r10
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.internal.JoiningState r2 = (io.ktor.utils.io.internal.JoiningState) r2
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x015f
        L_0x003f:
            int r9 = r0.I$0
            short r10 = r0.S$0
            java.lang.Object r2 = r0.L$2
            java.nio.ByteBuffer r2 = (java.nio.ByteBuffer) r2
            java.lang.Object r4 = r0.L$1
            io.ktor.utils.io.ByteBufferChannel r4 = (io.ktor.utils.io.ByteBufferChannel) r4
            java.lang.Object r7 = r0.L$0
            io.ktor.utils.io.internal.RingBufferCapacity r7 = (io.ktor.utils.io.internal.RingBufferCapacity) r7
            kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ all -> 0x0057 }
            r8 = r4
            r4 = r9
            r9 = r8
            goto L_0x0132
        L_0x0057:
            r9 = move-exception
            goto L_0x01d2
        L_0x005a:
            short r9 = r0.S$0
            java.lang.Object r10 = r0.L$1
            io.ktor.utils.io.ByteBufferChannel r10 = (io.ktor.utils.io.ByteBufferChannel) r10
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.internal.JoiningState r2 = (io.ktor.utils.io.internal.JoiningState) r2
            kotlin.ResultKt.throwOnFailure(r11)
            r8 = r10
            r10 = r9
            r9 = r8
            goto L_0x00ac
        L_0x006b:
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x01d9
        L_0x0070:
            kotlin.ResultKt.throwOnFailure(r11)
            io.ktor.utils.io.internal.JoiningState r11 = r9.joining
            if (r11 == 0) goto L_0x008a
            io.ktor.utils.io.ByteBufferChannel r11 = r9.resolveDelegation(r9, r11)
            if (r11 == 0) goto L_0x0087
            short r9 = (short) r10
            r0.label = r5
            java.lang.Object r9 = r11.writeShort(r9, r0)
            if (r9 != r1) goto L_0x01d9
            return r1
        L_0x0087:
            r11 = r6
            java.lang.Void r11 = (java.lang.Void) r11
        L_0x008a:
            java.nio.ByteBuffer r11 = r9.setupStateForWrite$ktor_io()
            if (r11 != 0) goto L_0x00d7
            io.ktor.utils.io.internal.JoiningState r11 = r9.joining
            kotlin.jvm.internal.Intrinsics.checkNotNull(r11)
            io.ktor.utils.io.internal.ReadWriteBufferState r2 = r9.getState()
            io.ktor.utils.io.internal.ReadWriteBufferState$Terminated r3 = io.ktor.utils.io.internal.ReadWriteBufferState.Terminated.INSTANCE
            if (r2 != r3) goto L_0x00ab
            io.ktor.utils.io.ByteBufferChannel r9 = r11.getDelegatedTo()
            short r10 = (short) r10
            r0.label = r4
            java.lang.Object r9 = r9.writeShort(r10, r0)
            if (r9 != r1) goto L_0x01d9
            return r1
        L_0x00ab:
            r2 = r11
        L_0x00ac:
            io.ktor.utils.io.internal.ReadWriteBufferState r11 = r9.getState()
            io.ktor.utils.io.internal.ReadWriteBufferState$Terminated r3 = io.ktor.utils.io.internal.ReadWriteBufferState.Terminated.INSTANCE
            if (r11 != r3) goto L_0x00c7
            io.ktor.utils.io.ByteBufferChannel r9 = r2.getDelegatedTo()
            short r10 = (short) r10
            r0.L$0 = r6
            r0.L$1 = r6
            r11 = 3
            r0.label = r11
            java.lang.Object r9 = r9.writeShort(r10, r0)
            if (r9 != r1) goto L_0x01d9
            return r1
        L_0x00c7:
            r0.L$0 = r2
            r0.L$1 = r9
            r0.S$0 = r10
            r11 = 4
            r0.label = r11
            java.lang.Object r11 = r9.writeSuspend(r5, r0)
            if (r11 != r1) goto L_0x00ac
            return r1
        L_0x00d7:
            io.ktor.utils.io.internal.ReadWriteBufferState r2 = r9.getState()
            io.ktor.utils.io.internal.RingBufferCapacity r2 = r2.capacity
            boolean r7 = r2.tryWriteExact(r4)
            if (r7 != 0) goto L_0x00e5
            r7 = r3
            goto L_0x011a
        L_0x00e5:
            r9.prepareWriteBuffer$ktor_io(r11, r4)
            int r7 = r11.remaining()
            if (r7 >= r4) goto L_0x00fd
            int r7 = r11.capacity()
            r11.limit(r7)
            short r7 = (short) r10
            r11.putShort(r7)
            r9.carry(r11)
            goto L_0x0101
        L_0x00fd:
            short r7 = (short) r10
            r11.putShort(r7)
        L_0x0101:
            r9.bytesWritten(r11, r2, r4)
            boolean r7 = r2.isFull()
            if (r7 != 0) goto L_0x0110
            boolean r7 = r9.getAutoFlush()
            if (r7 == 0) goto L_0x0113
        L_0x0110:
            r9.flush()
        L_0x0113:
            r9.restoreStateAfterWrite$ktor_io()
            r9.tryTerminate$ktor_io()
            r7 = r5
        L_0x011a:
            if (r7 != 0) goto L_0x01d9
            r7 = r2
            r2 = r11
        L_0x011e:
            r0.L$0 = r7     // Catch:{ all -> 0x01cf }
            r0.L$1 = r9     // Catch:{ all -> 0x01cf }
            r0.L$2 = r2     // Catch:{ all -> 0x01cf }
            r0.S$0 = r10     // Catch:{ all -> 0x01cf }
            r0.I$0 = r4     // Catch:{ all -> 0x01cf }
            r11 = 5
            r0.label = r11     // Catch:{ all -> 0x01cf }
            java.lang.Object r11 = r9.writeSuspend(r4, r0)     // Catch:{ all -> 0x01cf }
            if (r11 != r1) goto L_0x0132
            return r1
        L_0x0132:
            io.ktor.utils.io.internal.JoiningState r11 = r9.joining
            if (r11 == 0) goto L_0x018f
            r9.restoreStateAfterWrite$ktor_io()
            io.ktor.utils.io.internal.JoiningState r11 = r9.joining
            kotlin.jvm.internal.Intrinsics.checkNotNull(r11)
            io.ktor.utils.io.internal.ReadWriteBufferState r2 = r9.getState()
            io.ktor.utils.io.internal.ReadWriteBufferState$Terminated r3 = io.ktor.utils.io.internal.ReadWriteBufferState.Terminated.INSTANCE
            if (r2 != r3) goto L_0x015b
            io.ktor.utils.io.ByteBufferChannel r9 = r11.getDelegatedTo()
            short r10 = (short) r10
            r0.L$0 = r6
            r0.L$1 = r6
            r0.L$2 = r6
            r11 = 6
            r0.label = r11
            java.lang.Object r9 = r9.writeShort(r10, r0)
            if (r9 != r1) goto L_0x01d9
            return r1
        L_0x015b:
            r2 = r11
            r8 = r10
            r10 = r9
            r9 = r8
        L_0x015f:
            io.ktor.utils.io.internal.ReadWriteBufferState r11 = r10.getState()
            io.ktor.utils.io.internal.ReadWriteBufferState$Terminated r3 = io.ktor.utils.io.internal.ReadWriteBufferState.Terminated.INSTANCE
            if (r11 != r3) goto L_0x017c
            io.ktor.utils.io.ByteBufferChannel r10 = r2.getDelegatedTo()
            short r9 = (short) r9
            r0.L$0 = r6
            r0.L$1 = r6
            r0.L$2 = r6
            r11 = 7
            r0.label = r11
            java.lang.Object r9 = r10.writeShort(r9, r0)
            if (r9 != r1) goto L_0x01d9
            return r1
        L_0x017c:
            r0.L$0 = r2
            r0.L$1 = r10
            r0.L$2 = r6
            r0.S$0 = r9
            r11 = 8
            r0.label = r11
            java.lang.Object r11 = r10.writeSuspend(r5, r0)
            if (r11 != r1) goto L_0x015f
            return r1
        L_0x018f:
            boolean r11 = r7.tryWriteExact(r4)
            if (r11 != 0) goto L_0x0197
            r11 = r3
            goto L_0x01cc
        L_0x0197:
            r9.prepareWriteBuffer$ktor_io(r2, r4)
            int r11 = r2.remaining()
            if (r11 >= r4) goto L_0x01af
            int r11 = r2.capacity()
            r2.limit(r11)
            short r11 = (short) r10
            r2.putShort(r11)
            r9.carry(r2)
            goto L_0x01b3
        L_0x01af:
            short r11 = (short) r10
            r2.putShort(r11)
        L_0x01b3:
            r9.bytesWritten(r2, r7, r4)
            boolean r11 = r7.isFull()
            if (r11 != 0) goto L_0x01c2
            boolean r11 = r9.getAutoFlush()
            if (r11 == 0) goto L_0x01c5
        L_0x01c2:
            r9.flush()
        L_0x01c5:
            r9.restoreStateAfterWrite$ktor_io()
            r9.tryTerminate$ktor_io()
            r11 = r5
        L_0x01cc:
            if (r11 == 0) goto L_0x011e
            goto L_0x01d9
        L_0x01cf:
            r10 = move-exception
            r4 = r9
            r9 = r10
        L_0x01d2:
            r4.restoreStateAfterWrite$ktor_io()
            r4.tryTerminate$ktor_io()
            throw r9
        L_0x01d9:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.writeShort$suspendImpl(io.ktor.utils.io.ByteBufferChannel, short, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00b1, code lost:
        if (r9.getState() != io.ktor.utils.io.internal.ReadWriteBufferState.Terminated.INSTANCE) goto L_0x00c5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00b3, code lost:
        r9 = r2.getDelegatedTo();
        r0.L$0 = null;
        r0.L$1 = null;
        r0.label = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00c2, code lost:
        if (r9.writeInt(r10, r0) != r1) goto L_0x01d0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00c4, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00c5, code lost:
        r0.L$0 = r2;
        r0.L$1 = r9;
        r0.I$0 = r10;
        r0.label = 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00d1, code lost:
        if (r9.writeSuspend(1, r0) != r1) goto L_0x00ab;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00d3, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:?, code lost:
        r0.L$0 = r7;
        r0.L$1 = r9;
        r0.L$2 = r2;
        r0.I$0 = r10;
        r0.I$1 = r4;
        r0.label = 5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x012a, code lost:
        if (r9.writeSuspend(r4, r0) != r1) goto L_0x012d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x012c, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x012f, code lost:
        if (r9.joining == null) goto L_0x0188;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0131, code lost:
        r9.restoreStateAfterWrite$ktor_io();
        r11 = r9.joining;
        kotlin.jvm.internal.Intrinsics.checkNotNull(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x013f, code lost:
        if (r9.getState() != io.ktor.utils.io.internal.ReadWriteBufferState.Terminated.INSTANCE) goto L_0x0155;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0141, code lost:
        r9 = r11.getDelegatedTo();
        r0.L$0 = null;
        r0.L$1 = null;
        r0.L$2 = null;
        r0.label = 6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0152, code lost:
        if (r9.writeInt(r10, r0) != r1) goto L_0x01d0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0154, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0155, code lost:
        r2 = r11;
        r8 = r10;
        r10 = r9;
        r9 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x015f, code lost:
        if (r10.getState() != io.ktor.utils.io.internal.ReadWriteBufferState.Terminated.INSTANCE) goto L_0x0175;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0161, code lost:
        r10 = r2.getDelegatedTo();
        r0.L$0 = null;
        r0.L$1 = null;
        r0.L$2 = null;
        r0.label = 7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0172, code lost:
        if (r10.writeInt(r9, r0) != r1) goto L_0x01d0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0174, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0175, code lost:
        r0.L$0 = r2;
        r0.L$1 = r10;
        r0.L$2 = null;
        r0.I$0 = r9;
        r0.label = 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0185, code lost:
        if (r10.writeSuspend(1, r0) != r1) goto L_0x0159;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0187, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x018c, code lost:
        if (r7.tryWriteExact(r4) != false) goto L_0x0190;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x018e, code lost:
        r11 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0190, code lost:
        r9.prepareWriteBuffer$ktor_io(r2, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0197, code lost:
        if (r2.remaining() >= r4) goto L_0x01a7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0199, code lost:
        r2.limit(r2.capacity());
        r2.putInt(r10);
        r9.carry(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x01a7, code lost:
        r2.putInt(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x01aa, code lost:
        r9.bytesWritten(r2, r7, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x01b1, code lost:
        if (r7.isFull() != false) goto L_0x01b9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x01b7, code lost:
        if (r9.getAutoFlush() == false) goto L_0x01bc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x01b9, code lost:
        r9.flush();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x01bc, code lost:
        r9.restoreStateAfterWrite$ktor_io();
        r9.tryTerminate$ktor_io();
        r11 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x01c3, code lost:
        if (r11 == false) goto L_0x0119;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x01c6, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x01c7, code lost:
        r4 = r9;
        r9 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x01d2, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0030  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ java.lang.Object writeInt$suspendImpl(io.ktor.utils.io.ByteBufferChannel r9, int r10, kotlin.coroutines.Continuation r11) {
        /*
            boolean r0 = r11 instanceof io.ktor.utils.io.ByteBufferChannel$writeInt$1
            if (r0 == 0) goto L_0x0014
            r0 = r11
            io.ktor.utils.io.ByteBufferChannel$writeInt$1 r0 = (io.ktor.utils.io.ByteBufferChannel$writeInt$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L_0x0019
        L_0x0014:
            io.ktor.utils.io.ByteBufferChannel$writeInt$1 r0 = new io.ktor.utils.io.ByteBufferChannel$writeInt$1
            r0.<init>(r9, r11)
        L_0x0019:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 4
            r5 = 1
            r6 = 0
            switch(r2) {
                case 0: goto L_0x0070;
                case 1: goto L_0x006b;
                case 2: goto L_0x006b;
                case 3: goto L_0x006b;
                case 4: goto L_0x005a;
                case 5: goto L_0x003f;
                case 6: goto L_0x006b;
                case 7: goto L_0x006b;
                case 8: goto L_0x0030;
                default: goto L_0x0028;
            }
        L_0x0028:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x0030:
            int r9 = r0.I$0
            java.lang.Object r10 = r0.L$1
            io.ktor.utils.io.ByteBufferChannel r10 = (io.ktor.utils.io.ByteBufferChannel) r10
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.internal.JoiningState r2 = (io.ktor.utils.io.internal.JoiningState) r2
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x0159
        L_0x003f:
            int r9 = r0.I$1
            int r10 = r0.I$0
            java.lang.Object r2 = r0.L$2
            java.nio.ByteBuffer r2 = (java.nio.ByteBuffer) r2
            java.lang.Object r4 = r0.L$1
            io.ktor.utils.io.ByteBufferChannel r4 = (io.ktor.utils.io.ByteBufferChannel) r4
            java.lang.Object r7 = r0.L$0
            io.ktor.utils.io.internal.RingBufferCapacity r7 = (io.ktor.utils.io.internal.RingBufferCapacity) r7
            kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ all -> 0x0057 }
            r8 = r4
            r4 = r9
            r9 = r8
            goto L_0x012d
        L_0x0057:
            r9 = move-exception
            goto L_0x01c9
        L_0x005a:
            int r9 = r0.I$0
            java.lang.Object r10 = r0.L$1
            io.ktor.utils.io.ByteBufferChannel r10 = (io.ktor.utils.io.ByteBufferChannel) r10
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.internal.JoiningState r2 = (io.ktor.utils.io.internal.JoiningState) r2
            kotlin.ResultKt.throwOnFailure(r11)
            r8 = r10
            r10 = r9
            r9 = r8
            goto L_0x00ab
        L_0x006b:
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x01d0
        L_0x0070:
            kotlin.ResultKt.throwOnFailure(r11)
            io.ktor.utils.io.internal.JoiningState r11 = r9.joining
            if (r11 == 0) goto L_0x0089
            io.ktor.utils.io.ByteBufferChannel r11 = r9.resolveDelegation(r9, r11)
            if (r11 == 0) goto L_0x0086
            r0.label = r5
            java.lang.Object r9 = r11.writeInt(r10, r0)
            if (r9 != r1) goto L_0x01d0
            return r1
        L_0x0086:
            r11 = r6
            java.lang.Void r11 = (java.lang.Void) r11
        L_0x0089:
            java.nio.ByteBuffer r11 = r9.setupStateForWrite$ktor_io()
            if (r11 != 0) goto L_0x00d4
            io.ktor.utils.io.internal.JoiningState r11 = r9.joining
            kotlin.jvm.internal.Intrinsics.checkNotNull(r11)
            io.ktor.utils.io.internal.ReadWriteBufferState r2 = r9.getState()
            io.ktor.utils.io.internal.ReadWriteBufferState$Terminated r3 = io.ktor.utils.io.internal.ReadWriteBufferState.Terminated.INSTANCE
            if (r2 != r3) goto L_0x00aa
            io.ktor.utils.io.ByteBufferChannel r9 = r11.getDelegatedTo()
            r11 = 2
            r0.label = r11
            java.lang.Object r9 = r9.writeInt(r10, r0)
            if (r9 != r1) goto L_0x01d0
            return r1
        L_0x00aa:
            r2 = r11
        L_0x00ab:
            io.ktor.utils.io.internal.ReadWriteBufferState r11 = r9.getState()
            io.ktor.utils.io.internal.ReadWriteBufferState$Terminated r3 = io.ktor.utils.io.internal.ReadWriteBufferState.Terminated.INSTANCE
            if (r11 != r3) goto L_0x00c5
            io.ktor.utils.io.ByteBufferChannel r9 = r2.getDelegatedTo()
            r0.L$0 = r6
            r0.L$1 = r6
            r11 = 3
            r0.label = r11
            java.lang.Object r9 = r9.writeInt(r10, r0)
            if (r9 != r1) goto L_0x01d0
            return r1
        L_0x00c5:
            r0.L$0 = r2
            r0.L$1 = r9
            r0.I$0 = r10
            r0.label = r4
            java.lang.Object r11 = r9.writeSuspend(r5, r0)
            if (r11 != r1) goto L_0x00ab
            return r1
        L_0x00d4:
            io.ktor.utils.io.internal.ReadWriteBufferState r2 = r9.getState()
            io.ktor.utils.io.internal.RingBufferCapacity r2 = r2.capacity
            boolean r7 = r2.tryWriteExact(r4)
            if (r7 != 0) goto L_0x00e2
            r7 = r3
            goto L_0x0115
        L_0x00e2:
            r9.prepareWriteBuffer$ktor_io(r11, r4)
            int r7 = r11.remaining()
            if (r7 >= r4) goto L_0x00f9
            int r7 = r11.capacity()
            r11.limit(r7)
            r11.putInt(r10)
            r9.carry(r11)
            goto L_0x00fc
        L_0x00f9:
            r11.putInt(r10)
        L_0x00fc:
            r9.bytesWritten(r11, r2, r4)
            boolean r7 = r2.isFull()
            if (r7 != 0) goto L_0x010b
            boolean r7 = r9.getAutoFlush()
            if (r7 == 0) goto L_0x010e
        L_0x010b:
            r9.flush()
        L_0x010e:
            r9.restoreStateAfterWrite$ktor_io()
            r9.tryTerminate$ktor_io()
            r7 = r5
        L_0x0115:
            if (r7 != 0) goto L_0x01d0
            r7 = r2
            r2 = r11
        L_0x0119:
            r0.L$0 = r7     // Catch:{ all -> 0x01c6 }
            r0.L$1 = r9     // Catch:{ all -> 0x01c6 }
            r0.L$2 = r2     // Catch:{ all -> 0x01c6 }
            r0.I$0 = r10     // Catch:{ all -> 0x01c6 }
            r0.I$1 = r4     // Catch:{ all -> 0x01c6 }
            r11 = 5
            r0.label = r11     // Catch:{ all -> 0x01c6 }
            java.lang.Object r11 = r9.writeSuspend(r4, r0)     // Catch:{ all -> 0x01c6 }
            if (r11 != r1) goto L_0x012d
            return r1
        L_0x012d:
            io.ktor.utils.io.internal.JoiningState r11 = r9.joining
            if (r11 == 0) goto L_0x0188
            r9.restoreStateAfterWrite$ktor_io()
            io.ktor.utils.io.internal.JoiningState r11 = r9.joining
            kotlin.jvm.internal.Intrinsics.checkNotNull(r11)
            io.ktor.utils.io.internal.ReadWriteBufferState r2 = r9.getState()
            io.ktor.utils.io.internal.ReadWriteBufferState$Terminated r3 = io.ktor.utils.io.internal.ReadWriteBufferState.Terminated.INSTANCE
            if (r2 != r3) goto L_0x0155
            io.ktor.utils.io.ByteBufferChannel r9 = r11.getDelegatedTo()
            r0.L$0 = r6
            r0.L$1 = r6
            r0.L$2 = r6
            r11 = 6
            r0.label = r11
            java.lang.Object r9 = r9.writeInt(r10, r0)
            if (r9 != r1) goto L_0x01d0
            return r1
        L_0x0155:
            r2 = r11
            r8 = r10
            r10 = r9
            r9 = r8
        L_0x0159:
            io.ktor.utils.io.internal.ReadWriteBufferState r11 = r10.getState()
            io.ktor.utils.io.internal.ReadWriteBufferState$Terminated r3 = io.ktor.utils.io.internal.ReadWriteBufferState.Terminated.INSTANCE
            if (r11 != r3) goto L_0x0175
            io.ktor.utils.io.ByteBufferChannel r10 = r2.getDelegatedTo()
            r0.L$0 = r6
            r0.L$1 = r6
            r0.L$2 = r6
            r11 = 7
            r0.label = r11
            java.lang.Object r9 = r10.writeInt(r9, r0)
            if (r9 != r1) goto L_0x01d0
            return r1
        L_0x0175:
            r0.L$0 = r2
            r0.L$1 = r10
            r0.L$2 = r6
            r0.I$0 = r9
            r11 = 8
            r0.label = r11
            java.lang.Object r11 = r10.writeSuspend(r5, r0)
            if (r11 != r1) goto L_0x0159
            return r1
        L_0x0188:
            boolean r11 = r7.tryWriteExact(r4)
            if (r11 != 0) goto L_0x0190
            r11 = r3
            goto L_0x01c3
        L_0x0190:
            r9.prepareWriteBuffer$ktor_io(r2, r4)
            int r11 = r2.remaining()
            if (r11 >= r4) goto L_0x01a7
            int r11 = r2.capacity()
            r2.limit(r11)
            r2.putInt(r10)
            r9.carry(r2)
            goto L_0x01aa
        L_0x01a7:
            r2.putInt(r10)
        L_0x01aa:
            r9.bytesWritten(r2, r7, r4)
            boolean r11 = r7.isFull()
            if (r11 != 0) goto L_0x01b9
            boolean r11 = r9.getAutoFlush()
            if (r11 == 0) goto L_0x01bc
        L_0x01b9:
            r9.flush()
        L_0x01bc:
            r9.restoreStateAfterWrite$ktor_io()
            r9.tryTerminate$ktor_io()
            r11 = r5
        L_0x01c3:
            if (r11 == 0) goto L_0x0119
            goto L_0x01d0
        L_0x01c6:
            r10 = move-exception
            r4 = r9
            r9 = r10
        L_0x01c9:
            r4.restoreStateAfterWrite$ktor_io()
            r4.tryTerminate$ktor_io()
            throw r9
        L_0x01d0:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.writeInt$suspendImpl(io.ktor.utils.io.ByteBufferChannel, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00b2, code lost:
        if (r11.getState() != io.ktor.utils.io.internal.ReadWriteBufferState.Terminated.INSTANCE) goto L_0x00c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00b4, code lost:
        r11 = r2.getDelegatedTo();
        r0.L$0 = null;
        r0.L$1 = null;
        r0.label = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00c3, code lost:
        if (r11.writeLong(r12, r0) != r1) goto L_0x01d2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00c5, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00c6, code lost:
        r0.L$0 = r2;
        r0.L$1 = r11;
        r0.J$0 = r12;
        r0.label = 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00d3, code lost:
        if (r11.writeSuspend(1, r0) != r1) goto L_0x00ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00d5, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:?, code lost:
        r0.L$0 = r8;
        r0.L$1 = r11;
        r0.L$2 = r2;
        r0.J$0 = r13;
        r0.I$0 = r12;
        r0.label = 5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x012e, code lost:
        if (r11.writeSuspend(r12, r0) != r1) goto L_0x0131;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0130, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0133, code lost:
        if (r11.joining == null) goto L_0x018a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0135, code lost:
        r11.restoreStateAfterWrite$ktor_io();
        r12 = r11.joining;
        kotlin.jvm.internal.Intrinsics.checkNotNull(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0143, code lost:
        if (r11.getState() != io.ktor.utils.io.internal.ReadWriteBufferState.Terminated.INSTANCE) goto L_0x0159;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0145, code lost:
        r11 = r12.getDelegatedTo();
        r0.L$0 = null;
        r0.L$1 = null;
        r0.L$2 = null;
        r0.label = 6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0156, code lost:
        if (r11.writeLong(r13, r0) != r1) goto L_0x01d2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0158, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0159, code lost:
        r2 = r12;
        r9 = r13;
        r13 = r11;
        r11 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0163, code lost:
        if (r13.getState() != io.ktor.utils.io.internal.ReadWriteBufferState.Terminated.INSTANCE) goto L_0x0179;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0165, code lost:
        r13 = r2.getDelegatedTo();
        r0.L$0 = null;
        r0.L$1 = null;
        r0.L$2 = null;
        r0.label = 7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0176, code lost:
        if (r13.writeLong(r11, r0) != r1) goto L_0x01d2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0178, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0179, code lost:
        r0.L$0 = r2;
        r0.L$1 = r13;
        r0.L$2 = null;
        r0.J$0 = r11;
        r0.label = 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0187, code lost:
        if (r13.writeSuspend(1, r0) != r1) goto L_0x015d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0189, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x018e, code lost:
        if (r8.tryWriteExact(r12) != false) goto L_0x0192;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0190, code lost:
        r7 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0192, code lost:
        r11.prepareWriteBuffer$ktor_io(r2, r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0199, code lost:
        if (r2.remaining() >= r12) goto L_0x01a9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x019b, code lost:
        r2.limit(r2.capacity());
        r2.putLong(r13);
        r11.carry(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x01a9, code lost:
        r2.putLong(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x01ac, code lost:
        r11.bytesWritten(r2, r8, r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x01b3, code lost:
        if (r8.isFull() != false) goto L_0x01bb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x01b9, code lost:
        if (r11.getAutoFlush() == false) goto L_0x01be;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x01bb, code lost:
        r11.flush();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x01be, code lost:
        r11.restoreStateAfterWrite$ktor_io();
        r11.tryTerminate$ktor_io();
        r7 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x01c5, code lost:
        if (r7 == false) goto L_0x011d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x01c8, code lost:
        r12 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x01c9, code lost:
        r7 = r11;
        r11 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x01d4, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ java.lang.Object writeLong$suspendImpl(io.ktor.utils.io.ByteBufferChannel r11, long r12, kotlin.coroutines.Continuation r14) {
        /*
            boolean r0 = r14 instanceof io.ktor.utils.io.ByteBufferChannel$writeLong$1
            if (r0 == 0) goto L_0x0014
            r0 = r14
            io.ktor.utils.io.ByteBufferChannel$writeLong$1 r0 = (io.ktor.utils.io.ByteBufferChannel$writeLong$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r14 = r0.label
            int r14 = r14 - r2
            r0.label = r14
            goto L_0x0019
        L_0x0014:
            io.ktor.utils.io.ByteBufferChannel$writeLong$1 r0 = new io.ktor.utils.io.ByteBufferChannel$writeLong$1
            r0.<init>(r11, r14)
        L_0x0019:
            java.lang.Object r14 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 8
            r5 = 1
            r6 = 0
            switch(r2) {
                case 0: goto L_0x0071;
                case 1: goto L_0x006c;
                case 2: goto L_0x006c;
                case 3: goto L_0x006c;
                case 4: goto L_0x005b;
                case 5: goto L_0x0040;
                case 6: goto L_0x006c;
                case 7: goto L_0x006c;
                case 8: goto L_0x0031;
                default: goto L_0x0029;
            }
        L_0x0029:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x0031:
            long r11 = r0.J$0
            java.lang.Object r13 = r0.L$1
            io.ktor.utils.io.ByteBufferChannel r13 = (io.ktor.utils.io.ByteBufferChannel) r13
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.internal.JoiningState r2 = (io.ktor.utils.io.internal.JoiningState) r2
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x015d
        L_0x0040:
            int r11 = r0.I$0
            long r12 = r0.J$0
            java.lang.Object r2 = r0.L$2
            java.nio.ByteBuffer r2 = (java.nio.ByteBuffer) r2
            java.lang.Object r7 = r0.L$1
            io.ktor.utils.io.ByteBufferChannel r7 = (io.ktor.utils.io.ByteBufferChannel) r7
            java.lang.Object r8 = r0.L$0
            io.ktor.utils.io.internal.RingBufferCapacity r8 = (io.ktor.utils.io.internal.RingBufferCapacity) r8
            kotlin.ResultKt.throwOnFailure(r14)     // Catch:{ all -> 0x0058 }
            r13 = r12
            r12 = r11
            r11 = r7
            goto L_0x0131
        L_0x0058:
            r11 = move-exception
            goto L_0x01cb
        L_0x005b:
            long r11 = r0.J$0
            java.lang.Object r13 = r0.L$1
            io.ktor.utils.io.ByteBufferChannel r13 = (io.ktor.utils.io.ByteBufferChannel) r13
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.internal.JoiningState r2 = (io.ktor.utils.io.internal.JoiningState) r2
            kotlin.ResultKt.throwOnFailure(r14)
            r9 = r11
            r11 = r13
            r12 = r9
            goto L_0x00ac
        L_0x006c:
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x01d2
        L_0x0071:
            kotlin.ResultKt.throwOnFailure(r14)
            io.ktor.utils.io.internal.JoiningState r14 = r11.joining
            if (r14 == 0) goto L_0x008a
            io.ktor.utils.io.ByteBufferChannel r14 = r11.resolveDelegation(r11, r14)
            if (r14 == 0) goto L_0x0087
            r0.label = r5
            java.lang.Object r11 = r14.writeLong(r12, r0)
            if (r11 != r1) goto L_0x01d2
            return r1
        L_0x0087:
            r14 = r6
            java.lang.Void r14 = (java.lang.Void) r14
        L_0x008a:
            java.nio.ByteBuffer r14 = r11.setupStateForWrite$ktor_io()
            if (r14 != 0) goto L_0x00d6
            io.ktor.utils.io.internal.JoiningState r14 = r11.joining
            kotlin.jvm.internal.Intrinsics.checkNotNull(r14)
            io.ktor.utils.io.internal.ReadWriteBufferState r2 = r11.getState()
            io.ktor.utils.io.internal.ReadWriteBufferState$Terminated r3 = io.ktor.utils.io.internal.ReadWriteBufferState.Terminated.INSTANCE
            if (r2 != r3) goto L_0x00ab
            io.ktor.utils.io.ByteBufferChannel r11 = r14.getDelegatedTo()
            r14 = 2
            r0.label = r14
            java.lang.Object r11 = r11.writeLong(r12, r0)
            if (r11 != r1) goto L_0x01d2
            return r1
        L_0x00ab:
            r2 = r14
        L_0x00ac:
            io.ktor.utils.io.internal.ReadWriteBufferState r14 = r11.getState()
            io.ktor.utils.io.internal.ReadWriteBufferState$Terminated r3 = io.ktor.utils.io.internal.ReadWriteBufferState.Terminated.INSTANCE
            if (r14 != r3) goto L_0x00c6
            io.ktor.utils.io.ByteBufferChannel r11 = r2.getDelegatedTo()
            r0.L$0 = r6
            r0.L$1 = r6
            r14 = 3
            r0.label = r14
            java.lang.Object r11 = r11.writeLong(r12, r0)
            if (r11 != r1) goto L_0x01d2
            return r1
        L_0x00c6:
            r0.L$0 = r2
            r0.L$1 = r11
            r0.J$0 = r12
            r14 = 4
            r0.label = r14
            java.lang.Object r14 = r11.writeSuspend(r5, r0)
            if (r14 != r1) goto L_0x00ac
            return r1
        L_0x00d6:
            io.ktor.utils.io.internal.ReadWriteBufferState r2 = r11.getState()
            io.ktor.utils.io.internal.RingBufferCapacity r2 = r2.capacity
            boolean r7 = r2.tryWriteExact(r4)
            if (r7 != 0) goto L_0x00e4
            r7 = r3
            goto L_0x0117
        L_0x00e4:
            r11.prepareWriteBuffer$ktor_io(r14, r4)
            int r7 = r14.remaining()
            if (r7 >= r4) goto L_0x00fb
            int r7 = r14.capacity()
            r14.limit(r7)
            r14.putLong(r12)
            r11.carry(r14)
            goto L_0x00fe
        L_0x00fb:
            r14.putLong(r12)
        L_0x00fe:
            r11.bytesWritten(r14, r2, r4)
            boolean r7 = r2.isFull()
            if (r7 != 0) goto L_0x010d
            boolean r7 = r11.getAutoFlush()
            if (r7 == 0) goto L_0x0110
        L_0x010d:
            r11.flush()
        L_0x0110:
            r11.restoreStateAfterWrite$ktor_io()
            r11.tryTerminate$ktor_io()
            r7 = r5
        L_0x0117:
            if (r7 != 0) goto L_0x01d2
            r8 = r2
            r2 = r14
            r13 = r12
            r12 = r4
        L_0x011d:
            r0.L$0 = r8     // Catch:{ all -> 0x01c8 }
            r0.L$1 = r11     // Catch:{ all -> 0x01c8 }
            r0.L$2 = r2     // Catch:{ all -> 0x01c8 }
            r0.J$0 = r13     // Catch:{ all -> 0x01c8 }
            r0.I$0 = r12     // Catch:{ all -> 0x01c8 }
            r7 = 5
            r0.label = r7     // Catch:{ all -> 0x01c8 }
            java.lang.Object r7 = r11.writeSuspend(r12, r0)     // Catch:{ all -> 0x01c8 }
            if (r7 != r1) goto L_0x0131
            return r1
        L_0x0131:
            io.ktor.utils.io.internal.JoiningState r7 = r11.joining
            if (r7 == 0) goto L_0x018a
            r11.restoreStateAfterWrite$ktor_io()
            io.ktor.utils.io.internal.JoiningState r12 = r11.joining
            kotlin.jvm.internal.Intrinsics.checkNotNull(r12)
            io.ktor.utils.io.internal.ReadWriteBufferState r2 = r11.getState()
            io.ktor.utils.io.internal.ReadWriteBufferState$Terminated r3 = io.ktor.utils.io.internal.ReadWriteBufferState.Terminated.INSTANCE
            if (r2 != r3) goto L_0x0159
            io.ktor.utils.io.ByteBufferChannel r11 = r12.getDelegatedTo()
            r0.L$0 = r6
            r0.L$1 = r6
            r0.L$2 = r6
            r12 = 6
            r0.label = r12
            java.lang.Object r11 = r11.writeLong(r13, r0)
            if (r11 != r1) goto L_0x01d2
            return r1
        L_0x0159:
            r2 = r12
            r9 = r13
            r13 = r11
            r11 = r9
        L_0x015d:
            io.ktor.utils.io.internal.ReadWriteBufferState r14 = r13.getState()
            io.ktor.utils.io.internal.ReadWriteBufferState$Terminated r3 = io.ktor.utils.io.internal.ReadWriteBufferState.Terminated.INSTANCE
            if (r14 != r3) goto L_0x0179
            io.ktor.utils.io.ByteBufferChannel r13 = r2.getDelegatedTo()
            r0.L$0 = r6
            r0.L$1 = r6
            r0.L$2 = r6
            r14 = 7
            r0.label = r14
            java.lang.Object r11 = r13.writeLong(r11, r0)
            if (r11 != r1) goto L_0x01d2
            return r1
        L_0x0179:
            r0.L$0 = r2
            r0.L$1 = r13
            r0.L$2 = r6
            r0.J$0 = r11
            r0.label = r4
            java.lang.Object r14 = r13.writeSuspend(r5, r0)
            if (r14 != r1) goto L_0x015d
            return r1
        L_0x018a:
            boolean r7 = r8.tryWriteExact(r12)
            if (r7 != 0) goto L_0x0192
            r7 = r3
            goto L_0x01c5
        L_0x0192:
            r11.prepareWriteBuffer$ktor_io(r2, r12)
            int r7 = r2.remaining()
            if (r7 >= r12) goto L_0x01a9
            int r7 = r2.capacity()
            r2.limit(r7)
            r2.putLong(r13)
            r11.carry(r2)
            goto L_0x01ac
        L_0x01a9:
            r2.putLong(r13)
        L_0x01ac:
            r11.bytesWritten(r2, r8, r12)
            boolean r7 = r8.isFull()
            if (r7 != 0) goto L_0x01bb
            boolean r7 = r11.getAutoFlush()
            if (r7 == 0) goto L_0x01be
        L_0x01bb:
            r11.flush()
        L_0x01be:
            r11.restoreStateAfterWrite$ktor_io()
            r11.tryTerminate$ktor_io()
            r7 = r5
        L_0x01c5:
            if (r7 == 0) goto L_0x011d
            goto L_0x01d2
        L_0x01c8:
            r12 = move-exception
            r7 = r11
            r11 = r12
        L_0x01cb:
            r7.restoreStateAfterWrite$ktor_io()
            r7.tryTerminate$ktor_io()
            throw r11
        L_0x01d2:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.writeLong$suspendImpl(io.ktor.utils.io.ByteBufferChannel, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object writeDouble$suspendImpl(ByteBufferChannel byteBufferChannel, double d, Continuation continuation) {
        Object writeLong = byteBufferChannel.writeLong(Double.doubleToRawLongBits(d), continuation);
        return writeLong == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? writeLong : Unit.INSTANCE;
    }

    static /* synthetic */ Object writeFloat$suspendImpl(ByteBufferChannel byteBufferChannel, float f, Continuation continuation) {
        Object writeInt = byteBufferChannel.writeInt(Float.floatToRawIntBits(f), continuation);
        return writeInt == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? writeInt : Unit.INSTANCE;
    }

    /* JADX INFO: finally extract failed */
    private final Object writePrimitive(int i, Function1<? super ByteBufferChannel, Unit> function1, Function1<? super ByteBuffer, Unit> function12, Continuation<? super Unit> continuation) {
        boolean z;
        boolean z2;
        JoiningState joiningState = this.joining;
        if (joiningState != null) {
            ByteBufferChannel resolveDelegation = resolveDelegation(this, joiningState);
            if (resolveDelegation != null) {
                function1.invoke(resolveDelegation);
                return Unit.INSTANCE;
            }
            Void voidR = null;
        }
        ByteBuffer byteBuffer = setupStateForWrite$ktor_io();
        if (byteBuffer != null) {
            RingBufferCapacity ringBufferCapacity = getState().capacity;
            if (!ringBufferCapacity.tryWriteExact(i)) {
                z = false;
            } else {
                prepareWriteBuffer$ktor_io(byteBuffer, i);
                if (byteBuffer.remaining() < i) {
                    byteBuffer.limit(byteBuffer.capacity());
                    function12.invoke(byteBuffer);
                    carry(byteBuffer);
                } else {
                    function12.invoke(byteBuffer);
                }
                bytesWritten(byteBuffer, ringBufferCapacity, i);
                if (ringBufferCapacity.isFull() || getAutoFlush()) {
                    flush();
                }
                restoreStateAfterWrite$ktor_io();
                tryTerminate$ktor_io();
                z = true;
            }
            if (z) {
                return Unit.INSTANCE;
            }
            while (true) {
                try {
                    InlineMarker.mark(0);
                    writeSuspend(i, continuation);
                    InlineMarker.mark(1);
                    if (this.joining == null) {
                        if (!ringBufferCapacity.tryWriteExact(i)) {
                            z2 = false;
                            continue;
                        } else {
                            prepareWriteBuffer$ktor_io(byteBuffer, i);
                            if (byteBuffer.remaining() < i) {
                                byteBuffer.limit(byteBuffer.capacity());
                                function12.invoke(byteBuffer);
                                carry(byteBuffer);
                            } else {
                                function12.invoke(byteBuffer);
                            }
                            bytesWritten(byteBuffer, ringBufferCapacity, i);
                            if (ringBufferCapacity.isFull() || getAutoFlush()) {
                                flush();
                            }
                            restoreStateAfterWrite$ktor_io();
                            tryTerminate$ktor_io();
                            z2 = true;
                            continue;
                        }
                        if (z2) {
                            break;
                        }
                    } else {
                        restoreStateAfterWrite$ktor_io();
                        JoiningState joiningState2 = this.joining;
                        Intrinsics.checkNotNull(joiningState2);
                        if (getState() == ReadWriteBufferState.Terminated.INSTANCE) {
                            function1.invoke(joiningState2.getDelegatedTo());
                        } else {
                            while (getState() != ReadWriteBufferState.Terminated.INSTANCE) {
                                InlineMarker.mark(0);
                                writeSuspend(1, continuation);
                                InlineMarker.mark(1);
                            }
                            function1.invoke(joiningState2.getDelegatedTo());
                        }
                    }
                } catch (Throwable th) {
                    restoreStateAfterWrite$ktor_io();
                    tryTerminate$ktor_io();
                    throw th;
                }
            }
            return Unit.INSTANCE;
        }
        JoiningState joiningState3 = this.joining;
        Intrinsics.checkNotNull(joiningState3);
        if (getState() == ReadWriteBufferState.Terminated.INSTANCE) {
            function1.invoke(joiningState3.getDelegatedTo());
        } else {
            while (getState() != ReadWriteBufferState.Terminated.INSTANCE) {
                InlineMarker.mark(0);
                writeSuspend(1, continuation);
                InlineMarker.mark(1);
            }
            function1.invoke(joiningState3.getDelegatedTo());
        }
        return Unit.INSTANCE;
    }

    private final boolean tryWritePrimitive(ByteBuffer byteBuffer, int i, RingBufferCapacity ringBufferCapacity, Function1<? super ByteBuffer, Unit> function1) {
        if (!ringBufferCapacity.tryWriteExact(i)) {
            return false;
        }
        prepareWriteBuffer$ktor_io(byteBuffer, i);
        if (byteBuffer.remaining() < i) {
            byteBuffer.limit(byteBuffer.capacity());
            function1.invoke(byteBuffer);
            carry(byteBuffer);
        } else {
            function1.invoke(byteBuffer);
        }
        bytesWritten(byteBuffer, ringBufferCapacity, i);
        if (ringBufferCapacity.isFull() || getAutoFlush()) {
            flush();
        }
        restoreStateAfterWrite$ktor_io();
        tryTerminate$ktor_io();
        return true;
    }

    private final void doWritePrimitive(int i, ByteBuffer byteBuffer, RingBufferCapacity ringBufferCapacity, Function1<? super ByteBuffer, Unit> function1) {
        if (byteBuffer.remaining() < i) {
            byteBuffer.limit(byteBuffer.capacity());
            function1.invoke(byteBuffer);
            carry(byteBuffer);
        } else {
            function1.invoke(byteBuffer);
        }
        bytesWritten(byteBuffer, ringBufferCapacity, i);
        if (ringBufferCapacity.isFull() || getAutoFlush()) {
            flush();
        }
        restoreStateAfterWrite$ktor_io();
        tryTerminate$ktor_io();
    }

    /* JADX INFO: finally extract failed */
    private final Object writeSuspendPrimitive(ByteBuffer byteBuffer, int i, RingBufferCapacity ringBufferCapacity, Function1<? super ByteBufferChannel, Unit> function1, Function1<? super ByteBuffer, Unit> function12, Continuation<? super Unit> continuation) {
        boolean z;
        do {
            z = false;
            try {
                InlineMarker.mark(0);
                writeSuspend(i, continuation);
                InlineMarker.mark(1);
                if (this.joining != null) {
                    restoreStateAfterWrite$ktor_io();
                    JoiningState joiningState = this.joining;
                    Intrinsics.checkNotNull(joiningState);
                    if (getState() == ReadWriteBufferState.Terminated.INSTANCE) {
                        function1.invoke(joiningState.getDelegatedTo());
                    } else {
                        while (getState() != ReadWriteBufferState.Terminated.INSTANCE) {
                            InlineMarker.mark(0);
                            writeSuspend(1, continuation);
                            InlineMarker.mark(1);
                        }
                        function1.invoke(joiningState.getDelegatedTo());
                    }
                    return Unit.INSTANCE;
                } else if (ringBufferCapacity.tryWriteExact(i)) {
                    prepareWriteBuffer$ktor_io(byteBuffer, i);
                    if (byteBuffer.remaining() < i) {
                        byteBuffer.limit(byteBuffer.capacity());
                        function12.invoke(byteBuffer);
                        carry(byteBuffer);
                    } else {
                        function12.invoke(byteBuffer);
                    }
                    bytesWritten(byteBuffer, ringBufferCapacity, i);
                    if (ringBufferCapacity.isFull() || getAutoFlush()) {
                        flush();
                    }
                    restoreStateAfterWrite$ktor_io();
                    tryTerminate$ktor_io();
                    z = true;
                    continue;
                }
            } catch (Throwable th) {
                restoreStateAfterWrite$ktor_io();
                tryTerminate$ktor_io();
                throw th;
            }
        } while (!z);
        return Unit.INSTANCE;
    }

    private final Object delegatePrimitive(Function1<? super ByteBufferChannel, Unit> function1, Continuation<? super Unit> continuation) {
        JoiningState joiningState = this.joining;
        Intrinsics.checkNotNull(joiningState);
        if (getState() == ReadWriteBufferState.Terminated.INSTANCE) {
            function1.invoke(joiningState.getDelegatedTo());
            return Unit.INSTANCE;
        }
        while (getState() != ReadWriteBufferState.Terminated.INSTANCE) {
            InlineMarker.mark(0);
            writeSuspend(1, continuation);
            InlineMarker.mark(1);
        }
        function1.invoke(joiningState.getDelegatedTo());
        return Unit.INSTANCE;
    }

    static /* synthetic */ Object awaitFreeSpace$suspendImpl(ByteBufferChannel byteBufferChannel, Continuation continuation) {
        Object writeSuspend = byteBufferChannel.writeSuspend(1, continuation);
        return writeSuspend == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? writeSuspend : Unit.INSTANCE;
    }

    static /* synthetic */ Object writeAvailable$suspendImpl(ByteBufferChannel byteBufferChannel, ByteBuffer byteBuffer, Continuation continuation) {
        JoiningState joiningState = byteBufferChannel.joining;
        if (joiningState != null) {
            ByteBufferChannel resolveDelegation = byteBufferChannel.resolveDelegation(byteBufferChannel, joiningState);
            if (resolveDelegation != null) {
                return resolveDelegation.writeAvailable(byteBuffer, (Continuation<? super Integer>) continuation);
            }
            Void voidR = null;
        }
        int writeAsMuchAsPossible = byteBufferChannel.writeAsMuchAsPossible(byteBuffer);
        if (writeAsMuchAsPossible > 0) {
            return Boxing.boxInt(writeAsMuchAsPossible);
        }
        JoiningState joiningState2 = byteBufferChannel.joining;
        if (joiningState2 != null) {
            ByteBufferChannel resolveDelegation2 = byteBufferChannel.resolveDelegation(byteBufferChannel, joiningState2);
            if (resolveDelegation2 != null) {
                return resolveDelegation2.writeAvailableSuspend(byteBuffer, (Continuation<? super Integer>) continuation);
            }
            Void voidR2 = null;
        }
        return byteBufferChannel.writeAvailableSuspend(byteBuffer, (Continuation<? super Integer>) continuation);
    }

    static /* synthetic */ Object writeAvailable$suspendImpl(ByteBufferChannel byteBufferChannel, ChunkBuffer chunkBuffer, Continuation continuation) {
        JoiningState joiningState = byteBufferChannel.joining;
        if (joiningState != null) {
            ByteBufferChannel resolveDelegation = byteBufferChannel.resolveDelegation(byteBufferChannel, joiningState);
            if (resolveDelegation != null) {
                return resolveDelegation.writeAvailable(chunkBuffer, (Continuation<? super Integer>) continuation);
            }
            Void voidR = null;
        }
        int writeAsMuchAsPossible = byteBufferChannel.writeAsMuchAsPossible((Buffer) chunkBuffer);
        if (writeAsMuchAsPossible > 0) {
            return Boxing.boxInt(writeAsMuchAsPossible);
        }
        JoiningState joiningState2 = byteBufferChannel.joining;
        if (joiningState2 != null) {
            ByteBufferChannel resolveDelegation2 = byteBufferChannel.resolveDelegation(byteBufferChannel, joiningState2);
            if (resolveDelegation2 != null) {
                return resolveDelegation2.writeAvailableSuspend(chunkBuffer, (Continuation<? super Integer>) continuation);
            }
            Void voidR2 = null;
        }
        return byteBufferChannel.writeAvailableSuspend(chunkBuffer, (Continuation<? super Integer>) continuation);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0081 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0082 A[PHI: r8 
      PHI: (r8v2 java.lang.Object) = (r8v5 java.lang.Object), (r8v1 java.lang.Object) binds: [B:30:0x007f, B:11:0x002c] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object writeAvailableSuspend(java.nio.ByteBuffer r7, kotlin.coroutines.Continuation<? super java.lang.Integer> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof io.ktor.utils.io.ByteBufferChannel$writeAvailableSuspend$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            io.ktor.utils.io.ByteBufferChannel$writeAvailableSuspend$1 r0 = (io.ktor.utils.io.ByteBufferChannel$writeAvailableSuspend$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            io.ktor.utils.io.ByteBufferChannel$writeAvailableSuspend$1 r0 = new io.ktor.utils.io.ByteBufferChannel$writeAvailableSuspend$1
            r0.<init>(r6, r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0048
            if (r2 == r5) goto L_0x003c
            if (r2 == r4) goto L_0x0038
            if (r2 != r3) goto L_0x0030
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0082
        L_0x0030:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0038:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0071
        L_0x003c:
            java.lang.Object r7 = r0.L$1
            java.nio.ByteBuffer r7 = (java.nio.ByteBuffer) r7
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.ByteBufferChannel r2 = (io.ktor.utils.io.ByteBufferChannel) r2
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0059
        L_0x0048:
            kotlin.ResultKt.throwOnFailure(r8)
            r0.L$0 = r6
            r0.L$1 = r7
            r0.label = r5
            java.lang.Object r8 = r6.writeSuspend(r5, r0)
            if (r8 != r1) goto L_0x0058
            return r1
        L_0x0058:
            r2 = r6
        L_0x0059:
            io.ktor.utils.io.internal.JoiningState r8 = r2.joining
            r5 = 0
            if (r8 == 0) goto L_0x0075
            io.ktor.utils.io.ByteBufferChannel r8 = r2.resolveDelegation(r2, r8)
            if (r8 == 0) goto L_0x0072
            r0.L$0 = r5
            r0.L$1 = r5
            r0.label = r4
            java.lang.Object r8 = r8.writeAvailableSuspend((java.nio.ByteBuffer) r7, (kotlin.coroutines.Continuation<? super java.lang.Integer>) r0)
            if (r8 != r1) goto L_0x0071
            return r1
        L_0x0071:
            return r8
        L_0x0072:
            r8 = r5
            java.lang.Void r8 = (java.lang.Void) r8
        L_0x0075:
            r0.L$0 = r5
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r8 = r2.writeAvailable((java.nio.ByteBuffer) r7, (kotlin.coroutines.Continuation<? super java.lang.Integer>) r0)
            if (r8 != r1) goto L_0x0082
            return r1
        L_0x0082:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.writeAvailableSuspend(java.nio.ByteBuffer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0081 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0082 A[PHI: r8 
      PHI: (r8v2 java.lang.Object) = (r8v5 java.lang.Object), (r8v1 java.lang.Object) binds: [B:30:0x007f, B:11:0x002c] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object writeAvailableSuspend(io.ktor.utils.io.core.internal.ChunkBuffer r7, kotlin.coroutines.Continuation<? super java.lang.Integer> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof io.ktor.utils.io.ByteBufferChannel$writeAvailableSuspend$3
            if (r0 == 0) goto L_0x0014
            r0 = r8
            io.ktor.utils.io.ByteBufferChannel$writeAvailableSuspend$3 r0 = (io.ktor.utils.io.ByteBufferChannel$writeAvailableSuspend$3) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            io.ktor.utils.io.ByteBufferChannel$writeAvailableSuspend$3 r0 = new io.ktor.utils.io.ByteBufferChannel$writeAvailableSuspend$3
            r0.<init>(r6, r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0048
            if (r2 == r5) goto L_0x003c
            if (r2 == r4) goto L_0x0038
            if (r2 != r3) goto L_0x0030
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0082
        L_0x0030:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0038:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0071
        L_0x003c:
            java.lang.Object r7 = r0.L$1
            io.ktor.utils.io.core.internal.ChunkBuffer r7 = (io.ktor.utils.io.core.internal.ChunkBuffer) r7
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.ByteBufferChannel r2 = (io.ktor.utils.io.ByteBufferChannel) r2
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0059
        L_0x0048:
            kotlin.ResultKt.throwOnFailure(r8)
            r0.L$0 = r6
            r0.L$1 = r7
            r0.label = r5
            java.lang.Object r8 = r6.writeSuspend(r5, r0)
            if (r8 != r1) goto L_0x0058
            return r1
        L_0x0058:
            r2 = r6
        L_0x0059:
            io.ktor.utils.io.internal.JoiningState r8 = r2.joining
            r5 = 0
            if (r8 == 0) goto L_0x0075
            io.ktor.utils.io.ByteBufferChannel r8 = r2.resolveDelegation(r2, r8)
            if (r8 == 0) goto L_0x0072
            r0.L$0 = r5
            r0.L$1 = r5
            r0.label = r4
            java.lang.Object r8 = r8.writeAvailableSuspend((io.ktor.utils.io.core.internal.ChunkBuffer) r7, (kotlin.coroutines.Continuation<? super java.lang.Integer>) r0)
            if (r8 != r1) goto L_0x0071
            return r1
        L_0x0071:
            return r8
        L_0x0072:
            r8 = r5
            java.lang.Void r8 = (java.lang.Void) r8
        L_0x0075:
            r0.L$0 = r5
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r8 = r2.writeAvailable((io.ktor.utils.io.core.internal.ChunkBuffer) r7, (kotlin.coroutines.Continuation<? super java.lang.Integer>) r0)
            if (r8 != r1) goto L_0x0082
            return r1
        L_0x0082:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.writeAvailableSuspend(io.ktor.utils.io.core.internal.ChunkBuffer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object writeFully$suspendImpl(ByteBufferChannel byteBufferChannel, ByteBuffer byteBuffer, Continuation continuation) {
        JoiningState joiningState = byteBufferChannel.joining;
        if (joiningState != null) {
            ByteBufferChannel resolveDelegation = byteBufferChannel.resolveDelegation(byteBufferChannel, joiningState);
            if (resolveDelegation != null) {
                Object writeFully = resolveDelegation.writeFully(byteBuffer, (Continuation<? super Unit>) continuation);
                return writeFully == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? writeFully : Unit.INSTANCE;
            }
            Void voidR = null;
        }
        byteBufferChannel.writeAsMuchAsPossible(byteBuffer);
        if (!byteBuffer.hasRemaining()) {
            return Unit.INSTANCE;
        }
        Object writeFullySuspend = byteBufferChannel.writeFullySuspend(byteBuffer, (Continuation<? super Unit>) continuation);
        return writeFullySuspend == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? writeFullySuspend : Unit.INSTANCE;
    }

    static /* synthetic */ Object writeFully$suspendImpl(ByteBufferChannel byteBufferChannel, Buffer buffer, Continuation continuation) {
        byteBufferChannel.writeAsMuchAsPossible(buffer);
        if (!(buffer.getWritePosition() > buffer.getReadPosition())) {
            return Unit.INSTANCE;
        }
        Object writeFullySuspend = byteBufferChannel.writeFullySuspend(buffer, (Continuation<? super Unit>) continuation);
        return writeFullySuspend == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? writeFullySuspend : Unit.INSTANCE;
    }

    /* renamed from: writeFully-JT6ljtQ$suspendImpl  reason: not valid java name */
    static /* synthetic */ Object m21writeFullyJT6ljtQ$suspendImpl(ByteBufferChannel byteBufferChannel, ByteBuffer byteBuffer, int i, int i2, Continuation continuation) {
        Object writeFully = byteBufferChannel.writeFully(Memory.m50slice87lwejk(byteBuffer, i, i2 - i), (Continuation<? super Unit>) continuation);
        return writeFully == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? writeFully : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object writeFullySuspend(java.nio.ByteBuffer r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof io.ktor.utils.io.ByteBufferChannel$writeFullySuspend$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            io.ktor.utils.io.ByteBufferChannel$writeFullySuspend$1 r0 = (io.ktor.utils.io.ByteBufferChannel$writeFullySuspend$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            io.ktor.utils.io.ByteBufferChannel$writeFullySuspend$1 r0 = new io.ktor.utils.io.ByteBufferChannel$writeFullySuspend$1
            r0.<init>(r6, r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0041
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0070
        L_0x002d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0035:
            java.lang.Object r7 = r0.L$1
            java.nio.ByteBuffer r7 = (java.nio.ByteBuffer) r7
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.ByteBufferChannel r2 = (io.ktor.utils.io.ByteBufferChannel) r2
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0058
        L_0x0041:
            kotlin.ResultKt.throwOnFailure(r8)
            r2 = r6
        L_0x0045:
            boolean r8 = r7.hasRemaining()
            if (r8 == 0) goto L_0x0079
            r0.L$0 = r2
            r0.L$1 = r7
            r0.label = r4
            java.lang.Object r8 = r2.tryWriteSuspend$ktor_io(r4, r0)
            if (r8 != r1) goto L_0x0058
            return r1
        L_0x0058:
            io.ktor.utils.io.internal.JoiningState r8 = r2.joining
            if (r8 == 0) goto L_0x0075
            io.ktor.utils.io.ByteBufferChannel r8 = r2.resolveDelegation(r2, r8)
            r5 = 0
            if (r8 == 0) goto L_0x0073
            r0.L$0 = r5
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r7 = r8.writeFully((java.nio.ByteBuffer) r7, (kotlin.coroutines.Continuation<? super kotlin.Unit>) r0)
            if (r7 != r1) goto L_0x0070
            return r1
        L_0x0070:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        L_0x0073:
            java.lang.Void r5 = (java.lang.Void) r5
        L_0x0075:
            r2.writeAsMuchAsPossible((java.nio.ByteBuffer) r7)
            goto L_0x0045
        L_0x0079:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.writeFullySuspend(java.nio.ByteBuffer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object writeFullySuspend(io.ktor.utils.io.core.Buffer r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof io.ktor.utils.io.ByteBufferChannel$writeFullySuspend$3
            if (r0 == 0) goto L_0x0014
            r0 = r8
            io.ktor.utils.io.ByteBufferChannel$writeFullySuspend$3 r0 = (io.ktor.utils.io.ByteBufferChannel$writeFullySuspend$3) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            io.ktor.utils.io.ByteBufferChannel$writeFullySuspend$3 r0 = new io.ktor.utils.io.ByteBufferChannel$writeFullySuspend$3
            r0.<init>(r6, r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0041
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0079
        L_0x002d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0035:
            java.lang.Object r7 = r0.L$1
            io.ktor.utils.io.core.Buffer r7 = (io.ktor.utils.io.core.Buffer) r7
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.ByteBufferChannel r2 = (io.ktor.utils.io.ByteBufferChannel) r2
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0061
        L_0x0041:
            kotlin.ResultKt.throwOnFailure(r8)
            r2 = r6
        L_0x0045:
            int r8 = r7.getWritePosition()
            int r5 = r7.getReadPosition()
            if (r8 <= r5) goto L_0x0051
            r8 = r4
            goto L_0x0052
        L_0x0051:
            r8 = 0
        L_0x0052:
            if (r8 == 0) goto L_0x0082
            r0.L$0 = r2
            r0.L$1 = r7
            r0.label = r4
            java.lang.Object r8 = r2.tryWriteSuspend$ktor_io(r4, r0)
            if (r8 != r1) goto L_0x0061
            return r1
        L_0x0061:
            io.ktor.utils.io.internal.JoiningState r8 = r2.joining
            if (r8 == 0) goto L_0x007e
            io.ktor.utils.io.ByteBufferChannel r8 = r2.resolveDelegation(r2, r8)
            r5 = 0
            if (r8 == 0) goto L_0x007c
            r0.L$0 = r5
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r7 = r8.writeFully((io.ktor.utils.io.core.Buffer) r7, (kotlin.coroutines.Continuation<? super kotlin.Unit>) r0)
            if (r7 != r1) goto L_0x0079
            return r1
        L_0x0079:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        L_0x007c:
            java.lang.Void r5 = (java.lang.Void) r5
        L_0x007e:
            r2.writeAsMuchAsPossible((io.ktor.utils.io.core.Buffer) r7)
            goto L_0x0045
        L_0x0082:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.writeFullySuspend(io.ktor.utils.io.core.Buffer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final Object awaitClose(Continuation<? super Unit> continuation) {
        if (getClosed() != null) {
            return Unit.INSTANCE;
        }
        JoiningState joiningState = this.joining;
        if (joiningState == null) {
            if (getClosed() != null) {
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("Only works for joined.".toString());
        }
        Object awaitClose = joiningState.awaitClose(continuation);
        return awaitClose == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitClose : Unit.INSTANCE;
    }

    public final Object joinFrom$ktor_io(ByteBufferChannel byteBufferChannel, boolean z, Continuation<? super Unit> continuation) {
        if (byteBufferChannel.getClosed() == null || byteBufferChannel.getState() != ReadWriteBufferState.Terminated.INSTANCE) {
            ClosedElement closed = getClosed();
            if (closed == null) {
                JoiningState joiningState = byteBufferChannel.setupDelegateTo(this, z);
                if (byteBufferChannel.tryCompleteJoining(joiningState)) {
                    Object awaitClose = byteBufferChannel.awaitClose(continuation);
                    if (awaitClose == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        return awaitClose;
                    }
                    return Unit.INSTANCE;
                }
                Object joinFromSuspend = joinFromSuspend(byteBufferChannel, z, joiningState, continuation);
                return joinFromSuspend == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? joinFromSuspend : Unit.INSTANCE;
            } else if (byteBufferChannel.getClosed() != null) {
                return Unit.INSTANCE;
            } else {
                Void unused = ByteBufferChannelKt.rethrowClosed(closed.getSendException());
                throw new KotlinNothingValueException();
            }
        } else {
            if (z) {
                ClosedElement closed2 = byteBufferChannel.getClosed();
                Intrinsics.checkNotNull(closed2);
                close(closed2.getCause());
            }
            return Unit.INSTANCE;
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object joinFromSuspend(io.ktor.utils.io.ByteBufferChannel r10, boolean r11, io.ktor.utils.io.internal.JoiningState r12, kotlin.coroutines.Continuation<? super kotlin.Unit> r13) {
        /*
            r9 = this;
            boolean r0 = r13 instanceof io.ktor.utils.io.ByteBufferChannel$joinFromSuspend$1
            if (r0 == 0) goto L_0x0014
            r0 = r13
            io.ktor.utils.io.ByteBufferChannel$joinFromSuspend$1 r0 = (io.ktor.utils.io.ByteBufferChannel$joinFromSuspend$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r13 = r0.label
            int r13 = r13 - r2
            r0.label = r13
            goto L_0x0019
        L_0x0014:
            io.ktor.utils.io.ByteBufferChannel$joinFromSuspend$1 r0 = new io.ktor.utils.io.ByteBufferChannel$joinFromSuspend$1
            r0.<init>(r9, r13)
        L_0x0019:
            java.lang.Object r13 = r0.result
            java.lang.Object r7 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r0.label
            r8 = 2
            r2 = 1
            if (r1 == 0) goto L_0x0043
            if (r1 == r2) goto L_0x0035
            if (r1 != r8) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x0080
        L_0x002d:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x0035:
            boolean r11 = r0.Z$0
            java.lang.Object r10 = r0.L$1
            io.ktor.utils.io.ByteBufferChannel r10 = (io.ktor.utils.io.ByteBufferChannel) r10
            java.lang.Object r12 = r0.L$0
            io.ktor.utils.io.ByteBufferChannel r12 = (io.ktor.utils.io.ByteBufferChannel) r12
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x005f
        L_0x0043:
            kotlin.ResultKt.throwOnFailure(r13)
            r3 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r0.L$0 = r9
            r0.L$1 = r10
            r0.Z$0 = r11
            r0.label = r2
            r1 = r9
            r2 = r10
            r5 = r12
            r6 = r0
            java.lang.Object r12 = r1.copyDirect$ktor_io(r2, r3, r5, r6)
            if (r12 != r7) goto L_0x005e
            return r7
        L_0x005e:
            r12 = r9
        L_0x005f:
            if (r11 == 0) goto L_0x006f
            boolean r11 = r10.isClosedForRead()
            if (r11 == 0) goto L_0x006f
            io.ktor.utils.io.ByteWriteChannel r12 = (io.ktor.utils.io.ByteWriteChannel) r12
            io.ktor.utils.io.ByteWriteChannelKt.close(r12)
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        L_0x006f:
            r12.flush()
            r11 = 0
            r0.L$0 = r11
            r0.L$1 = r11
            r0.label = r8
            java.lang.Object r10 = r10.awaitClose(r0)
            if (r10 != r7) goto L_0x0080
            return r7
        L_0x0080:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.joinFromSuspend(io.ktor.utils.io.ByteBufferChannel, boolean, io.ktor.utils.io.internal.JoiningState, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v63, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v12, resolved type: io.ktor.utils.io.ByteBufferChannel} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x0272 A[Catch:{ all -> 0x02b2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0284 A[Catch:{ all -> 0x02b2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x02e7  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x0307 A[Catch:{ all -> 0x03d1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x0324 A[SYNTHETIC, Splitter:B:160:0x0324] */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x0343 A[Catch:{ all -> 0x007d }] */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x0383 A[ADDED_TO_REGION, Catch:{ all -> 0x007d }] */
    /* JADX WARNING: Removed duplicated region for block: B:181:0x038c A[Catch:{ all -> 0x007d }] */
    /* JADX WARNING: Removed duplicated region for block: B:190:0x03a9 A[Catch:{ all -> 0x007d }] */
    /* JADX WARNING: Removed duplicated region for block: B:211:0x0402 A[Catch:{ all -> 0x007d }] */
    /* JADX WARNING: Removed duplicated region for block: B:215:0x0418 A[Catch:{ all -> 0x007d }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0128 A[Catch:{ all -> 0x007d }] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0164 A[Catch:{ all -> 0x03d4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0191 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0192  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x01c0  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002e  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x01ec A[Catch:{ all -> 0x02d8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x01fa A[Catch:{ all -> 0x02d8 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object copyDirect$ktor_io(io.ktor.utils.io.ByteBufferChannel r26, long r27, io.ktor.utils.io.internal.JoiningState r29, kotlin.coroutines.Continuation<? super java.lang.Long> r30) {
        /*
            r25 = this;
            r1 = r25
            r0 = r26
            r2 = r29
            r3 = r30
            boolean r4 = r3 instanceof io.ktor.utils.io.ByteBufferChannel$copyDirect$1
            if (r4 == 0) goto L_0x001c
            r4 = r3
            io.ktor.utils.io.ByteBufferChannel$copyDirect$1 r4 = (io.ktor.utils.io.ByteBufferChannel$copyDirect$1) r4
            int r5 = r4.label
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r5 & r6
            if (r5 == 0) goto L_0x001c
            int r3 = r4.label
            int r3 = r3 - r6
            r4.label = r3
            goto L_0x0021
        L_0x001c:
            io.ktor.utils.io.ByteBufferChannel$copyDirect$1 r4 = new io.ktor.utils.io.ByteBufferChannel$copyDirect$1
            r4.<init>(r1, r3)
        L_0x0021:
            java.lang.Object r3 = r4.result
            java.lang.Object r5 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r6 = r4.label
            r7 = 3
            r8 = 2
            r9 = 1
            if (r6 == 0) goto L_0x00cd
            if (r6 == r9) goto L_0x0080
            if (r6 == r8) goto L_0x0063
            if (r6 != r7) goto L_0x005b
            boolean r0 = r4.Z$0
            long r11 = r4.J$0
            java.lang.Object r2 = r4.L$3
            kotlin.jvm.internal.Ref$LongRef r2 = (kotlin.jvm.internal.Ref.LongRef) r2
            java.lang.Object r6 = r4.L$2
            io.ktor.utils.io.internal.JoiningState r6 = (io.ktor.utils.io.internal.JoiningState) r6
            java.lang.Object r13 = r4.L$1
            io.ktor.utils.io.ByteBufferChannel r13 = (io.ktor.utils.io.ByteBufferChannel) r13
            java.lang.Object r14 = r4.L$0
            io.ktor.utils.io.ByteBufferChannel r14 = (io.ktor.utils.io.ByteBufferChannel) r14
            kotlin.ResultKt.throwOnFailure(r3)     // Catch:{ all -> 0x007d }
            r10 = r7
            r1 = r8
            r8 = r2
            r7 = r5
            r2 = r11
            r5 = r0
            r11 = r9
            r0 = r13
            r9 = 0
            r23 = r6
            r6 = r4
            r4 = r23
            goto L_0x03cd
        L_0x005b:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0063:
            boolean r0 = r4.Z$0
            long r11 = r4.J$0
            java.lang.Object r2 = r4.L$3
            kotlin.jvm.internal.Ref$LongRef r2 = (kotlin.jvm.internal.Ref.LongRef) r2
            java.lang.Object r6 = r4.L$2
            io.ktor.utils.io.internal.JoiningState r6 = (io.ktor.utils.io.internal.JoiningState) r6
            java.lang.Object r13 = r4.L$1
            io.ktor.utils.io.ByteBufferChannel r13 = (io.ktor.utils.io.ByteBufferChannel) r13
            java.lang.Object r14 = r4.L$0
            io.ktor.utils.io.ByteBufferChannel r14 = (io.ktor.utils.io.ByteBufferChannel) r14
            kotlin.ResultKt.throwOnFailure(r3)     // Catch:{ all -> 0x007d }
            r1 = r8
            goto L_0x037b
        L_0x007d:
            r0 = move-exception
            goto L_0x0425
        L_0x0080:
            long r11 = r4.J$1
            boolean r0 = r4.Z$0
            long r13 = r4.J$0
            java.lang.Object r2 = r4.L$9
            io.ktor.utils.io.ByteBufferChannel r2 = (io.ktor.utils.io.ByteBufferChannel) r2
            java.lang.Object r6 = r4.L$8
            java.nio.ByteBuffer r6 = (java.nio.ByteBuffer) r6
            java.lang.Object r15 = r4.L$7
            io.ktor.utils.io.internal.RingBufferCapacity r15 = (io.ktor.utils.io.internal.RingBufferCapacity) r15
            java.lang.Object r7 = r4.L$6
            io.ktor.utils.io.internal.RingBufferCapacity r7 = (io.ktor.utils.io.internal.RingBufferCapacity) r7
            java.lang.Object r8 = r4.L$5
            io.ktor.utils.io.ByteBufferChannel r8 = (io.ktor.utils.io.ByteBufferChannel) r8
            java.lang.Object r10 = r4.L$4
            io.ktor.utils.io.ByteBufferChannel r10 = (io.ktor.utils.io.ByteBufferChannel) r10
            java.lang.Object r9 = r4.L$3
            kotlin.jvm.internal.Ref$LongRef r9 = (kotlin.jvm.internal.Ref.LongRef) r9
            r26 = r0
            java.lang.Object r0 = r4.L$2
            io.ktor.utils.io.internal.JoiningState r0 = (io.ktor.utils.io.internal.JoiningState) r0
            r27 = r0
            java.lang.Object r0 = r4.L$1
            io.ktor.utils.io.ByteBufferChannel r0 = (io.ktor.utils.io.ByteBufferChannel) r0
            r28 = r0
            java.lang.Object r0 = r4.L$0
            r16 = r0
            io.ktor.utils.io.ByteBufferChannel r16 = (io.ktor.utils.io.ByteBufferChannel) r16
            kotlin.ResultKt.throwOnFailure(r3)     // Catch:{ all -> 0x00c8 }
            r1 = r15
            r3 = r16
            r16 = r27
            r14 = r13
            r12 = r11
            r11 = r7
            r7 = r5
            r5 = r26
            r26 = r28
            goto L_0x019d
        L_0x00c8:
            r0 = move-exception
            r14 = r16
            goto L_0x03f1
        L_0x00cd:
            kotlin.ResultKt.throwOnFailure(r3)
            java.lang.Throwable r3 = r26.getClosedCause()
            r6 = 0
            if (r3 == 0) goto L_0x00e4
            java.lang.Throwable r0 = r26.getClosedCause()
            r1.close(r0)
            java.lang.Long r0 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r6)
            return r0
        L_0x00e4:
            boolean r3 = r26.isClosedForRead()
            if (r3 == 0) goto L_0x0104
            if (r2 == 0) goto L_0x00ff
            boolean r0 = r0.tryCompleteJoining(r2)
            if (r0 == 0) goto L_0x00f3
            goto L_0x00ff
        L_0x00f3:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "Check failed."
            java.lang.String r2 = r2.toString()
            r0.<init>(r2)
            throw r0
        L_0x00ff:
            java.lang.Long r0 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r6)
            return r0
        L_0x0104:
            if (r2 == 0) goto L_0x0111
            boolean r3 = r0.tryCompleteJoining(r2)
            if (r3 == 0) goto L_0x0111
            java.lang.Long r0 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r6)
            return r0
        L_0x0111:
            boolean r3 = r25.getAutoFlush()
            kotlin.jvm.internal.Ref$LongRef r6 = new kotlin.jvm.internal.Ref$LongRef     // Catch:{ all -> 0x0422 }
            r6.<init>()     // Catch:{ all -> 0x0422 }
            r14 = r1
            r7 = r5
            r8 = r6
            r5 = r3
            r6 = r4
            r4 = r2
            r2 = r27
        L_0x0122:
            long r9 = r8.element     // Catch:{ all -> 0x007d }
            int r9 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
            if (r9 >= 0) goto L_0x0416
            io.ktor.utils.io.internal.JoiningState r9 = r14.joining     // Catch:{ all -> 0x007d }
            if (r9 == 0) goto L_0x0132
            io.ktor.utils.io.ByteBufferChannel r9 = r14.resolveDelegation(r14, r9)     // Catch:{ all -> 0x007d }
            if (r9 != 0) goto L_0x0133
        L_0x0132:
            r9 = r14
        L_0x0133:
            java.nio.ByteBuffer r10 = r9.setupStateForWrite$ktor_io()     // Catch:{ all -> 0x007d }
            if (r10 != 0) goto L_0x013b
            goto L_0x0322
        L_0x013b:
            io.ktor.utils.io.internal.ReadWriteBufferState r11 = r9.getState()     // Catch:{ all -> 0x007d }
            io.ktor.utils.io.internal.RingBufferCapacity r11 = r11.capacity     // Catch:{ all -> 0x007d }
            long r12 = r9.getTotalBytesWritten()     // Catch:{ all -> 0x007d }
            io.ktor.utils.io.internal.ClosedElement r15 = r9.getClosed()     // Catch:{ all -> 0x03ec }
            if (r15 != 0) goto L_0x03df
            r15 = r9
            io.ktor.utils.io.ByteBufferChannel r15 = (io.ktor.utils.io.ByteBufferChannel) r15     // Catch:{ all -> 0x03ec }
            r26 = r12
            r16 = r15
            r12 = r2
            r15 = r11
            r3 = r14
            r23 = r9
            r9 = r8
            r8 = r23
        L_0x015a:
            long r1 = r9.element     // Catch:{ all -> 0x03d4 }
            int r1 = (r1 > r12 ? 1 : (r1 == r12 ? 0 : -1))
            if (r1 >= 0) goto L_0x02e7
            int r1 = r15._availableForWrite$internal     // Catch:{ all -> 0x03d4 }
            if (r1 != 0) goto L_0x01c0
            r6.L$0 = r3     // Catch:{ all -> 0x03d4 }
            r6.L$1 = r0     // Catch:{ all -> 0x03d4 }
            r6.L$2 = r4     // Catch:{ all -> 0x03d4 }
            r6.L$3 = r9     // Catch:{ all -> 0x03d4 }
            r6.L$4 = r14     // Catch:{ all -> 0x03d4 }
            r6.L$5 = r8     // Catch:{ all -> 0x03d4 }
            r6.L$6 = r11     // Catch:{ all -> 0x03d4 }
            r6.L$7 = r15     // Catch:{ all -> 0x03d4 }
            r6.L$8 = r10     // Catch:{ all -> 0x03d4 }
            r2 = r16
            r6.L$9 = r2     // Catch:{ all -> 0x03d4 }
            r6.J$0 = r12     // Catch:{ all -> 0x03d4 }
            r6.Z$0 = r5     // Catch:{ all -> 0x03d4 }
            r28 = r3
            r16 = r4
            r3 = r26
            r6.J$1 = r3     // Catch:{ all -> 0x01bd }
            r1 = 1
            r6.label = r1     // Catch:{ all -> 0x01bd }
            r26 = r0
            java.lang.Object r0 = r2.tryWriteSuspend$ktor_io(r1, r6)     // Catch:{ all -> 0x01bd }
            if (r0 != r7) goto L_0x0192
            return r7
        L_0x0192:
            r1 = r15
            r23 = r3
            r3 = r28
            r4 = r6
            r6 = r10
            r10 = r14
            r14 = r12
            r12 = r23
        L_0x019d:
            io.ktor.utils.io.internal.JoiningState r0 = r2.joining     // Catch:{ all -> 0x01b7 }
            if (r0 != 0) goto L_0x01b0
            int r0 = r1._availableForWrite$internal     // Catch:{ all -> 0x01b7 }
            r27 = r3
            r28 = r16
            r3 = r2
            r2 = r1
            r1 = r26
            r26 = r10
            r10 = r6
            r6 = r4
            goto L_0x01da
        L_0x01b0:
            r0 = r26
            r6 = r4
            r4 = r16
            goto L_0x02f6
        L_0x01b7:
            r0 = move-exception
            r14 = r3
            r7 = r11
            r11 = r12
            goto L_0x03f1
        L_0x01bd:
            r0 = move-exception
            goto L_0x03d9
        L_0x01c0:
            r28 = r3
            r2 = r16
            r16 = r4
            r3 = r26
            r26 = r0
            r27 = r28
            r0 = r1
            r28 = r16
            r1 = r26
            r26 = r14
            r23 = r3
            r3 = r2
            r2 = r15
            r14 = r12
            r12 = r23
        L_0x01da:
            int r4 = r3.writePosition     // Catch:{ all -> 0x02d8 }
            r3.prepareBuffer(r10, r4, r0)     // Catch:{ all -> 0x02d8 }
            kotlin.jvm.internal.Ref$IntRef r4 = new kotlin.jvm.internal.Ref$IntRef     // Catch:{ all -> 0x02d8 }
            r4.<init>()     // Catch:{ all -> 0x02d8 }
            r29 = r6
            java.nio.ByteBuffer r6 = r1.setupStateForRead()     // Catch:{ all -> 0x02d8 }
            if (r6 != 0) goto L_0x01fa
            r21 = r0
            r16 = r7
            r17 = r8
            r18 = r12
            r8 = r3
            r13 = r11
            r3 = r1
            r1 = r4
            goto L_0x026e
        L_0x01fa:
            r16 = r7
            io.ktor.utils.io.internal.ReadWriteBufferState r7 = r1.getState()     // Catch:{ all -> 0x02d8 }
            io.ktor.utils.io.internal.RingBufferCapacity r7 = r7.capacity     // Catch:{ all -> 0x02d8 }
            r17 = r8
            int r8 = r7._availableForRead$internal     // Catch:{ all -> 0x02cc }
            if (r8 != 0) goto L_0x0222
            r1.restoreStateAfterRead()     // Catch:{ all -> 0x0217 }
            r1.tryTerminate$ktor_io()     // Catch:{ all -> 0x0217 }
            r21 = r0
            r8 = r3
            r18 = r12
            r3 = r1
            r1 = r4
            r13 = r11
            goto L_0x026e
        L_0x0217:
            r0 = move-exception
            r10 = r26
            r14 = r27
            r7 = r11
            r11 = r12
            r8 = r17
            goto L_0x03f1
        L_0x0222:
            int r8 = r6.remaining()     // Catch:{ all -> 0x02cc }
            r18 = r12
            r13 = r11
            long r11 = (long) r8
            int r8 = r10.remaining()     // Catch:{ all -> 0x02c9 }
            r21 = r0
            r20 = r1
            long r0 = (long) r8
            r8 = r3
            r22 = r4
            long r3 = r9.element     // Catch:{ all -> 0x02c5 }
            long r3 = r14 - r3
            long r0 = java.lang.Math.min(r0, r3)     // Catch:{ all -> 0x02c5 }
            long r0 = java.lang.Math.min(r11, r0)     // Catch:{ all -> 0x02c5 }
            int r0 = (int) r0     // Catch:{ all -> 0x02c5 }
            int r0 = r2.tryWriteAtMost(r0)     // Catch:{ all -> 0x02c5 }
            if (r0 > 0) goto L_0x024e
            r3 = r20
            r1 = r22
            goto L_0x0268
        L_0x024e:
            boolean r1 = r7.tryReadExact(r0)     // Catch:{ all -> 0x02c5 }
            if (r1 == 0) goto L_0x02bb
            int r1 = r6.position()     // Catch:{ all -> 0x02c5 }
            int r1 = r1 + r0
            r6.limit(r1)     // Catch:{ all -> 0x02c5 }
            r10.put(r6)     // Catch:{ all -> 0x02c5 }
            r1 = r22
            r1.element = r0     // Catch:{ all -> 0x02c5 }
            r3 = r20
            r3.bytesRead(r6, r7, r0)     // Catch:{ all -> 0x02c3 }
        L_0x0268:
            r3.restoreStateAfterRead()     // Catch:{ all -> 0x02b2 }
            r3.tryTerminate$ktor_io()     // Catch:{ all -> 0x02b2 }
        L_0x026e:
            int r0 = r1.element     // Catch:{ all -> 0x02b2 }
            if (r0 > 0) goto L_0x0284
            r10 = r26
            r4 = r28
            r6 = r29
            r0 = r3
            r11 = r13
            r7 = r16
            r8 = r17
            r12 = r18
            r3 = r27
            goto L_0x02f6
        L_0x0284:
            int r0 = r1.element     // Catch:{ all -> 0x02b2 }
            r8.bytesWritten(r10, r2, r0)     // Catch:{ all -> 0x02b2 }
            long r6 = r9.element     // Catch:{ all -> 0x02b2 }
            int r0 = r1.element     // Catch:{ all -> 0x02b2 }
            long r11 = (long) r0     // Catch:{ all -> 0x02b2 }
            long r6 = r6 + r11
            r9.element = r6     // Catch:{ all -> 0x02b2 }
            int r0 = r1.element     // Catch:{ all -> 0x02b2 }
            int r0 = r21 - r0
            if (r0 == 0) goto L_0x0299
            if (r5 == 0) goto L_0x029c
        L_0x0299:
            r8.flush()     // Catch:{ all -> 0x02b2 }
        L_0x029c:
            r4 = r28
            r6 = r29
            r0 = r3
            r11 = r13
            r12 = r14
            r7 = r16
            r14 = r26
            r3 = r27
            r15 = r2
            r16 = r8
            r8 = r17
            r26 = r18
            goto L_0x015a
        L_0x02b2:
            r0 = move-exception
            r10 = r26
            r14 = r27
            r7 = r13
            r8 = r17
            goto L_0x02e3
        L_0x02bb:
            r3 = r20
            java.lang.AssertionError r0 = new java.lang.AssertionError     // Catch:{ all -> 0x02c3 }
            r0.<init>()     // Catch:{ all -> 0x02c3 }
            throw r0     // Catch:{ all -> 0x02c3 }
        L_0x02c3:
            r0 = move-exception
            goto L_0x02d1
        L_0x02c5:
            r0 = move-exception
            r3 = r20
            goto L_0x02d1
        L_0x02c9:
            r0 = move-exception
            r3 = r1
            goto L_0x02d1
        L_0x02cc:
            r0 = move-exception
            r3 = r1
            r18 = r12
            r13 = r11
        L_0x02d1:
            r3.restoreStateAfterRead()     // Catch:{ all -> 0x02b2 }
            r3.tryTerminate$ktor_io()     // Catch:{ all -> 0x02b2 }
            throw r0     // Catch:{ all -> 0x02b2 }
        L_0x02d8:
            r0 = move-exception
            r17 = r8
            r18 = r12
            r13 = r11
            r10 = r26
            r14 = r27
            r7 = r13
        L_0x02e3:
            r11 = r18
            goto L_0x03f1
        L_0x02e7:
            r28 = r3
            r16 = r4
            r3 = r26
            r26 = r0
            r10 = r14
            r14 = r12
            r12 = r3
            r4 = r16
            r3 = r28
        L_0x02f6:
            boolean r1 = r11.isFull()     // Catch:{ all -> 0x03d1 }
            if (r1 != 0) goto L_0x0302
            boolean r1 = r8.getAutoFlush()     // Catch:{ all -> 0x03d1 }
            if (r1 == 0) goto L_0x0305
        L_0x0302:
            r8.flush()     // Catch:{ all -> 0x03d1 }
        L_0x0305:
            if (r8 == r10) goto L_0x0316
            long r1 = r10.getTotalBytesWritten()     // Catch:{ all -> 0x03d1 }
            long r16 = r8.getTotalBytesWritten()     // Catch:{ all -> 0x03d1 }
            long r16 = r16 - r12
            long r1 = r1 + r16
            r10.setTotalBytesWritten$ktor_io(r1)     // Catch:{ all -> 0x03d1 }
        L_0x0316:
            r8.restoreStateAfterWrite$ktor_io()     // Catch:{ all -> 0x03d1 }
            r8.tryTerminate$ktor_io()     // Catch:{ all -> 0x03d1 }
            r8 = r9
            r23 = r14
            r14 = r3
            r2 = r23
        L_0x0322:
            if (r4 == 0) goto L_0x033d
            boolean r1 = r0.tryCompleteJoining(r4)     // Catch:{ all -> 0x007d }
            if (r1 == 0) goto L_0x032c
            goto L_0x0416
        L_0x032c:
            io.ktor.utils.io.internal.ReadWriteBufferState r1 = r0.getState()     // Catch:{ all -> 0x007d }
            io.ktor.utils.io.internal.RingBufferCapacity r1 = r1.capacity     // Catch:{ all -> 0x007d }
            boolean r1 = r1.flush()     // Catch:{ all -> 0x007d }
            if (r1 == 0) goto L_0x033d
            r0.resumeWriteOp()     // Catch:{ all -> 0x007d }
            goto L_0x03cd
        L_0x033d:
            long r9 = r8.element     // Catch:{ all -> 0x007d }
            int r1 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
            if (r1 >= 0) goto L_0x0416
            r14.flush()     // Catch:{ all -> 0x007d }
            int r1 = r0.getAvailableForRead()     // Catch:{ all -> 0x007d }
            if (r1 != 0) goto L_0x03a4
            r6.L$0 = r14     // Catch:{ all -> 0x007d }
            r6.L$1 = r0     // Catch:{ all -> 0x007d }
            r6.L$2 = r4     // Catch:{ all -> 0x007d }
            r6.L$3 = r8     // Catch:{ all -> 0x007d }
            r1 = 0
            r6.L$4 = r1     // Catch:{ all -> 0x007d }
            r6.L$5 = r1     // Catch:{ all -> 0x007d }
            r6.L$6 = r1     // Catch:{ all -> 0x007d }
            r6.L$7 = r1     // Catch:{ all -> 0x007d }
            r6.L$8 = r1     // Catch:{ all -> 0x007d }
            r6.L$9 = r1     // Catch:{ all -> 0x007d }
            r6.J$0 = r2     // Catch:{ all -> 0x007d }
            r6.Z$0 = r5     // Catch:{ all -> 0x007d }
            r1 = 2
            r6.label = r1     // Catch:{ all -> 0x007d }
            r9 = 1
            java.lang.Object r10 = r0.readSuspendImpl(r9, r6)     // Catch:{ all -> 0x007d }
            if (r10 != r7) goto L_0x0370
            return r7
        L_0x0370:
            r13 = r0
            r11 = r2
            r0 = r5
            r5 = r7
            r2 = r8
            r3 = r10
            r23 = r6
            r6 = r4
            r4 = r23
        L_0x037b:
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch:{ all -> 0x007d }
            boolean r3 = r3.booleanValue()     // Catch:{ all -> 0x007d }
            if (r3 == 0) goto L_0x038c
            if (r6 == 0) goto L_0x0395
            boolean r3 = r13.tryCompleteJoining(r6)     // Catch:{ all -> 0x007d }
            if (r3 == 0) goto L_0x0395
            goto L_0x03a0
        L_0x038c:
            if (r6 == 0) goto L_0x03a0
            boolean r3 = r13.tryCompleteJoining(r6)     // Catch:{ all -> 0x007d }
            if (r3 == 0) goto L_0x0395
            goto L_0x03a0
        L_0x0395:
            r8 = r2
            r7 = r5
            r2 = r11
            r5 = r0
            r0 = r13
            r23 = r6
            r6 = r4
            r4 = r23
            goto L_0x03a5
        L_0x03a0:
            r5 = r0
            r8 = r2
            goto L_0x0416
        L_0x03a4:
            r1 = 2
        L_0x03a5:
            io.ktor.utils.io.internal.JoiningState r9 = r14.joining     // Catch:{ all -> 0x007d }
            if (r9 == 0) goto L_0x03cd
            r6.L$0 = r14     // Catch:{ all -> 0x007d }
            r6.L$1 = r0     // Catch:{ all -> 0x007d }
            r6.L$2 = r4     // Catch:{ all -> 0x007d }
            r6.L$3 = r8     // Catch:{ all -> 0x007d }
            r9 = 0
            r6.L$4 = r9     // Catch:{ all -> 0x007d }
            r6.L$5 = r9     // Catch:{ all -> 0x007d }
            r6.L$6 = r9     // Catch:{ all -> 0x007d }
            r6.L$7 = r9     // Catch:{ all -> 0x007d }
            r6.L$8 = r9     // Catch:{ all -> 0x007d }
            r6.L$9 = r9     // Catch:{ all -> 0x007d }
            r6.J$0 = r2     // Catch:{ all -> 0x007d }
            r6.Z$0 = r5     // Catch:{ all -> 0x007d }
            r10 = 3
            r6.label = r10     // Catch:{ all -> 0x007d }
            r11 = 1
            java.lang.Object r12 = r14.tryWriteSuspend$ktor_io(r11, r6)     // Catch:{ all -> 0x007d }
            if (r12 != r7) goto L_0x03cd
            return r7
        L_0x03cd:
            r1 = r25
            goto L_0x0122
        L_0x03d1:
            r0 = move-exception
            r14 = r3
            goto L_0x0425
        L_0x03d4:
            r0 = move-exception
            r28 = r3
            r3 = r26
        L_0x03d9:
            r7 = r11
            r10 = r14
            r14 = r28
            r11 = r3
            goto L_0x03f1
        L_0x03df:
            java.lang.Throwable r0 = r15.getSendException()     // Catch:{ all -> 0x03ec }
            java.lang.Void unused = io.ktor.utils.io.ByteBufferChannelKt.rethrowClosed(r0)     // Catch:{ all -> 0x03ec }
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException     // Catch:{ all -> 0x03ec }
            r0.<init>()     // Catch:{ all -> 0x03ec }
            throw r0     // Catch:{ all -> 0x03ec }
        L_0x03ec:
            r0 = move-exception
            r8 = r9
            r7 = r11
            r11 = r12
            r10 = r14
        L_0x03f1:
            boolean r1 = r7.isFull()     // Catch:{ all -> 0x007d }
            if (r1 != 0) goto L_0x03fd
            boolean r1 = r8.getAutoFlush()     // Catch:{ all -> 0x007d }
            if (r1 == 0) goto L_0x0400
        L_0x03fd:
            r8.flush()     // Catch:{ all -> 0x007d }
        L_0x0400:
            if (r8 == r10) goto L_0x040f
            long r1 = r10.getTotalBytesWritten()     // Catch:{ all -> 0x007d }
            long r3 = r8.getTotalBytesWritten()     // Catch:{ all -> 0x007d }
            long r3 = r3 - r11
            long r1 = r1 + r3
            r10.setTotalBytesWritten$ktor_io(r1)     // Catch:{ all -> 0x007d }
        L_0x040f:
            r8.restoreStateAfterWrite$ktor_io()     // Catch:{ all -> 0x007d }
            r8.tryTerminate$ktor_io()     // Catch:{ all -> 0x007d }
            throw r0     // Catch:{ all -> 0x007d }
        L_0x0416:
            if (r5 == 0) goto L_0x041b
            r14.flush()     // Catch:{ all -> 0x007d }
        L_0x041b:
            long r0 = r8.element     // Catch:{ all -> 0x007d }
            java.lang.Long r0 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r0)     // Catch:{ all -> 0x007d }
            return r0
        L_0x0422:
            r0 = move-exception
            r14 = r25
        L_0x0425:
            r14.close(r0)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.copyDirect$ktor_io(io.ktor.utils.io.ByteBufferChannel, long, io.ktor.utils.io.internal.JoiningState, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void ensureClosedJoined(JoiningState joiningState) {
        ClosedElement closed = getClosed();
        if (closed != null) {
            this.joining = null;
            if (!joiningState.getDelegateClose()) {
                joiningState.getDelegatedTo().flush();
                joiningState.complete();
                return;
            }
            ReadWriteBufferState state = joiningState.getDelegatedTo().getState();
            boolean z = (state instanceof ReadWriteBufferState.Writing) || (state instanceof ReadWriteBufferState.ReadingWriting);
            if (closed.getCause() != null || !z) {
                joiningState.getDelegatedTo().close(closed.getCause());
            } else {
                joiningState.getDelegatedTo().flush();
            }
            joiningState.complete();
        }
    }

    static /* synthetic */ Object writeFully$suspendImpl(ByteBufferChannel byteBufferChannel, byte[] bArr, int i, int i2, Continuation continuation) {
        JoiningState joiningState = byteBufferChannel.joining;
        if (joiningState != null) {
            ByteBufferChannel resolveDelegation = byteBufferChannel.resolveDelegation(byteBufferChannel, joiningState);
            if (resolveDelegation != null) {
                Object writeFully = resolveDelegation.writeFully(bArr, i, i2, continuation);
                return writeFully == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? writeFully : Unit.INSTANCE;
            }
            Void voidR = null;
        }
        while (i2 > 0) {
            int writeAsMuchAsPossible = byteBufferChannel.writeAsMuchAsPossible(bArr, i, i2);
            if (writeAsMuchAsPossible == 0) {
                break;
            }
            i += writeAsMuchAsPossible;
            i2 -= writeAsMuchAsPossible;
        }
        if (i2 == 0) {
            return Unit.INSTANCE;
        }
        Object writeFullySuspend = byteBufferChannel.writeFullySuspend(bArr, i, i2, continuation);
        return writeFullySuspend == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? writeFullySuspend : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object writeFullySuspend(byte[] r6, int r7, int r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r5 = this;
            boolean r0 = r9 instanceof io.ktor.utils.io.ByteBufferChannel$writeFullySuspend$5
            if (r0 == 0) goto L_0x0014
            r0 = r9
            io.ktor.utils.io.ByteBufferChannel$writeFullySuspend$5 r0 = (io.ktor.utils.io.ByteBufferChannel$writeFullySuspend$5) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            io.ktor.utils.io.ByteBufferChannel$writeFullySuspend$5 r0 = new io.ktor.utils.io.ByteBufferChannel$writeFullySuspend$5
            r0.<init>(r5, r9)
        L_0x0019:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003e
            if (r2 != r3) goto L_0x0036
            int r6 = r0.I$1
            int r7 = r0.I$0
            java.lang.Object r8 = r0.L$1
            byte[] r8 = (byte[]) r8
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.ByteBufferChannel r2 = (io.ktor.utils.io.ByteBufferChannel) r2
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0058
        L_0x0036:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x003e:
            kotlin.ResultKt.throwOnFailure(r9)
            r2 = r5
        L_0x0042:
            if (r8 <= 0) goto L_0x0064
            r0.L$0 = r2
            r0.L$1 = r6
            r0.I$0 = r7
            r0.I$1 = r8
            r0.label = r3
            java.lang.Object r9 = r2.writeAvailable(r6, r7, r8, r0)
            if (r9 != r1) goto L_0x0055
            return r1
        L_0x0055:
            r4 = r8
            r8 = r6
            r6 = r4
        L_0x0058:
            java.lang.Number r9 = (java.lang.Number) r9
            int r9 = r9.intValue()
            int r7 = r7 + r9
            int r6 = r6 - r9
            r4 = r8
            r8 = r6
            r6 = r4
            goto L_0x0042
        L_0x0064:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.writeFullySuspend(byte[], int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object writeAvailable$suspendImpl(ByteBufferChannel byteBufferChannel, byte[] bArr, int i, int i2, Continuation continuation) {
        JoiningState joiningState = byteBufferChannel.joining;
        if (joiningState != null) {
            ByteBufferChannel resolveDelegation = byteBufferChannel.resolveDelegation(byteBufferChannel, joiningState);
            if (resolveDelegation != null) {
                return resolveDelegation.writeAvailable(bArr, i, i2, continuation);
            }
            Void voidR = null;
        }
        int writeAsMuchAsPossible = byteBufferChannel.writeAsMuchAsPossible(bArr, i, i2);
        if (writeAsMuchAsPossible > 0) {
            return Boxing.boxInt(writeAsMuchAsPossible);
        }
        return byteBufferChannel.writeSuspend(bArr, i, i2, continuation);
    }

    /* access modifiers changed from: private */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x005c A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x007e  */
    public final java.lang.Object writeSuspend(byte[] r8, int r9, int r10, kotlin.coroutines.Continuation<? super java.lang.Integer> r11) {
        /*
            r7 = this;
            boolean r0 = r11 instanceof io.ktor.utils.io.ByteBufferChannel$writeSuspend$1
            if (r0 == 0) goto L_0x0014
            r0 = r11
            io.ktor.utils.io.ByteBufferChannel$writeSuspend$1 r0 = (io.ktor.utils.io.ByteBufferChannel$writeSuspend$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L_0x0019
        L_0x0014:
            io.ktor.utils.io.ByteBufferChannel$writeSuspend$1 r0 = new io.ktor.utils.io.ByteBufferChannel$writeSuspend$1
            r0.<init>(r7, r11)
        L_0x0019:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0048
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x0075
        L_0x002d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0035:
            int r8 = r0.I$1
            int r9 = r0.I$0
            java.lang.Object r10 = r0.L$1
            byte[] r10 = (byte[]) r10
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.ByteBufferChannel r2 = (io.ktor.utils.io.ByteBufferChannel) r2
            kotlin.ResultKt.throwOnFailure(r11)
            r6 = r10
            r10 = r8
            r8 = r6
            goto L_0x005d
        L_0x0048:
            kotlin.ResultKt.throwOnFailure(r11)
            r2 = r7
        L_0x004c:
            r0.L$0 = r2
            r0.L$1 = r8
            r0.I$0 = r9
            r0.I$1 = r10
            r0.label = r4
            java.lang.Object r11 = r2.tryWriteSuspend$ktor_io(r4, r0)
            if (r11 != r1) goto L_0x005d
            return r1
        L_0x005d:
            io.ktor.utils.io.internal.JoiningState r11 = r2.joining
            if (r11 == 0) goto L_0x0078
            io.ktor.utils.io.ByteBufferChannel r11 = r2.resolveDelegation(r2, r11)
            r5 = 0
            if (r11 == 0) goto L_0x0076
            r0.L$0 = r5
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r11 = r11.writeSuspend(r8, r9, r10, r0)
            if (r11 != r1) goto L_0x0075
            return r1
        L_0x0075:
            return r11
        L_0x0076:
            java.lang.Void r5 = (java.lang.Void) r5
        L_0x0078:
            int r11 = r2.writeAsMuchAsPossible(r8, r9, r10)
            if (r11 <= 0) goto L_0x004c
            java.lang.Integer r8 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r11)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.writeSuspend(byte[], int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ java.lang.Object write$suspendImpl(io.ktor.utils.io.ByteBufferChannel r5, int r6, kotlin.jvm.functions.Function1 r7, kotlin.coroutines.Continuation r8) {
        /*
            boolean r0 = r8 instanceof io.ktor.utils.io.ByteBufferChannel$write$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            io.ktor.utils.io.ByteBufferChannel$write$1 r0 = (io.ktor.utils.io.ByteBufferChannel$write$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            io.ktor.utils.io.ByteBufferChannel$write$1 r0 = new io.ktor.utils.io.ByteBufferChannel$write$1
            r0.<init>(r5, r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0040
            if (r2 != r3) goto L_0x0038
            int r5 = r0.I$0
            java.lang.Object r6 = r0.L$1
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            java.lang.Object r7 = r0.L$0
            io.ktor.utils.io.ByteBufferChannel r7 = (io.ktor.utils.io.ByteBufferChannel) r7
            kotlin.ResultKt.throwOnFailure(r8)
            r4 = r6
            r6 = r5
            r5 = r7
            r7 = r4
            goto L_0x0052
        L_0x0038:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0040:
            kotlin.ResultKt.throwOnFailure(r8)
            r8 = 0
            if (r6 <= 0) goto L_0x0048
            r2 = r3
            goto L_0x0049
        L_0x0048:
            r2 = r8
        L_0x0049:
            if (r2 == 0) goto L_0x008a
            r2 = 4088(0xff8, float:5.729E-42)
            if (r6 > r2) goto L_0x0050
            r8 = r3
        L_0x0050:
            if (r8 == 0) goto L_0x006a
        L_0x0052:
            int r8 = r5.writeAvailable((int) r6, (kotlin.jvm.functions.Function1<? super java.nio.ByteBuffer, kotlin.Unit>) r7)
            if (r8 < 0) goto L_0x005b
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L_0x005b:
            r0.L$0 = r5
            r0.L$1 = r7
            r0.I$0 = r6
            r0.label = r3
            java.lang.Object r8 = r5.awaitFreeSpaceOrDelegate(r6, r7, r0)
            if (r8 != r1) goto L_0x0052
            return r1
        L_0x006a:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r7 = "Min("
            r5.append(r7)
            r5.append(r6)
            java.lang.String r6 = ") should'nt be greater than (4088)"
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.String r5 = r5.toString()
            r6.<init>(r5)
            throw r6
        L_0x008a:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r6 = "min should be positive"
            java.lang.String r6 = r6.toString()
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.write$suspendImpl(io.ktor.utils.io.ByteBufferChannel, int, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object awaitFreeSpaceOrDelegate(int r6, kotlin.jvm.functions.Function1<? super java.nio.ByteBuffer, kotlin.Unit> r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof io.ktor.utils.io.ByteBufferChannel$awaitFreeSpaceOrDelegate$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            io.ktor.utils.io.ByteBufferChannel$awaitFreeSpaceOrDelegate$1 r0 = (io.ktor.utils.io.ByteBufferChannel$awaitFreeSpaceOrDelegate$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            io.ktor.utils.io.ByteBufferChannel$awaitFreeSpaceOrDelegate$1 r0 = new io.ktor.utils.io.ByteBufferChannel$awaitFreeSpaceOrDelegate$1
            r0.<init>(r5, r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0043
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x006e
        L_0x002d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0035:
            int r6 = r0.I$0
            java.lang.Object r7 = r0.L$1
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.ByteBufferChannel r2 = (io.ktor.utils.io.ByteBufferChannel) r2
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0056
        L_0x0043:
            kotlin.ResultKt.throwOnFailure(r8)
            r0.L$0 = r5
            r0.L$1 = r7
            r0.I$0 = r6
            r0.label = r4
            java.lang.Object r8 = r5.writeSuspend(r6, r0)
            if (r8 != r1) goto L_0x0055
            return r1
        L_0x0055:
            r2 = r5
        L_0x0056:
            io.ktor.utils.io.internal.JoiningState r8 = r2.joining
            if (r8 == 0) goto L_0x0073
            io.ktor.utils.io.ByteBufferChannel r8 = r2.resolveDelegation(r2, r8)
            r2 = 0
            if (r8 == 0) goto L_0x0071
            r0.L$0 = r2
            r0.L$1 = r2
            r0.label = r3
            java.lang.Object r6 = r8.write(r6, r7, r0)
            if (r6 != r1) goto L_0x006e
            return r1
        L_0x006e:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L_0x0071:
            java.lang.Void r2 = (java.lang.Void) r2
        L_0x0073:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.awaitFreeSpaceOrDelegate(int, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object writeWhile$suspendImpl(ByteBufferChannel byteBufferChannel, Function1 function1, Continuation continuation) {
        if (!byteBufferChannel.writeWhileNoSuspend(function1)) {
            return Unit.INSTANCE;
        }
        ClosedElement closed = byteBufferChannel.getClosed();
        if (closed == null) {
            Object writeWhileSuspend = byteBufferChannel.writeWhileSuspend(function1, continuation);
            return writeWhileSuspend == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? writeWhileSuspend : Unit.INSTANCE;
        }
        Void unused = ByteBufferChannelKt.rethrowClosed(closed.getSendException());
        throw new KotlinNothingValueException();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0077, code lost:
        r4 = resolveDelegation(r1, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00d7, code lost:
        if (r4.getClosed() != null) goto L_0x00d9;
     */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00c4 A[Catch:{ all -> 0x0066 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00c9 A[Catch:{ all -> 0x0066 }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0104  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x015e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object writeWhileSuspend(kotlin.jvm.functions.Function1<? super java.nio.ByteBuffer, java.lang.Boolean> r18, kotlin.coroutines.Continuation<? super kotlin.Unit> r19) {
        /*
            r17 = this;
            r1 = r17
            r0 = r19
            boolean r2 = r0 instanceof io.ktor.utils.io.ByteBufferChannel$writeWhileSuspend$1
            if (r2 == 0) goto L_0x0018
            r2 = r0
            io.ktor.utils.io.ByteBufferChannel$writeWhileSuspend$1 r2 = (io.ktor.utils.io.ByteBufferChannel$writeWhileSuspend$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r0 = r2.label
            int r0 = r0 - r4
            r2.label = r0
            goto L_0x001d
        L_0x0018:
            io.ktor.utils.io.ByteBufferChannel$writeWhileSuspend$1 r2 = new io.ktor.utils.io.ByteBufferChannel$writeWhileSuspend$1
            r2.<init>(r1, r0)
        L_0x001d:
            java.lang.Object r0 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 2
            r6 = 1
            if (r4 == 0) goto L_0x0069
            if (r4 == r6) goto L_0x003a
            if (r4 != r5) goto L_0x0032
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x012b
        L_0x0032:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x003a:
            long r7 = r2.J$0
            java.lang.Object r4 = r2.L$8
            io.ktor.utils.io.ByteBufferChannel r4 = (io.ktor.utils.io.ByteBufferChannel) r4
            java.lang.Object r9 = r2.L$7
            java.nio.ByteBuffer r9 = (java.nio.ByteBuffer) r9
            java.lang.Object r10 = r2.L$6
            io.ktor.utils.io.internal.RingBufferCapacity r10 = (io.ktor.utils.io.internal.RingBufferCapacity) r10
            java.lang.Object r11 = r2.L$5
            io.ktor.utils.io.internal.RingBufferCapacity r11 = (io.ktor.utils.io.internal.RingBufferCapacity) r11
            java.lang.Object r12 = r2.L$4
            io.ktor.utils.io.ByteBufferChannel r12 = (io.ktor.utils.io.ByteBufferChannel) r12
            java.lang.Object r13 = r2.L$3
            io.ktor.utils.io.ByteBufferChannel r13 = (io.ktor.utils.io.ByteBufferChannel) r13
            java.lang.Object r14 = r2.L$2
            kotlin.jvm.internal.Ref$BooleanRef r14 = (kotlin.jvm.internal.Ref.BooleanRef) r14
            java.lang.Object r15 = r2.L$1
            kotlin.jvm.functions.Function1 r15 = (kotlin.jvm.functions.Function1) r15
            java.lang.Object r5 = r2.L$0
            io.ktor.utils.io.ByteBufferChannel r5 = (io.ktor.utils.io.ByteBufferChannel) r5
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ all -> 0x0066 }
            r0 = r15
            goto L_0x00c5
        L_0x0066:
            r0 = move-exception
            goto L_0x014d
        L_0x0069:
            kotlin.ResultKt.throwOnFailure(r0)
            kotlin.jvm.internal.Ref$BooleanRef r0 = new kotlin.jvm.internal.Ref$BooleanRef
            r0.<init>()
            r0.element = r6
            io.ktor.utils.io.internal.JoiningState r4 = r1.joining
            if (r4 == 0) goto L_0x0080
            io.ktor.utils.io.ByteBufferChannel r4 = r1.resolveDelegation(r1, r4)
            if (r4 != 0) goto L_0x007e
            goto L_0x0080
        L_0x007e:
            r12 = r4
            goto L_0x0081
        L_0x0080:
            r12 = r1
        L_0x0081:
            java.nio.ByteBuffer r4 = r12.setupStateForWrite$ktor_io()
            if (r4 != 0) goto L_0x008d
            r14 = r0
            r5 = r1
            r0 = r18
            goto L_0x00fd
        L_0x008d:
            io.ktor.utils.io.internal.ReadWriteBufferState r5 = r12.getState()
            io.ktor.utils.io.internal.RingBufferCapacity r11 = r5.capacity
            long r7 = r12.getTotalBytesWritten()
            io.ktor.utils.io.internal.ClosedElement r5 = r12.getClosed()     // Catch:{ all -> 0x014b }
            if (r5 != 0) goto L_0x013e
            r5 = r12
            io.ktor.utils.io.ByteBufferChannel r5 = (io.ktor.utils.io.ByteBufferChannel) r5     // Catch:{ all -> 0x014b }
            r14 = r0
            r13 = r1
            r9 = r4
            r4 = r5
            r10 = r11
            r0 = r18
            r5 = r13
        L_0x00a8:
            r2.L$0 = r5     // Catch:{ all -> 0x0066 }
            r2.L$1 = r0     // Catch:{ all -> 0x0066 }
            r2.L$2 = r14     // Catch:{ all -> 0x0066 }
            r2.L$3 = r13     // Catch:{ all -> 0x0066 }
            r2.L$4 = r12     // Catch:{ all -> 0x0066 }
            r2.L$5 = r11     // Catch:{ all -> 0x0066 }
            r2.L$6 = r10     // Catch:{ all -> 0x0066 }
            r2.L$7 = r9     // Catch:{ all -> 0x0066 }
            r2.L$8 = r4     // Catch:{ all -> 0x0066 }
            r2.J$0 = r7     // Catch:{ all -> 0x0066 }
            r2.label = r6     // Catch:{ all -> 0x0066 }
            java.lang.Object r15 = r4.writeSuspend(r6, r2)     // Catch:{ all -> 0x0066 }
            if (r15 != r3) goto L_0x00c5
            return r3
        L_0x00c5:
            io.ktor.utils.io.internal.JoiningState r15 = r4.joining     // Catch:{ all -> 0x0066 }
            if (r15 != 0) goto L_0x00d9
            boolean r15 = r4.writeWhileLoop(r9, r10, r0)     // Catch:{ all -> 0x0066 }
            if (r15 != 0) goto L_0x00d3
            r4 = 0
            r14.element = r4     // Catch:{ all -> 0x0066 }
            goto L_0x00d9
        L_0x00d3:
            io.ktor.utils.io.internal.ClosedElement r15 = r4.getClosed()     // Catch:{ all -> 0x0066 }
            if (r15 == 0) goto L_0x00a8
        L_0x00d9:
            boolean r4 = r11.isFull()
            if (r4 != 0) goto L_0x00e5
            boolean r4 = r12.getAutoFlush()
            if (r4 == 0) goto L_0x00e8
        L_0x00e5:
            r12.flush()
        L_0x00e8:
            if (r12 == r13) goto L_0x00f7
            long r9 = r13.getTotalBytesWritten()
            long r15 = r12.getTotalBytesWritten()
            long r15 = r15 - r7
            long r9 = r9 + r15
            r13.setTotalBytesWritten$ktor_io(r9)
        L_0x00f7:
            r12.restoreStateAfterWrite$ktor_io()
            r12.tryTerminate$ktor_io()
        L_0x00fd:
            boolean r4 = r14.element
            if (r4 != 0) goto L_0x0104
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x0104:
            io.ktor.utils.io.internal.ClosedElement r4 = r5.getClosed()
            if (r4 != 0) goto L_0x0131
            io.ktor.utils.io.internal.JoiningState r4 = r5.joining
            if (r4 == 0) goto L_0x012e
            r4 = 0
            r2.L$0 = r4
            r2.L$1 = r4
            r2.L$2 = r4
            r2.L$3 = r4
            r2.L$4 = r4
            r2.L$5 = r4
            r2.L$6 = r4
            r2.L$7 = r4
            r2.L$8 = r4
            r4 = 2
            r2.label = r4
            java.lang.Object r0 = r5.writeWhile(r0, r2)
            if (r0 != r3) goto L_0x012b
            return r3
        L_0x012b:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x012e:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x0131:
            java.lang.Throwable r0 = r4.getSendException()
            java.lang.Void unused = io.ktor.utils.io.ByteBufferChannelKt.rethrowClosed(r0)
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException
            r0.<init>()
            throw r0
        L_0x013e:
            java.lang.Throwable r0 = r5.getSendException()     // Catch:{ all -> 0x014b }
            java.lang.Void unused = io.ktor.utils.io.ByteBufferChannelKt.rethrowClosed(r0)     // Catch:{ all -> 0x014b }
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException     // Catch:{ all -> 0x014b }
            r0.<init>()     // Catch:{ all -> 0x014b }
            throw r0     // Catch:{ all -> 0x014b }
        L_0x014b:
            r0 = move-exception
            r13 = r1
        L_0x014d:
            boolean r2 = r11.isFull()
            if (r2 != 0) goto L_0x0159
            boolean r2 = r12.getAutoFlush()
            if (r2 == 0) goto L_0x015c
        L_0x0159:
            r12.flush()
        L_0x015c:
            if (r12 == r13) goto L_0x016b
            long r2 = r13.getTotalBytesWritten()
            long r4 = r12.getTotalBytesWritten()
            long r4 = r4 - r7
            long r2 = r2 + r4
            r13.setTotalBytesWritten$ktor_io(r2)
        L_0x016b:
            r12.restoreStateAfterWrite$ktor_io()
            r12.tryTerminate$ktor_io()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.writeWhileSuspend(kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final boolean writeWhileLoop(ByteBuffer byteBuffer, RingBufferCapacity ringBufferCapacity, Function1<? super ByteBuffer, Boolean> function1) {
        int capacity = byteBuffer.capacity() - this.reservedSize;
        boolean z = true;
        while (z) {
            int tryWriteAtLeast = ringBufferCapacity.tryWriteAtLeast(1);
            if (tryWriteAtLeast == 0) {
                break;
            }
            int i = this.writePosition;
            int coerceAtMost = RangesKt.coerceAtMost(i + tryWriteAtLeast, capacity);
            byteBuffer.limit(coerceAtMost);
            byteBuffer.position(i);
            try {
                boolean booleanValue = ((Boolean) function1.invoke(byteBuffer)).booleanValue();
                boolean z2 = false;
                if (byteBuffer.limit() == coerceAtMost) {
                    int position = byteBuffer.position() - i;
                    if (position >= 0) {
                        z2 = true;
                    }
                    if (z2) {
                        bytesWritten(byteBuffer, ringBufferCapacity, position);
                        if (position < tryWriteAtLeast) {
                            tryWriteAtLeast -= position;
                        }
                        z = booleanValue;
                    } else {
                        throw new IllegalStateException("Position has been moved backward: pushback is not supported.".toString());
                    }
                } else {
                    throw new IllegalStateException("Buffer limit modified.".toString());
                }
            } finally {
                ringBufferCapacity.completeRead(tryWriteAtLeast);
            }
        }
        return z;
    }

    public SuspendableReadSession startReadSession() {
        return this.readSession;
    }

    public void endReadSession() {
        this.readSession.completed();
        ReadWriteBufferState state = getState();
        if ((state instanceof ReadWriteBufferState.Reading) || (state instanceof ReadWriteBufferState.ReadingWriting)) {
            restoreStateAfterRead();
            tryTerminate$ktor_io();
        }
    }

    public WriterSuspendSession beginWriteSession() {
        WriteSessionImpl writeSessionImpl = this.writeSession;
        writeSessionImpl.begin();
        return writeSessionImpl;
    }

    public void endWriteSession(int i) {
        this.writeSession.written(i);
        this.writeSession.complete();
    }

    @Deprecated(message = "Use read { } instead.")
    public void readSession(Function1<? super ReadSession, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "consumer");
        lookAhead(new ByteBufferChannel$readSession$1(function1, this));
    }

    @Deprecated(message = "Use read { } instead.")
    static /* synthetic */ Object readSuspendableSession$suspendImpl(ByteBufferChannel byteBufferChannel, Function2 function2, Continuation continuation) {
        Object lookAheadSuspend = byteBufferChannel.lookAheadSuspend(new ByteBufferChannel$readSuspendableSession$2(function2, byteBufferChannel, (Continuation<? super ByteBufferChannel$readSuspendableSession$2>) null), continuation);
        return lookAheadSuspend == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? lookAheadSuspend : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x008f, code lost:
        if (r13.isClosedForRead() != false) goto L_0x00b1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0091, code lost:
        r0.L$0 = r13;
        r0.L$1 = r12;
        r0.J$0 = r10;
        r0.label = 1;
        r14 = r13.readSuspend(1, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x009d, code lost:
        if (r14 != r1) goto L_0x00a0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x009f, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00a6, code lost:
        if (((java.lang.Boolean) r14).booleanValue() != false) goto L_0x004a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object discardSuspend(long r10, long r12, kotlin.coroutines.Continuation<? super java.lang.Long> r14) {
        /*
            r9 = this;
            boolean r0 = r14 instanceof io.ktor.utils.io.ByteBufferChannel$discardSuspend$1
            if (r0 == 0) goto L_0x0014
            r0 = r14
            io.ktor.utils.io.ByteBufferChannel$discardSuspend$1 r0 = (io.ktor.utils.io.ByteBufferChannel$discardSuspend$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r14 = r0.label
            int r14 = r14 - r2
            r0.label = r14
            goto L_0x0019
        L_0x0014:
            io.ktor.utils.io.ByteBufferChannel$discardSuspend$1 r0 = new io.ktor.utils.io.ByteBufferChannel$discardSuspend$1
            r0.<init>(r9, r14)
        L_0x0019:
            java.lang.Object r14 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003d
            if (r2 != r3) goto L_0x0035
            long r10 = r0.J$0
            java.lang.Object r12 = r0.L$1
            kotlin.jvm.internal.Ref$LongRef r12 = (kotlin.jvm.internal.Ref.LongRef) r12
            java.lang.Object r13 = r0.L$0
            io.ktor.utils.io.ByteBufferChannel r13 = (io.ktor.utils.io.ByteBufferChannel) r13
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x00a0
        L_0x0035:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r14)
            kotlin.jvm.internal.Ref$LongRef r14 = new kotlin.jvm.internal.Ref$LongRef
            r14.<init>()
            r14.element = r10
            r10 = r12
            r12 = r14
            r13 = r9
        L_0x004a:
            long r4 = r12.element
            int r14 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r14 >= 0) goto L_0x00b1
            java.nio.ByteBuffer r14 = r13.setupStateForRead()
            r2 = 0
            if (r14 != 0) goto L_0x0058
            goto L_0x0089
        L_0x0058:
            io.ktor.utils.io.internal.ReadWriteBufferState r4 = r13.getState()
            io.ktor.utils.io.internal.RingBufferCapacity r4 = r4.capacity
            int r5 = r4._availableForRead$internal     // Catch:{ all -> 0x00a9 }
            if (r5 != 0) goto L_0x0069
            r13.restoreStateAfterRead()
            r13.tryTerminate$ktor_io()
            goto L_0x0089
        L_0x0069:
            r5 = 2147483647(0x7fffffff, double:1.060997895E-314)
            long r7 = r12.element     // Catch:{ all -> 0x00a9 }
            long r7 = r10 - r7
            long r5 = java.lang.Math.min(r5, r7)     // Catch:{ all -> 0x00a9 }
            int r2 = (int) r5     // Catch:{ all -> 0x00a9 }
            int r2 = r4.tryReadAtMost(r2)     // Catch:{ all -> 0x00a9 }
            r13.bytesRead(r14, r4, r2)     // Catch:{ all -> 0x00a9 }
            long r4 = r12.element     // Catch:{ all -> 0x00a9 }
            long r6 = (long) r2     // Catch:{ all -> 0x00a9 }
            long r4 = r4 + r6
            r12.element = r4     // Catch:{ all -> 0x00a9 }
            r13.restoreStateAfterRead()
            r13.tryTerminate$ktor_io()
            r2 = r3
        L_0x0089:
            if (r2 != 0) goto L_0x004a
            boolean r14 = r13.isClosedForRead()
            if (r14 != 0) goto L_0x00b1
            r0.L$0 = r13
            r0.L$1 = r12
            r0.J$0 = r10
            r0.label = r3
            java.lang.Object r14 = r13.readSuspend(r3, r0)
            if (r14 != r1) goto L_0x00a0
            return r1
        L_0x00a0:
            java.lang.Boolean r14 = (java.lang.Boolean) r14
            boolean r14 = r14.booleanValue()
            if (r14 != 0) goto L_0x004a
            goto L_0x00b1
        L_0x00a9:
            r10 = move-exception
            r13.restoreStateAfterRead()
            r13.tryTerminate$ktor_io()
            throw r10
        L_0x00b1:
            long r10 = r12.element
            java.lang.Long r10 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r10)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.discardSuspend(long, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object readBlockSuspend(int r6, kotlin.jvm.functions.Function1<? super java.nio.ByteBuffer, kotlin.Unit> r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof io.ktor.utils.io.ByteBufferChannel$readBlockSuspend$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            io.ktor.utils.io.ByteBufferChannel$readBlockSuspend$1 r0 = (io.ktor.utils.io.ByteBufferChannel$readBlockSuspend$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            io.ktor.utils.io.ByteBufferChannel$readBlockSuspend$1 r0 = new io.ktor.utils.io.ByteBufferChannel$readBlockSuspend$1
            r0.<init>(r5, r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0043
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0091
        L_0x002d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0035:
            int r6 = r0.I$0
            java.lang.Object r7 = r0.L$1
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.ByteBufferChannel r2 = (io.ktor.utils.io.ByteBufferChannel) r2
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x005a
        L_0x0043:
            kotlin.ResultKt.throwOnFailure(r8)
            int r8 = kotlin.ranges.RangesKt.coerceAtLeast(r6, r4)
            r0.L$0 = r5
            r0.L$1 = r7
            r0.I$0 = r6
            r0.label = r4
            java.lang.Object r8 = r5.readSuspend(r8, r0)
            if (r8 != r1) goto L_0x0059
            return r1
        L_0x0059:
            r2 = r5
        L_0x005a:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 != 0) goto L_0x0083
            if (r6 > 0) goto L_0x0067
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L_0x0067:
            java.io.EOFException r7 = new java.io.EOFException
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r0 = "Got EOF but at least "
            r8.append(r0)
            r8.append(r6)
            java.lang.String r6 = " bytes were expected"
            r8.append(r6)
            java.lang.String r6 = r8.toString()
            r7.<init>(r6)
            throw r7
        L_0x0083:
            r8 = 0
            r0.L$0 = r8
            r0.L$1 = r8
            r0.label = r3
            java.lang.Object r6 = r2.read(r6, r7, r0)
            if (r6 != r1) goto L_0x0091
            return r1
        L_0x0091:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.readBlockSuspend(int, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object writePacket$suspendImpl(ByteBufferChannel byteBufferChannel, ByteReadPacket byteReadPacket, Continuation continuation) {
        JoiningState joiningState = byteBufferChannel.joining;
        if (joiningState != null) {
            ByteBufferChannel resolveDelegation = byteBufferChannel.resolveDelegation(byteBufferChannel, joiningState);
            if (resolveDelegation != null) {
                Object writePacket = resolveDelegation.writePacket(byteReadPacket, continuation);
                return writePacket == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? writePacket : Unit.INSTANCE;
            }
            Void voidR = null;
        }
        do {
            try {
                if (!(!byteReadPacket.getEndOfInput()) || byteBufferChannel.tryWritePacketPart(byteReadPacket) == 0) {
                }
                break;
            } catch (Throwable th) {
                byteReadPacket.release();
                throw th;
            }
        } while (byteBufferChannel.tryWritePacketPart(byteReadPacket) == 0);
        if (byteReadPacket.getRemaining() <= 0) {
            return Unit.INSTANCE;
        }
        JoiningState joiningState2 = byteBufferChannel.joining;
        if (joiningState2 != null) {
            ByteBufferChannel resolveDelegation2 = byteBufferChannel.resolveDelegation(byteBufferChannel, joiningState2);
            if (resolveDelegation2 != null) {
                Object writePacket2 = resolveDelegation2.writePacket(byteReadPacket, continuation);
                return writePacket2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? writePacket2 : Unit.INSTANCE;
            }
            Void voidR2 = null;
        }
        Object writePacketSuspend = byteBufferChannel.writePacketSuspend(byteReadPacket, continuation);
        return writePacketSuspend == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? writePacketSuspend : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0052 A[Catch:{ all -> 0x0045 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0063 A[Catch:{ all -> 0x0045 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object writePacketSuspend(io.ktor.utils.io.core.ByteReadPacket r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof io.ktor.utils.io.ByteBufferChannel$writePacketSuspend$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            io.ktor.utils.io.ByteBufferChannel$writePacketSuspend$1 r0 = (io.ktor.utils.io.ByteBufferChannel$writePacketSuspend$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            io.ktor.utils.io.ByteBufferChannel$writePacketSuspend$1 r0 = new io.ktor.utils.io.ByteBufferChannel$writePacketSuspend$1
            r0.<init>(r6, r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0047
            if (r2 == r4) goto L_0x0039
            if (r2 != r3) goto L_0x0031
            java.lang.Object r7 = r0.L$0
            io.ktor.utils.io.core.ByteReadPacket r7 = (io.ktor.utils.io.core.ByteReadPacket) r7
            kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ all -> 0x0045 }
            goto L_0x0077
        L_0x0031:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0039:
            java.lang.Object r7 = r0.L$1
            io.ktor.utils.io.core.ByteReadPacket r7 = (io.ktor.utils.io.core.ByteReadPacket) r7
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.ByteBufferChannel r2 = (io.ktor.utils.io.ByteBufferChannel) r2
            kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ all -> 0x0045 }
            goto L_0x005f
        L_0x0045:
            r8 = move-exception
            goto L_0x0089
        L_0x0047:
            kotlin.ResultKt.throwOnFailure(r8)
            r2 = r6
        L_0x004b:
            boolean r8 = r7.getEndOfInput()     // Catch:{ all -> 0x0045 }
            r8 = r8 ^ r4
            if (r8 == 0) goto L_0x0083
            r0.L$0 = r2     // Catch:{ all -> 0x0045 }
            r0.L$1 = r7     // Catch:{ all -> 0x0045 }
            r0.label = r4     // Catch:{ all -> 0x0045 }
            java.lang.Object r8 = r2.writeSuspend(r4, r0)     // Catch:{ all -> 0x0045 }
            if (r8 != r1) goto L_0x005f
            return r1
        L_0x005f:
            io.ktor.utils.io.internal.JoiningState r8 = r2.joining     // Catch:{ all -> 0x0045 }
            if (r8 == 0) goto L_0x007f
            io.ktor.utils.io.ByteBufferChannel r8 = r2.resolveDelegation(r2, r8)     // Catch:{ all -> 0x0045 }
            r5 = 0
            if (r8 == 0) goto L_0x007d
            r0.L$0 = r7     // Catch:{ all -> 0x0045 }
            r0.L$1 = r5     // Catch:{ all -> 0x0045 }
            r0.label = r3     // Catch:{ all -> 0x0045 }
            java.lang.Object r8 = r8.writePacket(r7, r0)     // Catch:{ all -> 0x0045 }
            if (r8 != r1) goto L_0x0077
            return r1
        L_0x0077:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0045 }
            r7.release()
            return r8
        L_0x007d:
            java.lang.Void r5 = (java.lang.Void) r5     // Catch:{ all -> 0x0045 }
        L_0x007f:
            r2.tryWritePacketPart(r7)     // Catch:{ all -> 0x0045 }
            goto L_0x004b
        L_0x0083:
            r7.release()
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        L_0x0089:
            r7.release()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.writePacketSuspend(io.ktor.utils.io.core.ByteReadPacket, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Deprecated(message = "Use read { } instead.")
    public <R> R lookAhead(Function1<? super LookAheadSession, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(function1, "visitor");
        Throwable closedCause = getClosedCause();
        if (closedCause != null) {
            return function1.invoke(new FailedLookAhead(closedCause));
        }
        if (getState() == ReadWriteBufferState.Terminated.INSTANCE) {
            return function1.invoke(TerminatedLookAhead.INSTANCE);
        }
        R r = null;
        boolean z = false;
        if (setupStateForRead() != null) {
            try {
                if (getState().capacity._availableForRead$internal != 0) {
                    r = function1.invoke(this);
                    z = true;
                }
            } finally {
                restoreStateAfterRead();
                tryTerminate$ktor_io();
            }
        }
        if (!z) {
            Throwable closedCause2 = getClosedCause();
            if (closedCause2 != null) {
                return function1.invoke(new FailedLookAhead(closedCause2));
            }
            return function1.invoke(TerminatedLookAhead.INSTANCE);
        }
        Intrinsics.checkNotNull(r);
        return r;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0087, code lost:
        return r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x009c, code lost:
        return r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
        r7.element = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00d6, code lost:
        r8.restoreStateAfterRead();
        r8.tryTerminate$ktor_io();
        r9 = r2;
        r8 = r3;
        r3 = true;
        r7 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00e0, code lost:
        if (r3 != false) goto L_0x017a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00e2, code lost:
        r2 = r7.getClosedCause();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00e7, code lost:
        if (r2 == null) goto L_0x0103;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00e9, code lost:
        r7 = new io.ktor.utils.io.internal.FailedLookAhead(r2);
        r0.L$0 = null;
        r0.L$1 = null;
        r0.L$2 = null;
        r0.L$3 = null;
        r0.L$4 = null;
        r0.label = 4;
        r9 = r8.invoke(r7, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00ff, code lost:
        if (r9 != r1) goto L_0x0102;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0101, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0102, code lost:
        return r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0109, code lost:
        if (r7.getState() != io.ktor.utils.io.internal.ReadWriteBufferState.Terminated.INSTANCE) goto L_0x0122;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x010b, code lost:
        r7 = io.ktor.utils.io.internal.TerminatedLookAhead.INSTANCE;
        r0.L$0 = null;
        r0.L$1 = null;
        r0.L$2 = null;
        r0.L$3 = null;
        r0.L$4 = null;
        r0.label = 5;
        r9 = r8.invoke(r7, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x011e, code lost:
        if (r9 != r1) goto L_0x0121;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0120, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0121, code lost:
        return r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:?, code lost:
        r0.L$0 = r7;
        r0.L$1 = r9;
        r0.L$2 = r9;
        r0.L$3 = null;
        r0.L$4 = null;
        r0.label = 6;
        r8 = r8.invoke(r7, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0133, code lost:
        if (r8 != r1) goto L_0x0136;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0135, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0136, code lost:
        r0 = r7;
        r7 = r9;
        r9 = r8;
        r8 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:?, code lost:
        r7.element = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x013c, code lost:
        r7 = r0.getState();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0144, code lost:
        if (r7.getIdle() != false) goto L_0x0158;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0148, code lost:
        if (r7 == io.ktor.utils.io.internal.ReadWriteBufferState.Terminated.INSTANCE) goto L_0x0158;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x014c, code lost:
        if ((r7 instanceof io.ktor.utils.io.internal.ReadWriteBufferState.Reading) != false) goto L_0x0152;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0150, code lost:
        if ((r7 instanceof io.ktor.utils.io.internal.ReadWriteBufferState.ReadingWriting) == false) goto L_0x0155;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0152, code lost:
        r0.restoreStateAfterRead();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0155, code lost:
        r0.tryTerminate$ktor_io();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0158, code lost:
        r9 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x015a, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x015b, code lost:
        r0 = r7;
        r7 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x015d, code lost:
        r8 = r0.getState();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x0173, code lost:
        r0.restoreStateAfterRead();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x0176, code lost:
        r0.tryTerminate$ktor_io();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x0179, code lost:
        throw r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x017c, code lost:
        return r9.element;
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x002e  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    @kotlin.Deprecated(message = "Use read { } instead.")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ java.lang.Object lookAheadSuspend$suspendImpl(io.ktor.utils.io.ByteBufferChannel r7, kotlin.jvm.functions.Function2 r8, kotlin.coroutines.Continuation r9) {
        /*
            boolean r0 = r9 instanceof io.ktor.utils.io.ByteBufferChannel$lookAheadSuspend$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            io.ktor.utils.io.ByteBufferChannel$lookAheadSuspend$1 r0 = (io.ktor.utils.io.ByteBufferChannel$lookAheadSuspend$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            io.ktor.utils.io.ByteBufferChannel$lookAheadSuspend$1 r0 = new io.ktor.utils.io.ByteBufferChannel$lookAheadSuspend$1
            r0.<init>(r7, r9)
        L_0x0019:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            switch(r2) {
                case 0: goto L_0x0070;
                case 1: goto L_0x006c;
                case 2: goto L_0x0068;
                case 3: goto L_0x004c;
                case 4: goto L_0x0047;
                case 5: goto L_0x0042;
                case 6: goto L_0x002e;
                default: goto L_0x0026;
            }
        L_0x0026:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x002e:
            java.lang.Object r7 = r0.L$2
            kotlin.jvm.internal.Ref$ObjectRef r7 = (kotlin.jvm.internal.Ref.ObjectRef) r7
            java.lang.Object r8 = r0.L$1
            kotlin.jvm.internal.Ref$ObjectRef r8 = (kotlin.jvm.internal.Ref.ObjectRef) r8
            java.lang.Object r0 = r0.L$0
            io.ktor.utils.io.ByteBufferChannel r0 = (io.ktor.utils.io.ByteBufferChannel) r0
            kotlin.ResultKt.throwOnFailure(r9)     // Catch:{ all -> 0x003f }
            goto L_0x013a
        L_0x003f:
            r7 = move-exception
            goto L_0x015d
        L_0x0042:
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0121
        L_0x0047:
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0102
        L_0x004c:
            java.lang.Object r7 = r0.L$4
            kotlin.jvm.internal.Ref$ObjectRef r7 = (kotlin.jvm.internal.Ref.ObjectRef) r7
            java.lang.Object r8 = r0.L$3
            io.ktor.utils.io.ByteBufferChannel r8 = (io.ktor.utils.io.ByteBufferChannel) r8
            java.lang.Object r2 = r0.L$2
            kotlin.jvm.internal.Ref$ObjectRef r2 = (kotlin.jvm.internal.Ref.ObjectRef) r2
            java.lang.Object r3 = r0.L$1
            kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
            java.lang.Object r5 = r0.L$0
            io.ktor.utils.io.ByteBufferChannel r5 = (io.ktor.utils.io.ByteBufferChannel) r5
            kotlin.ResultKt.throwOnFailure(r9)     // Catch:{ all -> 0x0065 }
            goto L_0x00d4
        L_0x0065:
            r7 = move-exception
            goto L_0x0181
        L_0x0068:
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x009c
        L_0x006c:
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0087
        L_0x0070:
            kotlin.ResultKt.throwOnFailure(r9)
            java.lang.Throwable r9 = r7.getClosedCause()
            if (r9 == 0) goto L_0x0088
            io.ktor.utils.io.internal.FailedLookAhead r7 = new io.ktor.utils.io.internal.FailedLookAhead
            r7.<init>(r9)
            r0.label = r4
            java.lang.Object r9 = r8.invoke(r7, r0)
            if (r9 != r1) goto L_0x0087
            return r1
        L_0x0087:
            return r9
        L_0x0088:
            io.ktor.utils.io.internal.ReadWriteBufferState r9 = r7.getState()
            io.ktor.utils.io.internal.ReadWriteBufferState$Terminated r2 = io.ktor.utils.io.internal.ReadWriteBufferState.Terminated.INSTANCE
            if (r9 != r2) goto L_0x009d
            io.ktor.utils.io.internal.TerminatedLookAhead r7 = io.ktor.utils.io.internal.TerminatedLookAhead.INSTANCE
            r9 = 2
            r0.label = r9
            java.lang.Object r9 = r8.invoke(r7, r0)
            if (r9 != r1) goto L_0x009c
            return r1
        L_0x009c:
            return r9
        L_0x009d:
            kotlin.jvm.internal.Ref$ObjectRef r9 = new kotlin.jvm.internal.Ref$ObjectRef
            r9.<init>()
            java.nio.ByteBuffer r2 = r7.setupStateForRead()
            if (r2 != 0) goto L_0x00a9
            goto L_0x00e0
        L_0x00a9:
            io.ktor.utils.io.internal.ReadWriteBufferState r2 = r7.getState()
            io.ktor.utils.io.internal.RingBufferCapacity r2 = r2.capacity
            int r2 = r2._availableForRead$internal     // Catch:{ all -> 0x017d }
            if (r2 != 0) goto L_0x00ba
            r7.restoreStateAfterRead()
            r7.tryTerminate$ktor_io()
            goto L_0x00e0
        L_0x00ba:
            r0.L$0 = r7     // Catch:{ all -> 0x017d }
            r0.L$1 = r8     // Catch:{ all -> 0x017d }
            r0.L$2 = r9     // Catch:{ all -> 0x017d }
            r0.L$3 = r7     // Catch:{ all -> 0x017d }
            r0.L$4 = r9     // Catch:{ all -> 0x017d }
            r2 = 3
            r0.label = r2     // Catch:{ all -> 0x017d }
            java.lang.Object r2 = r8.invoke(r7, r0)     // Catch:{ all -> 0x017d }
            if (r2 != r1) goto L_0x00ce
            return r1
        L_0x00ce:
            r5 = r7
            r3 = r8
            r8 = r5
            r7 = r9
            r9 = r2
            r2 = r7
        L_0x00d4:
            r7.element = r9     // Catch:{ all -> 0x0065 }
            r8.restoreStateAfterRead()
            r8.tryTerminate$ktor_io()
            r9 = r2
            r8 = r3
            r3 = r4
            r7 = r5
        L_0x00e0:
            if (r3 != 0) goto L_0x017a
            java.lang.Throwable r2 = r7.getClosedCause()
            r3 = 0
            if (r2 == 0) goto L_0x0103
            io.ktor.utils.io.internal.FailedLookAhead r7 = new io.ktor.utils.io.internal.FailedLookAhead
            r7.<init>(r2)
            r0.L$0 = r3
            r0.L$1 = r3
            r0.L$2 = r3
            r0.L$3 = r3
            r0.L$4 = r3
            r9 = 4
            r0.label = r9
            java.lang.Object r9 = r8.invoke(r7, r0)
            if (r9 != r1) goto L_0x0102
            return r1
        L_0x0102:
            return r9
        L_0x0103:
            io.ktor.utils.io.internal.ReadWriteBufferState r2 = r7.getState()
            io.ktor.utils.io.internal.ReadWriteBufferState$Terminated r4 = io.ktor.utils.io.internal.ReadWriteBufferState.Terminated.INSTANCE
            if (r2 != r4) goto L_0x0122
            io.ktor.utils.io.internal.TerminatedLookAhead r7 = io.ktor.utils.io.internal.TerminatedLookAhead.INSTANCE
            r0.L$0 = r3
            r0.L$1 = r3
            r0.L$2 = r3
            r0.L$3 = r3
            r0.L$4 = r3
            r9 = 5
            r0.label = r9
            java.lang.Object r9 = r8.invoke(r7, r0)
            if (r9 != r1) goto L_0x0121
            return r1
        L_0x0121:
            return r9
        L_0x0122:
            r0.L$0 = r7     // Catch:{ all -> 0x015a }
            r0.L$1 = r9     // Catch:{ all -> 0x015a }
            r0.L$2 = r9     // Catch:{ all -> 0x015a }
            r0.L$3 = r3     // Catch:{ all -> 0x015a }
            r0.L$4 = r3     // Catch:{ all -> 0x015a }
            r2 = 6
            r0.label = r2     // Catch:{ all -> 0x015a }
            java.lang.Object r8 = r8.invoke(r7, r0)     // Catch:{ all -> 0x015a }
            if (r8 != r1) goto L_0x0136
            return r1
        L_0x0136:
            r0 = r7
            r7 = r9
            r9 = r8
            r8 = r7
        L_0x013a:
            r7.element = r9     // Catch:{ all -> 0x003f }
            io.ktor.utils.io.internal.ReadWriteBufferState r7 = r0.getState()
            boolean r9 = r7.getIdle()
            if (r9 != 0) goto L_0x0158
            io.ktor.utils.io.internal.ReadWriteBufferState$Terminated r9 = io.ktor.utils.io.internal.ReadWriteBufferState.Terminated.INSTANCE
            if (r7 == r9) goto L_0x0158
            boolean r9 = r7 instanceof io.ktor.utils.io.internal.ReadWriteBufferState.Reading
            if (r9 != 0) goto L_0x0152
            boolean r7 = r7 instanceof io.ktor.utils.io.internal.ReadWriteBufferState.ReadingWriting
            if (r7 == 0) goto L_0x0155
        L_0x0152:
            r0.restoreStateAfterRead()
        L_0x0155:
            r0.tryTerminate$ktor_io()
        L_0x0158:
            r9 = r8
            goto L_0x017a
        L_0x015a:
            r8 = move-exception
            r0 = r7
            r7 = r8
        L_0x015d:
            io.ktor.utils.io.internal.ReadWriteBufferState r8 = r0.getState()
            boolean r9 = r8.getIdle()
            if (r9 != 0) goto L_0x0179
            io.ktor.utils.io.internal.ReadWriteBufferState$Terminated r9 = io.ktor.utils.io.internal.ReadWriteBufferState.Terminated.INSTANCE
            if (r8 == r9) goto L_0x0179
            boolean r9 = r8 instanceof io.ktor.utils.io.internal.ReadWriteBufferState.Reading
            if (r9 != 0) goto L_0x0173
            boolean r8 = r8 instanceof io.ktor.utils.io.internal.ReadWriteBufferState.ReadingWriting
            if (r8 == 0) goto L_0x0176
        L_0x0173:
            r0.restoreStateAfterRead()
        L_0x0176:
            r0.tryTerminate$ktor_io()
        L_0x0179:
            throw r7
        L_0x017a:
            java.lang.Object r7 = r9.element
            return r7
        L_0x017d:
            r8 = move-exception
            r6 = r8
            r8 = r7
            r7 = r6
        L_0x0181:
            r8.restoreStateAfterRead()
            r8.tryTerminate$ktor_io()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.lookAheadSuspend$suspendImpl(io.ktor.utils.io.ByteBufferChannel, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @kotlin.Deprecated(message = "Use write { } instead.")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ java.lang.Object writeSuspendSession$suspendImpl(io.ktor.utils.io.ByteBufferChannel r4, kotlin.jvm.functions.Function2 r5, kotlin.coroutines.Continuation r6) {
        /*
            boolean r0 = r6 instanceof io.ktor.utils.io.ByteBufferChannel$writeSuspendSession$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            io.ktor.utils.io.ByteBufferChannel$writeSuspendSession$1 r0 = (io.ktor.utils.io.ByteBufferChannel$writeSuspendSession$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            io.ktor.utils.io.ByteBufferChannel$writeSuspendSession$1 r0 = new io.ktor.utils.io.ByteBufferChannel$writeSuspendSession$1
            r0.<init>(r4, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r4 = r0.L$0
            io.ktor.utils.io.internal.WriteSessionImpl r4 = (io.ktor.utils.io.internal.WriteSessionImpl) r4
            kotlin.ResultKt.throwOnFailure(r6)     // Catch:{ all -> 0x004f }
            goto L_0x0049
        L_0x002e:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r6)
            io.ktor.utils.io.internal.WriteSessionImpl r4 = r4.writeSession
            r4.begin()
            r0.L$0 = r4     // Catch:{ all -> 0x004f }
            r0.label = r3     // Catch:{ all -> 0x004f }
            java.lang.Object r5 = r5.invoke(r4, r0)     // Catch:{ all -> 0x004f }
            if (r5 != r1) goto L_0x0049
            return r1
        L_0x0049:
            r4.complete()
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        L_0x004f:
            r5 = move-exception
            r4.complete()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.writeSuspendSession$suspendImpl(io.ktor.utils.io.ByteBufferChannel, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public void consumed(int i) {
        if (i >= 0) {
            ReadWriteBufferState state = getState();
            if (!state.capacity.tryReadExact(i)) {
                throw new IllegalStateException("Unable to consume " + i + " bytes: not enough available bytes");
            } else if (i > 0) {
                bytesRead(state.getReadBuffer(), state.capacity, i);
            }
        } else {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    public final Object awaitAtLeast(int i, Continuation<? super Boolean> continuation) {
        boolean z = false;
        if (i >= 0) {
            if (i <= 4088) {
                z = true;
            }
            if (!z) {
                throw new IllegalArgumentException(("atLeast parameter shouldn't be larger than max buffer size of 4088: " + i).toString());
            } else if (getState().capacity._availableForRead$internal >= i) {
                if (getState().getIdle() || (getState() instanceof ReadWriteBufferState.Writing)) {
                    setupStateForRead();
                }
                return Boxing.boxBoolean(true);
            } else if (getState().getIdle() || (getState() instanceof ReadWriteBufferState.Writing)) {
                return awaitAtLeastSuspend(i, continuation);
            } else {
                if (i == 1) {
                    return readSuspendImpl(1, continuation);
                }
                return readSuspend(i, continuation);
            }
        } else {
            throw new IllegalArgumentException(("atLeast parameter shouldn't be negative: " + i).toString());
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object awaitAtLeastSuspend(int r5, kotlin.coroutines.Continuation<? super java.lang.Boolean> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof io.ktor.utils.io.ByteBufferChannel$awaitAtLeastSuspend$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            io.ktor.utils.io.ByteBufferChannel$awaitAtLeastSuspend$1 r0 = (io.ktor.utils.io.ByteBufferChannel$awaitAtLeastSuspend$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            io.ktor.utils.io.ByteBufferChannel$awaitAtLeastSuspend$1 r0 = new io.ktor.utils.io.ByteBufferChannel$awaitAtLeastSuspend$1
            r0.<init>(r4, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r5 = r0.L$0
            io.ktor.utils.io.ByteBufferChannel r5 = (io.ktor.utils.io.ByteBufferChannel) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0045
        L_0x002e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r6 = r4.readSuspend(r5, r0)
            if (r6 != r1) goto L_0x0044
            return r1
        L_0x0044:
            r5 = r4
        L_0x0045:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 == 0) goto L_0x005a
            io.ktor.utils.io.internal.ReadWriteBufferState r0 = r5.getState()
            boolean r0 = r0.getIdle()
            if (r0 == 0) goto L_0x005a
            r5.setupStateForRead()
        L_0x005a:
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.awaitAtLeastSuspend(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public ByteBuffer request(int i, int i2) {
        ReadWriteBufferState state = getState();
        int i3 = state.capacity._availableForRead$internal;
        int i4 = this.readPosition;
        if (i3 < i2 + i) {
            return null;
        }
        if (!state.getIdle() && ((state instanceof ReadWriteBufferState.Reading) || (state instanceof ReadWriteBufferState.ReadingWriting))) {
            ByteBuffer readBuffer = state.getReadBuffer();
            prepareBuffer(readBuffer, carryIndex(readBuffer, i4 + i), i3 - i);
            if (readBuffer.remaining() >= i2) {
                return readBuffer;
            }
            return null;
        } else if (setupStateForRead() == null) {
            return null;
        } else {
            return request(i, i2);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0069, code lost:
        if (r11 == 0) goto L_0x006d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x006b, code lost:
        r2 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x006d, code lost:
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x006e, code lost:
        r5.restoreStateAfterRead();
        r5.tryTerminate$ktor_io();
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object consumeEachBufferRangeSuspend(kotlin.jvm.functions.Function2<? super java.nio.ByteBuffer, ? super java.lang.Boolean, java.lang.Boolean> r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof io.ktor.utils.io.ByteBufferChannel$consumeEachBufferRangeSuspend$1
            if (r0 == 0) goto L_0x0014
            r0 = r11
            io.ktor.utils.io.ByteBufferChannel$consumeEachBufferRangeSuspend$1 r0 = (io.ktor.utils.io.ByteBufferChannel$consumeEachBufferRangeSuspend$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L_0x0019
        L_0x0014:
            io.ktor.utils.io.ByteBufferChannel$consumeEachBufferRangeSuspend$1 r0 = new io.ktor.utils.io.ByteBufferChannel$consumeEachBufferRangeSuspend$1
            r0.<init>(r9, r11)
        L_0x0019:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x0042
            if (r2 != r4) goto L_0x003a
            int r10 = r0.I$0
            java.lang.Object r2 = r0.L$1
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            java.lang.Object r5 = r0.L$0
            io.ktor.utils.io.ByteBufferChannel r5 = (io.ktor.utils.io.ByteBufferChannel) r5
            kotlin.ResultKt.throwOnFailure(r11)
            r8 = r11
            r11 = r10
            r10 = r2
            r2 = r8
            goto L_0x00c9
        L_0x003a:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x0042:
            kotlin.ResultKt.throwOnFailure(r11)
            r5 = r9
            r11 = r3
        L_0x0047:
            java.nio.ByteBuffer r2 = r5.setupStateForRead()
            if (r2 != 0) goto L_0x004f
        L_0x004d:
            r2 = r3
            goto L_0x0074
        L_0x004f:
            io.ktor.utils.io.internal.ReadWriteBufferState r6 = r5.getState()
            io.ktor.utils.io.internal.RingBufferCapacity r6 = r6.capacity
            int r7 = r6._availableForRead$internal     // Catch:{ all -> 0x00d4 }
            if (r7 != 0) goto L_0x0060
            r5.restoreStateAfterRead()
            r5.tryTerminate$ktor_io()
            goto L_0x004d
        L_0x0060:
            boolean r7 = r2.hasRemaining()     // Catch:{ all -> 0x00d4 }
            if (r7 != 0) goto L_0x0089
            if (r11 == 0) goto L_0x0069
            goto L_0x0089
        L_0x0069:
            if (r11 == 0) goto L_0x006d
            r2 = r4
            goto L_0x006e
        L_0x006d:
            r2 = r3
        L_0x006e:
            r5.restoreStateAfterRead()
            r5.tryTerminate$ktor_io()
        L_0x0074:
            if (r2 != 0) goto L_0x00b0
            io.ktor.utils.io.internal.ClosedElement r6 = r5.getClosed()
            if (r6 == 0) goto L_0x00b0
            java.nio.ByteBuffer r2 = io.ktor.utils.io.internal.ReadWriteBufferStateKt.getEmptyByteBuffer()
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            r10.invoke(r2, r6)
        L_0x0087:
            r2 = r4
            goto L_0x00b0
        L_0x0089:
            if (r11 == 0) goto L_0x008d
            r7 = r4
            goto L_0x008e
        L_0x008d:
            r7 = r3
        L_0x008e:
            java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r7)     // Catch:{ all -> 0x00d4 }
            java.lang.Object r7 = r10.invoke(r2, r7)     // Catch:{ all -> 0x00d4 }
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch:{ all -> 0x00d4 }
            boolean r7 = r7.booleanValue()     // Catch:{ all -> 0x00d4 }
            r5.afterBufferVisited(r2, r6)     // Catch:{ all -> 0x00d4 }
            if (r7 == 0) goto L_0x00a9
            if (r11 == 0) goto L_0x0060
            boolean r7 = r2.hasRemaining()     // Catch:{ all -> 0x00d4 }
            if (r7 != 0) goto L_0x0060
        L_0x00a9:
            r5.restoreStateAfterRead()
            r5.tryTerminate$ktor_io()
            goto L_0x0087
        L_0x00b0:
            if (r2 == 0) goto L_0x00b5
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        L_0x00b5:
            if (r11 == 0) goto L_0x00ba
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        L_0x00ba:
            r0.L$0 = r5
            r0.L$1 = r10
            r0.I$0 = r11
            r0.label = r4
            java.lang.Object r2 = r5.readSuspend(r4, r0)
            if (r2 != r1) goto L_0x00c9
            return r1
        L_0x00c9:
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 != 0) goto L_0x0047
            r11 = r4
            goto L_0x0047
        L_0x00d4:
            r10 = move-exception
            r5.restoreStateAfterRead()
            r5.tryTerminate$ktor_io()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.consumeEachBufferRangeSuspend(kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final int afterBufferVisited(ByteBuffer byteBuffer, RingBufferCapacity ringBufferCapacity) {
        int position = byteBuffer.position() - this.readPosition;
        if (position > 0) {
            if (ringBufferCapacity.tryReadExact(position)) {
                bytesRead(byteBuffer, ringBufferCapacity, position);
                prepareBuffer(byteBuffer, this.readPosition, ringBufferCapacity._availableForRead$internal);
            } else {
                throw new IllegalStateException("Consumed more bytes than available");
            }
        }
        return position;
    }

    /* access modifiers changed from: private */
    public final Object readUTF8LineToAscii(Appendable appendable, int i, Continuation<? super Boolean> continuation) {
        if (getState() == ReadWriteBufferState.Terminated.INSTANCE) {
            Throwable closedCause = getClosedCause();
            if (closedCause == null) {
                return Boxing.boxBoolean(false);
            }
            throw closedCause;
        }
        Ref.IntRef intRef = new Ref.IntRef();
        char[] cArr = new char[Marshallable.PROTO_PACKET_SIZE];
        CharBuffer wrap = CharBuffer.wrap(cArr);
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        lookAhead(new ByteBufferChannel$readUTF8LineToAscii$2(booleanRef, this, appendable, cArr, wrap, intRef, i));
        if (booleanRef.element) {
            return Boxing.boxBoolean(true);
        }
        if (intRef.element == 0 && isClosedForRead()) {
            return Boxing.boxBoolean(false);
        }
        Intrinsics.checkNotNullExpressionValue(wrap, "buffer");
        return readUTF8LineToUtf8Suspend(appendable, i - intRef.element, cArr, wrap, intRef.element, continuation);
    }

    private final boolean readLineLoop(LookAheadSession lookAheadSession, Appendable appendable, char[] cArr, CharBuffer charBuffer, Function1<? super Integer, Boolean> function1, Function1<? super Integer, Unit> function12, Function1<? super ByteBuffer, Long> function13) {
        ByteBuffer request;
        LookAheadSession lookAheadSession2 = lookAheadSession;
        Appendable appendable2 = appendable;
        int i = 1;
        while (true) {
            if (((Boolean) function1.invoke(Integer.valueOf(i))).booleanValue() && (request = lookAheadSession.request(0, 1)) != null) {
                int position = request.position();
                if (request.remaining() < i) {
                    rollBytes(request, i);
                }
                long longValue = ((Number) function13.invoke(request)).longValue();
                lookAheadSession.consumed(request.position() - position);
                int i2 = (int) (longValue >> 32);
                int i3 = (int) (longValue & KeyboardMap.kValueMask);
                int i4 = -1;
                if (i3 == -1) {
                    i4 = 0;
                } else if (i3 != 0 || !request.hasRemaining()) {
                    i4 = Math.max(1, i3);
                }
                function12.invoke(Integer.valueOf(i2));
                if (appendable2 instanceof StringBuilder) {
                    ((StringBuilder) appendable2).append(cArr, 0, i2);
                } else {
                    char[] cArr2 = cArr;
                    appendable2.append(charBuffer, 0, i2);
                }
                i = i4;
                if (i4 <= 0) {
                    break;
                }
            }
        }
        if (i == 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object readUTF8LineToUtf8Suspend(java.lang.Appendable r17, int r18, char[] r19, java.nio.CharBuffer r20, int r21, kotlin.coroutines.Continuation<? super java.lang.Boolean> r22) {
        /*
            r16 = this;
            r10 = r16
            r0 = r22
            boolean r1 = r0 instanceof io.ktor.utils.io.ByteBufferChannel$readUTF8LineToUtf8Suspend$1
            if (r1 == 0) goto L_0x0018
            r1 = r0
            io.ktor.utils.io.ByteBufferChannel$readUTF8LineToUtf8Suspend$1 r1 = (io.ktor.utils.io.ByteBufferChannel$readUTF8LineToUtf8Suspend$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0018
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            goto L_0x001d
        L_0x0018:
            io.ktor.utils.io.ByteBufferChannel$readUTF8LineToUtf8Suspend$1 r1 = new io.ktor.utils.io.ByteBufferChannel$readUTF8LineToUtf8Suspend$1
            r1.<init>(r10, r0)
        L_0x001d:
            r11 = r1
            java.lang.Object r0 = r11.result
            java.lang.Object r12 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r11.label
            r13 = 1
            if (r1 == 0) goto L_0x003b
            if (r1 != r13) goto L_0x0033
            java.lang.Object r1 = r11.L$0
            kotlin.jvm.internal.Ref$BooleanRef r1 = (kotlin.jvm.internal.Ref.BooleanRef) r1
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x006c
        L_0x0033:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x003b:
            kotlin.ResultKt.throwOnFailure(r0)
            kotlin.jvm.internal.Ref$IntRef r5 = new kotlin.jvm.internal.Ref$IntRef
            r5.<init>()
            kotlin.jvm.internal.Ref$BooleanRef r14 = new kotlin.jvm.internal.Ref$BooleanRef
            r14.<init>()
            r14.element = r13
            io.ktor.utils.io.ByteBufferChannel$readUTF8LineToUtf8Suspend$2 r15 = new io.ktor.utils.io.ByteBufferChannel$readUTF8LineToUtf8Suspend$2
            r9 = 0
            r0 = r15
            r1 = r16
            r2 = r17
            r3 = r19
            r4 = r20
            r6 = r21
            r7 = r14
            r8 = r18
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            kotlin.jvm.functions.Function2 r15 = (kotlin.jvm.functions.Function2) r15
            r11.L$0 = r14
            r11.label = r13
            java.lang.Object r0 = r10.lookAheadSuspend(r15, r11)
            if (r0 != r12) goto L_0x006b
            return r12
        L_0x006b:
            r1 = r14
        L_0x006c:
            boolean r0 = r1.element
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.readUTF8LineToUtf8Suspend(java.lang.Appendable, int, char[], java.nio.CharBuffer, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0057 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ java.lang.Object readUTF8Line$suspendImpl(io.ktor.utils.io.ByteBufferChannel r5, int r6, kotlin.coroutines.Continuation r7) {
        /*
            boolean r0 = r7 instanceof io.ktor.utils.io.ByteBufferChannel$readUTF8Line$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            io.ktor.utils.io.ByteBufferChannel$readUTF8Line$1 r0 = (io.ktor.utils.io.ByteBufferChannel$readUTF8Line$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            io.ktor.utils.io.ByteBufferChannel$readUTF8Line$1 r0 = new io.ktor.utils.io.ByteBufferChannel$readUTF8Line$1
            r0.<init>(r5, r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r5 = r0.L$0
            java.lang.StringBuilder r5 = (java.lang.StringBuilder) r5
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x004f
        L_0x002e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r7)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r2 = r7
            java.lang.Appendable r2 = (java.lang.Appendable) r2
            r0.L$0 = r7
            r0.label = r3
            java.lang.Object r5 = r5.readUTF8LineTo(r2, r6, r0)
            if (r5 != r1) goto L_0x004c
            return r1
        L_0x004c:
            r4 = r7
            r7 = r5
            r5 = r4
        L_0x004f:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r6 = r7.booleanValue()
            if (r6 != 0) goto L_0x0059
            r5 = 0
            return r5
        L_0x0059:
            java.lang.String r5 = r5.toString()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.readUTF8Line$suspendImpl(io.ktor.utils.io.ByteBufferChannel, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object readRemaining$suspendImpl(ByteBufferChannel byteBufferChannel, long j, Continuation continuation) {
        if (!byteBufferChannel.isClosedForWrite()) {
            return byteBufferChannel.readRemainingSuspend(j, continuation);
        }
        Throwable closedCause = byteBufferChannel.getClosedCause();
        if (closedCause == null) {
            return byteBufferChannel.remainingPacket(j);
        }
        Void unused = ByteBufferChannelKt.rethrowClosed(closedCause);
        throw new KotlinNothingValueException();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x007a A[Catch:{ all -> 0x003f, all -> 0x00da }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00b0 A[Catch:{ all -> 0x003f, all -> 0x00da }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00c2 A[Catch:{ all -> 0x003f, all -> 0x00da }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00c7 A[SYNTHETIC, Splitter:B:39:0x00c7] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00d0 A[Catch:{ all -> 0x003f, all -> 0x00da }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00d5 A[Catch:{ all -> 0x003f, all -> 0x00da }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object readRemainingSuspend(long r13, kotlin.coroutines.Continuation<? super io.ktor.utils.io.core.ByteReadPacket> r15) {
        /*
            r12 = this;
            boolean r0 = r15 instanceof io.ktor.utils.io.ByteBufferChannel$readRemainingSuspend$1
            if (r0 == 0) goto L_0x0014
            r0 = r15
            io.ktor.utils.io.ByteBufferChannel$readRemainingSuspend$1 r0 = (io.ktor.utils.io.ByteBufferChannel$readRemainingSuspend$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r15 = r0.label
            int r15 = r15 - r2
            r0.label = r15
            goto L_0x0019
        L_0x0014:
            io.ktor.utils.io.ByteBufferChannel$readRemainingSuspend$1 r0 = new io.ktor.utils.io.ByteBufferChannel$readRemainingSuspend$1
            r0.<init>(r12, r15)
        L_0x0019:
            java.lang.Object r15 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x004a
            if (r2 != r3) goto L_0x0042
            java.lang.Object r13 = r0.L$4
            io.ktor.utils.io.core.internal.ChunkBuffer r13 = (io.ktor.utils.io.core.internal.ChunkBuffer) r13
            java.lang.Object r14 = r0.L$3
            io.ktor.utils.io.core.Output r14 = (io.ktor.utils.io.core.Output) r14
            java.lang.Object r2 = r0.L$2
            kotlin.jvm.internal.Ref$LongRef r2 = (kotlin.jvm.internal.Ref.LongRef) r2
            java.lang.Object r4 = r0.L$1
            io.ktor.utils.io.core.BytePacketBuilder r4 = (io.ktor.utils.io.core.BytePacketBuilder) r4
            java.lang.Object r5 = r0.L$0
            io.ktor.utils.io.ByteBufferChannel r5 = (io.ktor.utils.io.ByteBufferChannel) r5
            kotlin.ResultKt.throwOnFailure(r15)     // Catch:{ all -> 0x003f }
            goto L_0x00b3
        L_0x003f:
            r13 = move-exception
            goto L_0x00d6
        L_0x0042:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L_0x004a:
            kotlin.ResultKt.throwOnFailure(r15)
            io.ktor.utils.io.core.BytePacketBuilder r15 = new io.ktor.utils.io.core.BytePacketBuilder
            r2 = 0
            r15.<init>(r2, r3, r2)
            kotlin.jvm.internal.Ref$LongRef r4 = new kotlin.jvm.internal.Ref$LongRef     // Catch:{ all -> 0x00dd }
            r4.<init>()     // Catch:{ all -> 0x00dd }
            r4.element = r13     // Catch:{ all -> 0x00dd }
            r13 = r15
            io.ktor.utils.io.core.Output r13 = (io.ktor.utils.io.core.Output) r13     // Catch:{ all -> 0x00dd }
            io.ktor.utils.io.core.internal.ChunkBuffer r14 = io.ktor.utils.io.core.internal.UnsafeKt.prepareWriteHead(r13, r3, r2)     // Catch:{ all -> 0x00dd }
            r2 = r4
            r4 = r15
            r15 = r12
            r11 = r14
            r14 = r13
            r13 = r11
        L_0x0067:
            r6 = r13
            io.ktor.utils.io.core.Buffer r6 = (io.ktor.utils.io.core.Buffer) r6     // Catch:{ all -> 0x003f }
            int r5 = r6.getLimit()     // Catch:{ all -> 0x003f }
            int r7 = r6.getWritePosition()     // Catch:{ all -> 0x003f }
            int r5 = r5 - r7
            long r7 = (long) r5     // Catch:{ all -> 0x003f }
            long r9 = r2.element     // Catch:{ all -> 0x003f }
            int r5 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r5 <= 0) goto L_0x0080
            long r7 = r2.element     // Catch:{ all -> 0x003f }
            int r5 = (int) r7     // Catch:{ all -> 0x003f }
            r6.resetForWrite(r5)     // Catch:{ all -> 0x003f }
        L_0x0080:
            r7 = 0
            r8 = 0
            r9 = 6
            r10 = 0
            r5 = r15
            int r5 = readAsMuchAsPossible$default(r5, r6, r7, r8, r9, r10)     // Catch:{ all -> 0x003f }
            long r6 = r2.element     // Catch:{ all -> 0x003f }
            long r8 = (long) r5     // Catch:{ all -> 0x003f }
            long r6 = r6 - r8
            r2.element = r6     // Catch:{ all -> 0x003f }
            long r5 = r2.element     // Catch:{ all -> 0x003f }
            r7 = 0
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 <= 0) goto L_0x00bf
            boolean r5 = r15.isClosedForRead()     // Catch:{ all -> 0x003f }
            if (r5 != 0) goto L_0x00bf
            r0.L$0 = r15     // Catch:{ all -> 0x003f }
            r0.L$1 = r4     // Catch:{ all -> 0x003f }
            r0.L$2 = r2     // Catch:{ all -> 0x003f }
            r0.L$3 = r14     // Catch:{ all -> 0x003f }
            r0.L$4 = r13     // Catch:{ all -> 0x003f }
            r0.label = r3     // Catch:{ all -> 0x003f }
            java.lang.Object r5 = r15.readSuspend(r3, r0)     // Catch:{ all -> 0x003f }
            if (r5 != r1) goto L_0x00b0
            return r1
        L_0x00b0:
            r11 = r5
            r5 = r15
            r15 = r11
        L_0x00b3:
            java.lang.Boolean r15 = (java.lang.Boolean) r15     // Catch:{ all -> 0x003f }
            boolean r15 = r15.booleanValue()     // Catch:{ all -> 0x003f }
            if (r15 == 0) goto L_0x00be
            r15 = r5
            r5 = r3
            goto L_0x00c0
        L_0x00be:
            r15 = r5
        L_0x00bf:
            r5 = 0
        L_0x00c0:
            if (r5 == 0) goto L_0x00c7
            io.ktor.utils.io.core.internal.ChunkBuffer r13 = io.ktor.utils.io.core.internal.UnsafeKt.prepareWriteHead(r14, r3, r13)     // Catch:{ all -> 0x003f }
            goto L_0x0067
        L_0x00c7:
            r14.afterHeadWrite()     // Catch:{ all -> 0x00da }
            java.lang.Throwable r13 = r15.getClosedCause()     // Catch:{ all -> 0x00da }
            if (r13 != 0) goto L_0x00d5
            io.ktor.utils.io.core.ByteReadPacket r13 = r4.build()     // Catch:{ all -> 0x00da }
            return r13
        L_0x00d5:
            throw r13     // Catch:{ all -> 0x00da }
        L_0x00d6:
            r14.afterHeadWrite()     // Catch:{ all -> 0x00da }
            throw r13     // Catch:{ all -> 0x00da }
        L_0x00da:
            r13 = move-exception
            r15 = r4
            goto L_0x00de
        L_0x00dd:
            r13 = move-exception
        L_0x00de:
            r15.release()
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.readRemainingSuspend(long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final void resumeReadOp() {
        Throwable th = null;
        Continuation continuation = (Continuation) _readOp$FU.getAndSet(this, (Object) null);
        if (continuation != null) {
            ClosedElement closed = getClosed();
            if (closed != null) {
                th = closed.getCause();
            }
            if (th != null) {
                Result.Companion companion = Result.Companion;
                continuation.resumeWith(Result.m320constructorimpl(ResultKt.createFailure(th)));
                return;
            }
            Result.Companion companion2 = Result.Companion;
            continuation.resumeWith(Result.m320constructorimpl(true));
        }
    }

    private final void resumeReadOp(Function0<? extends Throwable> function0) {
        Continuation continuation = (Continuation) _readOp$FU.getAndSet(this, (Object) null);
        if (continuation != null) {
            Result.Companion companion = Result.Companion;
            continuation.resumeWith(Result.m320constructorimpl(ResultKt.createFailure((Throwable) function0.invoke())));
        }
    }

    private final void resumeWriteOp() {
        Continuation<Unit> writeOp;
        ClosedElement closed;
        Object obj;
        do {
            writeOp = getWriteOp();
            if (writeOp != null) {
                closed = getClosed();
                if (closed == null && this.joining != null) {
                    ReadWriteBufferState state = getState();
                    if (!(state instanceof ReadWriteBufferState.Writing) && !(state instanceof ReadWriteBufferState.ReadingWriting) && state != ReadWriteBufferState.Terminated.INSTANCE) {
                        return;
                    }
                }
            } else {
                return;
            }
        } while (!_writeOp$FU.compareAndSet(this, writeOp, (Object) null));
        if (closed == null) {
            Result.Companion companion = Result.Companion;
            obj = Unit.INSTANCE;
        } else {
            Result.Companion companion2 = Result.Companion;
            obj = ResultKt.createFailure(closed.getSendException());
        }
        writeOp.resumeWith(Result.m320constructorimpl(obj));
    }

    private final void resumeClosed(Throwable th) {
        Continuation continuation = (Continuation) _readOp$FU.getAndSet(this, (Object) null);
        if (continuation != null) {
            if (th != null) {
                Result.Companion companion = Result.Companion;
                continuation.resumeWith(Result.m320constructorimpl(ResultKt.createFailure(th)));
            } else {
                Boolean valueOf = Boolean.valueOf(getState().capacity._availableForRead$internal > 0);
                Result.Companion companion2 = Result.Companion;
                continuation.resumeWith(Result.m320constructorimpl(valueOf));
            }
        }
        Continuation continuation2 = (Continuation) _writeOp$FU.getAndSet(this, (Object) null);
        if (continuation2 != null) {
            Result.Companion companion3 = Result.Companion;
            if (th == null) {
                th = new ClosedWriteChannelException(ByteBufferChannelKt.DEFAULT_CLOSE_MESSAGE);
            }
            continuation2.resumeWith(Result.m320constructorimpl(ResultKt.createFailure(th)));
        }
    }

    static /* synthetic */ Object awaitContent$suspendImpl(ByteBufferChannel byteBufferChannel, Continuation continuation) {
        Object readSuspend = byteBufferChannel.readSuspend(1, continuation);
        return readSuspend == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? readSuspend : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public final Object readSuspend(int i, Continuation<? super Boolean> continuation) {
        boolean z = true;
        if (getState().capacity._availableForRead$internal >= i) {
            return Boxing.boxBoolean(true);
        }
        ClosedElement closed = getClosed();
        if (closed != null) {
            Throwable cause = closed.getCause();
            if (cause == null) {
                RingBufferCapacity ringBufferCapacity = getState().capacity;
                if (!ringBufferCapacity.flush() || ringBufferCapacity._availableForRead$internal < i) {
                    z = false;
                }
                if (getReadOp() == null) {
                    return Boxing.boxBoolean(z);
                }
                throw new IllegalStateException("Read operation is already in progress");
            }
            Void unused = ByteBufferChannelKt.rethrowClosed(cause);
            throw new KotlinNothingValueException();
        } else if (i == 1) {
            return readSuspendImpl(1, continuation);
        } else {
            return readSuspendLoop(i, continuation);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object readSuspendLoop(int r6, kotlin.coroutines.Continuation<? super java.lang.Boolean> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof io.ktor.utils.io.ByteBufferChannel$readSuspendLoop$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            io.ktor.utils.io.ByteBufferChannel$readSuspendLoop$1 r0 = (io.ktor.utils.io.ByteBufferChannel$readSuspendLoop$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            io.ktor.utils.io.ByteBufferChannel$readSuspendLoop$1 r0 = new io.ktor.utils.io.ByteBufferChannel$readSuspendLoop$1
            r0.<init>(r5, r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x0039
            if (r2 != r4) goto L_0x0031
            int r6 = r0.I$0
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.ByteBufferChannel r2 = (io.ktor.utils.io.ByteBufferChannel) r2
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0096
        L_0x0031:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0039:
            kotlin.ResultKt.throwOnFailure(r7)
            r2 = r5
        L_0x003d:
            io.ktor.utils.io.internal.ReadWriteBufferState r7 = r2.getState()
            io.ktor.utils.io.internal.RingBufferCapacity r7 = r7.capacity
            int r7 = r7._availableForRead$internal
            if (r7 < r6) goto L_0x004c
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            return r6
        L_0x004c:
            io.ktor.utils.io.internal.ClosedElement r7 = r2.getClosed()
            if (r7 == 0) goto L_0x0089
            java.lang.Throwable r0 = r7.getCause()
            if (r0 != 0) goto L_0x007c
            io.ktor.utils.io.internal.ReadWriteBufferState r7 = r2.getState()
            io.ktor.utils.io.internal.RingBufferCapacity r7 = r7.capacity
            boolean r0 = r7.flush()
            if (r0 == 0) goto L_0x0069
            int r7 = r7._availableForRead$internal
            if (r7 < r6) goto L_0x0069
            r3 = r4
        L_0x0069:
            kotlin.coroutines.Continuation r6 = r2.getReadOp()
            if (r6 != 0) goto L_0x0074
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            return r6
        L_0x0074:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "Read operation is already in progress"
            r6.<init>(r7)
            throw r6
        L_0x007c:
            java.lang.Throwable r6 = r7.getCause()
            java.lang.Void unused = io.ktor.utils.io.ByteBufferChannelKt.rethrowClosed(r6)
            kotlin.KotlinNothingValueException r6 = new kotlin.KotlinNothingValueException
            r6.<init>()
            throw r6
        L_0x0089:
            r0.L$0 = r2
            r0.I$0 = r6
            r0.label = r4
            java.lang.Object r7 = r2.readSuspendImpl(r6, r0)
            if (r7 != r1) goto L_0x0096
            return r1
        L_0x0096:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 != 0) goto L_0x003d
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.readSuspendLoop(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final boolean readSuspendPredicate(int i) {
        ReadWriteBufferState state = getState();
        return state.capacity._availableForRead$internal < i && (this.joining == null || getWriteOp() == null || (state != ReadWriteBufferState.IdleEmpty.INSTANCE && !(state instanceof ReadWriteBufferState.IdleNonEmpty)));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object readSuspendImpl(int r5, kotlin.coroutines.Continuation<? super java.lang.Boolean> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof io.ktor.utils.io.ByteBufferChannel$readSuspendImpl$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            io.ktor.utils.io.ByteBufferChannel$readSuspendImpl$1 r0 = (io.ktor.utils.io.ByteBufferChannel$readSuspendImpl$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            io.ktor.utils.io.ByteBufferChannel$readSuspendImpl$1 r0 = new io.ktor.utils.io.ByteBufferChannel$readSuspendImpl$1
            r0.<init>(r4, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003a
            if (r2 != r3) goto L_0x0032
            int r5 = r0.I$0
            java.lang.Object r5 = r0.L$0
            io.ktor.utils.io.ByteBufferChannel r5 = (io.ktor.utils.io.ByteBufferChannel) r5
            kotlin.ResultKt.throwOnFailure(r6)     // Catch:{ all -> 0x0030 }
            goto L_0x008a
        L_0x0030:
            r6 = move-exception
            goto L_0x008d
        L_0x0032:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x003a:
            kotlin.ResultKt.throwOnFailure(r6)
            io.ktor.utils.io.internal.ReadWriteBufferState r6 = r4.getState()
            io.ktor.utils.io.internal.RingBufferCapacity r2 = r6.capacity
            int r2 = r2._availableForRead$internal
            if (r2 >= r5) goto L_0x005b
            io.ktor.utils.io.internal.JoiningState r2 = r4.joining
            if (r2 == 0) goto L_0x0059
            kotlin.coroutines.Continuation r2 = r4.getWriteOp()
            if (r2 == 0) goto L_0x0059
            io.ktor.utils.io.internal.ReadWriteBufferState$IdleEmpty r2 = io.ktor.utils.io.internal.ReadWriteBufferState.IdleEmpty.INSTANCE
            if (r6 == r2) goto L_0x005b
            boolean r6 = r6 instanceof io.ktor.utils.io.internal.ReadWriteBufferState.IdleNonEmpty
            if (r6 != 0) goto L_0x005b
        L_0x0059:
            r6 = r3
            goto L_0x005c
        L_0x005b:
            r6 = 0
        L_0x005c:
            if (r6 != 0) goto L_0x0063
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            return r5
        L_0x0063:
            r0.L$0 = r4     // Catch:{ all -> 0x008b }
            r0.I$0 = r5     // Catch:{ all -> 0x008b }
            r0.label = r3     // Catch:{ all -> 0x008b }
            r6 = r0
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6     // Catch:{ all -> 0x008b }
            io.ktor.utils.io.internal.CancellableReusableContinuation<java.lang.Boolean> r2 = r4.readSuspendContinuationCache     // Catch:{ all -> 0x008b }
            r3 = r2
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3     // Catch:{ all -> 0x008b }
            r4.suspensionForSize(r5, r3)     // Catch:{ all -> 0x008b }
            kotlin.coroutines.Continuation r5 = kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(r6)     // Catch:{ all -> 0x008b }
            java.lang.Object r6 = r2.completeSuspendBlock(r5)     // Catch:{ all -> 0x008b }
            java.lang.Object r5 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()     // Catch:{ all -> 0x008b }
            if (r6 != r5) goto L_0x0087
            kotlin.coroutines.Continuation r0 = (kotlin.coroutines.Continuation) r0     // Catch:{ all -> 0x008b }
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r0)     // Catch:{ all -> 0x008b }
        L_0x0087:
            if (r6 != r1) goto L_0x008a
            return r1
        L_0x008a:
            return r6
        L_0x008b:
            r6 = move-exception
            r5 = r4
        L_0x008d:
            r0 = 0
            r5.setReadOp(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.readSuspendImpl(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final boolean shouldResumeReadOp() {
        return this.joining != null && (getState() == ReadWriteBufferState.IdleEmpty.INSTANCE || (getState() instanceof ReadWriteBufferState.IdleNonEmpty));
    }

    /* access modifiers changed from: private */
    public final boolean writeSuspendPredicate(int i) {
        JoiningState joiningState = this.joining;
        ReadWriteBufferState state = getState();
        if (getClosed() == null) {
            if (joiningState == null) {
                if (state.capacity._availableForWrite$internal < i && state != ReadWriteBufferState.IdleEmpty.INSTANCE) {
                    return true;
                }
            } else if (state != ReadWriteBufferState.Terminated.INSTANCE && !(state instanceof ReadWriteBufferState.Writing) && !(state instanceof ReadWriteBufferState.ReadingWriting)) {
                return true;
            }
        }
        return false;
    }

    public final Object tryWriteSuspend$ktor_io(int i, Continuation<? super Unit> continuation) {
        Throwable sendException;
        if (!writeSuspendPredicate(i)) {
            ClosedElement closed = getClosed();
            if (closed != null && (sendException = closed.getSendException()) != null) {
                Void unused = ByteBufferChannelKt.rethrowClosed(sendException);
                throw new KotlinNothingValueException();
            } else if (IntrinsicsKt.getCOROUTINE_SUSPENDED() == null) {
                return null;
            } else {
                return Unit.INSTANCE;
            }
        } else {
            this.writeSuspensionSize = i;
            if (this.attachedJob != null) {
                Object invoke = this.writeSuspension.invoke(continuation);
                if (invoke == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    DebugProbesKt.probeCoroutineSuspended(continuation);
                }
                return invoke == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? invoke : Unit.INSTANCE;
            }
            CancellableReusableContinuation<Unit> cancellableReusableContinuation = this.writeSuspendContinuationCache;
            this.writeSuspension.invoke(cancellableReusableContinuation);
            Object completeSuspendBlock = cancellableReusableContinuation.completeSuspendBlock(IntrinsicsKt.intercepted(continuation));
            if (completeSuspendBlock == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return completeSuspendBlock == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? completeSuspendBlock : Unit.INSTANCE;
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object writeSuspend(int r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof io.ktor.utils.io.ByteBufferChannel$writeSuspend$3
            if (r0 == 0) goto L_0x0014
            r0 = r7
            io.ktor.utils.io.ByteBufferChannel$writeSuspend$3 r0 = (io.ktor.utils.io.ByteBufferChannel$writeSuspend$3) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            io.ktor.utils.io.ByteBufferChannel$writeSuspend$3 r0 = new io.ktor.utils.io.ByteBufferChannel$writeSuspend$3
            r0.<init>(r5, r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0038
            if (r2 != r3) goto L_0x0030
            int r6 = r0.I$0
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.ByteBufferChannel r2 = (io.ktor.utils.io.ByteBufferChannel) r2
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x003c
        L_0x0030:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0038:
            kotlin.ResultKt.throwOnFailure(r7)
            r2 = r5
        L_0x003c:
            boolean r7 = r2.writeSuspendPredicate(r6)
            if (r7 == 0) goto L_0x006a
            r0.L$0 = r2
            r0.I$0 = r6
            r0.label = r3
            kotlinx.coroutines.CancellableContinuationImpl r7 = new kotlinx.coroutines.CancellableContinuationImpl
            kotlin.coroutines.Continuation r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(r0)
            r7.<init>(r4, r3)
            r7.initCancellability()
            r4 = r7
            kotlinx.coroutines.CancellableContinuation r4 = (kotlinx.coroutines.CancellableContinuation) r4
            r2.writeSuspendBlock(r6, r4)
            java.lang.Object r7 = r7.getResult()
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r7 != r4) goto L_0x0067
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r0)
        L_0x0067:
            if (r7 != r1) goto L_0x003c
            return r1
        L_0x006a:
            io.ktor.utils.io.internal.ClosedElement r6 = r2.getClosed()
            if (r6 == 0) goto L_0x0080
            java.lang.Throwable r6 = r6.getSendException()
            if (r6 != 0) goto L_0x0077
            goto L_0x0080
        L_0x0077:
            java.lang.Void unused = io.ktor.utils.io.ByteBufferChannelKt.rethrowClosed(r6)
            kotlin.KotlinNothingValueException r6 = new kotlin.KotlinNothingValueException
            r6.<init>()
            throw r6
        L_0x0080:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.writeSuspend(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void writeSuspendBlock(int r7, kotlinx.coroutines.CancellableContinuation<? super kotlin.Unit> r8) {
        /*
            r6 = this;
        L_0x0000:
            io.ktor.utils.io.internal.ClosedElement r0 = r6.getClosed()
            if (r0 == 0) goto L_0x0016
            java.lang.Throwable r0 = r0.getSendException()
            if (r0 != 0) goto L_0x000d
            goto L_0x0016
        L_0x000d:
            java.lang.Void unused = io.ktor.utils.io.ByteBufferChannelKt.rethrowClosed(r0)
            kotlin.KotlinNothingValueException r7 = new kotlin.KotlinNothingValueException
            r7.<init>()
            throw r7
        L_0x0016:
            boolean r0 = r6.writeSuspendPredicate(r7)
            if (r0 != 0) goto L_0x002a
            kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
            kotlin.Result$Companion r0 = kotlin.Result.Companion
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            java.lang.Object r0 = kotlin.Result.m320constructorimpl(r0)
            r8.resumeWith(r0)
            goto L_0x0059
        L_0x002a:
            kotlin.coroutines.Continuation r0 = r6.getWriteOp()
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x0034
            r0 = r1
            goto L_0x0035
        L_0x0034:
            r0 = r2
        L_0x0035:
            if (r0 == 0) goto L_0x0066
            boolean r0 = r6.writeSuspendPredicate(r7)
            if (r0 != 0) goto L_0x003f
        L_0x003d:
            r1 = r2
            goto L_0x0057
        L_0x003f:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = _writeOp$FU
            r3 = r8
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r4 = 0
            boolean r5 = r0.compareAndSet(r6, r4, r3)
            if (r5 == 0) goto L_0x002a
            boolean r5 = r6.writeSuspendPredicate(r7)
            if (r5 != 0) goto L_0x0057
            boolean r0 = r0.compareAndSet(r6, r3, r4)
            if (r0 != 0) goto L_0x003d
        L_0x0057:
            if (r1 == 0) goto L_0x0000
        L_0x0059:
            r6.flushImpl(r7)
            boolean r7 = r6.shouldResumeReadOp()
            if (r7 == 0) goto L_0x0065
            r6.resumeReadOp()
        L_0x0065:
            return
        L_0x0066:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "Operation is already in progress"
            java.lang.String r8 = r8.toString()
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.writeSuspendBlock(int, kotlinx.coroutines.CancellableContinuation):void");
    }

    private final ReadWriteBufferState.Initial newBuffer() {
        ReadWriteBufferState.Initial borrow = this.pool.borrow();
        borrow.capacity.resetForWrite();
        return borrow;
    }

    private final void releaseBuffer(ReadWriteBufferState.Initial initial) {
        this.pool.recycle(initial);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* renamed from: peekTo-lBXzO7A$suspendImpl  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ java.lang.Object m20peekTolBXzO7A$suspendImpl(io.ktor.utils.io.ByteBufferChannel r16, java.nio.ByteBuffer r17, long r18, long r20, long r22, long r24, kotlin.coroutines.Continuation r26) {
        /*
            r0 = r16
            r1 = r26
            boolean r2 = r1 instanceof io.ktor.utils.io.ByteBufferChannel$peekTo$1
            if (r2 == 0) goto L_0x0018
            r2 = r1
            io.ktor.utils.io.ByteBufferChannel$peekTo$1 r2 = (io.ktor.utils.io.ByteBufferChannel$peekTo$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001d
        L_0x0018:
            io.ktor.utils.io.ByteBufferChannel$peekTo$1 r2 = new io.ktor.utils.io.ByteBufferChannel$peekTo$1
            r2.<init>(r0, r1)
        L_0x001d:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 1
            if (r4 == 0) goto L_0x003a
            if (r4 != r5) goto L_0x0032
            java.lang.Object r0 = r2.L$0
            kotlin.jvm.internal.Ref$IntRef r0 = (kotlin.jvm.internal.Ref.IntRef) r0
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x0068
        L_0x0032:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x003a:
            kotlin.ResultKt.throwOnFailure(r1)
            kotlin.jvm.internal.Ref$IntRef r1 = new kotlin.jvm.internal.Ref$IntRef
            r1.<init>()
            long r6 = r22 + r20
            r8 = 4088(0xff8, double:2.0197E-320)
            long r6 = kotlin.ranges.RangesKt.coerceAtMost(r6, r8)
            int r4 = (int) r6
            io.ktor.utils.io.ByteBufferChannel$peekTo$2 r15 = new io.ktor.utils.io.ByteBufferChannel$peekTo$2
            r6 = r15
            r7 = r20
            r9 = r24
            r11 = r17
            r12 = r18
            r14 = r1
            r6.<init>(r7, r9, r11, r12, r14)
            kotlin.jvm.functions.Function1 r15 = (kotlin.jvm.functions.Function1) r15
            r2.L$0 = r1
            r2.label = r5
            java.lang.Object r0 = r0.read(r4, r15, r2)
            if (r0 != r3) goto L_0x0067
            return r3
        L_0x0067:
            r0 = r1
        L_0x0068:
            int r0 = r0.element
            long r0 = (long) r0
            java.lang.Long r0 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.m20peekTolBXzO7A$suspendImpl(io.ktor.utils.io.ByteBufferChannel, java.nio.ByteBuffer, long, long, long, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public String toString() {
        return "ByteBufferChannel(" + hashCode() + ", " + getState() + ')';
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lio/ktor/utils/io/ByteBufferChannel$Companion;", "", "()V", "ReservedLongIndex", "", "ktor-io"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ByteBufferChannel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: CodeShrinkVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Don't wrap MOVE or CONST insns: 0x0029: MOVE  (r0v3 io.ktor.utils.io.internal.ReadWriteBufferState$IdleNonEmpty) = 
          (r0v2 io.ktor.utils.io.internal.ReadWriteBufferState$IdleNonEmpty)
        
        	at jadx.core.dex.instructions.args.InsnArg.wrapArg(InsnArg.java:164)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.assignInline(CodeShrinkVisitor.java:133)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.checkInline(CodeShrinkVisitor.java:118)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkBlock(CodeShrinkVisitor.java:65)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkMethod(CodeShrinkVisitor.java:43)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.visit(CodeShrinkVisitor.java:35)
        */
    public final void restoreStateAfterWrite$ktor_io() {
        /*
            r5 = this;
            r0 = 0
        L_0x0001:
            java.lang.Object r1 = r5._state
            r2 = r1
            io.ktor.utils.io.internal.ReadWriteBufferState r2 = (io.ktor.utils.io.internal.ReadWriteBufferState) r2
            io.ktor.utils.io.internal.ReadWriteBufferState r2 = r2.stopWriting$ktor_io()
            boolean r3 = r2 instanceof io.ktor.utils.io.internal.ReadWriteBufferState.IdleNonEmpty
            if (r3 == 0) goto L_0x001d
            io.ktor.utils.io.internal.RingBufferCapacity r3 = r2.capacity
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L_0x001d
            io.ktor.utils.io.internal.ReadWriteBufferState$IdleEmpty r0 = io.ktor.utils.io.internal.ReadWriteBufferState.IdleEmpty.INSTANCE
            io.ktor.utils.io.internal.ReadWriteBufferState r0 = (io.ktor.utils.io.internal.ReadWriteBufferState) r0
            r4 = r2
            r2 = r0
            r0 = r4
        L_0x001d:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r3 = _state$FU
            boolean r1 = r3.compareAndSet(r5, r1, r2)
            if (r1 == 0) goto L_0x0001
            io.ktor.utils.io.internal.ReadWriteBufferState$IdleEmpty r1 = io.ktor.utils.io.internal.ReadWriteBufferState.IdleEmpty.INSTANCE
            if (r2 != r1) goto L_0x0034
            io.ktor.utils.io.internal.ReadWriteBufferState$IdleNonEmpty r0 = (io.ktor.utils.io.internal.ReadWriteBufferState.IdleNonEmpty) r0
            if (r0 == 0) goto L_0x0034
            io.ktor.utils.io.internal.ReadWriteBufferState$Initial r0 = r0.getInitial()
            r5.releaseBuffer(r0)
        L_0x0034:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.restoreStateAfterWrite$ktor_io():void");
    }

    private final ByteBuffer setupStateForRead() {
        Object obj;
        boolean z;
        Throwable cause;
        ReadWriteBufferState startReading$ktor_io;
        Throwable cause2;
        do {
            obj = this._state;
            ReadWriteBufferState readWriteBufferState = (ReadWriteBufferState) obj;
            if (Intrinsics.areEqual(readWriteBufferState, ReadWriteBufferState.Terminated.INSTANCE)) {
                z = true;
            } else {
                z = Intrinsics.areEqual(readWriteBufferState, ReadWriteBufferState.IdleEmpty.INSTANCE);
            }
            if (z) {
                ClosedElement closed = getClosed();
                if (closed == null || (cause = closed.getCause()) == null) {
                    return null;
                }
                Void unused = ByteBufferChannelKt.rethrowClosed(cause);
                throw new KotlinNothingValueException();
            }
            ClosedElement closed2 = getClosed();
            if (closed2 != null && (cause2 = closed2.getCause()) != null) {
                Void unused2 = ByteBufferChannelKt.rethrowClosed(cause2);
                throw new KotlinNothingValueException();
            } else if (readWriteBufferState.capacity._availableForRead$internal == 0) {
                return null;
            } else {
                startReading$ktor_io = readWriteBufferState.startReading$ktor_io();
            }
        } while (!_state$FU.compareAndSet(this, obj, startReading$ktor_io));
        ByteBuffer readBuffer = startReading$ktor_io.getReadBuffer();
        prepareBuffer(readBuffer, this.readPosition, startReading$ktor_io.capacity._availableForRead$internal);
        return readBuffer;
    }

    private final void restoreStateAfterRead() {
        Object obj;
        ReadWriteBufferState stopReading$ktor_io;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        ReadWriteBufferState.IdleNonEmpty idleNonEmpty = null;
        do {
            obj = this._state;
            ReadWriteBufferState readWriteBufferState = (ReadWriteBufferState) obj;
            ReadWriteBufferState.IdleNonEmpty idleNonEmpty2 = idleNonEmpty;
            if (idleNonEmpty2 != null) {
                idleNonEmpty2.capacity.resetForWrite();
                resumeWriteOp();
                idleNonEmpty = null;
            }
            stopReading$ktor_io = readWriteBufferState.stopReading$ktor_io();
            if ((stopReading$ktor_io instanceof ReadWriteBufferState.IdleNonEmpty) && getState() == readWriteBufferState && stopReading$ktor_io.capacity.tryLockForRelease()) {
                ReadWriteBufferState.IdleNonEmpty idleNonEmpty3 = stopReading$ktor_io;
                stopReading$ktor_io = ReadWriteBufferState.IdleEmpty.INSTANCE;
                idleNonEmpty = idleNonEmpty3;
            }
            atomicReferenceFieldUpdater = _state$FU;
        } while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, stopReading$ktor_io));
        if (stopReading$ktor_io == ReadWriteBufferState.IdleEmpty.INSTANCE) {
            ReadWriteBufferState.IdleNonEmpty idleNonEmpty4 = idleNonEmpty;
            if (idleNonEmpty4 != null) {
                releaseBuffer(idleNonEmpty4.getInitial());
            }
            resumeWriteOp();
        } else if ((stopReading$ktor_io instanceof ReadWriteBufferState.IdleNonEmpty) && stopReading$ktor_io.capacity.isEmpty() && stopReading$ktor_io.capacity.tryLockForRelease() && atomicReferenceFieldUpdater.compareAndSet(this, stopReading$ktor_io, ReadWriteBufferState.IdleEmpty.INSTANCE)) {
            stopReading$ktor_io.capacity.resetForWrite();
            releaseBuffer(((ReadWriteBufferState.IdleNonEmpty) stopReading$ktor_io).getInitial());
            resumeWriteOp();
        }
    }

    private final boolean tryReleaseBuffer(boolean z) {
        Object obj;
        ReadWriteBufferState readWriteBufferState;
        ReadWriteBufferState.Initial initial = null;
        do {
            obj = this._state;
            ReadWriteBufferState readWriteBufferState2 = (ReadWriteBufferState) obj;
            ClosedElement closed = getClosed();
            if (initial != null) {
                if ((closed != null ? closed.getCause() : null) == null) {
                    initial.capacity.resetForWrite();
                }
                resumeWriteOp();
                initial = null;
            }
            if (readWriteBufferState2 == ReadWriteBufferState.Terminated.INSTANCE) {
                return true;
            }
            if (readWriteBufferState2 == ReadWriteBufferState.IdleEmpty.INSTANCE) {
                readWriteBufferState = ReadWriteBufferState.Terminated.INSTANCE;
            } else if (closed != null && (readWriteBufferState2 instanceof ReadWriteBufferState.IdleNonEmpty) && (readWriteBufferState2.capacity.tryLockForRelease() || closed.getCause() != null)) {
                if (closed.getCause() != null) {
                    readWriteBufferState2.capacity.forceLockForRelease();
                }
                initial = ((ReadWriteBufferState.IdleNonEmpty) readWriteBufferState2).getInitial();
                readWriteBufferState = ReadWriteBufferState.Terminated.INSTANCE;
            } else if (!z || !(readWriteBufferState2 instanceof ReadWriteBufferState.IdleNonEmpty) || !readWriteBufferState2.capacity.tryLockForRelease()) {
                return false;
            } else {
                initial = ((ReadWriteBufferState.IdleNonEmpty) readWriteBufferState2).getInitial();
                readWriteBufferState = ReadWriteBufferState.Terminated.INSTANCE;
            }
        } while (!_state$FU.compareAndSet(this, obj, readWriteBufferState));
        if (initial != null && getState() == ReadWriteBufferState.Terminated.INSTANCE) {
            releaseBuffer(initial);
        }
        return true;
    }

    private final int readAsMuchAsPossible(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2 = setupStateForRead();
        int i = 0;
        if (byteBuffer2 != null) {
            RingBufferCapacity ringBufferCapacity = getState().capacity;
            try {
                if (ringBufferCapacity._availableForRead$internal != 0) {
                    int capacity = byteBuffer2.capacity() - this.reservedSize;
                    while (true) {
                        int remaining = byteBuffer.remaining();
                        if (remaining == 0) {
                            break;
                        }
                        int i2 = this.readPosition;
                        int tryReadAtMost = ringBufferCapacity.tryReadAtMost(Math.min(capacity - i2, remaining));
                        if (tryReadAtMost == 0) {
                            break;
                        }
                        byteBuffer2.limit(i2 + tryReadAtMost);
                        byteBuffer2.position(i2);
                        byteBuffer.put(byteBuffer2);
                        bytesRead(byteBuffer2, ringBufferCapacity, tryReadAtMost);
                        i += tryReadAtMost;
                    }
                }
            } finally {
                restoreStateAfterRead();
                tryTerminate$ktor_io();
            }
        }
        return i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK, PHI: r9 r10 
      PHI: (r9v1 int) = (r9v0 int), (r9v2 int) binds: [B:0:0x0000, B:25:0x006e] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r10v1 int) = (r10v0 int), (r10v2 int) binds: [B:0:0x0000, B:25:0x006e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0070 A[EDGE_INSN: B:30:0x0070->B:26:0x0070 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int readAsMuchAsPossible(io.ktor.utils.io.core.Buffer r8, int r9, int r10) {
        /*
            r7 = this;
        L_0x0000:
            java.nio.ByteBuffer r0 = r7.setupStateForRead()
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x000b
        L_0x0008:
            r0 = r2
            r5 = r0
            goto L_0x0054
        L_0x000b:
            io.ktor.utils.io.internal.ReadWriteBufferState r3 = r7.getState()
            io.ktor.utils.io.internal.RingBufferCapacity r3 = r3.capacity
            int r4 = r3._availableForRead$internal     // Catch:{ all -> 0x0071 }
            if (r4 != 0) goto L_0x001c
            r7.restoreStateAfterRead()
            r7.tryTerminate$ktor_io()
            goto L_0x0008
        L_0x001c:
            int r4 = r8.getLimit()     // Catch:{ all -> 0x0071 }
            int r5 = r8.getWritePosition()     // Catch:{ all -> 0x0071 }
            int r4 = r4 - r5
            int r5 = r0.remaining()     // Catch:{ all -> 0x0071 }
            int r6 = java.lang.Math.min(r4, r10)     // Catch:{ all -> 0x0071 }
            int r5 = java.lang.Math.min(r5, r6)     // Catch:{ all -> 0x0071 }
            int r5 = r3.tryReadAtMost(r5)     // Catch:{ all -> 0x0071 }
            if (r5 > 0) goto L_0x0039
            r0 = r2
            goto L_0x004e
        L_0x0039:
            int r6 = r0.remaining()     // Catch:{ all -> 0x0071 }
            if (r4 >= r6) goto L_0x0047
            int r6 = r0.position()     // Catch:{ all -> 0x0071 }
            int r6 = r6 + r4
            r0.limit(r6)     // Catch:{ all -> 0x0071 }
        L_0x0047:
            io.ktor.utils.io.core.BufferPrimitivesJvmKt.writeFully(r8, r0)     // Catch:{ all -> 0x0071 }
            r7.bytesRead(r0, r3, r5)     // Catch:{ all -> 0x0071 }
            r0 = r1
        L_0x004e:
            r7.restoreStateAfterRead()
            r7.tryTerminate$ktor_io()
        L_0x0054:
            int r9 = r9 + r5
            int r10 = r10 - r5
            if (r0 == 0) goto L_0x0070
            int r0 = r8.getLimit()
            int r3 = r8.getWritePosition()
            if (r0 <= r3) goto L_0x0063
            goto L_0x0064
        L_0x0063:
            r1 = r2
        L_0x0064:
            if (r1 == 0) goto L_0x0070
            io.ktor.utils.io.internal.ReadWriteBufferState r0 = r7.getState()
            io.ktor.utils.io.internal.RingBufferCapacity r0 = r0.capacity
            int r0 = r0._availableForRead$internal
            if (r0 > 0) goto L_0x0000
        L_0x0070:
            return r9
        L_0x0071:
            r8 = move-exception
            r7.restoreStateAfterRead()
            r7.tryTerminate$ktor_io()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.readAsMuchAsPossible(io.ktor.utils.io.core.Buffer, int, int):int");
    }

    static /* synthetic */ int readAsMuchAsPossible$default(ByteBufferChannel byteBufferChannel, Buffer buffer, int i, int i2, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                i = 0;
            }
            if ((i3 & 4) != 0) {
                i2 = buffer.getLimit() - buffer.getWritePosition();
            }
            return byteBufferChannel.readAsMuchAsPossible(buffer, i, i2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: readAsMuchAsPossible");
    }

    private final int readAsMuchAsPossible(byte[] bArr, int i, int i2) {
        ByteBuffer byteBuffer = setupStateForRead();
        int i3 = 0;
        if (byteBuffer != null) {
            RingBufferCapacity ringBufferCapacity = getState().capacity;
            try {
                if (ringBufferCapacity._availableForRead$internal != 0) {
                    int capacity = byteBuffer.capacity() - this.reservedSize;
                    while (true) {
                        int i4 = i2 - i3;
                        if (i4 == 0) {
                            break;
                        }
                        int i5 = this.readPosition;
                        int tryReadAtMost = ringBufferCapacity.tryReadAtMost(Math.min(capacity - i5, i4));
                        if (tryReadAtMost == 0) {
                            break;
                        }
                        byteBuffer.limit(i5 + tryReadAtMost);
                        byteBuffer.position(i5);
                        byteBuffer.get(bArr, i + i3, tryReadAtMost);
                        bytesRead(byteBuffer, ringBufferCapacity, tryReadAtMost);
                        i3 += tryReadAtMost;
                    }
                }
            } finally {
                restoreStateAfterRead();
                tryTerminate$ktor_io();
            }
        }
        return i3;
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x008b A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int readAvailable(int r7, kotlin.jvm.functions.Function1<? super java.nio.ByteBuffer, kotlin.Unit> r8) {
        /*
            r6 = this;
            java.lang.String r0 = "block"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            r0 = 1
            r1 = 0
            if (r7 <= 0) goto L_0x000b
            r2 = r0
            goto L_0x000c
        L_0x000b:
            r2 = r1
        L_0x000c:
            if (r2 == 0) goto L_0x00b5
            r2 = 4088(0xff8, float:5.729E-42)
            if (r7 > r2) goto L_0x0014
            r2 = r0
            goto L_0x0015
        L_0x0014:
            r2 = r1
        L_0x0015:
            if (r2 == 0) goto L_0x0095
            java.nio.ByteBuffer r2 = r6.setupStateForRead()
            if (r2 != 0) goto L_0x0020
        L_0x001d:
            r7 = r1
            goto L_0x0089
        L_0x0020:
            io.ktor.utils.io.internal.ReadWriteBufferState r3 = r6.getState()
            io.ktor.utils.io.internal.RingBufferCapacity r3 = r3.capacity
            int r4 = r3._availableForRead$internal     // Catch:{ all -> 0x008d }
            if (r4 != 0) goto L_0x0031
            r6.restoreStateAfterRead()
            r6.tryTerminate$ktor_io()
            goto L_0x001d
        L_0x0031:
            int r4 = r3.tryReadAtLeast(r7)     // Catch:{ all -> 0x008d }
            if (r4 <= 0) goto L_0x0080
            if (r4 >= r7) goto L_0x003a
            goto L_0x0080
        L_0x003a:
            int r7 = r2.position()     // Catch:{ all -> 0x008d }
            int r5 = r2.limit()     // Catch:{ all -> 0x008d }
            r8.invoke(r2)     // Catch:{ all -> 0x008d }
            int r8 = r2.limit()     // Catch:{ all -> 0x008d }
            if (r5 != r8) goto L_0x004d
            r8 = r0
            goto L_0x004e
        L_0x004d:
            r8 = r1
        L_0x004e:
            if (r8 == 0) goto L_0x0074
            int r8 = r2.position()     // Catch:{ all -> 0x008d }
            int r8 = r8 - r7
            if (r8 < 0) goto L_0x0058
            r1 = r0
        L_0x0058:
            if (r1 == 0) goto L_0x0068
            r6.bytesRead(r2, r3, r8)     // Catch:{ all -> 0x008d }
            if (r8 >= r4) goto L_0x0066
            int r4 = r4 - r8
            r3.completeWrite(r4)     // Catch:{ all -> 0x008d }
            r3.flush()     // Catch:{ all -> 0x008d }
        L_0x0066:
            r1 = r8
            goto L_0x0081
        L_0x0068:
            java.lang.String r7 = "Position shouldn't been moved backwards."
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException     // Catch:{ all -> 0x008d }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x008d }
            r8.<init>(r7)     // Catch:{ all -> 0x008d }
            throw r8     // Catch:{ all -> 0x008d }
        L_0x0074:
            java.lang.String r7 = "Buffer limit shouldn't be modified."
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException     // Catch:{ all -> 0x008d }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x008d }
            r8.<init>(r7)     // Catch:{ all -> 0x008d }
            throw r8     // Catch:{ all -> 0x008d }
        L_0x0080:
            r0 = r1
        L_0x0081:
            r6.restoreStateAfterRead()
            r6.tryTerminate$ktor_io()
            r7 = r1
            r1 = r0
        L_0x0089:
            if (r1 != 0) goto L_0x008c
            r7 = -1
        L_0x008c:
            return r7
        L_0x008d:
            r7 = move-exception
            r6.restoreStateAfterRead()
            r6.tryTerminate$ktor_io()
            throw r7
        L_0x0095:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r0 = "Min("
            r8.append(r0)
            r8.append(r7)
            java.lang.String r7 = ") shouldn't be greater than 4088"
            r8.append(r7)
            java.lang.String r7 = r8.toString()
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r7 = r7.toString()
            r8.<init>(r7)
            throw r8
        L_0x00b5:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.String r8 = "min should be positive"
            java.lang.String r8 = r8.toString()
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.readAvailable(int, kotlin.jvm.functions.Function1):int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x004b A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final <T extends java.lang.Number> java.lang.Object readPrimitive(int r7, kotlin.jvm.functions.Function1<? super java.nio.ByteBuffer, ? extends T> r8, kotlin.coroutines.Continuation<? super T> r9) {
        /*
            r6 = this;
        L_0x0000:
            java.nio.ByteBuffer r0 = r6.setupStateForRead()
            r1 = 0
            r2 = 0
            r3 = 1
            if (r0 != 0) goto L_0x000c
        L_0x0009:
            r5 = r1
            r0 = r2
            goto L_0x0049
        L_0x000c:
            io.ktor.utils.io.internal.ReadWriteBufferState r4 = r6.getState()
            io.ktor.utils.io.internal.RingBufferCapacity r4 = r4.capacity
            int r5 = r4._availableForRead$internal     // Catch:{ all -> 0x0086 }
            if (r5 != 0) goto L_0x0023
            kotlin.jvm.internal.InlineMarker.finallyStart(r3)
            r6.restoreStateAfterRead()
            r6.tryTerminate$ktor_io()
            kotlin.jvm.internal.InlineMarker.finallyEnd(r3)
            goto L_0x0009
        L_0x0023:
            boolean r5 = r4.tryReadExact(r7)     // Catch:{ all -> 0x0086 }
            if (r5 != 0) goto L_0x002c
            r5 = r1
            r0 = r2
            goto L_0x003d
        L_0x002c:
            int r5 = r0.remaining()     // Catch:{ all -> 0x0086 }
            if (r5 >= r7) goto L_0x0035
            r6.rollBytes(r0, r7)     // Catch:{ all -> 0x0086 }
        L_0x0035:
            java.lang.Object r5 = r8.invoke(r0)     // Catch:{ all -> 0x0086 }
            r6.bytesRead(r0, r4, r7)     // Catch:{ all -> 0x0086 }
            r0 = r3
        L_0x003d:
            kotlin.jvm.internal.InlineMarker.finallyStart(r3)
            r6.restoreStateAfterRead()
            r6.tryTerminate$ktor_io()
            kotlin.jvm.internal.InlineMarker.finallyEnd(r3)
        L_0x0049:
            if (r0 == 0) goto L_0x0057
            if (r5 != 0) goto L_0x0053
            java.lang.String r7 = "result"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r7)
            goto L_0x0056
        L_0x0053:
            r1 = r5
            java.lang.Number r1 = (java.lang.Number) r1
        L_0x0056:
            return r1
        L_0x0057:
            kotlin.jvm.internal.InlineMarker.mark(r2)
            java.lang.Object r0 = r6.readSuspend(r7, r9)
            kotlin.jvm.internal.InlineMarker.mark(r3)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x006a
            goto L_0x0000
        L_0x006a:
            kotlinx.coroutines.channels.ClosedReceiveChannelException r8 = new kotlinx.coroutines.channels.ClosedReceiveChannelException
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r0 = "EOF while "
            r9.append(r0)
            r9.append(r7)
            java.lang.String r7 = " bytes expected"
            r9.append(r7)
            java.lang.String r7 = r9.toString()
            r8.<init>(r7)
            throw r8
        L_0x0086:
            r7 = move-exception
            kotlin.jvm.internal.InlineMarker.finallyStart(r3)
            r6.restoreStateAfterRead()
            r6.tryTerminate$ktor_io()
            kotlin.jvm.internal.InlineMarker.finallyEnd(r3)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.readPrimitive(int, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final int writeAsMuchAsPossible(ByteBuffer byteBuffer) {
        ByteBufferChannel byteBufferChannel;
        int tryWriteAtMost;
        JoiningState joiningState = this.joining;
        if (joiningState == null || (byteBufferChannel = resolveDelegation(this, joiningState)) == null) {
            byteBufferChannel = this;
        }
        ByteBuffer byteBuffer2 = byteBufferChannel.setupStateForWrite$ktor_io();
        if (byteBuffer2 == null) {
            return 0;
        }
        RingBufferCapacity ringBufferCapacity = byteBufferChannel.getState().capacity;
        long totalBytesWritten2 = byteBufferChannel.getTotalBytesWritten();
        try {
            ClosedElement closed = byteBufferChannel.getClosed();
            if (closed == null) {
                ByteBufferChannel byteBufferChannel2 = byteBufferChannel;
                int limit = byteBuffer.limit();
                int i = 0;
                while (true) {
                    int position = limit - byteBuffer.position();
                    if (position == 0 || (tryWriteAtMost = ringBufferCapacity.tryWriteAtMost(Math.min(position, byteBuffer2.remaining()))) == 0) {
                        byteBuffer.limit(limit);
                        byteBufferChannel2.bytesWritten(byteBuffer2, ringBufferCapacity, i);
                    } else {
                        if (tryWriteAtMost > 0) {
                            byteBuffer.limit(byteBuffer.position() + tryWriteAtMost);
                            byteBuffer2.put(byteBuffer);
                            i += tryWriteAtMost;
                            byteBufferChannel2.prepareBuffer(byteBuffer2, byteBufferChannel2.carryIndex(byteBuffer2, byteBufferChannel2.writePosition + i), ringBufferCapacity._availableForWrite$internal);
                        } else {
                            throw new IllegalArgumentException("Failed requirement.".toString());
                        }
                    }
                }
                byteBuffer.limit(limit);
                byteBufferChannel2.bytesWritten(byteBuffer2, ringBufferCapacity, i);
                return i;
            }
            Void unused = ByteBufferChannelKt.rethrowClosed(closed.getSendException());
            throw new KotlinNothingValueException();
        } finally {
            if (ringBufferCapacity.isFull() || byteBufferChannel.getAutoFlush()) {
                byteBufferChannel.flush();
            }
            if (byteBufferChannel != this) {
                setTotalBytesWritten$ktor_io(getTotalBytesWritten() + (byteBufferChannel.getTotalBytesWritten() - totalBytesWritten2));
            }
            byteBufferChannel.restoreStateAfterWrite$ktor_io();
            byteBufferChannel.tryTerminate$ktor_io();
        }
    }

    private final int writeAsMuchAsPossible(Buffer buffer) {
        ByteBufferChannel byteBufferChannel;
        JoiningState joiningState = this.joining;
        if (joiningState == null || (byteBufferChannel = resolveDelegation(this, joiningState)) == null) {
            byteBufferChannel = this;
        }
        ByteBuffer byteBuffer = byteBufferChannel.setupStateForWrite$ktor_io();
        int i = 0;
        if (byteBuffer == null) {
            return 0;
        }
        RingBufferCapacity ringBufferCapacity = byteBufferChannel.getState().capacity;
        long totalBytesWritten2 = byteBufferChannel.getTotalBytesWritten();
        try {
            ClosedElement closed = byteBufferChannel.getClosed();
            if (closed == null) {
                ByteBufferChannel byteBufferChannel2 = byteBufferChannel;
                while (true) {
                    int tryWriteAtMost = ringBufferCapacity.tryWriteAtMost(Math.min(buffer.getWritePosition() - buffer.getReadPosition(), byteBuffer.remaining()));
                    if (tryWriteAtMost == 0) {
                        break;
                    }
                    BufferUtilsJvmKt.readFully(buffer, byteBuffer, tryWriteAtMost);
                    i += tryWriteAtMost;
                    byteBufferChannel2.prepareBuffer(byteBuffer, byteBufferChannel2.carryIndex(byteBuffer, byteBufferChannel2.writePosition + i), ringBufferCapacity._availableForWrite$internal);
                }
                byteBufferChannel2.bytesWritten(byteBuffer, ringBufferCapacity, i);
                return i;
            }
            Void unused = ByteBufferChannelKt.rethrowClosed(closed.getSendException());
            throw new KotlinNothingValueException();
        } finally {
            if (ringBufferCapacity.isFull() || byteBufferChannel.getAutoFlush()) {
                byteBufferChannel.flush();
            }
            if (byteBufferChannel != this) {
                setTotalBytesWritten$ktor_io(getTotalBytesWritten() + (byteBufferChannel.getTotalBytesWritten() - totalBytesWritten2));
            }
            byteBufferChannel.restoreStateAfterWrite$ktor_io();
            byteBufferChannel.tryTerminate$ktor_io();
        }
    }

    private final int writeAsMuchAsPossible(byte[] bArr, int i, int i2) {
        ByteBufferChannel byteBufferChannel;
        JoiningState joiningState = this.joining;
        if (joiningState == null || (byteBufferChannel = resolveDelegation(this, joiningState)) == null) {
            byteBufferChannel = this;
        }
        ByteBuffer byteBuffer = byteBufferChannel.setupStateForWrite$ktor_io();
        if (byteBuffer == null) {
            return 0;
        }
        RingBufferCapacity ringBufferCapacity = byteBufferChannel.getState().capacity;
        long totalBytesWritten2 = byteBufferChannel.getTotalBytesWritten();
        try {
            ClosedElement closed = byteBufferChannel.getClosed();
            if (closed == null) {
                ByteBufferChannel byteBufferChannel2 = byteBufferChannel;
                int i3 = 0;
                while (true) {
                    int tryWriteAtMost = ringBufferCapacity.tryWriteAtMost(Math.min(i2 - i3, byteBuffer.remaining()));
                    if (tryWriteAtMost != 0) {
                        if (tryWriteAtMost > 0) {
                            byteBuffer.put(bArr, i + i3, tryWriteAtMost);
                            i3 += tryWriteAtMost;
                            byteBufferChannel2.prepareBuffer(byteBuffer, byteBufferChannel2.carryIndex(byteBuffer, byteBufferChannel2.writePosition + i3), ringBufferCapacity._availableForWrite$internal);
                        } else {
                            throw new IllegalArgumentException("Failed requirement.".toString());
                        }
                    } else {
                        byteBufferChannel2.bytesWritten(byteBuffer, ringBufferCapacity, i3);
                        return i3;
                    }
                }
            } else {
                Void unused = ByteBufferChannelKt.rethrowClosed(closed.getSendException());
                throw new KotlinNothingValueException();
            }
        } finally {
            if (ringBufferCapacity.isFull() || byteBufferChannel.getAutoFlush()) {
                byteBufferChannel.flush();
            }
            if (byteBufferChannel != this) {
                setTotalBytesWritten$ktor_io(getTotalBytesWritten() + (byteBufferChannel.getTotalBytesWritten() - totalBytesWritten2));
            }
            byteBufferChannel.restoreStateAfterWrite$ktor_io();
            byteBufferChannel.tryTerminate$ktor_io();
        }
    }

    /* JADX INFO: finally extract failed */
    public int writeAvailable(int i, Function1<? super ByteBuffer, Unit> function1) {
        ByteBufferChannel byteBufferChannel;
        int i2;
        Intrinsics.checkNotNullParameter(function1, "block");
        int i3 = 1;
        int i4 = 0;
        if (i > 0) {
            if (i <= 4088) {
                JoiningState joiningState = this.joining;
                if (joiningState == null || (byteBufferChannel = resolveDelegation(this, joiningState)) == null) {
                    byteBufferChannel = this;
                }
                ByteBuffer byteBuffer = byteBufferChannel.setupStateForWrite$ktor_io();
                if (byteBuffer == null) {
                    i2 = 0;
                } else {
                    RingBufferCapacity ringBufferCapacity = byteBufferChannel.getState().capacity;
                    long totalBytesWritten2 = byteBufferChannel.getTotalBytesWritten();
                    try {
                        ClosedElement closed = byteBufferChannel.getClosed();
                        if (closed == null) {
                            ByteBufferChannel byteBufferChannel2 = byteBufferChannel;
                            int tryWriteAtLeast = ringBufferCapacity.tryWriteAtLeast(i);
                            if (tryWriteAtLeast <= 0) {
                                i3 = 0;
                            } else {
                                byteBufferChannel2.prepareBuffer(byteBuffer, byteBufferChannel2.writePosition, tryWriteAtLeast);
                                int position = byteBuffer.position();
                                int limit = byteBuffer.limit();
                                function1.invoke(byteBuffer);
                                if (limit == byteBuffer.limit()) {
                                    int position2 = byteBuffer.position() - position;
                                    if (position2 >= 0) {
                                        i4 = 1;
                                    }
                                    if (i4 == 0) {
                                        throw new IllegalStateException("Position has been moved backward: pushback is not supported".toString());
                                    } else if (position2 >= 0) {
                                        byteBufferChannel2.bytesWritten(byteBuffer, ringBufferCapacity, position2);
                                        if (position2 < tryWriteAtLeast) {
                                            ringBufferCapacity.completeRead(tryWriteAtLeast - position2);
                                        }
                                        i4 = position2;
                                    } else {
                                        throw new IllegalStateException();
                                    }
                                } else {
                                    throw new IllegalStateException("Buffer limit modified".toString());
                                }
                            }
                            if (ringBufferCapacity.isFull() || byteBufferChannel.getAutoFlush()) {
                                byteBufferChannel.flush();
                            }
                            if (byteBufferChannel != this) {
                                setTotalBytesWritten$ktor_io(getTotalBytesWritten() + (byteBufferChannel.getTotalBytesWritten() - totalBytesWritten2));
                            }
                            byteBufferChannel.restoreStateAfterWrite$ktor_io();
                            byteBufferChannel.tryTerminate$ktor_io();
                            i2 = i4;
                            i4 = i3;
                        } else {
                            Void unused = ByteBufferChannelKt.rethrowClosed(closed.getSendException());
                            throw new KotlinNothingValueException();
                        }
                    } catch (Throwable th) {
                        if (ringBufferCapacity.isFull() || byteBufferChannel.getAutoFlush()) {
                            byteBufferChannel.flush();
                        }
                        if (byteBufferChannel != this) {
                            setTotalBytesWritten$ktor_io(getTotalBytesWritten() + (byteBufferChannel.getTotalBytesWritten() - totalBytesWritten2));
                        }
                        byteBufferChannel.restoreStateAfterWrite$ktor_io();
                        byteBufferChannel.tryTerminate$ktor_io();
                        throw th;
                    }
                }
                if (i4 == 0) {
                    return -1;
                }
                return i2;
            }
            throw new IllegalArgumentException(("Min(" + i + ") shouldn't be greater than 4088").toString());
        }
        throw new IllegalArgumentException("min should be positive".toString());
    }

    private final boolean writeWhileNoSuspend(Function1<? super ByteBuffer, Boolean> function1) {
        ByteBufferChannel byteBufferChannel;
        JoiningState joiningState = this.joining;
        if (joiningState == null || (byteBufferChannel = resolveDelegation(this, joiningState)) == null) {
            byteBufferChannel = this;
        }
        ByteBuffer byteBuffer = byteBufferChannel.setupStateForWrite$ktor_io();
        if (byteBuffer == null) {
            return true;
        }
        RingBufferCapacity ringBufferCapacity = byteBufferChannel.getState().capacity;
        long totalBytesWritten2 = byteBufferChannel.getTotalBytesWritten();
        try {
            ClosedElement closed = byteBufferChannel.getClosed();
            if (closed == null) {
                return byteBufferChannel.writeWhileLoop(byteBuffer, ringBufferCapacity, function1);
            }
            Void unused = ByteBufferChannelKt.rethrowClosed(closed.getSendException());
            throw new KotlinNothingValueException();
        } finally {
            if (ringBufferCapacity.isFull() || byteBufferChannel.getAutoFlush()) {
                byteBufferChannel.flush();
            }
            if (byteBufferChannel != this) {
                setTotalBytesWritten$ktor_io(getTotalBytesWritten() + (byteBufferChannel.getTotalBytesWritten() - totalBytesWritten2));
            }
            byteBufferChannel.restoreStateAfterWrite$ktor_io();
            byteBufferChannel.tryTerminate$ktor_io();
        }
    }

    static /* synthetic */ Object read$suspendImpl(ByteBufferChannel byteBufferChannel, int i, Function1 function1, Continuation continuation) {
        boolean z = true;
        boolean z2 = false;
        if (i >= 0) {
            ByteBuffer byteBuffer = byteBufferChannel.setupStateForRead();
            if (byteBuffer != null) {
                RingBufferCapacity ringBufferCapacity = byteBufferChannel.getState().capacity;
                try {
                    if (ringBufferCapacity._availableForRead$internal != 0) {
                        int i2 = ringBufferCapacity._availableForRead$internal;
                        if (i2 > 0) {
                            if (i2 >= i) {
                                int position = byteBuffer.position();
                                int limit = byteBuffer.limit();
                                function1.invoke(byteBuffer);
                                if (limit == byteBuffer.limit()) {
                                    int position2 = byteBuffer.position() - position;
                                    if (position2 >= 0) {
                                        z2 = true;
                                    }
                                    if (!z2) {
                                        throw new IllegalStateException("Position has been moved backward: pushback is not supported.".toString());
                                    } else if (ringBufferCapacity.tryReadExact(position2)) {
                                        byteBufferChannel.bytesRead(byteBuffer, ringBufferCapacity, position2);
                                        byteBufferChannel.restoreStateAfterRead();
                                        byteBufferChannel.tryTerminate$ktor_io();
                                        z2 = z;
                                    } else {
                                        throw new IllegalStateException("Check failed.".toString());
                                    }
                                } else {
                                    throw new IllegalStateException("Buffer limit modified.".toString());
                                }
                            }
                        }
                        z = false;
                        byteBufferChannel.restoreStateAfterRead();
                        byteBufferChannel.tryTerminate$ktor_io();
                        z2 = z;
                    }
                } finally {
                    byteBufferChannel.restoreStateAfterRead();
                    byteBufferChannel.tryTerminate$ktor_io();
                }
            }
            if (z2) {
                return Unit.INSTANCE;
            }
            if (byteBufferChannel.isClosedForRead()) {
                return Unit.INSTANCE;
            }
            Object readBlockSuspend = byteBufferChannel.readBlockSuspend(i, function1, continuation);
            return readBlockSuspend == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? readBlockSuspend : Unit.INSTANCE;
        }
        throw new IllegalArgumentException("min should be positive or zero".toString());
    }

    static /* synthetic */ Object discard$suspendImpl(ByteBufferChannel byteBufferChannel, long j, Continuation continuation) {
        long j2 = 0;
        if (j >= 0) {
            ByteBuffer byteBuffer = byteBufferChannel.setupStateForRead();
            if (byteBuffer != null) {
                RingBufferCapacity ringBufferCapacity = byteBufferChannel.getState().capacity;
                try {
                    if (ringBufferCapacity._availableForRead$internal != 0) {
                        int tryReadAtMost = ringBufferCapacity.tryReadAtMost((int) Math.min(2147483647L, j));
                        byteBufferChannel.bytesRead(byteBuffer, ringBufferCapacity, tryReadAtMost);
                        j2 = 0 + ((long) tryReadAtMost);
                    }
                } finally {
                    byteBufferChannel.restoreStateAfterRead();
                    byteBufferChannel.tryTerminate$ktor_io();
                }
            }
            long j3 = j2;
            if (j3 == j || byteBufferChannel.isClosedForRead()) {
                return Boxing.boxLong(j3);
            }
            return byteBufferChannel.discardSuspend(j3, j, continuation);
        }
        throw new IllegalArgumentException(("max shouldn't be negative: " + j).toString());
    }

    /* JADX INFO: finally extract failed */
    private final int tryWritePacketPart(ByteReadPacket byteReadPacket) {
        ByteBufferChannel byteBufferChannel;
        JoiningState joiningState = this.joining;
        if (joiningState == null || (byteBufferChannel = resolveDelegation(this, joiningState)) == null) {
            byteBufferChannel = this;
        }
        ByteBuffer byteBuffer = byteBufferChannel.setupStateForWrite$ktor_io();
        if (byteBuffer == null) {
            return 0;
        }
        RingBufferCapacity ringBufferCapacity = byteBufferChannel.getState().capacity;
        long totalBytesWritten2 = byteBufferChannel.getTotalBytesWritten();
        try {
            ClosedElement closed = byteBufferChannel.getClosed();
            if (closed == null) {
                ByteBufferChannel byteBufferChannel2 = byteBufferChannel;
                int tryWriteAtMost = ringBufferCapacity.tryWriteAtMost((int) Math.min(byteReadPacket.getRemaining(), (long) byteBuffer.remaining()));
                if (tryWriteAtMost > 0) {
                    byteBuffer.limit(byteBuffer.position() + tryWriteAtMost);
                    ByteBuffersKt.readFully(byteReadPacket, byteBuffer);
                    byteBufferChannel2.bytesWritten(byteBuffer, ringBufferCapacity, tryWriteAtMost);
                }
                if (ringBufferCapacity.isFull() || byteBufferChannel.getAutoFlush()) {
                    byteBufferChannel.flush();
                }
                if (byteBufferChannel != this) {
                    setTotalBytesWritten$ktor_io(getTotalBytesWritten() + (byteBufferChannel.getTotalBytesWritten() - totalBytesWritten2));
                }
                byteBufferChannel.restoreStateAfterWrite$ktor_io();
                byteBufferChannel.tryTerminate$ktor_io();
                return tryWriteAtMost;
            }
            Void unused = ByteBufferChannelKt.rethrowClosed(closed.getSendException());
            throw new KotlinNothingValueException();
        } catch (Throwable th) {
            if (ringBufferCapacity.isFull() || byteBufferChannel.getAutoFlush()) {
                byteBufferChannel.flush();
            }
            if (byteBufferChannel != this) {
                setTotalBytesWritten$ktor_io(getTotalBytesWritten() + (byteBufferChannel.getTotalBytesWritten() - totalBytesWritten2));
            }
            byteBufferChannel.restoreStateAfterWrite$ktor_io();
            byteBufferChannel.tryTerminate$ktor_io();
            throw th;
        }
    }

    private final boolean consumeEachBufferRangeFast(boolean z, Function2<? super ByteBuffer, ? super Boolean, Boolean> function2) {
        ByteBuffer byteBuffer = setupStateForRead();
        int i = true;
        if (byteBuffer != null) {
            RingBufferCapacity ringBufferCapacity = getState().capacity;
            if (ringBufferCapacity._availableForRead$internal == 0) {
                InlineMarker.finallyStart(i);
                restoreStateAfterRead();
                tryTerminate$ktor_io();
                InlineMarker.finallyEnd(i);
            } else {
                while (true) {
                    try {
                        if (!byteBuffer.hasRemaining() && !z) {
                            InlineMarker.finallyStart(i);
                            restoreStateAfterRead();
                            tryTerminate$ktor_io();
                            InlineMarker.finallyEnd(i);
                            break;
                        }
                        boolean booleanValue = ((Boolean) function2.invoke(byteBuffer, Boolean.valueOf(z))).booleanValue();
                        afterBufferVisited(byteBuffer, ringBufferCapacity);
                        if (!booleanValue || (z && !byteBuffer.hasRemaining())) {
                            i = 2;
                        }
                    } finally {
                        InlineMarker.finallyStart(i ? 1 : 0);
                        restoreStateAfterRead();
                        tryTerminate$ktor_io();
                        InlineMarker.finallyEnd(i);
                    }
                }
                i = 2;
                return i;
            }
        }
        z = false;
        if (z || getClosed() == null) {
            return z;
        }
        function2.invoke(ReadWriteBufferStateKt.getEmptyByteBuffer(), Boolean.valueOf(i));
        return i;
    }

    private final ByteReadPacket remainingPacket(long j) {
        Output output;
        BytePacketBuilder bytePacketBuilder = new BytePacketBuilder((ObjectPool) null, 1, (DefaultConstructorMarker) null);
        try {
            output = bytePacketBuilder;
            ChunkBuffer prepareWriteHead = UnsafeKt.prepareWriteHead(output, 1, (ChunkBuffer) null);
            while (true) {
                Buffer buffer = prepareWriteHead;
                if (((long) (buffer.getLimit() - buffer.getWritePosition())) > j) {
                    buffer.resetForWrite((int) j);
                }
                j -= (long) readAsMuchAsPossible$default(this, buffer, 0, 0, 6, (Object) null);
                if (j > 0 && !isClosedForRead()) {
                    prepareWriteHead = UnsafeKt.prepareWriteHead(output, 1, prepareWriteHead);
                } else {
                    output.afterHeadWrite();
                    return bytePacketBuilder.build();
                }
            }
        } catch (Throwable th) {
            bytePacketBuilder.release();
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x00f7 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x00ba A[EDGE_INSN: B:89:0x00ba->B:53:0x00ba ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.Object suspensionForSize(int r7, kotlin.coroutines.Continuation<? super java.lang.Boolean> r8) {
        /*
            r6 = this;
        L_0x0000:
            io.ktor.utils.io.internal.ReadWriteBufferState r0 = r6.getState()
            io.ktor.utils.io.internal.RingBufferCapacity r1 = r0.capacity
            int r1 = r1._availableForRead$internal
            r2 = 1
            r3 = 0
            if (r1 >= r7) goto L_0x0020
            io.ktor.utils.io.internal.JoiningState r1 = r6.joining
            if (r1 == 0) goto L_0x001e
            kotlin.coroutines.Continuation r1 = r6.getWriteOp()
            if (r1 == 0) goto L_0x001e
            io.ktor.utils.io.internal.ReadWriteBufferState$IdleEmpty r1 = io.ktor.utils.io.internal.ReadWriteBufferState.IdleEmpty.INSTANCE
            if (r0 == r1) goto L_0x0020
            boolean r0 = r0 instanceof io.ktor.utils.io.internal.ReadWriteBufferState.IdleNonEmpty
            if (r0 != 0) goto L_0x0020
        L_0x001e:
            r0 = r2
            goto L_0x0021
        L_0x0020:
            r0 = r3
        L_0x0021:
            if (r0 != 0) goto L_0x0032
            kotlin.Result$Companion r7 = kotlin.Result.Companion
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r2)
            java.lang.Object r7 = kotlin.Result.m320constructorimpl(r7)
            r8.resumeWith(r7)
            goto L_0x00f9
        L_0x0032:
            io.ktor.utils.io.internal.ClosedElement r0 = r6.getClosed()
            if (r0 == 0) goto L_0x0083
            java.lang.Throwable r1 = r0.getCause()
            if (r1 == 0) goto L_0x0054
            kotlin.Result$Companion r7 = kotlin.Result.Companion
            java.lang.Throwable r7 = r0.getCause()
            java.lang.Object r7 = kotlin.ResultKt.createFailure(r7)
            java.lang.Object r7 = kotlin.Result.m320constructorimpl(r7)
            r8.resumeWith(r7)
            java.lang.Object r7 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            return r7
        L_0x0054:
            io.ktor.utils.io.internal.ReadWriteBufferState r0 = r6.getState()
            io.ktor.utils.io.internal.RingBufferCapacity r0 = r0.capacity
            boolean r0 = r0.flush()
            io.ktor.utils.io.internal.ReadWriteBufferState r1 = r6.getState()
            io.ktor.utils.io.internal.RingBufferCapacity r1 = r1.capacity
            int r1 = r1._availableForRead$internal
            if (r1 < r7) goto L_0x006a
            r7 = r2
            goto L_0x006b
        L_0x006a:
            r7 = r3
        L_0x006b:
            kotlin.Result$Companion r1 = kotlin.Result.Companion
            if (r0 == 0) goto L_0x0072
            if (r7 == 0) goto L_0x0072
            goto L_0x0073
        L_0x0072:
            r2 = r3
        L_0x0073:
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r2)
            java.lang.Object r7 = kotlin.Result.m320constructorimpl(r7)
            r8.resumeWith(r7)
            java.lang.Object r7 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            return r7
        L_0x0083:
            kotlin.coroutines.Continuation r0 = r6.getReadOp()
            if (r0 != 0) goto L_0x008b
            r0 = r2
            goto L_0x008c
        L_0x008b:
            r0 = r3
        L_0x008c:
            if (r0 == 0) goto L_0x00fe
            io.ktor.utils.io.internal.ClosedElement r0 = r6.getClosed()
            if (r0 != 0) goto L_0x00b7
            io.ktor.utils.io.internal.ReadWriteBufferState r0 = r6.getState()
            io.ktor.utils.io.internal.RingBufferCapacity r1 = r0.capacity
            int r1 = r1._availableForRead$internal
            if (r1 >= r7) goto L_0x00b2
            io.ktor.utils.io.internal.JoiningState r1 = r6.joining
            if (r1 == 0) goto L_0x00b0
            kotlin.coroutines.Continuation r1 = r6.getWriteOp()
            if (r1 == 0) goto L_0x00b0
            io.ktor.utils.io.internal.ReadWriteBufferState$IdleEmpty r1 = io.ktor.utils.io.internal.ReadWriteBufferState.IdleEmpty.INSTANCE
            if (r0 == r1) goto L_0x00b2
            boolean r0 = r0 instanceof io.ktor.utils.io.internal.ReadWriteBufferState.IdleNonEmpty
            if (r0 != 0) goto L_0x00b2
        L_0x00b0:
            r0 = r2
            goto L_0x00b3
        L_0x00b2:
            r0 = r3
        L_0x00b3:
            if (r0 == 0) goto L_0x00b7
            r0 = r2
            goto L_0x00b8
        L_0x00b7:
            r0 = r3
        L_0x00b8:
            if (r0 != 0) goto L_0x00bc
        L_0x00ba:
            r2 = r3
            goto L_0x00f7
        L_0x00bc:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = _readOp$FU
            r1 = 0
            boolean r4 = r0.compareAndSet(r6, r1, r8)
            if (r4 == 0) goto L_0x0083
            io.ktor.utils.io.internal.ClosedElement r4 = r6.getClosed()
            if (r4 != 0) goto L_0x00ee
            io.ktor.utils.io.internal.ReadWriteBufferState r4 = r6.getState()
            io.ktor.utils.io.internal.RingBufferCapacity r5 = r4.capacity
            int r5 = r5._availableForRead$internal
            if (r5 >= r7) goto L_0x00e9
            io.ktor.utils.io.internal.JoiningState r5 = r6.joining
            if (r5 == 0) goto L_0x00e7
            kotlin.coroutines.Continuation r5 = r6.getWriteOp()
            if (r5 == 0) goto L_0x00e7
            io.ktor.utils.io.internal.ReadWriteBufferState$IdleEmpty r5 = io.ktor.utils.io.internal.ReadWriteBufferState.IdleEmpty.INSTANCE
            if (r4 == r5) goto L_0x00e9
            boolean r4 = r4 instanceof io.ktor.utils.io.internal.ReadWriteBufferState.IdleNonEmpty
            if (r4 != 0) goto L_0x00e9
        L_0x00e7:
            r4 = r2
            goto L_0x00ea
        L_0x00e9:
            r4 = r3
        L_0x00ea:
            if (r4 == 0) goto L_0x00ee
            r4 = r2
            goto L_0x00ef
        L_0x00ee:
            r4 = r3
        L_0x00ef:
            if (r4 != 0) goto L_0x00f7
            boolean r0 = r0.compareAndSet(r6, r8, r1)
            if (r0 != 0) goto L_0x00ba
        L_0x00f7:
            if (r2 == 0) goto L_0x0000
        L_0x00f9:
            java.lang.Object r7 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            return r7
        L_0x00fe:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "Operation is already in progress"
            java.lang.String r8 = r8.toString()
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel.suspensionForSize(int, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
