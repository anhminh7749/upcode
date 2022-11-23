package com.watch.shopwatchonline.Controller.Site;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class BlogSiteController {

    @RequestMapping("/site/blog-list")
    public String blogList(){
        return "web-site/blog-list";
    }

    @RequestMapping("/site/blog-details")
    public String blogDetails(){
        return "web-site/blog-single";
    }
}
