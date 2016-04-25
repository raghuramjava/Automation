package general;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Query;
import mapping.Users;
import mail.sendMail;

import Connection.HibernateUtill;

public class ForgotPasswordDao {
	
	public String authenticateEmail(String email){
		
		String validEmail= "invaliedmail";
		try {
			
			Session session = HibernateUtill.getSession();
			Query query = session.createQuery("from Users where email = :email ");
			query.setParameter("email", email);
			
			List<Users> uselist = query.list();
			if(uselist.size() > 0){
				validEmail = "vaildMail";
				sendMail(uselist.get(0));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return validEmail;
	}
	
	public void sendMail(Users objCustomers) throws Exception{
		String emailSubject = " Forgot Password mail.";
		String emailMessage = "<html><head><meta http-equiv='Content-Type' content='text/html; charset=iso-8859-1'/><title>Your Password</title></head><body><table width='500' border='0' align='center' cellpadding='15' cellspacing='0' style='font-family:Verdana, Arial, Helvetica, sans-serif; font-size:12pt; color:#5a5a5a;'><tr><td align='left'><p>Dear " + objCustomers.getFname() + ",</p></td></tr><tr><td align='left'><p>As requested, please find your login details below:</p><br/><br/><p>Username: " + objCustomers.getLoginId() + "<br />Password: " + objCustomers.getPassword() + "<br /></p><br/><p>Thank you for using  this site.<br /></p><br/><br/><p>Regards,<br />BLUE OCEAN ADMIN TEAM<br /></p><p><br /><br />THIS IS AN AUTOMATED MESSAGE; PLEASE DO NOT REPLY. </p></td></tr></table></body></html>";
		String emailFrom  = "adm48120@gmail.com";
		String emailUser =  "adm48120";
		String password  = "restaurant@resrervation";
		sendMail.sendEmail(objCustomers.getEmail(), emailSubject, emailMessage);
	}

}
