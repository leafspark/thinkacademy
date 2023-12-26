package com.amazonaws.services.s3.model;

import java.util.Map;

@Deprecated
public interface EncryptionMaterialsAccessor {
    EncryptionMaterials getEncryptionMaterials(Map<String, String> map);
}
