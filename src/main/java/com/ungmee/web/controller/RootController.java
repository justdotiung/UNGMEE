package com.ungmee.web.controller;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ungmee.web.dao.PartnerDao;
import com.ungmee.web.dao.UserDao;
import com.ungmee.web.entity.Partner;
import com.ungmee.web.entity.Solo;
import com.ungmee.web.entity.SoloView;
import com.ungmee.web.entity.User;
import com.ungmee.web.security.CustomUserDetails;
import com.ungmee.web.service.KakaoAPI;
import com.ungmee.web.service.MemberShipService;
import com.ungmee.web.service.PushService;

@Controller
@RequestMapping("/")
public class RootController {
	@Autowired
	private UserDao userDao;
	@Autowired
	private PartnerDao partnerDao;
	@Autowired
	private PushService pushService;
	@Autowired
	private MemberShipService msService;
	@Autowired
	private KakaoAPI api;
	
	@GetMapping("kakao-login")
	public String login(String code) {
		String token = api.getAccessToken(code);
		System.out.println("code : "+code);
		System.out.println("token : "+token);
		return "root.index";
	}
	@GetMapping("login")
	public String login() {
		return "root.login";
	}
	
	@RequestMapping("withdraw")
	public String withdraw() {
		return "root.withdraw";
	}
	@GetMapping("signup")
	public String signup() {
		return "root.signup";
	}
//	@GetMapping("map")
//	public String map() {
//		return "root.map";
//	}
//	

	
	//�������� ����� �� ENTITY�� JSP ������ �������ֱ� 1
//	@PostMapping("partner-signup")
//	public String partnersignup(User user, Partner partner, @RequestParam("boss-name")String bName, 

//		PasswordEncoder pwdEncoder = new BCryptPasswordEncoder();
//		pwd = pwdEncoder.encode(pwd);
//		
//		user.setPw(pwd);
		
//�������� ����� �� ENTITY�� JSP ������ �������ֱ� 2		
//		partner.setbName(bName); //������̸�
//		partner.setpName(pName); //��ȣ��
//		partner.setpType(pType); //����
		
		
		//user�� ����ȸ�������� ����ִ� ��ü(�̸���,���,�г���) db Ŀ�ԵǱ� ��ü ��. 
		//insertUser �� ���� ȸ�� ������ ����� ������ ��� �ִ� ��ü db Ŀ�Ե� ��ü �� �����´�.
		

//		
//		return "redirect:/index" ; 	
//	}
	@RequestMapping("index")
	public String index(Model model,Authentication auth,HttpServletRequest req) {
		
		model.addAttribute("title","qkRNa");
//		if(auth != null) {
//			CustomUserDetails user = (CustomUserDetails) auth.getPrincipal();
//			int id = user.getId();
//			SoloView solo = msService.getSoloInfo(id);			
//			int count = pushService.getNewPushCount(id);
//			List<Map<String,Object>> list = pushService.getNewPushList(id);
//			model.addAttribute("count", count);
//			model.addAttribute("list", list);
//			model.addAttribute("user", solo);
//		}
//		int count = pushService.getNewPushedCount();

//		Map<String, Object> map = pushService.getNewPushedList();
//		model.addAttribute("eventList", map.get("eventList"));
		return "root.index";
	}
}
