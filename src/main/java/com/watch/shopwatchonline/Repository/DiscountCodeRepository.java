package com.watch.shopwatchonline.Repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.watch.shopwatchonline.Model.DiscountCode;

@Repository
public interface DiscountCodeRepository extends JpaRepository<DiscountCode, Integer>{

    Page<DiscountCode> findByNameContaining(String keyword, Pageable pageable);


}
