package reservation;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;



import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Connection.HibernateUtill;

import mapping.Reservation;
import mapping.PriceInventory;
import mapping.Users;


public class ReservationEditSaveDao {
	
	 public PriceInventory getInventoryDetails(String  pDate){
		 Session session = HibernateUtill.getSession();
		 try {
			   Query query = session.createQuery("from PriceInventory where to_char(priceDate,'dd-mm-yyyy') = :pdate ");
				query.setParameter("pdate",pDate );
				PriceInventory inventory = (PriceInventory)query.uniqueResult();
				return inventory;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			session.close();
		}
		 
	 }
	 
	 public Reservation getResDetails(String resId) {
		 Session session = HibernateUtill.getSession();
		 try {
			 Query query = session.createQuery("from Reservation where resId = :resId ");
			 query.setParameter("resId",Integer.parseInt(resId)); 
			 Reservation reservation  =   (Reservation) query.uniqueResult();
			return reservation;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally{
			session.close();
		}
		 
		 
	 }
	 
	 public String getReservedSeats(String rDate){
		 String reservedSeats  = "0";
		 Session session = HibernateUtill.getSession();
		 try {
			    Query query = session.createQuery("select sum(noOfPesons) from Reservation  where to_char(reservation_date,'dd-mm-yyyy')  = :rDate  and status =:stat");
				query.setParameter("rDate",rDate );
				query.setParameter("stat","A");
				 Object seats = query.uniqueResult();
				if(seats != null && !seats.toString().equals(""))
				reservedSeats =seats.toString();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return  reservedSeats;
	 }
	
	public String  SaveReservation(ReservationEditSaveModel reservationModel,Map httpSession){
		Session session = HibernateUtill.getSession();
		String status = "Operation Failed";
		Date date = Calendar.getInstance().getTime();

		try {
			Transaction tx= session.getTransaction();
			tx.begin();
			Reservation reservation = new Reservation();
			reservation.setAdvanceAmount(Float.parseFloat(reservationModel.getAdavanceAmount()));
			reservation.setCompanyName(reservationModel.getCompanyName());
			reservation.setContact_person(reservationModel.getContactPerson());
			reservation.setCreatedBy((String) httpSession.get("loginId"));
			reservation.setCreatedOn(date);
			reservation.setEmail(reservationModel.getEmail());
			reservation.setNoOfPesons(Integer.parseInt(reservationModel.getNoOfPerson()));
			reservation.setPhoneNo(reservationModel.getPhoneNo());
			reservation.setRemarks(reservationModel.getRemarks());
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			reservation.setReservation_date(sdf.parse(reservationModel.getReservationDate()));
			reservation.setStatus("A");
			reservation.setUserInput(reservationModel.getUserInput());
			session.save(reservation);
			reservationModel.setResId(String.valueOf(reservation.getResId()));
			tx.commit();
			status = "Reservation Saved Successfully";
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return status;		
		
	}
	
	
	public String  updateReservation(ReservationEditSaveModel reservationModel,Map httpSession){
		Session session = HibernateUtill.getSession();
		String status = "Operation Failed";
		Date date = Calendar.getInstance().getTime();

		try {
			Transaction tx= session.getTransaction();
			tx.begin();
			Reservation reservation = (Reservation)session.get(Reservation.class, Integer.parseInt(reservationModel.getResId()));
			reservation.setAdvanceAmount(Float.parseFloat(reservationModel.getAdavanceAmount()));
			reservation.setCompanyName(reservationModel.getCompanyName());
			reservation.setContact_person(reservationModel.getContactPerson());
			reservation.setModifiedBy((String) httpSession.get("loginId"));
			reservation.setModified_on(date);
			reservation.setEmail(reservationModel.getEmail());
			reservation.setNoOfPesons(Integer.parseInt(reservationModel.getNoOfPerson()));
			reservation.setPhoneNo(reservationModel.getPhoneNo());
			reservation.setRemarks(reservationModel.getRemarks());
			reservation.setUserInput(reservationModel.getUserInput());
			session.update(reservation);
			reservationModel.setResId(String.valueOf(reservation.getResId()));
			tx.commit();
			status = "Reservation Updated Successfully";
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return status;		
		
	}
	
	
	public String  cancelReservation(String resId){
		Session session = HibernateUtill.getSession();
		String status = "Operation Failed";
		

		try {
			Transaction tx= session.getTransaction();
			tx.begin();
			Reservation reservation = (Reservation)session.get(Reservation.class, Integer.parseInt(resId));
			reservation.setStatus("C");
			session.update(reservation);
			tx.commit();
			status = "Reservation Cancelled Successfully";
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return status;		
		
	}

}
