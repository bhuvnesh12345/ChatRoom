package com.bhuvnesh.chatroom;

import org.springframework.http.MediaType;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController
public class MessageController {

	
	@MessageMapping("/message")
	@SendTo("/topic/return-to")
    //@ResponseBody
	public Message msg(@RequestBody Message msg)
	{
		return msg;
	}
	
	//,produces=MediaType.TEXT_HTML_VALUE
//	@RequestMapping(path="/")
//	//@ResponseBody
//	public String index()
//	{
//		return "index";
//	}
}
