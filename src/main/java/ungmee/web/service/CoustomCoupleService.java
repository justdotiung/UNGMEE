package ungmee.web.service;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import ungmee.web.dao.CoupleDao;
import ungmee.web.dao.SoloDao;
import ungmee.web.dao.UserDao;
import ungmee.web.entity.Couple;
import ungmee.web.entity.Solo;
import ungmee.web.entity.User;


@Service
public class CoustomCoupleService implements CoupleService {

	@Autowired
	private CoupleDao coupleDao;
	@Autowired
	private SoloDao soloDao;
	@Autowired
	private UserDao userDao;
	
	
	@Override
	public Couple getCoupleInfo(int id) {
		Couple couple = coupleDao.getUser(id);
		return couple;
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

	@Override
	public int proposeCancel(String email) {
		User user = userDao.getEmail(email);
		Solo solo = soloDao.get(user.getId());
		Couple couple = coupleDao.getSender(solo.getId());

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

}
