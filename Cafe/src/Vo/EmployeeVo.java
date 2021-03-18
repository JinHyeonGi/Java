package Vo;

public class EmployeeVo {
	private String employee_Id;
	private String emp_Name;
	private String Password;
	private String E_mail;
	private String Gender;
	private String Phone_number;

	@Override
	public String toString() {
		return "EmployeeVo [employee_Id=" + employee_Id + ", emp_Name=" + emp_Name + ", Password=" + Password
				+ ", E_mail=" + E_mail + ", Gender=" + Gender + ", Phone_number=" + Phone_number + "]";
	}

	public String getEmployee_Id() {
		return employee_Id;
	}

	public void setEmployee_Id(String employee_Id) {
		this.employee_Id = employee_Id;
	}

	public String getEmp_Name() {
		return emp_Name;
	}

	public void setEmp_Name(String emp_Name) {
		this.emp_Name = emp_Name;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getE_mail() {
		return E_mail;
	}

	public void setE_mail(String e_mail) {
		E_mail = e_mail;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public String getPhone_number() {
		return Phone_number;
	}

	public void setPhone_number(String phone_number) {
		Phone_number = phone_number;
	}
}