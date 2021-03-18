package kg.eduone.vo;

public class Customer {
	// 멤버필드
	private String name;
	private String jumin;
	private String tel;
	private boolean gender;
	private String hobby;
	
	// 생성자
	public Customer() {}
	public Customer(String name, String jumin, String tel, boolean gender, String hobby) {
		super();
		this.name = name;
		this.jumin = jumin;
		this.tel = tel;
		this.gender = gender;
		this.hobby = hobby;
	}

	// 메서드
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJumin() {
		return jumin;
	}
	public void setJumin(String jumin) {
		this.jumin = jumin;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	
	// 오버라이드
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer("       ");
		sb.append(name);
		sb.append(" : ");
		sb.append(isGender() ? "남" : "여");
		return sb.toString();
	}
}
