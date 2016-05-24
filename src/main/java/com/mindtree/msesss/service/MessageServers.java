package com.mindtree.msesss.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import com.mindtree.msesss.database.DatabaseClass;
import com.mindtree.msesss.model.Message;

public class MessageServers {
	
	private Map<Long, Message> messages = DatabaseClass.getMessages();
	
	public MessageServers(){
		messages.put(1L, new Message(1, "Hello World", "Ranjeet"));
		messages.put(2L, new Message(2, "Bye World", "Ranjeet"));
	}
	
	public List<Message> getAllMessages(){
		return new ArrayList<Message>(messages.values());
	}
	
	public List<Message> getAllMessagesForYear(int year){
		List<Message> messagesForYear = new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		for(Message message : messages.values()){
			cal.setTime(message.getCreated());
			if(cal.get(Calendar.YEAR) == year){
				messagesForYear.add(message);
			}
		}
		return messagesForYear;
	}
	
	public List<Message> getAllMessagesPaginated(int start, int size){
		ArrayList<Message> list = new ArrayList<Message>(messages.values());
		if(start + size > list.size()) return new ArrayList<Message>();
		return list.subList(start, start + size);
	}
	
	public Message getMessages(long id){
		return messages.get(id);
	}
	
	public Message addMessages(Message message){
		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessages(Message message){
		if(message.getId() <= 0){
			return null;
		}
		messages.put(message.getId(),message);
		return message;
	}
	
	public Message removeMessages(long id){
		return messages.remove(id);
	}
}
