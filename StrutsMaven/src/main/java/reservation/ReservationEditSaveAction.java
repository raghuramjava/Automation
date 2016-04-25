package reservation;



import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mapping.PriceInventory;
import mapping.Reservation;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class ReservationEditSaveAction extends ReservationModuleAction implements Preparable,ModelDriven<ReservationEditSaveModel> {
     
	private  ReservationEditSaveModel rModel = new ReservationEditSaveModel();
	private ReservationEditSaveDao rDao;
	@Override
	public ReservationEditSaveModel getModel() {
		return rModel;
	}
	
	public String execute(){
		return SUCCESS;
	}

	public String saveReservation(){
		try {
			
			rDao = new ReservationEditSaveDao();
			Map session = (Map) ActionContext.getContext().get("session");
			String actionMessage = rDao.SaveReservation(rModel, session);
			addActionMessage(actionMessage);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	
	public String  getReservationDetails(){
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			String resId = request.getParameter("resId");
			rDao = new ReservationEditSaveDao();
			Reservation reservation = rDao.getResDetails(resId);
			rModel.setReservation(reservation);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	
	public String updateReservation(){
		try {
			String actionMessage ="";
			 rDao = new ReservationEditSaveDao();
			 HttpServletRequest request = ServletActionContext.getRequest();
			 Map session = (Map) ActionContext.getContext().get("session");
			 actionMessage = rDao.updateReservation(rModel, session);
			 addActionMessage(actionMessage);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	  return SUCCESS;
	}
	
	public String cancelReservation(){
		try {
			String actionMessage ="";
			 rDao = new ReservationEditSaveDao();
			 HttpServletRequest request = ServletActionContext.getRequest();
			 String resId =  request.getParameter("resId");
			 actionMessage = rDao.cancelReservation(resId);
			 addActionMessage(actionMessage);
			 getModel().setResId(resId);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	
	
	
	public String getInventoryDetails() throws Exception{
		 HttpServletRequest request = ServletActionContext.getRequest();
		 HttpServletResponse response = ServletActionContext.getResponse();
		 String message  = "";
		 String reservationDate = request.getParameter("rDate");
		 rDao = new ReservationEditSaveDao();
		 Map<String, String> options = new LinkedHashMap<String, String>();
		 PriceInventory inventory = rDao.getInventoryDetails(reservationDate);
		 if(inventory == null) {
			 options.put("message", "Please Set Seats for this Date");
			 options.put("totalSeats","0");
		 }else {
			 options.put("message", "success"); 
			 options.put("totalSeats",String.valueOf(inventory.getSeats()));
		 }
		 String seats  = rDao.getReservedSeats(reservationDate);
		 options.put("reservedSeats", seats);
		String json = new Gson().toJson(options);
		response.setHeader("Pragma", "no-cache");
		response.setContentType("application/json");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.getWriter().write(json);
		response.getWriter().close();
		return null;
	}
}
