package br.com.projetooi.utils;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.mail.EmailException;

public class EmailUtils {
	
	static Properties mailServerProperties;
	static Session getMailSession;
	static MimeMessage generateMailMessage;
	
	public static void enviaEmail(String emailDestinatario, String conteudo, String assunto) throws EmailException, AddressException, MessagingException {
		
		// Step1
				System.out.println("\n 1st ===> setup Mail Server Properties..");
				mailServerProperties = System.getProperties();
				mailServerProperties.put("mail.smtp.port", "587");
				mailServerProperties.put("mail.smtp.auth", "true");
				mailServerProperties.put("mail.smtp.starttls.enable", "true");
				System.out.println("Mail Server Properties have been setup successfully..");
		 
				// Step2
				System.out.println("\n\n 2nd ===> get Mail Session..");
				getMailSession = Session.getDefaultInstance(mailServerProperties, null);
				generateMailMessage = new MimeMessage(getMailSession);
				generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(emailDestinatario));
//				generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress("test2@crunchify.com"));
				generateMailMessage.setSubject(assunto);
				String emailBody = conteudo;
				generateMailMessage.setContent(emailBody, "text/html");
				System.out.println("Mail Session has been created successfully..");
		 
				// Step3
				System.out.println("\n\n 3rd ===> Get Session and Send mail");
				Transport transport = getMailSession.getTransport("smtp");
		 
				// Enter your correct gmail UserID and Password
				// if you have 2FA enabled then provide App Specific Password
				transport.connect("smtp.gmail.com", "rafael.estefano.rosa@gmail.com", "46430970");
				transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
				transport.close();
	    
//		   SimpleEmail email = new SimpleEmail();
//		   //Utilize o hostname do seu provedor de email
//		   System.out.println("alterando hostname...");
//		   email.setHostName("smtp.gmail.com");
//		   //Quando a porta utilizada não é a padrão (gmail = 465)
//		   email.setSmtpPort(465);
//		   //Adicione os destinatários
//		   email.addTo("rafael.estefano.rosa@gmail.com", "Rafael"); //enviar para
//		   //Configure o seu email do qual enviará
//		   email.setFrom("rafael.estefano.rosa@gmail.com", "Rafael");
//		   //Adicione um assunto
//		   email.setSubject("Test message");
//		   //Adicione a mensagem do email
//		   email.setMsg("This is a simple test of commons-email");
//		   //Para autenticar no servidor é necessário chamar os dois métodos abaixo
//		   System.out.println("autenticando...");
//		   email.setSSL(true);
//		   email.setAuthentication("rafael.estefano.rosa@gmail.com", "46430970");
//		   System.out.println("enviando...");
//		   email.send();
//		   System.out.println("Email enviado!");
		}
}
