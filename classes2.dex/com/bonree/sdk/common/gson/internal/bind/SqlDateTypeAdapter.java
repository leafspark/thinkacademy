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
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public final class SqlDateTypeAdapter extends TypeAdapter<Date> {
    public static final TypeAdapterFactory FACTORY = new TypeAdapterFactory() {
        public final <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            if (typeToken.getRawType() == Date.class) {
                return new SqlDateTypeAdapter();
            }
            return null;
        }
    };
    private final DateFormat format = new SimpleDateFormat("MMM d, yyyy");

    public final synchronized Date read(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        try {
            return new Date(this.format.parse(jsonReader.nextString()).getTime());
        } catch (ParseException e) {
            throw new JsonSyntaxException((Throwable) e);
        }
    }

    public final synchronized void write(JsonWriter jsonWriter, Date date) throws IOException {
        jsonWriter.value(date == null ? null : this.format.format(date));
    }
}
