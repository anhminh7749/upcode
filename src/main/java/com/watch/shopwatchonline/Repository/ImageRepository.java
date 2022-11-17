package com.watch.shopwatchonline.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.watch.shopwatchonline.Model.Image;



@Repository
public interface ImageRepository extends JpaRepository<Image, Integer>{

    @Query(value = "SELECT i.* FROM image i INNER JOIN product_images pi ON pi.image_id = i.id WHERE pi.product_id= :pid", nativeQuery = true)
    public List<Image> findImageByProductId(@Param("pid") int productId);
    @Query(value = "SELECT i.* FROM image i INNER JOIN blog_images bi ON bi.image_id = i.id WHERE bi.blog_id= :bid", nativeQuery = true)
    public List<Image> findImageByBlogId(@Param("bid") int blogId);
}
