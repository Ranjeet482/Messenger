package com.mindtree.msesss.service;

import java.util.ArrayList;
import java.util.List;

import com.mindtree.msesss.model.Message;

public class MessageServers {
	
	
	public List<Message> getAllMessages(){
		Message m1 = new Message(1L, "Hello World!", "Ranjeet");
		Message m2 = new Message(2L, "Hello Jersey!", "Ranjeet");
		List<Message> messages = new ArrayList<>();
		messages.add(m1);
		messages.add(m2);
		return messages;
	}
}
