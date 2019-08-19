package sportiveapp.compubase.com.sportiveapp.ui.api;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import sportiveapp.compubase.com.sportiveapp.ui.model.RegisterModel;

public interface API {

    @FormUrlEncoded
    @POST("register")
    Call<ResponseBody>UserRegister(
            @Field("name") String name,
            @Field("email") String email,
            @Field("password") String password,
            @Field("mobile") String mobile
//            @Field("type") String type
    );
}
