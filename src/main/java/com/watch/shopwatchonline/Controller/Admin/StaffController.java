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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.watch.shopwatchonline.Domain.StaffDto;
import com.watch.shopwatchonline.Model.Staff;
import com.watch.shopwatchonline.Service.StaffService;

@Controller
@RequestMapping("api/admin/staffs")
public class StaffController {
    @Autowired
    StaffService staffService;

    @GetMapping("add")
    public String add(Model model) {
        StaffDto dto = new StaffDto();
        dto.setIsEdit(false);
        model.addAttribute("staff", dto);
        return "web-admin/staff";
    }

    @GetMapping("edit/{staffId}")
    public ModelAndView edit(ModelMap model, @PathVariable("staffId") Integer staffId) {

        Optional<Staff> opt = staffService.findById(staffId);
        StaffDto dto = new StaffDto();

        if (opt.isPresent()) {
            Staff entity = opt.get();

            BeanUtils.copyProperties(entity, dto);
            dto.setIsEdit(true);

            model.addAttribute("staff", dto);

            return new ModelAndView("web-admin/staff", model);
        }

        model.addAttribute("message", "Staff is existed");

        return new ModelAndView("forward:/api/admin/staffs", model);
    }

    @GetMapping("delete/{staffId}")
    public ModelAndView delete(ModelMap model, @PathVariable("staffId") Integer staffId) {

        Optional<Staff> opt = staffService.findById(staffId);
        staffService.deleteById(staffId);

        model.addAttribute("message", "Staff is delete!");

        return new ModelAndView("forward:/api/admin/staffs", model);
    }

    @PostMapping("saveOrUpdate")
    public ModelAndView saveOrUpdate(ModelMap model, @Valid @ModelAttribute("staff") StaffDto dto,
            BindingResult result) {
        if (result.hasErrors()) {
            return new ModelAndView("web-admin/staff");
        }
        Staff entity = new Staff();
        BeanUtils.copyProperties(dto, entity);

        staffService.save(entity);

        model.addAttribute("message", "Staff is saved!");

        return new ModelAndView("forward:/api/admin/staffs", model);
    }

    @RequestMapping("")
    public String list(ModelMap model) {
        List<Staff> list = staffService.findAll();

        model.addAttribute("staffs", list);
        return "web-admin/liststaff";
    }

    @GetMapping("search")
    public String search() {
        return "web-admin/liststaff";
    }
}
