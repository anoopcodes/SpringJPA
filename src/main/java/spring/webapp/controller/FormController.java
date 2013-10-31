package spring.webapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.webapp.dao.FormDAO;
import spring.webapp.model.UserModel;

@Controller
@RequestMapping("/myform")
public class FormController {
	private static final Logger logger = LoggerFactory.getLogger(FormController.class);
	
	@Autowired
	private FormDAO formDAO;

	@RequestMapping(method = RequestMethod.GET)
	public String emptyForm(@ModelAttribute UserModel userModel) {
		return "myform";

	}

	@RequestMapping(method = RequestMethod.POST)
	public String saveForm(@ModelAttribute UserModel userModel) {

		System.out.println("----------------------------------------------");
		System.out.println(userModel.getPassword());
		System.out.println(userModel.getUserName());
		System.out.println("----------------------------------------------");
		// FormDAO fd = new FormDAO();
		formDAO.saveForm(userModel);
		// model.addAttribute("message", "Spring 3 MVC Hello World");
		return "success";

	}

}
