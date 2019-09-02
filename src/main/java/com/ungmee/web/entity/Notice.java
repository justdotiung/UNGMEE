package com.ungmee.web.entity;

import java.sql.Date;

public class Notice {
//COMMENT ON COLUMN NOTICE.ID IS '���̵�';
//COMMENT ON COLUMN NOTICE.WRITER_ID IS '�����ھ��̵�,�г���';
//COMMENT ON COLUMN NOTICE.TITLE IS '����';
//COMMENT ON COLUMN NOTICE.CONTENT IS '����';
//COMMENT ON COLUMN NOTICE.REGDATE IS '�����';
//COMMENT ON COLUMN NOTICE.CATEGORY_ID IS 'ī�װ� 1.ȸ���������� 2.���޻��������';

	private int id;
	private int writerId;
	private String title;
	private String content;
	private Date regdate;
	private int categoryId;
	private int hit;

	public Notice() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getWriterId() {
		return writerId;
	}

	public void setWriterId(int writerId) {
		this.writerId = writerId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	@Override
	public String toString() {
		return "Notice [id=" + id + ", writerId=" + writerId + ", title=" + title + ", content=" + content
				+ ", regdate=" + regdate + ", categoryId=" + categoryId + ", hit=" + hit + "]";
	}
	
	

}
