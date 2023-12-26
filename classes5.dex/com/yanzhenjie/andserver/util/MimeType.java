package com.yanzhenjie.andserver.util;

import com.yanzhenjie.andserver.error.InvalidMimeTypeException;
import io.agora.rtc.Constants;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.BitSet;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TreeSet;

public class MimeType implements Comparable<MimeType>, Serializable {
    private static final String PARAM_CHARSET = "charset";
    private static final BitSet TOKEN;
    protected static final String WILDCARD_TYPE = "*";
    private final Map<String, String> parameters;
    private final String subtype;
    private final String type;

    static {
        BitSet bitSet = new BitSet(Constants.ERR_WATERMARK_ARGB);
        for (int i = 0; i <= 31; i++) {
            bitSet.set(i);
        }
        bitSet.set(Constants.ERR_WATERMARKR_INFO);
        BitSet bitSet2 = new BitSet(Constants.ERR_WATERMARK_ARGB);
        bitSet2.set(40);
        bitSet2.set(41);
        bitSet2.set(60);
        bitSet2.set(62);
        bitSet2.set(64);
        bitSet2.set(44);
        bitSet2.set(59);
        bitSet2.set(58);
        bitSet2.set(92);
        bitSet2.set(34);
        bitSet2.set(47);
        bitSet2.set(91);
        bitSet2.set(93);
        bitSet2.set(63);
        bitSet2.set(61);
        bitSet2.set(123);
        bitSet2.set(125);
        bitSet2.set(32);
        bitSet2.set(9);
        BitSet bitSet3 = new BitSet(Constants.ERR_WATERMARK_ARGB);
        TOKEN = bitSet3;
        bitSet3.set(0, Constants.ERR_WATERMARK_ARGB);
        bitSet3.andNot(bitSet);
        bitSet3.andNot(bitSet2);
    }

    public MimeType(String str) {
        this(str, WILDCARD_TYPE);
    }

    public MimeType(String str, String str2) {
        this(str, str2, (Map<String, String>) Collections.emptyMap());
    }

    public MimeType(String str, String str2, Charset charset) {
        this(str, str2, (Map<String, String>) Collections.singletonMap("charset", charset.name()));
    }

    public MimeType(MimeType mimeType, Charset charset) {
        this(mimeType.getType(), mimeType.getSubtype(), addCharsetParameter(charset, mimeType.getParameters()));
    }

    public MimeType(MimeType mimeType, Map<String, String> map) {
        this(mimeType.getType(), mimeType.getSubtype(), map);
    }

    public MimeType(String str, String str2, Map<String, String> map) {
        checkToken(str);
        checkToken(str2);
        this.type = str.toLowerCase(Locale.ENGLISH);
        this.subtype = str2.toLowerCase(Locale.ENGLISH);
        if (map == null || map.isEmpty()) {
            this.parameters = Collections.emptyMap();
            return;
        }
        LinkedCaseInsensitiveMap linkedCaseInsensitiveMap = new LinkedCaseInsensitiveMap(map.size(), Locale.ENGLISH);
        for (Map.Entry next : map.entrySet()) {
            String str3 = (String) next.getKey();
            String str4 = (String) next.getValue();
            checkParameters(str3, str4);
            linkedCaseInsensitiveMap.put(str3, str4);
        }
        this.parameters = Collections.unmodifiableMap(linkedCaseInsensitiveMap);
    }

