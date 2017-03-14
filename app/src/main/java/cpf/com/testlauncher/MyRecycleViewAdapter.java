package cpf.com.testlauncher;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2017/2/24.
 */

public class MyRecycleViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private Context context;

    private List<TestRecycleBean> testRecycleBeanList;

    private boolean layout;

    public MyRecycleViewAdapter(Context context, List<TestRecycleBean> testRecycleBeanList) {
        this.context = context;
        this.testRecycleBeanList = testRecycleBeanList;
        layout = true;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        if(layout){
            view = LayoutInflater.from(context).inflate(R.layout.test_linear_recycle_view_item,null);
        }else{
            view = LayoutInflater.from(context).inflate(R.layout.test_grid_recycle_view_item,null);
        }

        return new CustomRecycleViewHolder(view);
    }

    public void setLayout(boolean layout){
        this.layout = layout;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            CustomRecycleViewHolder viewHolder = (CustomRecycleViewHolder)holder;
            viewHolder.titleTv.setText(testRecycleBeanList.get(position).getTitle());
            viewHolder.fatrueTv.setText(testRecycleBeanList.get(position).getFutrue());
            viewHolder.intrucTv.setText(testRecycleBeanList.get(position).getInstruc());
    }

    @Override
    public int getItemCount() {
        return testRecycleBeanList.size();
    }

    class CustomRecycleViewHolder extends RecyclerView.ViewHolder{

        TextView titleTv,fatrueTv,intrucTv;

        public CustomRecycleViewHolder(View itemView) {
            super(itemView);
            if(layout){
                titleTv = (TextView)itemView.findViewById(R.id.test_recycle_view_title_tv);
                fatrueTv = (TextView)itemView.findViewById(R.id.test_recycle_view_factrue_tv);
                intrucTv = (TextView)itemView.findViewById(R.id.test_recycle_view_intruct_tv);
            }else{
                titleTv = (TextView)itemView.findViewById(R.id.test_grid_recycle_view_title_tv);
                fatrueTv = (TextView)itemView.findViewById(R.id.test_grid_recycle_view_factrue_tv);
                intrucTv = (TextView)itemView.findViewById(R.id.test_grid_recycle_view_intruct_tv);
            }

        }


    }

}
