package general;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.log4j.Logger;
public class BaseAction extends ActionSupport {
	
	private String tabIndex;
	
	private static final Logger log = Logger.getLogger(BaseAction.class);
	
	public String execute (){
	log.info("Inside execute method");
	return 	SUCCESS;
	}
	
	public String login (){
		log.info("Inside login method");
		this.setTabIndex("home");
		log.error("TESTING ERROR");
		return 	SUCCESS;
		}

	public String getTabIndex() {
		return tabIndex;
	}

	public void setTabIndex(String tabIndex) {
		this.tabIndex = tabIndex;
	}

}
