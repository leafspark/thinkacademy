package io.ktor.utils.io.core;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\u0010\r\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00060\u0001j\u0002`\u0002J\u0014\u0010\u0005\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0016\u0010\u0005\u001a\u00060\u0001j\u0002`\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\bH\u0016J&\u0010\u0005\u001a\u00060\u0001j\u0002`\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"io/ktor/utils/io/core/Input$readAvailableCharacters$out$1", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "idx", "", "append", "value", "", "", "startIndex", "endIndex", "ktor-io"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Input.kt */
public final class Input$readAvailableCharacters$out$1 implements Appendable {
    final /* synthetic */ char[] $destination;
    private int idx;

    Input$readAvailableCharacters$out$1(int i, char[] cArr) {
        this.$destination = cArr;
        this.idx = i;
    }

    public Appendable append(char c) {
        char[] cArr = this.$destination;
        int i = this.idx;
        this.idx = i + 1;
        cArr[i] = c;
        return this;
    }

    public Appendable append(CharSequence charSequence) {
        if (charSequence instanceof String) {
            String str = (String) charSequence;
            StringsJVMKt.getCharsInternal(str, this.$destination, this.idx);
            this.idx += str.length();
        } else if (charSequence != null) {
            int length = charSequence.length();
            for (int i = 0; i < length; i++) {
                char[] cArr = this.$destination;
                int i2 = this.idx;
                this.idx = i2 + 1;
                cArr[i2] = charSequence.charAt(i);
            }
        }
        return this;
    }

    public Appendable append(CharSequence charSequence, int i, int i2) {
        throw new UnsupportedOperationException();
    }
}
