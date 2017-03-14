package cpf.com.testlauncher.custom_view;

import android.app.Activity;
import android.os.Bundle;

import cpf.com.testlauncher.R;

/**
 * 贝塞尔曲线测试
 */

public class TestBezierActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_bezier_layout);
    }
}
