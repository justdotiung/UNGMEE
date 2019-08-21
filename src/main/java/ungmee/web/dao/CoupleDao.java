package ungmee.web.dao;

import java.util.List;

import ungmee.web.entity.Couple;

public interface CoupleDao {
//CoupleRepository (��������)
	public Couple get(int id);//�ش� ���̵� Ŀ��  ����
	public Couple get(int id, int pId);//�ش� Ŀ�þ��̵� ����������̵� Ŀ������
	public Couple getUser(int id);//�ش����� Ŀ�� ����
	
	public int insert(Couple couple);
	public int delete(int proposeId);
	public int edit(Couple couple);
	
	public List<Couple> getProposeList(int accepterId);
	public List<Couple> getProposeList(int accepterId,int state);
	
	public int getNewProposeCount(int accepterId);
}
