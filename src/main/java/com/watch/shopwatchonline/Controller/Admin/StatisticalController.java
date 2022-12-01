package com.watch.shopwatchonline.Controller.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("api/admin/statistical")
public class StatisticalController {

@GetMapping("")
public String form() {
	return "web-admin/statistical";
}

}
