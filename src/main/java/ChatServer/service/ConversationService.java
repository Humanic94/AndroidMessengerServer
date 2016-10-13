/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatServer.service;

import ChatServer.DatabaseClass;
import ChatServer.Domain.Conversation;
import ChatServer.Domain.Message;
import ChatServer.Domain.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Jorgen
 */
public class ConversationService {
    private Map<String, Conversation> conversations = DatabaseClass.getConversations();
    
    public ConversationService(){
        Conversation c1 = new Conversation("test", new User(1L, "Jørgen", "Jørgen"), new ArrayList<User>(), new ArrayList<Message>());
        conversations.put(c1.getConversationName(), c1);
    }
    
    //gets all conversations
    public List<Conversation> getAllConversations(){
    
        return new ArrayList<Conversation>(conversations.values()); 
    }
    
    //get one conversation by name
    public Conversation getConversation(String conversationName){
        return conversations.get(conversationName);
    }
    
    //adds a new conversation
    public Conversation addConversation(Conversation conversation){
        conversation.setConversationId(conversations.size() + 1L);
        conversations.put(conversation.getConversationName(), conversation);
        return conversation;
    }
    
    //changes an existing conversation
    public Conversation updateConversation(Conversation conversation){
        if(conversation.getConversationName().isEmpty()){
            return null;
        }
        conversations.put(conversation.getConversationName(), conversation);
        return conversation;
    }
    
    //deletes a conversation
    public Conversation removeConversation(String conversationName){
        return conversations.remove(conversationName);
    }
}
