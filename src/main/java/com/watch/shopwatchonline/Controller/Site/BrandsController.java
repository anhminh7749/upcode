package com.watch.shopwatchonline.Controller.Site;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("site/brands")
public class BrandsController {

	@GetMapping("")
	public String form() {
		
		return "web-site/brands";
	}
}
