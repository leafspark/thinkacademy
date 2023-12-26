package org.apache.httpcore;

public interface Header extends NameValuePair {
    HeaderElement[] getElements() throws ParseException;
}
