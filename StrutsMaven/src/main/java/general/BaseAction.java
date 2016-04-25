package general;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import mapping.Users;
public class BaseAction extends ActionSupport implements ModelDriven<BaseModel> ,SessionAware {
	
	
	private Map httpsession;
	
	/**
	 * A getter method for the current session.
	 * @return The current session.
	 */
	    public Map getSession() {
	        return httpsession;
	    }
	/**
	 * A setter method for the current session.
	 * @param session The current session.
	 */
	    public void setSession(Map session) {
	        this.httpsession = session;
	    }
	
	
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
			Users  user =(Users) baseDao.authenticateUser(baseModel);
			if(user == null){
				addActionError("Invalid credentials");
				return INPUT;
			}else{
				httpsession  =  ActionContext.getContext().getSession();
				httpsession.put("userFname", user.getFname().toUpperCase());
				httpsession.put("userLname", user.getLname().toUpperCase());
				httpsession.put("loginId",user.getLoginId());
				httpsession.put("admin",String.valueOf(user.getAdminflag()));
				
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
			addActionError("Not able to Connect to database. Please contact admin");
			return INPUT;
		}
		
		log.error("TESTING ERROR");
		return 	SUCCESS;
		}

	public String getTabIndex() {
		return tabIndex;
	}
	
	public String home(){
		setTabIndex("home");
		return SUCCESS;
	}

	public void setTabIndex(String tabIndex) {
		this.tabIndex = tabIndex;
	}
	
	
	
	public String changePassword() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String message  = "";
		String userId = request.getParameter("loginId");
		String oldPassword = request.getParameter("oldPwd");
		String newPassword  = request.getParameter("newPwd");
		baseDao = new BaseDao();
		message =baseDao.paaswordChange(userId,oldPassword, newPassword);
		response.setHeader("Pragma", "no-cache");
		response.setContentType("text/text");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.getWriter().write(message);
		response.getWriter().close();
		return null;
	}
	
	
	
	public String getReservationDetails(){
		try{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HashMap<Object, Object[]> dateMap = new HashMap<Object, Object[]>();
		baseDao = new BaseDao();
		 String startDate = request.getParameter("start");
		 String endDate  =  request.getParameter("end");
		 long longStartDate = Long.parseLong(startDate);
		 long  longEndDate  = Long.parseLong(endDate);
		 Date dateEndDate =  new Date(longEndDate*1000L);
		 Date datestartDate =  new Date(longStartDate*1000L);
	
		 Calendar cal1 = Calendar.getInstance();
		
		 cal1.setTime(datestartDate);
		 cal1.add(Calendar.DATE, -1);
		 
		 Calendar cal2 = Calendar.getInstance();
		 cal2.setTime(dateEndDate);
		 cal2.add(Calendar.DATE, -1);
		 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
		 StringBuffer message  = new StringBuffer();
		 message.append("<events>");
		 while (cal1.getTime().before(cal2.getTime())) {
			    cal1.add(Calendar.DATE, 1);
			   // System.out.println(df.format(cal1.getTime()));
			    
			    String dateDeatils  = baseDao.getDayResDtails(df.format(cal1.getTime()),request);
			    //System.out.println(dateDeatils);
			    message.append(dateDeatils);
			    
			}
		     message.append("</events>");
		    // System.out.println(" total Xml ="+message);
		     response.setHeader("Pragma", "no-cache");
		    response.setContentType("application/xml");
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expires", 0);
			response.getWriter().write(message.toString());
			response.getWriter().close();
			
		
		 
		
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	public String logoff() throws Exception{
		httpsession = ActionContext.getContext().getSession();
		httpsession.remove("userFname");
		httpsession.remove("userLname");
		httpsession.remove("loginId");
		httpsession.remove("admin");
		httpsession.clear();
        return SUCCESS;
    }

	@Override
	public BaseModel getModel() {
		// TODO Auto-generated method stub
		return baseModel ;
	}

}
