/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatServer.resources;

import ChatServer.Domain.Conversation;
import ChatServer.service.ConversationService;
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
@Path("/conversations")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ConversationResource {
    ConversationService conversationService = new ConversationService();
    
    @GET
    public List<Conversation> getConversations(){
        return conversationService.getAllConversations();
    }
    
    @GET
    @Path("/{conversationName}")
    public Conversation getConversation(@PathParam("conversationName") String conversationName){
        return conversationService.getConversation(conversationName);
    }
    
    @POST
    public Conversation addConversation(Conversation conversation){
        return conversationService.addConversation(conversation);
    }
    
    @PUT
    @Path("/{conversationName}")
    public Conversation updateConversation(@PathParam("conversationName") String conversationName, Conversation conversation){
        conversation.setConversationName(conversationName);
        return conversationService.updateConversation(conversation);
    }
    
    @DELETE
    @Path("/{conversationName}")
    public void deleteConversation(@PathParam("conversationName") String conversationName){
        conversationService.removeConversation(conversationName);
    }
}
