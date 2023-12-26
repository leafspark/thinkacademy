package com.amazonaws.mobile.client;

public enum UserState {
    SIGNED_IN,
    GUEST,
    SIGNED_OUT_FEDERATED_TOKENS_INVALID,
    SIGNED_OUT_USER_POOLS_TOKENS_INVALID,
    SIGNED_OUT,
    UNKNOWN
}
