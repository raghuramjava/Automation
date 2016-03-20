package general;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Query;
import mapping.Users;

import Connection.HibernateUtill;

public class BaseDao {
	
	
	public String authenticateUser(BaseModel baseModel){
		String vaildUser = "invalidUser";
		try{
			Session session = HibernateUtill.getSession();
			Query query = session.createQuery("from Users where loginId = :id and password = :pwd ");
			query.setParameter("id", baseModel.getUserName());
			query.setParameter("pwd", baseModel.getPassword());
			System.out.println(baseModel.getUserName());
			System.out.println(baseModel.getPassword());
			List<Users> uselist = query.list();
			if(uselist.size() > 0){
				Users user = uselist.get(0);
				if(user.getAdminflag()==true){
					vaildUser = "adminUser";
				}else{
					vaildUser = "normalUser";
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return vaildUser;
	}

}
