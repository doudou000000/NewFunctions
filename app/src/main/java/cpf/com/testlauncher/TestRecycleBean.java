package cpf.com.testlauncher;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/2/24.
 */

public class TestRecycleBean implements Serializable{

    private String title;

    private String futrue;

    private String instruc;

    public TestRecycleBean() {
    }

    public TestRecycleBean(String title, String futrue, String instruc) {
        this.title = title;
        this.futrue = futrue;
        this.instruc = instruc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFutrue() {
        return futrue;
    }

    public void setFutrue(String futrue) {
        this.futrue = futrue;
    }

    public String getInstruc() {
        return instruc;
    }

    public void setInstruc(String instruc) {
        this.instruc = instruc;
    }
}
