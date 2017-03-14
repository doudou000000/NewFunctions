package cpf.com.testlauncher.custom_view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import cpf.com.testlauncher.R;

/**
 * Created by Administrator on 2017/3/2.
 */
public class TestCustomViewActivity extends Activity implements View.OnClickListener {

    Button circleBtn,codeBtn,topbarBtn,editextBtn,bezierBtn,waveBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_custom_view_layout);
        try{
            initView();
            initListener();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void initView() {
        circleBtn = (Button)findViewById(R.id.test_custom_view_circle_btn);
        codeBtn = (Button)findViewById(R.id.test_custom_view_code_btn);
        topbarBtn = (Button)findViewById(R.id.test_custom_topbar_btn);
        editextBtn = (Button)findViewById(R.id.test_custom_editext_btn);
        bezierBtn = (Button)findViewById(R.id.test_bezier_btn);
        waveBtn = (Button)findViewById(R.id.test_wave_btn);
//        btn4 = (Button)findViewById(R.id.button5);
//        btn5 = (Button)findViewById(R.id.button6);
//        btn6 = (Button)findViewById(R.id.button7);
//        btn7 = (Button)findViewById(R.id.button8);
//        btn8 = (Button)findViewById(R.id.button13);
//        btn9 = (Button)findViewById(R.id.button14);
//        ndkBtn = (Button)findViewById(R.id.test_ndk_btn);
//        imBtn = (Button)findViewById(R.id.test_im_btn);
//        volleryBtn = (Button)findViewById(R.id.test_ormlite_btn);
//        custom_view_btn = (Button)findViewById(R.id.test_custom_view_btn);
    }

    private void initListener() {
        circleBtn.setOnClickListener(this);
        codeBtn.setOnClickListener(this);
        topbarBtn.setOnClickListener(this);
        editextBtn.setOnClickListener(this);
        bezierBtn.setOnClickListener(this);
        waveBtn.setOnClickListener(this);
//        btn4.setOnClickListener(this);
//        btn5.setOnClickListener(this);
//        btn6.setOnClickListener(this);
//        btn7.setOnClickListener(this);
//        btn8.setOnClickListener(this);
//        btn9.setOnClickListener(this);
//        ndkBtn.setOnClickListener(this);
//        imBtn.setOnClickListener(this);
//        volleryBtn.setOnClickListener(this);
//        custom_view_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.test_custom_view_circle_btn:
                switch2activity(TestCustomCircleActivity.class);
                break;
            case R.id.test_custom_view_code_btn:
                switch2activity(TestCustomCodeActivity.class);
                break;
            case R.id.test_custom_topbar_btn:
                switch2activity(TestCustomWidghtViewActivity.class);
                break;
            case R.id.test_custom_editext_btn:
                switch2activity(TestCustomEditextActivity.class);
                break;
            case R.id.test_bezier_btn:
                switch2activity(TestBezierActivity.class);
                break;
            case R.id.test_wave_btn:
                switch2activity(TestWaveActivity.class);
                break;
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
//            case R.id.test_custom_view_btn:
//                switch2activity(TestCustomViewActivity.class);
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
