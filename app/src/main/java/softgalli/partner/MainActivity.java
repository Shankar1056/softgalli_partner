package softgalli.partner;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
                openDialog("soft_321");
                break;

            case R.id.tv_gurukul:
                ClsGeneral.setPreferences(MainActivity.this, PreferenceName.SCHOOLNAME, PreferenceName.GURUKUL);
                openDialog("gurukul_246");
                break;

            case R.id.tv_sps:
                ClsGeneral.setPreferences(MainActivity.this, PreferenceName.SCHOOLNAME, PreferenceName.SPS);
                openDialog("sps_986");
                break;

        }
    }

    private void openDialog(final String soft) {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.activity_dialog);
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.copyFrom(dialog.getWindow().getAttributes());
        lp.gravity = Gravity.BOTTOM;
        lp.windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setAttributes(lp);
        final EditText code = (EditText) dialog.findViewById(R.id.code);
        Button submit = (Button) dialog.findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (code.getText().toString().trim().equals(soft))
                {
                    dialog.dismiss();
                    startActivity(new Intent(MainActivity.this, StuTeaMainActivity.class));
                }
                else {
                    Toast.makeText(MainActivity.this, "Invalid code", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });

        dialog.show();

    }
}
