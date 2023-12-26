package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import com.alibaba.fastjson.JSONPathException;
import com.alibaba.fastjson.parser.deserializer.ExtraProcessable;
import com.alibaba.fastjson.parser.deserializer.ExtraProcessor;
import com.alibaba.fastjson.parser.deserializer.ExtraTypeProvider;
import com.alibaba.fastjson.parser.deserializer.FieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.FieldTypeResolver;
import com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.parser.deserializer.ResolveFieldDeserializer;
import com.alibaba.fastjson.serializer.BeanContext;
import com.alibaba.fastjson.serializer.IntegerCodec;
import com.alibaba.fastjson.serializer.LongCodec;
import com.alibaba.fastjson.serializer.StringCodec;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.Closeable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class DefaultJSONParser implements Closeable {
    public static final int NONE = 0;
    public static final int NeedToResolve = 1;
    public static final int TypeNameRedirect = 2;
    private static final Set<Class<?>> primitiveClasses = new HashSet();
    private String[] autoTypeAccept;
    private boolean autoTypeEnable;
    protected ParserConfig config;
    protected ParseContext context;
    private ParseContext[] contextArray;
    private int contextArrayIndex;
    private DateFormat dateFormat;
    private String dateFormatPattern;
    private List<ExtraProcessor> extraProcessors;
    private List<ExtraTypeProvider> extraTypeProviders;
    protected FieldTypeResolver fieldTypeResolver;
    public final Object input;
    protected transient BeanContext lastBeanContext;
    public final JSONLexer lexer;
    public int resolveStatus;
    private List<ResolveTask> resolveTaskList;
    public final SymbolTable symbolTable;

    static {
        Class[] clsArr = {Boolean.TYPE, Byte.TYPE, Short.TYPE, Integer.TYPE, Long.TYPE, Float.TYPE, Double.TYPE, Boolean.class, Byte.class, Short.class, Integer.class, Long.class, Float.class, Double.class, BigInteger.class, BigDecimal.class, String.class};
        for (int i = 0; i < 17; i++) {
            primitiveClasses.add(clsArr[i]);
        }
    }

    public String getDateFomartPattern() {
        return this.dateFormatPattern;
    }

    public DateFormat getDateFormat() {
        if (this.dateFormat == null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.dateFormatPattern, this.lexer.getLocale());
            this.dateFormat = simpleDateFormat;
            simpleDateFormat.setTimeZone(this.lexer.getTimeZone());
        }
        return this.dateFormat;
    }

    public void setDateFormat(String str) {
        this.dateFormatPattern = str;
        this.dateFormat = null;
    }

    public void setDateFomrat(DateFormat dateFormat2) {
        this.dateFormat = dateFormat2;
    }

    public DefaultJSONParser(String str) {
        this(str, ParserConfig.getGlobalInstance(), JSON.DEFAULT_PARSER_FEATURE);
    }

    public DefaultJSONParser(String str, ParserConfig parserConfig) {
        this((Object) str, (JSONLexer) new JSONScanner(str, JSON.DEFAULT_PARSER_FEATURE), parserConfig);
    }

    public DefaultJSONParser(String str, ParserConfig parserConfig, int i) {
        this((Object) str, (JSONLexer) new JSONScanner(str, i), parserConfig);
    }

    public DefaultJSONParser(char[] cArr, int i, ParserConfig parserConfig, int i2) {
        this((Object) cArr, (JSONLexer) new JSONScanner(cArr, i, i2), parserConfig);
    }

    public DefaultJSONParser(JSONLexer jSONLexer) {
        this(jSONLexer, ParserConfig.getGlobalInstance());
    }

    public DefaultJSONParser(JSONLexer jSONLexer, ParserConfig parserConfig) {
        this((Object) null, jSONLexer, parserConfig);
    }

    public DefaultJSONParser(Object obj, JSONLexer jSONLexer, ParserConfig parserConfig) {
        this.dateFormatPattern = JSON.DEFFAULT_DATE_FORMAT;
        this.contextArrayIndex = 0;
        this.resolveStatus = 0;
        this.extraTypeProviders = null;
        this.extraProcessors = null;
        this.fieldTypeResolver = null;
        this.autoTypeAccept = null;
        this.lexer = jSONLexer;
        this.input = obj;
        this.config = parserConfig;
        this.symbolTable = parserConfig.symbolTable;
        char current = jSONLexer.getCurrent();
        if (current == '{') {
            jSONLexer.next();
            ((JSONLexerBase) jSONLexer).token = 12;
        } else if (current == '[') {
            jSONLexer.next();
            ((JSONLexerBase) jSONLexer).token = 14;
        } else {
            jSONLexer.nextToken();
        }
    }

    public SymbolTable getSymbolTable() {
        return this.symbolTable;
    }

    public String getInput() {
        Object obj = this.input;
        if (obj instanceof char[]) {
            return new String((char[]) obj);
        }
        return obj.toString();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: java.lang.Number} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v21, resolved type: com.alibaba.fastjson.JSONArray} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v25, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v19, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v20, resolved type: java.util.Date} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v21, resolved type: java.lang.Number} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v34, resolved type: java.lang.Number} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v43, resolved type: com.alibaba.fastjson.JSONArray} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v44, resolved type: com.alibaba.fastjson.JSONArray} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v37, resolved type: java.util.Date} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v38, resolved type: java.util.Date} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v39, resolved type: java.util.Date} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v40, resolved type: java.util.Date} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v41, resolved type: java.util.Date} */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x0260, code lost:
        r15 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x0279, code lost:
        r4.nextToken(16);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x0284, code lost:
        if (r4.token() != 13) goto L_0x0302;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x0286, code lost:
        r4.nextToken(16);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:?, code lost:
        r0 = r1.config.getDeserializer((java.lang.reflect.Type) r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x0291, code lost:
        if ((r0 instanceof com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer) == false) goto L_0x02c5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x0293, code lost:
        r0 = (com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer) r0;
        r2 = r0.createInstance(r1, (java.lang.reflect.Type) r7);
        r3 = r9.entrySet().iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x02a5, code lost:
        if (r3.hasNext() == false) goto L_0x02c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x02a7, code lost:
        r4 = (java.util.Map.Entry) r3.next();
        r8 = r4.getKey();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x02b3, code lost:
        if ((r8 instanceof java.lang.String) == false) goto L_0x02a1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x02b5, code lost:
        r8 = r0.getFieldDeserializer((java.lang.String) r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x02bb, code lost:
        if (r8 == null) goto L_0x02a1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x02bd, code lost:
        r8.setValue((java.lang.Object) r2, r4.getValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x02c5, code lost:
        r2 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x02c6, code lost:
        if (r2 != null) goto L_0x02f5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x02ca, code lost:
        if (r7 != java.lang.Cloneable.class) goto L_0x02d2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x02cc, code lost:
        r2 = new java.util.HashMap();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x02d8, code lost:
        if ("java.util.Collections$EmptyMap".equals(r6) == false) goto L_0x02df;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x02da, code lost:
        r2 = java.util.Collections.emptyMap();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x02e5, code lost:
        if ("java.util.Collections$UnmodifiableMap".equals(r6) == false) goto L_0x02f1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x02e7, code lost:
        r2 = java.util.Collections.unmodifiableMap(new java.util.HashMap());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x02f1, code lost:
        r2 = r7.newInstance();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x02f5, code lost:
        setContext(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x02f8, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x0302, code lost:
        setResolveStatus(2);
        r3 = r1.context;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x0308, code lost:
        if (r3 == null) goto L_0x0319;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x030a, code lost:
        if (r2 == null) goto L_0x0319;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:0x030e, code lost:
        if ((r2 instanceof java.lang.Integer) != false) goto L_0x0319;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x0314, code lost:
        if ((r3.fieldName instanceof java.lang.Integer) != false) goto L_0x0319;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x0316, code lost:
        popContext();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x031d, code lost:
        if (r17.size() <= 0) goto L_0x032c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x031f, code lost:
        r0 = com.alibaba.fastjson.util.TypeUtils.cast((java.lang.Object) r0, r7, r1.config);
        parseObject((java.lang.Object) r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:0x0328, code lost:
        setContext(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:182:0x032b, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:184:?, code lost:
        r0 = r1.config.getDeserializer((java.lang.reflect.Type) r7);
        r3 = r0.getClass();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:185:0x033c, code lost:
        if (com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer.class.isAssignableFrom(r3) == false) goto L_0x034b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:187:0x0340, code lost:
        if (r3 == com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer.class) goto L_0x034b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:189:0x0344, code lost:
        if (r3 == com.alibaba.fastjson.parser.deserializer.ThrowableDeserializer.class) goto L_0x034b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:190:0x0346, code lost:
        setResolveStatus(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:192:0x034d, code lost:
        if ((r0 instanceof com.alibaba.fastjson.parser.deserializer.MapDeserializer) == false) goto L_0x0353;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:193:0x034f, code lost:
        setResolveStatus(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x0353, code lost:
        r0 = r0.deserialze(r1, r7, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:195:0x0357, code lost:
        setContext(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:196:0x035a, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:210:0x0396, code lost:
        if ("@".equals(r6) == false) goto L_0x03b2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:211:0x0398, code lost:
        r0 = r1.context;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:212:0x039a, code lost:
        if (r0 == null) goto L_0x03fc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:213:0x039c, code lost:
        r2 = r0.object;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:214:0x03a0, code lost:
        if ((r2 instanceof java.lang.Object[]) != false) goto L_0x03b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:216:0x03a4, code lost:
        if ((r2 instanceof java.util.Collection) == false) goto L_0x03a7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:219:0x03a9, code lost:
        if (r0.parent == null) goto L_0x03fc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:220:0x03ab, code lost:
        r6 = r0.parent.object;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:221:0x03b0, code lost:
        r6 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:223:0x03b8, code lost:
        if ("..".equals(r6) == false) goto L_0x03cd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:225:0x03bc, code lost:
        if (r5.object == null) goto L_0x03c1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:226:0x03be, code lost:
        r6 = r5.object;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:227:0x03c1, code lost:
        addResolveTask(new com.alibaba.fastjson.parser.DefaultJSONParser.ResolveTask(r5, r6));
        setResolveStatus(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:229:0x03d3, code lost:
        if ("$".equals(r6) == false) goto L_0x03f1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:230:0x03d5, code lost:
        r0 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:232:0x03d8, code lost:
        if (r0.parent == null) goto L_0x03dd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:233:0x03da, code lost:
        r0 = r0.parent;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:235:0x03df, code lost:
        if (r0.object == null) goto L_0x03e5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:236:0x03e1, code lost:
        r6 = r0.object;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:237:0x03e5, code lost:
        addResolveTask(new com.alibaba.fastjson.parser.DefaultJSONParser.ResolveTask(r0, r6));
        setResolveStatus(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:238:0x03f1, code lost:
        addResolveTask(new com.alibaba.fastjson.parser.DefaultJSONParser.ResolveTask(r5, r6));
        setResolveStatus(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:239:0x03fc, code lost:
        r6 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:241:0x0403, code lost:
        if (r4.token() != 13) goto L_0x040e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:242:0x0405, code lost:
        r4.nextToken(16);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:243:0x040a, code lost:
        setContext(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:244:0x040d, code lost:
        return r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:247:0x0428, code lost:
        throw new com.alibaba.fastjson.JSONException("syntax error, " + r4.info());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:292:0x04db, code lost:
        if (r8 != '}') goto L_0x04ed;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:293:0x04dd, code lost:
        r4.next();
        r4.resetStringPosition();
        r4.nextToken();
        setContext(r6, r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:294:0x04e9, code lost:
        setContext(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:295:0x04ec, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:298:0x050b, code lost:
        throw new com.alibaba.fastjson.JSONException("syntax error, position at " + r4.pos() + ", name " + r13);
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x0206 A[Catch:{ Exception -> 0x02f9, NumberFormatException -> 0x019a, all -> 0x067e }] */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x021f A[Catch:{ Exception -> 0x02f9, NumberFormatException -> 0x019a, all -> 0x067e }] */
    /* JADX WARNING: Removed duplicated region for block: B:197:0x035b  */
    /* JADX WARNING: Removed duplicated region for block: B:348:0x05d1 A[Catch:{ Exception -> 0x02f9, NumberFormatException -> 0x019a, all -> 0x067e }] */
    /* JADX WARNING: Removed duplicated region for block: B:353:0x05dd A[Catch:{ Exception -> 0x02f9, NumberFormatException -> 0x019a, all -> 0x067e }] */
    /* JADX WARNING: Removed duplicated region for block: B:356:0x05e9 A[Catch:{ Exception -> 0x02f9, NumberFormatException -> 0x019a, all -> 0x067e }] */
    /* JADX WARNING: Removed duplicated region for block: B:362:0x05fe A[SYNTHETIC, Splitter:B:362:0x05fe] */
    /* JADX WARNING: Removed duplicated region for block: B:407:0x05f4 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object parseObject(java.util.Map r17, java.lang.Object r18) {
        /*
            r16 = this;
            r1 = r16
            r0 = r17
            r2 = r18
            java.lang.String r3 = "parse number key error"
            com.alibaba.fastjson.parser.JSONLexer r4 = r1.lexer
            int r5 = r4.token()
            r6 = 0
            r7 = 8
            if (r5 != r7) goto L_0x0017
            r4.nextToken()
            return r6
        L_0x0017:
            int r5 = r4.token()
            r7 = 13
            if (r5 != r7) goto L_0x0023
            r4.nextToken()
            return r0
        L_0x0023:
            int r5 = r4.token()
            r8 = 4
            if (r5 != r8) goto L_0x0038
            java.lang.String r5 = r4.stringVal()
            int r5 = r5.length()
            if (r5 != 0) goto L_0x0038
            r4.nextToken()
            return r0
        L_0x0038:
            int r5 = r4.token()
            r9 = 12
            r10 = 16
            if (r5 == r9) goto L_0x0070
            int r5 = r4.token()
            if (r5 != r10) goto L_0x0049
            goto L_0x0070
        L_0x0049:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "syntax error, expect {, actual "
            r2.append(r3)
            java.lang.String r3 = r4.tokenName()
            r2.append(r3)
            java.lang.String r3 = ", "
            r2.append(r3)
            java.lang.String r3 = r4.info()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0.<init>(r2)
            throw r0
        L_0x0070:
            com.alibaba.fastjson.parser.ParseContext r5 = r1.context
            boolean r9 = r0 instanceof com.alibaba.fastjson.JSONObject     // Catch:{ all -> 0x067e }
            if (r9 == 0) goto L_0x007e
            r9 = r0
            com.alibaba.fastjson.JSONObject r9 = (com.alibaba.fastjson.JSONObject) r9     // Catch:{ all -> 0x067e }
            java.util.Map r9 = r9.getInnerMap()     // Catch:{ all -> 0x067e }
            goto L_0x007f
        L_0x007e:
            r9 = r0
        L_0x007f:
            r12 = 0
        L_0x0080:
            r4.skipWhitespace()     // Catch:{ all -> 0x067e }
            char r13 = r4.getCurrent()     // Catch:{ all -> 0x067e }
            com.alibaba.fastjson.parser.Feature r14 = com.alibaba.fastjson.parser.Feature.AllowArbitraryCommas     // Catch:{ all -> 0x067e }
            boolean r14 = r4.isEnabled((com.alibaba.fastjson.parser.Feature) r14)     // Catch:{ all -> 0x067e }
            r15 = 44
            if (r14 == 0) goto L_0x009e
        L_0x0091:
            if (r13 != r15) goto L_0x009e
            r4.next()     // Catch:{ all -> 0x067e }
            r4.skipWhitespace()     // Catch:{ all -> 0x067e }
            char r13 = r4.getCurrent()     // Catch:{ all -> 0x067e }
            goto L_0x0091
        L_0x009e:
            r7 = 125(0x7d, float:1.75E-43)
            java.lang.String r10 = ", name "
            java.lang.String r14 = "expect ':' at "
            r11 = 58
            r8 = 34
            java.lang.String r6 = "syntax error"
            r15 = 1
            if (r13 != r8) goto L_0x00de
            com.alibaba.fastjson.parser.SymbolTable r13 = r1.symbolTable     // Catch:{ all -> 0x067e }
            java.lang.String r13 = r4.scanSymbol(r13, r8)     // Catch:{ all -> 0x067e }
            r4.skipWhitespace()     // Catch:{ all -> 0x067e }
            char r8 = r4.getCurrent()     // Catch:{ all -> 0x067e }
            if (r8 != r11) goto L_0x00bf
        L_0x00bc:
            r8 = 0
            goto L_0x0204
        L_0x00bf:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x067e }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x067e }
            r2.<init>()     // Catch:{ all -> 0x067e }
            r2.append(r14)     // Catch:{ all -> 0x067e }
            int r3 = r4.pos()     // Catch:{ all -> 0x067e }
            r2.append(r3)     // Catch:{ all -> 0x067e }
            r2.append(r10)     // Catch:{ all -> 0x067e }
            r2.append(r13)     // Catch:{ all -> 0x067e }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x067e }
            r0.<init>(r2)     // Catch:{ all -> 0x067e }
            throw r0     // Catch:{ all -> 0x067e }
        L_0x00de:
            if (r13 != r7) goto L_0x0107
            r4.next()     // Catch:{ all -> 0x067e }
            r4.resetStringPosition()     // Catch:{ all -> 0x067e }
            r4.nextToken()     // Catch:{ all -> 0x067e }
            if (r12 != 0) goto L_0x0103
            com.alibaba.fastjson.parser.ParseContext r3 = r1.context     // Catch:{ all -> 0x067e }
            if (r3 == 0) goto L_0x00fc
            java.lang.Object r3 = r3.fieldName     // Catch:{ all -> 0x067e }
            if (r2 != r3) goto L_0x00fc
            com.alibaba.fastjson.parser.ParseContext r3 = r1.context     // Catch:{ all -> 0x067e }
            java.lang.Object r3 = r3.object     // Catch:{ all -> 0x067e }
            if (r0 != r3) goto L_0x00fc
            com.alibaba.fastjson.parser.ParseContext r5 = r1.context     // Catch:{ all -> 0x067e }
            goto L_0x0103
        L_0x00fc:
            com.alibaba.fastjson.parser.ParseContext r2 = r16.setContext(r17, r18)     // Catch:{ all -> 0x067e }
            if (r5 != 0) goto L_0x0103
            r5 = r2
        L_0x0103:
            r1.setContext(r5)
            return r0
        L_0x0107:
            r8 = 39
            if (r13 != r8) goto L_0x0142
            com.alibaba.fastjson.parser.Feature r13 = com.alibaba.fastjson.parser.Feature.AllowSingleQuotes     // Catch:{ all -> 0x067e }
            boolean r13 = r4.isEnabled((com.alibaba.fastjson.parser.Feature) r13)     // Catch:{ all -> 0x067e }
            if (r13 == 0) goto L_0x013c
            com.alibaba.fastjson.parser.SymbolTable r13 = r1.symbolTable     // Catch:{ all -> 0x067e }
            java.lang.String r13 = r4.scanSymbol(r13, r8)     // Catch:{ all -> 0x067e }
            r4.skipWhitespace()     // Catch:{ all -> 0x067e }
            char r8 = r4.getCurrent()     // Catch:{ all -> 0x067e }
            if (r8 != r11) goto L_0x0123
            goto L_0x00bc
        L_0x0123:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x067e }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x067e }
            r2.<init>()     // Catch:{ all -> 0x067e }
            r2.append(r14)     // Catch:{ all -> 0x067e }
            int r3 = r4.pos()     // Catch:{ all -> 0x067e }
            r2.append(r3)     // Catch:{ all -> 0x067e }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x067e }
            r0.<init>(r2)     // Catch:{ all -> 0x067e }
            throw r0     // Catch:{ all -> 0x067e }
        L_0x013c:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x067e }
            r0.<init>(r6)     // Catch:{ all -> 0x067e }
            throw r0     // Catch:{ all -> 0x067e }
        L_0x0142:
            r8 = 26
            if (r13 == r8) goto L_0x0678
            r8 = 44
            if (r13 == r8) goto L_0x0672
            r8 = 48
            if (r13 < r8) goto L_0x0152
            r8 = 57
            if (r13 <= r8) goto L_0x0156
        L_0x0152:
            r8 = 45
            if (r13 != r8) goto L_0x01b3
        L_0x0156:
            r4.resetStringPosition()     // Catch:{ all -> 0x067e }
            r4.scanNumber()     // Catch:{ all -> 0x067e }
            int r8 = r4.token()     // Catch:{ NumberFormatException -> 0x019a }
            r13 = 2
            if (r8 != r13) goto L_0x0168
            java.lang.Number r8 = r4.integerValue()     // Catch:{ NumberFormatException -> 0x019a }
            goto L_0x016c
        L_0x0168:
            java.lang.Number r8 = r4.decimalValue(r15)     // Catch:{ NumberFormatException -> 0x019a }
        L_0x016c:
            com.alibaba.fastjson.parser.Feature r13 = com.alibaba.fastjson.parser.Feature.NonStringKeyAsString     // Catch:{ NumberFormatException -> 0x019a }
            boolean r13 = r4.isEnabled((com.alibaba.fastjson.parser.Feature) r13)     // Catch:{ NumberFormatException -> 0x019a }
            if (r13 == 0) goto L_0x0178
            java.lang.String r8 = r8.toString()     // Catch:{ NumberFormatException -> 0x019a }
        L_0x0178:
            r13 = r8
            char r8 = r4.getCurrent()     // Catch:{ all -> 0x067e }
            if (r8 != r11) goto L_0x0181
            goto L_0x00bc
        L_0x0181:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x067e }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x067e }
            r2.<init>()     // Catch:{ all -> 0x067e }
            r2.append(r3)     // Catch:{ all -> 0x067e }
            java.lang.String r3 = r4.info()     // Catch:{ all -> 0x067e }
            r2.append(r3)     // Catch:{ all -> 0x067e }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x067e }
            r0.<init>(r2)     // Catch:{ all -> 0x067e }
            throw r0     // Catch:{ all -> 0x067e }
        L_0x019a:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x067e }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x067e }
            r2.<init>()     // Catch:{ all -> 0x067e }
            r2.append(r3)     // Catch:{ all -> 0x067e }
            java.lang.String r3 = r4.info()     // Catch:{ all -> 0x067e }
            r2.append(r3)     // Catch:{ all -> 0x067e }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x067e }
            r0.<init>(r2)     // Catch:{ all -> 0x067e }
            throw r0     // Catch:{ all -> 0x067e }
        L_0x01b3:
            r8 = 123(0x7b, float:1.72E-43)
            if (r13 == r8) goto L_0x01fc
            r8 = 91
            if (r13 != r8) goto L_0x01bc
            goto L_0x01fc
        L_0x01bc:
            com.alibaba.fastjson.parser.Feature r8 = com.alibaba.fastjson.parser.Feature.AllowUnQuotedFieldNames     // Catch:{ all -> 0x067e }
            boolean r8 = r4.isEnabled((com.alibaba.fastjson.parser.Feature) r8)     // Catch:{ all -> 0x067e }
            if (r8 == 0) goto L_0x01f6
            com.alibaba.fastjson.parser.SymbolTable r8 = r1.symbolTable     // Catch:{ all -> 0x067e }
            java.lang.String r13 = r4.scanSymbolUnQuoted(r8)     // Catch:{ all -> 0x067e }
            r4.skipWhitespace()     // Catch:{ all -> 0x067e }
            char r8 = r4.getCurrent()     // Catch:{ all -> 0x067e }
            if (r8 != r11) goto L_0x01d5
            goto L_0x00bc
        L_0x01d5:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x067e }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x067e }
            r2.<init>()     // Catch:{ all -> 0x067e }
            r2.append(r14)     // Catch:{ all -> 0x067e }
            int r3 = r4.pos()     // Catch:{ all -> 0x067e }
            r2.append(r3)     // Catch:{ all -> 0x067e }
            java.lang.String r3 = ", actual "
            r2.append(r3)     // Catch:{ all -> 0x067e }
            r2.append(r8)     // Catch:{ all -> 0x067e }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x067e }
            r0.<init>(r2)     // Catch:{ all -> 0x067e }
            throw r0     // Catch:{ all -> 0x067e }
        L_0x01f6:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x067e }
            r0.<init>(r6)     // Catch:{ all -> 0x067e }
            throw r0     // Catch:{ all -> 0x067e }
        L_0x01fc:
            r4.nextToken()     // Catch:{ all -> 0x067e }
            java.lang.Object r13 = r16.parse()     // Catch:{ all -> 0x067e }
            r8 = r15
        L_0x0204:
            if (r8 != 0) goto L_0x020c
            r4.next()     // Catch:{ all -> 0x067e }
            r4.skipWhitespace()     // Catch:{ all -> 0x067e }
        L_0x020c:
            char r8 = r4.getCurrent()     // Catch:{ all -> 0x067e }
            r4.resetStringPosition()     // Catch:{ all -> 0x067e }
            java.lang.String r11 = com.alibaba.fastjson.JSON.DEFAULT_TYPE_KEY     // Catch:{ all -> 0x067e }
            if (r13 != r11) goto L_0x035b
            com.alibaba.fastjson.parser.Feature r11 = com.alibaba.fastjson.parser.Feature.DisableSpecialKeyDetect     // Catch:{ all -> 0x067e }
            boolean r11 = r4.isEnabled((com.alibaba.fastjson.parser.Feature) r11)     // Catch:{ all -> 0x067e }
            if (r11 != 0) goto L_0x035b
            com.alibaba.fastjson.parser.SymbolTable r6 = r1.symbolTable     // Catch:{ all -> 0x067e }
            r7 = 34
            java.lang.String r6 = r4.scanSymbol(r6, r7)     // Catch:{ all -> 0x067e }
            com.alibaba.fastjson.parser.Feature r7 = com.alibaba.fastjson.parser.Feature.IgnoreAutoType     // Catch:{ all -> 0x067e }
            boolean r7 = r4.isEnabled((com.alibaba.fastjson.parser.Feature) r7)     // Catch:{ all -> 0x067e }
            if (r7 == 0) goto L_0x0233
        L_0x022f:
            r11 = 4
            r14 = 0
            goto L_0x0388
        L_0x0233:
            if (r0 == 0) goto L_0x0249
            java.lang.Class r7 = r17.getClass()     // Catch:{ all -> 0x067e }
            java.lang.String r7 = r7.getName()     // Catch:{ all -> 0x067e }
            boolean r7 = r7.equals(r6)     // Catch:{ all -> 0x067e }
            if (r7 == 0) goto L_0x0249
            java.lang.Class r7 = r17.getClass()     // Catch:{ all -> 0x067e }
            r11 = 0
            goto L_0x0271
        L_0x0249:
            r7 = 0
        L_0x024a:
            int r8 = r6.length()     // Catch:{ all -> 0x067e }
            if (r7 >= r8) goto L_0x0261
            char r8 = r6.charAt(r7)     // Catch:{ all -> 0x067e }
            r10 = 48
            if (r8 < r10) goto L_0x0260
            r10 = 57
            if (r8 <= r10) goto L_0x025d
            goto L_0x0260
        L_0x025d:
            int r7 = r7 + 1
            goto L_0x024a
        L_0x0260:
            r15 = 0
        L_0x0261:
            if (r15 != 0) goto L_0x026f
            com.alibaba.fastjson.parser.ParserConfig r7 = r1.config     // Catch:{ all -> 0x067e }
            int r8 = r4.getFeatures()     // Catch:{ all -> 0x067e }
            r11 = 0
            java.lang.Class r7 = r7.checkAutoType(r6, r11, r8)     // Catch:{ all -> 0x067e }
            goto L_0x0271
        L_0x026f:
            r11 = 0
            r7 = r11
        L_0x0271:
            if (r7 != 0) goto L_0x0279
            java.lang.String r7 = com.alibaba.fastjson.JSON.DEFAULT_TYPE_KEY     // Catch:{ all -> 0x067e }
            r9.put(r7, r6)     // Catch:{ all -> 0x067e }
            goto L_0x022f
        L_0x0279:
            r3 = 16
            r4.nextToken(r3)     // Catch:{ all -> 0x067e }
            int r8 = r4.token()     // Catch:{ all -> 0x067e }
            r10 = 13
            if (r8 != r10) goto L_0x0302
            r4.nextToken(r3)     // Catch:{ all -> 0x067e }
            com.alibaba.fastjson.parser.ParserConfig r0 = r1.config     // Catch:{ Exception -> 0x02f9 }
            com.alibaba.fastjson.parser.deserializer.ObjectDeserializer r0 = r0.getDeserializer((java.lang.reflect.Type) r7)     // Catch:{ Exception -> 0x02f9 }
            boolean r2 = r0 instanceof com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer     // Catch:{ Exception -> 0x02f9 }
            if (r2 == 0) goto L_0x02c5
            com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer r0 = (com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer) r0     // Catch:{ Exception -> 0x02f9 }
            java.lang.Object r2 = r0.createInstance((com.alibaba.fastjson.parser.DefaultJSONParser) r1, (java.lang.reflect.Type) r7)     // Catch:{ Exception -> 0x02f9 }
            java.util.Set r3 = r9.entrySet()     // Catch:{ Exception -> 0x02f9 }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ Exception -> 0x02f9 }
        L_0x02a1:
            boolean r4 = r3.hasNext()     // Catch:{ Exception -> 0x02f9 }
            if (r4 == 0) goto L_0x02c6
            java.lang.Object r4 = r3.next()     // Catch:{ Exception -> 0x02f9 }
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4     // Catch:{ Exception -> 0x02f9 }
            java.lang.Object r8 = r4.getKey()     // Catch:{ Exception -> 0x02f9 }
            boolean r9 = r8 instanceof java.lang.String     // Catch:{ Exception -> 0x02f9 }
            if (r9 == 0) goto L_0x02a1
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ Exception -> 0x02f9 }
            com.alibaba.fastjson.parser.deserializer.FieldDeserializer r8 = r0.getFieldDeserializer((java.lang.String) r8)     // Catch:{ Exception -> 0x02f9 }
            if (r8 == 0) goto L_0x02a1
            java.lang.Object r4 = r4.getValue()     // Catch:{ Exception -> 0x02f9 }
            r8.setValue((java.lang.Object) r2, (java.lang.Object) r4)     // Catch:{ Exception -> 0x02f9 }
            goto L_0x02a1
        L_0x02c5:
            r2 = r11
        L_0x02c6:
            if (r2 != 0) goto L_0x02f5
            java.lang.Class<java.lang.Cloneable> r0 = java.lang.Cloneable.class
            if (r7 != r0) goto L_0x02d2
            java.util.HashMap r2 = new java.util.HashMap     // Catch:{ Exception -> 0x02f9 }
            r2.<init>()     // Catch:{ Exception -> 0x02f9 }
            goto L_0x02f5
        L_0x02d2:
            java.lang.String r0 = "java.util.Collections$EmptyMap"
            boolean r0 = r0.equals(r6)     // Catch:{ Exception -> 0x02f9 }
            if (r0 == 0) goto L_0x02df
            java.util.Map r2 = java.util.Collections.emptyMap()     // Catch:{ Exception -> 0x02f9 }
            goto L_0x02f5
        L_0x02df:
            java.lang.String r0 = "java.util.Collections$UnmodifiableMap"
            boolean r0 = r0.equals(r6)     // Catch:{ Exception -> 0x02f9 }
            if (r0 == 0) goto L_0x02f1
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ Exception -> 0x02f9 }
            r0.<init>()     // Catch:{ Exception -> 0x02f9 }
            java.util.Map r2 = java.util.Collections.unmodifiableMap(r0)     // Catch:{ Exception -> 0x02f9 }
            goto L_0x02f5
        L_0x02f1:
            java.lang.Object r2 = r7.newInstance()     // Catch:{ Exception -> 0x02f9 }
        L_0x02f5:
            r1.setContext(r5)
            return r2
        L_0x02f9:
            r0 = move-exception
            com.alibaba.fastjson.JSONException r2 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x067e }
            java.lang.String r3 = "create instance error"
            r2.<init>(r3, r0)     // Catch:{ all -> 0x067e }
            throw r2     // Catch:{ all -> 0x067e }
        L_0x0302:
            r3 = 2
            r1.setResolveStatus(r3)     // Catch:{ all -> 0x067e }
            com.alibaba.fastjson.parser.ParseContext r3 = r1.context     // Catch:{ all -> 0x067e }
            if (r3 == 0) goto L_0x0319
            if (r2 == 0) goto L_0x0319
            boolean r4 = r2 instanceof java.lang.Integer     // Catch:{ all -> 0x067e }
            if (r4 != 0) goto L_0x0319
            java.lang.Object r3 = r3.fieldName     // Catch:{ all -> 0x067e }
            boolean r3 = r3 instanceof java.lang.Integer     // Catch:{ all -> 0x067e }
            if (r3 != 0) goto L_0x0319
            r16.popContext()     // Catch:{ all -> 0x067e }
        L_0x0319:
            int r3 = r17.size()     // Catch:{ all -> 0x067e }
            if (r3 <= 0) goto L_0x032c
            com.alibaba.fastjson.parser.ParserConfig r2 = r1.config     // Catch:{ all -> 0x067e }
            java.lang.Object r0 = com.alibaba.fastjson.util.TypeUtils.cast((java.lang.Object) r0, r7, (com.alibaba.fastjson.parser.ParserConfig) r2)     // Catch:{ all -> 0x067e }
            r1.parseObject((java.lang.Object) r0)     // Catch:{ all -> 0x067e }
            r1.setContext(r5)
            return r0
        L_0x032c:
            com.alibaba.fastjson.parser.ParserConfig r0 = r1.config     // Catch:{ all -> 0x067e }
            com.alibaba.fastjson.parser.deserializer.ObjectDeserializer r0 = r0.getDeserializer((java.lang.reflect.Type) r7)     // Catch:{ all -> 0x067e }
            java.lang.Class r3 = r0.getClass()     // Catch:{ all -> 0x067e }
            java.lang.Class<com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer> r4 = com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer.class
            boolean r4 = r4.isAssignableFrom(r3)     // Catch:{ all -> 0x067e }
            if (r4 == 0) goto L_0x034b
            java.lang.Class<com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer> r4 = com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer.class
            if (r3 == r4) goto L_0x034b
            java.lang.Class<com.alibaba.fastjson.parser.deserializer.ThrowableDeserializer> r4 = com.alibaba.fastjson.parser.deserializer.ThrowableDeserializer.class
            if (r3 == r4) goto L_0x034b
            r3 = 0
            r1.setResolveStatus(r3)     // Catch:{ all -> 0x067e }
            goto L_0x0353
        L_0x034b:
            boolean r3 = r0 instanceof com.alibaba.fastjson.parser.deserializer.MapDeserializer     // Catch:{ all -> 0x067e }
            if (r3 == 0) goto L_0x0353
            r14 = 0
            r1.setResolveStatus(r14)     // Catch:{ all -> 0x067e }
        L_0x0353:
            java.lang.Object r0 = r0.deserialze(r1, r7, r2)     // Catch:{ all -> 0x067e }
            r1.setContext(r5)
            return r0
        L_0x035b:
            r14 = 0
            java.lang.String r11 = "$ref"
            if (r13 != r11) goto L_0x0448
            if (r5 == 0) goto L_0x0448
            com.alibaba.fastjson.parser.Feature r11 = com.alibaba.fastjson.parser.Feature.DisableSpecialKeyDetect     // Catch:{ all -> 0x067e }
            boolean r11 = r4.isEnabled((com.alibaba.fastjson.parser.Feature) r11)     // Catch:{ all -> 0x067e }
            if (r11 != 0) goto L_0x0448
            r11 = 4
            r4.nextToken(r11)     // Catch:{ all -> 0x067e }
            int r6 = r4.token()     // Catch:{ all -> 0x067e }
            if (r6 != r11) goto L_0x0429
            java.lang.String r6 = r4.stringVal()     // Catch:{ all -> 0x067e }
            r7 = 13
            r4.nextToken(r7)     // Catch:{ all -> 0x067e }
            int r7 = r4.token()     // Catch:{ all -> 0x067e }
            r8 = 16
            if (r7 != r8) goto L_0x0390
            r9.put(r13, r6)     // Catch:{ all -> 0x067e }
        L_0x0388:
            r8 = r11
            r6 = 0
            r7 = 13
            r10 = 16
            goto L_0x0080
        L_0x0390:
            java.lang.String r0 = "@"
            boolean r0 = r0.equals(r6)     // Catch:{ all -> 0x067e }
            if (r0 == 0) goto L_0x03b2
            com.alibaba.fastjson.parser.ParseContext r0 = r1.context     // Catch:{ all -> 0x067e }
            if (r0 == 0) goto L_0x03fc
            java.lang.Object r2 = r0.object     // Catch:{ all -> 0x067e }
            boolean r3 = r2 instanceof java.lang.Object[]     // Catch:{ all -> 0x067e }
            if (r3 != 0) goto L_0x03b0
            boolean r3 = r2 instanceof java.util.Collection     // Catch:{ all -> 0x067e }
            if (r3 == 0) goto L_0x03a7
            goto L_0x03b0
        L_0x03a7:
            com.alibaba.fastjson.parser.ParseContext r2 = r0.parent     // Catch:{ all -> 0x067e }
            if (r2 == 0) goto L_0x03fc
            com.alibaba.fastjson.parser.ParseContext r0 = r0.parent     // Catch:{ all -> 0x067e }
            java.lang.Object r6 = r0.object     // Catch:{ all -> 0x067e }
            goto L_0x03fd
        L_0x03b0:
            r6 = r2
            goto L_0x03fd
        L_0x03b2:
            java.lang.String r0 = ".."
            boolean r0 = r0.equals(r6)     // Catch:{ all -> 0x067e }
            if (r0 == 0) goto L_0x03cd
            java.lang.Object r0 = r5.object     // Catch:{ all -> 0x067e }
            if (r0 == 0) goto L_0x03c1
            java.lang.Object r6 = r5.object     // Catch:{ all -> 0x067e }
            goto L_0x03fd
        L_0x03c1:
            com.alibaba.fastjson.parser.DefaultJSONParser$ResolveTask r0 = new com.alibaba.fastjson.parser.DefaultJSONParser$ResolveTask     // Catch:{ all -> 0x067e }
            r0.<init>(r5, r6)     // Catch:{ all -> 0x067e }
            r1.addResolveTask(r0)     // Catch:{ all -> 0x067e }
            r1.setResolveStatus(r15)     // Catch:{ all -> 0x067e }
            goto L_0x03fc
        L_0x03cd:
            java.lang.String r0 = "$"
            boolean r0 = r0.equals(r6)     // Catch:{ all -> 0x067e }
            if (r0 == 0) goto L_0x03f1
            r0 = r5
        L_0x03d6:
            com.alibaba.fastjson.parser.ParseContext r2 = r0.parent     // Catch:{ all -> 0x067e }
            if (r2 == 0) goto L_0x03dd
            com.alibaba.fastjson.parser.ParseContext r0 = r0.parent     // Catch:{ all -> 0x067e }
            goto L_0x03d6
        L_0x03dd:
            java.lang.Object r2 = r0.object     // Catch:{ all -> 0x067e }
            if (r2 == 0) goto L_0x03e5
            java.lang.Object r0 = r0.object     // Catch:{ all -> 0x067e }
            r6 = r0
            goto L_0x03fd
        L_0x03e5:
            com.alibaba.fastjson.parser.DefaultJSONParser$ResolveTask r2 = new com.alibaba.fastjson.parser.DefaultJSONParser$ResolveTask     // Catch:{ all -> 0x067e }
            r2.<init>(r0, r6)     // Catch:{ all -> 0x067e }
            r1.addResolveTask(r2)     // Catch:{ all -> 0x067e }
            r1.setResolveStatus(r15)     // Catch:{ all -> 0x067e }
            goto L_0x03fc
        L_0x03f1:
            com.alibaba.fastjson.parser.DefaultJSONParser$ResolveTask r0 = new com.alibaba.fastjson.parser.DefaultJSONParser$ResolveTask     // Catch:{ all -> 0x067e }
            r0.<init>(r5, r6)     // Catch:{ all -> 0x067e }
            r1.addResolveTask(r0)     // Catch:{ all -> 0x067e }
            r1.setResolveStatus(r15)     // Catch:{ all -> 0x067e }
        L_0x03fc:
            r6 = 0
        L_0x03fd:
            int r0 = r4.token()     // Catch:{ all -> 0x067e }
            r2 = 13
            if (r0 != r2) goto L_0x040e
            r0 = 16
            r4.nextToken(r0)     // Catch:{ all -> 0x067e }
            r1.setContext(r5)
            return r6
        L_0x040e:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x067e }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x067e }
            r2.<init>()     // Catch:{ all -> 0x067e }
            java.lang.String r3 = "syntax error, "
            r2.append(r3)     // Catch:{ all -> 0x067e }
            java.lang.String r3 = r4.info()     // Catch:{ all -> 0x067e }
            r2.append(r3)     // Catch:{ all -> 0x067e }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x067e }
            r0.<init>(r2)     // Catch:{ all -> 0x067e }
            throw r0     // Catch:{ all -> 0x067e }
        L_0x0429:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x067e }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x067e }
            r2.<init>()     // Catch:{ all -> 0x067e }
            java.lang.String r3 = "illegal ref, "
            r2.append(r3)     // Catch:{ all -> 0x067e }
            int r3 = r4.token()     // Catch:{ all -> 0x067e }
            java.lang.String r3 = com.alibaba.fastjson.parser.JSONToken.name(r3)     // Catch:{ all -> 0x067e }
            r2.append(r3)     // Catch:{ all -> 0x067e }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x067e }
            r0.<init>(r2)     // Catch:{ all -> 0x067e }
            throw r0     // Catch:{ all -> 0x067e }
        L_0x0448:
            r11 = 4
            if (r12 != 0) goto L_0x0464
            com.alibaba.fastjson.parser.ParseContext r11 = r1.context     // Catch:{ all -> 0x067e }
            if (r11 == 0) goto L_0x045c
            java.lang.Object r11 = r11.fieldName     // Catch:{ all -> 0x067e }
            if (r2 != r11) goto L_0x045c
            com.alibaba.fastjson.parser.ParseContext r11 = r1.context     // Catch:{ all -> 0x067e }
            java.lang.Object r11 = r11.object     // Catch:{ all -> 0x067e }
            if (r0 != r11) goto L_0x045c
            com.alibaba.fastjson.parser.ParseContext r5 = r1.context     // Catch:{ all -> 0x067e }
            goto L_0x0464
        L_0x045c:
            com.alibaba.fastjson.parser.ParseContext r11 = r16.setContext(r17, r18)     // Catch:{ all -> 0x067e }
            if (r5 != 0) goto L_0x0463
            r5 = r11
        L_0x0463:
            r12 = r15
        L_0x0464:
            java.lang.Class r11 = r17.getClass()     // Catch:{ all -> 0x067e }
            java.lang.Class<com.alibaba.fastjson.JSONObject> r14 = com.alibaba.fastjson.JSONObject.class
            if (r11 != r14) goto L_0x0470
            if (r13 != 0) goto L_0x0470
            java.lang.String r13 = "null"
        L_0x0470:
            java.lang.String r11 = "syntax error, position at "
            r14 = 34
            if (r8 != r14) goto L_0x049f
            r4.scanString()     // Catch:{ all -> 0x067e }
            java.lang.String r6 = r4.stringVal()     // Catch:{ all -> 0x067e }
            com.alibaba.fastjson.parser.Feature r8 = com.alibaba.fastjson.parser.Feature.AllowISO8601DateFormat     // Catch:{ all -> 0x067e }
            boolean r8 = r4.isEnabled((com.alibaba.fastjson.parser.Feature) r8)     // Catch:{ all -> 0x067e }
            if (r8 == 0) goto L_0x049b
            com.alibaba.fastjson.parser.JSONScanner r8 = new com.alibaba.fastjson.parser.JSONScanner     // Catch:{ all -> 0x067e }
            r8.<init>(r6)     // Catch:{ all -> 0x067e }
            boolean r14 = r8.scanISO8601DateIfMatch()     // Catch:{ all -> 0x067e }
            if (r14 == 0) goto L_0x0498
            java.util.Calendar r6 = r8.getCalendar()     // Catch:{ all -> 0x067e }
            java.util.Date r6 = r6.getTime()     // Catch:{ all -> 0x067e }
        L_0x0498:
            r8.close()     // Catch:{ all -> 0x067e }
        L_0x049b:
            r9.put(r13, r6)     // Catch:{ all -> 0x067e }
            goto L_0x04c7
        L_0x049f:
            r14 = 48
            if (r8 < r14) goto L_0x04a7
            r14 = 57
            if (r8 <= r14) goto L_0x04ab
        L_0x04a7:
            r14 = 45
            if (r8 != r14) goto L_0x050c
        L_0x04ab:
            r4.scanNumber()     // Catch:{ all -> 0x067e }
            int r6 = r4.token()     // Catch:{ all -> 0x067e }
            r8 = 2
            if (r6 != r8) goto L_0x04ba
            java.lang.Number r6 = r4.integerValue()     // Catch:{ all -> 0x067e }
            goto L_0x04c4
        L_0x04ba:
            com.alibaba.fastjson.parser.Feature r6 = com.alibaba.fastjson.parser.Feature.UseBigDecimal     // Catch:{ all -> 0x067e }
            boolean r6 = r4.isEnabled((com.alibaba.fastjson.parser.Feature) r6)     // Catch:{ all -> 0x067e }
            java.lang.Number r6 = r4.decimalValue(r6)     // Catch:{ all -> 0x067e }
        L_0x04c4:
            r9.put(r13, r6)     // Catch:{ all -> 0x067e }
        L_0x04c7:
            r4.skipWhitespace()     // Catch:{ all -> 0x067e }
            char r8 = r4.getCurrent()     // Catch:{ all -> 0x067e }
            r14 = 44
            if (r8 != r14) goto L_0x04db
            r4.next()     // Catch:{ all -> 0x067e }
        L_0x04d5:
            r7 = 13
            r8 = 16
            goto L_0x064e
        L_0x04db:
            if (r8 != r7) goto L_0x04ed
            r4.next()     // Catch:{ all -> 0x067e }
            r4.resetStringPosition()     // Catch:{ all -> 0x067e }
            r4.nextToken()     // Catch:{ all -> 0x067e }
            r1.setContext(r6, r13)     // Catch:{ all -> 0x067e }
            r1.setContext(r5)
            return r0
        L_0x04ed:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x067e }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x067e }
            r2.<init>()     // Catch:{ all -> 0x067e }
            r2.append(r11)     // Catch:{ all -> 0x067e }
            int r3 = r4.pos()     // Catch:{ all -> 0x067e }
            r2.append(r3)     // Catch:{ all -> 0x067e }
            r2.append(r10)     // Catch:{ all -> 0x067e }
            r2.append(r13)     // Catch:{ all -> 0x067e }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x067e }
            r0.<init>(r2)     // Catch:{ all -> 0x067e }
            throw r0     // Catch:{ all -> 0x067e }
        L_0x050c:
            r7 = 91
            if (r8 != r7) goto L_0x0558
            r4.nextToken()     // Catch:{ all -> 0x067e }
            com.alibaba.fastjson.JSONArray r7 = new com.alibaba.fastjson.JSONArray     // Catch:{ all -> 0x067e }
            r7.<init>()     // Catch:{ all -> 0x067e }
            if (r2 == 0) goto L_0x0520
            java.lang.Class r8 = r18.getClass()     // Catch:{ all -> 0x067e }
            java.lang.Class<java.lang.Integer> r10 = java.lang.Integer.class
        L_0x0520:
            if (r2 != 0) goto L_0x0525
            r1.setContext(r5)     // Catch:{ all -> 0x067e }
        L_0x0525:
            r1.parseArray((java.util.Collection) r7, (java.lang.Object) r13)     // Catch:{ all -> 0x067e }
            com.alibaba.fastjson.parser.Feature r8 = com.alibaba.fastjson.parser.Feature.UseObjectArray     // Catch:{ all -> 0x067e }
            boolean r8 = r4.isEnabled((com.alibaba.fastjson.parser.Feature) r8)     // Catch:{ all -> 0x067e }
            if (r8 == 0) goto L_0x0534
            java.lang.Object[] r7 = r7.toArray()     // Catch:{ all -> 0x067e }
        L_0x0534:
            r9.put(r13, r7)     // Catch:{ all -> 0x067e }
            int r7 = r4.token()     // Catch:{ all -> 0x067e }
            r8 = 13
            if (r7 != r8) goto L_0x0546
            r4.nextToken()     // Catch:{ all -> 0x067e }
            r1.setContext(r5)
            return r0
        L_0x0546:
            int r7 = r4.token()     // Catch:{ all -> 0x067e }
            r8 = 16
            if (r7 != r8) goto L_0x0552
            r7 = 13
            goto L_0x064e
        L_0x0552:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x067e }
            r0.<init>(r6)     // Catch:{ all -> 0x067e }
            throw r0     // Catch:{ all -> 0x067e }
        L_0x0558:
            r6 = 123(0x7b, float:1.72E-43)
            if (r8 != r6) goto L_0x062d
            r4.nextToken()     // Catch:{ all -> 0x067e }
            if (r2 == 0) goto L_0x056b
            java.lang.Class r6 = r18.getClass()     // Catch:{ all -> 0x067e }
            java.lang.Class<java.lang.Integer> r7 = java.lang.Integer.class
            if (r6 != r7) goto L_0x056b
            r6 = r15
            goto L_0x056c
        L_0x056b:
            r6 = 0
        L_0x056c:
            com.alibaba.fastjson.parser.Feature r7 = com.alibaba.fastjson.parser.Feature.CustomMapDeserializer     // Catch:{ all -> 0x067e }
            boolean r7 = r4.isEnabled((com.alibaba.fastjson.parser.Feature) r7)     // Catch:{ all -> 0x067e }
            if (r7 == 0) goto L_0x059b
            com.alibaba.fastjson.parser.ParserConfig r7 = r1.config     // Catch:{ all -> 0x067e }
            java.lang.Class<java.util.Map> r8 = java.util.Map.class
            com.alibaba.fastjson.parser.deserializer.ObjectDeserializer r7 = r7.getDeserializer((java.lang.reflect.Type) r8)     // Catch:{ all -> 0x067e }
            com.alibaba.fastjson.parser.deserializer.MapDeserializer r7 = (com.alibaba.fastjson.parser.deserializer.MapDeserializer) r7     // Catch:{ all -> 0x067e }
            int r8 = r4.getFeatures()     // Catch:{ all -> 0x067e }
            com.alibaba.fastjson.parser.Feature r10 = com.alibaba.fastjson.parser.Feature.OrderedField     // Catch:{ all -> 0x067e }
            int r10 = r10.mask     // Catch:{ all -> 0x067e }
            r8 = r8 & r10
            if (r8 == 0) goto L_0x0594
            java.lang.Class<java.util.Map> r8 = java.util.Map.class
            int r10 = r4.getFeatures()     // Catch:{ all -> 0x067e }
            java.util.Map r7 = r7.createMap(r8, r10)     // Catch:{ all -> 0x067e }
            goto L_0x05a6
        L_0x0594:
            java.lang.Class<java.util.Map> r8 = java.util.Map.class
            java.util.Map r7 = r7.createMap(r8)     // Catch:{ all -> 0x067e }
            goto L_0x05a6
        L_0x059b:
            com.alibaba.fastjson.JSONObject r7 = new com.alibaba.fastjson.JSONObject     // Catch:{ all -> 0x067e }
            com.alibaba.fastjson.parser.Feature r8 = com.alibaba.fastjson.parser.Feature.OrderedField     // Catch:{ all -> 0x067e }
            boolean r8 = r4.isEnabled((com.alibaba.fastjson.parser.Feature) r8)     // Catch:{ all -> 0x067e }
            r7.<init>((boolean) r8)     // Catch:{ all -> 0x067e }
        L_0x05a6:
            if (r6 != 0) goto L_0x05ad
            com.alibaba.fastjson.parser.ParseContext r8 = r1.setContext(r5, r7, r13)     // Catch:{ all -> 0x067e }
            goto L_0x05ae
        L_0x05ad:
            r8 = 0
        L_0x05ae:
            com.alibaba.fastjson.parser.deserializer.FieldTypeResolver r10 = r1.fieldTypeResolver     // Catch:{ all -> 0x067e }
            if (r10 == 0) goto L_0x05cd
            if (r13 == 0) goto L_0x05b9
            java.lang.String r10 = r13.toString()     // Catch:{ all -> 0x067e }
            goto L_0x05ba
        L_0x05b9:
            r10 = 0
        L_0x05ba:
            com.alibaba.fastjson.parser.deserializer.FieldTypeResolver r11 = r1.fieldTypeResolver     // Catch:{ all -> 0x067e }
            java.lang.reflect.Type r10 = r11.resolve(r0, r10)     // Catch:{ all -> 0x067e }
            if (r10 == 0) goto L_0x05cd
            com.alibaba.fastjson.parser.ParserConfig r11 = r1.config     // Catch:{ all -> 0x067e }
            com.alibaba.fastjson.parser.deserializer.ObjectDeserializer r11 = r11.getDeserializer((java.lang.reflect.Type) r10)     // Catch:{ all -> 0x067e }
            java.lang.Object r10 = r11.deserialze(r1, r10, r13)     // Catch:{ all -> 0x067e }
            goto L_0x05cf
        L_0x05cd:
            r10 = 0
            r15 = 0
        L_0x05cf:
            if (r15 != 0) goto L_0x05d5
            java.lang.Object r10 = r1.parseObject((java.util.Map) r7, (java.lang.Object) r13)     // Catch:{ all -> 0x067e }
        L_0x05d5:
            if (r8 == 0) goto L_0x05db
            if (r7 == r10) goto L_0x05db
            r8.object = r0     // Catch:{ all -> 0x067e }
        L_0x05db:
            if (r13 == 0) goto L_0x05e4
            java.lang.String r7 = r13.toString()     // Catch:{ all -> 0x067e }
            r1.checkMapResolve(r0, r7)     // Catch:{ all -> 0x067e }
        L_0x05e4:
            r9.put(r13, r10)     // Catch:{ all -> 0x067e }
            if (r6 == 0) goto L_0x05ec
            r1.setContext(r10, r13)     // Catch:{ all -> 0x067e }
        L_0x05ec:
            int r7 = r4.token()     // Catch:{ all -> 0x067e }
            r8 = 13
            if (r7 != r8) goto L_0x05fe
            r4.nextToken()     // Catch:{ all -> 0x067e }
            r1.setContext(r5)     // Catch:{ all -> 0x067e }
            r1.setContext(r5)
            return r0
        L_0x05fe:
            int r7 = r4.token()     // Catch:{ all -> 0x067e }
            r8 = 16
            if (r7 != r8) goto L_0x0612
            if (r6 == 0) goto L_0x060d
            r16.popContext()     // Catch:{ all -> 0x067e }
            goto L_0x04d5
        L_0x060d:
            r1.setContext(r5)     // Catch:{ all -> 0x067e }
            goto L_0x04d5
        L_0x0612:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x067e }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x067e }
            r2.<init>()     // Catch:{ all -> 0x067e }
            java.lang.String r3 = "syntax error, "
            r2.append(r3)     // Catch:{ all -> 0x067e }
            java.lang.String r3 = r4.tokenName()     // Catch:{ all -> 0x067e }
            r2.append(r3)     // Catch:{ all -> 0x067e }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x067e }
            r0.<init>(r2)     // Catch:{ all -> 0x067e }
            throw r0     // Catch:{ all -> 0x067e }
        L_0x062d:
            r4.nextToken()     // Catch:{ all -> 0x067e }
            java.lang.Object r6 = r16.parse()     // Catch:{ all -> 0x067e }
            r9.put(r13, r6)     // Catch:{ all -> 0x067e }
            int r6 = r4.token()     // Catch:{ all -> 0x067e }
            r7 = 13
            if (r6 != r7) goto L_0x0646
            r4.nextToken()     // Catch:{ all -> 0x067e }
            r1.setContext(r5)
            return r0
        L_0x0646:
            int r6 = r4.token()     // Catch:{ all -> 0x067e }
            r8 = 16
            if (r6 != r8) goto L_0x0653
        L_0x064e:
            r10 = r8
            r6 = 0
            r8 = 4
            goto L_0x0080
        L_0x0653:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x067e }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x067e }
            r2.<init>()     // Catch:{ all -> 0x067e }
            r2.append(r11)     // Catch:{ all -> 0x067e }
            int r3 = r4.pos()     // Catch:{ all -> 0x067e }
            r2.append(r3)     // Catch:{ all -> 0x067e }
            r2.append(r10)     // Catch:{ all -> 0x067e }
            r2.append(r13)     // Catch:{ all -> 0x067e }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x067e }
            r0.<init>(r2)     // Catch:{ all -> 0x067e }
            throw r0     // Catch:{ all -> 0x067e }
        L_0x0672:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x067e }
            r0.<init>(r6)     // Catch:{ all -> 0x067e }
            throw r0     // Catch:{ all -> 0x067e }
        L_0x0678:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x067e }
            r0.<init>(r6)     // Catch:{ all -> 0x067e }
            throw r0     // Catch:{ all -> 0x067e }
        L_0x067e:
            r0 = move-exception
            r1.setContext(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.DefaultJSONParser.parseObject(java.util.Map, java.lang.Object):java.lang.Object");
    }

    public ParserConfig getConfig() {
        return this.config;
    }

    public void setConfig(ParserConfig parserConfig) {
        this.config = parserConfig;
    }

    public <T> T parseObject(Class<T> cls) {
        return parseObject((Type) cls, (Object) null);
    }

    public <T> T parseObject(Type type) {
        return parseObject(type, (Object) null);
    }

    public <T> T parseObject(Type type, Object obj) {
        int i = this.lexer.token();
        if (i == 8) {
            this.lexer.nextToken();
            return null;
        }
        if (i == 4) {
            if (type == byte[].class) {
                Object bytesValue = this.lexer.bytesValue();
                this.lexer.nextToken();
                return bytesValue;
            } else if (type == char[].class) {
                String stringVal = this.lexer.stringVal();
                this.lexer.nextToken();
                return stringVal.toCharArray();
            }
        }
        ObjectDeserializer deserializer = this.config.getDeserializer(type);
        try {
            if (deserializer.getClass() != JavaBeanDeserializer.class) {
                return deserializer.deserialze(this, type, obj);
            }
            if (this.lexer.token() != 12) {
                if (this.lexer.token() != 14) {
                    throw new JSONException("syntax error,except start with { or [,but actually start with " + this.lexer.tokenName());
                }
            }
            return ((JavaBeanDeserializer) deserializer).deserialze(this, type, obj, 0);
        } catch (JSONException e) {
            throw e;
        } catch (Throwable th) {
            throw new JSONException(th.getMessage(), th);
        }
    }

    public <T> List<T> parseArray(Class<T> cls) {
        ArrayList arrayList = new ArrayList();
        parseArray((Class<?>) cls, (Collection) arrayList);
        return arrayList;
    }

    public void parseArray(Class<?> cls, Collection collection) {
        parseArray((Type) cls, collection);
    }

    public void parseArray(Type type, Collection collection) {
        parseArray(type, collection, (Object) null);
    }

    /* JADX INFO: finally extract failed */
    public void parseArray(Type type, Collection collection, Object obj) {
        ObjectDeserializer objectDeserializer;
        int i = this.lexer.token();
        if (i == 21 || i == 22) {
            this.lexer.nextToken();
            i = this.lexer.token();
        }
        if (i == 14) {
            if (Integer.TYPE == type) {
                objectDeserializer = IntegerCodec.instance;
                this.lexer.nextToken(2);
            } else if (String.class == type) {
                objectDeserializer = StringCodec.instance;
                this.lexer.nextToken(4);
            } else {
                objectDeserializer = this.config.getDeserializer(type);
                this.lexer.nextToken(objectDeserializer.getFastMatchToken());
            }
            ParseContext parseContext = this.context;
            setContext(collection, obj);
            int i2 = 0;
            while (true) {
                try {
                    if (this.lexer.isEnabled(Feature.AllowArbitraryCommas)) {
                        while (this.lexer.token() == 16) {
                            this.lexer.nextToken();
                        }
                    }
                    if (this.lexer.token() == 15) {
                        setContext(parseContext);
                        this.lexer.nextToken(16);
                        return;
                    }
                    Object obj2 = null;
                    if (Integer.TYPE == type) {
                        collection.add(IntegerCodec.instance.deserialze(this, (Type) null, (Object) null));
                    } else if (String.class == type) {
                        if (this.lexer.token() == 4) {
                            obj2 = this.lexer.stringVal();
                            this.lexer.nextToken(16);
                        } else {
                            Object parse = parse();
                            if (parse != null) {
                                obj2 = parse.toString();
                            }
                        }
                        collection.add(obj2);
                    } else {
                        if (this.lexer.token() == 8) {
                            this.lexer.nextToken();
                        } else {
                            obj2 = objectDeserializer.deserialze(this, type, Integer.valueOf(i2));
                        }
                        collection.add(obj2);
                        checkListResolve(collection);
                    }
                    if (this.lexer.token() == 16) {
                        this.lexer.nextToken(objectDeserializer.getFastMatchToken());
                    }
                    i2++;
                } catch (Throwable th) {
                    setContext(parseContext);
                    throw th;
                }
            }
        } else {
            throw new JSONException("expect '[', but " + JSONToken.name(i) + ", " + this.lexer.info());
        }
    }

    public Object[] parseArray(Type[] typeArr) {
        Object obj;
        boolean z;
        Class<?> cls;
        Type[] typeArr2 = typeArr;
        int i = 8;
        if (this.lexer.token() == 8) {
            this.lexer.nextToken(16);
            return null;
        }
        int i2 = 14;
        if (this.lexer.token() == 14) {
            Object[] objArr = new Object[typeArr2.length];
            if (typeArr2.length == 0) {
                this.lexer.nextToken(15);
                if (this.lexer.token() == 15) {
                    this.lexer.nextToken(16);
                    return new Object[0];
                }
                throw new JSONException("syntax error");
            }
            this.lexer.nextToken(2);
            int i3 = 0;
            while (i3 < typeArr2.length) {
                if (this.lexer.token() == i) {
                    this.lexer.nextToken(16);
                    obj = null;
                } else {
                    Type type = typeArr2[i3];
                    if (type == Integer.TYPE || type == Integer.class) {
                        if (this.lexer.token() == 2) {
                            obj = Integer.valueOf(this.lexer.intValue());
                            this.lexer.nextToken(16);
                        } else {
                            obj = TypeUtils.cast(parse(), type, this.config);
                        }
                    } else if (type != String.class) {
                        if (i3 != typeArr2.length - 1 || !(type instanceof Class)) {
                            cls = null;
                            z = false;
                        } else {
                            Class cls2 = (Class) type;
                            z = cls2.isArray();
                            cls = cls2.getComponentType();
                        }
                        if (!z || this.lexer.token() == i2) {
                            obj = this.config.getDeserializer(type).deserialze(this, type, Integer.valueOf(i3));
                        } else {
                            ArrayList arrayList = new ArrayList();
                            ObjectDeserializer deserializer = this.config.getDeserializer((Type) cls);
                            int fastMatchToken = deserializer.getFastMatchToken();
                            if (this.lexer.token() != 15) {
                                while (true) {
                                    arrayList.add(deserializer.deserialze(this, type, (Object) null));
                                    if (this.lexer.token() != 16) {
                                        break;
                                    }
                                    this.lexer.nextToken(fastMatchToken);
                                }
                                if (this.lexer.token() != 15) {
                                    throw new JSONException("syntax error :" + JSONToken.name(this.lexer.token()));
                                }
                            }
                            obj = TypeUtils.cast((Object) arrayList, type, this.config);
                        }
                    } else if (this.lexer.token() == 4) {
                        obj = this.lexer.stringVal();
                        this.lexer.nextToken(16);
                    } else {
                        obj = TypeUtils.cast(parse(), type, this.config);
                    }
                }
                objArr[i3] = obj;
                if (this.lexer.token() == 15) {
                    break;
                } else if (this.lexer.token() == 16) {
                    if (i3 == typeArr2.length - 1) {
                        this.lexer.nextToken(15);
                    } else {
                        this.lexer.nextToken(2);
                    }
                    i3++;
                    i = 8;
                    i2 = 14;
                } else {
                    throw new JSONException("syntax error :" + JSONToken.name(this.lexer.token()));
                }
            }
            if (this.lexer.token() == 15) {
                this.lexer.nextToken(16);
                return objArr;
            }
            throw new JSONException("syntax error");
        }
        throw new JSONException("syntax error : " + this.lexer.tokenName());
    }

    public void parseObject(Object obj) {
        Object obj2;
        Class<?> cls = obj.getClass();
        ObjectDeserializer deserializer = this.config.getDeserializer((Type) cls);
        JavaBeanDeserializer javaBeanDeserializer = deserializer instanceof JavaBeanDeserializer ? (JavaBeanDeserializer) deserializer : null;
        if (this.lexer.token() == 12 || this.lexer.token() == 16) {
            while (true) {
                String scanSymbol = this.lexer.scanSymbol(this.symbolTable);
                if (scanSymbol == null) {
                    if (this.lexer.token() == 13) {
                        this.lexer.nextToken(16);
                        return;
                    } else if (this.lexer.token() == 16 && this.lexer.isEnabled(Feature.AllowArbitraryCommas)) {
                    }
                }
                FieldDeserializer fieldDeserializer = javaBeanDeserializer != null ? javaBeanDeserializer.getFieldDeserializer(scanSymbol) : null;
                if (fieldDeserializer != null) {
                    Class<?> cls2 = fieldDeserializer.fieldInfo.fieldClass;
                    Type type = fieldDeserializer.fieldInfo.fieldType;
                    if (cls2 == Integer.TYPE) {
                        this.lexer.nextTokenWithColon(2);
                        obj2 = IntegerCodec.instance.deserialze(this, type, (Object) null);
                    } else if (cls2 == String.class) {
                        this.lexer.nextTokenWithColon(4);
                        obj2 = StringCodec.deserialze(this);
                    } else if (cls2 == Long.TYPE) {
                        this.lexer.nextTokenWithColon(2);
                        obj2 = LongCodec.instance.deserialze(this, type, (Object) null);
                    } else {
                        ObjectDeserializer deserializer2 = this.config.getDeserializer(cls2, type);
                        this.lexer.nextTokenWithColon(deserializer2.getFastMatchToken());
                        obj2 = deserializer2.deserialze(this, type, (Object) null);
                    }
                    fieldDeserializer.setValue(obj, obj2);
                    if (this.lexer.token() != 16 && this.lexer.token() == 13) {
                        this.lexer.nextToken(16);
                        return;
                    }
                } else if (this.lexer.isEnabled(Feature.IgnoreNotMatch)) {
                    this.lexer.nextTokenWithColon();
                    parse();
                    if (this.lexer.token() == 13) {
                        this.lexer.nextToken();
                        return;
                    }
                } else {
                    throw new JSONException("setter not found, class " + cls.getName() + ", property " + scanSymbol);
                }
            }
        } else {
            throw new JSONException("syntax error, expect {, actual " + this.lexer.tokenName());
        }
    }

    public Object parseArrayWithType(Type type) {
        if (this.lexer.token() == 8) {
            this.lexer.nextToken();
            return null;
        }
        Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
        if (actualTypeArguments.length == 1) {
            Type type2 = actualTypeArguments[0];
            if (type2 instanceof Class) {
                ArrayList arrayList = new ArrayList();
                parseArray((Class<?>) (Class) type2, (Collection) arrayList);
                return arrayList;
            } else if (type2 instanceof WildcardType) {
                WildcardType wildcardType = (WildcardType) type2;
                Type type3 = wildcardType.getUpperBounds()[0];
                if (!Object.class.equals(type3)) {
                    ArrayList arrayList2 = new ArrayList();
                    parseArray((Class<?>) (Class) type3, (Collection) arrayList2);
                    return arrayList2;
                } else if (wildcardType.getLowerBounds().length == 0) {
                    return parse();
                } else {
                    throw new JSONException("not support type : " + type);
                }
            } else {
                if (type2 instanceof TypeVariable) {
                    TypeVariable typeVariable = (TypeVariable) type2;
                    Type[] bounds = typeVariable.getBounds();
                    if (bounds.length == 1) {
                        Type type4 = bounds[0];
                        if (type4 instanceof Class) {
                            ArrayList arrayList3 = new ArrayList();
                            parseArray((Class<?>) (Class) type4, (Collection) arrayList3);
                            return arrayList3;
                        }
                    } else {
                        throw new JSONException("not support : " + typeVariable);
                    }
                }
                if (type2 instanceof ParameterizedType) {
                    ArrayList arrayList4 = new ArrayList();
                    parseArray((Type) (ParameterizedType) type2, (Collection) arrayList4);
                    return arrayList4;
                }
                throw new JSONException("TODO : " + type);
            }
        } else {
            throw new JSONException("not support type " + type);
        }
    }

    public void acceptType(String str) {
        JSONLexer jSONLexer = this.lexer;
        jSONLexer.nextTokenWithColon();
        if (jSONLexer.token() != 4) {
            throw new JSONException("type not match error");
        } else if (str.equals(jSONLexer.stringVal())) {
            jSONLexer.nextToken();
            if (jSONLexer.token() == 16) {
                jSONLexer.nextToken();
            }
        } else {
            throw new JSONException("type not match error");
        }
    }

    public int getResolveStatus() {
        return this.resolveStatus;
    }

    public void setResolveStatus(int i) {
        this.resolveStatus = i;
    }

    public Object getObject(String str) {
        for (int i = 0; i < this.contextArrayIndex; i++) {
            if (str.equals(this.contextArray[i].toString())) {
                return this.contextArray[i].object;
            }
        }
        return null;
    }

    public void checkListResolve(Collection collection) {
        if (this.resolveStatus != 1) {
            return;
        }
        if (collection instanceof List) {
            ResolveTask lastResolveTask = getLastResolveTask();
            lastResolveTask.fieldDeserializer = new ResolveFieldDeserializer(this, (List) collection, collection.size() - 1);
            lastResolveTask.ownerContext = this.context;
            setResolveStatus(0);
            return;
        }
        ResolveTask lastResolveTask2 = getLastResolveTask();
        lastResolveTask2.fieldDeserializer = new ResolveFieldDeserializer(collection);
        lastResolveTask2.ownerContext = this.context;
        setResolveStatus(0);
    }

    public void checkMapResolve(Map map, Object obj) {
        if (this.resolveStatus == 1) {
            ResolveFieldDeserializer resolveFieldDeserializer = new ResolveFieldDeserializer(map, obj);
            ResolveTask lastResolveTask = getLastResolveTask();
            lastResolveTask.fieldDeserializer = resolveFieldDeserializer;
            lastResolveTask.ownerContext = this.context;
            setResolveStatus(0);
        }
    }

    public Object parseObject(Map map) {
        return parseObject(map, (Object) null);
    }

    public JSONObject parseObject() {
        Object parseObject = parseObject((Map) new JSONObject(this.lexer.isEnabled(Feature.OrderedField)));
        if (parseObject instanceof JSONObject) {
            return (JSONObject) parseObject;
        }
        if (parseObject == null) {
            return null;
        }
        return new JSONObject((Map<String, Object>) (Map) parseObject);
    }

    public final void parseArray(Collection collection) {
        parseArray(collection, (Object) null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v0, resolved type: java.lang.Number} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: java.lang.Number} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v3, resolved type: java.lang.Number} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: java.util.Date} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: java.util.Date} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v13, resolved type: java.lang.Number} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v14, resolved type: java.lang.Number} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v15, resolved type: java.util.Date} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v16, resolved type: java.util.Date} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v17, resolved type: java.lang.Boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v18, resolved type: java.lang.Boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v20, resolved type: com.alibaba.fastjson.JSONArray} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v21, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void parseArray(java.util.Collection r10, java.lang.Object r11) {
        /*
            r9 = this;
            com.alibaba.fastjson.parser.JSONLexer r0 = r9.lexer
            int r1 = r0.token()
            r2 = 21
            if (r1 == r2) goto L_0x0012
            int r1 = r0.token()
            r2 = 22
            if (r1 != r2) goto L_0x0015
        L_0x0012:
            r0.nextToken()
        L_0x0015:
            int r1 = r0.token()
            r2 = 14
            if (r1 != r2) goto L_0x011a
            r1 = 4
            r0.nextToken(r1)
            com.alibaba.fastjson.parser.ParseContext r3 = r9.context
            r9.setContext(r10, r11)
            r11 = 0
            r4 = r11
        L_0x0028:
            com.alibaba.fastjson.parser.Feature r5 = com.alibaba.fastjson.parser.Feature.AllowArbitraryCommas     // Catch:{ all -> 0x0115 }
            boolean r5 = r0.isEnabled((com.alibaba.fastjson.parser.Feature) r5)     // Catch:{ all -> 0x0115 }
            r6 = 16
            if (r5 == 0) goto L_0x003c
        L_0x0032:
            int r5 = r0.token()     // Catch:{ all -> 0x0115 }
            if (r5 != r6) goto L_0x003c
            r0.nextToken()     // Catch:{ all -> 0x0115 }
            goto L_0x0032
        L_0x003c:
            int r5 = r0.token()     // Catch:{ all -> 0x0115 }
            r7 = 2
            r8 = 0
            if (r5 == r7) goto L_0x00fb
            r7 = 3
            if (r5 == r7) goto L_0x00e4
            if (r5 == r1) goto L_0x00bd
            r7 = 6
            if (r5 == r7) goto L_0x00b7
            r7 = 7
            if (r5 == r7) goto L_0x00b1
            r7 = 8
            if (r5 == r7) goto L_0x00ad
            r7 = 12
            if (r5 == r7) goto L_0x0099
            r7 = 20
            if (r5 == r7) goto L_0x0091
            r7 = 23
            if (r5 == r7) goto L_0x008c
            if (r5 == r2) goto L_0x0072
            r7 = 15
            if (r5 == r7) goto L_0x006b
            java.lang.Object r8 = r9.parse()     // Catch:{ all -> 0x0115 }
            goto L_0x0102
        L_0x006b:
            r0.nextToken(r6)     // Catch:{ all -> 0x0115 }
            r9.setContext(r3)
            return
        L_0x0072:
            com.alibaba.fastjson.JSONArray r8 = new com.alibaba.fastjson.JSONArray     // Catch:{ all -> 0x0115 }
            r8.<init>()     // Catch:{ all -> 0x0115 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x0115 }
            r9.parseArray((java.util.Collection) r8, (java.lang.Object) r5)     // Catch:{ all -> 0x0115 }
            com.alibaba.fastjson.parser.Feature r5 = com.alibaba.fastjson.parser.Feature.UseObjectArray     // Catch:{ all -> 0x0115 }
            boolean r5 = r0.isEnabled((com.alibaba.fastjson.parser.Feature) r5)     // Catch:{ all -> 0x0115 }
            if (r5 == 0) goto L_0x0102
            java.lang.Object[] r8 = r8.toArray()     // Catch:{ all -> 0x0115 }
            goto L_0x0102
        L_0x008c:
            r0.nextToken(r1)     // Catch:{ all -> 0x0115 }
            goto L_0x0102
        L_0x0091:
            com.alibaba.fastjson.JSONException r10 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x0115 }
            java.lang.String r11 = "unclosed jsonArray"
            r10.<init>(r11)     // Catch:{ all -> 0x0115 }
            throw r10     // Catch:{ all -> 0x0115 }
        L_0x0099:
            com.alibaba.fastjson.JSONObject r5 = new com.alibaba.fastjson.JSONObject     // Catch:{ all -> 0x0115 }
            com.alibaba.fastjson.parser.Feature r7 = com.alibaba.fastjson.parser.Feature.OrderedField     // Catch:{ all -> 0x0115 }
            boolean r7 = r0.isEnabled((com.alibaba.fastjson.parser.Feature) r7)     // Catch:{ all -> 0x0115 }
            r5.<init>((boolean) r7)     // Catch:{ all -> 0x0115 }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x0115 }
            java.lang.Object r8 = r9.parseObject((java.util.Map) r5, (java.lang.Object) r7)     // Catch:{ all -> 0x0115 }
            goto L_0x0102
        L_0x00ad:
            r0.nextToken(r1)     // Catch:{ all -> 0x0115 }
            goto L_0x0102
        L_0x00b1:
            java.lang.Boolean r8 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x0115 }
            r0.nextToken(r6)     // Catch:{ all -> 0x0115 }
            goto L_0x0102
        L_0x00b7:
            java.lang.Boolean r8 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x0115 }
            r0.nextToken(r6)     // Catch:{ all -> 0x0115 }
            goto L_0x0102
        L_0x00bd:
            java.lang.String r8 = r0.stringVal()     // Catch:{ all -> 0x0115 }
            r0.nextToken(r6)     // Catch:{ all -> 0x0115 }
            com.alibaba.fastjson.parser.Feature r5 = com.alibaba.fastjson.parser.Feature.AllowISO8601DateFormat     // Catch:{ all -> 0x0115 }
            boolean r5 = r0.isEnabled((com.alibaba.fastjson.parser.Feature) r5)     // Catch:{ all -> 0x0115 }
            if (r5 == 0) goto L_0x0102
            com.alibaba.fastjson.parser.JSONScanner r5 = new com.alibaba.fastjson.parser.JSONScanner     // Catch:{ all -> 0x0115 }
            r5.<init>(r8)     // Catch:{ all -> 0x0115 }
            boolean r7 = r5.scanISO8601DateIfMatch()     // Catch:{ all -> 0x0115 }
            if (r7 == 0) goto L_0x00e0
            java.util.Calendar r7 = r5.getCalendar()     // Catch:{ all -> 0x0115 }
            java.util.Date r7 = r7.getTime()     // Catch:{ all -> 0x0115 }
            r8 = r7
        L_0x00e0:
            r5.close()     // Catch:{ all -> 0x0115 }
            goto L_0x0102
        L_0x00e4:
            com.alibaba.fastjson.parser.Feature r5 = com.alibaba.fastjson.parser.Feature.UseBigDecimal     // Catch:{ all -> 0x0115 }
            boolean r5 = r0.isEnabled((com.alibaba.fastjson.parser.Feature) r5)     // Catch:{ all -> 0x0115 }
            if (r5 == 0) goto L_0x00f2
            r5 = 1
            java.lang.Number r5 = r0.decimalValue(r5)     // Catch:{ all -> 0x0115 }
            goto L_0x00f6
        L_0x00f2:
            java.lang.Number r5 = r0.decimalValue(r11)     // Catch:{ all -> 0x0115 }
        L_0x00f6:
            r8 = r5
            r0.nextToken(r6)     // Catch:{ all -> 0x0115 }
            goto L_0x0102
        L_0x00fb:
            java.lang.Number r8 = r0.integerValue()     // Catch:{ all -> 0x0115 }
            r0.nextToken(r6)     // Catch:{ all -> 0x0115 }
        L_0x0102:
            r10.add(r8)     // Catch:{ all -> 0x0115 }
            r9.checkListResolve(r10)     // Catch:{ all -> 0x0115 }
            int r5 = r0.token()     // Catch:{ all -> 0x0115 }
            if (r5 != r6) goto L_0x0111
            r0.nextToken(r1)     // Catch:{ all -> 0x0115 }
        L_0x0111:
            int r4 = r4 + 1
            goto L_0x0028
        L_0x0115:
            r10 = move-exception
            r9.setContext(r3)
            throw r10
        L_0x011a:
            com.alibaba.fastjson.JSONException r10 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "syntax error, expect [, actual "
            r1.append(r2)
            int r2 = r0.token()
            java.lang.String r2 = com.alibaba.fastjson.parser.JSONToken.name(r2)
            r1.append(r2)
            java.lang.String r2 = ", pos "
            r1.append(r2)
            int r0 = r0.pos()
            r1.append(r0)
            java.lang.String r0 = ", fieldName "
            r1.append(r0)
            r1.append(r11)
            java.lang.String r11 = r1.toString()
            r10.<init>(r11)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.DefaultJSONParser.parseArray(java.util.Collection, java.lang.Object):void");
    }

    public ParseContext getContext() {
        return this.context;
    }

    public List<ResolveTask> getResolveTaskList() {
        if (this.resolveTaskList == null) {
            this.resolveTaskList = new ArrayList(2);
        }
        return this.resolveTaskList;
    }

    public void addResolveTask(ResolveTask resolveTask) {
        if (this.resolveTaskList == null) {
            this.resolveTaskList = new ArrayList(2);
        }
        this.resolveTaskList.add(resolveTask);
    }

    public ResolveTask getLastResolveTask() {
        List<ResolveTask> list = this.resolveTaskList;
        return list.get(list.size() - 1);
    }

    public List<ExtraProcessor> getExtraProcessors() {
        if (this.extraProcessors == null) {
            this.extraProcessors = new ArrayList(2);
        }
        return this.extraProcessors;
    }

    public List<ExtraTypeProvider> getExtraTypeProviders() {
        if (this.extraTypeProviders == null) {
            this.extraTypeProviders = new ArrayList(2);
        }
        return this.extraTypeProviders;
    }

    public FieldTypeResolver getFieldTypeResolver() {
        return this.fieldTypeResolver;
    }

    public void setFieldTypeResolver(FieldTypeResolver fieldTypeResolver2) {
        this.fieldTypeResolver = fieldTypeResolver2;
    }

    public void setContext(ParseContext parseContext) {
        if (!this.lexer.isEnabled(Feature.DisableCircularReferenceDetect)) {
            this.context = parseContext;
        }
    }

    public void popContext() {
        if (!this.lexer.isEnabled(Feature.DisableCircularReferenceDetect)) {
            this.context = this.context.parent;
            int i = this.contextArrayIndex;
            if (i > 0) {
                int i2 = i - 1;
                this.contextArrayIndex = i2;
                this.contextArray[i2] = null;
            }
        }
    }

    public ParseContext setContext(Object obj, Object obj2) {
        if (this.lexer.isEnabled(Feature.DisableCircularReferenceDetect)) {
            return null;
        }
        return setContext(this.context, obj, obj2);
    }

    public ParseContext setContext(ParseContext parseContext, Object obj, Object obj2) {
        if (this.lexer.isEnabled(Feature.DisableCircularReferenceDetect)) {
            return null;
        }
        ParseContext parseContext2 = new ParseContext(parseContext, obj, obj2);
        this.context = parseContext2;
        addContext(parseContext2);
        return this.context;
    }

    private void addContext(ParseContext parseContext) {
        int i = this.contextArrayIndex;
        this.contextArrayIndex = i + 1;
        ParseContext[] parseContextArr = this.contextArray;
        if (parseContextArr == null) {
            this.contextArray = new ParseContext[8];
        } else if (i >= parseContextArr.length) {
            ParseContext[] parseContextArr2 = new ParseContext[((parseContextArr.length * 3) / 2)];
            System.arraycopy(parseContextArr, 0, parseContextArr2, 0, parseContextArr.length);
            this.contextArray = parseContextArr2;
        }
        this.contextArray[i] = parseContext;
    }

    public Object parse() {
        return parse((Object) null);
    }

    public Object parseKey() {
        if (this.lexer.token() != 18) {
            return parse((Object) null);
        }
        String stringVal = this.lexer.stringVal();
        this.lexer.nextToken(16);
        return stringVal;
    }

    public Object parse(Object obj) {
        JSONLexer jSONLexer = this.lexer;
        int i = jSONLexer.token();
        if (i == 2) {
            Number integerValue = jSONLexer.integerValue();
            jSONLexer.nextToken();
            return integerValue;
        } else if (i == 3) {
            Number decimalValue = jSONLexer.decimalValue(jSONLexer.isEnabled(Feature.UseBigDecimal));
            jSONLexer.nextToken();
            return decimalValue;
        } else if (i == 4) {
            String stringVal = jSONLexer.stringVal();
            jSONLexer.nextToken(16);
            if (jSONLexer.isEnabled(Feature.AllowISO8601DateFormat)) {
                JSONScanner jSONScanner = new JSONScanner(stringVal);
                try {
                    if (jSONScanner.scanISO8601DateIfMatch()) {
                        return jSONScanner.getCalendar().getTime();
                    }
                    jSONScanner.close();
                } finally {
                    jSONScanner.close();
                }
            }
            return stringVal;
        } else if (i == 12) {
            return parseObject((Map) new JSONObject(jSONLexer.isEnabled(Feature.OrderedField)), obj);
        } else {
            if (i == 14) {
                JSONArray jSONArray = new JSONArray();
                parseArray((Collection) jSONArray, obj);
                return jSONLexer.isEnabled(Feature.UseObjectArray) ? jSONArray.toArray() : jSONArray;
            } else if (i != 18) {
                if (i != 26) {
                    switch (i) {
                        case 6:
                            jSONLexer.nextToken();
                            return Boolean.TRUE;
                        case 7:
                            jSONLexer.nextToken();
                            return Boolean.FALSE;
                        case 8:
                            jSONLexer.nextToken();
                            return null;
                        case 9:
                            jSONLexer.nextToken(18);
                            if (jSONLexer.token() == 18) {
                                jSONLexer.nextToken(10);
                                accept(10);
                                long longValue = jSONLexer.integerValue().longValue();
                                accept(2);
                                accept(11);
                                return new Date(longValue);
                            }
                            throw new JSONException("syntax error");
                        default:
                            switch (i) {
                                case 20:
                                    if (jSONLexer.isBlankInput()) {
                                        return null;
                                    }
                                    throw new JSONException("unterminated json string, " + jSONLexer.info());
                                case 21:
                                    jSONLexer.nextToken();
                                    HashSet hashSet = new HashSet();
                                    parseArray((Collection) hashSet, obj);
                                    return hashSet;
                                case 22:
                                    jSONLexer.nextToken();
                                    TreeSet treeSet = new TreeSet();
                                    parseArray((Collection) treeSet, obj);
                                    return treeSet;
                                case 23:
                                    jSONLexer.nextToken();
                                    return null;
                                default:
                                    throw new JSONException("syntax error, " + jSONLexer.info());
                            }
                    }
                } else {
                    byte[] bytesValue = jSONLexer.bytesValue();
                    jSONLexer.nextToken();
                    return bytesValue;
                }
            } else if ("NaN".equals(jSONLexer.stringVal())) {
                jSONLexer.nextToken();
                return null;
            } else {
                throw new JSONException("syntax error, " + jSONLexer.info());
            }
        }
    }

    public void config(Feature feature, boolean z) {
        this.lexer.config(feature, z);
    }

    public boolean isEnabled(Feature feature) {
        return this.lexer.isEnabled(feature);
    }

    public JSONLexer getLexer() {
        return this.lexer;
    }

    public final void accept(int i) {
        JSONLexer jSONLexer = this.lexer;
        if (jSONLexer.token() == i) {
            jSONLexer.nextToken();
            return;
        }
        throw new JSONException("syntax error, expect " + JSONToken.name(i) + ", actual " + JSONToken.name(jSONLexer.token()));
    }

    public final void accept(int i, int i2) {
        JSONLexer jSONLexer = this.lexer;
        if (jSONLexer.token() == i) {
            jSONLexer.nextToken(i2);
        } else {
            throwException(i);
        }
    }

    public void throwException(int i) {
        throw new JSONException("syntax error, expect " + JSONToken.name(i) + ", actual " + JSONToken.name(this.lexer.token()));
    }

    public void close() {
        JSONLexer jSONLexer = this.lexer;
        try {
            if (jSONLexer.isEnabled(Feature.AutoCloseSource)) {
                if (jSONLexer.token() != 20) {
                    throw new JSONException("not close json text, token : " + JSONToken.name(jSONLexer.token()));
                }
            }
        } finally {
            jSONLexer.close();
        }
    }

    public Object resolveReference(String str) {
        if (this.contextArray == null) {
            return null;
        }
        int i = 0;
        while (true) {
            ParseContext[] parseContextArr = this.contextArray;
            if (i >= parseContextArr.length || i >= this.contextArrayIndex) {
                return null;
            }
            ParseContext parseContext = parseContextArr[i];
            if (parseContext.toString().equals(str)) {
                return parseContext.object;
            }
            i++;
        }
        return null;
    }

    public void handleResovleTask(Object obj) {
        Object obj2;
        List<ResolveTask> list = this.resolveTaskList;
        if (list != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ResolveTask resolveTask = this.resolveTaskList.get(i);
                String str = resolveTask.referenceValue;
                Object obj3 = null;
                if (resolveTask.ownerContext != null) {
                    obj3 = resolveTask.ownerContext.object;
                }
                if (str.startsWith("$")) {
                    obj2 = getObject(str);
                    if (obj2 == null) {
                        try {
                            obj2 = JSONPath.eval(obj, str);
                        } catch (JSONPathException unused) {
                        }
                    }
                } else {
                    obj2 = resolveTask.context.object;
                }
                FieldDeserializer fieldDeserializer = resolveTask.fieldDeserializer;
                if (fieldDeserializer != null) {
                    if (obj2 != null && obj2.getClass() == JSONObject.class && fieldDeserializer.fieldInfo != null && !Map.class.isAssignableFrom(fieldDeserializer.fieldInfo.fieldClass)) {
                        obj2 = JSONPath.eval(this.contextArray[0].object, str);
                    }
                    fieldDeserializer.setValue(obj3, obj2);
                }
            }
        }
    }

    public static class ResolveTask {
        public final ParseContext context;
        public FieldDeserializer fieldDeserializer;
        public ParseContext ownerContext;
        public final String referenceValue;

        public ResolveTask(ParseContext parseContext, String str) {
            this.context = parseContext;
            this.referenceValue = str;
        }
    }

    public void parseExtra(Object obj, String str) {
        Object obj2;
        this.lexer.nextTokenWithColon();
        List<ExtraTypeProvider> list = this.extraTypeProviders;
        Type type = null;
        if (list != null) {
            for (ExtraTypeProvider extraType : list) {
                type = extraType.getExtraType(obj, str);
            }
        }
        if (type == null) {
            obj2 = parse();
        } else {
            obj2 = parseObject(type);
        }
        if (obj instanceof ExtraProcessable) {
            ((ExtraProcessable) obj).processExtra(str, obj2);
            return;
        }
        List<ExtraProcessor> list2 = this.extraProcessors;
        if (list2 != null) {
            for (ExtraProcessor processExtra : list2) {
                processExtra.processExtra(obj, str, obj2);
            }
        }
        if (this.resolveStatus == 1) {
            this.resolveStatus = 0;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:61:?, code lost:
        r11 = r10.config.getDeserializer((java.lang.reflect.Type) r2);
        r10.lexer.nextToken(16);
        setResolveStatus(2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x01d7, code lost:
        if (r0 == null) goto L_0x01e0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x01db, code lost:
        if ((r12 instanceof java.lang.Integer) != false) goto L_0x01e0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x01dd, code lost:
        popContext();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x01e0, code lost:
        r11 = (java.util.Map) r11.deserialze(r10, r2, r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x01e6, code lost:
        setContext(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x01e9, code lost:
        return r11;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object parse(com.alibaba.fastjson.parser.deserializer.PropertyProcessable r11, java.lang.Object r12) {
        /*
            r10 = this;
            com.alibaba.fastjson.parser.JSONLexer r0 = r10.lexer
            int r0 = r0.token()
            r1 = 0
            r2 = 12
            if (r0 == r2) goto L_0x008c
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r0 = "syntax error, expect {, actual "
            r11.append(r0)
            com.alibaba.fastjson.parser.JSONLexer r0 = r10.lexer
            java.lang.String r0 = r0.tokenName()
            r11.append(r0)
            java.lang.String r11 = r11.toString()
            boolean r0 = r12 instanceof java.lang.String
            if (r0 == 0) goto L_0x0046
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r11)
            java.lang.String r11 = ", fieldName "
            r0.append(r11)
            java.lang.String r11 = r0.toString()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r11)
            r0.append(r12)
            java.lang.String r11 = r0.toString()
        L_0x0046:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r11)
            java.lang.String r11 = ", "
            r0.append(r11)
            java.lang.String r11 = r0.toString()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r11)
            com.alibaba.fastjson.parser.JSONLexer r11 = r10.lexer
            java.lang.String r11 = r11.info()
            r0.append(r11)
            java.lang.String r11 = r0.toString()
            com.alibaba.fastjson.JSONArray r0 = new com.alibaba.fastjson.JSONArray
            r0.<init>()
            r10.parseArray((java.util.Collection) r0, (java.lang.Object) r12)
            int r12 = r0.size()
            r2 = 1
            if (r12 != r2) goto L_0x0086
            java.lang.Object r12 = r0.get(r1)
            boolean r0 = r12 instanceof com.alibaba.fastjson.JSONObject
            if (r0 == 0) goto L_0x0086
            com.alibaba.fastjson.JSONObject r12 = (com.alibaba.fastjson.JSONObject) r12
            return r12
        L_0x0086:
            com.alibaba.fastjson.JSONException r12 = new com.alibaba.fastjson.JSONException
            r12.<init>(r11)
            throw r12
        L_0x008c:
            com.alibaba.fastjson.parser.ParseContext r0 = r10.context
        L_0x008e:
            com.alibaba.fastjson.parser.JSONLexer r2 = r10.lexer     // Catch:{ all -> 0x0260 }
            r2.skipWhitespace()     // Catch:{ all -> 0x0260 }
            com.alibaba.fastjson.parser.JSONLexer r2 = r10.lexer     // Catch:{ all -> 0x0260 }
            char r2 = r2.getCurrent()     // Catch:{ all -> 0x0260 }
            com.alibaba.fastjson.parser.JSONLexer r3 = r10.lexer     // Catch:{ all -> 0x0260 }
            com.alibaba.fastjson.parser.Feature r4 = com.alibaba.fastjson.parser.Feature.AllowArbitraryCommas     // Catch:{ all -> 0x0260 }
            boolean r3 = r3.isEnabled((com.alibaba.fastjson.parser.Feature) r4)     // Catch:{ all -> 0x0260 }
            if (r3 == 0) goto L_0x00b8
        L_0x00a3:
            r3 = 44
            if (r2 != r3) goto L_0x00b8
            com.alibaba.fastjson.parser.JSONLexer r2 = r10.lexer     // Catch:{ all -> 0x0260 }
            r2.next()     // Catch:{ all -> 0x0260 }
            com.alibaba.fastjson.parser.JSONLexer r2 = r10.lexer     // Catch:{ all -> 0x0260 }
            r2.skipWhitespace()     // Catch:{ all -> 0x0260 }
            com.alibaba.fastjson.parser.JSONLexer r2 = r10.lexer     // Catch:{ all -> 0x0260 }
            char r2 = r2.getCurrent()     // Catch:{ all -> 0x0260 }
            goto L_0x00a3
        L_0x00b8:
            java.lang.String r3 = "expect ':' at "
            r4 = 58
            r5 = 34
            r6 = 16
            if (r2 != r5) goto L_0x00f4
            com.alibaba.fastjson.parser.JSONLexer r2 = r10.lexer     // Catch:{ all -> 0x0260 }
            com.alibaba.fastjson.parser.SymbolTable r7 = r10.symbolTable     // Catch:{ all -> 0x0260 }
            java.lang.String r2 = r2.scanSymbol(r7, r5)     // Catch:{ all -> 0x0260 }
            com.alibaba.fastjson.parser.JSONLexer r7 = r10.lexer     // Catch:{ all -> 0x0260 }
            r7.skipWhitespace()     // Catch:{ all -> 0x0260 }
            com.alibaba.fastjson.parser.JSONLexer r7 = r10.lexer     // Catch:{ all -> 0x0260 }
            char r7 = r7.getCurrent()     // Catch:{ all -> 0x0260 }
            if (r7 != r4) goto L_0x00d9
            goto L_0x0171
        L_0x00d9:
            com.alibaba.fastjson.JSONException r11 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x0260 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x0260 }
            r12.<init>()     // Catch:{ all -> 0x0260 }
            r12.append(r3)     // Catch:{ all -> 0x0260 }
            com.alibaba.fastjson.parser.JSONLexer r1 = r10.lexer     // Catch:{ all -> 0x0260 }
            int r1 = r1.pos()     // Catch:{ all -> 0x0260 }
            r12.append(r1)     // Catch:{ all -> 0x0260 }
            java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x0260 }
            r11.<init>(r12)     // Catch:{ all -> 0x0260 }
            throw r11     // Catch:{ all -> 0x0260 }
        L_0x00f4:
            r7 = 125(0x7d, float:1.75E-43)
            if (r2 != r7) goto L_0x010b
            com.alibaba.fastjson.parser.JSONLexer r12 = r10.lexer     // Catch:{ all -> 0x0260 }
            r12.next()     // Catch:{ all -> 0x0260 }
            com.alibaba.fastjson.parser.JSONLexer r12 = r10.lexer     // Catch:{ all -> 0x0260 }
            r12.resetStringPosition()     // Catch:{ all -> 0x0260 }
            com.alibaba.fastjson.parser.JSONLexer r12 = r10.lexer     // Catch:{ all -> 0x0260 }
            r12.nextToken(r6)     // Catch:{ all -> 0x0260 }
            r10.setContext(r0)
            return r11
        L_0x010b:
            java.lang.String r7 = "syntax error"
            r8 = 39
            if (r2 != r8) goto L_0x0152
            com.alibaba.fastjson.parser.JSONLexer r2 = r10.lexer     // Catch:{ all -> 0x0260 }
            com.alibaba.fastjson.parser.Feature r9 = com.alibaba.fastjson.parser.Feature.AllowSingleQuotes     // Catch:{ all -> 0x0260 }
            boolean r2 = r2.isEnabled((com.alibaba.fastjson.parser.Feature) r9)     // Catch:{ all -> 0x0260 }
            if (r2 == 0) goto L_0x014c
            com.alibaba.fastjson.parser.JSONLexer r2 = r10.lexer     // Catch:{ all -> 0x0260 }
            com.alibaba.fastjson.parser.SymbolTable r7 = r10.symbolTable     // Catch:{ all -> 0x0260 }
            java.lang.String r2 = r2.scanSymbol(r7, r8)     // Catch:{ all -> 0x0260 }
            com.alibaba.fastjson.parser.JSONLexer r7 = r10.lexer     // Catch:{ all -> 0x0260 }
            r7.skipWhitespace()     // Catch:{ all -> 0x0260 }
            com.alibaba.fastjson.parser.JSONLexer r7 = r10.lexer     // Catch:{ all -> 0x0260 }
            char r7 = r7.getCurrent()     // Catch:{ all -> 0x0260 }
            if (r7 != r4) goto L_0x0131
            goto L_0x0171
        L_0x0131:
            com.alibaba.fastjson.JSONException r11 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x0260 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x0260 }
            r12.<init>()     // Catch:{ all -> 0x0260 }
            r12.append(r3)     // Catch:{ all -> 0x0260 }
            com.alibaba.fastjson.parser.JSONLexer r1 = r10.lexer     // Catch:{ all -> 0x0260 }
            int r1 = r1.pos()     // Catch:{ all -> 0x0260 }
            r12.append(r1)     // Catch:{ all -> 0x0260 }
            java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x0260 }
            r11.<init>(r12)     // Catch:{ all -> 0x0260 }
            throw r11     // Catch:{ all -> 0x0260 }
        L_0x014c:
            com.alibaba.fastjson.JSONException r11 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x0260 }
            r11.<init>(r7)     // Catch:{ all -> 0x0260 }
            throw r11     // Catch:{ all -> 0x0260 }
        L_0x0152:
            com.alibaba.fastjson.parser.JSONLexer r2 = r10.lexer     // Catch:{ all -> 0x0260 }
            com.alibaba.fastjson.parser.Feature r8 = com.alibaba.fastjson.parser.Feature.AllowUnQuotedFieldNames     // Catch:{ all -> 0x0260 }
            boolean r2 = r2.isEnabled((com.alibaba.fastjson.parser.Feature) r8)     // Catch:{ all -> 0x0260 }
            if (r2 == 0) goto L_0x025a
            com.alibaba.fastjson.parser.JSONLexer r2 = r10.lexer     // Catch:{ all -> 0x0260 }
            com.alibaba.fastjson.parser.SymbolTable r7 = r10.symbolTable     // Catch:{ all -> 0x0260 }
            java.lang.String r2 = r2.scanSymbolUnQuoted(r7)     // Catch:{ all -> 0x0260 }
            com.alibaba.fastjson.parser.JSONLexer r7 = r10.lexer     // Catch:{ all -> 0x0260 }
            r7.skipWhitespace()     // Catch:{ all -> 0x0260 }
            com.alibaba.fastjson.parser.JSONLexer r7 = r10.lexer     // Catch:{ all -> 0x0260 }
            char r7 = r7.getCurrent()     // Catch:{ all -> 0x0260 }
            if (r7 != r4) goto L_0x0237
        L_0x0171:
            com.alibaba.fastjson.parser.JSONLexer r3 = r10.lexer     // Catch:{ all -> 0x0260 }
            r3.next()     // Catch:{ all -> 0x0260 }
            com.alibaba.fastjson.parser.JSONLexer r3 = r10.lexer     // Catch:{ all -> 0x0260 }
            r3.skipWhitespace()     // Catch:{ all -> 0x0260 }
            com.alibaba.fastjson.parser.JSONLexer r3 = r10.lexer     // Catch:{ all -> 0x0260 }
            r3.getCurrent()     // Catch:{ all -> 0x0260 }
            com.alibaba.fastjson.parser.JSONLexer r3 = r10.lexer     // Catch:{ all -> 0x0260 }
            r3.resetStringPosition()     // Catch:{ all -> 0x0260 }
            java.lang.String r3 = com.alibaba.fastjson.JSON.DEFAULT_TYPE_KEY     // Catch:{ all -> 0x0260 }
            r4 = 13
            r7 = 0
            if (r2 != r3) goto L_0x01ea
            com.alibaba.fastjson.parser.JSONLexer r3 = r10.lexer     // Catch:{ all -> 0x0260 }
            com.alibaba.fastjson.parser.Feature r8 = com.alibaba.fastjson.parser.Feature.DisableSpecialKeyDetect     // Catch:{ all -> 0x0260 }
            boolean r3 = r3.isEnabled((com.alibaba.fastjson.parser.Feature) r8)     // Catch:{ all -> 0x0260 }
            if (r3 != 0) goto L_0x01ea
            com.alibaba.fastjson.parser.JSONLexer r2 = r10.lexer     // Catch:{ all -> 0x0260 }
            com.alibaba.fastjson.parser.SymbolTable r3 = r10.symbolTable     // Catch:{ all -> 0x0260 }
            java.lang.String r2 = r2.scanSymbol(r3, r5)     // Catch:{ all -> 0x0260 }
            com.alibaba.fastjson.parser.ParserConfig r3 = r10.config     // Catch:{ all -> 0x0260 }
            com.alibaba.fastjson.parser.JSONLexer r5 = r10.lexer     // Catch:{ all -> 0x0260 }
            int r5 = r5.getFeatures()     // Catch:{ all -> 0x0260 }
            java.lang.Class r2 = r3.checkAutoType(r2, r7, r5)     // Catch:{ all -> 0x0260 }
            java.lang.Class<java.util.Map> r3 = java.util.Map.class
            boolean r3 = r3.isAssignableFrom(r2)     // Catch:{ all -> 0x0260 }
            if (r3 == 0) goto L_0x01c8
            com.alibaba.fastjson.parser.JSONLexer r2 = r10.lexer     // Catch:{ all -> 0x0260 }
            r2.nextToken(r6)     // Catch:{ all -> 0x0260 }
            com.alibaba.fastjson.parser.JSONLexer r2 = r10.lexer     // Catch:{ all -> 0x0260 }
            int r2 = r2.token()     // Catch:{ all -> 0x0260 }
            if (r2 != r4) goto L_0x022f
            com.alibaba.fastjson.parser.JSONLexer r12 = r10.lexer     // Catch:{ all -> 0x0260 }
            r12.nextToken(r6)     // Catch:{ all -> 0x0260 }
            r10.setContext(r0)
            return r11
        L_0x01c8:
            com.alibaba.fastjson.parser.ParserConfig r11 = r10.config     // Catch:{ all -> 0x0260 }
            com.alibaba.fastjson.parser.deserializer.ObjectDeserializer r11 = r11.getDeserializer((java.lang.reflect.Type) r2)     // Catch:{ all -> 0x0260 }
            com.alibaba.fastjson.parser.JSONLexer r1 = r10.lexer     // Catch:{ all -> 0x0260 }
            r1.nextToken(r6)     // Catch:{ all -> 0x0260 }
            r1 = 2
            r10.setResolveStatus(r1)     // Catch:{ all -> 0x0260 }
            if (r0 == 0) goto L_0x01e0
            boolean r1 = r12 instanceof java.lang.Integer     // Catch:{ all -> 0x0260 }
            if (r1 != 0) goto L_0x01e0
            r10.popContext()     // Catch:{ all -> 0x0260 }
        L_0x01e0:
            java.lang.Object r11 = r11.deserialze(r10, r2, r12)     // Catch:{ all -> 0x0260 }
            java.util.Map r11 = (java.util.Map) r11     // Catch:{ all -> 0x0260 }
            r10.setContext(r0)
            return r11
        L_0x01ea:
            com.alibaba.fastjson.parser.JSONLexer r3 = r10.lexer     // Catch:{ all -> 0x0260 }
            r3.nextToken()     // Catch:{ all -> 0x0260 }
            if (r1 == 0) goto L_0x01f4
            r10.setContext(r0)     // Catch:{ all -> 0x0260 }
        L_0x01f4:
            java.lang.reflect.Type r3 = r11.getType(r2)     // Catch:{ all -> 0x0260 }
            com.alibaba.fastjson.parser.JSONLexer r5 = r10.lexer     // Catch:{ all -> 0x0260 }
            int r5 = r5.token()     // Catch:{ all -> 0x0260 }
            r6 = 8
            if (r5 != r6) goto L_0x0208
            com.alibaba.fastjson.parser.JSONLexer r3 = r10.lexer     // Catch:{ all -> 0x0260 }
            r3.nextToken()     // Catch:{ all -> 0x0260 }
            goto L_0x020c
        L_0x0208:
            java.lang.Object r7 = r10.parseObject((java.lang.reflect.Type) r3, (java.lang.Object) r2)     // Catch:{ all -> 0x0260 }
        L_0x020c:
            r11.apply(r2, r7)     // Catch:{ all -> 0x0260 }
            r10.setContext(r0, r7, r2)     // Catch:{ all -> 0x0260 }
            r10.setContext(r0)     // Catch:{ all -> 0x0260 }
            com.alibaba.fastjson.parser.JSONLexer r2 = r10.lexer     // Catch:{ all -> 0x0260 }
            int r2 = r2.token()     // Catch:{ all -> 0x0260 }
            r3 = 20
            if (r2 == r3) goto L_0x0233
            r3 = 15
            if (r2 != r3) goto L_0x0224
            goto L_0x0233
        L_0x0224:
            if (r2 != r4) goto L_0x022f
            com.alibaba.fastjson.parser.JSONLexer r12 = r10.lexer     // Catch:{ all -> 0x0260 }
            r12.nextToken()     // Catch:{ all -> 0x0260 }
            r10.setContext(r0)
            return r11
        L_0x022f:
            int r1 = r1 + 1
            goto L_0x008e
        L_0x0233:
            r10.setContext(r0)
            return r11
        L_0x0237:
            com.alibaba.fastjson.JSONException r11 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x0260 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x0260 }
            r12.<init>()     // Catch:{ all -> 0x0260 }
            r12.append(r3)     // Catch:{ all -> 0x0260 }
            com.alibaba.fastjson.parser.JSONLexer r1 = r10.lexer     // Catch:{ all -> 0x0260 }
            int r1 = r1.pos()     // Catch:{ all -> 0x0260 }
            r12.append(r1)     // Catch:{ all -> 0x0260 }
            java.lang.String r1 = ", actual "
            r12.append(r1)     // Catch:{ all -> 0x0260 }
            r12.append(r7)     // Catch:{ all -> 0x0260 }
            java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x0260 }
            r11.<init>(r12)     // Catch:{ all -> 0x0260 }
            throw r11     // Catch:{ all -> 0x0260 }
        L_0x025a:
            com.alibaba.fastjson.JSONException r11 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x0260 }
            r11.<init>(r7)     // Catch:{ all -> 0x0260 }
            throw r11     // Catch:{ all -> 0x0260 }
        L_0x0260:
            r11 = move-exception
            r10.setContext(r0)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.DefaultJSONParser.parse(com.alibaba.fastjson.parser.deserializer.PropertyProcessable, java.lang.Object):java.lang.Object");
    }
}
