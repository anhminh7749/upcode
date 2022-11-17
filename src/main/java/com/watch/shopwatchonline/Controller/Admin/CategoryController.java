package com.watch.shopwatchonline.Controller.Admin;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.javafaker.Faker;
import com.watch.shopwatchonline.Model.Category;
import com.watch.shopwatchonline.Model.Product;
import com.watch.shopwatchonline.Service.CategoryService;
import com.watch.shopwatchonline.Service.ProductService;

@Controller
@RequestMapping("admin/categories")
public class CategoryController {

    @Autowired
	private CategoryService CategoryService;
	// @Autowired
	// private ProductService ProductService;

    @GetMapping("/listshow")
    public String index() {
        return "web-admin/ListProduct";
    }
    @ModelAttribute("")
	public List<Category> getCategoryDtos(){
		return CategoryService.findAll();
	}
   
    @PostMapping("/store")
    public String store(ModelMap model) {

        return "web-admin/ListProduct";
    }
   
    @GetMapping("/create")
    public String create() {

        Faker fk = new Faker(new Locale("vi"));

        
            Category  cate = new Category();
            cate.setName("Men");
            
        

        return "web-admin/AddProduct";
    }

    @GetMapping("/showAdd")
    public String showAdd() {

        return "web-admin/AddProduct";
    }
   
    @PatchMapping("/update")
    public String update() {

        return "web-admin/ListProduct";
    }
   
    @DeleteMapping("/delete")
    public String destroy(int id) {

        return "web-admin/ListProduct";
    }
   
    @GetMapping("/edit/{id}")
    public String edit(ModelMap model,  @PathVariable("id") int Id) {

        return "web-admin/ListProduct";
    }
   
}
