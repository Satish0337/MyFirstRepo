package model;

public class Profile {
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContactno() {
		return contactno;
	}
	public void setContactno(String contactno) {
		this.contactno = contactno;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPswd() {
		return pswd;
	}
	public void setPswd(String pswd) {
		this.pswd = pswd;
	}
	private String email;
	private String name;
	private String contactno;
	private String address;
	private String pswd;
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	private String role="user";

	
	
	
	
}
