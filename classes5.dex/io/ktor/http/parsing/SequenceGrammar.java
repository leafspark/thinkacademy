package io.ktor.http.parsing;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\u0010\u0005R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lio/ktor/http/parsing/SequenceGrammar;", "Lio/ktor/http/parsing/Grammar;", "Lio/ktor/http/parsing/ComplexGrammar;", "sourceGrammars", "", "(Ljava/util/List;)V", "grammars", "getGrammars", "()Ljava/util/List;", "ktor-http"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ParserDsl.kt */
public final class SequenceGrammar extends Grammar implements ComplexGrammar {
    private final List<Grammar> grammars;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SequenceGrammar(List<? extends Grammar> list) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(list, "sourceGrammars");
        List<Grammar> arrayList = new ArrayList<>();
        for (Grammar grammar : list) {
            if (grammar instanceof SequenceGrammar) {
                CollectionsKt.addAll(arrayList, ((ComplexGrammar) grammar).getGrammars());
            } else {
                arrayList.add(grammar);
            }
        }
        this.grammars = arrayList;
    }

    public List<Grammar> getGrammars() {
        return this.grammars;
    }
}
