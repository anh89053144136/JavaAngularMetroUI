package anh.AngularMetroUI.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import anh.AngularMetroUI.HibernateUtils;

@RestController
public class HomeController {
	@GetMapping("/")
    public RedirectView hello() {
		return new RedirectView("index.html");
    }
	
	@GetMapping("/testdb")
    public void Testdb() throws Exception {
		var session = HibernateUtils.GetSessionFactory();
    }
}
