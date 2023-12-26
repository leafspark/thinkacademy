package com.eaydu.omni.net.squareup.moshi;

import com.eaydu.omni.net.okio.BufferedSink;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.util.Objects;

public class JsonWriter implements Closeable, Flushable {
    private static final String[] REPLACEMENT_CHARS = new String[128];
    private String deferredName;
    private String indent;
    private boolean lenient;
    private int[] pathIndices;
    private String[] pathNames;
    private boolean promoteNameToValue;
    private String separator;
    private boolean serializeNulls;
    private final BufferedSink sink;
    private int[] stack = new int[32];
    private int stackSize = 0;

    static {
        for (int i = 0; i <= 31; i++) {
            REPLACEMENT_CHARS[i] = String.format("\\u%04x", new Object[]{Integer.valueOf(i)});
        }
        String[] strArr = REPLACEMENT_CHARS;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
    }

    private JsonWriter(BufferedSink bufferedSink) {
        push(6);
        this.pathNames = new String[32];
        this.pathIndices = new int[32];
        this.separator = ":";
        Objects.requireNonNull(bufferedSink, "sink == null");
        this.sink = bufferedSink;
    }

    public static JsonWriter of(BufferedSink bufferedSink) {
        return new JsonWriter(bufferedSink);
    }

    public final void setIndent(String str) {
        if (str.length() == 0) {
            this.indent = null;
            this.separator = ":";
            return;
        }
        this.indent = str;
        this.separator = ": ";
    }

    public final void setLenient(boolean z) {
        this.lenient = z;
    }

    public boolean isLenient() {
        return this.lenient;
    }

    public final void setSerializeNulls(boolean z) {
        this.serializeNulls = z;
    }

    public final boolean getSerializeNulls() {
        return this.serializeNulls;
    }

    public JsonWriter beginArray() throws IOException {
        writeDeferredName();
        return open(1, "[");
    }

    public JsonWriter endArray() throws IOException {
        return close(1, 2, "]");
    }

    public JsonWriter beginObject() throws IOException {
        writeDeferredName();
        return open(3, "{");
    }

    public JsonWriter endObject() throws IOException {
        this.promoteNameToValue = false;
        return close(3, 5, "}");
    }

    private JsonWriter open(int i, String str) throws IOException {
        beforeValue();
        this.pathIndices[this.stackSize] = 0;
        push(i);
        this.sink.writeUtf8(str);
        return this;
    }

    private JsonWriter close(int i, int i2, String str) throws IOException {
        int peek = peek();
        if (peek != i2 && peek != i) {
            throw new IllegalStateException("Nesting problem.");
        } else if (this.deferredName == null) {
            int i3 = this.stackSize - 1;
            this.stackSize = i3;
            this.pathNames[i3] = null;
            int[] iArr = this.pathIndices;
            int i4 = i3 - 1;
            iArr[i4] = iArr[i4] + 1;
            if (peek == i2) {
                newline();
            }
            this.sink.writeUtf8(str);
            return this;
        } else {
            throw new IllegalStateException("Dangling name: " + this.deferredName);
        }
    }

    private void push(int i) {
        int i2 = this.stackSize;
        int[] iArr = this.stack;
        if (i2 == iArr.length) {
            int[] iArr2 = new int[(i2 * 2)];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            this.stack = iArr2;
        }
        int[] iArr3 = this.stack;
        int i3 = this.stackSize;
        this.stackSize = i3 + 1;
        iArr3[i3] = i;
    }

