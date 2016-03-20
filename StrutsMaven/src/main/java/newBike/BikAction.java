package newBike;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class BikAction extends ActionSupport implements ModelDriven<BikeModel>{
	BikeModel bikeModel;
	BikeDao bikeDao;
	@Override
	public BikeModel getModel() {
		// TODO Auto-generated method stub
		bikeModel = new BikeModel();
		return  bikeModel;
	}
	
	public String execute() {
		 bikeDao= new BikeDao();
		 int result = bikeDao.saveBike(bikeModel);
	return SUCCESS;	
	}
	

}
