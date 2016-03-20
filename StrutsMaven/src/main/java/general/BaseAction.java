package general;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import newBike.BikeModel;

import org.apache.log4j.Logger;
public class BaseAction extends ActionSupport implements ModelDriven<BaseModel>{
	
	private String tabIndex;
	
	private BaseDao baseDao;
	private static final Logger log = Logger.getLogger(BaseAction.class);
	private BaseModel baseModel = new BaseModel();
	
	public String execute (){
	log.info("Inside execute method");
	return 	SUCCESS;
	}
	
	public String login (){
		log.info("Inside login method");
		this.setTabIndex("home");
		try{
			baseDao = new BaseDao();
			String authUser = baseDao.authenticateUser(baseModel);
			if(authUser.equals("invalidUser")){
				return INPUT;
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		log.error("TESTING ERROR");
		return 	SUCCESS;
		}

	public String getTabIndex() {
		return tabIndex;
	}

	public void setTabIndex(String tabIndex) {
		this.tabIndex = tabIndex;
	}

	@Override
	public BaseModel getModel() {
		// TODO Auto-generated method stub
		return baseModel ;
	}

}
