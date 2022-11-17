package com.watch.shopwatchonline.Repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.watch.shopwatchonline.Model.wishlist;

@Repository
public interface WishlistRepository extends JpaRepository<wishlist, Integer>{

    @Query(value = "SELECT * FROM wishlist JOIN Product on Product.Id = wishlist.product_id "+
    " WHERE product.name = ?1", nativeQuery = true)
    Page<wishlist> findByProductId(String keyword, Pageable pageable);

    @Query(value = "SELECT * FROM wishlist"+
    " WHERE wishlist.product_id = ?1 and wishlist.User_id = ?2", nativeQuery = true)
    List<wishlist> check(int pro,int users);

    @Query(value = "DELETE FROM wishlist WHERE wishlist.product_id = ?1 and wishlist.User_id = ?2", nativeQuery = true)
    void deleteByProAndUser(int pro,int users);
}
