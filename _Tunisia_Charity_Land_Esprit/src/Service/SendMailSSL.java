/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/**
 *
 * @author oflcad
 */
public class SendMailSSL {
     public SendMailSSL(){
     }
     
     
     public void sendEmail(String email, String confirmation_token, String username ){
         Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props,
			new javax.mail.Authenticator() {
                                @Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("omarlakhdhar@gmail.com","mabroukhabiba91*/");
				}
			});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("omarlakhdhar@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse("omarlakhdhar@gmail.com"));
			message.setSubject("Verification for Tunisia Charity Land subscription");
			message.setText("Dear Mail '"+username+"'," +
                                        
					"\n\n No spam to my email,"
                                + " please Copy this confirmation token : <br>"
                                + " <b>'"+confirmation_token+"'!");

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
    
}
