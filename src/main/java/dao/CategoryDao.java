package dao;

import domain.Category;

import java.util.List;

/**
 * 查询所有
 */
public interface CategoryDao {
    public List<Category> findAll();
    public List<Category> findByFlag(String flag);
}
