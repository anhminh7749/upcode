package com.watch.shopwatchonline.Controller.Site;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.watch.shopwatchonline.Domain.blogDto;
import com.watch.shopwatchonline.Model.Blog;
import com.watch.shopwatchonline.Model.Image;
import com.watch.shopwatchonline.Service.BlogService;
import com.watch.shopwatchonline.Service.StogareService;

@Controller
// @RequestMapping
public class comment {

    
@Autowired
private BlogService blogService;

@Autowired
private StogareService stogareService;
    
    @GetMapping("site/cmt") 
     public String detailProduct() {
      

        return "web-site/comment";
    }

    @GetMapping("site/blog/detail/{id}") 
     public String detail(ModelMap model, @PathVariable("id") Integer id) {
        Optional < Blog > opt = blogService.findById(id);
        List <Image> images = stogareService.findImageByBlogId(id);

        if (opt.isPresent()) {
            Blog entity = opt.get();

            model.addAttribute("listimage", images);
            model.addAttribute("blog", entity);
			return "web-site/blog-single";
		}
        return "web-site/blog-single";
    }
    @GetMapping("images/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serverFile(@PathVariable(name = "filename") String fileName) {

        Resource file = stogareService.loadResource(fileName);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                .body(file);
    }

    @GetMapping("site/blog")
     public String Listblog(ModelMap model, @RequestParam(name = "keyword", required = false) String keyword,
     @RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size) {
        int curPage = page.orElse(1);
        int pageSize = size.orElse(5);
        Page<Blog> resultPage = null;
        if (StringUtils.hasText(keyword)) {
            Pageable pageable = PageRequest.of(curPage - 1, pageSize);
          //  resultPage = blogService.findByNameContaining(keyword, pageable);
            model.addAttribute("keyword", keyword);
        } else {
            
            Pageable pageable = PageRequest.of(curPage - 1, pageSize,Sort.by("createAt").descending());
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
      

        return "web-site/ListBlog";
    }
}
