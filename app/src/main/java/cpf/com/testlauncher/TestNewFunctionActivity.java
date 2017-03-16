package cpf.com.testlauncher;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import cpf.com.testlauncher.animator.TestAnimatorActivity;
import cpf.com.testlauncher.custom_view.TestCustomViewActivity;
import cpf.com.testlauncher.hanle_img.TestPhotoImageActivity;
import cpf.com.testlauncher.tab_layout.TestTabLayoutActivity;
import cpf.com.testlauncher.test_im.TestIMActivity;
import cpf.com.testlauncher.test_ndk.TestNDKActivity;
import cpf.com.testlauncher.test_pull2refresh.TestPull2RefreshActivity;
import cpf.com.testlauncher.test_vollery.TestVolleryActivity;

/**
 * 测试Android5.0新控件
 * Created by Administrator on 2017/2/8.
 */
public class TestNewFunctionActivity extends Activity implements View.OnClickListener {

    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,ndkBtn,imBtn,volleryBtn,custom_view_btn,photo_image_btn,animatorBtn,pull2refreshBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_function_layout);
        try{
            initView();
            initListener();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void initView() {
        btn1 = (Button)findViewById(R.id.button2);
        btn2 = (Button)findViewById(R.id.button3);
        btn3 = (Button)findViewById(R.id.button4);
        btn4 = (Button)findViewById(R.id.button5);
        btn5 = (Button)findViewById(R.id.button6);
        btn6 = (Button)findViewById(R.id.button7);
        btn7 = (Button)findViewById(R.id.button8);
        btn8 = (Button)findViewById(R.id.button13);
        btn9 = (Button)findViewById(R.id.button14);
        ndkBtn = (Button)findViewById(R.id.test_ndk_btn);
        imBtn = (Button)findViewById(R.id.test_im_btn);
        volleryBtn = (Button)findViewById(R.id.test_ormlite_btn);
        custom_view_btn = (Button)findViewById(R.id.test_custom_view_btn);
        photo_image_btn = (Button)findViewById(R.id.test_photo_image_btn);
        animatorBtn = (Button)findViewById(R.id.test_animator_btn);
        pull2refreshBtn = (Button)findViewById(R.id.test_pull2refresh_btn);
    }

    private void initListener() {
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        ndkBtn.setOnClickListener(this);
        imBtn.setOnClickListener(this);
        volleryBtn.setOnClickListener(this);
        custom_view_btn.setOnClickListener(this);
        photo_image_btn.setOnClickListener(this);
        animatorBtn.setOnClickListener(this);
        pull2refreshBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.button2:
                switch2activity(TestContraintLayout.class);
                break;
            case R.id.button3:
                switch2activity(TestCardViewActivity.class);
                break;
            case R.id.button4:
                switch2activity(TestRecycleViewActivity.class);
                break;
            case R.id.button5:
                switch2activity(TestFloatingActionButtonActivity.class);
                break;
            case R.id.button6:
                switch2activity(TestTextIputLayoutActivity.class);
                break;
            case R.id.button7:
                switch2activity(TestTabLayoutActivity.class);
                break;
            case R.id.button8:
                switch2activity(TestNavigationViewActivity.class);
                break;
            case R.id.button13:
                switch2activity(TestCollapsingToolBarLayout.class);
                break;
            case R.id.button14:
                switch2activity(TestOtherActivity.class);
                break;
            case R.id.test_ndk_btn:
                switch2activity(TestNDKActivity.class);
                break;
            case R.id.test_im_btn:
                switch2activity(TestIMActivity.class);
                break;
            case R.id.test_ormlite_btn:
                switch2activity(TestVolleryActivity.class);
                break;
            case R.id.test_custom_view_btn:
                switch2activity(TestCustomViewActivity.class);
                break;
            case R.id.test_photo_image_btn:
                switch2activity(TestPhotoImageActivity.class);
                break;
            case R.id.test_animator_btn:
                switch2activity(TestAnimatorActivity.class);
                break;
            case R.id.test_pull2refresh_btn:
                switch2activity(TestPull2RefreshActivity.class);
                break;
            default:
                break;
        }

    }

    private void switch2activity(Class obj) {
        Intent initent = new Intent(this,obj);
        startActivity(initent);
    }

}
