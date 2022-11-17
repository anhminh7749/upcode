package com.watch.shopwatchonline.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.watch.shopwatchonline.Domain.UserDto;
import com.watch.shopwatchonline.Model.ChatBox;
import com.watch.shopwatchonline.Model.User;
import com.watch.shopwatchonline.Repository.ChatBoxRepository;
import com.watch.shopwatchonline.Repository.RaitingRepository;
import com.watch.shopwatchonline.Repository.UserRepository;
import com.watch.shopwatchonline.Service.StogareService;


@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
@RequestMapping("/api")
public class HomeController {

  @Autowired
  private StogareService StogareService;
  @Autowired
  private ChatBoxRepository boxRepository;
  @Autowired
  private UserRepository userRepository   ;
  

  @GetMapping("/login")
  public String allAccess() {
    return "web-admin/login";
  }
  @GetMapping("/site/login")
  public String all() {
    return "web-site/login";
  }

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
 
  @GetMapping("/ShoppingCart")
  public String ShoppingCart() {
    return "web-site/checkout";
  }
  @GetMapping("/register")
  public String Access() {
    return "web-admin/signup";
  }

  @GetMapping("/user")
  @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")

  public String userAccess() {
    return "User Content.";
  }

  @GetMapping("/mod")
  @PreAuthorize("hasRole('MODERATOR')")
  public String moderatorAccess() {
    return "Moderator Board.";
  }

  @GetMapping("images/{filename:.+}")
  @ResponseBody
  public ResponseEntity < Resource > serverFile(@PathVariable(name = "filename") String fileName) {
    Resource file = StogareService.loadResource(fileName);
    return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
  }
}