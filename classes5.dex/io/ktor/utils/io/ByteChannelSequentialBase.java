package io.ktor.utils.io;

import io.ktor.utils.io.core.Buffer;
import io.ktor.utils.io.core.BuffersKt;
import io.ktor.utils.io.core.BytePacketBuilder;
import io.ktor.utils.io.core.ByteReadPacket;
import io.ktor.utils.io.core.InputArraysKt;
import io.ktor.utils.io.core.InputPrimitivesKt;
import io.ktor.utils.io.core.Output;
import io.ktor.utils.io.core.OutputKt;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.core.internal.UTF8Kt;
import io.ktor.utils.io.core.internal.UnsafeKt;
import io.ktor.utils.io.internal.AwaitingSlot;
import io.ktor.utils.io.pool.ObjectPool;
import java.io.EOFException;
import java.nio.ByteBuffer;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000à\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b<\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b&\u0018\u00002\u00030Ö\u00012\u00030×\u00012\u00030Ø\u00012\u00020{2\u00030Ù\u00012\u00030Ú\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000e\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0004¢\u0006\u0004\b\u000f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0004¢\u0006\u0004\b\u0010\u0010\rJ\u001b\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\tH@ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH@ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0013J\u001b\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH@ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0013J\u0013\u0010\u0018\u001a\u00020\u000bH@ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u000bH@ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0019J\u0013\u0010\u001c\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u0019J\u001b\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\tH@ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u0013J\u000f\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b\u001f\u0010 J\u0019\u0010#\u001a\u00020\u00032\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016¢\u0006\u0004\b#\u0010$J#\u0010(\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\t2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010&H\u0002¢\u0006\u0004\b(\u0010)J\u0019\u0010*\u001a\u00020\u00032\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016¢\u0006\u0004\b*\u0010$J\u000f\u0010+\u001a\u00020\u000bH\u0002¢\u0006\u0004\b+\u0010,J\u0017\u0010.\u001a\u00020\t2\u0006\u0010-\u001a\u00020\tH\u0016¢\u0006\u0004\b.\u0010/J\u001b\u0010.\u001a\u0002002\u0006\u00101\u001a\u000200H@ø\u0001\u0000¢\u0006\u0004\b.\u00102J#\u00104\u001a\u0002002\u0006\u00101\u001a\u0002002\u0006\u00103\u001a\u000200H@ø\u0001\u0000¢\u0006\u0004\b4\u00105J\u000f\u00106\u001a\u00020\u000bH\u0016¢\u0006\u0004\b6\u0010,J\u0017\u00108\u001a\u00020\u000b2\u0006\u00107\u001a\u00020\tH\u0016¢\u0006\u0004\b8\u0010\rJ\u000f\u00109\u001a\u00020\u000bH\u0002¢\u0006\u0004\b9\u0010,J\u000f\u0010:\u001a\u00020\u000bH\u0002¢\u0006\u0004\b:\u0010,J\u0017\u0010:\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020&H\u0002¢\u0006\u0004\b:\u0010;J\u000f\u0010<\u001a\u00020\u000bH\u0016¢\u0006\u0004\b<\u0010,J\u000f\u0010=\u001a\u00020\u0003H\u0002¢\u0006\u0004\b=\u0010>J\u000f\u0010?\u001a\u00020\u000bH\u0002¢\u0006\u0004\b?\u0010,JA\u0010G\u001a\u0002002\u0006\u0010A\u001a\u00020@2\u0006\u0010B\u001a\u0002002\u0006\u0010C\u001a\u0002002\u0006\u0010D\u001a\u0002002\u0006\u00101\u001a\u000200H@ø\u0001\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bE\u0010FJ\u000f\u0010H\u001a\u00020\u000bH\u0004¢\u0006\u0004\bH\u0010,J\u001b\u0010M\u001a\u00020\t2\u0006\u0010J\u001a\u00020IH@ø\u0001\u0000¢\u0006\u0004\bK\u0010LJ\u001b\u0010M\u001a\u00020\t2\u0006\u0010J\u001a\u00020\u0001H@ø\u0001\u0000¢\u0006\u0004\bM\u0010NJ+\u0010M\u001a\u00020\t2\u0006\u0010J\u001a\u00020O2\u0006\u0010C\u001a\u00020\t2\u0006\u0010P\u001a\u00020\tH@ø\u0001\u0000¢\u0006\u0004\bM\u0010QJ\u000f\u0010R\u001a\u00020\tH\u0004¢\u0006\u0004\bR\u0010SJ\u0013\u0010T\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0004\bT\u0010\u0019J\u0013\u0010U\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0004\bU\u0010\u0019J\u0013\u0010W\u001a\u00020VH@ø\u0001\u0000¢\u0006\u0004\bW\u0010\u0019J\u0013\u0010X\u001a\u00020VH@ø\u0001\u0000¢\u0006\u0004\bX\u0010\u0019J\u0013\u0010Z\u001a\u00020YH@ø\u0001\u0000¢\u0006\u0004\bZ\u0010\u0019J\u0013\u0010[\u001a\u00020YH@ø\u0001\u0000¢\u0006\u0004\b[\u0010\u0019J\u0013\u0010]\u001a\u00020\\H@ø\u0001\u0000¢\u0006\u0004\b]\u0010\u0019J\u0013\u0010^\u001a\u00020\\H@ø\u0001\u0000¢\u0006\u0004\b^\u0010\u0019J#\u0010_\u001a\u00020\u000b2\u0006\u0010J\u001a\u00020I2\u0006\u0010-\u001a\u00020\tH@ø\u0001\u0000¢\u0006\u0004\b_\u0010`J#\u0010_\u001a\u00020\u000b2\u0006\u0010J\u001a\u00020\u00012\u0006\u0010-\u001a\u00020\tH@ø\u0001\u0000¢\u0006\u0004\b_\u0010aJ+\u0010_\u001a\u00020\u000b2\u0006\u0010J\u001a\u00020O2\u0006\u0010C\u001a\u00020\t2\u0006\u0010P\u001a\u00020\tH@ø\u0001\u0000¢\u0006\u0004\b_\u0010QJ#\u0010b\u001a\u00020\u000b2\u0006\u0010J\u001a\u00020I2\u0006\u0010-\u001a\u00020\tH@ø\u0001\u0000¢\u0006\u0004\bb\u0010`J+\u0010b\u001a\u00020\u000b2\u0006\u0010J\u001a\u00020O2\u0006\u0010C\u001a\u00020\t2\u0006\u0010P\u001a\u00020\tH@ø\u0001\u0000¢\u0006\u0004\bb\u0010QJ\u0013\u0010c\u001a\u00020\tH@ø\u0001\u0000¢\u0006\u0004\bc\u0010\u0019J\u0013\u0010d\u001a\u00020\tH@ø\u0001\u0000¢\u0006\u0004\bd\u0010\u0019J\u0013\u0010e\u001a\u000200H@ø\u0001\u0000¢\u0006\u0004\be\u0010\u0019J\u0013\u0010f\u001a\u000200H@ø\u0001\u0000¢\u0006\u0004\bf\u0010\u0019J\u001b\u0010i\u001a\u00020h2\u0006\u0010g\u001a\u00020\tH@ø\u0001\u0000¢\u0006\u0004\bi\u0010\u0013J#\u0010k\u001a\u00020h2\u0006\u0010j\u001a\u00020&2\u0006\u0010g\u001a\u00020\tH@ø\u0001\u0000¢\u0006\u0004\bk\u0010lJ\u001b\u0010n\u001a\u00020h2\u0006\u0010m\u001a\u000200H@ø\u0001\u0000¢\u0006\u0004\bn\u00102J#\u0010o\u001a\u00020h2\u0006\u0010j\u001a\u00020&2\u0006\u0010m\u001a\u000200H@ø\u0001\u0000¢\u0006\u0004\bo\u0010pJ(\u0010u\u001a\u00020\u000b2\u0017\u0010t\u001a\u0013\u0012\u0004\u0012\u00020r\u0012\u0004\u0012\u00020\u000b0q¢\u0006\u0002\bsH\u0017¢\u0006\u0004\bu\u0010vJ\u0013\u0010x\u001a\u00020wH@ø\u0001\u0000¢\u0006\u0004\bx\u0010\u0019J\u0013\u0010y\u001a\u00020wH@ø\u0001\u0000¢\u0006\u0004\by\u0010\u0019J<\u0010~\u001a\u00020\u000b2'\u0010t\u001a#\b\u0001\u0012\u0004\u0012\u00020{\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0|\u0012\u0006\u0012\u0004\u0018\u00010}0z¢\u0006\u0002\bsH@ø\u0001\u0000¢\u0006\u0004\b~\u0010J \u0010\u0001\u001a\u0005\u0018\u00010\u00012\u0006\u0010m\u001a\u00020\tH@ø\u0001\u0000¢\u0006\u0005\b\u0001\u0010\u0013J8\u0010\u0001\u001a\u00020\u0003\"\u000f\b\u0000\u0010\u0001*\b0\u0001j\u0003`\u00012\u0007\u0010\u0001\u001a\u00028\u00002\u0006\u0010m\u001a\u00020\tH@ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u001c\u0010\u0001\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0011\u001a\u00020\tH\u0016¢\u0006\u0006\b\u0001\u0010\u0001J\u001c\u0010\u0001\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0011\u001a\u00020\tH\u0002¢\u0006\u0006\b\u0001\u0010\u0001J\u0012\u0010\u0001\u001a\u00020{H\u0016¢\u0006\u0006\b\u0001\u0010\u0001J\"\u0010\u0001\u001a\u0002002\u0006\u0010J\u001a\u00020\u00002\u0006\u0010m\u001a\u000200H\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u001e\u0010\u0001\u001a\u00020\t2\u0007\u0010\u0001\u001a\u00020\u0001H@ø\u0001\u0000¢\u0006\u0005\b\u0001\u0010NJ.\u0010\u0001\u001a\u00020\t2\u0007\u0010\u0001\u001a\u00020O2\u0006\u0010C\u001a\u00020\t2\u0006\u0010P\u001a\u00020\tH@ø\u0001\u0000¢\u0006\u0005\b\u0001\u0010QJ\u001e\u0010\u0001\u001a\u00020\t2\u0007\u0010\u0001\u001a\u00020\u0001H@ø\u0001\u0000¢\u0006\u0005\b\u0001\u0010NJ.\u0010\u0001\u001a\u00020\t2\u0007\u0010\u0001\u001a\u00020O2\u0006\u0010C\u001a\u00020\t2\u0006\u0010P\u001a\u00020\tH@ø\u0001\u0000¢\u0006\u0005\b\u0001\u0010QJ\u001f\u0010\u0001\u001a\u00020\u000b2\u0007\u0010\u0001\u001a\u00020VH@ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u001f\u0010\u0001\u001a\u00020\u000b2\u0007\u0010\u0001\u001a\u00020YH@ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u001f\u0010\u0001\u001a\u00020\u000b2\u0007\u0010\u0001\u001a\u00020\\H@ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J7\u0010¡\u0001\u001a\u00020\u000b2\u0007\u0010\u0001\u001a\u00020@2\u0007\u0010\u0001\u001a\u00020\t2\u0007\u0010\u0001\u001a\u00020\tH@ø\u0001\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\b\u0001\u0010 \u0001J\u001e\u0010¡\u0001\u001a\u00020\u000b2\u0007\u0010\u0001\u001a\u00020IH@ø\u0001\u0000¢\u0006\u0005\b¡\u0001\u0010LJ.\u0010¡\u0001\u001a\u00020\u000b2\u0007\u0010\u0001\u001a\u00020O2\u0006\u0010C\u001a\u00020\t2\u0006\u0010P\u001a\u00020\tH@ø\u0001\u0000¢\u0006\u0005\b¡\u0001\u0010QJ\u001e\u0010£\u0001\u001a\u00020\u000b2\u0007\u0010¢\u0001\u001a\u00020\tH@ø\u0001\u0000¢\u0006\u0005\b£\u0001\u0010\u0013J\u001e\u0010¥\u0001\u001a\u00020\u000b2\u0007\u0010¤\u0001\u001a\u000200H@ø\u0001\u0000¢\u0006\u0005\b¥\u0001\u00102J\u001f\u0010§\u0001\u001a\u00020\u000b2\u0007\u0010¦\u0001\u001a\u00020hH@ø\u0001\u0000¢\u0006\u0006\b§\u0001\u0010¨\u0001J\u001f\u0010ª\u0001\u001a\u00020\u000b2\u0007\u0010©\u0001\u001a\u00020wH@ø\u0001\u0000¢\u0006\u0006\bª\u0001\u0010«\u0001J?\u0010­\u0001\u001a\u00020\u000b2(\u0010¬\u0001\u001a#\b\u0001\u0012\u0004\u0012\u00020\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0|\u0012\u0006\u0012\u0004\u0018\u00010}0z¢\u0006\u0002\bsH@ø\u0001\u0000¢\u0006\u0005\b­\u0001\u0010R\u001c\u0010\u0004\u001a\u00020\u00038\u0016X\u0004¢\u0006\u000e\n\u0005\b\u0004\u0010®\u0001\u001a\u0005\b¯\u0001\u0010>R\u0016\u0010±\u0001\u001a\u00020\t8VX\u0004¢\u0006\u0007\u001a\u0005\b°\u0001\u0010SR\u0016\u0010³\u0001\u001a\u00020\t8VX\u0004¢\u0006\u0007\u001a\u0005\b²\u0001\u0010SR)\u0010¸\u0001\u001a\u00020\u00032\u0007\u0010´\u0001\u001a\u00020\u00038D@DX\u000e¢\u0006\u000f\u001a\u0005\bµ\u0001\u0010>\"\u0006\b¶\u0001\u0010·\u0001R.\u0010½\u0001\u001a\u0004\u0018\u00010!2\t\u0010´\u0001\u001a\u0004\u0018\u00010!8F@FX\u000e¢\u0006\u0010\u001a\u0006\b¹\u0001\u0010º\u0001\"\u0006\b»\u0001\u0010¼\u0001R\u0017\u0010¾\u0001\u001a\u00020&8\u0002X\u0004¢\u0006\b\n\u0006\b¾\u0001\u0010¿\u0001R\u001c\u0010Á\u0001\u001a\u00070}j\u0003`À\u00018\u0002X\u0004¢\u0006\b\n\u0006\bÁ\u0001\u0010Â\u0001R\u0016\u0010Ã\u0001\u001a\u00020\u00038BX\u0004¢\u0006\u0007\u001a\u0005\bÃ\u0001\u0010>R\u0016\u0010Ä\u0001\u001a\u00020\u00038VX\u0004¢\u0006\u0007\u001a\u0005\bÄ\u0001\u0010>R\u0016\u0010Å\u0001\u001a\u00020\u00038VX\u0004¢\u0006\u0007\u001a\u0005\bÅ\u0001\u0010>R\u001f\u0010Æ\u0001\u001a\u00020h8\u0004X\u0004¢\u0006\u0010\n\u0006\bÆ\u0001\u0010Ç\u0001\u001a\u0006\bÈ\u0001\u0010É\u0001R\u0018\u0010Ë\u0001\u001a\u00030Ê\u00018\u0002X\u0004¢\u0006\b\n\u0006\bË\u0001\u0010Ì\u0001R\u0017\u0010Ï\u0001\u001a\u0002008VX\u0004¢\u0006\b\u001a\u0006\bÍ\u0001\u0010Î\u0001R\u0017\u0010Ñ\u0001\u001a\u0002008VX\u0004¢\u0006\b\u001a\u0006\bÐ\u0001\u0010Î\u0001R\u001f\u0010Ò\u0001\u001a\u00020&8\u0004X\u0004¢\u0006\u0010\n\u0006\bÒ\u0001\u0010¿\u0001\u001a\u0006\bÓ\u0001\u0010Ô\u0001\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006Õ\u0001"}, d2 = {"Lio/ktor/utils/io/ByteChannelSequentialBase;", "Lio/ktor/utils/io/core/internal/ChunkBuffer;", "initial", "", "autoFlush", "Lio/ktor/utils/io/pool/ObjectPool;", "pool", "<init>", "(Lio/ktor/utils/io/core/internal/ChunkBuffer;ZLio/ktor/utils/io/pool/ObjectPool;)V", "", "count", "", "addBytesRead", "(I)V", "addBytesWritten", "afterRead", "afterWrite", "atLeast", "await", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitAtLeastNBytesAvailableForRead$ktor_io", "awaitAtLeastNBytesAvailableForRead", "awaitAtLeastNBytesAvailableForWrite$ktor_io", "awaitAtLeastNBytesAvailableForWrite", "awaitContent", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitFreeSpace", "awaitInternalAtLeast1$ktor_io", "awaitInternalAtLeast1", "awaitSuspend", "Lio/ktor/utils/io/WriterSuspendSession;", "beginWriteSession", "()Lio/ktor/utils/io/WriterSuspendSession;", "", "cause", "cancel", "(Ljava/lang/Throwable;)Z", "remaining", "Lio/ktor/utils/io/core/BytePacketBuilder;", "closeable", "checkClosed", "(ILio/ktor/utils/io/core/BytePacketBuilder;)V", "close", "completeReading", "()V", "n", "discard", "(I)I", "", "max", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "discarded0", "discardSuspend", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "endReadSession", "written", "endWriteSession", "ensureNotClosed", "ensureNotFailed", "(Lio/ktor/utils/io/core/BytePacketBuilder;)V", "flush", "flushImpl", "()Z", "flushWrittenBytes", "Lio/ktor/utils/io/bits/Memory;", "destination", "destinationOffset", "offset", "min", "peekTo-lBXzO7A", "(Ljava/nio/ByteBuffer;JJJJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "peekTo", "prepareFlushedBytes", "Lio/ktor/utils/io/core/Buffer;", "dst", "readAvailable$ktor_io", "(Lio/ktor/utils/io/core/Buffer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readAvailable", "(Lio/ktor/utils/io/core/internal/ChunkBuffer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "length", "([BIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readAvailableClosed", "()I", "readBoolean", "readBooleanSlow", "", "readByte", "readByteSlow", "", "readDouble", "readDoubleSlow", "", "readFloat", "readFloatSlow", "readFully", "(Lio/ktor/utils/io/core/Buffer;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lio/ktor/utils/io/core/internal/ChunkBuffer;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readFullySuspend", "readInt", "readIntSlow", "readLong", "readLongSlow", "size", "Lio/ktor/utils/io/core/ByteReadPacket;", "readPacket", "builder", "readPacketSuspend", "(Lio/ktor/utils/io/core/BytePacketBuilder;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "limit", "readRemaining", "readRemainingSuspend", "(Lio/ktor/utils/io/core/BytePacketBuilder;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/Function1;", "Lio/ktor/utils/io/ReadSession;", "Lkotlin/ExtensionFunctionType;", "consumer", "readSession", "(Lkotlin/jvm/functions/Function1;)V", "", "readShort", "readShortSlow", "Lkotlin/Function2;", "Lio/ktor/utils/io/SuspendableReadSession;", "Lkotlin/coroutines/Continuation;", "", "readSuspendableSession", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "readUTF8Line", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "A", "out", "readUTF8LineTo", "(Ljava/lang/Appendable;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "request", "(I)Lio/ktor/utils/io/core/internal/ChunkBuffer;", "requestNextView", "startReadSession", "()Lio/ktor/utils/io/SuspendableReadSession;", "transferTo$ktor_io", "(Lio/ktor/utils/io/ByteChannelSequentialBase;J)J", "transferTo", "src", "writeAvailable", "writeAvailableSuspend", "b", "writeByte", "(BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "d", "writeDouble", "(DLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "f", "writeFloat", "(FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "memory", "startIndex", "endIndex", "writeFully-JT6ljtQ", "(Ljava/nio/ByteBuffer;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeFully", "i", "writeInt", "l", "writeLong", "packet", "writePacket", "(Lio/ktor/utils/io/core/ByteReadPacket;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "s", "writeShort", "(SLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "visitor", "writeSuspendSession", "Z", "getAutoFlush", "getAvailableForRead", "availableForRead", "getAvailableForWrite", "availableForWrite", "<anonymous parameter 0>", "getClosed", "setClosed", "(Z)V", "closed", "getClosedCause", "()Ljava/lang/Throwable;", "setClosedCause", "(Ljava/lang/Throwable;)V", "closedCause", "flushBuffer", "Lio/ktor/utils/io/core/BytePacketBuilder;", "Lkotlinx/atomicfu/locks/SynchronizedObject;", "flushMutex", "Ljava/lang/Object;", "isCancelled", "isClosedForRead", "isClosedForWrite", "readable", "Lio/ktor/utils/io/core/ByteReadPacket;", "getReadable", "()Lio/ktor/utils/io/core/ByteReadPacket;", "Lio/ktor/utils/io/internal/AwaitingSlot;", "slot", "Lio/ktor/utils/io/internal/AwaitingSlot;", "getTotalBytesRead", "()J", "totalBytesRead", "getTotalBytesWritten", "totalBytesWritten", "writable", "getWritable", "()Lio/ktor/utils/io/core/BytePacketBuilder;", "ktor-io", "Lio/ktor/utils/io/ByteChannel;", "Lio/ktor/utils/io/ByteReadChannel;", "Lio/ktor/utils/io/ByteWriteChannel;", "Lio/ktor/utils/io/HasReadSession;", "Lio/ktor/utils/io/HasWriteSession;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ByteChannelSequential.kt */
public abstract class ByteChannelSequentialBase implements ByteChannel, ByteReadChannel, ByteWriteChannel, SuspendableReadSession, HasReadSession, HasWriteSession {
    private static final /* synthetic */ AtomicIntegerFieldUpdater _availableForRead$FU;
    private static final /* synthetic */ AtomicReferenceFieldUpdater _closed$FU;
    private static final /* synthetic */ AtomicLongFieldUpdater _totalBytesRead$FU;
    private static final /* synthetic */ AtomicLongFieldUpdater _totalBytesWritten$FU;
    private static final /* synthetic */ AtomicIntegerFieldUpdater channelSize$FU;
    private volatile /* synthetic */ int _availableForRead;
    private volatile /* synthetic */ Object _closed;
    private volatile /* synthetic */ Object _lastReadView;
    private volatile /* synthetic */ long _totalBytesRead;
    private volatile /* synthetic */ long _totalBytesWritten;
    private final boolean autoFlush;
    private volatile /* synthetic */ int channelSize;
    private final BytePacketBuilder flushBuffer;
    private final Object flushMutex;
    private volatile /* synthetic */ int lastReadAvailable$delegate;
    private volatile /* synthetic */ Object lastReadView$delegate;
    private final ByteReadPacket readable;
    private final AwaitingSlot slot;
    private final BytePacketBuilder writable;

    static {
        Class<ByteChannelSequentialBase> cls = ByteChannelSequentialBase.class;
        _totalBytesRead$FU = AtomicLongFieldUpdater.newUpdater(cls, "_totalBytesRead");
        _totalBytesWritten$FU = AtomicLongFieldUpdater.newUpdater(cls, "_totalBytesWritten");
        _availableForRead$FU = AtomicIntegerFieldUpdater.newUpdater(cls, "_availableForRead");
        channelSize$FU = AtomicIntegerFieldUpdater.newUpdater(cls, "channelSize");
        _closed$FU = AtomicReferenceFieldUpdater.newUpdater(cls, Object.class, "_closed");
    }

    public Object await(int i, Continuation<? super Boolean> continuation) {
        return await$suspendImpl(this, i, continuation);
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

    public Object readAvailable(ChunkBuffer chunkBuffer, Continuation<? super Integer> continuation) {
        return readAvailable$ktor_io(chunkBuffer, continuation);
    }

    public Object readAvailable(byte[] bArr, int i, int i2, Continuation<? super Integer> continuation) {
        return readAvailable$suspendImpl(this, bArr, i, i2, continuation);
    }

    public Object readBoolean(Continuation<? super Boolean> continuation) {
        return readBoolean$suspendImpl(this, continuation);
    }

    public Object readByte(Continuation<? super Byte> continuation) {
        return readByte$suspendImpl(this, continuation);
    }

    public Object readDouble(Continuation<? super Double> continuation) {
        return readDouble$suspendImpl(this, continuation);
    }

    public Object readFloat(Continuation<? super Float> continuation) {
        return readFloat$suspendImpl(this, continuation);
    }

    public Object readFully(ChunkBuffer chunkBuffer, int i, Continuation<? super Unit> continuation) {
        return readFully$suspendImpl(this, chunkBuffer, i, continuation);
    }

    public Object readFully(byte[] bArr, int i, int i2, Continuation<? super Unit> continuation) {
        return readFully$suspendImpl(this, bArr, i, i2, continuation);
    }

    public Object readInt(Continuation<? super Integer> continuation) {
        return readInt$suspendImpl(this, continuation);
    }

    public Object readLong(Continuation<? super Long> continuation) {
        return readLong$suspendImpl(this, continuation);
    }

    public Object readPacket(int i, Continuation<? super ByteReadPacket> continuation) {
        return readPacket$suspendImpl(this, i, continuation);
    }

    public Object readRemaining(long j, Continuation<? super ByteReadPacket> continuation) {
        return readRemaining$suspendImpl(this, j, continuation);
    }

    public Object readShort(Continuation<? super Short> continuation) {
        return readShort$suspendImpl(this, continuation);
    }

    @Deprecated(message = "Use read instead.")
    public Object readSuspendableSession(Function2<? super SuspendableReadSession, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        return readSuspendableSession$suspendImpl(this, function2, continuation);
    }

    public Object readUTF8Line(int i, Continuation<? super String> continuation) {
        return readUTF8Line$suspendImpl(this, i, continuation);
    }

    public <A extends Appendable> Object readUTF8LineTo(A a, int i, Continuation<? super Boolean> continuation) {
        return readUTF8LineTo$suspendImpl(this, a, i, continuation);
    }

    public Object writeAvailable(ChunkBuffer chunkBuffer, Continuation<? super Integer> continuation) {
        return writeAvailable$suspendImpl(this, chunkBuffer, continuation);
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
        return writeFully$suspendImpl(this, buffer, continuation);
    }

    public Object writeFully(byte[] bArr, int i, int i2, Continuation<? super Unit> continuation) {
        return writeFully$suspendImpl(this, bArr, i, i2, continuation);
    }

    /* renamed from: writeFully-JT6ljtQ  reason: not valid java name */
    public Object m26writeFullyJT6ljtQ(ByteBuffer byteBuffer, int i, int i2, Continuation<? super Unit> continuation) {
        return m24writeFullyJT6ljtQ$suspendImpl(this, byteBuffer, i, i2, continuation);
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

    public ByteChannelSequentialBase(ChunkBuffer chunkBuffer, boolean z, ObjectPool<ChunkBuffer> objectPool) {
        Intrinsics.checkNotNullParameter(chunkBuffer, "initial");
        Intrinsics.checkNotNullParameter(objectPool, "pool");
        this.autoFlush = z;
        this._lastReadView = ChunkBuffer.Companion.getEmpty();
        this._totalBytesRead = 0;
        this._totalBytesWritten = 0;
        this._availableForRead = 0;
        this.channelSize = 0;
        this._closed = null;
        this.writable = new BytePacketBuilder(objectPool);
        this.readable = new ByteReadPacket(chunkBuffer, objectPool);
        this.lastReadAvailable$delegate = 0;
        this.lastReadView$delegate = ChunkBuffer.Companion.getEmpty();
        this.slot = new AwaitingSlot();
        this.flushMutex = new Object();
        this.flushBuffer = new BytePacketBuilder((ObjectPool) null, 1, (DefaultConstructorMarker) null);
        int remainingAll = (int) BuffersKt.remainingAll(chunkBuffer);
        afterWrite(remainingAll);
        _availableForRead$FU.addAndGet(this, remainingAll);
    }

    public boolean getAutoFlush() {
        return this.autoFlush;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ByteChannelSequentialBase(ChunkBuffer chunkBuffer, boolean z, ObjectPool<ChunkBuffer> objectPool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(chunkBuffer, z, (i & 4) != 0 ? ChunkBuffer.Companion.getPool() : objectPool);
    }

    private final boolean isCancelled() {
        CloseElement closeElement = (CloseElement) this._closed;
        return (closeElement != null ? closeElement.getCause() : null) != null;
    }

    /* access modifiers changed from: protected */
    public final boolean getClosed() {
        return this._closed != null;
    }

    /* access modifiers changed from: protected */
    public final void setClosed(boolean z) {
        throw new IllegalStateException("Setting is not allowed for closed".toString());
    }

    /* access modifiers changed from: protected */
    public final BytePacketBuilder getWritable() {
        return this.writable;
    }

    /* access modifiers changed from: protected */
    public final ByteReadPacket getReadable() {
        return this.readable;
    }

    private final int getLastReadAvailable() {
        return this.lastReadAvailable$delegate;
    }

    private final void setLastReadAvailable(int i) {
        this.lastReadAvailable$delegate = i;
    }

    private final ChunkBuffer getLastReadView() {
        return (ChunkBuffer) this.lastReadView$delegate;
    }

    private final void setLastReadView(ChunkBuffer chunkBuffer) {
        this.lastReadView$delegate = chunkBuffer;
    }

    public int getAvailableForRead() {
        return this._availableForRead;
    }

    public int getAvailableForWrite() {
        return Math.max(0, 4088 - this.channelSize);
    }

    public boolean isClosedForRead() {
        return isCancelled() || (getClosed() && this.channelSize == 0);
    }

    public boolean isClosedForWrite() {
        return getClosed();
    }

    public long getTotalBytesRead() {
        return this._totalBytesRead;
    }

    public long getTotalBytesWritten() {
        return this._totalBytesWritten;
    }

    public final Throwable getClosedCause() {
        CloseElement closeElement = (CloseElement) this._closed;
        if (closeElement != null) {
            return closeElement.getCause();
        }
        return null;
    }

    public final void setClosedCause(Throwable th) {
        throw new IllegalStateException("Closed cause shouldn't be changed directly".toString());
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object awaitAtLeastNBytesAvailableForWrite$ktor_io(int r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof io.ktor.utils.io.ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForWrite$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            io.ktor.utils.io.ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForWrite$1 r0 = (io.ktor.utils.io.ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForWrite$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            io.ktor.utils.io.ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForWrite$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForWrite$1
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
            io.ktor.utils.io.ByteChannelSequentialBase r2 = (io.ktor.utils.io.ByteChannelSequentialBase) r2
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
            int r7 = r2.getAvailableForWrite()
            if (r7 >= r6) goto L_0x0064
            boolean r7 = r2.getClosed()
            if (r7 != 0) goto L_0x0064
            boolean r7 = r2.flushImpl()
            if (r7 != 0) goto L_0x003c
            io.ktor.utils.io.internal.AwaitingSlot r7 = r2.slot
            io.ktor.utils.io.ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForWrite$2 r4 = new io.ktor.utils.io.ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForWrite$2
            r4.<init>(r2, r6)
            kotlin.jvm.functions.Function0 r4 = (kotlin.jvm.functions.Function0) r4
            r0.L$0 = r2
            r0.I$0 = r6
            r0.label = r3
            java.lang.Object r7 = r7.sleep(r4, r0)
            if (r7 != r1) goto L_0x003c
            return r1
        L_0x0064:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.awaitAtLeastNBytesAvailableForWrite$ktor_io(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object awaitAtLeastNBytesAvailableForRead$ktor_io(int r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof io.ktor.utils.io.ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForRead$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            io.ktor.utils.io.ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForRead$1 r0 = (io.ktor.utils.io.ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForRead$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            io.ktor.utils.io.ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForRead$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForRead$1
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
            io.ktor.utils.io.ByteChannelSequentialBase r2 = (io.ktor.utils.io.ByteChannelSequentialBase) r2
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
            int r7 = r2.getAvailableForRead()
            if (r7 >= r6) goto L_0x005e
            boolean r7 = r2.getClosed()
            if (r7 != 0) goto L_0x005e
            io.ktor.utils.io.internal.AwaitingSlot r7 = r2.slot
            io.ktor.utils.io.ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForRead$2 r4 = new io.ktor.utils.io.ByteChannelSequentialBase$awaitAtLeastNBytesAvailableForRead$2
            r4.<init>(r2, r6)
            kotlin.jvm.functions.Function0 r4 = (kotlin.jvm.functions.Function0) r4
            r0.L$0 = r2
            r0.I$0 = r6
            r0.label = r3
            java.lang.Object r7 = r7.sleep(r4, r0)
            if (r7 != r1) goto L_0x003c
            return r1
        L_0x005e:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.awaitAtLeastNBytesAvailableForRead$ktor_io(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public void flush() {
        flushImpl();
    }

    private final boolean flushImpl() {
        if (this.writable.isEmpty()) {
            this.slot.resume();
            return false;
        }
        flushWrittenBytes();
        this.slot.resume();
        return true;
    }

    private final void flushWrittenBytes() {
        synchronized (this.flushMutex) {
            int size = this.writable.getSize();
            ChunkBuffer stealAll$ktor_io = this.writable.stealAll$ktor_io();
            Intrinsics.checkNotNull(stealAll$ktor_io);
            this.flushBuffer.writeChunkBuffer$ktor_io(stealAll$ktor_io);
            _availableForRead$FU.addAndGet(this, size);
        }
    }

    /* access modifiers changed from: protected */
    public final void prepareFlushedBytes() {
        synchronized (this.flushMutex) {
            UnsafeKt.unsafeAppend(this.readable, this.flushBuffer);
        }
    }

    private final void ensureNotClosed() {
        if (getClosed()) {
            Throwable closedCause = getClosedCause();
            if (closedCause == null) {
                closedCause = new ClosedWriteChannelException("Channel " + this + " is already closed");
            }
            throw closedCause;
        }
    }

    private final void ensureNotFailed() {
        Throwable closedCause = getClosedCause();
        if (closedCause != null) {
            throw closedCause;
        }
    }

    private final void ensureNotFailed(BytePacketBuilder bytePacketBuilder) {
        Throwable closedCause = getClosedCause();
        if (closedCause != null) {
            bytePacketBuilder.release();
            throw closedCause;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ java.lang.Object writeByte$suspendImpl(io.ktor.utils.io.ByteChannelSequentialBase r4, byte r5, kotlin.coroutines.Continuation r6) {
        /*
            boolean r0 = r6 instanceof io.ktor.utils.io.ByteChannelSequentialBase$writeByte$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            io.ktor.utils.io.ByteChannelSequentialBase$writeByte$1 r0 = (io.ktor.utils.io.ByteChannelSequentialBase$writeByte$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            io.ktor.utils.io.ByteChannelSequentialBase$writeByte$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$writeByte$1
            r0.<init>(r4, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0038
            if (r2 != r3) goto L_0x0030
            byte r5 = r0.B$0
            java.lang.Object r4 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r4 = (io.ktor.utils.io.ByteChannelSequentialBase) r4
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0048
        L_0x0030:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0038:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.L$0 = r4
            r0.B$0 = r5
            r0.label = r3
            java.lang.Object r6 = r4.awaitAtLeastNBytesAvailableForWrite$ktor_io(r3, r0)
            if (r6 != r1) goto L_0x0048
            return r1
        L_0x0048:
            io.ktor.utils.io.core.BytePacketBuilder r6 = r4.writable
            byte r5 = (byte) r5
            r6.writeByte(r5)
            r4.afterWrite(r3)
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.writeByte$suspendImpl(io.ktor.utils.io.ByteChannelSequentialBase, byte, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ java.lang.Object writeShort$suspendImpl(io.ktor.utils.io.ByteChannelSequentialBase r5, short r6, kotlin.coroutines.Continuation r7) {
        /*
            boolean r0 = r7 instanceof io.ktor.utils.io.ByteChannelSequentialBase$writeShort$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            io.ktor.utils.io.ByteChannelSequentialBase$writeShort$1 r0 = (io.ktor.utils.io.ByteChannelSequentialBase$writeShort$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            io.ktor.utils.io.ByteChannelSequentialBase$writeShort$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$writeShort$1
            r0.<init>(r5, r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0039
            if (r2 != r4) goto L_0x0031
            short r6 = r0.S$0
            java.lang.Object r5 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r5 = (io.ktor.utils.io.ByteChannelSequentialBase) r5
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0049
        L_0x0031:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0039:
            kotlin.ResultKt.throwOnFailure(r7)
            r0.L$0 = r5
            r0.S$0 = r6
            r0.label = r4
            java.lang.Object r7 = r5.awaitAtLeastNBytesAvailableForWrite$ktor_io(r3, r0)
            if (r7 != r1) goto L_0x0049
            return r1
        L_0x0049:
            io.ktor.utils.io.core.BytePacketBuilder r7 = r5.writable
            io.ktor.utils.io.core.Output r7 = (io.ktor.utils.io.core.Output) r7
            short r6 = (short) r6
            io.ktor.utils.io.core.OutputPrimitivesKt.writeShort(r7, r6)
            r5.afterWrite(r3)
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.writeShort$suspendImpl(io.ktor.utils.io.ByteChannelSequentialBase, short, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ java.lang.Object writeInt$suspendImpl(io.ktor.utils.io.ByteChannelSequentialBase r5, int r6, kotlin.coroutines.Continuation r7) {
        /*
            boolean r0 = r7 instanceof io.ktor.utils.io.ByteChannelSequentialBase$writeInt$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            io.ktor.utils.io.ByteChannelSequentialBase$writeInt$1 r0 = (io.ktor.utils.io.ByteChannelSequentialBase$writeInt$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            io.ktor.utils.io.ByteChannelSequentialBase$writeInt$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$writeInt$1
            r0.<init>(r5, r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 4
            r4 = 1
            if (r2 == 0) goto L_0x0039
            if (r2 != r4) goto L_0x0031
            int r6 = r0.I$0
            java.lang.Object r5 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r5 = (io.ktor.utils.io.ByteChannelSequentialBase) r5
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0049
        L_0x0031:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0039:
            kotlin.ResultKt.throwOnFailure(r7)
            r0.L$0 = r5
            r0.I$0 = r6
            r0.label = r4
            java.lang.Object r7 = r5.awaitAtLeastNBytesAvailableForWrite$ktor_io(r3, r0)
            if (r7 != r1) goto L_0x0049
            return r1
        L_0x0049:
            io.ktor.utils.io.core.BytePacketBuilder r7 = r5.writable
            io.ktor.utils.io.core.Output r7 = (io.ktor.utils.io.core.Output) r7
            io.ktor.utils.io.core.OutputPrimitivesKt.writeInt(r7, r6)
            r5.afterWrite(r3)
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.writeInt$suspendImpl(io.ktor.utils.io.ByteChannelSequentialBase, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ java.lang.Object writeLong$suspendImpl(io.ktor.utils.io.ByteChannelSequentialBase r5, long r6, kotlin.coroutines.Continuation r8) {
        /*
            boolean r0 = r8 instanceof io.ktor.utils.io.ByteChannelSequentialBase$writeLong$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            io.ktor.utils.io.ByteChannelSequentialBase$writeLong$1 r0 = (io.ktor.utils.io.ByteChannelSequentialBase$writeLong$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            io.ktor.utils.io.ByteChannelSequentialBase$writeLong$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$writeLong$1
            r0.<init>(r5, r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 8
            r4 = 1
            if (r2 == 0) goto L_0x003a
            if (r2 != r4) goto L_0x0032
            long r6 = r0.J$0
            java.lang.Object r5 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r5 = (io.ktor.utils.io.ByteChannelSequentialBase) r5
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x004a
        L_0x0032:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x003a:
            kotlin.ResultKt.throwOnFailure(r8)
            r0.L$0 = r5
            r0.J$0 = r6
            r0.label = r4
            java.lang.Object r8 = r5.awaitAtLeastNBytesAvailableForWrite$ktor_io(r3, r0)
            if (r8 != r1) goto L_0x004a
            return r1
        L_0x004a:
            io.ktor.utils.io.core.BytePacketBuilder r8 = r5.writable
            io.ktor.utils.io.core.Output r8 = (io.ktor.utils.io.core.Output) r8
            io.ktor.utils.io.core.OutputPrimitivesKt.writeLong(r8, r6)
            r5.afterWrite(r3)
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.writeLong$suspendImpl(io.ktor.utils.io.ByteChannelSequentialBase, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ java.lang.Object writeFloat$suspendImpl(io.ktor.utils.io.ByteChannelSequentialBase r5, float r6, kotlin.coroutines.Continuation r7) {
        /*
            boolean r0 = r7 instanceof io.ktor.utils.io.ByteChannelSequentialBase$writeFloat$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            io.ktor.utils.io.ByteChannelSequentialBase$writeFloat$1 r0 = (io.ktor.utils.io.ByteChannelSequentialBase$writeFloat$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            io.ktor.utils.io.ByteChannelSequentialBase$writeFloat$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$writeFloat$1
            r0.<init>(r5, r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 4
            r4 = 1
            if (r2 == 0) goto L_0x0039
            if (r2 != r4) goto L_0x0031
            float r6 = r0.F$0
            java.lang.Object r5 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r5 = (io.ktor.utils.io.ByteChannelSequentialBase) r5
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0049
        L_0x0031:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0039:
            kotlin.ResultKt.throwOnFailure(r7)
            r0.L$0 = r5
            r0.F$0 = r6
            r0.label = r4
            java.lang.Object r7 = r5.awaitAtLeastNBytesAvailableForWrite$ktor_io(r3, r0)
            if (r7 != r1) goto L_0x0049
            return r1
        L_0x0049:
            io.ktor.utils.io.core.BytePacketBuilder r7 = r5.writable
            io.ktor.utils.io.core.Output r7 = (io.ktor.utils.io.core.Output) r7
            io.ktor.utils.io.core.OutputPrimitivesKt.writeFloat(r7, r6)
            r5.afterWrite(r3)
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.writeFloat$suspendImpl(io.ktor.utils.io.ByteChannelSequentialBase, float, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ java.lang.Object writeDouble$suspendImpl(io.ktor.utils.io.ByteChannelSequentialBase r5, double r6, kotlin.coroutines.Continuation r8) {
        /*
            boolean r0 = r8 instanceof io.ktor.utils.io.ByteChannelSequentialBase$writeDouble$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            io.ktor.utils.io.ByteChannelSequentialBase$writeDouble$1 r0 = (io.ktor.utils.io.ByteChannelSequentialBase$writeDouble$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            io.ktor.utils.io.ByteChannelSequentialBase$writeDouble$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$writeDouble$1
            r0.<init>(r5, r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 8
            r4 = 1
            if (r2 == 0) goto L_0x003a
            if (r2 != r4) goto L_0x0032
            double r6 = r0.D$0
            java.lang.Object r5 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r5 = (io.ktor.utils.io.ByteChannelSequentialBase) r5
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x004a
        L_0x0032:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x003a:
            kotlin.ResultKt.throwOnFailure(r8)
            r0.L$0 = r5
            r0.D$0 = r6
            r0.label = r4
            java.lang.Object r8 = r5.awaitAtLeastNBytesAvailableForWrite$ktor_io(r3, r0)
            if (r8 != r1) goto L_0x004a
            return r1
        L_0x004a:
            io.ktor.utils.io.core.BytePacketBuilder r8 = r5.writable
            io.ktor.utils.io.core.Output r8 = (io.ktor.utils.io.core.Output) r8
            io.ktor.utils.io.core.OutputPrimitivesKt.writeDouble(r8, r6)
            r5.afterWrite(r3)
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.writeDouble$suspendImpl(io.ktor.utils.io.ByteChannelSequentialBase, double, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: io.ktor.utils.io.core.ByteReadPacket} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ java.lang.Object writePacket$suspendImpl(io.ktor.utils.io.ByteChannelSequentialBase r4, io.ktor.utils.io.core.ByteReadPacket r5, kotlin.coroutines.Continuation r6) {
        /*
            boolean r0 = r6 instanceof io.ktor.utils.io.ByteChannelSequentialBase$writePacket$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            io.ktor.utils.io.ByteChannelSequentialBase$writePacket$1 r0 = (io.ktor.utils.io.ByteChannelSequentialBase$writePacket$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            io.ktor.utils.io.ByteChannelSequentialBase$writePacket$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$writePacket$1
            r0.<init>(r4, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003b
            if (r2 != r3) goto L_0x0033
            java.lang.Object r4 = r0.L$1
            r5 = r4
            io.ktor.utils.io.core.ByteReadPacket r5 = (io.ktor.utils.io.core.ByteReadPacket) r5
            java.lang.Object r4 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r4 = (io.ktor.utils.io.ByteChannelSequentialBase) r4
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x004b
        L_0x0033:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x003b:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.L$0 = r4
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r6 = r4.awaitAtLeastNBytesAvailableForWrite$ktor_io(r3, r0)
            if (r6 != r1) goto L_0x004b
            return r1
        L_0x004b:
            long r0 = r5.getRemaining()
            int r6 = (int) r0
            io.ktor.utils.io.core.BytePacketBuilder r0 = r4.writable
            r0.writePacket(r5)
            r4.afterWrite(r6)
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.writePacket$suspendImpl(io.ktor.utils.io.ByteChannelSequentialBase, io.ktor.utils.io.core.ByteReadPacket, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: io.ktor.utils.io.core.Buffer} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ java.lang.Object writeFully$suspendImpl(io.ktor.utils.io.ByteChannelSequentialBase r4, io.ktor.utils.io.core.Buffer r5, kotlin.coroutines.Continuation r6) {
        /*
            boolean r0 = r6 instanceof io.ktor.utils.io.ByteChannelSequentialBase$writeFully$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            io.ktor.utils.io.ByteChannelSequentialBase$writeFully$1 r0 = (io.ktor.utils.io.ByteChannelSequentialBase$writeFully$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            io.ktor.utils.io.ByteChannelSequentialBase$writeFully$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$writeFully$1
            r0.<init>(r4, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003b
            if (r2 != r3) goto L_0x0033
            java.lang.Object r4 = r0.L$1
            r5 = r4
            io.ktor.utils.io.core.Buffer r5 = (io.ktor.utils.io.core.Buffer) r5
            java.lang.Object r4 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r4 = (io.ktor.utils.io.ByteChannelSequentialBase) r4
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x004b
        L_0x0033:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x003b:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.L$0 = r4
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r6 = r4.awaitAtLeastNBytesAvailableForWrite$ktor_io(r3, r0)
            if (r6 != r1) goto L_0x004b
            return r1
        L_0x004b:
            int r6 = r5.getWritePosition()
            int r0 = r5.getReadPosition()
            int r6 = r6 - r0
            io.ktor.utils.io.core.BytePacketBuilder r0 = r4.writable
            io.ktor.utils.io.core.Output r0 = (io.ktor.utils.io.core.Output) r0
            r1 = 0
            r2 = 2
            r3 = 0
            io.ktor.utils.io.core.OutputKt.writeFully$default(r0, r5, r1, r2, r3)
            r4.afterWrite(r6)
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.writeFully$suspendImpl(io.ktor.utils.io.ByteChannelSequentialBase, io.ktor.utils.io.core.Buffer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ java.lang.Object writeFully$suspendImpl(io.ktor.utils.io.ByteChannelSequentialBase r5, byte[] r6, int r7, int r8, kotlin.coroutines.Continuation r9) {
        /*
            boolean r0 = r9 instanceof io.ktor.utils.io.ByteChannelSequentialBase$writeFully$2
            if (r0 == 0) goto L_0x0014
            r0 = r9
            io.ktor.utils.io.ByteChannelSequentialBase$writeFully$2 r0 = (io.ktor.utils.io.ByteChannelSequentialBase$writeFully$2) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            io.ktor.utils.io.ByteChannelSequentialBase$writeFully$2 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$writeFully$2
            r0.<init>(r5, r9)
        L_0x0019:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0041
            if (r2 != r3) goto L_0x0039
            int r5 = r0.I$1
            int r6 = r0.I$0
            java.lang.Object r7 = r0.L$1
            byte[] r7 = (byte[]) r7
            java.lang.Object r8 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r8 = (io.ktor.utils.io.ByteChannelSequentialBase) r8
            kotlin.ResultKt.throwOnFailure(r9)
            r4 = r8
            r8 = r6
            r6 = r4
            goto L_0x005d
        L_0x0039:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0041:
            kotlin.ResultKt.throwOnFailure(r9)
            int r8 = r8 + r7
            r4 = r6
            r6 = r5
            r5 = r8
            r8 = r7
            r7 = r4
        L_0x004a:
            if (r8 >= r5) goto L_0x0073
            r0.L$0 = r6
            r0.L$1 = r7
            r0.I$0 = r8
            r0.I$1 = r5
            r0.label = r3
            java.lang.Object r9 = r6.awaitAtLeastNBytesAvailableForWrite$ktor_io(r3, r0)
            if (r9 != r1) goto L_0x005d
            return r1
        L_0x005d:
            int r9 = r6.getAvailableForWrite()
            int r2 = r5 - r8
            int r9 = java.lang.Math.min(r9, r2)
            io.ktor.utils.io.core.BytePacketBuilder r2 = r6.writable
            io.ktor.utils.io.core.Output r2 = (io.ktor.utils.io.core.Output) r2
            io.ktor.utils.io.core.OutputKt.writeFully((io.ktor.utils.io.core.Output) r2, (byte[]) r7, (int) r8, (int) r9)
            int r8 = r8 + r9
            r6.afterWrite(r9)
            goto L_0x004a
        L_0x0073:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.writeFully$suspendImpl(io.ktor.utils.io.ByteChannelSequentialBase, byte[], int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* renamed from: writeFully-JT6ljtQ$suspendImpl  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ java.lang.Object m24writeFullyJT6ljtQ$suspendImpl(io.ktor.utils.io.ByteChannelSequentialBase r5, java.nio.ByteBuffer r6, int r7, int r8, kotlin.coroutines.Continuation r9) {
        /*
            boolean r0 = r9 instanceof io.ktor.utils.io.ByteChannelSequentialBase$writeFully$3
            if (r0 == 0) goto L_0x0014
            r0 = r9
            io.ktor.utils.io.ByteChannelSequentialBase$writeFully$3 r0 = (io.ktor.utils.io.ByteChannelSequentialBase$writeFully$3) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            io.ktor.utils.io.ByteChannelSequentialBase$writeFully$3 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$writeFully$3
            r0.<init>(r5, r9)
        L_0x0019:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0043
            if (r2 != r3) goto L_0x003b
            int r5 = r0.I$1
            int r6 = r0.I$0
            java.lang.Object r7 = r0.L$1
            java.nio.ByteBuffer r7 = (java.nio.ByteBuffer) r7
            java.lang.Object r8 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r8 = (io.ktor.utils.io.ByteChannelSequentialBase) r8
            kotlin.ResultKt.throwOnFailure(r9)
            r4 = r7
            r7 = r5
            r5 = r8
            r8 = r6
            r6 = r4
            goto L_0x0059
        L_0x003b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0043:
            kotlin.ResultKt.throwOnFailure(r9)
        L_0x0046:
            if (r7 >= r8) goto L_0x006f
            r0.L$0 = r5
            r0.L$1 = r6
            r0.I$0 = r8
            r0.I$1 = r7
            r0.label = r3
            java.lang.Object r9 = r5.awaitAtLeastNBytesAvailableForWrite$ktor_io(r3, r0)
            if (r9 != r1) goto L_0x0059
            return r1
        L_0x0059:
            int r9 = r5.getAvailableForWrite()
            int r2 = r8 - r7
            int r9 = java.lang.Math.min(r9, r2)
            io.ktor.utils.io.core.BytePacketBuilder r2 = r5.writable
            io.ktor.utils.io.core.Output r2 = (io.ktor.utils.io.core.Output) r2
            io.ktor.utils.io.core.OutputKt.m258writeFullyUAd2zVI((io.ktor.utils.io.core.Output) r2, (java.nio.ByteBuffer) r6, (int) r7, (int) r9)
            int r7 = r7 + r9
            r5.afterWrite(r9)
            goto L_0x0046
        L_0x006f:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.m24writeFullyJT6ljtQ$suspendImpl(io.ktor.utils.io.ByteChannelSequentialBase, java.nio.ByteBuffer, int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object writeAvailable$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, ChunkBuffer chunkBuffer, Continuation continuation) {
        Buffer buffer = chunkBuffer;
        int writePosition = buffer.getWritePosition() - buffer.getReadPosition();
        if (writePosition == 0) {
            return Boxing.boxInt(0);
        }
        int min = Math.min(writePosition, byteChannelSequentialBase.getAvailableForWrite());
        if (min == 0) {
            return byteChannelSequentialBase.writeAvailableSuspend(chunkBuffer, continuation);
        }
        OutputKt.writeFully(byteChannelSequentialBase.writable, buffer, min);
        byteChannelSequentialBase.afterWrite(min);
        return Boxing.boxInt(min);
    }

    static /* synthetic */ Object writeAvailable$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, byte[] bArr, int i, int i2, Continuation continuation) {
        if (i2 == 0) {
            return Boxing.boxInt(0);
        }
        int min = Math.min(i2, byteChannelSequentialBase.getAvailableForWrite());
        if (min == 0) {
            return byteChannelSequentialBase.writeAvailableSuspend(bArr, i, i2, continuation);
        }
        OutputKt.writeFully((Output) byteChannelSequentialBase.writable, bArr, i, min);
        byteChannelSequentialBase.afterWrite(min);
        return Boxing.boxInt(min);
    }

    @Deprecated(message = "Use write { } instead.")
    static /* synthetic */ Object writeSuspendSession$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, Function2 function2, Continuation continuation) {
        Object invoke = function2.invoke(byteChannelSequentialBase.beginWriteSession(), continuation);
        return invoke == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? invoke : Unit.INSTANCE;
    }

    public WriterSuspendSession beginWriteSession() {
        return new ByteChannelSequentialBase$beginWriteSession$1(this);
    }

    public void endWriteSession(int i) {
        this.writable.afterHeadWrite();
        afterWrite(i);
    }

    static /* synthetic */ Object readByte$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, Continuation continuation) {
        if (!(!byteChannelSequentialBase.readable.getEndOfInput())) {
            return byteChannelSequentialBase.readByteSlow(continuation);
        }
        byte readByte = byteChannelSequentialBase.readable.readByte();
        byteChannelSequentialBase.afterRead(1);
        return Boxing.boxByte(readByte);
    }

    static /* synthetic */ void checkClosed$default(ByteChannelSequentialBase byteChannelSequentialBase, int i, BytePacketBuilder bytePacketBuilder, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                bytePacketBuilder = null;
            }
            byteChannelSequentialBase.checkClosed(i, bytePacketBuilder);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: checkClosed");
    }

    private final void checkClosed(int i, BytePacketBuilder bytePacketBuilder) {
        Throwable closedCause = getClosedCause();
        if (closedCause != null) {
            if (bytePacketBuilder != null) {
                bytePacketBuilder.close();
            }
            throw closedCause;
        } else if (getClosed() && getAvailableForRead() < i) {
            if (bytePacketBuilder != null) {
                bytePacketBuilder.close();
            }
            throw new EOFException(i + " bytes required but EOF reached");
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0044 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object readByteSlow(kotlin.coroutines.Continuation<? super java.lang.Byte> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof io.ktor.utils.io.ByteChannelSequentialBase$readByteSlow$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            io.ktor.utils.io.ByteChannelSequentialBase$readByteSlow$1 r0 = (io.ktor.utils.io.ByteChannelSequentialBase$readByteSlow$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            io.ktor.utils.io.ByteChannelSequentialBase$readByteSlow$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$readByteSlow$1
            r0.<init>(r5, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r2 = (io.ktor.utils.io.ByteChannelSequentialBase) r2
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0045
        L_0x002e:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r6)
            r2 = r5
        L_0x003a:
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r6 = r2.awaitSuspend(r3, r0)
            if (r6 != r1) goto L_0x0045
            return r1
        L_0x0045:
            io.ktor.utils.io.core.ByteReadPacket r6 = r2.readable
            boolean r6 = r6.getEndOfInput()
            r6 = r6 ^ r3
            if (r6 == 0) goto L_0x0062
            io.ktor.utils.io.core.ByteReadPacket r6 = r2.readable
            byte r6 = r6.readByte()
            java.lang.Byte r6 = kotlin.coroutines.jvm.internal.Boxing.boxByte(r6)
            r0 = r6
            java.lang.Number r0 = (java.lang.Number) r0
            r0.byteValue()
            r2.afterRead(r3)
            return r6
        L_0x0062:
            r6 = 2
            r4 = 0
            checkClosed$default(r2, r3, r4, r6, r4)
            goto L_0x003a
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.readByteSlow(kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object readShort$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, Continuation continuation) {
        if (!byteChannelSequentialBase.readable.hasBytes(2)) {
            return byteChannelSequentialBase.readShortSlow(continuation);
        }
        short readShort = InputPrimitivesKt.readShort(byteChannelSequentialBase.readable);
        byteChannelSequentialBase.afterRead(2);
        return Boxing.boxShort(readShort);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object readShortSlow(kotlin.coroutines.Continuation<? super java.lang.Short> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof io.ktor.utils.io.ByteChannelSequentialBase$readShortSlow$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            io.ktor.utils.io.ByteChannelSequentialBase$readShortSlow$1 r0 = (io.ktor.utils.io.ByteChannelSequentialBase$readShortSlow$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            io.ktor.utils.io.ByteChannelSequentialBase$readShortSlow$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$readShortSlow$1
            r0.<init>(r5, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r4) goto L_0x002f
            java.lang.Object r0 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r0 = (io.ktor.utils.io.ByteChannelSequentialBase) r0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0046
        L_0x002f:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.L$0 = r5
            r0.label = r4
            java.lang.Object r6 = r5.awaitSuspend(r3, r0)
            if (r6 != r1) goto L_0x0045
            return r1
        L_0x0045:
            r0 = r5
        L_0x0046:
            io.ktor.utils.io.core.ByteReadPacket r6 = r0.readable
            io.ktor.utils.io.core.Input r6 = (io.ktor.utils.io.core.Input) r6
            short r6 = io.ktor.utils.io.core.InputPrimitivesKt.readShort(r6)
            r0.afterRead(r3)
            short r6 = (short) r6
            java.lang.Short r6 = kotlin.coroutines.jvm.internal.Boxing.boxShort(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.readShortSlow(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: protected */
    public final void afterRead(int i) {
        addBytesRead(i);
        this.slot.resume();
    }

    static /* synthetic */ Object readInt$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, Continuation continuation) {
        if (!byteChannelSequentialBase.readable.hasBytes(4)) {
            return byteChannelSequentialBase.readIntSlow(continuation);
        }
        int readInt = InputPrimitivesKt.readInt(byteChannelSequentialBase.readable);
        byteChannelSequentialBase.afterRead(4);
        return Boxing.boxInt(readInt);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object readIntSlow(kotlin.coroutines.Continuation<? super java.lang.Integer> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof io.ktor.utils.io.ByteChannelSequentialBase$readIntSlow$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            io.ktor.utils.io.ByteChannelSequentialBase$readIntSlow$1 r0 = (io.ktor.utils.io.ByteChannelSequentialBase$readIntSlow$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            io.ktor.utils.io.ByteChannelSequentialBase$readIntSlow$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$readIntSlow$1
            r0.<init>(r5, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 4
            r4 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r4) goto L_0x002f
            java.lang.Object r0 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r0 = (io.ktor.utils.io.ByteChannelSequentialBase) r0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0046
        L_0x002f:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.L$0 = r5
            r0.label = r4
            java.lang.Object r6 = r5.awaitSuspend(r3, r0)
            if (r6 != r1) goto L_0x0045
            return r1
        L_0x0045:
            r0 = r5
        L_0x0046:
            io.ktor.utils.io.core.ByteReadPacket r6 = r0.readable
            io.ktor.utils.io.core.Input r6 = (io.ktor.utils.io.core.Input) r6
            int r6 = io.ktor.utils.io.core.InputPrimitivesKt.readInt(r6)
            r0.afterRead(r3)
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.readIntSlow(kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object readLong$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, Continuation continuation) {
        if (!byteChannelSequentialBase.readable.hasBytes(8)) {
            return byteChannelSequentialBase.readLongSlow(continuation);
        }
        long readLong = InputPrimitivesKt.readLong(byteChannelSequentialBase.readable);
        byteChannelSequentialBase.afterRead(8);
        return Boxing.boxLong(readLong);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object readLongSlow(kotlin.coroutines.Continuation<? super java.lang.Long> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof io.ktor.utils.io.ByteChannelSequentialBase$readLongSlow$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            io.ktor.utils.io.ByteChannelSequentialBase$readLongSlow$1 r0 = (io.ktor.utils.io.ByteChannelSequentialBase$readLongSlow$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            io.ktor.utils.io.ByteChannelSequentialBase$readLongSlow$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$readLongSlow$1
            r0.<init>(r5, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 8
            r4 = 1
            if (r2 == 0) goto L_0x0038
            if (r2 != r4) goto L_0x0030
            java.lang.Object r0 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r0 = (io.ktor.utils.io.ByteChannelSequentialBase) r0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0047
        L_0x0030:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x0038:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.L$0 = r5
            r0.label = r4
            java.lang.Object r6 = r5.awaitSuspend(r3, r0)
            if (r6 != r1) goto L_0x0046
            return r1
        L_0x0046:
            r0 = r5
        L_0x0047:
            io.ktor.utils.io.core.ByteReadPacket r6 = r0.readable
            io.ktor.utils.io.core.Input r6 = (io.ktor.utils.io.core.Input) r6
            long r1 = io.ktor.utils.io.core.InputPrimitivesKt.readLong(r6)
            r0.afterRead(r3)
            java.lang.Long r6 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r1)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.readLongSlow(kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object readFloat$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, Continuation continuation) {
        if (!byteChannelSequentialBase.readable.hasBytes(4)) {
            return byteChannelSequentialBase.readFloatSlow(continuation);
        }
        float readFloat = InputPrimitivesKt.readFloat(byteChannelSequentialBase.readable);
        byteChannelSequentialBase.afterRead(4);
        return Boxing.boxFloat(readFloat);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object readFloatSlow(kotlin.coroutines.Continuation<? super java.lang.Float> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof io.ktor.utils.io.ByteChannelSequentialBase$readFloatSlow$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            io.ktor.utils.io.ByteChannelSequentialBase$readFloatSlow$1 r0 = (io.ktor.utils.io.ByteChannelSequentialBase$readFloatSlow$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            io.ktor.utils.io.ByteChannelSequentialBase$readFloatSlow$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$readFloatSlow$1
            r0.<init>(r5, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 4
            r4 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r4) goto L_0x002f
            java.lang.Object r0 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r0 = (io.ktor.utils.io.ByteChannelSequentialBase) r0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0046
        L_0x002f:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.L$0 = r5
            r0.label = r4
            java.lang.Object r6 = r5.awaitSuspend(r3, r0)
            if (r6 != r1) goto L_0x0045
            return r1
        L_0x0045:
            r0 = r5
        L_0x0046:
            io.ktor.utils.io.core.ByteReadPacket r6 = r0.readable
            io.ktor.utils.io.core.Input r6 = (io.ktor.utils.io.core.Input) r6
            float r6 = io.ktor.utils.io.core.InputPrimitivesKt.readFloat(r6)
            r0.afterRead(r3)
            java.lang.Float r6 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.readFloatSlow(kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object readDouble$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, Continuation continuation) {
        if (!byteChannelSequentialBase.readable.hasBytes(8)) {
            return byteChannelSequentialBase.readDoubleSlow(continuation);
        }
        double readDouble = InputPrimitivesKt.readDouble(byteChannelSequentialBase.readable);
        byteChannelSequentialBase.afterRead(8);
        return Boxing.boxDouble(readDouble);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object readDoubleSlow(kotlin.coroutines.Continuation<? super java.lang.Double> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof io.ktor.utils.io.ByteChannelSequentialBase$readDoubleSlow$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            io.ktor.utils.io.ByteChannelSequentialBase$readDoubleSlow$1 r0 = (io.ktor.utils.io.ByteChannelSequentialBase$readDoubleSlow$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            io.ktor.utils.io.ByteChannelSequentialBase$readDoubleSlow$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$readDoubleSlow$1
            r0.<init>(r5, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 8
            r4 = 1
            if (r2 == 0) goto L_0x0038
            if (r2 != r4) goto L_0x0030
            java.lang.Object r0 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r0 = (io.ktor.utils.io.ByteChannelSequentialBase) r0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0047
        L_0x0030:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x0038:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.L$0 = r5
            r0.label = r4
            java.lang.Object r6 = r5.awaitSuspend(r3, r0)
            if (r6 != r1) goto L_0x0046
            return r1
        L_0x0046:
            r0 = r5
        L_0x0047:
            io.ktor.utils.io.core.ByteReadPacket r6 = r0.readable
            io.ktor.utils.io.core.Input r6 = (io.ktor.utils.io.core.Input) r6
            double r1 = io.ktor.utils.io.core.InputPrimitivesKt.readDouble(r6)
            r0.afterRead(r3)
            java.lang.Double r6 = kotlin.coroutines.jvm.internal.Boxing.boxDouble(r1)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.readDoubleSlow(kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object readRemaining$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, long j, Continuation continuation) {
        byteChannelSequentialBase.ensureNotFailed();
        BytePacketBuilder bytePacketBuilder = new BytePacketBuilder((ObjectPool) null, 1, (DefaultConstructorMarker) null);
        long min = Math.min(j, byteChannelSequentialBase.readable.getRemaining());
        bytePacketBuilder.writePacket(byteChannelSequentialBase.readable, min);
        byteChannelSequentialBase.afterRead((int) min);
        if (j - ((long) bytePacketBuilder.getSize()) != 0 && !byteChannelSequentialBase.isClosedForRead()) {
            return byteChannelSequentialBase.readRemainingSuspend(bytePacketBuilder, j, continuation);
        }
        byteChannelSequentialBase.ensureNotFailed(bytePacketBuilder);
        return bytePacketBuilder.build();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object readRemainingSuspend(io.ktor.utils.io.core.BytePacketBuilder r11, long r12, kotlin.coroutines.Continuation<? super io.ktor.utils.io.core.ByteReadPacket> r14) {
        /*
            r10 = this;
            boolean r0 = r14 instanceof io.ktor.utils.io.ByteChannelSequentialBase$readRemainingSuspend$1
            if (r0 == 0) goto L_0x0014
            r0 = r14
            io.ktor.utils.io.ByteChannelSequentialBase$readRemainingSuspend$1 r0 = (io.ktor.utils.io.ByteChannelSequentialBase$readRemainingSuspend$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r14 = r0.label
            int r14 = r14 - r2
            r0.label = r14
            goto L_0x0019
        L_0x0014:
            io.ktor.utils.io.ByteChannelSequentialBase$readRemainingSuspend$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$readRemainingSuspend$1
            r0.<init>(r10, r14)
        L_0x0019:
            java.lang.Object r14 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003f
            if (r2 != r3) goto L_0x0037
            long r11 = r0.J$0
            java.lang.Object r13 = r0.L$1
            io.ktor.utils.io.core.BytePacketBuilder r13 = (io.ktor.utils.io.core.BytePacketBuilder) r13
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r2 = (io.ktor.utils.io.ByteChannelSequentialBase) r2
            kotlin.ResultKt.throwOnFailure(r14)
            r8 = r11
            r11 = r13
            r12 = r8
            goto L_0x0043
        L_0x0037:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x003f:
            kotlin.ResultKt.throwOnFailure(r14)
            r2 = r10
        L_0x0043:
            int r14 = r11.getSize()
            long r4 = (long) r14
            int r14 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1))
            if (r14 >= 0) goto L_0x0086
            int r14 = r11.getSize()
            long r4 = (long) r14
            long r4 = r12 - r4
            io.ktor.utils.io.core.ByteReadPacket r14 = r2.readable
            long r6 = r14.getRemaining()
            long r4 = java.lang.Math.min(r4, r6)
            io.ktor.utils.io.core.ByteReadPacket r14 = r2.readable
            r11.writePacket((io.ktor.utils.io.core.ByteReadPacket) r14, (long) r4)
            int r14 = (int) r4
            r2.afterRead(r14)
            r2.ensureNotFailed(r11)
            boolean r14 = r2.isClosedForRead()
            if (r14 != 0) goto L_0x0086
            int r14 = r11.getSize()
            int r4 = (int) r12
            if (r14 != r4) goto L_0x0077
            goto L_0x0086
        L_0x0077:
            r0.L$0 = r2
            r0.L$1 = r11
            r0.J$0 = r12
            r0.label = r3
            java.lang.Object r14 = r2.awaitSuspend(r3, r0)
            if (r14 != r1) goto L_0x0043
            return r1
        L_0x0086:
            r2.ensureNotFailed(r11)
            io.ktor.utils.io.core.ByteReadPacket r11 = r11.build()
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.readRemainingSuspend(io.ktor.utils.io.core.BytePacketBuilder, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object readPacket$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, int i, Continuation continuation) {
        checkClosed$default(byteChannelSequentialBase, i, (BytePacketBuilder) null, 2, (Object) null);
        BytePacketBuilder bytePacketBuilder = new BytePacketBuilder((ObjectPool) null, 1, (DefaultConstructorMarker) null);
        int min = (int) Math.min((long) i, byteChannelSequentialBase.readable.getRemaining());
        int i2 = i - min;
        bytePacketBuilder.writePacket(byteChannelSequentialBase.readable, min);
        byteChannelSequentialBase.afterRead(min);
        byteChannelSequentialBase.checkClosed(i2, bytePacketBuilder);
        if (i2 > 0) {
            return byteChannelSequentialBase.readPacketSuspend(bytePacketBuilder, i2, continuation);
        }
        return bytePacketBuilder.build();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object readPacketSuspend(io.ktor.utils.io.core.BytePacketBuilder r10, int r11, kotlin.coroutines.Continuation<? super io.ktor.utils.io.core.ByteReadPacket> r12) {
        /*
            r9 = this;
            boolean r0 = r12 instanceof io.ktor.utils.io.ByteChannelSequentialBase$readPacketSuspend$1
            if (r0 == 0) goto L_0x0014
            r0 = r12
            io.ktor.utils.io.ByteChannelSequentialBase$readPacketSuspend$1 r0 = (io.ktor.utils.io.ByteChannelSequentialBase$readPacketSuspend$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L_0x0019
        L_0x0014:
            io.ktor.utils.io.ByteChannelSequentialBase$readPacketSuspend$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$readPacketSuspend$1
            r0.<init>(r9, r12)
        L_0x0019:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003f
            if (r2 != r3) goto L_0x0037
            int r10 = r0.I$0
            java.lang.Object r11 = r0.L$1
            io.ktor.utils.io.core.BytePacketBuilder r11 = (io.ktor.utils.io.core.BytePacketBuilder) r11
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r2 = (io.ktor.utils.io.ByteChannelSequentialBase) r2
            kotlin.ResultKt.throwOnFailure(r12)
            r8 = r11
            r11 = r10
            r10 = r8
            goto L_0x0043
        L_0x0037:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x003f:
            kotlin.ResultKt.throwOnFailure(r12)
            r2 = r9
        L_0x0043:
            if (r11 <= 0) goto L_0x006e
            long r4 = (long) r11
            io.ktor.utils.io.core.ByteReadPacket r12 = r2.readable
            long r6 = r12.getRemaining()
            long r4 = java.lang.Math.min(r4, r6)
            int r12 = (int) r4
            int r11 = r11 - r12
            io.ktor.utils.io.core.ByteReadPacket r4 = r2.readable
            r10.writePacket((io.ktor.utils.io.core.ByteReadPacket) r4, (int) r12)
            r2.afterRead(r12)
            r2.checkClosed(r11, r10)
            if (r11 <= 0) goto L_0x0043
            r0.L$0 = r2
            r0.L$1 = r10
            r0.I$0 = r11
            r0.label = r3
            java.lang.Object r12 = r2.awaitSuspend(r3, r0)
            if (r12 != r1) goto L_0x0043
            return r1
        L_0x006e:
            r2.checkClosed(r11, r10)
            io.ktor.utils.io.core.ByteReadPacket r10 = r10.build()
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.readPacketSuspend(io.ktor.utils.io.core.BytePacketBuilder, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: protected */
    public final int readAvailableClosed() {
        Throwable closedCause = getClosedCause();
        if (closedCause != null) {
            throw closedCause;
        } else if (getAvailableForRead() <= 0) {
            return -1;
        } else {
            prepareFlushedBytes();
            return -1;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object readAvailable$ktor_io(io.ktor.utils.io.core.Buffer r6, kotlin.coroutines.Continuation<? super java.lang.Integer> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof io.ktor.utils.io.ByteChannelSequentialBase$readAvailable$2
            if (r0 == 0) goto L_0x0014
            r0 = r7
            io.ktor.utils.io.ByteChannelSequentialBase$readAvailable$2 r0 = (io.ktor.utils.io.ByteChannelSequentialBase$readAvailable$2) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            io.ktor.utils.io.ByteChannelSequentialBase$readAvailable$2 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$readAvailable$2
            r0.<init>(r5, r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003a
            if (r2 != r3) goto L_0x0032
            java.lang.Object r6 = r0.L$1
            io.ktor.utils.io.core.Buffer r6 = (io.ktor.utils.io.core.Buffer) r6
            java.lang.Object r0 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r0 = (io.ktor.utils.io.ByteChannelSequentialBase) r0
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x007a
        L_0x0032:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x003a:
            kotlin.ResultKt.throwOnFailure(r7)
            java.lang.Throwable r7 = r5.getClosedCause()
            if (r7 != 0) goto L_0x00a9
            boolean r7 = r5.getClosed()
            if (r7 == 0) goto L_0x0055
            int r7 = r5.getAvailableForRead()
            if (r7 != 0) goto L_0x0055
            r6 = -1
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r6)
            return r6
        L_0x0055:
            int r7 = r6.getLimit()
            int r2 = r6.getWritePosition()
            int r7 = r7 - r2
            if (r7 != 0) goto L_0x0066
            r6 = 0
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r6)
            return r6
        L_0x0066:
            int r7 = r5.getAvailableForRead()
            if (r7 != 0) goto L_0x0079
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r3
            java.lang.Object r7 = r5.awaitSuspend(r3, r0)
            if (r7 != r1) goto L_0x0079
            return r1
        L_0x0079:
            r0 = r5
        L_0x007a:
            io.ktor.utils.io.core.ByteReadPacket r7 = r0.readable
            boolean r7 = r7.canRead()
            if (r7 != 0) goto L_0x0085
            r0.prepareFlushedBytes()
        L_0x0085:
            int r7 = r6.getLimit()
            int r1 = r6.getWritePosition()
            int r7 = r7 - r1
            long r1 = (long) r7
            io.ktor.utils.io.core.ByteReadPacket r7 = r0.readable
            long r3 = r7.getRemaining()
            long r1 = java.lang.Math.min(r1, r3)
            int r7 = (int) r1
            io.ktor.utils.io.core.ByteReadPacket r1 = r0.readable
            io.ktor.utils.io.core.Input r1 = (io.ktor.utils.io.core.Input) r1
            io.ktor.utils.io.core.InputArraysKt.readFully(r1, r6, r7)
            r0.afterRead(r7)
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r7)
            return r6
        L_0x00a9:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.readAvailable$ktor_io(io.ktor.utils.io.core.Buffer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object readFully$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, ChunkBuffer chunkBuffer, int i, Continuation continuation) {
        Object readFully = byteChannelSequentialBase.readFully((Buffer) chunkBuffer, i, (Continuation<? super Unit>) continuation);
        return readFully == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? readFully : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0063 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object readFullySuspend(io.ktor.utils.io.core.Buffer r6, int r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof io.ktor.utils.io.ByteChannelSequentialBase$readFullySuspend$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            io.ktor.utils.io.ByteChannelSequentialBase$readFullySuspend$1 r0 = (io.ktor.utils.io.ByteChannelSequentialBase$readFullySuspend$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            io.ktor.utils.io.ByteChannelSequentialBase$readFullySuspend$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$readFullySuspend$1
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
            goto L_0x0064
        L_0x002d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0035:
            int r7 = r0.I$0
            java.lang.Object r6 = r0.L$1
            io.ktor.utils.io.core.Buffer r6 = (io.ktor.utils.io.core.Buffer) r6
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r2 = (io.ktor.utils.io.ByteChannelSequentialBase) r2
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0056
        L_0x0043:
            kotlin.ResultKt.throwOnFailure(r8)
            r0.L$0 = r5
            r0.L$1 = r6
            r0.I$0 = r7
            r0.label = r4
            java.lang.Object r8 = r5.awaitSuspend(r7, r0)
            if (r8 != r1) goto L_0x0055
            return r1
        L_0x0055:
            r2 = r5
        L_0x0056:
            r8 = 0
            r0.L$0 = r8
            r0.L$1 = r8
            r0.label = r3
            java.lang.Object r6 = r2.readFully((io.ktor.utils.io.core.Buffer) r6, (int) r7, (kotlin.coroutines.Continuation<? super kotlin.Unit>) r0)
            if (r6 != r1) goto L_0x0064
            return r1
        L_0x0064:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.readFullySuspend(io.ktor.utils.io.core.Buffer, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ java.lang.Object readAvailable$suspendImpl(io.ktor.utils.io.ByteChannelSequentialBase r6, byte[] r7, int r8, int r9, kotlin.coroutines.Continuation r10) {
        /*
            boolean r0 = r10 instanceof io.ktor.utils.io.ByteChannelSequentialBase$readAvailable$4
            if (r0 == 0) goto L_0x0014
            r0 = r10
            io.ktor.utils.io.ByteChannelSequentialBase$readAvailable$4 r0 = (io.ktor.utils.io.ByteChannelSequentialBase$readAvailable$4) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L_0x0019
        L_0x0014:
            io.ktor.utils.io.ByteChannelSequentialBase$readAvailable$4 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$readAvailable$4
            r0.<init>(r6, r10)
        L_0x0019:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0044
            if (r2 != r3) goto L_0x003c
            int r6 = r0.I$1
            int r7 = r0.I$0
            java.lang.Object r8 = r0.L$1
            byte[] r8 = (byte[]) r8
            java.lang.Object r9 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r9 = (io.ktor.utils.io.ByteChannelSequentialBase) r9
            kotlin.ResultKt.throwOnFailure(r10)
            r4 = r9
            r9 = r6
            r6 = r4
            r5 = r8
            r8 = r7
            r7 = r5
            goto L_0x007e
        L_0x003c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0044:
            kotlin.ResultKt.throwOnFailure(r10)
            java.lang.Throwable r10 = r6.getClosedCause()
            if (r10 != 0) goto L_0x00a4
            boolean r10 = r6.getClosed()
            if (r10 == 0) goto L_0x005f
            int r10 = r6.getAvailableForRead()
            if (r10 != 0) goto L_0x005f
            r6 = -1
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r6)
            return r6
        L_0x005f:
            if (r9 != 0) goto L_0x0067
            r6 = 0
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r6)
            return r6
        L_0x0067:
            int r10 = r6.getAvailableForRead()
            if (r10 != 0) goto L_0x007e
            r0.L$0 = r6
            r0.L$1 = r7
            r0.I$0 = r8
            r0.I$1 = r9
            r0.label = r3
            java.lang.Object r10 = r6.awaitSuspend(r3, r0)
            if (r10 != r1) goto L_0x007e
            return r1
        L_0x007e:
            io.ktor.utils.io.core.ByteReadPacket r10 = r6.readable
            boolean r10 = r10.canRead()
            if (r10 != 0) goto L_0x0089
            r6.prepareFlushedBytes()
        L_0x0089:
            long r9 = (long) r9
            io.ktor.utils.io.core.ByteReadPacket r0 = r6.readable
            long r0 = r0.getRemaining()
            long r9 = java.lang.Math.min(r9, r0)
            int r9 = (int) r9
            io.ktor.utils.io.core.ByteReadPacket r10 = r6.readable
            io.ktor.utils.io.core.Input r10 = (io.ktor.utils.io.core.Input) r10
            io.ktor.utils.io.core.InputArraysKt.readFully((io.ktor.utils.io.core.Input) r10, (byte[]) r7, (int) r8, (int) r9)
            r6.afterRead(r9)
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r9)
            return r6
        L_0x00a4:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.readAvailable$suspendImpl(io.ktor.utils.io.ByteChannelSequentialBase, byte[], int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: byte[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ java.lang.Object readFully$suspendImpl(io.ktor.utils.io.ByteChannelSequentialBase r5, byte[] r6, int r7, int r8, kotlin.coroutines.Continuation r9) {
        /*
            boolean r0 = r9 instanceof io.ktor.utils.io.ByteChannelSequentialBase$readFully$6
            if (r0 == 0) goto L_0x0014
            r0 = r9
            io.ktor.utils.io.ByteChannelSequentialBase$readFully$6 r0 = (io.ktor.utils.io.ByteChannelSequentialBase$readFully$6) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            io.ktor.utils.io.ByteChannelSequentialBase$readFully$6 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$readFully$6
            r0.<init>(r5, r9)
        L_0x0019:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0046
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0078
        L_0x002d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0035:
            int r8 = r0.I$1
            int r7 = r0.I$0
            java.lang.Object r5 = r0.L$1
            r6 = r5
            byte[] r6 = (byte[]) r6
            java.lang.Object r5 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r5 = (io.ktor.utils.io.ByteChannelSequentialBase) r5
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x005a
        L_0x0046:
            kotlin.ResultKt.throwOnFailure(r9)
            r0.L$0 = r5
            r0.L$1 = r6
            r0.I$0 = r7
            r0.I$1 = r8
            r0.label = r4
            java.lang.Object r9 = r5.readAvailable(r6, r7, r8, r0)
            if (r9 != r1) goto L_0x005a
            return r1
        L_0x005a:
            java.lang.Number r9 = (java.lang.Number) r9
            int r9 = r9.intValue()
            if (r9 != r8) goto L_0x0065
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L_0x0065:
            r2 = -1
            if (r9 == r2) goto L_0x007b
            int r7 = r7 + r9
            int r8 = r8 - r9
            r9 = 0
            r0.L$0 = r9
            r0.L$1 = r9
            r0.label = r3
            java.lang.Object r5 = r5.readFullySuspend(r6, r7, r8, r0)
            if (r5 != r1) goto L_0x0078
            return r1
        L_0x0078:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L_0x007b:
            java.io.EOFException r5 = new java.io.EOFException
            java.lang.String r6 = "Unexpected end of stream"
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.readFully$suspendImpl(io.ktor.utils.io.ByteChannelSequentialBase, byte[], int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object readFullySuspend(byte[] r8, int r9, int r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            r7 = this;
            boolean r0 = r11 instanceof io.ktor.utils.io.ByteChannelSequentialBase$readFullySuspend$2
            if (r0 == 0) goto L_0x0014
            r0 = r11
            io.ktor.utils.io.ByteChannelSequentialBase$readFullySuspend$2 r0 = (io.ktor.utils.io.ByteChannelSequentialBase$readFullySuspend$2) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L_0x0019
        L_0x0014:
            io.ktor.utils.io.ByteChannelSequentialBase$readFullySuspend$2 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$readFullySuspend$2
            r0.<init>(r7, r11)
        L_0x0019:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0045
            if (r2 != r3) goto L_0x003d
            int r8 = r0.I$2
            int r9 = r0.I$1
            int r10 = r0.I$0
            java.lang.Object r2 = r0.L$1
            byte[] r2 = (byte[]) r2
            java.lang.Object r4 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r4 = (io.ktor.utils.io.ByteChannelSequentialBase) r4
            kotlin.ResultKt.throwOnFailure(r11)
            r6 = r0
            r0 = r9
            r9 = r2
        L_0x003a:
            r2 = r1
            r1 = r6
            goto L_0x006c
        L_0x003d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0045:
            kotlin.ResultKt.throwOnFailure(r11)
            r11 = 0
            r4 = r7
            r6 = r9
            r9 = r8
            r8 = r11
            r11 = r10
            r10 = r6
        L_0x004f:
            if (r8 >= r11) goto L_0x0082
            int r2 = r10 + r8
            int r5 = r11 - r8
            r0.L$0 = r4
            r0.L$1 = r9
            r0.I$0 = r10
            r0.I$1 = r11
            r0.I$2 = r8
            r0.label = r3
            java.lang.Object r2 = r4.readAvailable(r9, r2, r5, r0)
            if (r2 != r1) goto L_0x0068
            return r1
        L_0x0068:
            r6 = r0
            r0 = r11
            r11 = r2
            goto L_0x003a
        L_0x006c:
            java.lang.Number r11 = (java.lang.Number) r11
            int r11 = r11.intValue()
            r5 = -1
            if (r11 == r5) goto L_0x007a
            int r8 = r8 + r11
            r11 = r0
            r0 = r1
            r1 = r2
            goto L_0x004f
        L_0x007a:
            java.io.EOFException r8 = new java.io.EOFException
            java.lang.String r9 = "Unexpected end of stream"
            r8.<init>(r9)
            throw r8
        L_0x0082:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.readFullySuspend(byte[], int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object readBoolean$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, Continuation continuation) {
        if (!byteChannelSequentialBase.readable.canRead()) {
            return byteChannelSequentialBase.readBooleanSlow(continuation);
        }
        boolean z = byteChannelSequentialBase.readable.readByte() == 1;
        byteChannelSequentialBase.afterRead(1);
        return Boxing.boxBoolean(z);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x005a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x005b A[PHI: r6 
      PHI: (r6v2 java.lang.Object) = (r6v4 java.lang.Object), (r6v1 java.lang.Object) binds: [B:19:0x0058, B:10:0x0029] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object readBooleanSlow(kotlin.coroutines.Continuation<? super java.lang.Boolean> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof io.ktor.utils.io.ByteChannelSequentialBase$readBooleanSlow$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            io.ktor.utils.io.ByteChannelSequentialBase$readBooleanSlow$1 r0 = (io.ktor.utils.io.ByteChannelSequentialBase$readBooleanSlow$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            io.ktor.utils.io.ByteChannelSequentialBase$readBooleanSlow$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$readBooleanSlow$1
            r0.<init>(r5, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003d
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x005b
        L_0x002d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x0035:
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r2 = (io.ktor.utils.io.ByteChannelSequentialBase) r2
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x004c
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.L$0 = r5
            r0.label = r4
            java.lang.Object r6 = r5.awaitSuspend(r4, r0)
            if (r6 != r1) goto L_0x004b
            return r1
        L_0x004b:
            r2 = r5
        L_0x004c:
            r6 = 0
            checkClosed$default(r2, r4, r6, r3, r6)
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r6 = r2.readBoolean(r0)
            if (r6 != r1) goto L_0x005b
            return r1
        L_0x005b:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.readBooleanSlow(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void completeReading() {
        Buffer lastReadView = getLastReadView();
        int lastReadAvailable = getLastReadAvailable() - (lastReadView.getWritePosition() - lastReadView.getReadPosition());
        if (getLastReadView() != Buffer.Companion.getEmpty()) {
            UnsafeKt.completeReadHead(this.readable, getLastReadView());
        }
        if (lastReadAvailable > 0) {
            afterRead(lastReadAvailable);
        }
        setLastReadAvailable(0);
        setLastReadView(ChunkBuffer.Companion.getEmpty());
    }

    static /* synthetic */ Object await$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, int i, Continuation continuation) {
        boolean z = false;
        if (i >= 0) {
            long j = (long) i;
            if (j <= 4088) {
                z = true;
            }
            if (z) {
                byteChannelSequentialBase.completeReading();
                if (i == 0) {
                    return Boxing.boxBoolean(!byteChannelSequentialBase.isClosedForRead());
                }
                if (byteChannelSequentialBase.readable.getRemaining() >= j) {
                    return Boxing.boxBoolean(true);
                }
                return byteChannelSequentialBase.awaitSuspend(i, continuation);
            }
            throw new IllegalArgumentException(("atLeast parameter shouldn't be larger than max buffer size of 4088: " + i).toString());
        }
        throw new IllegalArgumentException(("atLeast parameter shouldn't be negative: " + i).toString());
    }

    public final Object awaitInternalAtLeast1$ktor_io(Continuation<? super Boolean> continuation) {
        if (!this.readable.getEndOfInput()) {
            return Boxing.boxBoolean(true);
        }
        return awaitSuspend(1, continuation);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object awaitSuspend(int r6, kotlin.coroutines.Continuation<? super java.lang.Boolean> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof io.ktor.utils.io.ByteChannelSequentialBase$awaitSuspend$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            io.ktor.utils.io.ByteChannelSequentialBase$awaitSuspend$1 r0 = (io.ktor.utils.io.ByteChannelSequentialBase$awaitSuspend$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            io.ktor.utils.io.ByteChannelSequentialBase$awaitSuspend$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$awaitSuspend$1
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
            java.lang.Object r0 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r0 = (io.ktor.utils.io.ByteChannelSequentialBase) r0
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0051
        L_0x0031:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0039:
            kotlin.ResultKt.throwOnFailure(r7)
            if (r6 < 0) goto L_0x0040
            r7 = r4
            goto L_0x0041
        L_0x0040:
            r7 = r3
        L_0x0041:
            if (r7 == 0) goto L_0x006d
            r0.L$0 = r5
            r0.I$0 = r6
            r0.label = r4
            java.lang.Object r7 = r5.awaitAtLeastNBytesAvailableForRead$ktor_io(r6, r0)
            if (r7 != r1) goto L_0x0050
            return r1
        L_0x0050:
            r0 = r5
        L_0x0051:
            r0.prepareFlushedBytes()
            java.lang.Throwable r7 = r0.getClosedCause()
            if (r7 != 0) goto L_0x006c
            boolean r7 = r0.isClosedForRead()
            if (r7 != 0) goto L_0x0067
            int r7 = r0.getAvailableForRead()
            if (r7 < r6) goto L_0x0067
            r3 = r4
        L_0x0067:
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            return r6
        L_0x006c:
            throw r7
        L_0x006d:
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.String r7 = "Failed requirement."
            java.lang.String r7 = r7.toString()
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.awaitSuspend(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public int discard(int i) {
        Throwable closedCause = getClosedCause();
        if (closedCause != null) {
            throw closedCause;
        } else if (i == 0) {
            return 0;
        } else {
            int discard = this.readable.discard(i);
            afterRead(i);
            requestNextView(1);
            return discard;
        }
    }

    public ChunkBuffer request(int i) {
        Throwable closedCause = getClosedCause();
        if (closedCause == null) {
            completeReading();
            return requestNextView(i);
        }
        throw closedCause;
    }

    private final ChunkBuffer requestNextView(int i) {
        if (this.readable.getEndOfInput()) {
            prepareFlushedBytes();
        }
        ChunkBuffer prepareReadHead$ktor_io = this.readable.prepareReadHead$ktor_io(i);
        if (prepareReadHead$ktor_io == null) {
            setLastReadView(ChunkBuffer.Companion.getEmpty());
            setLastReadAvailable(0);
        } else {
            setLastReadView(prepareReadHead$ktor_io);
            Buffer buffer = prepareReadHead$ktor_io;
            setLastReadAvailable(buffer.getWritePosition() - buffer.getReadPosition());
        }
        return prepareReadHead$ktor_io;
    }

    static /* synthetic */ Object discard$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, long j, Continuation continuation) {
        long discard = byteChannelSequentialBase.readable.discard(j);
        byteChannelSequentialBase.afterRead((int) discard);
        if (discard != j && !byteChannelSequentialBase.isClosedForRead()) {
            return byteChannelSequentialBase.discardSuspend(j, discard, continuation);
        }
        byteChannelSequentialBase.ensureNotFailed();
        return Boxing.boxLong(discard);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x006d, code lost:
        if (r2.isClosedForRead() == false) goto L_0x0041;
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004f A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object discardSuspend(long r9, long r11, kotlin.coroutines.Continuation<? super java.lang.Long> r13) {
        /*
            r8 = this;
            boolean r0 = r13 instanceof io.ktor.utils.io.ByteChannelSequentialBase$discardSuspend$1
            if (r0 == 0) goto L_0x0014
            r0 = r13
            io.ktor.utils.io.ByteChannelSequentialBase$discardSuspend$1 r0 = (io.ktor.utils.io.ByteChannelSequentialBase$discardSuspend$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r13 = r0.label
            int r13 = r13 - r2
            r0.label = r13
            goto L_0x0019
        L_0x0014:
            io.ktor.utils.io.ByteChannelSequentialBase$discardSuspend$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$discardSuspend$1
            r0.<init>(r8, r13)
        L_0x0019:
            java.lang.Object r13 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003d
            if (r2 != r3) goto L_0x0035
            long r9 = r0.J$1
            long r11 = r0.J$0
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r2 = (io.ktor.utils.io.ByteChannelSequentialBase) r2
            kotlin.ResultKt.throwOnFailure(r13)
            r6 = r9
            r9 = r11
            r11 = r6
            goto L_0x0050
        L_0x0035:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r13)
            r2 = r8
        L_0x0041:
            r0.L$0 = r2
            r0.J$0 = r9
            r0.J$1 = r11
            r0.label = r3
            java.lang.Object r13 = r2.await(r3, r0)
            if (r13 != r1) goto L_0x0050
            return r1
        L_0x0050:
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r13 = r13.booleanValue()
            if (r13 == 0) goto L_0x006f
            io.ktor.utils.io.core.ByteReadPacket r13 = r2.readable
            long r4 = r9 - r11
            long r4 = r13.discard((long) r4)
            int r13 = (int) r4
            r2.afterRead(r13)
            long r11 = r11 + r4
            int r13 = (r11 > r9 ? 1 : (r11 == r9 ? 0 : -1))
            if (r13 >= 0) goto L_0x006f
            boolean r13 = r2.isClosedForRead()
            if (r13 == 0) goto L_0x0041
        L_0x006f:
            r2.ensureNotFailed()
            java.lang.Long r9 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r11)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.discardSuspend(long, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Deprecated(message = "Use read instead.")
    public void readSession(Function1<? super ReadSession, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "consumer");
        try {
            function1.invoke(this);
        } finally {
            completeReading();
        }
    }

    public SuspendableReadSession startReadSession() {
        return this;
    }

    public void endReadSession() {
        completeReading();
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @kotlin.Deprecated(message = "Use read instead.")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ java.lang.Object readSuspendableSession$suspendImpl(io.ktor.utils.io.ByteChannelSequentialBase r4, kotlin.jvm.functions.Function2 r5, kotlin.coroutines.Continuation r6) {
        /*
            boolean r0 = r6 instanceof io.ktor.utils.io.ByteChannelSequentialBase$readSuspendableSession$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            io.ktor.utils.io.ByteChannelSequentialBase$readSuspendableSession$1 r0 = (io.ktor.utils.io.ByteChannelSequentialBase$readSuspendableSession$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            io.ktor.utils.io.ByteChannelSequentialBase$readSuspendableSession$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$readSuspendableSession$1
            r0.<init>(r4, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r4 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r4 = (io.ktor.utils.io.ByteChannelSequentialBase) r4
            kotlin.ResultKt.throwOnFailure(r6)     // Catch:{ all -> 0x004a }
            goto L_0x0044
        L_0x002e:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.L$0 = r4     // Catch:{ all -> 0x004a }
            r0.label = r3     // Catch:{ all -> 0x004a }
            java.lang.Object r5 = r5.invoke(r4, r0)     // Catch:{ all -> 0x004a }
            if (r5 != r1) goto L_0x0044
            return r1
        L_0x0044:
            r4.completeReading()
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        L_0x004a:
            r5 = move-exception
            r4.completeReading()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.readSuspendableSession$suspendImpl(io.ktor.utils.io.ByteChannelSequentialBase, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object readUTF8LineTo$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, Appendable appendable, int i, Continuation continuation) {
        if (!byteChannelSequentialBase.isClosedForRead()) {
            return UTF8Kt.decodeUTF8LineLoopSuspend(appendable, i, new ByteChannelSequentialBase$readUTF8LineTo$2(byteChannelSequentialBase, (Continuation<? super ByteChannelSequentialBase$readUTF8LineTo$2>) null), new ByteChannelSequentialBase$readUTF8LineTo$3(byteChannelSequentialBase), continuation);
        }
        Throwable closedCause = byteChannelSequentialBase.getClosedCause();
        if (closedCause == null) {
            return Boxing.boxBoolean(false);
        }
        throw closedCause;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0057 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ java.lang.Object readUTF8Line$suspendImpl(io.ktor.utils.io.ByteChannelSequentialBase r5, int r6, kotlin.coroutines.Continuation r7) {
        /*
            boolean r0 = r7 instanceof io.ktor.utils.io.ByteChannelSequentialBase$readUTF8Line$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            io.ktor.utils.io.ByteChannelSequentialBase$readUTF8Line$1 r0 = (io.ktor.utils.io.ByteChannelSequentialBase$readUTF8Line$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            io.ktor.utils.io.ByteChannelSequentialBase$readUTF8Line$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$readUTF8Line$1
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
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.readUTF8Line$suspendImpl(io.ktor.utils.io.ByteChannelSequentialBase, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public boolean cancel(Throwable th) {
        if (getClosedCause() != null || getClosed()) {
            return false;
        }
        if (th == null) {
            th = new CancellationException("Channel cancelled");
        }
        return close(th);
    }

    public boolean close(Throwable th) {
        if (!_closed$FU.compareAndSet(this, (Object) null, th == null ? CloseElementKt.getCLOSED_SUCCESS() : new CloseElement(th))) {
            return false;
        }
        if (th != null) {
            this.readable.release();
            this.writable.release();
            this.flushBuffer.release();
        } else {
            flush();
        }
        this.slot.cancel(th);
        return true;
    }

    public final long transferTo$ktor_io(ByteChannelSequentialBase byteChannelSequentialBase, long j) {
        Intrinsics.checkNotNullParameter(byteChannelSequentialBase, "dst");
        long remaining = this.readable.getRemaining();
        if (remaining > j) {
            return 0;
        }
        byteChannelSequentialBase.writable.writePacket(this.readable);
        int i = (int) remaining;
        byteChannelSequentialBase.afterWrite(i);
        afterRead(i);
        return remaining;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x005f A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0060 A[PHI: r7 
      PHI: (r7v2 java.lang.Object) = (r7v4 java.lang.Object), (r7v1 java.lang.Object) binds: [B:19:0x005d, B:10:0x0029] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object writeAvailableSuspend(io.ktor.utils.io.core.internal.ChunkBuffer r6, kotlin.coroutines.Continuation<? super java.lang.Integer> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof io.ktor.utils.io.ByteChannelSequentialBase$writeAvailableSuspend$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            io.ktor.utils.io.ByteChannelSequentialBase$writeAvailableSuspend$1 r0 = (io.ktor.utils.io.ByteChannelSequentialBase$writeAvailableSuspend$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            io.ktor.utils.io.ByteChannelSequentialBase$writeAvailableSuspend$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$writeAvailableSuspend$1
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
            goto L_0x0060
        L_0x002d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0035:
            java.lang.Object r6 = r0.L$1
            io.ktor.utils.io.core.internal.ChunkBuffer r6 = (io.ktor.utils.io.core.internal.ChunkBuffer) r6
            java.lang.Object r2 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r2 = (io.ktor.utils.io.ByteChannelSequentialBase) r2
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0052
        L_0x0041:
            kotlin.ResultKt.throwOnFailure(r7)
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r4
            java.lang.Object r7 = r5.awaitAtLeastNBytesAvailableForWrite$ktor_io(r4, r0)
            if (r7 != r1) goto L_0x0051
            return r1
        L_0x0051:
            r2 = r5
        L_0x0052:
            r7 = 0
            r0.L$0 = r7
            r0.L$1 = r7
            r0.label = r3
            java.lang.Object r7 = r2.writeAvailable(r6, r0)
            if (r7 != r1) goto L_0x0060
            return r1
        L_0x0060:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.writeAvailableSuspend(io.ktor.utils.io.core.internal.ChunkBuffer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0067 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0068 A[PHI: r9 
      PHI: (r9v2 java.lang.Object) = (r9v4 java.lang.Object), (r9v1 java.lang.Object) binds: [B:19:0x0065, B:10:0x0029] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object writeAvailableSuspend(byte[] r6, int r7, int r8, kotlin.coroutines.Continuation<? super java.lang.Integer> r9) {
        /*
            r5 = this;
            boolean r0 = r9 instanceof io.ktor.utils.io.ByteChannelSequentialBase$writeAvailableSuspend$2
            if (r0 == 0) goto L_0x0014
            r0 = r9
            io.ktor.utils.io.ByteChannelSequentialBase$writeAvailableSuspend$2 r0 = (io.ktor.utils.io.ByteChannelSequentialBase$writeAvailableSuspend$2) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            io.ktor.utils.io.ByteChannelSequentialBase$writeAvailableSuspend$2 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$writeAvailableSuspend$2
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
            goto L_0x0068
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
            io.ktor.utils.io.ByteChannelSequentialBase r2 = (io.ktor.utils.io.ByteChannelSequentialBase) r2
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x005a
        L_0x0045:
            kotlin.ResultKt.throwOnFailure(r9)
            r0.L$0 = r5
            r0.L$1 = r6
            r0.I$0 = r7
            r0.I$1 = r8
            r0.label = r4
            java.lang.Object r9 = r5.awaitAtLeastNBytesAvailableForWrite$ktor_io(r4, r0)
            if (r9 != r1) goto L_0x0059
            return r1
        L_0x0059:
            r2 = r5
        L_0x005a:
            r9 = 0
            r0.L$0 = r9
            r0.L$1 = r9
            r0.label = r3
            java.lang.Object r9 = r2.writeAvailable(r6, r7, r8, r0)
            if (r9 != r1) goto L_0x0068
            return r1
        L_0x0068:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.writeAvailableSuspend(byte[], int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: protected */
    public final void afterWrite(int i) {
        addBytesWritten(i);
        if (getClosed()) {
            this.writable.release();
            ensureNotClosed();
        }
        if (getAutoFlush() || getAvailableForWrite() == 0) {
            flush();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ java.lang.Object awaitFreeSpace$suspendImpl(io.ktor.utils.io.ByteChannelSequentialBase r4, kotlin.coroutines.Continuation r5) {
        /*
            boolean r0 = r5 instanceof io.ktor.utils.io.ByteChannelSequentialBase$awaitFreeSpace$1
            if (r0 == 0) goto L_0x0014
            r0 = r5
            io.ktor.utils.io.ByteChannelSequentialBase$awaitFreeSpace$1 r0 = (io.ktor.utils.io.ByteChannelSequentialBase$awaitFreeSpace$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L_0x0019
        L_0x0014:
            io.ktor.utils.io.ByteChannelSequentialBase$awaitFreeSpace$1 r0 = new io.ktor.utils.io.ByteChannelSequentialBase$awaitFreeSpace$1
            r0.<init>(r4, r5)
        L_0x0019:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r4 = r0.L$0
            io.ktor.utils.io.ByteChannelSequentialBase r4 = (io.ktor.utils.io.ByteChannelSequentialBase) r4
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x0047
        L_0x002e:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r5)
            r4.flush()
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = r4.awaitAtLeastNBytesAvailableForWrite$ktor_io(r3, r0)
            if (r5 != r1) goto L_0x0047
            return r1
        L_0x0047:
            r4.ensureNotClosed()
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.awaitFreeSpace$suspendImpl(io.ktor.utils.io.ByteChannelSequentialBase, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object awaitContent$suspendImpl(ByteChannelSequentialBase byteChannelSequentialBase, Continuation continuation) {
        Object await = byteChannelSequentialBase.await(1, continuation);
        return await == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? await : Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* renamed from: peekTo-lBXzO7A  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object m25peekTolBXzO7A(java.nio.ByteBuffer r19, long r20, long r22, long r24, long r26, kotlin.coroutines.Continuation<? super java.lang.Long> r28) {
        /*
            r18 = this;
            r0 = r18
            r1 = r28
            boolean r2 = r1 instanceof io.ktor.utils.io.ByteChannelSequentialBase$peekTo$1
            if (r2 == 0) goto L_0x0018
            r2 = r1
            io.ktor.utils.io.ByteChannelSequentialBase$peekTo$1 r2 = (io.ktor.utils.io.ByteChannelSequentialBase$peekTo$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001d
        L_0x0018:
            io.ktor.utils.io.ByteChannelSequentialBase$peekTo$1 r2 = new io.ktor.utils.io.ByteChannelSequentialBase$peekTo$1
            r2.<init>(r0, r1)
        L_0x001d:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 1
            if (r4 == 0) goto L_0x003a
            if (r4 != r5) goto L_0x0032
            java.lang.Object r2 = r2.L$0
            kotlin.jvm.internal.Ref$LongRef r2 = (kotlin.jvm.internal.Ref.LongRef) r2
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x0063
        L_0x0032:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x003a:
            kotlin.ResultKt.throwOnFailure(r1)
            kotlin.jvm.internal.Ref$LongRef r1 = new kotlin.jvm.internal.Ref$LongRef
            r1.<init>()
            io.ktor.utils.io.ByteChannelSequentialBase$peekTo$2 r4 = new io.ktor.utils.io.ByteChannelSequentialBase$peekTo$2
            r17 = 0
            r6 = r4
            r7 = r24
            r9 = r22
            r11 = r1
            r12 = r26
            r14 = r19
            r15 = r20
            r6.<init>(r7, r9, r11, r12, r14, r15, r17)
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            r2.L$0 = r1
            r2.label = r5
            java.lang.Object r2 = r0.readSuspendableSession(r4, r2)
            if (r2 != r3) goto L_0x0062
            return r3
        L_0x0062:
            r2 = r1
        L_0x0063:
            long r1 = r2.element
            java.lang.Long r1 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r1)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteChannelSequentialBase.m25peekTolBXzO7A(java.nio.ByteBuffer, long, long, long, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final Object readFully(Buffer buffer, int i, Continuation<? super Unit> continuation) {
        boolean z = true;
        if (i <= buffer.getLimit() - buffer.getWritePosition()) {
            if (i < 0) {
                z = false;
            }
            if (!z) {
                throw new IllegalArgumentException("n shouldn't be negative".toString());
            } else if (getClosedCause() != null) {
                Throwable closedCause = getClosedCause();
                Intrinsics.checkNotNull(closedCause);
                throw closedCause;
            } else if (this.readable.getRemaining() >= ((long) i)) {
                InputArraysKt.readFully(this.readable, buffer, i);
                Unit unit = Unit.INSTANCE;
                afterRead(i);
                if (unit == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    return unit;
                }
                return Unit.INSTANCE;
            } else if (!getClosed()) {
                Object readFullySuspend = readFullySuspend(buffer, i, continuation);
                return readFullySuspend == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? readFullySuspend : Unit.INSTANCE;
            } else {
                throw new EOFException("Channel is closed and not enough bytes available: required " + i + " but " + getAvailableForRead() + " available");
            }
        } else {
            throw new IllegalArgumentException(("Not enough space in the destination buffer to write " + i + " bytes").toString());
        }
    }

    private final void addBytesRead(int i) {
        boolean z = true;
        if (i >= 0) {
            int i2 = -i;
            channelSize$FU.getAndAdd(this, i2);
            _totalBytesRead$FU.addAndGet(this, (long) i);
            _availableForRead$FU.getAndAdd(this, i2);
            if (this.channelSize >= 0) {
                if (getAvailableForRead() < 0) {
                    z = false;
                }
                if (!z) {
                    throw new IllegalStateException(("Readable bytes count is negative: " + getAvailableForRead() + ", " + i + " in " + this).toString());
                }
                return;
            }
            throw new IllegalStateException(("Readable bytes count is negative: " + getAvailableForRead() + ", " + i + " in " + this).toString());
        }
        throw new IllegalArgumentException(("Can't read negative amount of bytes: " + i).toString());
    }

    private final void addBytesWritten(int i) {
        boolean z = true;
        if (i >= 0) {
            channelSize$FU.getAndAdd(this, i);
            _totalBytesWritten$FU.addAndGet(this, (long) i);
            if (this.channelSize < 0) {
                z = false;
            }
            if (!z) {
                throw new IllegalStateException(("Readable bytes count is negative: " + this.channelSize + ", " + i + " in " + this).toString());
            }
            return;
        }
        throw new IllegalArgumentException(("Can't write negative amount of bytes: " + i).toString());
    }
}
