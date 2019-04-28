package com.gayatri.accountservice.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gayatri.accountservice.constants.Constants;

@RestController
public class ApplicationErrorController implements ErrorController{
	
	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<String> getError() {
		return new ResponseEntity<>(Constants.ERROR_MESSAGE, HttpStatus.BAD_REQUEST);
	}

	@Override
	public String getErrorPath() {
		return Constants.ERROR_PATH;
	}

}
