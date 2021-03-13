package service.impl;

import dao.CompanyDao;
import dao.impl.CompanyDaoImpl;
import domain.Company;
import service.CompanyService;
import util.MailUtils;
import util.UuidUtil;

public class CompanyServiceImpl implements CompanyService {
    private CompanyDao companyDao = new CompanyDaoImpl();

    /**
     * 注册用户
     *
     * @param company
     * @return
     */
    @Override
    public boolean regist(Company company) {
        Company findcompany = companyDao.findByCompanyname(company.getCompanyname());
        boolean flag = false;
        if (findcompany == null) {
            System.out.println("注册成功");
            //设置唯一激活码
            company.setCode(UuidUtil.getUuid());
            company.setStatus("N");
            //保存用户信息
            companyDao.save(company);
            //发送激活邮件
            String emailText = "<a href='http://localhost:8080/meetingmanagement/company/activeCompany?code=" + company.getCode() + "'>点击激活【神马会议】</a>";
            MailUtils.sendMail(company.getEmail(), emailText, "激活邮件");

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
        Company company = companyDao.findByCode(code);
        if (company != null) {
            //调用dao修改激活状态
            companyDao.updataStates(company);
            flag = true;
        }
        return flag;
    }

    /**
     * 登录方法
     *
     * @param company
     * @return
     */
    @Override
    public Company login(Company company) {
        return companyDao.findByCompanynameAndPassword(company.getCompanyname(), company.getPassword());
    }
}
