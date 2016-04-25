package reservation;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.xml.crypto.dsig.spec.ExcC14NParameterSpec;

import org.apache.struts2.ServletActionContext;

import mapping.PriceInventory;

import admin.AdminAction;

import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class ReservationManageAction extends AdminAction implements ModelDriven<ReservationManageModel> {
	
	private ReservationManageModel  rModel  = new ReservationManageModel();
	private ReservationManageDao rDao ;
	@Override
	public void prepare() throws Exception {
		setTabIndex("Admin");
		
	}
	
	public String getPriceInventoryDetails(){
		List<Object[]> invList  = new ArrayList<Object[]>();
		Map<String,String> dateMap  = new LinkedHashMap<String, String>();
		
		try {
			
			rDao = new ReservationManageDao();
			
			int currYear = Calendar.getInstance().get(Calendar.YEAR);
			int currMonth = Calendar.getInstance().get(Calendar.MONTH);
			
			invList = rDao.getInventoryList(currYear,currMonth+1);
			getModel().setMonth(String.valueOf(currMonth));
			getModel().setYear(String.valueOf(currYear));
			
			Map<String, String>	yearMap = new LinkedHashMap<String, String>();
			Map<String, String>	monthMap = new LinkedHashMap<String, String>();
			yearMap = rDao.getYear();	
			monthMap =	rDao.getMonth();
			getModel().setYearMap(yearMap);
			getModel().setMonthMap(monthMap);
			
			
			if(invList == null  || invList.size() ==0 ){
			
			
		
			
			
			Calendar cal = Calendar.getInstance();
			cal.set(Calendar.YEAR,Calendar.getInstance().get(Calendar.YEAR));
		    cal.set(Calendar.MONTH,Calendar.getInstance().get(Calendar.MONTH));
		    cal.set(Calendar.DAY_OF_MONTH, 1);
		    int maxDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		    SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		    System.out.print(df.format(cal.getTime()));
		    getModel().setNumberOfDays(String.valueOf(maxDay));
		    for (int i = 0; i < maxDay; i++) {
		        cal.set(Calendar.DAY_OF_MONTH, i + 1);
		        System.out.print(", " + df.format(cal.getTime()));
		        dateMap.put("input-"+i, String.valueOf(df.format(cal.getTime())));
		        
		     }
			}else{
				getModel().setNumberOfDays(String.valueOf(invList.size()));
			}
			
			getModel().setInvAarray(invList);
			getModel().setDateMap(dateMap);
			
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
		
		return SUCCESS;
	}
	
	
	public String getPriceInventoryDetailsNewDate(){
		List<Object[]> invList  = new ArrayList<Object[]>();
		Map<String,String> dateMap  = new LinkedHashMap<String, String>();
		
		try {
			
			rDao = new ReservationManageDao();
			HttpServletRequest request = ServletActionContext.getRequest();
			int currYear =Integer.parseInt(request.getParameter("year"));
			int currMonth =Integer.parseInt(request.getParameter("month"));
			
			Map<String, String>	yearMap = new LinkedHashMap<String, String>();
			Map<String, String>	monthMap = new LinkedHashMap<String, String>();
			yearMap = rDao.getYear();	
			monthMap =	rDao.getMonth();
			getModel().setYearMap(yearMap);
			getModel().setMonthMap(monthMap);
			
			invList = rDao.getInventoryList(currYear,currMonth+1);
			
			if(invList == null  || invList.size() ==0 ){
				
				
				
				
				
				Calendar cal = Calendar.getInstance();
				cal.set(Calendar.YEAR,currYear);
			    cal.set(Calendar.MONTH,currMonth);
			    cal.set(Calendar.DAY_OF_MONTH, 1);
			    int maxDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
			    SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
			    System.out.print(df.format(cal.getTime()));
			    getModel().setNumberOfDays(String.valueOf(maxDay));
			    for (int i = 0; i < maxDay; i++) {
			        cal.set(Calendar.DAY_OF_MONTH, i + 1);
			        System.out.print(", " + df.format(cal.getTime()));
			        dateMap.put("input-"+i, String.valueOf(df.format(cal.getTime())));
			        
			     }
				}

			getModel().setDateMap(dateMap);
			getModel().setMonth(String.valueOf(currMonth));
			getModel().setYear(String.valueOf(currYear));
			getModel().setInvAarray(invList);
			
			
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
		
		return SUCCESS;
	}
	
	public String savePriceInventoryAction(){
		try{
			String actionMessage  = "";
			rDao = new ReservationManageDao();
			actionMessage = rDao.savePriceInventoryDetails(rModel);
			addActionMessage(actionMessage);
			rModel.setYear(rModel.getYear());
			rModel.setMonth(rModel.getMonth());
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return SUCCESS;
	}

	
	public String updatePriceInventoryAction(){
		try{
			String actionMessage  = "";
			rDao = new ReservationManageDao();
			actionMessage = rDao.updatePriceInventoryDetails(rModel);
			addActionMessage(actionMessage);
			rModel.setYear(rModel.getYear());
			rModel.setMonth(rModel.getMonth());
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	
	@Override
	public ReservationManageModel getModel() {
		// TODO Auto-generated method stub
		return rModel;
	}
	

}
