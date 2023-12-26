package com.yanzhenjie.andserver.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Properties;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TimeZone;

public abstract class StringUtils {
    private static final String CURRENT_PATH = ".";
    private static final char EXTENSION_SEPARATOR = '.';
    private static final String FOLDER_SEPARATOR = "/";
    private static final String TOP_PATH = "..";
    private static final String WINDOWS_FOLDER_SEPARATOR = "\\";

    public static boolean isEmpty(Object obj) {
        return obj == null || "".equals(obj);
    }

    public static boolean hasLength(CharSequence charSequence) {
        return charSequence != null && charSequence.length() > 0;
    }

    public static boolean hasLength(String str) {
        return str != null && !str.isEmpty();
    }

    public static boolean hasText(CharSequence charSequence) {
        return hasLength(charSequence) && containsText(charSequence);
    }

    public static boolean hasText(String str) {
        return hasLength(str) && containsText(str);
    }

    private static boolean containsText(CharSequence charSequence) {
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isWhitespace(charSequence.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsWhitespace(CharSequence charSequence) {
        if (!hasLength(charSequence)) {
            return false;
        }
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (Character.isWhitespace(charSequence.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsWhitespace(String str) {
        return containsWhitespace((CharSequence) str);
    }

    public static String trimWhitespace(String str) {
        if (!hasLength(str)) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        while (sb.length() > 0 && Character.isWhitespace(sb.charAt(0))) {
            sb.deleteCharAt(0);
        }
        while (sb.length() > 0 && Character.isWhitespace(sb.charAt(sb.length() - 1))) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    public static String trimAllWhitespace(String str) {
        if (!hasLength(str)) {
            return str;
        }
        int length = str.length();
        StringBuilder sb = new StringBuilder(str.length());
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (!Character.isWhitespace(charAt)) {
                sb.append(charAt);
            }
        }
        return sb.toString();
    }

    public static String trimLeadingWhitespace(String str) {
        if (!hasLength(str)) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        while (sb.length() > 0 && Character.isWhitespace(sb.charAt(0))) {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }

    public static String trimTrailingWhitespace(String str) {
        if (!hasLength(str)) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        while (sb.length() > 0 && Character.isWhitespace(sb.charAt(sb.length() - 1))) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    public static String trimLeadingCharacter(String str, char c) {
        if (!hasLength(str)) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        while (sb.length() > 0 && sb.charAt(0) == c) {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }

    public static String trimTrailingCharacter(String str, char c) {
        if (!hasLength(str)) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        while (sb.length() > 0 && sb.charAt(sb.length() - 1) == c) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    public static boolean startsWithIgnoreCase(String str, String str2) {
        if (!(str == null || str2 == null || str.length() < str2.length())) {
            if (str.regionMatches(true, 0, str2, 0, str2.length())) {
                return true;
            }
        }
        return false;
    }

    public static boolean endsWithIgnoreCase(String str, String str2) {
        if (!(str == null || str2 == null || str.length() < str2.length())) {
            if (str.regionMatches(true, str.length() - str2.length(), str2, 0, str2.length())) {
                return true;
            }
        }
        return false;
    }

    public static boolean substringMatch(CharSequence charSequence, int i, CharSequence charSequence2) {
        if (charSequence2.length() + i > charSequence.length()) {
            return false;
        }
        for (int i2 = 0; i2 < charSequence2.length(); i2++) {
            if (charSequence.charAt(i + i2) != charSequence2.charAt(i2)) {
                return false;
            }
        }
        return true;
    }

    public static int countOccurrencesOf(String str, String str2) {
        int i = 0;
        if (!hasLength(str) || !hasLength(str2)) {
            return 0;
        }
        int i2 = 0;
        while (true) {
            int indexOf = str.indexOf(str2, i);
            if (indexOf == -1) {
                return i2;
            }
            i2++;
            i = indexOf + str2.length();
        }
    }

    public static String replace(String str, String str2, String str3) {
        int indexOf;
        if (!hasLength(str) || !hasLength(str2) || str3 == null || (indexOf = str.indexOf(str2)) == -1) {
            return str;
        }
        int length = str.length();
        if (str3.length() > str2.length()) {
            length += 16;
        }
        StringBuilder sb = new StringBuilder(length);
        int i = 0;
        int length2 = str2.length();
        while (indexOf >= 0) {
            sb.append(str.substring(i, indexOf));
            sb.append(str3);
            i = indexOf + length2;
            indexOf = str.indexOf(str2, i);
        }
        sb.append(str.substring(i));
        return sb.toString();
    }

    public static String delete(String str, String str2) {
        return replace(str, str2, "");
    }

    public static String deleteAny(String str, String str2) {
        if (!hasLength(str) || !hasLength(str2)) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str.length());
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (str2.indexOf(charAt) == -1) {
                sb.append(charAt);
            }
        }
        return sb.toString();
    }

    public static String quote(String str) {
        if (str == null) {
            return null;
        }
        return "'" + str + "'";
    }

    public static Object quoteIfString(Object obj) {
        return obj instanceof String ? quote((String) obj) : obj;
    }

    public static String unqualify(String str) {
        return unqualify(str, EXTENSION_SEPARATOR);
    }

    public static String unqualify(String str, char c) {
        return str.substring(str.lastIndexOf(c) + 1);
    }

    public static String capitalize(String str) {
        return changeFirstCharacterCase(str, true);
    }

    public static String uncapitalize(String str) {
        return changeFirstCharacterCase(str, false);
    }

    private static String changeFirstCharacterCase(String str, boolean z) {
        char c;
        if (!hasLength(str)) {
            return str;
        }
        char charAt = str.charAt(0);
        if (z) {
            c = Character.toUpperCase(charAt);
        } else {
            c = Character.toLowerCase(charAt);
        }
        if (charAt == c) {
            return str;
        }
        char[] charArray = str.toCharArray();
        charArray[0] = c;
        return new String(charArray, 0, charArray.length);
    }

    public static String getFilename(String str) {
        if (str == null) {
            return null;
        }
        int lastIndexOf = str.lastIndexOf(FOLDER_SEPARATOR);
        return lastIndexOf != -1 ? str.substring(lastIndexOf + 1) : str;
    }

    public static String getFilenameExtension(String str) {
        int lastIndexOf;
        if (str == null || (lastIndexOf = str.lastIndexOf(46)) == -1 || str.lastIndexOf(FOLDER_SEPARATOR) > lastIndexOf) {
            return null;
        }
        return str.substring(lastIndexOf + 1);
    }

    public static String stripFilenameExtension(String str) {
        if (str == null) {
            return null;
        }
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf != -1 && str.lastIndexOf(FOLDER_SEPARATOR) <= lastIndexOf) {
            return str.substring(0, lastIndexOf);
        }
        return str;
    }

    public static String applyRelativePath(String str, String str2) {
        int lastIndexOf = str.lastIndexOf(FOLDER_SEPARATOR);
        if (lastIndexOf == -1) {
            return str2;
        }
        String substring = str.substring(0, lastIndexOf);
        if (!str2.startsWith(FOLDER_SEPARATOR)) {
            substring = substring + FOLDER_SEPARATOR;
        }
        return substring + str2;
    }

    public static String cleanPath(String str) {
        if (str == null) {
            return null;
        }
        String replace = replace(str, WINDOWS_FOLDER_SEPARATOR, FOLDER_SEPARATOR);
        int indexOf = replace.indexOf(":");
        String str2 = "";
        if (indexOf != -1) {
            int i = indexOf + 1;
            String substring = replace.substring(0, i);
            if (!substring.contains(FOLDER_SEPARATOR)) {
                replace = replace.substring(i);
                str2 = substring;
            }
        }
        if (replace.startsWith(FOLDER_SEPARATOR)) {
            str2 = str2 + FOLDER_SEPARATOR;
            replace = replace.substring(1);
        }
        String[] delimitedListToStringArray = delimitedListToStringArray(replace, FOLDER_SEPARATOR);
        LinkedList linkedList = new LinkedList();
        int i2 = 0;
        for (int length = delimitedListToStringArray.length - 1; length >= 0; length--) {
            String str3 = delimitedListToStringArray[length];
            if (!CURRENT_PATH.equals(str3)) {
                if (TOP_PATH.equals(str3)) {
                    i2++;
                } else if (i2 > 0) {
                    i2--;
                } else {
                    linkedList.add(0, str3);
                }
            }
        }
        for (int i3 = 0; i3 < i2; i3++) {
            linkedList.add(0, TOP_PATH);
        }
        return str2 + collectionToDelimitedString(linkedList, FOLDER_SEPARATOR);
    }

    public static boolean pathEquals(String str, String str2) {
        return cleanPath(str).equals(cleanPath(str2));
    }

    public static Locale parseLocaleString(String str) {
        String[] strArr = tokenizeToStringArray(str, "_ ", false, false);
        String str2 = "";
        String str3 = strArr.length > 0 ? strArr[0] : str2;
        String str4 = strArr.length > 1 ? strArr[1] : str2;
        validateLocalePart(str3);
        validateLocalePart(str4);
        if (strArr.length > 2) {
            str2 = trimLeadingWhitespace(str.substring(str.indexOf(str4, str3.length()) + str4.length()));
            if (str2.startsWith("_")) {
                str2 = trimLeadingCharacter(str2, '_');
            }
        }
        if (str3.length() > 0) {
            return new Locale(str3, str4, str2);
        }
        return null;
    }

    private static void validateLocalePart(String str) {
        int i = 0;
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (charAt == ' ' || charAt == '_' || charAt == '#' || Character.isLetterOrDigit(charAt)) {
                i++;
            } else {
                throw new IllegalArgumentException("Locale part \"" + str + "\" contains invalid characters");
            }
        }
    }

    public static String toLanguageTag(Locale locale) {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(locale.getLanguage());
        if (hasText(locale.getCountry())) {
            str = "-" + locale.getCountry();
        } else {
            str = "";
        }
        sb.append(str);
        return sb.toString();
    }

    public static TimeZone parseTimeZoneString(String str) {
        TimeZone timeZone = TimeZone.getTimeZone(str);
        if (!"GMT".equals(timeZone.getID()) || str.startsWith("GMT")) {
            return timeZone;
        }
        throw new IllegalArgumentException("Invalid time zone specification '" + str + "'");
    }

    public static String[] addStringToArray(String[] strArr, String str) {
        if (ObjectUtils.isEmpty((Object[]) strArr)) {
            return new String[]{str};
        }
        String[] strArr2 = new String[(strArr.length + 1)];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        strArr2[strArr.length] = str;
        return strArr2;
    }

    public static String[] concatenateStringArrays(String[] strArr, String[] strArr2) {
        if (ObjectUtils.isEmpty((Object[]) strArr)) {
            return strArr2;
        }
        if (ObjectUtils.isEmpty((Object[]) strArr2)) {
            return strArr;
        }
        String[] strArr3 = new String[(strArr.length + strArr2.length)];
        System.arraycopy(strArr, 0, strArr3, 0, strArr.length);
        System.arraycopy(strArr2, 0, strArr3, strArr.length, strArr2.length);
        return strArr3;
    }

    public static String[] mergeStringArrays(String[] strArr, String[] strArr2) {
        if (ObjectUtils.isEmpty((Object[]) strArr)) {
            return strArr2;
        }
        if (ObjectUtils.isEmpty((Object[]) strArr2)) {
            return strArr;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(Arrays.asList(strArr));
        for (String str : strArr2) {
            if (!arrayList.contains(str)) {
                arrayList.add(str);
            }
        }
        return toStringArray((Collection<String>) arrayList);
    }

    public static String[] sortStringArray(String[] strArr) {
        if (ObjectUtils.isEmpty((Object[]) strArr)) {
            return new String[0];
        }
        Arrays.sort(strArr);
        return strArr;
    }

    public static String[] toStringArray(Collection<String> collection) {
        if (collection == null) {
            return null;
        }
        return (String[]) collection.toArray(new String[collection.size()]);
    }

    public static String[] toStringArray(Enumeration<String> enumeration) {
        if (enumeration == null) {
            return null;
        }
        ArrayList<T> list = Collections.list(enumeration);
        return (String[]) list.toArray(new String[list.size()]);
    }

    public static String[] trimArrayElements(String[] strArr) {
        if (ObjectUtils.isEmpty((Object[]) strArr)) {
            return new String[0];
        }
        String[] strArr2 = new String[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            String str = strArr[i];
            strArr2[i] = str != null ? str.trim() : null;
        }
        return strArr2;
    }

    public static String[] removeDuplicateStrings(String[] strArr) {
        if (ObjectUtils.isEmpty((Object[]) strArr)) {
            return strArr;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (String add : strArr) {
            linkedHashSet.add(add);
        }
        return toStringArray((Collection<String>) linkedHashSet);
    }

    public static String[] split(String str, String str2) {
        int indexOf;
        if (!hasLength(str) || !hasLength(str2) || (indexOf = str.indexOf(str2)) < 0) {
            return null;
        }
        return new String[]{str.substring(0, indexOf), str.substring(indexOf + str2.length())};
    }

    public static Properties splitArrayElementsIntoProperties(String[] strArr, String str) {
        return splitArrayElementsIntoProperties(strArr, str, (String) null);
    }

    public static Properties splitArrayElementsIntoProperties(String[] strArr, String str, String str2) {
        if (ObjectUtils.isEmpty((Object[]) strArr)) {
            return null;
        }
        Properties properties = new Properties();
        for (String str3 : strArr) {
            if (str2 != null) {
                str3 = deleteAny(str3, str2);
            }
            String[] split = split(str3, str);
            if (split != null) {
                properties.setProperty(split[0].trim(), split[1].trim());
            }
        }
        return properties;
    }

    public static String[] tokenizeToStringArray(String str, String str2) {
        return tokenizeToStringArray(str, str2, true, true);
    }

    public static String[] tokenizeToStringArray(String str, String str2, boolean z, boolean z2) {
        if (str == null) {
            return null;
        }
        StringTokenizer stringTokenizer = new StringTokenizer(str, str2);
        ArrayList arrayList = new ArrayList();
        while (stringTokenizer.hasMoreTokens()) {
            String nextToken = stringTokenizer.nextToken();
            if (z) {
                nextToken = nextToken.trim();
            }
            if (!z2 || nextToken.length() > 0) {
                arrayList.add(nextToken);
            }
        }
        return toStringArray((Collection<String>) arrayList);
    }

    public static String[] delimitedListToStringArray(String str, String str2) {
        return delimitedListToStringArray(str, str2, (String) null);
    }

    public static String[] delimitedListToStringArray(String str, String str2, String str3) {
        int i = 0;
        if (str == null) {
            return new String[0];
        }
        if (str2 == null) {
            return new String[]{str};
        }
        ArrayList arrayList = new ArrayList();
        if ("".equals(str2)) {
            while (i < str.length()) {
                int i2 = i + 1;
                arrayList.add(deleteAny(str.substring(i, i2), str3));
                i = i2;
            }
        } else {
            while (true) {
                int indexOf = str.indexOf(str2, i);
                if (indexOf == -1) {
                    break;
                }
                arrayList.add(deleteAny(str.substring(i, indexOf), str3));
                i = str2.length() + indexOf;
            }
            if (str.length() > 0 && i <= str.length()) {
                arrayList.add(deleteAny(str.substring(i), str3));
            }
        }
        return toStringArray((Collection<String>) arrayList);
    }

    public static String[] commaDelimitedListToStringArray(String str) {
        return delimitedListToStringArray(str, ",");
    }

    public static Set<String> commaDelimitedListToSet(String str) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (String add : commaDelimitedListToStringArray(str)) {
            linkedHashSet.add(add);
        }
        return linkedHashSet;
    }

    public static String collectionToDelimitedString(Collection<?> collection, String str, String str2, String str3) {
        if (CollectionUtils.isEmpty(collection)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            sb.append(str2);
            sb.append(it.next());
            sb.append(str3);
            if (it.hasNext()) {
                sb.append(str);
            }
        }
        return sb.toString();
    }

    public static String collectionToDelimitedString(Collection<?> collection, String str) {
        return collectionToDelimitedString(collection, str, "", "");
    }

    public static String collectionToCommaDelimitedString(Collection<?> collection) {
        return collectionToDelimitedString(collection, ",");
    }

    public static String arrayToDelimitedString(Object[] objArr, String str) {
        if (ObjectUtils.isEmpty(objArr)) {
            return "";
        }
        if (objArr.length == 1) {
            return ObjectUtils.nullSafeToString(objArr[0]);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < objArr.length; i++) {
            if (i > 0) {
                sb.append(str);
            }
            sb.append(objArr[i]);
        }
        return sb.toString();
    }

    public static String arrayToCommaDelimitedString(Object[] objArr) {
        return arrayToDelimitedString(objArr, ",");
    }
}
