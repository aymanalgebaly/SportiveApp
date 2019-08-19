package sportiveapp.compubase.com.sportiveapp.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import sportiveapp.compubase.com.sportiveapp.R;

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
                break;
            case R.id.BTN_signup_log:
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
                break;
        }
    }
}
