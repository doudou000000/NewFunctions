package cpf.com.testlauncher.animator;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import cpf.com.testlauncher.R;

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

    public void menu(View view){
        startActivity(new Intent(TestAnimatorActivity.this,TestMenuActivity.class));
    }

    public void move(View view){
//        TranslateAnimation translateAnimation = new TranslateAnimation(0,200,0,0);
//        translateAnimation.setFillAfter(true);
//        translateAnimation.setDuration(1000);
        ImageView imageView = (ImageView) findViewById(R.id.show_animator_iv);
//        imageView.startAnimation(translateAnimation);
//        ObjectAnimator.ofFloat(imageView,"rotation",0,360).setDuration(1000).start();
//        ObjectAnimator.ofFloat(imageView,"translationX",0,200f).setDuration(1000).start();
//        ObjectAnimator.ofFloat(imageView,"translationY",0,200f).setDuration(1000).start();
//        PropertyValuesHolder propertyValuesHolder1 = PropertyValuesHolder.ofFloat("rotation",0,360);
//        PropertyValuesHolder propertyValuesHolder2 = PropertyValuesHolder.ofFloat("translationX",0,200f);
//        PropertyValuesHolder propertyValuesHolder3 = PropertyValuesHolder.ofFloat("translationY",0,200f);
//        ObjectAnimator.ofPropertyValuesHolder(imageView,propertyValuesHolder1,propertyValuesHolder2,propertyValuesHolder3).setDuration(1000).start();
        ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(imageView,"rotation",0,360);
        ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(imageView,"translationX",0,200f);
        ObjectAnimator objectAnimator3 = ObjectAnimator.ofFloat(imageView,"translationY",0,200f);

        AnimatorSet set = new AnimatorSet();

        set.play(objectAnimator1).with(objectAnimator2).before(objectAnimator3);

//        set.playSequentially(objectAnimator1,objectAnimator2,objectAnimator3);
//        set.playTogether(objectAnimator1,objectAnimator2,objectAnimator3);
        set.setDuration(1000);
        set.start();



    }

}
