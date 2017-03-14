package cpf.com.testlauncher.custom_view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import cpf.com.testlauncher.R;

/**
 * Created by Administrator on 2017/2/7.
 */

public class CustomPath extends View{

    private static final String TAG = "CircleProgressBar";

    private int mMaxProgress = 100;

    private int mProgress = 30;

    private final int mCircleLineStrokeWidth = 5;

    private final int mTxtStrokeWidth = 2;

    // 画圆所在的距形区域
    private final RectF mRectF;

    private final Paint mPaint;

    private final Context mContext;

    private String mTxtHint1;

    private String mTxtHint2;

    private int drawableCenter = 5;

    private int mCircleLineStrokeColor = Color.rgb(27, 83, 138);

    public CustomPath(Context context, AttributeSet attrs) {
        super(context, attrs);

        mContext = context;
        mRectF = new RectF();
        mPaint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = this.getWidth();
        int height = this.getHeight();

        if (width != height) {
            int min = Math.min(width, height);
            width = min;
            height = min;
        }

        // 设置画笔相关属性
        mPaint.setAntiAlias(true);
        //设置进度条默认颜色
        mPaint.setColor(mCircleLineStrokeColor);//Color.rgb(0xe9, 0xe9, 0xe9)
        canvas.drawColor(Color.TRANSPARENT);
        mPaint.setStrokeWidth(mCircleLineStrokeWidth);
        mPaint.setStyle(Paint.Style.STROKE);
        // 位置
        mRectF.left = mCircleLineStrokeWidth / 2; // 左上角x
        mRectF.top = mCircleLineStrokeWidth / 2; // 左上角y
        mRectF.right = width - mCircleLineStrokeWidth / 2; // 右下角x
        mRectF.bottom = height - mCircleLineStrokeWidth / 2; // 右下角y

        // 绘制圆圈，进度条背景
        canvas.drawArc(mRectF, -180, 360, false, mPaint);
        mPaint.setColor(Color.rgb(0, 133, 208));//
        canvas.drawArc(mRectF, -180, ((float) mProgress / mMaxProgress) * 360, false, mPaint);
        // 绘制进度文案显示
        mPaint.setStrokeWidth(mTxtStrokeWidth);
        String text = mProgress + "%";
        int textHeight = height / 4;
        mPaint.setTextSize(textHeight);
        int textWidth = (int) mPaint.measureText(text, 0, text.length());
        mPaint.setStyle(Paint.Style.FILL);
        if (drawableCenter == 0) {
            canvas.drawText(text, width / 2 - textWidth / 2, height / 2 + textHeight / 2, mPaint);
        }
//
//        if (!TextUtils.isEmpty(mTxtHint1)) {
//            mPaint.setStrokeWidth(mTxtStrokeWidth);
//            text = mTxtHint1;
//            textHeight = height / 8;
//            mPaint.setTextSize(textHeight);
//            mPaint.setColor(Color.rgb(0x99, 0x99, 0x99));
//            textWidth = (int) mPaint.measureText(text, 0, text.length());
//            mPaint.setStyle(Style.FILL);
//            canvas.drawText(text, width / 2 - textWidth / 2, height / 4 + textHeight / 2, mPaint);
//        }
//
//        if (!TextUtils.isEmpty(mTxtHint2)) {
//            mPaint.setStrokeWidth(mTxtStrokeWidth);
//            text = mTxtHint2;
//            textHeight = height / 8;
//            mPaint.setTextSize(textHeight);
//            textWidth = (int) mPaint.measureText(text, 0, text.length());
//            mPaint.setStyle(Style.FILL);
//            canvas.drawText(text, width / 2 - textWidth / 2, 3 * height / 4 + textHeight / 2, mPaint);
//        }
        if (drawableCenter != 0) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.exeh5_icon_over);
//            canvas.drawBitmap(bitmap, width / 2 - bitmap.getWidth() / 2, height / 2 - bitmap.getHeight() / 2, mPaint);
            Bitmap newbmp = Bitmap.createScaledBitmap(bitmap, width-mCircleLineStrokeWidth-14, height-mCircleLineStrokeWidth-14, true);
            canvas.drawBitmap(newbmp, mCircleLineStrokeWidth/2+7, mCircleLineStrokeWidth/2+7, mPaint);


        }

    }
}
