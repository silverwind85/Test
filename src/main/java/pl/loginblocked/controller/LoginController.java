package pl.loginblocked.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.loginblocked.entity.User;



@Controller
public class LoginController {
	@GetMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String error,
    		@RequestParam(value = "logout", required = false) String logout, Model model, HttpServletRequest request) {
		
		
	
		
		 
		/*if (error != null) {
			model.addAttribute("error", 
                           getErrorMessage(request, "SPRING_SECURITY_LAST_EXCEPTION"));
		}*/

		if (logout != null) {
			model.addAttribute("msg", "You've been logged out successfully.");
		}
		
        model.addAttribute("user", new User());
        return "login";
    }
}
