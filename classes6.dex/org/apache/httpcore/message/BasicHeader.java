package org.apache.httpcore.message;

import java.io.Serializable;
import org.apache.httpcore.Header;
import org.apache.httpcore.HeaderElement;
import org.apache.httpcore.ParseException;
import org.apache.httpcore.util.Args;
import org.apache.httpcore.util.CharArrayBuffer;

public class BasicHeader implements Header, Cloneable, Serializable {
    private static final HeaderElement[] EMPTY_HEADER_ELEMENTS = new HeaderElement[0];
    private static final long serialVersionUID = -5427236326487562174L;
    private final String name;
    private final String value;

    public BasicHeader(String str, String str2) {
        this.name = (String) Args.notNull(str, "Name");
        this.value = str2;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public HeaderElement[] getElements() throws ParseException {
        if (getValue() != null) {
            return BasicHeaderValueParser.parseElements(getValue(), (HeaderValueParser) null);
        }
        return EMPTY_HEADER_ELEMENTS;
    }

    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.value;
    }

    public String toString() {
        return BasicLineFormatter.INSTANCE.formatHeader((CharArrayBuffer) null, (Header) this).toString();
    }
}
