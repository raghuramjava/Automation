package reservation;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.LinkedHashMap;
import java.util.List;



import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Connection.HibernateUtill;

import mapping.PriceInventory;



public class ReservationManageDao {
	
	
	public List<Object[]> getInventoryList(int year ,int month){
		List<Object[]> invList = new ArrayList<Object[]>();
		Session session = HibernateUtill.getSession();
		try {
			 Query query = session.createQuery("select id,to_char(priceDate,'dd-mm-yyyy'),adultPrice,childPrice,seats from PriceInventory  where YEAR(priceDate) = :year and MONTH(priceDate) =:month order by priceDate ");
			 query.setParameter("year", year);
			 query.setParameter("month", month);
			 invList = query.list();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return invList;
	}
	
	public String savePriceInventoryDetails(ReservationManageModel rModel) {
		String statusMessage  =  "Opeartion Failed";
		Session session = HibernateUtill.getSession();
		Transaction tx  = session.getTransaction();
		try {
			List <String> dateList = rModel.getDates();
			List <String> adultPriceList = rModel.getAdultPrices();
			List <String> childPriceList = rModel.getChildPrices();
			List <String> seats          =  rModel.getSeats();
			tx.begin();
			for(int index  = 0 ; index < dateList.size() ; index++){
				PriceInventory prInv = new PriceInventory();
				prInv.setAdultPrice(Float.parseFloat(adultPriceList.get(index)));
				prInv.setChildPrice(Float.parseFloat(childPriceList.get(index)));
				prInv.setSeats(Integer.parseInt(seats.get(index)));
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
				prInv.setPriceDate(sdf.parse(dateList.get(index)));
				session.save(prInv);
			}
			tx.commit();
			statusMessage ="Price Details Saved Successfully";
			
		} catch (Exception e) {
		  e.printStackTrace();
		}finally{
			session.close();
		}
		return statusMessage;
	}
	
	public String updatePriceInventoryDetails(ReservationManageModel rModel) {
		String statusMessage  =  "Opeartion Failed";
		Session session = HibernateUtill.getSession();
		Transaction tx  = session.getTransaction();
		
		try {
			List <String> dateList = rModel.getDates();
			List <String> adultPriceList = rModel.getAdultPrices();
			List <String> childPriceList = rModel.getChildPrices();
			List <String> seats          =  rModel.getSeats();
			List  <String> priIds = rModel.getPriIds();
			tx.begin();
			for(int index  = 0 ; index < dateList.size() ; index++){
				PriceInventory prInv = (PriceInventory) session.get(PriceInventory.class,Integer.parseInt(priIds.get(index)));
				prInv.setAdultPrice(Float.parseFloat(adultPriceList.get(index)));
				prInv.setChildPrice(Float.parseFloat(childPriceList.get(index)));
				prInv.setSeats(Integer.parseInt(seats.get(index)));
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
				prInv.setPriceDate(sdf.parse(dateList.get(index)));
				session.update(prInv);
			}
			tx.commit();
			statusMessage ="Price Details Saved Successfully";
			
		} catch (Exception e) {
		  e.printStackTrace();
		}finally{
			session.close();
		}
		return statusMessage;
	}
	
	public LinkedHashMap<String, String> getYear() throws Exception {
		 LinkedHashMap<String, String>  yearMap = new  LinkedHashMap<String, String>();
		 yearMap.put("2016", "2016");
		 yearMap.put("2017", "2017");
		 yearMap.put("2018", "2018");
		 yearMap.put("2019", "2019");
		 yearMap.put("2020", "2020");
		 
		 return yearMap;
		
	}
	
	
	public LinkedHashMap<String, String> getMonth() throws Exception {
		LinkedHashMap<String, String>  monthMap = new  LinkedHashMap<String, String>();
		 monthMap.put("0", "January");
		 monthMap.put("1", "February");
		 monthMap.put("2", "March");
		 monthMap.put("3", "April");
		 monthMap.put("4", "May");
		 monthMap.put("5", "June");
		 monthMap.put("6", "July");
		 monthMap.put("7", "August");
		 monthMap.put("8", "September");
		 monthMap.put("9", "October");
		 monthMap.put("10", "November");
		 monthMap.put("11", "December");
		 
		 
		 return monthMap;
		
	}

}
