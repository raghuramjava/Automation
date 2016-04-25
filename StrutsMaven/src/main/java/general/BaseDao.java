package general;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import reservation.SearchReservationModel;

import mapping.PriceInventory;
import mapping.Users;

import Connection.HibernateUtill;
import mapping.Reservation;

public class BaseDao {
	
	
	public Object authenticateUser(BaseModel baseModel){
		String vaildUser = "invalidUser";
		Session session = HibernateUtill.getSession();
		try{
			
			Query query = session.createQuery("from Users where loginId = :id and password = :pwd and active =:active ");
			query.setParameter("id", baseModel.getUserName());
			query.setParameter("pwd", baseModel.getPassword());
			query.setParameter("active", true);
			
			Users user = (Users)query.uniqueResult();
			return user;
		}catch(Exception e){
			return null;
		}
		finally{
			session.close();
		}
	}
	
	
	public HashMap<Object, Object[]> getReservedSeats(Date startDate,Date endDate){
		 Session session = HibernateUtill.getSession();
		 try {
			 HashMap<Object, Object[]> dateMap = new HashMap<Object, Object[]>();
			  Query query = session.createQuery("select a.priceDate,a.seats as total,b.reserved_seats,(a.seats-b.reserved_seats) as availble from " +
			    		" ((select priceDate,seats  from  PriceInventory where priceDate between :startDate and :endDate order by priceDate ) as a LEFT JOIN " +
			    		" (select sum (noOfPesons) as reserved_seats,reservation_date from Reservation where reservation_date  between :startDate and :endDate and status ='A' group by reservation_date) as b " +
			    		" ON a.priceDate =b.reservation_date)");
			  
				query.setParameter("startDate",startDate );
				query.setParameter("endDate",endDate);
				List<Object []> monthResDetails = query.list();
				for(Object [] tempObject : monthResDetails){
					dateMap.put(tempObject[0], tempObject);
				}
				return dateMap;
				
				
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			session.close();
		}
		
		
	 }
	
	
	public String getDayResDtails(String date,HttpServletRequest request){

		String reservedSeats  = "0";
		Session session = HibernateUtill.getSession();
		StringBuffer strBuffer  = new StringBuffer();
		
		int totalSeats = 0;
		try{
			
			Query query = session.createQuery("select sum(noOfPesons) from Reservation  where to_char(reservation_date,'yyyy-mm-dd')  = :rDate  and status =:stat");
			query.setParameter("rDate",date );
			query.setParameter("stat","A");
			Object seats = query.uniqueResult();
			if(seats != null && !seats.toString().equals(""))
			reservedSeats =seats.toString();
			strBuffer.append("<event>");
			strBuffer.append("<title> RESERVED SEATS "+reservedSeats+"</title>");//	#00bfff
			strBuffer.append("<color>#f5f5f5</color>");
			strBuffer.append("<start>"+date+"</start>");
			strBuffer.append("</event>");

		    Query query1 = session.createQuery("from PriceInventory where to_char(priceDate,'yyyy-mm-dd')  = :pdate ");
			query1.setParameter("pdate",date );
			PriceInventory inventory = (PriceInventory)query1.uniqueResult();
			
			if(Integer.parseInt(reservedSeats) >0){
			    strBuffer.append("<event>");
				strBuffer.append("<title> RESERVATION CHART </title>");
				strBuffer.append("<start>"+date+"</start>");
				strBuffer.append("<color>#5cb85c</color>");
				strBuffer.append("<url>"+request.getContextPath()+"/reservationChartAction?rdate="+date+"</url>");
				strBuffer.append("</event>");
			 
		 }
			
			if(inventory == null){
				strBuffer.append("<event>");
				strBuffer.append("<title> TOTAL SEATS 0 </title>");
				strBuffer.append("<start>"+date+"</start>");
				strBuffer.append("<color>#f5f5f5</color>");
				strBuffer.append("</event>");
			}else{
				strBuffer.append("<event>");
				strBuffer.append("<title> TOTAL SEATS "+inventory.getSeats()+"</title>");
				strBuffer.append("<start>"+date+"</start>");
				strBuffer.append("<color>#f5f5f5</color>");
				strBuffer.append("</event>");
				totalSeats = inventory.getSeats();
				
				Calendar c = new GregorianCalendar();
			    c.set(Calendar.HOUR_OF_DAY, 23); //anything 0 - 23
			    c.set(Calendar.MINUTE, 59);
			    c.set(Calendar.SECOND, 59);
			    Date d1 = c.getTime();
			    ///System.out.println(d1);

			   //new SimpleDateFormat("yyyy-MM-dd").parse(date).after(d1) ||
				if (new SimpleDateFormat("yyyy-MM-dd").parse(date).after(d1) || date.equals(new SimpleDateFormat("yyyy-MM-dd").format(d1))) {
				strBuffer.append("<event>");
				strBuffer.append("<title> AVAILABLE SEATS "+(totalSeats-Integer.parseInt(reservedSeats))+"</title>");
				strBuffer.append("<start>"+date+"</start>");
				strBuffer.append("<color>#f5f5f5</color>");
				strBuffer.append("</event>");
				 
				
				 }
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return strBuffer.toString();
	}
	
	public String paaswordChange(String loginId,String oldpwd, String Password){
		String mssage  = "";
		Session session = HibernateUtill.getSession();
		try{
			Query query = session.createQuery("from Users where loginId = :id  ");
			query.setParameter("id", loginId);
			Users user = (Users)query.uniqueResult();
			if(oldpwd.equals(user.getPassword())){
			Transaction tx = session.getTransaction();
			tx.begin();
			user.setPassword(Password);
			session.update(user);
			tx.commit();
			mssage ="success";
			}else {
				mssage ="CurrentPwdMismtch)"; 
			}
		}catch (Exception e){
			e.printStackTrace();
			mssage ="Failed";
			
		}finally{
			session.close();
		}
		
		return mssage;
	}
	

}
