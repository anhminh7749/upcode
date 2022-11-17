package com.watch.shopwatchonline.Controller;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.watch.shopwatchonline.Domain.ProductDto;
import com.watch.shopwatchonline.Domain.UserDto;
import com.watch.shopwatchonline.Model.Erole;
import com.watch.shopwatchonline.Model.Role;
import com.watch.shopwatchonline.Model.User;
import com.watch.shopwatchonline.Repository.RoleRepository;
import com.watch.shopwatchonline.Repository.UserRepository;
import com.watch.shopwatchonline.message.MessageResponse;
import com.watch.shopwatchonline.security.Request.LoginRequest;
import com.watch.shopwatchonline.security.Request.SignupRequest;
import com.watch.shopwatchonline.security.Response.UserInfoResponse;
import com.watch.shopwatchonline.security.jwt.JwtUtils;


@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
@RequestMapping("/api/auth")
public class AuthController {
  @Autowired
  AuthenticationManager authenticationManager;

  @Autowired
  UserRepository userRepository;

  @Autowired
  RoleRepository roleRepository;

  @Autowired
  PasswordEncoder encoder;

  @Autowired
  JwtUtils jwtUtils;

  private String linkApi;

  // @PostMapping(value="/signin")
  // public String authenticateUser( @RequestParam(name = "username") String username,
  //  @RequestParam(name = "password") String password ) {

  //   Authentication authentication = authenticationManager
  //       .authenticate(new UsernamePasswordAuthenticationToken(username, password));

  //   SecurityContextHolder.getContext().setAuthentication(authentication);

  //   UserDto userDetails = (UserDto) authentication.getPrincipal();

  //   ResponseCookie jwtCookie = jwtUtils.generateJwtCookie(userDetails);

  //   List<String> roles = userDetails.getAuthorities().stream()
  //       .map(item -> item.getAuthority())
  //       .collect(Collectors.toList());
        
  //       ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, jwtCookie.toString()).body(new UserInfoResponse(userDetails.getId(),
  //       userDetails.getUsername(),
  //       userDetails.getEmail(),
  //       userDetails.getGender(),
  //       userDetails.getPhone(),
  //       roles));
     
  //   return "redirect:/admin/product/add-product";
  // }


  @PostMapping(value="/signin")
  public ResponseEntity<?> authenticateUser( @RequestParam(name = "username") String username,
   @RequestParam(name = "password") String password ) {

    Authentication authentication = authenticationManager
        .authenticate(new UsernamePasswordAuthenticationToken(username, password));

    SecurityContextHolder.getContext().setAuthentication(authentication);

    UserDto userDetails = (UserDto) authentication.getPrincipal();
    
    ResponseCookie jwtCookie = jwtUtils.generateJwtCookie(userDetails);
    
    // List<String> roles = userDetails.getAuthorities().stream()
    //     .map(item -> item.getAuthority())
    //     .collect(Collectors.toList());

    //     roles.forEach(role -> {
    //       if(role.equals("admin")){linkApi = "redirect:/api/admin/product/add-product";}else{
    //         linkApi = "redirect:/api/site/product";
    //       }
    //     });
        
        // return "redirect:/api/admin/product/add-product";

        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, jwtCookie.toString()).body(new MessageResponse("okkk"));
               
       
  }

  @PostMapping(value="/signup")
  public String registerUser(  @Validated @ModelAttribute("signUpRequest") SignupRequest signUpRequest) {
   
    if (userRepository.existsByUsername(signUpRequest.getUsername())) {
      ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
      return "forward:/signup";
    }

    if (userRepository.existsByEmail(signUpRequest.getEmail())) {
      ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
      return "forward:/signup";
    }
   
    // Create new user's account
    User user = new User(signUpRequest.getUsername(),
                         signUpRequest.getEmail(),
                         encoder.encode(signUpRequest.getPassword()),
                         signUpRequest.getGender(),
                         signUpRequest.getPhone());

    Set<String> strRoles = signUpRequest.getRole();
    Set<Role> roles = new HashSet<>();
   
    if (strRoles == null) {
      Role userRole = roleRepository.findByName(Erole.ROLE_USER)
          .orElseThrow(() -> new RuntimeException("Error: Role is null."));
      roles.add(userRole);
    } else {
      strRoles.forEach(role -> {
    //     System.out.println("----------------------------");
    // System.out.println(role);
        switch (role) {
        case "admin":
          Role adminRole = roleRepository.findByName(Erole.ROLE_ADMIN)
              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
          roles.add(adminRole);

          break;
        case "mod":
          Role modRole = roleRepository.findByName(Erole.ROLE_MODERATOR)
              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
          roles.add(modRole);

          break;
        default:
          Role userRole = roleRepository.findByName(Erole.ROLE_USER)
              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
          roles.add(userRole);
        }
      });
    }

    user.setRoles(roles);
    userRepository.save(user);
    ResponseEntity.ok(new MessageResponse("User registered successfully!" ));
    return "redirect:/api/login";
  }

  @PostMapping("/signout")
  public ResponseEntity<?> logoutUser() {
    ResponseCookie cookie = jwtUtils.getCleanJwtCookie();
    return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString())
        .body(new MessageResponse("You've been signed out!"));
  }
  
}