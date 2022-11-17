package com.watch.shopwatchonline.Controller.Admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.expression.ParseException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.watch.shopwatchonline.Domain.ListImageDto;
import com.watch.shopwatchonline.Domain.ProductDto;
import com.watch.shopwatchonline.Domain.blogDto;
import com.watch.shopwatchonline.Model.Blog;
import com.watch.shopwatchonline.Model.Brand;
import com.watch.shopwatchonline.Model.Category;
import com.watch.shopwatchonline.Model.Image;
import com.watch.shopwatchonline.Model.Product;
import com.watch.shopwatchonline.Service.CategoryService;
import com.watch.shopwatchonline.Service.ProductService;
import com.watch.shopwatchonline.Service.StogareService;
import com.watch.shopwatchonline.message.MessageResponse;

import javassist.runtime.Desc;

import com.watch.shopwatchonline.Service.BlogService;
import com.watch.shopwatchonline.Service.BrandService;

@Controller
@RequestMapping("admin/blog")
public class BlogController {

    @Autowired
private BlogService blogService;

@Autowired
private ProductService ProductService;

@Autowired
private StogareService stogareService;


@GetMapping("add-blog")
public String indexA(Model model) {
    blogDto dto = new blogDto();
    dto.setIsEdit(false);
    model.addAttribute("blog", dto);
return "web-admin/AddBlog";
}

@ModelAttribute("products")
public List<Product> getProductDtos(){
    return ProductService.findAll();
    }

@GetMapping("list-blog")
public ModelAndView indexL(ModelMap model, @RequestParam(name = "keyword", required = false) String keyword,
@RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size) {

    int curPage = page.orElse(1);
    int pageSize = size.orElse(5);

  
    Page<Blog> resultPage = null;
   
    if (StringUtils.hasText(keyword)) {
        Pageable pageable = PageRequest.of(curPage - 1, pageSize);
        // resultPage = ProductService.findByNameContaining(keyword, pageable);
        model.addAttribute("keyword", keyword);
    } else {
        Pageable pageable = PageRequest.of(curPage - 1, pageSize);
        resultPage = blogService.findAll(pageable);
        
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

    List<Blog> p = blogService.findAll();


    model.addAttribute("keyword", keyword);
    model.addAttribute("blogPage", resultPage);
    model.addAttribute("tt", p.size());
    return new ModelAndView("web-admin/ListBlog", model);
}



        @PostMapping(value = "update", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE })
        public ModelAndView update(ModelMap model, 
        @Validated @ModelAttribute("blog") blogDto dto,
        @RequestParam("listImageFile") MultipartFile[] file ,BindingResult result)
        throws ParseException {

        if (result.hasErrors()) {
       
        return new ModelAndView("admin/blog/AddBlog");
        }
        if(!dto.getIsEdit().booleanValue()) {
       dto.setCreateAt(new Date());
        }else {
            Optional<Blog> s = blogService.findById( dto.getId());           
		    Date pdto = s.get().getCreateAt();
             dto.setCreateAt(pdto);
        }
        
        
           Blog bl = new Blog();
            BeanUtils.copyProperties(dto, bl);

            Product pro = new Product();
            pro.setId(dto.getProductId());
            bl.setProduct(pro);


           bl.setUpdateAt(new Date());
            bl.setBanner(stogareService.getFileName(dto.getImageFile()));
            stogareService.store(dto.getImageFile(), bl.getBanner());
            

            try {       
           
                Set<Image> images = uploadImage(file);
                bl.setBlogImages(images);
                
            } catch (Exception e) {
                System.out.println(e);

            }

            blogService.save(bl);



            return new ModelAndView("redirect:/admin/blog/list-blog");
            }


            public Set<Image> uploadImage(MultipartFile[] multipartFiles) throws IOException{
                Set<Image> images = new HashSet<>();

                for(MultipartFile file:multipartFiles){
                    Image img = new Image(
                        stogareService.getFileName(file),
                        file.getContentType(),
                        file.getBytes());
                        stogareService.store(file,  img.getName());
                       images.add(img);

                       
                }

             return images;
            }



            @GetMapping("images/{filename:.+}")
            @ResponseBody
            public ResponseEntity<Resource> serverFile(@PathVariable(name = "filename") String fileName) {
        
                Resource file = stogareService.loadResource(fileName);
                return ResponseEntity.ok()
                        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                        .body(file);
            }

            @GetMapping("delete/{Id}")
            public String delete(ModelMap map, @PathVariable("Id") Integer id) {
            blogService.deleteById(id);

            return "redirect:/admin/blog/list-blog";
            }

    @GetMapping("edit/{Id}")
	public ModelAndView edit(ModelMap map, @PathVariable("Id") Integer Id) {

		Optional<Blog> opt = blogService.findById(Id);
        List<Image> images = stogareService.findImageByBlogId(Id);
		blogDto dto = new blogDto();

		if (opt.isPresent()) {
			Blog entity = opt.get();
			BeanUtils.copyProperties(entity, dto);
			dto.setIsEdit(true);
            map.addAttribute("pushImage", images);
			map.addAttribute("blog", dto);
			return new ModelAndView("web-admin/AddBlog", map);
		}

            return new ModelAndView("web-admin/AddBlog");
            }


            }