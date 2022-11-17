package com.watch.shopwatchonline.Controller.Site;

import java.util.Date;
import java.util.List;
import java.util.Optional;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import com.watch.shopwatchonline.Model.Brand;
import com.watch.shopwatchonline.Model.Category;
import com.watch.shopwatchonline.Model.Image;
import com.watch.shopwatchonline.Model.Product;
import com.watch.shopwatchonline.Model.Raiting;
import com.watch.shopwatchonline.Model.User;
import com.watch.shopwatchonline.Repository.RaitingRepository;
import com.watch.shopwatchonline.Repository.UserRepository;
import com.watch.shopwatchonline.Repository.WishlistRepository;
import com.watch.shopwatchonline.Service.CategoryService;
import com.watch.shopwatchonline.Service.ProductService;
import com.watch.shopwatchonline.Service.StogareService;
import com.watch.shopwatchonline.Service.ServiceImpl.UserDetailsServiceImpl;
import com.watch.shopwatchonline.security.jwt.JwtUtils;
import com.watch.shopwatchonline.Service.BrandService;
@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
@RequestMapping("api/site/product")
public class SearchProductController {

    @Autowired private CategoryService CategoryService;

    @Autowired private BrandService BrandService;

    @Autowired private ProductService ProductService;

    @Autowired private StogareService StogareService;
    @Autowired
  private RaitingRepository raitingRepository;
  @Autowired private JwtUtils jwtUtils;
  @Autowired private UserRepository userRepository;
  @Autowired
  private WishlistRepository wishlistRepository;

