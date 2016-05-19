package com.mindtree.msesss;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mindtree.msesss.model.Message;
import com.mindtree.msesss.service.MessageServers;

@Path("/messages")
public class MessagesResource {
	
	MessageServers messageService = new MessageServers();
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Message> getMessages(){
		return messageService.getAllMessages();
	}

}
