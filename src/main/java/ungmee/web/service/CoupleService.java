package ungmee.web.service;



import java.util.Date;
import java.util.Map;

import ungmee.web.entity.Couple;



public interface CoupleService {
	//Ŀ������
	public Couple get(int id);
	//Ŀ���� ��� ����
	public Map<String, Object> getCoupleInfo(int id);
	//Ŀ�õ��
	public int regInfo(Couple couple, Date sloveDate, int id);
	//�������� ���
	public int proposeCancel(String email);
	//�������� ����
	public int proposeAccept(int coupleId, int aId);
	//�������� ����
	public int prposeRefuse(int coupleId);
	//�̸� ����
	public int nameUpdate(String name, int id);
	//���� ����
	public int messageUpdate(String name, int id);
	//������ ����
	public int editSoloProfile(int id, String fileName);

}