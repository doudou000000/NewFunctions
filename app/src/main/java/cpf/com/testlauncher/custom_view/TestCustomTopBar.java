package cpf.com.testlauncher.custom_view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import cpf.com.testlauncher.R;

/**
 * Created by Administrator on 2017/3/6.
 */

public class TestCustomTopBar extends RelativeLayout {

    private String title;

    private float titleSize;

    private int titleColor;

    private String leftButtonText;
    
    private int leftButtonBackground;
    
    private int leftButtonTextColor;

    private String rightButtonText;

    private int rightButtonBackground;

    private int rightButtonTextColor;

    private Button leftBtn,rightBtn;
    
    private TextView titleTv;
    
    private LayoutParams leftParams,rightParams,titleParams;
    
    public TestCustomTopBar(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.custom_view);

        title = ta.getString(R.styleable.custom_view_title);

        titleSize = ta.getDimension(R.styleable.custom_view_titleSize,0);

        titleColor = ta.getColor(R.styleable.custom_view_titleColor,0);
        
        leftButtonText = ta.getString(R.styleable.custom_view_leftButtonText);
        
        leftButtonBackground = ta.getColor(R.styleable.custom_view_leftButtonBackground,0);
        
        leftButtonTextColor = ta.getColor(R.styleable.custom_view_leftButtonTextColor,0);

        rightButtonText = ta.getString(R.styleable.custom_view_rightButtonText);

        rightButtonBackground = ta.getColor(R.styleable.custom_view_rightButtonBackground,0);

        rightButtonTextColor = ta.getColor(R.styleable.custom_view_rightButtonTextColor,0);

        setBackgroundColor(Color.RED);

        leftBtn = new Button(context);
        rightBtn = new Button(context);
        titleTv = new TextView(context);

        leftBtn.setBackgroundColor(leftButtonBackground);
        leftBtn.setText(leftButtonText);
        leftBtn.setTextColor(leftButtonTextColor);

        rightBtn.setBackgroundColor(rightButtonBackground);
        rightBtn.setText(rightButtonText);
        rightBtn.setTextColor(rightButtonTextColor);

        titleTv.setTextSize(titleSize);
        titleTv.setText(title);
        titleTv.setTextColor(titleColor);
        titleTv.setGravity(Gravity.CENTER);
        
        leftParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        leftParams.addRule(ALIGN_PARENT_LEFT,TRUE);
        addView(leftBtn,leftParams);

        rightParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        rightParams.addRule(ALIGN_PARENT_RIGHT,TRUE);
        addView(rightBtn,rightParams);

        titleParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        titleParams.addRule(CENTER_IN_PARENT,TRUE);
        addView(titleTv,titleParams);

        leftBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                onTopBarClickListener.leftBtnListener();
            }
        });

        rightBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                onTopBarClickListener.rightBtnListener();
            }
        });

    }

    public interface OnTopBarClickListener{

        public void leftBtnListener();
        public void rightBtnListener();

    }

    private OnTopBarClickListener onTopBarClickListener;

    public void setTopBarClickListener(OnTopBarClickListener onTopBarClickListener){
        this.onTopBarClickListener = onTopBarClickListener;
    }

}
