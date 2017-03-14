package cpf.com.testlauncher;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Xml;
import android.view.View;
import android.widget.Button;

import org.xmlpull.v1.XmlPullParser;

import java.io.EOFException;
import java.io.InputStream;

/**
 * Created by Administrator on 2017/2/10.
 */
public class TestOtherActivity extends Activity{
    FloatingActionButton fab;
    CoordinatorLayout coordinatorLayout;
    Button btn15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_snack_layout);
        coordinatorLayout = (CoordinatorLayout)findViewById(R.id.layoutRoot);
        btn15 = (Button)findViewById(R.id.button15);
        fab = (FloatingActionButton)findViewById(R.id.test_new_message_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Snackbar snackbar = Snackbar.make(coordinatorLayout,"hey!I am Snackbar",Snackbar.LENGTH_LONG);
                snackbar.setAction("ok", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        snackbar.dismiss();
                    }
                });
                snackbar.getView().setBackgroundColor(TestOtherActivity.this.getResources().getColor(android.R.color.holo_red_dark));
                snackbar.show();
            }
        });

        btn15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    InputStream xml = getAssets().open("1.txt");
                    pullPaserXML(xml);
                }catch (Exception e){

                }

            }
        });

    }


    private void pullPaserXML(InputStream xml){

        // 利用ANDROID提供的API快速获得pull解析器
        XmlPullParser pullParser = Xml.newPullParser();
        int event = 0;
        // 设置需要解析的XML数据
        try{
            pullParser.setInput(xml, "UTF-8");
            // 取得事件
            event = pullParser.getEventType();
        }catch (Exception e){

        }

        // 若为解析到末尾
        while (event != XmlPullParser.END_DOCUMENT) // 文档结束
        {
            String nodeName = pullParser.getName();
            switch (event)
            {
                case XmlPullParser.START_DOCUMENT: // 文档开始
                    break;
                case XmlPullParser.START_TAG: // 标签开始

                    if (nodeName.equals("UploadApplyResponse")) {
                        String Status = pullParser.getAttributeValue("", "Status");
                        System.out.print(Status);
                    }
                    break;
                case XmlPullParser.END_TAG: // 标签结束

                    break;
            }
            try{
                event = pullParser.next(); // 下一个标签
            }catch (Exception e){

            }

        }



    }

}
