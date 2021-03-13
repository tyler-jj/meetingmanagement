package dao;

import domain.User;

public interface UserDao {
    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    public User findByUsername(String username);

    /**
     * 用户保存
     */
    public void save(User user);


    User findByCode(String code);

    void updataStates(User user);

    User findByUsernameAndPassword(String username, String password);
}
