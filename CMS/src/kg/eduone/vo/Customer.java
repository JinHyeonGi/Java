package kg.eduone.vo;

public class Customer {
	// 멤버
	private String name;
	private int age;
	private String tel;
	private String address;
	
	// 생성자
	public Customer() {
		
	}	// end Customer()
	public Customer(String name, int age, String tel, String address) {
		super();
		this.name = name;
		this.age = age;
		this.tel = tel;
		this.address = address;
	}	// end Customer(String name, int age, String tel, String address)

	// 메서드
	public String getName() {
		return name;
	}	// end String getName()
	public void setName(String name) {
		this.name = name;
	}	// end void setName(String name)
	public int getAge() {
		return age;
	}	// end int getAge()
	public void setAge(int age) {
		this.age = age;
	}	// end void setAge(int age)
	public String getTel() {
		return tel;
	}	// end String getTel()
	public void setTel(String tel) {
		this.tel = tel;
	}	// end void setTel(String tel)
	public String getAddress() {
		return address;
	}	// end String getAddress()
	public void setAddress(String address) {
		this.address = address;
	}	// end void setAddress(String address)
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer(name);
		sb.append(" : ");
		sb.append(age);
		sb.append(" : ");
		sb.append(tel);
		sb.append(" : ");
		sb.append(address);
		return sb.toString();
	}	// end String toString()
}	// end class Customer