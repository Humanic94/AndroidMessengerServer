/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatServer.Domain;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.ws.rs.GET;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Humanic
 */
@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Conversation implements Serializable{
    @Id @GeneratedValue
    private Long conversationId;
    private String conversationName;
    private List<Message> messages;
    private User owner;
    private List<User> recipients;
    
    protected Conversation(){
        
    }
    public Conversation(User owner, List<User> recipients, List<Message> messages){
        this.owner = owner;
        this.recipients = recipients;
        this.messages = messages;
    }
    
    @GET
    public Long getConversationId(){
    return conversationId;
    }
    
    @GET
    public String getConversationName(){
    return conversationName;
    }
    
    /*
    @GET
    public List<Message> getConversation(){
    return conversation;
    }
    */
    @GET
    public List<Message> getMessages() {
        return messages;
    }
    
    @GET
    public User getOwner() {
        return owner;
    }
    
    @GET
    public List<User> getRecipients() {
        return recipients;
    }
}
