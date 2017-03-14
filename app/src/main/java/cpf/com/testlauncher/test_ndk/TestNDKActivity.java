package cpf.com.testlauncher.test_ndk;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import cpf.com.testlauncher.R;
import cpf.com.testlauncher.test_ndk.TestNDK;

/**
 * Created by Administrator on 2017/2/23.
 */
public class TestNDKActivity extends Activity{

    TextView testNdkTv;
    static {

        System.loadLibrary("hellojni");

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_ndk_layout);
        testNdkTv = (TextView)findViewById(R.id.test_ndk_tv);
        testNdkTv.setText(TestNDK.getStringFromNative());
    }
}
