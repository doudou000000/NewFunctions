package cpf.com.testlauncher.custom_view;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import cpf.com.testlauncher.R;
import cpf.com.testlauncher.custom_view.CustomCircleView;

/**
 * Created by Administrator on 2017/3/2.
 */
public class TestCustomCircleActivity extends Activity{

    CustomCircleView customCircleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_custom_view_circle_layout);
        customCircleView = (CustomCircleView)findViewById(R.id.test_custom_circle);
        customCircleView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                customCircleView.setCircleX(event.getX());
                customCircleView.setCircleY(event.getY());
                customCircleView.setCircleR(10f);
                customCircleView.invalidate();
                return false;
            }
        });
    }
}
