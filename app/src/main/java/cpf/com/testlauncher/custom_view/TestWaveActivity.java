package cpf.com.testlauncher.custom_view;

import android.app.Activity;
import android.os.Bundle;

import cpf.com.testlauncher.R;
import cpf.com.testlauncher.custom_view.TestWave;

/**
 * Created by Administrator on 2017/3/8.
 */

public class TestWaveActivity extends Activity {

    TestWave testWave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_wave_layout);
        testWave = (TestWave)findViewById(R.id.test_wave_layout_view);
        testWave.start();
    }
}
