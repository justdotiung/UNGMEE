package ungmee.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PublicController {
	@RequestMapping("/login")
	public void login() {
		System.out.println("����� �α��� ���� ");
	}
	@RequestMapping("/signup")
	public void signup() {
		System.out.println("����� ȸ������ ���� ");
	}
	@RequestMapping("/index")
	public String index() {
		System.out.println("����� ���������� ���� ");
		return "/index";
	}
}
