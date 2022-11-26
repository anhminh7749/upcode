package com.watch.shopwatchonline.Repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.watch.shopwatchonline.Model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer>{
 Address findByStatus(Short status);



 @Query(value  = "select * FROM address where address.user_id = ?1",nativeQuery = true)
 List<Address> findbyuser(int id);
}