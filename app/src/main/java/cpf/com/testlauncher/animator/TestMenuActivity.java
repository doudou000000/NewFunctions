package cpf.com.testlauncher.animator;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cpf.com.testlauncher.MyApplication;
import cpf.com.testlauncher.R;

/**
 * Created by Administrator on 2017/3/15.
 */

public class TestMenuActivity extends Activity implements View.OnClickListener{

    private List<ImageView> imageViewList = new ArrayList<ImageView>();

    private boolean isOpen = true;

    private int[] ids = new int[]{R.id.test_animator_menu_item_a_iv,R.id.test_animator_menu_item_b_iv,R.id.test_animator_menu_item_c_iv,
            R.id.test_animator_menu_item_d_iv,R.id.test_animator_menu_item_e_iv,R.id.test_animator_menu_item_f_iv};


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.test_animator_menu_layout);

        TextView textView = (TextView)findViewById(R.id.test_flot_animator_tv);
        textView.setOnClickListener(this);

        View view = createFlotView();

        for(int i = 0; i < ids.length; i ++){
            ImageView imageView = (ImageView) view.findViewById(ids[i]);
            imageView.setOnClickListener(this);
            imageViewList.add(imageView);
        }

    }

    private View createFlotView() {

        LayoutInflater inflater = LayoutInflater.from(getApplicationContext());
        View view = inflater.inflate(R.layout.test_animator_menu_item_layout,null);

        WindowManager windowManager = (WindowManager) getApplicationContext().getSystemService(WINDOW_SERVICE);

        WindowManager.LayoutParams params = ((MyApplication)getApplication()).getWindowParams();

        params.type = WindowManager.LayoutParams.TYPE_SYSTEM_ALERT;//设置最高级

        params.format = PixelFormat.RGBA_8888;//设置图片格式，效果为背景透明
        // 设置Window flag

        params.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
                | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
        /*
         * 注意，flag的值可以为：
         * LayoutParams.FLAG_NOT_TOUCH_MODAL 不影响后面的事件
         * LayoutParams.FLAG_NOT_FOCUSABLE 不可聚焦
         * LayoutParams.FLAG_NOT_TOUCHABLE 不可触摸
        */
        // 调整悬浮窗口至左上角，便于调整坐标
        params.gravity = Gravity.LEFT | Gravity.BOTTOM;

        // 设置悬浮窗口长宽数据
        params.width = WindowManager.LayoutParams.MATCH_PARENT;
        params.height = WindowManager.LayoutParams.MATCH_PARENT;
        // 以屏幕左上角为原点，设置x、y初始值
        params.x = 0;
        params.y = params.height;
        // 显示myFloatView图像
        windowManager.addView(view, params);

        return view;

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.test_animator_menu_item_f_iv:
                if(isOpen){
                    isOpen = false;
                    startAnimator();
                }else{
                    isOpen = true;
                    closeAnimator();
                }
                break;
            case R.id.test_flot_animator_tv:
                Toast.makeText(TestMenuActivity.this,"我是主页面按钮",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }

    private void closeAnimator() {

        AnimatorSet set = new AnimatorSet();
        ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(imageViewList.get(imageViewList.size() - 1),"rotation", 135 , 0);
        set.playTogether(objectAnimator1);
        for(int i = 0; i < imageViewList.size()-1; i ++){

            ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(imageViewList.get(i),"translationY", -(i+1) * 150f , 0);
            set.playTogether(objectAnimator);
        }
        set.setDuration(500);

        set.start();

    }

    private void startAnimator() {

        AnimatorSet set = new AnimatorSet();
        ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(imageViewList.get(imageViewList.size() - 1),"rotation", 0 , 135);
        set.playTogether(objectAnimator1);
        for(int i = 0; i < imageViewList.size()-1; i ++){

            ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(imageViewList.get(i),"translationY", 0 , -(i+1) * 150f);
            set.playTogether(objectAnimator);
        }
        set.setDuration(500);

        set.start();




    }
}
