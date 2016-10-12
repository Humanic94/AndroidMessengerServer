/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatServer.resources;

import ChatServer.Domain.Message;
import ChatServer.service.MessageService;
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
@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {
    MessageService messageService = new MessageService();
    
    //Get all messages
    @GET
    public List<Message> getMessages(){
        return messageService.getAllMessages();
    }
    
    //Adds a new message 
    @POST
    public Message addMessage(Message message){
        return messageService.addMessage(message);
    }
    
    //Changes an existing message
    @PUT
    @Path("/{messageId}")
    public Message updateMessage(@PathParam("messageId") Long messageId, Message message){
        message.setMessageId(messageId);
        return messageService.updateMessage(message);
    }
    
    //Removes a message by id
    @DELETE
    @Path("/{messageId}")
    public void deleteMessage(@PathParam("messageId") Long messageId){
        messageService.removeMessage(messageId);
    }
    
    //Search messages by Id
    @GET
    @Path("/{messageId}")
    public Message getMessage(@PathParam("messageId") Long messageId){
    return messageService.getMessage(messageId);

    }
}
