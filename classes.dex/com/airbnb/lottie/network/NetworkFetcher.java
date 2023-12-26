package com.airbnb.lottie.network;

import android.util.Pair;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieResult;
import com.airbnb.lottie.utils.Logger;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipInputStream;

public class NetworkFetcher {
    private final LottieNetworkFetcher fetcher;
    private final NetworkCache networkCache;

    public NetworkFetcher(NetworkCache networkCache2, LottieNetworkFetcher lottieNetworkFetcher) {
        this.networkCache = networkCache2;
        this.fetcher = lottieNetworkFetcher;
    }

    public LottieResult<LottieComposition> fetchSync(String str, String str2) {
        LottieComposition fetchFromCache = fetchFromCache(str, str2);
        if (fetchFromCache != null) {
            return new LottieResult<>(fetchFromCache);
        }
        Logger.debug("Animation for " + str + " not found in cache. Fetching from network.");
        return fetchFromNetwork(str, str2);
    }

    private LottieComposition fetchFromCache(String str, String str2) {
        Pair<FileExtension, InputStream> fetch;
        LottieResult<LottieComposition> lottieResult;
        if (str2 == null || (fetch = this.networkCache.fetch(str)) == null) {
            return null;
        }
        FileExtension fileExtension = (FileExtension) fetch.first;
        InputStream inputStream = (InputStream) fetch.second;
        if (fileExtension == FileExtension.ZIP) {
            lottieResult = LottieCompositionFactory.fromZipStreamSync(new ZipInputStream(inputStream), str);
        } else {
            lottieResult = LottieCompositionFactory.fromJsonInputStreamSync(inputStream, str);
        }
        if (lottieResult.getValue() != null) {
            return lottieResult.getValue();
        }
        return null;
    }

    private LottieResult<LottieComposition> fetchFromNetwork(String str, String str2) {
        Logger.debug("Fetching " + str);
        LottieFetchResult lottieFetchResult = null;
        try {
            lottieFetchResult = this.fetcher.fetchSync(str);
            if (lottieFetchResult.isSuccessful()) {
                LottieResult<LottieComposition> fromInputStream = fromInputStream(str, lottieFetchResult.bodyByteStream(), lottieFetchResult.contentType(), str2);
                StringBuilder sb = new StringBuilder();
                sb.append("Completed fetch from network. Success: ");
                sb.append(fromInputStream.getValue() != null);
                Logger.debug(sb.toString());
                if (lottieFetchResult != null) {
                    try {
                        lottieFetchResult.close();
                    } catch (IOException e) {
                        Logger.warning("LottieFetchResult close failed ", e);
                    }
                }
                return fromInputStream;
            }
            LottieResult<LottieComposition> lottieResult = new LottieResult<>((Throwable) new IllegalArgumentException(lottieFetchResult.error()));
            if (lottieFetchResult != null) {
                try {
                    lottieFetchResult.close();
                } catch (IOException e2) {
                    Logger.warning("LottieFetchResult close failed ", e2);
                }
            }
            return lottieResult;
        } catch (Exception e3) {
            LottieResult<LottieComposition> lottieResult2 = new LottieResult<>((Throwable) e3);
            if (lottieFetchResult != null) {
                try {
                    lottieFetchResult.close();
                } catch (IOException e4) {
                    Logger.warning("LottieFetchResult close failed ", e4);
                }
            }
            return lottieResult2;
        } catch (Throwable th) {
            if (lottieFetchResult != null) {
                try {
                    lottieFetchResult.close();
                } catch (IOException e5) {
                    Logger.warning("LottieFetchResult close failed ", e5);
                }
            }
            throw th;
        }
    }

    private LottieResult<LottieComposition> fromInputStream(String str, InputStream inputStream, String str2, String str3) throws IOException {
        FileExtension fileExtension;
        LottieResult<LottieComposition> lottieResult;
        if (str2 == null) {
            str2 = "application/json";
        }
        if (str2.contains("application/zip") || str2.contains("application/x-zip") || str2.contains("application/x-zip-compressed") || str.split("\\?")[0].endsWith(".lottie")) {
            Logger.debug("Handling zip response.");
            fileExtension = FileExtension.ZIP;
            lottieResult = fromZipStream(str, inputStream, str3);
        } else {
            Logger.debug("Received json response.");
            fileExtension = FileExtension.JSON;
            lottieResult = fromJsonStream(str, inputStream, str3);
        }
        if (!(str3 == null || lottieResult.getValue() == null)) {
            this.networkCache.renameTempFile(str, fileExtension);
        }
        return lottieResult;
    }

    private LottieResult<LottieComposition> fromZipStream(String str, InputStream inputStream, String str2) throws IOException {
        if (str2 == null) {
            return LottieCompositionFactory.fromZipStreamSync(new ZipInputStream(inputStream), (String) null);
        }
        return LottieCompositionFactory.fromZipStreamSync(new ZipInputStream(new FileInputStream(this.networkCache.writeTempCacheFile(str, inputStream, FileExtension.ZIP))), str);
    }

    private LottieResult<LottieComposition> fromJsonStream(String str, InputStream inputStream, String str2) throws IOException {
        if (str2 == null) {
            return LottieCompositionFactory.fromJsonInputStreamSync(inputStream, (String) null);
        }
        return LottieCompositionFactory.fromJsonInputStreamSync(new FileInputStream(this.networkCache.writeTempCacheFile(str, inputStream, FileExtension.JSON).getAbsolutePath()), str);
    }
}
