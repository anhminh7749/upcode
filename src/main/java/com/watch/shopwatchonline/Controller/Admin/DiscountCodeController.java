package com.watch.shopwatchonline.Controller.Admin;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.watch.shopwatchonline.Domain.DiscountCodeDto;
import com.watch.shopwatchonline.Model.DiscountCode;
import com.watch.shopwatchonline.Repository.DiscountCodeRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
@RequestMapping("api/admin/DiscountCode")
public class DiscountCodeController {
    
@Autowired
private DiscountCodeRepository codeRepository;

@GetMapping("")
public String index(Model model){
   
    DiscountCodeDto dto = new DiscountCodeDto();
        dto.setIsEdit(false);
        model.addAttribute("code", dto);
    return "web-admin/AddDiscountCode";
}
@GetMapping("list-code")
public ModelAndView indexL(ModelMap model, @RequestParam(name = "keyword", required = false) String keyword,
@RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size) {

    int curPage = page.orElse(1);
    int pageSize = size.orElse(5);

  
    Page<DiscountCode> resultPage = null;
   
    if (StringUtils.hasText(keyword)) {
        Pageable pageable = PageRequest.of(curPage - 1, pageSize);
        resultPage = codeRepository.findByNameContaining(keyword, pageable);
        model.addAttribute("keyword", keyword);
    } else {
        Pageable pageable = PageRequest.of(curPage - 1, pageSize);
        resultPage = codeRepository.findAll(pageable);
        
    }

    int totalPages = resultPage.getTotalPages();

    if (totalPages > 0) {
        int start = Math.max(1, curPage - 2);
        int end = Math.min(curPage + 2, totalPages);

        if (totalPages > 5) {
            if (end == totalPages){
                start = end - 5;
            }else{
                if (start == 1){
                    end = start + 5;
                }
            }
        }

        List<Integer> pageNums = IntStream.rangeClosed(start, end).boxed().collect(Collectors.toList());
        model.addAttribute("pageNums", pageNums);
    
    }

    List<DiscountCode> p = codeRepository.findAll();


    model.addAttribute("keyword", keyword);
    model.addAttribute("codePage", resultPage);
    model.addAttribute("tt", p.size());
    return new ModelAndView("web-admin/ListDiscountCode", model);
}


@PostMapping("/update")
public String update(ModelMap model, @Validated @ModelAttribute("code") DiscountCodeDto dto, BindingResult result)
throws ParseException {
if (result.hasErrors()) {
return "";
}
DiscountCode code = new DiscountCode();
    BeanUtils.copyProperties(dto, code);
   
    codeRepository.save(code);   
    return "redirect:/api/admin/DiscountCode/list-code";
}


@GetMapping("edit/{Id}")
	public ModelAndView edit(ModelMap map, @PathVariable("Id") Integer Id) {

		Optional<DiscountCode> opt = codeRepository.findById(Id);
      
		DiscountCodeDto dto = new DiscountCodeDto();

		if (opt.isPresent()) {
			DiscountCode entity = opt.get();
			BeanUtils.copyProperties(entity, dto);
			dto.setIsEdit(true);
           
			map.addAttribute("code", dto);
			return new ModelAndView("web-admin/AddDiscountCode", map);
		}

            return new ModelAndView("web-admin/ListDiscountCode");
            }

            
            @GetMapping("delete/{Id}")
            public String delete(ModelMap map, @PathVariable("Id") Integer id) {
                codeRepository.deleteById(id);

            return "redirect:/api/admin/DiscountCode/list-code";
            }
}
