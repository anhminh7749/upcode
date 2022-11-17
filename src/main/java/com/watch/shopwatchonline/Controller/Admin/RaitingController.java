package com.watch.shopwatchonline.Controller.Admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.watch.shopwatchonline.Model.ChatBox;
import com.watch.shopwatchonline.Model.Raiting;
import com.watch.shopwatchonline.Repository.ChatBoxRepository;
import com.watch.shopwatchonline.Repository.RaitingRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
@RequestMapping("api/admin/raiting")
public class RaitingController {
    @Autowired
    private RaitingRepository raitingRepository;


    @GetMapping("list-waiting")
    public ModelAndView indexL(ModelMap model, @RequestParam(name = "keyword", required = false) String keyword,
        @RequestParam("page") Optional < Integer > page, @RequestParam("size") Optional < Integer > size) {

        int curPage = page.orElse(1);
        int pageSize = size.orElse(5);


        Page < Raiting > resultPage = null;

        if (StringUtils.hasText(keyword)) {
            Pageable pageable = PageRequest.of(curPage - 1, pageSize);
            resultPage = raitingRepository.findByKeyWord(keyword, (short) 0, pageable);
            model.addAttribute("keyword", keyword);
        } else {
            Pageable pageable = PageRequest.of(curPage - 1, pageSize);
            resultPage = raitingRepository.findByActive((short) 0, pageable);

        }

        int totalPages = resultPage.getTotalPages();

        if (totalPages > 0) {
            int start = Math.max(1, curPage - 2);
            int end = Math.min(curPage + 2, totalPages);

            if (totalPages > 5) {
                if (end == totalPages) {
                    start = end - 5;
                } else {
                    if (start == 1) {
                        end = start + 5;
                    }
                }
            }

            List < Integer > pageNums = IntStream.rangeClosed(start, end).boxed().collect(Collectors.toList());
            model.addAttribute("pageNums", pageNums);

        }

        List < Raiting > p = raitingRepository.findAll();


        model.addAttribute("keyword", keyword);
        model.addAttribute("raitingPage", resultPage);
        model.addAttribute("tt", p.size());
        return new ModelAndView("web-admin/ListRaiting", model);
    }


    @GetMapping("list-check")
    public ModelAndView index(ModelMap model, @RequestParam(name = "keyword", required = false) String keyword,
        @RequestParam("page") Optional < Integer > page, @RequestParam("size") Optional < Integer > size) {

        int curPage = page.orElse(1);
        int pageSize = size.orElse(5);


        Page < Raiting > resultPage = null;

        if (StringUtils.hasText(keyword)) {
            Pageable pageable = PageRequest.of(curPage - 1, pageSize);
            resultPage = raitingRepository.findByKeyWord(keyword, (short) 1, pageable);
            model.addAttribute("keyword", keyword);
        } else {
            Pageable pageable = PageRequest.of(curPage - 1, pageSize);
            resultPage = raitingRepository.findByActive((short) 1, pageable);

        }

        int totalPages = resultPage.getTotalPages();

        if (totalPages > 0) {
            int start = Math.max(1, curPage - 2);
            int end = Math.min(curPage + 2, totalPages);

            if (totalPages > 5) {
                if (end == totalPages) {
                    start = end - 5;
                } else {
                    if (start == 1) {
                        end = start + 5;
                    }
                }
            }

            List < Integer > pageNums = IntStream.rangeClosed(start, end).boxed().collect(Collectors.toList());
            model.addAttribute("pageNums", pageNums);

        }
       
        List < Raiting > p = raitingRepository.findAll();
        
        model.addAttribute("keyword", keyword);
        model.addAttribute("raitingPage", resultPage);
        model.addAttribute("tt", p.size());
        return new ModelAndView("web-admin/ListRaiting", model);
    }


    @GetMapping("check/{Id}")
    public ModelAndView edit(ModelMap map, @PathVariable("Id") Integer Id) {

        Optional < Raiting > opt = raitingRepository.findById(Id);

        if (opt.isPresent()) {
            Raiting entity = opt.get();
            Raiting r = new Raiting();
            BeanUtils.copyProperties(entity, r);
            r.setActive((short) 1);
            raitingRepository.save(r);
            return new ModelAndView("/list-waiting", map);
        }

        return new ModelAndView("/list-waiting");
    }

    @GetMapping("delete/{Id}")
    public String delete(ModelMap map, @PathVariable("Id") Integer id) {
        raitingRepository.deleteById(id);

        return "redirect:/api/admin/raiting/list-waiting";
    }
}