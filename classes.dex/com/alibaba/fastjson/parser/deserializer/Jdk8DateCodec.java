package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONScanner;
import com.alibaba.fastjson.serializer.BeanContext;
import com.alibaba.fastjson.serializer.ContextObjectSerializer;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.chrono.ChronoZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Locale;
import java.util.TimeZone;

public class Jdk8DateCodec extends ContextObjectDeserializer implements ObjectSerializer, ContextObjectSerializer, ObjectDeserializer {
    private static final DateTimeFormatter ISO_FIXED_FORMAT = DateTimeFormatter.ofPattern(defaultPatttern).withZone(ZoneId.systemDefault());
    private static final DateTimeFormatter defaultFormatter = DateTimeFormatter.ofPattern(defaultPatttern);
    private static final DateTimeFormatter defaultFormatter_23 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
    private static final String defaultPatttern = "yyyy-MM-dd HH:mm:ss";
    private static final DateTimeFormatter formatter_d10_cn = DateTimeFormatter.ofPattern("yyyy年M月d日");
    private static final DateTimeFormatter formatter_d10_de = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    private static final DateTimeFormatter formatter_d10_eur = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final DateTimeFormatter formatter_d10_in = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private static final DateTimeFormatter formatter_d10_kr = DateTimeFormatter.ofPattern("yyyy년M월d일");
    private static final DateTimeFormatter formatter_d10_tw = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    private static final DateTimeFormatter formatter_d10_us = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    private static final DateTimeFormatter formatter_d8 = DateTimeFormatter.ofPattern("yyyyMMdd");
    private static final DateTimeFormatter formatter_dt19_cn = DateTimeFormatter.ofPattern("yyyy年M月d日 HH:mm:ss");
    private static final DateTimeFormatter formatter_dt19_cn_1 = DateTimeFormatter.ofPattern("yyyy年M月d日 H时m分s秒");
    private static final DateTimeFormatter formatter_dt19_de = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
    private static final DateTimeFormatter formatter_dt19_eur = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    private static final DateTimeFormatter formatter_dt19_in = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    private static final DateTimeFormatter formatter_dt19_kr = DateTimeFormatter.ofPattern("yyyy년M월d일 HH:mm:ss");
    private static final DateTimeFormatter formatter_dt19_tw = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    private static final DateTimeFormatter formatter_dt19_us = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
    private static final DateTimeFormatter formatter_iso8601 = DateTimeFormatter.ofPattern(formatter_iso8601_pattern);
    private static final String formatter_iso8601_pattern = "yyyy-MM-dd'T'HH:mm:ss";
    private static final String formatter_iso8601_pattern_23 = "yyyy-MM-dd'T'HH:mm:ss.SSS";
    private static final String formatter_iso8601_pattern_29 = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSSSS";
    public static final Jdk8DateCodec instance = new Jdk8DateCodec();

