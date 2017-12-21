package UrlBuilder;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.net.URL;

public class UrlBuilder {

    static OkHttpClient ok = new OkHttpClient();

    public URL buildNewForecastRequestURL(String city, String APPID) {

        return new HttpUrl.Builder()
                .scheme("http")
                .host("api.openweathermap.org")
                .addPathSegments("/data/2.5/forecast")
                .addQueryParameter("q", city)
                .addQueryParameter("APPID", APPID)
                .addQueryParameter("units", "metric")
                .build().url();
    }

    public String getResponseBodyFromURL (URL url) throws IOException {
        Request request = new Request.Builder().url(url).build();
        try (Response response = ok.newCall(request).execute()) {
            return response.body().string();
        }
    }
}
