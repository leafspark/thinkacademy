package androidx.camera.core.impl;

public interface CamcorderProfileProvider {
    public static final CamcorderProfileProvider EMPTY = new CamcorderProfileProvider() {
        public CamcorderProfileProxy get(int i) {
            return null;
        }

        public boolean hasProfile(int i) {
            return false;
        }
    };

    CamcorderProfileProxy get(int i);

    boolean hasProfile(int i);
}
