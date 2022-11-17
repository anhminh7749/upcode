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

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.expression.ParseException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
import org.springframework.web.servlet.resource.HttpResource;

import com.watch.shopwatchonline.Domain.ListImageDto;
import com.watch.shopwatchonline.Domain.ProductDto;
import com.watch.shopwatchonline.Model.Brand;
import com.watch.shopwatchonline.Model.Category;
import com.watch.shopwatchonline.Model.Image;
import com.watch.shopwatchonline.Model.Product;
import com.watch.shopwatchonline.Service.CategoryService;
import com.watch.shopwatchonline.Service.ProductService;
import com.watch.shopwatchonline.Service.StogareService;
import com.watch.shopwatchonline.message.MessageResponse;
import com.watch.shopwatchonline.security.Response.UserInfoResponse;
import com.watch.shopwatchonline.security.jwt.AuthTokenFilter;
import com.watch.shopwatchonline.security.jwt.JwtUtils;

import javassist.runtime.Desc;

import com.watch.shopwatchonline.Service.BrandService;
@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
@RequestMapping("api/admin/product")
public class ProductController {

@Autowired
private CategoryService CategoryService;

@Autowired
private BrandService BrandService;

@Autowired
private ProductService ProductService;

@Autowired
private StogareService stogareService;

@GetMapping(value="add-product")
public String indexA(Model model) {
    ProductDto dto = new ProductDto();
    dto.setIsEdit(false);

    model.addAttribute("product", dto);
return "web-admin/AddProduct";
}

@GetMapping("list-product")
public ModelAndView indexL(ModelMap model, @RequestParam(name = "keyword", required = false) String keyword,
@RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size) {

    int curPage = page.orElse(1);
    int pageSize = size.orElse(5);

  
    Page<Product> resultPage = null;
   
    if (StringUtils.hasText(keyword)) {
        Pageable pageable = PageRequest.of(curPage - 1, pageSize);
        resultPage = ProductService.findByNameContaining(keyword, pageable);
        model.addAttribute("keyword", keyword);
    } else {
        Pageable pageable = PageRequest.of(curPage - 1, pageSize);
        resultPage = ProductService.findAll(pageable);
        
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

    List<Product> p = ProductService.findAll();


    model.addAttribute("keyword", keyword);
    model.addAttribute("productPage", resultPage);
    model.addAttribute("tt", p.size());
    return new ModelAndView("web-admin/ListProduct", model);
}

@ModelAttribute("categories")
public List<Category> getCategoryDtos(){
    return CategoryService.findAll();
    }

    @ModelAttribute("brands")
    public List<Brand> getBrandDtos(){
        return BrandService.findAll();
        }

        @PostMapping("/store")
        public String store(ModelMap model) {

        return "web-admin/ListProduct";
        }

        @GetMapping("/create")
        public String create() {

        return "web-admin/AddProduct";
        }



        @PostMapping(value = "update", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE })
        public ModelAndView update(ModelMap model, 
        @Validated @ModelAttribute("product") ProductDto dto,
        @RequestParam("listImageFile") MultipartFile[] file ,BindingResult result)
        throws ParseException {


           

        if (result.hasErrors()) {
       
        return new ModelAndView("admin/product/AddProduct");
        }
        if(!dto.getIsEdit().booleanValue()) {
       dto.setCreateAt(new Date());
        }else {
            Optional<Product> s = ProductService.findById( dto.getId());
            
		    Date pdto = s.get().getCreateAt();
             dto.setCreateAt(pdto);
        }
         
           Product product = new Product();
            BeanUtils.copyProperties(dto, product);

            Category category = new Category();
            category.setId(dto.getCategoryId());
            product.setCategory(category);

            Brand Brand = new Brand();
            Brand.setId(dto.getBrandId());
            product.setBrand(Brand);

            product.setUpdateAt(new Date());
            product.setThumbnail(stogareService.getFileName(dto.getImageFile()));
            stogareService.store(dto.getImageFile(), product.getThumbnail());
            

            try {       
           
                Set<Image> images = uploadImage(file);
                product.setProductImages(images);
                
            } catch (Exception e) {
                System.out.println(e);

            }

            ProductService.save(product);



            return new ModelAndView("redirect:/admin/product/list-product");
            }


            public Set<Image> uploadImage(MultipartFile[] multipartFiles) throws IOException{
                Set<Image> images = new HashSet<>();

                for(MultipartFile file:multipartFiles){
                    Image img = new Image(
                        stogareService.getFileName(file),
                        file.getContentType(),
                        file.getBytes());
                        stogareService.store(file,  img.getName());
                        // System.out.println(stogareService.getFileName(file));
                        // System.out.println(stogareService.loadResource(img.getName()));
                        // System.out.println(img.getName());
                        // System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
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
            ProductService.deleteById(id);

            return "redirect:/admin/product/list-product";
            }

    @GetMapping("edit/{productId}")
	public ModelAndView edit(ModelMap map, @PathVariable("productId") Integer Id) {

		Optional<Product> opt = ProductService.findById(Id);
        List<Image> images = stogareService.findImageByProductId(Id);
		ProductDto dto = new ProductDto();

		if (opt.isPresent()) {
			Product entity = opt.get();
			BeanUtils.copyProperties(entity, dto);
			dto.setIsEdit(true);
            map.addAttribute("pushImage", images);
			map.addAttribute("product", dto);
			return new ModelAndView("web-admin/AddProduct", map);
		}

            return new ModelAndView("web-admin/AddProduct");
            }


            }