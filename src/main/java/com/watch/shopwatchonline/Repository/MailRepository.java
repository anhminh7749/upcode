package com.watch.shopwatchonline.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.watch.shopwatchonline.Model.Customer;
import com.watch.shopwatchonline.Model.Mail;

@Repository
public interface MailRepository extends JpaRepository<Mail, Integer>{

}
