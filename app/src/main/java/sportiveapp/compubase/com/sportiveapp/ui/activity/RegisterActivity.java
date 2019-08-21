package sportiveapp.compubase.com.sportiveapp.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;

import java.io.IOException;
import java.util.Objects;

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
import sportiveapp.compubase.com.sportiveapp.ui.model.RegisterModel;

public class RegisterActivity extends AppCompatActivity {

    @BindView(R.id.full_name)
    EditText fullName;
    @BindView(R.id.view1)
    View view1;
    @BindView(R.id.email)
    EditText email;
    @BindView(R.id.view2)
    View view2;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.view3)
    View view3;
    @BindView(R.id.phone_num)
    EditText phoneNum;
    @BindView(R.id.view4)
    View view4;
    @BindView(R.id.center_btn)
    RadioButton centerBtn;
    @BindView(R.id.user_btn)
    RadioButton userBtn;
    @BindView(R.id.lin_one)
    RadioGroup linOne;
    @BindView(R.id.lin_radio)
    LinearLayout linRadio;
    @BindView(R.id.view5)
    View view5;
    @BindView(R.id.location)
    EditText location;
    @BindView(R.id.RV_OR)
    RelativeLayout RVOR;
    @BindView(R.id.BTN_signUp_registar)
    Button BTNSignUpRegistar;
    @BindView(R.id.text_qs)
    TextView textQs;
    @BindView(R.id.text_login)
    TextView textLogin;

    private String userName, userMail, userphone, userpass;
    int PLACE_PICKER_REQUEST = 1;

    private String radio;
    private SharedPreferences preferences;
    private String string;

    int MAP_BUTTON_REQUEST_CODE = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);


        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

    }

    @OnClick({R.id.center_btn, R.id.user_btn, R.id.location, R.id.BTN_signUp_registar, R.id.text_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.center_btn:
                radio = "center";
                location.setVisibility(View.VISIBLE);
                break;
            case R.id.user_btn:
                radio = "user";
                location.setVisibility(View.GONE);
                break;
            case R.id.location:
                placePacker();
                break;
            case R.id.BTN_signUp_registar:

                if (centerBtn.isChecked()) {
                    ValidateCenter();
                } else if (userBtn.isChecked()) {
                    Validate();
                }

                break;
            case R.id.text_login:
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                break;
        }
    }

    private void ValidateCenter() {
        userName = fullName.getText().toString();
        userMail = email.getText().toString();
        userphone = phoneNum.getText().toString();
        userpass = password.getText().toString();

        if (TextUtils.isEmpty(userName)) {
            fullName.setError("User name is required");
        } else if (TextUtils.isEmpty(userMail)) {
            email.setError("Email is required");
        } else if (TextUtils.isEmpty(userphone)) {
            phoneNum.setError("Birthday is required");
        } else if (TextUtils.isEmpty(userpass)) {
            password.setError("Blood Type is required");
        } else {
            Retrofit retrofit = RetrofitClient.getInstant();
            API api = retrofit.create(API.class);
            Call<ResponseBody> responseBodyCall = api.UserRegister(userName, userMail, userpass, userphone, radio, 0.0000
                    , 0.0000, "image", "famous", "des");
            responseBodyCall.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                    if (response.isSuccessful()) {
                        try {
                            assert response.body() != null;
                            String string = response.body().string();

                            Toast.makeText(RegisterActivity.this, string, Toast.LENGTH_SHORT).show();

                            if (string.equals("True")) {
                                startActivity(new Intent(RegisterActivity.this, CenterHomeActivity.class));
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    Toast.makeText(RegisterActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    private void Validate() {

        userName = fullName.getText().toString();
        userMail = email.getText().toString();
        userphone = phoneNum.getText().toString();
        userpass = password.getText().toString();

        if (TextUtils.isEmpty(userName)) {
            fullName.setError("User name is required");
        } else if (TextUtils.isEmpty(userMail)) {
            email.setError("Email is required");
        } else if (TextUtils.isEmpty(userphone)) {
            phoneNum.setError("Birthday is required");
        } else if (TextUtils.isEmpty(userpass)) {
            password.setError("Blood Type is required");
        } else {
            Retrofit retrofit = RetrofitClient.getInstant();
            API api = retrofit.create(API.class);
            Call<ResponseBody> responseBodyCall = api.UserRegister(userName, userMail, userpass, userphone, radio, 0.0000
                    , 0.0000, "image", "famous", "des");
            responseBodyCall.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                    if (response.isSuccessful()) {
                        try {
                            assert response.body() != null;
                            String string = response.body().string();

                            if (string.equals("True")) {
                                sharedLogin();
                                startActivity(new Intent(RegisterActivity.this, HomeActivity.class));
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    Toast.makeText(RegisterActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    public void sharedLogin() {

        SharedPreferences.Editor editor = getSharedPreferences("user", MODE_PRIVATE).edit();

        preferences = getSharedPreferences("user", MODE_PRIVATE);

        editor.putBoolean("login", true);

        editor.putString("name", userName);
        editor.putString("email", userMail);
        editor.putString("pass", userpass);
        editor.putString("phone", userphone);
        editor.putString("type", radio);

        editor.apply();
    }

    private void placePacker() {


        PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();

        try {
            startActivityForResult(builder.build(this), PLACE_PICKER_REQUEST);
        } catch (GooglePlayServicesRepairableException e) {
            e.printStackTrace();
        } catch (GooglePlayServicesNotAvailableException e) {
            e.printStackTrace();
        }

//        Intent locationPickerIntent = new LocationPickerActivity.Builder()
//                .withLocation(41.4036299, 2.1743558)
//                .withSearchZone("es_ES")
//                .shouldReturnOkOnBackPressed()
//                .withStreetHidden()
//                .withCityHidden()
//                .withZipCodeHidden()
//                .withSatelliteViewHidden()
//                .build(RegisterActivity.this);
//
//        startActivityForResult(locationPickerIntent, MAP_BUTTON_REQUEST_CODE);

//        PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();
//        try {
//            startActivityForResult(builder.build(RegisterActivity.this),PLACE_PICKER);
//        } catch (GooglePlayServicesRepairableException e) {
//            e.printStackTrace();
//        } catch (GooglePlayServicesNotAvailableException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PLACE_PICKER_REQUEST) {
            if (resultCode == RESULT_OK) {
                Place place = PlacePicker.getPlace(data, this);
                String toastMsg = String.format("Place: %s", place.getName());
                Toast.makeText(this, toastMsg, Toast.LENGTH_LONG).show();

                location.setText(toastMsg);
            }
        }
    }
}
