package com.amazonaws.transform;

public class VoidStaxUnmarshaller<T> implements Unmarshaller<T, StaxUnmarshallerContext> {
    public T unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        do {
        } while (staxUnmarshallerContext.nextEvent() != 1);
        return null;
    }
}