    @GetMapping("") public ModelAndView index(ModelMap model,
        @RequestParam("page") Optional < Integer > page,
        @RequestParam("size") Optional < Integer > size,
        @RequestParam("sort") Optional < Integer > sort,
        @RequestParam(name = "Getcategory", required = false) String Getcategory,
        @RequestParam(name = "Getbrand", required = false) String Getbrand,
        @RequestParam(name = "GetPrice", required = false) String GetPrice) {

          
        List < Brand > brand = BrandService.findAll();
        List < Category > cate = CategoryService.findAll();
        Page < Product > resultPage = null;

        int curPage = page.orElse(1);
        int pageSize = size.orElse(6);
        int abx = sort.orElse(1);
        if (!sort.isEmpty()) {

            Sort sortable = Sort.by("id").ascending();

            if (abx == 1) {
                sortable = Sort.by("id").ascending();
            }

            if (abx == 3) {
                sortable = Sort.by("price").ascending();
            }

            if (abx == 4) {
                sortable = Sort.by("discount").descending();
            }

            if (abx == 2) {
                sortable = Sort.by("name").descending();
            }

            Pageable pageable = PageRequest.of(curPage - 1, pageSize, sortable);

            if (Getcategory != null || Getbrand != null || GetPrice != null) {
                if (Getbrand != null && Getcategory == null && GetPrice == null) resultPage = ProductService.findByBrand(Integer.parseInt(Getbrand), pageable);
                if (Getbrand == null && Getcategory != null && GetPrice == null) resultPage = ProductService.findByCategory(Integer.parseInt(Getcategory), pageable);
                if (Getcategory != null && Getbrand != null && GetPrice == null) resultPage = ProductService.findByAllNotPrice(Integer.parseInt(Getbrand), Integer.parseInt(Getcategory), pageable);
                if (Getbrand != null && Getcategory != null && GetPrice != null) {
                    switch (Integer.parseInt(GetPrice)) {
                        case 1:

                            resultPage = ProductService.findByAll(Integer.parseInt(Getbrand), Integer.parseInt(Getcategory), 0, 100, pageable);
                            break;
                        case 2:
                            resultPage = ProductService.findByAll(Integer.parseInt(Getbrand), Integer.parseInt(Getcategory), 100, 500, pageable);
                            break;
                        case 3:
                            resultPage = ProductService.findByAll(Integer.parseInt(Getbrand), Integer.parseInt(Getcategory), 500, 1000, pageable);
                            break;
                        case 4:
                            resultPage = ProductService.findByAll(Integer.parseInt(Getbrand), Integer.parseInt(Getcategory), 1000, 5000, pageable);
                            break;
                        case 5:
                            resultPage = ProductService.findByAll(Integer.parseInt(Getbrand), Integer.parseInt(Getcategory), 5000, 10000, pageable);
                            break;
                    }
                }
                if (Getbrand == null && Getcategory != null && GetPrice != null) {
                    switch (Integer.parseInt(GetPrice)) {
                        case 1:

                            resultPage = ProductService.findByAllNotBrand(Integer.parseInt(Getcategory), 0, 100, pageable);
                            break;
                        case 2:
                            resultPage = ProductService.findByAllNotBrand(Integer.parseInt(Getcategory), 100, 500, pageable);
                            break;
                        case 3:
                            resultPage = ProductService.findByAllNotBrand(Integer.parseInt(Getcategory), 500, 1000, pageable);
                            break;
                        case 4:
                            resultPage = ProductService.findByAllNotBrand(Integer.parseInt(Getcategory), 1000, 5000, pageable);
                            break;
                        case 5:
                            resultPage = ProductService.findByAllNotBrand(Integer.parseInt(Getcategory), 5000, 500000, pageable);
                            break;
                    }

                }
                if (Getbrand != null && Getcategory == null && GetPrice != null) {
                    switch (Integer.parseInt(GetPrice)) {
                        case 1:
                            resultPage = ProductService.findByAllNotCate(Integer.parseInt(Getbrand), 0, 100, pageable);
                            break;
                        case 2:
                            resultPage = ProductService.findByAllNotCate(Integer.parseInt(Getbrand), 100, 500, pageable);
                            break;
                        case 3:
                            resultPage = ProductService.findByAllNotCate(Integer.parseInt(Getbrand), 500, 1000, pageable);
                            break;
                        case 4:
                            resultPage = ProductService.findByAllNotCate(Integer.parseInt(Getbrand), 1000, 5000, pageable);
                            break;
                        case 5:
                            resultPage = ProductService.findByAllNotCate(Integer.parseInt(Getbrand), 5000, 500000, pageable);
                            break;
                    }
                }
                if (Getbrand == null && Getcategory == null && GetPrice != null) {
                    switch (Integer.parseInt(GetPrice)) {
                        case 1:
                        
                            resultPage = ProductService.findByPriceBetween(0, 100, pageable);
                            break;
                        case 2:
                            resultPage = ProductService.findByPriceBetween(100, 500, pageable);
                            break;
                        case 3:
                            resultPage = ProductService.findByPriceBetween(500, 1000, pageable);
                            break;
                        case 4:
                            resultPage = ProductService.findByPriceBetween(1000, 5000, pageable);
                            break;
                        case 5:
                            resultPage = ProductService.findByPriceBetween(5000, 500000, pageable);
                            break;
                    }
                }
            } else {
                resultPage = ProductService.findAll(pageable);
            }

            
            model.addAttribute("sort", abx);

        } else {
            Pageable pageable = PageRequest.of(curPage - 1, pageSize);

            if (Getcategory != null || Getbrand != null || GetPrice != null) {
                if (Getbrand != null && Getcategory == null && GetPrice == null) resultPage = ProductService.findByBrand(Integer.parseInt(Getbrand), pageable);
                if (Getbrand == null && Getcategory != null && GetPrice == null) resultPage = ProductService.findByCategory(Integer.parseInt(Getcategory), pageable);
                if (Getcategory != null && Getbrand != null && GetPrice == null) resultPage = ProductService.findByAllNotPrice(Integer.parseInt(Getbrand), Integer.parseInt(Getcategory), pageable);
                if (Getbrand != null && Getcategory != null && GetPrice != null) {
                    switch (Integer.parseInt(GetPrice)) {
                        case 1:

                            resultPage = ProductService.findByAll(Integer.parseInt(Getbrand), Integer.parseInt(Getcategory), 0, 100, pageable);
                            break;
                        case 2:
                            resultPage = ProductService.findByAll(Integer.parseInt(Getbrand), Integer.parseInt(Getcategory), 100, 500, pageable);
                            break;
                        case 3:
                            resultPage = ProductService.findByAll(Integer.parseInt(Getbrand), Integer.parseInt(Getcategory), 500, 1000, pageable);
                            break;
                        case 4:
                            resultPage = ProductService.findByAll(Integer.parseInt(Getbrand), Integer.parseInt(Getcategory), 1000, 5000, pageable);
                            break;
                        case 5:
                            resultPage = ProductService.findByAll(Integer.parseInt(Getbrand), Integer.parseInt(Getcategory), 5000, 10000, pageable);
                            break;
                    }
                }
                if (Getbrand == null && Getcategory != null && GetPrice != null) {
                    switch (Integer.parseInt(GetPrice)) {
                        case 1:

                            resultPage = ProductService.findByAllNotBrand(Integer.parseInt(Getcategory), 0, 100, pageable);
                            break;
                        case 2:
                            resultPage = ProductService.findByAllNotBrand(Integer.parseInt(Getcategory), 100, 500, pageable);
                            break;
                        case 3:
                            resultPage = ProductService.findByAllNotBrand(Integer.parseInt(Getcategory), 500, 1000, pageable);
                            break;
                        case 4:
                            resultPage = ProductService.findByAllNotBrand(Integer.parseInt(Getcategory), 1000, 5000, pageable);
                            break;
                        case 5:
                            resultPage = ProductService.findByAllNotBrand(Integer.parseInt(Getcategory), 5000, 500000, pageable);
                            break;
                    }

                }
                if (Getbrand != null && Getcategory == null && GetPrice != null) {
                    switch (Integer.parseInt(GetPrice)) {
                        case 1:
                            resultPage = ProductService.findByAllNotCate(Integer.parseInt(Getbrand), 0, 100, pageable);
                            break;
                        case 2:
                            resultPage = ProductService.findByAllNotCate(Integer.parseInt(Getbrand), 100, 500, pageable);
                            break;
                        case 3:
                            resultPage = ProductService.findByAllNotCate(Integer.parseInt(Getbrand), 500, 1000, pageable);
                            break;
                        case 4:
                            resultPage = ProductService.findByAllNotCate(Integer.parseInt(Getbrand), 1000, 5000, pageable);
                            break;
                        case 5:
                            resultPage = ProductService.findByAllNotCate(Integer.parseInt(Getbrand), 5000, 500000, pageable);
                            break;
                    }
                }
                if (Getbrand == null && Getcategory == null && GetPrice != null) {
                    switch (Integer.parseInt(GetPrice)) {
                        case 1:
                            resultPage = ProductService.findByPriceBetween(0, 100, pageable);
                            break;
                        case 2:
                            resultPage = ProductService.findByPriceBetween(100, 500, pageable);
                            break;
                        case 3:
                            resultPage = ProductService.findByPriceBetween(500, 1000, pageable);
                            break;
                        case 4:
                            resultPage = ProductService.findByPriceBetween(1000, 5000, pageable);
                            break;
                        case 5:
                            resultPage = ProductService.findByPriceBetween(5000, 500000, pageable);
                            break;
                    }
                }
            } else {
                resultPage = ProductService.findAll(pageable);
            }


        }

        int totalPages = resultPage.getTotalPages();

        if (totalPages > 0) {
            int start = Math.max(1, curPage - 2);
            int end = Math.min(curPage + 2, totalPages);

            if (totalPages > 6) {
                if (end == totalPages) {
                    start = end - 6;
                } else {
                    if (start == 1) {
                        end = start + 6;
                    }
                }
            }

            List < Integer > pageNums = IntStream.rangeClosed(start, end).boxed().collect(Collectors.toList());
            model.addAttribute("pageNums", pageNums);

        }

        if (Getcategory != null) {
            model.addAttribute("Getcategory", Integer.parseInt(Getcategory));
        }

        if (Getbrand != null) {
            model.addAttribute("Getbrand", Integer.parseInt(Getbrand));
        }

        if (GetPrice != null) {
            model.addAttribute("GetPrice", Integer.parseInt(GetPrice));
        }



        model.addAttribute("productPage", resultPage);
        model.addAttribute("brand", brand);
        model.addAttribute("cate", cate);

        return new ModelAndView("web-site/index", model);
    }




