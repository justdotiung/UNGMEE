package com.ungmee.web.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ungmee.web.entity.Couple;
import com.ungmee.web.entity.SoloView;

@Service
public interface PushService {

	//������� ����
	//public SoloView getSendUserDetails(int id, int pId);
	//���� ������ �������� ����
	public Couple getProposeDetail(int id);
	//���ο� �˶� ����
	public int getNewPushCount(int userNum);
	//�˶� ����Ʈ
	public List<Map<String, Object>> getList(int accepterId);
	//���ο� �˶� ����Ʈ
	public List<Map<String,Object>> getNewPushList(int userNum);
	//�˶� ���� ����
	public Map<String,Object> getPushDetails(String type, int id);
}
