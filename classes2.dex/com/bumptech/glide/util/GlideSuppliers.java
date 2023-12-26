package com.bumptech.glide.util;

public final class GlideSuppliers {

    public interface GlideSupplier<T> {
        T get();
    }

    private GlideSuppliers() {
    }

    public static <T> GlideSupplier<T> memorize(final GlideSupplier<T> glideSupplier) {
        return new GlideSupplier<T>() {
            private volatile T instance;

            public T get() {
                if (this.instance == null) {
                    synchronized (this) {
                        if (this.instance == null) {
                            this.instance = Preconditions.checkNotNull(GlideSupplier.this.get());
                        }
                    }
                }
                return this.instance;
            }
        };
    }
}
