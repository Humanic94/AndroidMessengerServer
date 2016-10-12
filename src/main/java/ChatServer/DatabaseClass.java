package ChatServer;
import ChatServer.Domain.Conversation;
import ChatServer.Domain.Message;
import ChatServer.Domain.User;
import java.util.HashMap;
import java.util.Map;




/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jorgen
 */
public class DatabaseClass {
    private static Map<Long, Message> messages = new HashMap<>();
    private static Map<Long, User> users = new HashMap<>();
    private static Map<Long, Conversation> conversations = new HashMap<>();
    
    public static Map<Long, Message> getMessages(){
        return messages;
    }
    
    public static Map<Long, User> getUsers(){
        return users;
    }
    
    public static Map<Long, Conversation> getConversations(){
        return conversations;
    }
}
