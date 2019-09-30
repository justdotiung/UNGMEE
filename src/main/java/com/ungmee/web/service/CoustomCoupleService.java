package com.ungmee.web.service;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ungmee.web.dao.CoupleDao;
import com.ungmee.web.dao.SoloDao;
import com.ungmee.web.dao.UserDao;
import com.ungmee.web.entity.Couple;
import com.ungmee.web.entity.Solo;
import com.ungmee.web.entity.User;


@Service
public class CoustomCoupleService implements CoupleService {

	@Autowired
	private CoupleDao coupleDao;
	@Autowired
	private SoloDao soloDao;
	@Autowired
	private UserDao userDao;
	
	@Override
	public Couple get(int id) {
		Couple couple = coupleDao.getUser(id);
		return couple;
	}
	
	@Override
	public Map<String,Object> getCoupleInfo(int id) {
		Map<String, Object> map = new HashMap<String, Object>();
		Couple couple = coupleDao.getUser(id);
		
		// date1, date2 �� ��¥�� parse()�� ���� Date������ ��ȯ.
	    Date FirstDate = couple.getLoveDate();
	    Date SecondDate = new Date();
	    // Date�� ��ȯ�� �� ��¥�� ����� �� �� ���ϰ����� long type ������ �ʱ�ȭ �ϰ� �ִ�.
	    long calDate = FirstDate.getTime() - SecondDate.getTime(); 
	    // Date.getTime() �� �ش糯¥�� ��������1970�� 00:00:00 ���� �� �ʰ� �귶������ ��ȯ���ش�. 
	    // ���� 24*60*60*1000(�� �ð����� ���� ������) �� �����ָ� �ϼ��� ���´�.
	    long calDateDays = calDate / ( 24*60*60*1000); 
	    // Math.abs() �� ���� ���� ����� ��� ���
	    calDateDays = Math.abs(calDateDays)+1;
	    // System.out.println("�� ��¥�� ��¥ ����: "+calDateDays);
	    
	    map.put("date", calDateDays);
	    map.put("info",couple);
		return map;
	}

	@Override
	public int regInfo(Couple couple, @DateTimeFormat(pattern = "yyyy-MM-dd")Date sloveDate,int id) {
		couple.setLoveDate(sloveDate);
		couple.setProposeId(id);
		coupleDao.insert(couple);
		Solo solo = soloDao.get(couple.getProposeId());
		solo.setcState(0);
		int result = soloDao.update(solo);
		return result;
	}
	@Transactional
	@Override
	public int proposeCancel(String email) {
		User user = userDao.getEmail(email);
		Solo solo = soloDao.get(user.getId());
		Couple couple = coupleDao.getSender(solo.getId());
		System.out.println(couple.toString());
		solo.setcState(-1);
		soloDao.update(solo);
		
		int result = coupleDao.delete(couple.getId());
		
		return result;
	}

	@Override
	public int proposeAccept(int cId,int aId) {
		Solo acceptSolo = soloDao.get(aId); //������ ���̵� 
		Couple couple = coupleDao.get(cId); //Ŀ�� pk�� �̿��� ���� ���̵�
		Solo proposeSolo = soloDao.get(couple.getProposeId());//�������� ���̵�
		Couple check = coupleDao.getUser(aId);//Ŀ�û��� �����ƴ��� ����
		
		
		if(check != null) {
			//System.out.println("�̹�Ŀ�û���");
			return -2;
		}
		
		acceptSolo.setcState(1);
		soloDao.update(acceptSolo);
		
		proposeSolo.setcState(1);
		soloDao.update(proposeSolo);
		
		couple.setAccept(1);
		couple.setOldData(1);
		couple.setPseudo(1);
		int result  = coupleDao.update(couple);
		
		return result;
	}

	@Override
	public int prposeRefuse(int coupleId) {
		Couple couple = coupleDao.get(coupleId); //Ŀ�� ���� ���̵�
		Solo solo = soloDao.get(couple.getProposeId());//�������� ���̵�
		
		solo.setcState(-1);
		soloDao.update(solo);
		
		int result = coupleDao.delete(coupleId);
		return result;
	}

	@Override
	public int nameUpdate(String name, int id) {
		Couple couple = coupleDao.getUser(id);
		couple.setName(name);
		int result= coupleDao.update(couple);
		return result;
	}

	@Override
	public int messageUpdate(String message, int id) {
		Couple couple = coupleDao.getUser(id);
		couple.setMessage(message);
		int result= coupleDao.update(couple);
		return result;
	}

	@Override
	public int editProfile(int id, String fileName) {
		Couple couple = coupleDao.getUser(id);
		couple.setProfile(fileName);
		int result = coupleDao.update(couple);
		return result;
	}

	@Override
	public int breakUp(int id) {
		Couple couple = coupleDao.getUser(id);
		int result = coupleDao.delete(couple.getId());
		return result;
	}

}
