package com.shall.ms.general.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping("/v1/")
public class OperationController {

	@Value("${message: This value shouldn't be visible}")
	String message;

	@RequestMapping(value = "message", produces = "application/json; charset=UTF-8", method = RequestMethod.GET)
	public ResponseEntity<String> getMessage() {
		System.out.println("Message: "+message);
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}
}
