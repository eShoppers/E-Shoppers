package edu.mum.cs425.project.eshoppers.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ContactController {
	
	@RequestMapping(value = "/contactus")
	public String contactus() {
		return "webapps/contactus";
	}

}
