package io.ktor.utils.io;

import io.ktor.utils.io.core.internal.ChunkBuffer;
import kotlin.Deprecated;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0007H&¨\u0006\n"}, d2 = {"Lio/ktor/utils/io/WriterSession;", "", "flush", "", "request", "Lio/ktor/utils/io/core/internal/ChunkBuffer;", "min", "", "written", "n", "ktor-io"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Deprecated(message = "Use writeMemory instead.")
/* compiled from: WriterSession.kt */
public interface WriterSession {
    void flush();

    ChunkBuffer request(int i);

    void written(int i);
}
