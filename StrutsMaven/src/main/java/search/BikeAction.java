package search;

import org.apache.log4j.Logger;
import com.opensymphony.xwork2.ActionSupport;
public class BikeAction extends ActionSupport {
	
	private static final Logger log = Logger.getLogger(BikeAction.class);
	private String tabIndex;
	
	public String  newBike() {
		log.info("inside newBike method");
		this.setTabIndex("home");
		return SUCCESS;
		
	}
	
	public String  bikeDetails() {
		log.info("inside bikeDetails method");
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
