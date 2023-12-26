package com.amazonaws.auth.policy.resources;

import com.amazonaws.auth.policy.Resource;

public class S3ObjectResource extends Resource {
    public S3ObjectResource(String str, String str2) {
        this("aws", str, str2);
    }

    public S3ObjectResource(String str, String str2, String str3) {
        super(String.format("arn:%s:s3:::%s/%s", new Object[]{str, str2, str3}));
    }
}
