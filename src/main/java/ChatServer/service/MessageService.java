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
    
    
    public List<Message> getAllMessages(){
    return new ArrayList<Message>(messages.values());
    }
    
    public Message getMessage(Long id){
        return messages.get(id);
    }
    
    public Message addMessage(Message message){
        message.setMessageId(messages.size() + 1L);
        messages.put(message.getMessageId(), message);
        return message;
    }
    
    public Message updateMessage(Message message){
        if(message.getMessageId() <= 0){
            return null;
        }
        messages.put(message.getMessageId(), message);
        return message;
    }
    
    public Message removeMessage(long id){
        return messages.remove(id);
    }
}
