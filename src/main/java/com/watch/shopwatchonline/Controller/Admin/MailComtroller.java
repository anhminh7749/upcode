package com.watch.shopwatchonline.Controller.Admin;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.watch.shopwatchonline.Domain.MailDto;
import com.watch.shopwatchonline.Model.Mail;
import com.watch.shopwatchonline.Repository.MailRepository;

@Controller
@RequestMapping("site/mail")
public class MailComtroller {
    @Autowired
    JavaMailSender javaMailSender;
    
    @Autowired
    MailRepository mailRepository;

 
    @GetMapping("form")
	public String showForm() {
		return "web-site/contact";
	}

    @PostMapping("send")
	public ModelAndView sendMail(ModelMap model, @Valid @ModelAttribute("mail") MailDto dto,
			BindingResult result) {
    	if(result.hasErrors()) {
            return new ModelAndView("web-site/contact");
        }
    	System.out.println(result);
		Mail entity = new Mail();
		BeanUtils.copyProperties(dto, entity);
		Date date = new Date();
		entity.setCreateAt(date);
		entity.setUpdateAt(date);
		mailRepository.save(entity);
		model.addAttribute("message", "Mail is saved!");
		return new ModelAndView("redirect:/site/mail/form", model);
	}
}
