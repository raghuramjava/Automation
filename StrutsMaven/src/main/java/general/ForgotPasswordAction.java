package general;

import com.opensymphony.xwork2.ActionSupport;

public class ForgotPasswordAction extends ActionSupport{
	private String email;
	
	ForgotPasswordDao fDao;
	
	public String execute(){
		return SUCCESS;
	}
	
	public String authUserAndSendMail(){
		try {
			fDao = new ForgotPasswordDao();
			System.out.println(getEmail());
			String chkMail = fDao.authenticateEmail(getEmail());
			if(chkMail.equals("invaliedmail")){
				addActionError("This Email address is not registered in the System");
				return INPUT;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
