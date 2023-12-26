package org.apache.httpcore.entity;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.httpcore.Consts;
import org.apache.httpcore.Header;
import org.apache.httpcore.HeaderElement;
import org.apache.httpcore.HttpEntity;
import org.apache.httpcore.NameValuePair;
import org.apache.httpcore.ParseException;
import org.apache.httpcore.message.BasicHeaderValueFormatter;
import org.apache.httpcore.message.BasicHeaderValueParser;
import org.apache.httpcore.message.BasicNameValuePair;
import org.apache.httpcore.message.ParserCursor;
import org.apache.httpcore.protocol.HTTP;
import org.apache.httpcore.util.Args;
import org.apache.httpcore.util.CharArrayBuffer;
import org.apache.httpcore.util.TextUtils;

public final class ContentType implements Serializable {
    public static final ContentType APPLICATION_ATOM_XML;
    public static final ContentType APPLICATION_FORM_URLENCODED;
    public static final ContentType APPLICATION_JSON;
    public static final ContentType APPLICATION_OCTET_STREAM;
    public static final ContentType APPLICATION_SOAP_XML = create("application/soap+xml", Consts.UTF_8);
    public static final ContentType APPLICATION_SVG_XML;
    public static final ContentType APPLICATION_XHTML_XML;
    public static final ContentType APPLICATION_XML;
    private static final Map<String, ContentType> CONTENT_TYPE_MAP;
    public static final ContentType DEFAULT_BINARY = APPLICATION_OCTET_STREAM;
    public static final ContentType DEFAULT_TEXT = TEXT_PLAIN;
    public static final ContentType IMAGE_BMP;
    public static final ContentType IMAGE_GIF;
    public static final ContentType IMAGE_JPEG;
    public static final ContentType IMAGE_PNG;
    public static final ContentType IMAGE_SVG;
    public static final ContentType IMAGE_TIFF;
    public static final ContentType IMAGE_WEBP;
    public static final ContentType MULTIPART_FORM_DATA;
    public static final ContentType TEXT_HTML;
    public static final ContentType TEXT_PLAIN;
    public static final ContentType TEXT_XML;
    public static final ContentType WILDCARD;
    private static final long serialVersionUID = -7768694718232371896L;
    private final Charset charset;
    private final String mimeType;
    private final NameValuePair[] params;

    static {
        ContentType create = create("application/atom+xml", Consts.ISO_8859_1);
        APPLICATION_ATOM_XML = create;
        ContentType create2 = create("application/x-www-form-urlencoded", Consts.ISO_8859_1);
        APPLICATION_FORM_URLENCODED = create2;
        ContentType create3 = create("application/json", Consts.UTF_8);
        APPLICATION_JSON = create3;
        Charset charset2 = null;
        APPLICATION_OCTET_STREAM = create("application/octet-stream", charset2);
        ContentType create4 = create("application/svg+xml", Consts.ISO_8859_1);
        APPLICATION_SVG_XML = create4;
        ContentType create5 = create("application/xhtml+xml", Consts.ISO_8859_1);
        APPLICATION_XHTML_XML = create5;
        ContentType create6 = create("application/xml", Consts.ISO_8859_1);
        APPLICATION_XML = create6;
        ContentType create7 = create("image/bmp");
        IMAGE_BMP = create7;
        ContentType create8 = create("image/gif");
        IMAGE_GIF = create8;
        ContentType create9 = create("image/jpeg");
        IMAGE_JPEG = create9;
        ContentType create10 = create("image/png");
        IMAGE_PNG = create10;
        ContentType create11 = create("image/svg+xml");
        IMAGE_SVG = create11;
        ContentType create12 = create("image/tiff");
        IMAGE_TIFF = create12;
        ContentType create13 = create("image/webp");
        IMAGE_WEBP = create13;
        ContentType create14 = create(FileUploadBase.MULTIPART_FORM_DATA, Consts.ISO_8859_1);
        MULTIPART_FORM_DATA = create14;
        ContentType contentType = create14;
        ContentType create15 = create("text/html", Consts.ISO_8859_1);
        TEXT_HTML = create15;
        ContentType contentType2 = create15;
        ContentType create16 = create(HTTP.PLAIN_TEXT_TYPE, Consts.ISO_8859_1);
        TEXT_PLAIN = create16;
        ContentType contentType3 = create16;
        ContentType create17 = create("text/xml", Consts.ISO_8859_1);
        TEXT_XML = create17;
        WILDCARD = create("*/*", charset2);
        ContentType[] contentTypeArr = {create, create2, create3, create4, create5, create6, create7, create8, create9, create10, create11, create12, create13, contentType, contentType2, contentType3, create17};
        HashMap hashMap = new HashMap();
        for (int i = 0; i < 17; i++) {
            ContentType contentType4 = contentTypeArr[i];
            hashMap.put(contentType4.getMimeType(), contentType4);
        }
        CONTENT_TYPE_MAP = Collections.unmodifiableMap(hashMap);
    }

    ContentType(String str, Charset charset2) {
        this.mimeType = str;
        this.charset = charset2;
        this.params = null;
    }

