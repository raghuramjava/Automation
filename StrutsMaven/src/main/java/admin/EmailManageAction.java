package admin;

import java.util.ArrayList;
import java.util.List;

import general.BaseModel;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import mapping.EmailConfig;

public class EmailManageAction extends AdminAction implements ModelDriven<EmailManageModel> {
	private EmailManageModel emailModel = new EmailManageModel();
	@Override
	public EmailManageModel getModel() {
		// TODO Auto-generated method stub
		return emailModel;
	}
	
	public String emailConfig(){
		setTabIndex("Admin");
		try{
			EmailManageDao emailDao = new EmailManageDao();
			List<EmailConfig> emailList = emailDao.checkEmailConfigExust();
			if(emailList.size() > 0){
				EmailConfig econfig = emailList.get(0);
				emailModel.setEmail(econfig.getEmail());
				emailModel.setHost(econfig.getHost());
				emailModel.setPassword(econfig.getPassword());
				emailModel.setPort(econfig.getPort());
				emailModel.setEmailId(econfig.getEmailId());
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String saveEmailConfig (){
		try {
			EmailManageDao emailDao = new EmailManageDao();
			emailDao.deleteExistEmailConfig();
			emailDao.saveEmailConfig(getModel());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	
}
