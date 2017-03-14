package cpf.com.testlauncher.test_vollery;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.Volley;

import java.util.List;

import cpf.com.testlauncher.BitmapCache;
import cpf.com.testlauncher.R;

/**
 * Created by Administrator on 2017/2/28.
 */
public class CustomVolleyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context context;

    private List<String> imageList;

    private RequestQueue queue;

    private ImageLoader imageLoader;

    public CustomVolleyAdapter(Context context, List<String> imageList) {
        this.context = context;
        this.imageList = imageList;
        queue = Volley.newRequestQueue(context);
        imageLoader = new ImageLoader(queue,new BitmapCache());
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.test_vollery_frame_item,null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        MyViewHolder myViewHolder = (MyViewHolder)holder;
        myViewHolder.networkImageView.setDefaultImageResId(R.mipmap.default_img);
        myViewHolder.networkImageView.setErrorImageResId(R.mipmap.default_img);
        myViewHolder.networkImageView.setImageUrl(imageList.get(position),imageLoader);

    }

    @Override
    public int getItemCount() {
        return imageList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        NetworkImageView networkImageView;

        public MyViewHolder(View itemView) {
            super(itemView);
            networkImageView = (NetworkImageView)itemView.findViewById(R.id.test_vollery_frame_item_network_image_view);
        }
    }

}
