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
    private List<Message> conversation;
    
    protected Conversation(){
        
    }
    public Conversation(Long conversationId, String conversationName){
        conversation = new ArrayList<Message>();
        this.conversationId = conversationId;
        this.conversationName = conversationName;
    }
    
    @GET
    public Long getConversationId(){
    return conversationId;
    }
    
    @GET
    public String getConversationName(){
    return conversationName;
    }
    
    @GET
    public List<Message> getConversation(){
    return conversation;
    }
    
}
