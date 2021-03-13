package service;

import domain.Company;

public interface CompanyService {
    /**
     * 注册企业
     * @param company
     * @return
     */
    boolean regist(Company company);

    /**
     * 激活企业
     * @param code
     * @return
     */
    boolean active(String code);

    /**
     * 登录
     * @param company
     * @return
     */
    Company login(Company company);
}
