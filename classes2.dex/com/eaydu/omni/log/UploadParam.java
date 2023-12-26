package com.eaydu.omni.log;

import com.didi.hummer.adapter.http.IHttpAdapter;

public class UploadParam {
    public String callback = "";
    public String fileName = "";
    public String filePath = "";
    public String host = "";
    public String key = "";
    public String method = IHttpAdapter.METHOD_POST;
    public String ossAccessKeyId = "";
    public String policy = "";
    public String signature = "";
    public String successActionStatus = "";

    UploadParam() {
    }
}
