package reservation;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;



import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import Connection.HibernateUtill;

import mapping.Reservation;
public class SearchReservationDao {
	
	public List<Reservation []> getSerachResults(SearchReservationModel searchModel){
		Session session = HibernateUtill.getSession();
		try {
			Criteria cr = session.createCriteria(Reservation.class);
			if(searchModel.getCompanyName() != null && !searchModel.getCompanyName().equals("")){
				cr.add(Restrictions.like("companyName", "%"+searchModel.getCompanyName()+"%"));
			}
			if(searchModel.getContactPerson() != null && !searchModel.getContactPerson().equals("")){
				cr.add(Restrictions.like("contact_person", "%"+searchModel.getContactPerson()+"%"));
			}
			if(searchModel.getReservationId() != null && !searchModel.getReservationId().equals("")){
				cr.add(Restrictions.eq("resId", Integer.parseInt(searchModel.getReservationId()) ));
			}
			
			if(searchModel.getReservationDate() != null && !searchModel.getReservationDate().equals("")){
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
				cr.add(Restrictions.eq("reservation_date", sdf.parse(searchModel.getReservationDate())));
			}
			
			cr.addOrder(Order.asc("resId"));

			
			List<Reservation []> resList = cr.list();
			return resList;
			
		} catch (Exception e) {
			return null;
		}finally{
			session.close();
		}
	}

}
