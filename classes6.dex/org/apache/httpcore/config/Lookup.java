package org.apache.httpcore.config;

public interface Lookup<I> {
    I lookup(String str);
}
