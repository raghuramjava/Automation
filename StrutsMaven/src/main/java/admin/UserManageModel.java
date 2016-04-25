package admin;

import java.util.List;

import mapping.Users;

public class UserManageModel {
	
	private List<Users[]> userList;
	
	private String admUser;
	private String  chkMail;
	private String fname;
	private String lname;
	private String email;
	private String password;
	private String userId;
	private String deleteUsers;
	
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Users[]> getUserList() {
		return userList;
	}

	public void setUserList(List<Users[]> userList) {
		this.userList = userList;
	}

	public String getAdmUser() {
		return admUser;
	}

	public void setAdmUser(String admUser) {
		this.admUser = admUser;
	}

	public String getChkMail() {
		return chkMail;
	}

	public void setChkMail(String chkMail) {
		this.chkMail = chkMail;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getDeleteUsers() {
		return deleteUsers;
	}

	public void setDeleteUsers(String deleteUsers) {
		this.deleteUsers = deleteUsers;
	}

}
