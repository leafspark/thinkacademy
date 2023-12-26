package io.ktor.util;

import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001c\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0010&\n\u0002\u0010 \n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH&J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH&J\u001e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\u000fH&J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH&J\u001e\u0010\u0010\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\u000fH&J\b\u0010\u0011\u001a\u00020\rH&J\b\u0010\u0012\u001a\u00020\u0007H&J\u0011\u0010\u0013\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH¦\u0002J\u0018\u0010\u0013\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH&J \u0010\u0014\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00170\u00160\u0015H&J\u0013\u0010\u0018\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\tH¦\u0002J\u0018\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00172\u0006\u0010\b\u001a\u00020\tH&J\b\u0010\u001a\u001a\u00020\u0003H&J\u000e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\t0\u0015H&J\u0010\u0010\u001c\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0018\u0010\u001c\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH&J\b\u0010\u001d\u001a\u00020\u0007H&J\u0019\u0010\u001e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH¦\u0002R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u001f"}, d2 = {"Lio/ktor/util/StringValuesBuilder;", "", "caseInsensitiveName", "", "getCaseInsensitiveName", "()Z", "append", "", "name", "", "value", "appendAll", "stringValues", "Lio/ktor/util/StringValues;", "values", "", "appendMissing", "build", "clear", "contains", "entries", "", "", "", "get", "getAll", "isEmpty", "names", "remove", "removeKeysWithNoEntries", "set", "ktor-utils"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: StringValues.kt */
public interface StringValuesBuilder {
    void append(String str, String str2);

    void appendAll(StringValues stringValues);

    void appendAll(String str, Iterable<String> iterable);

    void appendMissing(StringValues stringValues);

    void appendMissing(String str, Iterable<String> iterable);

    StringValues build();

    void clear();

    boolean contains(String str);

    boolean contains(String str, String str2);

    Set<Map.Entry<String, List<String>>> entries();

    String get(String str);

    List<String> getAll(String str);

    boolean getCaseInsensitiveName();

    boolean isEmpty();

    Set<String> names();

    void remove(String str);

    boolean remove(String str, String str2);

    void removeKeysWithNoEntries();

    void set(String str, String str2);
}
