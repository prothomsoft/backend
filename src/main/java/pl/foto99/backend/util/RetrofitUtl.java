package pl.foto99.backend.util;

import okhttp3.OkHttpClient;
import pl.foto99.backend.config.RetrofitConstants;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.concurrent.TimeUnit;

public class RetrofitUtl {
    private static Retrofit retrofit = null;
    
    private static OkHttpClient client = null;

    public static Retrofit getRetrofitInstance() {

        if(client == null) {
            TokenInterceptor tokenInterceptor = new TokenInterceptor();
            client = new OkHttpClient.Builder()
                    .callTimeout(2, TimeUnit.MINUTES)
                    .connectTimeout(3600, TimeUnit.SECONDS)
                    .readTimeout(3600, TimeUnit.SECONDS)
                    .writeTimeout(3600, TimeUnit.SECONDS)
                    .addInterceptor(tokenInterceptor).build();
        }
        
        if (retrofit == null && client != null) {
            retrofit = new Retrofit.Builder().baseUrl(RetrofitConstants.QA_DEV).client(client).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
