package com.springbootemail.application.controller;

import com.springbootemail.application.Repository.UsersRepository;
import com.springbootemail.application.model.Mails;
import com.springbootemail.application.model.Retrive;
import com.springbootemail.application.model.User;
import com.springbootemail.application.model.Users;
import com.springbootemail.application.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;

@Controller
public class MailController {

	@Autowired
	private MailService notificationService;
    @Autowired
	private  UsersRepository usersRepository;
//Send mail
	@PostMapping("/send-mail")
	public String send(@RequestBody User user) {

		try {
			notificationService.sendEmail(user);
		} catch (MailException mailException) {
			System.out.println(mailException);
		}
		return "Congratulations! Your mail has been send to the user.";
	}
//Send emails with attachments
	@PostMapping("send-mail-attachment")
	public String sendWithAttachment(@RequestBody User user) throws MessagingException {

		try {
			notificationService.sendEmailWithAttachment(user);
		} catch (MailException mailException) {
			System.out.println(mailException);
		}
		return "Congratulations! Your mail has been send to the user.";
	}
	//Retrieve the  mails from the server
	@PostMapping("retrive-attachments")
	public String RetrieveAttachments(@RequestBody Retrive retrive){
	 try{
			notificationService.downloadEmailAttachments(retrive);
		}
		catch (Exception e){
 System.out.println(e);
		}
return "Attachment downloaded";
	}


	//Retrieve the whitelisted mails from the server
	@PostMapping("/read_mails")
	public String ReadEmails(Retrive retrive){

		try{
			notificationService.readMails(retrive);}
		catch (Exception e){
			return String.valueOf(e);
		}
		return "download_Success"  ;
	}



}