    @GetMapping("images/{filename:.+}") @ResponseBody public ResponseEntity < Resource > serverFile(@PathVariable(name = "filename") String fileName) {

        Resource file = StogareService.loadResource(fileName);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }

    @GetMapping("detail/{id}") public ModelAndView detailProduct(ModelMap model, @PathVariable("id") Integer id, HttpServletRequest request) {
        Optional < Product > opt = ProductService.findById(id);
        List < Image > images = StogareService.findImageByProductId(id);
        List<Raiting> rai = raitingRepository.findByProductId(id);
        String token = jwtUtils.getJwtFromCookies(request);
        String username =jwtUtils.getUserNameFromJwtToken(token);
        Optional<User> user = userRepository.findByUsername(username);
        float avg=0;
         if(raitingRepository.AvgByProductId(id) != null){
            avg = Float.parseFloat(raitingRepository.AvgByProductId(id));
        }
        
        int like;
        if(!wishlistRepository.check(opt.get().getId(), user.get().getId()).isEmpty()){
            like = 0;
            model.addAttribute("like", like);
        }else{
            like = 1;
            model.addAttribute("like", like);
        }

        if (opt.isPresent()) {
            if (!rai.isEmpty()) {
                model.addAttribute("raiting", rai);
              
            }

            if (avg!=0) {
                model.addAttribute("avg", avg);
              
            }
            Product entity = opt.get();

            model.addAttribute("listimage", images);
            model.addAttribute("product", entity);
            return new ModelAndView("web-site/single", model);
        }

        return new ModelAndView("", model);
    }

}

