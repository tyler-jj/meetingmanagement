package dao;

import domain.Company;
import domain.User;

public interface CompanyDao {
    /**
     * 根据公司名查询用户信息
     * @param companyname
     * @return
     */
    public Company findByCompanyname(String companyname);

    /**
     * 用户保存
     */
    public void save(Company company);


    Company findByCode(String code);

    void updataStates(Company company);

    Company findByCompanynameAndPassword(String companyname, String password);
}
