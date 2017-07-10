package com.contactRecord.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HomeController {
	
@RequestMapping(value="/editContactRecord", method=RequestMethod.GET)
public String displayHomePage(){
	return "editContactRecordForm";
}

@RequestMapping(value={"/", "/createContactRecord"}, method=RequestMethod.GET)
public String createContactRecord(){
	return "createContactRecordForm";
}

}
