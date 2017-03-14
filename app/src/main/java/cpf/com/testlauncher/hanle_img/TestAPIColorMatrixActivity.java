package cpf.com.testlauncher.hanle_img;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;

import cpf.com.testlauncher.R;
import cpf.com.testlauncher.hanle_img.ImageHandleUtil;

/**
 * 调用AndroidApi处理图像
 */
public class TestAPIColorMatrixActivity extends Activity implements SeekBar.OnSeekBarChangeListener{

    private ImageView imageView;

    SeekBar hueSeekBar,stuationSeekBar,lumSeekBar;

    Bitmap bitmap;

    int MAX_VALUE = 255;

    int MID_VALUE = 127;

    float hue,stuation,lum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_api_color_matrix_layout);
        imageView = (ImageView)findViewById(R.id.test_api_color_matrix_img);
        hueSeekBar = (SeekBar)findViewById(R.id.test_api_color_matrix_hue_seekbar);
        stuationSeekBar = (SeekBar)findViewById(R.id.test_api_color_matrix_stuation_seekbar);
        lumSeekBar = (SeekBar)findViewById(R.id.test_api_color_matrix_lum_seekbar);
        hueSeekBar.setMax(MAX_VALUE);
        hueSeekBar.setProgress(MID_VALUE);
        stuationSeekBar.setMax(MAX_VALUE);
        stuationSeekBar.setProgress(MID_VALUE);
        lumSeekBar.setMax(MAX_VALUE);
        lumSeekBar.setProgress(MID_VALUE);

        hueSeekBar.setOnSeekBarChangeListener(this);
        stuationSeekBar.setOnSeekBarChangeListener(this);
        lumSeekBar.setOnSeekBarChangeListener(this);

        bitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.img_1);
        imageView.setImageBitmap(bitmap);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        switch (seekBar.getId()){
            case R.id.test_api_color_matrix_hue_seekbar:
                hue = (progress - MID_VALUE) * 1.0f / MID_VALUE * 180;
                break;
            case R.id.test_api_color_matrix_stuation_seekbar:
                stuation = progress * 1.0f / MID_VALUE;
                break;
            case R.id.test_api_color_matrix_lum_seekbar:
                lum = progress * 1.0f / MID_VALUE;
                break;
            default:
                break;
        }
        imageView.setImageBitmap(ImageHandleUtil.apiHanleImag(bitmap,hue,stuation,lum));
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
