package cpf.com.testlauncher.custom_view;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import cpf.com.testlauncher.R;

/**
 * Created by Administrator on 2017/3/16.
 */

public class TestCustomCircleWaveActivity extends Activity {

    CustomWaveView customWaveView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_circle_wave_layout);
        customWaveView = (CustomWaveView)findViewById(R.id.test_custom_circle_view);
        customWaveView.startWave();
    }
}
