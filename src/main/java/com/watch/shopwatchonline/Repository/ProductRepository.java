package com.watch.shopwatchonline.Repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.watch.shopwatchonline.Model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

  @Query(value = "select p.* from product p join wishlist w on w.product_id = p.id join users u on u.id = w.user_id where u.username = ?1", nativeQuery= true)
  Page<Product> findByUserName(String username, Pageable pageable);

    @Query(value = "SELECT p FROM Product p "+
   "join Brand b on b.id =  p.Brand.id "+ 
     "join Category c on c.id =  p.Category.id "+ 
    "where p.name like %:kw% or p.id like %:kw% or c.name like %:kw% or b.name like %:kw%")
    Page<Product> findByNameContaining(@Param("kw") String keyword, Pageable pageable);

@Query(value = "select * from product where product.brand_id = :bid and product.category_id = :cid and product.price between :min and :max ", nativeQuery = true)
Page<Product> findByAll(@Param("bid") int id_brand, @Param("cid") int id_cate, @Param("min") float min,@Param("max") float max, Pageable pageable);

@Query(value = "select * from product where product.category_id = :cid and product.price between :min and :max ", nativeQuery = true)
Page<Product> findByAllNotBrand(@Param("cid") int id_cate, @Param("min") float min,@Param("max") float max, Pageable pageable);

@Query(value = "select * from product where product.brand_id = :bid and product.price between :min and :max", nativeQuery = true)
Page<Product> findByAllNotCate(@Param("bid") int id_brand, @Param("min") float min,@Param("max") float max, Pageable pageable);

@Query(value = "SELECT * FROM Product where Product.brand_id = :bid and Product.category_Id = :cid", nativeQuery = true)
Page<Product> findByAllNotPrice( @Param("bid") int id_brand, @Param("cid") int id_cate, Pageable pageable);

Page<Product> findByPriceBetween(float min, float max, Pageable pageable);

@Query(value = "SELECT * FROM Product  where Product.category_Id = :cid", nativeQuery = true)
Page<Product> findByCategory(@Param("cid") int id_cate, Pageable pageable);

@Query(value = "SELECT * FROM Product where Product.brand_id = :bid", nativeQuery = true)
Page<Product> findByBrand(@Param("bid") int id_brand, Pageable pageable);

@Query(value = "select p.* from product p"+
" where p.brand_id = :b and p.category_id = :c and p.price between :min and :max "+
" or p.category_id = :c and p.price between :min and :max "+
" or p.brand_id = :b and p.price between :min and :max "+
" or p.brand_id = :b and p.category_id = :c " +
" or p.brand_id = :b "+
" or p.category_id = :c "+ 
" or p.price between :min and :max ", nativeQuery = true)
Page<Product> findByAllOrWhere(@Param("b") String id_cate, @Param("c") String id_brand, @Param("min") float min, @Param("max")  float max, Pageable pageable);


}
