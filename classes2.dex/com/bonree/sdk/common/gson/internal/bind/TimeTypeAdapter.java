package com.bonree.sdk.common.gson.internal.bind;

import com.bonree.sdk.common.gson.Gson;
import com.bonree.sdk.common.gson.JsonSyntaxException;
import com.bonree.sdk.common.gson.TypeAdapter;
import com.bonree.sdk.common.gson.TypeAdapterFactory;
import com.bonree.sdk.common.gson.reflect.TypeToken;
import com.bonree.sdk.common.gson.stream.JsonReader;
import com.bonree.sdk.common.gson.stream.JsonToken;
import com.bonree.sdk.common.gson.stream.JsonWriter;
import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public final class TimeTypeAdapter extends TypeAdapter<Time> {
    public static final TypeAdapterFactory FACTORY = new TypeAdapterFactory() {
        public final <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            if (typeToken.getRawType() == Time.class) {
                return new TimeTypeAdapter();
            }
            return null;
        }
    };
    private final DateFormat format = new SimpleDateFormat("hh:mm:ss a");

    public final synchronized Time read(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        try {
            return new Time(this.format.parse(jsonReader.nextString()).getTime());
        } catch (ParseException e) {
            throw new JsonSyntaxException((Throwable) e);
        }
    }

    public final synchronized void write(JsonWriter jsonWriter, Time time) throws IOException {
        jsonWriter.value(time == null ? null : this.format.format(time));
    }
}
