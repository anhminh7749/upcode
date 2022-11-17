package com.watch.shopwatchonline.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.watch.shopwatchonline.Model.Raiting;

public interface RaitingRepository extends JpaRepository<Raiting, Integer>{
    @Query(value = "SELECT * FROM Raiting  where Raiting.product_Id = :pid", nativeQuery = true)
    List<Raiting> findByProductId(@Param("pid") int id_pro);
   

    @Query(value = " SELECT AVG(point) FROM Raiting  where Raiting.product_Id = :pid", nativeQuery = true)
    String AvgByProductId(@Param("pid") int id_pro);

    @Query(value = "SELECT * FROM Raiting  "+
   "join users u on u.id = Raiting.user_id "+ 
     "join product p on p.id =  Raiting.product_id "+ 
    "where (u.username like %:kw% or p.name like %:kw% ) and Raiting.active = :act", nativeQuery = true)
    Page<Raiting> findByKeyWord(@Param("kw") String keyword, @Param("act") Short active, Pageable pageable);

    Page<Raiting> findByActive(Short active, Pageable pageable);
   
}
