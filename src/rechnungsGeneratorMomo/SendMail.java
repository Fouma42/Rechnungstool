package rechnungsGeneratorMomo;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
public class SendMail {

	   
	   public boolean sendEmail(String toEmail, String subject, String body,String filePath){
		   Properties props = new Properties();
		   boolean mailSent=false;
		   MailCredentials mailSettings= new MailCredentials();
			props.put("mail.smtp.host",mailSettings.getSMTP_HOST()); //SMTP Host
			props.put("mail.smtp.port", mailSettings.getTLS_PORT()); //TLS Port
			props.put("mail.smtp.auth",mailSettings.getAUTHENTICATION()); //enable authentication
			props.put("mail.smtp.ssl.protocols", mailSettings.getPROTOCOL());
			props.put("mail.smtp.starttls.enable",mailSettings.getSTART_TLS_ENABLE()); //enable STARTTLS
			
	                //create Authenticator object to pass in Session.getInstance argument
			Authenticator auth = new Authenticator() {
				//override the getPasswordAuthentication method
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(mailSettings.getFROM_MAIL(), mailSettings.getPASSWORD());
				}
			};
			Session session = Session.getInstance(props, auth);
			try
		    {
 		      MimeMessage msg = new MimeMessage(session);
		      //set message headers
		      msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
		      msg.addHeader("format", "flowed");
		      msg.addHeader("Content-Transfer-Encoding", "8bit");

		      msg.setFrom(new InternetAddress(mailSettings.getFROM_MAIL(), "MOMO´S Fensterputz"));

		    // msg.setReplyTo(InternetAddress.parse(toEmail, false));

		      msg.setSubject(subject, "UTF-8");

		      //msg.setText(body, "UTF-8");

		      msg.setSentDate(new Date());

		      msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
		      BodyPart messageBodyPart = new MimeBodyPart();
		      messageBodyPart.setText(body);
		      Multipart multipart = new MimeMultipart();
		      multipart.addBodyPart(messageBodyPart);
		      // Anhang
		      DataSource source = new FileDataSource(filePath);
		      messageBodyPart = new MimeBodyPart();
		      messageBodyPart.setDataHandler(new DataHandler(source));
		      messageBodyPart.setFileName(filePath);
		      multipart.addBodyPart(messageBodyPart);
		      msg.setContent(multipart);
	    	  Transport.send(msg); 

		      mailSent=true;
		    }
		    catch (Exception e) {
		      e.printStackTrace();
		    }
			return mailSent;
		}
	}


