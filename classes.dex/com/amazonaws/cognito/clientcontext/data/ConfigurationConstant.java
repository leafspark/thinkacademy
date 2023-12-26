package com.amazonaws.cognito.clientcontext.data;

import com.amazonaws.services.s3.internal.Constants;
import java.nio.charset.Charset;

public class ConfigurationConstant {
    public static final Charset DEFAULT_CHARSET = Charset.forName(Constants.DEFAULT_ENCODING);
}
