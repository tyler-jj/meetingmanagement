package dao.impl;

import dao.CompanyDao;
import domain.Company;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JdbcDruidUtils;


public class CompanyDaoImpl implements CompanyDao {

    private JdbcTemplate template = new JdbcTemplate(JdbcDruidUtils.getDatasource());

    @Override
    public Company findByCompanyname(String companyname) {
        Company company = null;
        try {
            //定义sql语句
            String sql = "select * from tab_company where companyname = ?";
            //执行sql
            company = template.queryForObject(sql, new BeanPropertyRowMapper<Company>(Company.class), companyname);
            System.out.println(company);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return company;
    }

    @Override
    public void save(Company company) {
        String sql = "insert into tab_company(companyname,password,email,telephone,status,code)"
                + "values(?,?,?,?,?,?)";
        template.update(sql, company.getCompanyname(),
                company.getPassword(),
                company.getEmail(),
                company.getTelephone(),
                company.getStatus(),
                company.getCode());
    }

    @Override
    public Company findByCode(String code) {
        Company company = null;
        try {
            String sql = "select * from tab_company where code = ?";
            company = template.queryForObject(sql, new BeanPropertyRowMapper<Company>(Company.class), code);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return company;
    }

    @Override
    public void updataStates(Company company) {
        String sql = "update tab_company set status='Y' where uid = ?";
        template.update(sql, company.getUid());
    }

    @Override
    public Company findByCompanynameAndPassword(String companyname, String password) {
        Company company = null;
        try {
            String sql = "select * from tab_company where companyname = ? and password = ?";
            company = template.queryForObject(sql, new BeanPropertyRowMapper<Company>(Company.class), companyname, password);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        System.out.println(company);
        return company;
    }


}

