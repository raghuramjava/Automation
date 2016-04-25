package mail;

import javax.mail.*;

import javax.mail.internet.*;
import Connection.HibernateUtill;

import mapping.EmailConfig;



import Connection.HibernateUtill;

import java.util.*;
import org.hibernate.Session;
import org.hibernate.Query;

public class sendMail {
	
	
	 public static void sendEmail  (String toMailAddress,String subject,String content) {
		 try {
	      String to = toMailAddress;//change accordingly
	      
	      org.hibernate.Session hsession = HibernateUtill.getSession();
			Query query = hsession.createQuery("from EmailConfig ");
			List<EmailConfig> emailConfigList = query.list();
			EmailConfig  econfig = emailConfigList.get(0);
			String   from = econfig.getEmail();
			final String   username = econfig.getEmailId();
			final String   password = econfig.getPassword();
			String  host = econfig.getHost();
			String port = econfig.getPort();

	      Properties props = new Properties();
	      props.put("mail.smtp.auth", "true");
	      props.put("mail.smtp.starttls.enable", "true");
	      props.put("mail.smtp.host", host);
	     
	      props.put("mail.smtp.port", port);

	      // Get the Session object.
	      javax.mail.Session session = javax.mail.Session.getInstance(props,
	    	      new javax.mail.Authenticator() {
	    	         protected PasswordAuthentication getPasswordAuthentication() {
	    	            return new PasswordAuthentication(username, password);
	    	         }
	    	      });
	      
	      
	         // Create a default MimeMessage object.
	         Message message = new MimeMessage(session);

	         // Set From: header field of the header.
	         message.setFrom(new InternetAddress(from));

	         // Set To: header field of the header.
	         message.setRecipients(Message.RecipientType.TO,
	         InternetAddress.parse(to));

	         // Set Subject: header field
	         message.setSubject(subject);

	         // Now set the actual message
	         message.setContent(content, "text/html");

	         // Send message
	         Transport.send(message);

	         System.out.println("Sent message successfully....");

	      } catch (Exception e) {
	            e.printStackTrace();
	      }
	   }
}