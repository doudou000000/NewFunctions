package cpf.com.testlauncher.custom_view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2017/3/2.
 */

public class CustomCircleView extends View {

    private float circleX = 0;

    private float circleY = 0;

    private float circleR = 0;

    private Paint mPaint;

    public CustomCircleView(Context context) {
        this(context,null);
    }

    public CustomCircleView(Context context, AttributeSet attrs) {
        this(context,attrs,0);

    }

    public CustomCircleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint();
        mPaint.setStrokeWidth(4f);
        mPaint.setColor(Color.RED);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(circleX,circleY,circleR,mPaint);
    }

    public float getCircleX() {
        return circleX;
    }

    public void setCircleX(float circleX) {
        this.circleX = circleX;
    }

    public float getCircleY() {
        return circleY;
    }

    public void setCircleY(float circleY) {
        this.circleY = circleY;
    }

    public float getCircleR() {
        return circleR;
    }

    public void setCircleR(float circleR) {
        this.circleR = circleR;
    }
}
