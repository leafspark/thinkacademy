package org.apache.httpcore;

import java.util.Iterator;

public interface HeaderIterator extends Iterator<Object> {
    boolean hasNext();

    Header nextHeader();
}
