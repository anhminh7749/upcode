package com.watch.shopwatchonline.Controller.Admin;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.watch.shopwatchonline.Domain.BrandDto;
import com.watch.shopwatchonline.Model.Brand;
import com.watch.shopwatchonline.Service.BrandService;
import com.watch.shopwatchonline.Service.StogareService;

@Controller
@RequestMapping("admin/brands")
public class BrandController {

	@Autowired
	private BrandService brandService;

//	@Autowired
//	private StogareService stogareService;

	@GetMapping("add-brand")
	public String add(Model model) {
		BrandDto dto = new BrandDto();
		dto.setIsEdit(false);
		model.addAttribute("brand", dto);
		return "web-admin/Addbrand";
	}

	@GetMapping("edit/{id}")
	public ModelAndView edit(ModelMap model, @PathVariable("id") Integer id) {

		Optional<Brand> opt = brandService.findById(id);
		BrandDto dto = new BrandDto();

		if (opt.isPresent()) {
			Brand entity = opt.get();

			BeanUtils.copyProperties(entity, dto);
			dto.setIsEdit(true);

			model.addAttribute("brand", dto);

			return new ModelAndView("web-admin/Addbrand", model);
		}

		model.addAttribute("message", "Brand is existed");

		return new ModelAndView("forward:/admin/brands", model);
	}
//
//	@GetMapping("images/{filename:.+}")
//	@ResponseBody
//	public ResponseEntity<Resource> serverFile(@PathVariable(name = "filename") String fileName) {
//
//		Resource file = stogareService.loadResource(fileName);
//		return ResponseEntity.ok()
//				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
//				.body(file);
//	}

	@GetMapping("delete/{id}")
	public ModelAndView delete(ModelMap model, @PathVariable("id") Integer id) {

		Optional<Brand> opt = brandService.findById(id);
		brandService.deleteById(id);

		model.addAttribute("message", "Brand is delete!");

		return new ModelAndView("forward:/admin/brands", model);
	}

	@PostMapping("saveOrUpdate")
	public ModelAndView saveOrUpdate(ModelMap model, @Valid @ModelAttribute("brand") BrandDto dto,
			BindingResult result) {

		if (result.hasErrors()) {
			return new ModelAndView("web-admin/Addbrand");
		}
		Brand entity = new Brand();
		BeanUtils.copyProperties(dto, entity);

		brandService.save(entity);

		model.addAttribute("message", "Brand is saved!");

		return new ModelAndView("forward:/admin/brands", model);
	}

	@RequestMapping("")
	public String list(ModelMap model) {
		List<Brand> list = brandService.findAll();

		model.addAttribute("brands", list);
		return "web-admin/listbrand";
	}

	@GetMapping("search")
	public String search() {
		return "web-admin/Addbrands";
	}
}
