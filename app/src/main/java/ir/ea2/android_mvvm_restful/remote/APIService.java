package ir.ea2.android_mvvm_restful.remote;

import ir.ea2.android_mvvm_restful.remote.user.UsersList;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface APIService {
    @GET("/api/json/get/cfGDlCDNsO?indent=2")
    Call<UsersList> getUsersList(
//            @Query("name") String name
    );

    @FormUrlEncoded
    @POST("/api/json/get/cfGDlCDNsO?indent=2")
    Call<UsersList> sendUsersList(@Field("name") String name);
}
