package dao.impl;

import dao.CategoryDao;
import domain.Category;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JdbcDruidUtils;

import java.util.List;

public class CategoryDaoImpl implements CategoryDao {
    private JdbcTemplate template = new JdbcTemplate(JdbcDruidUtils.getDatasource());

    @Override
    public List<Category> findAll() {
        String sql = "select * from tab_category";
        return template.query(sql, new BeanPropertyRowMapper<Category>(Category.class));
    }

    @Override
    public List<Category> findByFlag(String flag) {
        String sql = "select * from tab_category where flag = ?";
        System.out.println(flag);
        System.out.println(template.query(sql, new BeanPropertyRowMapper<Category>(Category.class),flag));
        return template.query(sql, new BeanPropertyRowMapper<Category>(Category.class),flag);
    }
}
