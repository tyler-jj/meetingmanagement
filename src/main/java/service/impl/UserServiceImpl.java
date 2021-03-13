package service.impl;

import cn.itcast.travel.util.UuidUtil;
import dao.UserDao;
import dao.impl.UserDaoImpl;
import domain.User;
import service.UserService;
import util.MailUtils;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    /**
     * 注册用户
     *
     * @param user
     * @return
     */
    @Override
    public boolean regist(User user) {
        User finduser = userDao.findByUsername(user.getUsername());
        boolean flag = false;
        if (finduser == null) {
            System.out.println("注册成功");
            //设置唯一激活码
            user.setCode(UuidUtil.getUuid());
            user.setStatus("N");
            //保存用户信息
            userDao.save(user);
            //发送激活邮件
            String emailText = "<a href='http://localhost:8080/meetingmanagement/user/activeUser?code=" + user.getCode() + "'>点击激活【神马会议】</a>";
            MailUtils.sendMail(user.getEmail(), emailText, "激活邮件");

            flag = true;
        } else {
            //注册失败
            System.out.println("注册失败");
            flag = false;
        }
        return flag;


    }

    @Override
    public boolean active(String code) {
        boolean flag = false;
        //根据激活码查询用户对象
        User user = userDao.findByCode(code);
        if (user != null) {
            //调用dao修改激活状态
            userDao.updataStates(user);
            flag=true;
        }
        return flag;
    }

    /**
     * 登录方法
     * @param user
     * @return
     */
    @Override
    public User login(User user) {
        return userDao.findByUsernameAndPassword(user.getUsername(),user.getPassword());
    }
}
