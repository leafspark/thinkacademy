package com.didi.hummer.core.util;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

public class GsonTypeAdapterFactory implements TypeAdapterFactory {
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        final TypeAdapter<T> delegateAdapter = gson.getDelegateAdapter(this, typeToken);
        return new TypeAdapter<T>() {
            public void write(JsonWriter jsonWriter, T t) throws IOException {
                delegateAdapter.write(jsonWriter, t);
            }

            public T read(JsonReader jsonReader) throws IOException {
                try {
                    return delegateAdapter.read(jsonReader);
                } catch (Throwable unused) {
                    consumeAll(jsonReader);
                    return null;
                }
            }

            private void consumeAll(JsonReader jsonReader) throws IOException {
                if (jsonReader.hasNext()) {
                    JsonToken peek = jsonReader.peek();
                    if (peek == JsonToken.STRING) {
                        jsonReader.nextString();
                    } else if (peek == JsonToken.BEGIN_ARRAY) {
                        jsonReader.beginArray();
                        consumeAll(jsonReader);
                        jsonReader.endArray();
                    } else if (peek == JsonToken.BEGIN_OBJECT) {
                        jsonReader.beginObject();
                        consumeAll(jsonReader);
                        jsonReader.endObject();
                    } else if (peek == JsonToken.END_ARRAY) {
                        jsonReader.endArray();
                    } else if (peek == JsonToken.END_OBJECT) {
                        jsonReader.endObject();
                    } else if (peek == JsonToken.NUMBER) {
                        jsonReader.nextString();
                    } else if (peek == JsonToken.BOOLEAN) {
                        jsonReader.nextBoolean();
                    } else if (peek == JsonToken.NAME) {
                        jsonReader.nextName();
                        consumeAll(jsonReader);
                    } else if (peek == JsonToken.NULL) {
                        jsonReader.nextNull();
                    }
                }
            }
        };
    }
}
