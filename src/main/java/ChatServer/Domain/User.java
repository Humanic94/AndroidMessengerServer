/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatServer.Domain;
import javax.ws.rs.GET;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Humanic
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class User {
    Long id;
    String name;
    Conversation conversation;
    
    public User(){
        conversation = new Conversation();
    }
    
    public User(String name){
        this.name = name;
    }
    
    public User(Long id, String name, Conversation conversation){
    this.id = id;
    this.name = name;
    this.conversation = conversation;
    }
    
    @GET
    public Long getId(){
        return id;
    }
    
    @GET
    public String getName(){
    return name;
    }
    
    @GET
    public Conversation getConversation(){
    return conversation;
    }
}