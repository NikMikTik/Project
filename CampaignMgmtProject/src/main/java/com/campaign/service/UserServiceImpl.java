package com.campaign.service;

import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.campaign.dto.ResponseDto;
import com.campaign.dto.UserDto;
import com.campaign.model.User;
import com.campaign.repository.UserRepository;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

	Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	ModelMapper modelMapper = new ModelMapper();
	private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private IRedisService iredis;

	@Autowired
	private JavaMailSender sender;

	String noToken = "******";

	ResponseDto response = new ResponseDto();

	@Override
	public ResponseDto registrationFunction(UserDto userDto) {
		if (userRepository.findByUserEmail(userDto.getUserEmail()) != null) {
			response.setCode(HttpStatus.FORBIDDEN.value());
			response.setToken(noToken);
			response.setMessage("Account Already Exists..");
			response.setResponse("You need to Login to access your account");
			return response;
		}
		if ((userRepository.findByUserEmail(userDto.getUserEmail()) == null)
				&& (userDto.getPassword().equals(userDto.getConfirmPassword()))) {
			User user = modelMapper.map(userDto, User.class);
			user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
			userRepository.save(user);

			response.setCode(HttpStatus.OK.value());
			response.setToken(noToken);
			response.setMessage(
					user.getUserDesignation() + " : " + user.getUserName() + " : Registered Successfully...");
			response.setResponse("You can access your account Now");
			return response;
		} else {
			response.setCode(HttpStatus.FORBIDDEN.value());
			response.setMessage("Cannot Register...");
			response.setToken(noToken);
			response.setResponse("Enter correct Details");
			return response;
		}

	}

	@Override
	public ResponseDto loginFunction(UserDto userDto) {
		if ((userRepository.findByUserEmail(userDto.getUserEmail()) == null)) {
			response.setCode(HttpStatus.FORBIDDEN.value());
			response.setMessage("Cannot Login...Enter correct Details..");
			response.setToken(noToken);
			response.setResponse("If Already not Registered, Please Register");
			return response;
		}
		User user = userRepository.findByUserEmail(userDto.getUserEmail());
		if (bCryptPasswordEncoder.matches(userDto.getPassword(), user.getPassword())) {
			String token = null;
			try {
				token = Jwts.builder().setSubject("campaign:" + user.getUserName() + ":" + user.getUserDesignation())
						.claim("scope", "CampaignManagers")
						.signWith(SignatureAlgorithm.HS256, "secret".getBytes("UTF-8"))
						.setIssuedAt(new Date(System.currentTimeMillis()))
						.setExpiration(new Date(System.currentTimeMillis() + 10000)).compact();
				iredis.setValue(token, user.getUserEmail());

				response.setCode(HttpStatus.OK.value());
				response.setMessage("User successfully logged In");
				response.setResponse("Access Given");
				response.setToken(token);
				return response;

			} catch (Exception e) {

				e.printStackTrace();
			}

		} else {
			response.setCode(HttpStatus.UNAUTHORIZED.value());
			response.setToken("No Token Generated");
			response.setMessage("Email/Password Not valid");
			response.setResponse("Access Denied");
			return response;
		}
		return response;

	}

	@Override
	public ResponseDto logoutFunction(HttpServletRequest request) {
		String token = request.getHeader("Authorization");
		iredis.deleteValue(token);
		ResponseDto responseDto = new ResponseDto();
		responseDto.setCode(HttpStatus.OK.value());
		responseDto.setMessage("Successfully logged out");
		responseDto.setToken("Token Deleted");
		responseDto.setResponse("To get Access, Login Again");
		return responseDto;
	}

	@Override
	public ResponseDto forgotPwdFunction(String userEmail) {
		if ((userRepository.findByUserEmail(userEmail) == null)) {
			response.setCode(HttpStatus.FORBIDDEN.value());
			response.setMessage("Not Authorized.. ");
			response.setToken(noToken);
			response.setResponse("If Already not Registered, Please Register");
			return response;
		}
		String resetToken = null;
		try {
			resetToken = Jwts.builder().setSubject("forgotPwd" + userEmail).claim("scope", "CampaignManagers")
					.signWith(SignatureAlgorithm.HS256, "secret".getBytes("UTF-8"))
					.setIssuedAt(new Date(System.currentTimeMillis()))
					.setExpiration(new Date(System.currentTimeMillis() + 10000)).compact();
			iredis.setValue(resetToken, userEmail);

			User user = userRepository.findByUserEmail(userEmail);
			MimeMessage message = sender.createMimeMessage();
			try {
				logger.info("Sending Forgot Pwd Email");
				MimeMessageHelper helper = new MimeMessageHelper(message, true);
				helper.setTo(user.getUserEmail());
				helper.setText("<html><body><h2>Hi " + user.getUserName()
						+ ",<br></h2><h3>You requested that your Password to be Reset<b></b>!</br>Please visit the following link below or copy and paste it in your browser to create a new Password</br></br>"
						+ "http://localhost:8090/campaign/resetPwd/{"+resetToken+"}</br>If you did not made the request to reset the password, Please Ignore...</br></h3><h2>Team Campaign Mgmt :: Nikita</h2><br><br><img src='cid:id101'/>"
								+ " **** This is an Auto Generated Mail. Please do not Reply. **** <body></html>",
						true);
				helper.setSubject("Campaign Mgmt Application: [Password Reset]");
				ClassPathResource file1 = new ClassPathResource("campaignMgmt.jpg");
				helper.addInline("id101", file1);

				/*
				 * ClassPathResource file = new ClassPathResource("Terms and Conditions.pdf");
				 * helper.addAttachment("Terms and Conditions.pdf", file);
				 */
				sender.send(message);
				logger.info("Registration Email sent");

			} catch (MailException e) {
				e.printStackTrace();
			} catch (MessagingException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

			
		} catch (Exception e) {

			e.printStackTrace();
		}
		response.setCode(HttpStatus.OK.value());
		response.setMessage("Reset Password Token Generated");
		response.setResponse("You can Reset your Password Now..");
		response.setToken(resetToken);
		return response;

	}

	@Override
	public ResponseDto resetPwdFunction(String resetToken) {
		if(iredis.getValue(resetToken)==null)
		return response;
	}

}
