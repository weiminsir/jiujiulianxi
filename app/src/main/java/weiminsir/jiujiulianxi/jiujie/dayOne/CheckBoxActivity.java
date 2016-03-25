package weiminsir.jiujiulianxi.jiujie.dayOne;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import weiminsir.jiujiulianxi.R;

public class CheckBoxActivity extends Activity {

    private CheckBox cbPhoto01;
    private CheckBox cbPhoto02;
    private CheckBox cbPhoto03;
    private CheckBox cbPhoto04;
    private CheckBox cbPhoto05;
    private CheckBox cbPhoto06;
    private CheckBox cbPhoto07;
    private Button btnSubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);
        cbPhoto01 = (CheckBox) findViewById(R.id.cb_photo_1);
        cbPhoto02 = (CheckBox) findViewById(R.id.cb_photo_2);
        cbPhoto03 = (CheckBox) findViewById(R.id.cb_photo_3);
        cbPhoto04 = (CheckBox) findViewById(R.id.cb_photo_4);
        cbPhoto05 = (CheckBox) findViewById(R.id.cb_photo_5);
        cbPhoto06 = (CheckBox) findViewById(R.id.cb_photo_6);
        cbPhoto07 = (CheckBox) findViewById(R.id.cb_photo_7);
        btnSubmit = (Button) findViewById(R.id.btn_submit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String result = "";
                // 根据CheckBox的选中状态，决定是否提示
                if(cbPhoto01.isChecked()) {
                    result += cbPhoto01.getText().toString() + " ";
                }
                if(cbPhoto02.isChecked()) {
                    result += cbPhoto02.getText().toString() + " ";
                }
                if(cbPhoto03.isChecked()) {
                    result += cbPhoto03.getText().toString() + " ";
                }
                if(cbPhoto04.isChecked()) {
                    result += cbPhoto04.getText().toString() + " ";
                }
                if(cbPhoto05.isChecked()) {
                    result += cbPhoto05.getText().toString() + " ";
                }
                if(cbPhoto06.isChecked()) {
                    result += cbPhoto06.getText().toString() + " ";
                }
                if(cbPhoto07.isChecked()) {
                    result += cbPhoto07.getText().toString() + " ";
                }
                // 提示文字
                Toast.makeText(CheckBoxActivity.this, result.trim(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
