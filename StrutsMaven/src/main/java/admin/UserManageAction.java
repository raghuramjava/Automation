package admin;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.HibernateException;

import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import org.apache.struts2.ServletActionContext;

import mapping.Users;

public class UserManageAction  extends AdminAction implements ModelDriven<UserManageModel>,Preparable {
	private UserManageModel uModel= new UserManageModel();

	@Override
	public UserManageModel getModel() {
		// TODO Auto-generated method stub
		return uModel;
	}
	
	
	
	public String execute(){
		try {
			setTabIndex("Admin");
			
			UserManageDao userDao  = new UserManageDao(); 
			List <Users[]> usersList = new ArrayList<Users[]>();
			usersList = userDao.getUsersList();
			System.out.println(usersList.size());
			uModel.setUserList(usersList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	return SUCCESS;	
	}
	
	public String newUser(){
		setTabIndex("Admin");
		return SUCCESS;	
	}
	
	public String saveUser(){
		try{
		setTabIndex("Admin");
		System.out.println(getModel().getChkMail());
		UserManageDao userDao  = new UserManageDao(); 
		HttpServletRequest request = ServletActionContext.getRequest();
		String contextPath  = request.getRealPath(File.pathSeparator);
		userDao.saveNewUser(getModel(),contextPath);
		addActionMessage("User Saved Successfully");
		
		}catch(HibernateException e){
			addActionError("Operation Failed");
			return INPUT;
		}
		
		catch(Exception e){
			e.printStackTrace();
		}
		return SUCCESS;	
	}
	
	public String deleteUsers(){
		try {
			UserManageDao userDao  = new UserManageDao();
			userDao.deleteUsers(getModel());
			addActionMessage("User Deleted Successfully");
			
		}catch(HibernateException e){
			addActionError("Operation Failed");
			return INPUT;
		} catch (Exception e) {
			e.printStackTrace();
		}
	return SUCCESS;	
	}

}
