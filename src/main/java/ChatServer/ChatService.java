/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatServer;
import ChatServer.Domain.User;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
/**
 *
 * @author Humanic
 */
@Path("Chat")
@Produces("application/json")
public class ChatService {
    private List<User> users;
    
    public ChatService(){
        users = new ArrayList();
    }
    
    public String getHelloWorld(){
        return "Hello World";
    }
    
    @GET
    public User getUser(@QueryParam("user") User user){
        return new User("Jorgen");
    }
    @GET
    @Path("{user}")
    public List<User> findUser(@PathParam("user") String name){
        return users;
    }
    
}
