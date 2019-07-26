package ungmee.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class RootController {
	@Autowired
	private user
	
	@GetMapping("login")
	public String login() {
		return "root.login";
	}
	
	@PostMapping("logout")
	public String logout() {
		return "root.login";
	}
	@RequestMapping("withdraw")
	public String withdraw() {
		return "root.withdraw";
	}
	@GetMapping("signup")
	public String signup() {
		System.out.println(":durl");
		return "root.signup";
	}
	
	@PostMapping("signup")
	public String signup(String type
			,String name
			,String email
			,String pw
			,String terms1
			,String terms2
			,String bDay
			,String lDay
			,String gender		
			) {
		System.out.println(":durldfdf");
		
		System.out.println(type);
		System.out.println(name);
		System.out.println(email);
		System.out.println(pw);
		System.out.println(terms1);
		System.out.println(terms2);
		System.out.println(bDay);
		System.out.println(lDay);
		System.out.println(gender);
		
		return "redirect:login";
	}
	
	@RequestMapping("index")
	public String index() {
		return "root.index";
	}
}
