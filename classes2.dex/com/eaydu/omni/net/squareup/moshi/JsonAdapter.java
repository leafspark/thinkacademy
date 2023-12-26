package com.eaydu.omni.net.squareup.moshi;

import com.eaydu.omni.net.okio.Buffer;
import com.eaydu.omni.net.okio.BufferedSink;
import com.eaydu.omni.net.okio.BufferedSource;
import com.eaydu.omni.net.squareup.moshi.JsonReader;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Set;

public abstract class JsonAdapter<T> {

    public interface Factory {
        JsonAdapter<?> create(Type type, Set<? extends Annotation> set, Moshi moshi);
    }

    public abstract T fromJson(JsonReader jsonReader) throws IOException;

    public abstract void toJson(JsonWriter jsonWriter, T t) throws IOException;

    public final T fromJson(BufferedSource bufferedSource) throws IOException {
        return fromJson(JsonReader.of(bufferedSource));
    }

    public final T fromJson(String str) throws IOException {
        return fromJson((BufferedSource) new Buffer().writeUtf8(str));
    }

    public final void toJson(BufferedSink bufferedSink, T t) throws IOException {
        toJson(JsonWriter.of(bufferedSink), t);
    }

    public final String toJson(T t) {
        Buffer buffer = new Buffer();
        try {
            toJson((BufferedSink) buffer, t);
            return buffer.readUtf8();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    public final JsonAdapter<T> nullSafe() {
        return new JsonAdapter<T>() {
            public T fromJson(JsonReader jsonReader) throws IOException {
                if (jsonReader.peek() == JsonReader.Token.NULL) {
                    return jsonReader.nextNull();
                }
                return this.fromJson(jsonReader);
            }

            public void toJson(JsonWriter jsonWriter, T t) throws IOException {
                if (t == null) {
                    jsonWriter.nullValue();
                } else {
                    this.toJson(jsonWriter, t);
                }
            }

            public String toString() {
                return this + ".nullSafe()";
            }
        };
    }

    public final JsonAdapter<T> lenient() {
        return new JsonAdapter<T>() {
            public T fromJson(JsonReader jsonReader) throws IOException {
                boolean isLenient = jsonReader.isLenient();
                jsonReader.setLenient(true);
                try {
                    return this.fromJson(jsonReader);
                } finally {
                    jsonReader.setLenient(isLenient);
                }
            }

            public void toJson(JsonWriter jsonWriter, T t) throws IOException {
                boolean isLenient = jsonWriter.isLenient();
                jsonWriter.setLenient(true);
                try {
                    this.toJson(jsonWriter, t);
                } finally {
                    jsonWriter.setLenient(isLenient);
                }
            }

            public String toString() {
                return this + ".lenient()";
            }
        };
    }

    public final JsonAdapter<T> failOnUnknown() {
        return new JsonAdapter<T>() {
            public T fromJson(JsonReader jsonReader) throws IOException {
                boolean failOnUnknown = jsonReader.failOnUnknown();
                jsonReader.setFailOnUnknown(true);
                try {
                    return this.fromJson(jsonReader);
                } finally {
                    jsonReader.setFailOnUnknown(failOnUnknown);
                }
            }

            public void toJson(JsonWriter jsonWriter, T t) throws IOException {
                this.toJson(jsonWriter, t);
            }

            public String toString() {
                return this + ".failOnUnknown()";
            }
        };
    }
}
