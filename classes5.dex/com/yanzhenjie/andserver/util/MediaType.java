package com.yanzhenjie.andserver.util;

import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.yanzhenjie.andserver.error.InvalidMediaTypeException;
import com.yanzhenjie.andserver.error.InvalidMimeTypeException;
import com.yanzhenjie.andserver.util.MimeType;
import com.yanzhenjie.andserver.util.comparator.CompoundComparator;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MediaType extends MimeType implements Serializable {
    public static final MediaType ALL = valueOf(ALL_VALUE);
    public static final String ALL_VALUE = "*/*";
    public static final MediaType APPLICATION_ATOM_XML = valueOf(APPLICATION_ATOM_XML_VALUE);
    public static final String APPLICATION_ATOM_XML_VALUE = "application/atom+xml";
    public static final MediaType APPLICATION_FORM_URLENCODED = valueOf(APPLICATION_FORM_URLENCODED_VALUE);
    public static final String APPLICATION_FORM_URLENCODED_VALUE = "application/x-www-form-urlencoded";
    public static final MediaType APPLICATION_JSON = valueOf(APPLICATION_JSON_VALUE);
    public static final MediaType APPLICATION_JSON_UTF8 = valueOf(APPLICATION_JSON_UTF8_VALUE);
    public static final String APPLICATION_JSON_UTF8_VALUE = "application/json;charset=UTF-8";
    public static final String APPLICATION_JSON_VALUE = "application/json";
    public static final MediaType APPLICATION_OCTET_STREAM = valueOf(APPLICATION_OCTET_STREAM_VALUE);
    public static final String APPLICATION_OCTET_STREAM_VALUE = "application/octet-stream";
    public static final MediaType APPLICATION_PDF = valueOf(APPLICATION_PDF_VALUE);
    public static final String APPLICATION_PDF_VALUE = "application/pdf";
    public static final MediaType APPLICATION_RSS_XML = valueOf(APPLICATION_RSS_XML_VALUE);
    public static final String APPLICATION_RSS_XML_VALUE = "application/rss+xml";
    public static final MediaType APPLICATION_XHTML_XML = valueOf(APPLICATION_XHTML_XML_VALUE);
    public static final String APPLICATION_XHTML_XML_VALUE = "application/xhtml+xml";
    public static final MediaType APPLICATION_XML = valueOf(APPLICATION_XML_VALUE);
    public static final MediaType APPLICATION_XML_UTF8 = valueOf(APPLICATION_XML_UTF8_VALUE);
    public static final String APPLICATION_XML_UTF8_VALUE = "application/xml;charset=UTF-8";
    public static final String APPLICATION_XML_VALUE = "application/xml";
    public static final MediaType IMAGE_GIF = valueOf(IMAGE_GIF_VALUE);
    public static final String IMAGE_GIF_VALUE = "image/gif";
    public static final MediaType IMAGE_JPEG = valueOf(IMAGE_JPEG_VALUE);
    public static final String IMAGE_JPEG_VALUE = "image/jpeg";
    public static final MediaType IMAGE_PNG = valueOf(IMAGE_PNG_VALUE);
    public static final String IMAGE_PNG_VALUE = "image/png";
    public static final MediaType MULTIPART_FORM_DATA = valueOf(MULTIPART_FORM_DATA_VALUE);
    public static final String MULTIPART_FORM_DATA_VALUE = "multipart/form-data";
    private static final String PARAM_QUALITY_FACTOR = "q";
    public static final Comparator<MediaType> QUALITY_VALUE_COMPARATOR = new Comparator<MediaType>() {
        public int compare(MediaType mediaType, MediaType mediaType2) {
            int compare = Double.compare(mediaType2.getQualityValue(), mediaType.getQualityValue());
            if (compare != 0) {
                return compare;
            }
            if (mediaType.isWildcardType() && !mediaType2.isWildcardType()) {
                return 1;
            }
            if (mediaType2.isWildcardType() && !mediaType.isWildcardType()) {
                return -1;
            }
            if (!mediaType.getType().equals(mediaType2.getType())) {
                return 0;
            }
            if (mediaType.isWildcardSubtype() && !mediaType2.isWildcardSubtype()) {
                return 1;
            }
            if (mediaType2.isWildcardSubtype() && !mediaType.isWildcardSubtype()) {
                return -1;
            }
            if (!mediaType.getSubtype().equals(mediaType2.getSubtype())) {
                return 0;
            }
            int size = mediaType.getParameters().size();
            int size2 = mediaType2.getParameters().size();
            if (size2 < size) {
                return -1;
            }
            if (size2 == size) {
                return 0;
            }
            return 1;
        }
    };
    public static final Comparator<MediaType> SPECIFICITY_COMPARATOR = new MimeType.SpecificityComparator<MediaType>() {
        /* access modifiers changed from: protected */
        public int compareParameters(MediaType mediaType, MediaType mediaType2) {
            int compare = Double.compare(mediaType2.getQualityValue(), mediaType.getQualityValue());
            if (compare != 0) {
                return compare;
            }
            return super.compareParameters(mediaType, mediaType2);
        }
    };
    public static final MediaType TEXT_EVENT_STREAM = valueOf(TEXT_EVENT_STREAM_VALUE);
    public static final String TEXT_EVENT_STREAM_VALUE = "text/event-stream";
    public static final MediaType TEXT_HTML = valueOf(TEXT_HTML_VALUE);
    public static final String TEXT_HTML_VALUE = "text/html";
    public static final MediaType TEXT_MARKDOWN = valueOf(TEXT_MARKDOWN_VALUE);
    public static final String TEXT_MARKDOWN_VALUE = "text/markdown";
    public static final MediaType TEXT_PLAIN = valueOf(TEXT_PLAIN_VALUE);
    public static final String TEXT_PLAIN_VALUE = "text/plain";
    public static final MediaType TEXT_XML = valueOf(TEXT_XML_VALUE);
    public static final String TEXT_XML_VALUE = "text/xml";

    public MediaType(String str) {
        super(str);
    }

    public MediaType(String str, String str2) {
        super(str, str2, (Map<String, String>) Collections.emptyMap());
    }

    public MediaType(String str, String str2, Charset charset) {
        super(str, str2, charset);
    }

    public MediaType(String str, String str2, double d) {
        this(str, str2, (Map<String, String>) Collections.singletonMap(PARAM_QUALITY_FACTOR, Double.toString(d)));
    }

    public MediaType(MediaType mediaType, Charset charset) {
        super((MimeType) mediaType, charset);
    }

    public MediaType(MediaType mediaType, Map<String, String> map) {
        super(mediaType.getType(), mediaType.getSubtype(), map);
    }

    public MediaType(String str, String str2, Map<String, String> map) {
        super(str, str2, map);
    }

    /* access modifiers changed from: protected */
    public void checkParameters(String str, String str2) {
        super.checkParameters(str, str2);
        if (PARAM_QUALITY_FACTOR.equals(str)) {
            String unquote = unquote(str2);
            double parseDouble = Double.parseDouble(unquote);
            Assert.isTrue(parseDouble >= 0.0d && parseDouble <= 1.0d, "Invalid quality value '" + unquote + "': should be between 0.0 and 1.0");
        }
    }

    public double getQualityValue() {
        String parameter = getParameter(PARAM_QUALITY_FACTOR);
        if (parameter != null) {
            return Double.parseDouble(unquote(parameter));
        }
        return 1.0d;
    }

    public boolean includes(MediaType mediaType) {
        return super.includes(mediaType);
    }

    public boolean isCompatibleWith(MediaType mediaType) {
        return super.isCompatibleWith(mediaType);
    }

    public MediaType copyQualityValue(MediaType mediaType) {
        if (!mediaType.getParameters().containsKey(PARAM_QUALITY_FACTOR)) {
            return this;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(getParameters());
        linkedHashMap.put(PARAM_QUALITY_FACTOR, mediaType.getParameters().get(PARAM_QUALITY_FACTOR));
        return new MediaType(this, (Map<String, String>) linkedHashMap);
    }

    public MediaType removeQualityValue() {
        if (!getParameters().containsKey(PARAM_QUALITY_FACTOR)) {
            return this;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(getParameters());
        linkedHashMap.remove(PARAM_QUALITY_FACTOR);
        return new MediaType(this, (Map<String, String>) linkedHashMap);
    }

    public static MediaType valueOf(String str) {
        return parseMediaType(str);
    }

    public static MediaType parseMediaType(String str) {
        try {
            MimeType valueOf = MimeType.valueOf(str);
            try {
                return new MediaType(valueOf.getType(), valueOf.getSubtype(), valueOf.getParameters());
            } catch (IllegalArgumentException e) {
                throw new InvalidMediaTypeException(str, e.getMessage());
            }
        } catch (InvalidMimeTypeException e2) {
            throw new InvalidMediaTypeException(e2);
        }
    }

    public static List<MediaType> parseMediaTypes(String str) {
        if (StringUtils.isEmpty(str)) {
            return Collections.emptyList();
        }
        String[] strArr = StringUtils.tokenizeToStringArray(str, ",");
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String parseMediaType : strArr) {
            arrayList.add(parseMediaType(parseMediaType));
        }
        return arrayList;
    }

    public static List<MediaType> parseMediaTypes(List<String> list) {
        if (CollectionUtils.isEmpty((Collection<?>) list)) {
            return Collections.emptyList();
        }
        if (list.size() == 1) {
            return parseMediaTypes(list.get(0));
        }
        ArrayList arrayList = new ArrayList(8);
        for (String parseMediaTypes : list) {
            arrayList.addAll(parseMediaTypes(parseMediaTypes));
        }
        return arrayList;
    }

    public static void sortBySpecificity(List<MediaType> list) {
        Assert.notNull(list, "'mediaTypes' must not be null");
        if (list.size() > 1) {
            Collections.sort(list, SPECIFICITY_COMPARATOR);
        }
    }

    public static void sortByQualityValue(List<MediaType> list) {
        Assert.notNull(list, "'mediaTypes' must not be null");
        if (list.size() > 1) {
            Collections.sort(list, QUALITY_VALUE_COMPARATOR);
        }
    }

    public static void sortBySpecificityAndQuality(List<MediaType> list) {
        Assert.notNull(list, "'mediaTypes' must not be null");
        if (list.size() > 1) {
            Collections.sort(list, new CompoundComparator(SPECIFICITY_COMPARATOR, QUALITY_VALUE_COMPARATOR));
        }
    }

    public static MediaType getFileMediaType(String str) {
        String urlExtension = getUrlExtension(str);
        if (!MimeTypeMap.getSingleton().hasExtension(urlExtension)) {
            return APPLICATION_OCTET_STREAM;
        }
        try {
            return parseMediaType(MimeTypeMap.getSingleton().getMimeTypeFromExtension(urlExtension));
        } catch (Exception unused) {
            return APPLICATION_OCTET_STREAM;
        }
    }

    public static String getUrlExtension(String str) {
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(str);
        return TextUtils.isEmpty(fileExtensionFromUrl) ? "" : fileExtensionFromUrl;
    }
}
