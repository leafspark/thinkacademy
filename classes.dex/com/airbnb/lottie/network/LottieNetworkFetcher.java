package com.airbnb.lottie.network;

import java.io.IOException;

public interface LottieNetworkFetcher {
    LottieFetchResult fetchSync(String str) throws IOException;
}
