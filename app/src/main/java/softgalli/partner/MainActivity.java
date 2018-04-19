package softgalli.partner;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import softgalli.partner.activity.StuTeaMainActivity;
import softgalli.partner.common.ClsGeneral;
import softgalli.partner.common.PreferenceName;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tv_soft)
    TextView tv_soft;
    @BindView(R.id.tv_gurukul)
    TextView tv_gurukul;
    @BindView(R.id.tv_sps)
    TextView tv_sps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        ButterKnife.bind(this);
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Roboto-RobotoRegular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );

    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
    @OnClick({R.id.tv_soft, R.id.tv_gurukul, R.id.tv_sps})
    void OntextClick(TextView textView){
        switch (textView.getId()){
            case R.id.tv_soft:
                ClsGeneral.setPreferences(MainActivity.this, PreferenceName.SCHOOLNAME, PreferenceName.SOFTGALLI);
                startActivity(new Intent(MainActivity.this, StuTeaMainActivity.class));
                break;

            case R.id.tv_gurukul:
                ClsGeneral.setPreferences(MainActivity.this, PreferenceName.SCHOOLNAME, PreferenceName.GURUKUL);
                startActivity(new Intent(MainActivity.this, StuTeaMainActivity.class));
                break;

            case R.id.tv_sps:
                ClsGeneral.setPreferences(MainActivity.this, PreferenceName.SCHOOLNAME, PreferenceName.SPS);
                startActivity(new Intent(MainActivity.this, StuTeaMainActivity.class));
                break;

        }
    }
}
