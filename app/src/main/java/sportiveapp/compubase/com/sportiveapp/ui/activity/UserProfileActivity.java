package sportiveapp.compubase.com.sportiveapp.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import sportiveapp.compubase.com.sportiveapp.R;

public class UserProfileActivity extends AppCompatActivity {

    @BindView(R.id.img_user_profile)
    CircleImageView imgUserProfile;
    @BindView(R.id.rel_img)
    RelativeLayout relImg;
    @BindView(R.id.full_name_user_profile)
    EditText fullNameUserProfile;
    @BindView(R.id.view1)
    View view1;
    @BindView(R.id.email_user_profile)
    EditText emailUserProfile;
    @BindView(R.id.view2)
    View view2;
    @BindView(R.id.password_user_profile)
    EditText passwordUserProfile;
    @BindView(R.id.view3)
    View view3;
    @BindView(R.id.phone_num_user_profile)
    EditText phoneNumUserProfile;
    @BindView(R.id.view4)
    View view4;
    @BindView(R.id.btn_edit)
    Button btnEdit;
    @BindView(R.id.RV_OR)
    RelativeLayout RVOR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_edit)
    public void onViewClicked() {
    }
}
