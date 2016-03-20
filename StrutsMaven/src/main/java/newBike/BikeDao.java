package newBike;
import java.text.SimpleDateFormat;

import mapping.Bike;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import Connection.HibernateUtill;
import org.hibernate.Transaction;

public class BikeDao {
	
	public int saveBike(BikeModel bikeModel){
	 int result= 0 ;
	 try {
		 SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm a");
		  
		 Bike  bike= new Bike();
		 System.out.println("Here");
		 System.out.println(bikeModel.getBikeType());
		 bike.setBikeType(bikeModel.getBikeType());
		 bike.setChaseNo(bikeModel.getModelNo());
		 bike.setModelNo(bikeModel.getModelNo());
		 bike.setCratedDate(formatter.parse(bikeModel.getCratedDate()));
		 bike.setBikeNo(bikeModel.getBikeNo());
		 Session session = HibernateUtill.getSession();
		 Transaction tx= session.beginTransaction();
		 session.save(bike);
		 tx.commit();
		 
	} catch (Exception e) {
e.printStackTrace();

}
	 
	 return result;
	}

}
