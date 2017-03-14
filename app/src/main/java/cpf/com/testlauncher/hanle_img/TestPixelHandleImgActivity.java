package cpf.com.testlauncher.hanle_img;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

import cpf.com.testlauncher.R;

/**
 * 使用像素来处理图片
 */

public class TestPixelHandleImgActivity extends Activity{

    private ImageView img_1,img_2,img_3,img_4;

    private Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_pixel_img_layout);
        img_1 = (ImageView)findViewById(R.id.test_pixel_img_1);
        img_2 = (ImageView)findViewById(R.id.test_pixel_img_2);
        img_3 = (ImageView)findViewById(R.id.test_pixel_img_3);
        img_4 = (ImageView)findViewById(R.id.test_pixel_img_4);

        bitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.img_3);

        img_1.setImageBitmap(bitmap);

        img_2.setImageBitmap(ImageHandleUtil.pixelHandleImgToDiPian(bitmap));

        img_3.setImageBitmap(ImageHandleUtil.pixelHandleImgTofugu(bitmap));

        img_4.setImageBitmap(ImageHandleUtil.pixelHandleImgToBlackWheight(bitmap));

    }
}
