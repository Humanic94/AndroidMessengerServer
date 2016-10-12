/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatServer.resources;

import ChatServer.Domain.Message;
import ChatServer.service.MessageService;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Jorgen
 */
@Path("/messages")
public class MessageResource {
    MessageService messageService = new MessageService();
    
    //Get all messages
    @GET
    @Produces("Application/json")
    public List<Message> getMessages(){
        return messageService.getAllMessages();
    }
    
    //Search messages by Id
    @GET
    @Path("/{messageId}")
    @Produces(MediaType.APPLICATION_XML)
    public Message getMessage(@PathParam("messageId") Long messageId){
    return messageService.getMessage(messageId);

    }
}
