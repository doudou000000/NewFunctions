package cpf.com.testlauncher;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/2/10.
 */
public class TestRecycleViewActivity extends Activity{

    RecyclerView testRecycleView;

    List<TestRecycleBean> testRecycleBeanList;

    private MyRecycleViewAdapter myRecycleViewAdapter;

    Button btn;

    boolean layout = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_recycle_view_layout);
        try{
            initData();
            initView();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void initData() {

        testRecycleBeanList = new ArrayList<TestRecycleBean>();
        TestRecycleBean testRecycleBean = new TestRecycleBean("剩下的就没时间看","jksf","hefsdksjdvskkhsksddkvssjjsdj");
        TestRecycleBean testRecycleBean1 = new TestRecycleBean("找师傅","jksf","hefsdksjdvskkhsksddkvssjjsdj");
        TestRecycleBean testRecycleBean2 = new TestRecycleBean("造成","jksf","hefsdksjdvskkhsksddkvssjjsdj");
        TestRecycleBean testRecycleBean3 = new TestRecycleBean("是否","jksf","hefsdksjdvskkhsksddkvssjjsdj");
        TestRecycleBean testRecycleBean4 = new TestRecycleBean("十分丰富的","jksf","hefsdksjdvskkhsksddkvssjjsdj");
        TestRecycleBean testRecycleBean5 = new TestRecycleBean("发挥地方","jksf","hefsdksjdvskkhsksddkvssjjsdj");
        TestRecycleBean testRecycleBean6 = new TestRecycleBean("按时到达时","jksf","hefsdksjdvskkhsksddkvssjjsdj");
        TestRecycleBean testRecycleBean7 = new TestRecycleBean("多个","jksf","hefsdksjdvskkhsksddkvssjjsdj");
        TestRecycleBean testRecycleBean8 = new TestRecycleBean("按时","jksf","hefsdksjdvskkhsksddkvssjjsdj");
        TestRecycleBean testRecycleBean9 = new TestRecycleBean("的话","jksf","hefsdksjdvskkhsksddkvssjjsdj");
        TestRecycleBean testRecycleBean10 = new TestRecycleBean("附近的","jksf","hefsdksjdvskkhsksddkvssjjsdj");
        TestRecycleBean testRecycleBean11 = new TestRecycleBean("过几天","jksf","hefsdksjdvskkhsksddkvssjjsdj");
        TestRecycleBean testRecycleBean12 = new TestRecycleBean("十大歌手","jksf","hefsdksjdvskkhsksddkvssjjsdj");
        TestRecycleBean testRecycleBean13 = new TestRecycleBean("当人肉","jksf","hefsdksjdvskkhsksddkvssjjsdj");
        TestRecycleBean testRecycleBean14 = new TestRecycleBean("深入骨髓","jksf","hefsdksjdvskkhsksddkvssjjsdj");
        TestRecycleBean testRecycleBean15 = new TestRecycleBean("电话突然","jksf","hefsdksjdvskkhsksddkvssjjsdj");
        TestRecycleBean testRecycleBean16 = new TestRecycleBean("工业集团与","jksf","hefsdksjdvskkhsksddkvssjjsdj");
        TestRecycleBean testRecycleBean17 = new TestRecycleBean("沙发上","jksf","hefsdksjdvskkhsksddkvssjjsdj");
        TestRecycleBean testRecycleBean18 = new TestRecycleBean("多喝点","jksf","hefsdksjdvskkhsksddkvssjjsdj");
        TestRecycleBean testRecycleBean19 = new TestRecycleBean("东风浩荡","jksf","hefsdksjdvskkhsksddkvssjjsdj");
        TestRecycleBean testRecycleBean20 = new TestRecycleBean("乳业律师","jksf","hefsdksjdvskkhsksddkvssjjsdj");
        TestRecycleBean testRecycleBean21 = new TestRecycleBean("加分不到","jksf","hefsdksjdvskkhsksddkvssjjsdj");
        TestRecycleBean testRecycleBean22 = new TestRecycleBean("我发誓v是v","jksf","hefsdksjdvskkhsksddkvssjjsdj");
        TestRecycleBean testRecycleBean23 = new TestRecycleBean("阜阳教育局发布的","jksf","hefsdksjdvskkhsksddkvssjjsdj");
        testRecycleBeanList.add(testRecycleBean);
        testRecycleBeanList.add(testRecycleBean1);
        testRecycleBeanList.add(testRecycleBean2);
        testRecycleBeanList.add(testRecycleBean3);
        testRecycleBeanList.add(testRecycleBean4);
        testRecycleBeanList.add(testRecycleBean5);
        testRecycleBeanList.add(testRecycleBean6);
        testRecycleBeanList.add(testRecycleBean7);
        testRecycleBeanList.add(testRecycleBean8);
        testRecycleBeanList.add(testRecycleBean9);
        testRecycleBeanList.add(testRecycleBean10);
        testRecycleBeanList.add(testRecycleBean11);
        testRecycleBeanList.add(testRecycleBean12);
        testRecycleBeanList.add(testRecycleBean13);
        testRecycleBeanList.add(testRecycleBean14);
        testRecycleBeanList.add(testRecycleBean15);
        testRecycleBeanList.add(testRecycleBean16);
        testRecycleBeanList.add(testRecycleBean17);
        testRecycleBeanList.add(testRecycleBean18);
        testRecycleBeanList.add(testRecycleBean19);
        testRecycleBeanList.add(testRecycleBean20);
        testRecycleBeanList.add(testRecycleBean21);
        testRecycleBeanList.add(testRecycleBean22);
        testRecycleBeanList.add(testRecycleBean23);
    }

    private void initView() {

        testRecycleView = (RecyclerView)findViewById(R.id.test_recycle_view);

        btn = (Button)findViewById(R.id.test_recycle_view_btn);

        myRecycleViewAdapter = new MyRecycleViewAdapter(TestRecycleViewActivity.this,testRecycleBeanList);

        testRecycleView.setLayoutManager(new LinearLayoutManager(this));

        testRecycleView.setAdapter(myRecycleViewAdapter);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(layout){
                    layout = false;
                    testRecycleView.setLayoutManager(new GridLayoutManager(TestRecycleViewActivity.this,2));

                }else{
                    layout = true;
                    testRecycleView.setLayoutManager(new LinearLayoutManager(TestRecycleViewActivity.this));
                }
                myRecycleViewAdapter.setLayout(layout);
                myRecycleViewAdapter.notifyDataSetChanged();
            }
        });

    }
}
