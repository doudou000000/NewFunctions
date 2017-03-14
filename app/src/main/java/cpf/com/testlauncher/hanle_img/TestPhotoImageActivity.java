package cpf.com.testlauncher.hanle_img;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import cpf.com.testlauncher.R;
import cpf.com.testlauncher.hanle_img.TestAPIColorMatrixActivity;
import cpf.com.testlauncher.hanle_img.TestColorMatrixActivity;

/**
 * 图片图像处理(色调、饱和度、亮度)
 */
public class TestPhotoImageActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_photo_image_layout);

    }

    public void useAPIColorMatrix(View view){
        startActivity(new Intent(this,TestAPIColorMatrixActivity.class));
    }

    public void useColorMatrix(View view){
        startActivity(new Intent(this,TestColorMatrixActivity.class));
    }

    public void useColorPelix(View view){

        startActivity(new Intent(this,TestPixelHandleImgActivity.class));

    }

}
