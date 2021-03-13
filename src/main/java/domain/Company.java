package domain;

import java.io.Serializable;

public class Company implements Serializable {
    private int uid;//用户id
    private String companyname;//用户名，账号
    private String password;//密码
    private String email;//邮箱
    private String telephone;//电话号
    private String status;//激活状态，Y代表激活，N代表未激活
    private String code;//激活码（要求唯一）

    /**
     * 无参构造
     */
    public Company() {
    }

    /**
     * 有参构造
     * @param uid
     * @param companyname
     * @param password
     * @param email
     * @param telephone
     * @param status
     * @param code
     */
    public Company(int uid, String companyname, String password, String email, String telephone, String status, String code) {
        this.uid = uid;
        this.companyname = companyname;
        this.password = password;
        this.email = email;
        this.telephone = telephone;
        this.status = status;
        this.code = code;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
