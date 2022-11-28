package com.watch.shopwatchonline.Controller.Admin;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.watch.shopwatchonline.Domain.CategoryDto;
import com.watch.shopwatchonline.Model.Category;
import com.watch.shopwatchonline.Service.CategoryService;


@Controller
@RequestMapping("api/admin/categories")
public class CategoryController {

    @Autowired
	private CategoryService categoryService;
    
    @GetMapping("add-category")
    public String add(Model model) {
        CategoryDto dto = new CategoryDto();
        dto.setIsEdit(false);
        model.addAttribute("category", dto);
        return "web-admin/Addcategory";
    }

    @GetMapping("edit/{id}")
    public ModelAndView edit(ModelMap model, @PathVariable("id") Integer id) {

    	Optional<Category> opt = categoryService.findById(id);
        CategoryDto dto = new CategoryDto();

        if (opt.isPresent()) {
            Category entity = opt.get();

            BeanUtils.copyProperties(entity, dto);
            dto.setIsEdit(true);

            model.addAttribute("category", dto);

            return new ModelAndView("web-admin/Addcategory", model);
        }

        model.addAttribute("message", "Category is existed");

        return new ModelAndView("forward:/api/admin/categories", model);
    }

    @GetMapping("delete/{id}")
    public ModelAndView delete(ModelMap model, @PathVariable("id") Integer id) {

        Optional<Category> opt = categoryService.findById(id);
        categoryService.deleteById(id);

        model.addAttribute("message", "Category is delete!");

        return new ModelAndView("forward:/api/admin/categories", model);
    }

    @PostMapping("saveOrUpdate")
    public ModelAndView saveOrUpdate(ModelMap model, @Valid @ModelAttribute("category") CategoryDto dto,
            BindingResult result) {

        if(result.hasErrors()) {
            return new ModelAndView("web-admin/Addcategory");
        }
        Category entity = new Category();
        BeanUtils.copyProperties(dto, entity);

        categoryService.save(entity);

        model.addAttribute("message", "Category is saved!");

        return new ModelAndView("forward:/api/admin/categories", model);
    }

    @RequestMapping("")
    public String list(ModelMap model) {
        List<Category> list = categoryService.findAll();

        model.addAttribute("categorys", list);
        return "web-admin/listcategory";
    }

    @GetMapping("search")
    public String search() {
        return "web-admin/Addcategory";
    }
}
