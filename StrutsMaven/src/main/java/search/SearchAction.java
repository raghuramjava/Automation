package search;

import general.BaseAction;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.log4j.Logger;
public class SearchAction extends ActionSupport{
	
	private static final Logger log = Logger.getLogger(BaseAction.class);
	private String tabIndex;
	
	public String  searchBike() {
		log.info("inside searchBike method");
		this.setTabIndex("home");
		return SUCCESS;
		
	}
	public String getTabIndex() {
		return tabIndex;
	}
	public void setTabIndex(String tabIndex) {
		this.tabIndex = tabIndex;
	}

}
