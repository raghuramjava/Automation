package reservation;

import java.util.ArrayList;
import java.util.List;

import mapping.Reservation;

import com.opensymphony.xwork2.ModelDriven;

public class SearchReservationAction  extends ReservationModuleAction implements ModelDriven<SearchReservationModel>{
	
	private  SearchReservationModel searchModel = new SearchReservationModel();
	private  SearchReservationDao searchDao;
	public String  execute(){
	return SUCCESS;	
	}
     
	public String getSearchResult(){
		try {
			List<Reservation[]> resList = new ArrayList<Reservation[]>();
			searchDao = new SearchReservationDao();
			resList = searchDao.getSerachResults(searchModel);
			getModel().setReservationList(resList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	
	@Override
	public SearchReservationModel getModel() {
		// TODO Auto-generated method stub
		return searchModel;
	}

}
