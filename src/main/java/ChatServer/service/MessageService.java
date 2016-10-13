/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatServer.service;

import ChatServer.Domain.Message;
import ChatServer.Domain.User;
import ChatServer.DatabaseClass;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Jorgen
 */
public class MessageService {
    
    private Map<Long, Message> messages = DatabaseClass.getMessages();
    
    
    public MessageService(){
    Message m1 = new Message(new User("test1"), "someText", new Date());
    Message m2 = new Message(new User("test2"), "someMoreText", new Date()); 
    messages.put(1L, m1);
    messages.put(2L, m2);
    }
    
    //return all the messages as an arraylist
    public List<Message> getAllMessages(){
    return new ArrayList<Message>(messages.values());
    }
    
    //Filtering messages by year
    public List<Message> getAllMessagesForYear(int year){
        List<Message> messagesForYear = new ArrayList<>();
        Calendar cal = Calendar.getInstance();
        for(Message message : messages.values()){
            cal.setTime(message.getTimestamp());
            if(cal.get(Calendar.YEAR) == year){
                messagesForYear.add(message);
            }
        }
        return messagesForYear;
    }
    
    //gets a paginated part of all the messages, a little piece
    public List<Message> getAllMessagesPaginated(int start, int size){
        ArrayList<Message> list = new ArrayList<Message>(messages.values());
        if(start + size > list.size()) return new ArrayList<Message>();
        return list.subList(start, start + size);
    } 
    
    //returns a message by id
    public Message getMessage(Long id){
        return messages.get(id);
    }
    
    //Adds a new message
    public Message addMessage(Message message){
        message.setMessageId(messages.size() + 1L);
        messages.put(message.getMessageId(), message);
        return message;
    }
    
    //Changes a existing message
    public Message updateMessage(Message message){
        if(message.getMessageId() <= 0){
            return null;
        }
        messages.put(message.getMessageId(), message);
        return message;
    }
    
    //Deletes a message by id
    public Message removeMessage(long id){
        return messages.remove(id);
    }
}
