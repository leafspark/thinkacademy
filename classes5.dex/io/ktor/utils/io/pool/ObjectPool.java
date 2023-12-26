package io.ktor.utils.io.pool;

import java.io.Closeable;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00060\u0003j\u0002`\u0004J\r\u0010\t\u001a\u00028\u0000H&¢\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\fH&J\u0015\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0010R\u0012\u0010\u0005\u001a\u00020\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"Lio/ktor/utils/io/pool/ObjectPool;", "T", "", "Ljava/io/Closeable;", "Lio/ktor/utils/io/core/Closeable;", "capacity", "", "getCapacity", "()I", "borrow", "()Ljava/lang/Object;", "close", "", "dispose", "recycle", "instance", "(Ljava/lang/Object;)V", "ktor-io"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Pool.kt */
public interface ObjectPool<T> extends Closeable {
    T borrow();

    void close();

    void dispose();

    int getCapacity();

    void recycle(T t);

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Pool.kt */
    public static final class DefaultImpls {
        public static <T> void close(ObjectPool<T> objectPool) {
            objectPool.dispose();
        }
    }
}
