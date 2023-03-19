package anh.AngularMetroUI.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	@GetMapping("/")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
      System.out.println("hello method is starting");
      
      return String.format("Hello %s!", name);
    }
}
