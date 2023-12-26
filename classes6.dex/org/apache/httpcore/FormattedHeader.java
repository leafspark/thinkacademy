package org.apache.httpcore;

import org.apache.httpcore.util.CharArrayBuffer;

public interface FormattedHeader extends Header {
    CharArrayBuffer getBuffer();

    int getValuePos();
}
