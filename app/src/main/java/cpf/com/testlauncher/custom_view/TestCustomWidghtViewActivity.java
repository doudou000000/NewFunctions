package cpf.com.testlauncher.custom_view;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import cpf.com.testlauncher.R;

/**
 * Created by Administrator on 2017/3/6.
 */
public class TestCustomWidghtViewActivity extends Activity{

    TestCustomTopBar topBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_custom_topbar_layout);
        topBar = (TestCustomTopBar)findViewById(R.id.test_top_bar);
        topBar.setTopBarClickListener(new TestCustomTopBar.OnTopBarClickListener() {
            @Override
            public void leftBtnListener() {
                Toast.makeText(TestCustomWidghtViewActivity.this,"this is leftBtn",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void rightBtnListener() {
                Toast.makeText(TestCustomWidghtViewActivity.this,"this is rightBtn",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
