package com.shall.productapplication.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shall.productapplication.model.ResponseVO;

@RestController
@RefreshScope
@RequestMapping("/v1/")
public class OperationsController {

	@Value("${viewAction: Config server not working}")
	private String viewAction;

	@Value("${viewActionByIdMock}")
	private String viewActionByIdMock;

	@RequestMapping(value = "${viewAction}", produces = "application/json; charset=UTF-8", method = RequestMethod.GET)
	public ResponseEntity<String> findAll() {
		System.out.println("View action for: " + viewAction);
		return new ResponseEntity<String>(viewAction, HttpStatus.OK);
	}

	@RequestMapping(value = "{viewId}/${viewAction}", produces = "application/json; charset=UTF-8", method = RequestMethod.GET)
	public ResponseEntity<ResponseVO<String>> findById(@PathVariable("viewId") String viewId) {
		System.out.println("View by id result: " + viewActionByIdMock);
		return ResponseEntity.ok(new ResponseVO<>(viewActionByIdMock));
	}
}
