/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatServer;
import ChatServer.Domain.Conversation;
import ChatServer.Domain.Message;
import ChatServer.Domain.User;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
/**
 *
 * @author Humanic
 */
@Stateless
@Path("Chat")
@Produces("application/json")
public class ChatService {
    private List<User> users;
    private List<Conversation> conversations;
    private List<Message> messages;
    public ChatService(){
        users = new ArrayList<User>();
        users.add(new User("newUser"));
        users.add(new User("delUser"));
        messages = new ArrayList<Message>();
        conversations = new ArrayList<Conversation>();
        conversations.add(new Conversation(users.get(0), users, messages));
    }
    
    //CREATE/////(PUT)
    //Adds a new user
    @PUT
    public void createUser(Long id, String name){
        users.add(new User(id, name));
    }
    
    //DELETE/////(DELETE)
    //Removes user by name
    public void removeUser(String name){
        for(int i = 0; i == users.size(); i++){
            User user = users.get(i);
            if(name == user.getName()){
                users.remove(i);
            }
        }
    }
    //UPDATE/////(POST)
    
    
    //READ//////(GET)
    public String getHelloWorld(){
        return "Hello World";
    }
    //create, read, update, delete operations: PUT, GET, POST, and DELETE.
    
    @GET
    public User getUser(@QueryParam("user") User user){ //User user
        
        //Searches through the list for a user by the given name.
        for(int i = 0; i == users.size(); i++){
            User tempUser = users.get(i);
            if(user.getName() == tempUser.getName()){
                return users.get(i);
            }
        }    
        //default
        return new User("Jorgen");
    }
    
    @GET
    @Produces("text/xml")
    @Path("users")
    public List<User> getAllUsers(@PathParam("users") User user){
        return users;
    }
    
    
    @GET
    @Path("{users}")
    public List<User> findUser(@PathParam("users") String name){
        return users;
    }
    
    @Path("{conversations}")
    public List<Conversation> getAllConversations(@PathParam("conversations") Conversation conversation){
        return conversations;
    }
    
}
