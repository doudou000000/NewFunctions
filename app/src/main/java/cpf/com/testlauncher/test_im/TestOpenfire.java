package cpf.com.testlauncher.test_im;

import android.os.Handler;

/**
 * Created by Administrator on 2017/2/27.
 */

public interface TestOpenfire {
    /**
     * 注册
     */
    public boolean regist(String usernmae,String password);

    /**
     * 登录
     */
    public boolean login(String usernmae,String password);

    /**
     * 添加好友
     */
    public void addFriend();

    /**
     * 发送消息
     */
    public void sendMsg();

    /**
     * 接收消息
     */
    public void recevieMsg(Handler mHandler);

}
