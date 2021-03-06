package com.gayatri.accountservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gayatri.accountservice.constants.Constants;

@RestController
public class TestController {
	
	/* Hello API */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<String> hello() {
		return new ResponseEntity<>(Constants.GREETING_HELLO , HttpStatus.OK);
	}

}
