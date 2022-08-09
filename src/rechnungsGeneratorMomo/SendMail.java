package rechnungsGeneratorMomo;
import javax.mail.*;
import javax.mail.internet.*;

import java.util.Date;
import java.util.Properties;
public class SendMail {

		public static void main (String [] args) throws MessagingException {
			final String fromEmail = "fouma2003@msn.com"; //requires valid gmail id
			final String password = "Fouma1322251509"; // correct password for gmail id
			final String toEmail = "h.dalkilic@outlook.de"; // can be any email id 
			
			System.out.println("TLSEmail Start");
			Properties props = new Properties();
			props.put("mail.smtp.host", "smtp-mail.outlook.com"); //SMTP Host
			props.put("mail.smtp.port", "587"); //TLS Port
			props.put("mail.smtp.auth", "true"); //enable authentication
			props.put("mail.smtp.ssl.protocols", "TLSv1.2");
			props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS
			
	                //create Authenticator object to pass in Session.getInstance argument
			Authenticator auth = new Authenticator() {
				//override the getPasswordAuthentication method
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(fromEmail, password);
				}
			};
			Session session = Session.getInstance(props, auth);
			
			sendEmail(session,fromEmail,password,toEmail,"TLSEmail Testing Subject", "TLSEmail Testing Body");
			
		}

	   
	   public static void sendEmail(Session session,String from, String pwd, String toEmail, String subject, String body){
			try
		    {
 		      MimeMessage msg = new MimeMessage(session);
		      //set message headers
		      msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
		      msg.addHeader("format", "flowed");
		      msg.addHeader("Content-Transfer-Encoding", "8bit");

		      msg.setFrom(new InternetAddress(from, "MOMO´Fensterputz"));

		    // msg.setReplyTo(InternetAddress.parse(toEmail, false));

		      msg.setSubject(subject, "UTF-8");

		      msg.setText(body, "UTF-8");

		      msg.setSentDate(new Date());

		      msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
		      System.out.println("Message is ready");
	    	  Transport.send(msg); 

		      System.out.println("EMail Sent Successfully!!");
		    }
		    catch (Exception e) {
		      e.printStackTrace();
		    }
		}
	}


