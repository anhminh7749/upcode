package com.watch.shopwatchonline.Controller;

import java.util.HashMap;
import java.util.Map;

import com.watch.shopwatchonline.Domain.MailRequest;
import com.watch.shopwatchonline.Domain.UserDto;
import com.watch.shopwatchonline.Model.User;
import com.watch.shopwatchonline.Repository.UserRepository;
import com.watch.shopwatchonline.Service.MailService;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/")
@Slf4j
@RequiredArgsConstructor
public class TrangChuController {
	private final MailService mailService;
	private final UserRepository userRepository;
	private final PasswordEncoder encoder;
	
	@GetMapping("")
	public String allAccess() {
		return "web-site/trang-chu";
	}
	
	@GetMapping("/forgot-password")
	public String openFormForgotPassword() {
		return "web-site/forgotpassword";
	}
	
	@PostMapping("/forgot-password")
	public String openFormForgotPassword(@RequestParam(name = "username") String username) {
		log.info("Username: {}", username);
		User user = userRepository.findByUsername(username).orElse(null);
		if (user != null) {
			Map<String, String> params = new HashMap<>();
			String newPassword = RandomStringUtils.randomAlphabetic(10);
			log.info("Mat khau moi: {}", newPassword);
			params.put("password", newPassword);
			user.setPassword(encoder.encode(newPassword));
			userRepository.save(user);
			log.info("Luu mat khau moi cua user");
			mailService.send(MailRequest.builder()
					.to(user.getEmail())
					.subject("Thông báo lấy lại mật khẩu")
					.body("Mật khẩu mới của bạn là: [({$password})]")
					.params(params)
					.build());
			log.info("Gui email thanh cong");
			return "redirect:/api/auth/site/login";
		}
		return "redirect:/forgot-password";
	}
}
