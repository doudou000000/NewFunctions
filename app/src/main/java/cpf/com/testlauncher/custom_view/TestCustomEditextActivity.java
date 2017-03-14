package cpf.com.testlauncher.custom_view;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;

import cpf.com.testlauncher.R;

/**
 * Created by Administrator on 2017/3/6.
 */
public class TestCustomEditextActivity extends Activity{

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_custom_editext_layout);
        editText = (EditText)findViewById(R.id.test_top_bar);
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                String s = v.getText().toString();
                System.out.print("============"+s);
                System.out.print("============"+s.length());
                if(event.getKeyCode() == KeyEvent.KEYCODE_ENTER){
                    s = v.getText().toString();
                    s = s+"\n\r\r";
                    editText.setText(s.toString());
                    editText.setSelection(s.length());
                    System.out.print("============"+s);
                    System.out.print("============"+s.length());
                }

                return true;
            }
        });
    }
}
