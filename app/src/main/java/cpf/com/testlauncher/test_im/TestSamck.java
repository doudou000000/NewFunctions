package cpf.com.testlauncher.test_im;

import android.os.Handler;

import org.jivesoftware.smack.chat.Chat;
import org.jivesoftware.smack.chat.ChatManager;
import org.jivesoftware.smack.chat.ChatManagerListener;
import org.jivesoftware.smack.chat.ChatMessageListener;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import org.jivesoftware.smackx.iqregister.AccountManager;

import cpf.com.testlauncher.MyApplication;
import cpf.com.testlauncher.test_im.TestOpenfire;

/**
 * Created by Administrator on 2017/2/27.
 */

public class TestSamck implements TestOpenfire {



    @Override
    public boolean regist(String usernmae,String password){
        boolean registResult;
        //获取连接
        XMPPTCPConnection conn = MyApplication.connection;
        try{
            if(!conn.isConnected()){
                conn.connect();
            }
            AccountManager accountManager = AccountManager.getInstance(conn);
            accountManager.createAccount(usernmae,password);
            registResult = true;
        }catch (Exception e){
            registResult = false;
            e.printStackTrace();
        }
        if(conn.isConnected()){
            conn.disconnect();
        }
        return registResult;
    }

    @Override
    public boolean login(String username,String password) {
        boolean loginResult;
        //获取连接
        XMPPTCPConnection conn = MyApplication.connection;
        try{
            if(!conn.isConnected()){
                conn.connect();
            }
            conn.login(username,password);
            loginResult = true;
        }catch (Exception e){
            loginResult = false;
            e.printStackTrace();
        }
        return loginResult;
    }

    @Override
    public void addFriend() {

    }

    @Override
    public void sendMsg() {
        XMPPTCPConnection conn = MyApplication.connection;
        ChatManager chatm = ChatManager.getInstanceFor(conn);
        Chat chat = chatm.createChat("test@172.16.0.221", new ChatMessageListener() {        //创建与piyell的会话
            public void processMessage(Chat chat, Message message) {
                System.out.println("Received message: " + message);
            }
        });
        try {
            /**
             * 发送一条消息给piyell
             */
            Message message = new Message("test@172.16.0.221");
            message.addBody(null, "http://pic55.nipic.com/file/20141208/19462408_171130083000_2.jpg");
            message.addSubject("favorite color", "red");
//            chat.sendMessage("Hello World!");
            chat.sendMessage(message);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Override
    public void recevieMsg(final Handler mHandler) {
        //获取连接
        XMPPTCPConnection conn = MyApplication.connection;
        try{
            if(!conn.isConnected()){
                conn.connect();
            }
            ChatManager chatManager = ChatManager.getInstanceFor(conn);
            chatManager.addChatListener(new ChatManagerListener() {
                @Override
                public void chatCreated(Chat chat, boolean createdLocally) {
                    chat.addMessageListener(new ChatMessageListener() {
                        @Override
                        public void processMessage(Chat chat, Message message) {
                            String content = message.getBody();
                            if(content != null){
                                android.os.Message msg = new android.os.Message();
                                msg.what = 3;
                                msg.obj = content;
                                mHandler.sendMessage(msg);
                            }
                        }
                    });
                }
            });

        }catch (Exception e){
            e.printStackTrace();
        }


    }

}
