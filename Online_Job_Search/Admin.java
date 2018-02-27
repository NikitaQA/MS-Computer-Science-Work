package domain;

public class Admin {

	private int admin_id;
	private String name;
	private String password;
	
public Admin(String name,String password){
	this.admin_id=admin_id;
	this.name=name;
	this.password=password;	
}
public int getId() {
	return admin_id;
}

public void setId(int admin_id) {
	this.admin_id = admin_id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

@Override
public String toString() {
	return "Admin [id=" + admin_id + ", name=" + name + ", password=" + password
			+ "]";
}

/*public boolean hasPasswd(String passwd){
	if(password.equals(passwd))return true;
	else return false;
}*/
}

