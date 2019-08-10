package ungmee.web.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ungmee.web.dao.PartnerDao;
import ungmee.web.dao.UserDao;
import ungmee.web.entity.Partner;
import ungmee.web.entity.User;
import ungmee.web.service.PushService;

@Controller
@RequestMapping("/")
public class RootController {
	@Autowired
	private UserDao userDao;
	@Autowired
	private PartnerDao partnerDao;

	private PushService pushService;

	
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
	
	@PostMapping("signup")
	public String signup(User user ,String echeck) {
		if(echeck == null)
			user.setEcheck("F");
		String pwd = user.getPw();
		System.out.println(pwd);
		PasswordEncoder pwdEncoder = new BCryptPasswordEncoder();
		pwd = pwdEncoder.encode(pwd);
		
		user.setPw(pwd);

		userDao.insert(user);
		System.out.println(user.getId());
		return "redirect:/index" ; 
		
	}
	
	@GetMapping("partner-signup")
	public String partnersignup() {
		return "partner/signup";
	}
	
	@PostMapping("partner-signup")
	public String partnersignup(User user, Partner partner, @RequestParam("boss-name")String bName, 
			@RequestParam("partner-name")String pName, @RequestParam("partner-type")String pType ) {
		
		String pwd = user.getPw();
		System.out.println("signup-pwd:"+ pwd);
		PasswordEncoder pwdEncoder = new BCryptPasswordEncoder();
		pwd = pwdEncoder.encode(pwd);
		
		user.setPw(pwd);
		partner.setbName(bName); //������̸�
		partner.setpName(pName); //��ȣ��
		partner.setpType(pType); //����
		
		
		//user�� ����ȸ�������� ����ִ� ��ü(�̸���,���,�г���) db Ŀ�ԵǱ� ��ü ��. 
		//insertUser �� ���� ȸ�� ������ ����� ������ ��� �ִ� ��ü db Ŀ�Ե� ��ü �� �����´�.
		
		
		// ���� ȸ�� ���� ����
		userDao.insertPartner(user);
		// ��� ���� ȸ�� ���� ��������
		User insertUser = userDao.getEmail(user.getEmail());
		//��ϵ� ȸ���� ID �����´� 
		insertUser.getId();
		System.out.println("�μ�Ʈ�� �������̵�" + insertUser.getId());
		partner.setUserId(insertUser.getId());
		System.out.println("�μ�Ʈ�� �������̵�" + partner.getUserId());
		partnerDao.insert(partner);
		
		
		return "redirect:/index" ; 	
	}
	
	@RequestMapping("index")
	public String index(Model model) {
//		int count = pushService.getNewPushedCount();
		
//		Map<String, Object> map = pushService.getNewPushedList();
//		model.addAttribute("eventList", map.get("eventList"));
		
		
		
		
		return "root.index";
	}
	
}
