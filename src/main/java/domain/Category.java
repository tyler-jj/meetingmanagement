package domain;

import java.io.Serializable;

public class Category implements Serializable {
    private int cid;//分类id
    private String cname;//分类名称
    private String flag;//分类名称

    public Category() {
    }

    public Category(int cid, String cname, String flag) {
        this.cid = cid;
        this.cname = cname;
        this.flag = flag;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }
}
