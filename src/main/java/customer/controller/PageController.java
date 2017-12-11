package customer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PageController {
	
	@RequestMapping (value =  "/home" , method = RequestMethod. GET )  
	public String home() {
		return "home";
	}
	
	@RequestMapping (value =  "/createform" , method = RequestMethod. GET )  
	public String createForm() {
		return "createform";
	}
	
	@RequestMapping (value =  "/customer_report" , method = RequestMethod. GET )  
	public String issueReport() {
		return "customer_report";
	}
	
	
	
}
