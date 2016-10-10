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
    String messageSender;
    String message = "";
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
    
    public Message(Long messageId, String messageSender, String message){
        this.message = message;
        this.messageId = messageId;
        this.messageSender = messageSender;
    }

    public Long getMessageId() {
        return messageId;
    }

    public String getMessageSender() {
        return messageSender;
    }
    
    public String getMessage(){
    return message;
    }

    public User getSender() {
        return sender;
    }

    public String getText() {
        return text;
    }

    public Date getTimestamp() {
        return timestamp;
    }
    
    
}
