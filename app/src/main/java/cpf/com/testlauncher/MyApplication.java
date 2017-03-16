package cpf.com.testlauncher;

import android.app.Application;
import android.view.WindowManager;

import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import org.jivesoftware.smack.tcp.XMPPTCPConnectionConfiguration;
import org.jivesoftware.smackx.iqregister.AccountManager;

import java.sql.Connection;

public class MyApplication extends Application {

    private String username = "test1";
    private String password = "123456";

    private WindowManager.LayoutParams params = new WindowManager.LayoutParams();

    public WindowManager.LayoutParams getWindowParams(){
        return params;
    }

    public static XMPPTCPConnection connection;

    @Override
    public void onCreate() {
        super.onCreate();
        connection = getConnection();
//        setConnction();
    }
//
//    private void setConnction() {
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try{
//
////                    connection.connect();
////                    connection.login("test1","test12");
////            AccountManager amgr = AccountManager.getInstance(connection);
////            amgr.createAccount(username,password);
//                }catch (Exception e){
//                    e.printStackTrace();
//                }
//            }
//        }).start();
//
//    }

    private XMPPTCPConnection getConnection(){
        String server="172.16.0.221";
        int port=5222;
        XMPPTCPConnectionConfiguration.Builder builder = XMPPTCPConnectionConfiguration.builder();
        builder.setServiceName(server);
        builder.setHost(server);
        builder.setPort(port);
        builder.setCompressionEnabled(true);
        builder.setDebuggerEnabled(true);
        builder.setSendPresence(true);
        builder.setSecurityMode(ConnectionConfiguration.SecurityMode.disabled);
        XMPPTCPConnection connection = new XMPPTCPConnection(builder.build());
        return connection;
    }

}
