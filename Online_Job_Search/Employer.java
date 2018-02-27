package domain;

public class Employer {

	private int id;
	private String companyName;
	private String email;
	private String address;
	private String password;
	private String ph_no;
	
public Employer(int id,String companyName, String address,String email,String password,String ph_no){
	this.id=id;
	this.companyName=companyName;
	this.address=address;
	this.email=email;
	this.password=password;
	this.ph_no=ph_no;
}
	
public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}



public String getCompanyName() {
	return companyName;
}

public void setName(String name) {
	this.companyName = name;
}


public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getph_no() {
	return ph_no;
}

public void setph_no(String ph_no) {
	this.ph_no = ph_no;
}

public boolean hasPasswd(String passwd){
	if(password.equals(passwd)) return true;
	else return false;
}

@Override
public String toString() {
	return "Employer [id=" + id + ", companyName=" + companyName + ", email="
			+ email + ", address=" + address + ", password=" + password
			+ ", ph_no=" + ph_no + "]";
}




}
