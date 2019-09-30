package com.ungmee.web.service;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ungmee.web.dao.PartnerDao;
import com.ungmee.web.dao.SoloDao;
import com.ungmee.web.dao.SoloViewDao;
import com.ungmee.web.dao.UserDao;
import com.ungmee.web.entity.Partner;
import com.ungmee.web.entity.Solo;
import com.ungmee.web.entity.SoloView;
import com.ungmee.web.entity.User;


@Service
public class CustomMemberShipService implements MemberShipService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private SoloDao soloDao;
	@Autowired
	private SoloViewDao soloViewDao; 
	@Autowired
	private PartnerDao partnerDao;
	
	
	@Transactional
	@Override
	public int soloRegistration(User user, Solo solo) {
		int result = 0;
		BCryptPasswordEncoder bpw = new BCryptPasswordEncoder();
		String pw = bpw.encode(user.getPw());
		user.setPw(pw);
		result = userDao.insert(user);
		User sUser = userDao.getEmail(user.getEmail());
		solo.setId(sUser.getId());
		result = soloDao.insert(solo);
		
		return result;
		
	}
	@Override
	public boolean duplicateUserEmail(String email) {
		User user = userDao.getEmail(email);	
		if(user != null)//�����ϸ� 
			return true;
		return false;
	}
	
	@Override
	public SoloView getSoloInfo(int id) {
		soloViewDao.get(id);		
		return soloViewDao.get(id);
	}

	@Override
	public int editSoloNickName(int id , String nickName) {
		User user = userDao.get(id);
		user.setNickName(nickName);
		return userDao.edit(user);
	}
	
	@Override
	public int editSoloProfile(int id,String profile) {
		User user = userDao.get(id);
		user.setProfile(profile);
		return userDao.edit(user);
	}

	@Override
	public int editSoloPassword(int id, String pwd) {
		User user = userDao.get(id);
		user.setPw(pwd);
		return userDao.edit(user);
	}
	
	@Override
	public int editSoloEvent(int id, String e) {
		User user = userDao.get(id);
		if(e.equals("T"))
			user.setEcheck("F");
		else
			user.setEcheck("T");
		return userDao.edit(user);
	}

	@Override
	public User getEmail(String email) {
		User user = userDao.getEmail(email);
		return user;
	}
	@Override
	public int partnerReg(User user, Partner partner) {
		String pwd = user.getPw();
		System.out.println("signup-pwd:"+ pwd);
		PasswordEncoder pwdEncoder = new BCryptPasswordEncoder();
		pwd = pwdEncoder.encode(pwd);
		
		user.setPw(pwd);
		
		// ���� ȸ�� ���� ����
		userDao.insert(user);
		// ��� ���� ȸ�� ���� ��������
		User insertUser = userDao.getEmail(user.getEmail());
		//��ϵ� ȸ���� ID �����´� 
		insertUser.getId();
		//System.out.println("�μ�Ʈ�� �������̵�" + insertUser.getId());
		partner.setUserId(insertUser.getId());
		//System.out.println("�μ�Ʈ�� �������̵�" + partner.getUserId());
		int result = partnerDao.insert(partner);
		
		return result;
	}
}
