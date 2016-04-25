package mapping;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name ="email_config")
public class EmailConfig {
	
	@Id 
	@Column(name = "id")
	private int id;
	
	@Column(name="email")
	private String email;
	@Column(name="email_host")
	private String host;
	@Column(name="email_password")
	private String password;
	@Column(name="port")
	private String port;
	@Column(name="email_id")
	private String emailId;
	
	
	public int getId() {
	      return id;
	   }
	   public void setId( int id ) {
	      this.id = id;
	   }

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

}
