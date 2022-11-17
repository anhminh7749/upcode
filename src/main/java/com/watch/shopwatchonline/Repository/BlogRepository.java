package com.watch.shopwatchonline.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.watch.shopwatchonline.Model.Blog;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Integer>{


//     @Query(value = "SELECT p FROM Product p "+
//    "join Brand b on b.id =  p.Brand.id "+ 
//      "join Category c on c.id =  p.Category.id "+ 
//     "where p.name like %:kw% or p.id like %:kw% or c.name like %:kw% or b.name like %:kw%")
//     Page<Product> findByNameContaining(@Param("kw") String keyword, Pageable pageable);

// @Query(value = "select p.* from product p where p.brand_id = ?1 and p.category_id = ?2 and p.price between ?3 and ?4 ;", nativeQuery = true)
// Page<Product> findByAll(int id_brand, int id_cate, float min, float max, Pageable pageable);

// @Query(value = "select p.* from product p where  p.category_id = ?1 and p.price between ?2 and ?3 ;", nativeQuery = true)
// Page<Product> findByAllNotBrand( int id_cate, float min, float max, Pageable pageable);

// @Query(value = "select p.* from product p where p.brand_id = ?1 p.price between ?2 and ?3 ;", nativeQuery = true)
// Page<Product> findByAllNotCate(int id_brand, float min, float max, Pageable pageable);

// @Query(value = "select p.* from product p where p.brand_id = ?1 and p.category_id = ?2;", nativeQuery = true)
// Page<Product> findByAllNotPrice(int id_brand, int id_cate, Pageable pageable);

// Page<Product> findByPriceBetween(double min, double max, Pageable pageable);

// @Query(value = "SELECT p FROM Product p where p.category_id = :cid", nativeQuery = true)
// Page<Product> findByCategory(@Param("cid") int id_cate, Pageable pageable);

// @Query(value = "SELECT p FROM Product p where p.brand_id = :bid", nativeQuery = true)
// Page<Product> findByBrand(@Param("bid") int id_brand, Pageable pageable);

// @Query(value = "select p.* from product p"+
// " where p.brand_id = :b and p.category_id = :c and p.price between :min and :max "+
// " or p.category_id = :c and p.price between :min and :max "+
// " or p.brand_id = :b and p.price between :min and :max "+
// " or p.brand_id = :b and p.category_id = :c " +
// " or p.brand_id = :b "+
// " or p.category_id = :c "+ 
// " or p.price between :min and :max ", nativeQuery = true)
// Page<Product> findByAllOrWhere(@Param("b") String id_cate, @Param("c") String id_brand, @Param("min") float min, @Param("max")  float max, Pageable pageable);
}