    private void checkToken(String str) {
        int i = 0;
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (TOKEN.get(charAt)) {
                i++;
            } else {
                throw new IllegalArgumentException("Invalid token character '" + charAt + "' in token \"" + str + "\"");
            }
        }
    }

    /* access modifiers changed from: protected */
    public void checkParameters(String str, String str2) {
        Assert.hasLength(str, "'attribute' must not be empty.");
        Assert.hasLength(str2, "'value' must not be empty.");
        checkToken(str);
        if ("charset".equals(str)) {
            Charset.forName(unquote(str2));
        } else if (!isQuotedString(str2)) {
            checkToken(str2);
        }
    }

    private boolean isQuotedString(String str) {
        if (str.length() < 2) {
            return false;
        }
        if ((!str.startsWith("\"") || !str.endsWith("\"")) && (!str.startsWith("'") || !str.endsWith("'"))) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public String unquote(String str) {
        if (str == null) {
            return null;
        }
        return isQuotedString(str) ? str.substring(1, str.length() - 1) : str;
    }

    public boolean isWildcardType() {
        return WILDCARD_TYPE.equals(getType());
    }

    public boolean isWildcardSubtype() {
        return WILDCARD_TYPE.equals(getSubtype()) || getSubtype().startsWith("*+");
    }

    public boolean isConcrete() {
        return !isWildcardType() && !isWildcardSubtype();
    }

    public String getType() {
        return this.type;
    }

    public String getSubtype() {
        return this.subtype;
    }

    public Charset getCharset() {
        String parameter = getParameter("charset");
        if (parameter != null) {
            return Charset.forName(unquote(parameter));
        }
        return null;
    }

    public String getParameter(String str) {
        return this.parameters.get(str);
    }

    public Map<String, String> getParameters() {
        return this.parameters;
    }

    public boolean includes(MimeType mimeType) {
        if (mimeType == null) {
            return false;
        }
        if (isWildcardType()) {
            return true;
        }
        if (getType().equals(mimeType.getType())) {
            if (getSubtype().equals(mimeType.getSubtype())) {
                return true;
            }
            if (isWildcardSubtype()) {
                int indexOf = getSubtype().indexOf(43);
                if (indexOf == -1) {
                    return true;
                }
                int indexOf2 = mimeType.getSubtype().indexOf(43);
                if (indexOf2 != -1) {
                    return getSubtype().substring(indexOf + 1).equals(mimeType.getSubtype().substring(indexOf2 + 1)) && WILDCARD_TYPE.equals(getSubtype().substring(0, indexOf));
                }
            }
        }
    }

    public boolean isCompatibleWith(MimeType mimeType) {
        if (mimeType == null) {
            return false;
        }
        if (isWildcardType() || mimeType.isWildcardType()) {
            return true;
        }
        if (getType().equals(mimeType.getType())) {
            if (getSubtype().equals(mimeType.getSubtype())) {
                return true;
            }
            if (isWildcardSubtype() || mimeType.isWildcardSubtype()) {
                int indexOf = getSubtype().indexOf(43);
                int indexOf2 = mimeType.getSubtype().indexOf(43);
                if (indexOf == -1 && indexOf2 == -1) {
                    return true;
                }
                if (!(indexOf == -1 || indexOf2 == -1)) {
                    return getSubtype().substring(indexOf + 1).equals(mimeType.getSubtype().substring(indexOf2 + 1)) && (WILDCARD_TYPE.equals(getSubtype().substring(0, indexOf)) || WILDCARD_TYPE.equals(mimeType.getSubtype().substring(0, indexOf2)));
                }
            }
        }
    }

    public boolean equals(Object obj) {
        if (!equalsExcludeParameter(obj)) {
            return false;
        }
        return parametersAreEqual((MimeType) obj);
    }

    public boolean equalsExcludeParameter(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MimeType)) {
            return false;
        }
        MimeType mimeType = (MimeType) obj;
        if (!this.type.equalsIgnoreCase(mimeType.type) || !this.subtype.equalsIgnoreCase(mimeType.subtype)) {
            return false;
        }
        return true;
    }

    private boolean parametersAreEqual(MimeType mimeType) {
        if (this.parameters.size() != mimeType.parameters.size()) {
            return false;
        }
        for (String next : this.parameters.keySet()) {
            if (!mimeType.parameters.containsKey(next)) {
                return false;
            }
            if ("charset".equals(next)) {
                if (!ObjectUtils.nullSafeEquals(getCharset(), mimeType.getCharset())) {
                    return false;
                }
            } else if (!ObjectUtils.nullSafeEquals(this.parameters.get(next), mimeType.parameters.get(next))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        return (((this.type.hashCode() * 31) + this.subtype.hashCode()) * 31) + this.parameters.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        appendTo(sb);
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public void appendTo(StringBuilder sb) {
        sb.append(this.type);
        sb.append('/');
        sb.append(this.subtype);
        appendTo(this.parameters, sb);
    }

    private void appendTo(Map<String, String> map, StringBuilder sb) {
        for (Map.Entry next : map.entrySet()) {
            sb.append(';');
            sb.append((String) next.getKey());
            sb.append('=');
            sb.append((String) next.getValue());
        }
    }

    public int compareTo(MimeType mimeType) {
        int compareToIgnoreCase = getType().compareToIgnoreCase(mimeType.getType());
        if (compareToIgnoreCase != 0) {
            return compareToIgnoreCase;
        }
        int compareToIgnoreCase2 = getSubtype().compareToIgnoreCase(mimeType.getSubtype());
        if (compareToIgnoreCase2 != 0) {
            return compareToIgnoreCase2;
        }
        int size = getParameters().size() - mimeType.getParameters().size();
        if (size != 0) {
            return size;
        }
        TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        treeSet.addAll(getParameters().keySet());
        TreeSet treeSet2 = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        treeSet2.addAll(mimeType.getParameters().keySet());
        Iterator it = treeSet.iterator();
        Iterator it2 = treeSet2.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            String str2 = (String) it2.next();
            int compareToIgnoreCase3 = str.compareToIgnoreCase(str2);
            if (compareToIgnoreCase3 != 0) {
                return compareToIgnoreCase3;
            }
            String str3 = getParameters().get(str);
            String str4 = mimeType.getParameters().get(str2);
            if (str4 == null) {
                str4 = "";
            }
            int compareTo = str3.compareTo(str4);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return 0;
    }

    public static MimeType valueOf(String str) {
        if (StringUtils.hasLength(str)) {
            int indexOf = str.indexOf(59);
            String trim = (indexOf >= 0 ? str.substring(0, indexOf) : str).trim();
            if (!trim.isEmpty()) {
                if (WILDCARD_TYPE.equals(trim)) {
                    trim = MediaType.ALL_VALUE;
                }
                int indexOf2 = trim.indexOf(47);
                if (indexOf2 == -1) {
                    throw new InvalidMimeTypeException(str, "does not contain '/'");
                } else if (indexOf2 != trim.length() - 1) {
                    String substring = trim.substring(0, indexOf2);
                    String substring2 = trim.substring(indexOf2 + 1, trim.length());
                    if (!WILDCARD_TYPE.equals(substring) || WILDCARD_TYPE.equals(substring2)) {
                        LinkedHashMap linkedHashMap = null;
                        while (true) {
                            int i = indexOf + 1;
                            int i2 = i;
                            boolean z = false;
                            while (i2 < str.length()) {
                                char charAt = str.charAt(i2);
                                if (charAt == ';') {
                                    if (!z) {
                                        break;
                                    }
                                } else if (charAt == '\"') {
                                    z = !z;
                                }
                                i2++;
                            }
                            String trim2 = str.substring(i, i2).trim();
                            if (trim2.length() > 0) {
                                if (linkedHashMap == null) {
                                    linkedHashMap = new LinkedHashMap(4);
                                }
                                int indexOf3 = trim2.indexOf(61);
                                if (indexOf3 >= 0) {
                                    linkedHashMap.put(trim2.substring(0, indexOf3), trim2.substring(indexOf3 + 1, trim2.length()));
                                }
                            }
                            if (i2 >= str.length()) {
                                try {
                                    return new MimeType(substring, substring2, (Map<String, String>) linkedHashMap);
                                } catch (UnsupportedCharsetException e) {
                                    throw new InvalidMimeTypeException(str, "unsupported charset '" + e.getCharsetName() + "'");
                                } catch (IllegalArgumentException e2) {
                                    throw new InvalidMimeTypeException(str, e2.getMessage());
                                }
                            } else {
                                indexOf = i2;
                            }
                        }
                    } else {
                        throw new InvalidMimeTypeException(str, "wildcard type is legal only in '*/*' (all mime types)");
                    }
                } else {
                    throw new InvalidMimeTypeException(str, "does not contain subtype after '/'");
                }
            } else {
                throw new InvalidMimeTypeException(str, "'contentType' must not be empty");
            }
        } else {
            throw new InvalidMimeTypeException(str, "[mimeType] must not be empty");
        }
    }

    public static String toString(Collection<? extends MimeType> collection) {
        StringBuilder sb = new StringBuilder();
        Iterator<? extends MimeType> it = collection.iterator();
        while (it.hasNext()) {
            ((MimeType) it.next()).appendTo(sb);
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    private static Map<String, String> addCharsetParameter(Charset charset, Map<String, String> map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        linkedHashMap.put("charset", charset.name());
        return linkedHashMap;
    }

    public static class SpecificityComparator<T extends MimeType> implements Comparator<T> {
        public int compare(T t, T t2) {
            if (t.isWildcardType() && !t2.isWildcardType()) {
                return 1;
            }
            if (t2.isWildcardType() && !t.isWildcardType()) {
                return -1;
            }
            if (!t.getType().equals(t2.getType())) {
                return 0;
            }
            if (t.isWildcardSubtype() && !t2.isWildcardSubtype()) {
                return 1;
            }
            if (t2.isWildcardSubtype() && !t.isWildcardSubtype()) {
                return -1;
            }
            if (!t.getSubtype().equals(t2.getSubtype())) {
                return 0;
            }
            return compareParameters(t, t2);
        }

        /* access modifiers changed from: protected */
        public int compareParameters(T t, T t2) {
            int size = t.getParameters().size();
            int size2 = t2.getParameters().size();
            if (size2 < size) {
                return -1;
            }
            return size2 == size ? 0 : 1;
        }
    }
}
