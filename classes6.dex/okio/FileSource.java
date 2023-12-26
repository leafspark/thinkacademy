package okio;

import java.io.FileInputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lokio/FileSource;", "Lokio/InputStreamSource;", "Lokio/Cursor;", "input", "Ljava/io/FileInputStream;", "(Ljava/io/FileInputStream;)V", "cursor", "position", "", "seek", "", "size", "okio"}, k = 1, mv = {1, 4, 1})
/* compiled from: JvmOkio.kt */
final class FileSource extends InputStreamSource implements Cursor {
    private final FileInputStream input;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FileSource(FileInputStream fileInputStream) {
        super(fileInputStream, new Timeout());
        Intrinsics.checkNotNullParameter(fileInputStream, "input");
        this.input = fileInputStream;
    }

    public Cursor cursor() {
        return this;
    }

    public long position() {
        return this.input.getChannel().position();
    }

    public long size() {
        return this.input.getChannel().size();
    }

    public void seek(long j) {
        this.input.getChannel().position(j);
    }
}
