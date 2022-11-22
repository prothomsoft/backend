package pl.foto99.backend.util;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class TokenInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        String bearer = "token 123";
        Request newRequest=chain.request().newBuilder()
                .header("Authorization","Bearer " + bearer)
                .build();

        return chain.proceed(newRequest);
    }
}
