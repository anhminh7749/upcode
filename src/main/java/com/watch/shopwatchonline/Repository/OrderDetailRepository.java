package com.watch.shopwatchonline.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.watch.shopwatchonline.Model.OrderDetail;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {

    @Query(value = "SELECT * FROM order_detail WHERE order_detail.order_id = :oid",nativeQuery = true)
    List<OrderDetail> FindByOrder(@Param("oid") int orderId);
}