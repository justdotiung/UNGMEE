package ungmee.web.service;



import java.util.Date;

import ungmee.web.entity.Couple;



public interface CoupleService {
	//Ŀ������
	public Couple getCoupleInfo(int id);
	//Ŀ�õ��
	public int regInfo(Couple couple, Date sloveDate, int id);
	//�������� ���
	public int proposeCancel(int pId);
	//�������� ����
	public int proposeAccept(int coupleId, int uId);
	//�������� ����
	public int prposeRefuse(int coupleId, int uId);

}