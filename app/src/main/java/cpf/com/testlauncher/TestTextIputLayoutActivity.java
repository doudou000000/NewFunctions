package cpf.com.testlauncher;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2017/2/17.
 */

public class TestTextIputLayoutActivity extends Activity {

    TextInputLayout usernameText;
    TextInputLayout passwordText;
    EditText usernameEt,passwordEt;
    Button loginBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_text_input_layout);
        try{
            initView();
            initListener();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void initView() {

        usernameText = (TextInputLayout)findViewById(R.id.text_input_username);
        passwordText = (TextInputLayout)findViewById(R.id.text_input_password);
        loginBtn = (Button)findViewById(R.id.btn);
        usernameEt = usernameText.getEditText();
        passwordEt = passwordText.getEditText();
        usernameText.setHint("请输入用户名");
        passwordText.setHint("请输入密码");
    }

    private void initListener() {

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validity(usernameEt.getText().toString(),passwordEt.getText().toString())){
                    passwordText.setErrorEnabled(false);
                    Toast.makeText(TestTextIputLayoutActivity.this,"登陆成功",Toast.LENGTH_SHORT).show();
                }else{
                    passwordText.setError("用户名或密码不对");
                };
            }
        });

    }


    private boolean validity(String username, String password) {

        // 正则表达式规则 四位中文
        String userReg = "^[\\u0391-\\uFFE5]{4}$";
        // 编译正则表达式
        Pattern userPattern = Pattern.compile(userReg);
        // 忽略大小写的写法
        // Pattern pat = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
        Matcher userMatcher = userPattern.matcher(username);
        // 查找字符串中是否有匹配正则表达式的字符/字符串
        boolean userRegReult = userMatcher.find();

        // 正则表达式规则 四位中文
        String passwordReg = "^[1-9]{8}$";
        // 编译正则表达式
        Pattern passwordPattern = Pattern.compile(passwordReg);
        // 忽略大小写的写法
        // Pattern pat = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
        Matcher passwordMatcher = passwordPattern.matcher(password);
        // 查找字符串中是否有匹配正则表达式的字符/字符串
        boolean passwordRegReult = passwordMatcher.find();

        if(userRegReult && passwordRegReult){
            return true;
        }

        return false;

    }

}
