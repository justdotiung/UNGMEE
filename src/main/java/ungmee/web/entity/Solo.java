package ungmee.web.entity;

public class Solo {
	/*
	 * COMMENT ON COLUMN SOLO.ID IS 'ȸ�����̵�';
	 * COMMENT ON COLUMN SOLO.BIRTHDAY IS '����4��';
	 * COMMENT ON COLUMN SOLO.GENDER IS '���� 1.male 2.female';
	 * COMMENT ON COLUMN SOLO.C_STATE IS '1Ŀ�� 0Ŀ�ý�û�� -1�ַ�';
	 */ 
	private int id;
    private int birthday;
    private int gender;
    private int cState;
	
    public Solo() {}
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBirthday() {
		return birthday;
	}
	public void setBirthday(int birthday) {
		this.birthday = birthday;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public int getcState() {
		return cState;
	}
	public void setcState(int cState) {
		this.cState = cState;
	}
    
    
}
