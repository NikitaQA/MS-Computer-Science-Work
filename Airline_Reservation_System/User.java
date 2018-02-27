package domain;

import java.sql.Date;

public class User {
	private int id;
    private String firstName;
    private String lastName;
    private Date dob;
    private String email;
    private String skill;
    private String address;
    private String qualification;
    private String ph_no;
    private String password;
    java.util.Date today;
  //  private boolean isValid;
    
    
	public User(int id, String firstName, String lastName,Date dob,String email,
		String skill, String address, String qualification, String ph_no,
		String password) {
	this.id = id;
	this.firstName = firstName;
	this.lastName = lastName;
	this.dob = dob;
	this.email = email;
	this.skill = skill;
	this.address = address;
	this.qualification = qualification;
	this.ph_no = ph_no;
	this.password = password;
	this.today = new java.util.Date();
}
	
	
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public Date getDob() {
		return dob;
	}
    
	public Date getDob1() {
	    return new java.sql.Date(today.getTime());
	}
	
	public void setDob(Date dob) {
		this.dob = dob;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getSkill() {
		return skill;
	}



	public void setSkill(String skill) {
		this.skill = skill;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getQualification() {
		return qualification;
	}



	public void setQualification(String qualification) {
		this.qualification = qualification;
	}



	public String getph_no() {
		return ph_no;
	}



	public void setph_no(String ph_no) {
		this.ph_no = ph_no;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public boolean hasPasswd(String passwd){
		if(password.equals(passwd)){
			return true;
		}else{
			return false;
		}
	}



	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName="
				+ lastName + ", dob=" + dob + ", email=" + email + ", skill="
				+ skill + ", address=" + address + ", qualification="
				+ qualification + ", ph_no=" + ph_no + ", password="
				+ password + "]";
	}
	
	
	
    
        

}

