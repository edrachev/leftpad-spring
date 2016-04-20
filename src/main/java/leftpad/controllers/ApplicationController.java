package leftpad.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationController {
    @RequestMapping
    public String welcome(@RequestParam(required = false, defaultValue = "Traveller") String name) {
	return "Hello, " + name + "!";
    }
}
