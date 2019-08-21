package sportiveapp.compubase.com.sportiveapp.ui.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import sportiveapp.compubase.com.sportiveapp.R;
import sportiveapp.compubase.com.sportiveapp.ui.api.API;
import sportiveapp.compubase.com.sportiveapp.ui.helper.RetrofitClient;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.mail_login)
    EditText mailLogin;
    @BindView(R.id.view5)
    View view5;
    @BindView(R.id.editText)
    EditText editText;
    @BindView(R.id.view6)
    View view6;
    @BindView(R.id.RV_LOGIN)
    RelativeLayout RVLOGIN;
    @BindView(R.id.text_forgot_pass)
    TextView textForgotPass;
    @BindView(R.id.BTN_signIn_login)
    Button BTNSignInLogin;
    @BindView(R.id.BTN_signup_log)
    Button BTNSignupLog;
    private String email,password;
    private SharedPreferences preferences;
    private String string;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);


        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

    }

    @OnClick({R.id.text_forgot_pass, R.id.BTN_signIn_login, R.id.BTN_signup_log})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.text_forgot_pass:
                break;
            case R.id.BTN_signIn_login:
                startActivity(new Intent(LoginActivity.this,HomeActivity.class));

                userLogin();
                break;
            case R.id.BTN_signup_log:
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
                break;
        }
    }

    public void userLogin() {
        email = mailLogin.getText().toString();
        password = editText.getText().toString();

        if (!TextUtils.isEmpty(email) || !TextUtils.isEmpty(password)) {

            Retrofit retrofit = RetrofitClient.getInstant();
            API api = retrofit.create(API.class);
            Call<ResponseBody> responseBodyCall = api.UserLogin(email, password);
            responseBodyCall.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    if (response.isSuccessful()){
                        try {
                            string = response.body().string();

                            sharedLogin();


                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {

                }
            });

        }
    }

    public void sharedLogin() {

        SharedPreferences.Editor editor = getSharedPreferences("user", MODE_PRIVATE).edit();

        preferences = getSharedPreferences("user", MODE_PRIVATE);

        editor.putBoolean("login", true);

        editor.putString("string",string);

        editor.apply();
    }

}
