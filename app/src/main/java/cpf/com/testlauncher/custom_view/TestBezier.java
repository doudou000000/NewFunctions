package cpf.com.testlauncher.custom_view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

import cpf.com.testlauncher.R;

/**
 * Created by Administrator on 2017/3/7.
 */

public class TestBezier extends View {

    private Path mPath;

    private Paint mPaint;

    private float assitpointX = 100;

    private float assitpointY = 100;

    private float startX  = 100;

    private float startY  = 100;

    private float endX = 600;

    private float endY = 100;

    private Bitmap background,bitmap,upBitmap;

    private int screemWidth;

    private int screemHeight;

    BitmapFactory.Options opt;

    private boolean isShowBitmap = false;

    private boolean isCallBack = true;

    public TestBezier(Context context) {
        this(context,null);
    }

    public TestBezier(Context context, AttributeSet attrs) {
        this(context,attrs,0);
    }

    public TestBezier(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);

        screemWidth = windowManager.getDefaultDisplay().getWidth();
        screemHeight = windowManager.getDefaultDisplay().getHeight();



        opt = new BitmapFactory.Options();
        opt.inJustDecodeBounds = true;

//        BitmapFactory.decodeResource(getResources(), com.wingsofts.my360clean.R.drawable.t,opt);
//        int bgWidth = opt.outWidth;
//        int bgHeight = opt.outHeight;

        //按线的长度缩放背景图
//        Log.e("wing",bgWidth + " " +scale+"");
        opt.inSampleSize= 2;
//        opt.outWidth = 500;
        opt.inJustDecodeBounds = false;

        background = BitmapFactory.decodeResource(getResources(), R.drawable.t,opt);
        bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.mb);
        upBitmap = BitmapFactory.decodeResource(getResources(),R.drawable.m);
        startX = (screemWidth-background.getWidth())/2;

        endX = startX + background.getWidth();

        startY = screemHeight/2 + background.getHeight()/2;

        assitpointX = (screemWidth)/2;

        assitpointY = startY;

        endY = startY;

        mPath = new Path();

        mPaint = new Paint();
        mPaint.setStrokeWidth(20); //画笔宽度
        mPaint.setStyle(Paint.Style.STROKE);



    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    int mFlyPercent = 100;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(background,(screemWidth-background.getWidth())/2,(screemHeight-background.getHeight())/2,mPaint);

        mPath.reset();
        mPath.moveTo(startX,startY);

        if(isShowBitmap){

            canvas.drawBitmap(bitmap,assitpointX-bitmap.getWidth()/2,(assitpointY -startY)/2 + startY- bitmap.getHeight(),mPaint);
        }

        if(isCallBack){
            mPaint.setColor(Color.YELLOW);
            mPath.quadTo(assitpointX,assitpointY,endX,endY);
            canvas.drawPath(mPath,mPaint);
        }else{
            mPaint.setColor(Color.YELLOW);
                mPath.quadTo(assitpointX,  startY + (assitpointY - startY) * mFlyPercent / 100, endX,endY);
                canvas.drawPath(mPath, mPaint);

                if(mFlyPercent >0) {
                    canvas.drawBitmap(upBitmap, assitpointX-upBitmap.getWidth()/2, ((assitpointY -startY)/2 + startY- upBitmap.getHeight())* mFlyPercent/100, mPaint);
                    mFlyPercent -=2;
                    postInvalidateDelayed(10);
                }else {
                    mFlyPercent = 100;
                    isCallBack = true;
                }

        }
        mPaint.setColor(Color.GRAY);
        canvas.drawCircle(startX,startY,10,mPaint);
        canvas.drawCircle(endX,endY,10,mPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()){

            case MotionEvent.ACTION_DOWN:

                break;

            case MotionEvent.ACTION_MOVE:
                isShowBitmap = true;
                if(event.getY() > startY){
                    assitpointY = event.getY();
                    invalidate();
                }

            break;
            case MotionEvent.ACTION_UP:
                if(event.getY() < startY){
                     break;
                }
                isShowBitmap = false;
                isCallBack = false;
                invalidate();
                break;
        }
        return true;
    }
}
