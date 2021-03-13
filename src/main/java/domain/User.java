package domain;

import java.io.Serializable;

/**
 * 用户实体类
 */
public class User implements Serializable {
    private int uid;//用户id
    private String username;//用户名，账号
    private String password;//密码
    private String email;//邮箱
    private String name;//真实姓名
    private String telephone;//手机号
    private String sex;//男或女
    private String birthday;//出生日期
    private String company;//公司
    private String post;//职务
    private String status;//激活状态，Y代表激活，N代表未激活
    private String code;//激活码（要求唯一）

    /**
     * 有参构造
     * @param uid
     * @param username
     * @param password
     * @param email
     * @param name
     * @param telephone
     * @param sex
     * @param birthday
     * @param company
     * @param post
     * @param status
     * @param code
     */
    public User(int uid, String username, String password, String email, String name, String telephone, String sex, String birthday, String company, String post, String status, String code) {
        this.uid = uid;
        this.username = username;
        this.password = password;
        this.email = email;
        this.name = name;
        this.telephone = telephone;
        this.sex = sex;
        this.birthday = birthday;
        this.company = company;
        this.post = post;
        this.status = status;
        this.code = code;
    }

    /**
     * 无参构造
     */
    public User() {
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
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
