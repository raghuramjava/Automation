package reservation;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

public class ReservationModuleAction extends ActionSupport implements Preparable {
	
	private String tabIndex;
	
	public String execute(){
		return SUCCESS;
	}

	public String getTabIndex() {
		return tabIndex;
	}

	public void setTabIndex(String tabIndex) {
		this.tabIndex = tabIndex;
	}

	@Override
	public void prepare() throws Exception {
		setTabIndex("reservation");
		
	}

}
