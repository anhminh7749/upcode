package com.watch.shopwatchonline.Controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.watch.shopwatchonline.Domain.AddressDto;
import com.watch.shopwatchonline.Model.Address;
import com.watch.shopwatchonline.Model.User;
import com.watch.shopwatchonline.Repository.AddressRepository;
import com.watch.shopwatchonline.Repository.DiscountCodeRepository;
import com.watch.shopwatchonline.Repository.OrderDetailRepository;
import com.watch.shopwatchonline.Repository.OrderRepository;
import com.watch.shopwatchonline.Repository.ProductRepository;
import com.watch.shopwatchonline.Repository.UserRepository;
import com.watch.shopwatchonline.security.jwt.JwtUtils;

public class AddressController {
	 @Autowired
	  private UserRepository userRepository   ;
	 @Autowired
	  private DiscountCodeRepository discountCodeRepository;
	  @Autowired
	  private AddressRepository addressRepository;
	  @Autowired
	  private JwtUtils utils;


	  @Autowired
	  private OrderRepository orderRepository;

	  @Autowired
	  private OrderDetailRepository detailRepository;
	  @Autowired
	  private ProductRepository productRepository;
	  
	  @GetMapping("/address")
	  public String view() {
	    return "web-site/address";
	  }
	  
	  @PostMapping("/address/up")

	  public String update(ModelMap model, @ModelAttribute("address") AddressDto dto, HttpServletRequest request) {

	    Address address = new Address();
	    BeanUtils.copyProperties(dto, address);
	    Optional<User> user = userRepository.findByUsername(utils.getUser(request));
	    address.setUsers(user.get());

	    if (dto.getStatus().intValue() == 1) {
	      Address add = addressRepository.findByStatus((short) 1);
	      if (add != null) {
	        add.setStatus((short) 0);
	        addressRepository.save(add);
	      }
	    }
	    addressRepository.save(address);
	    System.out.println("------------------------------------------------");
	    String rr = "redirect:" + dto.getRedirect();
	    return rr;
	  }

}
