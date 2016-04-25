package mapping;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name ="users")
public class Users {
	@Column(name="id")
	@Id @SequenceGenerator(name = "UserSequence", sequenceName = "seq_users", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="UserSequence")
	private int userId;
	
	@Column(name="admin")
	private boolean adminflag;
	
	@Column(name="email")
	private String email;
	@Column(name="first_name")
	private String fname;
	@Column(name="last_name")
	private String lname;
	
	@Column(name="login_id")
	private String loginId;
	@Column(name="password")
	private String password;
	
	@Column(name="active")
	private boolean active;
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public boolean getAdminflag() {
		return adminflag;
	}

	public void setAdminflag(boolean adminflag) {
		this.adminflag = adminflag;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
