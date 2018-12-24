package in.apkglobal.retrofit;

import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

public interface API {
    @FormUrlEncoded
    @POST("/Soham/insert.php")
    public void send(
            @Field("name") String name,
            @Field("email") String email,
            @Field("password") String password,
            @Field("mobile") String mobile,
            @Field("technology") String technology,
            Callback<Response> responseCallback
    );

}
