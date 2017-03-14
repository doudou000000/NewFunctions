package cpf.com.testlauncher.hanle_img;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;

import cpf.com.testlauncher.R;

/**
 * 通过颜色矩阵处理图像
 */

public class TestColorMatrixActivity extends Activity {

    private ImageView imageView;

    private GridLayout gridLayout;

    private EditText editText;
    //Editext的宽、高
    private int mEditextWidth,mEditextHeight;
    //Editext集合
    private EditText ets[] = new EditText[20];
    //Editext值得集合
    private float etValues[] = new float[20];

    private Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_color_matrix_layout);

        imageView = (ImageView)findViewById(R.id.test_color_matrix_img);

        gridLayout = (GridLayout)findViewById(R.id.test_color_matrix_gl);

        bitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.img_2);

        imageView.setImageBitmap(bitmap);
        //通过gridLayout获取Editext的宽高
        gridLayout.post(new Runnable() {
            @Override
            public void run() {
                mEditextWidth = gridLayout.getWidth()/5;
                mEditextHeight = gridLayout.getHeight()/4;
                addEditext();
                initEditextValues();
            }
        });
    }

    private void addEditext() {
        for(int i = 0; i < 20; i ++){
            editText = new EditText(TestColorMatrixActivity.this);
            editText.setGravity(Gravity.CENTER);
            ets[i] = editText;
            gridLayout.addView(editText,mEditextWidth,mEditextHeight);
        }
    }

    public void getEditextValues(){
        for(int i = 0; i < 20; i ++){
            etValues[i] = Float.valueOf(ets[i].getText().toString());
        }
    }

    public void initEditextValues(){
        for(int i = 0; i < 20; i ++){
            if(i % 6 == 0){
                ets[i].setText("1"); //0/6/12/18 R G B A
            }else{
                ets[i].setText("0");
            }
        }
    }

    public void setImageBitmap(){

        imageView.setImageBitmap(ImageHandleUtil.matrixHanleImag(bitmap,etValues));

    }

    public void changeImgColorMatrix(View view){

        getEditextValues();
        setImageBitmap();

    }

    public void resetImgColorMatrix(View view){

        initEditextValues();
        getEditextValues();
        setImageBitmap();

    }

}
