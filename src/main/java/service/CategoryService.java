package service;

import domain.Category;

import java.util.List;

public interface CategoryService {
    public List<Category> findAll();
    public List<Category> findByFlag(String flag);
}
