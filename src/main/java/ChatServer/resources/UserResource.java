/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatServer.resources;

import ChatServer.Domain.User;
import ChatServer.service.UserService;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Jorgen
 */
@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {
    
    private UserService userService = new UserService();
    
    protected UserResource(){}
    
    @GET
    public List<User> getUsers(){
        return userService.getAllUsers();
    }
    
    @POST
    public User addUser(User user){
        return userService.addUser(user);
    }
    
    @PUT
    @Path("/{userName}")
    public User updateUser(@PathParam("userName") String userName, User user){
        user.setName(userName);
        return userService.updateUser(user);
    }
    
    @DELETE
    @Path("/{userName}")
    public void deleteUser(@PathParam("userName") String userName){
        userService.removeUser(userName);
    }
    
    @GET
    @Path("/{userName}")
    public User getUser(@PathParam("userName") String userName){
        return userService.getUser(userName);
    }
}
