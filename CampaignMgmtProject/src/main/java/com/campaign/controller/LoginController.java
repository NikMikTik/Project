package com.campaign.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.campaign.dto.ResponseDto;
import com.campaign.dto.UserDto;
import com.campaign.service.IUserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/campaign")
@Api(value = "Campaign Management login Screen", description = "Used for Login into Application")
public class LoginController {

	@Autowired
	IUserService iUserService;

	ResponseDto response = new ResponseDto();

	// SIGNUP
	@ApiOperation(value = "Sign Up for Application")
	@RequestMapping(value = "/signUp", method = RequestMethod.POST)
	public ResponseDto signUp(@RequestBody UserDto userDto) {
		return iUserService.registrationFunction(userDto);
	}

	// SIGNIN
	@ApiOperation(value = "Sign In for Application")
	@RequestMapping(value = "/signIn", method = RequestMethod.POST)
	public ResponseDto signIn(@RequestBody UserDto userDto) {
		return iUserService.loginFunction(userDto);
	}

	// SIGNOUT
	@RequestMapping(value = "/signOut", method = RequestMethod.DELETE)
	public ResponseDto logout(HttpServletRequest request) {
		return iUserService.logoutFunction(request);

	}

	// FORGOT PASSWORD
	@RequestMapping(value = "/forgotPwd", method = RequestMethod.POST)
	public ResponseDto forgotPassword(String userEmail) {
		return iUserService.forgotPwdFunction(userEmail);

	}

	// RESET PASSWORD
	@RequestMapping(value = "/resetPwd", method = RequestMethod.POST)
	public ResponseDto resetPassword(@PathVariable("resetToken") String resetToken) {
		return iUserService.resetPwdFunction(resetToken);

	}
}
