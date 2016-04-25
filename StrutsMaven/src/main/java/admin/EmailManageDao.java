package admin;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import mapping.EmailConfig;
import mapping.Users;
import Connection.HibernateUtill;

public  class EmailManageDao {
	
	public List<EmailConfig> checkEmailConfigExust(){
		List<EmailConfig> uselist =new ArrayList<EmailConfig>();
		try{
				Session session = HibernateUtill.getSession();
				Query query = session.createQuery("from EmailConfig  ");
				 uselist = query.list();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return uselist;
	}

	public void deleteExistEmailConfig() throws Exception{
		
			Session session = HibernateUtill.getSession();
			Transaction tx= session.getTransaction();
			tx.begin();
			session.createQuery("delete from EmailConfig ").executeUpdate();
			tx.commit();
		
	}
	
	public void saveEmailConfig(EmailManageModel emodel) throws Exception{
		Session session = HibernateUtill.getSession();
		Transaction tx= session.getTransaction();
		tx.begin();
		EmailConfig econfig = new EmailConfig();
		econfig.setId(1);
		econfig.setEmail(emodel.getEmail());
		econfig.setHost(emodel.getHost());
		econfig.setPassword(emodel.getPassword());
		econfig.setPort(emodel.getPort());
		econfig.setEmailId(emodel.getEmailId());
		session.save(econfig);
		tx.commit();
	}
	
	
}
