package com.springbootemail.application.controller;

import com.springbootemail.application.Repository.MailsRepository;
import com.springbootemail.application.Repository.UsersRepository;
import com.springbootemail.application.model.Mails;
import com.springbootemail.application.model.Retrive;
import com.springbootemail.application.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AppController {


	@Autowired
	private MailsRepository mailsRepository;
	@Autowired
	private UsersRepository usersRepository;
	private Users users;
	@GetMapping("")
	public String viewHomePage() {
		return "index";
	}
	
	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		model.addAttribute("users", new Users());
		
		return "signup_form";
	}
	@PostMapping("/process_register")
	public String processRegister(Users users) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(users.getPassword());
		users.setPassword(encodedPassword);
		
		usersRepository.save(users);
		
		return "register_success";
	}
	//returns a page to view previously accesed mails
	@GetMapping("/viewmail")
	public String Viewmail(Model model) {
		List<Mails> listMails = mailsRepository.findAll();
		model.addAttribute("listMails", listMails);
		return "fetch_mail";
	}

	//returns to page where you're supposed to give mail credentials to download emails
	@GetMapping("/mail")
	public String formmail(@ModelAttribute Retrive retrive, Model model) {
		model.addAttribute("retrive", retrive);
		return "mails1";
	}
//return to the homepage
	@GetMapping("/index2")
	public String viewdash() {
		return "index2";
	}
}
