package com.campaign.service;

import javax.servlet.http.HttpServletRequest;

import com.campaign.dto.ResponseDto;
import com.campaign.dto.UserDto;

public interface IUserService {

	ResponseDto registrationFunction(UserDto userDto);

	ResponseDto loginFunction(UserDto userDto);

	ResponseDto logoutFunction(HttpServletRequest request);

	ResponseDto forgotPwdFunction(String userEmail);

	ResponseDto resetPwdFunction(String resetToken);

}
