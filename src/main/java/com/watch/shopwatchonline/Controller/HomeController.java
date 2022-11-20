package com.watch.shopwatchonline.Controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
@RequestMapping("/api/auth")
public class HomeController {
    @GetMapping("/login")
    public String allAccess() {
      return "web-admin/login";
    }
    @GetMapping("/site/login")
    public String all() {
      return "web-site/login";
    }

    @GetMapping("/register")
    public String Access() {
      return "web-admin/signup";
    }
    
    @GetMapping("/site/register")
    public String siteRegister() {
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
}
