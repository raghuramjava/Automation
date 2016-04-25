package admin;


import java.util.ArrayList;
import java.util.List;



import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Connection.HibernateUtill;

import mapping.Users;
import mail.sendMail;

public class UserManageDao {
	
	public List<Users[]> getUsersList(){
		List<Users[]> uselist =new ArrayList<Users[]>();
		try {
			 Session session = HibernateUtill.getSession();
			 Query query = session.createQuery("from Users where active = :status ");
			 query.setParameter("status", true);
			 uselist = query.list();
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return uselist;
	}
	
	public void saveNewUser(UserManageModel userModel,String contextPath) throws Exception{
		Session session = HibernateUtill.getSession();
		Transaction tx= session.getTransaction();
		tx.begin();
		Users user = new Users();
		user.setEmail(userModel.getEmail());
	    user.setFname(userModel.getFname());
		user.setLname(userModel.getLname());
		user.setLoginId(userModel.getUserId());
		user.setPassword(userModel.getPassword());
		user.setAdminflag(userModel.getAdmUser() == null ? false :true);
		user.setActive(true);
		session.save(user);
		tx.commit();
		if(userModel.getChkMail() != null){
			

//			String emailMessage ="<!DOCTYPE HTML><html><head> <style type='text/css'>body{background-color: #fff; background-repeat: no-repeat; color: #8a8a8a; font-family: 'Calibri',sans-serif; font-size: 13px; line-height: 18px; width: 680px; margin: auto; border: 1px;}header{background: #fff none repeat scroll 0 0; margin: 0; outline: medium none; padding: 0; text-rendering: optimizelegibility !important;}.topbaraligment{background-color: #6fc7eb; background-image: url('"+contextPath+"/img/topshad.png'); background-position: center center; background-repeat: no-repeat; color: #fefefe; height: 30px; margin: auto; width: 100%;}.topbarblue{font-size: 16px; margin: auto; padding-top: 5px; width: 960px;}.topbarblue .leftpad1{float: left; padding: 0 10px;}.topbarblue .leftpad2{background-image: url('"+contextPath+"/img/phone.png'); background-position: left center; background-repeat: no-repeat; float: left; padding: 0 30px;}.topbarblue .leftpad3{background-image: url('"+contextPath+"/img/emailico.png'); background-position: left center; background-repeat: no-repeat; float: left; padding: 0 30px;}.clear{clear: both;}.headerinner{background-color: #fff; color: #6dc6eb; height: 151px; margin: auto; width: 960px;}.logo{float: left;}.reservationbar{background-color: #d8bed5; border-top: 1px solid #6dc6eb; height: 4px;}p{font-size: 12pt;color: #6fc7eb;}</style></head><body><div class='topbaraligment'><div class='topbarblue'><span class='leftpad1'>For information: </span><span class='leftpad2'>+966 12 - 6066144 Ext 400 </span><span class='leftpad3'><a href='mailto:info@tarfeehfakieh.com'>info@tarfeehfakieh.com</a><div class='clear'></div></div></div></header><div id='headermain'><div class='headerinner'><div class='logo'><img src='logoblueocean.png'></div></div></div><div class='clear reservationbar' style='height:4px;'></div><p>Dear "+userModel.getFname()+" "+userModel.getLname()+" ,</p><p>As requested, please find your login details below:</p><p>Username: " + userModel.getUserId() + "<br/>Password: " + userModel.getPassword() + "</p><br><p>Thank you for using this site.<br/></p><br><p>Regards,<br/>BLUE OCEAN ADMIN TEAM<br/></p><p><br/><br/>THIS IS AN AUTOMATED MESSAGE; PLEASE DO NOT REPLY. </p></body></html>";
			String emailMessage ="<!DOCTYPE HTML><html><head></head><body style = 'background-color: #fff; background-repeat: no-repeat; color: #8a8a8a; font-size: 13px; line-height: 18px; width: 680px; margin: auto; border: 1px;'><header style ='background: #fff none repeat scroll 0 0; margin: 0; outline: medium none; padding: 0; text-rendering: optimizelegibility !important;'><div style = 'background-color: #6fc7eb; background-position: center center; background-repeat: no-repeat; color: #fefefe; height: 30px; margin: auto; width: 100%;'><div style ='font-size: 16px; margin: auto; padding-top: 5px; width: 960px;'><span style= 'float: left; padding: 0 10px;'>For information: </span><span style='background-image: url(http://52.79.139.187:8080/RestaurantReservationSystem/img/phone.png); background-position: left center; background-repeat: no-repeat; float: left; padding: 0 30px;'>+966 12 - 6066144 Ext 400 </span><span class='background-image: url(http://52.79.139.187:8080/RestaurantReservationSystem/img/emailico.png); background-position: left center; background-repeat: no-repeat; float: left; padding: 0 30px;'><a href='mailto:info@tarfeehfakieh.com'>info@tarfeehfakieh.com</a></span></div></div><div ><div style ='background-color: #fff; color: #6dc6eb; height: 151px; margin: auto; width: 960px;'><div style ='float: left;'><img src='http://52.79.139.187:8080/RestaurantReservationSystem/img/logoblueocean.png'></div></div></div><div style='background-color: #d8bed5; border-top: 1px solid #6dc6eb; height: 4px;height:4px;'> </div><p>Dear "+userModel.getFname()+" "+userModel.getLname()+" ,</p><br></br> <p>As requested, please find your login details below:</p><p>Username: " + userModel.getUserId() + "<br/>Password: " + userModel.getPassword() + "</p><br><p>Thank you for using this site.<br/></p><br><p>Regards,<br/>BLUE OCEAN ADMIN TEAM<br/></p><p><br/><br/>THIS IS AN AUTOMATED MESSAGE; PLEASE DO NOT REPLY. </p></header></body></html>";
			System.out.println(emailMessage);
			String subject  = "Blue Ocean Restaurant Log in Credentials";
            sendMail.sendEmail(userModel.getEmail(), subject, emailMessage);
		}
		
	}
	
	public void deleteUsers(UserManageModel userModel) throws Exception{
		Session session = HibernateUtill.getSession();
		Transaction tx= session.getTransaction();
		tx.begin();
		System.out.println(userModel.getDeleteUsers());
		String [] userArr = userModel.getDeleteUsers().split(",");
		for(String userId : userArr){
		Users user = (Users) session.get(Users.class,Integer.parseInt(userId));
		user.setActive(false);
		session.update(user);
		}
		tx.commit();
	}
	
	/*
	 * 
	 * 
	 * public void saveEmailConfig(EmailManageModel emodel) throws Exception{
		Session session = HibernateUtill.getSession();
		Transaction tx= session.getTransaction();
		tx.begin();
		EmailConfig econfig = new EmailConfig();
		econfig.setEmail(emodel.getEmail());
		econfig.setHost(emodel.getHost());
		econfig.setPassword(emodel.getPassword());
		econfig.setPort(emodel.getPort());
		econfig.setEmailId(emodel.getEmailId());
		session.save(econfig);
		tx.commit();
	}*/

}
