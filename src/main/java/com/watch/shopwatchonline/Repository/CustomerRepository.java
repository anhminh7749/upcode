package com.watch.shopwatchonline.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.watch.shopwatchonline.Model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
