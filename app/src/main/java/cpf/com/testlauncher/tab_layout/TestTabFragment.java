package cpf.com.testlauncher.tab_layout;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import cpf.com.testlauncher.R;

/**
 * Created by Administrator on 2017/2/10.
 */
public class TestTabFragment extends Fragment {

    TextView tv;

    public static TestTabFragment newInstance(int index){
        Bundle bundle = new Bundle();
        bundle.putString("index", "A" + index);
        TestTabFragment fragment = new TestTabFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.test_tab_fragment_layout,null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        tv = (TextView)view.findViewById(R.id.test_tab_fg_tv);
        String s = getArguments().getString("index").toString();
        System.out.print("==============="+s);
        tv.setText(s);
    }
}
