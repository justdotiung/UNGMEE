package com.ungmee.web.dao;

import java.util.List;

import com.ungmee.web.entity.Couple;

public interface CoupleDao {
//CoupleRepository (��������)
	public Couple get(int id);//�ش� ���̵� Ŀ��  ����
	public Couple getUser(int id);//�ش����� Ŀ�� ����
	public Couple getSender(int id);//����������̵��� Ŀ�� ����
	
	public int insert(Couple couple);
	public int update(Couple couple);
	public int delete(int coupleId);
	
	public List<Couple> getProposeList(int accepterId);
	public List<Couple> getProposeList(int accepterId,int state);
	
	public int getNewProposeCount(int accepterId);
}
