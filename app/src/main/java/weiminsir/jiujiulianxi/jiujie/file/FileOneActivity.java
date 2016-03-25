package weiminsir.jiujiulianxi.jiujie.file;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import butterknife.InjectView;
import weiminsir.jiujiulianxi.R;

public class FileOneActivity extends Activity implements View.OnClickListener {

    @InjectView(R.id.ed_txt)
    protected EditText editText;
    @InjectView(R.id.save)
    protected Button button;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_one);
        button.setOnClickListener(this);
//        ImageButton imageButton;

        FileInputStream fileInputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader;
        try {
            fileInputStream = openFileInput("content.txt");
            inputStreamReader = new InputStreamReader(fileInputStream);
            bufferedReader = new BufferedReader(inputStreamReader);
            StringBuffer content = new StringBuffer();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                content.append(line);
            }

        } catch (FileNotFoundException e) {
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    @Override
    public void onClick(View view) {
        String content = editText.getText().toString();
        FileOutputStream fos = null;
        try {
            fos = openFileOutput("content.txt", MODE_PRIVATE);
            fos.write(content.getBytes());
            fos.flush();
        } catch (FileNotFoundException e) {

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
