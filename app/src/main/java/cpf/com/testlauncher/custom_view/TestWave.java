package cpf.com.testlauncher.custom_view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.PointF;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;

/**
 * Created by Administrator on 2017/3/8.
 */

public class TestWave extends View {

    Paint mPaint;

    Path mPath;

    int screenWidth;

    int screenHeight;

    boolean is = true;

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
//            if (msg.what == 1) {
//                if(is){
//                    prgress += 10;
//                }else{
//                    prgress -= 10;
//                }
//                if(prgress == 2*mWavePeak){
//                    is = false;
//                }
//                if(prgress == 0){
//                    is = true;
//                }
//                invalidate();
//            }
            reset();
            startAnim();
            isRunning = true;
        }

    };

    private int prgress = 0;

    /**
     * 波峰
     */
    private float mWavePeak = 35f;
    /**
     * 波槽
     */
    private float mWaveTrough = 35f;
    /**
     * 水位
     */
    private float mWaveHeight = 250f;


    private boolean isRunning = false;

    private PointF startP,fristP,secondP,thirdP,forthP,firp,controllP1,controllP2,controllP3,controllP4;


    public TestWave(Context context) {
        super(context);
        init(context);
    }

    public TestWave(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public TestWave(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public void init(Context context){

        WindowManager w = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);

        screenWidth = w.getDefaultDisplay().getWidth();

        screenHeight = w.getDefaultDisplay().getHeight();

        mPaint = new Paint();
        mPaint.setStrokeWidth(20);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(0xBB0000FF);
        mPath = new Path();



    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(!isRunning){
            return;
        }
        mPath.reset();
//        mPath.moveTo(0,screenHeight-mWaveHeight);
//        mPath.quadTo(screenWidth/4,(screenHeight-mWaveHeight - mWavePeak) + (mWavePeak)*prgress/(mWavePeak),screenWidth/2,screenHeight-mWaveHeight);
//        mPath.quadTo(3*screenWidth/4,(screenHeight-mWaveHeight + mWavePeak) - (mWavePeak)*prgress/(mWavePeak),screenWidth,screenHeight-mWaveHeight);
//        mPath.lineTo(screenWidth,screenHeight);
//       mPath.lineTo(0,screenHeight);
//        canvas.drawPath(mPath,mPaint);

        mPath.moveTo(fristP.x,fristP.y);
        mPath.quadTo(controllP1.x,controllP1.y,secondP.x,secondP.y);
        mPath.quadTo(controllP2.x,controllP2.y,thirdP.x,thirdP.y);
        mPath.quadTo(controllP3.x,controllP3.y,forthP.x,forthP.y);
        mPath.quadTo(controllP4.x,controllP4.y,firp.x,firp.y);
        mPath.lineTo(firp.x,screenHeight);
        mPath.lineTo(fristP.x,screenHeight);
        mPath.lineTo(fristP.x,fristP.y);
        canvas.drawPath(mPath,mPaint);

    }



    public void start(){

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
//                    while (true){

//                        Thread.sleep(50);
                        handler.sendEmptyMessage(1);
//                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();

    }



    private void reset() {

        startP = new PointF(-screenWidth,screenHeight-(int)mWaveHeight);
        fristP = new PointF(-screenWidth,screenHeight-(int)mWaveHeight);
        secondP = new PointF(-screenWidth/2,screenHeight-(int)mWaveHeight);
        thirdP = new PointF(0,screenHeight-(int)mWaveHeight);
        forthP = new PointF(screenWidth/2,screenHeight-(int)mWaveHeight);
        firp = new PointF(screenWidth,screenHeight-(int)mWaveHeight);
        controllP1 = new PointF(-screenWidth/4,screenHeight-(int)mWaveHeight - (int) mWavePeak);
        controllP2 = new PointF(-screenWidth*3/4,screenHeight-(int)mWaveHeight + (int) mWavePeak);
        controllP3 = new PointF(screenWidth/4,screenHeight-(int)mWaveHeight - (int) mWavePeak);
        controllP4 = new PointF(screenWidth*3/4,screenHeight-(int)mWaveHeight + (int) mWavePeak);


    }

    private void startAnim() {

        ValueAnimator va = ValueAnimator.ofFloat(startP.x,0);
        va.setInterpolator(new LinearInterpolator());
        va.setDuration(2000);

        va.setRepeatCount(ValueAnimator.INFINITE);

        va.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {

                fristP.x = (Float) animation.getAnimatedValue();
                secondP = new PointF((fristP.x + screenWidth/2),screenHeight-(int)mWaveHeight);
                thirdP = new PointF((secondP.x + screenWidth/2),screenHeight-(int)mWaveHeight);
                forthP = new PointF(thirdP.x + screenWidth/2,screenHeight-(int)mWaveHeight);
                firp = new PointF(forthP.x + screenWidth/2,screenHeight-(int)mWaveHeight);
                controllP1 = new PointF(fristP.x + screenWidth/4,screenHeight-(int)mWaveHeight - (int) mWavePeak);
                controllP2 = new PointF(secondP.x + screenWidth/4,screenHeight-(int)mWaveHeight + (int) mWavePeak);
                controllP3 = new PointF(thirdP.x + screenWidth/4,screenHeight-(int)mWaveHeight - (int) mWavePeak);
                controllP4 = new PointF(forthP.x + screenWidth/4,screenHeight-(int)mWaveHeight + (int) mWavePeak);
                invalidate();
            }
        });
        va.start();
    }

}
