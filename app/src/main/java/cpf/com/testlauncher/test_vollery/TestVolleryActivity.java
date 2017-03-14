package cpf.com.testlauncher.test_vollery;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import cpf.com.testlauncher.R;

/**
 * Created by Administrator on 2017/2/28.
 */
public class TestVolleryActivity extends Activity implements View.OnClickListener{
    Button volleryFrameBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_vollery_layout);
        try{
            initView();
            initListener();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private void initView() {
        volleryFrameBtn = (Button)findViewById(R.id.test_open_frame_vollery_btn);
//        btn2 = (Button)findViewById(R.id.button3);
//        btn3 = (Button)findViewById(R.id.button4);
//        btn4 = (Button)findViewById(R.id.button5);
//        btn5 = (Button)findViewById(R.id.button6);
//        btn6 = (Button)findViewById(R.id.button7);
//        btn7 = (Button)findViewById(R.id.button8);
//        btn8 = (Button)findViewById(R.id.button13);
//        btn9 = (Button)findViewById(R.id.button14);
//        ndkBtn = (Button)findViewById(R.id.test_ndk_btn);
//        imBtn = (Button)findViewById(R.id.test_im_btn);
//        volleryBtn = (Button)findViewById(R.id.test_ormlite_btn);
    }

    private void initListener() {
        volleryFrameBtn.setOnClickListener(this);
//        btn2.setOnClickListener(this);
//        btn3.setOnClickListener(this);
//        btn4.setOnClickListener(this);
//        btn5.setOnClickListener(this);
//        btn6.setOnClickListener(this);
//        btn7.setOnClickListener(this);
//        btn8.setOnClickListener(this);
//        btn9.setOnClickListener(this);
//        ndkBtn.setOnClickListener(this);
//        imBtn.setOnClickListener(this);
//        volleryBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.test_open_frame_vollery_btn:
                switch2activity(TestVolleryFrameActivity.class);
                break;
//            case R.id.button3:
//                switch2activity(TestCardViewActivity.class);
//                break;
//            case R.id.button4:
//                switch2activity(TestRecycleViewActivity.class);
//                break;
//            case R.id.button5:
//                switch2activity(TestFloatingActionButtonActivity.class);
//                break;
//            case R.id.button6:
//                switch2activity(TestTextIputLayoutActivity.class);
//                break;
//            case R.id.button7:
//                switch2activity(TestTabLayoutActivity.class);
//                break;
//            case R.id.button8:
//                switch2activity(TestNavigationViewActivity.class);
//                break;
//            case R.id.button13:
//                switch2activity(TestCollapsingToolBarLayout.class);
//                break;
//            case R.id.button14:
//                switch2activity(TestOtherActivity.class);
//                break;
//            case R.id.test_ndk_btn:
//                switch2activity(TestNDKActivity.class);
//                break;
//            case R.id.test_im_btn:
//                switch2activity(TestIMActivity.class);
//                break;
//            case R.id.test_ormlite_btn:
//                switch2activity(TestVolleryActivity.class);
//                break;
            default:
                break;
        }

    }

    private void switch2activity(Class obj) {
        Intent initent = new Intent(this,obj);
        startActivity(initent);
    }
}
