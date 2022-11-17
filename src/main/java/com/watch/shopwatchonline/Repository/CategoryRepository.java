package com.watch.shopwatchonline.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.watch.shopwatchonline.Model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{
    
}
