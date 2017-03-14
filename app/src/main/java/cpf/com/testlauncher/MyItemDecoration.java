package cpf.com.testlauncher;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Administrator on 2017/2/28.
 */
public class MyItemDecoration extends RecyclerView.ItemDecoration {

    private static final int[] ATRRS = new int[]{android.R.attr.listDivider};

    Drawable mDraeable;

    public MyItemDecoration(Context context) {

        TypedArray ta = context.obtainStyledAttributes(ATRRS);
        mDraeable = ta.getDrawable(0);
        ta.recycle();
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        int left = 0;
        int right = parent.getWidth();
        for(int i = 0; i < parent.getChildCount(); i++){
            View childView = parent.getChildAt(i);
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams)childView.getLayoutParams();
            int top = childView.getBottom() + params.bottomMargin;
            int bottom = top + mDraeable.getIntrinsicWidth();
            mDraeable.setBounds(left,top,right,bottom);
            mDraeable.draw(c);
        }

    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.set(0,0,0,mDraeable.getIntrinsicHeight());
    }
}
