package cpf.com.testlauncher.test_im;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import cpf.com.testlauncher.R;
import cpf.com.testlauncher.ResultActivity;

/**
 * Created by Administrator on 2017/2/27.
 */

public class TestIMActivity extends Activity implements View.OnClickListener{

    private TextInputLayout usernameEt,passwordEt;

    private Button loginBtn,registBtn,sendBtn;

    private ExecutorService executorService = Executors.newCachedThreadPool();

    private TestSamck testSamck;

    private String username,password;

    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1:
                    boolean regist = (boolean)msg.obj;
                    if(regist){
                        Toast.makeText(TestIMActivity.this,"注册成功",Toast.LENGTH_SHORT).show();
                    }else{
                        passwordEt.setErrorEnabled(true);
                        passwordEt.setError("注册失败");
                    }
                    break;
                case 2:
                    boolean login = (boolean)msg.obj;
                    if(login){
                        Toast.makeText(TestIMActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
                        testSamck.recevieMsg(mHandler);
                    }else{
                        passwordEt.setErrorEnabled(true);
                        passwordEt.setError("用户名或密码不对");
                    }
                    break;
                case 3:
                    String content = (String)msg.obj;
                    startNotify(content);
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_im_login_layout);
        try{
            initView();
            initListener();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void initView() {
        testSamck = new TestSamck();
        usernameEt = (TextInputLayout)findViewById(R.id.test_im_username_til);
        passwordEt = (TextInputLayout)findViewById(R.id.test_im_password_til);
        loginBtn = (Button)findViewById(R.id.test_im_login_btn);
        registBtn = (Button)findViewById(R.id.test_im_regist_btn);
        sendBtn = (Button)findViewById(R.id.test_im_send_msg_btn);
        usernameEt.setHint("请输入用户名");
        passwordEt.setHint("请输入密码");
    }

    private void initListener() {
        loginBtn.setOnClickListener(this);
        registBtn.setOnClickListener(this);
        sendBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.test_im_login_btn:
                login();
                break;
            case R.id.test_im_regist_btn:
                regist();
                break;
            case R.id.test_im_send_msg_btn:
                testSamck.sendMsg();
                break;
            default:
                break;
        }
    }

    private void regist() {
        passwordEt.setErrorEnabled(false);
        username = usernameEt.getEditText().getText().toString();
        password = passwordEt.getEditText().getText().toString();
        MyTask myTask = new MyTask(1);
        executorService.execute(myTask);
    }

    private void login() {
        passwordEt.setErrorEnabled(false);
        username = usernameEt.getEditText().getText().toString();
        password = passwordEt.getEditText().getText().toString();
        MyTask myTask = new MyTask(2);
        executorService.execute(myTask);
    }

    class MyTask implements Runnable{

        private int testType;

        private boolean result;

        public MyTask(int testType) {
            this.testType = testType;
        }

        @Override
        public void run() {

            if(testType == 1){
                result = testSamck.regist(username,password);
            }else if(testType == 2){
                result = testSamck.login(username,password);
            }
            Message msg = new Message();
            msg.what = testType;
            msg.obj = result;
            mHandler.sendMessage(msg);
        }
    }

    private void startNotify(String content) {

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);

        mBuilder.setContentTitle("测试标题");
        mBuilder.setContentText(content);
        mBuilder.setSmallIcon(R.mipmap.ic_launcher);

        Intent resultIntent = new Intent(this, ResultActivity.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(ResultActivity.class);
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(
                        0,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );

        mBuilder.setContentIntent(resultPendingIntent);
        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
// mId allows you to update the notification later on.
        mNotificationManager.notify(0, mBuilder.build());


    }

}
