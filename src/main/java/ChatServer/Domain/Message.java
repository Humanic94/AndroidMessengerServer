/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatServer.Domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Humanic
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Message {
    String message = "";

    protected Message() {
    }

    
    
    public Message(String message){
        this.message = message;
    }
    
    public String getMessage(){
    return message;
    }
}
