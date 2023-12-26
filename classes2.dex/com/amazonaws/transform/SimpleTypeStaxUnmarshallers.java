package com.amazonaws.transform;

import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.util.Base64;
import com.amazonaws.util.DateUtils;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.Date;

public class SimpleTypeStaxUnmarshallers {
    /* access modifiers changed from: private */
    public static Log log = LogFactory.getLog(SimpleTypeStaxUnmarshallers.class);

    public static class StringStaxUnmarshaller implements Unmarshaller<String, StaxUnmarshallerContext> {
        private static StringStaxUnmarshaller instance;

        public String unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
            return staxUnmarshallerContext.readText();
        }

        public static StringStaxUnmarshaller getInstance() {
            if (instance == null) {
                instance = new StringStaxUnmarshaller();
            }
            return instance;
        }
    }

    public static class BigDecimalStaxUnmarshaller implements Unmarshaller<BigDecimal, StaxUnmarshallerContext> {
        private static BigDecimalStaxUnmarshaller instance;

        public BigDecimal unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
            String readText = staxUnmarshallerContext.readText();
            if (readText == null) {
                return null;
            }
            return new BigDecimal(readText);
        }

        public static BigDecimalStaxUnmarshaller getInstance() {
            if (instance == null) {
                instance = new BigDecimalStaxUnmarshaller();
            }
            return instance;
        }
    }

    public static class BigIntegerStaxUnmarshaller implements Unmarshaller<BigInteger, StaxUnmarshallerContext> {
        private static BigIntegerStaxUnmarshaller instance;

        public BigInteger unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
            String readText = staxUnmarshallerContext.readText();
            if (readText == null) {
                return null;
            }
            return new BigInteger(readText);
        }

        public static BigIntegerStaxUnmarshaller getInstance() {
            if (instance == null) {
                instance = new BigIntegerStaxUnmarshaller();
            }
            return instance;
        }
    }

    public static class DoubleStaxUnmarshaller implements Unmarshaller<Double, StaxUnmarshallerContext> {
        private static DoubleStaxUnmarshaller instance;

        public Double unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
            String readText = staxUnmarshallerContext.readText();
            if (readText == null) {
                return null;
            }
            return Double.valueOf(Double.parseDouble(readText));
        }

        public static DoubleStaxUnmarshaller getInstance() {
            if (instance == null) {
                instance = new DoubleStaxUnmarshaller();
            }
            return instance;
        }
    }

    public static class IntegerStaxUnmarshaller implements Unmarshaller<Integer, StaxUnmarshallerContext> {
        private static IntegerStaxUnmarshaller instance;

        public Integer unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
            String readText = staxUnmarshallerContext.readText();
            if (readText == null) {
                return null;
            }
            return Integer.valueOf(Integer.parseInt(readText));
        }

        public static IntegerStaxUnmarshaller getInstance() {
            if (instance == null) {
                instance = new IntegerStaxUnmarshaller();
            }
            return instance;
        }
    }

    public static class BooleanStaxUnmarshaller implements Unmarshaller<Boolean, StaxUnmarshallerContext> {
        private static BooleanStaxUnmarshaller instance;

        public Boolean unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
            String readText = staxUnmarshallerContext.readText();
            if (readText == null) {
                return null;
            }
            return Boolean.valueOf(Boolean.parseBoolean(readText));
        }

        public static BooleanStaxUnmarshaller getInstance() {
            if (instance == null) {
                instance = new BooleanStaxUnmarshaller();
            }
            return instance;
        }
    }

    public static class FloatStaxUnmarshaller implements Unmarshaller<Float, StaxUnmarshallerContext> {
        private static FloatStaxUnmarshaller instance;

        public Float unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
            String readText = staxUnmarshallerContext.readText();
            if (readText == null) {
                return null;
            }
            return Float.valueOf(readText);
        }

        public static FloatStaxUnmarshaller getInstance() {
            if (instance == null) {
                instance = new FloatStaxUnmarshaller();
            }
            return instance;
        }
    }

    public static class LongStaxUnmarshaller implements Unmarshaller<Long, StaxUnmarshallerContext> {
        private static LongStaxUnmarshaller instance;

        public Long unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
            String readText = staxUnmarshallerContext.readText();
            if (readText == null) {
                return null;
            }
            return Long.valueOf(Long.parseLong(readText));
        }

        public static LongStaxUnmarshaller getInstance() {
            if (instance == null) {
                instance = new LongStaxUnmarshaller();
            }
            return instance;
        }
    }

    public static class ByteStaxUnmarshaller implements Unmarshaller<Byte, StaxUnmarshallerContext> {
        private static ByteStaxUnmarshaller instance;

        public Byte unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
            String readText = staxUnmarshallerContext.readText();
            if (readText == null) {
                return null;
            }
            return Byte.valueOf(readText);
        }

        public static ByteStaxUnmarshaller getInstance() {
            if (instance == null) {
                instance = new ByteStaxUnmarshaller();
            }
            return instance;
        }
    }

    public static class DateStaxUnmarshaller implements Unmarshaller<Date, StaxUnmarshallerContext> {
        private static DateStaxUnmarshaller instance;

        public Date unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
            String readText = staxUnmarshallerContext.readText();
            if (readText == null) {
                return null;
            }
            try {
                return DateUtils.parseISO8601Date(readText);
            } catch (Exception e) {
                Log access$000 = SimpleTypeStaxUnmarshallers.log;
                access$000.warn("Unable to parse date '" + readText + "':  " + e.getMessage(), e);
                return null;
            }
        }

        public static DateStaxUnmarshaller getInstance() {
            if (instance == null) {
                instance = new DateStaxUnmarshaller();
            }
            return instance;
        }
    }

    public static class ByteBufferStaxUnmarshaller implements Unmarshaller<ByteBuffer, StaxUnmarshallerContext> {
        private static ByteBufferStaxUnmarshaller instance;

        public ByteBuffer unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
            return ByteBuffer.wrap(Base64.decode(staxUnmarshallerContext.readText()));
        }

        public static ByteBufferStaxUnmarshaller getInstance() {
            if (instance == null) {
                instance = new ByteBufferStaxUnmarshaller();
            }
            return instance;
        }
    }
}
