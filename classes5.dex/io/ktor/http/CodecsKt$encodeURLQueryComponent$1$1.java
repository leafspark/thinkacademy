package io.ktor.http;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0005\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: Codecs.kt */
final class CodecsKt$encodeURLQueryComponent$1$1 extends Lambda implements Function1<Byte, Unit> {
    final /* synthetic */ boolean $encodeFull;
    final /* synthetic */ boolean $spaceToPlus;
    final /* synthetic */ StringBuilder $this_buildString;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CodecsKt$encodeURLQueryComponent$1$1(boolean z, StringBuilder sb, boolean z2) {
        super(1);
        this.$spaceToPlus = z;
        this.$this_buildString = sb;
        this.$encodeFull = z2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).byteValue());
        return Unit.INSTANCE;
    }

    public final void invoke(byte b) {
        if (b == ((byte) 32)) {
            if (this.$spaceToPlus) {
                this.$this_buildString.append('+');
            } else {
                this.$this_buildString.append("%20");
            }
        } else if (CodecsKt.URL_ALPHABET.contains(Byte.valueOf(b)) || (!this.$encodeFull && CodecsKt.URL_PROTOCOL_PART.contains(Byte.valueOf(b)))) {
            this.$this_buildString.append((char) b);
        } else {
            this.$this_buildString.append(CodecsKt.percentEncode(b));
        }
    }
}
