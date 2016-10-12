/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatServer.Domain;

import java.io.Serializable;
import java.util.Date;
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
public class Message implements Serializable {
    @Id @GeneratedValue
    Long messageId;
    private User sender;
    private String text;
    private Date timestamp;

    protected Message() {
    }

    public Message(User sender, String text, Date timestamp){
        this.sender = sender;
        this.text = text;
        this.timestamp = timestamp;
    }

    @GET
    public Long getMessageId() {
        return messageId;
    }

    @GET
    public User getSender() {
        return sender;
    }

    @GET
    public String getText() {
        return text;
    }

    @GET
    public Date getTimestamp() {
        return timestamp;
    }
    
    
}
