package cpf.com.testlauncher.test_vollery;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import cpf.com.testlauncher.MyItemDecoration;
import cpf.com.testlauncher.R;

/**
 * Created by Administrator on 2017/2/28.
 */
public class TestVolleryFrameActivity extends Activity{

    RecyclerView recyclerView;

    List<String> imageList;

    CustomVolleyAdapter customVolleryAdaper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_vollery_frame_layout);
        try{
            initData();
            initView();
        }catch (Exception e){

        }
    }

    private void initData() {

        imageList = new ArrayList<String>();
        imageList.add("http://img.my.csdn.net/uploads/201407/26/1406383299_1976.jpg");
        imageList.add("http://img.my.csdn.net/uploads/201407/26/1406383291_6518.jpg");
        imageList.add("http://img.my.csdn.net/uploads/201407/26/1406383291_8239.jpg");
        imageList.add("http://img.my.csdn.net/uploads/201407/26/1406383290_9329.jpg");
        imageList.add("http://img.my.csdn.net/uploads/201407/26/1406383290_1042.jpg");
        imageList.add("http://img.my.csdn.net/uploads/201407/26/1406383275_3977.jpg");
        imageList.add("http://img.my.csdn.net/uploads/201407/26/1406383265_8550.jpg");
        imageList.add("http://img.my.csdn.net/uploads/201407/26/1406383264_3954.jpg");
        imageList.add("http://img.my.csdn.net/uploads/201407/26/1406383264_4787.jpg");
        imageList.add("http://img.my.csdn.net/uploads/201407/26/1406383264_8243.jpg");
        imageList.add("http://img.my.csdn.net/uploads/201407/26/1406383248_3693.jpg");
        imageList.add("http://img.my.csdn.net/uploads/201407/26/1406383243_5120.jpg");
        imageList.add("http://img.my.csdn.net/uploads/201407/26/1406383242_3127.jpg");
        imageList.add("http://img.my.csdn.net/uploads/201407/26/1406383242_9576.jpg");
        imageList.add("http://img.my.csdn.net/uploads/201407/26/1406383242_1721.jpg");
        imageList.add("http://img.my.csdn.net/uploads/201407/26/1406383219_5806.jpg");
        imageList.add("http://img.my.csdn.net/uploads/201407/26/1406383214_7794.jpg");
        imageList.add("http://img.my.csdn.net/uploads/201407/26/1406383213_4418.jpg");
        imageList.add("http://img.my.csdn.net/uploads/201407/26/1406383213_3557.jpg");
        imageList.add("http://img.my.csdn.net/uploads/201407/26/1406383210_8779.jpg");
        imageList.add("http://img.my.csdn.net/uploads/201407/26/1406383172_4577.jpg");
        imageList.add("http://img.my.csdn.net/uploads/201407/26/1406383166_3407.jpg");
        imageList.add("http://img.my.csdn.net/uploads/201407/26/1406383166_2224.jpg");
        imageList.add("http://img.my.csdn.net/uploads/201407/26/1406383166_7301.jpg");
        imageList.add("http://img.my.csdn.net/uploads/201407/26/1406383165_7197.jpg");
        imageList.add("http://img.my.csdn.net/uploads/201407/26/1406383150_8410.jpg");
        imageList.add("http://img.my.csdn.net/uploads/201407/26/1406383131_3736.jpg");
        imageList.add("http://img.my.csdn.net/uploads/201407/26/1406383130_5094.jpg");
        imageList.add("http://img.my.csdn.net/uploads/201407/26/1406383130_7393.jpg");
        imageList.add("http://img.my.csdn.net/uploads/201407/26/1406383129_8813.jpg");
        imageList.add("http://img.my.csdn.net/uploads/201407/26/1406383100_3554.jpg");
        imageList.add("http://img.my.csdn.net/uploads/201407/26/1406383093_7894.jpg");
        imageList.add("http://img.my.csdn.net/uploads/201407/26/1406383092_2432.jpg");
        imageList.add("http://img.my.csdn.net/uploads/201407/26/1406383092_3071.jpg");
        imageList.add("http://img.my.csdn.net/uploads/201407/26/1406383091_3119.jpg");
        imageList.add("http://img.my.csdn.net/uploads/201407/26/1406383059_6589.jpg");
        imageList.add("http://img.my.csdn.net/uploads/201407/26/1406383059_8814.jpg");
        imageList.add("http://img.my.csdn.net/uploads/201407/26/1406383059_2237.jpg");
        imageList.add("http://img.my.csdn.net/uploads/201407/26/1406383058_4330.jpg");
        imageList.add("http://img.my.csdn.net/uploads/201407/26/1406383038_3602.jpg");
        imageList.add("http://img.my.csdn.net/uploads/201407/26/1406382942_3079.jpg");
        imageList.add("http://img.my.csdn.net/uploads/201407/26/1406382942_8125.jpg");
        imageList.add("http://img.my.csdn.net/uploads/201407/26/1406382942_4881.jpg");
        imageList.add("http://img.my.csdn.net/uploads/201407/26/1406382941_4559.jpg");
        imageList.add("http://img.my.csdn.net/uploads/201407/26/1406382941_3845.jpg");
        imageList.add("http://img.my.csdn.net/uploads/201407/26/1406382924_8955.jpg");
        imageList.add("http://img.my.csdn.net/uploads/201407/26/1406382923_2141.jpg");
        imageList.add("http://img.my.csdn.net/uploads/201407/26/1406382923_8437.jpg");
        imageList.add("http://img.my.csdn.net/uploads/201407/26/1406382922_6166.jpg");
        imageList.add("http://img.my.csdn.net/uploads/201407/26/1406382922_4843.jpg");
        imageList.add("http://img.my.csdn.net/uploads/201407/26/1406382905_5804.jpg");
        imageList.add("http://img.my.csdn.net/uploads/201407/26/1406382904_3362.jpg");
        imageList.add("http://img.my.csdn.net/uploads/201407/26/1406382904_2312.jpg");
        imageList.add("http://img.my.csdn.net/uploads/201407/26/1406382904_4960.jpg");
        imageList.add("http://img.my.csdn.net/uploads/201407/26/1406382900_2418.jpg");
        imageList.add("http://img.my.csdn.net/uploads/201407/26/1406382881_4490.jpg");
        imageList.add("http://img.my.csdn.net/uploads/201407/26/1406382881_5935.jpg");
        imageList.add("http://img.my.csdn.net/uploads/201407/26/1406382880_3865.jpg");
        imageList.add("http://img.my.csdn.net/uploads/201407/26/1406382880_4662.jpg");
        imageList.add("http://img.my.csdn.net/uploads/201407/26/1406382879_2553.jpg");
        imageList.add("http://img.my.csdn.net/uploads/201407/26/1406382862_5375.jpg");
        imageList.add("http://img.my.csdn.net/uploads/201407/26/1406382862_1748.jpg");
        imageList.add("http://img.my.csdn.net/uploads/201407/26/1406382861_7618.jpg");
        imageList.add("http://img.my.csdn.net/uploads/201407/26/1406382861_8606.jpg");
        imageList.add("http://img.my.csdn.net/uploads/201407/26/1406382861_8949.jpg");
        imageList.add("http://img.my.csdn.net/uploads/201407/26/1406382841_9821.jpg");
        imageList.add("http://img.my.csdn.net/uploads/201407/26/1406382840_6603.jpg");
        imageList.add("http://img.my.csdn.net/uploads/201407/26/1406382840_2405.jpg");
        imageList.add("http://img.my.csdn.net/uploads/201407/26/1406382840_6354.jpg");
        imageList.add("http://img.my.csdn.net/uploads/201407/26/1406382839_5779.jpg");
        imageList.add("http://img.my.csdn.net/uploads/201407/26/1406382810_7578.jpg");
        imageList.add("http://img.my.csdn.net/uploads/201407/26/1406382810_2436.jpg");
        imageList.add("http://img.my.csdn.net/uploads/201407/26/1406382809_3883.jpg");
        imageList.add("http://img.my.csdn.net/uploads/201407/26/1406382809_6269.jpg");
        imageList.add("http://img.my.csdn.net/uploads/201407/26/1406382808_4179.jpg");
        imageList.add("http://img.my.csdn.net/uploads/201407/26/1406382790_8326.jpg");
        imageList.add("http://img.my.csdn.net/uploads/201407/26/1406382789_7174.jpg");
        imageList.add("http://img.my.csdn.net/uploads/201407/26/1406382789_5170.jpg");
        imageList.add("http://img.my.csdn.net/uploads/201407/26/1406382789_4118.jpg");
        imageList.add("http://img.my.csdn.net/uploads/201407/26/1406382788_9532.jpg");
        imageList.add("http://img.my.csdn.net/uploads/201407/26/1406382767_3184.jpg");
        imageList.add("http://img.my.csdn.net/uploads/201407/26/1406382767_4772.jpg");
        imageList.add("http://img.my.csdn.net/uploads/201407/26/1406382766_4924.jpg");
        imageList.add("http://img.my.csdn.net/uploads/201407/26/1406382766_5762.jpg");
        imageList.add("http://img.my.csdn.net/uploads/201407/26/1406382765_7341.jpg");

    }

    private void initView() {

        recyclerView = (RecyclerView)findViewById(R.id.test_vollery_frame_recycle_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(TestVolleryFrameActivity.this));
        recyclerView.addItemDecoration(new MyItemDecoration(TestVolleryFrameActivity.this));
        customVolleryAdaper = new CustomVolleyAdapter(TestVolleryFrameActivity.this,imageList);
        recyclerView.setAdapter(customVolleryAdaper);
    }
}
