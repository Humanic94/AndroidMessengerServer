/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatServer.service;

import ChatServer.DatabaseClass;
import ChatServer.Domain.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Jorgen
 */
public class UserService {
    private Map<String, User> users = DatabaseClass.getUsers();
    
    public UserService(){
       users.put("Jorgen", new User(1L, "Jorgen", "photoUri"));
    }
    
    //Returns all users
    public List<User> getAllUsers(){
        return new ArrayList<User>(users.values());
    }
    
    //Gets a user by name
    public User getUser(String userName){
        return users.get(userName);
    }
    
    //creates a new user
    public User addUser(User user){
        user.setUid(users.size() + 1L);
        users.put(user.getName(), user);
        return user;
    }
    
    //changes the values of an existing user
    public User updateUser(User user){
        if(user.getName().isEmpty()){
            return null;
        }
        users.put(user.getName(), user);
        return user;
    }
    
    //Deletes an existing user
    public User removeUser(String userName){
        return users.remove(userName);
    }
}
