package ir.ea2.android_mvvm_restful.remote;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroClass {
    //All Request Go To This Path.
    private static  final  String BASE_URL="http://www.json-generator.com";
    private static Retrofit getRetroInstance()
    {
        //Create Builder For Gson .
        Gson gson = new GsonBuilder().setLenient().create();
        //Create Client For HTTP .
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                .connectTimeout(60 , TimeUnit.SECONDS)
                .readTimeout(60,TimeUnit.SECONDS)
                .writeTimeout(60,TimeUnit.SECONDS)
                .build();
        //From BASE_URL Create One CLIENT / Define Factory For CLIENT
        return new Retrofit.Builder().baseUrl(BASE_URL).client(okHttpClient).addConverterFactory(GsonConverterFactory.create(gson)).build();
    }
    public  static  APIService getApiService(){
        return  getRetroInstance().create(APIService.class);
    }

}
