package cyrilpillai.supernatives.utils.network;

import android.support.annotation.NonNull;
import android.util.Log;

import java.io.IOException;

import cyrilpillai.supernatives.BuildConfig;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import static cyrilpillai.supernatives.heroes_list.HeroesListActivity.TAG;

/**
 * Created by cyrilpillai on 11-11-2017.
 */

public class ServiceInterceptor implements Interceptor {
    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        HttpUrl url = chain.request().url()
                .newBuilder()
                .addQueryParameter("apikey", BuildConfig.SUPERHERO_API_KEY)
                .build();
        Request request = chain.request().newBuilder().url(url).build();
        Log.d(TAG, "intercept: " + request.url().toString());
        return chain.proceed(request);
    }
}
