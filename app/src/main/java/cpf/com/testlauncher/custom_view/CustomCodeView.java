package cpf.com.testlauncher.custom_view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import cpf.com.testlauncher.R;

/**
 * Created by Administrator on 2017/3/3.
 */

public class CustomCodeView extends View{

    private Paint mPaint;

    private String text;

    private int textSize;

    private int textColor;

    private Rect rect;

    private int circleX;
    private int circleY;
    private int circleR = 2;

    int width;
    int height;

    public CustomCodeView(Context context) {
        this(context,null);
    }

    public CustomCodeView(Context context, AttributeSet attrs) {
        this(context,attrs,0);
    }

    public CustomCodeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.custom_code_view);
        text = ta.getText(R.styleable.custom_code_view_text).toString();
        textSize = ta.getDimensionPixelSize(R.styleable.custom_code_view_textSise,20);
        textColor = ta.getColor(R.styleable.custom_code_view_textColor, Color.BLACK);
        ta.recycle();
        mPaint = new Paint();
        mPaint.setTextSize(textSize);

        rect = new Rect();
        mPaint.getTextBounds(text,0,text.length(),rect);
        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                text = randomText();

                postInvalidate();
            }

        });
    }


    private String randomText() {

        Random random = new Random();
        List<Integer> set = new ArrayList<Integer>();

        while (set.size()<4){
             set.add(random.nextInt(10));
        }

        StringBuffer sb = new StringBuffer();
        for (Integer i : set)
        {
            sb.append("" + i);
        }

        return sb.toString();

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        if(widthMode == MeasureSpec.EXACTLY){
            width = widthSize;
        }else{
            rect = new Rect();
            mPaint.getTextBounds(text,0,text.length(),rect);
            int textWidth = rect.width();
            width = getPaddingStart()+textWidth+getPaddingEnd();
        }
        if(heightMode == MeasureSpec.EXACTLY){
            height = heightSize;
        }else{
            rect = new Rect();
            mPaint.getTextBounds(text,0,text.length(),rect);
            int textHeight = rect.height();
            height = getPaddingBottom()+textHeight+getPaddingTop();
        }
        setMeasuredDimension(width,height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//
//        int mWidth = getMeasuredWidth();
//        int mHeight = getMeasuredHeight();
//        int width = getWidth();
//        int height = getHeight();

        int x = circleR;

        int y = circleR;

        mPaint.setColor(Color.YELLOW);
        canvas.drawRect(0,0,getMeasuredWidth(),getMeasuredHeight(),mPaint);

        mPaint.setColor(textColor);
        canvas.drawText(text,getWidth() / 2 - rect.width() / 2, getHeight() / 2 + rect.height() / 2, mPaint);


        mPaint.setColor(Color.BLACK);
        for(int i = 0; i < 100; i++){
            circleX = new Random().nextInt(width);
            circleY = new Random().nextInt(height);
            if(circleX > circleR && circleX < (width-circleR)){
                x = circleX;
            }
            if(circleY > circleR && circleY < (height-circleR)){
                y = circleY;
            }
            canvas.drawCircle(x,y,circleR,mPaint);
        }

        int startX;

        int stopX;

        int startY;

        int stopY;

        mPaint.setColor(Color.GRAY);
        for(int i = 0; i < 10; i++){
            startX = new Random().nextInt(width);
            stopX = new Random().nextInt(width);
            startY = new Random().nextInt(height);
            stopY = new Random().nextInt(height);
            if(startX > 0 && startX < width && stopX > 0 && stopX < width && startX != stopX){
                startX = startX;
                stopX = stopX;
            }
            if(startY > 0 && startY < height && stopY > 0 && stopY < height && startY != stopY){
                startY = startY;
                stopY = stopY;
            }
            canvas.drawLine(startX,startY,stopX,stopY,mPaint);
        }

    }

}