    ContentType(String str, Charset charset2, NameValuePair[] nameValuePairArr) {
        this.mimeType = str;
        this.charset = charset2;
        this.params = nameValuePairArr;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public Charset getCharset() {
        return this.charset;
    }

    public String getParameter(String str) {
        Args.notEmpty(str, "Parameter name");
        NameValuePair[] nameValuePairArr = this.params;
        if (nameValuePairArr == null) {
            return null;
        }
        for (NameValuePair nameValuePair : nameValuePairArr) {
            if (nameValuePair.getName().equalsIgnoreCase(str)) {
                return nameValuePair.getValue();
            }
        }
        return null;
    }

    public String toString() {
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(64);
        charArrayBuffer.append(this.mimeType);
        if (this.params != null) {
            charArrayBuffer.append("; ");
            BasicHeaderValueFormatter.INSTANCE.formatParameters(charArrayBuffer, this.params, false);
        } else if (this.charset != null) {
            charArrayBuffer.append(HTTP.CHARSET_PARAM);
            charArrayBuffer.append(this.charset.name());
        }
        return charArrayBuffer.toString();
    }

    private static boolean valid(String str) {
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt == '\"' || charAt == ',' || charAt == ';') {
                return false;
            }
        }
        return true;
    }

    public static ContentType create(String str, Charset charset2) {
        String lowerCase = ((String) Args.notBlank(str, "MIME type")).toLowerCase(Locale.ROOT);
        Args.check(valid(lowerCase), "MIME type may not contain reserved characters");
        return new ContentType(lowerCase, charset2);
    }

    public static ContentType create(String str) {
        return create(str, (Charset) null);
    }

    public static ContentType create(String str, String str2) throws UnsupportedCharsetException {
        return create(str, !TextUtils.isBlank(str2) ? Charset.forName(str2) : null);
    }

    private static ContentType create(HeaderElement headerElement, boolean z) {
        return create(headerElement.getName(), headerElement.getParameters(), z);
    }

    private static ContentType create(String str, NameValuePair[] nameValuePairArr, boolean z) {
        Charset charset2;
        int length = nameValuePairArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            NameValuePair nameValuePair = nameValuePairArr[i];
            if (nameValuePair.getName().equalsIgnoreCase("charset")) {
                String value = nameValuePair.getValue();
                if (!TextUtils.isBlank(value)) {
                    try {
                        charset2 = Charset.forName(value);
                    } catch (UnsupportedCharsetException e) {
                        if (z) {
                            throw e;
                        }
                    }
                }
            } else {
                i++;
            }
        }
        charset2 = null;
        if (nameValuePairArr == null || nameValuePairArr.length <= 0) {
            nameValuePairArr = null;
        }
        return new ContentType(str, charset2, nameValuePairArr);
    }

    public static ContentType create(String str, NameValuePair... nameValuePairArr) throws UnsupportedCharsetException {
        Args.check(valid(((String) Args.notBlank(str, "MIME type")).toLowerCase(Locale.ROOT)), "MIME type may not contain reserved characters");
        return create(str, nameValuePairArr, true);
    }

    public static ContentType parse(String str) throws ParseException, UnsupportedCharsetException {
        Args.notNull(str, "Content type");
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(str.length());
        charArrayBuffer.append(str);
        HeaderElement[] parseElements = BasicHeaderValueParser.INSTANCE.parseElements(charArrayBuffer, new ParserCursor(0, str.length()));
        if (parseElements.length > 0) {
            return create(parseElements[0], true);
        }
        throw new ParseException("Invalid content type: " + str);
    }

    public static ContentType get(HttpEntity httpEntity) throws ParseException, UnsupportedCharsetException {
        Header contentType;
        if (!(httpEntity == null || (contentType = httpEntity.getContentType()) == null)) {
            HeaderElement[] elements = contentType.getElements();
            if (elements.length > 0) {
                return create(elements[0], true);
            }
        }
        return null;
    }

    public static ContentType getLenient(HttpEntity httpEntity) {
        Header contentType;
        if (!(httpEntity == null || (contentType = httpEntity.getContentType()) == null)) {
            try {
                HeaderElement[] elements = contentType.getElements();
                if (elements.length > 0) {
                    return create(elements[0], false);
                }
            } catch (ParseException unused) {
            }
        }
        return null;
    }

    public static ContentType getOrDefault(HttpEntity httpEntity) throws ParseException, UnsupportedCharsetException {
        ContentType contentType = get(httpEntity);
        return contentType != null ? contentType : DEFAULT_TEXT;
    }

    public static ContentType getLenientOrDefault(HttpEntity httpEntity) throws ParseException, UnsupportedCharsetException {
        ContentType contentType = get(httpEntity);
        return contentType != null ? contentType : DEFAULT_TEXT;
    }

    public static ContentType getByMimeType(String str) {
        if (str == null) {
            return null;
        }
        return CONTENT_TYPE_MAP.get(str);
    }

    public ContentType withCharset(Charset charset2) {
        return create(getMimeType(), charset2);
    }

    public ContentType withCharset(String str) {
        return create(getMimeType(), str);
    }

    public ContentType withParameters(NameValuePair... nameValuePairArr) throws UnsupportedCharsetException {
        if (nameValuePairArr.length == 0) {
            return this;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        NameValuePair[] nameValuePairArr2 = this.params;
        if (nameValuePairArr2 != null) {
            for (NameValuePair nameValuePair : nameValuePairArr2) {
                linkedHashMap.put(nameValuePair.getName(), nameValuePair.getValue());
            }
        }
        for (NameValuePair nameValuePair2 : nameValuePairArr) {
            linkedHashMap.put(nameValuePair2.getName(), nameValuePair2.getValue());
        }
        ArrayList arrayList = new ArrayList(linkedHashMap.size() + 1);
        if (this.charset != null && !linkedHashMap.containsKey("charset")) {
            arrayList.add(new BasicNameValuePair("charset", this.charset.name()));
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            arrayList.add(new BasicNameValuePair((String) entry.getKey(), (String) entry.getValue()));
        }
        return create(getMimeType(), (NameValuePair[]) arrayList.toArray(new NameValuePair[arrayList.size()]), true);
    }
}
