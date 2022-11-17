package com.watch.shopwatchonline.Controller.Admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.watch.shopwatchonline.Model.ChatBox;
import com.watch.shopwatchonline.Repository.ChatBoxRepository;


@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
@RequestMapping("api/admin/")
public class ChatBoxController {
    
    @Autowired
    private ChatBoxRepository boxRepository;

    

    @GetMapping("/chatbox")
  public String chatbox(Model model, HttpServletRequest request) {
    try {
 
      List < ChatBox > list = boxRepository.findAll();
      model.addAttribute("listChatBox", list);
    } catch (Exception e) {
      System.out.println(e);
    }

    return "web-admin/compose";
  }


}
