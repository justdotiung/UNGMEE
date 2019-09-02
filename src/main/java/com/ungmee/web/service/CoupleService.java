package com.ungmee.web.service;



import java.util.Date;
import java.util.Map;

import com.ungmee.web.entity.Couple;



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
	public int messageUpdate(String message, int id);
	//������ ����
	public int editProfile(int id, String fileName);
	//Ŀ�� �������
	public int breakUp(int id);

}