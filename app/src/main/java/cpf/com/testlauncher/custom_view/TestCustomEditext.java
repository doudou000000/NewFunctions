//package cpf.com.testlauncher.custom_view;
//
//import android.content.Context;
//import android.graphics.Canvas;
//import android.graphics.Color;
//import android.graphics.Paint;
//import android.util.AttributeSet;
//import android.widget.EditText;
//
///**
// * Created by Administrator on 2017/3/7.
// */
//
//public class TestCustomEditext extends EditText {
//
//    int lineHeigtht = 100;
//
//    int width;
//
//    int height;
//
//    int count;
//
//    Paint paint;
//
//    public TestCustomEditext(Context context) {
//        super(context);
//    }
//
//    public TestCustomEditext(Context context, AttributeSet attrs) {
//        super(context, attrs);
//    }
//
//    @Override
//    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
//        int heightSize = MeasureSpec.getMode(heightMeasureSpec);
//        width = widthSize;
//        height = heightSize;
//        count = height/lineHeigtht;
//
//        paint = new Paint();
//        paint.setColor(Color.BLACK);
//    }
//
//    @Override
//    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
//        for(int i = 0; i < count; i ++){
//            canvas.drawLine(0,lineHeigtht*(i+1),width,lineHeigtht*(i+1),paint);
//        }
//    }
//}
