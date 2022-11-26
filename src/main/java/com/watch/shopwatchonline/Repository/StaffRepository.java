package com.watch.shopwatchonline.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.watch.shopwatchonline.Model.Staff;
@Repository
public interface StaffRepository extends JpaRepository<Staff, Integer>{

}