    public int getFastMatchToken() {
        return 4;
    }

    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj, String str, int i) {
        DateTimeFormatter dateTimeFormatter;
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (jSONLexer.token() == 8) {
            jSONLexer.nextToken();
            return null;
        } else if (jSONLexer.token() == 4) {
            String stringVal = jSONLexer.stringVal();
            jSONLexer.nextToken();
            if (str != null) {
                dateTimeFormatter = defaultPatttern.equals(str) ? defaultFormatter : DateTimeFormatter.ofPattern(str);
            } else {
                dateTimeFormatter = null;
            }
            if ("".equals(stringVal)) {
                return null;
            }
            if (type == LocalDateTime.class) {
                if (stringVal.length() == 10 || stringVal.length() == 8) {
                    return LocalDateTime.of(parseLocalDate(stringVal, str, dateTimeFormatter), LocalTime.MIN);
                }
                return parseDateTime(stringVal, dateTimeFormatter);
            } else if (type == LocalDate.class) {
                if (stringVal.length() != 23) {
                    return parseLocalDate(stringVal, str, dateTimeFormatter);
                }
                LocalDateTime parse = LocalDateTime.parse(stringVal);
                return LocalDate.of(parse.getYear(), parse.getMonthValue(), parse.getDayOfMonth());
            } else if (type == LocalTime.class) {
                if (stringVal.length() != 23) {
                    return LocalTime.parse(stringVal);
                }
                LocalDateTime parse2 = LocalDateTime.parse(stringVal);
                return LocalTime.of(parse2.getHour(), parse2.getMinute(), parse2.getSecond(), parse2.getNano());
            } else if (type == ZonedDateTime.class) {
                if (dateTimeFormatter == defaultFormatter) {
                    dateTimeFormatter = ISO_FIXED_FORMAT;
                }
                if (dateTimeFormatter == null && stringVal.length() <= 19) {
                    JSONScanner jSONScanner = new JSONScanner(stringVal);
                    TimeZone timeZone = defaultJSONParser.lexer.getTimeZone();
                    jSONScanner.setTimeZone(timeZone);
                    if (jSONScanner.scanISO8601DateIfMatch(false)) {
                        return ZonedDateTime.ofInstant(jSONScanner.getCalendar().getTime().toInstant(), timeZone.toZoneId());
                    }
                }
                return parseZonedDateTime(stringVal, dateTimeFormatter);
            } else if (type == OffsetDateTime.class) {
                return OffsetDateTime.parse(stringVal);
            } else {
                if (type == OffsetTime.class) {
                    return OffsetTime.parse(stringVal);
                }
                if (type == ZoneId.class) {
                    return ZoneId.of(stringVal);
                }
                if (type == Period.class) {
                    return Period.parse(stringVal);
                }
                if (type == Duration.class) {
                    return Duration.parse(stringVal);
                }
                if (type == Instant.class) {
                    return Instant.parse(stringVal);
                }
                return null;
            }
        } else if (jSONLexer.token() == 2) {
            long longValue = jSONLexer.longValue();
            jSONLexer.nextToken();
            if ("unixtime".equals(str)) {
                longValue *= 1000;
            }
            if (type == LocalDateTime.class) {
                return LocalDateTime.ofInstant(Instant.ofEpochMilli(longValue), JSON.defaultTimeZone.toZoneId());
            }
            if (type == LocalDate.class) {
                return LocalDateTime.ofInstant(Instant.ofEpochMilli(longValue), JSON.defaultTimeZone.toZoneId()).toLocalDate();
            }
            if (type == LocalTime.class) {
                return LocalDateTime.ofInstant(Instant.ofEpochMilli(longValue), JSON.defaultTimeZone.toZoneId()).toLocalTime();
            }
            if (type == ZonedDateTime.class) {
                return ZonedDateTime.ofInstant(Instant.ofEpochMilli(longValue), JSON.defaultTimeZone.toZoneId());
            }
            throw new UnsupportedOperationException();
        } else {
            throw new UnsupportedOperationException();
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00fc  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.time.LocalDateTime parseDateTime(java.lang.String r16, java.time.format.DateTimeFormatter r17) {
        /*
            r15 = this;
            r0 = r16
            r1 = 0
            if (r17 != 0) goto L_0x011f
            int r2 = r16.length()
            r3 = 32
            r4 = 1
            r5 = 16
            r6 = 13
            r7 = 7
            r8 = 19
            r9 = 46
            r10 = 4
            r11 = 58
            r12 = 10
            r13 = 45
            if (r2 != r8) goto L_0x00c3
            char r2 = r0.charAt(r10)
            char r7 = r0.charAt(r7)
            char r8 = r0.charAt(r12)
            char r6 = r0.charAt(r6)
            char r5 = r0.charAt(r5)
            if (r6 != r11) goto L_0x00f2
            if (r5 != r11) goto L_0x00f2
            if (r2 != r13) goto L_0x0048
            if (r7 != r13) goto L_0x0048
            r2 = 84
            if (r8 != r2) goto L_0x0042
            java.time.format.DateTimeFormatter r2 = java.time.format.DateTimeFormatter.ISO_LOCAL_DATE_TIME
            goto L_0x00f4
        L_0x0042:
            if (r8 != r3) goto L_0x00f2
            java.time.format.DateTimeFormatter r2 = defaultFormatter
            goto L_0x00f4
        L_0x0048:
            if (r2 != r13) goto L_0x0050
            if (r7 != r13) goto L_0x0050
            java.time.format.DateTimeFormatter r2 = defaultFormatter
            goto L_0x00f4
        L_0x0050:
            r3 = 47
            if (r2 != r3) goto L_0x005a
            if (r7 != r3) goto L_0x005a
            java.time.format.DateTimeFormatter r2 = formatter_dt19_tw
            goto L_0x00f4
        L_0x005a:
            char r5 = r0.charAt(r1)
            char r6 = r0.charAt(r4)
            r7 = 2
            char r7 = r0.charAt(r7)
            r8 = 3
            char r8 = r0.charAt(r8)
            r11 = 5
            char r11 = r0.charAt(r11)
            if (r7 != r3) goto L_0x00b5
            if (r11 != r3) goto L_0x00b5
            int r5 = r5 + -48
            int r5 = r5 * r12
            int r6 = r6 + -48
            int r5 = r5 + r6
            int r8 = r8 + -48
            int r8 = r8 * r12
            int r2 = r2 + -48
            int r8 = r8 + r2
            r2 = 12
            if (r5 <= r2) goto L_0x0089
            java.time.format.DateTimeFormatter r2 = formatter_dt19_eur
            goto L_0x00f4
        L_0x0089:
            if (r8 <= r2) goto L_0x008f
            java.time.format.DateTimeFormatter r2 = formatter_dt19_us
            goto L_0x00f4
        L_0x008f:
            java.util.Locale r2 = java.util.Locale.getDefault()
            java.lang.String r2 = r2.getCountry()
            java.lang.String r3 = "US"
            boolean r3 = r2.equals(r3)
            if (r3 == 0) goto L_0x00a2
            java.time.format.DateTimeFormatter r2 = formatter_dt19_us
            goto L_0x00f4
        L_0x00a2:
            java.lang.String r3 = "BR"
            boolean r3 = r2.equals(r3)
            if (r3 != 0) goto L_0x00b2
            java.lang.String r3 = "AU"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x00f2
        L_0x00b2:
            java.time.format.DateTimeFormatter r2 = formatter_dt19_eur
            goto L_0x00f4
        L_0x00b5:
            if (r7 != r9) goto L_0x00bc
            if (r11 != r9) goto L_0x00bc
            java.time.format.DateTimeFormatter r2 = formatter_dt19_de
            goto L_0x00f4
        L_0x00bc:
            if (r7 != r13) goto L_0x00f2
            if (r11 != r13) goto L_0x00f2
            java.time.format.DateTimeFormatter r2 = formatter_dt19_in
            goto L_0x00f4
        L_0x00c3:
            int r2 = r16.length()
            r14 = 23
            if (r2 != r14) goto L_0x00f2
            char r2 = r0.charAt(r10)
            char r7 = r0.charAt(r7)
            char r12 = r0.charAt(r12)
            char r6 = r0.charAt(r6)
            char r5 = r0.charAt(r5)
            char r8 = r0.charAt(r8)
            if (r6 != r11) goto L_0x00f2
            if (r5 != r11) goto L_0x00f2
            if (r2 != r13) goto L_0x00f2
            if (r7 != r13) goto L_0x00f2
            if (r12 != r3) goto L_0x00f2
            if (r8 != r9) goto L_0x00f2
            java.time.format.DateTimeFormatter r2 = defaultFormatter_23
            goto L_0x00f4
        L_0x00f2:
            r2 = r17
        L_0x00f4:
            int r3 = r16.length()
            r5 = 17
            if (r3 < r5) goto L_0x0121
            char r3 = r0.charAt(r10)
            r5 = 24180(0x5e74, float:3.3883E-41)
            if (r3 != r5) goto L_0x0117
            int r2 = r16.length()
            int r2 = r2 - r4
            char r2 = r0.charAt(r2)
            r3 = 31186(0x79d2, float:4.3701E-41)
            if (r2 != r3) goto L_0x0114
            java.time.format.DateTimeFormatter r2 = formatter_dt19_cn_1
            goto L_0x0121
        L_0x0114:
            java.time.format.DateTimeFormatter r2 = formatter_dt19_cn
            goto L_0x0121
        L_0x0117:
            r4 = 45380(0xb144, float:6.3591E-41)
            if (r3 != r4) goto L_0x0121
            java.time.format.DateTimeFormatter r2 = formatter_dt19_kr
            goto L_0x0121
        L_0x011f:
            r2 = r17
        L_0x0121:
            if (r2 != 0) goto L_0x013f
            com.alibaba.fastjson.parser.JSONScanner r3 = new com.alibaba.fastjson.parser.JSONScanner
            r3.<init>(r0)
            boolean r1 = r3.scanISO8601DateIfMatch(r1)
            if (r1 == 0) goto L_0x013f
            java.util.Calendar r0 = r3.getCalendar()
            java.time.Instant r0 = r0.toInstant()
            java.time.ZoneId r1 = java.time.ZoneId.systemDefault()
            java.time.LocalDateTime r0 = java.time.LocalDateTime.ofInstant(r0, r1)
            return r0
        L_0x013f:
            if (r2 != 0) goto L_0x0146
            java.time.LocalDateTime r0 = java.time.LocalDateTime.parse(r16)
            goto L_0x014a
        L_0x0146:
            java.time.LocalDateTime r0 = java.time.LocalDateTime.parse(r0, r2)
        L_0x014a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.deserializer.Jdk8DateCodec.parseDateTime(java.lang.String, java.time.format.DateTimeFormatter):java.time.LocalDateTime");
    }

    /* access modifiers changed from: protected */
    public LocalDate parseLocalDate(String str, String str2, DateTimeFormatter dateTimeFormatter) {
        DateTimeFormatter dateTimeFormatter2;
        if (dateTimeFormatter == null) {
            if (str.length() == 8) {
                dateTimeFormatter = formatter_d8;
            }
            if (str.length() == 10) {
                char charAt = str.charAt(4);
                char charAt2 = str.charAt(7);
                if (charAt == '/' && charAt2 == '/') {
                    dateTimeFormatter = formatter_d10_tw;
                }
                char charAt3 = str.charAt(0);
                char charAt4 = str.charAt(1);
                char charAt5 = str.charAt(2);
                char charAt6 = str.charAt(3);
                char charAt7 = str.charAt(5);
                if (charAt5 == '/' && charAt7 == '/') {
                    int i = ((charAt6 - '0') * 10) + (charAt - '0');
                    if (((charAt3 - '0') * 10) + (charAt4 - '0') > 12) {
                        dateTimeFormatter = formatter_d10_eur;
                    } else if (i > 12) {
                        dateTimeFormatter = formatter_d10_us;
                    } else {
                        String country = Locale.getDefault().getCountry();
                        if (country.equals("US")) {
                            dateTimeFormatter = formatter_d10_us;
                        } else if (country.equals("BR") || country.equals("AU")) {
                            dateTimeFormatter = formatter_d10_eur;
                        }
                    }
                } else {
                    if (charAt5 == '.' && charAt7 == '.') {
                        dateTimeFormatter2 = formatter_d10_de;
                    } else if (charAt5 == '-' && charAt7 == '-') {
                        dateTimeFormatter2 = formatter_d10_in;
                    }
                    dateTimeFormatter = dateTimeFormatter2;
                }
            }
            if (str.length() >= 9) {
                char charAt8 = str.charAt(4);
                if (charAt8 == 24180) {
                    dateTimeFormatter = formatter_d10_cn;
                } else if (charAt8 == 45380) {
                    dateTimeFormatter = formatter_d10_kr;
                }
            }
        }
        if (dateTimeFormatter == null) {
            return LocalDate.parse(str);
        }
        return LocalDate.parse(str, dateTimeFormatter);
    }

    /* access modifiers changed from: protected */
    public ZonedDateTime parseZonedDateTime(String str, DateTimeFormatter dateTimeFormatter) {
        if (dateTimeFormatter == null) {
            if (str.length() == 19) {
                char charAt = str.charAt(4);
                char charAt2 = str.charAt(7);
                char charAt3 = str.charAt(10);
                char charAt4 = str.charAt(13);
                char charAt5 = str.charAt(16);
                if (charAt4 == ':' && charAt5 == ':') {
                    if (charAt == '-' && charAt2 == '-') {
                        if (charAt3 == 'T') {
                            dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
                        } else if (charAt3 == ' ') {
                            dateTimeFormatter = defaultFormatter;
                        }
                    } else if (charAt == '-' && charAt2 == '-') {
                        dateTimeFormatter = defaultFormatter;
                    } else if (charAt == '/' && charAt2 == '/') {
                        dateTimeFormatter = formatter_dt19_tw;
                    } else {
                        char charAt6 = str.charAt(0);
                        char charAt7 = str.charAt(1);
                        char charAt8 = str.charAt(2);
                        char charAt9 = str.charAt(3);
                        char charAt10 = str.charAt(5);
                        if (charAt8 == '/' && charAt10 == '/') {
                            int i = ((charAt9 - '0') * 10) + (charAt - '0');
                            if (((charAt6 - '0') * 10) + (charAt7 - '0') > 12) {
                                dateTimeFormatter = formatter_dt19_eur;
                            } else if (i > 12) {
                                dateTimeFormatter = formatter_dt19_us;
                            } else {
                                String country = Locale.getDefault().getCountry();
                                if (country.equals("US")) {
                                    dateTimeFormatter = formatter_dt19_us;
                                } else if (country.equals("BR") || country.equals("AU")) {
                                    dateTimeFormatter = formatter_dt19_eur;
                                }
                            }
                        } else if (charAt8 == '.' && charAt10 == '.') {
                            dateTimeFormatter = formatter_dt19_de;
                        } else if (charAt8 == '-' && charAt10 == '-') {
                            dateTimeFormatter = formatter_dt19_in;
                        }
                    }
                }
            }
            if (str.length() >= 17) {
                char charAt11 = str.charAt(4);
                if (charAt11 == 24180) {
                    if (str.charAt(str.length() - 1) == 31186) {
                        dateTimeFormatter = formatter_dt19_cn_1;
                    } else {
                        dateTimeFormatter = formatter_dt19_cn;
                    }
                } else if (charAt11 == 45380) {
                    dateTimeFormatter = formatter_dt19_kr;
                }
            }
        }
        if (dateTimeFormatter == null) {
            return ZonedDateTime.parse(str);
        }
        return ZonedDateTime.parse(str, dateTimeFormatter);
    }

    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        int nano;
        SerializeWriter serializeWriter = jSONSerializer.out;
        if (obj == null) {
            serializeWriter.writeNull();
            return;
        }
        if (type == null) {
            type = obj.getClass();
        }
        if (type == LocalDateTime.class) {
            int mask = SerializerFeature.UseISO8601DateFormat.getMask();
            LocalDateTime localDateTime = (LocalDateTime) obj;
            String dateFormatPattern = jSONSerializer.getDateFormatPattern();
            if (dateFormatPattern == null) {
                if ((mask & i) != 0 || jSONSerializer.isEnabled(SerializerFeature.UseISO8601DateFormat) || (nano = localDateTime.getNano()) == 0) {
                    dateFormatPattern = formatter_iso8601_pattern;
                } else {
                    dateFormatPattern = nano % 1000000 == 0 ? formatter_iso8601_pattern_23 : formatter_iso8601_pattern_29;
                }
            }
            if (dateFormatPattern != null) {
                write(serializeWriter, (TemporalAccessor) localDateTime, dateFormatPattern);
            } else if (serializeWriter.isEnabled(SerializerFeature.WriteDateUseDateFormat)) {
                write(serializeWriter, (TemporalAccessor) localDateTime, JSON.DEFFAULT_DATE_FORMAT);
            } else {
                serializeWriter.writeLong(localDateTime.atZone(JSON.defaultTimeZone.toZoneId()).toInstant().toEpochMilli());
            }
        } else {
            serializeWriter.writeString(obj.toString());
        }
    }

    public void write(JSONSerializer jSONSerializer, Object obj, BeanContext beanContext) throws IOException {
        write(jSONSerializer.out, (TemporalAccessor) obj, beanContext.getFormat());
    }

    private void write(SerializeWriter serializeWriter, TemporalAccessor temporalAccessor, String str) {
        DateTimeFormatter dateTimeFormatter;
        if (!"unixtime".equals(str) || !(temporalAccessor instanceof ChronoZonedDateTime)) {
            if (str == formatter_iso8601_pattern) {
                dateTimeFormatter = formatter_iso8601;
            } else {
                dateTimeFormatter = DateTimeFormatter.ofPattern(str);
            }
            serializeWriter.writeString(dateTimeFormatter.format(temporalAccessor));
            return;
        }
        serializeWriter.writeInt((int) ((ChronoZonedDateTime) temporalAccessor).toEpochSecond());
    }
}
