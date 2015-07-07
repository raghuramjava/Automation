package general;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport {
	
	private String tabIndex;
	
	public String execute (){
	//System.out.println("Testing debugg mode");
	return 	SUCCESS;
	}
	
	public String login (){
		this.setTabIndex("home");
		return 	SUCCESS;
		}

	public String getTabIndex() {
		return tabIndex;
	}

	public void setTabIndex(String tabIndex) {
		this.tabIndex = tabIndex;
	}

}
