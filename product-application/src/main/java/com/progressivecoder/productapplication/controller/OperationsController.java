package com.progressivecoder.productapplication.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
@RequestMapping("/v1/")
public class OperationsController {

	@Value("${viewAction: Config server not working}")
	private String viewAction; 
	
	@RequestMapping(value = "${viewAction}", produces = "application/json; charset=UTF-8", method = RequestMethod.GET)
	public ResponseEntity<String> executeViewAction() {
		System.out.println("View action for: "+viewAction);
		return new ResponseEntity<String>(viewAction, HttpStatus.OK);
	}
}
