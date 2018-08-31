package com.batch.processor;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.MailException;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.batch.model.User;
import com.batch.repository.UserRepository;
@Configuration
public class Processor implements ItemProcessor<User, User>{
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	private JavaMailSender sender;

	@Override
	public User process(User user) throws Exception {
		user.setOffer("Offer Sent");
		
		MimeMessage message = sender.createMimeMessage();
		try {
			
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setTo(user.getEmail());
			if(user.getGender().equals("Male"))
			{helper.setText("<html><body><h2>Hi " + user.getName()
					+ ",<br></h2><h3>Welcome to ABC Family<b></b>!</br>Thank you for using our services on ABC...  </br>\r\n"
					+ "<br>We are giving you offer of 20% off on Men's Wear...<b></br></br>See you around</br></h3><h2>Team ABC :: Nikita </h2><br><br><img src='cid:id101'/><body></html>",
					true);}
			else if (user.getGender().equals("Female")) {
				helper.setText("<html><body><h2>Hi " + user.getName()
				+ ",<br></h2><h3>Welcome to ABC Family<b></b>!</br>Thank you for using our services on ABC...  </br>\r\n"
				+ "<br>We are giving you offer of 20% off on Women's Wear...<b></br></br>See you around</br></h3><h2>Team ABC :: Nikita </h2><br><br><img src='cid:id101'/><body></html>",
				true);
			}
			else
			{
				helper.setText("<html><body><h2>Hi " + user.getName()
				+ ",<br></h2><h3>Welcome to ABC Family<b></b>!</br>Thank you for using our services on ABC...  </br>\r\n"
				+ "<br>We are giving you offer of 20% off on Clothing...<b></br></br>See you around</br></h3><h2>Team ABC :: Nikita </h2><br><br><img src='cid:id101'/><body></html>",
				true);
			}
			helper.setSubject("Welcome to ABC...!");
			ClassPathResource file1 = new ClassPathResource("promoImg.png");
			helper.addInline("id101", file1);
			sender.send(message);

		} catch (MailException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	
	
	}

}
