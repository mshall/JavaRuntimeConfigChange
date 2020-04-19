package com.shall.productapplication.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class MessageController {

	@Value("${msg: Config server not working}")
	private String msg;

	@GetMapping(value = "/msg")
	String getMsg(){
		return this.msg;
	}
}
