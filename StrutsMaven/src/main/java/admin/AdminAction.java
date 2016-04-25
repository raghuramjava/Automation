package admin;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

public class AdminAction extends ActionSupport implements Preparable{
	private String tabIndex;
	
	public String execute() {
		return SUCCESS;
	}

	@Override
	public void prepare() throws Exception {
		this.setTabIndex("Admin");
		
	}

	public String getTabIndex() {
		return tabIndex;
	}

	public void setTabIndex(String tabIndex) {
		this.tabIndex = tabIndex;
	}

}
