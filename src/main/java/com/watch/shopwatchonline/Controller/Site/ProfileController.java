package com.watch.shopwatchonline.Controller.Site;

import com.watch.shopwatchonline.Model.User;
import com.watch.shopwatchonline.Repository.UserRepository;
import com.watch.shopwatchonline.security.jwt.JwtUtils;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/profile")
@Slf4j
@RequiredArgsConstructor
public class ProfileController {
	private final UserRepository userRepository;
	private final JwtUtils jwtUtils;
	private final PasswordEncoder encoder;
	@GetMapping("/info")
    public String getInfo() {
      return "web-site/index";
    }
	
	@GetMapping("/change-password")
    public String openFormChangePassword(Model model) {
		model.addAttribute("abc", "adadaa");
      return "web-site/changepassword";
    }
	
	@PostMapping("/change-password")
    public String changePassword(
    		Model model,
    			@RequestParam(name = "currentPassword") String currentPassword,
    		   @RequestParam(name = "newPassword") String newPassword,
    		   @RequestParam(name = "confirmPassword") String confirmPassword,
    		   @CookieValue("shopwatch") String token
		   ) {
	log.info("Change password, request currentPassword: {}, newPassword: {}, confirmPassword: {}", currentPassword, newPassword, confirmPassword);
	model.addAttribute("tuandt", "Tuandt varrrr");
	String error = null;
	try {
		String username = jwtUtils.getUserNameFromJwtToken(token);
		User user = userRepository.findByUsername(username).orElse(null);
		if (!encoder.matches(currentPassword,  user.getPassword())) {
			error = "Mật khẩu hiện tại không đúng.";
		}
		if (!newPassword.equals(confirmPassword)) {
			error = "Mật khẩu xác nhận không trùng khớp.";
		}
		log.info("Change password error: {}", error);
		if (error == null) {
			user.setPassword(encoder.encode(newPassword));
			userRepository.save(user);
			log.info("Change password successfully");
			return "redirect:/"; 
		} else {
			log.info("Change password fail");
			model.addAttribute("error", error);
		}
	} catch (Exception e) {
		log.info("Change password exception");
		model.addAttribute("error", "Đổi mật khẩu không thành công!");
	}
	return "web-site/changepassword";
    }
}