    private int peek() {
        int i = this.stackSize;
        if (i != 0) {
            return this.stack[i - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    private void replaceTop(int i) {
        this.stack[this.stackSize - 1] = i;
    }

    public JsonWriter name(String str) throws IOException {
        Objects.requireNonNull(str, "name == null");
        int i = this.stackSize;
        if (i == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        } else if (this.deferredName == null) {
            this.deferredName = str;
            this.pathNames[i - 1] = str;
            this.promoteNameToValue = false;
            return this;
        } else {
            throw new IllegalStateException();
        }
    }

    private void writeDeferredName() throws IOException {
        if (this.deferredName != null) {
            beforeName();
            string(this.deferredName);
            this.deferredName = null;
        }
    }

    public JsonWriter value(String str) throws IOException {
        if (str == null) {
            return nullValue();
        }
        if (this.promoteNameToValue) {
            return name(str);
        }
        writeDeferredName();
        beforeValue();
        string(str);
        int[] iArr = this.pathIndices;
        int i = this.stackSize - 1;
        iArr[i] = iArr[i] + 1;
        return this;
    }

    public JsonWriter nullValue() throws IOException {
        if (this.deferredName != null) {
            if (this.serializeNulls) {
                writeDeferredName();
            } else {
                this.deferredName = null;
                return this;
            }
        }
        beforeValue();
        this.sink.writeUtf8("null");
        int[] iArr = this.pathIndices;
        int i = this.stackSize - 1;
        iArr[i] = iArr[i] + 1;
        return this;
    }

    public JsonWriter value(boolean z) throws IOException {
        writeDeferredName();
        beforeValue();
        this.sink.writeUtf8(z ? "true" : "false");
        int[] iArr = this.pathIndices;
        int i = this.stackSize - 1;
        iArr[i] = iArr[i] + 1;
        return this;
    }

    public JsonWriter value(double d) throws IOException {
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + d);
        } else if (this.promoteNameToValue) {
            return name(Double.toString(d));
        } else {
            writeDeferredName();
            beforeValue();
            this.sink.writeUtf8(Double.toString(d));
            int[] iArr = this.pathIndices;
            int i = this.stackSize - 1;
            iArr[i] = iArr[i] + 1;
            return this;
        }
    }

    public JsonWriter value(long j) throws IOException {
        if (this.promoteNameToValue) {
            return name(Long.toString(j));
        }
        writeDeferredName();
        beforeValue();
        this.sink.writeUtf8(Long.toString(j));
        int[] iArr = this.pathIndices;
        int i = this.stackSize - 1;
        iArr[i] = iArr[i] + 1;
        return this;
    }

    public JsonWriter value(Number number) throws IOException {
        if (number == null) {
            return nullValue();
        }
        String obj = number.toString();
        if (!this.lenient && (obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN"))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
        } else if (this.promoteNameToValue) {
            return name(obj);
        } else {
            writeDeferredName();
            beforeValue();
            this.sink.writeUtf8(obj);
            int[] iArr = this.pathIndices;
            int i = this.stackSize - 1;
            iArr[i] = iArr[i] + 1;
            return this;
        }
    }

    public void flush() throws IOException {
        if (this.stackSize != 0) {
            this.sink.flush();
            return;
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    public void close() throws IOException {
        this.sink.close();
        int i = this.stackSize;
        if (i > 1 || (i == 1 && this.stack[i - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.stackSize = 0;
    }

    private void string(String str) throws IOException {
        String str2;
        String[] strArr = REPLACEMENT_CHARS;
        this.sink.writeByte(34);
        int length = str.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (charAt < 128) {
                str2 = strArr[charAt];
                if (str2 == null) {
                }
            } else if (charAt == 8232) {
                str2 = "\\u2028";
            } else if (charAt == 8233) {
                str2 = "\\u2029";
            }
            if (i < i2) {
                this.sink.writeUtf8(str, i, i2);
            }
            this.sink.writeUtf8(str2);
            i = i2 + 1;
        }
        if (i < length) {
            this.sink.writeUtf8(str, i, length);
        }
        this.sink.writeByte(34);
    }

    private void newline() throws IOException {
        if (this.indent != null) {
            this.sink.writeByte(10);
            int i = this.stackSize;
            for (int i2 = 1; i2 < i; i2++) {
                this.sink.writeUtf8(this.indent);
            }
        }
    }

    private void beforeName() throws IOException {
        int peek = peek();
        if (peek == 5) {
            this.sink.writeByte(44);
        } else if (peek != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        newline();
        replaceTop(4);
    }

    private void beforeValue() throws IOException {
        int peek = peek();
        if (peek == 1) {
            replaceTop(2);
            newline();
        } else if (peek == 2) {
            this.sink.writeByte(44);
            newline();
        } else if (peek != 4) {
            if (peek != 6) {
                if (peek != 7) {
                    throw new IllegalStateException("Nesting problem.");
                } else if (!this.lenient) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
            }
            replaceTop(7);
        } else {
            this.sink.writeUtf8(this.separator);
            replaceTop(5);
        }
    }

    /* access modifiers changed from: package-private */
    public void promoteNameToValue() throws IOException {
        int peek = peek();
        if (peek == 5 || peek == 3) {
            this.promoteNameToValue = true;
            return;
        }
        throw new IllegalStateException("Nesting problem.");
    }

    public String getPath() {
        return JsonScope.getPath(this.stackSize, this.stack, this.pathNames, this.pathIndices);
    }
}
