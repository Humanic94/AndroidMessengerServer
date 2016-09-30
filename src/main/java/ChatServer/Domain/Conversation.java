/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatServer.Domain;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Humanic
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Conversation {
    private List<Message> conversation;
    
    public Conversation(){
        conversation = new ArrayList<Message>();
    }
    
    public List<Message> getConversation(){
    return conversation;
    }
    
}
