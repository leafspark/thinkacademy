package com.eaydu.omni.gson.internal.bind;

import com.eaydu.omni.gson.Gson;
import com.eaydu.omni.gson.JsonSyntaxException;
import com.eaydu.omni.gson.TypeAdapter;
import com.eaydu.omni.gson.TypeAdapterFactory;
import com.eaydu.omni.gson.reflect.TypeToken;
import com.eaydu.omni.gson.stream.JsonReader;
import com.eaydu.omni.gson.stream.JsonToken;
import com.eaydu.omni.gson.stream.JsonWriter;
import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public final class TimeTypeAdapter extends TypeAdapter<Time> {
    public static final TypeAdapterFactory FACTORY = new TypeAdapterFactory() {
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            if (typeToken.getRawType() == Time.class) {
                return new TimeTypeAdapter();
            }
            return null;
        }
    };
    private final DateFormat format = new SimpleDateFormat("hh:mm:ss a");

    public synchronized Time read(JsonReader jsonReader) throws IOException {
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

    public synchronized void write(JsonWriter jsonWriter, Time time) throws IOException {
        jsonWriter.value(time == null ? null : this.format.format(time));
    }
}