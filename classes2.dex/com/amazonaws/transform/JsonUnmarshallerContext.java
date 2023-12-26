package com.amazonaws.transform;

import com.amazonaws.http.HttpResponse;
import com.amazonaws.util.json.AwsJsonReader;

public class JsonUnmarshallerContext {
    private final HttpResponse httpResponse;
    private final AwsJsonReader reader;

    public JsonUnmarshallerContext(AwsJsonReader awsJsonReader) {
        this(awsJsonReader, (HttpResponse) null);
    }

    public JsonUnmarshallerContext(AwsJsonReader awsJsonReader, HttpResponse httpResponse2) {
        this.reader = awsJsonReader;
        this.httpResponse = httpResponse2;
    }

    public AwsJsonReader getReader() {
        return this.reader;
    }

    public String getHeader(String str) {
        HttpResponse httpResponse2 = this.httpResponse;
        if (httpResponse2 == null) {
            return null;
        }
        return (String) httpResponse2.getHeaders().get(str);
    }

    public HttpResponse getHttpResponse() {
        return this.httpResponse;
    }
}
