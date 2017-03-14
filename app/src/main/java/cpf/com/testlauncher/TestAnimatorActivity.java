package cpf.com.testlauncher;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/3/14.
 */

public class TestAnimatorActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.test_object_animator_layout);

    }

    public void click(View view){

        Toast.makeText(this, "click" ,Toast.LENGTH_SHORT).show();
    }

    public void move(View view){
        TranslateAnimation translateAnimation = new TranslateAnimation(0,200,0,0);
        translateAnimation.setFillAfter(true);
        translateAnimation.setDuration(1000);
        ImageView imageView = (ImageView) findViewById(R.id.show_animator_iv);
        imageView.startAnimation(translateAnimation);
    }

}
