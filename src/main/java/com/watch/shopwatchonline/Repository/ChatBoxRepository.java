package com.watch.shopwatchonline.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.watch.shopwatchonline.Model.ChatBox;

@Repository
public interface ChatBoxRepository extends JpaRepository<ChatBox, Integer>{
    ChatBox findByUsername(String username);
}
